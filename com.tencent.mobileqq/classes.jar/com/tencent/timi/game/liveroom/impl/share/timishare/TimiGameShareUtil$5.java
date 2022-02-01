package com.tencent.timi.game.liveroom.impl.share.timishare;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.timi.game.env.Env;
import java.io.IOException;

final class TimiGameShareUtil$5
  implements Runnable
{
  TimiGameShareUtil$5(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = HttpUtil.openUrlForByte(Env.a(), MsfSdkUtils.insertMtype("GameCenter", this.a), "GET", null, null);
        if (localObject1 != null)
        {
          Object localObject2 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
          if (localObject2 != null)
          {
            int j = ((Bitmap)localObject2).getWidth();
            i = ((Bitmap)localObject2).getHeight();
            double d1 = j * i;
            if (d1 > 8000.0D)
            {
              Double.isNaN(d1);
              d1 = 8000.0D / d1;
              d1 = Math.sqrt(d1);
              double d2 = j;
              Double.isNaN(d2);
              j = (int)(d2 * d1);
              d2 = i;
              Double.isNaN(d2);
              i = (int)(d2 * d1);
              localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject2, j, i, true);
              ((Bitmap)localObject2).recycle();
              localObject2 = WXShareHelper.a();
              String str1 = this.b;
              String str2 = this.c;
              String str3 = this.d;
              String str4 = this.e;
              if (this.f != 0) {
                break label202;
              }
              i = 0;
              ((WXShareHelper)localObject2).a(str1, str2, (Bitmap)localObject1, str3, str4, i);
              ((Bitmap)localObject1).recycle();
            }
          }
        }
        return;
      }
      catch (IOException|OutOfMemoryError localIOException)
      {
        return;
      }
      label202:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.share.timishare.TimiGameShareUtil.5
 * JD-Core Version:    0.7.0.1
 */