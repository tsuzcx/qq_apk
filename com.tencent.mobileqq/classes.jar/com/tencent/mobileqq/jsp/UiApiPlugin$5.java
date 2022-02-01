package com.tencent.mobileqq.jsp;

import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.utils.TroopInfoUIUtil;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import mqq.observer.BusinessObserver;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

class UiApiPlugin$5
  implements BusinessObserver
{
  UiApiPlugin$5(UiApiPlugin paramUiApiPlugin) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      Object localObject = paramBundle.getByteArray("data");
      paramBundle.getString("openId");
      if (localObject != null)
      {
        paramBundle = new oidb_sso.OIDBSSOPkg();
        try
        {
          paramBundle = (oidb_sso.OIDBSSOPkg)paramBundle.mergeFrom((byte[])localObject);
          paramInt = paramBundle.uint32_result.get();
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("handleOidb0x716_48Rsp, resultCode:");
            ((StringBuilder)localObject).append(paramInt);
            QLog.d("UiApiPlugin.troopTAG_GET_UIN_BY_OPEN_ID", 2, ((StringBuilder)localObject).toString());
          }
          localObject = paramBundle.bytes_bodybuffer.get().toByteArray();
          if (paramInt == 0)
          {
            paramBundle = new byte[4];
            System.arraycopy(localObject, 0, paramBundle, 0, 4);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(ByteBuffer.wrap(paramBundle).getInt());
            ((StringBuilder)localObject).append("");
            paramBundle = TroopInfoUIUtil.a(String.valueOf(((StringBuilder)localObject).toString()), "", 32);
            TroopUtils.a(this.a.a(), paramBundle, -1);
            return;
          }
        }
        catch (Exception paramBundle)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("pkg.mergeFrom:");
            ((StringBuilder)localObject).append(paramBundle.toString());
            QLog.e("UiApiPlugin.troopTAG_GET_UIN_BY_OPEN_ID", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.5
 * JD-Core Version:    0.7.0.1
 */