package com.tencent.mobileqq.nearby;

import aevp;
import aevq;
import aevr;
import aevs;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.camera.QavCameraUsage;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.richmedia.MX3FlowNewCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraActivity;
import com.tencent.mobileqq.activity.richmedia.NewPreFlowCamera;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager.DpcAccountNames;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.profilecard.NearbyAuthVideoPlayerFragment;
import com.tencent.mobileqq.nearby.widget.BlueButtonInfo;
import com.tencent.mobileqq.nearby.widget.NearbyCustomDialog;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraCompatibleList;
import com.tencent.mobileqq.shortvideo.util.NativeSoLoader;
import com.tencent.mobileqq.shortvideo.util.PtvFilterSoLoad;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class NearbyVideoUtils
{
  private static String a = "need_show_auth_video_guide_";
  private static String b = "need_open_auth_video";
  
  /* Error */
  private static String a(android.graphics.Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 28	java/io/File
    //   6: dup
    //   7: getstatic 33	com/tencent/mobileqq/app/AppConstants:bJ	Ljava/lang/String;
    //   10: invokespecial 36	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: aload_1
    //   15: invokevirtual 40	java/io/File:mkdirs	()Z
    //   18: pop
    //   19: new 28	java/io/File
    //   22: dup
    //   23: aload_1
    //   24: new 42	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   31: ldc 45
    //   33: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokestatic 55	java/lang/System:currentTimeMillis	()J
    //   39: invokevirtual 58	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   42: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokespecial 65	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   48: astore 5
    //   50: aload 5
    //   52: invokevirtual 68	java/io/File:exists	()Z
    //   55: ifeq +9 -> 64
    //   58: aload 5
    //   60: invokevirtual 71	java/io/File:delete	()Z
    //   63: pop
    //   64: new 73	java/io/FileOutputStream
    //   67: dup
    //   68: aload 5
    //   70: invokespecial 76	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   73: astore_1
    //   74: new 78	java/io/BufferedOutputStream
    //   77: dup
    //   78: aload_1
    //   79: sipush 4096
    //   82: invokespecial 81	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   85: astore 4
    //   87: aload 4
    //   89: astore_3
    //   90: aload_1
    //   91: astore_2
    //   92: aload_0
    //   93: getstatic 87	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   96: bipush 100
    //   98: aload 4
    //   100: invokevirtual 93	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   103: pop
    //   104: aload 4
    //   106: astore_3
    //   107: aload_1
    //   108: astore_2
    //   109: aload 4
    //   111: invokevirtual 96	java/io/BufferedOutputStream:flush	()V
    //   114: aload 4
    //   116: astore_3
    //   117: aload_1
    //   118: astore_2
    //   119: aload 5
    //   121: invokevirtual 99	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   124: astore_0
    //   125: aload_1
    //   126: ifnull +7 -> 133
    //   129: aload_1
    //   130: invokevirtual 102	java/io/FileOutputStream:close	()V
    //   133: aload_0
    //   134: astore_1
    //   135: aload 4
    //   137: ifnull +10 -> 147
    //   140: aload 4
    //   142: invokevirtual 103	java/io/BufferedOutputStream:close	()V
    //   145: aload_0
    //   146: astore_1
    //   147: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +28 -> 178
    //   153: ldc 110
    //   155: iconst_2
    //   156: new 42	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   163: ldc 112
    //   165: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_1
    //   169: invokevirtual 49	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: invokevirtual 62	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokestatic 116	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   178: aload_1
    //   179: areturn
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   185: goto -52 -> 133
    //   188: astore_1
    //   189: aload_1
    //   190: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   193: aload_0
    //   194: astore_1
    //   195: goto -48 -> 147
    //   198: astore 5
    //   200: aconst_null
    //   201: astore_0
    //   202: aconst_null
    //   203: astore_1
    //   204: aload_0
    //   205: astore_3
    //   206: aload_1
    //   207: astore_2
    //   208: aload 5
    //   210: invokevirtual 120	java/io/FileNotFoundException:printStackTrace	()V
    //   213: aload_1
    //   214: ifnull +7 -> 221
    //   217: aload_1
    //   218: invokevirtual 102	java/io/FileOutputStream:close	()V
    //   221: aload 6
    //   223: astore_1
    //   224: aload_0
    //   225: ifnull -78 -> 147
    //   228: aload_0
    //   229: invokevirtual 103	java/io/BufferedOutputStream:close	()V
    //   232: aload 6
    //   234: astore_1
    //   235: goto -88 -> 147
    //   238: astore_0
    //   239: aload_0
    //   240: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   243: aload 6
    //   245: astore_1
    //   246: goto -99 -> 147
    //   249: astore_1
    //   250: aload_1
    //   251: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   254: goto -33 -> 221
    //   257: astore 5
    //   259: aconst_null
    //   260: astore_0
    //   261: aconst_null
    //   262: astore_1
    //   263: aload_0
    //   264: astore_3
    //   265: aload_1
    //   266: astore_2
    //   267: aload 5
    //   269: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   272: aload_1
    //   273: ifnull +7 -> 280
    //   276: aload_1
    //   277: invokevirtual 102	java/io/FileOutputStream:close	()V
    //   280: aload 6
    //   282: astore_1
    //   283: aload_0
    //   284: ifnull -137 -> 147
    //   287: aload_0
    //   288: invokevirtual 103	java/io/BufferedOutputStream:close	()V
    //   291: aload 6
    //   293: astore_1
    //   294: goto -147 -> 147
    //   297: astore_0
    //   298: aload_0
    //   299: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   302: aload 6
    //   304: astore_1
    //   305: goto -158 -> 147
    //   308: astore_1
    //   309: aload_1
    //   310: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   313: goto -33 -> 280
    //   316: astore_0
    //   317: aconst_null
    //   318: astore_3
    //   319: aconst_null
    //   320: astore_1
    //   321: aload_1
    //   322: ifnull +7 -> 329
    //   325: aload_1
    //   326: invokevirtual 102	java/io/FileOutputStream:close	()V
    //   329: aload_3
    //   330: ifnull +7 -> 337
    //   333: aload_3
    //   334: invokevirtual 103	java/io/BufferedOutputStream:close	()V
    //   337: aload_0
    //   338: athrow
    //   339: astore_1
    //   340: aload_1
    //   341: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   344: goto -15 -> 329
    //   347: astore_1
    //   348: aload_1
    //   349: invokevirtual 119	java/io/IOException:printStackTrace	()V
    //   352: goto -15 -> 337
    //   355: astore_0
    //   356: aconst_null
    //   357: astore_3
    //   358: goto -37 -> 321
    //   361: astore_0
    //   362: aload_2
    //   363: astore_1
    //   364: goto -43 -> 321
    //   367: astore 5
    //   369: aconst_null
    //   370: astore_0
    //   371: goto -108 -> 263
    //   374: astore 5
    //   376: aload 4
    //   378: astore_0
    //   379: goto -116 -> 263
    //   382: astore 5
    //   384: aconst_null
    //   385: astore_0
    //   386: goto -182 -> 204
    //   389: astore 5
    //   391: aload 4
    //   393: astore_0
    //   394: goto -190 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	paramBitmap	android.graphics.Bitmap
    //   13	166	1	localObject1	Object
    //   180	2	1	localIOException1	java.io.IOException
    //   188	2	1	localIOException2	java.io.IOException
    //   194	52	1	localObject2	Object
    //   249	2	1	localIOException3	java.io.IOException
    //   262	43	1	localObject3	Object
    //   308	2	1	localIOException4	java.io.IOException
    //   320	6	1	localObject4	Object
    //   339	2	1	localIOException5	java.io.IOException
    //   347	2	1	localIOException6	java.io.IOException
    //   363	1	1	localObject5	Object
    //   91	272	2	localObject6	Object
    //   89	269	3	localObject7	Object
    //   85	307	4	localBufferedOutputStream	java.io.BufferedOutputStream
    //   48	72	5	localFile	java.io.File
    //   198	11	5	localFileNotFoundException1	java.io.FileNotFoundException
    //   257	11	5	localIOException7	java.io.IOException
    //   367	1	5	localIOException8	java.io.IOException
    //   374	1	5	localIOException9	java.io.IOException
    //   382	1	5	localFileNotFoundException2	java.io.FileNotFoundException
    //   389	1	5	localFileNotFoundException3	java.io.FileNotFoundException
    //   1	302	6	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   129	133	180	java/io/IOException
    //   140	145	188	java/io/IOException
    //   64	74	198	java/io/FileNotFoundException
    //   228	232	238	java/io/IOException
    //   217	221	249	java/io/IOException
    //   64	74	257	java/io/IOException
    //   287	291	297	java/io/IOException
    //   276	280	308	java/io/IOException
    //   64	74	316	finally
    //   325	329	339	java/io/IOException
    //   333	337	347	java/io/IOException
    //   74	87	355	finally
    //   92	104	361	finally
    //   109	114	361	finally
    //   119	125	361	finally
    //   208	213	361	finally
    //   267	272	361	finally
    //   74	87	367	java/io/IOException
    //   92	104	374	java/io/IOException
    //   109	114	374	java/io/IOException
    //   119	125	374	java/io/IOException
    //   74	87	382	java/io/FileNotFoundException
    //   92	104	389	java/io/FileNotFoundException
    //   109	114	389	java/io/FileNotFoundException
    //   119	125	389	java/io/FileNotFoundException
  }
  
  public static String a(String paramString)
  {
    return a(ShortVideoUtils.a(null, paramString));
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, int paramInt)
  {
    if (!a(paramAppInterface))
    {
      QQToast.a(BaseApplication.getContext(), "对不起，你的设备不支持视频功能", 0).a();
      return;
    }
    if (QavCameraUsage.b(BaseApplicationImpl.getContext()))
    {
      QQToast.a(BaseApplication.getContext(), 2131434809, 0).a();
      return;
    }
    if (AudioHelper.b(0))
    {
      ChatActivityUtils.b(paramActivity);
      return;
    }
    if (AudioHelper.b(1))
    {
      ChatActivityUtils.a(paramActivity);
      return;
    }
    if (AudioHelper.a(0))
    {
      DialogUtil.a(paramActivity, 230, paramActivity.getResources().getString(2131433425), paramActivity.getResources().getString(2131433427), new aevp(), null).show();
      return;
    }
    boolean bool2 = PtvFilterSoLoad.a(BaseApplicationImpl.getContext());
    boolean bool1;
    if ((VideoEnvironment.e(paramAppInterface)) && ((bool2) || (PtvFilterSoLoad.b())))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.i("NearbyVideoUtils", 2, "filterOK=" + bool2 + ",videoAndSoReady:" + bool1);
      }
      if (!bool1) {
        break label372;
      }
      paramAppInterface = NewFlowCameraActivity.class;
      if (CameraCompatibleList.d(CameraCompatibleList.c)) {
        paramAppInterface = MX3FlowNewCameraActivity.class;
      }
      paramAppInterface = new Intent(paramActivity, paramAppInterface);
      paramAppInterface.putExtra("sv_config", DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.SV658Cfg.name(), null));
      paramAppInterface.putExtra("video_min_frame_count", 3);
      paramAppInterface.putExtra("sv_whitelist", DeviceProfileManager.a().a(DeviceProfileManager.AccountDpcManager.DpcAccountNames.picpredownload_whitelist.name()));
      paramAppInterface.putExtra("flow_camera_video_mode", true);
      paramAppInterface.putExtra("confirm_text", "上传");
      paramAppInterface.putExtra("flow_camera_use_filter_function", bool2);
      paramAppInterface.putExtra("flow_camera_use_3dfilter_function", NativeSoLoader.a("TKGLRenderer"));
      paramAppInterface.putExtra("activity_start_time", SystemClock.elapsedRealtime());
      paramAppInterface.putExtra("edit_video_type", 10011);
      paramActivity.startActivityForResult(paramAppInterface, 11000);
    }
    for (;;)
    {
      a("exp_shoot", new String[] { "" + paramInt });
      return;
      bool1 = false;
      break;
      label372:
      paramAppInterface = new Intent(paramActivity, NewPreFlowCamera.class);
      paramAppInterface.putExtra("edit_video_type", 10011);
      paramActivity.startActivityForResult(paramAppInterface, 11000);
    }
  }
  
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
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a + paramQQAppInterface.getCurrentAccountUin();
    PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).edit().putBoolean(paramQQAppInterface, false).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface.a(new aevs(paramString, paramQQAppInterface));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, TransProcessorHandler paramTransProcessorHandler)
  {
    paramTransProcessorHandler.a(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    paramQQAppInterface.a().a(paramTransProcessorHandler);
    ThreadManager.post(new aevr(paramQQAppInterface, paramString, (int)(System.currentTimeMillis() / 1000L)), 8, null, true);
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
      while (!QLog.isColorLevel()) {}
      QLog.e("NearbyVideoUtils", 2, "setAuthVideoConfig=" + paramString + ",error:" + localJSONException.toString());
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
    if (!a(paramQQAppInterface)) {}
    do
    {
      return false;
      if (!paramActivity.isFinishing()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("NearbyVideoUtils", 2, "showVoteUpdateDialog invoke, but activity is finishing");
    return false;
    ImageView localImageView = new ImageView(paramActivity);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setImageDrawable(URLDrawable.getDrawable("http://pub.idqqimg.com/pc/misc/files/20170807/f2f569d65bc74317bb9a6bfe482dcd2c.png?_t=1502087876532"));
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, AIOUtils.a(150.0F, paramActivity.getResources()));
    new NearbyCustomDialog(paramActivity).a(localImageView, localLayoutParams).b("真实视频认证享受优先展示，获得更多被关注，收到礼物的机会").a(new BlueButtonInfo("上传自拍视频", new aevq(paramActivity, paramQQAppInterface))).show();
    a(paramQQAppInterface);
    return true;
  }
  
  public static boolean a(AppInterface paramAppInterface)
  {
    boolean bool1 = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.BlessPTVEnable.name()).equals("1");
    boolean bool2 = VideoEnvironment.c(paramAppInterface);
    boolean bool3 = VideoEnvironment.c();
    boolean bool4 = VcSystemInfo.e();
    if (QLog.isColorLevel()) {
      QLog.d("NearbyVideoUtils", 2, " ptvRecord=" + bool2 + " isX86=" + bool3 + " frontCamera=" + true);
    }
    return (bool2) && (!bool3) && (bool4) && (!bool1);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a + paramQQAppInterface.getCurrentAccountUin();
    return PreferenceManager.getDefaultSharedPreferences(BaseApplication.getContext()).getBoolean(paramQQAppInterface, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyVideoUtils
 * JD-Core Version:    0.7.0.1
 */