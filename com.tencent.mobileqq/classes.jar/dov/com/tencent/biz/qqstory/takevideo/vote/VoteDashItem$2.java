package dov.com.tencent.biz.qqstory.takevideo.vote;

import android.view.View;
import bmrg;
import bnfb;

public class VoteDashItem$2
  implements Runnable
{
  public VoteDashItem$2(bnfb parambnfb, bmrg parambmrg, boolean paramBoolean, View paramView, Runnable paramRunnable) {}
  
  public void run()
  {
    bmrg localbmrg;
    if (this.jdField_a_of_type_Bmrg.jdField_a_of_type_Boolean != this.jdField_a_of_type_Boolean)
    {
      localbmrg = this.jdField_a_of_type_Bmrg;
      if (this.jdField_a_of_type_Bmrg.jdField_a_of_type_Boolean) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      localbmrg.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidViewView.invalidate();
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_JavaLangRunnable.run();
      }
      bnfb.a(this.this$0, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.vote.VoteDashItem.2
 * JD-Core Version:    0.7.0.1
 */