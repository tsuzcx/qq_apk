package dov.com.qq.im.ae.album.logic;

import bllh;
import bllm;
import blly;
import blmi;
import com.tencent.mobileqq.widget.QQToast;
import mqq.util.WeakReference;

public class AEPhotoListLogicBase$8
  implements Runnable
{
  public AEPhotoListLogicBase$8(blmi paramblmi, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a) {
      QQToast.a(((bllh)this.this$0.a.get()).getActivity(), "暂无媒体文件", 1000).a();
    }
    ((bllh)this.this$0.a.get()).jdField_a_of_type_Bllm.notifyDataSetChanged();
    ((bllh)this.this$0.a.get()).jdField_a_of_type_Blly.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.8
 * JD-Core Version:    0.7.0.1
 */