package com.tencent.mobileqq.kandian.biz.common;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.biu.RIJBiuAndCommentMixDataManager;
import com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.IUiApiPlugin;
import com.tencent.mobileqq.kandian.biz.common.ipc.constants.IReadInJoyIPCModuleConst;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.glue.router.ReadInJoyChannelGuidingJumpUtils;
import com.tencent.mobileqq.kandian.glue.router.ReadInJoyDailyJumpToKDTabUtils;
import com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJBiuAndCommentAladdinUtils;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;

public class ReadInJoyIPCModule
  extends QIPCModule
  implements IReadInJoyIPCModuleConst
{
  private static volatile ReadInJoyIPCModule a;
  
  private ReadInJoyIPCModule(String paramString)
  {
    super(paramString);
  }
  
  public static ReadInJoyIPCModule a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new ReadInJoyIPCModule("ReadInJoyIPCModule");
        }
      }
      finally {}
    }
    return a;
  }
  
  private void a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getStringArrayList("uinList");
    if ((paramBundle != null) && (paramBundle.size() > 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[updateUserInfo] uinList: ");
      Iterator localIterator = paramBundle.iterator();
      while (localIterator.hasNext())
      {
        localStringBuilder.append((String)localIterator.next());
        localStringBuilder.append(", ");
      }
      QLog.i("ReadInJoyIPCModule", 1, localStringBuilder.toString());
      ReadInJoyUserInfoModule.a(paramBundle);
      return;
    }
    QLog.i("ReadInJoyIPCModule", 1, "[updateUserInfo] uin list is empty.");
  }
  
  private void b(Bundle paramBundle)
  {
    int i = paramBundle.getInt("key_native_channel_id", 0);
    int j = paramBundle.getInt("key_native_channel_change_order", 0);
    String str = paramBundle.getString("key_native_channel_name", "");
    int k = paramBundle.getInt("key_native_channel_type", 0);
    boolean bool = paramBundle.getBoolean("key_native_channel_is_push", false);
    int m = paramBundle.getInt("key_channel_source_from", -1);
    Object localObject = paramBundle.getString("key_channel_jump_scheme", "");
    paramBundle = new StringBuilder();
    paramBundle.append("[jumpToNativeChannel] native channel jump, channelID = ");
    paramBundle.append(i);
    paramBundle.append(", changeChannelOrder = ");
    paramBundle.append(j);
    paramBundle.append(", channelName = ");
    paramBundle.append(str);
    paramBundle.append(", channelType = ");
    paramBundle.append(k);
    paramBundle.append(", isPush = ");
    paramBundle.append(bool);
    paramBundle.append(", sourceFrom = ");
    paramBundle.append(m);
    paramBundle.append(", scheme = ");
    paramBundle.append((String)localObject);
    QLog.i("ReadInJoyIPCModule", 1, paramBundle.toString());
    if (j == 1) {
      ReadInJoyLogicEngine.a().b(i, m);
    }
    if (BaseActivity.sTopActivity == null) {
      paramBundle = BaseApplicationImpl.getContext();
    } else {
      paramBundle = BaseActivity.sTopActivity;
    }
    if (paramBundle == null)
    {
      QLog.i("ReadInJoyIPCModule", 1, "[jumpToNativeChannel], context is null.");
      return;
    }
    if (ReadInJoyDailyJumpToKDTabUtils.a(paramBundle, (String)localObject))
    {
      QLog.i("ReadInJoyIPCModule", 1, "[jumpToNativeChannel], jump to recommend channel, using floating window.");
      return;
    }
    if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).jumpToMiniGameHippyTab(paramBundle, (String)localObject, i))
    {
      QLog.i("ReadInJoyIPCModule", 1, "[jumpToNativeChannel], jump to mini game channel");
      return;
    }
    if (bool) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    if (ReadInJoyChannelGuidingJumpUtils.a((String)localObject, i))
    {
      ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchChannelActivity(paramBundle, i, str, k, 4);
      return;
    }
    localObject = ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).getJumpReadInJoyTabIntent(paramBundle, 0, i);
    if (!(paramBundle instanceof BaseActivity)) {
      ((Intent)localObject).setFlags(268435456);
    }
    paramBundle.startActivity((Intent)localObject);
  }
  
  protected void a(Bundle paramBundle, int paramInt)
  {
    ReadInJoyUserInfoModule.a(paramBundle.getLong("uin"), new ReadInJoyIPCModule.2(this, paramInt));
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    boolean bool2 = BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface;
    boolean bool1 = true;
    if (!bool2)
    {
      QLog.i("ReadInJoyIPCModule", 1, "[onCall], runtime is not QQAppInterface.");
      return null;
    }
    if ("action_native_channel_jump".equals(paramString))
    {
      if (paramBundle != null)
      {
        b(paramBundle);
        return null;
      }
    }
    else
    {
      String str;
      if ("action_viola_fragment_jump".equals(paramString))
      {
        if (paramBundle != null)
        {
          str = paramBundle.getString("key_viola_fragment_jump_url", "");
          paramInt = paramBundle.getInt("key_native_channel_id", 0);
          if (ReadInJoyChannelGuidingJumpUtils.a(Uri.parse(str).getQueryParameter("ispush"), paramInt))
          {
            try
            {
              if (str.contains("v_url_base64")) {
                paramString = JumpAction.c(Uri.parse(str).getQueryParameter("v_url_base64"));
              } else {
                paramString = URLDecoder.decode(Uri.parse(str).getQueryParameter("v_url"), "utf-8");
              }
            }
            catch (Exception paramString)
            {
              paramBundle = new StringBuilder();
              paramBundle.append("call viola page error = ");
              paramBundle.append(paramString.getMessage());
              QLog.e("ReadInJoyIPCModule", 1, paramBundle.toString());
              paramString = null;
            }
            if (BaseActivity.sTopActivity == null) {
              paramBundle = BaseApplicationImpl.getContext();
            } else {
              paramBundle = BaseActivity.sTopActivity;
            }
            ViolaAccessHelper.a(paramBundle, null, paramString, null);
            return null;
          }
          paramInt = paramBundle.getInt("key_native_channel_change_order", 0);
          if (BaseActivity.sTopActivity == null) {
            paramString = BaseApplicationImpl.getContext();
          } else {
            paramString = BaseActivity.sTopActivity;
          }
          if (paramInt != 1) {
            bool1 = false;
          }
          ReadInJoyChannelGuidingJumpUtils.a(paramString, str, bool1);
          return null;
        }
      }
      else
      {
        if ("action_update_biu_and_comment_switch_action".equals(paramString))
        {
          bool1 = RIJBiuAndCommentAladdinUtils.a();
          paramString = new Bundle();
          paramString.putBoolean("action_update_biu_and_comment_switch", bool1);
          callbackResult(paramInt, EIPCResult.createResult(0, paramString));
          return null;
        }
        if ("action_update_biu_and_comment_request_action".equals(paramString))
        {
          paramString = (Intent)paramBundle.getParcelable("action_update_biu_and_comment_request");
          if (paramString == null) {
            return null;
          }
          paramBundle = new RIJBiuAndCommentMixDataManager();
          str = paramString.getStringExtra("arg_callback");
          ((IUiApiPlugin)QRoute.api(IUiApiPlugin.class)).handleInfoAndRequestForWeb(paramString, paramBundle, str, new ReadInJoyIPCModule.1(this, paramInt, paramBundle));
          return null;
        }
        if ("action_get_user_info_action".equals(paramString))
        {
          a(paramBundle, paramInt);
          return null;
        }
        if ("action_get_app_type_action".equals(paramString))
        {
          paramString = new Bundle();
          paramString.putInt("action_get_app_type", ReadinjoyReportUtils.c());
          callbackResult(paramInt, EIPCResult.createResult(0, paramString));
          return null;
        }
        if ("action_update_user_info".equals(paramString)) {
          a(paramBundle);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyIPCModule
 * JD-Core Version:    0.7.0.1
 */