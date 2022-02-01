package com.tencent.mobileqq.writetogether.client;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.easysync2.AText;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.mobileqq.writetogether.IWriteTogetherObserver;
import com.tencent.mobileqq.writetogether.WTConstants;
import com.tencent.mobileqq.writetogether.WriteTogetherUtils;
import com.tencent.mobileqq.writetogether.api.IQQWriteTogetherService;
import com.tencent.mobileqq.writetogether.data.DocMetaData;
import com.tencent.mobileqq.writetogether.data.EditUserHistory;
import com.tencent.mobileqq.writetogether.data.IEditorModel;
import com.tencent.mobileqq.writetogether.data.UserEditInfo;
import com.tencent.mobileqq.writetogether.statemachine.UserState;
import com.tencent.mobileqq.writetogether.statemachine.UserStateMachineController;
import com.tencent.mobileqq.writetogether.websocket.msg.ClientReadyRespMsg;
import com.tencent.mobileqq.writetogether.websocket.msg.OnPostResult;
import com.tencent.mobileqq.writetogether.websocket.msg.OnPostWrapper;
import com.tencent.mobileqq.writetogether.websocket.msg.Type;
import com.tencent.mobileqq.writetogether.websocket.msg.UserLeaveMsg;
import com.tencent.mobileqq.writetogether.websocket.msg.UserLeaveMsg.Body;
import com.tencent.mobileqq.writetogether.websocket.msg.UserLeaveMsg.Notice;
import com.tencent.mobileqq.writetogether.websocket.msg.UserNewInfoMsg;
import com.tencent.mobileqq.writetogether.websocket.msg.UserNewInfoMsg.Body;
import com.tencent.mobileqq.writetogether.websocket.msg.UserNewInfoMsg.Notice;
import com.tencent.mobileqq.writetogetherui.UserStateBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

