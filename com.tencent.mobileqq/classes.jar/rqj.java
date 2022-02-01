import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.util.Iterator;
import java.util.List;

class rqj
  extends QIPCModule
{
  rqj(rqi paramrqi, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    synchronized (rqi.a(this.a))
    {
      Iterator localIterator = rqi.a(this.a).iterator();
      if (localIterator.hasNext()) {
        ((rqk)localIterator.next()).a(paramString, paramBundle);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rqj
 * JD-Core Version:    0.7.0.1
 */