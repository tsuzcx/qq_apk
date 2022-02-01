package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.share.ShareResultCallback;
import com.tencent.mobileqq.kandian.biz.share.WxShareHelperFromReadInjoy;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;

public class VideoShareUtils
{
  private static Bitmap a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return null;
    }
    try
    {
      int j = paramBitmap.getWidth();
      int i = paramBitmap.getHeight();
      int k = j * i;
      localObject = paramBitmap;
      if (k > 8000)
      {
        double d1 = k;
        Double.isNaN(d1);
        d1 = 8000.0D / d1;
        d1 = Math.sqrt(d1);
        double d2 = j;
        Double.isNaN(d2);
        j = (int)(d2 * d1);
        d2 = i;
        Double.isNaN(d2);
        i = (int)(d2 * d1);
        localObject = Bitmap.createScaledBitmap(paramBitmap, j, i, true);
      }
      return localObject;
    }
    catch (Exception paramBitmap)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("scaleBitmapForWeChat ERROR e=");
        ((StringBuilder)localObject).append(paramBitmap.getMessage());
        QLog.d("VideoShareUtils", 2, ((StringBuilder)localObject).toString());
        return null;
      }
    }
    catch (OutOfMemoryError paramBitmap)
    {
      System.gc();
      paramBitmap.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("VideoShareUtils", 2, "scaleBitmapForWeChat ERROR OutOfMemoryError");
      }
    }
    return null;
  }
  
  public static void a(BaseActivity paramBaseActivity, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, boolean paramBoolean1, String paramString4, boolean paramBoolean2, ShareResultCallback paramShareResultCallback)
  {
    String str = "";
    paramBaseActivity = paramString1;
    if (paramString1 == null) {
      paramBaseActivity = "";
    }
    if (paramString2 == null) {
      paramString1 = str;
    } else {
      paramString1 = paramString2;
    }
    int i;
    if (!WXShareHelper.a().b()) {
      i = 2131918154;
    } else if (!WXShareHelper.a().c()) {
      i = 2131918155;
    } else {
      i = -1;
    }
    if (i != -1)
    {
      QRUtils.a(0, i);
    }
    else
    {
      paramString2 = String.valueOf(System.currentTimeMillis());
      paramShareResultCallback = new VideoShareUtils.1(paramString2, paramShareResultCallback);
      WXShareHelper.a().a(paramShareResultCallback);
      if ((paramBoolean1) && (!TextUtils.isEmpty(paramString4)) && (!paramBoolean2)) {
        WxShareHelperFromReadInjoy.getInstance().shareVideoMiniProgram(paramString2, paramBaseActivity, paramBitmap, paramString1, paramString3, paramString4);
      } else if (ReadInJoyHelper.L(RIJQQAppInterfaceUtil.e()) == 1) {
        WXShareHelper.a().b(paramString2, paramBaseActivity, a(paramBitmap), paramString1, paramString3, paramBoolean1 ^ true);
      } else {
        WxShareHelperFromReadInjoy.getInstance().shareVideo(paramString2, paramBaseActivity, a(paramBitmap), paramString1, paramString3, paramBoolean1 ^ true);
      }
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("title=");
      paramString2.append(paramBaseActivity);
      paramString2.append(", description=");
      paramString2.append(paramString1);
      paramString2.append(", shareUrl=");
      paramString2.append(paramString3);
      paramString2.append(", toWeChat=");
      paramString2.append(paramBoolean1);
      QLog.d("VideoShareUtils", 2, paramString2.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoShareUtils
 * JD-Core Version:    0.7.0.1
 */