import com.tencent.biz.pubaccount.readinjoy.ugc.managecolumn.AbsPublishColumnFragment;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionCallback;

public class rfi
  implements QQPermissionCallback
{
  public rfi(AbsPublishColumnFragment paramAbsPublishColumnFragment) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("RIJUGC.PublishTopicFragment", 1, "request camera permissions, deny");
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    QLog.i("RIJUGC.PublishTopicFragment", 1, "request camera permissions, grant");
    AbsPublishColumnFragment.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rfi
 * JD-Core Version:    0.7.0.1
 */