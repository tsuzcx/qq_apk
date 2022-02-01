package dov.com.qq.im.ae.album.logic;

import bmyq;
import bmyv;
import bmzh;
import bmzr;
import com.tencent.mobileqq.widget.QQToast;
import mqq.util.WeakReference;

public class AEPhotoListLogicBase$8
  implements Runnable
{
  public AEPhotoListLogicBase$8(bmzr parambmzr, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a) {
      QQToast.a(((bmyq)this.this$0.a.get()).getActivity(), "暂无媒体文件", 1000).a();
    }
    ((bmyq)this.this$0.a.get()).jdField_a_of_type_Bmyv.notifyDataSetChanged();
    ((bmyq)this.this$0.a.get()).jdField_a_of_type_Bmzh.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.8
 * JD-Core Version:    0.7.0.1
 */