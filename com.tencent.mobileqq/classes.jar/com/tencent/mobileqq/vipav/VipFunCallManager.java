package com.tencent.mobileqq.vipav;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.AVPathUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vas.vipav.VipFullScreenVideoView;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.pb.funcall.VipFunCallAndRing.TSourceInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class VipFunCallManager
  implements Manager
{
  /* Error */
  public VipFunCallManager(com.tencent.mobileqq.app.QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 15	java/lang/Object:<init>	()V
    //   4: new 17	java/io/File
    //   7: dup
    //   8: invokestatic 23	com/tencent/av/AVPathUtil:k	()Ljava/lang/String;
    //   11: invokespecial 26	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_2
    //   15: aload_2
    //   16: invokevirtual 30	java/io/File:exists	()Z
    //   19: ifne +8 -> 27
    //   22: aload_2
    //   23: invokevirtual 33	java/io/File:mkdirs	()Z
    //   26: pop
    //   27: aload_0
    //   28: invokespecial 36	com/tencent/mobileqq/vipav/VipFunCallManager:a	()Z
    //   31: ifne +108 -> 139
    //   34: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   37: ifeq +11 -> 48
    //   40: ldc 43
    //   42: iconst_2
    //   43: ldc 45
    //   45: invokestatic 49	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aconst_null
    //   49: astore_3
    //   50: aconst_null
    //   51: astore_2
    //   52: aload_1
    //   53: invokevirtual 55	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   56: invokevirtual 61	com/tencent/qphone/base/util/BaseApplication:getAssets	()Landroid/content/res/AssetManager;
    //   59: ldc 63
    //   61: invokevirtual 69	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   64: astore_1
    //   65: aload_1
    //   66: astore_2
    //   67: aload_1
    //   68: astore_3
    //   69: invokestatic 23	com/tencent/av/AVPathUtil:k	()Ljava/lang/String;
    //   72: new 71	java/lang/StringBuffer
    //   75: dup
    //   76: ldc 73
    //   78: invokespecial 74	java/lang/StringBuffer:<init>	(Ljava/lang/String;)V
    //   81: aload_1
    //   82: invokestatic 80	com/tencent/mobileqq/utils/FileUtils:writeFile	(Ljava/lang/String;Ljava/lang/StringBuffer;Ljava/io/InputStream;)Z
    //   85: pop
    //   86: aload_1
    //   87: ifnull +52 -> 139
    //   90: aload_1
    //   91: invokevirtual 85	java/io/InputStream:close	()V
    //   94: return
    //   95: astore_1
    //   96: goto +25 -> 121
    //   99: astore_1
    //   100: aload_3
    //   101: astore_2
    //   102: aload_1
    //   103: invokevirtual 88	java/io/IOException:printStackTrace	()V
    //   106: aload_3
    //   107: ifnull +32 -> 139
    //   110: aload_3
    //   111: invokevirtual 85	java/io/InputStream:close	()V
    //   114: return
    //   115: astore_1
    //   116: aload_1
    //   117: invokevirtual 89	java/lang/Exception:printStackTrace	()V
    //   120: return
    //   121: aload_2
    //   122: ifnull +15 -> 137
    //   125: aload_2
    //   126: invokevirtual 85	java/io/InputStream:close	()V
    //   129: goto +8 -> 137
    //   132: astore_2
    //   133: aload_2
    //   134: invokevirtual 89	java/lang/Exception:printStackTrace	()V
    //   137: aload_1
    //   138: athrow
    //   139: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	this	VipFunCallManager
    //   0	140	1	paramQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    //   14	112	2	localObject	Object
    //   132	2	2	localException	java.lang.Exception
    //   49	62	3	localQQAppInterface	com.tencent.mobileqq.app.QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   52	65	95	finally
    //   69	86	95	finally
    //   102	106	95	finally
    //   52	65	99	java/io/IOException
    //   69	86	99	java/io/IOException
    //   90	94	115	java/lang/Exception
    //   110	114	115	java/lang/Exception
    //   125	129	132	java/lang/Exception
  }
  
  public static VipFullScreenVideoView a(Activity paramActivity, RelativeLayout paramRelativeLayout, boolean paramBoolean)
  {
    if (paramActivity != null)
    {
      if (paramRelativeLayout == null) {
        return null;
      }
      View localView = LayoutInflater.from(VasUtil.a().getApplicationContext()).inflate(2131563034, null);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(13);
      if (paramActivity.isFinishing()) {
        return null;
      }
      paramRelativeLayout.addView(localView, 0, localLayoutParams);
      if (QLog.isDevelopLevel()) {
        QLog.i("VipFunCall", 4, "addVideoView");
      }
      return (VipFullScreenVideoView)localView.findViewById(2131380499);
    }
    return null;
  }
  
  public static void a(AppRuntime paramAppRuntime, int paramInt, Bundle paramBundle, VipFunCallAndRing.TSourceInfo paramTSourceInfo, boolean paramBoolean)
  {
    int k = -1;
    int i;
    String str1;
    int j;
    String str2;
    String str3;
    String str4;
    if (paramBundle != null)
    {
      i = paramBundle.getInt("callId");
      str1 = paramBundle.getString("name");
      j = paramBundle.getInt("ringId");
      k = paramBundle.getInt("feeType");
      str2 = paramBundle.getString("url_Video");
      str3 = paramBundle.getString("url_Fuzz");
      str4 = paramBundle.getString("url_Picture");
      localObject = paramBundle.getString("url_Ring");
      paramTSourceInfo = paramBundle.getString("url_call_thum");
      paramBundle = (Bundle)localObject;
    }
    else if (paramTSourceInfo != null)
    {
      str2 = paramTSourceInfo.str_media_url.get();
      str3 = paramTSourceInfo.str_image_url.get();
      str4 = paramTSourceInfo.str_image_url.get();
      paramBundle = paramTSourceInfo.str_ring_url.get();
      str1 = paramTSourceInfo.str_fc_name.get();
      paramTSourceInfo = paramTSourceInfo.str_thumb_url.get();
      j = 0;
      i = paramInt;
    }
    else
    {
      i = paramInt;
      paramTSourceInfo = null;
      paramBundle = null;
      j = 0;
      str1 = null;
      str2 = null;
      str3 = null;
      str4 = null;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("downloadFCSuit callid=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", ringid=");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(", feeType");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(", mediaUrl=");
      ((StringBuilder)localObject).append(str2);
      ((StringBuilder)localObject).append(", fuzzImageUrl");
      ((StringBuilder)localObject).append(str3);
      ((StringBuilder)localObject).append(", imageUrl=");
      ((StringBuilder)localObject).append(str4);
      ((StringBuilder)localObject).append(", ringUrl");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.d("VipFunCallManager", 2, ((StringBuilder)localObject).toString());
    }
    if (i == 0) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AVPathUtil.k());
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(File.separator);
    localObject = new File(((StringBuilder)localObject).toString());
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    localObject = VipFunCallUtil.a(paramAppRuntime, 0, String.valueOf(paramInt));
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("callId", i);
      ((SharedPreferences.Editor)localObject).putInt("ringId", j);
      if (k != 0) {
        ((SharedPreferences.Editor)localObject).putInt("feeType", k);
      }
      if (!TextUtils.isEmpty(str1)) {
        ((SharedPreferences.Editor)localObject).putString("name", str1);
      }
      ((SharedPreferences.Editor)localObject).putString("_6", str2);
      ((SharedPreferences.Editor)localObject).putString("_9", str3);
      ((SharedPreferences.Editor)localObject).putString("_7", str4);
      ((SharedPreferences.Editor)localObject).putString("_3", paramBundle);
      ((SharedPreferences.Editor)localObject).putString("_8", paramTSourceInfo);
      ((SharedPreferences.Editor)localObject).commit();
    }
    paramAppRuntime = VipFunCallUtil.a(paramAppRuntime, 0, null);
    if (paramAppRuntime != null)
    {
      paramAppRuntime = paramAppRuntime.edit();
      paramTSourceInfo = new StringBuilder();
      paramTSourceInfo.append("_3_");
      paramTSourceInfo.append(j);
      paramAppRuntime.putString(paramTSourceInfo.toString(), paramBundle);
      paramAppRuntime.commit();
    }
  }
  
  private boolean a()
  {
    return new File(VipFunCallConstants.a).exists();
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipFunCallManager
 * JD-Core Version:    0.7.0.1
 */