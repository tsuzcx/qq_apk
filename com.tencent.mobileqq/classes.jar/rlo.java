import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastShareBottomCreator.ViewHolder.ShareCallBack.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class rlo
  extends pak
{
  public ArticleInfo a;
  
  public rlo(rln paramrln, ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
  }
  
  public void a(boolean paramBoolean, int paramInt, rna paramrna)
  {
    super.a(paramBoolean, paramInt, paramrna);
    if ((paramBoolean) && (paramrna != null) && (!TextUtils.isEmpty(paramrna.a(paramInt)))) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ThreadManager.getUIHandler().post(new WebFastShareBottomCreator.ViewHolder.ShareCallBack.1(this, paramBoolean, paramInt, paramrna));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rlo
 * JD-Core Version:    0.7.0.1
 */