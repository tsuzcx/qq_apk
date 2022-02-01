package com.tencent.mobileqq.qqexpand.widget.voice;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqexpand.api.R.styleable;
import com.tencent.mobileqq.qqexpand.manager.IExpandManagerProxy;
import com.tencent.mobileqq.qqexpand.utils.ExpandResourceUtil;
import com.tencent.mobileqq.qqexpand.utils.ProfileGuideDialogUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class ExpandVoiceView
  extends FrameLayout
  implements View.OnClickListener, ExpandVoicePlayer.ExtendFriendVoicePlayerListener
{
  private static final Map<String, WeakReference<Bitmap>> c = new HashMap();
  public boolean a = false;
  Paint b;
  private final int d;
  private final View e;
  private final URLImageView f;
  private final TextView g;
  private final View h;
  private String i;
  private String j;
  private ExpandVoiceView.DeleteIconClickListener k;
  private QBaseActivity l;
  private ExpandVoicePlayer m;
  private ApngDrawable n;
  private boolean o;
  private boolean p;
  private long q;
  private long r;
  private int s = 1;
  
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
    this.d = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.X).getInteger(R.styleable.Y, 0);
    LayoutInflater.from(paramContext).inflate(2131627404, this, true);
    this.e = findViewById(2131449972);
    this.f = ((URLImageView)findViewById(2131435622));
    this.g = ((TextView)findViewById(2131448966));
    this.h = findViewById(2131435570);
    this.h.setOnClickListener(this);
    this.h.setOnTouchListener(ProfileGuideDialogUtils.a);
    f();
    this.b = new Paint();
    this.b.setAntiAlias(true);
    this.b.setColorFilter(ThemeUtil.NIGHTMODE_COLORFILTER);
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    File localFile = new File(getVoiceWavePath());
    if ((localFile.exists()) && (localFile.isFile())) {
      return;
    }
    ThreadManager.getFileThreadHandler().post(new ExpandVoiceView.3(paramAppRuntime, localFile));
  }
  
  private boolean b(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mUseApngImage = true;
      localObject = URLDrawable.getDrawable("https://down.qq.com/extendfriend/voicewave.png", (URLDrawable.URLDrawableOptions)localObject);
      this.f.setImageDrawable((Drawable)localObject);
      if (QLog.isColorLevel()) {
        QLog.i("ExtendFriendVoiceView", 2, "load voice wave png in a default way!");
      }
      return true;
    }
    return false;
  }
  
  private void f()
  {
    ThreadManager.getUIHandler().post(new ExpandVoiceView.1(this));
  }
  
  public static String getVoiceWavePath()
  {
    return ExpandResourceUtil.a().concat("/voicewave.png");
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
      QLog.d("ExtendFriendVoiceView", 2, String.format("playerCompletion mVoiceUrl=%s", new Object[] { this.i }));
    }
    ThreadManager.getUIHandler().post(new ExpandVoiceView.2(this));
    paramString = this.m;
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
    return this.o;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("playVoice mVoiceUrl=%s", new Object[] { this.i }));
    }
    if (this.m == null) {
      this.m = new ExpandVoicePlayer(this, this.l);
    }
    if (!TextUtils.isEmpty(this.i)) {}
    try
    {
      this.m.a(this.i);
      this.o = true;
      d();
      return;
    }
    catch (Exception localException)
    {
      label83:
      break label83;
    }
    QLog.e("ExtendFriendVoiceView", 1, "playVoice fail.");
  }
  
  public void b(String paramString, int paramInt1, int paramInt2) {}
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("stopVoice mVoiceUrl=%s", new Object[] { this.i }));
    }
    ExpandVoicePlayer localExpandVoicePlayer = this.m;
    if (localExpandVoicePlayer != null) {}
    try
    {
      localExpandVoicePlayer.a();
      this.o = false;
      e();
      return;
    }
    catch (Exception localException)
    {
      label52:
      break label52;
    }
    QLog.e("ExtendFriendVoiceView", 1, "stopVoice fail.");
  }
  
  public void d()
  {
    ApngDrawable localApngDrawable = this.n;
    if (localApngDrawable != null) {
      localApngDrawable.resume();
    }
    this.p = true;
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
    ApngDrawable localApngDrawable = this.n;
    if (localApngDrawable != null) {
      localApngDrawable.pause();
    }
    this.p = false;
  }
  
  public void onClick(View paramView)
  {
    ExpandVoiceView.DeleteIconClickListener localDeleteIconClickListener;
    if (paramView.getId() == 2131435570)
    {
      localDeleteIconClickListener = this.k;
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
  }
  
  public void setActivity(QBaseActivity paramQBaseActivity)
  {
    this.l = paramQBaseActivity;
    this.r = ((IExpandManagerProxy)QRoute.api(IExpandManagerProxy.class)).getVoiceMaxDuration(this.l.getAppRuntime());
  }
  
  public void setDeleteIconEnable(boolean paramBoolean, ExpandVoiceView.DeleteIconClickListener paramDeleteIconClickListener)
  {
    View localView = this.h;
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
    this.k = paramDeleteIconClickListener;
  }
  
  public void setMode(int paramInt) {}
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    if (this.s == 1)
    {
      View localView = this.e;
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
    if (this.g != null)
    {
      long l1 = paramLong / 60L;
      long l2 = paramLong % 60L;
      if (l2 < 10L) {
        str = "0".concat(String.valueOf(l2));
      } else {
        str = String.valueOf(l2);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(String.valueOf(l1));
      localStringBuilder.append(":");
      localStringBuilder.append(str);
      String str = localStringBuilder.toString().intern();
      this.g.setText(str);
      this.q = paramLong;
    }
  }
  
  public void setVoiceFileMD5(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendVoiceView", 2, String.format("setVoiceFileMD5 md5=%s", new Object[] { paramString }));
    }
    if (!TextUtils.isEmpty(paramString)) {
      this.j = paramString.toUpperCase();
    }
  }
  
  public void setVoiceUrl(String paramString)
  {
    this.i = paramString;
    if (!TextUtils.isEmpty(this.i))
    {
      int i1 = this.i.lastIndexOf('=');
      if (i1 >= 0) {
        setVoiceFileMD5(this.i.substring(i1 + 1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoiceView
 * JD-Core Version:    0.7.0.1
 */