package dov.com.tencent.biz.qqstory.takevideo.vote;

import android.view.View;
import bmmu;
import bnap;

public class VoteDashItem$2
  implements Runnable
{
  public VoteDashItem$2(bnap parambnap, bmmu parambmmu, boolean paramBoolean, View paramView, Runnable paramRunnable) {}
  
  public void run()
  {
    bmmu localbmmu;
    if (this.jdField_a_of_type_Bmmu.jdField_a_of_type_Boolean != this.jdField_a_of_type_Boolean)
    {
      localbmmu = this.jdField_a_of_type_Bmmu;
      if (this.jdField_a_of_type_Bmmu.jdField_a_of_type_Boolean) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      localbmmu.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidViewView.invalidate();
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_JavaLangRunnable.run();
      }
      bnap.a(this.this$0, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.vote.VoteDashItem.2
 * JD-Core Version:    0.7.0.1
 */