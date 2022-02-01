import android.app.Activity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class tgn
  extends tgb
{
  tgn(tfy paramtfy1, Activity paramActivity, tfy paramtfy2, JSONObject paramJSONObject)
  {
    super(paramtfy1, paramActivity, paramtfy2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    paramString2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("rowkey", "");
    paramString3 = this.jdField_a_of_type_OrgJsonJSONObject.optString("topicId", "");
    paramActionSheetItem = this.jdField_a_of_type_OrgJsonJSONObject.optString("title", "");
    if (!TextUtils.isEmpty(paramString2))
    {
      tfy.a(this.jdField_a_of_type_Tfy).rijWatchWordPresenter.a(paramString2, paramString1, paramString3, paramActionSheetItem);
      return;
    }
    if (!TextUtils.isEmpty(paramString3))
    {
      tfy.a(this.jdField_a_of_type_Tfy).rijWatchWordPresenter.a(paramString3, paramString1, paramActionSheetItem);
      return;
    }
    QLog.e(tfy.a, 1, "args is illegal: " + this.jdField_a_of_type_OrgJsonJSONObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tgn
 * JD-Core Version:    0.7.0.1
 */