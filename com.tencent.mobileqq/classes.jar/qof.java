import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentHotQuestion;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDeliverUGCActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import org.json.JSONObject;

public class qof
  implements View.OnClickListener
{
  public qof(ComponentContentHotQuestion paramComponentContentHotQuestion) {}
  
  public void onClick(View paramView)
  {
    ppu localppu = this.a.jdField_a_of_type_Qno.a();
    ArticleInfo localArticleInfo = localppu.a();
    Object localObject2 = (qwp)localArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
    Object localObject3;
    if ((localArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 12) && (((qwp)localObject2).jdField_a_of_type_Qwr != null))
    {
      localObject3 = new Intent(this.a.jdField_a_of_type_AndroidContentContext, ReadInJoyDeliverUGCActivity.class);
      ((Intent)localObject3).putExtra("arg_topic_id", String.valueOf(((qwp)localObject2).jdField_a_of_type_Qwr.jdField_b_of_type_Int));
      ((Intent)localObject3).putExtra("support_topic", true);
      ((Intent)localObject3).putExtra("support_linkify", true);
    }
    try
    {
      String str1 = new String(bhkv.decode(((qwp)localObject2).jdField_a_of_type_Qwr.jdField_b_of_type_JavaLangString, 0));
      ((Intent)localObject3).putExtra("is_from_poly_topic", true);
      if (localppu.e() == 70)
      {
        bool = true;
        ((Intent)localObject3).putExtra("is_from_dian_dian", bool);
        ((Intent)localObject3).putExtra("arg_topic_name", str1);
        ((Intent)localObject3).putExtra("arg_ad_tag", ((qwp)localObject2).jdField_a_of_type_Qwr.c);
        this.a.getContext().startActivity((Intent)localObject3);
        localObject3 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject3).put("channel_id", localppu.e());
        if (((qwp)localObject2).jdField_a_of_type_Qwq == null) {
          break label398;
        }
        str1 = ((qwp)localObject2).jdField_a_of_type_Qwq.a;
        ((JSONObject)localObject3).put("rowkey", str1);
        if (((qwp)localObject2).jdField_a_of_type_Qwr == null) {
          break label407;
        }
        i = ((qwp)localObject2).jdField_a_of_type_Qwr.jdField_b_of_type_Int;
        ((JSONObject)localObject3).put("topicid", i);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          int i;
          Object localObject1;
          localException2.printStackTrace();
          continue;
          String str2 = "2";
        }
      }
      localObject2 = localArticleInfo.mFeedId + "";
      if (ozs.o(localArticleInfo))
      {
        str1 = "1";
        ocd.a(null, "CliOper", "", "", "0X800982C", "0X800982C", 0, 0, (String)localObject2, str1, localArticleInfo.mStrategyId + "", ((JSONObject)localObject3).toString(), false);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localException1.printStackTrace();
        localObject1 = "";
        continue;
        boolean bool = false;
        continue;
        label398:
        localObject1 = Integer.valueOf(0);
        continue;
        label407:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qof
 * JD-Core Version:    0.7.0.1
 */