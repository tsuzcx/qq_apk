import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.util.Iterator;
import java.util.List;

class rzm
  extends QIPCModule
{
  rzm(rzl paramrzl, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    synchronized (rzl.a(this.a))
    {
      Iterator localIterator = rzl.a(this.a).iterator();
      if (localIterator.hasNext()) {
        ((rzn)localIterator.next()).a(paramString, paramBundle);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rzm
 * JD-Core Version:    0.7.0.1
 */