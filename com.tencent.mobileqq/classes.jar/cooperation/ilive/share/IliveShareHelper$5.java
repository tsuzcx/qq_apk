package cooperation.ilive.share;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.IOException;
import java.util.Map;
import nnr;

class IliveShareHelper$5
  implements Runnable
{
  IliveShareHelper$5(IliveShareHelper paramIliveShareHelper, Map paramMap, Runnable paramRunnable) {}
  
  public void run()
  {
    label153:
    try
    {
      localObject = nnr.a(BaseApplicationImpl.getContext(), IliveShareHelper.access$700(this.this$0), "GET", null, null);
      if (localObject == null) {
        break label118;
      }
      localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
      if (localObject == null) {
        break label118;
      }
      int i = ((Bitmap)localObject).getWidth();
      int j = ((Bitmap)localObject).getHeight();
      if (i * j <= 8000) {
        break label153;
      }
      double d = Math.sqrt(8000.0D / (i * j));
      Bitmap localBitmap = Bitmap.createScaledBitmap((Bitmap)localObject, (int)(i * d), (int)(j * d), true);
      ((Bitmap)localObject).recycle();
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      Object localObject;
      break label118;
    }
    catch (IOException localIOException)
    {
      label118:
      for (;;) {}
    }
    this.val$wrapper.put("image", localObject);
    if (this.this$0.mHostActivity != null) {
      this.this$0.mHostActivity.runOnUiThread(this.val$shareR);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.ilive.share.IliveShareHelper.5
 * JD-Core Version:    0.7.0.1
 */