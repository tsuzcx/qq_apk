import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import cooperation.plugin.PluginBaseActivity;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class sey
  implements sga
{
  sey(sel paramsel) {}
  
  public void onClick(View paramView)
  {
    this.a.a();
    this.a.a();
    pnd localpnd = (pnd)paramView.getTag();
    if (localpnd == null) {}
    for (;;)
    {
      return;
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)this.a.jdField_b_of_type_JavaUtilList.get(localpnd.a);
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("time", System.currentTimeMillis() / 1000L);
        localJSONObject.put("channel_id", this.a.c);
        if ((this.a.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity))
        {
          localJSONObject.put("folder_status", ozs.d);
          localJSONObject.put("kandian_mode", ozs.e());
          localJSONObject.put("feeds_type", "" + ozs.a(localBaseArticleInfo));
          localJSONObject.put("rowkey", ubg.a(localBaseArticleInfo));
          ocd.a(null, "", "0X8007058", "0X8007058", 0, 0, "", "", "", localJSONObject.toString(), false);
        }
        while (localBaseArticleInfo != null)
        {
          sel.a(this.a, paramView, localpnd, localBaseArticleInfo);
          if ((this.a.jdField_a_of_type_Rvy != null) && (this.a.jdField_a_of_type_Rvy.b()))
          {
            this.a.jdField_a_of_type_Rvy.a();
            this.a.jdField_b_of_type_Boolean = true;
          }
          pms.a(paramView);
          return;
          if ((this.a.jdField_a_of_type_AndroidAppActivity instanceof PluginBaseActivity))
          {
            localJSONObject.put("folder_status", 1);
            bdll.b(null, "CliOper", "", "", "0X800705F", "0X800705F", 0, 0, "", "", "", localJSONObject.toString());
          }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sey
 * JD-Core Version:    0.7.0.1
 */