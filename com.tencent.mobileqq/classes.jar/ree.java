import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import eipc.EIPCResult;
import java.util.Iterator;
import java.util.List;

class ree
  extends QIPCModule
{
  ree(red paramred, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    synchronized (red.a(this.a))
    {
      Iterator localIterator = red.a(this.a).iterator();
      if (localIterator.hasNext()) {
        ((ref)localIterator.next()).a(paramString, paramBundle);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ree
 * JD-Core Version:    0.7.0.1
 */