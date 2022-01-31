package dov.com.qq.im.AECamera.View;

import awim;
import awir;
import bgxk;
import bgys;
import bgyv;
import bhcs;

public class AECameraManager$5
  implements Runnable
{
  public AECameraManager$5(bgys parambgys) {}
  
  public void run()
  {
    if ((bgys.c(this.this$0)) && (bgys.a(this.this$0)))
    {
      if ((!bgys.d(this.this$0)) || (bgys.b(this.this$0) != this.this$0.jdField_a_of_type_Int) || (bgys.c(this.this$0) != this.this$0.b))
      {
        bgys.a(this.this$0).i(this.this$0.jdField_a_of_type_Int);
        bgys.a(this.this$0).j(this.this$0.b);
        if (!this.this$0.jdField_a_of_type_Boolean) {
          break label250;
        }
        bgys.a().a(new awim(this.this$0.b, this.this$0.jdField_a_of_type_Int), new awim(this.this$0.jdField_a_of_type_Int, this.this$0.b), 0, 30, true);
      }
      for (;;)
      {
        bgys.a().a(bgys.a(this.this$0), null, this.this$0, true);
        bgys.a(this.this$0, true);
        bgys.a(this.this$0, this.this$0.jdField_a_of_type_Int);
        bgys.b(this.this$0, this.this$0.b);
        if (bgys.a(this.this$0) != null) {
          bgys.a(this.this$0).h();
        }
        bhcs.a(bgys.b(), 1, "### startCameraPreview");
        return;
        label250:
        bgys.a().a(new awim(bgys.a(this.this$0).b(), bgys.a(this.this$0).c()), new awim(bgys.a(this.this$0).d(), bgys.a(this.this$0).e()), 0, 30, false);
      }
    }
    bhcs.a(bgys.b(), 1, "### startCameraPreview failed: surfaceReady = " + bgys.c(this.this$0) + ", cameraCreated = " + bgys.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECamera.View.AECameraManager.5
 * JD-Core Version:    0.7.0.1
 */