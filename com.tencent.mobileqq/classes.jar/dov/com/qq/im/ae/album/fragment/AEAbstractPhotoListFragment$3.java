package dov.com.qq.im.ae.album.fragment;

import dov.com.qq.im.AEReportUtils;
import dov.com.qq.im.ae.album.AEAlbumLinearLayout.ScrollListener;
import dov.com.qq.im.ae.album.data.AEAlbumLogicData;
import dov.com.qq.im.ae.album.logic.AEPhotoListLogic;

class AEAbstractPhotoListFragment$3
  implements AEAlbumLinearLayout.ScrollListener
{
  AEAbstractPhotoListFragment$3(AEAbstractPhotoListFragment paramAEAbstractPhotoListFragment) {}
  
  public void a(float paramFloat)
  {
    this.a.a.a(paramFloat);
  }
  
  public void a(int paramInt)
  {
    this.a.a.a(paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    this.a.a.a(paramInt, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((!AEAbstractPhotoListFragment.a(this.a)) && (!paramBoolean)) {
      if (this.a.a.a.initialHasPickedNum <= 0) {
        break label46;
      }
    }
    label46:
    for (paramBoolean = true;; paramBoolean = false)
    {
      AEReportUtils.b(paramBoolean);
      AEAbstractPhotoListFragment.a(this.a, true);
      return;
    }
  }
  
  public void b(float paramFloat)
  {
    this.a.a.b(paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment.3
 * JD-Core Version:    0.7.0.1
 */