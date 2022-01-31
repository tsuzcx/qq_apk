package dov.com.qq.im.ae.album.logic;

import bkql;
import bkqn;
import bkrh;
import com.tencent.mobileqq.widget.QQToast;
import mqq.util.WeakReference;

public class AEPhotoListLogicBase$5
  implements Runnable
{
  public AEPhotoListLogicBase$5(bkrh parambkrh) {}
  
  public void run()
  {
    ((bkql)this.this$0.a.get()).a.notifyDataSetChanged();
    this.this$0.d();
    QQToast.a(((bkql)this.this$0.a.get()).getActivity(), "暂无媒体文件", 1000).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.5
 * JD-Core Version:    0.7.0.1
 */