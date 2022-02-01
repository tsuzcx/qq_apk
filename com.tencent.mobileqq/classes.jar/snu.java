import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import cooperation.plugin.PluginBaseActivity;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class snu
  implements sow
{
  snu(snh paramsnh) {}
  
  public void onClick(View paramView)
  {
    this.a.a();
    this.a.a();
    puq localpuq = (puq)paramView.getTag();
    if (localpuq == null) {}
    for (;;)
    {
      return;
      BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)this.a.jdField_b_of_type_JavaUtilList.get(localpuq.a);
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("time", System.currentTimeMillis() / 1000L);
        localJSONObject.put("channel_id", this.a.c);
        if ((this.a.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity))
        {
          localJSONObject.put("folder_status", pha.d);
          localJSONObject.put("kandian_mode", pha.e());
          localJSONObject.put("feeds_type", "" + pha.a(localBaseArticleInfo));
          localJSONObject.put("rowkey", ube.a(localBaseArticleInfo));
          oat.a(null, "", "0X8007058", "0X8007058", 0, 0, "", "", "", localJSONObject.toString(), false);
        }
        while (localBaseArticleInfo != null)
        {
          snh.a(this.a, paramView, localpuq, localBaseArticleInfo);
          if ((this.a.jdField_a_of_type_Seu != null) && (this.a.jdField_a_of_type_Seu.b()))
          {
            this.a.jdField_a_of_type_Seu.a();
            this.a.jdField_b_of_type_Boolean = true;
          }
          puf.a(paramView);
          return;
          if ((this.a.jdField_a_of_type_AndroidAppActivity instanceof PluginBaseActivity))
          {
            localJSONObject.put("folder_status", 1);
            bcst.b(null, "CliOper", "", "", "0X800705F", "0X800705F", 0, 0, "", "", "", localJSONObject.toString());
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
 * Qualified Name:     snu
 * JD-Core Version:    0.7.0.1
 */