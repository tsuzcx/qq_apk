import android.content.SharedPreferences;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import cooperation.readinjoy.ReadInJoyHelper;

public class llx
  implements Runnable
{
  public llx(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = ReadInJoyHelper.a(KandianMergeManager.a(this.a), true, false);
    if (localSharedPreferences != null) {
      KandianMergeManager.a(this.a, localSharedPreferences.getInt("kandian_follow_data_length", -1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     llx
 * JD-Core Version:    0.7.0.1
 */