import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;

public class rlq
  extends rkj
  implements View.OnClickListener
{
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private boolean jdField_a_of_type_Boolean;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private KandianUrlImageView jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  
  public rlq(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378378));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378036));
    this.d = ((TextView)paramView.findViewById(2131378049));
    this.c = ((TextView)paramView.findViewById(2131378048));
    this.e = ((TextView)paramView.findViewById(2131378050));
    this.f = ((TextView)paramView.findViewById(2131378179));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131368501));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131368596));
    paramView.findViewById(2131375373).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setRound(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369386));
    paramBaseData = sgw.a(null, actn.a(12.0F, paramView.getResources()), Color.parseColor("#e9ebec"));
    paramView = sgw.a(null, actn.a(12.0F, paramView.getResources()), Color.parseColor("#12B7F5"));
    sgw.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, paramView, paramBaseData);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this);
  }
  
  private long a()
  {
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b.mSubscribeID);
      return l;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
      return 0L;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.f.setOnClickListener(this);
    if (paramBoolean)
    {
      this.f.setText(ajyc.a(2131716884));
      this.f.setTextColor(-4473925);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setEnabled(false);
      return;
    }
    this.f.setText(ajyc.a(2131716885));
    this.f.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setEnabled(true);
  }
  
  private void b()
  {
    Object localObject;
    pbx localpbx;
    long l;
    rlr localrlr;
    if (!this.jdField_a_of_type_Boolean)
    {
      a(true);
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localpbx = osj.a().a();
      localObject = ((QQAppInterface)localObject).getAccount();
      l = a();
      localrlr = new rlr(this);
      if (!rap.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b)) {
        break label81;
      }
    }
    label81:
    for (int i = 2;; i = 1)
    {
      localpbx.a((String)localObject, l, true, localrlr, i);
      return;
    }
  }
  
  private void c() {}
  
  public void a(BaseData paramBaseData1, BaseData paramBaseData2, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131369386: 
    case 2131378179: 
      b();
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rlq
 * JD-Core Version:    0.7.0.1
 */