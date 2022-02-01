package com.tencent.mobileqq.qwallet.hb.impl;

import Wallet.GetGroupRedPackListRsp;
import com.tencent.mobileqq.qwallet.hb.aio.elem.IRedPacket.OnGetAvailableListListener;
import java.util.HashMap;

class RedPacketManagerImpl$6$1
  implements Runnable
{
  RedPacketManagerImpl$6$1(RedPacketManagerImpl.6 param6, GetGroupRedPackListRsp paramGetGroupRedPackListRsp) {}
  
  public void run()
  {
    if (this.b.this$0.mReqGroupAvailableListListeners != null)
    {
      localObject = this.b.this$0.mReqGroupAvailableListListeners;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b.b);
      localStringBuilder.append("_");
      localStringBuilder.append(this.b.c);
      if (((HashMap)localObject).get(localStringBuilder.toString()) != null)
      {
        localObject = this.b.this$0.mReqGroupAvailableListListeners;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.b.b);
        localStringBuilder.append("_");
        localStringBuilder.append(this.b.c);
        localObject = (IRedPacket.OnGetAvailableListListener)((HashMap)localObject).get(localStringBuilder.toString());
        break label141;
      }
    }
    Object localObject = null;
    label141:
    if (localObject == null) {
      return;
    }
    this.b.this$0.filterHbHasGrabbed(this.b.a, this.b.b, this.b.c, (IRedPacket.OnGetAvailableListListener)localObject, this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.impl.RedPacketManagerImpl.6.1
 * JD-Core Version:    0.7.0.1
 */