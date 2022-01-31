import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialHeaderFollowClickListener.1.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class oxi
  implements oqy
{
  oxi(oxh paramoxh) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    QLog.d("OnSocialHeaderFollowClickListener", 2, "978 resp, result : " + paramBoolean + ", data : " + paramInt + ", distUin : " + paramString);
    if ((paramBoolean) && (paramInt == 2))
    {
      String str;
      if ((oxh.a(this.a) != null) && (oxh.a(this.a).mSocialFeedInfo != null))
      {
        ogy.a().b(oxh.a(oxh.a(this.a)), paramInt);
        str = obz.a(oxh.a(this.a).mAlgorithmID, obz.a(oxh.a(this.a)), (int)oxh.a(this.a).mChannelID, 0, 0, badq.h(oxh.a(this.a)), oxh.a(oxh.a(this.a)) + "", null, oxh.a(this.a).innerUniqueID, null, oxh.a(this.a));
        if (!rvf.a(oxh.a(this.a).mChannelID)) {
          break label300;
        }
      }
      label300:
      for (paramString = "0X800941D";; paramString = "0X80080EC")
      {
        ndn.a(null, oxh.a(oxh.a(this.a)) + "", paramString, paramString, 0, 0, String.valueOf(oxh.a(this.a).mFeedId), String.valueOf(oxh.a(this.a).mArticleID), Integer.toString(oxh.a(this.a).mStrategyId), str, false);
        ThreadManager.getUIHandler().post(new OnSocialHeaderFollowClickListener.1.1(this));
        return;
      }
    }
    bbmy.a(oxh.a(this.a), ajjy.a(2131642058), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oxi
 * JD-Core Version:    0.7.0.1
 */