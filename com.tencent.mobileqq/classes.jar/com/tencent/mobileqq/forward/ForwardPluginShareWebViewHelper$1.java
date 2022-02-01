package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.RspBody;
import tencent.im.oidb.cmd0xdc2.oidb_cmd0xdc2.BatchSendRsp;

final class ForwardPluginShareWebViewHelper$1
  extends ProtoUtils.TroopProtocolObserver
{
  ForwardPluginShareWebViewHelper$1(QQProgressDialog paramQQProgressDialog, Activity paramActivity, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, String paramString) {}
  
  public boolean onError(int paramInt, String paramString, Bundle paramBundle)
  {
    this.a.dismiss();
    QQToast.makeText(BaseApplicationImpl.getContext(), 2131916544, 0).show();
    this.b.finish();
    QLog.e("ForwardPluginShareWebViewHelper", 1, new Object[] { "onError msg =", paramString });
    return true;
  }
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    this.a.dismiss();
    if (paramInt == 0)
    {
      List localList = ForwardUtils.b(paramArrayOfByte);
      paramBundle = "";
      paramArrayOfByte = paramBundle;
      if (localList != null)
      {
        paramArrayOfByte = paramBundle;
        if (localList.size() > 0)
        {
          paramArrayOfByte = (oidb_cmd0xdc2.BatchSendRsp)localList.get(0);
          if (paramArrayOfByte.err_code.get() == 0)
          {
            i = 1;
            paramArrayOfByte = paramBundle;
            break label89;
          }
          paramArrayOfByte = paramArrayOfByte.rsp_body.wording.get();
        }
      }
    }
    else
    {
      paramArrayOfByte = "sso error";
    }
    int i = 0;
    label89:
    if (i != 0)
    {
      ChatActivityFacade.b(this.c, this.b, this.d, this.e);
      paramBundle = BaseApplicationImpl.getContext().getString(2131889669);
    }
    else
    {
      paramBundle = new StringBuilder();
      paramBundle.append(BaseApplicationImpl.getContext().getString(2131916544));
      paramBundle.append(":");
      paramBundle.append(paramArrayOfByte);
      paramBundle = paramBundle.toString();
      QQToast.makeText(BaseApplicationImpl.getContext(), paramBundle, 0).show();
    }
    ThreadManager.getUIHandler().postDelayed(new ForwardPluginShareWebViewHelper.1.1(this, paramBundle), 300L);
    this.b.finish();
    QLog.d("ForwardPluginShareWebViewHelper", 1, new Object[] { "webview send oidb_cmd0xdc2 errorCode=", Integer.valueOf(paramInt), ",errorMsg = ", paramArrayOfByte });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardPluginShareWebViewHelper.1
 * JD-Core Version:    0.7.0.1
 */