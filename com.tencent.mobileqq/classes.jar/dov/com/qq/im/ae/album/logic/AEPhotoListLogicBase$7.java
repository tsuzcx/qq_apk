package dov.com.qq.im.ae.album.logic;

import bmyq;
import bmyv;
import bmzr;
import com.tencent.mobileqq.widget.QQToast;
import mqq.util.WeakReference;

public class AEPhotoListLogicBase$7
  implements Runnable
{
  public AEPhotoListLogicBase$7(bmzr parambmzr) {}
  
  public void run()
  {
    ((bmyq)this.this$0.a.get()).a.notifyDataSetChanged();
    this.this$0.e();
    QQToast.a(((bmyq)this.this$0.a.get()).getActivity(), "暂无媒体文件", 1000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.7
 * JD-Core Version:    0.7.0.1
 */