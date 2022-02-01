package com.tencent.mobileqq.onlinestatus.music;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.data.Sentence;
import com.tencent.mobileqq.lyric.data.SentenceUI;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.manager.IOnlineMusicStatusManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.MosaicEffect;
import com.tencent.mobileqq.widget.MosaicEffect.IMosaicEffect;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class OnlineStatusLyricView
  extends TextView
  implements Handler.Callback, MosaicEffect.IMosaicEffect
{
  protected Handler a;
  protected Lyric b;
  public Friends c;
  public String d;
  public String e;
  private MosaicEffect f;
  private volatile boolean g;
  private LyricStateListener h;
  private volatile boolean i = false;
  private boolean j;
  private int k;
  private int l;
  private int m;
  private SentenceUI n;
  private Paint.Align o = Paint.Align.CENTER;
  private int p;
  private long q;
  
  public OnlineStatusLyricView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public OnlineStatusLyricView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public OnlineStatusLyricView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private int a(SentenceUI paramSentenceUI)
  {
    if (this.o == Paint.Align.LEFT) {
      return 0;
    }
    if (this.o == Paint.Align.RIGHT) {
      return paramSentenceUI.b * 2;
    }
    return paramSentenceUI.b;
  }
  
  private Sentence a(int paramInt)
  {
    long l1;
    long l2;
    if (paramInt > 0)
    {
      l1 = this.q;
      l2 = paramInt;
    }
    else
    {
      l1 = this.q;
      l2 = this.c.songEndTime - NetConnInfoCenter.getServerTimeMillis();
    }
    paramInt = (int)(l1 - l2);
    int i1 = this.b.a(paramInt);
    Object localObject = this.b.b;
    int i2 = ((ArrayList)localObject).size();
    paramInt = i1;
    if (i1 < 0) {
      paramInt = 0;
    }
    i1 = paramInt;
    if (paramInt >= i2) {
      i1 = i2 - 1;
    }
    Sentence localSentence = (Sentence)((ArrayList)localObject).get(i1);
    localObject = localSentence;
    if (localSentence.c().isEmpty())
    {
      if (this.k != 0) {
        b();
      }
      QLog.d("OnlineStatusLyricView", 1, "getUILyricLineList empty");
      localObject = null;
    }
    return localObject;
  }
  
  @SuppressLint({"WrongCall"})
  private void a(Canvas paramCanvas)
  {
    this.j = false;
    Object localObject1;
    if (e())
    {
      if ((this.n == null) || (!getText().toString().equals(this.n.a))) {
        this.n = a(getText().toString());
      }
      localObject1 = this.n;
      this.m = 0;
    }
    else
    {
      Object localObject2;
      if (this.i)
      {
        localObject2 = this.n;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = a(this.c.songPauseRemainTime);
          if (localObject1 != null)
          {
            if (((Sentence)localObject1).c().isEmpty()) {
              return;
            }
            localObject1 = (SentenceUI)((Sentence)localObject1).c().get(0);
          }
        }
      }
      else
      {
        localObject2 = a(-1);
        if (localObject2 == null) {
          return;
        }
        if (((Sentence)localObject2).c().isEmpty()) {
          return;
        }
        localObject1 = (SentenceUI)((Sentence)localObject2).c().get(0);
        this.j = a((Sentence)localObject2);
      }
    }
    if (localObject1 != null) {
      a(paramCanvas, (SentenceUI)localObject1);
    }
  }
  
  private void a(Canvas paramCanvas, SentenceUI paramSentenceUI)
  {
    if (TextUtils.isEmpty(getText().toString())) {
      return;
    }
    this.n = paramSentenceUI;
    paramCanvas.save();
    TextPaint localTextPaint = getPaint();
    paramCanvas.clipRect(getPaddingLeft(), getPaddingTop(), getMeasuredWidth() - getPaddingRight(), getMeasuredHeight() - getPaddingBottom());
    int i1 = getPaddingLeft() + a(paramSentenceUI);
    Drawable[] arrayOfDrawable = getCompoundDrawables();
    int i6;
    Rect localRect;
    if (arrayOfDrawable[0] != null)
    {
      i3 = getMeasuredHeight();
      i4 = getPaddingTop();
      i5 = getPaddingBottom();
      i6 = arrayOfDrawable[0].getBounds().height();
      i2 = getPaddingTop();
      i3 = (i3 - i4 - i5 - i6) / 2;
      localRect = new Rect(0, 0, arrayOfDrawable[0].getBounds().width(), arrayOfDrawable[0].getBounds().height());
      localRect.offset(i1, i2 + i3);
      arrayOfDrawable[0].setBounds(localRect);
      arrayOfDrawable[0].draw(paramCanvas);
    }
    if (arrayOfDrawable[2] != null)
    {
      i3 = getMeasuredHeight();
      i4 = getPaddingTop();
      i5 = getPaddingBottom();
      i6 = arrayOfDrawable[2].getBounds().height();
      i2 = getPaddingTop();
      i3 = (i3 - i4 - i5 - i6) / 2;
      localRect = new Rect(0, 0, arrayOfDrawable[2].getBounds().width(), arrayOfDrawable[2].getBounds().height());
      i1 += getCompoundPaddingLeft();
      double d1;
      if (paramSentenceUI != null)
      {
        d1 = localTextPaint.measureText(paramSentenceUI.a);
        Double.isNaN(d1);
        i1 += (int)(d1 + 0.5D);
      }
      else
      {
        d1 = i1;
        double d2 = localTextPaint.measureText(getText().toString());
        Double.isNaN(d2);
        Double.isNaN(d1);
        i1 = (int)(d1 + (d2 + 0.5D));
      }
      localRect.offset(Math.min(i1 + ViewUtils.dip2px(2.0F), getMeasuredWidth() - getCompoundPaddingRight()), i2 + i3);
      arrayOfDrawable[2].setBounds(localRect);
      arrayOfDrawable[2].draw(paramCanvas);
    }
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.clipRect(getCompoundPaddingLeft(), getPaddingTop(), getMeasuredWidth() - getCompoundPaddingRight(), getMeasuredHeight() - getPaddingBottom());
    i1 = a(paramSentenceUI);
    int i2 = getCompoundPaddingLeft();
    int i3 = this.m;
    if (this.l == 0) {
      this.l = getBaselineY();
    }
    int i4 = this.l;
    int i5 = getPaddingTop();
    localTextPaint.setStyle(Paint.Style.FILL);
    localTextPaint.setColor(getCurrentTextColor());
    paramCanvas.drawText(paramSentenceUI.a, i1 + i2 - i3, i4 + i5, localTextPaint);
    paramCanvas.restore();
  }
  
  private boolean a(Sentence paramSentence)
  {
    long l1 = (int)(this.q - (this.c.songEndTime - NetConnInfoCenter.getServerTimeMillis()));
    long l2 = paramSentence.b;
    long l3 = paramSentence.c;
    int i1 = 0;
    if (l1 > l2 + l3) {
      return false;
    }
    int i4 = ((SentenceUI)paramSentence.c().get(0)).c;
    int i5 = getMeasuredWidth() - getPaddingRight() - getPaddingLeft();
    boolean bool;
    if (i4 > i5)
    {
      bool = true;
      int i3 = (int)((float)(l1 - l2) / (float)l3 * i4);
      int i2 = this.m;
      int i6 = i3 - (int)(i2 + i5 * 0.5F);
      i3 = i2 + i6;
      if (i6 < 0)
      {
        if (i3 < 0) {}
      }
      else
      {
        do
        {
          i1 = i3;
          break label180;
          if (i6 <= 0) {
            break;
          }
          i1 = i4 - i5;
        } while (i3 <= i1);
        break label180;
        i1 = i2;
      }
    }
    else
    {
      bool = false;
    }
    label180:
    this.m = i1;
    return bool;
  }
  
  private void g()
  {
    this.g = false;
    this.a.removeMessages(0);
    this.a.sendEmptyMessage(0);
  }
  
  private int getBaselineY()
  {
    Paint.FontMetrics localFontMetrics = getPaint().getFontMetrics();
    int i1 = (int)(localFontMetrics.descent - localFontMetrics.ascent);
    return (int)((getMeasuredHeight() - getPaddingTop() - getPaddingBottom() - i1) * 0.5F - localFontMetrics.ascent);
  }
  
  private void h()
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((Handler)localObject).removeMessages(0);
    }
    localObject = this.h;
    if (localObject != null) {
      ((LyricStateListener)localObject).b();
    }
  }
  
  public SentenceUI a(String paramString)
  {
    double d1 = getPaint().measureText(paramString);
    Double.isNaN(d1);
    int i3 = (int)(d1 + 0.5D);
    Drawable[] arrayOfDrawable = getCompoundDrawables();
    int i1;
    if (arrayOfDrawable[0] != null) {
      i1 = arrayOfDrawable[0].getBounds().width() + getCompoundDrawablePadding();
    } else {
      i1 = 0;
    }
    int i2 = i1;
    if (QQTheme.isNowSimpleUI())
    {
      i2 = i1;
      if (arrayOfDrawable[0] == null)
      {
        i2 = i1;
        if (arrayOfDrawable[2] != null)
        {
          i1 = getCompoundPaddingRight();
          i2 = ViewUtils.dip2px(4.0F) + i1;
        }
      }
    }
    return new SentenceUI(paramString, Math.max(getMeasuredWidth() / 2 - i3 / 2 - i2, 0), 0, i3 + i2, 0, null);
  }
  
  public void a()
  {
    this.p = Utils.a(200.0F, getResources());
    this.a = new Handler(Looper.getMainLooper(), this);
  }
  
  public void b()
  {
    if (this.b.b != null)
    {
      Iterator localIterator = this.b.b.iterator();
      while (localIterator.hasNext())
      {
        Sentence localSentence = (Sentence)localIterator.next();
        localSentence.d.clear();
        localSentence.d.add(a(localSentence.a));
      }
    }
  }
  
  public void c()
  {
    this.l = 0;
    this.n = null;
    this.m = 0;
  }
  
  public boolean d()
  {
    return this.b != null;
  }
  
  public void draw(Canvas paramCanvas)
  {
    MosaicEffect localMosaicEffect = this.f;
    if (localMosaicEffect != null)
    {
      localMosaicEffect.a(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public boolean e()
  {
    Object localObject2 = MobileQQ.sMobileQQ.peekAppRuntime();
    Object localObject3 = ((IMessageFacade)((AppRuntime)localObject2).getRuntimeService(IMessageFacade.class, "")).getCurrChatUin();
    Object localObject1 = null;
    boolean bool2 = true;
    if (localObject3 != null)
    {
      Friends localFriends = this.c;
      if ((localFriends != null) && (!((String)localObject3).equals(localFriends.uin)))
      {
        this.c = null;
        QLog.d("OnlineStatusLyricView", 1, "currentChatUin is not matched");
        return true;
      }
    }
    localObject3 = this.c;
    if ((localObject3 != null) && (!TextUtils.isEmpty(((Friends)localObject3).songName)))
    {
      if (!this.c.songId.equals(this.d))
      {
        this.b = null;
        this.d = this.c.songId;
        QLog.d("OnlineStatusLyricView", 1, "mFriend songId has changed");
      }
      else if (System.currentTimeMillis() > this.c.songEndTime)
      {
        this.b = null;
        h();
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusLyricView", 2, "mFriend song is deprecated");
        }
        return true;
      }
      if (this.c.songPauseRemainTime > 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.i = bool1;
      localObject3 = this.b;
      if ((localObject3 == null) || (((Lyric)localObject3).b == null) || (this.b.b.isEmpty()))
      {
        localObject2 = (IOnlineMusicStatusManager)((IOnlineStatusManagerService)((AppRuntime)localObject2).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineMusicStatusManager.class);
        if (localObject2 != null) {
          localObject1 = ((IOnlineMusicStatusManager)localObject2).a(this.c.songId);
        }
        this.b = ((Lyric)localObject1);
        localObject1 = this.b;
        if ((localObject1 != null) && (((Lyric)localObject1).b != null))
        {
          this.b.a();
          this.a.sendEmptyMessage(1);
          this.q = this.c.songDuration;
          if (this.q <= 0L)
          {
            localObject1 = this.b;
            if ((localObject1 != null) && (((Lyric)localObject1).b != null) && (!this.b.b.isEmpty())) {
              this.q = (((Sentence)this.b.b.get(this.b.b.size() - 1)).b + 30000L);
            }
          }
          localObject1 = this.h;
          if (localObject1 != null) {
            ((LyricStateListener)localObject1).a();
          }
          QLog.d("OnlineStatusLyricView", 1, "mLyric reset");
        }
      }
      localObject1 = this.b;
      boolean bool1 = bool2;
      if (localObject1 != null)
      {
        bool1 = bool2;
        if (((Lyric)localObject1).b != null)
        {
          if (this.b.b.isEmpty()) {
            return true;
          }
          bool1 = false;
        }
      }
      return bool1;
    }
    this.b = null;
    h();
    QLog.d("OnlineStatusLyricView", 1, "mFriend is null");
    return true;
  }
  
  public void f()
  {
    this.g = true;
    this.a.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 0)
    {
      if (i1 != 1) {
        return false;
      }
      this.a.removeMessages(1);
      requestLayout();
      return false;
    }
    this.a.removeMessages(0);
    if ((!this.i) && (!this.g))
    {
      if (this.j) {
        i1 = 200;
      } else {
        i1 = 500;
      }
      this.a.sendEmptyMessageDelayed(0, i1);
    }
    invalidate();
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    f();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    MosaicEffect localMosaicEffect = this.f;
    if (localMosaicEffect != null)
    {
      localMosaicEffect.b(paramCanvas);
      return;
    }
    a(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (getMeasuredWidth() != this.k)
    {
      this.k = getMeasuredWidth();
      if (this.b != null) {
        b();
      }
      c();
    }
    g();
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusLyricView", 2, new Object[] { "onLayout, mLastWidth:", Integer.valueOf(this.k) });
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Drawable[] arrayOfDrawable = getCompoundDrawables();
    if (d())
    {
      paramInt1 = this.p;
    }
    else
    {
      double d1 = getPaint().measureText(getText().toString());
      Double.isNaN(d1);
      paramInt2 = (int)(d1 + 0.5D);
      if ((arrayOfDrawable[0] != null) && (arrayOfDrawable[2] == null))
      {
        paramInt1 = getCompoundPaddingLeft();
      }
      else
      {
        if (arrayOfDrawable[2] == null) {
          break label99;
        }
        paramInt1 = ViewUtils.dip2px(4.0F) + getCompoundPaddingRight();
      }
      paramInt1 *= 2;
      break label111;
      label99:
      paramInt2 += getCompoundPaddingLeft();
      paramInt1 = getCompoundPaddingRight();
      label111:
      paramInt1 = Math.min(paramInt2 + paramInt1, this.p);
    }
    Paint.FontMetricsInt localFontMetricsInt = getPaint().getFontMetricsInt();
    int i1 = localFontMetricsInt.descent;
    int i2 = localFontMetricsInt.ascent;
    if (arrayOfDrawable[0] != null) {
      paramInt2 = arrayOfDrawable[0].getBounds().height();
    } else {
      paramInt2 = 0;
    }
    setMeasuredDimension(paramInt1, Math.max(paramInt2, i1 - i2) + (getPaddingTop() + getPaddingBottom()));
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusLyricView", 2, new Object[] { "onMeasure, measureWidth:", Integer.valueOf(paramInt1) });
    }
  }
  
  public void setFriendSession(Friends paramFriends, String paramString)
  {
    this.c = paramFriends;
    this.e = paramString;
    boolean bool = false;
    if (paramFriends == null) {
      bool = true;
    }
    QLog.d("OnlineStatusLyricView", 1, new Object[] { "setFriendSession, friendIsNull:", Boolean.valueOf(bool) });
  }
  
  public void setLyricStateListener(LyricStateListener paramLyricStateListener)
  {
    this.h = paramLyricStateListener;
  }
  
  public void setMosaicEffect(MosaicEffect paramMosaicEffect)
  {
    MosaicEffect localMosaicEffect = this.f;
    if (localMosaicEffect != null) {
      localMosaicEffect.a(null);
    }
    this.f = paramMosaicEffect;
    if (paramMosaicEffect != null) {
      paramMosaicEffect.a(this);
    }
    invalidate();
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    String str = getText().toString();
    super.setText(paramCharSequence, paramBufferType);
    if ((paramCharSequence == null) || (!str.equals(paramCharSequence.toString())))
    {
      paramBufferType = this.e;
      if ((paramBufferType != null) && (!paramBufferType.equals(paramCharSequence)))
      {
        QLog.d("OnlineStatusLyricView", 1, new Object[] { "setText, mSongStatusName:", this.e });
        this.e = null;
        this.c = null;
        this.b = null;
      }
      paramBufferType = this.a;
      if (paramBufferType != null) {
        paramBufferType.sendEmptyMessage(1);
      }
    }
    if (QLog.isDevelopLevel())
    {
      if (paramCharSequence == null) {
        paramCharSequence = "null";
      } else {
        paramCharSequence = paramCharSequence.toString();
      }
      QLog.d("OnlineStatusLyricView", 4, new Object[] { "setText:", paramCharSequence });
    }
  }
  
  public void setTextColor(int paramInt)
  {
    super.setTextColor(paramInt);
    getPaint().setColor(paramInt);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    super.setTextSize(paramInt, paramFloat);
    this.a.sendEmptyMessage(1);
  }
  
  public void superDrawMosaic(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public void superOnDrawMosaic(Canvas paramCanvas)
  {
    a(paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.music.OnlineStatusLyricView
 * JD-Core Version:    0.7.0.1
 */