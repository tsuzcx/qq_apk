package dov.com.tencent.biz.qqstory.takevideo.vote;

import android.view.View;
import bpim;
import bpwh;

public class VoteDashItem$2
  implements Runnable
{
  public VoteDashItem$2(bpwh parambpwh, bpim parambpim, boolean paramBoolean, View paramView, Runnable paramRunnable) {}
  
  public void run()
  {
    bpim localbpim;
    if (this.jdField_a_of_type_Bpim.jdField_a_of_type_Boolean != this.jdField_a_of_type_Boolean)
    {
      localbpim = this.jdField_a_of_type_Bpim;
      if (this.jdField_a_of_type_Bpim.jdField_a_of_type_Boolean) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      localbpim.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidViewView.invalidate();
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_JavaLangRunnable.run();
      }
      bpwh.a(this.this$0, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.vote.VoteDashItem.2
 * JD-Core Version:    0.7.0.1
 */