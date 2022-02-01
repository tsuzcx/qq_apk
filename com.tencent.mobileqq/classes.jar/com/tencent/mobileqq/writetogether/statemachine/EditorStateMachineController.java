package com.tencent.mobileqq.writetogether.statemachine;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.troop.api.observer.TroopPushObserver;
import com.tencent.mobileqq.writetogether.client.IScheduler;
import com.tencent.mobileqq.writetogether.client.ISchedulerCallback;
import com.tencent.mobileqq.writetogether.statemachine.core.StateMachine;
import com.tencent.mobileqq.writetogetherui.DocRefresher;
import com.tencent.mobileqq.writetogetherui.EditableModifier;
import java.util.Arrays;
import java.util.Collections;
import mqq.app.AppRuntime;

public class EditorStateMachineController
  implements ISchedulerCallback
{
  private AppRuntime a;
  private QBaseActivity b;
  private EditableModifier c;
  private StateMachine<EditorState> d;
  private IScheduler e;
  private DocRefresher f;
  private String g;
  private TroopPushObserver h = new EditorStateMachineController.1(this);
  
  public EditorStateMachineController(AppRuntime paramAppRuntime, QBaseActivity paramQBaseActivity, EditableModifier paramEditableModifier)
  {
    this.a = paramAppRuntime;
    this.b = paramQBaseActivity;
    this.c = paramEditableModifier;
    this.b.addObserver(this.h);
  }
  
  public EditorState a()
  {
    return (EditorState)this.d.a();
  }
  
  public void a(int paramInt)
  {
    this.d.a(paramInt);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt != -2)
    {
      if (paramInt != -1)
      {
        if (paramInt != 40401)
        {
          if (paramInt != 60010)
          {
            switch (paramInt)
            {
            default: 
              return;
            case 65021: 
            case 65022: 
            case 65023: 
              a(EditorState.BLOCKED, paramString);
              return;
            case 65020: 
              a(EditorState.GAG, paramString);
              return;
            }
            a(EditorState.NOT_MEMBER, paramString);
            return;
          }
          a(EditorState.ROOM_FULL);
          return;
        }
        a(EditorState.OVER_SIZE);
        return;
      }
      a(EditorState.NET_ERR);
      return;
    }
    a(EditorState.NET_AVAIL);
  }
  
  public void a(EditorState paramEditorState)
  {
    this.d.a(paramEditorState);
  }
  
  public void a(EditorState paramEditorState, String paramString)
  {
    this.d.a(paramEditorState, paramString);
  }
  
  public void a(DocRefresher paramDocRefresher)
  {
    this.f = paramDocRefresher;
  }
  
  public void a(String paramString)
  {
    this.g = paramString;
  }
  
  public void b()
  {
    this.d = new StateMachine(EditorState.UNLOADED, "EditorStateMachineContr");
    this.d.a(new EditorStateMachineController.EditableStateProcessor(this, EditorState.UNLOADED, Collections.singletonList(EditorState.OPEN_BY_ADMIN)));
    this.d.a(new EditorStateMachineController.2(this, EditorState.CREATING, Arrays.asList(new EditorState[] { EditorState.UNLOADED, EditorState.NET_AVAIL })));
    this.d.a(new EditorStateMachineController.EditableStateProcessor(this, EditorState.READY, Arrays.asList(new EditorState[] { EditorState.UNLOADED, EditorState.NET_AVAIL, EditorState.ROOM_FULL, EditorState.OPEN_BY_ADMIN })));
    this.d.a(new EditorStateMachineController.3(this, EditorState.LIMITED, Arrays.asList(new EditorState[] { EditorState.UNLOADED, EditorState.NET_AVAIL })));
    this.d.a(new EditorStateMachineController.4(this, EditorState.GAG_OR_ANONYMOUS_ON_ENTER, Arrays.asList(new EditorState[] { EditorState.UNLOADED, EditorState.NET_AVAIL, EditorState.ROOM_FULL, EditorState.OPEN_BY_ADMIN })));
    this.d.a(new EditorStateMachineController.5(this, EditorState.ACTIVATED, Arrays.asList(new EditorState[] { EditorState.READY, EditorState.NET_AVAIL, EditorState.OPEN_BY_ADMIN })));
    this.d.a(new EditorStateMachineController.6(this, EditorState.NET_ERR, Arrays.asList(new EditorState[] { EditorState.READY, EditorState.ACTIVATED, EditorState.NET_AVAIL, EditorState.CREATING, EditorState.OPEN_BY_ADMIN })));
    this.d.a(new EditorStateMachineController.ToastUneditableStateProcessor(this, EditorState.BLOCKED, Arrays.asList(new EditorState[] { EditorState.READY, EditorState.ACTIVATED, EditorState.UNLOADED, EditorState.NET_AVAIL })));
    this.d.a(new EditorStateMachineController.ShowToastWhenMoveToStateProcessor(this, EditorState.GAG, Arrays.asList(new EditorState[] { EditorState.READY, EditorState.ACTIVATED, EditorState.UNLOADED, EditorState.NET_AVAIL })));
    this.d.a(new EditorStateMachineController.7(this, EditorState.NET_AVAIL, Collections.singletonList(EditorState.NET_ERR)));
    this.d.a(new EditorStateMachineController.DialogUneditableStateProcessor(this, EditorState.NOT_MEMBER, Arrays.asList(new EditorState[] { EditorState.READY, EditorState.ACTIVATED, EditorState.UNLOADED, EditorState.NET_AVAIL })));
    this.d.a(new EditorStateMachineController.8(this, EditorState.CLOSED_BY_ADMIN, Arrays.asList(new EditorState[] { EditorState.READY, EditorState.ACTIVATED, EditorState.NET_ERR, EditorState.UNLOADED, EditorState.ROOM_FULL, EditorState.OVER_SIZE })));
    this.d.a(new EditorStateMachineController.9(this, EditorState.OPEN_BY_ADMIN, Collections.singletonList(EditorState.CLOSED_BY_ADMIN)));
    this.d.a(new EditorStateMachineController.10(this, EditorState.ROOM_FULL, Arrays.asList(new EditorState[] { EditorState.UNLOADED, EditorState.NET_AVAIL, EditorState.OPEN_BY_ADMIN, EditorState.READY, EditorState.ACTIVATED })));
  }
  
  public void c()
  {
    this.b.removeObserver(this.h);
  }
  
  public boolean c(int paramInt)
  {
    if (paramInt == 1)
    {
      this.f.c();
      this.e.a(1, 60000);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.EditorStateMachineController
 * JD-Core Version:    0.7.0.1
 */