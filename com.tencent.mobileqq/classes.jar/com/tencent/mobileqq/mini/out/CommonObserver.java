package com.tencent.mobileqq.mini.out;

import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.proto.lbsshare.LBSShare.LocationResp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.observer.BusinessObserver;

public class CommonObserver
  implements BusinessObserver
{
  public static final String KEY_REQ = "req";
  public static final String KEY_RSP = "rsp";
  
  public void onGetPoiList(boolean paramBoolean, LBSShare.LocationResp paramLocationResp) {}
  
  public void onGetStreetUrl(boolean paramBoolean, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    ToServiceMsg localToServiceMsg = (ToServiceMsg)paramBundle.getParcelable("req");
    FromServiceMsg localFromServiceMsg = (FromServiceMsg)paramBundle.getParcelable("rsp");
    localToServiceMsg = null;
    paramBundle = null;
    if (paramInt == 1)
    {
      if (paramBoolean) {}
      try
      {
        paramBundle = (LBSShare.LocationResp)new LBSShare.LocationResp().mergeFrom(localFromServiceMsg.getWupBuffer());
        onGetPoiList(paramBoolean, paramBundle);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
    }
    if (paramInt == 2)
    {
      paramBundle = localToServiceMsg;
      if (paramBoolean) {
        paramBundle = new String(localFromServiceMsg.getWupBuffer());
      }
      onGetStreetUrl(paramBoolean, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.CommonObserver
 * JD-Core Version:    0.7.0.1
 */