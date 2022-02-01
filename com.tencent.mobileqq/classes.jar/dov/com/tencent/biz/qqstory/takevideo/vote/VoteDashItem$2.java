package dov.com.tencent.biz.qqstory.takevideo.vote;

import android.view.View;
import bqkh;
import bqyc;

public class VoteDashItem$2
  implements Runnable
{
  public VoteDashItem$2(bqyc parambqyc, bqkh parambqkh, boolean paramBoolean, View paramView, Runnable paramRunnable) {}
  
  public void run()
  {
    bqkh localbqkh;
    if (this.jdField_a_of_type_Bqkh.jdField_a_of_type_Boolean != this.jdField_a_of_type_Boolean)
    {
      localbqkh = this.jdField_a_of_type_Bqkh;
      if (this.jdField_a_of_type_Bqkh.jdField_a_of_type_Boolean) {
        break label69;
      }
    }
    label69:
    for (boolean bool = true;; bool = false)
    {
      localbqkh.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_AndroidViewView.invalidate();
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_JavaLangRunnable.run();
      }
      bqyc.a(this.this$0, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.vote.VoteDashItem.2
 * JD-Core Version:    0.7.0.1
 */