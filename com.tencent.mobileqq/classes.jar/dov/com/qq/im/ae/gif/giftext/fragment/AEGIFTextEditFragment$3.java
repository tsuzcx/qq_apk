package dov.com.qq.im.ae.gif.giftext.fragment;

import android.app.Dialog;
import android.app.FragmentManager;
import dov.com.qq.im.ae.gif.giftext.viewmodel.AEGIFTextEditViewModel;
import dov.com.qq.im.ae.gif.video.PngsTextDrawer.Callback;

class AEGIFTextEditFragment$3
  implements PngsTextDrawer.Callback
{
  AEGIFTextEditFragment$3(AEGIFTextEditFragment paramAEGIFTextEditFragment, String paramString) {}
  
  public void a()
  {
    AEGIFTextEditFragment.a(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFTextEditFragment).dismiss();
    this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFTextEditFragment.getFragmentManager().popBackStack();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFTextEditFragment.a.a(this.jdField_a_of_type_JavaLangString, paramString);
    AEGIFTextEditFragment.a(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFTextEditFragment).dismiss();
    this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFTextEditFragment.getFragmentManager().popBackStack();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFTextEditFragment.3
 * JD-Core Version:    0.7.0.1
 */