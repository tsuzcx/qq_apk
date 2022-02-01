package com.tencent.mobileqq.olympic.activity;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;

public class ARTipsManager
{
  private LayoutInflater a;
  private Resources b;
  private ViewConfiguration c;
  private Handler d;
  private RelativeLayout e;
  private ARTipsManager.ARTipsVisibleListener f;
  private ViewGroup g;
  
  public ARTipsManager(Context paramContext, RelativeLayout paramRelativeLayout, ARTipsManager.ARTipsVisibleListener paramARTipsVisibleListener)
  {
    this.a = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.b = paramContext.getResources();
    this.c = ViewConfiguration.get(paramContext);
    this.d = new ARTipsManager.CustomHandler(this);
    this.e = paramRelativeLayout;
    this.f = paramARTipsVisibleListener;
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, ARTipsManager.BaikeClickListener paramBaikeClickListener, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showBaike tag=%s type=%s title=%s content=%s listener=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramBaikeClickListener, Boolean.valueOf(paramBoolean1) }));
    }
    ARTipsManager.TipsInfo localTipsInfo = new ARTipsManager.TipsInfo(this, null);
    localTipsInfo.a = paramInt1;
    localTipsInfo.b = paramInt2;
    localTipsInfo.c = paramBoolean1;
    localTipsInfo.i = paramString1;
    localTipsInfo.j = paramString2;
    localTipsInfo.k = paramBaikeClickListener;
    localTipsInfo.m = paramBoolean2;
    this.d.removeMessages(101);
    paramString1 = this.d.obtainMessage(100);
    paramString1.obj = localTipsInfo;
    paramString1.sendToTarget();
  }
  
  private void a(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, ARTipsManager.ButtonClickListener paramButtonClickListener, int paramInt3, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("showTips tag=%s type=%s tips=%s description=%s btnText=%s btnListener=%s progress=%s autoRemove=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString1, paramString2, paramString3, paramButtonClickListener, Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean) }));
    }
    ARTipsManager.TipsInfo localTipsInfo = new ARTipsManager.TipsInfo(this, null);
    localTipsInfo.a = paramInt1;
    localTipsInfo.b = paramInt2;
    localTipsInfo.c = paramBoolean;
    localTipsInfo.d = paramString1;
    localTipsInfo.e = paramString2;
    localTipsInfo.f = paramString3;
    localTipsInfo.g = paramButtonClickListener;
    localTipsInfo.h = paramInt3;
    this.d.removeMessages(101);
    paramString1 = this.d.obtainMessage(100);
    paramString1.obj = localTipsInfo;
    paramString1.sendToTarget();
  }
  
  private void a(ARTipsManager.TipsInfo paramTipsInfo)
  {
    if (this.g == null) {
      this.g = d();
    }
    Object localObject = this.g;
    if (localObject != null)
    {
      ((ViewGroup)localObject).setTag(2131428720, paramTipsInfo);
      localObject = (ARTipsManager.ViewHolder)this.g.getTag();
      if (localObject != null)
      {
        int i = paramTipsInfo.b;
        if ((i != 1) && (i != 2) && (i != 3))
        {
          if ((i != 10) && (i != 11))
          {
            if (i == 12)
            {
              ((ARTipsManager.ViewHolder)localObject).a.setVisibility(8);
              ((ARTipsManager.ViewHolder)localObject).f.setVisibility(8);
              ((ARTipsManager.ViewHolder)localObject).l.setVisibility(0);
              if (paramTipsInfo.l != null)
              {
                ((ARTipsManager.ViewHolder)localObject).m.setOnClickListener(new ARTipsManager.4(this, paramTipsInfo));
                ((ARTipsManager.ViewHolder)localObject).n.setOnClickListener(new ARTipsManager.5(this, paramTipsInfo));
              }
            }
          }
          else
          {
            ((ARTipsManager.ViewHolder)localObject).a.setVisibility(8);
            ((ARTipsManager.ViewHolder)localObject).l.setVisibility(8);
            ((ARTipsManager.ViewHolder)localObject).f.setVisibility(0);
            if (paramTipsInfo.m) {
              ((ARTipsManager.ViewHolder)localObject).o.setVisibility(0);
            } else {
              ((ARTipsManager.ViewHolder)localObject).o.setVisibility(4);
            }
            ((ARTipsManager.ViewHolder)localObject).h.setText(paramTipsInfo.i);
            ((ARTipsManager.ViewHolder)localObject).i.setText(paramTipsInfo.j);
            ((ARTipsManager.ViewHolder)localObject).g.setOnClickListener(new ARTipsManager.2(this, paramTipsInfo));
            FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)((ARTipsManager.ViewHolder)localObject).f.getLayoutParams();
            if (i != 10)
            {
              if (i == 11)
              {
                ((ARTipsManager.ViewHolder)localObject).j.setVisibility(0);
                ((ARTipsManager.ViewHolder)localObject).k.setOnClickListener(new ARTipsManager.3(this, paramTipsInfo));
                localLayoutParams.bottomMargin = AIOUtils.b(0.0F, this.b);
              }
            }
            else
            {
              ((ARTipsManager.ViewHolder)localObject).j.setVisibility(8);
              localLayoutParams.bottomMargin = AIOUtils.b(20.0F, this.b);
            }
            ((ARTipsManager.ViewHolder)localObject).f.setLayoutParams(localLayoutParams);
          }
        }
        else
        {
          ((ARTipsManager.ViewHolder)localObject).a.setVisibility(0);
          ((ARTipsManager.ViewHolder)localObject).f.setVisibility(8);
          ((ARTipsManager.ViewHolder)localObject).l.setVisibility(8);
          ((ARTipsManager.ViewHolder)localObject).b.setText(paramTipsInfo.d);
          if (TextUtils.isEmpty(paramTipsInfo.e))
          {
            ((ARTipsManager.ViewHolder)localObject).c.setVisibility(8);
            ((ARTipsManager.ViewHolder)localObject).b.setTextSize(1, 16.0F);
          }
          else
          {
            ((ARTipsManager.ViewHolder)localObject).c.setVisibility(0);
            ((ARTipsManager.ViewHolder)localObject).c.setText(paramTipsInfo.e);
            ((ARTipsManager.ViewHolder)localObject).b.setTextSize(1, 20.0F);
          }
          if (i != 1)
          {
            if (i != 2)
            {
              if (i == 3)
              {
                ((ARTipsManager.ViewHolder)localObject).d.setVisibility(8);
                ((ARTipsManager.ViewHolder)localObject).e.setVisibility(0);
                ((ARTipsManager.ViewHolder)localObject).e.setProgress(paramTipsInfo.h);
                ((ARTipsManager.ViewHolder)localObject).a.setEnabled(false);
              }
            }
            else
            {
              ((ARTipsManager.ViewHolder)localObject).d.setVisibility(0);
              ((ARTipsManager.ViewHolder)localObject).e.setVisibility(8);
              ((ARTipsManager.ViewHolder)localObject).d.setText(paramTipsInfo.f);
              ((ARTipsManager.ViewHolder)localObject).a.setEnabled(true);
            }
          }
          else
          {
            ((ARTipsManager.ViewHolder)localObject).d.setVisibility(8);
            ((ARTipsManager.ViewHolder)localObject).e.setVisibility(8);
            ((ARTipsManager.ViewHolder)localObject).a.setEnabled(false);
          }
        }
        if (this.g.getParent() == null) {
          e();
        }
        if (paramTipsInfo.c)
        {
          this.d.removeMessages(101);
          paramTipsInfo = this.d.obtainMessage(101);
          this.d.sendMessageDelayed(paramTipsInfo, 5000L);
        }
      }
    }
  }
  
  private ViewGroup d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, "createTipsView");
    }
    ViewGroup localViewGroup = (ViewGroup)this.a.inflate(2131624250, null);
    if (localViewGroup != null)
    {
      ARTipsManager.ViewHolder localViewHolder = new ARTipsManager.ViewHolder(this, null);
      localViewHolder.a = ((ViewGroup)localViewGroup.findViewById(2131428721));
      localViewHolder.b = ((TextView)localViewGroup.findViewById(2131428725));
      localViewHolder.c = ((TextView)localViewGroup.findViewById(2131428723));
      localViewHolder.d = ((TextView)localViewGroup.findViewById(2131428722));
      localViewHolder.e = ((ARTipsCircleProgress)localViewGroup.findViewById(2131428724));
      localViewHolder.f = ((ViewGroup)localViewGroup.findViewById(2131428709));
      localViewHolder.g = ((ViewGroup)localViewGroup.findViewById(2131428711));
      localViewHolder.h = ((TextView)localViewGroup.findViewById(2131428713));
      localViewHolder.i = ((TextView)localViewGroup.findViewById(2131428712));
      localViewHolder.j = ((ViewGroup)localViewGroup.findViewById(2131428714));
      localViewHolder.k = ((TextView)localViewGroup.findViewById(2131428715));
      localViewHolder.l = localViewGroup.findViewById(2131428716);
      localViewHolder.m = ((TextView)localViewGroup.findViewById(2131428717));
      localViewHolder.n = ((TextView)localViewGroup.findViewById(2131428719));
      localViewHolder.o = ((ImageView)localViewGroup.findViewById(2131428710));
      localViewGroup.setTag(localViewHolder);
      localViewGroup.setOnTouchListener(new ARTipsManager.1(this));
    }
    return localViewGroup;
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, "addTipsWithAnim");
    }
    Object localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(12, -1);
    this.e.addView(this.g, (ViewGroup.LayoutParams)localObject);
    this.g.setVisibility(4);
    localObject = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    ((ValueAnimator)localObject).setDuration(400L);
    ((ValueAnimator)localObject).addUpdateListener(new ARTipsManager.6(this));
    ((ValueAnimator)localObject).addListener(new ARTipsManager.7(this));
    ((ValueAnimator)localObject).start();
    localObject = this.f;
    if (localObject != null) {
      ((ARTipsManager.ARTipsVisibleListener)localObject).a(true);
    }
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, "removeTipsWithAnim");
    }
    Object localObject = this.g;
    if (localObject != null)
    {
      this.g = null;
      ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      localValueAnimator.setDuration(400L);
      localValueAnimator.addUpdateListener(new ARTipsManager.8(this, (View)localObject));
      localValueAnimator.addListener(new ARTipsManager.9(this, (View)localObject));
      localValueAnimator.start();
      localObject = this.f;
      if (localObject != null) {
        ((ARTipsManager.ARTipsVisibleListener)localObject).a(false);
      }
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARTipsManager", 2, String.format("dismissTips", new Object[0]));
    }
    this.d.removeMessages(100);
    if (this.g != null) {
      this.d.obtainMessage(101).sendToTarget();
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    a(paramInt, 1, paramString, null, null, null, 0, true);
  }
  
  public void a(int paramInt, String paramString1, String paramString2, String paramString3, ARTipsManager.ButtonClickListener paramButtonClickListener, boolean paramBoolean)
  {
    a(paramInt, 2, paramString1, paramString2, paramString3, paramButtonClickListener, 0, paramBoolean);
  }
  
  public void a(int paramInt, String paramString, boolean paramBoolean)
  {
    a(paramInt, 1, paramString, null, null, null, 0, paramBoolean);
  }
  
  public void a(String paramString)
  {
    a(0, paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    a(0, 3, paramString, null, null, null, paramInt, false);
  }
  
  public void a(String paramString1, String paramString2, ARTipsManager.BaikeClickListener paramBaikeClickListener, boolean paramBoolean)
  {
    a(0, 10, paramString1, paramString2, paramBaikeClickListener, false, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, ARTipsManager.ButtonClickListener paramButtonClickListener)
  {
    a(paramString1, paramString2, paramButtonClickListener, false);
  }
  
  public void a(String paramString1, String paramString2, ARTipsManager.ButtonClickListener paramButtonClickListener, boolean paramBoolean)
  {
    a(0, paramString1, null, paramString2, paramButtonClickListener, paramBoolean);
  }
  
  public int b()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = (ARTipsManager.TipsInfo)((ViewGroup)localObject).getTag(2131428720);
      if (localObject != null) {
        return ((ARTipsManager.TipsInfo)localObject).a;
      }
    }
    return 0;
  }
  
  public boolean c()
  {
    ViewGroup localViewGroup = this.g;
    return (localViewGroup != null) && (localViewGroup.getVisibility() == 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.ARTipsManager
 * JD-Core Version:    0.7.0.1
 */