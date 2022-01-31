import android.graphics.Color;
import android.text.TextPaint;
import android.widget.Button;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderRecommend;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;

public class qec
  implements phj
{
  public qec(ComponentHeaderRecommend paramComponentHeaderRecommend) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    ComponentHeaderRecommend.a(this.a).setText(alpo.a(2131702674));
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
      str = ors.a(localArticleInfo.mAlgorithmID, ors.a(localArticleInfo), this.a.a.a.e(), 0, 0, bdee.h(this.a.getContext()), ComponentHeaderRecommend.a(this.a) + "", null, localArticleInfo.innerUniqueID, null, localArticleInfo);
      if (!szp.a(this.a.a.a.e())) {
        break label305;
      }
    }
    label305:
    for (paramString = "0X800941D";; paramString = "0X80080EC")
    {
      nrt.a(null, ComponentHeaderRecommend.a(this.a) + "", paramString, paramString, 0, 0, String.valueOf(localArticleInfo.mFeedId), String.valueOf(localArticleInfo.mArticleID), Integer.toString(localArticleInfo.mStrategyId), str, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qec
 * JD-Core Version:    0.7.0.1
 */