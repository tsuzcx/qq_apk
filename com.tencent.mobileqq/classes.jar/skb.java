import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoySelectPositionHeader;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

public class skb
  implements View.OnClickListener
{
  public skb(ReadInJoySelectPositionHeader paramReadInJoySelectPositionHeader, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    paramView = owy.a().a();
    SelectPositionModule.PositionData localPositionData;
    if (paramView != null)
    {
      localPositionData = paramView.b();
      if (!paramView.a(localPositionData)) {
        break label53;
      }
      paramView.b(localPositionData);
      if (ReadInJoySelectPositionHeader.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoySelectPositionHeader) != null) {
        ReadInJoySelectPositionHeader.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoySelectPositionHeader).a(localPositionData);
      }
    }
    label53:
    do
    {
      return;
      if (localPositionData != null) {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, String.format("你当前在%s，暂无本地频道。", new Object[] { localPositionData.cityGPS }), 0).a();
      }
    } while (!QLog.isColorLevel());
    QLog.i("ReadInJoySelectPositionHeader", 2, "onClick not in city white list gpsPosition = " + localPositionData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     skb
 * JD-Core Version:    0.7.0.1
 */