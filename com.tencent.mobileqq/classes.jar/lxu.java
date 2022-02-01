import android.os.RemoteException;
import com.tencent.av.service.LBSInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class lxu
  extends aoau
{
  private List<lxd> a = new ArrayList();
  
  public int a()
  {
    return this.a.size();
  }
  
  public void a(lxd paramlxd)
  {
    if (paramlxd != null) {
      this.a.add(paramlxd);
    }
  }
  
  protected void a(boolean paramBoolean, LBSInfo paramLBSInfo)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      lxd locallxd = (lxd)localIterator.next();
      try
      {
        locallxd.a(paramBoolean, paramLBSInfo);
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
 * Qualified Name:     lxu
 * JD-Core Version:    0.7.0.1
 */