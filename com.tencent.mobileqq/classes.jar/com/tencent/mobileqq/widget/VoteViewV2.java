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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import apit;
import astn;
import awsn;
import awsr;
import awss;
import azmk;
import bdhj;
import bewe;
import bewf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;

public class VoteViewV2
  extends FrameLayout
  implements awss
{
  private double jdField_a_of_type_Double;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  protected ImageView a;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private astn jdField_a_of_type_Astn;
  awsn jdField_a_of_type_Awsn = new awsn();
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HeartLayout jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout;
  private boolean jdField_a_of_type_Boolean;
  protected TextView b;
  private boolean b;
  protected TextView c;
  private boolean c;
  private boolean d;
  public int e;
  public int f;
  protected int g = 0;
  
  public VoteViewV2(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VoteViewV2(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VoteViewV2(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_Double = getResources().getDisplayMetrics().density;
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(a(), this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380092));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131375553));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131375554));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131371630));
    bewe.a();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131380097));
    a(1);
  }
  
  protected int a()
  {
    return 2131561233;
  }
  
  public void a()
  {
    if (azmk.b())
    {
      QLog.i("PraiseManager", 1, "showPatternVote, SimpleUIMode is open now");
      return;
    }
    this.jdField_a_of_type_Awsn.jdField_a_of_type_Boolean = false;
    if (!this.d)
    {
      bewf.a();
      VasWebviewUtil.reportCommercialDrainage(null, "thumbup", "others_pageview", null, 1, 0, 0, null, "1", null);
    }
    this.d = true;
    postDelayed(new VoteViewV2.1(this), 3000L);
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
    if (this.g == 1)
    {
      if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845471);
      }
      for (;;)
      {
        this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166977));
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131166977));
        if (this.jdField_a_of_type_Awsn.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
          this.jdField_a_of_type_Awsn.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bdhj.a(this.jdField_a_of_type_Awsn.jdField_a_of_type_AndroidGraphicsDrawableDrawable, -7894119);
        }
        return;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845472);
      }
    }
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Boolean)) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845471);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167059));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167059));
      if (this.jdField_a_of_type_Awsn.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
        this.jdField_a_of_type_Awsn.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bdhj.a(this.jdField_a_of_type_Awsn.jdField_a_of_type_AndroidGraphicsDrawableDrawable, -1);
      }
      if (!ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setColorFilter(1996488704);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131166903));
      return;
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845473);
    }
  }
  
  public void a(int paramInt1, awsr paramawsr, int paramInt2, String paramString)
  {
    if (paramInt1 == 0) {}
    do
    {
      do
      {
        return;
      } while ((paramInt1 != PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) || (paramawsr == null) || (this.jdField_b_of_type_Boolean));
      a(paramawsr);
      paramawsr = (Pair)this.jdField_a_of_type_Awsn.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
    } while (paramawsr == null);
    this.jdField_a_of_type_Awsn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout, this.jdField_a_of_type_Astn.b(), this, paramInt1, false, 0, ((Point)paramawsr.first).x, ((Point)paramawsr.first).y);
    this.jdField_a_of_type_Awsn.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt1);
  }
  
  public void a(awsr paramawsr)
  {
    if (azmk.b()) {
      QLog.i("PraiseManager", 1, "startPraiseAnim, SimpleUIMode is open now");
    }
    while ((this.jdField_b_of_type_Boolean) || (paramawsr == null) || (this.jdField_a_of_type_Awsn.jdField_a_of_type_Boolean) || (this.d)) {
      return;
    }
    this.jdField_a_of_type_Awsn.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidWidgetImageView;
    this.jdField_a_of_type_Awsn.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(getResources(), paramawsr.a);
    if (this.g == 1) {
      this.jdField_a_of_type_Awsn.jdField_a_of_type_AndroidGraphicsDrawableDrawable = bdhj.a(this.jdField_a_of_type_Awsn.jdField_a_of_type_AndroidGraphicsDrawableDrawable, -7894119);
    }
    this.jdField_a_of_type_Awsn.a(false, false, this.jdField_a_of_type_AndroidWidgetImageView.getDrawable(), getResources());
    this.jdField_a_of_type_AndroidWidgetImageView.startAnimation(awsn.a(this.jdField_a_of_type_Awsn, 1.0F, 0.3F));
    this.jdField_a_of_type_Awsn.jdField_a_of_type_Boolean = true;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0) {
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130849802);
    ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localViewGroup.setVisibility(i);
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    int j;
    int i;
    Object localObject;
    if ((this.jdField_b_of_type_Boolean) && (this.f > 0)) {
      if (paramBoolean)
      {
        j = 2130849802;
        i = this.e;
        this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(j);
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(paramInt);
        TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label115;
        }
        localObject = "";
        label60:
        localTextView.setText((CharSequence)localObject);
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        if (!paramBoolean) {
          break label143;
        }
        paramInt = 4;
        label79:
        ((TextView)localObject).setVisibility(paramInt);
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(i));
      return;
      j = 2130849811;
      i = this.e - this.f;
      break;
      label115:
      localObject = "+" + this.f;
      break label60;
      label143:
      paramInt = 0;
      break label79;
      paramInt = this.e;
      if (this.jdField_b_of_type_Boolean)
      {
        i = paramInt;
        if (this.jdField_c_of_type_Boolean) {}
      }
      else
      {
        this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(4);
        i = paramInt;
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, apit paramapit, boolean paramBoolean3)
  {
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    label39:
    Object localObject;
    if (paramInt1 > 0)
    {
      this.e = paramInt1;
      if (paramInt2 <= this.e) {
        break label333;
      }
      this.f = (this.e % 20);
      if ((this.jdField_b_of_type_Boolean) || (!this.jdField_a_of_type_Boolean)) {
        break label355;
      }
      localObject = getResources().getDrawable(2130845471);
      label64:
      setContentDescription(String.format(getContext().getString(2131691210), new Object[] { String.valueOf(this.e) }));
      if (!this.jdField_a_of_type_Awsn.jdField_a_of_type_Boolean) {
        break label391;
      }
      this.jdField_a_of_type_Awsn.a(false, false, (Drawable)localObject, getResources());
    }
    float f1;
    float f2;
    for (;;)
    {
      if ((!paramBoolean1) && (!this.jdField_a_of_type_Awsn.jdField_a_of_type_Boolean) && (!paramBoolean3) && (!this.d))
      {
        paramInt1 = PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (paramInt1 > 0)
        {
          localObject = (PraiseManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(209);
          ((PraiseManager)localObject).a(this);
          a(((PraiseManager)localObject).a(paramInt1, true, "from_profile_card"));
        }
      }
      if (this.jdField_b_of_type_Boolean) {
        break label422;
      }
      a(false, 4);
      if ((paramBoolean3) && (this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout != null))
      {
        paramapit = new int[2];
        this.jdField_b_of_type_AndroidWidgetTextView.getLocationInWindow(paramapit);
        if (this.jdField_a_of_type_Astn == null) {
          this.jdField_a_of_type_Astn = new astn(getContext(), 2130845483);
        }
        f1 = (float)(paramapit[0] + this.jdField_b_of_type_AndroidWidgetTextView.getCompoundPaddingLeft() * 0.5D);
        f2 = paramapit[1];
        paramInt1 = PraiseManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        if (paramInt1 <= 0) {
          break label403;
        }
        this.jdField_a_of_type_Awsn.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout, this.jdField_a_of_type_Astn.b(), this, paramInt1, true, 0, f1, f2);
      }
      return;
      paramInt1 = 0;
      break;
      label333:
      if (paramInt2 < 0)
      {
        this.f = 0;
        break label39;
      }
      this.f = paramInt2;
      break label39;
      label355:
      if (this.g == 1)
      {
        localObject = getResources().getDrawable(2130845472);
        break label64;
      }
      localObject = getResources().getDrawable(2130845473);
      break label64;
      label391:
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject);
    }
    label403:
    this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout.a(this.jdField_a_of_type_Astn.b(), f1, f2);
    return;
    label422:
    if (paramapit != null)
    {
      paramapit.a(this.e, this.f, this.jdField_a_of_type_AndroidViewViewGroup, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, null, this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
      a(this.jdField_c_of_type_Boolean);
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
    astn.a(this.jdField_a_of_type_ComTencentMobileqqHotchatAnimHeartLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.VoteViewV2
 * JD-Core Version:    0.7.0.1
 */