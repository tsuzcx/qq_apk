import android.content.Context;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil;
import com.tencent.mobileqq.app.PublicAccountObserver;
import org.json.JSONException;
import org.json.JSONObject;

class mnp
  extends PublicAccountObserver
{
  mnp(mnm parammnm) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    mnm.a(this.a, true);
    Context localContext = this.a.jdField_a_of_type_AndroidViewView.getContext();
    ArticleInfo localArticleInfo = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {
      paramString = "2";
    }
    for (;;)
    {
      paramString = ReadInJoyUtils.a(localContext, localArticleInfo, 0, paramString);
      int i;
      if (paramBoolean) {
        i = 1;
      }
      try
      {
        for (;;)
        {
          paramString.put("is_done", i);
          ReportUtil.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X800898B", paramString.toString());
          return;
          paramString = "1";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mnp
 * JD-Core Version:    0.7.0.1
 */