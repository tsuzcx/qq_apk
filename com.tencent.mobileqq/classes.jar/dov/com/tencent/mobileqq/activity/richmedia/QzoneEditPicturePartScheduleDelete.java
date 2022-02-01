package dov.com.tencent.mobileqq.activity.richmedia;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPart;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoUi;

public class QzoneEditPicturePartScheduleDelete
  extends EditVideoPart
  implements View.OnClickListener
{
  private Button jdField_a_of_type_AndroidWidgetButton;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  
  public QzoneEditPicturePartScheduleDelete(@NonNull QzoneEditPicturePartManager paramQzoneEditPicturePartManager)
  {
    super(paramQzoneEditPicturePartManager);
  }
  
  private void c()
  {
    DialogUtil.a(a().getActivity(), 230).setMessage(2131718002).setPositiveButton(2131717515, new QzoneEditPicturePartScheduleDelete.3(this)).setNegativeButton(2131691144, new QzoneEditPicturePartScheduleDelete.2(this)).show();
  }
  
  public QzoneEditPicturePartManager a()
  {
    return (QzoneEditPicturePartManager)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)a(2131375846));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)a(2131367198));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new QzoneEditPicturePartScheduleDelete.1(this));
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.QzoneEditPicturePartScheduleDelete
 * JD-Core Version:    0.7.0.1
 */