import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import cooperation.readinjoy.ReadInJoyHelper;

public class lmd
  implements Runnable
{
  public lmd(KandianMergeManager paramKandianMergeManager, int paramInt) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = ReadInJoyHelper.a(KandianMergeManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineKandianMergeManager), 1).edit();
    localEditor.putInt("subscribe_push_msg_status", this.jdField_a_of_type_Int);
    ReadInJoyHelper.a(localEditor, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lmd
 * JD-Core Version:    0.7.0.1
 */