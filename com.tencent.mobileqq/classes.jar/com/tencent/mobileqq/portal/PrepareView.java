package com.tencent.mobileqq.portal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.AnimatorSet.Builder;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;

public class PrepareView
  extends RelativeLayout
{
  public int a;
  public long a;
  private Context jdField_a_of_type_AndroidContentContext;
  private CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  Animator jdField_a_of_type_ComNineoldandroidsAnimationAnimator;
  AnimatorSet jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet;
  private ImageAlphaSwitchView jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView;
  private ImageShakeAnimView jdField_a_of_type_ComTencentMobileqqPortalImageShakeAnimView;
  private ImageSwitchAnimView jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView;
  public List<PortalManager.LogoConfig> a;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  AnimatorSet jdField_b_of_type_ComNineoldandroidsAnimationAnimatorSet;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  AnimatorSet jdField_c_of_type_ComNineoldandroidsAnimationAnimatorSet;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private ImageView jdField_g_of_type_AndroidWidgetImageView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private ImageView jdField_h_of_type_AndroidWidgetImageView;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private ImageView jdField_i_of_type_AndroidWidgetImageView;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private TextView j;
  
  public PrepareView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private Bitmap a(int paramInt)
  {
    int m = 0;
    int k;
    if (this.jdField_a_of_type_Int == 1) {
      if (paramInt == 0) {
        k = 2130845269;
      }
    }
    while (k != 0)
    {
      Drawable localDrawable = getResources().getDrawable(k);
      if ((localDrawable instanceof SkinnableBitmapDrawable))
      {
        return ((SkinnableBitmapDrawable)localDrawable).getBitmap();
        k = m;
        if (paramInt == 1)
        {
          k = 2130845270;
          continue;
          if (this.jdField_a_of_type_Int != 2)
          {
            k = m;
            if (this.jdField_a_of_type_Int != 3) {
              break;
            }
          }
          else if (paramInt == 0)
          {
            k = 2130845237;
          }
          else
          {
            k = m;
            if (paramInt == 1) {
              k = 2130845238;
            }
          }
        }
      }
      else if ((localDrawable instanceof BitmapDrawable))
      {
        return ((BitmapDrawable)localDrawable).getBitmap();
      }
    }
    return null;
  }
  
  private void d()
  {
    if ((this.jdField_f_of_type_AndroidWidgetImageView == null) || (this.jdField_h_of_type_AndroidWidgetImageView == null) || (this.jdField_g_of_type_AndroidWidgetImageView == null)) {}
    do
    {
      return;
      ObjectAnimator localObjectAnimator1;
      ObjectAnimator localObjectAnimator2;
      if (this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet == null)
      {
        ViewHelper.setPivotX(this.jdField_f_of_type_AndroidWidgetImageView, 0.5F);
        ViewHelper.setPivotY(this.jdField_f_of_type_AndroidWidgetImageView, 0.2F);
        localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_f_of_type_AndroidWidgetImageView, "rotation", new float[] { 0.0F, -10.0F, 10.0F, -6.0F, 0.0F });
        localObjectAnimator1.setDuration(720L);
        localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_f_of_type_AndroidWidgetImageView, "translationY", new float[] { 0.0F, 8.0F, -8.0F, 4.0F, 0.0F });
        localObjectAnimator2.setDuration(720L);
        this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet = new AnimatorSet();
        this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
      }
      if (this.jdField_b_of_type_ComNineoldandroidsAnimationAnimatorSet == null)
      {
        ViewHelper.setPivotX(this.jdField_h_of_type_AndroidWidgetImageView, 0.5F);
        ViewHelper.setPivotY(this.jdField_h_of_type_AndroidWidgetImageView, 0.2F);
        localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_h_of_type_AndroidWidgetImageView, "rotation", new float[] { 0.0F, 3.0F, -3.0F, 2.0F, 0.0F });
        localObjectAnimator1.setDuration(720L);
        localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_h_of_type_AndroidWidgetImageView, "translationY", new float[] { 0.0F, 8.0F, -8.0F, 4.0F, 0.0F });
        localObjectAnimator2.setDuration(720L);
        this.jdField_b_of_type_ComNineoldandroidsAnimationAnimatorSet = new AnimatorSet();
        this.jdField_b_of_type_ComNineoldandroidsAnimationAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
      }
      if (this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator == null)
      {
        localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_g_of_type_AndroidWidgetImageView, "translationY", new float[] { 0.0F, 8.0F, -8.0F, 4.0F, 0.0F });
        localObjectAnimator1.setDuration(720L);
        this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator = localObjectAnimator1;
      }
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_c_of_type_ComNineoldandroidsAnimationAnimatorSet == null) && (this.jdField_a_of_type_Int == 1))
      {
        localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "translationY", new float[] { 0.0F, 8.0F, -8.0F, 4.0F, 0.0F });
        localObjectAnimator1.setDuration(720L);
        localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidWidgetImageView, "scaleX", new float[] { 1.0F, 0.99F, 1.02F, 0.99F, 1.0F });
        localObjectAnimator2.setDuration(720L);
        this.jdField_c_of_type_ComNineoldandroidsAnimationAnimatorSet = new AnimatorSet();
        this.jdField_c_of_type_ComNineoldandroidsAnimationAnimatorSet.play(localObjectAnimator1).with(localObjectAnimator2);
      }
    } while ((this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet == null) || (this.jdField_b_of_type_ComNineoldandroidsAnimationAnimatorSet == null));
    this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet.cancel();
    this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet.start();
    this.jdField_b_of_type_ComNineoldandroidsAnimationAnimatorSet.cancel();
    this.jdField_b_of_type_ComNineoldandroidsAnimationAnimatorSet.start();
    this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator.cancel();
    this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator.start();
    if ((this.jdField_a_of_type_Int == 1) && (this.jdField_c_of_type_ComNineoldandroidsAnimationAnimatorSet != null) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
    {
      this.jdField_c_of_type_ComNineoldandroidsAnimationAnimatorSet.cancel();
      this.jdField_c_of_type_ComNineoldandroidsAnimationAnimatorSet.start();
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalImageShakeAnimView.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int < 0) {}
    while (this.jdField_a_of_type_AndroidOsCountDownTimer == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
    this.jdField_a_of_type_AndroidOsCountDownTimer = null;
  }
  
  public boolean a(int paramInt)
  {
    a();
    removeAllViews();
    if (paramInt == 1)
    {
      LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561171, this, true);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370548));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371805));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131378920));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378916));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378917));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378919));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365916));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378906));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378907));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378908));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378909));
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368955));
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131368956));
      this.j = ((TextView)findViewById(2131370138));
      Object localObject = Typeface.createFromAsset(this.jdField_a_of_type_AndroidContentContext.getAssets(), "fonts/DS-DIGIB.TTF");
      this.jdField_a_of_type_AndroidWidgetTextView.setTypeface((Typeface)localObject);
      this.jdField_b_of_type_AndroidWidgetTextView.setTypeface((Typeface)localObject);
      this.jdField_c_of_type_AndroidWidgetTextView.setTypeface((Typeface)localObject);
      this.jdField_d_of_type_AndroidWidgetTextView.setTypeface((Typeface)localObject);
      this.jdField_e_of_type_AndroidWidgetTextView.setTypeface((Typeface)localObject);
      this.jdField_f_of_type_AndroidWidgetTextView.setTypeface((Typeface)localObject);
      this.jdField_g_of_type_AndroidWidgetTextView.setTypeface((Typeface)localObject);
      this.jdField_h_of_type_AndroidWidgetTextView.setTypeface((Typeface)localObject);
      this.jdField_i_of_type_AndroidWidgetTextView.setTypeface((Typeface)localObject);
      this.j.setTypeface((Typeface)localObject);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369990));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376667));
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131381515));
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131363484));
      this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376972));
      this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376971));
      this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365261));
      localObject = (RelativeLayout.LayoutParams)this.jdField_i_of_type_AndroidWidgetImageView.getLayoutParams();
      if (localObject != null)
      {
        ((RelativeLayout.LayoutParams)localObject).topMargin = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_i_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = new RelativeLayout.LayoutParams(AIOUtils.dp2px(475.0F, getResources()), AIOUtils.dp2px(300.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      addView(this.jdField_a_of_type_ComTencentMobileqqPortalImageShakeAnimView, 0, (ViewGroup.LayoutParams)localObject);
      return true;
      if ((paramInt != 2) && (paramInt != 3)) {
        break;
      }
      LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561170, this, true);
      this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView = ((ImageSwitchAnimView)findViewById(2131370548));
      this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView = ((ImageAlphaSwitchView)findViewById(2131371805));
    }
    return false;
  }
  
  public void b()
  {
    d();
  }
  
  public void c()
  {
    try
    {
      if (this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet != null)
      {
        if (this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet.isRunning()) {
          this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet.cancel();
        }
        this.jdField_a_of_type_ComNineoldandroidsAnimationAnimatorSet = null;
      }
      if (this.jdField_b_of_type_ComNineoldandroidsAnimationAnimatorSet != null)
      {
        if (this.jdField_b_of_type_ComNineoldandroidsAnimationAnimatorSet.isRunning()) {
          this.jdField_b_of_type_ComNineoldandroidsAnimationAnimatorSet.cancel();
        }
        this.jdField_b_of_type_ComNineoldandroidsAnimationAnimatorSet = null;
      }
      if (this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator != null)
      {
        if (this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator.isRunning()) {
          this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator.cancel();
        }
        this.jdField_a_of_type_ComNineoldandroidsAnimationAnimator = null;
      }
      if (this.jdField_c_of_type_ComNineoldandroidsAnimationAnimatorSet != null)
      {
        if (this.jdField_c_of_type_ComNineoldandroidsAnimationAnimatorSet.isRunning()) {
          this.jdField_c_of_type_ComNineoldandroidsAnimationAnimatorSet.cancel();
        }
        this.jdField_c_of_type_ComNineoldandroidsAnimationAnimatorSet = null;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      localThrowable.printStackTrace();
    }
  }
  
  public void setBackground(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, Bitmap paramBitmap5, Bitmap paramBitmap6)
  {
    if (this.jdField_a_of_type_Int < 0) {
      return;
    }
    if (paramBitmap1 != null) {}
    for (;;)
    {
      try
      {
        paramBitmap2 = getBackground();
        if ((paramBitmap2 == null) || (!(paramBitmap2 instanceof BitmapDrawable))) {
          continue;
        }
        paramBitmap2 = ((BitmapDrawable)paramBitmap2).getBitmap();
        if (paramBitmap2 != paramBitmap1) {
          continue;
        }
      }
      catch (Throwable paramBitmap1)
      {
        continue;
        this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap3);
        continue;
      }
      if (paramBitmap3 != null) {}
      try
      {
        paramBitmap1 = this.jdField_c_of_type_AndroidWidgetImageView.getDrawable();
        if ((paramBitmap1 == null) || (!(paramBitmap1 instanceof BitmapDrawable))) {
          continue;
        }
        paramBitmap1 = ((BitmapDrawable)paramBitmap1).getBitmap();
        if (paramBitmap1 != paramBitmap3) {
          continue;
        }
      }
      catch (Throwable paramBitmap1)
      {
        continue;
        this.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap4);
        continue;
      }
      if (paramBitmap4 != null) {}
      try
      {
        paramBitmap1 = this.jdField_d_of_type_AndroidWidgetImageView.getDrawable();
        if ((paramBitmap1 == null) || (!(paramBitmap1 instanceof BitmapDrawable))) {
          break label199;
        }
        paramBitmap1 = ((BitmapDrawable)paramBitmap1).getBitmap();
        if (paramBitmap1 != paramBitmap4) {
          break label199;
        }
      }
      catch (Throwable paramBitmap1)
      {
        continue;
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130845255);
      }
      if (paramBitmap5 == null) {
        break label215;
      }
      paramBitmap1 = this.jdField_e_of_type_AndroidWidgetImageView.getDrawable();
      if ((paramBitmap1 != null) && ((paramBitmap1 instanceof BitmapDrawable)) && (((BitmapDrawable)paramBitmap1).getBitmap() == paramBitmap5)) {
        break;
      }
      this.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap5);
      return;
      super.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap1));
    }
    label199:
    label215:
    return;
  }
  
  public void setLogo(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if (this.jdField_a_of_type_Int == 1) {
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null)) {
        break label53;
      }
    }
    label53:
    label186:
    label205:
    label230:
    for (;;)
    {
      return;
      if (((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 3)) || ((this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView != null)))
      {
        Bitmap localBitmap = paramBitmap1;
        if (paramBitmap1 == null) {
          localBitmap = a(0);
        }
        if (localBitmap != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView != null)
          {
            if (this.jdField_a_of_type_Int != 3) {
              break label186;
            }
            this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView.a(localBitmap);
          }
          if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_Int == 1)) {
            this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
          }
        }
        paramBitmap1 = paramBitmap2;
        if (paramBitmap2 == null) {
          paramBitmap1 = a(1);
        }
        if (paramBitmap1 == null) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView != null)
        {
          if (this.jdField_a_of_type_Int != 3) {
            break label205;
          }
          this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.setGravity(3);
          this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.a(paramBitmap1);
        }
        for (;;)
        {
          if ((this.jdField_b_of_type_AndroidWidgetImageView == null) || (this.jdField_a_of_type_Int != 1)) {
            break label230;
          }
          this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap1);
          return;
          if (this.jdField_a_of_type_Int != 2) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView.setLogo(localBitmap);
          break;
          if (this.jdField_a_of_type_Int == 2)
          {
            this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.setGravity(3);
            this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.setImage(paramBitmap1);
          }
        }
      }
    }
  }
  
  public void setLogoConfigList(List<PortalManager.LogoConfig> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if ((paramList != null) && (QLog.isColorLevel()))
    {
      int k = 0;
      while (k < paramList.size())
      {
        PortalManager.LogoConfig localLogoConfig = (PortalManager.LogoConfig)paramList.get(k);
        if (localLogoConfig != null) {
          QLog.d("PortalManager", 2, "prepareview, setLogoConfigList, index=" + k + ", p=" + localLogoConfig.toString());
        }
        k += 1;
      }
    }
  }
  
  public void setMode(int paramInt)
  {
    if (((paramInt != 1) && (paramInt != 2) && (paramInt != 3)) || (this.jdField_a_of_type_Int == paramInt)) {}
    while (!a(paramInt)) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PrepareView
 * JD-Core Version:    0.7.0.1
 */