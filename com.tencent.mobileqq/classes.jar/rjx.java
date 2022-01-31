import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;

public class rjx
  implements pbx
{
  public rjx(AuthorData paramAuthorData) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    this.a.a(true);
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    ArticleInfo localArticleInfo = this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    if (this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {
      paramString = "2";
    }
    for (;;)
    {
      paramString = onh.a(localBaseApplication, localArticleInfo, 0, paramString);
      if (paramBoolean) {
        paramInt = 1;
      }
      try
      {
        for (;;)
        {
          paramString.put("is_done", paramInt);
          rno.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X800898B", paramString.toString());
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
 * Qualified Name:     rjx
 * JD-Core Version:    0.7.0.1
 */