import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.RainView;
import com.tencent.qphone.base.util.QLog;

public class okb
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private RainView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView;
  private okd jdField_a_of_type_Okd;
  private boolean jdField_a_of_type_Boolean = true;
  
  public okb(ViewGroup paramViewGroup, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Okd = new okd(this);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyRainAnimationController", 2, "rain animation show");
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup.findViewWithTag("ReadInJoyRainAnimationController") == null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView = new RainView(this.jdField_a_of_type_AndroidContentContext);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localLayoutParams.gravity = 48;
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView, localLayoutParams);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView.setTag("ReadInJoyRainAnimationController");
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView.setAnimationEndListener(new okc(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView.a(this.jdField_a_of_type_AndroidViewViewGroup.getWidth(), this.jdField_a_of_type_AndroidViewViewGroup.getTop(), this.jdField_a_of_type_AndroidViewViewGroup.getBottom(), paramString);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup.findViewWithTag("ReadInJoyRainAnimationController") != null;
  }
  
  public void b()
  {
    if ((a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyRainAnimationController", 2, "rain animation hide");
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView.n();
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewRainView);
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     okb
 * JD-Core Version:    0.7.0.1
 */