public class UserStateController
  implements View.OnClickListener, IWriteTogetherObserver, IOnChangesetCommit, IPartChangeListener, SaveTimeUpdater
{
  private int jdField_a_of_type_Int;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private Context jdField_a_of_type_AndroidContentContext;
  private UserStateController.OnCharacterOverSizeListener jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController$OnCharacterOverSizeListener;
  private UserStateController.OnUserNewInfoListener jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController$OnUserNewInfoListener;
  private IEditorModel jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel;
  private UserStateMachineController jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController;
  private UserStateBar jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean = true;
  
  public UserStateController(AppRuntime paramAppRuntime, UserStateBar paramUserStateBar, IEditorModel paramIEditorModel, int paramInt, Context paramContext)
  {
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar = paramUserStateBar;
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel = paramIEditorModel;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController = new UserStateMachineController(paramContext, paramInt, paramUserStateBar, paramIEditorModel);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(this);
    ((IQQWriteTogetherService)paramAppRuntime.getRuntimeService(IQQWriteTogetherService.class, "")).addObservers(this);
    a(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar.a().setOnClickListener(this);
  }
  
  private long a()
  {
    return System.currentTimeMillis();
  }
  
  @NonNull
  private String a(long paramLong, int paramInt, String paramString)
  {
    if (!WriteTogetherUtils.a(a(), paramLong))
    {
      if (QLog.isColorLevel()) {
        QLog.d("UserStateController", 2, "not in same year. ");
      }
      if (b()) {
        return WriteTogetherUtils.a(this.jdField_a_of_type_AndroidContentContext.getString(2131720176), paramLong);
      }
      return WriteTogetherUtils.a(this.jdField_a_of_type_AndroidContentContext.getString(2131720177), paramString, paramLong);
    }
    StringBuilder localStringBuilder;
    if (paramInt > 604800000)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("last modified before ");
        localStringBuilder.append(paramInt / 604800000);
        localStringBuilder.append(" 7 days");
        QLog.d("UserStateController", 4, localStringBuilder.toString());
      }
      if (b()) {
        return WriteTogetherUtils.b(this.jdField_a_of_type_AndroidContentContext.getString(2131720174), paramLong);
      }
      return WriteTogetherUtils.b(this.jdField_a_of_type_AndroidContentContext.getString(2131720175), paramString, paramLong);
    }
    if (paramInt > 86400000)
    {
      paramInt /= 86400000;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("last modified before ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" day");
        QLog.d("UserStateController", 4, localStringBuilder.toString());
      }
      if (b()) {
        return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131720168), new Object[] { Integer.valueOf(paramInt) });
      }
      return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131720169), new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    if (paramInt > 3600000)
    {
      paramInt /= 3600000;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("last modified before ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" hour");
        QLog.d("UserStateController", 4, localStringBuilder.toString());
      }
      if (b()) {
        return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131720170), new Object[] { Integer.valueOf(paramInt) });
      }
      return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131720171), new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    if (paramInt > 60000)
    {
      paramInt /= 60000;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("last modified before ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" min");
        QLog.d("UserStateController", 4, localStringBuilder.toString());
      }
      if (b()) {
        return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131720172), new Object[] { Integer.valueOf(paramInt) });
      }
      return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131720173), new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    if (QLog.isColorLevel()) {
      QLog.d("UserStateController", 4, "last modified in 1 min");
    }
    if (b()) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131720166);
    }
    return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131720167), new Object[] { paramString });
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new UserStateController.1(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.TIME_TICK");
    localIntentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
    localIntentFilter.addAction("android.intent.action.TIME_SET");
    paramContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[throwExceptionIfNeeded] reason: ");
      localStringBuilder.append(paramString);
      QLog.d("UserStateController", 2, localStringBuilder.toString());
    }
  }
  
  private void a(boolean paramBoolean, UserLeaveMsg paramUserLeaveMsg)
  {
    if ((paramBoolean) && (paramUserLeaveMsg != null))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[onUserLeave] msg: ");
        localStringBuilder.append(paramUserLeaveMsg.toJson());
        QLog.d("UserStateController", 2, localStringBuilder.toString());
      }
      paramUserLeaveMsg = (UserLeaveMsg.Body)paramUserLeaveMsg.body;
      if (paramUserLeaveMsg != null)
      {
        paramUserLeaveMsg = paramUserLeaveMsg.notice;
        if (paramUserLeaveMsg != null)
        {
          paramUserLeaveMsg = WriteTogetherUtils.a(paramUserLeaveMsg.userId);
          this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(paramUserLeaveMsg);
          return;
        }
        QLog.e("UserStateController", 1, "[onUserLeave] notice is null");
        return;
      }
      QLog.e("UserStateController", 1, "[onUserLeave] body is null");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onUserLeave] failed. msg :");
    if (paramUserLeaveMsg == null) {
      paramUserLeaveMsg = "msg is null";
    } else {
      paramUserLeaveMsg = paramUserLeaveMsg.toJson();
    }
    localStringBuilder.append(paramUserLeaveMsg);
    QLog.e("UserStateController", 1, localStringBuilder.toString());
  }
  
  private void a(boolean paramBoolean, UserNewInfoMsg paramUserNewInfoMsg)
  {
    if ((paramBoolean) && (paramUserNewInfoMsg != null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[onUserNewInfo] msg: ");
        ((StringBuilder)localObject).append(paramUserNewInfoMsg.toJson());
        QLog.d("UserStateController", 2, ((StringBuilder)localObject).toString());
      }
      localObject = (UserNewInfoMsg.Body)paramUserNewInfoMsg.body;
      if (localObject != null)
      {
        localObject = ((UserNewInfoMsg.Body)localObject).notice;
        if (localObject != null)
        {
          long l2 = ((UserNewInfoMsg.Notice)localObject).aliveTime;
          long l1 = l2;
          if (l2 <= 0L) {
            l1 = a();
          }
          localObject = WriteTogetherUtils.a(((UserNewInfoMsg.Notice)localObject).userId);
          UserEditInfo localUserEditInfo = new UserEditInfo();
          localUserEditInfo.a = WriteTogetherUtils.a(((UserNewInfoMsg.Body)paramUserNewInfoMsg.body).notice.userId);
          localUserEditInfo.jdField_b_of_type_Int = WTConstants.jdField_a_of_type_ArrayOfInt[(((UserNewInfoMsg.Body)paramUserNewInfoMsg.body).notice.colorId % WTConstants.jdField_a_of_type_ArrayOfInt.length)];
          localUserEditInfo.jdField_b_of_type_JavaLangString = a(localUserEditInfo.a);
          if (QLog.isColorLevel())
          {
            paramUserNewInfoMsg = new StringBuilder();
            paramUserNewInfoMsg.append("[onUserNewInfo] getNickName from ContactUtils: ");
            paramUserNewInfoMsg.append(localUserEditInfo.jdField_b_of_type_JavaLangString);
            QLog.d("UserStateController", 2, paramUserNewInfoMsg.toString());
          }
          this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a((String)localObject, l1, localUserEditInfo);
          return;
        }
        QLog.e("UserStateController", 1, "[onUserNewInfo] notice is null");
        return;
      }
      QLog.e("UserStateController", 1, "[onUserNewInfo] body is null");
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onUserNewInfo] failed. msg: ");
    if (paramUserNewInfoMsg == null) {
      paramUserNewInfoMsg = "msg is null";
    } else {
      paramUserNewInfoMsg = paramUserNewInfoMsg.toJson();
    }
    ((StringBuilder)localObject).append(paramUserNewInfoMsg);
    QLog.e("UserStateController", 1, ((StringBuilder)localObject).toString());
  }
  
  private boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a() != UserState.NEW_DOC;
  }
  
  private String b(String paramString)
  {
    return TextUtils.ellipsize(paramString, this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar.b(), this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar.a(), TextUtils.TruncateAt.END).toString();
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    Object localObject;
    if (paramInt1 >= paramInt2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("not reach the limit ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", with current ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.w("UserStateController", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a() != UserState.CHARACTERS_OVERSIZE) {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.CHARACTERS_OVERSIZE);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a() == UserState.CHARACTERS_OVERSIZE)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar;
      String str = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131720178), new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.b() != UserState.NEW_DOC) {
        bool = false;
      }
      ((UserStateBar)localObject).a(str, bool);
    }
  }
  
  private boolean b()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.b();
    String str2 = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a();
    if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1))) {
      return str1.equals(str2);
    }
    return true;
  }
  
  private String c(String paramString)
  {
    return TextUtils.ellipsize(paramString, this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar.a(), this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar.b(), TextUtils.TruncateAt.END).toString();
  }
  
  private String d(String paramString)
  {
    return ((ITroopMemberNameService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberName(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.d(), paramString);
  }
  
  private void g()
  {
    try
    {
      String str = String.format("https://qun.qq.com/writetogether/history?gc=%s&padid=%s&_wv=3", new Object[] { URLEncoder.encode(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.d(), "utf-8"), URLEncoder.encode(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a().jdField_b_of_type_JavaLangString), "utf-8" });
      ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.jdField_a_of_type_AndroidContentContext, "/base/browser");
      localActivityURIRequest.extra().putString("url", str);
      QRoute.startUri(localActivityURIRequest, new UserStateController.2(this));
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
  }
  
  protected String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str2 = d(paramString);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str2 = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(paramString);
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = paramString;
      }
    }
    return str1;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserStateController", 4, "[onCommitStart]");
    }
    if (a())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a() == UserState.ALERT) {
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.COMMIT_WHILE_ALERT);
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a() == UserState.LAST_EDIT) || (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a() == UserState.LAST_SAVE)) {
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.SAVING);
      }
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserStateController", 4, "[onCommitComplete]");
    }
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(a());
    IEditorModel localIEditorModel = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel;
    localIEditorModel.b(localIEditorModel.b());
    if (a())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a() == UserState.COMMIT_WHILE_ALERT) {
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.ACCEPT_WHILE_ALERT);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a() == UserState.SAVING) {
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.LAST_SAVE);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a() == UserState.LAST_SAVE) {
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(1);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      b(paramInt1, paramInt2);
    } else if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a() == UserState.CHARACTERS_OVERSIZE) {
      if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.b() == UserState.NEW_DOC) {
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.NEW_DOC);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.SAVING);
      }
    }
    UserStateController.OnCharacterOverSizeListener localOnCharacterOverSizeListener = this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController$OnCharacterOverSizeListener;
    if (localOnCharacterOverSizeListener != null)
    {
      boolean bool;
      if (paramInt1 < paramInt2) {
        bool = true;
      } else {
        bool = false;
      }
      localOnCharacterOverSizeListener.a(bool);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt != -2)
    {
      if (paramInt != -1)
      {
        if (paramInt != 40401)
        {
          switch (paramInt)
          {
          default: 
            return;
          case 65021: 
          case 65023: 
            this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.SANCTION);
            return;
          case 65020: 
            this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.GAG, paramString);
            return;
          }
          this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.COMMIT_ERR);
          return;
        }
        b(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(), this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a().a.length());
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.NET_ERR);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.NET_AVAIL);
  }
  
  public void a(UserStateController.OnCharacterOverSizeListener paramOnCharacterOverSizeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController$OnCharacterOverSizeListener = paramOnCharacterOverSizeListener;
  }
  
  public void a(UserStateController.OnUserNewInfoListener paramOnUserNewInfoListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController$OnUserNewInfoListener = paramOnUserNewInfoListener;
  }
  
  public void a(Type paramType, boolean paramBoolean, Object paramObject)
  {
    if ((paramType == Type.USER_NEWINFO) && ((paramObject instanceof UserNewInfoMsg)))
    {
      paramType = (UserNewInfoMsg)paramObject;
      paramObject = this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController$OnUserNewInfoListener;
      if (paramObject != null) {
        paramObject.a(paramBoolean, paramType);
      }
      a(paramBoolean, paramType);
      return;
    }
    if ((paramType == Type.USER_LEAVE) && ((paramObject instanceof UserLeaveMsg)))
    {
      a(paramBoolean, (UserLeaveMsg)paramObject);
      return;
    }
    if (paramType == Type.CLIENT_READY)
    {
      paramType = ((OnPostWrapper)((ClientReadyRespMsg)paramObject).body).onpost;
      if (paramType.result == 60010)
      {
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.ROOM_FULL);
        return;
      }
      if ((paramBoolean) && ((paramType.result == 0) || (paramType.result == 60009)) && (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a() != UserState.ROOM_AVAILABLE))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a() != UserState.ROOM_FULL) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.ROOM_AVAILABLE);
      }
    }
  }
  
  public void a(String paramString, List<String> paramList, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramList == null) {
        return;
      }
      ArrayList localArrayList = new ArrayList(paramList);
      int j = localArrayList.size();
      if (!paramBoolean) {
        localArrayList.remove(paramString);
      }
      paramList = new StringBuilder();
      Object localObject1;
      if (!paramBoolean)
      {
        paramString = b(a(paramString));
        paramList.append(paramString);
        paramList.append("发起");
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[onPartChange] get owner nick name: ");
          ((StringBuilder)localObject1).append(paramString);
          QLog.d("UserStateController", 2, ((StringBuilder)localObject1).toString());
        }
      }
      if (localArrayList.size() != 0)
      {
        if (!paramBoolean) {
          paramList.append("，");
        }
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar.b();
        if (paramBoolean) {
          i = 1;
        } else {
          i = 2;
        }
        if (j > i) {
          i = 1;
        } else {
          i = 0;
        }
        Object localObject2 = new StringBuilder();
        if (i != 0)
        {
          paramString = new StringBuilder();
          paramString.append("等");
          paramString.append(j);
          paramString.append("人");
          paramString = paramString.toString();
        }
        else
        {
          paramString = "";
        }
        ((StringBuilder)localObject2).append(paramString);
        if (paramBoolean) {
          paramString = "正在输入";
        } else {
          paramString = "一起写";
        }
        ((StringBuilder)localObject2).append(paramString);
        localObject2 = ((StringBuilder)localObject2).toString();
        float f = this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar.c();
        paramString = new StringBuilder();
        paramString.append(WTConstants.jdField_a_of_type_JavaLangCharacter);
        paramString.append(paramList.toString());
        f = f - ((TextPaint)localObject1).measureText(paramString.toString()) - ((TextPaint)localObject1).measureText((String)localObject2);
        j = 0;
        int i = 3;
        while ((j < localArrayList.size()) && (i > 0))
        {
          paramString = a((String)localArrayList.get(j));
          if (f < this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar.d()) {
            break;
          }
          paramString = TextUtils.ellipsize(paramString, this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar.b(), f, TextUtils.TruncateAt.END).toString();
          paramList.append(paramString);
          paramList.append(WTConstants.jdField_a_of_type_JavaLangCharacter);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append(WTConstants.jdField_a_of_type_JavaLangCharacter);
          f -= ((TextPaint)localObject1).measureText(localStringBuilder.toString());
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[onPartChange] get partNickName: ");
            localStringBuilder.append(paramString);
            QLog.d("UserStateController", 2, localStringBuilder.toString());
          }
          j += 1;
          i -= 1;
        }
        paramString = paramList.toString();
        if (WTConstants.jdField_a_of_type_JavaLangCharacter.charValue() == paramList.toString().charAt(paramList.length() - 1)) {
          paramString = paramList.substring(0, paramList.length() - 1);
        }
        paramList = new StringBuilder();
        paramList.append(paramString);
        paramList.append((String)localObject2);
        paramString = paramList.toString();
      }
      else
      {
        paramString = paramList.toString();
      }
      this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar.a(paramString);
    }
  }
  
  public void a(List<EditUserHistory> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(paramList);
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a();
    if ((localObject != UserState.LAST_EDIT) && (localObject != UserState.SANCTION)) {
      return;
    }
    long l = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a();
    if (l <= 0L)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[updateSaveTime] last save time not init yet: ");
        ((StringBuilder)localObject).append(l);
        QLog.d("UserStateController", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    localObject = a(l, (int)(a() - l), c(a(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a())));
    this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar.a((String)localObject, 1);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    ((IQQWriteTogetherService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IQQWriteTogetherService.class, "")).removeObserver(this);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a();
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.LAST_EDIT);
  }
  
  public void e()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a() != UserState.NEW_USER_HINT) && (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a() != UserState.INACTIVATED) && (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a() != UserState.ROOM_AVAILABLE) && (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a() != UserState.LAST_EDIT))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onEditorActivated] trans from illegal state: ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a());
      a(localStringBuilder.toString());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.ALERT);
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a() == UserState.INACTIVATED)
    {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.NEW_USER_HINT);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onNewUserHintShow] trans from illegal state: ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a());
    a(localStringBuilder.toString());
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131381266) {
      g();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.client.UserStateController
 * JD-Core Version:    0.7.0.1
 */