import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.util.Iterator;
import java.util.List;

class qpd
  extends QIPCModule
{
  qpd(qpc paramqpc, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    synchronized (qpc.a(this.a))
    {
      Iterator localIterator = qpc.a(this.a).iterator();
      if (localIterator.hasNext()) {
        ((qpe)localIterator.next()).a(paramString, paramBundle);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qpd
 * JD-Core Version:    0.7.0.1
 */