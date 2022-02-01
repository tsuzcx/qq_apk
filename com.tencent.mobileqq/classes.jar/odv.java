import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.AccountDetail.view.AccountDetailTopGestureLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class odv
  implements View.OnClickListener
{
  protected float a;
  int jdField_a_of_type_Int = 0;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  Button jdField_a_of_type_AndroidWidgetButton;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  protected AccountDetailTopGestureLayout a;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private AccountDetail jdField_a_of_type_ComTencentMobileqqDataAccountDetail;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  public ImageView b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  public ImageView c;
  ImageView d;
  protected ImageView e;
  
  public odv(BaseActivity paramBaseActivity, View.OnClickListener paramOnClickListener, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_b_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_Float = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics().density;
    b();
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131361923));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131361922));
    this.jdField_a_of_type_AndroidWidgetTextView.setSingleLine();
    this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
  }
  
  private boolean a()
  {
    return Build.VERSION.SDK_INT < 19;
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131370073));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
    int j;
    if (a()) {
      j = (int)(64.0F * this.jdField_a_of_type_Float);
    }
    for (int i = (int)(4.0F * this.jdField_a_of_type_Float);; i = (int)(25.0F * this.jdField_a_of_type_Float))
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, j);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding(0, i, 0, 0);
      this.jdField_a_of_type_Int = j;
      if (this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailViewAccountDetailTopGestureLayout.setTitleHeight(this.jdField_a_of_type_Int);
      }
      this.d = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131370072));
      this.d.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131369262));
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      this.e = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131369245));
      this.e.setImageResource(2130843770);
      this.e.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697263));
      this.e.setVisibility(0);
      this.e.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368423));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131368394));
      this.c = ((ImageView)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131364435));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131361891));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.d.setImageResource(2130850116);
      this.e.setImageResource(2130842506);
      return;
      j = (int)(75.0F * this.jdField_a_of_type_Float);
    }
  }
  
  public void a(AccountDetail paramAccountDetail)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail = paramAccountDetail;
    this.jdField_a_of_type_AndroidViewViewGroup.removeAllViews();
    if (this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail == null) {}
    Object localObject;
    do
    {
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(FaceDrawable.getFaceDrawable(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, 1, this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.uin));
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.c.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name);
      paramAccountDetail = new Paint();
      paramAccountDetail.setTextSize(this.jdField_a_of_type_AndroidWidgetTextView.getTextSize());
      localObject = this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).width = ((int)((int)paramAccountDetail.measureText(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.name) + 4.0F * this.jdField_a_of_type_Float));
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramAccountDetail = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      String str = this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedDescription;
      if ((!TextUtils.isEmpty(str)) && (str.contains(":")))
      {
        int i = str.indexOf(":");
        localObject = str.substring(0, i);
        if (str.length() > i + 1)
        {
          str = str.substring(i + 1);
          this.jdField_a_of_type_AndroidViewViewGroup.addView(new odw(paramAccountDetail, null, (String)localObject, str).a());
        }
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary)) {
        this.jdField_a_of_type_AndroidViewViewGroup.addView(new odw(paramAccountDetail, null, "信息简介", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.summary).a());
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedEnterprise)) {
        this.jdField_a_of_type_AndroidViewViewGroup.addView(new odw(paramAccountDetail, null, "认证来源", this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail.certifiedEnterprise).a());
      }
      localObject = uuc.a(this.jdField_a_of_type_ComTencentMobileqqDataAccountDetail);
    } while (TextUtils.isEmpty((CharSequence)localObject));
    this.jdField_a_of_type_AndroidViewViewGroup.addView(new odw(paramAccountDetail, null, "联系电话", (String)localObject).a());
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131370072) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.doOnBackPressed();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     odv
 * JD-Core Version:    0.7.0.1
 */