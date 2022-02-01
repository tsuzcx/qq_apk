package com.tencent.mobileqq.friend.handler.recevier;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.friend.utils.AddFriendUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.AddFriendResp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.friend.AddContactVerifyInfo.AddFriendVerifyInfo;
import trpc.mizarproto.passthrough.FunctionLockMsg.FunctionLockBeatRsp;
import trpc.mizarproto.passthrough.FunctionLockMsg.FunctionLockBtn;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/friend/handler/recevier/FriendAddReceiver;", "Lcom/tencent/mobileqq/friend/handler/recevier/BaseProtocolReceiver;", "Lcom/tencent/mobileqq/friend/handler/FriendHandler;", "appRuntime", "Lcom/tencent/common/app/AppInterface;", "handler", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/friend/handler/FriendHandler;)V", "dealFunctionLockMsg", "", "data", "Landroid/os/Bundle;", "functionLockBeatRsp", "Ltrpc/mizarproto/passthrough/FunctionLockMsg$FunctionLockBeatRsp;", "getCmd", "", "handleAddFriend", "resp", "Lfriendlist/AddFriendResp;", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "receive", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "", "Companion", "IMCore_release"}, k=1, mv={1, 1, 16})
public final class FriendAddReceiver
  extends BaseProtocolReceiver<FriendHandler>
{
  public static final FriendAddReceiver.Companion a = new FriendAddReceiver.Companion(null);
  
  public FriendAddReceiver(@NotNull AppInterface paramAppInterface, @NotNull FriendHandler paramFriendHandler)
  {
    super(paramAppInterface, (BusinessHandler)paramFriendHandler);
  }
  
  @NotNull
  public String a()
  {
    return "friendlist.addFriend";
  }
  
  public final void a(@NotNull Bundle paramBundle, @NotNull FunctionLockMsg.FunctionLockBeatRsp paramFunctionLockBeatRsp)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "data");
    Intrinsics.checkParameterIsNotNull(paramFunctionLockBeatRsp, "functionLockBeatRsp");
    paramBundle.putString("error_tips_wording", paramFunctionLockBeatRsp.wording.get());
    paramFunctionLockBeatRsp = paramFunctionLockBeatRsp.btns.get().iterator();
    while (paramFunctionLockBeatRsp.hasNext())
    {
      FunctionLockMsg.FunctionLockBtn localFunctionLockBtn = (FunctionLockMsg.FunctionLockBtn)paramFunctionLockBeatRsp.next();
      if (localFunctionLockBtn != null) {
        if (localFunctionLockBtn.jump_type.get() == 1)
        {
          paramBundle.putString("error_tips_h5_url", localFunctionLockBtn.url.get());
          paramBundle.putString("error_tips_jump_btn_wording", localFunctionLockBtn.woding.get());
        }
        else if (localFunctionLockBtn.jump_type.get() == 2)
        {
          paramBundle.putString("error_tips_mini_app_url", localFunctionLockBtn.url.get());
          paramBundle.putString("error_tips_jump_btn_wording", localFunctionLockBtn.woding.get());
        }
        else if (localFunctionLockBtn.jump_type.get() == 0)
        {
          paramBundle.putString("error_tips_cancel_wording", localFunctionLockBtn.woding.get());
        }
      }
    }
  }
  
  public void a(@NotNull ToServiceMsg paramToServiceMsg, @NotNull FromServiceMsg paramFromServiceMsg, @Nullable Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramToServiceMsg, "req");
    Intrinsics.checkParameterIsNotNull(paramFromServiceMsg, "res");
    paramFromServiceMsg = paramFromServiceMsg.getServiceCmd();
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.hashCode() == 843392877) && (paramFromServiceMsg.equals("friendlist.addFriend")))
    {
      if (QLog.isColorLevel()) {
        QLog.i("IMCore.friend.FriendAddReceiver", 2, "receive and handle cmd FriendCMD.CMD_ADD");
      }
      a((AddFriendResp)paramObject, paramToServiceMsg);
      return;
    }
    QLog.e("IMCore.friend.FriendAddReceiver", 1, "receive cmd error: can not handle");
  }
  
  public final void a(@Nullable AddFriendResp paramAddFriendResp, @NotNull ToServiceMsg paramToServiceMsg)
  {
    Intrinsics.checkParameterIsNotNull(paramToServiceMsg, "req");
    Bundle localBundle = new Bundle();
    localBundle.putAll(paramToServiceMsg.extraData);
    boolean bool2 = false;
    if (paramAddFriendResp == null)
    {
      ((FriendHandler)c()).notifyUI(11, false, localBundle);
      QLog.d("IMCore.friend.FriendAddReceiver", 1, "handleAddFriend, resp or req is null");
      return;
    }
    localBundle.putInt("resultCode", paramAddFriendResp.result);
    localBundle.putString("ErrorString", paramAddFriendResp.ErrorString);
    localBundle.putInt("error_code", paramAddFriendResp.errorCode);
    Object localObject;
    if (paramAddFriendResp.verify != null)
    {
      localObject = new AddContactVerifyInfo.AddFriendVerifyInfo();
      try
      {
        ((AddContactVerifyInfo.AddFriendVerifyInfo)localObject).mergeFrom(paramAddFriendResp.verify);
      }
      catch (Exception localException1)
      {
        QLog.e("IMCore.friend.FriendAddReceiver", 1, "handleAddFriend, AddFriendVerifyInfo mergeFrom failed: ", (Throwable)localException1);
      }
      if (paramAddFriendResp.errorCode == 168)
      {
        localObject = new FunctionLockMsg.FunctionLockBeatRsp();
        try
        {
          ((FunctionLockMsg.FunctionLockBeatRsp)localObject).mergeFrom(paramAddFriendResp.verify);
        }
        catch (Exception localException2)
        {
          QLog.e("IMCore.friend.FriendAddReceiver", 1, "handleAddFriend, FunctionLockBeatRsp mergeFrom failed: ", (Throwable)localException2);
        }
        a(localBundle, (FunctionLockMsg.FunctionLockBeatRsp)localObject);
      }
      else if (((AddContactVerifyInfo.AddFriendVerifyInfo)localObject).str_url.has())
      {
        String str = ((AddContactVerifyInfo.AddFriendVerifyInfo)localObject).str_url.get();
        if (!TextUtils.isEmpty((CharSequence)str))
        {
          localBundle.putString("security_check_url", str);
          localBundle.putString("security_check_buffer", ((AddContactVerifyInfo.AddFriendVerifyInfo)localObject).str_verify_info.get());
          ((FriendHandler)c()).notifyUI(117, true, localBundle);
          if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.FriendAddReceiver", 2, "handleAddFriend, needSecCheck");
          }
          return;
        }
      }
    }
    if (paramAddFriendResp.result == 0)
    {
      localObject = paramToServiceMsg.extraData;
      boolean bool3 = ((Bundle)localObject).getBoolean("auto_send", false);
      int j = ((Bundle)localObject).getInt("source_id");
      boolean bool4 = ((Bundle)localObject).getBoolean("contact_bothway");
      int i;
      if ((bool3) && (AddFriendUtil.a(paramAddFriendResp.adduinsetting, j, bool4))) {
        i = 1;
      } else {
        i = 0;
      }
      localBundle.putByteArray("sig", paramAddFriendResp.sig);
      localBundle.putString("result_uin", String.valueOf(paramAddFriendResp.adduin));
      boolean bool1 = bool2;
      if (bool3)
      {
        bool1 = bool2;
        if (i != 0) {
          bool1 = true;
        }
      }
      localBundle.putBoolean("addDirect", bool1);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("$handleAddFriend|autoSend=");
        ((StringBuilder)localObject).append(bool3);
        ((StringBuilder)localObject).append(",uin");
        ((StringBuilder)localObject).append(paramAddFriendResp.adduin);
        ((StringBuilder)localObject).append(",sourceId=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(",beBothWay=");
        ((StringBuilder)localObject).append(bool4);
        ((StringBuilder)localObject).append(",successDirectly=");
        ((StringBuilder)localObject).append(AddFriendUtil.a(paramAddFriendResp.adduinsetting, j, bool4));
        QLog.d("IMCore.friend.FriendAddReceiver", 2, ((StringBuilder)localObject).toString());
      }
      localObject = ((FriendHandler)c()).d().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((BaseFriendProcessor)((Iterator)localObject).next()).onAddFriendSuccess(paramAddFriendResp, paramToServiceMsg);
      }
      ((FriendHandler)c()).notifyUI(11, true, localBundle);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("ErrorString:");
      paramToServiceMsg.append(paramAddFriendResp.ErrorString);
      paramToServiceMsg.append(",resultCode:");
      paramToServiceMsg.append(paramAddFriendResp.result);
      paramToServiceMsg.append(",errorCode:");
      paramToServiceMsg.append(paramAddFriendResp.errorCode);
      QLog.d("IMCore.friend.FriendAddReceiver", 2, paramToServiceMsg.toString());
    }
    ((FriendHandler)c()).notifyUI(11, true, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.friend.handler.recevier.FriendAddReceiver
 * JD-Core Version:    0.7.0.1
 */