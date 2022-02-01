import android.os.RemoteException;
import com.tencent.av.service.LBSInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class lxs
  extends anxj
{
  private List<lxb> a = new ArrayList();
  
  public int a()
  {
    return this.a.size();
  }
  
  public void a(lxb paramlxb)
  {
    if (paramlxb != null) {
      this.a.add(paramlxb);
    }
  }
  
  protected void a(boolean paramBoolean, LBSInfo paramLBSInfo)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      lxb locallxb = (lxb)localIterator.next();
      try
      {
        locallxb.a(paramBoolean, paramLBSInfo);
      }
      catch (RemoteException localRemoteException) {}
      if (QLog.isColorLevel()) {
        QLog.e("QQServiceForAV", 2, "Call onGetUserLocation fail", localRemoteException);
      }
    }
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     lxs
 * JD-Core Version:    0.7.0.1
 */