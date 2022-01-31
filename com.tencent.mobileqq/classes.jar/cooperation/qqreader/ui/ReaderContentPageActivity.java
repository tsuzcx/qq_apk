package cooperation.qqreader.ui;

import android.view.Window;
import bfnu;

public class ReaderContentPageActivity
  extends ReaderBaseWebActivity
{
  public void doOnResume()
  {
    super.doOnResume();
    Object localObject = (ReaderBaseFragment)b();
    if ((localObject != null) && (((ReaderBaseFragment)localObject).b))
    {
      localObject = (bfnu)((ReaderBaseFragment)localObject).a;
      Window localWindow = getWindow();
      if ((localObject != null) && (localWindow != null)) {
        ((bfnu)localObject).a(false, localWindow);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderContentPageActivity
 * JD-Core Version:    0.7.0.1
 */