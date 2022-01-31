import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.qphone.base.util.QLog;

public class pmt
  implements phu
{
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new pmu(this);
  private View jdField_a_of_type_AndroidViewView;
  private final ProteusItemView jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView;
  private pax jdField_a_of_type_Pax;
  private boolean jdField_a_of_type_Boolean;
  
  public pmt(ProteusItemView paramProteusItemView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView = paramProteusItemView;
    b();
  }
  
  private static float a()
  {
    try
    {
      float f = Float.valueOf((String)bhvh.a("kandian_daily_wrapper_alpha", "1.0")).floatValue();
      if ((f >= 0.0F) && (f <= 1.0F)) {
        return f;
      }
    }
    catch (Exception localException)
    {
      QLog.d("ProteusItemHelper", 1, localException, new Object[] { "" });
    }
    return 1.0F;
  }
  
  private boolean a()
  {
    return false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView.a(this);
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    noo.a(null, "", "0X8009882", "0X8009882", 0, 0, "", "", "", onk.a().b("jump_src", oox.b()).a(), false);
  }
  
  public pax a()
  {
    return this.jdField_a_of_type_Pax;
  }
  
  public void a()
  {
    if (a())
    {
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView.getContext()).inflate(2131559895, null, false);
        localObject = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377211);
        ((TextView)localObject).setTextSize(0, Utils.dp2px(14.0D));
        ((TextView)localObject).setText(rce.a(((TextView)localObject).getContext()));
        f = a();
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130848386);
        this.jdField_a_of_type_AndroidViewView.getBackground().setAlpha((int)(f * 255.0F));
        this.jdField_a_of_type_AndroidViewView.setPadding(0, 0, 0, 0);
        localObject = new RelativeLayout.LayoutParams(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView.getWidth(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView.getHeight());
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView.addView(this.jdField_a_of_type_AndroidViewView, (ViewGroup.LayoutParams)localObject);
        c();
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    }
    while (this.jdField_a_of_type_AndroidViewView == null)
    {
      Object localObject;
      float f;
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusItemProteusItemView.removeView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_AndroidViewView = null;
  }
  
  public void a(pax parampax)
  {
    this.jdField_a_of_type_Pax = parampax;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pmt
 * JD-Core Version:    0.7.0.1
 */