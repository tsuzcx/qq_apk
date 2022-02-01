package dov.com.qq.im.ae.album.logic;

import dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment;
import mqq.util.WeakReference;

class AEPhotoListLogicBase$13
  implements Runnable
{
  AEPhotoListLogicBase$13(AEPhotoListLogicBase paramAEPhotoListLogicBase) {}
  
  public void run()
  {
    if (((AEAbstractPhotoListFragment)this.this$0.a.get()).a == null) {
      ((AEAbstractPhotoListFragment)this.this$0.a.get()).a(true, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.13
 * JD-Core Version:    0.7.0.1
 */