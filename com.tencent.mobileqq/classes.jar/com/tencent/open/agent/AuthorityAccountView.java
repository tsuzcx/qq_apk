package com.tencent.open.agent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.base.StringAddition;

public class AuthorityAccountView
  extends BaseAuthorityAccountView
{
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AuthorityAccountView.IChangeAccountListener jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView$IChangeAccountListener = null;
  private AuthorityAccountView.IDeleteLastAccountListener jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView$IDeleteLastAccountListener = null;
  private TextView b;
  
  public AuthorityAccountView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AuthorityAccountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AuthorityAccountView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    g();
  }
  
  private void g()
  {
    SSOLog.a("AuthorityAccountView", new Object[] { "-->initUI" });
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    setOrientation(1);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559658, null);
    localLayoutParams.topMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 37.0F);
    localLayoutParams.bottomMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 37.0F);
    addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131361898));
    this.b = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131361870));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131361883));
    int i = BaseAIOUtils.b(10.0F, getResources());
    BaseAIOUtils.a(this.jdField_a_of_type_AndroidWidgetTextView, i, i, i, i);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new AuthorityAccountView.1(this));
    b();
    if ((this.jdField_a_of_type_AndroidContentContext instanceof AuthorityActivity)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((AuthorityActivity)this.jdField_a_of_type_AndroidContentContext);
    } else if ((this.jdField_a_of_type_AndroidContentContext instanceof QuickLoginAuthorityActivity)) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener((QuickLoginAuthorityActivity)this.jdField_a_of_type_AndroidContentContext);
    }
    h();
  }
  
  private void h()
  {
    ImageView localImageView = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131363050);
    localImageView.getViewTreeObserver().addOnGlobalLayoutListener(new AuthorityAccountView.2(this, localImageView));
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  protected boolean a()
  {
    AuthorityAccountView.IDeleteLastAccountListener localIDeleteLastAccountListener = this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView$IDeleteLastAccountListener;
    if (localIDeleteLastAccountListener == null) {
      return false;
    }
    localIDeleteLastAccountListener.a();
    return true;
  }
  
  protected boolean a(String paramString, boolean paramBoolean)
  {
    if (!(this.jdField_a_of_type_AndroidContentContext instanceof AuthorityActivity)) {
      return false;
    }
    ((AuthorityActivity)this.jdField_a_of_type_AndroidContentContext).a(paramString, paramBoolean);
    return true;
  }
  
  public void setAppInfo(String paramString, Bitmap paramBitmap)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = StringAddition.a(paramString, 12, true);
      this.b.setText(paramString);
    }
    if (paramBitmap != null)
    {
      paramString = new StringBuilder();
      paramString.append("setAppInfo appIcon=");
      paramString.append(paramBitmap);
      SSOLog.b("AuthorityAccountView", paramString.toString());
      this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void setAppType(String paramString)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      TextView localTextView = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131361868);
      String str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694613);
      if ("web".equals(paramString)) {
        str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694614);
      } else if ("android".equals(paramString)) {
        str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131694613);
      }
      localTextView.setText(str);
      paramString = new StringBuilder();
      paramString.append("setAppType=");
      paramString.append(str);
      SSOLog.b("AuthorityAccountView", paramString.toString());
    }
  }
  
  public void setChangeAccountListener(AuthorityAccountView.IChangeAccountListener paramIChangeAccountListener)
  {
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView$IChangeAccountListener = paramIChangeAccountListener;
  }
  
  public void setDeleteLastAccountListener(AuthorityAccountView.IDeleteLastAccountListener paramIDeleteLastAccountListener)
  {
    this.jdField_a_of_type_ComTencentOpenAgentAuthorityAccountView$IDeleteLastAccountListener = paramIDeleteLastAccountListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityAccountView
 * JD-Core Version:    0.7.0.1
 */