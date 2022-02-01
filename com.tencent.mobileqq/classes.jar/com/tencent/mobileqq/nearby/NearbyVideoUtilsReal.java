package com.tencent.mobileqq.nearby;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment;
import com.tencent.mobileqq.nearby.widget.BlueButtonInfo;
import com.tencent.mobileqq.nearby.widget.NearbyCustomDialog;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class NearbyVideoUtilsReal
{
  private static String a = "need_show_auth_video_guide_";
  private static String b = "need_open_auth_video";
  
  /* Error */
  private static String a(android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 24	java/io/File
    //   3: dup
    //   4: getstatic 29	com/tencent/mobileqq/app/AppConstants:DYNAMIC_PROFILE	Ljava/lang/String;
    //   7: invokestatic 35	com/tencent/mobileqq/vfs/VFSAssistantUtils:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   10: invokespecial 38	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 42	java/io/File:mkdirs	()Z
    //   18: pop
    //   19: new 44	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   26: astore_2
    //   27: aload_2
    //   28: ldc 47
    //   30: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_2
    //   35: invokestatic 57	java/lang/System:currentTimeMillis	()J
    //   38: invokevirtual 60	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: new 24	java/io/File
    //   45: dup
    //   46: aload_1
    //   47: aload_2
    //   48: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokespecial 67	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   54: astore 7
    //   56: aload 7
    //   58: invokevirtual 70	java/io/File:exists	()Z
    //   61: ifeq +9 -> 70
    //   64: aload 7
    //   66: invokevirtual 73	java/io/File:delete	()Z
    //   69: pop
    //   70: aconst_null
    //   71: astore 5
    //   73: aconst_null
    //   74: astore 6
    //   76: new 75	java/io/FileOutputStream
    //   79: dup
    //   80: aload 7
    //   82: invokespecial 78	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   85: astore_2
    //   86: new 80	java/io/BufferedOutputStream
    //   89: dup
    //   90: aload_2
    //   91: sipush 4096
    //   94: invokespecial 83	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   97: astore 4
    //   99: aload_2
    //   100: astore_1
    //   101: aload 4
    //   103: astore_3
    //   104: aload_0
    //   105: getstatic 89	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   108: bipush 100
    //   110: aload 4
    //   112: invokevirtual 95	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   115: pop
    //   116: aload_2
    //   117: astore_1
    //   118: aload 4
    //   120: astore_3
    //   121: aload 4
    //   123: invokevirtual 98	java/io/BufferedOutputStream:flush	()V
    //   126: aload_2
    //   127: astore_1
    //   128: aload 4
    //   130: astore_3
    //   131: aload 7
    //   133: invokevirtual 101	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   136: astore_0
    //   137: aload_2
    //   138: invokevirtual 104	java/io/FileOutputStream:close	()V
    //   141: goto +8 -> 149
    //   144: astore_1
    //   145: aload_1
    //   146: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   149: aload_0
    //   150: astore_1
    //   151: aload 4
    //   153: invokevirtual 108	java/io/BufferedOutputStream:close	()V
    //   156: aload_0
    //   157: astore_1
    //   158: goto +107 -> 265
    //   161: astore_0
    //   162: aload_0
    //   163: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   166: goto +99 -> 265
    //   169: astore_1
    //   170: aload 4
    //   172: astore_0
    //   173: aload_1
    //   174: astore 4
    //   176: goto +32 -> 208
    //   179: astore_0
    //   180: aconst_null
    //   181: astore_3
    //   182: aload_2
    //   183: astore_1
    //   184: goto +121 -> 305
    //   187: astore 4
    //   189: aconst_null
    //   190: astore_0
    //   191: goto +17 -> 208
    //   194: astore_0
    //   195: aconst_null
    //   196: astore_1
    //   197: aload_1
    //   198: astore_3
    //   199: goto +106 -> 305
    //   202: astore 4
    //   204: aconst_null
    //   205: astore_2
    //   206: aload_2
    //   207: astore_0
    //   208: aload_2
    //   209: astore_1
    //   210: aload_0
    //   211: astore_3
    //   212: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq +17 -> 232
    //   218: aload_2
    //   219: astore_1
    //   220: aload_0
    //   221: astore_3
    //   222: ldc 115
    //   224: iconst_2
    //   225: ldc 117
    //   227: aload 4
    //   229: invokestatic 121	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   232: aload_2
    //   233: ifnull +15 -> 248
    //   236: aload_2
    //   237: invokevirtual 104	java/io/FileOutputStream:close	()V
    //   240: goto +8 -> 248
    //   243: astore_1
    //   244: aload_1
    //   245: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   248: aload 5
    //   250: astore_1
    //   251: aload_0
    //   252: ifnull +13 -> 265
    //   255: aload 6
    //   257: astore_1
    //   258: aload_0
    //   259: invokevirtual 108	java/io/BufferedOutputStream:close	()V
    //   262: aload 5
    //   264: astore_1
    //   265: invokestatic 113	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   268: ifeq +34 -> 302
    //   271: new 44	java/lang/StringBuilder
    //   274: dup
    //   275: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   278: astore_0
    //   279: aload_0
    //   280: ldc 123
    //   282: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload_0
    //   287: aload_1
    //   288: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: ldc 115
    //   294: iconst_2
    //   295: aload_0
    //   296: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 127	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: aload_1
    //   303: areturn
    //   304: astore_0
    //   305: aload_1
    //   306: ifnull +15 -> 321
    //   309: aload_1
    //   310: invokevirtual 104	java/io/FileOutputStream:close	()V
    //   313: goto +8 -> 321
    //   316: astore_1
    //   317: aload_1
    //   318: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   321: aload_3
    //   322: ifnull +15 -> 337
    //   325: aload_3
    //   326: invokevirtual 108	java/io/BufferedOutputStream:close	()V
    //   329: goto +8 -> 337
    //   332: astore_1
    //   333: aload_1
    //   334: invokevirtual 107	java/io/IOException:printStackTrace	()V
    //   337: aload_0
    //   338: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	paramBitmap	android.graphics.Bitmap
    //   13	115	1	localObject1	Object
    //   144	2	1	localIOException1	java.io.IOException
    //   150	8	1	localBitmap	android.graphics.Bitmap
    //   169	5	1	localException1	java.lang.Exception
    //   183	37	1	localObject2	Object
    //   243	2	1	localIOException2	java.io.IOException
    //   250	60	1	localObject3	Object
    //   316	2	1	localIOException3	java.io.IOException
    //   332	2	1	localIOException4	java.io.IOException
    //   26	211	2	localObject4	Object
    //   103	223	3	localObject5	Object
    //   97	78	4	localObject6	Object
    //   187	1	4	localException2	java.lang.Exception
    //   202	26	4	localException3	java.lang.Exception
    //   71	192	5	localObject7	Object
    //   74	182	6	localObject8	Object
    //   54	78	7	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   137	141	144	java/io/IOException
    //   151	156	161	java/io/IOException
    //   258	262	161	java/io/IOException
    //   104	116	169	java/lang/Exception
    //   121	126	169	java/lang/Exception
    //   131	137	169	java/lang/Exception
    //   86	99	179	finally
    //   86	99	187	java/lang/Exception
    //   76	86	194	finally
    //   76	86	202	java/lang/Exception
    //   236	240	243	java/io/IOException
    //   104	116	304	finally
    //   121	126	304	finally
    //   131	137	304	finally
    //   212	218	304	finally
    //   222	232	304	finally
    //   309	313	316	java/io/IOException
    //   325	329	332	java/io/IOException
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, int paramInt) {}
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("file_send_path", paramString1);
    localIntent.putExtra("video_url", paramString2);
    localIntent.putExtra("video_thumb_url", paramString3);
    localIntent.putExtra("mode", paramInt);
    localIntent.putExtra("uin", paramString4);
    localIntent.putExtra("is_authentic", paramBoolean);
    PublicFragmentActivity.a(paramActivity, localIntent, NearbyAuthVideoPlayerFragment.class, 11000);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface.execute(new NearbyVideoUtilsReal.3(paramString, paramQQAppInterface));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, TransProcessorHandler paramTransProcessorHandler)
  {
    paramTransProcessorHandler.addFilter(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).addHandle(paramTransProcessorHandler);
    ThreadManager.post(new NearbyVideoUtilsReal.2(paramQQAppInterface, paramString, (int)(System.currentTimeMillis() / 1000L)), 8, null, true);
  }
  
  public static void a(String paramString)
  {
    try
    {
      boolean bool = new JSONObject(paramString).getBoolean("VideoAuthEnable");
      String str = b;
      PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit().putBoolean(str, bool).commit();
      return;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setAuthVideoConfig=");
        localStringBuilder.append(paramString);
        localStringBuilder.append(",error:");
        localStringBuilder.append(localJSONException.toString());
        QLog.e("NearbyVideoUtils", 2, localStringBuilder.toString());
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, String... paramVarArgs)
  {
    new ReportTask(null).a("dc00899").b("grp_lbs").c(paramString1).d(paramString2).a(paramInt1).b(paramInt2).a(paramVarArgs).a();
  }
  
  public static void a(String paramString, String... paramVarArgs)
  {
    a("data_card", paramString, 0, 0, paramVarArgs);
  }
  
  public static boolean a()
  {
    String str = b;
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getBoolean(str, true);
  }
  
  public static boolean a(Activity paramActivity, QQAppInterface paramQQAppInterface)
  {
    if (!a(paramQQAppInterface)) {
      return false;
    }
    if (paramActivity.isFinishing())
    {
      if (QLog.isColorLevel()) {
        QLog.i("NearbyVideoUtils", 2, "showVoteUpdateDialog invoke, but activity is finishing");
      }
      return false;
    }
    ImageView localImageView = new ImageView(paramActivity);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setImageDrawable(URLDrawable.getDrawable("https://pub.idqqimg.com/pc/misc/files/20170807/f2f569d65bc74317bb9a6bfe482dcd2c.png?_t=1502087876532"));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.b(150.0F, paramActivity.getResources()));
    new NearbyCustomDialog(paramActivity).a(localImageView, localLayoutParams).b(HardCodeUtil.a(2131905248)).a(new BlueButtonInfo(HardCodeUtil.a(2131905250), new NearbyVideoUtilsReal.1(paramActivity, paramQQAppInterface))).show();
    b(paramQQAppInterface);
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface = localStringBuilder.toString();
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getBoolean(paramQQAppInterface, true);
  }
  
  public static String b(String paramString)
  {
    return a(ShortVideoUtils.getVideoThumbnail(null, paramString));
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a);
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface = localStringBuilder.toString();
    PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit().putBoolean(paramQQAppInterface, false).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyVideoUtilsReal
 * JD-Core Version:    0.7.0.1
 */