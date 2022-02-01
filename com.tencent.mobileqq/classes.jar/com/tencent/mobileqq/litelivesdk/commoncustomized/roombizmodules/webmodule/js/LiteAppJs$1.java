package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;

class LiteAppJs$1
  implements Runnable
{
  LiteAppJs$1(LiteAppJs paramLiteAppJs, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    int i = 0;
    try
    {
      Object localObject1 = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), MsfSdkUtils.insertMtype("GameCenter", this.a), "GET", null, null);
      Object localObject2;
      String str1;
      String str2;
      String str3;
      if (localObject1 != null)
      {
        localObject2 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
        if (localObject2 != null)
        {
          int j = ((Bitmap)localObject2).getWidth();
          int k = ((Bitmap)localObject2).getHeight();
          if (j * k > 8000.0D)
          {
            double d1 = Math.sqrt(8000.0D / (j * k));
            localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject2, (int)(j * d1), (int)(k * d1), true);
            ((Bitmap)localObject2).recycle();
            localObject2 = this.this$0;
            str1 = this.b;
            str2 = this.c;
            str3 = this.d;
            if (!"0".equals(this.e)) {
              break label166;
            }
          }
        }
      }
      for (;;)
      {
        LiteAppJs.access$000((LiteAppJs)localObject2, str1, str2, (Bitmap)localObject1, str3, i);
        ((Bitmap)localObject1).recycle();
        return;
        label166:
        i = 1;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.LiteAppJs.1
 * JD-Core Version:    0.7.0.1
 */