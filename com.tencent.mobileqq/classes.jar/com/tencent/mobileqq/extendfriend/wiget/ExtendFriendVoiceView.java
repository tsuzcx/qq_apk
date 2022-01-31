package com.tencent.mobileqq.extendfriend.wiget;

import aepi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import aqbg;
import aqbj;
import aqhh;
import aqhs;
import aqhu;
import aqhv;
import aqhx;
import aqim;
import aqin;
import bdoo;
import bflr;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class ExtendFriendVoiceView
  extends FrameLayout
  implements View.OnClickListener, aqhu
{
  private static Map<String, WeakReference<Bitmap>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static final int[] jdField_a_of_type_ArrayOfInt = { -13900833, -37464, -12331403, -5544982 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { -14167603, -1350502, -12728981, -6464553 };
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private aqhs jdField_a_of_type_Aqhs;
  private aqim jdField_a_of_type_Aqim;
  private aqin jdField_a_of_type_Aqin;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private final int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  private View jdField_d_of_type_AndroidViewView;
  private boolean jdField_d_of_type_Boolean;
  
  public ExtendFriendVoiceView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExtendFriendVoiceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExtendFriendVoiceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_c_of_type_Int = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ExtendFriendView).getInteger(0, 0);
    LayoutInflater.from(paramContext).inflate(2131560965, this, true);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131380076);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131368171);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379182));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131368122);
    this.jdField_d_of_type_AndroidViewView = findViewById(2131368123);
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_d_of_type_AndroidViewView.setOnTouchListener(aqhx.a);
    e();
    this.jdField_a_of_type_Aqin = new aqin();
    this.jdField_a_of_type_Aqin.a(3000L);
    this.jdField_a_of_type_Aqin.a(true);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
  }
  
  private Bitmap a(String paramString)
  {
    Object localObject = aqhh.d;
    if ((!TextUtils.isEmpty(paramString)) && (localObject != null) && (localObject.length > 0))
    {
      this.jdField_b_of_type_Int = (paramString.toUpperCase().charAt(0) % localObject.length);
      String str = aqhh.a(localObject[this.jdField_b_of_type_Int]);
      paramString = (WeakReference)jdField_a_of_type_JavaUtilMap.get(str);
      if (paramString != null) {}
      for (paramString = (Bitmap)paramString.get();; paramString = null)
      {
        if (paramString != null)
        {
          localObject = paramString;
          if (!paramString.isRecycled()) {}
        }
        else
        {
          paramString = new BitmapFactory.Options();
          paramString.inPreferredConfig = Bitmap.Config.RGB_565;
          localObject = aqhh.a(str, paramString);
          jdField_a_of_type_JavaUtilMap.put(str, new WeakReference(localObject));
        }
        return localObject;
      }
    }
    return null;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      int i = aepi.a(50.0F, getResources());
      GradientDrawable localGradientDrawable1 = aqhv.a(paramInt1, i, i, i, i);
      GradientDrawable localGradientDrawable2 = aqhv.a(paramInt2, i, i, i, i);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { 16842919 }, localGradientDrawable2);
      localStateListDrawable.addState(new int[0], localGradientDrawable1);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
    }
  }
  
  private void e()
  {
    ThreadManager.post(new ExtendFriendVoiceView.1(this), 5, null, true);
  }
  
  private void f()
  {
    int k;
    int j;
    if ((getVisibility() == 0) && ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 3)))
    {
      k = getWidth() - aepi.a(22.0F, getResources());
      if (k > 0)
      {
        j = aepi.a(110.0F, getResources());
        if ((this.jdField_d_of_type_AndroidViewView == null) || (this.jdField_d_of_type_AndroidViewView.getVisibility() != 0)) {
          break label235;
        }
      }
    }
    label235:
    for (int i = aepi.a(33.0F, getResources());; i = 0)
    {
      k = k - j - i;
      int m = (int)(k * Math.min((float)this.jdField_a_of_type_Long / (float)this.jdField_b_of_type_Long, 1.0F));
      if ((m >= 0) && (this.jdField_a_of_type_AndroidViewView != null))
      {
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        localLayoutParams.width = (i + j + m);
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
        post(new ExtendFriendVoiceView.2(this));
        QLog.d("ExtendFriendVoiceView", 2, String.format("updateBubbleSize mVoiceDuration=%s mMaxVoiceDuration=%s maxWidth=%s increaseWidth=%s layoutParams.width=%s this=%s", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(this.jdField_b_of_type_Long), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(localLayoutParams.width), this }));
      }
      return;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("playVoice mVoiceUrl=%s", new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
    if (this.jdField_a_of_type_Aqhs == null) {
      this.jdField_a_of_type_Aqhs = new aqhs(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    try
    {
      this.jdField_a_of_type_Aqhs.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_b_of_type_Boolean = true;
      c();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ExtendFriendVoiceView", 1, "playVoice fail.");
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("playerCompletion mVoiceUrl=%s", new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
    ThreadManager.getUIHandler().post(new ExtendFriendVoiceView.3(this));
    if (this.jdField_a_of_type_Aqhs != null) {
      this.jdField_a_of_type_Aqhs.b();
    }
  }
  
  public void a(File paramFile)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("onDownloadFinish path=%s", new Object[] { paramFile.getAbsoluteFile() }));
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      int i = (int)(getContext().getResources().getDisplayMetrics().density * 20.0F);
      aepi.a(this.jdField_a_of_type_AndroidViewView, i, i, i, i);
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("stopVoice mVoiceUrl=%s", new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
    if (this.jdField_a_of_type_Aqhs != null) {}
    try
    {
      this.jdField_a_of_type_Aqhs.a();
      this.jdField_b_of_type_Boolean = false;
      d();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ExtendFriendVoiceView", 1, "stopVoice fail.");
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void c()
  {
    Object localObject3 = null;
    if (this.jdField_a_of_type_Int != 3)
    {
      Object localObject1;
      switch (this.jdField_b_of_type_Int)
      {
      default: 
        localObject1 = null;
      }
      Object localObject2;
      for (;;)
      {
        localObject2 = localObject3;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        localObject1 = new File(aqhh.a((String)localObject1));
        localObject2 = localObject3;
        if (!((File)localObject1).exists()) {
          break;
        }
        File[] arrayOfFile = ((File)localObject1).listFiles();
        localObject2 = localObject3;
        if (arrayOfFile == null) {
          break;
        }
        localObject2 = localObject3;
        if (arrayOfFile.length <= 0) {
          break;
        }
        localObject1 = new String[arrayOfFile.length];
        int i = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (i >= arrayOfFile.length) {
            break;
          }
          localObject1[i] = arrayOfFile[i].getAbsolutePath();
          i += 1;
        }
        localObject1 = "expand_animate_logo1";
        continue;
        localObject1 = "expand_animate_logo2";
        continue;
        localObject1 = "expand_animate_logo3";
        continue;
        localObject1 = "expand_animate_logo4";
      }
      if ((localObject2 != null) && (localObject2.length > 0) && (this.jdField_a_of_type_Aqin != null))
      {
        if (this.jdField_c_of_type_AndroidViewView != null) {
          this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(this.jdField_a_of_type_Aqin);
        }
        this.jdField_a_of_type_Aqin.a(localObject2);
        this.jdField_a_of_type_Aqin.a();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("onFocusChanged focused=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (!paramBoolean) {
      b();
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Aqin != null) {
      this.jdField_a_of_type_Aqin.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.endAnimation();
    }
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      Bitmap localBitmap = a(this.jdField_b_of_type_JavaLangString);
      if (localBitmap != null) {
        this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(new BitmapDrawable(localBitmap));
      }
    }
    this.jdField_c_of_type_Boolean = false;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_Boolean) && ("1103".equals(ThemeUtil.curThemeId)))
    {
      if (this.jdField_a_of_type_AndroidGraphicsPaint.getColorFilter() == null) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
      }
      paramCanvas.saveLayer(null, this.jdField_a_of_type_AndroidGraphicsPaint, 31);
      super.dispatchDraw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public void f(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("onDownloadFailed errCode=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    b();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_Aqim == null);
    try
    {
      this.jdField_a_of_type_Aqim.a();
      return;
    }
    catch (Exception paramView) {}
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    f();
  }
  
  public void setActivity(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    paramBaseActivity = (aqbg)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(264);
    if (paramBaseActivity != null)
    {
      paramBaseActivity = paramBaseActivity.a();
      if (paramBaseActivity != null) {
        this.jdField_b_of_type_Long = paramBaseActivity.jdField_c_of_type_Int;
      }
    }
  }
  
  public void setDeleteIconEnable(boolean paramBoolean, aqim paramaqim)
  {
    View localView;
    if (this.jdField_d_of_type_AndroidViewView != null)
    {
      localView = this.jdField_d_of_type_AndroidViewView;
      if (!paramBoolean) {
        break label31;
      }
    }
    label31:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      this.jdField_a_of_type_Aqim = paramaqim;
      return;
    }
  }
  
  public void setMode(int paramInt)
  {
    int i4 = aepi.a(35.0F, getResources());
    int i3 = aepi.a(22.0F, getResources());
    int i2 = aepi.a(19.0F, getResources());
    int i1 = aepi.a(19.0F, getResources());
    int n = aepi.a(40.0F, getResources());
    int m = aepi.a(30.0F, getResources());
    int k = aepi.a(70.0F, getResources());
    int i5 = aepi.a(10.0F, getResources());
    int j = aepi.a(60.0F, getResources());
    int i = aepi.a(49.0F, getResources());
    this.jdField_a_of_type_Int = paramInt;
    int i6;
    float f;
    if (this.jdField_a_of_type_Int == 2)
    {
      i4 = (int)(i4 * 0.8F);
      i3 = (int)(i3 * 0.8F);
      i2 = (int)(i2 * 0.8F);
      i1 = (int)(i1 * 0.8F);
      n = (int)(n * 0.8F);
      m = (int)(m * 0.8F);
      k = (int)(k * 0.8F);
      paramInt = (int)(i5 * 0.8F);
      i6 = (int)(j * 0.8F);
      int i7 = (int)(i * 0.8F);
      i5 = -1;
      j = paramInt;
      f = 14.0F * 0.8F;
      i = i6;
      paramInt = i7;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).width = i5;
        ((FrameLayout.LayoutParams)localObject).height = i4;
        ((FrameLayout.LayoutParams)localObject).leftMargin = i3;
      }
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        localObject = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).width = i2;
        ((FrameLayout.LayoutParams)localObject).height = i1;
        ((FrameLayout.LayoutParams)localObject).leftMargin = n;
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).width = m;
        ((LinearLayout.LayoutParams)localObject).leftMargin = k;
        ((LinearLayout.LayoutParams)localObject).rightMargin = j;
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, f);
      }
      if (this.jdField_c_of_type_AndroidViewView != null)
      {
        if (this.jdField_a_of_type_Int == 3) {
          this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        }
      }
      else
      {
        return;
        if (this.jdField_a_of_type_Int != 3) {
          break label496;
        }
        n = bdoo.a(20.0F);
        i3 = bdoo.a(16.0F);
        i2 = bdoo.a(16.0F);
        i1 = bdoo.a(17.0F);
        i5 = -2;
        i6 = 0;
        f = 14.0F;
        paramInt = i;
        i = j;
        j = i3;
        i3 = i6;
        continue;
      }
      Object localObject = (FrameLayout.LayoutParams)this.jdField_c_of_type_AndroidViewView.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).width = i;
      ((FrameLayout.LayoutParams)localObject).height = paramInt;
      return;
      label496:
      i6 = -2;
      f = 14.0F;
      paramInt = i;
      i = j;
      j = i5;
      i5 = i6;
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if ((this.jdField_a_of_type_Int == 1) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(paramOnClickListener);
      return;
    }
    super.setOnClickListener(paramOnClickListener);
  }
  
  public void setVoiceDuration(long paramLong)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      String str = String.format("%s″", new Object[] { Long.valueOf(paramLong) });
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str);
      this.jdField_a_of_type_Long = paramLong;
      f();
    }
  }
  
  public void setVoiceFileMD5(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("setVoiceFileMD5 md5=%s", new Object[] { paramString }));
    }
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_b_of_type_JavaLangString = paramString.toUpperCase();
      paramString = a(this.jdField_b_of_type_JavaLangString);
      if ((this.jdField_c_of_type_AndroidViewView != null) && (paramString != null)) {
        this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(new BitmapDrawable(paramString));
      }
      int i = bflr.d(this.jdField_b_of_type_JavaLangString).toUpperCase().charAt(0) % jdField_a_of_type_ArrayOfInt.length;
      a(jdField_a_of_type_ArrayOfInt[i], jdField_b_of_type_ArrayOfInt[i]);
    }
  }
  
  public void setVoiceUrl(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      int i = this.jdField_a_of_type_JavaLangString.lastIndexOf('=');
      if (i >= 0) {
        setVoiceFileMD5(this.jdField_a_of_type_JavaLangString.substring(i + 1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView
 * JD-Core Version:    0.7.0.1
 */