package com.tencent.mobileqq.kandian.biz.video;

import android.os.Handler;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager;
import com.tencent.mobileqq.kandian.biz.accesslayer.data.RIJDataManager.Builder;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.framework.handlers.VideoHandler;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

public class NetInfoHandler
  implements INetInfoHandler
{
  private final VideoHandler a;
  private final ReadInJoyBaseAdapter b;
  private final RIJDataManager c;
  private final Handler d = new Handler();
  
  public NetInfoHandler(VideoHandler paramVideoHandler)
  {
    this.a = paramVideoHandler;
    this.b = paramVideoHandler.g();
    this.c = paramVideoHandler.h();
  }
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: mobile -> none");
    }
    this.a.C().updateNetworkChange(false);
    if (this.b.r())
    {
      if (!this.a.x()) {
        return;
      }
      VideoPlayManager localVideoPlayManager = this.a.A();
      if (localVideoPlayManager.g()) {
        localVideoPlayManager.c();
      }
    }
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: wifi -> mobile");
    }
    if (this.a.c() == 70)
    {
      this.d.post(new NetInfoHandler.9(this));
      return;
    }
    this.a.C().updateNetworkChange(true);
    if (this.b.r())
    {
      if (!this.a.x()) {
        return;
      }
      this.d.post(new NetInfoHandler.10(this));
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: none -> mobile");
    }
    if (this.a.c() == 70)
    {
      this.d.post(new NetInfoHandler.1(this));
      return;
    }
    paramString = this.a.C();
    int j = 0;
    if (paramString != null) {
      paramString.updateNetworkChange(false);
    }
    if (this.b.r())
    {
      if (!this.a.x()) {
        return;
      }
      int i = j;
      if (paramString != null)
      {
        i = j;
        if (paramString.canAutoPlayVideo()) {
          i = 1;
        }
      }
      if (i == 0) {
        return;
      }
      paramString = this.a.A();
      Object localObject = paramString.a();
      if ((!paramString.g()) && (!paramString.s()))
      {
        this.d.post(new NetInfoHandler.2(this));
        return;
      }
      if ((paramString.s()) && (localObject != null) && (paramString.n() == ((VideoPlayParam)localObject).j))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("net change: continue to play before video ,id : ");
          ((StringBuilder)localObject).append(paramString.n());
          QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject).toString());
        }
        paramString.v();
        return;
      }
      if ((localObject != null) && (paramString.s()) && (paramString.n() == ((VideoPlayParam)localObject).j))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mVideoPlayParam net change: continue to play before video ,id : ");
          ((StringBuilder)localObject).append(paramString.n());
          QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject).toString());
        }
        paramString.v();
      }
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: none -> wifi");
    }
    if (this.a.c() == 70)
    {
      this.d.post(new NetInfoHandler.7(this));
      return;
    }
    this.a.C().updateNetworkChange(true);
    if (this.b.r())
    {
      if (!this.a.x()) {
        return;
      }
      paramString = this.a.A();
      Object localObject = paramString.a();
      if ((!paramString.g()) && (!paramString.s()))
      {
        this.d.post(new NetInfoHandler.8(this));
        return;
      }
      if ((localObject != null) && (paramString.n() == ((VideoPlayParam)localObject).j) && (paramString.s()))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("net change: continue to play before video ,id : ");
          ((StringBuilder)localObject).append(paramString.n());
          QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject).toString());
        }
        paramString.v();
        return;
      }
      if ((localObject != null) && (paramString.n() == ((VideoPlayParam)localObject).j) && (paramString.s()))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("mVideoPlayParam net change: continue to play before video ,id : ");
          ((StringBuilder)localObject).append(paramString.n());
          QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject).toString());
        }
        paramString.v();
      }
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: wifi -> mobile,forwarding event to none2mobile handle");
    }
    if (this.a.c() == 70)
    {
      this.d.post(new NetInfoHandler.5(this));
      return;
    }
    paramString = this.a.C();
    int j = 0;
    paramString.updateNetworkChange(false);
    paramString = this.a.A();
    int i = j;
    if (paramString != null)
    {
      i = j;
      if (this.a.B() != null)
      {
        i = j;
        if (paramString.a() != null) {
          i = 1;
        }
      }
    }
    if (i != 0)
    {
      if (this.c.a().t()) {
        return;
      }
      this.d.post(new NetInfoHandler.6(this, paramString));
    }
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video", 2, "net change: wifi -> none.");
    }
    if (this.a.c() == 70)
    {
      this.d.post(new NetInfoHandler.3(this));
      return;
    }
    Object localObject = this.a.C();
    int j = 0;
    ((VideoAutoPlayController)localObject).updateNetworkChange(false);
    localObject = this.a.A();
    int i = j;
    if (localObject != null)
    {
      i = j;
      if (this.a.B() != null)
      {
        i = j;
        if (((VideoPlayManager)localObject).a() != null) {
          i = 1;
        }
      }
    }
    if (i != 0)
    {
      if (this.c.a().t()) {
        return;
      }
      this.d.post(new NetInfoHandler.4(this, (VideoPlayManager)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.NetInfoHandler
 * JD-Core Version:    0.7.0.1
 */