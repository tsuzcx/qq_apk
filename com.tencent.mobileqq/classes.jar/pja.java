import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialHeaderFollowClickListener.1.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class pja
  implements pca
{
  pja(piz parampiz) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    QLog.d("OnSocialHeaderFollowClickListener", 2, "978 resp, result : " + paramBoolean + ", data : " + paramInt + ", distUin : " + paramString);
    if ((paramBoolean) && (paramInt == 2))
    {
      String str;
      if ((piz.a(this.a) != null) && (piz.a(this.a).mSocialFeedInfo != null))
      {
        osj.a().b(piz.a(piz.a(this.a)), paramInt);
        str = onk.a(piz.a(this.a).mAlgorithmID, onk.a(piz.a(this.a)), (int)piz.a(this.a).mChannelID, 0, 0, bbev.h(piz.a(this.a)), piz.a(piz.a(this.a)) + "", null, piz.a(this.a).innerUniqueID, null, piz.a(this.a));
        if (!shx.a(piz.a(this.a).mChannelID)) {
          break label300;
        }
      }
      label300:
      for (paramString = "0X800941D";; paramString = "0X80080EC")
      {
        noo.a(null, piz.a(piz.a(this.a)) + "", paramString, paramString, 0, 0, String.valueOf(piz.a(this.a).mFeedId), String.valueOf(piz.a(this.a).mArticleID), Integer.toString(piz.a(this.a).mStrategyId), str, false);
        ThreadManager.getUIHandler().post(new OnSocialHeaderFollowClickListener.1.1(this));
        return;
      }
    }
    bcpw.a(piz.a(this.a), ajyc.a(2131707843), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pja
 * JD-Core Version:    0.7.0.1
 */