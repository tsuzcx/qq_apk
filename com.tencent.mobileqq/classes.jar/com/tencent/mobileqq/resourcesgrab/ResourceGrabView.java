package com.tencent.mobileqq.resourcesgrab;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.util.WeakReference;

public class ResourceGrabView
  extends LinearLayout
  implements View.OnClickListener
{
  boolean a = false;
  TextView b;
  private boolean c = false;
  private long d = 0L;
  private WindowManager.LayoutParams e = new WindowManager.LayoutParams();
  private WindowManager f;
  private Button g;
  private Button h;
  private Button i;
  private Button j;
  private WeakReference<Activity> k;
  private Application.ActivityLifecycleCallbacks l = new ResourceGrabView.2(this);
  
  public ResourceGrabView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public ResourceGrabView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ResourceGrabView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(2131624525, this, true);
    c();
  }
  
  private void c()
  {
    this.f = ((WindowManager)getContext().getSystemService("window"));
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(ViewUtils.dpToPx(6.0F));
    localGradientDrawable.setColor(-1);
    localGradientDrawable.setStroke(ViewUtils.dpToPx(1.5F), getResources().getColor(2131168149));
    setBackgroundDrawable(localGradientDrawable);
    this.g = ((Button)findViewById(2131430041));
    this.h = ((Button)findViewById(2131430016));
    this.i = ((Button)findViewById(2131429840));
    this.j = ((Button)findViewById(2131429831));
    this.b = ((TextView)findViewById(2131448710));
    this.g.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    d();
  }
  
  private void d()
  {
    setOnTouchListener(new ResourceGrabView.1(this));
  }
  
  private void e()
  {
    Button localButton = this.g;
    String str;
    if (this.c) {
      str = "关闭";
    } else {
      str = "开启";
    }
    localButton.setText(str);
    localButton = this.h;
    if (this.a) {
      str = "不发送";
    } else {
      str = "发送";
    }
    localButton.setText(str);
  }
  
  private Activity getCurActivity()
  {
    Object localObject1 = this.k;
    if (localObject1 != null) {
      localObject1 = (Activity)((WeakReference)localObject1).get();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = BaseActivity.sTopActivity;
    }
    return localObject2;
  }
  
  private Fragment getCurFragment()
  {
    Activity localActivity = getCurActivity();
    if ((localActivity instanceof BaseActivity)) {
      return ((BaseActivity)localActivity).getSupportFragmentManager().findFragmentByTag("ResourceGrabFragment");
    }
    return null;
  }
  
  void a()
  {
    try
    {
      this.f.removeView(this);
      ResourceGrabHelper.a().a = null;
      a(false);
      BaseApplicationImpl.getApplication().unregisterActivityLifecycleCallbacks(this.l);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("hideFromWindow error : ");
      localStringBuilder.append(localException);
      QLog.d("ResourceGrabView", 1, localStringBuilder.toString());
    }
  }
  
  void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enableGrabResourceName on: ");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("ResourceGrabView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = getCurFragment();
    if (!paramBoolean)
    {
      if ((localObject instanceof ResourceGrabFragment))
      {
        localObject = (ResourceGrabFragment)localObject;
        ((ResourceGrabFragment)localObject).a(this);
        ((ResourceGrabFragment)localObject).d();
      }
    }
    else
    {
      if ((localObject instanceof ResourceGrabFragment))
      {
        localObject = (ResourceGrabFragment)localObject;
        ((ResourceGrabFragment)localObject).a(this);
        ((ResourceGrabFragment)localObject).a();
        return;
      }
      localObject = getCurActivity();
      if ((localObject instanceof BaseActivity))
      {
        ResourceGrabFragment localResourceGrabFragment = new ResourceGrabFragment();
        localResourceGrabFragment.a(this);
        ((BaseActivity)localObject).getSupportFragmentManager().beginTransaction().add(localResourceGrabFragment, "ResourceGrabFragment").commitAllowingStateLoss();
        localResourceGrabFragment.a();
      }
    }
  }
  
  void b()
  {
    this.c = false;
    this.g.setText("开启");
    this.a = false;
    this.h.setText("发送");
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131430041: 
      if (this.c)
      {
        this.g.setText("开启");
        a(false);
        Toast.makeText(getContext(), "资源获取功能已关闭", 0).show();
      }
      else
      {
        this.g.setText("关闭");
        a(true);
        Toast.makeText(getContext(), "资源获取功能已开启", 0).show();
      }
      this.c ^= true;
      break;
    case 2131430016: 
      if (this.a)
      {
        this.h.setText("发送");
        Toast.makeText(getContext(), "发送图片至我的电脑功能已关闭", 0).show();
      }
      else
      {
        this.h.setText("不发送");
        Toast.makeText(getContext(), "发送图片至我的电脑功能已开启", 0).show();
      }
      this.a ^= true;
      break;
    case 2131429840: 
      a();
      break;
    case 2131429831: 
      this.b.setText("");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.resourcesgrab.ResourceGrabView
 * JD-Core Version:    0.7.0.1
 */