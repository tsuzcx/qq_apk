import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import org.json.JSONException;
import org.json.JSONObject;

class rlo
  implements pbx
{
  rlo(rln paramrln) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    rln.a(this.a, true);
    Context localContext = this.a.jdField_a_of_type_AndroidViewView.getContext();
    ArticleInfo localArticleInfo = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b;
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.a.c()) {
      paramString = "2";
    }
    for (;;)
    {
      paramString = onh.a(localContext, localArticleInfo, 0, paramString);
      if (paramBoolean) {
        paramInt = 1;
      }
      try
      {
        for (;;)
        {
          paramString.put("is_done", paramInt);
          rno.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b, "0X800898B", paramString.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rlo
 * JD-Core Version:    0.7.0.1
 */