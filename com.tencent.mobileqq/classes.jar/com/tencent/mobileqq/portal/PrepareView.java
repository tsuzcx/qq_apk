package com.tencent.mobileqq.portal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.util.List;

public class PrepareView
  extends RelativeLayout
{
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ImageAlphaSwitchView jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView;
  private ImageShakeAnimView jdField_a_of_type_ComTencentMobileqqPortalImageShakeAnimView;
  private ImageSwitchAnimView jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView;
  public List<PortalManager.LogoConfig> a;
  private boolean jdField_a_of_type_Boolean = false;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private ImageView jdField_e_of_type_AndroidWidgetImageView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private ImageView jdField_f_of_type_AndroidWidgetImageView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private TextView g;
  private TextView h;
  private TextView i;
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
        k = 2130845582;
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
          k = 2130845583;
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
            k = 2130845404;
          }
          else
          {
            k = m;
            if (paramInt == 1) {
              k = 2130845405;
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
  
  public void a()
  {
    if (this.jdField_a_of_type_Int < 0) {}
    while (this.jdField_a_of_type_AndroidOsCountDownTimer == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
    this.jdField_a_of_type_AndroidOsCountDownTimer = null;
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PrepareView", 2, "startTimeDown time = " + paramLong + ",mMode = " + this.jdField_a_of_type_Int);
    }
    if (this.jdField_a_of_type_Int < 0) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null) {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
    }
    this.jdField_a_of_type_AndroidOsCountDownTimer = new PrepareView.1(this, paramLong, 1000L);
    this.jdField_a_of_type_AndroidOsCountDownTimer.start();
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Int == 1) {
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null)) {
        break label53;
      }
    }
    for (;;)
    {
      return;
      if (((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 3)) || ((this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView != null)))
      {
        label53:
        Bitmap localBitmap = paramBitmap;
        if (paramBitmap == null) {
          localBitmap = a(0);
        }
        if (localBitmap == null) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView != null)
        {
          if (this.jdField_a_of_type_Int != 3) {
            break label116;
          }
          this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView.a(localBitmap);
        }
        while ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_Int == 1))
        {
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
          return;
          label116:
          if (this.jdField_a_of_type_Int == 2) {
            this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView.setLogo(localBitmap);
          }
        }
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = false;
    a();
    removeAllViews();
    if (paramInt == 1)
    {
      LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561270, this, true);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370833));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131372117));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131379351));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379347));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379348));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379350));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131366080));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379337));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379338));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379339));
      this.g = ((TextView)findViewById(2131379340));
      this.h = ((TextView)findViewById(2131369187));
      this.i = ((TextView)findViewById(2131369188));
      this.j = ((TextView)findViewById(2131370409));
      Object localObject = Typeface.createFromAsset(this.jdField_a_of_type_AndroidContentContext.getAssets(), "fonts/DS-DIGIB.TTF");
      this.jdField_a_of_type_AndroidWidgetTextView.setTypeface((Typeface)localObject);
      this.jdField_b_of_type_AndroidWidgetTextView.setTypeface((Typeface)localObject);
      this.jdField_c_of_type_AndroidWidgetTextView.setTypeface((Typeface)localObject);
      this.jdField_d_of_type_AndroidWidgetTextView.setTypeface((Typeface)localObject);
      this.jdField_e_of_type_AndroidWidgetTextView.setTypeface((Typeface)localObject);
      this.jdField_f_of_type_AndroidWidgetTextView.setTypeface((Typeface)localObject);
      this.g.setTypeface((Typeface)localObject);
      this.h.setTypeface((Typeface)localObject);
      this.i.setTypeface((Typeface)localObject);
      this.j.setTypeface((Typeface)localObject);
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370260));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131377062));
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131381977));
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365401));
      localObject = (RelativeLayout.LayoutParams)this.jdField_f_of_type_AndroidWidgetImageView.getLayoutParams();
      if (localObject != null)
      {
        ((RelativeLayout.LayoutParams)localObject).topMargin = AIOUtils.a(25.0F, getResources());
        this.jdField_f_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      paramInt = AIOUtils.a(475.0F, getResources());
      int k = AIOUtils.a(335.0F, getResources());
      this.jdField_a_of_type_ComTencentMobileqqPortalImageShakeAnimView = new ImageShakeAnimView(this.jdField_a_of_type_AndroidContentContext, paramInt, k, (getResources().getDisplayMetrics().widthPixels - paramInt) / 2, 0, Integer.valueOf(2130845532), true);
      localObject = new RelativeLayout.LayoutParams(paramInt, k);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      addView(this.jdField_a_of_type_ComTencentMobileqqPortalImageShakeAnimView, 0, (ViewGroup.LayoutParams)localObject);
      bool = true;
      do
      {
        return bool;
      } while ((paramInt != 2) && (paramInt != 3));
      LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561269, this, true);
      this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView = ((ImageSwitchAnimView)findViewById(2131370833));
      this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView = ((ImageAlphaSwitchView)findViewById(2131372117));
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqPortalImageShakeAnimView.a();
  }
  
  public void b(Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Int == 1) {
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null)) {
        break label53;
      }
    }
    for (;;)
    {
      return;
      if (((this.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int != 3)) || ((this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView != null) && (this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView != null)))
      {
        label53:
        Bitmap localBitmap = paramBitmap;
        if (paramBitmap == null) {
          localBitmap = a(1);
        }
        if (localBitmap == null) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView != null)
        {
          if (this.jdField_a_of_type_Int != 3) {
            break label129;
          }
          this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.setGravity(3);
          this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.a(localBitmap);
        }
        while ((this.jdField_b_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_Int == 1))
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(localBitmap);
          return;
          label129:
          if (this.jdField_a_of_type_Int == 2)
          {
            this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.setGravity(17);
            this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.setImage(localBitmap);
            int k = localBitmap.getWidth();
            int m = localBitmap.getHeight();
            paramBitmap = this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.getLayoutParams();
            int n = paramBitmap.width;
            paramBitmap.width = ((int)(paramBitmap.height * (k * 1.0F / m)));
            if (QLog.isColorLevel()) {
              QLog.d("PrepareView", 2, "updateBusinessNameBitmap,bitmapWidth = " + k + ",bitmapHeight = " + m + ",lp.width = " + paramBitmap.width + ",lp.height = " + paramBitmap.height + ",originWidth = " + n);
            }
            this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.setLayoutParams(paramBitmap);
          }
        }
      }
    }
  }
  
  public void c() {}
  
  public void setBackground(Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, Bitmap paramBitmap5, Bitmap paramBitmap6)
  {
    if (this.jdField_a_of_type_Int < 0) {
      return;
    }
    if (paramBitmap1 != null) {}
    try
    {
      paramBitmap2 = getBackground();
      if ((paramBitmap2 == null) || (!(paramBitmap2 instanceof BitmapDrawable))) {
        break label161;
      }
      paramBitmap2 = ((BitmapDrawable)paramBitmap2).getBitmap();
      if (paramBitmap2 != paramBitmap1) {
        break label161;
      }
    }
    catch (Throwable paramBitmap1)
    {
      label41:
      break label41;
    }
    if (paramBitmap3 != null) {}
    label161:
    label190:
    try
    {
      paramBitmap1 = this.jdField_c_of_type_AndroidWidgetImageView.getDrawable();
      if ((paramBitmap1 == null) || (!(paramBitmap1 instanceof BitmapDrawable))) {
        break label190;
      }
      paramBitmap1 = ((BitmapDrawable)paramBitmap1).getBitmap();
      if (paramBitmap1 != paramBitmap3) {
        break label190;
      }
    }
    catch (Throwable paramBitmap1)
    {
      label77:
      break label77;
    }
    if (paramBitmap4 != null) {}
    for (;;)
    {
      try
      {
        paramBitmap1 = this.jdField_d_of_type_AndroidWidgetImageView.getDrawable();
        if ((paramBitmap1 == null) || (!(paramBitmap1 instanceof BitmapDrawable))) {
          continue;
        }
        paramBitmap1 = ((BitmapDrawable)paramBitmap1).getBitmap();
        if (paramBitmap1 != paramBitmap4) {
          continue;
        }
      }
      catch (Throwable paramBitmap1)
      {
        continue;
      }
      if (paramBitmap5 == null) {
        continue;
      }
      paramBitmap1 = this.jdField_e_of_type_AndroidWidgetImageView.getDrawable();
      if ((paramBitmap1 != null) && ((paramBitmap1 instanceof BitmapDrawable)) && (((BitmapDrawable)paramBitmap1).getBitmap() == paramBitmap5)) {
        break;
      }
      this.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap5);
      return;
      super.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap1));
      break label41;
      super.setBackgroundResource(2130845416);
      break label41;
      this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap3);
      break label77;
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845412);
      break label77;
      this.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap4);
      continue;
      this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130845413);
    }
    this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130845540);
  }
  
  public void setLogo(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    a(paramBitmap1);
    b(paramBitmap2);
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