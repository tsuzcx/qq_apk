package dov.com.tencent.biz.qqstory.takevideo.vote;

import android.view.View;
import bijy;
import biyc;

public class VoteDashItem$2
  implements Runnable
{
  public VoteDashItem$2(biyc parambiyc, bijy parambijy, boolean paramBoolean, View paramView, Runnable paramRunnable) {}
  
  public void run()
  {
    bijy localbijy;
    if (this.jdField_a_of_type_Bijy.jdField_a_of_type_Boolean != this.jdField_a_of_type_Boolean)
    {
      localbijy = this.jdField_a_of_type_Bijy;
      if (this.jdField_a_of_type_Bijy.jdField_a_of_type_Boolean) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      localbijy.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidViewView.invalidate();
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_JavaLangRunnable.run();
      }
      biyc.a(this.this$0, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.vote.VoteDashItem.2
 * JD-Core Version:    0.7.0.1
 */