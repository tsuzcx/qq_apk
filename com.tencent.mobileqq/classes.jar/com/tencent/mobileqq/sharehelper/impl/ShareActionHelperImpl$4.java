package com.tencent.mobileqq.sharehelper.impl;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class ShareActionHelperImpl$4
  implements Runnable
{
  ShareActionHelperImpl$4(ShareActionHelperImpl paramShareActionHelperImpl, Activity paramActivity, String paramString, Map paramMap, Runnable paramRunnable) {}
  
  private void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      int j = paramBitmap.getWidth();
      int i = paramBitmap.getHeight();
      int k = j * i;
      Bitmap localBitmap = paramBitmap;
      if (k > 8000)
      {
        double d1 = k;
        Double.isNaN(d1);
        d1 = Math.sqrt(8000.0D / d1);
        double d2 = j;
        Double.isNaN(d2);
        j = (int)(d2 * d1);
        d2 = i;
        Double.isNaN(d2);
        localBitmap = Bitmap.createScaledBitmap(paramBitmap, j, (int)(d2 * d1), true);
        paramBitmap.recycle();
      }
      this.c.put("image", localBitmap);
      paramBitmap = this.a;
      if (paramBitmap != null) {
        paramBitmap.runOnUiThread(this.d);
      }
    }
  }
  
  public void run()
  {
    try
    {
      QLog.d("ShareActionHelperImpl", 1, "shareLinkToWeChat share url icon");
      byte[] arrayOfByte = HttpUtil.openUrlForByte(this.a, this.b, "GET", null, null);
      if (arrayOfByte == null) {
        return;
      }
      a(BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}catch (Exception localException)
    {
      break label83;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shareLinkToWeChat  OutOfMemoryError : ");
    localStringBuilder.append(localException.getMessage());
    QLog.e("ShareActionHelperImpl", 1, localStringBuilder.toString());
    return;
    label83:
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("shareLinkToWeChat  Exception : ");
    localStringBuilder.append(localException.getMessage());
    QLog.e("ShareActionHelperImpl", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.sharehelper.impl.ShareActionHelperImpl.4
 * JD-Core Version:    0.7.0.1
 */