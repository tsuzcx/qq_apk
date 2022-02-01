package com.tencent.mobileqq.writetogether.statemachine;

import android.content.Context;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.writetogether.client.SaveTimeUpdater;
import com.tencent.mobileqq.writetogether.data.IEditorModel;
import com.tencent.mobileqq.writetogether.statemachine.core.StateMachine;
import com.tencent.mobileqq.writetogether.statemachine.core.StateProcessor;
import com.tencent.mobileqq.writetogetherui.UserStateBar;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Collections;

public class UserStateMachineController
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private SaveTimeUpdater jdField_a_of_type_ComTencentMobileqqWritetogetherClientSaveTimeUpdater;
  private IEditorModel jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel;
  private StateMachine<UserState> jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine;
  private UserStateBar jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar;
  
  public UserStateMachineController(Context paramContext, int paramInt, UserStateBar paramUserStateBar, IEditorModel paramIEditorModel)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar = paramUserStateBar;
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel = paramIEditorModel;
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar.f();
    ReportController.b(null, "dc00898", "", "", "0X800B2D8", "0X800B2D8", 0, 0, "", "", "", "");
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.a() != UserState.ALERT) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("UserStateMachineControl", 2, "showAlertWording");
    }
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar.a(paramBoolean);
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("UserStateMachineControl", 2, "showAvailableWording");
    }
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar.e();
  }
  
  public UserState a()
  {
    return (UserState)this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.a();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.a(paramInt);
  }
  
  public void a(SaveTimeUpdater paramSaveTimeUpdater)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientSaveTimeUpdater = paramSaveTimeUpdater;
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine = new StateMachine(UserState.INACTIVATED, "UserStateMachineControl");
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.a(new StateProcessor(UserState.COMMIT_WHILE_ALERT, Arrays.asList(new UserState[] { UserState.ALERT, UserState.NET_AVAIL, UserState.COMMIT_ERR })));
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.a(new StateProcessor(UserState.ACCEPT_WHILE_ALERT, Arrays.asList(new UserState[] { UserState.COMMIT_WHILE_ALERT, UserState.NET_AVAIL })));
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.a(new StateProcessor(UserState.INACTIVATED, Collections.singletonList(UserState.INACTIVATED)));
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.a(new UserStateMachineController.1(this, UserState.ALERT, Arrays.asList(new UserState[] { UserState.NEW_USER_HINT, UserState.INACTIVATED, UserState.ROOM_AVAILABLE, UserState.LAST_EDIT })));
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.a(new UserStateMachineController.2(this, UserState.NEW_DOC, Arrays.asList(new UserState[] { UserState.ALERT, UserState.INACTIVATED, UserState.CHARACTERS_OVERSIZE })));
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.a(new UserStateMachineController.3(this, UserState.LAST_EDIT, Arrays.asList(new UserState[] { UserState.ALERT, UserState.INACTIVATED, UserState.NET_AVAIL, UserState.COMMIT_ERR })));
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.a(new UserStateMachineController.4(this, UserState.LAST_SAVE, Arrays.asList(new UserState[] { UserState.SAVING, UserState.ACCEPT_WHILE_ALERT, UserState.NET_AVAIL, UserState.COMMIT_ERR })));
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.a(new UserStateMachineController.5(this, UserState.SAVING, Arrays.asList(new UserState[] { UserState.CHARACTERS_OVERSIZE, UserState.LAST_EDIT, UserState.LAST_SAVE, UserState.COMMIT_WHILE_ALERT, UserState.NET_AVAIL })));
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.a(new UserStateMachineController.6(this, UserState.ROOM_FULL, Arrays.asList(new UserState[] { UserState.INACTIVATED, UserState.NET_AVAIL, UserState.LAST_EDIT, UserState.LAST_SAVE, UserState.CHARACTERS_OVERSIZE, UserState.SAVING })));
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.a(new UserStateMachineController.7(this, UserState.ROOM_AVAILABLE, Arrays.asList(new UserState[] { UserState.ROOM_FULL, UserState.NET_AVAIL })));
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.a(new StateProcessor(UserState.CHARACTERS_OVERSIZE, Arrays.asList(new UserState[] { UserState.CHARACTERS_OVERSIZE, UserState.LAST_EDIT, UserState.LAST_SAVE, UserState.NET_AVAIL, UserState.COMMIT_ERR, UserState.NEW_DOC, UserState.SAVING, UserState.ALERT })));
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.a(new StateProcessor(UserState.NEW_USER_HINT, Arrays.asList(new UserState[] { UserState.INACTIVATED, UserState.NET_AVAIL })));
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.a(new UserStateMachineController.8(this, UserState.NET_ERR, Arrays.asList(new UserState[] { UserState.ROOM_AVAILABLE, UserState.LAST_EDIT, UserState.LAST_SAVE, UserState.CHARACTERS_OVERSIZE, UserState.SAVING, UserState.COMMIT_WHILE_ALERT, UserState.ACCEPT_WHILE_ALERT })));
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.a(new UserStateMachineController.9(this, UserState.NET_AVAIL, Collections.singletonList(UserState.NET_ERR)));
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.a(new UserStateMachineController.10(this, UserState.COMMIT_ERR, Collections.singletonList(UserState.SAVING)));
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.a(new UserStateMachineController.11(this, UserState.SANCTION, Collections.singletonList(UserState.INACTIVATED)));
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.a(new UserStateMachineController.12(this, UserState.GAG, Arrays.asList(new UserState[] { UserState.SAVING, UserState.COMMIT_WHILE_ALERT })));
  }
  
  public void a(UserState paramUserState)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.a(paramUserState);
  }
  
  public void a(UserState paramUserState, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.a(paramUserState, paramString);
  }
  
  public UserState b()
  {
    return (UserState)this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineCoreStateMachine.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.statemachine.UserStateMachineController
 * JD-Core Version:    0.7.0.1
 */