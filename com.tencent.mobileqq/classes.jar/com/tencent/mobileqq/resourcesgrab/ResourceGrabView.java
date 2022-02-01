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
  private long jdField_a_of_type_Long = 0L;
  private Application.ActivityLifecycleCallbacks jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks = new ResourceGrabView.2(this);
  private WindowManager.LayoutParams jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
  private WindowManager jdField_a_of_type_AndroidViewWindowManager;
  private Button jdField_a_of_type_AndroidWidgetButton;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private WeakReference<Activity> jdField_a_of_type_MqqUtilWeakReference;
  boolean jdField_a_of_type_Boolean = false;
  private Button jdField_b_of_type_AndroidWidgetButton;
  private boolean jdField_b_of_type_Boolean = false;
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
    LayoutInflater.from(paramContext).inflate(2131558903, this, true);
    c();
  }
  
  private Activity a()
  {
    Object localObject1 = this.jdField_a_of_type_MqqUtilWeakReference;
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
  
  private Fragment a()
  {
    Activity localActivity = a();
    if ((localActivity instanceof BaseActivity)) {
      return ((BaseActivity)localActivity).getSupportFragmentManager().findFragmentByTag("ResourceGrabFragment");
    }
    return null;
  }
  
  private void c()
  {
    this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)getContext().getSystemService("window"));
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(ViewUtils.b(6.0F));
    localGradientDrawable.setColor(-1);
    localGradientDrawable.setStroke(ViewUtils.b(1.5F), getResources().getColor(2131167166));
    setBackgroundDrawable(localGradientDrawable);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131364078));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131364058));
    this.c = ((Button)findViewById(2131363890));
    this.d = ((Button)findViewById(2131363881));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379853));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.d.setOnClickListener(this);
    d();
  }
  
  private void d()
  {
    setOnTouchListener(new ResourceGrabView.1(this));
  }
  
  private void e()
  {
    Button localButton = this.jdField_a_of_type_AndroidWidgetButton;
    String str;
    if (this.jdField_b_of_type_Boolean) {
      str = "关闭";
    } else {
      str = "开启";
    }
    localButton.setText(str);
    localButton = this.jdField_b_of_type_AndroidWidgetButton;
    if (this.jdField_a_of_type_Boolean) {
      str = "不发送";
    } else {
      str = "发送";
    }
    localButton.setText(str);
  }
  
  void a()
  {
    try
    {
      this.jdField_a_of_type_AndroidViewWindowManager.removeView(this);
      ResourceGrabHelper.a().a = null;
      a(false);
      BaseApplicationImpl.getApplication().unregisterActivityLifecycleCallbacks(this.jdField_a_of_type_AndroidAppApplication$ActivityLifecycleCallbacks);
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
    Object localObject = a();
    if (!paramBoolean)
    {
      if ((localObject instanceof ResourceGrabFragment))
      {
        localObject = (ResourceGrabFragment)localObject;
        ((ResourceGrabFragment)localObject).a(this);
        ((ResourceGrabFragment)localObject).c();
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
      localObject = a();
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
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetButton.setText("开启");
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_AndroidWidgetButton.setText("发送");
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131364078: 
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetButton.setText("开启");
        a(false);
        Toast.makeText(getContext(), "资源获取功能已关闭", 0).show();
      }
      else
      {
        this.jdField_a_of_type_AndroidWidgetButton.setText("关闭");
        a(true);
        Toast.makeText(getContext(), "资源获取功能已开启", 0).show();
      }
      this.jdField_b_of_type_Boolean ^= true;
      break;
    case 2131364058: 
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidWidgetButton.setText("发送");
        Toast.makeText(getContext(), "发送图片至我的电脑功能已关闭", 0).show();
      }
      else
      {
        this.jdField_b_of_type_AndroidWidgetButton.setText("不发送");
        Toast.makeText(getContext(), "发送图片至我的电脑功能已开启", 0).show();
      }
      this.jdField_a_of_type_Boolean ^= true;
      break;
    case 2131363890: 
      a();
      break;
    case 2131363881: 
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.resourcesgrab.ResourceGrabView
 * JD-Core Version:    0.7.0.1
 */