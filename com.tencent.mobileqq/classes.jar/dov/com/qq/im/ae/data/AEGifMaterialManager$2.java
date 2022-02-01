package dov.com.qq.im.ae.data;

import blut;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import java.util.List;

public class AEGifMaterialManager$2
  implements Runnable
{
  public AEGifMaterialManager$2(blut paramblut) {}
  
  public void run()
  {
    for (;;)
    {
      synchronized (blut.a(this.this$0))
      {
        List localList = blut.a(this.this$0);
        if (!CollectionUtils.isEmpty(localList)) {
          blut.a(this.this$0, localList);
        }
        blut localblut = this.this$0;
        if (!CollectionUtils.isEmpty(localList))
        {
          bool = true;
          blut.a(localblut, bool);
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