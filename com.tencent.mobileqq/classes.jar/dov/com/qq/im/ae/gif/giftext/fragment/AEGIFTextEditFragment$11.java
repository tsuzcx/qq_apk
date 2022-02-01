package dov.com.qq.im.ae.gif.giftext.fragment;

import com.tencent.common.app.AppInterface;
import dov.com.qq.im.ae.config.CameraPeakServiceObserver;

class AEGIFTextEditFragment$11
  extends CameraPeakServiceObserver
{
  AEGIFTextEditFragment$11(AEGIFTextEditFragment paramAEGIFTextEditFragment, AppInterface paramAppInterface) {}
  
  public void onUpdateTextValid(boolean paramBoolean1, boolean paramBoolean2)
  {
    AEGIFTextEditFragment.a(this.jdField_a_of_type_DovComQqImAeGifGiftextFragmentAEGIFTextEditFragment).a(paramBoolean1, paramBoolean2);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.gif.giftext.fragment.AEGIFTextEditFragment.11
 * JD-Core Version:    0.7.0.1
 */