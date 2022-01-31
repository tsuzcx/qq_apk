import android.os.RemoteException;
import com.tencent.av.service.LBSInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class lxp
  extends ajzm
{
  private List<lwz> a = new ArrayList();
  
  public int a()
  {
    return this.a.size();
  }
  
  public void a(lwz paramlwz)
  {
    if (paramlwz != null) {
      this.a.add(paramlwz);
    }
  }
  
  protected void a(boolean paramBoolean, LBSInfo paramLBSInfo)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      lwz locallwz = (lwz)localIterator.next();
      try
      {
        locallwz.a(paramBoolean, paramLBSInfo);
      }
      catch (RemoteException localRemoteException) {}
      if (QLog.isColorLevel()) {
        QLog.e("QQServiceForAV", 2, "Call onGetUserLocation fail", localRemoteException);
      }
    }
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lxp
 * JD-Core Version:    0.7.0.1
 */