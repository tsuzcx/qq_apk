package dov.com.tencent.biz.qqstory.takevideo.vote;

import android.view.View;
import bkat;
import bkoo;

public class VoteDashItem$2
  implements Runnable
{
  public VoteDashItem$2(bkoo parambkoo, bkat parambkat, boolean paramBoolean, View paramView, Runnable paramRunnable) {}
  
  public void run()
  {
    bkat localbkat;
    if (this.jdField_a_of_type_Bkat.jdField_a_of_type_Boolean != this.jdField_a_of_type_Boolean)
    {
      localbkat = this.jdField_a_of_type_Bkat;
      if (this.jdField_a_of_type_Bkat.jdField_a_of_type_Boolean) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      localbkat.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidViewView.invalidate();
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_JavaLangRunnable.run();
      }
      bkoo.a(this.this$0, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.vote.VoteDashItem.2
 * JD-Core Version:    0.7.0.1
 */