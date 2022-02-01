package com.tencent.trtc;

import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.renderer.e;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.RenderInfo;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserInfo;

class TRTCSubCloud$5
  implements Runnable
{
  TRTCSubCloud$5(TRTCSubCloud paramTRTCSubCloud, String paramString, int paramInt, TRTCCloudListener.TRTCSnapshotListener paramTRTCSnapshotListener) {}
  
  public void run()
  {
    if (this.a != null)
    {
      TRTCRoomInfo.UserInfo localUserInfo = TRTCSubCloud.access$5400(this.d).getUser(this.a);
      StringBuilder localStringBuilder = null;
      Object localObject;
      if (this.b == 2)
      {
        localObject = localStringBuilder;
        if (localUserInfo != null)
        {
          localObject = localStringBuilder;
          if (localUserInfo.mainRender != null)
          {
            localObject = localStringBuilder;
            if (localUserInfo.mainRender.render != null)
            {
              localObject = this.d;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("snapshotRemoteSubStreamView->userId: ");
              localStringBuilder.append(this.a);
              TRTCSubCloud.access$5500((TRTCSubCloud)localObject, localStringBuilder.toString());
              localObject = localUserInfo.subRender.render.getVideoRender();
            }
          }
        }
      }
      else
      {
        localObject = localStringBuilder;
        if (localUserInfo != null)
        {
          localObject = localStringBuilder;
          if (localUserInfo.mainRender != null)
          {
            localObject = localStringBuilder;
            if (localUserInfo.mainRender.render != null)
            {
              localObject = this.d;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("snapshotRemoteView->userId: ");
              localStringBuilder.append(this.a);
              TRTCSubCloud.access$5600((TRTCSubCloud)localObject, localStringBuilder.toString());
              localObject = localUserInfo.mainRender.render.getVideoRender();
            }
          }
        }
      }
      if (localObject != null)
      {
        ((e)localObject).a(new TRTCSubCloud.5.1(this));
        return;
      }
      TRTCSubCloud.access$5800(this.d, new TRTCSubCloud.5.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.TRTCSubCloud.5
 * JD-Core Version:    0.7.0.1
 */