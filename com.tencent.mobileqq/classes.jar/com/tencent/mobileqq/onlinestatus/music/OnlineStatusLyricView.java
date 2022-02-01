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
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Paint.Align jdField_a_of_type_AndroidGraphicsPaint$Align = Paint.Align.CENTER;
  protected Handler a;
  public Friends a;
  protected Lyric a;
  private SentenceUI jdField_a_of_type_ComTencentMobileqqLyricDataSentenceUI;
  private LyricStateListener jdField_a_of_type_ComTencentMobileqqOnlinestatusMusicLyricStateListener;
  private MosaicEffect jdField_a_of_type_ComTencentMobileqqWidgetMosaicEffect;
  public String a;
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  public String b;
  private volatile boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int d;
  
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
  
  private int a()
  {
    Paint.FontMetrics localFontMetrics = getPaint().getFontMetrics();
    int i = (int)(localFontMetrics.descent - localFontMetrics.ascent);
    return (int)((getMeasuredHeight() - getPaddingTop() - getPaddingBottom() - i) * 0.5F - localFontMetrics.ascent);
  }
  
  private int a(SentenceUI paramSentenceUI)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint$Align == Paint.Align.LEFT) {
      return 0;
    }
    if (this.jdField_a_of_type_AndroidGraphicsPaint$Align == Paint.Align.RIGHT) {
      return paramSentenceUI.jdField_a_of_type_Int * 2;
    }
    return paramSentenceUI.jdField_a_of_type_Int;
  }
  
  private Sentence a(int paramInt)
  {
    long l1;
    long l2;
    if (paramInt > 0)
    {
      l1 = this.jdField_a_of_type_Long;
      l2 = paramInt;
    }
    else
    {
      l1 = this.jdField_a_of_type_Long;
      l2 = this.jdField_a_of_type_ComTencentMobileqqDataFriends.songEndTime - NetConnInfoCenter.getServerTimeMillis();
    }
    paramInt = (int)(l1 - l2);
    int i = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a(paramInt);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.jdField_a_of_type_JavaUtilArrayList;
    int j = ((ArrayList)localObject).size();
    paramInt = i;
    if (i < 0) {
      paramInt = 0;
    }
    i = paramInt;
    if (paramInt >= j) {
      i = j - 1;
    }
    Sentence localSentence = (Sentence)((ArrayList)localObject).get(i);
    localObject = localSentence;
    if (localSentence.a().isEmpty())
    {
      if (this.jdField_a_of_type_Int != 0) {
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
    this.jdField_c_of_type_Boolean = false;
    Object localObject1;
    if (b())
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceUI == null) || (!getText().toString().equals(this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceUI.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceUI = a(getText().toString());
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceUI;
      this.jdField_c_of_type_Int = 0;
    }
    else
    {
      Object localObject2;
      if (this.jdField_b_of_type_Boolean)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceUI;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.songPauseRemainTime);
          if (localObject1 != null)
          {
            if (((Sentence)localObject1).a().isEmpty()) {
              return;
            }
            localObject1 = (SentenceUI)((Sentence)localObject1).a().get(0);
          }
        }
      }
      else
      {
        localObject2 = a(-1);
        if (localObject2 == null) {
          return;
        }
        if (((Sentence)localObject2).a().isEmpty()) {
          return;
        }
        localObject1 = (SentenceUI)((Sentence)localObject2).a().get(0);
        this.jdField_c_of_type_Boolean = a((Sentence)localObject2);
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
    this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceUI = paramSentenceUI;
    paramCanvas.save();
    TextPaint localTextPaint = getPaint();
    paramCanvas.clipRect(getPaddingLeft(), getPaddingTop(), getMeasuredWidth() - getPaddingRight(), getMeasuredHeight() - getPaddingBottom());
    int i = getPaddingLeft() + a(paramSentenceUI);
    Drawable[] arrayOfDrawable = getCompoundDrawables();
    int i1;
    Rect localRect;
    if (arrayOfDrawable[0] != null)
    {
      k = getMeasuredHeight();
      m = getPaddingTop();
      n = getPaddingBottom();
      i1 = arrayOfDrawable[0].getBounds().height();
      j = getPaddingTop();
      k = (k - m - n - i1) / 2;
      localRect = new Rect(0, 0, arrayOfDrawable[0].getBounds().width(), arrayOfDrawable[0].getBounds().height());
      localRect.offset(i, j + k);
      arrayOfDrawable[0].setBounds(localRect);
      arrayOfDrawable[0].draw(paramCanvas);
    }
    if (arrayOfDrawable[2] != null)
    {
      k = getMeasuredHeight();
      m = getPaddingTop();
      n = getPaddingBottom();
      i1 = arrayOfDrawable[2].getBounds().height();
      j = getPaddingTop();
      k = (k - m - n - i1) / 2;
      localRect = new Rect(0, 0, arrayOfDrawable[2].getBounds().width(), arrayOfDrawable[2].getBounds().height());
      i += getCompoundPaddingLeft();
      double d1;
      if (paramSentenceUI != null)
      {
        d1 = localTextPaint.measureText(paramSentenceUI.jdField_a_of_type_JavaLangString);
        Double.isNaN(d1);
        i += (int)(d1 + 0.5D);
      }
      else
      {
        d1 = i;
        double d2 = localTextPaint.measureText(getText().toString());
        Double.isNaN(d2);
        Double.isNaN(d1);
        i = (int)(d1 + (d2 + 0.5D));
      }
      localRect.offset(Math.min(i + ViewUtils.a(2.0F), getMeasuredWidth() - getCompoundPaddingRight()), j + k);
      arrayOfDrawable[2].setBounds(localRect);
      arrayOfDrawable[2].draw(paramCanvas);
    }
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.clipRect(getCompoundPaddingLeft(), getPaddingTop(), getMeasuredWidth() - getCompoundPaddingRight(), getMeasuredHeight() - getPaddingBottom());
    i = a(paramSentenceUI);
    int j = getCompoundPaddingLeft();
    int k = this.jdField_c_of_type_Int;
    if (this.jdField_b_of_type_Int == 0) {
      this.jdField_b_of_type_Int = a();
    }
    int m = this.jdField_b_of_type_Int;
    int n = getPaddingTop();
    localTextPaint.setStyle(Paint.Style.FILL);
    localTextPaint.setColor(getCurrentTextColor());
    paramCanvas.drawText(paramSentenceUI.jdField_a_of_type_JavaLangString, i + j - k, m + n, localTextPaint);
    paramCanvas.restore();
  }
  
  private boolean a(Sentence paramSentence)
  {
    long l1 = (int)(this.jdField_a_of_type_Long - (this.jdField_a_of_type_ComTencentMobileqqDataFriends.songEndTime - NetConnInfoCenter.getServerTimeMillis()));
    long l2 = paramSentence.jdField_a_of_type_Long;
    long l3 = paramSentence.b;
    int i = 0;
    if (l1 > l2 + l3) {
      return false;
    }
    int m = ((SentenceUI)paramSentence.a().get(0)).jdField_b_of_type_Int;
    int n = getMeasuredWidth() - getPaddingRight() - getPaddingLeft();
    boolean bool;
    if (m > n)
    {
      bool = true;
      int k = (int)((float)(l1 - l2) / (float)l3 * m);
      int j = this.jdField_c_of_type_Int;
      int i1 = k - (int)(j + n * 0.5F);
      k = j + i1;
      if (i1 < 0)
      {
        if (k < 0) {}
      }
      else
      {
        do
        {
          i = k;
          break label179;
          if (i1 <= 0) {
            break;
          }
          i = m - n;
        } while (k <= i);
        break label179;
        i = j;
      }
    }
    else
    {
      bool = false;
    }
    label179:
    this.jdField_c_of_type_Int = i;
    return bool;
  }
  
  private void e()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
  }
  
  private void f()
  {
    Object localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeMessages(0);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusMusicLyricStateListener;
    if (localObject != null) {
      ((LyricStateListener)localObject).b();
    }
  }
  
  public SentenceUI a(String paramString)
  {
    double d1 = getPaint().measureText(paramString);
    Double.isNaN(d1);
    int j = (int)(d1 + 0.5D);
    Drawable[] arrayOfDrawable = getCompoundDrawables();
    int i;
    if (arrayOfDrawable[0] != null) {
      i = arrayOfDrawable[0].getBounds().width() + getCompoundDrawablePadding();
    } else {
      i = 0;
    }
    return new SentenceUI(paramString, Math.max(getMeasuredWidth() / 2 - j / 2 - i, 0), 0, j + i, 0, null);
  }
  
  public void a()
  {
    this.d = Utils.a(200.0F, getResources());
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric != null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        Sentence localSentence = (Sentence)localIterator.next();
        localSentence.jdField_a_of_type_JavaUtilArrayList.clear();
        localSentence.jdField_a_of_type_JavaUtilArrayList.add(a(localSentence.jdField_a_of_type_JavaLangString));
      }
    }
  }
  
  public boolean b()
  {
    Object localObject2 = MobileQQ.sMobileQQ.peekAppRuntime();
    Object localObject3 = ((IMessageFacade)((AppRuntime)localObject2).getRuntimeService(IMessageFacade.class, "")).getCurrChatUin();
    Object localObject1 = null;
    boolean bool2 = true;
    if (localObject3 != null)
    {
      Friends localFriends = this.jdField_a_of_type_ComTencentMobileqqDataFriends;
      if ((localFriends != null) && (!((String)localObject3).equals(localFriends.uin)))
      {
        this.jdField_a_of_type_ComTencentMobileqqDataFriends = null;
        QLog.d("OnlineStatusLyricView", 1, "currentChatUin is not matched");
        return true;
      }
    }
    localObject3 = this.jdField_a_of_type_ComTencentMobileqqDataFriends;
    if ((localObject3 != null) && (!TextUtils.isEmpty(((Friends)localObject3).songName)))
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqDataFriends.songId.equals(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric = null;
        this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.songId;
        QLog.d("OnlineStatusLyricView", 1, "mFriend songId has changed");
      }
      else if (System.currentTimeMillis() > this.jdField_a_of_type_ComTencentMobileqqDataFriends.songEndTime)
      {
        this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric = null;
        f();
        if (QLog.isColorLevel()) {
          QLog.d("OnlineStatusLyricView", 2, "mFriend song is deprecated");
        }
        return true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.songPauseRemainTime > 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.jdField_b_of_type_Boolean = bool1;
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric;
      if ((localObject3 == null) || (((Lyric)localObject3).jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        localObject2 = (IOnlineMusicStatusManager)((IOnlineStatusManagerService)((AppRuntime)localObject2).getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IOnlineMusicStatusManager.class);
        if (localObject2 != null) {
          localObject1 = ((IOnlineMusicStatusManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.songId);
        }
        this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric = ((Lyric)localObject1);
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric;
        if ((localObject1 != null) && (((Lyric)localObject1).jdField_a_of_type_JavaUtilArrayList != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.a();
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
          this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataFriends.songDuration;
          if (this.jdField_a_of_type_Long <= 0L)
          {
            localObject1 = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric;
            if ((localObject1 != null) && (((Lyric)localObject1).jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
              this.jdField_a_of_type_Long = (((Sentence)this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.jdField_a_of_type_JavaUtilArrayList.size() - 1)).jdField_a_of_type_Long + 30000L);
            }
          }
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqOnlinestatusMusicLyricStateListener;
          if (localObject1 != null) {
            ((LyricStateListener)localObject1).a();
          }
          QLog.d("OnlineStatusLyricView", 1, "mLyric reset");
        }
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric;
      boolean bool1 = bool2;
      if (localObject1 != null)
      {
        bool1 = bool2;
        if (((Lyric)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {
            return true;
          }
          bool1 = false;
        }
      }
      return bool1;
    }
    this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric = null;
    f();
    QLog.d("OnlineStatusLyricView", 1, "mFriend is null");
    return true;
  }
  
  public void c()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqLyricDataSentenceUI = null;
    this.jdField_c_of_type_Int = 0;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void draw(Canvas paramCanvas)
  {
    MosaicEffect localMosaicEffect = this.jdField_a_of_type_ComTencentMobileqqWidgetMosaicEffect;
    if (localMosaicEffect != null)
    {
      localMosaicEffect.a(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return false;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
      requestLayout();
      return false;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean))
    {
      if (this.jdField_c_of_type_Boolean) {
        i = 200;
      } else {
        i = 500;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, i);
    }
    invalidate();
    return false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    d();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    MosaicEffect localMosaicEffect = this.jdField_a_of_type_ComTencentMobileqqWidgetMosaicEffect;
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
    if (getMeasuredWidth() != this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = getMeasuredWidth();
      if (this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric != null) {
        b();
      }
      c();
    }
    e();
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusLyricView", 2, new Object[] { "onLayout, mLastWidth:", Integer.valueOf(this.jdField_a_of_type_Int) });
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Drawable[] arrayOfDrawable = getCompoundDrawables();
    if (a())
    {
      paramInt1 = this.d;
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
        paramInt1 = ViewUtils.a(4.0F) + getCompoundPaddingRight();
      }
      paramInt1 *= 2;
      break label111;
      label99:
      paramInt2 += getCompoundPaddingLeft();
      paramInt1 = getCompoundPaddingRight();
      label111:
      paramInt1 = Math.min(paramInt2 + paramInt1, this.d);
    }
    Paint.FontMetricsInt localFontMetricsInt = getPaint().getFontMetricsInt();
    int i = localFontMetricsInt.descent;
    int j = localFontMetricsInt.ascent;
    if (arrayOfDrawable[0] != null) {
      paramInt2 = arrayOfDrawable[0].getBounds().height();
    } else {
      paramInt2 = 0;
    }
    setMeasuredDimension(paramInt1, Math.max(paramInt2, i - j) + (getPaddingTop() + getPaddingBottom()));
    if (QLog.isColorLevel()) {
      QLog.d("OnlineStatusLyricView", 2, new Object[] { "onMeasure, measureWidth:", Integer.valueOf(paramInt1) });
    }
  }
  
  public void setFriendSession(Friends paramFriends, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = paramFriends;
    this.jdField_b_of_type_JavaLangString = paramString;
    boolean bool = false;
    if (paramFriends == null) {
      bool = true;
    }
    QLog.d("OnlineStatusLyricView", 1, new Object[] { "setFriendSession, friendIsNull:", Boolean.valueOf(bool) });
  }
  
  public void setLyricStateListener(LyricStateListener paramLyricStateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusMusicLyricStateListener = paramLyricStateListener;
  }
  
  public void setMosaicEffect(MosaicEffect paramMosaicEffect)
  {
    MosaicEffect localMosaicEffect = this.jdField_a_of_type_ComTencentMobileqqWidgetMosaicEffect;
    if (localMosaicEffect != null) {
      localMosaicEffect.a(null);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetMosaicEffect = paramMosaicEffect;
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
      paramBufferType = this.jdField_b_of_type_JavaLangString;
      if ((paramBufferType != null) && (!paramBufferType.equals(paramCharSequence)))
      {
        QLog.d("OnlineStatusLyricView", 1, new Object[] { "setText, mSongStatusName:", this.jdField_b_of_type_JavaLangString });
        this.jdField_b_of_type_JavaLangString = null;
        this.jdField_a_of_type_ComTencentMobileqqDataFriends = null;
        this.jdField_a_of_type_ComTencentMobileqqLyricDataLyric = null;
      }
      paramBufferType = this.jdField_a_of_type_AndroidOsHandler;
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
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.music.OnlineStatusLyricView
 * JD-Core Version:    0.7.0.1
 */