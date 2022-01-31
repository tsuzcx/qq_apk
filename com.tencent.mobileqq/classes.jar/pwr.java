import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUGCVoice;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVoiceInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class pwr
  implements View.OnClickListener
{
  public pwr(ComponentContentUGCVoice paramComponentContentUGCVoice) {}
  
  public void onClick(View paramView)
  {
    paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((ComponentContentUGCVoice.a(this.a) != null) && (!TextUtils.isEmpty(ComponentContentUGCVoice.a(this.a).jdField_a_of_type_JavaLangString))) {
      if (ComponentContentUGCVoice.a(this.a).jdField_a_of_type_Boolean)
      {
        nol.a(null, "", "0X8009CA4", "0X8009CA4", 0, 0, paramView.getCurrentAccountUin(), ComponentContentUGCVoice.a(this.a).mFeedId + "", "2", "", false);
        qiw.a().a();
      }
    }
    while (!QLog.isColorLevel())
    {
      return;
      if (qnl.a().a())
      {
        bcql.a(this.a.getContext(), ajya.a(2131702294), 0).a();
        return;
      }
      nol.a(null, "", "0X8009CA4", "0X8009CA4", 0, 0, paramView.getCurrentAccountUin(), ComponentContentUGCVoice.a(this.a).mFeedId + "", "1", "", false);
      qiw.a().a(this.a, ComponentContentUGCVoice.a(this.a));
      return;
    }
    QLog.d(ComponentContentUGCVoice.jdField_a_of_type_JavaLangString, 2, "mUGCVoiceInfo or its voiceUrl is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pwr
 * JD-Core Version:    0.7.0.1
 */