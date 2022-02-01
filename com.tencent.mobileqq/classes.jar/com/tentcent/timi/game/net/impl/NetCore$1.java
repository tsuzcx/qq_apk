package com.tentcent.timi.game.net.impl;

import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.timi.game.net.api.RequestListener;
import com.tencent.timi.game.utils.Logger;
import mqq.observer.BusinessObserver;

final class NetCore$1
  implements BusinessObserver
{
  NetCore$1(RequestListener paramRequestListener, Class paramClass) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("onReceive type:");
    ((StringBuilder)localObject1).append(paramInt);
    ((StringBuilder)localObject1).append(",isSuccess:");
    ((StringBuilder)localObject1).append(paramBoolean);
    Logger.a("NetCore", ((StringBuilder)localObject1).toString());
    if (this.a != null)
    {
      paramInt = paramBundle.getInt("req_cmd", 0);
      localObject1 = (FromServiceMsg)paramBundle.getParcelable("msf_data");
      boolean bool = paramBundle.getBoolean("msf_success", false);
      int i = paramBundle.getInt("msf_code", -1000);
      Object localObject2 = paramBundle.getByteArray("timi_data");
      int j = paramBundle.getInt("timi_code", -1);
      String str1 = paramBundle.getString("timi_errmsg", "");
      String str2 = paramBundle.getString("timi_displaymsg", "");
      int k = paramBundle.getInt("timi_subcode", -1);
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        try
        {
          paramBundle = ((MessageMicro)this.b.newInstance()).mergeFrom((byte[])localObject2);
        }
        catch (InstantiationException paramBundle)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramInt);
          ((StringBuilder)localObject2).append(" - parse rsp body InstantiationException");
          Logger.a("NetCore", ((StringBuilder)localObject2).toString(), paramBundle);
          break label329;
        }
        catch (IllegalAccessException paramBundle)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramInt);
          ((StringBuilder)localObject2).append(" - parse rsp body IllegalAccessException");
          Logger.a("NetCore", ((StringBuilder)localObject2).toString(), paramBundle);
          break label329;
        }
        catch (InvalidProtocolBufferMicroException paramBundle)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramInt);
          ((StringBuilder)localObject2).append(" - parse rsp body InvalidProtocolBufferMicroException");
          Logger.a("NetCore", ((StringBuilder)localObject2).toString(), paramBundle);
          break label329;
        }
      }
      else if (paramBoolean)
      {
        paramBundle = new StringBuilder();
        paramBundle.append(paramInt);
        paramBundle.append("- success, but parse rsp body empty! ");
        paramBundle.append(localObject2);
        Logger.c("NetCore", paramBundle.toString());
      }
      label329:
      paramBundle = null;
      if (paramBoolean)
      {
        this.a.a(paramBundle, (FromServiceMsg)localObject1);
        return;
      }
      this.a.a(bool, i, j, k, str1, str2, paramBundle, (FromServiceMsg)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tentcent.timi.game.net.impl.NetCore.1
 * JD-Core Version:    0.7.0.1
 */