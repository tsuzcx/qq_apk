import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.util.Iterator;
import java.util.List;

class qdf
  extends QIPCModule
{
  qdf(qde paramqde, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    synchronized (qde.a(this.a))
    {
      Iterator localIterator = qde.a(this.a).iterator();
      if (localIterator.hasNext()) {
        ((qdg)localIterator.next()).a(paramString, paramBundle);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qdf
 * JD-Core Version:    0.7.0.1
 */