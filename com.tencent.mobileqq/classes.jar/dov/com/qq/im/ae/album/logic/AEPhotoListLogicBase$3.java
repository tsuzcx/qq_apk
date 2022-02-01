package dov.com.qq.im.ae.album.logic;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment.PhotoVH;

class AEPhotoListLogicBase$3
  implements View.OnClickListener
{
  AEPhotoListLogicBase$3(AEPhotoListLogicBase paramAEPhotoListLogicBase, int paramInt, AEAbstractPhotoListFragment.PhotoVH paramPhotoVH) {}
  
  public void onClick(View paramView)
  {
    if (!this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase.b()) {
      AEPhotoListLogicBase.a(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase, this.jdField_a_of_type_Int, this.jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractPhotoListFragment$PhotoVH);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.3
 * JD-Core Version:    0.7.0.1
 */