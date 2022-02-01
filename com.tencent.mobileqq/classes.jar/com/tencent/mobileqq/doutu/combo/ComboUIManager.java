package com.tencent.mobileqq.doutu.combo;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.doutu.IDoutuListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

@TargetApi(11)
public class ComboUIManager
  implements Handler.Callback, View.OnTouchListener
{
  private int jdField_a_of_type_Int = 0;
  public Activity a;
  Context jdField_a_of_type_AndroidContentContext;
  Handler jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  public RelativeLayout a;
  public BaseQQAppInterface a;
  public IDoutuListener a;
  ComboEggView jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView;
  ComboMasterView jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView;
  ComboNavigateBar jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar;
  private ComboObject jdField_a_of_type_ComTencentMobileqqDoutuComboComboObject;
  RelativeLayout b;
  
  public ComboUIManager(BaseQQAppInterface paramBaseQQAppInterface, Activity paramActivity, IDoutuListener paramIDoutuListener, RelativeLayout paramRelativeLayout)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_AndroidContentContext = paramRelativeLayout.getContext();
    this.jdField_a_of_type_ComTencentMobileqqDoutuIDoutuListener = paramIDoutuListener;
  }
  
  private ComboEggView a(ComboObject paramComboObject)
  {
    f();
    ComboEggView localComboEggView = (ComboEggView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558527, null);
    localComboEggView.a(this, this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface);
    if (localComboEggView.a(paramComboObject))
    {
      paramComboObject = new RelativeLayout.LayoutParams(-1, -1);
      paramComboObject.addRule(13);
      this.b.addView(localComboEggView, paramComboObject);
      localComboEggView.b();
      return localComboEggView;
    }
    b(paramComboObject);
    return null;
  }
  
  private ComboMasterView a(ComboObject paramComboObject)
  {
    f();
    ComboMasterView localComboMasterView = (ComboMasterView)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558528, null);
    localComboMasterView.a(this);
    if (localComboMasterView.a(paramComboObject))
    {
      paramComboObject = new RelativeLayout.LayoutParams(-1, -1);
      paramComboObject.addRule(13);
      this.b.addView(localComboMasterView, paramComboObject);
      localComboMasterView.a();
      return localComboMasterView;
    }
    b(paramComboObject);
    return null;
  }
  
  private boolean a()
  {
    Object localObject = Runtime.getRuntime();
    long l1 = (((Runtime)localObject).totalMemory() - ((Runtime)localObject).freeMemory()) / 1048576L;
    long l2 = ((Runtime)localObject).maxMemory() / 1048576L;
    long l3 = l2 - l1;
    boolean bool;
    if (l3 < 10L) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(" hasOOMDanger: ");
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(" availHeapSizeInMB:");
      ((StringBuilder)localObject).append(l3);
      ((StringBuilder)localObject).append(" maxHeapSizeInMB:");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append(" usedMemInMB:");
      ((StringBuilder)localObject).append(l1);
      QLog.d("ComboUIManager", 2, ((StringBuilder)localObject).toString());
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "ComboEggOOM", bool ^ true, l3, l1, null, "");
    return bool;
  }
  
  private void b(ComboObject paramComboObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar = ((ComboNavigateBar)LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131558529, null));
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar.a(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface);
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.indexOfChild(this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar) == -1)
    {
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, Utils.a(32.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      localLayoutParams.addRule(11);
      localLayoutParams.topMargin = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131299168) + Utils.a(22.0F, this.jdField_a_of_type_AndroidContentContext.getResources()));
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar, localLayoutParams);
    }
    this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar.setInfo(paramComboObject);
  }
  
  private void f()
  {
    if (this.b == null)
    {
      this.b = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      this.b.setOnTouchListener(this);
    }
    FrameLayout localFrameLayout = (FrameLayout)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView();
    if (localFrameLayout.indexOfChild(this.b) == -1)
    {
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localFrameLayout.addView(this.b, localLayoutParams);
    }
  }
  
  public ComboObject a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComboUIManager", 2, "clearAnimationView");
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView;
    if (localObject != null)
    {
      ((ComboMasterView)localObject).a(this.b);
      localObject = new ComboObject(this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView.jdField_a_of_type_ComTencentMobileqqDoutuComboComboObject.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView.jdField_a_of_type_ComTencentMobileqqDoutuComboComboObject.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView = null;
      return localObject;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView;
    if (localObject != null)
    {
      ((ComboEggView)localObject).a(this.b);
      localObject = new ComboObject(this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView.jdField_a_of_type_ComTencentMobileqqDoutuComboComboObject.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView.jdField_a_of_type_ComTencentMobileqqDoutuComboComboObject.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView = null;
      return localObject;
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComboUIManager", 2, "uninit");
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    c();
    e();
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(12, paramLong);
  }
  
  public void a(Animator paramAnimator, ComboMasterView paramComboMasterView)
  {
    if (this.b != null)
    {
      paramAnimator = paramComboMasterView.jdField_a_of_type_ComTencentMobileqqDoutuComboComboObject;
      if ((paramAnimator != null) && (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboObject.jdField_a_of_type_Int == paramAnimator.jdField_a_of_type_Int)) {
        b(paramAnimator);
      }
      this.b.removeView(paramComboMasterView);
    }
    paramAnimator = this.jdField_a_of_type_ComTencentMobileqqDoutuIDoutuListener;
    if (paramAnimator != null) {
      paramAnimator.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView = null;
  }
  
  public void a(ComboEggView paramComboEggView)
  {
    if (this.b != null)
    {
      ComboObject localComboObject = paramComboEggView.jdField_a_of_type_ComTencentMobileqqDoutuComboComboObject;
      if ((localComboObject != null) && (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboObject.jdField_a_of_type_Int == localComboObject.jdField_a_of_type_Int)) {
        b(localComboObject);
      }
      this.b.removeView(paramComboEggView);
    }
    paramComboEggView = this.jdField_a_of_type_ComTencentMobileqqDoutuIDoutuListener;
    if (paramComboEggView != null) {
      paramComboEggView.b();
    }
    this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView = null;
  }
  
  public void a(ComboObject paramComboObject)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboObject != null)
        {
          int i = this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboObject.jdField_a_of_type_Int;
          int j = paramComboObject.jdField_a_of_type_Int;
          if (i >= j) {
            return;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboObject = paramComboObject;
        Object localObject = this.jdField_a_of_type_AndroidOsHandler;
        bool = true;
        localObject = ((Handler)localObject).obtainMessage(1);
        ((Message)localObject).obj = paramComboObject;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("update  msg what:");
          localStringBuilder.append(((Message)localObject).what);
          localStringBuilder.append(" ");
          localStringBuilder.append(paramComboObject);
          QLog.d("ComboUIManager", 2, localStringBuilder.toString());
        }
        if (!paramComboObject.jdField_a_of_type_Boolean) {
          ((Message)localObject).what = 1;
        } else if (ComboEggView.a(paramComboObject.jdField_a_of_type_Int)) {
          ((Message)localObject).what = 3;
        } else if (paramComboObject.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentUin())) {
          ((Message)localObject).what = 2;
        } else {
          ((Message)localObject).what = 1;
        }
        if (QLog.isColorLevel())
        {
          paramComboObject = new StringBuilder();
          paramComboObject.append("update, mDoutuListener == null : ");
          if (this.jdField_a_of_type_ComTencentMobileqqDoutuIDoutuListener == null)
          {
            paramComboObject.append(bool);
            QLog.d("ComboUIManager", 2, paramComboObject.toString());
          }
        }
        else
        {
          if ((this.jdField_a_of_type_ComTencentMobileqqDoutuIDoutuListener != null) && (!this.jdField_a_of_type_ComTencentMobileqqDoutuIDoutuListener.b()) && (((Message)localObject).what < 11))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ComboUIManager", 2, "isTroopAioTipsShown");
            }
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ComboUIManager", 2, "update sendMessage");
          }
          this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed((Message)localObject, 0L);
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeMessages(12);
  }
  
  public void c()
  {
    if (this.b != null)
    {
      localObject = (FrameLayout)this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView();
      a();
      ((FrameLayout)localObject).removeView(this.b);
      this.b = null;
    }
    ComboResource.a();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar;
    if (localObject != null)
    {
      RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (localRelativeLayout != null) {
        localRelativeLayout.removeView((View)localObject);
      }
      if (QLog.isColorLevel()) {
        QLog.d("ComboUIManager", 2, "clearViews, set mComboNavigateBar null");
      }
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar = null;
    }
  }
  
  public void d()
  {
    ComboObject localComboObject = a();
    if (localComboObject != null) {
      b(localComboObject);
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComboUIManager", 2, "removeListener");
    }
    this.jdField_a_of_type_ComTencentMobileqqDoutuIDoutuListener = null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    ComboObject localComboObject = (ComboObject)paramMessage.obj;
    Object localObject1 = a();
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[Doutu] + handleMessage : ");
      ((StringBuilder)localObject2).append(paramMessage.what);
      QLog.d("ComboUIManager", 2, ((StringBuilder)localObject2).toString());
    }
    int i = paramMessage.what;
    if (i != 1)
    {
      if ((i != 2) && (i != 3))
      {
        if (i != 11)
        {
          if (i != 12) {
            return true;
          }
          if (QLog.isColorLevel())
          {
            paramMessage = new StringBuilder();
            paramMessage.append("[Doutu] + handleMessage : 12 ,mComboNavigateBar == null : ");
            boolean bool;
            if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar == null) {
              bool = true;
            } else {
              bool = false;
            }
            paramMessage.append(bool);
            QLog.d("ComboUIManager", 2, paramMessage.toString());
          }
          paramMessage = this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboNavigateBar;
          if (paramMessage != null) {
            paramMessage.a();
          }
          this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboObject = null;
          c();
          return true;
        }
        c();
        return true;
      }
      if (localComboObject.jdField_a_of_type_Int > 999) {
        localComboObject.jdField_a_of_type_Int = 999;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDoutuIDoutuListener;
      if ((localObject2 != null) && (!((IDoutuListener)localObject2).a()))
      {
        b(localComboObject);
        return true;
      }
      if (localObject1 != null) {
        b((ComboObject)localObject1);
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDoutuIDoutuListener;
      if (localObject1 != null) {
        ((IDoutuListener)localObject1).a();
      }
      if (paramMessage.what == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView = a(localComboObject);
        return true;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, "dc00898", "", "", "0X8008096", "0X8008096", 0, 0, "", "", "", "");
      if (a())
      {
        if (localComboObject.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentAccountUin()))
        {
          this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView = a(localComboObject);
          return true;
        }
        b(localComboObject);
        return true;
      }
      this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView = a(localComboObject);
      if (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView == null)
      {
        b(localComboObject);
        return true;
      }
    }
    else
    {
      if (localComboObject.jdField_a_of_type_Int > 999) {
        localComboObject.jdField_a_of_type_Int = 999;
      }
      b(localComboObject);
    }
    return true;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboMasterView == null) && (this.jdField_a_of_type_ComTencentMobileqqDoutuComboComboEggView == null)) {
      return false;
    }
    d();
    paramView = this.jdField_a_of_type_ComTencentMobileqqDoutuIDoutuListener;
    if (paramView != null) {
      paramView.b();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.combo.ComboUIManager
 * JD-Core Version:    0.7.0.1
 */