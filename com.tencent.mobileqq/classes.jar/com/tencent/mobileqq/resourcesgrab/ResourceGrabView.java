package com.tencent.mobileqq.resourcesgrab;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import azyj;
import azyt;
import azyu;
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
  private long jdField_a_of_type_Long;
  private Application.ActivityLifecycleCallbacks jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks = new azyu(this);
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private WeakReference<Activity> jdField_a_of_type_MqqUtilWeakReference;
  boolean jdField_a_of_type_Boolean = false;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private boolean jdField_b_of_type_Boolean;
  private Button c;
  private Button d;
  
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
    LayoutInflater.from(paramContext).inflate(2131558941, this, true);
    c();
  }
  
  private Activity a()
  {
    Activity localActivity = null;
    if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
      localActivity = (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    }
    Object localObject = localActivity;
    if (localActivity == null) {
      localObject = BaseActivity.sTopActivity;
    }
    return localObject;
  }
  
  private Fragment a()
  {
    Activity localActivity = a();
    if ((localActivity instanceof FragmentActivity)) {
      return ((FragmentActivity)localActivity).getSupportFragmentManager().findFragmentByTag("ResourceGrabFragment");
    }
    return null;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)getContext().getSystemService("window"));
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(ViewUtils.dpToPx(6.0F));
    localGradientDrawable.setColor(-1);
    localGradientDrawable.setStroke(ViewUtils.dpToPx(1.5F), getResources().getColor(2131167120));
    setBackgroundDrawable(localGradientDrawable);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131363982));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131363962));
    this.c = ((Button)findViewById(2131363794));
    this.d = ((Button)findViewById(2131363786));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379805));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    d();
  }
  
  private void d()
  {
    setOnTouchListener(new azyt(this));
  }
  
  private void e()
  {
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    if (this.jdField_b_of_type_Boolean)
    {
      str = "关闭";
      localButton.setText(str);
      localButton = this.jdField_b_of_type_AndroidWidgetButton;
      if (!this.jdField_a_of_type_Boolean) {
        break label47;
      }
    }
    label47:
    for (String str = "不发送";; str = "发送")
    {
      localButton.setText(str);
      return;
      str = "开启";
      break;
    }
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeView(this);
      azyj.a().a = null;
      a(false);
      BaseApplicationImpl.getApplication().unregisterActivityLifecycleCallbacks(this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("ResourceGrabView", 1, "hideFromWindow error : " + localException);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ResourceGrabView", 2, "enableGrabResourceName on: " + paramBoolean);
    }
    Object localObject = a();
    if (!paramBoolean) {
      if ((localObject instanceof ResourceGrabFragment))
      {
        localObject = (ResourceGrabFragment)localObject;
        ((ResourceGrabFragment)localObject).a(this);
        ((ResourceGrabFragment)localObject).d();
      }
    }
    do
    {
      return;
      if ((localObject instanceof ResourceGrabFragment))
      {
        localObject = (ResourceGrabFragment)localObject;
        ((ResourceGrabFragment)localObject).a(this);
        ((ResourceGrabFragment)localObject).b();
        return;
      }
      localObject = a();
    } while (!(localObject instanceof FragmentActivity));
    ResourceGrabFragment localResourceGrabFragment = new ResourceGrabFragment();
    localResourceGrabFragment.a(this);
    ((FragmentActivity)localObject).getSupportFragmentManager().beginTransaction().add(localResourceGrabFragment, "ResourceGrabFragment").commitAllowingStateLoss();
    localResourceGrabFragment.b();
  }
  
  void b()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetButton.setText("开启");
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidWidgetButton.setText("发送");
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setText("开启");
        a(false);
        Toast.makeText(getContext(), "资源获取功能已关闭", 0).show();
        label95:
        if (this.jdField_b_of_type_Boolean) {
          break label141;
        }
      }
      for (;;)
      {
        this.jdField_b_of_type_Boolean = bool1;
        break;
        this.jdField_a_of_type_AndroidWidgetButton.setText("关闭");
        a(true);
        Toast.makeText(getContext(), "资源获取功能已开启", 0).show();
        break label95;
        label141:
        bool1 = false;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetButton.setText("发送");
        Toast.makeText(getContext(), "发送图片至我的电脑功能已关闭", 0).show();
        label176:
        if (this.jdField_a_of_type_Boolean) {
          break label219;
        }
      }
      label219:
      for (bool1 = bool2;; bool1 = false)
      {
        this.jdField_a_of_type_Boolean = bool1;
        break;
        this.jdField_b_of_type_AndroidWidgetButton.setText("不发送");
        Toast.makeText(getContext(), "发送图片至我的电脑功能已开启", 0).show();
        break label176;
      }
      a();
      continue;
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.resourcesgrab.ResourceGrabView
 * JD-Core Version:    0.7.0.1
 */