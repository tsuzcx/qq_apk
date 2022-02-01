package cooperation.ilive.share;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.IOException;
import java.util.Map;

class IliveShareHelper$5
  implements Runnable
{
  IliveShareHelper$5(IliveShareHelper paramIliveShareHelper, Map paramMap, Runnable paramRunnable) {}
  
  public void run()
  {
    try
    {
      Object localObject = HttpUtil.openUrlForByte(BaseApplicationImpl.getContext(), IliveShareHelper.access$700(this.this$0), "GET", null, null);
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
          this.val$wrapper.put("image", localObject);
        }
      }
    }
    catch (IOException|OutOfMemoryError localIOException)
    {
      label157:
      break label157;
    }
    if (this.this$0.mHostActivity != null) {
      this.this$0.mHostActivity.runOnUiThread(this.val$shareR);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.share.IliveShareHelper.5
 * JD-Core Version:    0.7.0.1
 */