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

public class OldExpandVoiceView
  extends FrameLayout
  implements View.OnClickListener, ExpandVoicePlayer.ExtendFriendVoicePlayerListener
{
  private static final int[] c = { -13900833, -37464, -12331403, -5544982 };
  private static final int[] d = { -14167603, -1350502, -12728981, -6464553 };
  private static final Map<String, WeakReference<Bitmap>> e = new HashMap();
  public boolean a = false;
  Paint b;
  private final int f;
  private final View g;
  private final View h;
  private final TextView i;
  private final View j;
  private final View k;
  private String l;
  private String m;
  private OldExpandVoiceView.DeleteIconClickListener n;
  private QBaseActivity o;
  private ExpandVoicePlayer p;
  private LottieDrawable q;
  private final FrameAnimationDrawable r;
  private boolean s;
  private boolean t;
  private long u;
  private long v;
  private int w = 1;
  private int x;
  
  public OldExpandVoiceView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public OldExpandVoiceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public OldExpandVoiceView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.f = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.X).getInteger(R.styleable.Y, 0);
    LayoutInflater.from(paramContext).inflate(2131627400, this, true);
    this.g = findViewById(2131449972);
    this.h = findViewById(2131435622);
    this.i = ((TextView)findViewById(2131448966));
    this.j = findViewById(2131435569);
    this.k = findViewById(2131435570);
    this.k.setOnClickListener(this);
    this.k.setOnTouchListener(ProfileGuideDialogUtils.a);
    g();
    this.r = new FrameAnimationDrawable();
    this.r.a(3000L);
    this.r.a(true);
    this.b = new Paint();
    this.b.setAntiAlias(true);
    this.b.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
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
          this.x = (paramString.toUpperCase().charAt(0) % arrayOfString.length);
          str = ExpandResourceUtil.a(arrayOfString[this.x]);
          localObject1 = (WeakReference)e.get(str);
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
            e.put(str, new WeakReference(localObject1));
          }
        }
      }
    }
    return localObject1;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (this.g != null)
    {
      float f1 = DisplayUtil.a(getContext(), 50.0F);
      GradientDrawable localGradientDrawable1 = GradientDrawableUtils.a(paramInt1, f1, f1, f1, f1);
      GradientDrawable localGradientDrawable2 = GradientDrawableUtils.a(paramInt2, f1, f1, f1, f1);
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(new int[] { 16842919 }, localGradientDrawable2);
      localStateListDrawable.addState(new int[0], localGradientDrawable1);
      this.g.setBackgroundDrawable(localStateListDrawable);
    }
  }
  
  private void g()
  {
    ThreadManager.post(new OldExpandVoiceView.1(this), 5, null, true);
  }
  
  private void h()
  {
    if (getVisibility() == 0)
    {
      int i1 = this.w;
      if ((i1 == 1) || (i1 == 3))
      {
        int i3 = getWidth() - DisplayUtil.a(getContext(), 22.0F);
        if (i3 > 0)
        {
          int i2 = DisplayUtil.a(getContext(), 110.0F);
          Object localObject = this.k;
          if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {
            i1 = DisplayUtil.a(getContext(), 33.0F);
          } else {
            i1 = 0;
          }
          i3 = i3 - i2 - i1;
          int i4 = (int)(i3 * Math.min((float)this.u / (float)this.v, 1.0F));
          if (i4 >= 0)
          {
            localObject = this.g;
            if (localObject != null)
            {
              localObject = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
              ((FrameLayout.LayoutParams)localObject).width = (i2 + i1 + i4);
              this.g.setLayoutParams((ViewGroup.LayoutParams)localObject);
              post(new OldExpandVoiceView.2(this));
              QLog.d("ExtendFriendVoiceView", 2, String.format("updateBubbleSize mVoiceDuration=%s mMaxVoiceDuration=%s maxWidth=%s increaseWidth=%s layoutParams.width=%s this=%s", new Object[] { Long.valueOf(this.u), Long.valueOf(this.v), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(((FrameLayout.LayoutParams)localObject).width), this }));
            }
          }
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("onDownloadFailed errCode=%s", new Object[] { Integer.valueOf(paramInt) }));
    }
    c();
  }
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("playerCompletion mVoiceUrl=%s", new Object[] { this.l }));
    }
    ThreadManager.getUIHandler().post(new OldExpandVoiceView.3(this));
    paramString = this.p;
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
      c();
    }
  }
  
  public boolean a()
  {
    return this.s;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("playVoice mVoiceUrl=%s", new Object[] { this.l }));
    }
    if (this.p == null) {
      this.p = new ExpandVoicePlayer(this, this.o);
    }
    if (!TextUtils.isEmpty(this.l)) {}
    try
    {
      this.p.a(this.l);
      this.s = true;
      e();
      return;
    }
    catch (Exception localException)
    {
      label84:
      break label84;
    }
    QLog.e("ExtendFriendVoiceView", 1, "playVoice fail.");
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.g != null))
    {
      int i1 = (int)(getContext().getResources().getDisplayMetrics().density * 20.0F);
      BaseAIOUtils.a(this.g, i1, i1, i1, i1);
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("stopVoice mVoiceUrl=%s", new Object[] { this.l }));
    }
    ExpandVoicePlayer localExpandVoicePlayer = this.p;
    if (localExpandVoicePlayer != null) {}
    try
    {
      localExpandVoicePlayer.a();
      this.s = false;
      f();
      return;
    }
    catch (Exception localException)
    {
      label53:
      break label53;
    }
    QLog.e("ExtendFriendVoiceView", 1, "stopVoice fail.");
  }
  
  public boolean d()
  {
    return this.t;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if ((this.a) && ("1103".equals(ThemeUtil.curThemeId)))
    {
      if (this.b.getColorFilter() == null) {
        this.b.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
      }
      paramCanvas.saveLayer(null, this.b, 31);
      super.dispatchDraw(paramCanvas);
      paramCanvas.restore();
      return;
    }
    super.dispatchDraw(paramCanvas);
  }
  
  public void e()
  {
    if (this.w != 3)
    {
      int i1 = this.x;
      View localView = null;
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 != 3) {
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
              i1 = 0;
              for (;;)
              {
                localObject2 = localObject1;
                if (i1 >= arrayOfFile.length) {
                  break;
                }
                localObject1[i1] = arrayOfFile[i1].getAbsolutePath();
                i1 += 1;
              }
            }
          }
        }
      }
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        localObject1 = this.r;
        if (localObject1 != null)
        {
          localView = this.j;
          if (localView != null) {
            localView.setBackgroundDrawable((Drawable)localObject1);
          }
          this.r.a((String[])localObject2);
          this.r.a();
        }
      }
    }
    Object localObject1 = this.q;
    if (localObject1 != null) {
      ((LottieDrawable)localObject1).playAnimation();
    }
    this.t = true;
  }
  
  public void f()
  {
    Object localObject = this.r;
    if (localObject != null) {
      ((FrameAnimationDrawable)localObject).b();
    }
    localObject = this.q;
    if (localObject != null) {
      ((LottieDrawable)localObject).endAnimation();
    }
    if (this.j != null)
    {
      localObject = a(this.m);
      if (localObject != null) {
        this.j.setBackgroundDrawable(new BitmapDrawable((Bitmap)localObject));
      }
    }
    this.t = false;
  }
  
  public void onClick(View paramView)
  {
    OldExpandVoiceView.DeleteIconClickListener localDeleteIconClickListener;
    if (paramView.getId() == 2131435570)
    {
      localDeleteIconClickListener = this.n;
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
    h();
  }
  
  public void setActivity(QBaseActivity paramQBaseActivity)
  {
    this.o = paramQBaseActivity;
    this.v = ((IExpandManagerProxy)QRoute.api(IExpandManagerProxy.class)).getVoiceMaxDuration(this.o.getAppRuntime());
  }
  
  public void setDeleteIconEnable(boolean paramBoolean, OldExpandVoiceView.DeleteIconClickListener paramDeleteIconClickListener)
  {
    View localView = this.k;
    if (localView != null)
    {
      int i1;
      if (paramBoolean) {
        i1 = 0;
      } else {
        i1 = 8;
      }
      localView.setVisibility(i1);
    }
    this.n = paramDeleteIconClickListener;
  }
  
  public void setMode(int paramInt)
  {
    int i15 = DisplayUtil.a(getContext(), 35.0F);
    int i6 = DisplayUtil.a(getContext(), 22.0F);
    int i1 = DisplayUtil.a(getContext(), 19.0F);
    int i2 = DisplayUtil.a(getContext(), 19.0F);
    int i3 = DisplayUtil.a(getContext(), 40.0F);
    int i14 = DisplayUtil.a(getContext(), 30.0F);
    int i13 = DisplayUtil.a(getContext(), 70.0F);
    int i4 = DisplayUtil.a(getContext(), 10.0F);
    int i12 = DisplayUtil.a(getContext(), 60.0F);
    int i11 = DisplayUtil.a(getContext(), 49.0F);
    this.w = paramInt;
    int i17 = this.w;
    int i16 = -2;
    float f2 = 14.0F;
    int i10;
    int i5;
    int i7;
    float f1;
    int i8;
    int i9;
    if (i17 == 2)
    {
      i10 = -1;
      i5 = (int)(i15 * 0.8F);
      paramInt = (int)(i6 * 0.8F);
      i1 = (int)(i1 * 0.8F);
      i2 = (int)(i2 * 0.8F);
      i3 = (int)(i3 * 0.8F);
      i6 = (int)(i14 * 0.8F);
      i7 = (int)(i13 * 0.8F);
      i4 = (int)(i4 * 0.8F);
      f1 = 11.2F;
      i8 = (int)(i12 * 0.8F);
      i9 = (int)(i11 * 0.8F);
    }
    else
    {
      i5 = i15;
      paramInt = i6;
      i6 = i14;
      i7 = i13;
      i8 = i12;
      i9 = i11;
      i10 = i16;
      f1 = f2;
      if (i17 == 3)
      {
        paramInt = 0;
        i3 = ViewUtils.dip2px(20.0F);
        i4 = ViewUtils.dip2px(16.0F);
        i1 = ViewUtils.dip2px(16.0F);
        i2 = ViewUtils.dip2px(17.0F);
        f1 = f2;
        i10 = i16;
        i9 = i11;
        i8 = i12;
        i7 = i13;
        i6 = i14;
        i5 = i15;
      }
    }
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).width = i10;
      ((FrameLayout.LayoutParams)localObject).height = i5;
      ((FrameLayout.LayoutParams)localObject).leftMargin = paramInt;
    }
    localObject = this.h;
    if (localObject != null)
    {
      localObject = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).width = i1;
      ((FrameLayout.LayoutParams)localObject).height = i2;
      ((FrameLayout.LayoutParams)localObject).leftMargin = i3;
    }
    localObject = this.i;
    if (localObject != null)
    {
      localObject = (LinearLayout.LayoutParams)((TextView)localObject).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).width = i6;
      ((LinearLayout.LayoutParams)localObject).leftMargin = i7;
      ((LinearLayout.LayoutParams)localObject).rightMargin = i4;
      this.i.setTextSize(1, f1);
    }
    localObject = this.j;
    if (localObject != null)
    {
      if (this.w == 3)
      {
        ((View)localObject).setVisibility(8);
        return;
      }
      localObject = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).width = i8;
      ((FrameLayout.LayoutParams)localObject).height = i9;
    }
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.w == 1)
    {
      View localView = this.g;
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
    if (this.i != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("\"");
      localObject = ((StringBuilder)localObject).toString().intern();
      this.i.setText((CharSequence)localObject);
      this.u = paramLong;
      h();
    }
  }
  
  public void setVoiceFileMD5(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("setVoiceFileMD5 md5=%s", new Object[] { paramString }));
    }
    if (!TextUtils.isEmpty(paramString))
    {
      this.m = paramString.toUpperCase();
      paramString = a(this.m);
      View localView = this.j;
      if ((localView != null) && (paramString != null)) {
        localView.setBackgroundDrawable(new BitmapDrawable(paramString));
      }
      int i1 = MD5Utils.toMD5(this.m).toUpperCase().charAt(0);
      paramString = c;
      i1 %= paramString.length;
      a(paramString[i1], d[i1]);
    }
  }
  
  public void setVoiceUrl(String paramString)
  {
    this.l = paramString;
    if (!TextUtils.isEmpty(this.l))
    {
      int i1 = this.l.lastIndexOf('=');
      if (i1 >= 0) {
        setVoiceFileMD5(this.l.substring(i1 + 1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.voice.OldExpandVoiceView
 * JD-Core Version:    0.7.0.1
 */