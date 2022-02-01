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
  private static long f;
  private static long g;
  protected final int a;
  protected final long a;
  protected ExcitingTransferUploadResultRp a;
  protected UFTFileUploaderProp.ExtfFUperProp a;
  protected final String a;
  protected final AppRuntime a;
  protected boolean a;
  protected byte[] a;
  protected final long b;
  protected long c = 0L;
  protected long d = 0L;
  
  private UFTExtfFileUploader(AppRuntime paramAppRuntime, UFTFileUploaderProp.ExtfFUperProp paramExtfFUperProp)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp = paramExtfFUperProp;
    this.jdField_a_of_type_Long = paramExtfFUperProp.a();
    this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp = paramExtfFUperProp;
    this.b = paramExtfFUperProp.b();
    this.jdField_a_of_type_Int = paramExtfFUperProp.a();
    this.jdField_a_of_type_JavaLangString = paramAppRuntime.getCurrentUin();
    this.jdField_a_of_type_Boolean = true;
    d();
  }
  
  private ExcitingTransferEngine.ExcitingSendInfo a()
  {
    ExcitingTransferEngine.ExcitingSendInfo localExcitingSendInfo = new ExcitingTransferEngine.ExcitingSendInfo();
    localExcitingSendInfo.mFileEntry = a();
    localExcitingSendInfo.mBusInfo = a();
    localExcitingSendInfo.mReqInfo = a();
    localExcitingSendInfo.mConfig = a();
    return localExcitingSendInfo;
  }
  
  private ExcitingTransferUploadBizInfo a()
  {
    ExcitingTransferUploadBizInfo localExcitingTransferUploadBizInfo = new ExcitingTransferUploadBizInfo();
    localExcitingTransferUploadBizInfo.commandId = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.d();
    localExcitingTransferUploadBizInfo.chateType = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.b();
    localExcitingTransferUploadBizInfo.businessType = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.c();
    localExcitingTransferUploadBizInfo.bufSig = this.jdField_a_of_type_ArrayOfByte;
    localExcitingTransferUploadBizInfo.senderUin = Long.valueOf(this.jdField_a_of_type_JavaLangString).longValue();
    localExcitingTransferUploadBizInfo.receiverUin = this.b;
    localExcitingTransferUploadBizInfo.clientType = 2;
    localExcitingTransferUploadBizInfo.clientVer = UFTDependFeatureApi.b();
    localExcitingTransferUploadBizInfo.terminalType = 2;
    localExcitingTransferUploadBizInfo.terminalVer = UFTDependFeatureApi.c();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().b();
    int j = 0;
    int i;
    UFTHost localUFTHost;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localExcitingTransferUploadBizInfo.vecFtnLanIpV4AndPorts = new ExcitingTransferHostInfo[((List)localObject).size()];
      localObject = ((List)localObject).iterator();
      i = 0;
      while (((Iterator)localObject).hasNext())
      {
        localUFTHost = (UFTHost)((Iterator)localObject).next();
        localExcitingTransferUploadBizInfo.vecFtnLanIpV4AndPorts[i] = new ExcitingTransferHostInfo(localUFTHost.a(), localUFTHost.a());
        i += 1;
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().c();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localExcitingTransferUploadBizInfo.vecFtnLanIpV6AndPorts = new ExcitingTransferHostInfo[((List)localObject).size()];
      localObject = ((List)localObject).iterator();
      i = j;
      while (((Iterator)localObject).hasNext())
      {
        localUFTHost = (UFTHost)((Iterator)localObject).next();
        localExcitingTransferUploadBizInfo.vecFtnLanIpV6AndPorts[i] = new ExcitingTransferHostInfo(localUFTHost.a(), localUFTHost.a());
        i += 1;
      }
    }
    localExcitingTransferUploadBizInfo.bufBusinessExt = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().a();
    localExcitingTransferUploadBizInfo.bufUuid = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().e();
    localExcitingTransferUploadBizInfo.bufUploadKey = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().f();
    localExcitingTransferUploadBizInfo.bUseMediaPlatform = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a();
    localExcitingTransferUploadBizInfo.groupCode = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.c();
    return localExcitingTransferUploadBizInfo;
  }
  
  private ExcitingTransferUploadChnConfigInfo a()
  {
    ExcitingTransferUploadChnConfigInfo localExcitingTransferUploadChnConfigInfo = new ExcitingTransferUploadChnConfigInfo();
    if (this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a() != null)
    {
      localExcitingTransferUploadChnConfigInfo.uMuliFileSizeLimit = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().a();
      localExcitingTransferUploadChnConfigInfo.uMaxChannelNum = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().a();
      localExcitingTransferUploadChnConfigInfo.uPieceSize = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().b();
      localExcitingTransferUploadChnConfigInfo.nMaxEachHostTotalUseCount = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().c();
      localExcitingTransferUploadChnConfigInfo.nMaxEachHostErrorCount = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().d();
      localExcitingTransferUploadChnConfigInfo.nMaxEachHostParallelUseCount = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().e();
      localExcitingTransferUploadChnConfigInfo.nConnectTimeout = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().b();
      localExcitingTransferUploadChnConfigInfo.nDataTimeout = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().c();
      localExcitingTransferUploadChnConfigInfo.nTotoalDataTimeout = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().d();
    }
    return localExcitingTransferUploadChnConfigInfo;
  }
  
  private ExcitingTransferUploadFileEntry a()
  {
    ExcitingTransferUploadFileEntry localExcitingTransferUploadFileEntry = new ExcitingTransferUploadFileEntry();
    localExcitingTransferUploadFileEntry.strLocalFilePath = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().a();
    localExcitingTransferUploadFileEntry.strFileName = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().b();
    localExcitingTransferUploadFileEntry.uFileSize = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().a();
    localExcitingTransferUploadFileEntry.buf10MMd5 = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().b();
    localExcitingTransferUploadFileEntry.bufMd5 = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().a();
    localExcitingTransferUploadFileEntry.bufSha = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().c();
    localExcitingTransferUploadFileEntry.bufSha3 = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().d();
    return localExcitingTransferUploadFileEntry;
  }
  
  private ExcitingTransferUploadReqInfo a()
  {
    ExcitingTransferUploadReqInfo localExcitingTransferUploadReqInfo = new ExcitingTransferUploadReqInfo();
    List localList = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().a();
    if (localList != null)
    {
      int j = localList.size();
      int i = 4;
      if (j <= 4) {
        i = localList.size();
      }
      localExcitingTransferUploadReqInfo.vecSrvIpAndPorts = new ExcitingTransferHostInfo[i];
      j = 0;
      while (j < i)
      {
        UFTHost localUFTHost = (UFTHost)localList.get(j);
        localExcitingTransferUploadReqInfo.vecSrvIpAndPorts[j] = new ExcitingTransferHostInfo(localUFTHost.a(), localUFTHost.a());
        j += 1;
      }
    }
    localExcitingTransferUploadReqInfo.bSupportHttps = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().a();
    localExcitingTransferUploadReqInfo.strSSLCName = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().a();
    return localExcitingTransferUploadReqInfo;
  }
  
  public static UFTExtfFileUploader a(AppRuntime paramAppRuntime, UFTFileUploaderProp.ExtfFUperProp paramExtfFUperProp)
  {
    if ((paramAppRuntime != null) && (paramExtfFUperProp != null))
    {
      if (!paramExtfFUperProp.b())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("prop invaild:");
        localStringBuilder.append(paramExtfFUperProp.a());
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
    long l2 = g;
    if ((l2 < 100L) && (l1 - f > 6000L))
    {
      f = l1;
      g = l2 + 1L;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("!!!getBigDataSigFromHwSvr. count:");
      localStringBuilder.append(g);
      localStringBuilder.append(" lastTime:");
      localStringBuilder.append(f);
      UFTLog.c("[UFTTransfer] UFTExtfFileUploader", 1, localStringBuilder.toString());
      UFTDependFeatureApi.a(paramAppRuntime);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ArrayOfByte = UFTDependFeatureApi.b(this.jdField_a_of_type_JavaLangString);
    Object localObject = this.jdField_a_of_type_ArrayOfByte;
    if ((localObject == null) || (localObject.length == 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("!!!!!Id[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("] UFTExtfFileUploader ERR: BigDataSig is null.!!!!!");
      UFTLog.d("[UFTTransfer] UFTExtfFileUploader", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private boolean d()
  {
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    return (arrayOfByte != null) && (arrayOfByte.length > 0);
  }
  
  public int a()
  {
    ExcitingTransferUploadResultRp localExcitingTransferUploadResultRp = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp;
    if (localExcitingTransferUploadResultRp != null) {
      return (int)localExcitingTransferUploadResultRp.muRetryCount;
    }
    return 0;
  }
  
  public String a()
  {
    ExcitingTransferUploadResultRp localExcitingTransferUploadResultRp = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp;
    if (localExcitingTransferUploadResultRp != null) {
      return localExcitingTransferUploadResultRp.mstrFileUrl;
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("] cancel^^^^");
    UFTLog.b("[UFTTransfer] UFTExtfFileUploader", 1, localStringBuilder.toString());
    this.jdField_a_of_type_Boolean = true;
    if (this.c != 0L)
    {
      ExcitingTransferEngine.getInstance().cancelSendFile(this.c);
      this.c = 0L;
    }
  }
  
  protected void a(int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.c != 0L)
    {
      ExcitingTransferEngine.getInstance().cancelSendFile(this.c);
      this.c = 0L;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("] *_* *_* onFailure errcode:");
    localStringBuilder.append(paramInt);
    UFTLog.d("[UFTTransfer] UFTExtfFileUploader", 1, localStringBuilder.toString());
    a(true, paramInt, this.d, "", "", paramExcitingTransferUploadResultRp);
  }
  
  public void a(IUFTFileUploaderCallback paramIUFTFileUploaderCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferIUFTFileUploaderCallback = paramIUFTFileUploaderCallback;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(long paramLong)
  {
    c();
    if (!d())
    {
      d();
      if (!d()) {
        a(this.jdField_a_of_type_MqqAppAppRuntime);
      }
    }
    Object localObject = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("] uploadFile >>>>");
    UFTLog.b("[UFTTransfer] UFTExtfFileUploader", 1, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("] ReqInfo   = {");
    localStringBuilder.append(((ExcitingTransferEngine.ExcitingSendInfo)localObject).mReqInfo.toString());
    localStringBuilder.append("}");
    UFTLog.b("[UFTTransfer] UFTExtfFileUploader", 1, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("] FileEntry = {");
    localStringBuilder.append(((ExcitingTransferEngine.ExcitingSendInfo)localObject).mFileEntry.toString());
    localStringBuilder.append("}");
    UFTLog.b("[UFTTransfer] UFTExtfFileUploader", 1, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("] BusInfo   = {");
    localStringBuilder.append(((ExcitingTransferEngine.ExcitingSendInfo)localObject).mBusInfo.toString());
    localStringBuilder.append("}");
    UFTLog.b("[UFTTransfer] UFTExtfFileUploader", 1, localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("] Config    = {");
    localStringBuilder.append(((ExcitingTransferEngine.ExcitingSendInfo)localObject).mConfig.toString());
    localStringBuilder.append("}");
    UFTLog.b("[UFTTransfer] UFTExtfFileUploader", 1, localStringBuilder.toString());
    paramLong = ExcitingTransferEngine.getInstance().sendFile((ExcitingTransferEngine.ExcitingSendInfo)localObject, this);
    if (paramLong == 0L)
    {
      this.jdField_a_of_type_Boolean = true;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Id[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("] uploadFile fail");
      UFTLog.d("[UFTTransfer] UFTExtfFileUploader", 1, ((StringBuilder)localObject).toString());
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    this.c = paramLong;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Id[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject).append("] uploadFile excitingId:");
    ((StringBuilder)localObject).append(this.c);
    UFTLog.b("[UFTTransfer] UFTExtfFileUploader", 1, ((StringBuilder)localObject).toString());
    return true;
  }
  
  public long b()
  {
    ExcitingTransferUploadResultRp localExcitingTransferUploadResultRp = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp;
    if (localExcitingTransferUploadResultRp != null) {
      return localExcitingTransferUploadResultRp.mu64StartSize;
    }
    return 0L;
  }
  
  public boolean b()
  {
    ExcitingTransferUploadResultRp localExcitingTransferUploadResultRp = this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localExcitingTransferUploadResultRp != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a() != null)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp.mu64StartSize == this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().a()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public long b_()
  {
    return this.d;
  }
  
  protected void c()
  {
    this.d = 0L;
    this.c = 0L;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp = null;
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void onExcitingSendProgress(long paramLong1, long paramLong2, long paramLong3)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.d = paramLong1;
    a(this.d, paramLong2, paramLong3);
  }
  
  public void onExcitingSendResult(boolean paramBoolean, int paramInt, ExcitingTransferUploadResultRp paramExcitingTransferUploadResultRp)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
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
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerExcitingtransferExcitingtransfersdkExcitingTransferUploadResultRp = paramExcitingTransferUploadResultRp;
    if (paramBoolean) {
      this.d = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().a();
    }
    this.c = 0L;
    if (paramExcitingTransferUploadResultRp != null)
    {
      long l;
      if (paramBoolean)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().a() - paramExcitingTransferUploadResultRp.mu64StartSize > 0L) {
          l = this.jdField_a_of_type_ComTencentMobileqqUftransferCommonTransferUFTFileUploaderProp$ExtfFUperProp.a().a() - paramExcitingTransferUploadResultRp.mu64StartSize;
        } else {
          l = 0L;
        }
        paramExcitingTransferUploadResultRp.mu64TransferSize = l;
      }
      else
      {
        if (this.d - paramExcitingTransferUploadResultRp.mu64StartSize > 0L) {
          l = this.d - paramExcitingTransferUploadResultRp.mu64StartSize;
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
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("] sendResultRP:");
      ((StringBuilder)localObject).append(paramExcitingTransferUploadResultRp.toString());
      UFTLog.b("[UFTTransfer] UFTExtfFileUploader", 1, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      a(b(), paramExcitingTransferUploadResultRp);
      return;
    }
    if (!UFTDependFeatureApi.a())
    {
      paramInt = 2;
      if (paramExcitingTransferUploadResultRp != null) {
        paramExcitingTransferUploadResultRp.mnResult = 2;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Id[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("] onExcitingSendResult. is no network");
      UFTLog.b("[UFTTransfer] UFTExtfFileUploader", 1, ((StringBuilder)localObject).toString());
    }
    a(paramInt, paramExcitingTransferUploadResultRp);
  }
  
  public void onExcitingSendStart()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("] onExcitingSendStart.");
    UFTLog.b("[UFTTransfer] UFTExtfFileUploader", 1, localStringBuilder.toString());
    a(this.d, 0L, 0L);
  }
  
  public void onExcitingSubSenderResult(int paramInt, ExcitingTransferUploaderRp paramExcitingTransferUploaderRp)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Id[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
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
    a(false, paramInt, this.d, "", "", paramExcitingTransferUploaderRp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.uftransfer.common.transfer.upload.UFTExtfFileUploader
 * JD-Core Version:    0.7.0.1
 */