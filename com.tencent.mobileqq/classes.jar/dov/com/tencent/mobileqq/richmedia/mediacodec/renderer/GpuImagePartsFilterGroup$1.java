package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

import bjgy;
import bjha;
import bjhj;

public class GpuImagePartsFilterGroup$1
  implements Runnable
{
  public GpuImagePartsFilterGroup$1(bjhj parambjhj, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    bjha localbjha1 = null;
    bjha localbjha2 = bjhj.a(this.this$0);
    bjhj.a(this.this$0, null);
    if ((bjhj.b(this.this$0) == null) || (bjhj.b(this.this$0).getFilterType() != this.a))
    {
      localbjha1 = bjhj.b(this.this$0);
      bjhj.b(this.this$0, (bjha)bjgy.a(this.a));
      bjhj.b(this.this$0).init();
      bjhj.b(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    bjhj.b(this.this$0).a(false, 0.0F);
    bjhj.a(this.this$0, 0.0F);
    if (localbjha2 != null) {
      localbjha2.destroy();
    }
    if (localbjha1 != null) {
      localbjha1.destroy();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.1
 * JD-Core Version:    0.7.0.1
 */