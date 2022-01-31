import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class nlq
  implements CompoundButton.OnCheckedChangeListener
{
  public nlq(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    int i;
    if (paramBoolean) {
      i = 0;
    }
    for (;;)
    {
      rup.a(i);
      paramCompoundButton = new JSONObject();
      if (paramBoolean) {
        i = j;
      }
      try
      {
        for (;;)
        {
          paramCompoundButton.put("click_opt", i);
          ndn.a(null, "", "0X800A80B", "0X800A80B", 0, 0, "", "", "", paramCompoundButton.toString(), false);
          return;
          i = 1;
          break;
          i = 2;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nlq
 * JD-Core Version:    0.7.0.1
 */