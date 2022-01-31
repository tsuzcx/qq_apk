package cooperation.qqreader.host.advertisement;

import aaso;
import android.support.annotation.NonNull;
import android.view.View;

public abstract class ReaderGdtSdk$ReportListener
  implements aaso
{
  private ReaderAdWrapper a;
  
  public ReaderGdtSdk$ReportListener(@NonNull ReaderAdWrapper paramReaderAdWrapper)
  {
    this.a = paramReaderAdWrapper;
  }
  
  public final void reportImpression(View paramView)
  {
    if (paramView.getTag(2131379969) == this.a.a()) {
      reportImpression(paramView, this.a);
    }
  }
  
  public abstract void reportImpression(View paramView, ReaderAdWrapper paramReaderAdWrapper);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qqreader.host.advertisement.ReaderGdtSdk.ReportListener
 * JD-Core Version:    0.7.0.1
 */