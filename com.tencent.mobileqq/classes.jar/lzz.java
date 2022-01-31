import android.os.RemoteException;
import com.tencent.av.service.LBSInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class lzz
  extends alqy
{
  private List<lzj> a = new ArrayList();
  
  public int a()
  {
    return this.a.size();
  }
  
  public void a(lzj paramlzj)
  {
    if (paramlzj != null) {
      this.a.add(paramlzj);
    }
  }
  
  protected void a(boolean paramBoolean, LBSInfo paramLBSInfo)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      lzj locallzj = (lzj)localIterator.next();
      try
      {
        locallzj.a(paramBoolean, paramLBSInfo);
      }
      catch (RemoteException localRemoteException) {}
      if (QLog.isColorLevel()) {
        QLog.e("QQServiceForAV", 2, "Call onGetUserLocation fail", localRemoteException);
      }
    }
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     lzz
 * JD-Core Version:    0.7.0.1
 */