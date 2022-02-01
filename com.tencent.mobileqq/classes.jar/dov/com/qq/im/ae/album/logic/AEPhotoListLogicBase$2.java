package dov.com.qq.im.ae.album.logic;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.widget.NumberCheckBox;
import dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment;
import dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment.PhotoGridAdapter;
import dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment.PhotoVH;
import java.util.ArrayList;
import mqq.util.WeakReference;

class AEPhotoListLogicBase$2
  implements View.OnTouchListener
{
  AEPhotoListLogicBase$2(AEPhotoListLogicBase paramAEPhotoListLogicBase, AEAbstractPhotoListFragment.PhotoVH paramPhotoVH, int paramInt) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractPhotoListFragment$PhotoVH.a.isChecked())
    {
      paramView = (LocalMediaInfo)AEPhotoListLogicBase.a(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase).get(this.jdField_a_of_type_Int);
      AEPhotoListLogicBase.a(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase, this.jdField_a_of_type_Int, paramView, this.jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractPhotoListFragment$PhotoVH);
      AEPhotoListLogicBase.a(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase, this.jdField_a_of_type_DovComQqImAeAlbumFragmentAEAbstractPhotoListFragment$PhotoVH);
      AEPhotoListLogicBase.a(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase);
      if (AEPhotoListLogicBase.b(this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase).isEmpty()) {
        ((AEAbstractPhotoListFragment)this.jdField_a_of_type_DovComQqImAeAlbumLogicAEPhotoListLogicBase.a.get()).a.notifyDataSetChanged();
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.2
 * JD-Core Version:    0.7.0.1
 */