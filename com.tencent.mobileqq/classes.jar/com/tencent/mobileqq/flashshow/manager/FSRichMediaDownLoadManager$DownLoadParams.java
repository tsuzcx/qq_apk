package com.tencent.mobileqq.flashshow.manager;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.open.base.MD5Utils;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;

public class FSRichMediaDownLoadManager$DownLoadParams
{
  private static final String a = AppConstants.SDCARD_IMG_SAVE;
  private static String b = a;
  private String c;
  private int d;
  private String e;
  private String f;
  private FSRichMediaDownLoadManager.IRichMediaListener g;
  private String h;
  
  public FSRichMediaDownLoadManager$DownLoadParams()
  {
    if (d())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppConstants.SDCARD_ROOT);
      localStringBuilder.append("/DCIM/Video/");
      b = localStringBuilder.toString();
    }
  }
  
  private boolean d()
  {
    return String.valueOf(Build.BRAND).toLowerCase().contains("meizu");
  }
  
  public DownLoadParams a(FSRichMediaDownLoadManager.IRichMediaListener paramIRichMediaListener)
  {
    this.g = paramIRichMediaListener;
    return this;
  }
  
  public DownLoadParams a(String paramString1, int paramInt, String paramString2)
  {
    this.h = paramString2;
    this.c = paramString1;
    this.d = paramInt;
    if (paramInt == 1)
    {
      str = MD5Utils.encodeHexStr(QCircleFeedPicLoader.getUniKeyFromUrl(paramString1));
      paramString2 = str;
      if (TextUtils.isEmpty(str)) {
        paramString2 = MD5Utils.encodeFileHexStr(paramString1);
      }
    }
    else
    {
      paramString2 = this.h;
    }
    if (paramString2 != null) {
      paramString1 = paramString2;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(FSRichMediaDownLoadManager.c());
    localStringBuilder.append(paramString1);
    String str = ".mp4";
    if (paramInt == 0) {
      paramString2 = ".mp4";
    } else {
      paramString2 = ".jpeg";
    }
    localStringBuilder.append(paramString2);
    this.f = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    if (paramInt == 0) {
      paramString2 = b;
    } else {
      paramString2 = a;
    }
    localStringBuilder.append(paramString2);
    localStringBuilder.append(paramString1);
    if (paramInt == 0) {
      paramString1 = str;
    } else {
      paramString1 = ".jpeg";
    }
    localStringBuilder.append(paramString1);
    this.e = localStringBuilder.toString();
    return this;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public String b()
  {
    return this.e;
  }
  
  public String c()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.manager.FSRichMediaDownLoadManager.DownLoadParams
 * JD-Core Version:    0.7.0.1
 */