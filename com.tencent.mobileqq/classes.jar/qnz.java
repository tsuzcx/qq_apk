import android.view.View;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;

public class qnz
  implements bljm
{
  public qnz(ComponentContentGridImage paramComponentContentGridImage) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((ComponentContentGridImage.a(this.a) == 62) || (ComponentContentGridImage.a(this.a) == 63) || (ComponentContentGridImage.a(this.a) == 64) || (ComponentContentGridImage.a(this.a) == 65))
    {
      if (ComponentContentGridImage.a(this.a) != null) {
        ComponentContentGridImage.a(this.a).a(paramInt);
      }
      return;
    }
    if ((Aladdin.getConfig(192).getIntegerFromString("picture_click_jumptype", 0) == 1) && (((pqk)this.a.a).a().mSocialFeedInfo != null) && (((pqk)this.a.a).a().mSocialFeedInfo.jdField_a_of_type_Qyg != null) && (((pqk)this.a.a).a().mSocialFeedInfo.jdField_a_of_type_Qyg.a) && (((pqk)this.a.a).a().mSocialFeedInfo.jdField_a_of_type_Qxz != null)) {
      try
      {
        ozs.a(this.a.getContext(), ((pqk)this.a.a).a().mSocialFeedInfo.jdField_a_of_type_Qxz.a.c, null);
        return;
      }
      catch (Exception paramAdapterView)
      {
        QLog.e("ComponentContentGridImage", 1, paramAdapterView.getLocalizedMessage());
        return;
      }
    }
    ComponentContentGridImage.a(this.a, paramInt, ComponentContentGridImage.a(this.a).a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qnz
 * JD-Core Version:    0.7.0.1
 */