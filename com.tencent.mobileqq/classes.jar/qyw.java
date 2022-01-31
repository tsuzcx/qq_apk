import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastShareBottomCreator.ViewHolder.ShareCallBack.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class qyw
  extends opj
{
  public ArticleInfo a;
  
  public qyw(qyv paramqyv, ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
  }
  
  public void a(boolean paramBoolean, int paramInt, rai paramrai)
  {
    super.a(paramBoolean, paramInt, paramrai);
    if ((paramBoolean) && (paramrai != null) && (!TextUtils.isEmpty(paramrai.a(paramInt)))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ThreadManager.getUIHandler().post(new WebFastShareBottomCreator.ViewHolder.ShareCallBack.1(this, paramBoolean, paramInt, paramrai));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qyw
 * JD-Core Version:    0.7.0.1
 */