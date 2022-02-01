package com.tencent.mobileqq.popanim.state;

import android.view.MotionEvent;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.popanim.PopOutAnimViewHolder;
import com.tencent.mobileqq.popanim.PopOutEmoticonGesture;
import com.tencent.qphone.base.util.QLog;

public class StateMachine
{
  private BlurMaskState a;
  private PopAnimState b;
  private PopDeleteState c;
  private TouchUpState d;
  private EndAnimState e;
  private StateContext f;
  private BaseState g;
  private BaseState h;
  private boolean i;
  private PopOutEmoticonGesture j;
  
  public StateMachine(PopOutEmoticonGesture paramPopOutEmoticonGesture, StateContext paramStateContext)
  {
    this.j = paramPopOutEmoticonGesture;
    this.f = paramStateContext;
    paramPopOutEmoticonGesture = PopOutAnimViewHolder.a().b;
    this.a = new BlurMaskState(paramPopOutEmoticonGesture, paramStateContext);
    this.b = new PopAnimState(paramPopOutEmoticonGesture, paramStateContext);
    this.c = new PopDeleteState(paramPopOutEmoticonGesture, paramStateContext);
    this.d = new TouchUpState(paramPopOutEmoticonGesture, paramStateContext);
    this.e = new EndAnimState(paramPopOutEmoticonGesture, paramStateContext);
  }
  
  private void a(int paramInt)
  {
    BaseState localBaseState1 = b(paramInt);
    if (localBaseState1 != this.g)
    {
      if (this.i) {
        return;
      }
      if (QLog.isColorLevel())
      {
        paramInt = hashCode();
        String str = null;
        if (localBaseState1 != null) {
          localObject = localBaseState1.getClass().getSimpleName();
        } else {
          localObject = null;
        }
        BaseState localBaseState2 = this.g;
        if (localBaseState2 != null) {
          str = localBaseState2.getClass().getSimpleName();
        }
        QLog.d("PopOut_StateMachine", 2, new Object[] { "transition state, hashCode:", Integer.valueOf(paramInt), " newState = ", localObject, " preState:", str });
      }
      this.h = this.g;
      this.g = localBaseState1;
      Object localObject = this.h;
      if (localObject != null) {
        ((BaseState)localObject).b(this.g);
      }
      localObject = this.g;
      if (localObject != null) {
        ((BaseState)localObject).a(this.h);
      }
    }
  }
  
  private BaseState b(int paramInt)
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
            return this.e;
          }
          return this.d;
        }
        return this.c;
      }
      return this.b;
    }
    return this.a;
  }
  
  public void a()
  {
    a(4);
    a(5);
    this.i = true;
  }
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    this.i = false;
    this.f.b = paramEmoticonInfo;
    a(1);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3) && (!this.f.j))
    {
      if ((paramMotionEvent.getAction() == 2) && (!this.f.b()))
      {
        StateContext localStateContext = this.f;
        boolean bool;
        if ((!localStateContext.h) && (this.j.b(paramMotionEvent))) {
          bool = false;
        } else {
          bool = true;
        }
        localStateContext.h = bool;
        if (this.f.h) {
          if (this.j.c(paramMotionEvent)) {
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
    this.g.a(paramMotionEvent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.popanim.state.StateMachine
 * JD-Core Version:    0.7.0.1
 */