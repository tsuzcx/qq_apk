package com.tencent.mobileqq.portal;

import agrl;
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
  public List a;
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
        k = 2130842672;
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
          k = 2130842673;
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
            k = 2130842620;
          }
          else
          {
            k = m;
            if (paramInt == 1) {
              k = 2130842621;
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
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Int < 0) {
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null) {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
    }
    this.jdField_a_of_type_AndroidOsCountDownTimer = new agrl(this, paramLong, 1000L);
    this.jdField_a_of_type_AndroidOsCountDownTimer.start();
  }
  
  /* Error */
  public void a(java.lang.String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_0
    //   4: getfield 33	com/tencent/mobileqq/portal/PrepareView:jdField_a_of_type_Int	I
    //   7: ifge +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 164	com/tencent/mobileqq/portal/PrepareView:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   15: bipush 8
    //   17: invokevirtual 162	android/widget/RelativeLayout:setVisibility	(I)V
    //   20: aload_1
    //   21: invokestatic 183	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifeq +13 -> 37
    //   27: aload_0
    //   28: getfield 158	com/tencent/mobileqq/portal/PrepareView:jdField_b_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   31: bipush 8
    //   33: invokevirtual 162	android/widget/RelativeLayout:setVisibility	(I)V
    //   36: return
    //   37: aload_0
    //   38: getfield 158	com/tencent/mobileqq/portal/PrepareView:jdField_b_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   41: iconst_0
    //   42: invokevirtual 162	android/widget/RelativeLayout:setVisibility	(I)V
    //   45: aload_1
    //   46: invokestatic 183	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   49: ifne -39 -> 10
    //   52: aload_1
    //   53: invokevirtual 189	java/lang/String:length	()I
    //   56: istore_2
    //   57: aload_1
    //   58: iconst_0
    //   59: iconst_2
    //   60: invokevirtual 193	java/lang/String:substring	(II)Ljava/lang/String;
    //   63: astore 4
    //   65: aload_1
    //   66: iconst_3
    //   67: iconst_5
    //   68: invokevirtual 193	java/lang/String:substring	(II)Ljava/lang/String;
    //   71: astore_3
    //   72: aload_1
    //   73: iload_2
    //   74: iconst_5
    //   75: isub
    //   76: iload_2
    //   77: iconst_3
    //   78: isub
    //   79: invokevirtual 193	java/lang/String:substring	(II)Ljava/lang/String;
    //   82: astore 5
    //   84: aload_1
    //   85: iload_2
    //   86: iconst_2
    //   87: isub
    //   88: iload_2
    //   89: invokevirtual 193	java/lang/String:substring	(II)Ljava/lang/String;
    //   92: astore_1
    //   93: aload 4
    //   95: astore 7
    //   97: aload 5
    //   99: astore 6
    //   101: aload_1
    //   102: astore 4
    //   104: aload_0
    //   105: getfield 195	com/tencent/mobileqq/portal/PrepareView:jdField_d_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   108: aload 7
    //   110: invokevirtual 201	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   113: aload_0
    //   114: getfield 203	com/tencent/mobileqq/portal/PrepareView:jdField_e_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   117: aload_3
    //   118: invokevirtual 201	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   121: aload_0
    //   122: getfield 205	com/tencent/mobileqq/portal/PrepareView:jdField_f_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   125: aload 6
    //   127: invokevirtual 201	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   130: aload_0
    //   131: getfield 207	com/tencent/mobileqq/portal/PrepareView:jdField_g_of_type_AndroidWidgetTextView	Landroid/widget/TextView;
    //   134: aload 4
    //   136: invokevirtual 201	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   139: return
    //   140: astore 4
    //   142: aconst_null
    //   143: astore_3
    //   144: aconst_null
    //   145: astore 5
    //   147: aconst_null
    //   148: astore_1
    //   149: aload 4
    //   151: invokevirtual 210	java/lang/IndexOutOfBoundsException:printStackTrace	()V
    //   154: aload 7
    //   156: astore 4
    //   158: aload_1
    //   159: astore 6
    //   161: aload 5
    //   163: astore 7
    //   165: goto -61 -> 104
    //   168: astore 6
    //   170: aconst_null
    //   171: astore_3
    //   172: aconst_null
    //   173: astore_1
    //   174: aload 4
    //   176: astore 5
    //   178: aload 6
    //   180: astore 4
    //   182: goto -33 -> 149
    //   185: astore 6
    //   187: aconst_null
    //   188: astore_1
    //   189: aload 4
    //   191: astore 5
    //   193: aload 6
    //   195: astore 4
    //   197: goto -48 -> 149
    //   200: astore 6
    //   202: aload 5
    //   204: astore_1
    //   205: aload 4
    //   207: astore 5
    //   209: aload 6
    //   211: astore 4
    //   213: goto -64 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	PrepareView
    //   0	216	1	paramString	java.lang.String
    //   56	33	2	k	int
    //   71	101	3	str1	java.lang.String
    //   63	72	4	str2	java.lang.String
    //   140	10	4	localIndexOutOfBoundsException1	java.lang.IndexOutOfBoundsException
    //   156	56	4	localObject1	Object
    //   82	126	5	localObject2	Object
    //   99	61	6	localObject3	Object
    //   168	11	6	localIndexOutOfBoundsException2	java.lang.IndexOutOfBoundsException
    //   185	9	6	localIndexOutOfBoundsException3	java.lang.IndexOutOfBoundsException
    //   200	10	6	localIndexOutOfBoundsException4	java.lang.IndexOutOfBoundsException
    //   1	163	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   57	65	140	java/lang/IndexOutOfBoundsException
    //   65	72	168	java/lang/IndexOutOfBoundsException
    //   72	84	185	java/lang/IndexOutOfBoundsException
    //   84	93	200	java/lang/IndexOutOfBoundsException
  }
  
  public boolean a(int paramInt)
  {
    a();
    removeAllViews();
    if (paramInt == 1)
    {
      LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970375, this, true);
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131362828));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370232));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370242));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370244));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370246));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370245));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131370234));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370235));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370237));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370239));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370241));
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370236));
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370240));
      this.j = ((TextView)findViewById(2131370238));
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
      this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370224));
      this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370225));
      this.jdField_e_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370233));
      this.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370230));
      this.jdField_h_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370229));
      this.jdField_g_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370228));
      this.jdField_i_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131370226));
      localObject = (RelativeLayout.LayoutParams)this.jdField_i_of_type_AndroidWidgetImageView.getLayoutParams();
      if (localObject != null)
      {
        ((RelativeLayout.LayoutParams)localObject).topMargin = ImmersiveUtils.a(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_i_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = new RelativeLayout.LayoutParams(AIOUtils.a(475.0F, getResources()), AIOUtils.a(300.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      addView(this.jdField_a_of_type_ComTencentMobileqqPortalImageShakeAnimView, 0, (ViewGroup.LayoutParams)localObject);
      return true;
      if ((paramInt != 2) && (paramInt != 3)) {
        break;
      }
      LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130970374, this, true);
      this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView = ((ImageSwitchAnimView)findViewById(2131362828));
      this.jdField_a_of_type_ComTencentMobileqqPortalImageAlphaSwitchView = ((ImageAlphaSwitchView)findViewById(2131370232));
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
        this.jdField_e_of_type_AndroidWidgetImageView.setImageResource(2130842647);
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
  
  public void setLogoConfigList(List paramList)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PrepareView
 * JD-Core Version:    0.7.0.1
 */