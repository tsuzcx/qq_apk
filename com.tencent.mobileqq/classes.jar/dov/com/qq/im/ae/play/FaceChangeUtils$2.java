package dov.com.qq.im.ae.play;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.List;

final class FaceChangeUtils$2
  implements Runnable
{
  FaceChangeUtils$2(List paramList, Bitmap paramBitmap, FaceChangeUtils.ChangeFaceBatchCallback paramChangeFaceBatchCallback) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.val$materialDir.size())
    {
      localArrayList.add(FaceChangeUtils.access$100(this.val$userFace, (String)this.val$materialDir.get(i)));
      i += 1;
    }
    this.val$callback.onResult(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.play.FaceChangeUtils.2
 * JD-Core Version:    0.7.0.1
 */