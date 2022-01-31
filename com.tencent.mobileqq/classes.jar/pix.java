import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnSocialHeaderFollowClickListener.1.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class pix
  implements pbx
{
  pix(piw parampiw) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    QLog.d("OnSocialHeaderFollowClickListener", 2, "978 resp, result : " + paramBoolean + ", data : " + paramInt + ", distUin : " + paramString);
    if ((paramBoolean) && (paramInt == 2))
    {
      String str;
      if ((piw.a(this.a) != null) && (piw.a(this.a).mSocialFeedInfo != null))
      {
        osg.a().b(piw.a(piw.a(this.a)), paramInt);
        str = onh.a(piw.a(this.a).mAlgorithmID, onh.a(piw.a(this.a)), (int)piw.a(this.a).mChannelID, 0, 0, bbfj.h(piw.a(this.a)), piw.a(piw.a(this.a)) + "", null, piw.a(this.a).innerUniqueID, null, piw.a(this.a));
        if (!shu.a(piw.a(this.a).mChannelID)) {
          break label300;
        }
      }
      label300:
      for (paramString = "0X800941D";; paramString = "0X80080EC")
      {
        nol.a(null, piw.a(piw.a(this.a)) + "", paramString, paramString, 0, 0, String.valueOf(piw.a(this.a).mFeedId), String.valueOf(piw.a(this.a).mArticleID), Integer.toString(piw.a(this.a).mStrategyId), str, false);
        ThreadManager.getUIHandler().post(new OnSocialHeaderFollowClickListener.1.1(this));
        return;
      }
    }
    bcql.a(piw.a(this.a), ajya.a(2131707854), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pix
 * JD-Core Version:    0.7.0.1
 */