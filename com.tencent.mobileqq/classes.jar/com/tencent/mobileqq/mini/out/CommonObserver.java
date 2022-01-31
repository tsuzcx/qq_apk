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
    paramBundle = (FromServiceMsg)paramBundle.getParcelable("rsp");
    if (paramInt == 1) {
      if (!paramBoolean) {
        break label94;
      }
    }
    for (;;)
    {
      try
      {
        paramBundle = (LBSShare.LocationResp)new LBSShare.LocationResp().mergeFrom(paramBundle.getWupBuffer());
        onGetPoiList(paramBoolean, paramBundle);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      if (paramInt == 2)
      {
        if (paramBoolean) {}
        for (paramBundle = new String(paramBundle.getWupBuffer());; paramBundle = null)
        {
          onGetStreetUrl(paramBoolean, paramBundle);
          return;
        }
        label94:
        paramBundle = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.CommonObserver
 * JD-Core Version:    0.7.0.1
 */