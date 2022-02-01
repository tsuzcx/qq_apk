import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;

public class szo
  extends sxk
{
  private int jdField_a_of_type_Int;
  private BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private szr jdField_a_of_type_Szr;
  protected boolean b;
  
  public szo(Activity paramActivity, szr paramszr)
  {
    super(paramActivity);
    this.jdField_a_of_type_Szr = paramszr;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560236, null);
    paramLayoutInflater.setLayoutParams(new FrameLayout.LayoutParams(-1, agej.a(60.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())));
    ImageView localImageView = (ImageView)paramLayoutInflater.findViewById(2131368913);
    localImageView.setImageResource(2130841655);
    ((TextView)paramLayoutInflater.findViewById(2131368989)).setVisibility(8);
    ((TextView)paramLayoutInflater.findViewById(2131368993)).setText(anzj.a(2131713032));
    paramLayoutInflater.findViewById(2131368977).setVisibility(8);
    paramLayoutInflater.findViewById(2131377371).setVisibility(8);
    paramLayoutInflater.setOnClickListener(new szp(this));
    localImageView.setOnClickListener(new szq(this));
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
 * Qualified Name:     szo
 * JD-Core Version:    0.7.0.1
 */