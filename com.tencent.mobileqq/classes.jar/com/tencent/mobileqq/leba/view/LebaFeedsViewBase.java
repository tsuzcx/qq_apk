package com.tencent.mobileqq.leba.view;

import aebk;
import aebl;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.LebaFeedInfo;
import com.tencent.mobileqq.leba.LebaFeedsAdapter.ListItem;
import com.tencent.mobileqq.leba.LebaUtils;
import com.tencent.qphone.base.util.QLog;

public abstract class LebaFeedsViewBase
  extends RelativeLayout
  implements View.OnClickListener, LebaFeedsDislikeMaskView.Listener
{
  public static ColorDrawable a;
  public static View.OnTouchListener b;
  public static int d;
  protected View.OnTouchListener a;
  protected View a;
  public Button a;
  protected LebaFeedInfo a;
  protected LebaFeedsDislikeMaskView a;
  protected LebaFeedsViewBase.ItemClickListener a;
  protected Object a;
  protected boolean a;
  protected ImageView b;
  public boolean b;
  protected int c;
  protected ImageView c;
  protected RelativeLayout c;
  protected TextView c;
  protected RelativeLayout d;
  protected RelativeLayout e;
  
  static
  {
    jdField_d_of_type_Int = -1;
    jdField_b_of_type_AndroidViewView$OnTouchListener = new aebl();
  }
  
  public LebaFeedsViewBase(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewView$OnTouchListener = new aebk(this);
    if (jdField_d_of_type_Int < 0) {
      jdField_d_of_type_Int = AIOUtils.a(12.0F, paramContext.getResources());
    }
    if (jdField_a_of_type_AndroidGraphicsDrawableColorDrawable == null) {
      jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(-2565408);
    }
  }
  
  protected static void a(TextView paramTextView, String paramString, boolean paramBoolean)
  {
    int i = 0;
    if (!TextUtils.isEmpty(paramString))
    {
      paramTextView.setText(paramString);
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setText("");
    if (paramBoolean) {
      i = 8;
    }
    paramTextView.setVisibility(i);
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo != null) {
      return this.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo.feedID;
    }
    return -1L;
  }
  
  public abstract void a(LebaFeedsAdapter.ListItem paramListItem);
  
  public void a(boolean paramBoolean)
  {
    float f2 = 0.5F;
    Object localObject;
    if (this.jdField_c_of_type_AndroidWidgetTextView != null)
    {
      localObject = this.jdField_c_of_type_AndroidWidgetTextView;
      if (paramBoolean)
      {
        f1 = 0.5F;
        ((TextView)localObject).setAlpha(f1);
      }
    }
    else if (this.jdField_c_of_type_AndroidWidgetImageView != null)
    {
      localObject = this.jdField_c_of_type_AndroidWidgetImageView;
      if (!paramBoolean) {
        break label60;
      }
    }
    label60:
    for (float f1 = f2;; f1 = 1.0F)
    {
      ((ImageView)localObject).setAlpha(f1);
      return;
      f1 = 1.0F;
      break;
    }
  }
  
  public void d()
  {
    ViewGroup.LayoutParams localLayoutParams = super.getLayoutParams();
    if ((localLayoutParams != null) && (localLayoutParams.height != -2))
    {
      localLayoutParams.height = -2;
      super.setLayoutParams(localLayoutParams);
    }
    super.setAlpha(1.0F);
    this.jdField_b_of_type_Boolean = false;
    j();
  }
  
  public abstract void e();
  
  public void f()
  {
    j();
  }
  
  @TargetApi(21)
  protected void g()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (QLog.isColorLevel()) {
        QLog.i("LebaFeedsViewBase", 2, "resetCornerMask using outline provider");
      }
      if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewView.getVisibility() != 8)) {
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      }
      if (!this.jdField_a_of_type_Boolean) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (this.jdField_a_of_type_JavaLangObject == null) {
                this.jdField_a_of_type_JavaLangObject = new LebaFeedsItemOutlineProvider(getContext());
              }
            } while (this.jdField_d_of_type_AndroidWidgetRelativeLayout == null);
            this.jdField_d_of_type_AndroidWidgetRelativeLayout.setOutlineProvider((LebaFeedsItemOutlineProvider)this.jdField_a_of_type_JavaLangObject);
            this.jdField_d_of_type_AndroidWidgetRelativeLayout.setClipToOutline(true);
            this.jdField_a_of_type_Boolean = true;
            return;
          } while (this.jdField_a_of_type_AndroidViewView == null);
          switch (LebaUtils.a())
          {
          }
        } while (this.jdField_a_of_type_AndroidViewView.getVisibility() == 8);
        this.jdField_a_of_type_AndroidViewView.setVisibility(8);
        return;
        this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130840611);
      } while (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      return;
      this.jdField_a_of_type_AndroidViewView.setBackgroundResource(2130840612);
    } while (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  protected void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsDislikeMaskView = ((LebaFeedsDislikeMaskView)super.findViewById(2131366701));
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsDislikeMaskView.setListener(this);
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsDislikeMaskView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131366702));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsDislikeMaskView.setButtonView(this.jdField_a_of_type_AndroidWidgetButton);
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsDislikeMaskView != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsDislikeMaskView.getVisibility() != 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsDislikeMaskView.a(false);
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsDislikeMaskView.setVisibility(0);
    }
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsDislikeMaskView != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsDislikeMaskView.getVisibility() != 8))
    {
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsDislikeMaskView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsDislikeMaskView.b(false);
      if (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsViewBase$ItemClickListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsViewBase$ItemClickListener.d(this, this.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo, this.jdField_c_of_type_Int);
      }
    }
  }
  
  public void k()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsDislikeMaskView != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsDislikeMaskView.getVisibility() != 8)) {
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsDislikeMaskView.b(true);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_b_of_type_Boolean) {}
    do
    {
      do
      {
        do
        {
          return;
          switch (paramView.getId())
          {
          default: 
            return;
          }
        } while (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsViewBase$ItemClickListener == null);
        this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsViewBase$ItemClickListener.b(this, this.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo, this.jdField_c_of_type_Int);
        return;
        this.jdField_b_of_type_Boolean = true;
      } while (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsViewBase$ItemClickListener == null);
      this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsViewBase$ItemClickListener.a(this, this.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo, this.jdField_c_of_type_Int);
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsViewBase$ItemClickListener == null);
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsViewBase$ItemClickListener.c(this, this.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo, this.jdField_c_of_type_Int);
    return;
    k();
  }
  
  public void setItemClickListener(LebaFeedsViewBase.ItemClickListener paramItemClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFeedsViewBase$ItemClickListener = paramItemClickListener;
  }
  
  public void setPosition(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public String toString()
  {
    return getClass().getSimpleName() + "|feedInfo=" + this.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.view.LebaFeedsViewBase
 * JD-Core Version:    0.7.0.1
 */