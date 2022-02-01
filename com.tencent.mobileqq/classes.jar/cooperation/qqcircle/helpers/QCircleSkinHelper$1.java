package cooperation.qqcircle.helpers;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.IOException;

class QCircleSkinHelper$1
  implements Runnable
{
  QCircleSkinHelper$1(QCircleSkinHelper paramQCircleSkinHelper) {}
  
  public void run()
  {
    try
    {
      QCircleSkinHelper.access$100(this.this$0).load(QCircleSkinHelper.access$000(this.this$0).getAssets().open("defaultmode/config.ini"));
      QCircleSkinHelper.access$200(this.this$0).load(QCircleSkinHelper.access$000(this.this$0).getAssets().open("darkmode/config.ini"));
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqcircle.helpers.QCircleSkinHelper.1
 * JD-Core Version:    0.7.0.1
 */