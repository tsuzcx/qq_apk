import com.tencent.biz.pubaccount.util.PublicAccountH5AbilityPlugin.BiuObserver.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class sgd
  extends osm
{
  final int jdField_a_of_type_Int;
  final String jdField_a_of_type_JavaLangString;
  
  public sgd(sfk paramsfk, String paramString, int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong, int paramInt, String paramString)
  {
    super.a(paramLong, paramInt, paramString);
    QLog.d("PublicAccountH5AbilityPlugin", 2, "[onBiuResult] " + paramLong + " " + paramInt + " errorMsg");
    try
    {
      paramString = new JSONObject();
      paramString.put("feedsId", String.valueOf(paramLong));
      paramString.put("retCode", paramInt);
      paramString.put("feedsType", this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Sfk.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramString.toString() });
      ThreadManager.getUIHandler().post(new PublicAccountH5AbilityPlugin.BiuObserver.1(this));
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("PublicAccountH5AbilityPlugin", 1, "[onBiuResult] ", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sgd
 * JD-Core Version:    0.7.0.1
 */