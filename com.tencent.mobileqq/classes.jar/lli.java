import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.comment.NativeCommentServlet;
import com.tencent.biz.pubaccount.readinjoy.comment.NativeCommentServlet.CommentObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.WebSsoBody.WebSsoResponseBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

public final class lli
  implements BusinessObserver
{
  public lli(NativeCommentServlet.CommentObserver paramCommentObserver, ArticleInfo paramArticleInfo) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    int m = 0;
    int k = 0;
    int j = -1;
    String str = "";
    localObject = str;
    paramInt = j;
    int i = k;
    if (paramBoolean) {
      paramInt = j;
    }
    for (i = m;; i = k)
    {
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        localObject = str;
        paramInt = j;
        i = k;
        if (paramBundle != null)
        {
          paramInt = j;
          i = m;
          localObject = new WebSsoBody.WebSsoResponseBody();
          paramInt = j;
          i = m;
          ((WebSsoBody.WebSsoResponseBody)localObject).mergeFrom(paramBundle);
          paramInt = j;
          i = m;
          j = ((WebSsoBody.WebSsoResponseBody)localObject).ret.get();
          paramInt = j;
          i = m;
          paramBundle = ((WebSsoBody.WebSsoResponseBody)localObject).data.get();
          paramInt = j;
          i = m;
          if (QLog.isColorLevel())
          {
            paramInt = j;
            i = m;
            QLog.d(NativeCommentServlet.a, 2, "fetch str=" + paramBundle);
          }
          paramInt = j;
          i = m;
          localObject = new JSONObject(paramBundle);
          if (j == 0) {
            break label233;
          }
          paramInt = j;
          i = m;
          localObject = ((JSONObject)localObject).optString("msg");
          i = k;
          paramInt = j;
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          label233:
          localObject = paramBundle.getLocalizedMessage();
          paramBundle.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.d(NativeCommentServlet.a, 2, "fetchCommentList error info:" + paramBundle.getLocalizedMessage());
          }
        }
      }
      if (i == 0) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentNativeCommentServlet$CommentObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, paramInt, (String)localObject);
      }
      return;
      i = 1;
      k = 1;
      paramInt = j;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentNativeCommentServlet$CommentObserver.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (JSONObject)localObject, paramBundle);
      localObject = str;
      paramInt = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lli
 * JD-Core Version:    0.7.0.1
 */