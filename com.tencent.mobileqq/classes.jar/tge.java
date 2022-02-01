import android.app.Activity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.json.JSONObject;

public class tge
  extends tgb
{
  tge(tfy paramtfy1, Activity paramActivity, tfy paramtfy2, JSONObject paramJSONObject)
  {
    super(paramtfy1, paramActivity, paramtfy2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    paramString1 = (QQAppInterface)ozs.a();
    if (paramString1 != null)
    {
      paramString1 = paramString1.getAccount();
      paramString2 = this.jdField_a_of_type_OrgJsonJSONObject.optString("title");
      paramString3 = this.jdField_a_of_type_OrgJsonJSONObject.optString("desc");
      paramActionSheetItem = this.jdField_a_of_type_OrgJsonJSONObject.optString("image_url");
      bmko.a(0, paramString2, this.jdField_a_of_type_OrgJsonJSONObject.optString("share_url"), null, paramString3, paramActionSheetItem, null, null, false, -1L).c(paramString1).b(this.jdField_a_of_type_AndroidAppActivity, paramString1, 2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tge
 * JD-Core Version:    0.7.0.1
 */