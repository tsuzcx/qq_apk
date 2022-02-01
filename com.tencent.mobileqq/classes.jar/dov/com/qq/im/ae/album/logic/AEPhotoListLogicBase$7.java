package dov.com.qq.im.ae.album.logic;

import bnff;
import bnfi;
import bnfu;
import bngd;
import com.tencent.mobileqq.widget.QQToast;
import mqq.util.WeakReference;

public class AEPhotoListLogicBase$7
  implements Runnable
{
  public AEPhotoListLogicBase$7(bngd parambngd, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a) {
      QQToast.a(((bnff)this.this$0.a.get()).getActivity(), "暂无媒体文件", 1000).a();
    }
    ((bnff)this.this$0.a.get()).jdField_a_of_type_Bnfi.notifyDataSetChanged();
    ((bnff)this.this$0.a.get()).jdField_a_of_type_Bnfu.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.7
 * JD-Core Version:    0.7.0.1
 */