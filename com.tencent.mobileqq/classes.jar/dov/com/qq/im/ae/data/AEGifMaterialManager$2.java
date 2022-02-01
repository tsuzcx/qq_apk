package dov.com.qq.im.ae.data;

import bnjw;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.List;

public class AEGifMaterialManager$2
  implements Runnable
{
  public AEGifMaterialManager$2(bnjw parambnjw) {}
  
  public void run()
  {
    for (;;)
    {
      synchronized (bnjw.a(this.this$0))
      {
        List localList = bnjw.a(this.this$0);
        if (!CollectionUtils.isEmpty(localList)) {
          bnjw.a(this.this$0, localList);
        }
        bnjw localbnjw = this.this$0;
        if (!CollectionUtils.isEmpty(localList))
        {
          bool = true;
          bnjw.a(localbnjw, bool);
          return;
        }
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.data.AEGifMaterialManager.2
 * JD-Core Version:    0.7.0.1
 */