import android.graphics.Color;
import android.text.TextPaint;
import android.widget.Button;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderRecommend;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class rig
  implements qie
{
  public rig(ComponentHeaderRecommend paramComponentHeaderRecommend) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    ComponentHeaderRecommend.a(this.a).setText(anvx.a(2131701799));
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
      str = pqf.a(localArticleInfo.mAlgorithmID, pqw.a(localArticleInfo), this.a.a.a.e(), 0, 0, NetworkUtil.isWifiConnected(this.a.getContext()), ComponentHeaderRecommend.a(this.a) + "", null, localArticleInfo.innerUniqueID, null, localArticleInfo);
      if (!uvs.a(this.a.a.a.e())) {
        break label305;
      }
    }
    label305:
    for (paramString = "0X800941D";; paramString = "0X80080EC")
    {
      olh.a(null, ComponentHeaderRecommend.a(this.a) + "", paramString, paramString, 0, 0, String.valueOf(localArticleInfo.mFeedId), String.valueOf(localArticleInfo.mArticleID), Integer.toString(localArticleInfo.mStrategyId), str, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rig
 * JD-Core Version:    0.7.0.1
 */