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
    for (;;)
    {
      try
      {
        Object localObject1 = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), MsfSdkUtils.insertMtype("GameCenter", this.a), "GET", null, null);
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
              localObject2 = this.this$0;
              String str1 = this.b;
              String str2 = this.c;
              String str3 = this.d;
              if (!"0".equals(this.e)) {
                break label205;
              }
              i = 0;
              LiteAppJs.access$000((LiteAppJs)localObject2, str1, str2, (Bitmap)localObject1, str3, i);
              ((Bitmap)localObject1).recycle();
              return;
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return;
      label205:
      int i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.LiteAppJs.1
 * JD-Core Version:    0.7.0.1
 */