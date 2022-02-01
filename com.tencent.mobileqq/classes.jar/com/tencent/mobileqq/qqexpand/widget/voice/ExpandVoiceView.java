package com.tencent.mobileqq.qqexpand.widget.voice;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.qqexpand.api.R.styleable;
import com.tencent.mobileqq.qqexpand.manager.IExpandManagerProxy;
import com.tencent.mobileqq.qqexpand.utils.ExpandResourceUtil;
import com.tencent.mobileqq.qqexpand.utils.GradientDrawableUtils;
import com.tencent.mobileqq.qqexpand.utils.ProfileGuideDialogUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class ExpandVoiceView
  extends FrameLayout
  implements View.OnClickListener, ExpandVoicePlayer.ExtendFriendVoicePlayerListener
{
  private static final Map<String, WeakReference<Bitmap>> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static final int[] jdField_a_of_type_ArrayOfInt = { -13900833, -37464, -12331403, -5544982 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { -14167603, -1350502, -12728981, -6464553 };
  private final int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  Paint jdField_a_of_type_AndroidGraphicsPaint;
  private final View jdField_a_of_type_AndroidViewView;
  private final TextView jdField_a_of_type_AndroidWidgetTextView;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private ExpandVoicePlayer jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoicePlayer;
  private ExpandVoiceView.DeleteIconClickListener jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView$DeleteIconClickListener;
  private final FrameAnimationDrawable jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceFrameAnimationDrawable;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private int jdField_b_of_type_Int = 1;
  private long jdField_b_of_type_Long;
  private final View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private final View jdField_c_of_type_AndroidViewView;
  private boolean jdField_c_of_type_Boolean;
  private final View d;
  
  public ExpandVoiceView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExpandVoiceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExpandVoiceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.V).getInteger(R.styleable.jdField_a_of_type_Int, 0);
    LayoutInflater.from(paramContext).inflate(2131561061, this, true);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131380981);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131368709);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131380059));
    this.jdField_c_of_type_AndroidViewView = findViewById(2131368656);
    this.d = findViewById(2131368657);
    this.d.setOnClickListener(this);
    this.d.setOnTouchListener(ProfileGuideDialogUtils.a);
    e();
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceFrameAnimationDrawable = new FrameAnimationDrawable();
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceFrameAnimationDrawable.a(3000L);
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceFrameAnimationDrawable.a(true);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
  }
  
  private Bitmap a(String paramString)
  {
    String[] arrayOfString = ExpandResourceUtil.d;
    boolean bool = TextUtils.isEmpty(paramString);
    String str = null;
    Object localObject2 = null;
    Object localObject1 = str;
    if (!bool)
    {
      localObject1 = str;
      if (arrayOfString != null)
      {
        localObject1 = str;
        if (arrayOfString.length > 0)
        {
          this.jdField_c_of_type_Int = (paramString.toUpperCase().charAt(0) % arrayOfString.length);
          str = ExpandResourceUtil.a(arrayOfString[this.jdField_c_of_type_Int]);
          localObject1 = (WeakReference)jdField_a_of_type_JavaUtilMap.get(str);
          paramString = localObject2;
          if (localObject1 != null) {
            paramString = (Bitmap)((WeakReference)localObject1).get();
          }
          if (paramString != null)
          {
            localObject1 = paramString;
            if (!paramString.isRecycled()) {}
          }
          else
          {
            paramString = new BitmapFactory.Options();
            paramString.inPreferredConfig = Bitmap.Config.RGB_565;
            localObject1 = ExpandResourceUtil.a(str, paramString);
            jdField_a_of_type_JavaUtilMap.put(str, new WeakReference(localObject1));
          }
        }
      }
    }
    return localObject1;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_AndroidViewView != null)
    {
      float f = DisplayUtil.a(getContext(), 50.0F);
      GradientDrawable localGradientDrawable1 = GradientDrawableUtils.a(paramInt1, f, f, f, f);
      GradientDrawable localGradientDrawable2 = GradientDrawableUtils.a(paramInt2, f, f, f, f);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { 16842919 }, localGradientDrawable2);
      localStateListDrawable.addState(new int[0], localGradientDrawable1);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
    }
  }
  
  private void e()
  {
    ThreadManager.post(new ExpandVoiceView.1(this), 5, null, true);
  }
  
  private void f()
  {
    if (getVisibility() == 0)
    {
      int i = this.jdField_b_of_type_Int;
      if ((i == 1) || (i == 3))
      {
        int k = getWidth() - DisplayUtil.a(getContext(), 22.0F);
        if (k > 0)
        {
          int j = DisplayUtil.a(getContext(), 110.0F);
          Object localObject = this.d;
          if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {
            i = DisplayUtil.a(getContext(), 33.0F);
          } else {
            i = 0;
          }
          k = k - j - i;
          int m = (int)(k * Math.min((float)this.jdField_a_of_type_Long / (float)this.jdField_b_of_type_Long, 1.0F));
          if (m >= 0)
          {
            localObject = this.jdField_a_of_type_AndroidViewView;
            if (localObject != null)
            {
              localObject = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
              ((FrameLayout.LayoutParams)localObject).width = (j + i + m);
              this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
              post(new ExpandVoiceView.2(this));
              QLog.d("ExtendFriendVoiceView", 2, String.format("updateBubbleSize mVoiceDuration=%s mMaxVoiceDuration=%s maxWidth=%s increaseWidth=%s layoutParams.width=%s this=%s", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(this.jdField_b_of_type_Long), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(((FrameLayout.LayoutParams)localObject).width), this }));
            }
          }
        }
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("playVoice mVoiceUrl=%s", new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoicePlayer == null) {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoicePlayer = new ExpandVoicePlayer(this, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoicePlayer.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_b_of_type_Boolean = true;
      c();
      return;
    }
    catch (Exception localException)
    {
      label84:
      break label84;
    }
    QLog.e("ExtendFriendVoiceView", 1, "playVoice fail.");
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("onDownloadFailed errCode=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    b();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("playerCompletion mVoiceUrl=%s", new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
    ThreadManager.getUIHandler().post(new ExpandVoiceView.3(this));
    paramString = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoicePlayer;
    if (paramString != null) {
      paramString.b();
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
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("onFocusChanged focused=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    }
    if (!paramBoolean) {
      b();
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
    ExpandVoicePlayer localExpandVoicePlayer = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoicePlayer;
    if (localExpandVoicePlayer != null) {}
    try
    {
      localExpandVoicePlayer.a();
      this.jdField_b_of_type_Boolean = false;
      d();
      return;
    }
    catch (Exception localException)
    {
      label53:
      break label53;
    }
    QLog.e("ExtendFriendVoiceView", 1, "stopVoice fail.");
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.jdField_a_of_type_AndroidViewView != null))
    {
      int i = (int)(getContext().getResources().getDisplayMetrics().density * 20.0F);
      BaseAIOUtils.a(this.jdField_a_of_type_AndroidViewView, i, i, i, i);
    }
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Int != 3)
    {
      int i = this.jdField_c_of_type_Int;
      View localView = null;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              localObject1 = null;
            } else {
              localObject1 = "expand_animate_logo4";
            }
          }
          else {
            localObject1 = "expand_animate_logo3";
          }
        }
        else {
          localObject1 = "expand_animate_logo2";
        }
      }
      else {
        localObject1 = "expand_animate_logo1";
      }
      Object localObject2 = localView;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = new File(ExpandResourceUtil.a((String)localObject1));
        localObject2 = localView;
        if (((File)localObject1).exists())
        {
          File[] arrayOfFile = ((File)localObject1).listFiles();
          localObject2 = localView;
          if (arrayOfFile != null)
          {
            localObject2 = localView;
            if (arrayOfFile.length > 0)
            {
              localObject1 = new String[arrayOfFile.length];
              i = 0;
              for (;;)
              {
                localObject2 = localObject1;
                if (i >= arrayOfFile.length) {
                  break;
                }
                localObject1[i] = arrayOfFile[i].getAbsolutePath();
                i += 1;
              }
            }
          }
        }
      }
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceFrameAnimationDrawable;
        if (localObject1 != null)
        {
          localView = this.jdField_c_of_type_AndroidViewView;
          if (localView != null) {
            localView.setBackgroundDrawable((Drawable)localObject1);
          }
          this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceFrameAnimationDrawable.a((String[])localObject2);
          this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceFrameAnimationDrawable.a();
        }
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if (localObject1 != null) {
      ((LottieDrawable)localObject1).playAnimation();
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceFrameAnimationDrawable;
    if (localObject != null) {
      ((FrameAnimationDrawable)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
    if (localObject != null) {
      ((LottieDrawable)localObject).endAnimation();
    }
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      localObject = a(this.jdField_b_of_type_JavaLangString);
      if (localObject != null) {
        this.jdField_c_of_type_AndroidViewView.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
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
  
  public void onClick(View paramView)
  {
    ExpandVoiceView.DeleteIconClickListener localDeleteIconClickListener;
    if (paramView.getId() == 2131368657)
    {
      localDeleteIconClickListener = this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView$DeleteIconClickListener;
      if (localDeleteIconClickListener == null) {}
    }
    try
    {
      localDeleteIconClickListener.a();
      label24:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    f();
  }
  
  public void setActivity(QBaseActivity paramQBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_b_of_type_Long = ((IExpandManagerProxy)QRoute.api(IExpandManagerProxy.class)).getVoiceMaxDuration(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime());
  }
  
  public void setDeleteIconEnable(boolean paramBoolean, ExpandVoiceView.DeleteIconClickListener paramDeleteIconClickListener)
  {
    View localView = this.d;
    if (localView != null)
    {
      int i;
      if (paramBoolean) {
        i = 0;
      } else {
        i = 8;
      }
      localView.setVisibility(i);
    }
    this.jdField_a_of_type_ComTencentMobileqqQqexpandWidgetVoiceExpandVoiceView$DeleteIconClickListener = paramDeleteIconClickListener;
  }
  
  public void setMode(int paramInt)
  {
    int i10 = DisplayUtil.a(getContext(), 35.0F);
    int i1 = DisplayUtil.a(getContext(), 22.0F);
    int i = DisplayUtil.a(getContext(), 19.0F);
    int j = DisplayUtil.a(getContext(), 19.0F);
    int k = DisplayUtil.a(getContext(), 40.0F);
    int i9 = DisplayUtil.a(getContext(), 30.0F);
    int i8 = DisplayUtil.a(getContext(), 70.0F);
    int m = DisplayUtil.a(getContext(), 10.0F);
    int i7 = DisplayUtil.a(getContext(), 60.0F);
    int i6 = DisplayUtil.a(getContext(), 49.0F);
    this.jdField_b_of_type_Int = paramInt;
    int i12 = this.jdField_b_of_type_Int;
    int i11 = -2;
    float f2 = 14.0F;
    int i5;
    int n;
    int i2;
    float f1;
    int i3;
    int i4;
    if (i12 == 2)
    {
      i5 = -1;
      n = (int)(i10 * 0.8F);
      paramInt = (int)(i1 * 0.8F);
      i = (int)(i * 0.8F);
      j = (int)(j * 0.8F);
      k = (int)(k * 0.8F);
      i1 = (int)(i9 * 0.8F);
      i2 = (int)(i8 * 0.8F);
      m = (int)(m * 0.8F);
      f1 = 11.2F;
      i3 = (int)(i7 * 0.8F);
      i4 = (int)(i6 * 0.8F);
    }
    else
    {
      n = i10;
      paramInt = i1;
      i1 = i9;
      i2 = i8;
      i3 = i7;
      i4 = i6;
      i5 = i11;
      f1 = f2;
      if (i12 == 3)
      {
        paramInt = 0;
        k = ViewUtils.a(20.0F);
        m = ViewUtils.a(16.0F);
        i = ViewUtils.a(16.0F);
        j = ViewUtils.a(17.0F);
        f1 = f2;
        i5 = i11;
        i4 = i6;
        i3 = i7;
        i2 = i8;
        i1 = i9;
        n = i10;
      }
    }
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject != null)
    {
      localObject = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).width = i5;
      ((FrameLayout.LayoutParams)localObject).height = n;
      ((FrameLayout.LayoutParams)localObject).leftMargin = paramInt;
    }
    localObject = this.jdField_b_of_type_AndroidViewView;
    if (localObject != null)
    {
      localObject = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).width = i;
      ((FrameLayout.LayoutParams)localObject).height = j;
      ((FrameLayout.LayoutParams)localObject).leftMargin = k;
    }
    localObject = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject != null)
    {
      localObject = (LinearLayout.LayoutParams)((TextView)localObject).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).width = i1;
      ((LinearLayout.LayoutParams)localObject).leftMargin = i2;
      ((LinearLayout.LayoutParams)localObject).rightMargin = m;
      this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, f1);
    }
    localObject = this.jdField_c_of_type_AndroidViewView;
    if (localObject != null)
    {
      if (this.jdField_b_of_type_Int == 3)
      {
        ((View)localObject).setVisibility(8);
        return;
      }
      localObject = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).width = i3;
      ((FrameLayout.LayoutParams)localObject).height = i4;
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_b_of_type_Int == 1)
    {
      View localView = this.jdField_a_of_type_AndroidViewView;
      if (localView != null)
      {
        localView.setOnClickListener(paramOnClickListener);
        return;
      }
    }
    super.setOnClickListener(paramOnClickListener);
  }
  
  public void setVoiceDuration(long paramLong)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("\"");
      localObject = ((StringBuilder)localObject).toString().intern();
      this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
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
      View localView = this.jdField_c_of_type_AndroidViewView;
      if ((localView != null) && (paramString != null)) {
        localView.setBackgroundDrawable(new BitmapDrawable(paramString));
      }
      int i = MD5Utils.toMD5(this.jdField_b_of_type_JavaLangString).toUpperCase().charAt(0);
      paramString = jdField_a_of_type_ArrayOfInt;
      i %= paramString.length;
      a(paramString[i], jdField_b_of_type_ArrayOfInt[i]);
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
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoiceView
 * JD-Core Version:    0.7.0.1
 */