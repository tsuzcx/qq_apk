package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import apek;
import aspe;
import awoe;
import awoi;
import awoj;
import azib;
import berw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;

public class VoteView
  extends RelativeLayout
  implements awoj
{
  private double jdField_a_of_type_Double;
  public int a;
  public FrameLayout a;
  public ImageView a;
  public RelativeLayout a;
  public TextView a;
  aspe jdField_a_of_type_Aspe;
  awoe jdField_a_of_type_Awoe = new awoe();
  public QQAppInterface a;
  HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  public SingleLineTextView a;
  public boolean a;
  public int b;
  private boolean b;
  private boolean c;
  private boolean d;
  
  public VoteView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public VoteView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public VoteView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    this.jdField_b_of_type_Boolean = false;
    this.c = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    Object localObject1 = getResources();
    this.jdField_a_of_type_Double = ((Resources)localObject1).getDisplayMetrics().density;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(getContext());
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setId(2131368954);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130845412);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setPadding((int)(this.jdField_a_of_type_Double * 8.0D), (int)(this.jdField_a_of_type_Double * 3.0D), (int)(this.jdField_a_of_type_Double * 8.0D), (int)(this.jdField_a_of_type_Double * 3.0D));
    Object localObject2 = new RelativeLayout.LayoutParams(-2, (int)(this.jdField_a_of_type_Double * 24.0D));
    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ((int)(this.jdField_a_of_type_Double * 6.0D));
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(getContext()).inflate(2131561214, null);
    localViewGroup.setId(2131369132);
    addView(localViewGroup, new RelativeLayout.LayoutParams(-2, -2));
    addView(localRelativeLayout, new RelativeLayout.LayoutParams(-2, -2));
    localRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout, (ViewGroup.LayoutParams)localObject2);
    berw.a();
    this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
    this.jdField_a_of_type_AndroidWidgetImageView.setId(2131372203);
    localObject2 = ((Resources)localObject1).getDrawable(2130849396);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
    int i;
    if (localObject2 == null)
    {
      i = (int)(this.jdField_a_of_type_Double * 18.0D);
      if (localObject2 != null) {
        break label637;
      }
    }
    label637:
    for (int j = (int)(this.jdField_a_of_type_Double * 18.0D);; j = ((Drawable)localObject2).getIntrinsicHeight())
    {
      localObject2 = new RelativeLayout.LayoutParams(i, j);
      ((RelativeLayout.LayoutParams)localObject2).addRule(9);
      ((RelativeLayout.LayoutParams)localObject2).addRule(15);
      ((RelativeLayout.LayoutParams)localObject2).rightMargin = ((int)(this.jdField_a_of_type_Double * 3.0D));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetImageView, (ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_ComTencentWidgetSingleLineTextView = new SingleLineTextView(getContext());
      this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setId(2131369412);
      this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextColor(-1);
      this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setTextSize(13.0F);
      localObject2 = new RelativeLayout.LayoutParams(-2, (int)(this.jdField_a_of_type_Double * 24.0D));
      ((RelativeLayout.LayoutParams)localObject2).addRule(1, 2131372203);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentWidgetSingleLineTextView, (ViewGroup.LayoutParams)localObject2);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(getContext());
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setId(2131368879);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130849738);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setMinimumHeight((int)(this.jdField_a_of_type_Double * 6.0D));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setMinimumWidth((int)(this.jdField_a_of_type_Double * 6.0D));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setContentDescription(((Resources)localObject1).getString(2131691193));
      localObject1 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject1).addRule(10);
      ((RelativeLayout.LayoutParams)localObject1).addRule(7, 2131368954);
      localRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetFrameLayout, (ViewGroup.LayoutParams)localObject1);
      this.jdField_a_of_type_AndroidWidgetTextView = new TextView(getContext());
      this.jdField_a_of_type_AndroidWidgetTextView.setId(2131371088);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 11.0F);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidWidgetTextView, -2, -2);
      return;
      i = ((Drawable)localObject2).getIntrinsicWidth();
      break;
    }
  }
  
  public void a()
  {
    if (azib.b())
    {
      QLog.i("PraiseManager", 1, "showPatternVote, SimpleUIMode is open now");
      return;
    }
    this.jdField_a_of_type_Awoe.jdField_a_of_type_Boolean = false;
    if (!this.d)
    {
      berw.a();
      VasWebviewUtil.reportCommercialDrainage(null, "thumbup", "others_pageview", null, 1, 0, 0, null, "1", null);
    }
    this.d = true;
    postDelayed(new VoteView.1(this), 3000L);
  }
  
  public void a(int paramInt1, awoi paramawoi, int paramInt2, String paramString)
  {
    if (paramInt1 == 0) {}
    do
    {
      do
      {
        return;
      } while ((paramInt1 != PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (paramawoi == null) || (this.c));
      a(paramawoi);
      paramawoi = (Pair)this.jdField_a_of_type_Awoe.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    } while (paramawoi == null);
    this.jdField_a_of_type_Awoe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout, this.jdField_a_of_type_Aspe.b(), this, paramInt1, false, 0, ((Point)paramawoi.first).x, ((Point)paramawoi.first).y);
    this.jdField_a_of_type_Awoe.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt1);
  }
  
  public void a(awoi paramawoi)
  {
    if (azib.b()) {
      QLog.i("PraiseManager", 1, "startPraiseAnim, SimpleUIMode is open now");
    }
    while ((this.c) || (paramawoi == null) || (this.jdField_a_of_type_Awoe.jdField_a_of_type_Boolean)) {
      return;
    }
    this.jdField_a_of_type_Awoe.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetImageView;
    this.jdField_a_of_type_Awoe.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(getResources(), paramawoi.a);
    this.jdField_a_of_type_Awoe.a(this.jdField_b_of_type_Boolean, false, this.jdField_a_of_type_AndroidWidgetImageView.getDrawable(), getResources());
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(awoe.a(this.jdField_a_of_type_Awoe, 1.0F, 0.3F));
    this.jdField_a_of_type_Awoe.jdField_a_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() == 0) {
      return;
    }
    if (paramBoolean)
    {
      localObject = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      if (localObject != null) {
        ((RelativeLayout.LayoutParams)localObject).topMargin = 0;
      }
      if (localLayoutParams != null)
      {
        localLayoutParams.width = ((int)(this.jdField_a_of_type_Double * 6.0D + 0.5D));
        localLayoutParams.height = ((int)(this.jdField_a_of_type_Double * 6.0D + 0.5D));
        localLayoutParams.rightMargin = ((int)(3.0D % this.jdField_a_of_type_Double + 0.5D));
      }
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(2130849729);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams(localLayoutParams);
    }
    Object localObject = this.jdField_a_of_type_AndroidWidgetFrameLayout;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      ((FrameLayout)localObject).setVisibility(i);
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    Object localObject3;
    int j;
    Object localObject2;
    int i;
    Object localObject1;
    if ((this.c) && (this.jdField_b_of_type_Int > 0))
    {
      localObject3 = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetFrameLayout.getLayoutParams();
      if (paramBoolean)
      {
        j = 2130849729;
        if (localLayoutParams != null) {
          localLayoutParams.topMargin = 0;
        }
        localObject2 = String.valueOf(this.jdField_a_of_type_Int);
        i = j;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          ((RelativeLayout.LayoutParams)localObject3).width = ((int)(this.jdField_a_of_type_Double * 6.0D + 0.5D));
          ((RelativeLayout.LayoutParams)localObject3).height = ((int)(this.jdField_a_of_type_Double * 6.0D + 0.5D));
          ((RelativeLayout.LayoutParams)localObject3).rightMargin = ((int)(3.0D % this.jdField_a_of_type_Double + 0.5D));
          localObject1 = localObject2;
          i = j;
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setBackgroundResource(i);
        if (localObject3 != null) {
          this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject3);
        }
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(paramInt);
        localObject3 = this.jdField_a_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label313;
        }
        localObject2 = "";
        label185:
        ((TextView)localObject3).setText((CharSequence)localObject2);
        localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label341;
        }
        paramInt = 4;
        label204:
        ((TextView)localObject2).setVisibility(paramInt);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetSingleLineTextView.setText(localObject1);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(localLayoutParams);
      return;
      j = 2130849732;
      if (localLayoutParams != null) {
        localLayoutParams.topMargin = ((int)(15.0D * this.jdField_a_of_type_Double + 0.5D));
      }
      localObject2 = String.valueOf(this.jdField_a_of_type_Int - this.jdField_b_of_type_Int);
      i = j;
      localObject1 = localObject2;
      if (localObject3 == null) {
        break;
      }
      ((RelativeLayout.LayoutParams)localObject3).width = -2;
      ((RelativeLayout.LayoutParams)localObject3).height = -2;
      ((RelativeLayout.LayoutParams)localObject3).rightMargin = 0;
      i = j;
      localObject1 = localObject2;
      break;
      label313:
      localObject2 = "+" + this.jdField_b_of_type_Int;
      break label185;
      label341:
      paramInt = 0;
      break label204;
      if (localLayoutParams != null) {
        localLayoutParams.topMargin = 0;
      }
      localObject2 = String.valueOf(this.jdField_a_of_type_Int);
      if (this.c)
      {
        localObject1 = localObject2;
        if (this.jdField_a_of_type_Boolean) {}
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(4);
        localObject1 = localObject2;
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, apek paramapek, boolean paramBoolean3)
  {
    this.c = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    label39:
    Object localObject;
    if (paramInt1 > 0)
    {
      this.jdField_a_of_type_Int = paramInt1;
      if (paramInt2 <= this.jdField_a_of_type_Int) {
        break label345;
      }
      this.jdField_b_of_type_Int = (this.jdField_a_of_type_Int % 20);
      if ((this.c) || (!this.jdField_b_of_type_Boolean)) {
        break label367;
      }
      localObject = super.getResources().getDrawable(2130849399);
      label65:
      if (!this.jdField_a_of_type_Awoe.jdField_a_of_type_Boolean) {
        break label381;
      }
      this.jdField_a_of_type_Awoe.a(this.jdField_b_of_type_Boolean, false, (Drawable)localObject, getResources());
    }
    float f1;
    float f2;
    for (;;)
    {
      if ((!paramBoolean1) && (!this.jdField_a_of_type_Awoe.jdField_a_of_type_Boolean) && (!paramBoolean3) && (!this.d))
      {
        paramInt1 = PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (paramInt1 > 0)
        {
          localObject = (PraiseManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(209);
          ((PraiseManager)localObject).a(this);
          a(((PraiseManager)localObject).a(paramInt1, true, "from_profile_card"));
        }
      }
      setContentDescription(String.format(getContext().getString(2131691209), new Object[] { String.valueOf(this.jdField_a_of_type_Int) }));
      if (this.c) {
        break label412;
      }
      a(false, 4);
      if ((paramBoolean3) && (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout != null))
      {
        paramapek = new int[2];
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.getLocationInWindow(paramapek);
        if (this.jdField_a_of_type_Aspe == null) {
          this.jdField_a_of_type_Aspe = new aspe(getContext(), 2130845411);
        }
        f1 = (float)(paramapek[0] + (this.jdField_a_of_type_AndroidWidgetImageView.getWidth() + this.jdField_a_of_type_AndroidWidgetRelativeLayout.getPaddingLeft()) * 0.5D);
        f2 = paramapek[1];
        paramInt1 = PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (paramInt1 <= 0) {
          break label393;
        }
        this.jdField_a_of_type_Awoe.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout, this.jdField_a_of_type_Aspe.b(), this, paramInt1, true, 0, f1, f2);
      }
      return;
      paramInt1 = 0;
      break;
      label345:
      if (paramInt2 < 0)
      {
        this.jdField_b_of_type_Int = 0;
        break label39;
      }
      this.jdField_b_of_type_Int = paramInt2;
      break label39;
      label367:
      localObject = super.getResources().getDrawable(2130849396);
      break label65;
      label381:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    label393:
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.a(this.jdField_a_of_type_Aspe.b(), f1, f2);
    return;
    label412:
    if (paramapek != null)
    {
      paramapek.a(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidWidgetFrameLayout, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComTencentWidgetSingleLineTextView, this.jdField_a_of_type_AndroidWidgetRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      a(this.jdField_a_of_type_Boolean);
      return;
    }
    a(true, 0);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout != null) {
      this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.setCanDoAnim(paramBoolean);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((PraiseManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(209)).b(this);
    }
    this.d = false;
    super.onDetachedFromWindow();
  }
  
  public void setHeartLayout(QQAppInterface paramQQAppInterface, HeartLayout paramHeartLayout)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout = paramHeartLayout;
    aspe.a(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.VoteView
 * JD-Core Version:    0.7.0.1
 */