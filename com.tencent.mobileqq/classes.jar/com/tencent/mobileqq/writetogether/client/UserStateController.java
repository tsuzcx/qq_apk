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
  private AppRuntime a;
  private Context b;
  private int c;
  private UserStateBar d;
  private IEditorModel e;
  private UserStateController.OnUserNewInfoListener f;
  private UserStateController.OnCharacterOverSizeListener g;
  private BroadcastReceiver h;
  private boolean i = true;
  private UserStateMachineController j;
  
  public UserStateController(AppRuntime paramAppRuntime, UserStateBar paramUserStateBar, IEditorModel paramIEditorModel, int paramInt, Context paramContext)
  {
    this.a = paramAppRuntime;
    this.b = paramContext;
    this.d = paramUserStateBar;
    this.e = paramIEditorModel;
    this.c = paramInt;
    this.j = new UserStateMachineController(paramContext, paramInt, paramUserStateBar, paramIEditorModel);
    this.j.a(this);
    ((IQQWriteTogetherService)paramAppRuntime.getRuntimeService(IQQWriteTogetherService.class, "")).addObservers(this);
    a(paramContext);
    this.d.l().setOnClickListener(this);
  }
  
  @NonNull
  private String a(long paramLong, int paramInt, String paramString)
  {
    if (!WriteTogetherUtils.a(i(), paramLong))
    {
      if (QLog.isColorLevel()) {
        QLog.d("UserStateController", 2, "not in same year. ");
      }
      if (j()) {
        return WriteTogetherUtils.a(this.b.getString(2131917806), paramLong);
      }
      return WriteTogetherUtils.a(this.b.getString(2131917807), paramString, paramLong);
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
      if (j()) {
        return WriteTogetherUtils.b(this.b.getString(2131917804), paramLong);
      }
      return WriteTogetherUtils.b(this.b.getString(2131917805), paramString, paramLong);
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
      if (j()) {
        return String.format(this.b.getString(2131917798), new Object[] { Integer.valueOf(paramInt) });
      }
      return String.format(this.b.getString(2131917799), new Object[] { paramString, Integer.valueOf(paramInt) });
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
      if (j()) {
        return String.format(this.b.getString(2131917800), new Object[] { Integer.valueOf(paramInt) });
      }
      return String.format(this.b.getString(2131917801), new Object[] { paramString, Integer.valueOf(paramInt) });
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
      if (j()) {
        return String.format(this.b.getString(2131917802), new Object[] { Integer.valueOf(paramInt) });
      }
      return String.format(this.b.getString(2131917803), new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    if (QLog.isColorLevel()) {
      QLog.d("UserStateController", 4, "last modified in 1 min");
    }
    if (j()) {
      return this.b.getString(2131917796);
    }
    return String.format(this.b.getString(2131917797), new Object[] { paramString });
  }
  
  private void a(Context paramContext)
  {
    this.h = new UserStateController.1(this);
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.TIME_TICK");
    localIntentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
    localIntentFilter.addAction("android.intent.action.TIME_SET");
    paramContext.registerReceiver(this.h, localIntentFilter);
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
          this.e.a(paramUserLeaveMsg);
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
            l1 = i();
          }
          localObject = WriteTogetherUtils.a(((UserNewInfoMsg.Notice)localObject).userId);
          UserEditInfo localUserEditInfo = new UserEditInfo();
          localUserEditInfo.a = WriteTogetherUtils.a(((UserNewInfoMsg.Body)paramUserNewInfoMsg.body).notice.userId);
          localUserEditInfo.d = WTConstants.d[(((UserNewInfoMsg.Body)paramUserNewInfoMsg.body).notice.colorId % WTConstants.d.length)];
          localUserEditInfo.b = a(localUserEditInfo.a);
          if (QLog.isColorLevel())
          {
            paramUserNewInfoMsg = new StringBuilder();
            paramUserNewInfoMsg.append("[onUserNewInfo] getNickName from ContactUtils: ");
            paramUserNewInfoMsg.append(localUserEditInfo.b);
            QLog.d("UserStateController", 2, paramUserNewInfoMsg.toString());
          }
          this.e.a((String)localObject, l1, localUserEditInfo);
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
  
  private String b(String paramString)
  {
    return TextUtils.ellipsize(paramString, this.d.n(), this.d.o(), TextUtils.TruncateAt.END).toString();
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
    if (this.j.a() != UserState.CHARACTERS_OVERSIZE) {
      this.j.a(UserState.CHARACTERS_OVERSIZE);
    }
    if (this.j.a() == UserState.CHARACTERS_OVERSIZE)
    {
      localObject = this.d;
      String str = String.format(this.b.getString(2131917808), new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
      if (this.j.b() != UserState.NEW_DOC) {
        bool = false;
      }
      ((UserStateBar)localObject).a(str, bool);
    }
  }
  
  private String c(String paramString)
  {
    return TextUtils.ellipsize(paramString, this.d.m(), this.d.p(), TextUtils.TruncateAt.END).toString();
  }
  
  private String d(String paramString)
  {
    return ((ITroopMemberNameService)this.a.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberName(this.e.m(), paramString);
  }
  
  private void e(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[throwExceptionIfNeeded] reason: ");
      localStringBuilder.append(paramString);
      QLog.d("UserStateController", 2, localStringBuilder.toString());
    }
  }
  
  private boolean g()
  {
    return this.j.a() != UserState.NEW_DOC;
  }
  
  private void h()
  {
    try
    {
      String str = String.format("https://qun.qq.com/writetogether/history?gc=%s&padid=%s&_wv=3", new Object[] { URLEncoder.encode(this.e.m(), "utf-8"), URLEncoder.encode(this.e.g().c), "utf-8" });
      ActivityURIRequest localActivityURIRequest = new ActivityURIRequest(this.b, "/base/browser");
      localActivityURIRequest.extra().putString("url", str);
      QRoute.startUri(localActivityURIRequest, new UserStateController.2(this));
      return;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
  }
  
  private long i()
  {
    return System.currentTimeMillis();
  }
  
  private boolean j()
  {
    String str1 = this.e.k();
    String str2 = this.e.j();
    if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1))) {
      return str1.equals(str2);
    }
    return true;
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
      str2 = this.e.b(paramString);
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = paramString;
      }
    }
    return str1;
  }
  
  public void a()
  {
    Object localObject = this.j.a();
    if ((localObject != UserState.LAST_EDIT) && (localObject != UserState.SANCTION)) {
      return;
    }
    long l = this.e.i();
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
    localObject = a(l, (int)(i() - l), c(a(this.e.j())));
    this.d.a((String)localObject, 1);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserStateController", 4, "[onCommitComplete]");
    }
    this.e.a(i());
    IEditorModel localIEditorModel = this.e;
    localIEditorModel.c(localIEditorModel.k());
    if (g())
    {
      if (this.j.a() == UserState.COMMIT_WHILE_ALERT) {
        this.j.a(UserState.ACCEPT_WHILE_ALERT);
      }
      if (this.j.a() == UserState.SAVING) {
        this.j.a(UserState.LAST_SAVE);
      }
      if (this.j.a() == UserState.LAST_SAVE) {
        this.j.a(1);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      b(paramInt1, paramInt2);
    } else if (this.j.a() == UserState.CHARACTERS_OVERSIZE) {
      if (this.j.b() == UserState.NEW_DOC) {
        this.j.a(UserState.NEW_DOC);
      } else {
        this.j.a(UserState.SAVING);
      }
    }
    UserStateController.OnCharacterOverSizeListener localOnCharacterOverSizeListener = this.g;
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
            this.j.a(UserState.SANCTION);
            return;
          case 65020: 
            this.j.a(UserState.GAG, paramString);
            return;
          }
          this.j.a(UserState.COMMIT_ERR);
          return;
        }
        b(this.e.h(), this.e.c().a.length());
        return;
      }
      this.j.a(UserState.NET_ERR);
      return;
    }
    this.j.a(UserState.NET_AVAIL);
  }
  
  public void a(UserStateController.OnCharacterOverSizeListener paramOnCharacterOverSizeListener)
  {
    this.g = paramOnCharacterOverSizeListener;
  }
  
  public void a(UserStateController.OnUserNewInfoListener paramOnUserNewInfoListener)
  {
    this.f = paramOnUserNewInfoListener;
  }
  
  public void a(Type paramType, boolean paramBoolean, Object paramObject)
  {
    if ((paramType == Type.USER_NEWINFO) && ((paramObject instanceof UserNewInfoMsg)))
    {
      paramType = (UserNewInfoMsg)paramObject;
      paramObject = this.f;
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
        this.j.a(UserState.ROOM_FULL);
        return;
      }
      if ((paramBoolean) && ((paramType.result == 0) || (paramType.result == 60009)) && (this.j.a() != UserState.ROOM_AVAILABLE))
      {
        if (this.j.a() != UserState.ROOM_FULL) {
          return;
        }
        this.j.a(UserState.ROOM_AVAILABLE);
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
      int m = localArrayList.size();
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
        localObject1 = this.d.n();
        if (paramBoolean) {
          k = 1;
        } else {
          k = 2;
        }
        if (m > k) {
          k = 1;
        } else {
          k = 0;
        }
        Object localObject2 = new StringBuilder();
        if (k != 0)
        {
          paramString = new StringBuilder();
          paramString.append("等");
          paramString.append(m);
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
        float f1 = this.d.q();
        paramString = new StringBuilder();
        paramString.append(WTConstants.g);
        paramString.append(paramList.toString());
        f1 = f1 - ((TextPaint)localObject1).measureText(paramString.toString()) - ((TextPaint)localObject1).measureText((String)localObject2);
        m = 0;
        int k = 3;
        while ((m < localArrayList.size()) && (k > 0))
        {
          paramString = a((String)localArrayList.get(m));
          if (f1 < this.d.r()) {
            break;
          }
          paramString = TextUtils.ellipsize(paramString, this.d.n(), f1, TextUtils.TruncateAt.END).toString();
          paramList.append(paramString);
          paramList.append(WTConstants.g);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString);
          localStringBuilder.append(WTConstants.g);
          f1 -= ((TextPaint)localObject1).measureText(localStringBuilder.toString());
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("[onPartChange] get partNickName: ");
            localStringBuilder.append(paramString);
            QLog.d("UserStateController", 2, localStringBuilder.toString());
          }
          m += 1;
          k -= 1;
        }
        paramString = paramList.toString();
        if (WTConstants.g.charValue() == paramList.toString().charAt(paramList.length() - 1)) {
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
      this.d.a(paramString);
    }
  }
  
  public void a(List<EditUserHistory> paramList)
  {
    this.e.a(paramList);
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("UserStateController", 4, "[onCommitStart]");
    }
    if (g())
    {
      if (this.j.a() == UserState.ALERT) {
        this.j.a(UserState.COMMIT_WHILE_ALERT);
      }
      if ((this.j.a() == UserState.LAST_EDIT) || (this.j.a() == UserState.LAST_SAVE)) {
        this.j.a(UserState.SAVING);
      }
    }
  }
  
  public void c()
  {
    this.b.unregisterReceiver(this.h);
    ((IQQWriteTogetherService)this.a.getRuntimeService(IQQWriteTogetherService.class, "")).removeObserver(this);
  }
  
  public void d()
  {
    this.e.f();
    this.j.a(UserState.LAST_EDIT);
  }
  
  public void e()
  {
    if (!this.i) {
      return;
    }
    this.i = false;
    if ((this.j.a() != UserState.NEW_USER_HINT) && (this.j.a() != UserState.INACTIVATED) && (this.j.a() != UserState.ROOM_AVAILABLE) && (this.j.a() != UserState.LAST_EDIT))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[onEditorActivated] trans from illegal state: ");
      localStringBuilder.append(this.j.a());
      e(localStringBuilder.toString());
      return;
    }
    this.j.a(UserState.ALERT);
  }
  
  public void f()
  {
    if (this.j.a() == UserState.INACTIVATED)
    {
      this.j.a(UserState.NEW_USER_HINT);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onNewUserHintShow] trans from illegal state: ");
    localStringBuilder.append(this.j.a());
    e(localStringBuilder.toString());
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131450314) {
      h();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.writetogether.client.UserStateController
 * JD-Core Version:    0.7.0.1
 */