import android.os.RemoteException;
import com.tencent.av.service.LBSInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class lxf
  extends amuv
{
  private List<lwo> a = new ArrayList();
  
  public int a()
  {
    return this.a.size();
  }
  
  public void a(lwo paramlwo)
  {
    if (paramlwo != null) {
      this.a.add(paramlwo);
    }
  }
  
  protected void a(boolean paramBoolean, LBSInfo paramLBSInfo)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      lwo locallwo = (lwo)localIterator.next();
      try
      {
        locallwo.a(paramBoolean, paramLBSInfo);
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
 * Qualified Name:     lxf
 * JD-Core Version:    0.7.0.1
 */