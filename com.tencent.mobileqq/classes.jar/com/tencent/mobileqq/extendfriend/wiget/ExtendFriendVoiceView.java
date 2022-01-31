package com.tencent.mobileqq.extendfriend.wiget;

import acjz;
import ackb;
import ackc;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.dinifly.LottieDrawable;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager.ExtendFriendConfig;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendResourceUtil;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendVoicePlayer;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendVoicePlayer.ExtendFriendVoicePlayerListener;
import com.tencent.mobileqq.extendfriend.utils.GradientDrawableUtils;
import com.tencent.mobileqq.extendfriend.utils.ProfileGuideDialogUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class ExtendFriendVoiceView
  extends FrameLayout
  implements View.OnClickListener, ExtendFriendVoicePlayer.ExtendFriendVoicePlayerListener
{
  private static Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private static final int[] jdField_a_of_type_ArrayOfInt = { -13900833, -37464, -12331403, -5544982 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { -14167603, -1350502, -12728981, -6464553 };
  private int jdField_a_of_type_Int = 1;
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private LottieDrawable jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable;
  private ExtendFriendVoicePlayer jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer;
  private ExtendFriendVoiceView.DeleteIconClickListener jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView$DeleteIconClickListener;
  private FrameAnimationDrawable jdField_a_of_type_ComTencentMobileqqExtendfriendWigetFrameAnimationDrawable;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private String jdField_b_of_type_JavaLangString;
  private View c;
  private View d;
  
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
    LayoutInflater.from(paramContext).inflate(2130970338, this, true);
    this.jdField_a_of_type_AndroidViewView = findViewById(2131370103);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131370104);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370105));
    this.c = findViewById(2131369919);
    this.d = findViewById(2131366645);
    this.d.setOnClickListener(this);
    this.d.setOnTouchListener(ProfileGuideDialogUtils.a);
    c();
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetFrameAnimationDrawable = new FrameAnimationDrawable();
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetFrameAnimationDrawable.a(3000L);
    this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetFrameAnimationDrawable.a(true);
  }
  
  private Bitmap a(String paramString)
  {
    Object localObject = ExtendFriendResourceUtil.d;
    if ((localObject != null) && (localObject.length > 0))
    {
      this.jdField_b_of_type_Int = (paramString.toUpperCase().charAt(0) % localObject.length);
      String str = ExtendFriendResourceUtil.a(localObject[this.jdField_b_of_type_Int]);
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
          localObject = ExtendFriendResourceUtil.a(str, paramString);
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
      int i = AIOUtils.a(50.0F, getResources());
      GradientDrawable localGradientDrawable1 = GradientDrawableUtils.a(paramInt1, i, i, i, i);
      GradientDrawable localGradientDrawable2 = GradientDrawableUtils.a(paramInt2, i, i, i, i);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { 16842919 }, localGradientDrawable2);
      localStateListDrawable.addState(new int[0], localGradientDrawable1);
      this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localStateListDrawable);
    }
  }
  
  private void c()
  {
    Object localObject = ExtendFriendResourceUtil.a("expand_voice_animation.json");
    try
    {
      localObject = new BufferedInputStream(new FileInputStream((String)localObject));
      LottieComposition.Factory.fromInputStream(getContext(), (InputStream)localObject, new acjz(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ExtendFriendVoiceView", 1, "loadVoiceAnimation fail.", localException);
    }
  }
  
  private void d()
  {
    int k;
    int j;
    if ((getVisibility() == 0) && (this.jdField_a_of_type_Int == 1))
    {
      k = getWidth() - AIOUtils.a(22.0F, getResources());
      if (k > 0)
      {
        j = AIOUtils.a(110.0F, getResources());
        if ((this.d == null) || (this.d.getVisibility() != 0)) {
          break label226;
        }
      }
    }
    label226:
    for (int i = AIOUtils.a(33.0F, getResources());; i = 0)
    {
      k = k - j - i;
      int m = (int)(k * Math.min((float)this.jdField_a_of_type_Long / (float)this.jdField_b_of_type_Long, 1.0F));
      if ((m >= 0) && (this.jdField_a_of_type_AndroidViewView != null))
      {
        FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        localLayoutParams.width = (i + j + m);
        this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
        post(new ackb(this));
        QLog.d("ExtendFriendVoiceView", 2, String.format("updateBubbleSize mVoiceDuration=%s mMaxVoiceDuration=%s maxWidth=%s increaseWidth=%s layoutParams.width=%s this=%s", new Object[] { Long.valueOf(this.jdField_a_of_type_Long), Long.valueOf(this.jdField_b_of_type_Long), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(localLayoutParams.width), this }));
      }
      return;
    }
  }
  
  private void e()
  {
    Object localObject3 = null;
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
      localObject1 = new File(ExtendFriendResourceUtil.a((String)localObject1));
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
    if ((localObject2 != null) && (localObject2.length > 0) && (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetFrameAnimationDrawable != null))
    {
      if (this.c != null) {
        this.c.setBackgroundDrawable(this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetFrameAnimationDrawable);
      }
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetFrameAnimationDrawable.a(localObject2);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetFrameAnimationDrawable.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.playAnimation();
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetFrameAnimationDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetFrameAnimationDrawable.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable != null) {
      this.jdField_a_of_type_ComTencentMobileqqDiniflyLottieDrawable.endAnimation();
    }
    if (this.c != null)
    {
      Bitmap localBitmap = a(this.jdField_b_of_type_JavaLangString);
      if (localBitmap != null) {
        this.c.setBackgroundDrawable(new BitmapDrawable(localBitmap));
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("playVoice mVoiceUrl=%s", new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer == null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer = new ExtendFriendVoicePlayer(this, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer.a(this.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_Boolean = true;
      e();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ExtendFriendVoiceView", 1, "playVoice fail.");
    }
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
    ThreadManager.getUIHandler().post(new ackc(this));
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer.b();
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
    if (!paramBoolean) {
      b();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("stopVoice mVoiceUrl=%s", new Object[] { this.jdField_a_of_type_JavaLangString }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendUtilsExtendFriendVoicePlayer.a();
      this.jdField_a_of_type_Boolean = false;
      f();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ExtendFriendVoiceView", 1, "stopVoice fail.");
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    do
    {
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView$DeleteIconClickListener == null);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView$DeleteIconClickListener.a();
      return;
    }
    catch (Exception paramView) {}
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    d();
  }
  
  public void setActivity(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    paramBaseActivity = (ExtendFriendManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(263);
    if (paramBaseActivity != null)
    {
      paramBaseActivity = paramBaseActivity.a();
      if (paramBaseActivity != null) {
        this.jdField_b_of_type_Long = paramBaseActivity.c;
      }
    }
  }
  
  public void setDeleteIconEnable(boolean paramBoolean, ExtendFriendVoiceView.DeleteIconClickListener paramDeleteIconClickListener)
  {
    View localView;
    if (this.d != null)
    {
      localView = this.d;
      if (!paramBoolean) {
        break label31;
      }
    }
    label31:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      this.jdField_a_of_type_ComTencentMobileqqExtendfriendWigetExtendFriendVoiceView$DeleteIconClickListener = paramDeleteIconClickListener;
      return;
    }
  }
  
  public void setMode(int paramInt)
  {
    int i6 = AIOUtils.a(35.0F, getResources());
    int i = AIOUtils.a(22.0F, getResources());
    int j = AIOUtils.a(19.0F, getResources());
    int k = AIOUtils.a(19.0F, getResources());
    int m = AIOUtils.a(40.0F, getResources());
    int n = AIOUtils.a(30.0F, getResources());
    int i1 = AIOUtils.a(70.0F, getResources());
    int i2 = AIOUtils.a(10.0F, getResources());
    int i3 = AIOUtils.a(60.0F, getResources());
    int i4 = AIOUtils.a(49.0F, getResources());
    this.jdField_a_of_type_Int = paramInt;
    int i5;
    if (this.jdField_a_of_type_Int == 2)
    {
      paramInt = (int)(i6 * 0.8F);
      i = (int)(i * 0.8F);
      j = (int)(j * 0.8F);
      k = (int)(k * 0.8F);
      m = (int)(m * 0.8F);
      n = (int)(n * 0.8F);
      i1 = (int)(i1 * 0.8F);
      i2 = (int)(i2 * 0.8F);
      i3 = (int)(i3 * 0.8F);
      i4 = (int)(i4 * 0.8F);
      i5 = -1;
    }
    for (float f = 14.0F * 0.8F;; f = 14.0F)
    {
      Object localObject;
      if (this.jdField_a_of_type_AndroidViewView != null)
      {
        localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).width = i5;
        ((FrameLayout.LayoutParams)localObject).height = paramInt;
        ((FrameLayout.LayoutParams)localObject).leftMargin = i;
      }
      if (this.jdField_b_of_type_AndroidViewView != null)
      {
        localObject = (FrameLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).width = j;
        ((FrameLayout.LayoutParams)localObject).height = k;
        ((FrameLayout.LayoutParams)localObject).leftMargin = m;
      }
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        localObject = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).width = n;
        ((LinearLayout.LayoutParams)localObject).leftMargin = i1;
        ((LinearLayout.LayoutParams)localObject).rightMargin = i2;
        this.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, f);
      }
      if (this.c != null)
      {
        localObject = (FrameLayout.LayoutParams)this.c.getLayoutParams();
        ((FrameLayout.LayoutParams)localObject).width = i3;
        ((FrameLayout.LayoutParams)localObject).height = i4;
      }
      return;
      i5 = -2;
      paramInt = i6;
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
      d();
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
      if ((this.c != null) && (paramString != null)) {
        this.c.setBackgroundDrawable(new BitmapDrawable(paramString));
      }
      int i = MD5Utils.d(this.jdField_b_of_type_JavaLangString).toUpperCase().charAt(0) % jdField_a_of_type_ArrayOfInt.length;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendVoiceView
 * JD-Core Version:    0.7.0.1
 */