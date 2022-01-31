import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialHeaderFollowClickListener.1.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class ppi
  implements phj
{
  ppi(pph parampph) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    QLog.d("OnSocialHeaderFollowClickListener", 2, "978 resp, result : " + paramBoolean + ", data : " + paramInt + ", distUin : " + paramString);
    if ((paramBoolean) && (paramInt == 2))
    {
      String str;
      if ((pph.a(this.a) != null) && (pph.a(this.a).mSocialFeedInfo != null))
      {
        owy.a().b(pph.a(pph.a(this.a)), paramInt);
        str = ors.a(pph.a(this.a).mAlgorithmID, ors.a(pph.a(this.a)), (int)pph.a(this.a).mChannelID, 0, 0, bdin.h(pph.a(this.a)), pph.a(pph.a(this.a)) + "", null, pph.a(this.a).innerUniqueID, null, pph.a(this.a));
        if (!szp.a(pph.a(this.a).mChannelID)) {
          break label300;
        }
      }
      label300:
      for (paramString = "0X800941D";; paramString = "0X80080EC")
      {
        nrt.a(null, pph.a(pph.a(this.a)) + "", paramString, paramString, 0, 0, String.valueOf(pph.a(this.a).mFeedId), String.valueOf(pph.a(this.a).mArticleID), Integer.toString(pph.a(this.a).mStrategyId), str, false);
        ThreadManager.getUIHandler().post(new OnSocialHeaderFollowClickListener.1.1(this));
        return;
      }
    }
    QQToast.a(pph.a(this.a), alud.a(2131708238), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ppi
 * JD-Core Version:    0.7.0.1
 */