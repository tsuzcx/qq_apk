package dov.com.qq.im.ae.album.logic;

import bogn;
import bogq;
import bohl;
import com.tencent.mobileqq.widget.QQToast;
import mqq.util.WeakReference;

public class AEPhotoListLogicBase$6
  implements Runnable
{
  public AEPhotoListLogicBase$6(bohl parambohl) {}
  
  public void run()
  {
    ((bogn)this.this$0.a.get()).a.notifyDataSetChanged();
    this.this$0.d();
    QQToast.a(((bogn)this.this$0.a.get()).getActivity(), "暂无媒体文件", 1000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.6
 * JD-Core Version:    0.7.0.1
 */