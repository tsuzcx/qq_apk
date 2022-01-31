import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import org.json.JSONException;
import org.json.JSONObject;

class sbm
  implements phj
{
  sbm(sbl paramsbl) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    sbl.a(this.a, true);
    Context localContext = this.a.jdField_a_of_type_AndroidViewView.getContext();
    ArticleInfo localArticleInfo = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b;
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.a.c()) {
      paramString = "2";
    }
    for (;;)
    {
      paramString = ors.a(localContext, localArticleInfo, 0, paramString);
      if (paramBoolean) {
        paramInt = 1;
      }
      try
      {
        for (;;)
        {
          paramString.put("is_done", paramInt);
          sdn.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b, "0X800898B", paramString.toString());
          return;
          paramString = "1";
          break;
          paramInt = 2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sbm
 * JD-Core Version:    0.7.0.1
 */