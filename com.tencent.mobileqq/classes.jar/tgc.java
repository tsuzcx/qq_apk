import android.app.Activity;
import android.content.ClipboardManager;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import org.json.JSONObject;

public class tgc
  extends tgb
{
  tgc(tfy paramtfy1, Activity paramActivity, tfy paramtfy2, JSONObject paramJSONObject)
  {
    super(paramtfy1, paramActivity, paramtfy2, paramJSONObject);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, int paramInt)
  {
    ((ClipboardManager)this.jdField_a_of_type_AndroidAppActivity.getSystemService("clipboard")).setText(paramString1);
    zyx.a(2, 2131691142);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tgc
 * JD-Core Version:    0.7.0.1
 */