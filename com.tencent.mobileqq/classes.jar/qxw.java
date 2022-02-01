import android.os.Looper;
import android.text.TextPaint;
import android.widget.Button;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderUgc;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;

public class qxw
  extends pmn
{
  public qxw(ComponentHeaderUgc paramComponentHeaderUgc) {}
  
  public void b(long paramLong, boolean paramBoolean)
  {
    int i;
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      i = 1;
      if (i != 0) {
        break label32;
      }
      QLog.e("ComponentHeaderUgc", 2, "Please call this method in main thread!!!");
    }
    label32:
    ArticleInfo localArticleInfo;
    do
    {
      return;
      i = 0;
      break;
      if (QLog.isColorLevel()) {
        QLog.d("ComponentHeaderUgc", 2, "onUpdateAfterAccountFollow uin = " + paramLong + " isFollow = " + paramBoolean);
      }
      localArticleInfo = this.a.jdField_a_of_type_Qva.a.a();
    } while (paramLong != localArticleInfo.mSocialFeedInfo.a.a);
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.a.jdField_a_of_type_AndroidWidgetButton.setText(anni.a(2131701099));
      this.a.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(false);
      localArticleInfo.mSocialFeedInfo.h = 2;
      localArticleInfo.isNeedShowBtnWhenFollowed = true;
    }
    for (;;)
    {
      pmk.a().b();
      return;
      this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.a.jdField_a_of_type_AndroidWidgetButton.setText(anni.a(2131701104));
      this.a.jdField_a_of_type_AndroidWidgetButton.getPaint().setFakeBoldText(true);
      localArticleInfo.mSocialFeedInfo.h = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qxw
 * JD-Core Version:    0.7.0.1
 */