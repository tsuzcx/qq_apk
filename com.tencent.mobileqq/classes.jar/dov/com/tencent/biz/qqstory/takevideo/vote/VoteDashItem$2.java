package dov.com.tencent.biz.qqstory.takevideo.vote;

import android.view.View;
import bkbk;
import bkpf;

public class VoteDashItem$2
  implements Runnable
{
  public VoteDashItem$2(bkpf parambkpf, bkbk parambkbk, boolean paramBoolean, View paramView, Runnable paramRunnable) {}
  
  public void run()
  {
    bkbk localbkbk;
    if (this.jdField_a_of_type_Bkbk.jdField_a_of_type_Boolean != this.jdField_a_of_type_Boolean)
    {
      localbkbk = this.jdField_a_of_type_Bkbk;
      if (this.jdField_a_of_type_Bkbk.jdField_a_of_type_Boolean) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      localbkbk.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidViewView.invalidate();
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_JavaLangRunnable.run();
      }
      bkpf.a(this.this$0, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.vote.VoteDashItem.2
 * JD-Core Version:    0.7.0.1
 */