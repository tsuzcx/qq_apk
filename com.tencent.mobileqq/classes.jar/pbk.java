import com.tencent.biz.webviewplugin.NearbyTroopsPlugin;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager.OnAnimationPlayEndListener;

public class pbk
  implements AIOAnimationControlManager.OnAnimationPlayEndListener
{
  public pbk(NearbyTroopsPlugin paramNearbyTroopsPlugin, String paramString) {}
  
  public void a(String paramString1, String paramString2)
  {
    if (AIOAnimationControlManager.jdField_a_of_type_JavaLangString.equals(paramString2)) {
      this.jdField_a_of_type_ComTencentBizWebviewpluginNearbyTroopsPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{\"result\":1,\"id\":" + paramString2 + "}" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pbk
 * JD-Core Version:    0.7.0.1
 */