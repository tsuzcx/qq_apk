package com.tencent.mobileqq.forward;

import adap;
import adaq;
import adar;
import adas;
import adat;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.file.DeviceFileHandler;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.util.VersionUtils;
import cooperation.smartdevice.SmartDevicePluginLoader;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public abstract class ForwardFileBaseOption
  extends ForwardBaseOption
  implements Handler.Callback
{
  public static String f;
  ForwardFileInfo jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo;
  ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public final MqqHandler a;
  private QQCustomDialog b;
  private boolean g;
  private boolean h;
  
  public ForwardFileBaseOption(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  }
  
  public static String a(Context paramContext, Uri paramUri)
  {
    String str = paramUri.getScheme();
    if ((str == null) || (str.equals("file"))) {
      return new File(paramUri.getPath()).getAbsolutePath();
    }
    if (str.equals("content")) {
      try
      {
        paramContext = paramContext.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
        int i = paramContext.getColumnIndexOrThrow("_data");
        paramContext.moveToFirst();
        paramUri = paramContext.getString(i);
        paramContext.close();
        return paramUri;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  public static String a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    Object localObject = null;
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    try
    {
      paramString = localBaseApplication.getContentResolver().query(paramUri, new String[] { "_data" }, paramString, paramArrayOfString, null);
      if ((paramString == null) || (paramString != null)) {
        paramString.close();
      }
    }
    finally
    {
      try
      {
        if (paramString.moveToFirst())
        {
          paramUri = paramString.getString(paramString.getColumnIndexOrThrow("_data"));
          if (paramString != null) {
            paramString.close();
          }
          return paramUri;
        }
        if (paramString != null) {
          paramString.close();
        }
        return null;
      }
      finally {}
      paramUri = finally;
      paramString = localObject;
    }
    throw paramUri;
  }
  
  private String a(String paramString, long paramLong)
  {
    Object localObject;
    if (paramLong < 1024L) {
      localObject = paramLong + " bytes";
    }
    for (;;)
    {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131435610) + paramString + "\n" + this.jdField_a_of_type_AndroidContentContext.getString(2131435611) + (String)localObject;
      if (paramLong < 1048576L)
      {
        localObject = paramLong / 1024L + " KB";
      }
      else
      {
        localObject = new DecimalFormat("##0.00");
        localObject = ((DecimalFormat)localObject).format(paramLong / 1048576.0D) + " MB";
      }
    }
  }
  
  private void a(Uri paramUri, String paramString, InputStream paramInputStream, long paramLong)
  {
    this.g = true;
    ThreadManager.post(new adar(this, paramString, paramInputStream, paramLong, paramUri), 5, null, true);
    if (this.b == null)
    {
      this.b = DialogUtil.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext.getString(2131436278), "取消", new adas(this));
      this.b.setOnDismissListener(new adat(this));
    }
    this.b.show();
  }
  
  private boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!paramString.startsWith("/data/data/com.tencent.mobileqq/")) {
      return false;
    }
    return true;
  }
  
  /* Error */
  private String c(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 178	com/tencent/mobileqq/forward/ForwardFileBaseOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   4: invokevirtual 229	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   7: astore 8
    //   9: aload 8
    //   11: aload_1
    //   12: aconst_null
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: invokevirtual 86	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   19: astore 6
    //   21: aload 6
    //   23: ifnonnull +33 -> 56
    //   26: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +11 -> 40
    //   32: ldc 236
    //   34: iconst_2
    //   35: ldc 238
    //   37: invokestatic 242	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   40: aload 6
    //   42: ifnull +10 -> 52
    //   45: aload 6
    //   47: invokeinterface 103 1 0
    //   52: aconst_null
    //   53: astore_1
    //   54: aload_1
    //   55: areturn
    //   56: aload 6
    //   58: ldc 244
    //   60: invokeinterface 247 2 0
    //   65: istore_2
    //   66: aload 6
    //   68: ldc 249
    //   70: invokeinterface 247 2 0
    //   75: istore_3
    //   76: aload 6
    //   78: invokeinterface 96 1 0
    //   83: pop
    //   84: aload 6
    //   86: iload_3
    //   87: invokeinterface 253 2 0
    //   92: lstore 4
    //   94: lload 4
    //   96: l2f
    //   97: invokestatic 258	com/tencent/mobileqq/utils/FileUtils:c	()F
    //   100: fcmpl
    //   101: ifle +30 -> 131
    //   104: aload_0
    //   105: getfield 178	com/tencent/mobileqq/forward/ForwardFileBaseOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   108: ldc_w 259
    //   111: invokevirtual 260	android/app/Activity:getString	(I)Ljava/lang/String;
    //   114: putstatic 262	com/tencent/mobileqq/forward/ForwardFileBaseOption:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   117: aload 6
    //   119: ifnull +10 -> 129
    //   122: aload 6
    //   124: invokeinterface 103 1 0
    //   129: aconst_null
    //   130: areturn
    //   131: iload_2
    //   132: iconst_m1
    //   133: if_icmpne +147 -> 280
    //   136: new 121	java/lang/StringBuilder
    //   139: dup
    //   140: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   143: invokestatic 268	java/lang/System:currentTimeMillis	()J
    //   146: invokevirtual 126	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   149: ldc_w 270
    //   152: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: astore 7
    //   160: new 121	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   167: aload_0
    //   168: getfield 178	com/tencent/mobileqq/forward/ForwardFileBaseOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   171: invokevirtual 274	android/app/Activity:getExternalCacheDir	()Ljava/io/File;
    //   174: invokevirtual 277	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   177: ldc_w 279
    //   180: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: ldc_w 281
    //   186: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: ldc_w 279
    //   192: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: astore 9
    //   200: aload 9
    //   202: invokestatic 284	com/tencent/mobileqq/forward/ForwardFileBaseOption:e	(Ljava/lang/String;)V
    //   205: new 121	java/lang/StringBuilder
    //   208: dup
    //   209: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   212: aload 9
    //   214: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload 9
    //   219: aload 7
    //   221: invokestatic 287	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   224: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: astore 7
    //   232: new 61	java/io/File
    //   235: dup
    //   236: aload 9
    //   238: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   241: astore 9
    //   243: aload 9
    //   245: invokevirtual 290	java/io/File:exists	()Z
    //   248: ifne +45 -> 293
    //   251: aload 9
    //   253: invokevirtual 293	java/io/File:mkdirs	()Z
    //   256: ifne +37 -> 293
    //   259: aload_0
    //   260: ldc_w 295
    //   263: invokespecial 210	com/tencent/mobileqq/forward/ForwardFileBaseOption:d	(Ljava/lang/String;)V
    //   266: aload 6
    //   268: ifnull +10 -> 278
    //   271: aload 6
    //   273: invokeinterface 103 1 0
    //   278: aconst_null
    //   279: areturn
    //   280: aload 6
    //   282: iload_2
    //   283: invokeinterface 100 2 0
    //   288: astore 7
    //   290: goto -130 -> 160
    //   293: aload 8
    //   295: aload_1
    //   296: invokevirtual 299	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   299: astore 8
    //   301: aload 8
    //   303: ifnonnull +32 -> 335
    //   306: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   309: ifeq +12 -> 321
    //   312: ldc 236
    //   314: iconst_2
    //   315: ldc_w 301
    //   318: invokestatic 242	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   321: aload 6
    //   323: ifnull +10 -> 333
    //   326: aload 6
    //   328: invokeinterface 103 1 0
    //   333: aconst_null
    //   334: areturn
    //   335: lload 4
    //   337: ldc2_w 302
    //   340: lcmp
    //   341: ifle +156 -> 497
    //   344: aload_0
    //   345: iconst_1
    //   346: putfield 305	com/tencent/mobileqq/forward/ForwardFileBaseOption:h	Z
    //   349: new 196	com/tencent/mobileqq/utils/QQCustomDialog
    //   352: dup
    //   353: aload_0
    //   354: getfield 178	com/tencent/mobileqq/forward/ForwardFileBaseOption:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   357: ldc_w 306
    //   360: invokespecial 309	com/tencent/mobileqq/utils/QQCustomDialog:<init>	(Landroid/content/Context;I)V
    //   363: astore 9
    //   365: aload 9
    //   367: ldc_w 310
    //   370: invokevirtual 314	com/tencent/mobileqq/utils/QQCustomDialog:setContentView	(I)V
    //   373: aload 9
    //   375: aload_0
    //   376: getfield 137	com/tencent/mobileqq/forward/ForwardFileBaseOption:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   379: ldc_w 315
    //   382: invokevirtual 139	android/content/Context:getString	(I)Ljava/lang/String;
    //   385: invokevirtual 319	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   388: pop
    //   389: aload 9
    //   391: aload_0
    //   392: getfield 137	com/tencent/mobileqq/forward/ForwardFileBaseOption:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   395: ldc_w 320
    //   398: invokevirtual 139	android/content/Context:getString	(I)Ljava/lang/String;
    //   401: invokevirtual 324	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(Ljava/lang/CharSequence;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   404: pop
    //   405: aload 9
    //   407: iconst_0
    //   408: invokevirtual 328	com/tencent/mobileqq/utils/QQCustomDialog:setCanceledOnTouchOutside	(Z)V
    //   411: aload 9
    //   413: iconst_0
    //   414: invokevirtual 331	com/tencent/mobileqq/utils/QQCustomDialog:setCancelable	(Z)V
    //   417: aload 9
    //   419: aload_0
    //   420: getfield 137	com/tencent/mobileqq/forward/ForwardFileBaseOption:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   423: ldc_w 332
    //   426: invokevirtual 139	android/content/Context:getString	(I)Ljava/lang/String;
    //   429: new 334	adau
    //   432: dup
    //   433: aload_0
    //   434: aload 8
    //   436: invokespecial 337	adau:<init>	(Lcom/tencent/mobileqq/forward/ForwardFileBaseOption;Ljava/io/InputStream;)V
    //   439: invokevirtual 341	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   442: pop
    //   443: aload 9
    //   445: aload_0
    //   446: getfield 137	com/tencent/mobileqq/forward/ForwardFileBaseOption:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   449: ldc_w 342
    //   452: invokevirtual 139	android/content/Context:getString	(I)Ljava/lang/String;
    //   455: new 344	adav
    //   458: dup
    //   459: aload_0
    //   460: aload_1
    //   461: aload 7
    //   463: aload 8
    //   465: lload 4
    //   467: invokespecial 346	adav:<init>	(Lcom/tencent/mobileqq/forward/ForwardFileBaseOption;Landroid/net/Uri;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   470: invokevirtual 349	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   473: pop
    //   474: aload 9
    //   476: invokevirtual 203	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   479: aload 7
    //   481: astore_1
    //   482: aload 6
    //   484: ifnull -430 -> 54
    //   487: aload 6
    //   489: invokeinterface 103 1 0
    //   494: aload 7
    //   496: areturn
    //   497: aload_0
    //   498: aload_1
    //   499: aload 7
    //   501: aload 8
    //   503: lload 4
    //   505: invokespecial 206	com/tencent/mobileqq/forward/ForwardFileBaseOption:a	(Landroid/net/Uri;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   508: goto -29 -> 479
    //   511: astore 7
    //   513: aload 6
    //   515: astore_1
    //   516: aload 7
    //   518: astore 6
    //   520: aload_0
    //   521: iconst_0
    //   522: putfield 162	com/tencent/mobileqq/forward/ForwardFileBaseOption:g	Z
    //   525: invokestatic 234	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   528: ifeq +14 -> 542
    //   531: ldc 236
    //   533: iconst_2
    //   534: ldc_w 351
    //   537: aload 6
    //   539: invokestatic 354	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   542: aload_1
    //   543: ifnull +9 -> 552
    //   546: aload_1
    //   547: invokeinterface 103 1 0
    //   552: aconst_null
    //   553: areturn
    //   554: astore_1
    //   555: aconst_null
    //   556: astore 6
    //   558: aload 6
    //   560: ifnull +10 -> 570
    //   563: aload 6
    //   565: invokeinterface 103 1 0
    //   570: aload_1
    //   571: athrow
    //   572: astore_1
    //   573: goto -15 -> 558
    //   576: astore 7
    //   578: aload_1
    //   579: astore 6
    //   581: aload 7
    //   583: astore_1
    //   584: goto -26 -> 558
    //   587: astore 6
    //   589: aconst_null
    //   590: astore_1
    //   591: goto -71 -> 520
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	594	0	this	ForwardFileBaseOption
    //   0	594	1	paramUri	Uri
    //   65	218	2	i	int
    //   75	12	3	j	int
    //   92	412	4	l	long
    //   19	561	6	localObject1	Object
    //   587	1	6	localException1	Exception
    //   158	342	7	str	String
    //   511	6	7	localException2	Exception
    //   576	6	7	localObject2	Object
    //   7	495	8	localObject3	Object
    //   198	277	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   26	40	511	java/lang/Exception
    //   56	117	511	java/lang/Exception
    //   136	160	511	java/lang/Exception
    //   160	266	511	java/lang/Exception
    //   280	290	511	java/lang/Exception
    //   293	301	511	java/lang/Exception
    //   306	321	511	java/lang/Exception
    //   344	479	511	java/lang/Exception
    //   497	508	511	java/lang/Exception
    //   9	21	554	finally
    //   26	40	572	finally
    //   56	117	572	finally
    //   136	160	572	finally
    //   160	266	572	finally
    //   280	290	572	finally
    //   293	301	572	finally
    //   306	321	572	finally
    //   344	479	572	finally
    //   497	508	572	finally
    //   520	542	576	finally
    //   9	21	587	java/lang/Exception
  }
  
  private void d(String paramString)
  {
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(this.jdField_a_of_type_AndroidAppActivity, 2131624515);
    localQQCustomDialog.setContentView(2130968851);
    localQQCustomDialog.setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131434764));
    localQQCustomDialog.setMessage(paramString);
    localQQCustomDialog.setCanceledOnTouchOutside(false);
    localQQCustomDialog.setCancelable(false);
    localQQCustomDialog.setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131433681), new adap(this));
    if (!this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
      localQQCustomDialog.show();
    }
  }
  
  private static void e(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {}
    for (;;)
    {
      return;
      paramString = paramString.listFiles();
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if (System.currentTimeMillis() - localObject.lastModified() > 86400000L) {
          localObject.delete();
        }
        i += 1;
      }
    }
  }
  
  private void w()
  {
    if (this.b != null) {
      this.b.dismiss();
    }
  }
  
  protected String a(Uri paramUri)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardFileBaseOption", 2, "uri= " + paramUri);
    }
    if ((VersionUtils.i()) && ("com.android.fileexplorer.fileprovider".equalsIgnoreCase(paramUri.getAuthority())))
    {
      localObject1 = paramUri.getPathSegments();
      if ((((List)localObject1).size() >= 2) && ("external_files".equalsIgnoreCase((String)((List)localObject1).get(0))))
      {
        paramUri = paramUri.getPath().replaceFirst("\\/external_files", AppConstants.aI);
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardFileBaseOption", 2, "Nougat path: " + paramUri);
        }
        return paramUri;
      }
    }
    else if (VersionUtils.h())
    {
      localObject1 = paramUri.getPathSegments();
      if ((((List)localObject1).size() < 2) || (!"document".equals(((List)localObject1).get(0)))) {
        break label437;
      }
    }
    label437:
    Object localObject2;
    for (Object localObject1 = (String)((List)localObject1).get(1);; localObject2 = null) {
      for (;;)
      {
        try
        {
          if ("com.android.externalstorage.documents".equals(paramUri.getAuthority()))
          {
            localObject1 = ((String)localObject1).split(":");
            if ("primary".equalsIgnoreCase(localObject1[0])) {
              return Environment.getExternalStorageDirectory() + "/" + localObject1[1];
            }
          }
          else
          {
            if ("com.android.providers.downloads.documents".equals(paramUri.getAuthority())) {
              return a(ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf((String)localObject1).longValue()), null, null);
            }
            if ("com.android.providers.media.documents".equals(paramUri.getAuthority()))
            {
              String[] arrayOfString = ((String)localObject1).split(":");
              localObject1 = arrayOfString[0];
              if ("image".equals(localObject1))
              {
                localObject1 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                return a((Uri)localObject1, "_id=?", new String[] { arrayOfString[1] });
              }
              if ("video".equals(localObject1))
              {
                localObject1 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                continue;
              }
              if (!"audio".equals(localObject1)) {
                break;
              }
              localObject1 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
              continue;
            }
            boolean bool = "com.google.android.apps.photos.content".equals(paramUri.getAuthority());
            if (!bool) {}
          }
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ForwardOption.ForwardFileBaseOption", 2, "handle exeption ", localException);
          continue;
        }
        return b(paramUri);
        if ((localException.size() >= 2) && ("my_external".equals(localException.get(0))) && ("com.android.contacts.files".equals(paramUri.getAuthority())))
        {
          paramUri = new StringBuilder(Environment.getExternalStorageDirectory().getAbsolutePath());
          int i = 1;
          while (i < localException.size())
          {
            paramUri.append('/').append((String)localException.get(i));
            i += 1;
          }
          return paramUri.toString();
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str;
    if (paramInt1 == 102)
    {
      str = this.jdField_a_of_type_AndroidOsBundle.getString("uin");
      if (!((DeviceFileHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(50)).a(Long.parseLong(str)))
      {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "打印机离线，无法打印", 2000).a();
        this.jdField_a_of_type_AndroidAppActivity.finish();
      }
    }
    else
    {
      return;
    }
    Object localObject = paramIntent.getParcelableArrayListExtra("sFilesSelected");
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      ArrayList localArrayList = new ArrayList();
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList.add(((FileInfo)((Iterator)localObject).next()).c());
      }
      paramIntent = paramIntent.getStringExtra("sPrintParam");
      DeviceMsgChatPie.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, localArrayList, paramIntent);
    }
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  protected void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString2 = ((SmartDeviceProxyMgr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(Long.parseLong(paramString2));
      Object localObject = new FileInfo(paramString1);
      paramString1 = new ArrayList();
      paramString1.add(localObject);
      localObject = new Intent();
      ((Intent)localObject).putParcelableArrayListExtra("sFilesSelected", paramString1);
      ((Intent)localObject).putExtra("sIsCloudPrinter", true);
      ((Intent)localObject).putExtra("device_info", paramString2);
      ((Intent)localObject).putExtra("url", "http://qzs.qq.com/open/mobile/iot_print/html/printOpt.html");
      ((Intent)localObject).putExtra("filetype", paramString3);
      SmartDevicePluginLoader.a().a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), (Intent)localObject, "com.tencent.device.activities.LightPinterOptionActivity", 102, null, SmartDevicePluginProxyActivity.class);
      return;
    }
    catch (FileNotFoundException paramString1) {}
  }
  
  public boolean a()
  {
    super.a();
    jdField_f_of_type_JavaLangString = null;
    Uri localUri = this.jdField_a_of_type_AndroidContentIntent.getData();
    if ((localUri != null) && (TextUtils.isEmpty(this.jdField_a_of_type_AndroidOsBundle.getString("forward_filepath")))) {
      a(localUri);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataForwardFileInfo = ((ForwardFileInfo)this.jdField_a_of_type_AndroidContentIntent.getParcelableExtra("fileinfo"));
    this.jdField_a_of_type_JavaUtilArrayList = this.jdField_a_of_type_AndroidContentIntent.getParcelableArrayListExtra("fileinfo_array");
    return true;
  }
  
  protected boolean a(Uri paramUri)
  {
    this.g = false;
    this.h = false;
    String str = a(paramUri);
    if (TextUtils.isEmpty(str))
    {
      d(d());
      return false;
    }
    File localFile = new File(str);
    long l = localFile.length();
    if ((!this.g) && (!this.h) && (l == 0L))
    {
      if (paramUri.toString().contains("mms/part"))
      {
        d(this.jdField_a_of_type_AndroidContentContext.getString(2131436271));
        return false;
      }
      d(this.jdField_a_of_type_AndroidContentContext.getString(2131436270));
      return false;
    }
    if ((true == this.jdField_a_of_type_AndroidOsBundle.getBoolean("forward_from_jump")) && (true == this.jdField_a_of_type_AndroidOsBundle.getBoolean("isFromShare")) && (b(str)))
    {
      paramUri = new QQCustomDialog(this.jdField_a_of_type_AndroidAppActivity, 2131624515);
      paramUri.setContentView(2130968851);
      paramUri.setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131434764));
      paramUri.setMessage(this.jdField_a_of_type_AndroidContentContext.getString(2131436272));
      paramUri.setCanceledOnTouchOutside(false);
      paramUri.setCancelable(false);
      paramUri.setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131433681), new adaq(this));
      paramUri.show();
      return false;
    }
    paramUri = localFile.getName();
    boolean bool = localFile.canRead();
    if ((!this.g) && (!this.h) && (!bool))
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("android.intent.extra.TEXT");
      this.jdField_a_of_type_AndroidOsBundle.putInt("forward_type", -1);
      return false;
    }
    this.jdField_a_of_type_AndroidOsBundle.putString("forward_filepath", str);
    c(str);
    this.jdField_a_of_type_JavaLangString = a(paramUri, l);
    return true;
  }
  
  public String b(Uri paramUri)
  {
    Object localObject = null;
    String str = paramUri.getScheme();
    if ((str == null) || (str.equals("file"))) {
      localObject = new File(paramUri.getPath()).getAbsolutePath();
    }
    for (;;)
    {
      return localObject;
      if (str.equals("content")) {
        try
        {
          localObject = this.jdField_a_of_type_AndroidAppActivity.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
          int i = ((Cursor)localObject).getColumnIndexOrThrow("_data");
          ((Cursor)localObject).moveToFirst();
          str = ((Cursor)localObject).getString(i);
          ((Cursor)localObject).close();
          localObject = str;
          if (!new File(str).canRead())
          {
            localObject = c(paramUri);
            return localObject;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
    return c(paramUri);
  }
  
  protected void b()
  {
    super.b();
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.adjustMessageBottomMargin(17.0F);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageTextColor(2131493794);
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessageTextSize(14.0F);
  }
  
  protected void c(String paramString) {}
  
  protected boolean c()
  {
    Intent localIntent;
    boolean bool;
    if (this.jdField_a_of_type_AndroidOsBundle.getInt("uintype") == 1008)
    {
      localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, ChatActivity.class);
      localIntent.putExtra("chat_subType", PublicAccountManager.a(this.jdField_a_of_type_AndroidOsBundle.getString("uin"), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      if (this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("sendMultiple", false))
      {
        this.jdField_a_of_type_AndroidOsBundle.putString("leftBackText", "消息");
        localIntent.addFlags(268435456);
        localIntent.addFlags(67108864);
        localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
        bool = a(localIntent);
        if (!this.jdField_f_of_type_Boolean) {
          break label178;
        }
        this.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
      }
    }
    for (;;)
    {
      localIntent.putExtras(this.jdField_a_of_type_AndroidOsBundle);
      this.jdField_a_of_type_AndroidAppActivity.setResult(-1, localIntent);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      return false;
      localIntent = AIOUtils.a(new Intent(this.jdField_a_of_type_AndroidAppActivity, SplashActivity.class), null);
      break;
      label178:
      if (!bool) {
        ForwardUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext, localIntent, null);
      }
    }
  }
  
  public String d()
  {
    if (jdField_f_of_type_JavaLangString == null) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131436269);
    }
    return jdField_f_of_type_JavaLangString;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      w();
      d(d());
      continue;
      w();
      continue;
      QLog.i("ForwardOption.ForwardFileBaseOption", 2, "progress: " + paramMessage.arg1);
      this.b.setProgress(paramMessage.arg1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardFileBaseOption
 * JD-Core Version:    0.7.0.1
 */