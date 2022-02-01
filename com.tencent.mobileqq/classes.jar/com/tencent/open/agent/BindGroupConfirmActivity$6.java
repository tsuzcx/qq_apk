package com.tencent.open.agent;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.appcommon.OpensdkBusinessObserver;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;

class BindGroupConfirmActivity$6
  implements OpensdkBusinessObserver
{
  BindGroupConfirmActivity$6(BindGroupConfirmActivity paramBindGroupConfirmActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = paramBundle.getString("ssoAccount");
    if (!this.a.app.getCurrentAccountUin().equals(localObject)) {
      return;
    }
    this.a.B.removeCallbacks(this.a.C);
    if (paramBoolean)
    {
      localObject = new GetAppInfoProto.GetAppinfoResponse();
      try
      {
        paramBundle = paramBundle.getByteArray("data");
        if (paramBundle != null)
        {
          ((GetAppInfoProto.GetAppinfoResponse)localObject).mergeFrom(paramBundle);
          if ((((GetAppInfoProto.GetAppinfoResponse)localObject).has()) && (((GetAppInfoProto.GetAppinfoResponse)localObject).ret.get() == 0))
          {
            paramBundle = this.a.B.obtainMessage();
            paramBundle.what = 3;
            paramBundle.obj = localObject;
            this.a.B.sendMessage(paramBundle);
            return;
          }
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BindGroupConfirmActivity.6
 * JD-Core Version:    0.7.0.1
 */