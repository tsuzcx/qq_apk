import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import cooperation.readinjoy.ReadInJoyHelper;

public class loo
  implements Runnable
{
  public loo(KandianMergeManager paramKandianMergeManager) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = ReadInJoyHelper.a(KandianMergeManager.a(this.a), 1).edit();
    localEditor.remove("subscribe_push_msg_time");
    localEditor.remove("subscribe_push_msg_uin");
    localEditor.remove("subscribe_push_msg_status");
    localEditor.remove("subscribe_push_msg_xml");
    ReadInJoyHelper.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     loo
 * JD-Core Version:    0.7.0.1
 */