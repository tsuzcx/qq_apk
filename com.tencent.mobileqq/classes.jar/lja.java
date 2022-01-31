import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.comment.NativeCommentServlet;
import com.tencent.biz.pubaccount.readinjoy.comment.NativeCommentServlet.CreateCommentObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONObject;

public final class lja
  implements BusinessObserver
{
  public lja(NativeCommentServlet.CreateCommentObserver paramCreateCommentObserver, ArticleInfo paramArticleInfo, int paramInt1, String paramString1, String paramString2, JSONArray paramJSONArray, int paramInt2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i = 0;
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle == null) {
          break label240;
        }
        localObject = new WebSsoBody.WebSsoResponseBody();
        ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
        paramInt = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
        localObject = paramBundle.getLocalizedMessage();
      }
      catch (Exception paramBundle)
      {
        try
        {
          paramBundle = ((WebSsoBody.WebSsoResponseBody)localObject).data.get();
          if (QLog.isColorLevel()) {
            QLog.d(NativeCommentServlet.jdField_a_of_type_JavaLangString, 2, "createComment ret=" + paramBundle);
          }
          paramBundle = new JSONObject(paramBundle);
          if (paramInt != 0)
          {
            paramBundle = paramBundle.optString("msg");
            i = 0;
            if (i == 0) {
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentNativeCommentServlet$CreateCommentObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_JavaLangString, paramInt, paramBundle);
            }
            return;
          }
        }
        catch (Exception paramBundle)
        {
          Object localObject;
          break label178;
        }
        try
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentNativeCommentServlet$CreateCommentObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, paramBundle, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_OrgJsonJSONArray, this.jdField_b_of_type_Int);
          paramBundle = "";
          i = 1;
        }
        catch (Exception paramBundle)
        {
          i = 1;
          break label178;
        }
        paramBundle = paramBundle;
        paramInt = -1;
      }
      label178:
      paramBundle.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d(NativeCommentServlet.jdField_a_of_type_JavaLangString, 2, "fetchCommentList error info:" + paramBundle.getLocalizedMessage());
      }
      paramBundle = (Bundle)localObject;
      continue;
      label240:
      i = 0;
      paramInt = -1;
      paramBundle = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lja
 * JD-Core Version:    0.7.0.1
 */