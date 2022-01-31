import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPolymeric;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPolymericView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;

public class phh
  extends pez
{
  private static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = phh.class.getSimpleName();
  }
  
  public phh(Context paramContext, azwg paramazwg, qoe paramqoe)
  {
    super(paramContext, paramazwg, paramqoe);
  }
  
  private void a(LinearLayout paramLinearLayout, opw paramopw)
  {
    if (paramopw.e() == 56)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.setDividerWidth(aciy.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.setPadding(azvv.a(this.jdField_a_of_type_AndroidContentContext, 6.0F), 0, azvv.a(this.jdField_a_of_type_AndroidContentContext, 6.0F), azvv.a(this.jdField_a_of_type_AndroidContentContext, 15.0F));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.setClipToPadding(false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.setClipChildren(false);
      paramLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.setDividerWidth(aciy.a(1.5F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.setPadding(azvv.a(this.jdField_a_of_type_AndroidContentContext, 6.0F), azvv.a(this.jdField_a_of_type_AndroidContentContext, 8.0F), azvv.a(this.jdField_a_of_type_AndroidContentContext, 12.0F), azvv.a(this.jdField_a_of_type_AndroidContentContext, 8.0F));
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 9) || (paramInt == 10) || (paramInt == 11);
  }
  
  private void b(View paramView)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof ReadInJoyNewFeedsActivity)) {}
    for (;;)
    {
      return;
      if (bgmq.i()) {
        try
        {
          ReadinjoyTabFrame localReadinjoyTabFrame = (ReadinjoyTabFrame)FrameHelperActivity.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext).a(ReadinjoyTabFrame.class);
          if (localReadinjoyTabFrame != null)
          {
            localReadinjoyTabFrame.a(paramView);
            return;
          }
        }
        catch (Exception paramView)
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "readinjoy tab add dispatch touch event view fail ! e : " + paramView);
          paramView.printStackTrace();
        }
      }
    }
  }
  
  public pez a()
  {
    this.jdField_a_of_type_Boolean = true;
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof opw)) && (((opw)this.jdField_a_of_type_JavaLangObject).e() == 56))
    {
      if (((opw)this.jdField_a_of_type_JavaLangObject).b() == 53) {
        return b(this.jdField_a_of_type_Qoe, this.jdField_a_of_type_Azwg).u().n();
      }
      return b(this.jdField_a_of_type_Qoe, this.jdField_a_of_type_Azwg).u().n().l().m();
    }
    return b(this.jdField_a_of_type_Qoe, this.jdField_a_of_type_Azwg).u().n().l();
  }
  
  public pez d()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new Exception("buildComponent() must after buildComponent()!");
    }
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric != null) {
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric);
    }
    Object localObject;
    if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof opw)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView != null))
    {
      localObject = ((opw)this.jdField_a_of_type_JavaLangObject).a();
      if ((((ArticleInfo)localObject).mPolymericInfo == null) || (!a(((ArticleInfo)localObject).mPolymericInfo.a))) {
        break label193;
      }
      a(localLinearLayout, (opw)this.jdField_a_of_type_JavaLangObject);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider != null) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentDivider);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead != null) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentLastRead);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace != null) {
        localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentWhiteSpace);
      }
      a(localLinearLayout);
      b(a());
      return this;
      label193:
      localObject = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject).leftMargin = azvv.a(this.jdField_a_of_type_AndroidContentContext, 12.0F);
      ((LinearLayout.LayoutParams)localObject).bottomMargin = azvv.a(this.jdField_a_of_type_AndroidContentContext, 20.0F);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.setDividerWidth(aciy.a(3.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localLinearLayout.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView, (ViewGroup.LayoutParams)localObject);
    }
  }
  
  public pez e()
  {
    return this;
  }
  
  public pez o()
  {
    super.o();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric.a(this.jdField_a_of_type_JavaLangObject);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentPolymericView.a(this.jdField_a_of_type_JavaLangObject);
    }
    return this;
  }
  
  public pez p()
  {
    super.p();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderPolymeric.a(this.jdField_a_of_type_Pfh);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     phh
 * JD-Core Version:    0.7.0.1
 */