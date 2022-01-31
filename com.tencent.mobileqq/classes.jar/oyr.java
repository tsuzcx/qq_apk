import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;

public class oyr
  extends oyp
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
  
  public oyr(Context paramContext, oye paramoye)
  {
    super(paramContext, paramoye);
  }
  
  public View a(int paramInt, ViewGroup paramViewGroup)
  {
    paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560102, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131367163));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131369128));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131369131));
    this.c = ((TextView)paramViewGroup.findViewById(2131369108));
    this.d = ((TextView)paramViewGroup.findViewById(2131369127));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramViewGroup.findViewById(2131367166));
    this.e = ((TextView)paramViewGroup.findViewById(2131375293));
    this.f = ((TextView)paramViewGroup.findViewById(2131375297));
    this.g = ((TextView)paramViewGroup.findViewById(2131375274));
    this.h = ((TextView)paramViewGroup.findViewById(2131375292));
    paramViewGroup.setTag(this);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyr
 * JD-Core Version:    0.7.0.1
 */