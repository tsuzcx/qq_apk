import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class tdo
  extends tbk
{
  private int jdField_a_of_type_Int;
  private BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private tdr jdField_a_of_type_Tdr;
  protected boolean b;
  
  public tdo(Activity paramActivity, tdr paramtdr)
  {
    super(paramActivity);
    this.jdField_a_of_type_Tdr = paramtdr;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560243, null);
    paramLayoutInflater.setLayoutParams(new FrameLayout.LayoutParams(-1, AIOUtils.dp2px(60.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())));
    ImageView localImageView = (ImageView)paramLayoutInflater.findViewById(2131368939);
    localImageView.setImageResource(2130841691);
    ((TextView)paramLayoutInflater.findViewById(2131369015)).setVisibility(8);
    ((TextView)paramLayoutInflater.findViewById(2131369019)).setText(amtj.a(2131713264));
    paramLayoutInflater.findViewById(2131369003).setVisibility(8);
    paramLayoutInflater.findViewById(2131377134).setVisibility(8);
    paramLayoutInflater.setOnClickListener(new tdp(this));
    localImageView.setOnClickListener(new tdq(this));
    return paramLayoutInflater;
  }
  
  public void a(View paramView, BaseArticleInfo paramBaseArticleInfo, int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo = paramBaseArticleInfo;
    this.jdField_a_of_type_Int = paramInt;
    if (!this.b)
    {
      a();
      this.b = true;
    }
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tdo
 * JD-Core Version:    0.7.0.1
 */