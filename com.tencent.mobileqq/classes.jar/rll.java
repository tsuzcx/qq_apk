import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastShareBottomCreator.ViewHolder.ShareCallBack.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class rll
  extends pah
{
  public ArticleInfo a;
  
  public rll(rlk paramrlk, ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
  }
  
  public void a(boolean paramBoolean, int paramInt, rmx paramrmx)
  {
    super.a(paramBoolean, paramInt, paramrmx);
    if ((paramBoolean) && (paramrmx != null) && (!TextUtils.isEmpty(paramrmx.a(paramInt)))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ThreadManager.getUIHandler().post(new WebFastShareBottomCreator.ViewHolder.ShareCallBack.1(this, paramBoolean, paramInt, paramrmx));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rll
 * JD-Core Version:    0.7.0.1
 */