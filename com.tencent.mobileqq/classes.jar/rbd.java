import android.os.AsyncTask;
import com.tencent.mfsdk.collector.FPSCalculator;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class rbd
  extends AsyncTask
{
  public rbd(FPSCalculator paramFPSCalculator) {}
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = FPSCalculator.a(this.a).iterator();
    while (paramVarArgs.hasNext()) {
      QLog.d("Q.PerfTrace", 2, (String)paramVarArgs.next());
    }
    FPSCalculator.a(this.a).clear();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aaa.jar
 * Qualified Name:     rbd
 * JD-Core Version:    0.7.0.1
 */