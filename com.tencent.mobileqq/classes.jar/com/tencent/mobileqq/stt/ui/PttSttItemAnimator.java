package com.tencent.mobileqq.stt.ui;

import android.content.res.Resources;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.PttItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.stt.shard.AIOSttResult;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class PttSttItemAnimator
{
  WeakReference<PttItemBuilder.Holder> a;
  MessageForPtt b;
  public int c;
  boolean d = false;
  int e = 0;
  volatile SpannableString f = new SpannableString("");
  private QQAppInterface g;
  private boolean h = true;
  
  public PttSttItemAnimator() {}
  
  public PttSttItemAnimator(QQAppInterface paramQQAppInterface, MessageForPtt paramMessageForPtt, int paramInt)
  {
    this.g = paramQQAppInterface;
    this.b = paramMessageForPtt;
    this.c = paramInt;
  }
  
  public static boolean a(MessageForPtt paramMessageForPtt)
  {
    if (paramMessageForPtt == null) {
      return false;
    }
    if (paramMessageForPtt.sttAbility != 3)
    {
      if (!paramMessageForPtt.expandStt) {
        return false;
      }
      return paramMessageForPtt.getSttResult().f();
    }
    return false;
  }
  
  public static boolean b(MessageForPtt paramMessageForPtt)
  {
    if (paramMessageForPtt == null) {
      return true;
    }
    if (paramMessageForPtt.getSttResult().e() == 4) {
      return true;
    }
    return (!StringUtil.isEmpty(paramMessageForPtt.sttText)) && (!paramMessageForPtt.getSttResult().f());
  }
  
  private int l()
  {
    int j = BaseApplicationImpl.getContext().getResources().getColor(2131167977);
    Object localObject = this.a;
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (!((WeakReference)localObject).isEnqueued())
      {
        localObject = (PttItemBuilder.Holder)this.a.get();
        i = j;
        if (localObject != null)
        {
          i = j;
          if (((PttItemBuilder.Holder)localObject).d != null) {
            i = ((PttItemBuilder.Holder)localObject).d.getCurrentTextColor();
          }
        }
      }
    }
    return i;
  }
  
  private int m()
  {
    return ColorUtils.setAlphaComponent(l(), 128);
  }
  
  private void n()
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((PttItemBuilder.Holder)this.a.get()).a(this.g, this.b, e(), this.c);
    }
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void a(Handler paramHandler)
  {
    if (paramHandler == null) {
      return;
    }
    paramHandler.post(new PttSttItemAnimator.1(this));
  }
  
  public void a(PttItemBuilder.Holder paramHolder)
  {
    if (paramHolder != null) {
      this.a = new WeakReference(paramHolder);
    }
  }
  
  void a(String paramString)
  {
    this.f = new SpannableString(paramString);
    if (this.f.length() > 0) {
      this.f.setSpan(new ForegroundColorSpan(l()), 0, this.f.length(), 17);
    }
    c();
  }
  
  public void a(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  void b(String paramString)
  {
    c(paramString);
    d();
  }
  
  public boolean b()
  {
    return this.d;
  }
  
  void c()
  {
    this.d = true;
  }
  
  void c(String paramString)
  {
    if (paramString == null) {
      return;
    }
    int i = paramString.length();
    if (i <= 0)
    {
      this.f = new SpannableString("");
      return;
    }
    int j = this.e;
    if (j == 0)
    {
      if (i >= 2)
      {
        this.f = new SpannableString(paramString.substring(0, 2));
        this.e += 2;
        return;
      }
      this.f = new SpannableString("");
      return;
    }
    if (j >= 2)
    {
      if (i - j >= 2)
      {
        this.f = new SpannableString(paramString.substring(0, j + 2));
        this.e += 2;
        return;
      }
      if (i % 2 != 0) {
        i -= 1;
      }
      this.f = new SpannableString(paramString.substring(0, i));
      this.e = i;
    }
  }
  
  void d()
  {
    int i = this.f.length();
    if (i <= 0) {
      return;
    }
    if (this.d)
    {
      this.f.setSpan(new ForegroundColorSpan(l()), 0, i, 17);
      return;
    }
    if (i == 2)
    {
      this.f.setSpan(new ForegroundColorSpan(m()), 0, 2, 17);
      return;
    }
    if (i >= 4)
    {
      int j = this.e + 2 - 3;
      this.f.setSpan(new ForegroundColorSpan(l()), 0, j, 17);
      this.f.setSpan(new ForegroundColorSpan(m()), j, i, 17);
    }
  }
  
  public SpannableString e()
  {
    return this.f;
  }
  
  public void f()
  {
    Object localObject = this.b;
    if ((localObject != null) && (((MessageForPtt)localObject).getSttResult() != null))
    {
      localObject = this.b.getSttResult().d();
      int i = this.b.getSttResult().e();
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        a((String)localObject);
        return;
      }
      b((String)localObject);
      return;
    }
    this.f = new SpannableString("");
  }
  
  void g()
  {
    this.f = new SpannableString("");
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((PttItemBuilder.Holder)this.a.get()).a(this.g, this.b, this.f, this.c);
    }
  }
  
  public boolean h()
  {
    return this.h;
  }
  
  public void i()
  {
    this.e = 0;
    g();
  }
  
  public void j()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = (PttItemBuilder.Holder)this.a.get();
      if (((PttItemBuilder.Holder)localObject).C != null)
      {
        ((PttItemBuilder.Holder)localObject).C.setVisibility(0);
        ((PttItemBuilder.Holder)localObject).C.setIndeterminate(true);
        if (QLog.isColorLevel()) {
          QLog.d("Q.stt_PttSttItemAnimator", 2, "stt repush, progress appear again");
        }
      }
    }
  }
  
  public void k()
  {
    MessageForPtt localMessageForPtt = this.b;
    if ((localMessageForPtt != null) && (localMessageForPtt.getSttResult() != null)) {
      this.b.getSttResult().c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.stt.ui.PttSttItemAnimator
 * JD-Core Version:    0.7.0.1
 */