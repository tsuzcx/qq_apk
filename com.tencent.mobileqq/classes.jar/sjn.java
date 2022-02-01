import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.util.Iterator;
import java.util.List;

class sjn
  extends QIPCModule
{
  sjn(sjm paramsjm, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    synchronized (sjm.a(this.a))
    {
      Iterator localIterator = sjm.a(this.a).iterator();
      if (localIterator.hasNext()) {
        ((sjo)localIterator.next()).a(paramString, paramBundle);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sjn
 * JD-Core Version:    0.7.0.1
 */