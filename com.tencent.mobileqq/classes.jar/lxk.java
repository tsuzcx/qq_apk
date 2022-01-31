import android.os.RemoteException;
import com.tencent.av.service.LBSInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class lxk
  extends ajzk
{
  private List<lwu> a = new ArrayList();
  
  public int a()
  {
    return this.a.size();
  }
  
  public void a(lwu paramlwu)
  {
    if (paramlwu != null) {
      this.a.add(paramlwu);
    }
  }
  
  protected void a(boolean paramBoolean, LBSInfo paramLBSInfo)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      lwu locallwu = (lwu)localIterator.next();
      try
      {
        locallwu.a(paramBoolean, paramLBSInfo);
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
 * Qualified Name:     lxk
 * JD-Core Version:    0.7.0.1
 */