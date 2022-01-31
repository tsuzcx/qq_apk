import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.readinjoy.model.FollowCoverInfoModule;
import cooperation.readinjoy.ReadInJoyHelper;

public class lrg
  implements Runnable
{
  public lrg(FollowCoverInfoModule paramFollowCoverInfoModule) {}
  
  public void run()
  {
    Object localObject = ReadInJoyHelper.a(FollowCoverInfoModule.a(this.a), true, false);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).remove("follow_tab_topic_update_info_exposure");
        ReadInJoyHelper.a((SharedPreferences.Editor)localObject, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lrg
 * JD-Core Version:    0.7.0.1
 */