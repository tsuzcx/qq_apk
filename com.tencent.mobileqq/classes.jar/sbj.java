import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastShareBottomCreator.ViewHolder.ShareCallBack.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class sbj
  extends pfq
{
  public ArticleInfo a;
  
  public sbj(sbi paramsbi, ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
  }
  
  public void a(boolean paramBoolean, int paramInt, scw paramscw)
  {
    super.a(paramBoolean, paramInt, paramscw);
    if ((paramBoolean) && (paramscw != null) && (!TextUtils.isEmpty(paramscw.a(paramInt)))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ThreadManager.getUIHandler().post(new WebFastShareBottomCreator.ViewHolder.ShareCallBack.1(this, paramBoolean, paramInt, paramscw));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sbj
 * JD-Core Version:    0.7.0.1
 */