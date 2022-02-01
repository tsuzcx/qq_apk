package com.tencent.mobileqq.popanim.state;

import android.view.MotionEvent;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.popanim.PopOutAnimViewHolder;
import com.tencent.mobileqq.popanim.PopOutEmoticonGesture;
import com.tencent.qphone.base.util.QLog;

public class StateMachine
{
  private PopOutEmoticonGesture jdField_a_of_type_ComTencentMobileqqPopanimPopOutEmoticonGesture;
  private BaseState jdField_a_of_type_ComTencentMobileqqPopanimStateBaseState;
  private BlurMaskState jdField_a_of_type_ComTencentMobileqqPopanimStateBlurMaskState;
  private EndAnimState jdField_a_of_type_ComTencentMobileqqPopanimStateEndAnimState;
  private PopAnimState jdField_a_of_type_ComTencentMobileqqPopanimStatePopAnimState;
  private PopDeleteState jdField_a_of_type_ComTencentMobileqqPopanimStatePopDeleteState;
  private StateContext jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext;
  private TouchUpState jdField_a_of_type_ComTencentMobileqqPopanimStateTouchUpState;
  private boolean jdField_a_of_type_Boolean;
  private BaseState b;
  
  public StateMachine(PopOutEmoticonGesture paramPopOutEmoticonGesture, StateContext paramStateContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqPopanimPopOutEmoticonGesture = paramPopOutEmoticonGesture;
    this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext = paramStateContext;
    paramPopOutEmoticonGesture = PopOutAnimViewHolder.a().a;
    this.jdField_a_of_type_ComTencentMobileqqPopanimStateBlurMaskState = new BlurMaskState(paramPopOutEmoticonGesture, paramStateContext);
    this.jdField_a_of_type_ComTencentMobileqqPopanimStatePopAnimState = new PopAnimState(paramPopOutEmoticonGesture, paramStateContext);
    this.jdField_a_of_type_ComTencentMobileqqPopanimStatePopDeleteState = new PopDeleteState(paramPopOutEmoticonGesture, paramStateContext);
    this.jdField_a_of_type_ComTencentMobileqqPopanimStateTouchUpState = new TouchUpState(paramPopOutEmoticonGesture, paramStateContext);
    this.jdField_a_of_type_ComTencentMobileqqPopanimStateEndAnimState = new EndAnimState(paramPopOutEmoticonGesture, paramStateContext);
  }
  
  private BaseState a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("getCurState exception type = ");
                localStringBuilder.append(paramInt);
                QLog.d("PopOut_StateMachine", 2, localStringBuilder.toString());
              }
              return null;
            }
            return this.jdField_a_of_type_ComTencentMobileqqPopanimStateEndAnimState;
          }
          return this.jdField_a_of_type_ComTencentMobileqqPopanimStateTouchUpState;
        }
        return this.jdField_a_of_type_ComTencentMobileqqPopanimStatePopDeleteState;
      }
      return this.jdField_a_of_type_ComTencentMobileqqPopanimStatePopAnimState;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPopanimStateBlurMaskState;
  }
  
  private void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("transitionToState type = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("PopOut_StateMachine", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(paramInt);
    BaseState localBaseState = this.jdField_a_of_type_ComTencentMobileqqPopanimStateBaseState;
    if (localObject != localBaseState)
    {
      if (this.jdField_a_of_type_Boolean) {
        return;
      }
      this.b = localBaseState;
      this.jdField_a_of_type_ComTencentMobileqqPopanimStateBaseState = ((BaseState)localObject);
      localObject = this.b;
      if (localObject != null) {
        ((BaseState)localObject).b(this.jdField_a_of_type_ComTencentMobileqqPopanimStateBaseState);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqPopanimStateBaseState;
      if (localObject != null) {
        ((BaseState)localObject).a(this.b);
      }
    }
  }
  
  public void a()
  {
    a(4);
    a(5);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo = paramEmoticonInfo;
    a(1);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3) && (!this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.c))
    {
      if (paramMotionEvent.getAction() == 2)
      {
        StateContext localStateContext = this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext;
        boolean bool;
        if ((!localStateContext.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqPopanimPopOutEmoticonGesture.b(paramMotionEvent))) {
          bool = false;
        } else {
          bool = true;
        }
        localStateContext.jdField_a_of_type_Boolean = bool;
        if (this.jdField_a_of_type_ComTencentMobileqqPopanimStateStateContext.jdField_a_of_type_Boolean) {
          if (this.jdField_a_of_type_ComTencentMobileqqPopanimPopOutEmoticonGesture.c(paramMotionEvent)) {
            a(3);
          } else {
            a(2);
          }
        }
      }
    }
    else {
      a(4);
    }
    this.jdField_a_of_type_ComTencentMobileqqPopanimStateBaseState.a(paramMotionEvent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.state.StateMachine
 * JD-Core Version:    0.7.0.1
 */