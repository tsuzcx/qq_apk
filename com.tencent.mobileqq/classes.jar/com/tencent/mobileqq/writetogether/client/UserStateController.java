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
        return WriteTogetherUtils.a(this.jdField_a_of_type_AndroidContentContext.getString(2131720461), paramLong);
      }
      return WriteTogetherUtils.a(this.jdField_a_of_type_AndroidContentContext.getString(2131720462), paramString, paramLong);
    }
    if (paramInt > 604800000)
    {
      if (QLog.isColorLevel()) {
        QLog.d("UserStateController", 4, "last modified before " + paramInt / 604800000 + " 7 days");
      }
      if (b()) {
        return WriteTogetherUtils.b(this.jdField_a_of_type_AndroidContentContext.getString(2131720459), paramLong);
      }
      return WriteTogetherUtils.b(this.jdField_a_of_type_AndroidContentContext.getString(2131720460), paramString, paramLong);
    }
    if (paramInt > 86400000)
    {
      paramInt /= 86400000;
      if (QLog.isColorLevel()) {
        QLog.d("UserStateController", 4, "last modified before " + paramInt + " day");
      }
      if (b()) {
        return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131720453), new Object[] { Integer.valueOf(paramInt) });
      }
      return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131720454), new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    if (paramInt > 3600000)
    {
      paramInt /= 3600000;
      if (QLog.isColorLevel()) {
        QLog.d("UserStateController", 4, "last modified before " + paramInt + " hour");
      }
      if (b()) {
        return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131720455), new Object[] { Integer.valueOf(paramInt) });
      }
      return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131720456), new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    if (paramInt > 60000)
    {
      paramInt /= 60000;
      if (QLog.isColorLevel()) {
        QLog.d("UserStateController", 4, "last modified before " + paramInt + " min");
      }
      if (b()) {
        return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131720457), new Object[] { Integer.valueOf(paramInt) });
      }
      return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131720458), new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    if (QLog.isColorLevel()) {
      QLog.d("UserStateController", 4, "last modified in 1 min");
    }
    if (b()) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131720451);
    }
    return String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131720452), new Object[] { paramString });
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
    if (QLog.isColorLevel()) {
      QLog.d("UserStateController", 2, "[throwExceptionIfNeeded] reason: " + paramString);
    }
  }
  
  private void a(boolean paramBoolean, UserLeaveMsg paramUserLeaveMsg)
  {
    if ((!paramBoolean) || (paramUserLeaveMsg == null))
    {
      StringBuilder localStringBuilder = new StringBuilder().append("[onUserLeave] failed. msg :");
      if (paramUserLeaveMsg == null) {}
      for (paramUserLeaveMsg = "msg is null";; paramUserLeaveMsg = paramUserLeaveMsg.toJson())
      {
        QLog.e("UserStateController", 1, paramUserLeaveMsg);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("UserStateController", 2, "[onUserLeave] msg: " + paramUserLeaveMsg.toJson());
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
  }
  
  private void a(boolean paramBoolean, UserNewInfoMsg paramUserNewInfoMsg)
  {
    if ((!paramBoolean) || (paramUserNewInfoMsg == null))
    {
      localObject = new StringBuilder().append("[onUserNewInfo] failed. msg: ");
      if (paramUserNewInfoMsg == null) {}
      for (paramUserNewInfoMsg = "msg is null";; paramUserNewInfoMsg = paramUserNewInfoMsg.toJson())
      {
        QLog.e("UserStateController", 1, paramUserNewInfoMsg);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("UserStateController", 2, "[onUserNewInfo] msg: " + paramUserNewInfoMsg.toJson());
    }
    Object localObject = (UserNewInfoMsg.Body)paramUserNewInfoMsg.body;
    long l;
    if (localObject != null)
    {
      localObject = ((UserNewInfoMsg.Body)localObject).notice;
      if (localObject != null)
      {
        l = ((UserNewInfoMsg.Notice)localObject).aliveTime;
        if (l > 0L) {
          break label283;
        }
        l = a();
      }
    }
    label283:
    for (;;)
    {
      localObject = WriteTogetherUtils.a(((UserNewInfoMsg.Notice)localObject).userId);
      UserEditInfo localUserEditInfo = new UserEditInfo();
      localUserEditInfo.a = WriteTogetherUtils.a(((UserNewInfoMsg.Body)paramUserNewInfoMsg.body).notice.userId);
      localUserEditInfo.jdField_b_of_type_Int = WTConstants.jdField_a_of_type_ArrayOfInt[(((UserNewInfoMsg.Body)paramUserNewInfoMsg.body).notice.colorId % WTConstants.jdField_a_of_type_ArrayOfInt.length)];
      localUserEditInfo.jdField_b_of_type_JavaLangString = a(localUserEditInfo.a);
      if (QLog.isColorLevel()) {
        QLog.d("UserStateController", 2, "[onUserNewInfo] getNickName from ContactUtils: " + localUserEditInfo.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a((String)localObject, l, localUserEditInfo);
      return;
      QLog.e("UserStateController", 1, "[onUserNewInfo] notice is null");
      return;
      QLog.e("UserStateController", 1, "[onUserNewInfo] body is null");
      return;
    }
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
    if (paramInt1 >= paramInt2) {
      QLog.w("UserStateController", 1, "not reach the limit " + paramInt1 + ", with current " + paramInt2);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a() != UserState.CHARACTERS_OVERSIZE) {
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.CHARACTERS_OVERSIZE);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a() != UserState.CHARACTERS_OVERSIZE);
    UserStateBar localUserStateBar = this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar;
    String str = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131720463), new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.b() == UserState.NEW_DOC) {}
    for (;;)
    {
      localUserStateBar.a(str, bool);
      return;
      bool = false;
    }
  }
  
  private boolean b()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.b();
    String str2 = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a();
    if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1))) {
      return true;
    }
    return str1.equals(str2);
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
      paramString = "";
    }
    String str1;
    do
    {
      return paramString;
      String str2 = d(paramString);
      str1 = str2;
      if (!TextUtils.isEmpty(str2)) {
        break;
      }
      str1 = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(paramString);
    } while (TextUtils.isEmpty(str1));
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
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.b(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.b());
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
    UserStateController.OnCharacterOverSizeListener localOnCharacterOverSizeListener;
    if (paramInt1 < paramInt2)
    {
      b(paramInt1, paramInt2);
      if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController$OnCharacterOverSizeListener != null)
      {
        localOnCharacterOverSizeListener = this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController$OnCharacterOverSizeListener;
        if (paramInt1 >= paramInt2) {
          break label92;
        }
      }
    }
    label92:
    for (boolean bool = true;; bool = false)
    {
      localOnCharacterOverSizeListener.a(bool);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a() != UserState.CHARACTERS_OVERSIZE) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.b() == UserState.NEW_DOC)
      {
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.NEW_DOC);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.SAVING);
      break;
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 40401: 
      b(this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(), this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a().a.length());
      return;
    case -1: 
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.NET_ERR);
      return;
    case -2: 
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.NET_AVAIL);
      return;
    case 65020: 
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.GAG, paramString);
      return;
    case 65019: 
    case 65022: 
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.COMMIT_ERR);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.SANCTION);
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
      if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController$OnUserNewInfoListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherClientUserStateController$OnUserNewInfoListener.a(paramBoolean, paramType);
      }
      a(paramBoolean, paramType);
    }
    do
    {
      do
      {
        return;
        if ((paramType == Type.USER_LEAVE) && ((paramObject instanceof UserLeaveMsg)))
        {
          a(paramBoolean, (UserLeaveMsg)paramObject);
          return;
        }
      } while (paramType != Type.CLIENT_READY);
      paramType = ((OnPostWrapper)((ClientReadyRespMsg)paramObject).body).onpost;
      if (paramType.result == 60010)
      {
        this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.ROOM_FULL);
        return;
      }
    } while ((!paramBoolean) || ((paramType.result != 0) && (paramType.result != 60009)) || (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a() == UserState.ROOM_AVAILABLE) || (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a() != UserState.ROOM_FULL));
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.ROOM_AVAILABLE);
  }
  
  public void a(String paramString, List<String> paramList, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramList == null)) {
      return;
    }
    ArrayList localArrayList = new ArrayList(paramList);
    int j = localArrayList.size();
    if (!paramBoolean) {
      localArrayList.remove(paramString);
    }
    paramList = new StringBuilder();
    if (!paramBoolean)
    {
      paramString = b(a(paramString));
      paramList.append(paramString).append("发起");
      if (QLog.isColorLevel()) {
        QLog.d("UserStateController", 2, "[onPartChange] get owner nick name: " + paramString);
      }
    }
    TextPaint localTextPaint;
    int i;
    label158:
    Object localObject;
    label200:
    label216:
    float f1;
    if (localArrayList.size() != 0)
    {
      if (!paramBoolean) {
        paramList.append("，");
      }
      localTextPaint = this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar.b();
      if (paramBoolean)
      {
        i = 1;
        if (j <= i) {
          break label414;
        }
        i = 1;
        localObject = new StringBuilder();
        if (i == 0) {
          break label420;
        }
        paramString = "等" + j + "人";
        localObject = ((StringBuilder)localObject).append(paramString);
        if (!paramBoolean) {
          break label426;
        }
        paramString = "正在输入";
        localObject = paramString;
        f1 = this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar.c();
        float f2 = localTextPaint.measureText(WTConstants.jdField_a_of_type_JavaLangCharacter + paramList.toString());
        float f3 = localTextPaint.measureText((String)localObject);
        j = 3;
        f1 = f1 - f2 - f3;
        i = 0;
        label292:
        if ((i < localArrayList.size()) && (j > 0))
        {
          paramString = a((String)localArrayList.get(i));
          if (f1 >= this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar.d()) {
            break label433;
          }
        }
        paramString = paramList.toString();
        if (WTConstants.jdField_a_of_type_JavaLangCharacter.charValue() == paramList.toString().charAt(paramList.length() - 1)) {
          paramString = paramList.substring(0, paramList.length() - 1);
        }
      }
    }
    for (paramString = paramString + (String)localObject;; paramString = paramList.toString())
    {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar.a(paramString);
      return;
      i = 2;
      break;
      label414:
      i = 0;
      break label158;
      label420:
      paramString = "";
      break label200;
      label426:
      paramString = "一起写";
      break label216;
      label433:
      paramString = TextUtils.ellipsize(paramString, this.jdField_a_of_type_ComTencentMobileqqWritetogetheruiUserStateBar.b(), f1, TextUtils.TruncateAt.END).toString();
      paramList.append(paramString).append(WTConstants.jdField_a_of_type_JavaLangCharacter);
      f1 -= localTextPaint.measureText(paramString + WTConstants.jdField_a_of_type_JavaLangCharacter);
      if (QLog.isColorLevel()) {
        QLog.d("UserStateController", 2, "[onPartChange] get partNickName: " + paramString);
      }
      j -= 1;
      i += 1;
      break label292;
    }
  }
  
  public void a(List<EditUserHistory> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a(paramList);
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a();
    if ((localObject != UserState.LAST_EDIT) && (localObject != UserState.SANCTION)) {}
    long l;
    do
    {
      return;
      l = this.jdField_a_of_type_ComTencentMobileqqWritetogetherDataIEditorModel.a();
      if (l > 0L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("UserStateController", 2, "[updateSaveTime] last save time not init yet: " + l);
    return;
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
    if ((this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a() == UserState.NEW_USER_HINT) || (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a() == UserState.INACTIVATED) || (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a() == UserState.ROOM_AVAILABLE) || (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a() == UserState.LAST_EDIT))
    {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.ALERT);
      return;
    }
    a("[onEditorActivated] trans from illegal state: " + this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a());
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a() == UserState.INACTIVATED)
    {
      this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a(UserState.NEW_USER_HINT);
      return;
    }
    a("[onNewUserHintShow] trans from illegal state: " + this.jdField_a_of_type_ComTencentMobileqqWritetogetherStatemachineUserStateMachineController.a());
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131382064) {
      g();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.client.UserStateController
 * JD-Core Version:    0.7.0.1
 */