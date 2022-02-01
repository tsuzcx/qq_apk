package com.tencent.mobileqq.flashchat;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StartAppCheckHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.config.QStorage;
import com.tencent.mobileqq.config.QStorageInstantiateException;
import com.tencent.mobileqq.config.QStorageSafeDeleteException;
import com.tencent.mobileqq.config.business.FlashChatConfBean;
import com.tencent.mobileqq.data.ArkFlashChatMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkFlashChat;
import com.tencent.mobileqq.data.MessageForHiBoom;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.NewIntent;
import mqq.manager.Manager;

public class FlashChatManager
  implements Manager
{
  public static SparseArray<Integer> p;
  public static SparseArray<Long> q;
  QQAppInterface a;
  public boolean b = true;
  public FlashChatManager.GlobalConfig c = new FlashChatManager.GlobalConfig();
  String d;
  QStorage e = QStorage.a("flashchat");
  boolean f;
  MessageForArkFlashChat g = null;
  public CopyOnWriteArrayList<MessageForArkFlashChat> h = new CopyOnWriteArrayList();
  public ConcurrentHashMap<Long, Long> i = new ConcurrentHashMap();
  public ConcurrentHashMap<String, String> j = new ConcurrentHashMap();
  public AtomicBoolean k = new AtomicBoolean(false);
  public ArrayList<FlashChatItem> l;
  public SparseArray<String> m = new SparseArray();
  public ConcurrentHashMap<String, String> n = new ConcurrentHashMap();
  boolean o = false;
  int[] r = { 3, 4, 2, 1, 0 };
  private HashMap<String, String> s = new HashMap();
  private boolean t;
  
  public FlashChatManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    ThreadManager.post(new FlashChatManager.1(this), 8, null, true);
  }
  
  public static final int a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForArkFlashChat)) {
      return 1;
    }
    if ((paramMessageRecord instanceof MessageForHiBoom)) {
      return 2;
    }
    if ((paramMessageRecord instanceof MessageForScribble)) {
      return 0;
    }
    if ((paramMessageRecord instanceof MessageForPic)) {
      return 3;
    }
    if ((paramMessageRecord instanceof MessageForShortVideo)) {
      return 4;
    }
    return -1;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, FlashChatItem paramFlashChatItem)
  {
    int i3 = ((ISVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).j();
    int i1 = paramFlashChatItem.feedType;
    int i2 = 1;
    if (i1 != 4)
    {
      if (i1 != 5)
      {
        i1 = i2;
        break label71;
      }
      if (i3 == 3)
      {
        i1 = i2;
        break label71;
      }
    }
    do
    {
      i1 = 0;
      break;
      i1 = i2;
      if (i3 == 1) {
        break;
      }
    } while (i3 != 3);
    i1 = i2;
    label71:
    paramQQAppInterface = null;
    if (i1 == 0)
    {
      if (paramFlashChatItem.feedType == 5) {
        return "CJCLUBT";
      }
      paramQQAppInterface = "LTMCLUB";
    }
    return paramQQAppInterface;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, MessageRecord paramMessageRecord)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SourceClickHandler clickWebMsg  url = ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d("FlashChat", 2, ((StringBuilder)localObject).toString());
    }
    if ((!TextUtils.isEmpty(paramString1)) && ((paramString1.startsWith("http://")) || (paramString1.startsWith("https://"))))
    {
      localObject = new Intent(paramContext, QQBrowserActivity.class);
      ((Intent)localObject).putExtra("key_isReadModeEnabled", true);
      ((Intent)localObject).putExtra("title", paramString2);
      ((Intent)localObject).putExtra("url", paramString1);
      paramContext.startActivity((Intent)localObject);
      if (paramMessageRecord != null)
      {
        ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).modifyIntentForSpecificBrowserIfNeeded(paramMessageRecord, (Intent)localObject, paramString1);
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramString1, "", "", "");
      }
      return true;
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, String paramString3, QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("SourceClickHandler clickAppMsg url = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", actionData = ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(", actionDataA = ");
      localStringBuilder.append(paramString3);
      QLog.d("FlashChat", 2, localStringBuilder.toString());
    }
    paramString1 = a(paramString2, paramString3);
    paramString2 = paramContext.getPackageManager();
    try
    {
      if (paramString2.getPackageInfo(paramString1[0], 1) != null)
      {
        paramString2 = paramString2.getLaunchIntentForPackage(paramString1[0]);
        if (paramString2 == null) {
          return false;
        }
        paramString2.addFlags(67108864);
        if (!TextUtils.isEmpty(paramString1[1])) {
          paramString2.setData(Uri.parse(paramString1[1]));
        }
      }
    }
    catch (RuntimeException paramContext)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("FlashChat", 2, paramContext.getMessage());
        return false;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label222:
      if (QLog.isColorLevel()) {
        QLog.d("FlashChat", 2, paramContext.getMessage());
      }
    }
    try
    {
      paramString3 = (StartAppCheckHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.STARTAPPCHECK_HANDLER);
      paramString2.putExtra("report_open_type", "flashChat");
      paramString2.putExtra("report_url", "");
      paramString2.putExtra("report_from", "1");
      paramString2.putExtra("report_click_origin", "AIOTail");
      paramString2.putExtra("report_class_name", paramContext.getClass().getName());
      paramString3.b(paramString1[0].trim(), paramContext, paramString2);
      return true;
    }
    catch (Exception paramString1)
    {
      break label222;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AppStartedHandler", 2, "<-- StartAppCheckHandler AbsShareMSG Failed!");
    }
    paramContext.startActivity(paramString2);
    return true;
    return false;
  }
  
  protected static final String[] a(String paramString1, String paramString2)
  {
    String[] arrayOfString = new String[2];
    arrayOfString[0] = "";
    arrayOfString[1] = "";
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1 = paramString2;
    }
    int i1;
    if (TextUtils.isEmpty(paramString1)) {
      i1 = -1;
    } else {
      i1 = paramString1.indexOf("://");
    }
    if (i1 == -1)
    {
      arrayOfString[0] = paramString1;
      return arrayOfString;
    }
    arrayOfString[0] = paramString1.substring(0, i1);
    arrayOfString[1] = paramString1.substring(i1 + 3);
    return arrayOfString;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int i2;
    int i1;
    do
    {
      return "";
      i2 = paramString.length();
      i1 = 0;
      int i3 = i2 - 1;
      while ((i1 <= i3) && (paramString.charAt(i1) == ' ')) {
        i1 += 1;
      }
      i2 = i3;
      while ((i2 >= i1) && (paramString.charAt(i2) == ' ')) {
        i2 -= 1;
      }
      if ((i1 == 0) && (i2 == i3)) {
        return paramString;
      }
    } while (i1 > i2);
    return paramString.substring(i1, i2 + 1);
  }
  
  /* Error */
  private void b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +55 -> 58
    //   6: new 167	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   13: astore 4
    //   15: aload 4
    //   17: ldc_w 367
    //   20: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 4
    //   26: aload_1
    //   27: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 4
    //   33: ldc_w 369
    //   36: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 4
    //   42: aload_2
    //   43: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: ldc 176
    //   49: iconst_2
    //   50: aload 4
    //   52: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: new 167	java/lang/StringBuilder
    //   61: dup
    //   62: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   65: astore 4
    //   67: aload 4
    //   69: aload_2
    //   70: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 4
    //   76: getstatic 374	java/io/File:separator	Ljava/lang/String;
    //   79: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: new 371	java/io/File
    //   86: dup
    //   87: aload 4
    //   89: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokespecial 377	java/io/File:<init>	(Ljava/lang/String;)V
    //   95: astore 4
    //   97: aload 4
    //   99: invokevirtual 380	java/io/File:exists	()Z
    //   102: ifne +9 -> 111
    //   105: aload 4
    //   107: invokevirtual 383	java/io/File:mkdirs	()Z
    //   110: pop
    //   111: aconst_null
    //   112: astore 4
    //   114: new 385	com/tencent/commonsdk/zip/QZipFile
    //   117: dup
    //   118: aload_1
    //   119: invokespecial 386	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   122: astore 6
    //   124: aload 6
    //   126: invokevirtual 392	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   129: astore 7
    //   131: sipush 8192
    //   134: newarray byte
    //   136: astore 8
    //   138: aload 7
    //   140: invokeinterface 397 1 0
    //   145: ifeq +340 -> 485
    //   148: aload 7
    //   150: invokeinterface 401 1 0
    //   155: checkcast 403	java/util/zip/ZipEntry
    //   158: astore_1
    //   159: aload_1
    //   160: invokevirtual 404	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   163: astore 5
    //   165: aload 5
    //   167: ifnull -29 -> 138
    //   170: aload 5
    //   172: ldc_w 406
    //   175: invokevirtual 409	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   178: ifeq +6 -> 184
    //   181: goto -43 -> 138
    //   184: new 167	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   191: astore 9
    //   193: aload 9
    //   195: aload_2
    //   196: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload 9
    //   202: getstatic 374	java/io/File:separator	Ljava/lang/String;
    //   205: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: pop
    //   209: aload 9
    //   211: aload 5
    //   213: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload 9
    //   219: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: astore 5
    //   224: aload_1
    //   225: invokevirtual 412	java/util/zip/ZipEntry:isDirectory	()Z
    //   228: ifeq +28 -> 256
    //   231: new 371	java/io/File
    //   234: dup
    //   235: aload 5
    //   237: invokespecial 377	java/io/File:<init>	(Ljava/lang/String;)V
    //   240: astore_1
    //   241: aload_1
    //   242: invokevirtual 380	java/io/File:exists	()Z
    //   245: ifne -107 -> 138
    //   248: aload_1
    //   249: invokevirtual 415	java/io/File:mkdir	()Z
    //   252: pop
    //   253: goto -115 -> 138
    //   256: aload 5
    //   258: getstatic 374	java/io/File:separator	Ljava/lang/String;
    //   261: invokevirtual 418	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   264: istore_3
    //   265: aload 5
    //   267: iconst_0
    //   268: iload_3
    //   269: invokevirtual 351	java/lang/String:substring	(II)Ljava/lang/String;
    //   272: astore 9
    //   274: aload 5
    //   276: iload_3
    //   277: iconst_1
    //   278: iadd
    //   279: invokevirtual 354	java/lang/String:substring	(I)Ljava/lang/String;
    //   282: ldc_w 420
    //   285: invokevirtual 197	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   288: ifeq +6 -> 294
    //   291: goto -153 -> 138
    //   294: new 371	java/io/File
    //   297: dup
    //   298: aload 9
    //   300: invokespecial 377	java/io/File:<init>	(Ljava/lang/String;)V
    //   303: astore 9
    //   305: aload 9
    //   307: invokevirtual 380	java/io/File:exists	()Z
    //   310: ifne +9 -> 319
    //   313: aload 9
    //   315: invokevirtual 415	java/io/File:mkdir	()Z
    //   318: pop
    //   319: new 167	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   326: astore 9
    //   328: aload 9
    //   330: aload 5
    //   332: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 9
    //   338: ldc_w 422
    //   341: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: new 371	java/io/File
    //   348: dup
    //   349: aload 9
    //   351: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   354: invokespecial 377	java/io/File:<init>	(Ljava/lang/String;)V
    //   357: astore 9
    //   359: new 371	java/io/File
    //   362: dup
    //   363: aload 5
    //   365: invokespecial 377	java/io/File:<init>	(Ljava/lang/String;)V
    //   368: astore 10
    //   370: aload 9
    //   372: invokevirtual 380	java/io/File:exists	()Z
    //   375: ifeq +9 -> 384
    //   378: aload 9
    //   380: invokevirtual 425	java/io/File:delete	()Z
    //   383: pop
    //   384: new 427	java/io/FileOutputStream
    //   387: dup
    //   388: aload 9
    //   390: invokespecial 430	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   393: astore 5
    //   395: aload 6
    //   397: aload_1
    //   398: invokevirtual 434	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   401: astore_1
    //   402: aload_1
    //   403: aload 8
    //   405: iconst_0
    //   406: aload 8
    //   408: arraylength
    //   409: invokevirtual 440	java/io/InputStream:read	([BII)I
    //   412: istore_3
    //   413: iload_3
    //   414: iconst_m1
    //   415: if_icmpeq +15 -> 430
    //   418: aload 5
    //   420: aload 8
    //   422: iconst_0
    //   423: iload_3
    //   424: invokevirtual 444	java/io/FileOutputStream:write	([BII)V
    //   427: goto -25 -> 402
    //   430: aload 5
    //   432: invokevirtual 447	java/io/FileOutputStream:flush	()V
    //   435: aload 5
    //   437: invokevirtual 450	java/io/FileOutputStream:close	()V
    //   440: aload_1
    //   441: invokevirtual 451	java/io/InputStream:close	()V
    //   444: aload 9
    //   446: aload 10
    //   448: invokestatic 457	com/tencent/mobileqq/utils/FileUtils:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   451: ifne -313 -> 138
    //   454: aload 9
    //   456: aload 10
    //   458: invokestatic 460	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   461: pop
    //   462: goto -324 -> 138
    //   465: astore 4
    //   467: aload_1
    //   468: astore_2
    //   469: aload 4
    //   471: astore_1
    //   472: goto +6 -> 478
    //   475: astore_1
    //   476: aconst_null
    //   477: astore_2
    //   478: aload 5
    //   480: astore 4
    //   482: goto +7 -> 489
    //   485: return
    //   486: astore_1
    //   487: aconst_null
    //   488: astore_2
    //   489: aload 4
    //   491: ifnull +18 -> 509
    //   494: aload 4
    //   496: invokevirtual 450	java/io/FileOutputStream:close	()V
    //   499: goto +10 -> 509
    //   502: astore 4
    //   504: aload 4
    //   506: invokevirtual 463	java/io/IOException:printStackTrace	()V
    //   509: aload_2
    //   510: ifnull +15 -> 525
    //   513: aload_2
    //   514: invokevirtual 451	java/io/InputStream:close	()V
    //   517: goto +8 -> 525
    //   520: astore_2
    //   521: aload_2
    //   522: invokevirtual 463	java/io/IOException:printStackTrace	()V
    //   525: goto +5 -> 530
    //   528: aload_1
    //   529: athrow
    //   530: goto -2 -> 528
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	533	0	this	FlashChatManager
    //   0	533	1	paramString1	String
    //   0	533	2	paramString2	String
    //   264	160	3	i1	int
    //   13	100	4	localObject1	Object
    //   465	5	4	localObject2	Object
    //   480	15	4	localObject3	Object
    //   502	3	4	localIOException	java.io.IOException
    //   163	316	5	localObject4	Object
    //   122	274	6	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   129	20	7	localEnumeration	java.util.Enumeration
    //   136	285	8	arrayOfByte	byte[]
    //   191	264	9	localObject5	Object
    //   368	89	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   402	413	465	finally
    //   418	427	465	finally
    //   430	444	465	finally
    //   395	402	475	finally
    //   114	138	486	finally
    //   138	165	486	finally
    //   170	181	486	finally
    //   184	253	486	finally
    //   256	291	486	finally
    //   294	319	486	finally
    //   319	384	486	finally
    //   384	395	486	finally
    //   444	462	486	finally
    //   494	499	502	java/io/IOException
    //   513	517	520	java/io/IOException
  }
  
  public static String d(String paramString)
  {
    return paramString.substring(0, paramString.lastIndexOf("."));
  }
  
  public ArkFlashChatMessage a(String paramString, int paramInt1, int paramInt2)
  {
    if (!a(this.a)) {
      return null;
    }
    if (paramString != null)
    {
      if (TextUtils.isEmpty(paramString.trim())) {
        return null;
      }
      try
      {
        Object localObject1 = this.l;
        if (localObject1 != null)
        {
          localObject3 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject1 = (FlashChatItem)((Iterator)localObject3).next();
            if ((localObject1 != null) && (((FlashChatItem)localObject1).id == paramInt2))
            {
              if (a(this.a, (FlashChatItem)localObject1) == null) {
                break label117;
              }
              c("");
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      Object localObject2 = null;
      label117:
      if (localObject2 == null) {
        return null;
      }
      Object localObject3 = new ArkFlashChatMessage();
      ((ArkFlashChatMessage)localObject3).appMinVersion = localObject2.ver;
      ((ArkFlashChatMessage)localObject3).appName = localObject2.appName;
      ((ArkFlashChatMessage)localObject3).appView = localObject2.mainView;
      ((ArkFlashChatMessage)localObject3).appDesc = localObject2.name;
      ((ArkFlashChatMessage)localObject3).appResId = localObject2.id;
      ((ArkFlashChatMessage)localObject3).promptText = paramString;
      ((ArkFlashChatMessage)localObject3).config = "config";
      if (QLog.isColorLevel()) {
        QLog.i("FlashChat", 1, "sendMessage");
      }
      return localObject3;
    }
    return null;
  }
  
  public String a()
  {
    if (this.d == null)
    {
      Object localObject = BaseApplicationImpl.getContext();
      int i1 = 0;
      try
      {
        boolean bool = "mounted".equals(Environment.getExternalStorageState());
        i1 = bool;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      if (i1 != 0) {
        localObject = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH);
      } else {
        localObject = ((Context)localObject).getFilesDir().getAbsolutePath();
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("flashchat");
      localStringBuilder.append(File.separator);
      this.d = localStringBuilder.toString();
      new File(this.d).mkdirs();
    }
    return this.d;
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    Object localObject1 = (String)this.m.get(paramInt);
    if (localObject1 != null) {
      return localObject1;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getAppPathByNameFromLocal ");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(" path ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" version");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append(" name");
      ((StringBuilder)localObject2).append(paramString1);
      QLog.d("FlashChat", 2, ((StringBuilder)localObject2).toString());
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("flashchat.");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(".cfg");
    localObject1 = FlashChatManager.FlashPackCfg.a(FileUtils.readFileContent(new File(a(((StringBuilder)localObject1).toString()))));
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FlashChat", 2, "getAppPathByNameFromLocal cfg not exist ...");
      }
      return null;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(a());
    ((StringBuilder)localObject2).append(d(((FlashChatManager.FlashPackCfg)localObject1).b));
    ((StringBuilder)localObject2).append(File.separator);
    ((StringBuilder)localObject2).append(paramString1);
    localObject2 = ((StringBuilder)localObject2).toString();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getAppPathByNameFromLocal installPath: ");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append("cfg info : ");
      localStringBuilder.append(localObject1);
      QLog.d("FlashChat", 2, localStringBuilder.toString());
    }
    localObject1 = new File((String)localObject2);
    if (!((File)localObject1).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("FlashChat", 2, "getAppPathByNameFromLocal appDir not exist ...");
      }
      return null;
    }
    localObject2 = ((File)localObject1).listFiles();
    if (localObject2 != null)
    {
      int i2 = localObject2.length;
      int i1 = 0;
      while (i1 < i2)
      {
        localObject1 = localObject2[i1];
        if ((((File)localObject1).isFile()) && (((File)localObject1).getName().endsWith(".app")) && (((File)localObject1).getName().contains(paramString2))) {
          break label427;
        }
        i1 += 1;
      }
    }
    localObject1 = null;
    label427:
    if (localObject1 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FlashChat", 2, "getAppPathByNameFromLocal appFile not exist ...");
      }
      return null;
    }
    localObject1 = ((File)localObject1).getAbsolutePath();
    if (localObject1 != null) {
      this.m.put(paramInt, localObject1);
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getAppPathByNameFromLocal ");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(" path ");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" version");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append(" name");
      ((StringBuilder)localObject2).append(paramString1);
      QLog.d("FlashChat", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public void a(int paramInt)
  {
    IVasQuickUpdateService localIVasQuickUpdateService = (IVasQuickUpdateService)this.a.getRuntimeService(IVasQuickUpdateService.class, "");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("flashchat.");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(".cfg");
    localObject = ((StringBuilder)localObject).toString();
    this.n.put(localObject, String.valueOf(paramInt));
    localIVasQuickUpdateService.downloadItem(1002L, (String)localObject, "initChatResource");
  }
  
  public void a(Context paramContext, MessageRecord paramMessageRecord)
  {
    FlashChatManager.GlobalConfig localGlobalConfig = this.c;
    String str1 = localGlobalConfig.c;
    String str2 = localGlobalConfig.f;
    String str3 = localGlobalConfig.g;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clickQIMSource clickAppMsg url = ");
      localStringBuilder.append(str1);
      localStringBuilder.append(", actionData = ");
      localStringBuilder.append(str2);
      localStringBuilder.append(", actionDataA = ");
      localStringBuilder.append(str3);
      localStringBuilder.append(paramMessageRecord);
      QLog.d("FlashChat", 2, localStringBuilder.toString());
    }
    if (a(paramContext, str1, str2, str3, this.a)) {
      return;
    }
    a(paramContext, str1, localGlobalConfig.b, paramMessageRecord);
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if (((paramChatMessage instanceof MessageForArkFlashChat)) && (!paramChatMessage.isread)) {
      a((MessageForArkFlashChat)paramChatMessage);
    }
  }
  
  public void a(MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "setNeedAnim i");
    }
    if (paramMessageForArkFlashChat != null)
    {
      Object localObject = this.g;
      if ((localObject == null) || (((MessageForArkFlashChat)localObject).uniseq != paramMessageForArkFlashChat.uniseq))
      {
        if (paramMessageForArkFlashChat != null) {
          localObject = Long.valueOf(paramMessageForArkFlashChat.uniseq);
        } else {
          localObject = null;
        }
        a((Long)localObject);
      }
    }
    this.g = paramMessageForArkFlashChat;
  }
  
  public void a(Long paramLong)
  {
    Object localObject = (CopyOnWriteArrayList)this.h.clone();
    this.h.clear();
    if (localObject == null) {
      return;
    }
    localObject = ((CopyOnWriteArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      MessageForArkFlashChat localMessageForArkFlashChat = (MessageForArkFlashChat)((Iterator)localObject).next();
      if ((paramLong == null) || (paramLong.longValue() != localMessageForArkFlashChat.uniseq))
      {
        String str = localMessageForArkFlashChat.ark_app_message.appName;
        ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToAppThread(str, new FlashChatManager.2(this, localMessageForArkFlashChat));
      }
    }
  }
  
  /* Error */
  public void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 165	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +55 -> 58
    //   6: new 167	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   13: astore 6
    //   15: aload 6
    //   17: ldc_w 720
    //   20: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 6
    //   26: aload_1
    //   27: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 6
    //   33: ldc_w 722
    //   36: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 6
    //   42: iload_2
    //   43: invokevirtual 576	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: ldc 176
    //   49: iconst_2
    //   50: aload 6
    //   52: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: aload_1
    //   59: ifnull +518 -> 577
    //   62: aload_1
    //   63: ldc_w 586
    //   66: invokevirtual 627	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   69: istore 5
    //   71: iconst_m1
    //   72: istore_3
    //   73: iload 5
    //   75: ifeq +186 -> 261
    //   78: aload_0
    //   79: getfield 103	com/tencent/mobileqq/flashchat/FlashChatManager:n	Ljava/util/concurrent/ConcurrentHashMap;
    //   82: aload_1
    //   83: invokevirtual 725	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   86: checkcast 193	java/lang/String
    //   89: astore 6
    //   91: iload_2
    //   92: ifeq +89 -> 181
    //   95: aload 6
    //   97: invokestatic 730	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   100: invokevirtual 733	java/lang/Integer:intValue	()I
    //   103: istore 4
    //   105: iload 4
    //   107: istore_3
    //   108: goto +41 -> 149
    //   111: astore_1
    //   112: new 167	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   119: astore 6
    //   121: aload 6
    //   123: ldc_w 735
    //   126: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 6
    //   132: iload_2
    //   133: invokevirtual 576	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: ldc 176
    //   139: iconst_2
    //   140: aload 6
    //   142: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: aload_1
    //   146: invokestatic 738	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   149: new 740	android/os/Bundle
    //   152: dup
    //   153: invokespecial 741	android/os/Bundle:<init>	()V
    //   156: astore_1
    //   157: aload_1
    //   158: ldc_w 743
    //   161: iload_3
    //   162: invokevirtual 746	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   165: aload_0
    //   166: getfield 109	com/tencent/mobileqq/flashchat/FlashChatManager:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   169: ldc_w 748
    //   172: sipush 968
    //   175: iconst_0
    //   176: aload_1
    //   177: invokevirtual 752	com/tencent/mobileqq/app/QQAppInterface:notifyObservers	(Ljava/lang/Class;IZLandroid/os/Bundle;)V
    //   180: return
    //   181: new 371	java/io/File
    //   184: dup
    //   185: aload_0
    //   186: aload_1
    //   187: invokevirtual 588	com/tencent/mobileqq/flashchat/FlashChatManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   190: invokespecial 377	java/io/File:<init>	(Ljava/lang/String;)V
    //   193: invokestatic 592	com/tencent/mobileqq/utils/FileUtils:readFileContent	(Ljava/io/File;)Ljava/lang/String;
    //   196: invokestatic 597	com/tencent/mobileqq/flashchat/FlashChatManager$FlashPackCfg:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/flashchat/FlashChatManager$FlashPackCfg;
    //   199: astore_1
    //   200: aload_1
    //   201: ifnull +376 -> 577
    //   204: aload_1
    //   205: getfield 603	com/tencent/mobileqq/flashchat/FlashChatManager$FlashPackCfg:b	Ljava/lang/String;
    //   208: ifnull +369 -> 577
    //   211: aload 6
    //   213: ifnull +364 -> 577
    //   216: aload_0
    //   217: getfield 89	com/tencent/mobileqq/flashchat/FlashChatManager:j	Ljava/util/concurrent/ConcurrentHashMap;
    //   220: aload_1
    //   221: getfield 603	com/tencent/mobileqq/flashchat/FlashChatManager$FlashPackCfg:b	Ljava/lang/String;
    //   224: aload 6
    //   226: invokevirtual 646	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   229: pop
    //   230: aload_0
    //   231: getfield 109	com/tencent/mobileqq/flashchat/FlashChatManager:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   234: ldc_w 636
    //   237: ldc 243
    //   239: invokevirtual 640	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   242: checkcast 636	com/tencent/mobileqq/vas/updatesystem/api/IVasQuickUpdateService
    //   245: ldc2_w 647
    //   248: aload_1
    //   249: getfield 603	com/tencent/mobileqq/flashchat/FlashChatManager$FlashPackCfg:b	Ljava/lang/String;
    //   252: ldc_w 754
    //   255: invokeinterface 654 5 0
    //   260: return
    //   261: aload_1
    //   262: ldc_w 756
    //   265: invokevirtual 627	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   268: ifeq +309 -> 577
    //   271: aload_0
    //   272: getfield 89	com/tencent/mobileqq/flashchat/FlashChatManager:j	Ljava/util/concurrent/ConcurrentHashMap;
    //   275: aload_1
    //   276: invokevirtual 725	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   279: checkcast 193	java/lang/String
    //   282: astore 8
    //   284: iload_2
    //   285: ifeq +89 -> 374
    //   288: aload 8
    //   290: invokestatic 730	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   293: invokevirtual 733	java/lang/Integer:intValue	()I
    //   296: istore 4
    //   298: iload 4
    //   300: istore_3
    //   301: goto +41 -> 342
    //   304: astore_1
    //   305: new 167	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   312: astore 6
    //   314: aload 6
    //   316: ldc_w 735
    //   319: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload 6
    //   325: iload_2
    //   326: invokevirtual 576	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: ldc 176
    //   332: iconst_2
    //   333: aload 6
    //   335: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: aload_1
    //   339: invokestatic 738	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   342: new 740	android/os/Bundle
    //   345: dup
    //   346: invokespecial 741	android/os/Bundle:<init>	()V
    //   349: astore_1
    //   350: aload_1
    //   351: ldc_w 743
    //   354: iload_3
    //   355: invokevirtual 746	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   358: aload_0
    //   359: getfield 109	com/tencent/mobileqq/flashchat/FlashChatManager:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   362: ldc_w 748
    //   365: sipush 968
    //   368: iconst_0
    //   369: aload_1
    //   370: invokevirtual 752	com/tencent/mobileqq/app/QQAppInterface:notifyObservers	(Ljava/lang/Class;IZLandroid/os/Bundle;)V
    //   373: return
    //   374: aload_0
    //   375: aload_1
    //   376: invokevirtual 588	com/tencent/mobileqq/flashchat/FlashChatManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   379: astore 7
    //   381: aload_1
    //   382: invokestatic 605	com/tencent/mobileqq/flashchat/FlashChatManager:d	(Ljava/lang/String;)Ljava/lang/String;
    //   385: astore_1
    //   386: new 167	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   393: astore 6
    //   395: aload 6
    //   397: aload_0
    //   398: invokevirtual 601	com/tencent/mobileqq/flashchat/FlashChatManager:a	()Ljava/lang/String;
    //   401: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload 6
    //   407: aload_1
    //   408: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: aload 6
    //   414: getstatic 374	java/io/File:separator	Ljava/lang/String;
    //   417: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: pop
    //   421: aload 6
    //   423: invokevirtual 180	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: astore 9
    //   428: aload_0
    //   429: getfield 96	com/tencent/mobileqq/flashchat/FlashChatManager:k	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   432: iconst_1
    //   433: invokevirtual 759	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   436: aload 9
    //   438: invokevirtual 762	java/lang/String:intern	()Ljava/lang/String;
    //   441: astore 6
    //   443: aload 6
    //   445: monitorenter
    //   446: new 371	java/io/File
    //   449: dup
    //   450: aload 9
    //   452: invokespecial 377	java/io/File:<init>	(Ljava/lang/String;)V
    //   455: astore_1
    //   456: aload_0
    //   457: aload 7
    //   459: aload 9
    //   461: invokespecial 764	com/tencent/mobileqq/flashchat/FlashChatManager:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   464: aload 8
    //   466: invokestatic 730	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   469: invokevirtual 733	java/lang/Integer:intValue	()I
    //   472: istore_2
    //   473: new 740	android/os/Bundle
    //   476: dup
    //   477: invokespecial 741	android/os/Bundle:<init>	()V
    //   480: astore 8
    //   482: aload 8
    //   484: ldc_w 743
    //   487: iload_2
    //   488: invokevirtual 746	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   491: aload_0
    //   492: getfield 109	com/tencent/mobileqq/flashchat/FlashChatManager:a	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   495: ldc_w 748
    //   498: sipush 968
    //   501: iconst_1
    //   502: aload 8
    //   504: invokevirtual 752	com/tencent/mobileqq/app/QQAppInterface:notifyObservers	(Ljava/lang/Class;IZLandroid/os/Bundle;)V
    //   507: new 371	java/io/File
    //   510: dup
    //   511: aload 7
    //   513: invokespecial 377	java/io/File:<init>	(Ljava/lang/String;)V
    //   516: invokevirtual 425	java/io/File:delete	()Z
    //   519: pop
    //   520: aload_0
    //   521: getfield 96	com/tencent/mobileqq/flashchat/FlashChatManager:k	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   524: astore_1
    //   525: aload_1
    //   526: iconst_0
    //   527: invokevirtual 759	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   530: goto +27 -> 557
    //   533: astore_1
    //   534: goto +27 -> 561
    //   537: astore 7
    //   539: aload 7
    //   541: invokevirtual 491	java/lang/Exception:printStackTrace	()V
    //   544: aload_1
    //   545: invokevirtual 425	java/io/File:delete	()Z
    //   548: pop
    //   549: aload_0
    //   550: getfield 96	com/tencent/mobileqq/flashchat/FlashChatManager:k	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   553: astore_1
    //   554: goto -29 -> 525
    //   557: aload 6
    //   559: monitorexit
    //   560: return
    //   561: aload_0
    //   562: getfield 96	com/tencent/mobileqq/flashchat/FlashChatManager:k	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   565: iconst_0
    //   566: invokevirtual 759	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   569: aload_1
    //   570: athrow
    //   571: astore_1
    //   572: aload 6
    //   574: monitorexit
    //   575: aload_1
    //   576: athrow
    //   577: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	578	0	this	FlashChatManager
    //   0	578	1	paramString	String
    //   0	578	2	paramInt	int
    //   72	283	3	i1	int
    //   103	196	4	i2	int
    //   69	5	5	bool	boolean
    //   13	560	6	localObject1	Object
    //   379	133	7	str1	String
    //   537	3	7	localException	Exception
    //   282	221	8	localObject2	Object
    //   426	34	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   95	105	111	java/lang/Exception
    //   288	298	304	java/lang/Exception
    //   456	520	533	finally
    //   539	549	533	finally
    //   456	520	537	java/lang/Exception
    //   446	456	571	finally
    //   520	525	571	finally
    //   525	530	571	finally
    //   549	554	571	finally
    //   557	560	571	finally
    //   561	571	571	finally
    //   572	575	571	finally
  }
  
  public void a(ArrayList<FlashChatItem> paramArrayList, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("onGetFlashItems begin ");
      paramArrayOfByte.append(paramBoolean);
      QLog.i("FlashChat", 2, paramArrayOfByte.toString());
    }
    if (paramArrayList != null)
    {
      if (paramBoolean) {
        this.e.a("FlashItems", paramArrayList);
      }
      paramArrayList.add(0, FlashChatItem.sDefaultItem);
      this.l = paramArrayList;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        paramArrayOfByte = (FlashChatItem)paramArrayList.next();
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onGetFlashItems item = ");
          localStringBuilder.append(paramArrayOfByte);
          QLog.i("FlashChat", 2, localStringBuilder.toString());
        }
        if ((paramArrayOfByte.id != -100001) && (paramArrayOfByte.id != -100000)) {
          a(paramArrayOfByte.id, paramArrayOfByte.appName, paramArrayOfByte.ver);
        }
      }
    }
  }
  
  public boolean a(int paramInt, MessageRecord paramMessageRecord)
  {
    Object localObject1 = p;
    Object localObject3 = q;
    long l2 = 0L;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = localObject3;
      if (localObject3 != null) {
        break label213;
      }
    }
    localObject3 = new SparseArray();
    Object localObject4 = new SparseArray();
    SharedPreferences localSharedPreferences = this.a.getApp().getSharedPreferences("sp_flashchat_source", 0);
    int[] arrayOfInt = this.r;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    for (;;)
    {
      localObject1 = localObject3;
      localObject2 = localObject4;
      if (i1 >= i2) {
        break;
      }
      int i3 = arrayOfInt[i1];
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("use_count_");
      ((StringBuilder)localObject1).append(i3);
      int i4 = localSharedPreferences.getInt(((StringBuilder)localObject1).toString(), 0);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("use_lasttime_");
      ((StringBuilder)localObject1).append(i3);
      l1 = localSharedPreferences.getLong(((StringBuilder)localObject1).toString(), 0L);
      ((SparseArray)localObject3).put(i3, Integer.valueOf(i4));
      ((SparseArray)localObject4).put(i3, Long.valueOf(l1));
      i1 += 1;
    }
    label213:
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              l1 = 0L;
              i1 = 0;
              break label327;
            }
            i1 = this.c.m;
            i2 = this.c.o;
          }
          else
          {
            i1 = this.c.l;
            i2 = this.c.n;
          }
          l1 = 1000L * i2;
          break label327;
        }
        i1 = this.c.j;
      }
      else
      {
        i1 = this.c.k;
      }
    }
    else {
      i1 = this.c.i;
    }
    long l1 = 0L;
    label327:
    localObject3 = (Integer)((SparseArray)localObject1).get(paramInt);
    localObject4 = (Long)localObject2.get(paramInt);
    if (localObject3 != null) {
      i2 = ((Integer)localObject3).intValue();
    } else {
      i2 = 0;
    }
    if (localObject4 != null) {
      l2 = ((Long)localObject4).longValue();
    }
    boolean bool;
    if ((i2 < i1) && (Math.abs(System.currentTimeMillis() - l2) > l1)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("hasLeftCount type ");
      ((StringBuilder)localObject3).append(paramInt);
      ((StringBuilder)localObject3).append(" ,");
      ((StringBuilder)localObject3).append(bool);
      ((StringBuilder)localObject3).append(", ");
      ((StringBuilder)localObject3).append(i2);
      ((StringBuilder)localObject3).append(", ");
      ((StringBuilder)localObject3).append(i1);
      ((StringBuilder)localObject3).append(", ");
      ((StringBuilder)localObject3).append(l2);
      ((StringBuilder)localObject3).append(", ");
      ((StringBuilder)localObject3).append(l1);
      QLog.i("FlashChat", 2, ((StringBuilder)localObject3).toString());
    }
    if (bool)
    {
      l1 = System.currentTimeMillis();
      ((SparseArray)localObject1).put(paramInt, Integer.valueOf(i2 + 1));
      localObject2.put(paramInt, Long.valueOf(l1));
      paramMessageRecord.saveExtInfoToExtStr("qim_source", "1");
      ReportController.b(this.a, "dc00898", "", "", "0X8008278", "0X8008278", paramInt, 0, "", "", "", "");
    }
    p = (SparseArray)localObject1;
    q = localObject2;
    return bool;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool3 = RichTextChatManager.a(paramQQAppInterface).c(paramQQAppInterface);
    boolean bool2 = false;
    boolean bool1 = false;
    if (!bool3) {
      return false;
    }
    paramQQAppInterface = RichTextChatManager.a(paramQQAppInterface).b(paramQQAppInterface);
    if (paramQQAppInterface != null)
    {
      if (paramQQAppInterface.size() <= 0) {
        return false;
      }
      paramQQAppInterface = paramQQAppInterface.iterator();
      for (;;)
      {
        bool2 = bool1;
        if (!paramQQAppInterface.hasNext()) {
          break;
        }
        if (((Integer)paramQQAppInterface.next()).intValue() == 1) {
          bool1 = true;
        }
      }
    }
    return bool2;
  }
  
  public String b()
  {
    String str2 = (String)this.s.get(this.a.getCurrentAccountUin());
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = null;
    }
    return str1;
  }
  
  public boolean b(MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    MessageForArkFlashChat localMessageForArkFlashChat = this.g;
    return (localMessageForArkFlashChat != null) && (localMessageForArkFlashChat.uniseq == paramMessageForArkFlashChat.uniseq);
  }
  
  public void c()
  {
    this.b = true;
    d();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initAndGetSwitch ");
      ((StringBuilder)localObject).append(this.c.a);
      ((StringBuilder)localObject).append(" u ");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("FlashChat", 2, ((StringBuilder)localObject).toString());
    }
    if ((p == null) || (q == null))
    {
      localObject = new SparseArray();
      SparseArray localSparseArray = new SparseArray();
      SharedPreferences localSharedPreferences = this.a.getApp().getSharedPreferences("sp_flashchat_source", 0);
      int[] arrayOfInt = this.r;
      int i2 = arrayOfInt.length;
      int i1 = 0;
      while (i1 < i2)
      {
        int i3 = arrayOfInt[i1];
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("use_count_");
        localStringBuilder.append(i3);
        int i4 = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("use_lasttime_");
        localStringBuilder.append(i3);
        long l1 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
        ((SparseArray)localObject).put(i3, Integer.valueOf(i4));
        localSparseArray.put(i3, Long.valueOf(l1));
        i1 += 1;
      }
      p = (SparseArray)localObject;
      q = localSparseArray;
    }
    ((FlashChatHanlder)this.a.getBusinessHandler(BusinessHandlerFactory.FLASH_CHAT_HANDLER)).a();
  }
  
  public void c(String paramString)
  {
    this.s.put(this.a.getCurrentAccountUin(), paramString);
  }
  
  public boolean c(MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    paramMessageForArkFlashChat = (Long)this.i.get(Long.valueOf(paramMessageForArkFlashChat.uniseq));
    return (paramMessageForArkFlashChat != null) && (System.currentTimeMillis() - paramMessageForArkFlashChat.longValue() < 600L);
  }
  
  public void d()
  {
    if (this.t) {
      return;
    }
    this.t = true;
    Object localObject1 = (FlashChatConfBean)QConfigManager.b().b(168);
    if (localObject1 == null) {
      localObject1 = "";
    } else {
      localObject1 = ((FlashChatConfBean)localObject1).a;
    }
    e((String)localObject1);
    try
    {
      localObject1 = (ArrayList)this.e.a("FlashItems", ArrayList.class, 0);
    }
    catch (QStorageSafeDeleteException localQStorageSafeDeleteException)
    {
      QLog.i("FlashChat", 1, "loadFromCacheOnce", localQStorageSafeDeleteException);
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      QLog.i("FlashChat", 1, "loadFromCacheOnce", localQStorageInstantiateException);
    }
    Object localObject2 = null;
    a((ArrayList)localObject2, false, null);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadFromCacheOnce ");
      if (localObject2 != null) {
        localObject2 = Integer.valueOf(((ArrayList)localObject2).size());
      } else {
        localObject2 = "null";
      }
      localStringBuilder.append(localObject2);
      QLog.i("FlashChat", 2, localStringBuilder.toString());
    }
  }
  
  public boolean d(MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext()) {
      if (((MessageForArkFlashChat)localIterator.next()).uniseq == paramMessageForArkFlashChat.uniseq) {
        return true;
      }
    }
    return false;
  }
  
  public void e(MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    if ((Long)this.i.get(Long.valueOf(paramMessageForArkFlashChat.uniseq)) == null) {
      this.i.put(Long.valueOf(paramMessageForArkFlashChat.uniseq), Long.valueOf(System.currentTimeMillis()));
    }
    this.h.add(paramMessageForArkFlashChat);
  }
  
  public void e(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("loadConfig l :");
      localStringBuilder1.append(paramString);
      QLog.i("FlashChat", 2, localStringBuilder1.toString());
    }
    try
    {
      this.c = ((FlashChatManager.GlobalConfig)QStorage.a(paramString, FlashChatManager.GlobalConfig.class));
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("loadConfig l :");
      localStringBuilder2.append(paramString);
      QLog.i("FlashChat", 1, localStringBuilder2.toString(), localQStorageInstantiateException);
    }
    this.a.notifyObservers(FlashChatObserver.class, 969, true, null);
    this.a.notifyObservers(FlashChatObserver.class, 970, true, null);
  }
  
  public boolean e()
  {
    d();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSwitchUser g ");
      localStringBuilder.append(this.c.a);
      localStringBuilder.append(" u ");
      localStringBuilder.append(this.b);
      QLog.d("FlashChat", 2, localStringBuilder.toString());
    }
    return this.b;
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "requestAIOFlashItems");
    }
    NewIntent localNewIntent = new NewIntent(this.a.getApplication(), FlashChatServlet.class);
    localNewIntent.putExtra("req_type", 1);
    this.a.startServlet(localNewIntent);
  }
  
  public ArrayList<FlashChatItem> g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "getItemList");
    }
    ArrayList localArrayList2 = this.l;
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      localArrayList1.add(FlashChatItem.sDefaultItem);
    }
    return localArrayList1;
  }
  
  public boolean h()
  {
    FlashChatManager.GlobalConfig localGlobalConfig = this.c;
    if (localGlobalConfig != null) {
      return TextUtils.isEmpty(localGlobalConfig.g) ^ true;
    }
    return false;
  }
  
  public boolean i()
  {
    FlashChatManager.GlobalConfig localGlobalConfig = this.c;
    if (localGlobalConfig != null) {
      return localGlobalConfig.p;
    }
    return false;
  }
  
  public boolean j()
  {
    FlashChatManager.GlobalConfig localGlobalConfig = this.c;
    if (localGlobalConfig != null) {
      return localGlobalConfig.q;
    }
    return false;
  }
  
  public String k()
  {
    FlashChatManager.GlobalConfig localGlobalConfig = this.c;
    if (localGlobalConfig != null) {
      return localGlobalConfig.r;
    }
    return "";
  }
  
  public void onDestroy()
  {
    int i1 = 0;
    this.t = false;
    this.f = false;
    SharedPreferences.Editor localEditor = this.a.getApp().getSharedPreferences("sp_flashchat_source", 0).edit();
    SparseArray localSparseArray1 = p;
    SparseArray localSparseArray2 = q;
    if (localSparseArray1 != null)
    {
      int[] arrayOfInt = this.r;
      int i2 = arrayOfInt.length;
      while (i1 < i2)
      {
        int i3 = arrayOfInt[i1];
        Object localObject = (Integer)localSparseArray1.get(i3);
        Long localLong = (Long)localSparseArray2.get(i3);
        if (localObject != null)
        {
          int i4 = ((Integer)localObject).intValue();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("use_count_");
          ((StringBuilder)localObject).append(i3);
          localEditor.putInt(((StringBuilder)localObject).toString(), i4);
        }
        if (localLong != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("use_lasttime_");
          ((StringBuilder)localObject).append(i3);
          localEditor.putLong(((StringBuilder)localObject).toString(), localLong.longValue());
        }
        i1 += 1;
      }
    }
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatManager
 * JD-Core Version:    0.7.0.1
 */