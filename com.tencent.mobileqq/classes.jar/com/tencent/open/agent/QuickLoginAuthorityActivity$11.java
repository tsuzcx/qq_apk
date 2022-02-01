package com.tencent.open.agent;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.appcommon.OpensdkBusinessObserver;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.protofile.getappinfo.GetAppInfoProto.MsgIconsurl;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class QuickLoginAuthorityActivity$11
  implements OpensdkBusinessObserver
{
  QuickLoginAuthorityActivity$11(QuickLoginAuthorityActivity paramQuickLoginAuthorityActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getAppInfo onReceive isSuccess=");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", bundle=");
    ((StringBuilder)localObject).append(paramBundle);
    QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, ((StringBuilder)localObject).toString());
    if (this.a.isFinishing())
    {
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "getAppInfo onReceive return for finish");
      return;
    }
    localObject = paramBundle.getString("ssoAccount");
    if (!this.a.b.equals(localObject))
    {
      QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, "getAppInfo onReceive return for account not equals");
      return;
    }
    if (paramBoolean)
    {
      localObject = new GetAppInfoProto.GetAppinfoResponse();
      for (;;)
      {
        try
        {
          paramBundle = paramBundle.getByteArray("data");
          if (paramBundle != null)
          {
            ((GetAppInfoProto.GetAppinfoResponse)localObject).mergeFrom(paramBundle);
            if ((((GetAppInfoProto.GetAppinfoResponse)localObject).has()) && (((GetAppInfoProto.GetAppinfoResponse)localObject).ret.get() == 0))
            {
              if ((((GetAppInfoProto.GetAppinfoResponse)localObject).appName != null) && (!TextUtils.isEmpty(((GetAppInfoProto.GetAppinfoResponse)localObject).appName.get())))
              {
                paramBundle = ((GetAppInfoProto.GetAppinfoResponse)localObject).appName.get();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("getAppInfo onReceive return appName:");
                localStringBuilder.append(paramBundle);
                QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, localStringBuilder.toString());
                QuickLoginAuthorityActivity.a(this.a, true);
                this.a.q.a(paramBundle, null);
              }
              if ((((GetAppInfoProto.GetAppinfoResponse)localObject).iconsURL != null) && (((GetAppInfoProto.GetAppinfoResponse)localObject).iconsURL.has()))
              {
                paramInt = 0;
                k = 0;
                i = 0;
                if (paramInt < ((GetAppInfoProto.GetAppinfoResponse)localObject).iconsURL.get().size()) {
                  paramBundle = (GetAppInfoProto.MsgIconsurl)((GetAppInfoProto.GetAppinfoResponse)localObject).iconsURL.get(paramInt);
                }
              }
            }
          }
        }
        catch (Exception paramBundle)
        {
          int k;
          int i;
          int j;
          int m;
          paramBundle.printStackTrace();
        }
        try
        {
          j = Integer.parseInt(paramBundle.size.get());
        }
        catch (NumberFormatException paramBundle)
        {
          continue;
        }
        j = 0;
        if (j < 100)
        {
          m = k;
          if (j > k)
          {
            i = paramInt;
            m = j;
          }
          paramInt += 1;
          k = m;
          continue;
          paramInt = i;
        }
        else
        {
          paramBundle = (GetAppInfoProto.MsgIconsurl)((GetAppInfoProto.GetAppinfoResponse)localObject).iconsURL.get(paramInt);
          if (paramBundle == null) {
            break label469;
          }
          paramBundle = paramBundle.url.get();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getAppInfo onReceive return iconimgUrl:");
          ((StringBuilder)localObject).append(paramBundle);
          QLog.i("Q.quicklogin.QuickLoginAuthorityActivity", 1, ((StringBuilder)localObject).toString());
          if (TextUtils.isEmpty(paramBundle)) {
            break label469;
          }
          QuickLoginAuthorityActivity.b(this.a, true);
          localObject = Message.obtain();
          ((Message)localObject).what = 1001;
          ((Message)localObject).obj = paramBundle;
          this.a.s.sendMessage((Message)localObject);
          return;
        }
      }
    }
    label469:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.QuickLoginAuthorityActivity.11
 * JD-Core Version:    0.7.0.1
 */