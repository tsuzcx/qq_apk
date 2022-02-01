package com.tencent.mobileqq.qwallet.hb.grap.voice.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import com.tencent.mobileqq.lyric.data.Character;
import com.tencent.mobileqq.lyric.data.Lyric;
import com.tencent.mobileqq.lyric.data.Sentence;
import com.tencent.mobileqq.lyric.util.LyricParseHelper;
import com.tencent.mobileqq.qqpay.ui.R.color;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.id;
import com.tencent.mobileqq.qqpay.ui.R.layout;
import com.tencent.mobileqq.qwallet.impl.QWalletTools;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class KSongView
  extends FrameLayout
{
  public long a;
  private int b = -1;
  private ListView c;
  private QwAdapter d;
  private KSongTextView e = null;
  private KSongTextView f;
  private int g = 0;
  private KSHelper.KListener h;
  private KSongView.KHandler i;
  private KSHelper.Config j = new KSHelper.Config();
  private KSongProsBar k;
  private List<Sentence> l;
  private long m = 0L;
  private long n = 0L;
  
  public KSongView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public KSongView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  @SuppressLint({"NewApi"})
  public KSongView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }
  
  private float a(int paramInt, long paramLong)
  {
    Object localObject2 = (Sentence)this.d.getItem(paramInt);
    if ((localObject2 != null) && (((Sentence)localObject2).g.size() > 0))
    {
      if (paramLong >= ((Sentence)localObject2).b + ((Sentence)localObject2).c)
      {
        QLog.i("KSongView", 2, "over the sentence...");
        return 1.0F;
      }
      localObject1 = null;
      paramInt = 0;
      while (paramInt < ((Sentence)localObject2).g.size())
      {
        localObject1 = (Character)((Sentence)localObject2).g.get(paramInt);
        if (paramLong < ((Character)localObject1).a + ((Character)localObject1).b) {
          break;
        }
        paramInt += 1;
      }
      if (localObject1 == null)
      {
        QLog.i("KSongView", 2, "error, charaxter is null...");
        return 0.0F;
      }
      localObject2 = (Character)((Sentence)localObject2).g.get(((Sentence)localObject2).g.size() - 1);
      float f1 = (float)(paramLong - ((Character)localObject1).a) / (float)((Character)localObject1).b;
      return (((Character)localObject1).c + f1) / ((Character)localObject2).d;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("error, sentence = ");
    ((StringBuilder)localObject1).append(localObject2);
    QLog.i("KSongView", 2, ((StringBuilder)localObject1).toString());
    return 0.0F;
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -1);
    Object localObject1 = new LinearLayout.LayoutParams(-1, -1);
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    this.f = new KSongTextView(paramContext);
    this.f.setText("● ● ● ● ●");
    this.f.setTextSize(2, 15.0F);
    Object localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).gravity = 1;
    this.f.setVisibility(4);
    localLinearLayout.addView(this.f, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new ListView(paramContext);
    this.c = ((ListView)localObject2);
    localLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    this.c.setDivider(null);
    this.c.setVerticalScrollBarEnabled(false);
    addView(localLinearLayout, paramAttributeSet);
    localObject1 = new LinearLayout(paramContext);
    ((LinearLayout)localObject1).setOrientation(1);
    ((LinearLayout)localObject1).setBackgroundResource(R.drawable.r);
    ((LinearLayout)localObject1).setClickable(true);
    addView((View)localObject1, paramAttributeSet);
    paramAttributeSet = this.c;
    localObject1 = new ArrayList();
    this.l = ((List)localObject1);
    paramContext = new QwAdapter(paramContext, (List)localObject1, R.layout.e, new KSongView.LrcHolder(this));
    this.d = paramContext;
    paramAttributeSet.setAdapter(paramContext);
  }
  
  private boolean a(String paramString)
  {
    paramString = QWalletTools.g(paramString);
    Object localObject = LyricParseHelper.a(paramString, true);
    int i3 = 0;
    if ((localObject != null) && (((Lyric)localObject).b != null))
    {
      int i1 = 0;
      int i2;
      for (;;)
      {
        i2 = i3;
        if (i1 >= ((Lyric)localObject).b.size()) {
          break;
        }
        paramString = (Sentence)((Lyric)localObject).b.get(i1);
        if ((paramString.b >= this.j.d) && (paramString.b + paramString.c <= this.j.e)) {
          this.l.add(paramString);
        }
        if (paramString.b >= this.j.e)
        {
          i2 = i3;
          break;
        }
        i1 += 1;
      }
      while (i2 < 5)
      {
        this.l.add(new Sentence());
        i2 += 1;
      }
      paramString = new StringBuilder();
      paramString.append("list size = ");
      paramString.append(this.l.size());
      QLog.i("KSongView", 2, paramString.toString());
      return true;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("error, parse Qrc fail, qrc = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("KSongView", 2, ((StringBuilder)localObject).toString());
    return false;
  }
  
  private KSHelper.Config b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("KSongView", 2, "error! config path wrong...");
      return null;
    }
    try
    {
      paramString = QWalletTools.g(paramString);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("config_content = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("KSongView", 2, ((StringBuilder)localObject).toString());
      if (TextUtils.isEmpty(paramString))
      {
        QLog.i("KSongView", 2, "error! config content wrong...");
        return null;
      }
      paramString = new JSONObject(paramString);
      localObject = new KSHelper.Config();
      ((KSHelper.Config)localObject).a = paramString.optString("name");
      ((KSHelper.Config)localObject).a = paramString.optString("singer");
      ((KSHelper.Config)localObject).b = paramString.optLong("time");
      ((KSHelper.Config)localObject).c = paramString.optString("ksongId");
      paramString = paramString.optJSONObject("qrcConfig");
      if (paramString == null) {
        return null;
      }
      ((KSHelper.Config)localObject).d = paramString.optLong("start", 0L);
      ((KSHelper.Config)localObject).e = paramString.optLong("end", 0L);
      ((KSHelper.Config)localObject).f = paramString.optLong("pretime", 0L);
      ((KSHelper.Config)localObject).g = paramString.optLong("total", 0L);
      if ((0L < ((KSHelper.Config)localObject).d) && (0L < ((KSHelper.Config)localObject).e) && (0L < ((KSHelper.Config)localObject).f) && (0L < ((KSHelper.Config)localObject).g))
      {
        paramString = (String)localObject;
        if (((KSHelper.Config)localObject).d < ((KSHelper.Config)localObject).e) {}
      }
      else
      {
        QLog.i("KSongView", 2, "error! config is wrong...");
        paramString = null;
      }
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private boolean b(long paramLong)
  {
    if (this.b != 1) {
      return false;
    }
    if (this.g >= this.l.size())
    {
      QLog.i("KSongView", 2, "error, out of scrop...");
      return false;
    }
    paramLong = paramLong + this.j.d - this.j.f;
    Object localObject = this.h;
    if (localObject != null) {
      ((KSHelper.KListener)localObject).a(paramLong);
    }
    localObject = (Sentence)this.l.get(this.g);
    long l1 = ((Sentence)localObject).b + ((Sentence)localObject).c;
    c(paramLong);
    if (paramLong > l1)
    {
      if (l1 >= this.j.e)
      {
        QLog.i("KSongView", 2, "play over, no scroll...");
        return false;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("scroll to next line = ");
      ((StringBuilder)localObject).append(this.g);
      ((StringBuilder)localObject).append(" duration = ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.i("KSongView", 2, ((StringBuilder)localObject).toString());
      localObject = this.c;
      int i1 = this.g + 1;
      this.g = i1;
      ((ListView)localObject).smoothScrollToPositionFromTop(i1, -1, 50);
    }
    return true;
  }
  
  private void c(long paramLong)
  {
    Object localObject = this.c.getChildAt(0);
    if (localObject == null)
    {
      QLog.i("KSongView", 2, "update sentence v is null...");
      return;
    }
    this.e = ((KSongTextView)((View)localObject).findViewById(R.id.bB));
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("index line = ");
    ((StringBuilder)localObject).append(this.g);
    QLog.i("KSongView", 2, ((StringBuilder)localObject).toString());
    if (this.e != null)
    {
      float f1 = a(this.g, paramLong);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("show text color rate = ");
      ((StringBuilder)localObject).append(f1);
      QLog.i("KSongView", 2, ((StringBuilder)localObject).toString());
      this.e.a(f1, 15, -1);
    }
  }
  
  public void a()
  {
    QLog.i("KSongView", 2, "start reset...");
    this.d.notifyDataSetChanged();
    Object localObject = this.c;
    this.g = 0;
    ((ListView)localObject).setSelection(0);
    localObject = this.k;
    if (localObject != null) {
      ((KSongProsBar)localObject).a(0L);
    }
    this.i.removeMessages(0);
    if (this.b > 0) {
      this.b = 0;
    }
  }
  
  public void a(long paramLong)
  {
    KSongProsBar localKSongProsBar = this.k;
    if (localKSongProsBar != null) {
      localKSongProsBar.a(paramLong);
    }
  }
  
  public void a(String paramString1, String paramString2, KSongProsBar paramKSongProsBar, KSHelper.KListener paramKListener)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      this.k = paramKSongProsBar;
      setKListener(paramKListener);
      this.i = new KSongView.KHandler(this);
      new KSongView.InitTask(this).execute(new String[] { paramString1, paramString2 });
      return;
    }
    QLog.i("KSongView", 2, "error! need thinds is null...");
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      if (this.b >= 0)
      {
        if (this.b == 1)
        {
          QLog.i("KSongView", 2, "error, the playing is going...");
          return;
        }
        if (this.b == 2)
        {
          this.b = 1;
          this.i.sendEmptyMessage(0);
          this.m += System.currentTimeMillis() - this.n;
          return;
        }
        QLog.i("KSongView", 2, "start playing...");
        if (this.b == 3) {
          a();
        }
        this.b = 1;
        this.m = 0L;
        KSongTextView localKSongTextView = this.f;
        int i1;
        if (paramBoolean) {
          i1 = 0;
        } else {
          i1 = getResources().getColor(R.color.c);
        }
        localKSongTextView.a(i1, 0);
        this.f.a(this.j.f, null);
        this.a = System.currentTimeMillis();
        this.i.sendEmptyMessage(0);
        return;
      }
      throw new RuntimeException("error! lyric object not initialized...");
    }
    finally {}
  }
  
  public void b()
  {
    if (this.b == 1)
    {
      this.b = 2;
      this.i.removeMessages(0);
      this.n = System.currentTimeMillis();
    }
  }
  
  public void c()
  {
    KSongView.KHandler localKHandler = this.i;
    if (localKHandler != null) {
      localKHandler.removeMessages(0);
    }
    if (this.b > 0) {
      this.b = 0;
    }
  }
  
  public KSHelper.Config getConfig()
  {
    return this.j;
  }
  
  public int getState()
  {
    try
    {
      int i1 = this.b;
      return i1;
    }
    finally {}
  }
  
  public void setKListener(KSHelper.KListener paramKListener)
  {
    this.h = paramKListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSongView
 * JD-Core Version:    0.7.0.1
 */