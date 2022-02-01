import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.EditVideoFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

public class ryi
  implements QQPermissionCallback
{
  public ryi(EditVideoFragment paramEditVideoFragment) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("RIJUGC.EditVideoFragment", 1, "request position permissions, deny");
    QQToast.a(this.a.getActivity(), 2131718110, 0).a();
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("RIJUGC.EditVideoFragment", 1, "request position permissions, grant");
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ryi
 * JD-Core Version:    0.7.0.1
 */