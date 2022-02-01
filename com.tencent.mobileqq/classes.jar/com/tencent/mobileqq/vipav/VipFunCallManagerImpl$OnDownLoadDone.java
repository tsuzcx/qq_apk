package com.tencent.mobileqq.vipav;

import android.os.Bundle;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class VipFunCallManagerImpl$OnDownLoadDone
{
  private boolean b;
  private int c;
  private int d;
  private boolean e;
  private int f;
  private String g;
  private String h;
  private File i;
  private int j;
  private Bundle k;
  
  public VipFunCallManagerImpl$OnDownLoadDone(VipFunCallManagerImpl paramVipFunCallManagerImpl, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, String paramString1, String paramString2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramBoolean;
    this.f = paramInt3;
    this.g = paramString1;
    this.h = paramString2;
  }
  
  boolean a()
  {
    return this.b;
  }
  
  public File b()
  {
    return this.i;
  }
  
  public int c()
  {
    return this.j;
  }
  
  public Bundle d()
  {
    return this.k;
  }
  
  public OnDownLoadDone e()
  {
    this.i = new File(this.h);
    boolean bool;
    if ((this.i.exists()) && (this.i.isFile())) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("startDownload exists(), id=");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(", resType=");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append(", isIPC=");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append(", srcType=");
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append(", fileExist=");
      ((StringBuilder)localObject).append(bool);
      QLog.d("VipFunCallManager", 2, ((StringBuilder)localObject).toString());
    }
    if ((bool) && (!this.e))
    {
      this.b = true;
      return this;
    }
    this.j = this.d;
    this.k = new Bundle();
    if ((7 != VipFunCallUtil.c()) && (7 == this.j)) {
      this.j = 0;
    }
    this.k.putInt("callId", this.c);
    this.k.putString("path", this.h);
    this.k.putBoolean("isIPC", this.e);
    this.k.putInt("resourceType", this.d);
    this.k.putInt("srcType", this.f);
    this.k.putInt("dealType", this.j);
    if (bool)
    {
      this.k.putBoolean("isExists", true);
      localObject = new DownloadTask(this.g, this.i);
      ((DownloadTask)localObject).a(3);
      ((DownloadTask)localObject).c = 0;
      ((DownloadTask)localObject).a(this.k);
      this.a.b.onDone((DownloadTask)localObject);
      this.b = true;
      return this;
    }
    this.b = false;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vipav.VipFunCallManagerImpl.OnDownLoadDone
 * JD-Core Version:    0.7.0.1
 */