import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoySelectPositionHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class tdm
  implements View.OnClickListener
{
  public tdm(ReadInJoySelectPositionHeader paramReadInJoySelectPositionHeader, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    SelectPositionModule localSelectPositionModule = pkm.a().a();
    SelectPositionModule.PositionData localPositionData;
    if (localSelectPositionModule != null)
    {
      localPositionData = localSelectPositionModule.b();
      if (!localSelectPositionModule.a(localPositionData)) {
        break label60;
      }
      localSelectPositionModule.b(localPositionData);
      if (ReadInJoySelectPositionHeader.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoySelectPositionHeader) != null) {
        ReadInJoySelectPositionHeader.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoySelectPositionHeader).a(localPositionData);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label60:
      if (localPositionData != null) {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, String.format("你当前在%s，暂无本地频道。", new Object[] { localPositionData.cityGPS }), 0).a();
      }
      if (QLog.isColorLevel()) {
        QLog.i("ReadInJoySelectPositionHeader", 2, "onClick not in city white list gpsPosition = " + localPositionData);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tdm
 * JD-Core Version:    0.7.0.1
 */