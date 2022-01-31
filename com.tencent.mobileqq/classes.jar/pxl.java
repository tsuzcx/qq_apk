import android.graphics.Color;
import android.text.TextPaint;
import android.widget.Button;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderRecommend;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;

public class pxl
  implements pca
{
  public pxl(ComponentHeaderRecommend paramComponentHeaderRecommend) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    ComponentHeaderRecommend.a(this.a).setText(ajyc.a(2131702291));
    ComponentHeaderRecommend.a(this.a).setTextColor(Color.parseColor("#BBBBBB"));
    ComponentHeaderRecommend.a(this.a).setEnabled(false);
    ComponentHeaderRecommend.a(this.a).getPaint().setFakeBoldText(false);
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderRecommend", 2, "followPubAccount() onFollowPublicAccount uin=" + paramString + ", isSuccess=" + paramBoolean);
    }
    ArticleInfo localArticleInfo;
    String str;
    if ((this.a.a.a != null) && (this.a.a.a.a() != null))
    {
      localArticleInfo = this.a.a.a.a();
      str = onk.a(localArticleInfo.mAlgorithmID, onk.a(localArticleInfo), this.a.a.a.e(), 0, 0, bbev.h(this.a.getContext()), ComponentHeaderRecommend.a(this.a) + "", null, localArticleInfo.innerUniqueID, null, localArticleInfo);
      if (!shx.a(this.a.a.a.e())) {
        break label305;
      }
    }
    label305:
    for (paramString = "0X800941D";; paramString = "0X80080EC")
    {
      noo.a(null, ComponentHeaderRecommend.a(this.a) + "", paramString, paramString, 0, 0, String.valueOf(localArticleInfo.mFeedId), String.valueOf(localArticleInfo.mArticleID), Integer.toString(localArticleInfo.mStrategyId), str, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pxl
 * JD-Core Version:    0.7.0.1
 */