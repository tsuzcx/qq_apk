package com.tencent.mobileqq.copyprompt;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.SoftKeyboardObserver;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

public class LiteCopyPromptHelper
  implements View.OnClickListener
{
  private View a;
  private Handler b = new Handler(Looper.getMainLooper());
  private long c;
  private QQAppInterface d;
  private ViewGroup e;
  private Context f;
  private XEditTextEx g;
  private SoftKeyboardObserver h;
  private TextWatcher i = new LiteCopyPromptHelper.1(this);
  private Runnable j = new LiteCopyPromptHelper.4(this);
  
  public LiteCopyPromptHelper(Context paramContext, ViewGroup paramViewGroup, QQAppInterface paramQQAppInterface, XEditTextEx paramXEditTextEx)
  {
    this.d = paramQQAppInterface;
    this.e = paramViewGroup;
    this.f = paramContext;
    this.g = paramXEditTextEx;
  }
  
  private void a(String paramString)
  {
    View localView = this.a;
    if (localView != null) {
      localView.setOnClickListener(new LiteCopyPromptHelper.3(this, paramString));
    }
  }
  
  private View b(String paramString)
  {
    View localView = LayoutInflater.from(this.f).inflate(2131625610, this.e, false);
    ((TextView)localView.findViewById(2131440777)).setText(new QQText(paramString, 3, 16));
    paramString = new RelativeLayout.LayoutParams(-2, -2);
    paramString.addRule(9);
    paramString.addRule(2, 2131435809);
    paramString.leftMargin = AIOUtils.b(14.0F, this.f.getResources());
    ((RelativeLayout)this.e.findViewById(2131430542)).addView(localView, paramString);
    return localView;
  }
  
  private void c()
  {
    if (this.h == null) {
      this.h = new SoftKeyboardObserver(this.e, new LiteCopyPromptHelper.2(this));
    }
  }
  
  private void d()
  {
    this.b.removeCallbacks(this.j);
    this.j.run();
  }
  
  public void a()
  {
    XEditTextEx localXEditTextEx = this.g;
    if (localXEditTextEx != null)
    {
      localXEditTextEx.a(this);
      this.g.addTextChangedListener(this.i);
    }
  }
  
  public void b()
  {
    this.b.removeCallbacks(this.j);
    this.j.run();
    Object localObject = this.g;
    if (localObject != null) {
      ((XEditTextEx)localObject).removeTextChangedListener(this.i);
    }
    localObject = this.h;
    if (localObject != null)
    {
      ((SoftKeyboardObserver)localObject).a();
      this.h = null;
    }
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (this.c + 2000L <= System.currentTimeMillis())
    {
      this.c = l;
      Object localObject = this.d.getManager(QQManagerFactory.COPY_PROMPT_MANAGER);
      if ((localObject instanceof CopyPromptManager))
      {
        localObject = ((CopyPromptManager)localObject).a();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          d();
          this.a = b((String)localObject);
          this.b.postDelayed(this.j, 5000L);
          c();
          a((String)localObject);
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.LiteCopyPromptHelper
 * JD-Core Version:    0.7.0.1
 */