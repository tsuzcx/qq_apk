import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;

public class sxn
  extends sxl
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
  
  public sxn(Context paramContext, qdc paramqdc)
  {
    super(paramContext, paramqdc);
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560426, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131367847));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370029));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131370034));
    this.c = ((TextView)paramViewGroup.findViewById(2131370005));
    this.d = ((TextView)paramViewGroup.findViewById(2131370028));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131367849));
    this.e = ((TextView)paramViewGroup.findViewById(2131376711));
    this.f = ((TextView)paramViewGroup.findViewById(2131376717));
    this.g = ((TextView)paramViewGroup.findViewById(2131376690));
    this.h = ((TextView)paramViewGroup.findViewById(2131376710));
    paramViewGroup.setTag(this);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sxn
 * JD-Core Version:    0.7.0.1
 */