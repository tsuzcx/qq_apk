package cooperation.qqreader.host.advertisement;

import android.view.View;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;
import java.lang.ref.WeakReference;

public class ReaderGdtSdk$GdtTimeStatisticsWrapper
{
  private GdtDwellTimeStatisticsAfterClick a;
  
  public ReaderGdtSdk$GdtTimeStatisticsWrapper(ReaderAdWrapper paramReaderAdWrapper, WeakReference<View> paramWeakReference)
  {
    this.a = new GdtDwellTimeStatisticsAfterClick(paramReaderAdWrapper.a(), paramWeakReference);
  }
  
  public void click()
  {
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.host.advertisement.ReaderGdtSdk.GdtTimeStatisticsWrapper
 * JD-Core Version:    0.7.0.1
 */