import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity;
import org.json.JSONException;
import org.json.JSONObject;

public class oad
  implements CompoundButton.OnCheckedChangeListener
{
  public oad(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    int j = 1;
    int i;
    if (paramBoolean) {
      i = 0;
    }
    for (;;)
    {
      syz.a(i);
      paramCompoundButton = new JSONObject();
      if (paramBoolean) {
        i = j;
      }
      try
      {
        for (;;)
        {
          paramCompoundButton.put("click_opt", i);
          nrt.a(null, "", "0X800A80B", "0X800A80B", 0, 0, "", "", "", paramCompoundButton.toString(), false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     oad
 * JD-Core Version:    0.7.0.1
 */