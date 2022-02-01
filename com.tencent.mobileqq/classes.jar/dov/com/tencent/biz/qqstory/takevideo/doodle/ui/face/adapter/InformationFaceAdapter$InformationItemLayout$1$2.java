package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.widget.ImageView;
import android.widget.ProgressBar;
import bqpt;
import dov.com.qq.im.capture.view.QIMCommonLoadingView;
import java.lang.ref.WeakReference;

public class InformationFaceAdapter$InformationItemLayout$1$2
  implements Runnable
{
  public InformationFaceAdapter$InformationItemLayout$1$2(bqpt parambqpt, int paramInt) {}
  
  public void run()
  {
    if (((QIMCommonLoadingView)this.jdField_a_of_type_Bqpt.a.get()).getVisibility() == 8)
    {
      ((ProgressBar)this.jdField_a_of_type_Bqpt.c.get()).setVisibility(8);
      ((QIMCommonLoadingView)this.jdField_a_of_type_Bqpt.a.get()).setProgress(0L);
      ((QIMCommonLoadingView)this.jdField_a_of_type_Bqpt.a.get()).setVisibility(0);
      ((ImageView)this.jdField_a_of_type_Bqpt.b.get()).setVisibility(8);
    }
    ((QIMCommonLoadingView)this.jdField_a_of_type_Bqpt.a.get()).setProgress(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.InformationItemLayout.1.2
 * JD-Core Version:    0.7.0.1
 */