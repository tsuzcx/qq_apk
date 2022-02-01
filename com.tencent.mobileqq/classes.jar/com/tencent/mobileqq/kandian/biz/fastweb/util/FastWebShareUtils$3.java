package com.tencent.mobileqq.kandian.biz.fastweb.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import java.io.IOException;
import java.util.Map;

class FastWebShareUtils$3
  implements Runnable
{
  FastWebShareUtils$3(FastWebShareUtils paramFastWebShareUtils, String paramString, boolean paramBoolean, Map paramMap, AppInterface paramAppInterface, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      Object localObject = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), MsfSdkUtils.insertMtype("GameCenter", this.a), "GET", null, null);
      if (localObject != null)
      {
        Bitmap localBitmap = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
        if (localBitmap != null)
        {
          int j = localBitmap.getWidth();
          int i = localBitmap.getHeight();
          int k = j * i;
          localObject = localBitmap;
          if (k > 8000)
          {
            boolean bool = this.b;
            localObject = localBitmap;
            if (!bool)
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
              localObject = Bitmap.createScaledBitmap(localBitmap, j, i, true);
              localBitmap.recycle();
            }
          }
          this.c.put("image", localObject);
        }
      }
    }
    catch (IOException|OutOfMemoryError localIOException)
    {
      label171:
      break label171;
    }
    this.d.runOnUiThread(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.fastweb.util.FastWebShareUtils.3
 * JD-Core Version:    0.7.0.1
 */