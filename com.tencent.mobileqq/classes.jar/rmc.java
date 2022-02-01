import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class rmc
  implements rme
{
  rmc(rlz paramrlz) {}
  
  public void a(JSONObject paramJSONObject)
  {
    rlz.a(this.a, paramJSONObject.toString());
    if (QLog.isColorLevel()) {
      QLog.w("ReadInJoyWebDataManager", 2, "preLoadMsgBox HttpFetchBizCallback jsonRetData result" + rlz.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rmc
 * JD-Core Version:    0.7.0.1
 */