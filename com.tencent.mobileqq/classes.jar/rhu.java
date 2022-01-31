import com.tencent.mobileqq.activity.ArkFullScreenAppActivity;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.ArkAppModuleCallback;

public class rhu
  implements ArkAppContainer.ArkAppModuleCallback
{
  public rhu(ArkFullScreenAppActivity paramArkFullScreenAppActivity) {}
  
  public boolean a(ArkAppContainer paramArkAppContainer)
  {
    this.a.finish();
    if (ArkFullScreenAppActivity.a(this.a)) {
      this.a.overridePendingTransition(2131034134, 2131034135);
    }
    return false;
  }
  
  public boolean a(ArkAppContainer paramArkAppContainer, String paramString1, String paramString2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rhu
 * JD-Core Version:    0.7.0.1
 */