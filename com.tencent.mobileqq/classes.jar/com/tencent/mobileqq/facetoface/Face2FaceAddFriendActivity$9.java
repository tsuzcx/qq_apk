package com.tencent.mobileqq.facetoface;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class Face2FaceAddFriendActivity$9
  extends FriendObserver
{
  DialogInterface.OnClickListener a = new Face2FaceAddFriendActivity.9.1(this);
  DialogInterface.OnClickListener b = new Face2FaceAddFriendActivity.9.2(this);
  DialogInterface.OnDismissListener c = new Face2FaceAddFriendActivity.9.3(this);
  private QQCustomDialog e;
  private int f;
  
  Face2FaceAddFriendActivity$9(Face2FaceAddFriendActivity paramFace2FaceAddFriendActivity) {}
  
  private void a()
  {
    if ((this.e != null) && (this.f != 0))
    {
      Object localObject1 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertTitle", 147, this.f);
      if (localObject1 != null) {
        localObject1 = ((Bundle)localObject1).getString("AlertTitle");
      } else {
        localObject1 = null;
      }
      Object localObject2 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertText", 147, this.f);
      Object localObject4;
      if (localObject2 != null) {
        localObject4 = ((Bundle)localObject2).getString("AlertText");
      } else {
        localObject4 = null;
      }
      localObject2 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertLeftBtnText", 147, this.f);
      if (localObject2 != null) {
        localObject2 = ((Bundle)localObject2).getString("AlertLeftBtnText");
      } else {
        localObject2 = null;
      }
      Object localObject3 = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "AlertRightBtnText", 147, this.f);
      if (localObject3 != null) {
        localObject3 = ((Bundle)localObject3).getString("AlertRightBtnText");
      } else {
        localObject3 = null;
      }
      Object localObject5 = localObject1;
      int i;
      if (localObject1 == null)
      {
        localObject1 = this.d;
        if (this.f == 1) {
          i = 2131916139;
        } else {
          i = 2131916143;
        }
        localObject5 = ((Face2FaceAddFriendActivity)localObject1).getString(i);
      }
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        i = this.f;
        if (i == 1)
        {
          localObject1 = this.d.getString(2131916140);
        }
        else if (i == 2)
        {
          localObject1 = this.d.getString(2131916138);
        }
        else if (i == 3)
        {
          localObject1 = this.d.getString(2131916142);
        }
        else
        {
          localObject1 = localObject4;
          if (i == 4) {
            localObject1 = this.d.getString(2131916141);
          }
        }
      }
      if (localObject2 == null)
      {
        if (this.f == 1)
        {
          this.a = null;
          localObject4 = localObject2;
        }
        else
        {
          localObject4 = this.d.getString(2131916135);
        }
      }
      else
      {
        localObject4 = localObject2;
        if (TextUtils.isEmpty(((String)localObject2).trim()))
        {
          this.a = null;
          localObject4 = localObject2;
        }
      }
      if (localObject3 == null)
      {
        if (this.f == 1) {
          localObject2 = this.d.getString(2131916134);
        } else {
          localObject2 = this.d.getString(2131916133);
        }
      }
      else
      {
        localObject2 = localObject3;
        if (TextUtils.isEmpty(((String)localObject3).trim()))
        {
          this.b = null;
          localObject2 = localObject3;
        }
      }
      this.e.setTitle((String)localObject5);
      this.e.setMessage((CharSequence)localObject1);
      this.e.setNegativeButton((String)localObject4, this.a);
      this.e.setPositiveButton((String)localObject2, this.b);
      if ((this.a == null) || (this.b == null)) {
        this.e.findViewById(2131429769).setVisibility(8);
      }
    }
  }
  
  protected void onGetAutoInfo(boolean paramBoolean, String paramString1, String paramString2, int paramInt)
  {
    if (!TextUtils.equals(this.d.U, paramString1)) {
      return;
    }
    if (paramBoolean) {
      if (!this.d.W.containsKey(paramString1)) {
        this.d.Q.setText(paramString2);
      }
    }
    try
    {
      this.d.Q.setSelection(this.d.Q.getText().length());
    }
    catch (IndexOutOfBoundsException paramString2)
    {
      label72:
      Face2FaceAddFriendActivity localFace2FaceAddFriendActivity;
      break label72;
    }
    if (QLog.isColorLevel()) {
      QLog.d(Face2FaceAddFriendActivity.a, 2, "onGetAutoInfo | IndexOutOfBoundsException");
    }
    if (!this.d.X.containsKey(paramString1))
    {
      paramString2 = this.d;
      paramString2.V = paramInt;
      paramString2 = paramString2.R;
      localFace2FaceAddFriendActivity = this.d;
      paramString2.setText(localFace2FaceAddFriendActivity.a(localFace2FaceAddFriendActivity.V));
      this.d.X.put(paramString1, Integer.valueOf(this.d.V));
      return;
      if (!this.d.X.containsKey(paramString1))
      {
        paramString2 = this.d;
        paramString2.V = 0;
        paramString2 = paramString2.R;
        localFace2FaceAddFriendActivity = this.d;
        paramString2.setText(localFace2FaceAddFriendActivity.a(localFace2FaceAddFriendActivity.V));
        this.d.X.put(paramString1, Integer.valueOf(this.d.V));
      }
    }
  }
  
  protected void onQueryUinSafetyFlag(boolean paramBoolean, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      String str = Face2FaceAddFriendActivity.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onQueryUinSafetyFlag isSuccess=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("status=");
      localStringBuilder.append(paramInt);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (paramInt != 0))
    {
      this.f = paramInt;
      AntiFraudConfigFileUtil.a().a(this.d.app, "SecWarningCfg");
      try
      {
        this.e = DialogUtil.a(this.d, 230, "", "", this.a, this.b);
        a();
        this.e.setOnDismissListener(this.c);
        this.e.show();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
    }
    Face2FaceAddFriendActivity.h(this.d);
  }
  
  protected void onUpdateAddFriend(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString, Bundle paramBundle)
  {
    super.onUpdateAddFriend(paramBoolean1, paramBoolean2, paramBoolean3, paramString, paramBundle);
    int i = paramBundle.getInt("friend_setting");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = Face2FaceAddFriendActivity.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateAddFriend请求加好友回调 isSuccess= ");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append("addSuccess=");
      localStringBuilder.append(paramBoolean2);
      localStringBuilder.append("reqestUin=");
      localStringBuilder.append(paramString);
      localStringBuilder.append("friendSetting");
      localStringBuilder.append(i);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if (paramBoolean2)
    {
      paramString = paramBundle.getString("remark");
      paramBundle = paramBundle.getString("uin");
      this.d.W.put(paramBundle, paramString);
      if (i == 0)
      {
        paramString = Face2FaceAddFriendActivity.a(this.d).obtainMessage();
        paramString.what = 2;
        paramString.arg1 = 2;
        paramString.obj = this.d.U;
        Face2FaceAddFriendActivity.a(this.d).sendMessage(paramString);
        paramString = this.d;
        Face2FaceAddFriendActivity.a(paramString, 2, paramString.U);
        return;
      }
      paramString = Face2FaceAddFriendActivity.a(this.d).obtainMessage();
      paramString.what = 2;
      paramString.arg1 = 4;
      paramString.obj = this.d.U;
      Face2FaceAddFriendActivity.a(this.d).sendMessage(paramString);
      paramString = this.d;
      Face2FaceAddFriendActivity.a(paramString, 4, paramString.U);
      return;
    }
    paramBundle = paramBundle.getString("ErrorString");
    if (QLog.isColorLevel())
    {
      paramString = Face2FaceAddFriendActivity.a;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("add friend response error and ErroString = ");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.d(paramString, 2, ((StringBuilder)localObject).toString());
    }
    paramString = paramBundle;
    if (TextUtils.isEmpty(paramBundle)) {
      paramString = this.d.getString(2131889122);
    }
    QQToast.makeText(this.d, 0, paramString, 0).show(this.d.getTitleBarHeight());
  }
  
  protected void onUpdateAddFriendSetting(boolean paramBoolean, Bundle paramBundle)
  {
    String str1 = paramBundle.getString("uin");
    int i = paramBundle.getInt("friend_setting");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      str2 = Face2FaceAddFriendActivity.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateAddFriendSetting请求加好友设置 isSuccess= ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("friendSetting=");
      localStringBuilder.append(i);
      QLog.d(str2, 2, localStringBuilder.toString());
    }
    String str2 = this.d.Q.getText().toString();
    byte b1 = (byte)this.d.V;
    if (TextUtils.isEmpty(this.d.U)) {
      return;
    }
    ((IFriendHandlerService)this.d.app.getRuntimeService(IFriendHandlerService.class)).requestAddFriend(this.d.U, null, i, b1, "", 3021, 0, true, null, true, str2, "");
    if (QLog.isColorLevel())
    {
      str2 = Face2FaceAddFriendActivity.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("请求加好友");
      localStringBuilder.append(this.d.U);
      QLog.d(str2, 2, localStringBuilder.toString());
    }
    if (!this.d.U.equals(str1)) {
      return;
    }
    if (paramBoolean)
    {
      paramBundle.getStringArrayList("user_question");
      paramBundle.getBoolean("contact_bothway");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity.9
 * JD-Core Version:    0.7.0.1
 */