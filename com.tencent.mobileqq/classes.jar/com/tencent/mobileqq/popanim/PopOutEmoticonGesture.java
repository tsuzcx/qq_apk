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
  private int jdField_a_of_type_Int = MobileQQ.getContext().getResources().getDisplayMetrics().heightPixels;
  private View jdField_a_of_type_AndroidViewView = PopOutAnimViewHolder.a().a.findViewById(2131372942);
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private StateMachine jdField_a_of_type_ComTencentMobileqqPopanimStateStateMachine;
  public boolean a;
  private boolean b;
  private boolean c;
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateMachine.a();
  }
  
  public void a(ViewGroup paramViewGroup1, ViewGroup paramViewGroup2, QQEmoticonPanelLinearLayoutHelper paramQQEmoticonPanelLinearLayoutHelper, IPanelInteractionListener paramIPanelInteractionListener)
  {
    EmoticonMainPanel localEmoticonMainPanel = (EmoticonMainPanel)((IEmosmService)QRoute.api(IEmosmService.class)).tryGetEmoticonMainPanel(paramIPanelInteractionListener);
    if (localEmoticonMainPanel == null) {
      QLog.e("PopOutEmoticonGesture", 1, "init, get mainPane fail");
    } else {
      ((EmoticonPopOutHelper)localEmoticonMainPanel.getEmoController().getHelperProvider().getHelper(11)).a(this);
    }
    this.jdField_a_of_type_AndroidWidgetEditText = paramIPanelInteractionListener.getAIOInput();
    StateContext localStateContext = new StateContext();
    localStateContext.jdField_a_of_type_ComTencentMobileqqPopanimPopOutEmoticonGesture = this;
    localStateContext.jdField_a_of_type_ComTencentMobileqqPopanimPopOutAnimConfig = paramIPanelInteractionListener.getPopOutAnimConfig();
    localStateContext.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup1;
    localStateContext.b = paramViewGroup2;
    localStateContext.jdField_a_of_type_AndroidWidgetEditText = this.jdField_a_of_type_AndroidWidgetEditText;
    localStateContext.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = localEmoticonMainPanel;
    localStateContext.jdField_a_of_type_ComTencentMobileqqEmoticonviewQQEmoticonPanelLinearLayoutHelper = paramQQEmoticonPanelLinearLayoutHelper;
    this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateMachine = new StateMachine(this, localStateContext);
    if (QLog.isColorLevel()) {
      QLog.i("PopOutEmoticonGesture", 2, "init");
    }
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateMachine.a(paramEmoticonInfo);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateMachine.a(paramMotionEvent);
  }
  
  public void b()
  {
    this.b = true;
    if (this.c) {
      this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateMachine.a();
    }
  }
  
  public boolean b(MotionEvent paramMotionEvent)
  {
    int[] arrayOfInt = new int[2];
    this.jdField_a_of_type_AndroidWidgetEditText.getLocationOnScreen(arrayOfInt);
    return paramMotionEvent.getRawY() > arrayOfInt[1];
  }
  
  public void c()
  {
    this.c = true;
    if (this.b) {
      this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateMachine.a();
    }
  }
  
  public boolean c(MotionEvent paramMotionEvent)
  {
    return paramMotionEvent.getRawY() > this.jdField_a_of_type_Int - this.jdField_a_of_type_AndroidViewView.getHeight();
  }
  
  public void d()
  {
    this.b = false;
    this.c = false;
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.PopOutEmoticonGesture
 * JD-Core Version:    0.7.0.1
 */