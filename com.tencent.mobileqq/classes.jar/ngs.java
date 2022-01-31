import android.os.Bundle;
import com.tencent.biz.qqstory.pgc.QQStoryDiscoverSearchDialog;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class ngs
  implements BusinessObserver
{
  public ngs(QQStoryDiscoverSearchDialog paramQQStoryDiscoverSearchDialog) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      this.a.a(paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.qqstory.search", 2, QLog.getStackTraceString(paramBundle));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ngs
 * JD-Core Version:    0.7.0.1
 */