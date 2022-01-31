import android.view.View;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentGridImage;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;

public class pvj
  implements bfpt
{
  public pvj(ComponentContentGridImage paramComponentContentGridImage) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((ComponentContentGridImage.a(this.a) == 62) || (ComponentContentGridImage.a(this.a) == 63) || (ComponentContentGridImage.a(this.a) == 64) || (ComponentContentGridImage.a(this.a) == 65))
    {
      if (ComponentContentGridImage.a(this.a) != null) {
        ComponentContentGridImage.a(this.a).a(paramInt);
      }
      return;
    }
    if ((Aladdin.getConfig(192).getIntegerFromString("picture_click_jumptype", 0) == 1) && (((pbf)this.a.a).a().mSocialFeedInfo != null) && (((pbf)this.a.a).a().mSocialFeedInfo.jdField_a_of_type_Qcv != null) && (((pbf)this.a.a).a().mSocialFeedInfo.jdField_a_of_type_Qcv.a) && (((pbf)this.a.a).a().mSocialFeedInfo.jdField_a_of_type_Qco != null)) {
      try
      {
        onh.a(this.a.getContext(), ((pbf)this.a.a).a().mSocialFeedInfo.jdField_a_of_type_Qco.a.c, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pvj
 * JD-Core Version:    0.7.0.1
 */