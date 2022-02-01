package com.tencent.mobileqq.intervideo.groupvideo.cschannel.impl;

import android.os.Bundle;
import com.tencent.mobileqq.intervideo.groupvideo.cschannel.IODCsChannel.CsChannelObserver;
import com.tencent.mobileqq.intervideo.now.dynamic.PluginManagerInterfaceImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

class ODCsChannelImpl$1
  implements Runnable
{
  ODCsChannelImpl$1(ODCsChannelImpl paramODCsChannelImpl, int paramInt1, int paramInt2, byte[] paramArrayOfByte, boolean paramBoolean, IODCsChannel.CsChannelObserver paramCsChannelObserver) {}
  
  public void run()
  {
    Object localObject1 = PluginManagerInterfaceImpl.a().a("Od", "1104763709");
    try
    {
      localObject1 = (Bundle)((Future)localObject1).get();
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getAccessToken: error=");
      ((StringBuilder)localObject2).append(localInterruptedException.getMessage());
      QLog.e("ODCsChannel", 2, ((StringBuilder)localObject2).toString());
    }
    catch (ExecutionException localExecutionException)
    {
      localExecutionException.printStackTrace();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getAccessToken: error=");
      ((StringBuilder)localObject2).append(localExecutionException.getMessage());
      QLog.e("ODCsChannel", 2, ((StringBuilder)localObject2).toString());
    }
    StringBuilder localStringBuilder1 = null;
    if (localStringBuilder1 == null)
    {
      QLog.i("ODCsChannel", 2, "getAccessToken: get access token fail，bundle = null");
      i = this.a;
      if (i > 0)
      {
        ODCsChannelImpl.access$000(this.this$0, this.b, this.c, this.d, i - 1, this.e);
        return;
      }
      ODCsChannelImpl.access$100(this.this$0, -1, null, null, this.e);
      return;
    }
    int i = localStringBuilder1.getInt("code");
    Object localObject2 = localStringBuilder1.getBundle("data");
    if ((localObject2 != null) && (i == 0))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("getAccessToken: accessToken=");
        localStringBuilder1.append(((Bundle)localObject2).toString());
        QLog.d("ODCsChannel", 2, localStringBuilder1.toString());
      }
      ODCsChannelImpl.access$202(this.this$0, (Bundle)localObject2);
      this.this$0.sendRequest(this.b, this.c, this.d, this.a, this.e);
      return;
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("getAccessToken: get access token fail，errorCode=");
    localStringBuilder2.append(i);
    localStringBuilder2.append(" accessToken=");
    if (localObject2 == null) {
      localObject2 = "null";
    } else {
      localObject2 = ((Bundle)localObject2).toString();
    }
    localStringBuilder2.append((String)localObject2);
    QLog.i("ODCsChannel", 2, localStringBuilder2.toString());
    int j = this.a;
    if (j > 0)
    {
      ODCsChannelImpl.access$000(this.this$0, this.b, this.c, this.d, j - 1, this.e);
      return;
    }
    ODCsChannelImpl.access$100(this.this$0, i, null, localStringBuilder1, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.groupvideo.cschannel.impl.ODCsChannelImpl.1
 * JD-Core Version:    0.7.0.1
 */