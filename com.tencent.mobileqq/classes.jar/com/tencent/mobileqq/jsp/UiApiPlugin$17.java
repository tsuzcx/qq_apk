package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.protofile.getopenid.GetOpenidProto.GetOpenidEntry;
import com.tencent.protofile.getopenid.GetOpenidProto.GetOpenidResp;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

final class UiApiPlugin$17
  implements BusinessObserver
{
  UiApiPlugin$17(Activity paramActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onReceive get_openid:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("UiApiPlugin", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a.isFinishing()) {
      return;
    }
    if (paramBoolean)
    {
      localObject = paramBundle.getByteArray("data");
      if (localObject != null) {
        paramBundle = new GetOpenidProto.GetOpenidResp();
      }
    }
    try
    {
      paramBundle.mergeFrom((byte[])localObject);
      if (paramBundle.retcode.get() != 0)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("get_openid retcode:");
          ((StringBuilder)localObject).append(paramBundle.retcode.get());
          QLog.d("UiApiPlugin", 2, ((StringBuilder)localObject).toString());
        }
        this.a.setResult(-1, new Intent().putExtra("ret", 2).putExtra("errMsg", "server error, unexpected retcode"));
        this.a.finish();
        return;
      }
      j = paramBundle.list.size();
      localObject = new String[j];
      arrayOfInt = new int[j];
      i = 0;
    }
    catch (InvalidProtocolBufferMicroException paramBundle)
    {
      for (;;)
      {
        int j;
        int[] arrayOfInt;
        int i;
        GetOpenidProto.GetOpenidEntry localGetOpenidEntry;
        continue;
        if (paramInt == 1) {
          paramInt = 4;
        } else if (paramInt == 2) {
          paramInt = 8;
        } else {
          paramInt = 0;
        }
        arrayOfInt[i] = paramInt;
        i += 1;
      }
    }
    if (i < j)
    {
      localGetOpenidEntry = (GetOpenidProto.GetOpenidEntry)paramBundle.list.get(i);
      localObject[i] = localGetOpenidEntry.openid.get();
      paramInt = localGetOpenidEntry.type.get();
      if (paramInt == 0)
      {
        paramInt = 1;
        break label389;
      }
    }
    else
    {
      this.a.setResult(-1, new Intent().putExtra("ret", 0).putExtra("openids", (String[])localObject).putExtra("types", arrayOfInt));
      this.a.finish();
      return;
      this.a.setResult(-1, new Intent().putExtra("ret", 2).putExtra("errMsg", "server error, unexpected pbdata"));
      this.a.finish();
      return;
      this.a.setResult(-1, new Intent().putExtra("ret", 2));
      this.a.finish();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.17
 * JD-Core Version:    0.7.0.1
 */