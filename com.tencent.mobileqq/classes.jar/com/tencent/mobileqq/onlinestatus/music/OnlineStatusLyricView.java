package com.tencent.mobileqq.onlinestatus.music;

import aekt;
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
import atsc;
import atse;
import atsg;
import awar;
import awau;
import bems;
import bemt;
import bllv;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class OnlineStatusLyricView
  extends TextView
  implements Handler.Callback, bemt
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Paint.Align jdField_a_of_type_AndroidGraphicsPaint$Align = Paint.Align.CENTER;
  protected Handler a;
  protected atsc a;
  private atsg jdField_a_of_type_Atsg;
  private awau jdField_a_of_type_Awau;
  private bems jdField_a_of_type_Bems;
  public Friends a;
  public String a;
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  public String b;
  private volatile boolean jdField_b_of_type_Boolean;
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
  
  private int a(atsg paramatsg)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPaint$Align == Paint.Align.LEFT) {
      return 0;
    }
    if (this.jdField_a_of_type_AndroidGraphicsPaint$Align == Paint.Align.RIGHT) {
      return paramatsg.jdField_a_of_type_Int * 2;
    }
    return paramatsg.jdField_a_of_type_Int;
  }
  
  private atse a(int paramInt)
  {
    if (paramInt > 0) {}
    for (paramInt = (int)(this.jdField_a_of_type_Long - paramInt);; paramInt = (int)(this.jdField_a_of_type_Long - (this.jdField_a_of_type_ComTencentMobileqqDataFriends.songEndTime - NetConnInfoCenter.getServerTimeMillis())))
    {
      int i = this.jdField_a_of_type_Atsc.a(paramInt);
      Object localObject = this.jdField_a_of_type_Atsc.jdField_a_of_type_JavaUtilArrayList;
      int j = ((ArrayList)localObject).size();
      paramInt = i;
      if (i < 0) {
        paramInt = 0;
      }
      i = paramInt;
      if (paramInt >= j) {
        i = j - 1;
      }
      atse localatse = (atse)((ArrayList)localObject).get(i);
      localObject = localatse;
      if (localatse.a().isEmpty())
      {
        if (this.jdField_a_of_type_Int != 0) {
          b();
        }
        QLog.d("OnlineStatusLyricView", 1, "getUILyricLineList empty");
        localObject = null;
      }
      return localObject;
    }
  }
  
  private void a(Canvas paramCanvas, atsg paramatsg)
  {
    if (TextUtils.isEmpty(getText().toString())) {
      return;
    }
    this.jdField_a_of_type_Atsg = paramatsg;
    paramCanvas.save();
    TextPaint localTextPaint = getPaint();
    paramCanvas.clipRect(getPaddingLeft(), getPaddingTop(), getMeasuredWidth() - getPaddingRight(), getMeasuredHeight() - getPaddingBottom());
    int i = getPaddingLeft();
    int j = a(paramatsg);
    Drawable[] arrayOfDrawable = getCompoundDrawables();
    if (arrayOfDrawable[0] != null)
    {
      m = getMeasuredHeight();
      n = getPaddingTop();
      int i1 = getPaddingBottom();
      int i2 = arrayOfDrawable[0].getBounds().height();
      k = getPaddingTop();
      m = (m - n - i1 - i2) / 2;
      Rect localRect = new Rect(0, 0, arrayOfDrawable[0].getBounds().width(), arrayOfDrawable[0].getBounds().height());
      localRect.offset(i + j, m + k);
      arrayOfDrawable[0].setBounds(localRect);
      arrayOfDrawable[0].draw(paramCanvas);
    }
    paramCanvas.restore();
    paramCanvas.save();
    paramCanvas.clipRect(getCompoundPaddingLeft(), getPaddingTop(), getMeasuredWidth() - getPaddingRight(), getMeasuredHeight() - getPaddingBottom());
    i = a(paramatsg);
    j = getCompoundPaddingLeft();
    int k = this.jdField_c_of_type_Int;
    if (this.jdField_b_of_type_Int == 0) {
      this.jdField_b_of_type_Int = a();
    }
    int m = this.jdField_b_of_type_Int;
    int n = getPaddingTop();
    localTextPaint.setStyle(Paint.Style.FILL);
    localTextPaint.setColor(getCurrentTextColor());
    paramCanvas.drawText(paramatsg.jdField_a_of_type_JavaLangString, i + j - k, m + n, localTextPaint);
    paramCanvas.restore();
  }
  
  private boolean a(atse paramatse)
  {
    boolean bool = false;
    long l1 = (int)(this.jdField_a_of_type_Long - (this.jdField_a_of_type_ComTencentMobileqqDataFriends.songEndTime - NetConnInfoCenter.getServerTimeMillis()));
    long l2 = paramatse.jdField_a_of_type_Long;
    long l3 = paramatse.b;
    if (l1 > l2 + l3) {
      return false;
    }
    int j = ((atsg)paramatse.a().get(0)).jdField_b_of_type_Int;
    int k = getMeasuredWidth() - getPaddingRight() - getPaddingLeft();
    int m;
    int i;
    if (j > k)
    {
      m = (int)((float)(l1 - l2) / (float)l3 * j) - (int)(this.jdField_c_of_type_Int + 0.5F * k);
      i = this.jdField_c_of_type_Int + m;
      if (m < 0)
      {
        if (i >= 0) {
          break label182;
        }
        i = 0;
        bool = true;
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_Int = i;
      return bool;
      if (m > 0)
      {
        j -= k;
        if (i <= j) {
          break label179;
        }
        i = j;
      }
      label179:
      for (;;)
      {
        bool = true;
        break;
        i = this.jdField_c_of_type_Int;
        bool = true;
        break;
      }
      label182:
      bool = true;
      continue;
      i = 0;
    }
  }
  
  @SuppressLint({"WrongCall"})
  private void c(Canvas paramCanvas)
  {
    this.jdField_c_of_type_Boolean = false;
    Object localObject;
    if (b())
    {
      if ((this.jdField_a_of_type_Atsg == null) || (!getText().toString().equals(this.jdField_a_of_type_Atsg.jdField_a_of_type_JavaLangString))) {
        this.jdField_a_of_type_Atsg = a(getText().toString());
      }
      localObject = this.jdField_a_of_type_Atsg;
      this.jdField_c_of_type_Int = 0;
    }
    for (;;)
    {
      if (localObject != null) {
        a(paramCanvas, (atsg)localObject);
      }
      label142:
      atse localatse;
      do
      {
        do
        {
          return;
          if (!this.jdField_b_of_type_Boolean) {
            break label142;
          }
          if (this.jdField_a_of_type_Atsg != null) {
            break;
          }
          localObject = a(this.jdField_a_of_type_ComTencentMobileqqDataFriends.songPauseRemainTime);
        } while ((localObject == null) || (((atse)localObject).a().isEmpty()));
        localObject = (atsg)((atse)localObject).a().get(0);
        break;
        localObject = this.jdField_a_of_type_Atsg;
        break;
        localatse = a(-1);
      } while ((localatse == null) || (localatse.a().isEmpty()));
      localObject = (atsg)localatse.a().get(0);
      this.jdField_c_of_type_Boolean = a(localatse);
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
    }
  }
  
  public atsg a(String paramString)
  {
    int j = (int)(getPaint().measureText(paramString) + 0.5D);
    Drawable[] arrayOfDrawable = getCompoundDrawables();
    if (arrayOfDrawable[0] != null) {}
    for (int i = arrayOfDrawable[0].getBounds().width() + getCompoundDrawablePadding();; i = 0) {
      return new atsg(paramString, Math.max(getMeasuredWidth() / 2 - j / 2 - i, 0), 0, j + i, 0, null);
    }
  }
  
  public void a()
  {
    this.d = aekt.a(200.0F, getResources());
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
  }
  
  public void a(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Atsc != null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Atsc.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_Atsc.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        atse localatse = (atse)localIterator.next();
        localatse.jdField_a_of_type_JavaUtilArrayList.clear();
        localatse.jdField_a_of_type_JavaUtilArrayList.add(a(localatse.jdField_a_of_type_JavaLangString));
      }
    }
  }
  
  public void b(Canvas paramCanvas)
  {
    c(paramCanvas);
  }
  
  public boolean b()
  {
    boolean bool2 = false;
    String str = ((QQAppInterface)bllv.a()).a().a();
    if ((str != null) && (this.jdField_a_of_type_ComTencentMobileqqDataFriends != null) && (!str.equals(this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin)))
    {
      this.jdField_a_of_type_ComTencentMobileqqDataFriends = null;
      QLog.d("OnlineStatusLyricView", 1, "currentChatUin is not matched");
      return true;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataFriends == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataFriends.songName)))
    {
      this.jdField_a_of_type_Atsc = null;
      f();
      QLog.d("OnlineStatusLyricView", 1, "mFriend is null");
      return true;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqDataFriends.songId.equals(this.jdField_a_of_type_JavaLangString))
    {
      this.jdField_a_of_type_Atsc = null;
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataFriends.songId;
      QLog.d("OnlineStatusLyricView", 1, "mFriend songId has changed");
      label138:
      if (this.jdField_a_of_type_ComTencentMobileqqDataFriends.songPauseRemainTime <= 0) {
        break label429;
      }
    }
    label429:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.jdField_b_of_type_Boolean = bool1;
      if ((this.jdField_a_of_type_Atsc == null) || (this.jdField_a_of_type_Atsc.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_Atsc.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
      {
        this.jdField_a_of_type_Atsc = ((atsc)awar.a().a.get(this.jdField_a_of_type_ComTencentMobileqqDataFriends.songId));
        if ((this.jdField_a_of_type_Atsc != null) && (this.jdField_a_of_type_Atsc.jdField_a_of_type_JavaUtilArrayList != null))
        {
          this.jdField_a_of_type_Atsc.a();
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
          this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqDataFriends.songDuration;
          if ((this.jdField_a_of_type_Long <= 0L) && (this.jdField_a_of_type_Atsc != null) && (this.jdField_a_of_type_Atsc.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_Atsc.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
            this.jdField_a_of_type_Long = (((atse)this.jdField_a_of_type_Atsc.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Atsc.jdField_a_of_type_JavaUtilArrayList.size() - 1)).jdField_a_of_type_Long + 30000L);
          }
          if (this.jdField_a_of_type_Awau != null) {
            this.jdField_a_of_type_Awau.a();
          }
          QLog.d("OnlineStatusLyricView", 1, "mLyric reset");
        }
      }
      if ((this.jdField_a_of_type_Atsc != null) && (this.jdField_a_of_type_Atsc.jdField_a_of_type_JavaUtilArrayList != null))
      {
        bool1 = bool2;
        if (!this.jdField_a_of_type_Atsc.jdField_a_of_type_JavaUtilArrayList.isEmpty()) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
      if (System.currentTimeMillis() <= this.jdField_a_of_type_ComTencentMobileqqDataFriends.songEndTime) {
        break label138;
      }
      this.jdField_a_of_type_Atsc = null;
      f();
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("OnlineStatusLyricView", 2, "mFriend song is deprecated");
      return true;
    }
  }
  
  public void c()
  {
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Atsg = null;
    this.jdField_c_of_type_Int = 0;
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bems != null)
    {
      this.jdField_a_of_type_Bems.a(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 0: 
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
      if ((!this.jdField_b_of_type_Boolean) && (!this.jdField_a_of_type_Boolean)) {
        if (!this.jdField_c_of_type_Boolean) {
          break label80;
        }
      }
      label80:
      for (int i = 200;; i = 500)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(0, i);
        invalidate();
        return false;
      }
    }
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    requestLayout();
    return false;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Bems != null)
    {
      this.jdField_a_of_type_Bems.b(paramCanvas);
      return;
    }
    c(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (getMeasuredWidth() != this.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = getMeasuredWidth();
      if (this.jdField_a_of_type_Atsc != null) {
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
    int i;
    int j;
    if (a())
    {
      paramInt1 = this.d;
      Paint.FontMetricsInt localFontMetricsInt = getPaint().getFontMetricsInt();
      i = localFontMetricsInt.descent;
      j = localFontMetricsInt.ascent;
      if (arrayOfDrawable[0] == null) {
        break label184;
      }
    }
    label184:
    for (paramInt2 = arrayOfDrawable[0].getBounds().height();; paramInt2 = 0)
    {
      setMeasuredDimension(paramInt1, Math.max(paramInt2, i - j) + (getPaddingTop() + getPaddingBottom()));
      if (QLog.isColorLevel()) {
        QLog.d("OnlineStatusLyricView", 2, new Object[] { "onMeasure, measureWidth:", Integer.valueOf(paramInt1) });
      }
      return;
      paramInt1 = (int)(getPaint().measureText(getText().toString()) + 0.5D);
      if ((arrayOfDrawable[0] != null) && (arrayOfDrawable[2] == null)) {
        paramInt1 += getCompoundPaddingLeft() * 2;
      }
      for (;;)
      {
        paramInt1 = Math.min(paramInt1, this.d);
        break;
        paramInt1 = paramInt1 + getCompoundPaddingLeft() + getCompoundPaddingRight();
      }
    }
  }
  
  public void setFriendSession(Friends paramFriends, String paramString)
  {
    boolean bool = false;
    this.jdField_a_of_type_ComTencentMobileqqDataFriends = paramFriends;
    this.jdField_b_of_type_JavaLangString = paramString;
    if (paramFriends == null) {
      bool = true;
    }
    QLog.d("OnlineStatusLyricView", 1, new Object[] { "setFriendSession, friendIsNull:", Boolean.valueOf(bool) });
  }
  
  public void setLyricStateListener(awau paramawau)
  {
    this.jdField_a_of_type_Awau = paramawau;
  }
  
  public void setMosaicEffect(bems parambems)
  {
    bems localbems = this.jdField_a_of_type_Bems;
    if (localbems != null) {
      localbems.a(null);
    }
    this.jdField_a_of_type_Bems = parambems;
    if (parambems != null) {
      parambems.a(this);
    }
    invalidate();
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    String str = getText().toString();
    super.setText(paramCharSequence, paramBufferType);
    if (!str.equals(paramCharSequence.toString()))
    {
      if ((this.jdField_b_of_type_JavaLangString != null) && (!paramCharSequence.equals(this.jdField_b_of_type_JavaLangString)))
      {
        QLog.d("OnlineStatusLyricView", 1, new Object[] { "setText, mSongStatusName:", this.jdField_b_of_type_JavaLangString });
        this.jdField_b_of_type_JavaLangString = null;
        this.jdField_a_of_type_ComTencentMobileqqDataFriends = null;
        this.jdField_a_of_type_Atsc = null;
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      }
    }
    QLog.d("OnlineStatusLyricView", 1, new Object[] { "setText:", paramCharSequence.toString() });
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.music.OnlineStatusLyricView
 * JD-Core Version:    0.7.0.1
 */