import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;

public class skd
  extends shz
{
  private int jdField_a_of_type_Int;
  private BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private skg jdField_a_of_type_Skg;
  protected boolean b;
  
  public skd(Activity paramActivity, skg paramskg)
  {
    super(paramActivity);
    this.jdField_a_of_type_Skg = paramskg;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560082, null);
    paramLayoutInflater.setLayoutParams(new FrameLayout.LayoutParams(-1, aekt.a(60.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())));
    ImageView localImageView = (ImageView)paramLayoutInflater.findViewById(2131368507);
    localImageView.setImageResource(2130841340);
    ((TextView)paramLayoutInflater.findViewById(2131368562)).setVisibility(8);
    ((TextView)paramLayoutInflater.findViewById(2131368566)).setText(alpo.a(2131714543));
    paramLayoutInflater.findViewById(2131368551).setVisibility(8);
    paramLayoutInflater.findViewById(2131376388).setVisibility(8);
    paramLayoutInflater.setOnClickListener(new ske(this));
    localImageView.setOnClickListener(new skf(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     skd
 * JD-Core Version:    0.7.0.1
 */