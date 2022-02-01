package dov.com.qq.im.ae.album.logic;

import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment;
import dov.com.qq.im.ae.album.fragment.AEAbstractPhotoListFragment.PhotoGridAdapter;
import mqq.util.WeakReference;

class AEPhotoListLogicBase$7
  implements Runnable
{
  AEPhotoListLogicBase$7(AEPhotoListLogicBase paramAEPhotoListLogicBase) {}
  
  public void run()
  {
    ((AEAbstractPhotoListFragment)this.this$0.a.get()).a.notifyDataSetChanged();
    this.this$0.e();
    QQToast.a(((AEAbstractPhotoListFragment)this.this$0.a.get()).getActivity(), "暂无媒体文件", 1000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.7
 * JD-Core Version:    0.7.0.1
 */