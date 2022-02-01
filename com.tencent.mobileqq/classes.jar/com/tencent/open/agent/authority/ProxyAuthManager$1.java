package com.tencent.open.agent.authority;

import android.os.Bundle;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.appcommon.OpensdkBusinessObserver;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.qconn.protofile.auth.AuthResponse;

class ProxyAuthManager$1
  implements OpensdkBusinessObserver
{
  ProxyAuthManager$1(ProxyAuthManager paramProxyAuthManager, long paramLong, AccountInfo paramAccountInfo, String paramString1, AuthCallback paramAuthCallback, boolean paramBoolean, String paramString2, String paramString3) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    long l1 = System.currentTimeMillis() - this.a;
    Object localObject1 = paramBundle.getString("ssoAccount");
    int i = paramBundle.getInt("code");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("ProxyAuth.doAuthorize.onReceive:  ssoAccount: ");
    ((StringBuilder)localObject2).append(AuthorityUtil.a((String)localObject1));
    ((StringBuilder)localObject2).append(", uin=*");
    ((StringBuilder)localObject2).append(AuthorityUtil.a(this.b.a));
    ((StringBuilder)localObject2).append(", timeCost=");
    ((StringBuilder)localObject2).append(l1);
    ((StringBuilder)localObject2).append(", isSuccess=");
    ((StringBuilder)localObject2).append(paramBoolean);
    ((StringBuilder)localObject2).append(", code=");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(", cmd=");
    ((StringBuilder)localObject2).append(this.c);
    SSOLog.a("ProxyAuthManager", new Object[] { ((StringBuilder)localObject2).toString() });
    if (!this.b.a.equals(localObject1))
    {
      this.d.a(false, -1, null);
      return;
    }
    if (paramBoolean)
    {
      localObject2 = new auth.AuthResponse();
      try
      {
        localObject1 = paramBundle.getByteArray("data");
        Object localObject3 = localObject1;
        if (this.e) {
          localObject3 = OpenSdkVirtualUtil.a((byte[])localObject1, this.b);
        }
        if (localObject3 != null)
        {
          localObject1 = (auth.AuthResponse)((auth.AuthResponse)localObject2).mergeFrom((byte[])localObject3);
          paramInt = i;
          try
          {
            i = ((auth.AuthResponse)localObject1).ret.get();
            paramInt = i;
            localObject2 = ((auth.AuthResponse)localObject1).state.get();
            paramInt = i;
            SSOLog.a("ProxyAuthManager", new Object[] { "code=", Integer.valueOf(i), ", respState=", localObject2, ", reqState=", this.f });
            if (i == 0)
            {
              paramInt = i;
              if (this.f.equals(localObject2))
              {
                paramInt = i;
                this.d.a(true, i, AuthResponse.a((auth.AuthResponse)localObject1));
                paramInt = 1;
                break label369;
              }
            }
            paramInt = 0;
            try
            {
              label369:
              j = ((auth.AuthResponse)localObject1).ret.get();
              AuthReporter.a(paramBundle, l1, j, 13, this.c, this.g, this.b.a);
              l1 = this.a;
              long l2 = localObject3.length;
              long l3 = ((auth.AuthResponse)localObject1).toByteArray().length;
              paramBundle = this.b.a;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("ret: ");
              ((StringBuilder)localObject2).append(j);
              AuthReporter.a("agent_authority", l1, l2, l3, 0, paramBundle, ((StringBuilder)localObject2).toString());
              AuthReporter.a(0, "LOGIN_AUTH", this.b.a, this.g, j, null);
            }
            catch (Exception paramBundle)
            {
              break label533;
            }
            localObject1 = localObject2;
          }
          catch (Exception paramBundle) {}
        }
        else
        {
          paramInt = 0;
        }
      }
      catch (Exception paramBundle)
      {
        localObject1 = localObject2;
        paramInt = i;
        int j = 0;
        i = paramInt;
        paramInt = j;
        label533:
        SSOLog.a("ProxyAuthManager", "-->exception catch", paramBundle);
        this.d.a(false, i, null);
      }
      if (paramInt == 0) {
        this.d.a(false, i, AuthResponse.a((auth.AuthResponse)localObject1));
      }
    }
    else
    {
      this.d.a(false, i, null);
      AuthReporter.a("agent_authority", this.a, 0L, 0L, i, this.b.a, "");
      AuthReporter.a(1, "LOGIN_AUTH", this.b.a, this.g, 3002, "");
      paramBundle = this.b.a;
      localObject1 = this.g;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(3002);
      AuthReporter.a(paramBundle, (String)localObject1, "6", ((StringBuilder)localObject2).toString(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.authority.ProxyAuthManager.1
 * JD-Core Version:    0.7.0.1
 */