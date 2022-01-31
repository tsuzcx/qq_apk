import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.RecommendFeedsDiandianEntranceManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class rpk
{
  private static rpk jdField_a_of_type_Rpk;
  private int jdField_a_of_type_Int = 0;
  private int b = 0;
  
  private rpk()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(218);
    if (localAladdinConfig != null)
    {
      this.jdField_a_of_type_Int = localAladdinConfig.getIntegerFromString("daily_diandian_icon_mode_pure", 0);
      this.b = localAladdinConfig.getIntegerFromString("daily_diandian_icon_mode_mix", 0);
      QLog.d("DailyFeedsDiandianEntranceManager", 1, "Daily entry pure : " + this.jdField_a_of_type_Int + ", mix : " + this.b);
    }
  }
  
  private String a()
  {
    int i = -1;
    int j = a();
    if (j == 2) {
      i = 5;
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("diandianfeeds_type", i);
        ((JSONObject)localObject).put("trigger_src", 1);
        ((JSONObject)localObject).put("channel_id", opt.b());
        localObject = ((JSONObject)localObject).toString();
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      if (j == 3) {
        i = 6;
      } else if (j == 1) {
        i = RecommendFeedsDiandianEntranceManager.a().a();
      }
    }
    return "";
  }
  
  public static rpk a()
  {
    if (jdField_a_of_type_Rpk == null) {}
    try
    {
      if (jdField_a_of_type_Rpk == null) {
        jdField_a_of_type_Rpk = new rpk();
      }
      return jdField_a_of_type_Rpk;
    }
    finally {}
  }
  
  public static slk a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getParcelable("daily_bottom_entry_data");
    if ((paramBundle instanceof slk)) {
      return (slk)paramBundle;
    }
    return null;
  }
  
  public static boolean a(Bundle paramBundle)
  {
    return paramBundle.containsKey("daily_bottom_entry_data");
  }
  
  public int a()
  {
    if (!bjxj.i())
    {
      QLog.d("DailyFeedsDiandianEntranceManager", 1, "getEntryMode | hide mode");
      return 0;
    }
    if (otf.a(otf.b()))
    {
      QLog.d("DailyFeedsDiandianEntranceManager", 1, "getEntryMode |  entryModeInNormalDaily : " + this.jdField_a_of_type_Int);
      return this.jdField_a_of_type_Int;
    }
    QLog.d("DailyFeedsDiandianEntranceManager", 1, "getEntryMode |  entryModeInMixDaily : " + this.b);
    return this.b;
  }
  
  public View.OnClickListener a(Activity paramActivity, View paramView, nww paramnww)
  {
    switch (a())
    {
    case 1: 
    default: 
      return new rpn(this, paramActivity);
    case 3: 
      return new rpl(this, paramnww);
    case 0: 
      return null;
    }
    return new rpm(this, paramActivity);
  }
  
  public void a()
  {
    if (a() != 0) {
      nrt.a(null, "CliOper", "", "", "0X80094FE", "0X80094FE", 0, 0, "", "", "", a(), false);
    }
  }
  
  public boolean a()
  {
    return a() != 0;
  }
  
  public void b()
  {
    nrt.a(null, "CliOper", "", "", "0X80094FF", "0X80094FF", 0, 0, "", "", "", a(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rpk
 * JD-Core Version:    0.7.0.1
 */