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

public class qvr
  implements View.OnClickListener
{
  public qvr(ComponentContentHotQuestion paramComponentContentHotQuestion) {}
  
  public void onClick(View paramView)
  {
    pxk localpxk = this.a.jdField_a_of_type_Qva.a();
    ArticleInfo localArticleInfo = localpxk.a();
    Object localObject2 = (rfw)localArticleInfo.mNewPolymericInfo.jdField_a_of_type_JavaUtilList.get(0);
    Object localObject3;
    if ((localArticleInfo.mNewPolymericInfo.jdField_a_of_type_Int == 12) && (((rfw)localObject2).jdField_a_of_type_Rfy != null))
    {
      localObject3 = new Intent(this.a.jdField_a_of_type_AndroidContentContext, ReadInJoyDeliverUGCActivity.class);
      ((Intent)localObject3).putExtra("arg_topic_id", String.valueOf(((rfw)localObject2).jdField_a_of_type_Rfy.jdField_b_of_type_Int));
      ((Intent)localObject3).putExtra("support_topic", true);
      ((Intent)localObject3).putExtra("support_linkify", true);
    }
    try
    {
      String str1 = new String(bgku.decode(((rfw)localObject2).jdField_a_of_type_Rfy.jdField_b_of_type_JavaLangString, 0));
      ((Intent)localObject3).putExtra("is_from_poly_topic", true);
      if (localpxk.e() == 70)
      {
        bool = true;
        ((Intent)localObject3).putExtra("is_from_dian_dian", bool);
        ((Intent)localObject3).putExtra("arg_topic_name", str1);
        ((Intent)localObject3).putExtra("arg_ad_tag", ((rfw)localObject2).jdField_a_of_type_Rfy.c);
        this.a.getContext().startActivity((Intent)localObject3);
        localObject3 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject3).put("channel_id", localpxk.e());
        if (((rfw)localObject2).jdField_a_of_type_Rfx == null) {
          break label398;
        }
        str1 = ((rfw)localObject2).jdField_a_of_type_Rfx.a;
        ((JSONObject)localObject3).put("rowkey", str1);
        if (((rfw)localObject2).jdField_a_of_type_Rfy == null) {
          break label407;
        }
        i = ((rfw)localObject2).jdField_a_of_type_Rfy.jdField_b_of_type_Int;
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
      if (pha.o(localArticleInfo))
      {
        str1 = "1";
        oat.a(null, "CliOper", "", "", "0X800982C", "0X800982C", 0, 0, (String)localObject2, str1, localArticleInfo.mStrategyId + "", ((JSONObject)localObject3).toString(), false);
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
 * Qualified Name:     qvr
 * JD-Core Version:    0.7.0.1
 */