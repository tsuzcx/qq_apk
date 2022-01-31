import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;

public class rtq
  extends rrm
{
  private int jdField_a_of_type_Int;
  private BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private rtt jdField_a_of_type_Rtt;
  protected boolean b;
  
  public rtq(Activity paramActivity, rtt paramrtt)
  {
    super(paramActivity);
    this.jdField_a_of_type_Rtt = paramrtt;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559983, null);
    paramLayoutInflater.setLayoutParams(new FrameLayout.LayoutParams(-1, actj.a(60.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())));
    ImageView localImageView = (ImageView)paramLayoutInflater.findViewById(2131368335);
    localImageView.setImageResource(2130841220);
    ((TextView)paramLayoutInflater.findViewById(2131368379)).setVisibility(8);
    ((TextView)paramLayoutInflater.findViewById(2131368383)).setText(ajya.a(2131714171));
    paramLayoutInflater.findViewById(2131368368).setVisibility(8);
    paramLayoutInflater.findViewById(2131375889).setVisibility(8);
    paramLayoutInflater.setOnClickListener(new rtr(this));
    localImageView.setOnClickListener(new rts(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rtq
 * JD-Core Version:    0.7.0.1
 */