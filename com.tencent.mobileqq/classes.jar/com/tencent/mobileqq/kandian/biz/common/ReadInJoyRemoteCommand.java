package com.tencent.mobileqq.kandian.biz.common;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.biz.follow.PublicAccountUnfollowTask;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.repo.follow.FollowListInfoModule;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class ReadInJoyRemoteCommand
  extends RemoteCommand
{
  private QQAppInterface a;
  
  public void a()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if ((localPluginCommunicationHandler != null) && (localPluginCommunicationHandler.containsCmd("com.tencent.qqreadinjoy.readinjoyremotecommand"))) {
      localPluginCommunicationHandler.unregister("com.tencent.qqreadinjoy.readinjoyremotecommand");
    }
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    boolean bool2 = false;
    int i = paramBundle.getInt("param_data_type", 0);
    paramOnInvokeFinishLinstener = new Bundle();
    Object localObject;
    switch (i)
    {
    default: 
      return paramOnInvokeFinishLinstener;
    case 8: 
      paramBundle = paramBundle.getString("param_uin");
      localObject = this.a;
      new PublicAccountUnfollowTask((QQAppInterface)localObject, paramBundle, ((QQAppInterface)localObject).getApp().getApplicationContext()).a();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handle remote unfollow public account request ! puin : ");
      ((StringBuilder)localObject).append(paramBundle);
      QLog.e("ReadInJoyRemoteCommand", 2, ((StringBuilder)localObject).toString());
      paramOnInvokeFinishLinstener.putBoolean("result_key", true);
      return paramOnInvokeFinishLinstener;
    case 7: 
      paramOnInvokeFinishLinstener.putString("result_key", RIJAppSetting.a());
      return paramOnInvokeFinishLinstener;
    case 6: 
      paramBundle = ReadInJoyHelper.f((QQAppInterface)RIJQQAppInterfaceUtil.e());
      boolean bool1 = bool2;
      if (paramBundle != null)
      {
        bool1 = bool2;
        if (paramBundle.f == 0) {
          bool1 = true;
        }
      }
      paramOnInvokeFinishLinstener.putString("result_key", Boolean.toString(bool1));
      return paramOnInvokeFinishLinstener;
    case 5: 
      paramBundle = paramBundle.getString("param_uin");
      if (!TextUtils.isEmpty(paramBundle))
      {
        paramOnInvokeFinishLinstener.putString("result_key", Boolean.toString(FollowListInfoModule.a(paramBundle, null)));
        return paramOnInvokeFinishLinstener;
      }
      break;
    case 4: 
      paramBundle = paramBundle.getString("param_uin");
      localObject = (FriendsManager)this.a.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((localObject != null) && (!TextUtils.isEmpty(paramBundle)))
      {
        paramBundle = ((FriendsManager)localObject).f(paramBundle);
        if (paramBundle != null)
        {
          paramOnInvokeFinishLinstener.putString("result_key", Short.toString(paramBundle.shGender));
          return paramOnInvokeFinishLinstener;
        }
      }
      break;
    case 3: 
      paramBundle = paramBundle.getString("param_uin");
      paramOnInvokeFinishLinstener.putParcelable("result_key", this.a.getFaceBitmap(paramBundle, true));
      return paramOnInvokeFinishLinstener;
    case 2: 
      paramBundle = paramBundle.getString("param_uin");
      ContactUtils.f(this.a, paramBundle);
      paramOnInvokeFinishLinstener.putString("result_key", ContactUtils.d(this.a, paramBundle));
      return paramOnInvokeFinishLinstener;
    case 1: 
      localObject = paramBundle.getString("param_sp_key");
      paramBundle = paramBundle.getString("param_sp_value_type");
      SharedPreferences localSharedPreferences = ReadInJoyHelper.a((QQAppInterface)RIJQQAppInterfaceUtil.e(), 1);
      if (localSharedPreferences != null) {
        try
        {
          if (paramBundle.equals("long"))
          {
            paramOnInvokeFinishLinstener.putString("result_key", Long.toString(localSharedPreferences.getLong((String)localObject, 0L)));
            return paramOnInvokeFinishLinstener;
          }
          if (paramBundle.equals("boolean"))
          {
            paramOnInvokeFinishLinstener.putString("result_key", Boolean.toString(localSharedPreferences.getBoolean((String)localObject, false)));
            return paramOnInvokeFinishLinstener;
          }
          if (paramBundle.equals("int"))
          {
            paramOnInvokeFinishLinstener.putString("result_key", Integer.toString(localSharedPreferences.getInt((String)localObject, 0)));
            return paramOnInvokeFinishLinstener;
          }
          if (paramBundle.equals("String"))
          {
            paramOnInvokeFinishLinstener.putString("result_key", localSharedPreferences.getString((String)localObject, null));
            return paramOnInvokeFinishLinstener;
          }
        }
        catch (ClassCastException paramBundle)
        {
          paramBundle.printStackTrace();
        }
      }
      break;
    }
    return paramOnInvokeFinishLinstener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyRemoteCommand
 * JD-Core Version:    0.7.0.1
 */