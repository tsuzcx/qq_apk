import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.util.Iterator;
import java.util.List;

class qpa
  extends QIPCModule
{
  qpa(qoz paramqoz, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    synchronized (qoz.a(this.a))
    {
      Iterator localIterator = qoz.a(this.a).iterator();
      if (localIterator.hasNext()) {
        ((qpb)localIterator.next()).a(paramString, paramBundle);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qpa
 * JD-Core Version:    0.7.0.1
 */