package cooperation.qqreader.host.advertisement;

import acvm;
import android.support.annotation.NonNull;
import android.view.View;

public abstract class ReaderGdtSdk$ReportListener
  implements acvm
{
  private ReaderAdWrapper a;
  
  public ReaderGdtSdk$ReportListener(@NonNull ReaderAdWrapper paramReaderAdWrapper)
  {
    this.a = paramReaderAdWrapper;
  }
  
  public final void reportImpression(View paramView)
  {
    if (paramView.getTag(2131381107) == this.a.a()) {
      reportImpression(paramView, this.a);
    }
  }
  
  public abstract void reportImpression(View paramView, ReaderAdWrapper paramReaderAdWrapper);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qqreader.host.advertisement.ReaderGdtSdk.ReportListener
 * JD-Core Version:    0.7.0.1
 */