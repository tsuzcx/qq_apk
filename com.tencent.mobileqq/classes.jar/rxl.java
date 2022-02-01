import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.util.Iterator;
import java.util.List;

class rxl
  extends QIPCModule
{
  rxl(rxk paramrxk, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    synchronized (rxk.a(this.a))
    {
      Iterator localIterator = rxk.a(this.a).iterator();
      if (localIterator.hasNext()) {
        ((rxm)localIterator.next()).a(paramString, paramBundle);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rxl
 * JD-Core Version:    0.7.0.1
 */