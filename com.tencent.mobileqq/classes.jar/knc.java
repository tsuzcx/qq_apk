import android.os.Bundle;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;

public class knc
  implements TroopMemberApiClient.Callback
{
  public knc(SensorAPIJavaScript paramSensorAPIJavaScript, String paramString) {}
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("mode");
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.callJs(this.jdField_a_of_type_JavaLangString, new String[] { i + "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     knc
 * JD-Core Version:    0.7.0.1
 */