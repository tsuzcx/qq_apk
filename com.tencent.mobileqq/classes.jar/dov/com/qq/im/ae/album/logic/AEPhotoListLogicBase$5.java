package dov.com.qq.im.ae.album.logic;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment.PhotoVH;

class AEPhotoListLogicBase$5
  implements View.OnClickListener
{
  AEPhotoListLogicBase$5(AEPhotoListLogicBase paramAEPhotoListLogicBase, AEAbstractPhotoListFragment.PhotoVH paramPhotoVH, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase.a(this.jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractPhotoListFragment$PhotoVH.itemView, this.jdField_a_of_type_Int);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.5
 * JD-Core Version:    0.7.0.1
 */