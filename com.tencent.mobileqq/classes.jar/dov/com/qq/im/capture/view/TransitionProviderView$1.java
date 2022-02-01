package dov.com.qq.im.capture.view;

import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.util.WeakReferenceHandler;
import dov.com.qq.im.capture.music.MusicDownloadListener;

class TransitionProviderView$1
  extends MusicDownloadListener
{
  TransitionProviderView$1(TransitionProviderView paramTransitionProviderView) {}
  
  public void a(int paramInt) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void a(String paramString, boolean paramBoolean) {}
  
  public void a(String paramString, boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataMusicItemInfo.getLocalPath().equals(paramString))) {
      this.a.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessage(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.qq.im.capture.view.TransitionProviderView.1
 * JD-Core Version:    0.7.0.1
 */