import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.json.JSONObject;

public class tgm
  extends tgb
{
  tgm(tfy paramtfy1, Activity paramActivity, tfy paramtfy2, JSONObject paramJSONObject)
  {
    super(paramtfy1, paramActivity, paramtfy2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    if ((paramString2 != null) && (paramString2.contains("kandianshare.html5.qq.com")))
    {
      tfy.a(this.a).mShareHelper.b(paramString2);
      return;
    }
    tfy.a(this.a).mShareHelper.b(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tgm
 * JD-Core Version:    0.7.0.1
 */