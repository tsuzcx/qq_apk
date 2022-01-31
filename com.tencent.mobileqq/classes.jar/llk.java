import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule.DeleteCommentObserver;
import com.tencent.biz.pubaccount.readinjoy.comment.NativeCommentServlet;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public final class llk
  implements BusinessObserver
{
  public llk(ArticleCommentModule.DeleteCommentObserver paramDeleteCommentObserver, ArticleInfo paramArticleInfo, int paramInt, String paramString1, String paramString2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int i1 = 0;
    int n = 0;
    int m = -1;
    String str = "";
    localObject = str;
    int k = m;
    paramInt = n;
    int i;
    if (paramBoolean)
    {
      i = m;
      j = i1;
    }
    for (;;)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        localObject = str;
        k = m;
        paramInt = n;
        if (paramBundle != null)
        {
          i = m;
          j = i1;
          localObject = new WebSsoBody.WebSsoResponseBody();
          i = m;
          j = i1;
          ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
          i = m;
          j = i1;
          m = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
          i = m;
          j = i1;
          paramBundle = ((WebSsoBody.WebSsoResponseBody)localObject).data.get();
          i = m;
          j = i1;
          if (QLog.isColorLevel())
          {
            i = m;
            j = i1;
            QLog.d(NativeCommentServlet.jdField_a_of_type_JavaLangString, 2, "deleteComment ret=" + paramBundle);
          }
          i = m;
          j = i1;
          paramBundle = new JSONObject(paramBundle);
          if (m == 0) {
            continue;
          }
          i = m;
          j = i1;
          localObject = paramBundle.optString("msg");
          paramInt = n;
          k = m;
        }
        i = k;
      }
      catch (Exception paramBundle)
      {
        localObject = paramBundle.getLocalizedMessage();
        paramBundle.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(NativeCommentServlet.jdField_a_of_type_JavaLangString, 2, "fetchCommentList error info:" + paramBundle.getLocalizedMessage());
        paramInt = j;
        continue;
      }
      if (paramInt == 0) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule$DeleteCommentObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_JavaLangString, this.b, i, (String)localObject);
      }
      return;
      localObject = str;
      k = m;
      paramInt = n;
      i = m;
      j = i1;
      if (paramBundle.optInt("ret") == 0)
      {
        j = 1;
        paramInt = 1;
        i = m;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentArticleCommentModule$DeleteCommentObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b);
        localObject = str;
        k = m;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     llk
 * JD-Core Version:    0.7.0.1
 */