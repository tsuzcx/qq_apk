import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUGCVoice;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCVoiceInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qph
  implements View.OnClickListener
{
  public qph(ComponentContentUGCVoice paramComponentContentUGCVoice) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if ((ComponentContentUGCVoice.a(this.a) != null) && (!TextUtils.isEmpty(ComponentContentUGCVoice.a(this.a).jdField_a_of_type_JavaLangString))) {
      if (ComponentContentUGCVoice.a(this.a).jdField_a_of_type_Boolean)
      {
        ocd.a(null, "", "0X8009CA4", "0X8009CA4", 0, 0, localQQAppInterface.getCurrentAccountUin(), ComponentContentUGCVoice.a(this.a).mFeedId + "", "2", "", false);
        rky.a().a();
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ocd.a(null, "", "0X8009CA4", "0X8009CA4", 0, 0, localQQAppInterface.getCurrentAccountUin(), ComponentContentUGCVoice.a(this.a).mFeedId + "", "1", "", false);
      rky.a().a(this.a, ComponentContentUGCVoice.a(this.a));
      continue;
      if (QLog.isColorLevel()) {
        QLog.d(ComponentContentUGCVoice.jdField_a_of_type_JavaLangString, 2, "mUGCVoiceInfo or its voiceUrl is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qph
 * JD-Core Version:    0.7.0.1
 */