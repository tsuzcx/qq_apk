package com.tencent.open.agent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.widget.ActionSheet;

public class OpenAuthorityAccountView
  extends BaseAuthorityAccountView
{
  private OpenCardContainer.AccountEventListener a;
  private View c;
  
  public OpenAuthorityAccountView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OpenAuthorityAccountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public OpenAuthorityAccountView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$AccountEventListener = null;
    g();
  }
  
  private void g()
  {
    SSOLog.a("OpenAuthorityAccountView", new Object[] { "-->initUI" });
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    setOrientation(1);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131559660, null);
    addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
    b();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new OpenAuthorityAccountView.1(this));
    this.c = findViewById(2131377154);
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      f();
      this.jdField_a_of_type_Boolean = true;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
  }
  
  protected boolean a()
  {
    if ((this.jdField_a_of_type_AndroidContentContext != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof PublicFragmentActivityForOpenSDK)))
    {
      OpenCardContainer.AccountEventListener localAccountEventListener = this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$AccountEventListener;
      if (localAccountEventListener != null) {
        localAccountEventListener.a();
      }
      return true;
    }
    return false;
  }
  
  protected boolean a(String paramString, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof PublicFragmentActivityForOpenSDK))
    {
      OpenCardContainer.AccountEventListener localAccountEventListener = this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$AccountEventListener;
      if (localAccountEventListener != null)
      {
        localAccountEventListener.a(paramString, paramBoolean);
        return true;
      }
    }
    return false;
  }
  
  public void setAccountEventListener(OpenCardContainer.AccountEventListener paramAccountEventListener)
  {
    this.jdField_a_of_type_ComTencentOpenAgentOpenCardContainer$AccountEventListener = paramAccountEventListener;
  }
  
  public void setMainAccountSelect(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setMainAccountSelect select=");
    ((StringBuilder)localObject).append(paramBoolean);
    localObject = ((StringBuilder)localObject).toString();
    int i = 0;
    SSOLog.a("OpenAuthorityAccountView", new Object[] { localObject });
    localObject = this.c;
    if (!paramBoolean) {
      i = 8;
    }
    ((View)localObject).setVisibility(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityAccountView
 * JD-Core Version:    0.7.0.1
 */