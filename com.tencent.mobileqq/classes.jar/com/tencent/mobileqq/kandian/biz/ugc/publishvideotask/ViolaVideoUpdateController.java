package com.tencent.mobileqq.kandian.biz.ugc.publishvideotask;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import org.jetbrains.annotations.NotNull;

public class ViolaVideoUpdateController
{
  private long jdField_a_of_type_Long = 500L;
  @NotNull
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean = false;
  private Runnable b = new ViolaVideoUpdateController.1(this);
  
  public ViolaVideoUpdateController(@NotNull Runnable paramRunnable, long paramLong)
  {
    this.jdField_a_of_type_JavaLangRunnable = paramRunnable;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    ThreadManagerV2.getUIHandlerV2().post(this.b);
  }
  
  public void b()
  {
    ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.b);
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.ViolaVideoUpdateController
 * JD-Core Version:    0.7.0.1
 */