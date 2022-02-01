package dov.com.qq.im.ae.album.logic;

import dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment;
import dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment.PhotoGridAdapter;
import mqq.util.WeakReference;

class AEPhotoListLogicBase$9
  implements Runnable
{
  AEPhotoListLogicBase$9(AEPhotoListLogicBase paramAEPhotoListLogicBase) {}
  
  public void run()
  {
    ((AEAbstractPhotoListFragment)this.this$0.a.get()).a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.9
 * JD-Core Version:    0.7.0.1
 */