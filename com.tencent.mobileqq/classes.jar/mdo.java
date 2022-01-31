import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class mdo
  implements mdp
{
  public mdo(ReadInJoyWebDataManager paramReadInJoyWebDataManager) {}
  
  public void a(JSONObject paramJSONObject)
  {
    ReadInJoyWebDataManager.a(this.a, paramJSONObject.toString());
    if (QLog.isColorLevel()) {
      QLog.w("ReadInJoyWebDataManager", 2, "preLoadMsgBox HttpFetchBizCallback jsonRetData result" + ReadInJoyWebDataManager.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mdo
 * JD-Core Version:    0.7.0.1
 */