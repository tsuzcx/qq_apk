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
    int k = this.jdField_a_of_type_Int;
    if (k == 1)
    {
      if (paramInt == 0)
      {
        paramInt = 2130845455;
        break label64;
      }
      if (paramInt == 1)
      {
        paramInt = 2130845456;
        break label64;
      }
    }
    else if ((k == 2) || (k == 3))
    {
      if (paramInt == 0)
      {
        paramInt = 2130845277;
        break label64;
      }
      if (paramInt == 1)
      {
        paramInt = 2130845278;
        break label64;
      }
    }
    paramInt = 0;
    label64:
    if (paramInt != 0)
    {
      Drawable localDrawable = getResources().getDrawable(paramInt);
      if ((localDrawable instanceof SkinnableBitmapDrawable)) {
        return ((SkinnableBitmapDrawable)localDrawable).getBitmap();
      }
      if ((localDrawable instanceof BitmapDrawable)) {
        return ((BitmapDrawable)localDrawable).getBitmap();
      }
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Int < 0) {
      return;
    }
    CountDownTimer localCountDownTimer = this.jdField_a_of_type_AndroidOsCountDownTimer;
    if (localCountDownTimer != null)
    {
      localCountDownTimer.cancel();
      this.jdField_a_of_type_AndroidOsCountDownTimer = null;
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startTimeDown time = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(",mMode = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
      QLog.d("PrepareView", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_Int < 0) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    Object localObject = this.jdField_a_of_type_AndroidOsCountDownTimer;
    if (localObject != null) {
      ((CountDownTimer)localObject).cancel();
    }
    this.jdField_a_of_type_AndroidOsCountDownTimer = new PrepareView.1(this, paramLong, 1000L);
    this.jdField_a_of_type_AndroidOsCountDownTimer.start();
  }
  
  public void a(Bitmap paramBitmap)
  {
    int k = this.jdField_a_of_type_Int;
    if (k == 1)
    {
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null)) {}
    }
    else if ((k == 2) || (k == 3))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView == null) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView == null) {
        return;
      }
    }
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      localBitmap = a(0);
    }
    if (localBitmap != null)
    {
      paramBitmap = this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView;
      if (paramBitmap != null)
      {
        k = this.jdField_a_of_type_Int;
        if (k == 3) {
          paramBitmap.a(localBitmap);
        } else if (k == 2) {
          paramBitmap.setLogo(localBitmap);
        }
      }
      paramBitmap = this.jdField_a_of_type_AndroidWidgetImageView;
      if ((paramBitmap != null) && (this.jdField_a_of_type_Int == 1)) {
        paramBitmap.setImageBitmap(localBitmap);
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    a();
    removeAllViews();
    if (paramInt == 1)
    {
      LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561113, this, true);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370464));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131371699));
    }
    else
    {
      if ((paramInt != 2) && (paramInt != 3)) {
        return false;
      }
      LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561112, this, true);
      this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView = ((ImageSwitchAnimView)findViewById(2131370464));
      this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView = ((ImageAlphaSwitchView)findViewById(2131371699));
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131378701));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378697));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378698));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378700));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131365997));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378689));
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378690));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131378691));
    this.g = ((TextView)findViewById(2131378692));
    this.h = ((TextView)findViewById(2131368917));
    this.i = ((TextView)findViewById(2131368918));
    this.j = ((TextView)findViewById(2131370068));
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
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131369928));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131376540));
    this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131381181));
    this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365266));
    localObject = (RelativeLayout.LayoutParams)this.jdField_f_of_type_AndroidWidgetImageView.getLayoutParams();
    if (localObject != null)
    {
      ((RelativeLayout.LayoutParams)localObject).topMargin = AIOUtils.b(25.0F, getResources());
      this.jdField_f_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    paramInt = AIOUtils.b(475.0F, getResources());
    int k = AIOUtils.b(335.0F, getResources());
    this.jdField_a_of_type_ComTencentMobileqqPortalImageShakeAnimView = new ImageShakeAnimView(this.jdField_a_of_type_AndroidContentContext, paramInt, k, (getResources().getDisplayMetrics().widthPixels - paramInt) / 2, 0, Integer.valueOf(2130845405), true);
    localObject = new RelativeLayout.LayoutParams(paramInt, k);
    ((RelativeLayout.LayoutParams)localObject).addRule(14);
    addView(this.jdField_a_of_type_ComTencentMobileqqPortalImageShakeAnimView, 0, (ViewGroup.LayoutParams)localObject);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqPortalImageShakeAnimView.a();
  }
  
  public void b(Bitmap paramBitmap)
  {
    int k = this.jdField_a_of_type_Int;
    if (k == 1)
    {
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null)) {}
    }
    else if ((k == 2) || (k == 3))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView == null) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView == null) {
        return;
      }
    }
    Bitmap localBitmap = paramBitmap;
    if (paramBitmap == null) {
      localBitmap = a(1);
    }
    if (localBitmap != null)
    {
      paramBitmap = this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView;
      if (paramBitmap != null)
      {
        k = this.jdField_a_of_type_Int;
        if (k == 3)
        {
          paramBitmap.setGravity(3);
          this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.a(localBitmap);
        }
        else if (k == 2)
        {
          paramBitmap.setGravity(17);
          this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.setImage(localBitmap);
          k = localBitmap.getWidth();
          int m = localBitmap.getHeight();
          paramBitmap = this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.getLayoutParams();
          int n = paramBitmap.width;
          paramBitmap.width = ((int)(paramBitmap.height * (k * 1.0F / m)));
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("updateBusinessNameBitmap,bitmapWidth = ");
            localStringBuilder.append(k);
            localStringBuilder.append(",bitmapHeight = ");
            localStringBuilder.append(m);
            localStringBuilder.append(",lp.width = ");
            localStringBuilder.append(paramBitmap.width);
            localStringBuilder.append(",lp.height = ");
            localStringBuilder.append(paramBitmap.height);
            localStringBuilder.append(",originWidth = ");
            localStringBuilder.append(n);
            QLog.d("PrepareView", 2, localStringBuilder.toString());
          }
          this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView.setLayoutParams(paramBitmap);
        }
      }
      paramBitmap = this.jdField_b_of_type_AndroidWidgetImageView;
      if ((paramBitmap != null) && (this.jdField_a_of_type_Int == 1)) {
        paramBitmap.setImageBitmap(localBitmap);
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
      if ((paramBitmap2 != null) && ((paramBitmap2 instanceof BitmapDrawable)) && (((BitmapDrawable)paramBitmap2).getBitmap() == paramBitmap1)) {
        break label68;
      }
      super.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap1));
    }
    catch (Throwable paramBitmap1)
    {
      label68:
      break label68;
    }
    super.setBackgroundResource(2130845289);
    if (paramBitmap3 != null) {}
    label187:
    try
    {
      paramBitmap1 = this.jdField_c_of_type_AndroidWidgetImageView.getDrawable();
      if ((paramBitmap1 != null) && ((paramBitmap1 instanceof BitmapDrawable)) && (((BitmapDrawable)paramBitmap1).getBitmap() == paramBitmap3)) {
        break label126;
      }
      this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap3);
    }
    catch (Throwable paramBitmap1)
    {
      label126:
      break label126;
    }
    this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130845285);
    if (paramBitmap4 != null) {}
    try
    {
      paramBitmap1 = this.jdField_d_of_type_AndroidWidgetImageView.getDrawable();
      if ((paramBitmap1 != null) && ((paramBitmap1 instanceof BitmapDrawable)) && (((BitmapDrawable)paramBitmap1).getBitmap() == paramBitmap4)) {
        break label187;
      }
      this.jdField_d_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap4);
    }
    catch (Throwable paramBitmap1)
    {
      break label187;
    }
    this.jdField_d_of_type_AndroidWidgetImageView.setImageResource(2130845286);
    if (paramBitmap5 != null)
    {
      paramBitmap1 = this.jdField_e_of_type_AndroidWidgetImageView.getDrawable();
      if ((paramBitmap1 == null) || (!(paramBitmap1 instanceof BitmapDrawable)) || (((BitmapDrawable)paramBitmap1).getBitmap() != paramBitmap5)) {
        this.jdField_e_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap5);
      }
    }
    else
    {
      this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130845413);
    }
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
        if (localLogoConfig != null)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("prepareview, setLogoConfigList, index=");
          localStringBuilder.append(k);
          localStringBuilder.append(", p=");
          localStringBuilder.append(localLogoConfig.toString());
          QLog.d("PortalManager", 2, localStringBuilder.toString());
        }
        k += 1;
      }
    }
  }
  
  public void setMode(int paramInt)
  {
    if (((paramInt != 1) && (paramInt != 2) && (paramInt != 3)) || (this.jdField_a_of_type_Int == paramInt)) {
      return;
    }
    if (a(paramInt)) {
      this.jdField_a_of_type_Int = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PrepareView
 * JD-Core Version:    0.7.0.1
 */