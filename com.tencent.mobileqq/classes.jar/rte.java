import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class rte
  implements rtg
{
  rte(rtb paramrtb) {}
  
  public void a(JSONObject paramJSONObject)
  {
    rtb.a(this.a, paramJSONObject.toString());
    if (QLog.isColorLevel()) {
      QLog.w("ReadInJoyWebDataManager", 2, "preLoadMsgBox HttpFetchBizCallback jsonRetData result" + rtb.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rte
 * JD-Core Version:    0.7.0.1
 */