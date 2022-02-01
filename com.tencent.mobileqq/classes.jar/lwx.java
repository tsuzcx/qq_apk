import android.os.RemoteException;
import com.tencent.av.service.LBSInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class lwx
  extends anot
{
  private List<lwh> a = new ArrayList();
  
  public int a()
  {
    return this.a.size();
  }
  
  public void a(lwh paramlwh)
  {
    if (paramlwh != null) {
      this.a.add(paramlwh);
    }
  }
  
  protected void a(boolean paramBoolean, LBSInfo paramLBSInfo)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      lwh locallwh = (lwh)localIterator.next();
      try
      {
        locallwh.a(paramBoolean, paramLBSInfo);
      }
      catch (RemoteException localRemoteException) {}
      if (QLog.isColorLevel()) {
        QLog.e("QQServiceForAV", 2, "Call onGetUserLocation fail", localRemoteException);
      }
    }
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lwx
 * JD-Core Version:    0.7.0.1
 */