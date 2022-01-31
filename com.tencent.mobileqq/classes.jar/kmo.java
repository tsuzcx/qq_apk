import android.os.Bundle;
import com.tencent.biz.game.SensorAPIJavaScript;
import com.tencent.biz.troop.TroopMemberApiClient.Callback;

public class kmo
  implements TroopMemberApiClient.Callback
{
  public kmo(SensorAPIJavaScript paramSensorAPIJavaScript, String paramString) {}
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getString("music");
      this.jdField_a_of_type_ComTencentBizGameSensorAPIJavaScript.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kmo
 * JD-Core Version:    0.7.0.1
 */