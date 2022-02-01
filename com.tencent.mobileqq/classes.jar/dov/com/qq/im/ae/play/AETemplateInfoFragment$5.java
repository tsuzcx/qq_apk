package dov.com.qq.im.ae.play;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class AETemplateInfoFragment$5
  implements FaceChangeUtils.ChangeFaceBatchCallback
{
  AETemplateInfoFragment$5(AETemplateInfoFragment paramAETemplateInfoFragment, String paramString, Bitmap paramBitmap, long paramLong) {}
  
  public void onResult(List<FaceChangeUtils.ChangeFaceResult> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      AETemplateInfoFragment.access$302(this.this$0, new ArrayList());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FaceChangeUtils.ChangeFaceResult localChangeFaceResult = (FaceChangeUtils.ChangeFaceResult)paramList.next();
        if (localChangeFaceResult.isSuccess)
        {
          String str = AETemplateInfoFragment.CACHE_DIR + System.currentTimeMillis();
          BitmapUtils.saveBitmap(localChangeFaceResult.data, str);
          AETemplateInfoFragment.access$300(this.this$0).add(str);
          BitmapUtils.recycle(localChangeFaceResult.data);
        }
        else
        {
          AETemplateInfoFragment.access$300(this.this$0).add(this.val$photo);
        }
      }
      BitmapUtils.recycle(this.val$bitmap);
      AETemplateInfoFragment.access$400(this.this$0, true);
    }
    for (;;)
    {
      AETemplateInfoFragment.access$500(this.this$0, false);
      return;
      BitmapUtils.recycle(this.val$bitmap);
      QLog.e("AETemplateInfoFragment", 1, "changeFace---failed to get face changed bitmaps");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.play.AETemplateInfoFragment.5
 * JD-Core Version:    0.7.0.1
 */