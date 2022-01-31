package dov.com.tencent.mobileqq.richmedia.mediacodec.renderer;

import bjgy;
import bjha;
import bjhj;

public class GpuImagePartsFilterGroup$2
  implements Runnable
{
  public GpuImagePartsFilterGroup$2(bjhj parambjhj, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, float paramFloat) {}
  
  public void run()
  {
    bjha localbjha2 = null;
    bjha localbjha1;
    if ((bjhj.a(this.this$0) == null) || (bjhj.a(this.this$0).getFilterType() != this.jdField_a_of_type_Int))
    {
      localbjha1 = bjhj.a(this.this$0);
      bjhj.a(this.this$0, (bjha)bjgy.a(this.jdField_a_of_type_Int));
      bjhj.a(this.this$0).init();
      bjhj.a(this.this$0).onOutputSizeChanged(this.b, this.c);
    }
    for (;;)
    {
      if ((bjhj.b(this.this$0) == null) || (bjhj.b(this.this$0).getFilterType() != this.d))
      {
        localbjha2 = bjhj.b(this.this$0);
        bjhj.b(this.this$0, (bjha)bjgy.a(this.d));
        bjhj.b(this.this$0).init();
        bjhj.b(this.this$0).onOutputSizeChanged(this.b, this.c);
      }
      if ((this.e == 90) || (this.e == 270))
      {
        bjhj.a(this.this$0).a(false);
        bjhj.b(this.this$0).a(false);
      }
      for (;;)
      {
        bjhj.a(this.this$0, this.jdField_a_of_type_Float);
        bjhj.a(this.this$0).a(true, this.jdField_a_of_type_Float + 0.1F);
        bjhj.b(this.this$0).a(false, this.jdField_a_of_type_Float - 0.1F);
        if (localbjha1 != null) {
          localbjha1.destroy();
        }
        if (localbjha2 != null) {
          localbjha2.destroy();
        }
        return;
        bjhj.a(this.this$0).a(true);
        bjhj.b(this.this$0).a(true);
      }
      localbjha1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.mediacodec.renderer.GpuImagePartsFilterGroup.2
 * JD-Core Version:    0.7.0.1
 */