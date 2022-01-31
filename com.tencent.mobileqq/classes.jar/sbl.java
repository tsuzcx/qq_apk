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

public class sbl
  extends sah
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
  
  public sbl(View paramView, BaseData paramBaseData)
  {
    super(paramView, paramBaseData);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378985));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378587));
    this.d = ((TextView)paramView.findViewById(2131378602));
    this.c = ((TextView)paramView.findViewById(2131378601));
    this.e = ((TextView)paramView.findViewById(2131378603));
    this.f = ((TextView)paramView.findViewById(2131378747));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131368691));
    this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView = ((KandianUrlImageView)paramView.findViewById(2131368794));
    paramView.findViewById(2131375860).setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewKandianUrlImageView.setRound(true);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131369632));
    paramBaseData = syo.a(null, aekt.a(12.0F, paramView.getResources()), Color.parseColor("#e9ebec"));
    paramView = syo.a(null, aekt.a(12.0F, paramView.getResources()), Color.parseColor("#12B7F5"));
    syo.a(this.jdField_a_of_type_AndroidWidgetLinearLayout, paramView, paramBaseData);
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
      this.f.setText(alpo.a(2131717267));
      this.f.setTextColor(-4473925);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setEnabled(false);
      return;
    }
    this.f.setText(alpo.a(2131717268));
    this.f.setTextColor(-1);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setEnabled(true);
  }
  
  private void b()
  {
    Object localObject;
    phg localphg;
    long l;
    sbm localsbm;
    if (!this.jdField_a_of_type_Boolean)
    {
      a(true);
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localphg = owy.a().a();
      localObject = ((QQAppInterface)localObject).getAccount();
      l = a();
      localsbm = new sbm(this);
      if (!rqj.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataBaseData.b)) {
        break label81;
      }
    }
    label81:
    for (int i = 2;; i = 1)
    {
      localphg.a((String)localObject, l, true, localsbm, i);
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
    case 2131369632: 
    case 2131378747: 
      b();
      return;
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sbl
 * JD-Core Version:    0.7.0.1
 */