package com.tencent.rtmp.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import java.text.SimpleDateFormat;

public class TXDashBoard
  extends LinearLayout
{
  protected TextView a;
  protected TextView b;
  protected ScrollView c;
  protected StringBuffer d = new StringBuffer("");
  protected int e = 3000;
  private final SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss.SSS");
  private boolean g = false;
  
  public TXDashBoard(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TXDashBoard(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    setVisibility(4);
  }
  
  private void a(ScrollView paramScrollView, View paramView)
  {
    if (paramScrollView != null)
    {
      if (paramView == null) {
        return;
      }
      int j = paramView.getMeasuredHeight() - paramScrollView.getMeasuredHeight();
      int i = j;
      if (j < 0) {
        i = 0;
      }
      paramScrollView.scrollTo(0, i);
    }
  }
  
  private void b()
  {
    if (this.a != null) {
      return;
    }
    this.a = new TextView(getContext());
    this.b = new TextView(getContext());
    this.c = new ScrollView(getContext());
    Object localObject = new LinearLayout.LayoutParams(-1, -2);
    this.a.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.a.setTextColor(-49023);
    this.a.setTypeface(Typeface.MONOSPACE);
    localObject = new LinearLayout.LayoutParams(-1, -1);
    this.c.setPadding(0, 10, 0, 0);
    this.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.c.setVerticalScrollBarEnabled(true);
    this.c.setScrollbarFadingEnabled(true);
    localObject = new FrameLayout.LayoutParams(-1, -1);
    this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.b.setTextColor(-49023);
    this.c.addView(this.b);
    addView(this.a);
    addView(this.c);
    if (this.d.length() <= 0)
    {
      localObject = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("liteav sdk version:");
      localStringBuilder.append(TXCCommonUtil.getSDKVersionStr());
      localStringBuilder.append("\n");
      ((StringBuffer)localObject).append(localStringBuilder.toString());
    }
    this.b.setText(this.d.toString());
  }
  
  protected String a(Bundle paramBundle)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("CPU:");
    ((StringBuilder)localObject1).append(paramBundle.getString("CPU_USAGE"));
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("RES:");
    ((StringBuilder)localObject2).append(paramBundle.getInt("VIDEO_WIDTH"));
    ((StringBuilder)localObject2).append("*");
    ((StringBuilder)localObject2).append(paramBundle.getInt("VIDEO_HEIGHT"));
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("SPD:");
    ((StringBuilder)localObject3).append(paramBundle.getInt("NET_SPEED"));
    ((StringBuilder)localObject3).append("Kbps");
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("JIT:");
    ((StringBuilder)localObject4).append(paramBundle.getInt("NET_JITTER"));
    localObject4 = ((StringBuilder)localObject4).toString();
    Object localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append("FPS:");
    ((StringBuilder)localObject5).append(paramBundle.getInt("VIDEO_FPS"));
    localObject5 = ((StringBuilder)localObject5).toString();
    Object localObject6 = new StringBuilder();
    ((StringBuilder)localObject6).append("GOP:");
    ((StringBuilder)localObject6).append(paramBundle.getInt("VIDEO_GOP"));
    ((StringBuilder)localObject6).append("s");
    localObject6 = ((StringBuilder)localObject6).toString();
    Object localObject7 = new StringBuilder();
    ((StringBuilder)localObject7).append("ARA:");
    ((StringBuilder)localObject7).append(paramBundle.getInt("AUDIO_BITRATE"));
    ((StringBuilder)localObject7).append("Kbps");
    localObject7 = ((StringBuilder)localObject7).toString();
    Object localObject8 = new StringBuilder();
    ((StringBuilder)localObject8).append("QUE:");
    ((StringBuilder)localObject8).append(paramBundle.getInt("AUDIO_CACHE"));
    ((StringBuilder)localObject8).append(" | ");
    ((StringBuilder)localObject8).append(paramBundle.getInt("VIDEO_CACHE"));
    ((StringBuilder)localObject8).append(",");
    ((StringBuilder)localObject8).append(paramBundle.getInt("V_SUM_CACHE_SIZE"));
    ((StringBuilder)localObject8).append(",");
    ((StringBuilder)localObject8).append(paramBundle.getInt("V_DEC_CACHE_SIZE"));
    ((StringBuilder)localObject8).append(" | ");
    ((StringBuilder)localObject8).append(paramBundle.getInt("AV_RECV_INTERVAL"));
    ((StringBuilder)localObject8).append(",");
    ((StringBuilder)localObject8).append(paramBundle.getInt("AV_PLAY_INTERVAL"));
    ((StringBuilder)localObject8).append(",");
    ((StringBuilder)localObject8).append(String.format("%.1f", new Object[] { Float.valueOf(paramBundle.getFloat("AUDIO_CACHE_THRESHOLD")) }).toString());
    localObject8 = ((StringBuilder)localObject8).toString();
    Object localObject9 = new StringBuilder();
    ((StringBuilder)localObject9).append("VRA:");
    ((StringBuilder)localObject9).append(paramBundle.getInt("VIDEO_BITRATE"));
    ((StringBuilder)localObject9).append("Kbps");
    localObject9 = ((StringBuilder)localObject9).toString();
    Object localObject10 = new StringBuilder();
    ((StringBuilder)localObject10).append("DRP:");
    ((StringBuilder)localObject10).append(paramBundle.getInt("AUDIO_DROP"));
    ((StringBuilder)localObject10).append("|");
    ((StringBuilder)localObject10).append(paramBundle.getInt("VIDEO_DROP"));
    localObject10 = ((StringBuilder)localObject10).toString();
    Object localObject11 = new StringBuilder();
    ((StringBuilder)localObject11).append("SVR:");
    ((StringBuilder)localObject11).append(paramBundle.getString("SERVER_IP"));
    localObject11 = ((StringBuilder)localObject11).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AUDIO:");
    localStringBuilder.append(paramBundle.getString("AUDIO_PLAY_INFO"));
    return String.format("%-16s %-16s %-16s\n%-12s %-12s %-12s %-12s\n%-14s %-14s %-14s\n%-16s %-16s", new Object[] { localObject1, localObject2, localObject3, localObject4, localObject5, localObject6, localObject7, localObject8, localObject9, localObject10, localObject11, localStringBuilder.toString() });
  }
  
  public void a()
  {
    this.d.setLength(0);
    TextView localTextView = this.a;
    if (localTextView != null) {
      localTextView.setText("");
    }
    localTextView = this.b;
    if (localTextView != null) {
      localTextView.setText("");
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((TextView)localObject).setPadding(paramInt1, paramInt2, paramInt3, 0);
    }
    localObject = this.c;
    if (localObject != null) {
      ((ScrollView)localObject).setPadding(paramInt1, 0, paramInt3, paramInt4);
    }
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (paramInt == 1020) {
      return;
    }
    String str = new SimpleDateFormat("HH:mm:ss.SSS").format(Long.valueOf(System.currentTimeMillis()));
    while (this.d.length() > this.e)
    {
      int i = this.d.indexOf("\n");
      paramInt = i;
      if (i == 0) {
        paramInt = 1;
      }
      this.d = this.d.delete(0, paramInt);
    }
    StringBuffer localStringBuffer = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("\n[");
    localStringBuilder.append(str);
    localStringBuilder.append("]");
    localStringBuilder.append(paramString);
    localStringBuffer.append(localStringBuilder.toString());
    this.d = localStringBuffer;
  }
  
  public void a(Bundle paramBundle1, Bundle paramBundle2, int paramInt)
  {
    if (this.g) {
      return;
    }
    if (paramInt != 2011)
    {
      if (paramInt == 2012) {
        return;
      }
      Object localObject;
      if (paramBundle1 != null)
      {
        localObject = this.a;
        if (localObject != null) {
          ((TextView)localObject).setText(a(paramBundle1));
        }
      }
      if (this.d.length() <= 0)
      {
        paramBundle1 = this.d;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("liteav sdk version:");
        ((StringBuilder)localObject).append(TXCCommonUtil.getSDKVersionStr());
        ((StringBuilder)localObject).append("\n");
        paramBundle1.append(((StringBuilder)localObject).toString());
      }
      if (paramBundle2 != null)
      {
        paramBundle1 = paramBundle2.getString("EVT_MSG");
        if ((paramBundle1 != null) && (!paramBundle1.isEmpty()))
        {
          a(paramInt, paramBundle1);
          paramBundle1 = this.b;
          if (paramBundle1 != null) {
            paramBundle1.setText(this.d.toString());
          }
          if (getVisibility() == 0)
          {
            paramBundle1 = this.c;
            if (paramBundle1 != null)
            {
              paramBundle2 = this.b;
              if (paramBundle2 != null) {
                a(paramBundle1, paramBundle2);
              }
            }
          }
        }
      }
    }
  }
  
  public void a(CharSequence paramCharSequence)
  {
    TextView localTextView = this.a;
    if (localTextView != null) {
      localTextView.setText(paramCharSequence);
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = this.f.format(Long.valueOf(System.currentTimeMillis()));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("]");
    localStringBuilder.append(paramString);
    localStringBuilder.append("\n");
    paramString = localStringBuilder.toString();
    if (this.d.length() <= 0)
    {
      localObject = this.d;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("liteav sdk version:");
      localStringBuilder.append(TXCCommonUtil.getSDKVersionStr());
      localStringBuilder.append("\n");
      ((StringBuffer)localObject).append(localStringBuilder.toString());
    }
    while (this.d.length() > this.e)
    {
      int j = this.d.indexOf("\n");
      int i = j;
      if (j == 0) {
        i = 1;
      }
      this.d = this.d.delete(0, i);
    }
    localObject = this.d;
    ((StringBuffer)localObject).append(paramString);
    this.d = ((StringBuffer)localObject);
    paramString = this.b;
    if (paramString != null) {
      paramString.setText(this.d.toString());
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  public void setEventTextSize(float paramFloat)
  {
    TextView localTextView = this.b;
    if (localTextView != null) {
      localTextView.setTextSize(paramFloat);
    }
  }
  
  public void setLogMsgLenLimit(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setShowLevel(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        b();
        this.a.setVisibility(0);
        this.c.setVisibility(0);
        setVisibility(0);
        return;
      }
      b();
      this.a.setVisibility(0);
      this.c.setVisibility(4);
      setVisibility(0);
      return;
    }
    Object localObject = this.a;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(4);
    }
    localObject = this.c;
    if (localObject != null) {
      ((ScrollView)localObject).setVisibility(4);
    }
    setVisibility(4);
  }
  
  public void setStatusTextSize(float paramFloat)
  {
    TextView localTextView = this.a;
    if (localTextView != null) {
      localTextView.setTextSize(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.ui.TXDashBoard
 * JD-Core Version:    0.7.0.1
 */