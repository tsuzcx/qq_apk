import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;

public class pdv
  extends pdu
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
  
  public pdv(Context paramContext, pdj parampdj)
  {
    super(paramContext, parampdj);
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560204, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131367293));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131369360));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131369363));
    this.c = ((TextView)paramViewGroup.findViewById(2131369340));
    this.d = ((TextView)paramViewGroup.findViewById(2131369359));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131367296));
    this.e = ((TextView)paramViewGroup.findViewById(2131375775));
    this.f = ((TextView)paramViewGroup.findViewById(2131375779));
    this.g = ((TextView)paramViewGroup.findViewById(2131375756));
    this.h = ((TextView)paramViewGroup.findViewById(2131375774));
    paramViewGroup.setTag(this);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pdv
 * JD-Core Version:    0.7.0.1
 */