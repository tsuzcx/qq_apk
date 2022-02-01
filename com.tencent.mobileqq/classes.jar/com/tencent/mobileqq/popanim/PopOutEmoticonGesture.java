package com.tencent.mobileqq.popanim;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.AIODepend.IPanelInteractionListener;
import com.tencent.mobileqq.emoticonview.EmoticonHelperProvider;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.emoticonview.QQEmoticonPanelLinearLayoutHelper;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.popanim.state.StateContext;
import com.tencent.mobileqq.popanim.state.StateMachine;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class PopOutEmoticonGesture
  implements EmoticonPopOutHelper.PopOutHelpListener
{
  public boolean a;
  private EditText b;
  private View c = PopOutAnimViewHolder.a().b.findViewById(2131440506);
  private int d = MobileQQ.getContext().getResources().getDisplayMetrics().heightPixels;
  private StateMachine e;
  private boolean f;
  private boolean g;
  
  public void a()
  {
    this.e.a();
  }
  
  public void a(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, QQEmoticonPanelLinearLayoutHelper paramQQEmoticonPanelLinearLayoutHelper, IPanelInteractionListener paramIPanelInteractionListener)
  {
    Object localObject = (EmoticonMainPanel)((IEmosmService)QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(paramIPanelInteractionListener);
    if (localObject == null) {
      QLog.e("PopOutEmoticonGesture", 1, "init, get mainPane fail");
    } else {
      ((EmoticonPopOutHelper)((EmoticonMainPanel)localObject).getEmoController().getHelperProvider().getHelper(11)).a(this);
    }
    this.b = paramIPanelInteractionListener.getAIOInput();
    localObject = new StateContext();
    ((StateContext)localObject).a = this;
    ((StateContext)localObject).c = paramIPanelInteractionListener.getPopOutAnimConfig();
    ((StateContext)localObject).d = paramViewGroup1;
    ((StateContext)localObject).e = paramViewGroup2;
    ((StateContext)localObject).f = this.b;
    ((StateContext)localObject).g = paramQQEmoticonPanelLinearLayoutHelper;
    this.e = new StateMachine(this, (StateContext)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("PopOutEmoticonGesture", 2, "init");
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    this.a = true;
    this.e.a(paramEmoticonInfo);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return this.e.a(paramMotionEvent);
  }
  
  public void b()
  {
    this.f = true;
    if (this.g) {
      this.e.a();
    }
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = new int[2];
    this.b.getLocationOnScreen(arrayOfInt);
    return paramMotionEvent.getRawY() > arrayOfInt[1];
  }
  
  public boolean c()
  {
    return this.a;
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getRawY() > this.d - this.c.getHeight();
  }
  
  public void d()
  {
    this.g = true;
    if (this.f) {
      this.e.a();
    }
  }
  
  public void e()
  {
    this.f = false;
    this.g = false;
    this.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.PopOutEmoticonGesture
 * JD-Core Version:    0.7.0.1
 */