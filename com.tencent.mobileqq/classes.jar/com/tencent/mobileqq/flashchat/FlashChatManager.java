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
  public static SparseArray<Integer> b;
  public static SparseArray<Long> c;
  public SparseArray<String> a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  QStorage jdField_a_of_type_ComTencentMobileqqConfigQStorage = QStorage.a("flashchat");
  MessageForArkFlashChat jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat = null;
  public FlashChatManager.GlobalConfig a;
  String jdField_a_of_type_JavaLangString;
  public ArrayList<FlashChatItem> a;
  private HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public ConcurrentHashMap<Long, Long> a;
  public CopyOnWriteArrayList<MessageForArkFlashChat> a;
  public AtomicBoolean a;
  public boolean a;
  int[] jdField_a_of_type_ArrayOfInt = { 3, 4, 2, 1, 0 };
  public ConcurrentHashMap<String, String> b;
  boolean b;
  public ConcurrentHashMap<String, String> c;
  boolean c;
  private boolean d;
  
  public FlashChatManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig = new FlashChatManager.GlobalConfig();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
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
    int k = ((ISVIPHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).g();
    int i = paramFlashChatItem.feedType;
    int j = 1;
    if (i != 4)
    {
      if (i != 5)
      {
        i = j;
        break label71;
      }
      if (k == 3)
      {
        i = j;
        break label71;
      }
    }
    do
    {
      i = 0;
      break;
      i = j;
      if (k == 1) {
        break;
      }
    } while (k != 3);
    i = j;
    label71:
    paramQQAppInterface = null;
    if (i == 0)
    {
      if (paramFlashChatItem.feedType == 5) {
        return "CJCLUBT";
      }
      paramQQAppInterface = "LTMCLUB";
    }
    return paramQQAppInterface;
  }
  
  /* Error */
  private void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +53 -> 56
    //   6: new 154	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   13: astore 4
    //   15: aload 4
    //   17: ldc 157
    //   19: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 4
    //   25: aload_1
    //   26: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 4
    //   32: ldc 163
    //   34: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 4
    //   40: aload_2
    //   41: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: ldc 165
    //   47: iconst_2
    //   48: aload 4
    //   50: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: new 154	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   63: astore 4
    //   65: aload 4
    //   67: aload_2
    //   68: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 4
    //   74: getstatic 177	java/io/File:separator	Ljava/lang/String;
    //   77: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: new 174	java/io/File
    //   84: dup
    //   85: aload 4
    //   87: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokespecial 180	java/io/File:<init>	(Ljava/lang/String;)V
    //   93: astore 4
    //   95: aload 4
    //   97: invokevirtual 183	java/io/File:exists	()Z
    //   100: ifne +9 -> 109
    //   103: aload 4
    //   105: invokevirtual 186	java/io/File:mkdirs	()Z
    //   108: pop
    //   109: aconst_null
    //   110: astore 4
    //   112: new 188	com/tencent/commonsdk/zip/QZipFile
    //   115: dup
    //   116: aload_1
    //   117: invokespecial 189	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   120: astore 6
    //   122: aload 6
    //   124: invokevirtual 195	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   127: astore 7
    //   129: sipush 8192
    //   132: newarray byte
    //   134: astore 8
    //   136: aload 7
    //   138: invokeinterface 200 1 0
    //   143: ifeq +337 -> 480
    //   146: aload 7
    //   148: invokeinterface 204 1 0
    //   153: checkcast 206	java/util/zip/ZipEntry
    //   156: astore_1
    //   157: aload_1
    //   158: invokevirtual 209	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   161: astore 5
    //   163: aload 5
    //   165: ifnull -29 -> 136
    //   168: aload 5
    //   170: ldc 211
    //   172: invokevirtual 217	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   175: ifeq +6 -> 181
    //   178: goto -42 -> 136
    //   181: new 154	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   188: astore 9
    //   190: aload 9
    //   192: aload_2
    //   193: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: aload 9
    //   199: getstatic 177	java/io/File:separator	Ljava/lang/String;
    //   202: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 9
    //   208: aload 5
    //   210: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 9
    //   216: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: astore 5
    //   221: aload_1
    //   222: invokevirtual 220	java/util/zip/ZipEntry:isDirectory	()Z
    //   225: ifeq +28 -> 253
    //   228: new 174	java/io/File
    //   231: dup
    //   232: aload 5
    //   234: invokespecial 180	java/io/File:<init>	(Ljava/lang/String;)V
    //   237: astore_1
    //   238: aload_1
    //   239: invokevirtual 183	java/io/File:exists	()Z
    //   242: ifne -106 -> 136
    //   245: aload_1
    //   246: invokevirtual 223	java/io/File:mkdir	()Z
    //   249: pop
    //   250: goto -114 -> 136
    //   253: aload 5
    //   255: getstatic 177	java/io/File:separator	Ljava/lang/String;
    //   258: invokevirtual 227	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   261: istore_3
    //   262: aload 5
    //   264: iconst_0
    //   265: iload_3
    //   266: invokevirtual 231	java/lang/String:substring	(II)Ljava/lang/String;
    //   269: astore 9
    //   271: aload 5
    //   273: iload_3
    //   274: iconst_1
    //   275: iadd
    //   276: invokevirtual 234	java/lang/String:substring	(I)Ljava/lang/String;
    //   279: ldc 236
    //   281: invokevirtual 240	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   284: ifeq +6 -> 290
    //   287: goto -151 -> 136
    //   290: new 174	java/io/File
    //   293: dup
    //   294: aload 9
    //   296: invokespecial 180	java/io/File:<init>	(Ljava/lang/String;)V
    //   299: astore 9
    //   301: aload 9
    //   303: invokevirtual 183	java/io/File:exists	()Z
    //   306: ifne +9 -> 315
    //   309: aload 9
    //   311: invokevirtual 223	java/io/File:mkdir	()Z
    //   314: pop
    //   315: new 154	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   322: astore 9
    //   324: aload 9
    //   326: aload 5
    //   328: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload 9
    //   334: ldc 242
    //   336: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: pop
    //   340: new 174	java/io/File
    //   343: dup
    //   344: aload 9
    //   346: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokespecial 180	java/io/File:<init>	(Ljava/lang/String;)V
    //   352: astore 9
    //   354: new 174	java/io/File
    //   357: dup
    //   358: aload 5
    //   360: invokespecial 180	java/io/File:<init>	(Ljava/lang/String;)V
    //   363: astore 10
    //   365: aload 9
    //   367: invokevirtual 183	java/io/File:exists	()Z
    //   370: ifeq +9 -> 379
    //   373: aload 9
    //   375: invokevirtual 245	java/io/File:delete	()Z
    //   378: pop
    //   379: new 247	java/io/FileOutputStream
    //   382: dup
    //   383: aload 9
    //   385: invokespecial 250	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   388: astore 5
    //   390: aload 6
    //   392: aload_1
    //   393: invokevirtual 254	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   396: astore_1
    //   397: aload_1
    //   398: aload 8
    //   400: iconst_0
    //   401: aload 8
    //   403: arraylength
    //   404: invokevirtual 260	java/io/InputStream:read	([BII)I
    //   407: istore_3
    //   408: iload_3
    //   409: iconst_m1
    //   410: if_icmpeq +15 -> 425
    //   413: aload 5
    //   415: aload 8
    //   417: iconst_0
    //   418: iload_3
    //   419: invokevirtual 264	java/io/FileOutputStream:write	([BII)V
    //   422: goto -25 -> 397
    //   425: aload 5
    //   427: invokevirtual 267	java/io/FileOutputStream:flush	()V
    //   430: aload 5
    //   432: invokevirtual 270	java/io/FileOutputStream:close	()V
    //   435: aload_1
    //   436: invokevirtual 271	java/io/InputStream:close	()V
    //   439: aload 9
    //   441: aload 10
    //   443: invokestatic 277	com/tencent/mobileqq/utils/FileUtils:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   446: ifne -310 -> 136
    //   449: aload 9
    //   451: aload 10
    //   453: invokestatic 280	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   456: pop
    //   457: goto -321 -> 136
    //   460: astore 4
    //   462: aload_1
    //   463: astore_2
    //   464: aload 4
    //   466: astore_1
    //   467: goto +6 -> 473
    //   470: astore_1
    //   471: aconst_null
    //   472: astore_2
    //   473: aload 5
    //   475: astore 4
    //   477: goto +7 -> 484
    //   480: return
    //   481: astore_1
    //   482: aconst_null
    //   483: astore_2
    //   484: aload 4
    //   486: ifnull +18 -> 504
    //   489: aload 4
    //   491: invokevirtual 270	java/io/FileOutputStream:close	()V
    //   494: goto +10 -> 504
    //   497: astore 4
    //   499: aload 4
    //   501: invokevirtual 283	java/io/IOException:printStackTrace	()V
    //   504: aload_2
    //   505: ifnull +15 -> 520
    //   508: aload_2
    //   509: invokevirtual 271	java/io/InputStream:close	()V
    //   512: goto +8 -> 520
    //   515: astore_2
    //   516: aload_2
    //   517: invokevirtual 283	java/io/IOException:printStackTrace	()V
    //   520: goto +5 -> 525
    //   523: aload_1
    //   524: athrow
    //   525: goto -2 -> 523
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	528	0	this	FlashChatManager
    //   0	528	1	paramString1	String
    //   0	528	2	paramString2	String
    //   261	158	3	i	int
    //   13	98	4	localObject1	Object
    //   460	5	4	localObject2	Object
    //   475	15	4	localObject3	Object
    //   497	3	4	localIOException	java.io.IOException
    //   161	313	5	localObject4	Object
    //   120	271	6	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   127	20	7	localEnumeration	java.util.Enumeration
    //   134	282	8	arrayOfByte	byte[]
    //   188	262	9	localObject5	Object
    //   363	89	10	localFile	File
    // Exception table:
    //   from	to	target	type
    //   397	408	460	finally
    //   413	422	460	finally
    //   425	439	460	finally
    //   390	397	470	finally
    //   112	136	481	finally
    //   136	163	481	finally
    //   168	178	481	finally
    //   181	250	481	finally
    //   253	287	481	finally
    //   290	315	481	finally
    //   315	379	481	finally
    //   379	390	481	finally
    //   439	457	481	finally
    //   489	494	497	java/io/IOException
    //   508	512	515	java/io/IOException
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
      label223:
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
      break label223;
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
    int i;
    if (TextUtils.isEmpty(paramString1)) {
      i = -1;
    } else {
      i = paramString1.indexOf("://");
    }
    if (i == -1)
    {
      arrayOfString[0] = paramString1;
      return arrayOfString;
    }
    arrayOfString[0] = paramString1.substring(0, i);
    arrayOfString[1] = paramString1.substring(i + 3);
    return arrayOfString;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    int j;
    int i;
    do
    {
      return "";
      j = paramString.length();
      i = 0;
      int k = j - 1;
      while ((i <= k) && (paramString.charAt(i) == ' ')) {
        i += 1;
      }
      j = k;
      while ((j >= i) && (paramString.charAt(j) == ' ')) {
        j -= 1;
      }
      if ((i == 0) && (j == k)) {
        return paramString;
      }
    } while (i > j);
    return paramString.substring(i, j + 1);
  }
  
  public static String c(String paramString)
  {
    return paramString.substring(0, paramString.lastIndexOf("."));
  }
  
  public ArkFlashChatMessage a(String paramString, int paramInt1, int paramInt2)
  {
    if (!a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      return null;
    }
    if (paramString != null)
    {
      if (TextUtils.isEmpty(paramString.trim())) {
        return null;
      }
      try
      {
        Object localObject1 = this.jdField_a_of_type_JavaUtilArrayList;
        if (localObject1 != null)
        {
          localObject3 = ((ArrayList)localObject1).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject1 = (FlashChatItem)((Iterator)localObject3).next();
            if ((localObject1 != null) && (((FlashChatItem)localObject1).id == paramInt2))
            {
              if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (FlashChatItem)localObject1) == null) {
                break label118;
              }
              a("");
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      Object localObject2 = null;
      label118:
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
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      Object localObject = BaseApplicationImpl.getContext();
      int i = 0;
      try
      {
        boolean bool = "mounted".equals(Environment.getExternalStorageState());
        i = bool;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      if (i != 0) {
        localObject = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH);
      } else {
        localObject = ((Context)localObject).getFilesDir().getAbsolutePath();
      }
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(File.separator);
      localStringBuilder.append("flashchat");
      localStringBuilder.append(File.separator);
      this.jdField_a_of_type_JavaLangString = localStringBuilder.toString();
      new File(this.jdField_a_of_type_JavaLangString).mkdirs();
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    Object localObject1 = (String)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
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
    ((StringBuilder)localObject2).append(c(((FlashChatManager.FlashPackCfg)localObject1).jdField_b_of_type_JavaLangString));
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
      int j = localObject2.length;
      int i = 0;
      while (i < j)
      {
        localObject1 = localObject2[i];
        if ((((File)localObject1).isFile()) && (((File)localObject1).getName().endsWith(".app")) && (((File)localObject1).getName().contains(paramString2))) {
          break label427;
        }
        i += 1;
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
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject1);
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
  
  public ArrayList<FlashChatItem> a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "getItemList");
    }
    ArrayList localArrayList2 = this.jdField_a_of_type_JavaUtilArrayList;
    ArrayList localArrayList1 = localArrayList2;
    if (localArrayList2 == null)
    {
      localArrayList1 = new ArrayList();
      localArrayList1.add(FlashChatItem.sDefaultItem);
    }
    return localArrayList1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    b();
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initAndGetSwitch ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" u ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
      QLog.d("FlashChat", 2, ((StringBuilder)localObject).toString());
    }
    if ((jdField_b_of_type_AndroidUtilSparseArray == null) || (jdField_c_of_type_AndroidUtilSparseArray == null))
    {
      localObject = new SparseArray();
      SparseArray localSparseArray = new SparseArray();
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("sp_flashchat_source", 0);
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      int j = arrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = arrayOfInt[i];
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("use_count_");
        localStringBuilder.append(k);
        int m = localSharedPreferences.getInt(localStringBuilder.toString(), 0);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("use_lasttime_");
        localStringBuilder.append(k);
        long l = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
        ((SparseArray)localObject).put(k, Integer.valueOf(m));
        localSparseArray.put(k, Long.valueOf(l));
        i += 1;
      }
      jdField_b_of_type_AndroidUtilSparseArray = (SparseArray)localObject;
      jdField_c_of_type_AndroidUtilSparseArray = localSparseArray;
    }
    ((FlashChatHanlder)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FLASH_CHAT_HANDLER)).a();
  }
  
  public void a(int paramInt)
  {
    IVasQuickUpdateService localIVasQuickUpdateService = (IVasQuickUpdateService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IVasQuickUpdateService.class, "");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("flashchat.");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(".cfg");
    localObject = ((StringBuilder)localObject).toString();
    this.jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap.put(localObject, String.valueOf(paramInt));
    localIVasQuickUpdateService.downloadItem(1002L, (String)localObject, "initChatResource");
  }
  
  public void a(Context paramContext, MessageRecord paramMessageRecord)
  {
    FlashChatManager.GlobalConfig localGlobalConfig = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig;
    String str1 = localGlobalConfig.jdField_c_of_type_JavaLangString;
    String str2 = localGlobalConfig.jdField_f_of_type_JavaLangString;
    String str3 = localGlobalConfig.jdField_g_of_type_JavaLangString;
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
    if (a(paramContext, str1, str2, str3, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
      return;
    }
    a(paramContext, str1, localGlobalConfig.jdField_b_of_type_JavaLangString, paramMessageRecord);
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
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat;
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
    this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat = paramMessageForArkFlashChat;
  }
  
  public void a(Long paramLong)
  {
    Object localObject = (CopyOnWriteArrayList)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clone();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
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
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilHashMap.put(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString);
  }
  
  /* Error */
  public void a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +55 -> 58
    //   6: new 154	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   13: astore 6
    //   15: aload 6
    //   17: ldc_w 775
    //   20: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 6
    //   26: aload_1
    //   27: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 6
    //   33: ldc_w 777
    //   36: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 6
    //   42: iload_2
    //   43: invokevirtual 562	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: ldc 165
    //   49: iconst_2
    //   50: aload 6
    //   52: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 172	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: aload_1
    //   59: ifnull +519 -> 578
    //   62: aload_1
    //   63: ldc_w 572
    //   66: invokevirtual 613	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   69: istore 5
    //   71: iconst_m1
    //   72: istore_3
    //   73: iload 5
    //   75: ifeq +187 -> 262
    //   78: aload_0
    //   79: getfield 87	com/tencent/mobileqq/flashchat/FlashChatManager:jdField_c_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   82: aload_1
    //   83: invokevirtual 780	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   86: checkcast 213	java/lang/String
    //   89: astore 6
    //   91: iload_2
    //   92: ifeq +89 -> 181
    //   95: aload 6
    //   97: invokestatic 783	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   100: invokevirtual 786	java/lang/Integer:intValue	()I
    //   103: istore 4
    //   105: iload 4
    //   107: istore_3
    //   108: goto +41 -> 149
    //   111: astore_1
    //   112: new 154	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   119: astore 6
    //   121: aload 6
    //   123: ldc_w 788
    //   126: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 6
    //   132: iload_2
    //   133: invokevirtual 562	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: ldc 165
    //   139: iconst_2
    //   140: aload 6
    //   142: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: aload_1
    //   146: invokestatic 792	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   149: new 794	android/os/Bundle
    //   152: dup
    //   153: invokespecial 795	android/os/Bundle:<init>	()V
    //   156: astore_1
    //   157: aload_1
    //   158: ldc_w 797
    //   161: iload_3
    //   162: invokevirtual 800	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   165: aload_0
    //   166: getfield 93	com/tencent/mobileqq/flashchat/FlashChatManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   169: ldc_w 802
    //   172: sipush 968
    //   175: iconst_0
    //   176: aload_1
    //   177: invokevirtual 806	com/tencent/mobileqq/app/QQAppInterface:notifyObservers	(Ljava/lang/Class;IZLandroid/os/Bundle;)V
    //   180: return
    //   181: new 174	java/io/File
    //   184: dup
    //   185: aload_0
    //   186: aload_1
    //   187: invokevirtual 574	com/tencent/mobileqq/flashchat/FlashChatManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   190: invokespecial 180	java/io/File:<init>	(Ljava/lang/String;)V
    //   193: invokestatic 578	com/tencent/mobileqq/utils/FileUtils:readFileContent	(Ljava/io/File;)Ljava/lang/String;
    //   196: invokestatic 583	com/tencent/mobileqq/flashchat/FlashChatManager$FlashPackCfg:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/flashchat/FlashChatManager$FlashPackCfg;
    //   199: astore_1
    //   200: aload_1
    //   201: ifnull +377 -> 578
    //   204: aload_1
    //   205: getfield 589	com/tencent/mobileqq/flashchat/FlashChatManager$FlashPackCfg:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   208: ifnull +370 -> 578
    //   211: aload 6
    //   213: ifnull +365 -> 578
    //   216: aload_0
    //   217: getfield 73	com/tencent/mobileqq/flashchat/FlashChatManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   220: aload_1
    //   221: getfield 589	com/tencent/mobileqq/flashchat/FlashChatManager$FlashPackCfg:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   224: aload 6
    //   226: invokevirtual 701	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   229: pop
    //   230: aload_0
    //   231: getfield 93	com/tencent/mobileqq/flashchat/FlashChatManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   234: ldc_w 692
    //   237: ldc_w 339
    //   240: invokevirtual 696	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;Ljava/lang/String;)Lmqq/app/api/IRuntimeService;
    //   243: checkcast 692	com/tencent/mobileqq/vas/updatesystem/api/IVasQuickUpdateService
    //   246: ldc2_w 702
    //   249: aload_1
    //   250: getfield 589	com/tencent/mobileqq/flashchat/FlashChatManager$FlashPackCfg:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   253: ldc_w 808
    //   256: invokeinterface 709 5 0
    //   261: return
    //   262: aload_1
    //   263: ldc_w 810
    //   266: invokevirtual 613	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   269: ifeq +309 -> 578
    //   272: aload_0
    //   273: getfield 73	com/tencent/mobileqq/flashchat/FlashChatManager:jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   276: aload_1
    //   277: invokevirtual 780	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   280: checkcast 213	java/lang/String
    //   283: astore 8
    //   285: iload_2
    //   286: ifeq +89 -> 375
    //   289: aload 8
    //   291: invokestatic 783	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   294: invokevirtual 786	java/lang/Integer:intValue	()I
    //   297: istore 4
    //   299: iload 4
    //   301: istore_3
    //   302: goto +41 -> 343
    //   305: astore_1
    //   306: new 154	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   313: astore 6
    //   315: aload 6
    //   317: ldc_w 788
    //   320: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: aload 6
    //   326: iload_2
    //   327: invokevirtual 562	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: ldc 165
    //   333: iconst_2
    //   334: aload 6
    //   336: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: aload_1
    //   340: invokestatic 792	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   343: new 794	android/os/Bundle
    //   346: dup
    //   347: invokespecial 795	android/os/Bundle:<init>	()V
    //   350: astore_1
    //   351: aload_1
    //   352: ldc_w 797
    //   355: iload_3
    //   356: invokevirtual 800	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   359: aload_0
    //   360: getfield 93	com/tencent/mobileqq/flashchat/FlashChatManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   363: ldc_w 802
    //   366: sipush 968
    //   369: iconst_0
    //   370: aload_1
    //   371: invokevirtual 806	com/tencent/mobileqq/app/QQAppInterface:notifyObservers	(Ljava/lang/Class;IZLandroid/os/Bundle;)V
    //   374: return
    //   375: aload_0
    //   376: aload_1
    //   377: invokevirtual 574	com/tencent/mobileqq/flashchat/FlashChatManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   380: astore 7
    //   382: aload_1
    //   383: invokestatic 591	com/tencent/mobileqq/flashchat/FlashChatManager:c	(Ljava/lang/String;)Ljava/lang/String;
    //   386: astore_1
    //   387: new 154	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 155	java/lang/StringBuilder:<init>	()V
    //   394: astore 6
    //   396: aload 6
    //   398: aload_0
    //   399: invokevirtual 587	com/tencent/mobileqq/flashchat/FlashChatManager:a	()Ljava/lang/String;
    //   402: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload 6
    //   408: aload_1
    //   409: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: aload 6
    //   415: getstatic 177	java/io/File:separator	Ljava/lang/String;
    //   418: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: pop
    //   422: aload 6
    //   424: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: astore 9
    //   429: aload_0
    //   430: getfield 80	com/tencent/mobileqq/flashchat/FlashChatManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   433: iconst_1
    //   434: invokevirtual 813	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   437: aload 9
    //   439: invokevirtual 816	java/lang/String:intern	()Ljava/lang/String;
    //   442: astore 6
    //   444: aload 6
    //   446: monitorenter
    //   447: new 174	java/io/File
    //   450: dup
    //   451: aload 9
    //   453: invokespecial 180	java/io/File:<init>	(Ljava/lang/String;)V
    //   456: astore_1
    //   457: aload_0
    //   458: aload 7
    //   460: aload 9
    //   462: invokespecial 818	com/tencent/mobileqq/flashchat/FlashChatManager:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   465: aload 8
    //   467: invokestatic 783	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   470: invokevirtual 786	java/lang/Integer:intValue	()I
    //   473: istore_2
    //   474: new 794	android/os/Bundle
    //   477: dup
    //   478: invokespecial 795	android/os/Bundle:<init>	()V
    //   481: astore 8
    //   483: aload 8
    //   485: ldc_w 797
    //   488: iload_2
    //   489: invokevirtual 800	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   492: aload_0
    //   493: getfield 93	com/tencent/mobileqq/flashchat/FlashChatManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   496: ldc_w 802
    //   499: sipush 968
    //   502: iconst_1
    //   503: aload 8
    //   505: invokevirtual 806	com/tencent/mobileqq/app/QQAppInterface:notifyObservers	(Ljava/lang/Class;IZLandroid/os/Bundle;)V
    //   508: new 174	java/io/File
    //   511: dup
    //   512: aload 7
    //   514: invokespecial 180	java/io/File:<init>	(Ljava/lang/String;)V
    //   517: invokevirtual 245	java/io/File:delete	()Z
    //   520: pop
    //   521: aload_0
    //   522: getfield 80	com/tencent/mobileqq/flashchat/FlashChatManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   525: astore_1
    //   526: aload_1
    //   527: iconst_0
    //   528: invokevirtual 813	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   531: goto +27 -> 558
    //   534: astore_1
    //   535: goto +27 -> 562
    //   538: astore 7
    //   540: aload 7
    //   542: invokevirtual 476	java/lang/Exception:printStackTrace	()V
    //   545: aload_1
    //   546: invokevirtual 245	java/io/File:delete	()Z
    //   549: pop
    //   550: aload_0
    //   551: getfield 80	com/tencent/mobileqq/flashchat/FlashChatManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   554: astore_1
    //   555: goto -29 -> 526
    //   558: aload 6
    //   560: monitorexit
    //   561: return
    //   562: aload_0
    //   563: getfield 80	com/tencent/mobileqq/flashchat/FlashChatManager:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   566: iconst_0
    //   567: invokevirtual 813	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   570: aload_1
    //   571: athrow
    //   572: astore_1
    //   573: aload 6
    //   575: monitorexit
    //   576: aload_1
    //   577: athrow
    //   578: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	579	0	this	FlashChatManager
    //   0	579	1	paramString	String
    //   0	579	2	paramInt	int
    //   72	284	3	i	int
    //   103	197	4	j	int
    //   69	5	5	bool	boolean
    //   13	561	6	localObject1	Object
    //   380	133	7	str1	String
    //   538	3	7	localException	Exception
    //   283	221	8	localObject2	Object
    //   427	34	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   95	105	111	java/lang/Exception
    //   289	299	305	java/lang/Exception
    //   457	521	534	finally
    //   540	550	534	finally
    //   457	521	538	java/lang/Exception
    //   447	457	572	finally
    //   521	526	572	finally
    //   526	531	572	finally
    //   550	555	572	finally
    //   558	561	572	finally
    //   562	572	572	finally
    //   573	576	572	finally
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
        this.jdField_a_of_type_ComTencentMobileqqConfigQStorage.a("FlashItems", paramArrayList);
      }
      paramArrayList.add(0, FlashChatItem.sDefaultItem);
      this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
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
  
  public boolean a()
  {
    b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isSwitchUser g ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" u ");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
      QLog.d("FlashChat", 2, localStringBuilder.toString());
    }
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt, MessageRecord paramMessageRecord)
  {
    Object localObject1 = jdField_b_of_type_AndroidUtilSparseArray;
    Object localObject3 = jdField_c_of_type_AndroidUtilSparseArray;
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
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("sp_flashchat_source", 0);
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    int j = arrayOfInt.length;
    int i = 0;
    for (;;)
    {
      localObject1 = localObject3;
      localObject2 = localObject4;
      if (i >= j) {
        break;
      }
      int k = arrayOfInt[i];
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("use_count_");
      ((StringBuilder)localObject1).append(k);
      int m = localSharedPreferences.getInt(((StringBuilder)localObject1).toString(), 0);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("use_lasttime_");
      ((StringBuilder)localObject1).append(k);
      l1 = localSharedPreferences.getLong(((StringBuilder)localObject1).toString(), 0L);
      ((SparseArray)localObject3).put(k, Integer.valueOf(m));
      ((SparseArray)localObject4).put(k, Long.valueOf(l1));
      i += 1;
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
              i = 0;
              break label327;
            }
            i = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig.e;
            j = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig.jdField_g_of_type_Int;
          }
          else
          {
            i = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig.d;
            j = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig.jdField_f_of_type_Int;
          }
          l1 = 1000L * j;
          break label327;
        }
        i = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig.jdField_b_of_type_Int;
      }
      else
      {
        i = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig.jdField_c_of_type_Int;
      }
    }
    else {
      i = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig.jdField_a_of_type_Int;
    }
    long l1 = 0L;
    label327:
    localObject3 = (Integer)((SparseArray)localObject1).get(paramInt);
    localObject4 = (Long)localObject2.get(paramInt);
    if (localObject3 != null) {
      j = ((Integer)localObject3).intValue();
    } else {
      j = 0;
    }
    if (localObject4 != null) {
      l2 = ((Long)localObject4).longValue();
    }
    boolean bool;
    if ((j < i) && (Math.abs(System.currentTimeMillis() - l2) > l1)) {
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
      ((StringBuilder)localObject3).append(j);
      ((StringBuilder)localObject3).append(", ");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append(", ");
      ((StringBuilder)localObject3).append(l2);
      ((StringBuilder)localObject3).append(", ");
      ((StringBuilder)localObject3).append(l1);
      QLog.i("FlashChat", 2, ((StringBuilder)localObject3).toString());
    }
    if (bool)
    {
      l1 = System.currentTimeMillis();
      ((SparseArray)localObject1).put(paramInt, Integer.valueOf(j + 1));
      localObject2.put(paramInt, Long.valueOf(l1));
      paramMessageRecord.saveExtInfoToExtStr("qim_source", "1");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008278", "0X8008278", paramInt, 0, "", "", "", "");
    }
    jdField_b_of_type_AndroidUtilSparseArray = (SparseArray)localObject1;
    jdField_c_of_type_AndroidUtilSparseArray = localObject2;
    return bool;
  }
  
  public boolean a(QQAppInterface paramQQAppInterface)
  {
    boolean bool3 = RichTextChatManager.a(paramQQAppInterface).b(paramQQAppInterface);
    boolean bool2 = false;
    boolean bool1 = false;
    if (!bool3) {
      return false;
    }
    paramQQAppInterface = RichTextChatManager.a(paramQQAppInterface).a(paramQQAppInterface);
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
  
  public boolean a(MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    MessageForArkFlashChat localMessageForArkFlashChat = this.jdField_a_of_type_ComTencentMobileqqDataMessageForArkFlashChat;
    return (localMessageForArkFlashChat != null) && (localMessageForArkFlashChat.uniseq == paramMessageForArkFlashChat.uniseq);
  }
  
  public String b()
  {
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = null;
    }
    return str1;
  }
  
  public void b()
  {
    if (this.d) {
      return;
    }
    this.d = true;
    Object localObject1 = (FlashChatConfBean)QConfigManager.a().a(168);
    if (localObject1 == null) {
      localObject1 = "";
    } else {
      localObject1 = ((FlashChatConfBean)localObject1).jdField_a_of_type_JavaLangString;
    }
    b((String)localObject1);
    try
    {
      localObject1 = (ArrayList)this.jdField_a_of_type_ComTencentMobileqqConfigQStorage.a("FlashItems", ArrayList.class, 0);
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
  
  public void b(MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    if ((Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramMessageForArkFlashChat.uniseq)) == null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(paramMessageForArkFlashChat.uniseq), Long.valueOf(System.currentTimeMillis()));
    }
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramMessageForArkFlashChat);
  }
  
  public void b(String paramString)
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
      this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig = ((FlashChatManager.GlobalConfig)QStorage.a(paramString, FlashChatManager.GlobalConfig.class));
    }
    catch (QStorageInstantiateException localQStorageInstantiateException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("loadConfig l :");
      localStringBuilder2.append(paramString);
      QLog.i("FlashChat", 1, localStringBuilder2.toString(), localQStorageInstantiateException);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.notifyObservers(FlashChatObserver.class, 969, true, null);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.notifyObservers(FlashChatObserver.class, 970, true, null);
  }
  
  public boolean b()
  {
    FlashChatManager.GlobalConfig localGlobalConfig = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig;
    if (localGlobalConfig != null) {
      return TextUtils.isEmpty(localGlobalConfig.jdField_g_of_type_JavaLangString) ^ true;
    }
    return false;
  }
  
  public boolean b(MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    paramMessageForArkFlashChat = (Long)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramMessageForArkFlashChat.uniseq));
    return (paramMessageForArkFlashChat != null) && (System.currentTimeMillis() - paramMessageForArkFlashChat.longValue() < 600L);
  }
  
  public String c()
  {
    FlashChatManager.GlobalConfig localGlobalConfig = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig;
    if (localGlobalConfig != null) {
      return localGlobalConfig.i;
    }
    return "";
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlashChat", 2, "requestAIOFlashItems");
    }
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), FlashChatServlet.class);
    localNewIntent.putExtra("req_type", 1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public boolean c()
  {
    FlashChatManager.GlobalConfig localGlobalConfig = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig;
    if (localGlobalConfig != null) {
      return localGlobalConfig.jdField_a_of_type_Boolean;
    }
    return false;
  }
  
  public boolean c(MessageForArkFlashChat paramMessageForArkFlashChat)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      if (((MessageForArkFlashChat)localIterator.next()).uniseq == paramMessageForArkFlashChat.uniseq) {
        return true;
      }
    }
    return false;
  }
  
  public boolean d()
  {
    FlashChatManager.GlobalConfig localGlobalConfig = this.jdField_a_of_type_ComTencentMobileqqFlashchatFlashChatManager$GlobalConfig;
    if (localGlobalConfig != null) {
      return localGlobalConfig.jdField_b_of_type_Boolean;
    }
    return false;
  }
  
  public void onDestroy()
  {
    int i = 0;
    this.d = false;
    this.jdField_b_of_type_Boolean = false;
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("sp_flashchat_source", 0).edit();
    SparseArray localSparseArray1 = jdField_b_of_type_AndroidUtilSparseArray;
    SparseArray localSparseArray2 = jdField_c_of_type_AndroidUtilSparseArray;
    if (localSparseArray1 != null)
    {
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      int j = arrayOfInt.length;
      while (i < j)
      {
        int k = arrayOfInt[i];
        Object localObject = (Integer)localSparseArray1.get(k);
        Long localLong = (Long)localSparseArray2.get(k);
        if (localObject != null)
        {
          int m = ((Integer)localObject).intValue();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("use_count_");
          ((StringBuilder)localObject).append(k);
          localEditor.putInt(((StringBuilder)localObject).toString(), m);
        }
        if (localLong != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("use_lasttime_");
          ((StringBuilder)localObject).append(k);
          localEditor.putLong(((StringBuilder)localObject).toString(), localLong.longValue());
        }
        i += 1;
      }
    }
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.flashchat.FlashChatManager
 * JD-Core Version:    0.7.0.1
 */