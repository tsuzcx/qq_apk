import android.graphics.Color;
import android.text.TextPaint;
import android.widget.Button;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.CmpCtxt;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderRecommend;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.PublicAccountObserver;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class lvv
  extends PublicAccountObserver
{
  public lvv(ComponentHeaderRecommend paramComponentHeaderRecommend) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    ComponentHeaderRecommend.a(this.a).setText("已关注");
    ComponentHeaderRecommend.a(this.a).setTextColor(Color.parseColor("#BBBBBB"));
    ComponentHeaderRecommend.a(this.a).setEnabled(false);
    ComponentHeaderRecommend.a(this.a).getPaint().setFakeBoldText(false);
    if (QLog.isColorLevel()) {
      QLog.d("ComponentHeaderRecommend", 2, "followPubAccount() onFollowPublicAccount uin=" + paramString + ", isSuccess=" + paramBoolean);
    }
    if ((this.a.a.a != null) && (this.a.a.a.a() != null))
    {
      paramString = this.a.a.a.a();
      String str = ReadInJoyUtils.a(paramString.mAlgorithmID, ReadInJoyUtils.a(paramString), this.a.a.a.e(), 0, 0, NetworkUtil.h(this.a.getContext()), ComponentHeaderRecommend.a(this.a) + "", null, paramString.innerUniqueID, null, paramString);
      PublicAccountReportUtils.a(null, ComponentHeaderRecommend.a(this.a) + "", "0X80080EC", "0X80080EC", 0, 0, String.valueOf(paramString.mFeedId), String.valueOf(paramString.mArticleID), Integer.toString(paramString.mStrategyId), str, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lvv
 * JD-Core Version:    0.7.0.1
 */