import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;

public class pne
  extends pnd
{
  public TextView a;
  public BaseArticleInfo a;
  public KandianUrlImageView a;
  public TextView b;
  public BaseArticleInfo b;
  public KandianUrlImageView b;
  public TextView c;
  public TextView d;
  public TextView e;
  public TextView f;
  public TextView g;
  public TextView h;
  
  public pne(Context paramContext, pms parampms)
  {
    super(paramContext, parampms);
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560368, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131367679));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131369867));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131369871));
    this.c = ((TextView)paramViewGroup.findViewById(2131369845));
    this.d = ((TextView)paramViewGroup.findViewById(2131369866));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131367681));
    this.e = ((TextView)paramViewGroup.findViewById(2131376689));
    this.f = ((TextView)paramViewGroup.findViewById(2131376695));
    this.g = ((TextView)paramViewGroup.findViewById(2131376669));
    this.h = ((TextView)paramViewGroup.findViewById(2131376688));
    paramViewGroup.setTag(this);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pne
 * JD-Core Version:    0.7.0.1
 */