import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;

public class rhd
  extends rez
{
  private int jdField_a_of_type_Int;
  private BaseArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo;
  private rhg jdField_a_of_type_Rhg;
  protected boolean b;
  
  public rhd(Activity paramActivity, rhg paramrhg)
  {
    super(paramActivity);
    this.jdField_a_of_type_Rhg = paramrhg;
  }
  
  public View a(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131494413, null);
    paramLayoutInflater.setLayoutParams(new FrameLayout.LayoutParams(-1, aciy.a(60.0F, this.jdField_a_of_type_AndroidAppActivity.getResources())));
    ImageView localImageView = (ImageView)paramLayoutInflater.findViewById(2131302713);
    localImageView.setImageResource(2130841145);
    ((TextView)paramLayoutInflater.findViewById(2131302755)).setVisibility(8);
    ((TextView)paramLayoutInflater.findViewById(2131302759)).setText(ajjy.a(2131648372));
    paramLayoutInflater.findViewById(2131302744).setVisibility(8);
    paramLayoutInflater.findViewById(2131310123).setVisibility(8);
    paramLayoutInflater.setOnClickListener(new rhe(this));
    localImageView.setOnClickListener(new rhf(this));
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
 * Qualified Name:     rhd
 * JD-Core Version:    0.7.0.1
 */