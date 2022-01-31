import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentHotQuestion;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import java.util.List;
import org.json.JSONObject;

public class pvp
  implements View.OnClickListener
{
  public pvp(ComponentContentHotQuestion paramComponentContentHotQuestion) {}
  
  public void onClick(View paramView)
  {
    pau localpau = this.a.jdField_a_of_type_Puy.a();
    ArticleInfo localArticleInfo = localpau.a();
    Object localObject1 = (qbo)localArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
    Object localObject2;
    if ((localArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 12) && (((qbo)localObject1).jdField_a_of_type_Qbq != null))
    {
      localObject2 = new Intent((Activity)this.a.jdField_a_of_type_AndroidContentContext, ReadInJoyDeliverUGCActivity.class);
      ((Intent)localObject2).putExtra("arg_topic_id", String.valueOf(String.valueOf(((qbo)localObject1).jdField_a_of_type_Qbq.jdField_b_of_type_Int)));
      ((Intent)localObject2).putExtra("support_topic", true);
      ((Intent)localObject2).putExtra("support_linkify", true);
    }
    try
    {
      paramView = new String(bbco.decode(((qbo)localObject1).jdField_a_of_type_Qbq.jdField_b_of_type_JavaLangString, 0));
      ((Intent)localObject2).putExtra("is_from_poly_topic", true);
      if (localpau.e() == 70)
      {
        bool = true;
        ((Intent)localObject2).putExtra("is_from_dian_dian", bool);
        ((Intent)localObject2).putExtra("arg_topic_name", paramView);
        ((Intent)localObject2).putExtra("arg_ad_tag", ((qbo)localObject1).jdField_a_of_type_Qbq.c);
        this.a.getContext().startActivity((Intent)localObject2);
        localObject2 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject2).put("channel_id", localpau.e());
        if (((qbo)localObject1).jdField_a_of_type_Qbp == null) {
          break label388;
        }
        paramView = ((qbo)localObject1).jdField_a_of_type_Qbp.a;
        ((JSONObject)localObject2).put("rowkey", paramView);
        if (((qbo)localObject1).jdField_a_of_type_Qbq == null) {
          break label396;
        }
        i = ((qbo)localObject1).jdField_a_of_type_Qbq.jdField_b_of_type_Int;
        ((JSONObject)localObject2).put("topicid", i);
      }
      catch (Exception paramView)
      {
        for (;;)
        {
          int i;
          paramView.printStackTrace();
          continue;
          paramView = "2";
        }
      }
      localObject1 = localArticleInfo.mFeedId + "";
      if (onh.o(localArticleInfo))
      {
        paramView = "1";
        nol.a(null, "CliOper", "", "", "0X800982C", "0X800982C", 0, 0, (String)localObject1, paramView, localArticleInfo.mStrategyId + "", ((JSONObject)localObject2).toString(), false);
        return;
      }
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        paramView.printStackTrace();
        paramView = "";
        continue;
        boolean bool = false;
        continue;
        label388:
        paramView = Integer.valueOf(0);
        continue;
        label396:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pvp
 * JD-Core Version:    0.7.0.1
 */