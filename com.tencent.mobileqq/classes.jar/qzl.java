import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class qzl
  implements qzn
{
  qzl(qzi paramqzi) {}
  
  public void a(JSONObject paramJSONObject)
  {
    qzi.a(this.a, paramJSONObject.toString());
    if (QLog.isColorLevel()) {
      QLog.w("ReadInJoyWebDataManager", 2, "preLoadMsgBox HttpFetchBizCallback jsonRetData result" + qzi.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     qzl
 * JD-Core Version:    0.7.0.1
 */