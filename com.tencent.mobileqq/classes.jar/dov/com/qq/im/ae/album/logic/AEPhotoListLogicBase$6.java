package dov.com.qq.im.ae.album.logic;

import bkql;
import bkqn;
import bkrb;
import bkrh;
import com.tencent.mobileqq.widget.QQToast;
import mqq.util.WeakReference;

public class AEPhotoListLogicBase$6
  implements Runnable
{
  public AEPhotoListLogicBase$6(bkrh parambkrh, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a) {
      QQToast.a(((bkql)this.this$0.a.get()).getActivity(), "暂无媒体文件", 1000).a();
    }
    ((bkql)this.this$0.a.get()).jdField_a_of_type_Bkqn.notifyDataSetChanged();
    ((bkql)this.this$0.a.get()).jdField_a_of_type_Bkrb.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEPhotoListLogicBase.6
 * JD-Core Version:    0.7.0.1
 */