package dov.com.qq.im.ae.album.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogic;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogic.IcheckBoxCallback;

public class AEAbstractPhotoListFragment$PhotoItemClickListener
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  
  public AEAbstractPhotoListFragment$PhotoItemClickListener(AEAbstractPhotoListFragment paramAEAbstractPhotoListFragment) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(CheckBox paramCheckBox)
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox = paramCheckBox;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractPhotoListFragment.a.a != null) {
      this.jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractPhotoListFragment.a.a.a(paramView, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidWidgetCheckBox);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment.PhotoItemClickListener
 * JD-Core Version:    0.7.0.1
 */