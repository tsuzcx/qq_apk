import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRequestUtil;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class mmj
  implements Runnable
{
  mmj(mmi parammmi, long paramLong, List paramList) {}
  
  public void run()
  {
    FastWebActivity localFastWebActivity = this.jdField_a_of_type_Mmi.a;
    ArticleInfo localArticleInfo = FastWebActivity.a(this.jdField_a_of_type_Mmi.a);
    Object localObject;
    if (FastWebActivity.a(this.jdField_a_of_type_Mmi.a).c()) {
      localObject = "2";
    }
    for (;;)
    {
      localObject = ReadInJoyUtils.a(localFastWebActivity, localArticleInfo, 0, (String)localObject);
      try
      {
        ((JSONObject)localObject).put("open_speed", this.jdField_a_of_type_Long);
        ReportUtil.a(FastWebActivity.a(this.jdField_a_of_type_Mmi.a), "0X8008997", ((JSONObject)localObject).toString());
        FastWebActivity.f(this.jdField_a_of_type_Mmi.a);
        FastWebActivity.a(this.jdField_a_of_type_Mmi.a, FastWebActivity.a(this.jdField_a_of_type_Mmi.a), FastWebActivity.a(this.jdField_a_of_type_Mmi.a));
        ReportUtil.a(FastWebActivity.a(this.jdField_a_of_type_Mmi.a), this.jdField_a_of_type_JavaUtilList);
        FastWebRequestUtil.a(FastWebActivity.a(this.jdField_a_of_type_Mmi.a).mArticleContentUrl, FastWebActivity.a(this.jdField_a_of_type_Mmi.a));
        return;
        localObject = "1";
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
 * Qualified Name:     mmj
 * JD-Core Version:    0.7.0.1
 */