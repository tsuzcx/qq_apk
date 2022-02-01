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
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;

public class CopyPromptHelper
  implements View.OnClickListener, ILifeCycleHelper
{
  private BaseChatPie a;
  private View b;
  private Handler c = new Handler(Looper.getMainLooper());
  private SoftKeyboardObserver d;
  private long e;
  private TextWatcher f = new CopyPromptHelper.1(this);
  private Runnable g = new CopyPromptHelper.4(this);
  
  public CopyPromptHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  private void a(String paramString)
  {
    View localView = this.b;
    if (localView != null) {
      localView.setOnClickListener(new CopyPromptHelper.3(this, paramString));
    }
  }
  
  private View b(String paramString)
  {
    View localView = LayoutInflater.from(this.a.e).inflate(2131625610, this.a.aZ, false);
    ((TextView)localView.findViewById(2131440777)).setText(new QQText(paramString, 3, 16));
    paramString = new RelativeLayout.LayoutParams(-2, -2);
    paramString.addRule(9);
    paramString.addRule(2, 2131435809);
    paramString.leftMargin = AIOUtils.b(14.0F, this.a.e.getResources());
    ((RelativeLayout)this.a.aZ.findViewById(2131430542)).addView(localView, paramString);
    ReportController.b(this.a.i(), "dc00898", "", "", "0X800B22B", "0X800B22B", 0, 0, "", "", "", "");
    return localView;
  }
  
  private void b()
  {
    Object localObject = this.a.d.getManager(QQManagerFactory.COPY_PROMPT_MANAGER);
    if ((localObject instanceof CopyPromptManager))
    {
      localObject = ((CopyPromptManager)localObject).a();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handlePrompt content : ");
        localStringBuilder.append((String)localObject);
        QLog.d("CopyPromptHelper", 2, localStringBuilder.toString());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        a();
        this.b = b((String)localObject);
        this.c.postDelayed(this.g, 5000L);
        c();
        a((String)localObject);
      }
    }
  }
  
  private void c()
  {
    if (this.d == null) {
      this.d = new SoftKeyboardObserver(this.a.aZ, new CopyPromptHelper.2(this));
    }
  }
  
  private boolean d()
  {
    return this.a.aZ.findViewById(2131430644).getVisibility() == 0;
  }
  
  public void a()
  {
    this.c.removeCallbacks(this.g);
    this.g.run();
  }
  
  public String getTag()
  {
    return "CopyPromptHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 4, 15 };
  }
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (this.e + 2000L <= System.currentTimeMillis())
    {
      this.e = l;
      if (!d()) {
        b();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 15) {
        return;
      }
      this.c.removeCallbacks(this.g);
      this.g.run();
      SoftKeyboardObserver localSoftKeyboardObserver = this.d;
      if (localSoftKeyboardObserver != null)
      {
        localSoftKeyboardObserver.a();
        this.d = null;
      }
      if (this.a.Y != null) {
        this.a.Y.removeTextChangedListener(this.f);
      }
    }
    else
    {
      this.a.Y.a(this);
      this.a.Y.addTextChangedListener(this.f);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.CopyPromptHelper
 * JD-Core Version:    0.7.0.1
 */