import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupTips.1;
import com.tencent.biz.pubaccount.readinjoy.redpacket.widget.RIJRedPacketPopupView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class qhj
  extends PopupWindow
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int = 17;
  private RIJRedPacketPopupView jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView = (RIJRedPacketPopupView)getContentView();
  private boolean jdField_a_of_type_Boolean = true;
  private int b;
  
  public qhj(Context paramContext)
  {
    super(new RIJRedPacketPopupView(paramContext), -2, -2);
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.b(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.a(false);
    setAnimationStyle(2131755822);
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.setText(paramString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.b(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.a(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.setOnCloseIconClickListener(this);
    setAnimationStyle(2131755823);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public boolean isShowing()
  {
    return super.isShowing();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    dismiss();
  }
  
  public void showAsDropDown(View paramView)
  {
    showAsDropDown(paramView, 0, 0);
  }
  
  public void showAsDropDown(View paramView, int paramInt1, int paramInt2)
  {
    int i = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.measure(0, 0);
    if (this.jdField_a_of_type_Int == 17) {
      i = (-this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.getMeasuredWidth() + paramView.getWidth()) / 2;
    }
    for (;;)
    {
      super.showAsDropDown(paramView, i + paramInt1, paramInt2);
      if (this.jdField_a_of_type_Boolean) {
        ThreadManager.getUIHandler().postDelayed(new RIJRedPacketPopupTips.1(this), this.b);
      }
      return;
      if (this.jdField_a_of_type_Int == 3) {
        i = -this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRedpacketWidgetRIJRedPacketPopupView.getMeasuredWidth() + paramView.getWidth();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qhj
 * JD-Core Version:    0.7.0.1
 */