package com.tencent.mobileqq.uftransfer.common.transfer.upload;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferEngine.ExcitingSendInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferHostInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadBizInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadChnConfigInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadFileEntry;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadReqInfo;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploadResultRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.IExcitingTransferSendListener;
import com.tencent.mobileqq.uftransfer.api.UFTHost;
import com.tencent.mobileqq.uftransfer.api.UFTTransferConfig.ExtfUploadCfg;
import com.tencent.mobileqq.uftransfer.common.transfer.IUFTFileUploader;
import com.tencent.mobileqq.uftransfer.common.transfer.IUFTFileUploaderCallback;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.ExtfFUperProp;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.ExtfFileInfo;
import com.tencent.mobileqq.uftransfer.common.transfer.UFTFileUploaderProp.ExtfSvrInfo;
import com.tencent.mobileqq.uftransfer.depend.UFTDependFeatureApi;
import com.tencent.mobileqq.uftransfer.depend.UFTLog;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class UFTExtfFileUploader
  extends UFTFileUploaderCbWrapper
  implements IExcitingTransferSendListener, IUFTFileUploader
{
  private static long o;
  private static long p;
  protected final AppRuntime a;
  protected UFTFileUploaderProp.ExtfFUperProp b;
  protected final long c;
  protected final long d;
  protected final int e;
  protected final String f;
  protected byte[] g;
  protected boolean h = true;
  protected long i = 0L;
  protected long j = 0L;
  protected ExcitingTransferUploadResultRp k;
  
  private UFTExtfFileUploader(AppRuntime paramAppRuntime, UFTFileUploaderProp.ExtfFUperProp paramExtfFUperProp)
  {
    this.a = paramAppRuntime;
    this.b = paramExtfFUperProp;
    this.c = paramExtfFUperProp.a();
    this.b = paramExtfFUperProp;
    this.d = paramExtfFUperProp.c();
    this.e = paramExtfFUperProp.b();
    this.f = paramAppRuntime.getCurrentUin();
    this.h = true;
    k();
  }
  
  public static UFTExtfFileUploader a(AppRuntime paramAppRuntime, UFTFileUploaderProp.ExtfFUperProp paramExtfFUperProp)
  {
    if ((paramAppRuntime != null) && (paramExtfFUperProp != null))
    {
      if (!paramExtfFUperProp.l())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("prop invaild:");
        localStringBuilder.append(paramExtfFUperProp.m());
        UFTLog.d("[UFTTransfer] UFTExtfFileUploader", 1, localStringBuilder.toString());
      }
      return new UFTExtfFileUploader(paramAppRuntime, paramExtfFUperProp);
    }
    UFTLog.d("[UFTTransfer] UFTExtfFileUploader", 1, "app|prop is null");
    return null;
  }
  
  private static void a(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = p;
    if ((l2 < 100L) && (l1 - o > 6000L))
    {
      o = l1;
      p = l2 + 1L;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("!!!getBigDataSigFromHwSvr. count:");
      localStringBuilder.append(p);
      localStringBuilder.append(" lastTime:");
      localStringBuilder.append(o);
      UFTLog.c("[UFTTransfer] UFTExtfFileUploader", 1, localStringBuilder.toString());
      UFTDependFeatureApi.b(paramAppRuntime);
    }
  }
  
  private void k()
  {
    this.g = UFTDependFeatureApi.b(this.f);
    Object localObject = this.g;
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("!!!!!Id[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("] UFTExtfFileUploader ERR: BigDataSig is null.!!!!!");
      UFTLog.d("[UFTTransfer] UFTExtfFileUploader", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private boolean l()
  {
    byte[] arrayOfByte = this.g;
    return (arrayOfByte != null) && (arrayOfByte.length > 0);
  }
  
  private ExcitingTransferEngine.ExcitingSendInfo m()
  {
    ExcitingTransferEngine.ExcitingSendInfo localExcitingSendInfo = new ExcitingTransferEngine.ExcitingSendInfo();
    localExcitingSendInfo.mFileEntry = n();
    localExcitingSendInfo.mBusInfo = o();
    localExcitingSendInfo.mReqInfo = p();
    localExcitingSendInfo.mConfig = q();
    return localExcitingSendInfo;
  }
  
  private ExcitingTransferUploadFileEntry n()
  {
    ExcitingTransferUploadFileEntry localExcitingTransferUploadFileEntry = new ExcitingTransferUploadFileEntry();
    localExcitingTransferUploadFileEntry.strLocalFilePath = this.b.g().a();
    localExcitingTransferUploadFileEntry.strFileName = this.b.g().b();
    localExcitingTransferUploadFileEntry.uFileSize = this.b.g().c();
    localExcitingTransferUploadFileEntry.buf10MMd5 = this.b.g().e();
    localExcitingTransferUploadFileEntry.bufMd5 = this.b.g().d();
    localExcitingTransferUploadFileEntry.bufSha = this.b.g().f();
    localExcitingTransferUploadFileEntry.bufSha3 = this.b.g().g();
    return localExcitingTransferUploadFileEntry;
  }
  
  private ExcitingTransferUploadBizInfo o()
  {
    ExcitingTransferUploadBizInfo localExcitingTransferUploadBizInfo = new ExcitingTransferUploadBizInfo();
    localExcitingTransferUploadBizInfo.commandId = this.b.f();
    localExcitingTransferUploadBizInfo.chateType = this.b.d();
    localExcitingTransferUploadBizInfo.businessType = this.b.e();
    localExcitingTransferUploadBizInfo.bufSig = this.g;
    localExcitingTransferUploadBizInfo.senderUin = Long.valueOf(this.f).longValue();
    localExcitingTransferUploadBizInfo.receiverUin = this.d;
    localExcitingTransferUploadBizInfo.clientType = 2;
    localExcitingTransferUploadBizInfo.clientVer = UFTDependFeatureApi.e();
    localExcitingTransferUploadBizInfo.terminalType = 2;
    localExcitingTransferUploadBizInfo.terminalVer = UFTDependFeatureApi.f();
    Object localObject = this.b.h().b();
    int n = 0;
    int m;
    UFTHost localUFTHost;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localExcitingTransferUploadBizInfo.vecFtnLanIpV4AndPorts = new ExcitingTransferHostInfo[((List)localObject).size()];
      localObject = ((List)localObject).iterator();
      m = 0;
      while (((Iterator)localObject).hasNext())
      {
        localUFTHost = (UFTHost)((Iterator)localObject).next();
        localExcitingTransferUploadBizInfo.vecFtnLanIpV4AndPorts[m] = new ExcitingTransferHostInfo(localUFTHost.a(), localUFTHost.b());
        m += 1;
      }
    }
    localObject = this.b.h().c();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localExcitingTransferUploadBizInfo.vecFtnLanIpV6AndPorts = new ExcitingTransferHostInfo[((List)localObject).size()];
      localObject = ((List)localObject).iterator();
      m = n;
      while (((Iterator)localObject).hasNext())
      {
        localUFTHost = (UFTHost)((Iterator)localObject).next();
        localExcitingTransferUploadBizInfo.vecFtnLanIpV6AndPorts[m] = new ExcitingTransferHostInfo(localUFTHost.a(), localUFTHost.b());
        m += 1;
      }
    }
    localExcitingTransferUploadBizInfo.bufBusinessExt = this.b.h().d();
    localExcitingTransferUploadBizInfo.bufUuid = this.b.g().h();
    localExcitingTransferUploadBizInfo.bufUploadKey = this.b.g().i();
    localExcitingTransferUploadBizInfo.bUseMediaPlatform = this.b.j();
    localExcitingTransferUploadBizInfo.groupCode = this.b.i();
    return localExcitingTransferUploadBizInfo;
  }
  
  private ExcitingTransferUploadReqInfo p()
  {
    ExcitingTransferUploadReqInfo localExcitingTransferUploadReqInfo = new ExcitingTransferUploadReqInfo();
    List localList = this.b.h().a();
    if (localList != null)
    {
      int n = localList.size();
      int m = 4;
      if (n <= 4) {
        m = localList.size();
      }
      localExcitingTransferUploadReqInfo.vecSrvIpAndPorts = new ExcitingTransferHostInfo[m];
      n = 0;
      while (n < m)
      {
        UFTHost localUFTHost = (UFTHost)localList.get(n);
        localExcitingTransferUploadReqInfo.vecSrvIpAndPorts[n] = new ExcitingTransferHostInfo(localUFTHost.a(), localUFTHost.b());
        n += 1;
      }
    }
    localExcitingTransferUploadReqInfo.bSupportHttps = this.b.h().e();
    localExcitingTransferUploadReqInfo.strSSLCName = this.b.h().f();
    return localExcitingTransferUploadReqInfo;
  }
  
  private ExcitingTransferUploadChnConfigInfo q()
  {
    ExcitingTransferUploadChnConfigInfo localExcitingTransferUploadChnConfigInfo = new ExcitingTransferUploadChnConfigInfo();
    if (this.b.k() != null)
    {
      localExcitingTransferUploadChnConfigInfo.uMuliFileSizeLimit = this.b.k().a();
      localExcitingTransferUploadChnConfigInfo.uMaxChannelNum = this.b.k().b();
      localExcitingTransferUploadChnConfigInfo.uPieceSize = this.b.k().c();
      localExcitingTransferUploadChnConfigInfo.nMaxEachHostTotalUseCount = this.b.k().d();
      localExcitingTransferUploadChnConfigInfo.nMaxEachHostErrorCount = this.b.k().e();
      localExcitingTransferUploadChnConfigInfo.nMaxEachHostParallelUseCount = this.b.k().f();
      localExcitingTransferUploadChnConfigInfo.nConnectTimeout = this.b.k().g();
      localExcitingTransferUploadChnConfigInfo.nDataTimeout = this.b.k().h();
      localExcitingTransferUploadChnConfigInfo.nTotoalDataTimeout = this.b.k().i();
    }
    return localExcitingTransferUploadChnConfigInfo;
  }
  
  public void a()
  {
    if (this.h) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("] cancel^^^^");
    UFTLog.b("[UFTTransfer] UFTExtfFileUploader", 1, localStringBuilder.toString());
    this.h = true;
    if (this.i != 0L)
    {
      ExcitingTransferEngine.getInstance().cancelSendFile(this.i);
      this.i = 0L;
    }
  }
  
  protected void a(int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    if (this.h) {
      return;
    }
    if (this.i != 0L)
    {
      ExcitingTransferEngine.getInstance().cancelSendFile(this.i);
      this.i = 0L;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("] *_* *_* onFailure errcode:");
    localStringBuilder.append(paramInt);
    UFTLog.d("[UFTTransfer] UFTExtfFileUploader", 1, localStringBuilder.toString());
    a(true, paramInt, this.j, "", "", paramExcitingTransferUploadResultRp);
  }
  
  public void a(IUFTFileUploaderCallback paramIUFTFileUploaderCallback)
  {
    this.l = paramIUFTFileUploaderCallback;
  }
  
  public boolean a(long paramLong)
  {
    i();
    if (!l())
    {
      k();
      if (!l()) {
        a(this.a);
      }
    }
    Object localObject = m();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("] uploadFile >>>>");
    UFTLog.b("[UFTTransfer] UFTExtfFileUploader", 1, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("] ReqInfo   = {");
    localStringBuilder.append(((ExcitingTransferEngine.ExcitingSendInfo)localObject).mReqInfo.toString());
    localStringBuilder.append("}");
    UFTLog.b("[UFTTransfer] UFTExtfFileUploader", 1, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("] FileEntry = {");
    localStringBuilder.append(((ExcitingTransferEngine.ExcitingSendInfo)localObject).mFileEntry.toString());
    localStringBuilder.append("}");
    UFTLog.b("[UFTTransfer] UFTExtfFileUploader", 1, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("] BusInfo   = {");
    localStringBuilder.append(((ExcitingTransferEngine.ExcitingSendInfo)localObject).mBusInfo.toString());
    localStringBuilder.append("}");
    UFTLog.b("[UFTTransfer] UFTExtfFileUploader", 1, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("] Config    = {");
    localStringBuilder.append(((ExcitingTransferEngine.ExcitingSendInfo)localObject).mConfig.toString());
    localStringBuilder.append("}");
    UFTLog.b("[UFTTransfer] UFTExtfFileUploader", 1, localStringBuilder.toString());
    paramLong = ExcitingTransferEngine.getInstance().sendFile((ExcitingTransferEngine.ExcitingSendInfo)localObject, this);
    if (paramLong == 0L)
    {
      this.h = true;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Id[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("] uploadFile fail");
      UFTLog.d("[UFTTransfer] UFTExtfFileUploader", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    this.h = false;
    this.i = paramLong;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Id[");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("] uploadFile excitingId:");
    ((StringBuilder)localObject).append(this.i);
    UFTLog.b("[UFTTransfer] UFTExtfFileUploader", 1, ((StringBuilder)localObject).toString());
    return true;
  }
  
  public int b()
  {
    ExcitingTransferUploadResultRp localExcitingTransferUploadResultRp = this.k;
    if (localExcitingTransferUploadResultRp != null) {
      return (int)localExcitingTransferUploadResultRp.muRetryCount;
    }
    return 0;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public String d()
  {
    ExcitingTransferUploadResultRp localExcitingTransferUploadResultRp = this.k;
    if (localExcitingTransferUploadResultRp != null) {
      return localExcitingTransferUploadResultRp.mstrFileUrl;
    }
    return null;
  }
  
  public long e()
  {
    return this.j;
  }
  
  public long f()
  {
    ExcitingTransferUploadResultRp localExcitingTransferUploadResultRp = this.k;
    if (localExcitingTransferUploadResultRp != null) {
      return localExcitingTransferUploadResultRp.mu64StartSize;
    }
    return 0L;
  }
  
  public boolean h()
  {
    ExcitingTransferUploadResultRp localExcitingTransferUploadResultRp = this.k;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localExcitingTransferUploadResultRp != null)
    {
      bool1 = bool2;
      if (this.b.g() != null)
      {
        bool1 = bool2;
        if (this.k.mu64StartSize == this.b.g().c()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected void i()
  {
    this.j = 0L;
    this.i = 0L;
    this.k = null;
  }
  
  public boolean j()
  {
    return this.h;
  }
  
  public void onExcitingSendProgress(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.h) {
      return;
    }
    this.j = paramLong1;
    a(this.j, paramLong2, paramLong3);
  }
  
  public void onExcitingSendResult(boolean paramBoolean, int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    if (this.h) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("] onExcitingSendResult suc:");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" errcode:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" RP:");
    Object localObject;
    if (paramExcitingTransferUploadResultRp != null) {
      localObject = paramExcitingTransferUploadResultRp.toString();
    } else {
      localObject = "";
    }
    localStringBuilder.append((String)localObject);
    UFTLog.b("[UFTTransfer] UFTExtfFileUploader", 1, localStringBuilder.toString());
    this.k = paramExcitingTransferUploadResultRp;
    if (paramBoolean) {
      this.j = this.b.g().c();
    }
    this.i = 0L;
    if (paramExcitingTransferUploadResultRp != null)
    {
      long l;
      if (paramBoolean)
      {
        if (this.b.g().c() - paramExcitingTransferUploadResultRp.mu64StartSize > 0L) {
          l = this.b.g().c() - paramExcitingTransferUploadResultRp.mu64StartSize;
        } else {
          l = 0L;
        }
        paramExcitingTransferUploadResultRp.mu64TransferSize = l;
      }
      else
      {
        if (this.j - paramExcitingTransferUploadResultRp.mu64StartSize > 0L) {
          l = this.j - paramExcitingTransferUploadResultRp.mu64StartSize;
        } else {
          l = 0L;
        }
        paramExcitingTransferUploadResultRp.mu64TransferSize = l;
      }
      if ((l > 0L) && (paramExcitingTransferUploadResultRp.mu64HttpTime > 0L))
      {
        float f1 = (float)paramExcitingTransferUploadResultRp.mu64HttpTime / 1000.0F;
        paramExcitingTransferUploadResultRp.mu64TransferSpeed = (((float)l / f1));
      }
      else
      {
        paramExcitingTransferUploadResultRp.mu64TransferSpeed = 0L;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Id[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("] sendResultRP:");
      ((StringBuilder)localObject).append(paramExcitingTransferUploadResultRp.toString());
      UFTLog.b("[UFTTransfer] UFTExtfFileUploader", 1, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      a(h(), paramExcitingTransferUploadResultRp);
      return;
    }
    if (!UFTDependFeatureApi.c())
    {
      paramInt = 2;
      if (paramExcitingTransferUploadResultRp != null) {
        paramExcitingTransferUploadResultRp.mnResult = 2;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Id[");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append("] onExcitingSendResult. is no network");
      UFTLog.b("[UFTTransfer] UFTExtfFileUploader", 1, ((StringBuilder)localObject).toString());
    }
    a(paramInt, paramExcitingTransferUploadResultRp);
  }
  
  public void onExcitingSendStart()
  {
    if (this.h) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("] onExcitingSendStart.");
    UFTLog.b("[UFTTransfer] UFTExtfFileUploader", 1, localStringBuilder.toString());
    a(this.j, 0L, 0L);
  }
  
  public void onExcitingSubSenderResult(int paramInt, ExcitingTransferUploaderRp paramExcitingTransferUploaderRp)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("] ^_^ onExcitingSubSenderResult:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" RP:");
    String str;
    if (paramExcitingTransferUploaderRp != null) {
      str = paramExcitingTransferUploaderRp.toString();
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    UFTLog.b("[UFTTransfer] UFTExtfFileUploader", 1, localStringBuilder.toString());
    if (paramInt == 0)
    {
      a(paramExcitingTransferUploaderRp);
      return;
    }
    a(false, paramInt, this.j, "", "", paramExcitingTransferUploaderRp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTExtfFileUploader
 * JD-Core Version:    0.7.0.1
 */