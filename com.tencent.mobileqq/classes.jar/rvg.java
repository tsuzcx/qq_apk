import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class rvg
  implements rvi
{
  rvg(rvd paramrvd) {}
  
  public void a(JSONObject paramJSONObject)
  {
    rvd.a(this.a, paramJSONObject.toString());
    if (QLog.isColorLevel()) {
      QLog.w("ReadInJoyWebDataManager", 2, "preLoadMsgBox HttpFetchBizCallback jsonRetData result" + rvd.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rvg
 * JD-Core Version:    0.7.0.1
 */