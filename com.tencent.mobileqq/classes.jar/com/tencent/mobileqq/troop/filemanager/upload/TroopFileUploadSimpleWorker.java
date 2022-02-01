package com.tencent.mobileqq.troop.filemanager.upload;

import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.troop.file.TroopFileProtocol;
import com.tencent.biz.troop.file.protocol.TroopFileReqUploadFileObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.DomainInfo;
import com.tencent.mobileqq.filemanager.core.FileIPv6StrateyController.IPListInfo;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.troop.filemanager.TroopFileProtoReqMgr.ProtoRequest;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.utils.TroopTechReportUtils.TroopFileReportResultCode;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class TroopFileUploadSimpleWorker
  implements ITroopFileUploaderSink, TroopFileScaner.ITroopFileScanPrg, TroopFileUploadMgr.ITroopFileUploadWorker
{
  private int jdField_a_of_type_Int = 0;
  protected long a;
  private TroopFileReqUploadFileObserver jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqUploadFileObserver = new TroopFileUploadSimpleWorker.1(this);
  private TroopFileProtoReqMgr.ProtoRequest jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest;
  private ITroopFileUploader jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader;
  private String jdField_a_of_type_JavaLangString;
  private List<TroopFileUploadMgr.ITroopFileUploadWorkerListener> jdField_a_of_type_JavaUtilList = new LinkedList();
  private UUID jdField_a_of_type_JavaUtilUUID;
  private boolean jdField_a_of_type_Boolean = true;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int = 102;
  private long jdField_b_of_type_Long = 0L;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private byte[] jdField_c_of_type_ArrayOfByte;
  private int jdField_d_of_type_Int = 0;
  private long jdField_d_of_type_Long = 0L;
  private String jdField_d_of_type_JavaLangString;
  private int jdField_e_of_type_Int = 0;
  private String jdField_e_of_type_JavaLangString;
  private String f;
  private String g;
  
  public TroopFileUploadSimpleWorker(UUID paramUUID, long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilUUID = paramUUID;
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaUtilUUID.toString();
    this.jdField_c_of_type_Long = paramLong;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void b(boolean paramBoolean)
  {
    TroopFileTransferUtil.Log.c("TroopFileUploadSimpleWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onUploadSuc. bHit:" + paramBoolean);
    b(5);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileUploadMgr.ITroopFileUploadWorkerListener)localIterator.next()).a(this.jdField_a_of_type_JavaUtilUUID, true, 0, this);
    }
  }
  
  private void c()
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileUploadSimpleWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqUploadFile app=null");
      this.jdField_b_of_type_Boolean = true;
      c(TroopTechReportUtils.TroopFileReportResultCode.w);
      return;
    }
    TroopFileTransferUtil.Log.c("TroopFileUploadSimpleWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] reqUploadFile");
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest = TroopFileProtocol.a(localQQAppInterface, this.jdField_c_of_type_Long, this.jdField_b_of_type_JavaLangString, this.jdField_c_of_type_JavaLangString, this.jdField_d_of_type_Long, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, this.jdField_b_of_type_Int, "", null, this.jdField_a_of_type_ComTencentBizTroopFileProtocolTroopFileReqUploadFileObserver);
    b(2);
  }
  
  private void c(int paramInt)
  {
    TroopFileTransferUtil.Log.a("TroopFileUploadSimpleWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onUploadErr ResultCode:" + paramInt);
    this.jdField_a_of_type_Boolean = true;
    b(6);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((TroopFileUploadMgr.ITroopFileUploadWorkerListener)localIterator.next()).a(this.jdField_a_of_type_JavaUtilUUID, false, paramInt, this);
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public UUID a()
  {
    return this.jdField_a_of_type_JavaUtilUUID;
  }
  
  public void a()
  {
    b(7);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      TroopFileTransferUtil.Log.c("TroopFileUploadSimpleWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop. but had stoped. mStatus:" + this.jdField_a_of_type_Int);
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    TroopFileTransferUtil.Log.c("TroopFileUploadSimpleWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop. mStatus:" + this.jdField_a_of_type_Int + " reason:" + paramInt);
    if (this.jdField_a_of_type_Int == 1) {
      if (this.jdField_b_of_type_Long != 0L)
      {
        TroopFileScaner.a().a(this.jdField_b_of_type_Long);
        this.jdField_b_of_type_Long = 0L;
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest != null)
      {
        TroopFileProtocol.a(TroopFileTransferUtil.a(), this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest);
        this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerTroopFileProtoReqMgr$ProtoRequest = null;
      }
      b(0);
      return;
      if (this.jdField_a_of_type_Int == 3) {
        if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader == null)
        {
          TroopFileTransferUtil.Log.b("TroopFileUploadSimpleWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] stop upload. uploader=null");
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader.a();
          this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader = null;
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {}
    while (paramLong <= this.jdField_a_of_type_Long) {
      return;
    }
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    if (this.jdField_b_of_type_Long != paramLong1) {}
    while ((paramLong2 == 0L) || (this.jdField_d_of_type_Long != 0L)) {
      return;
    }
    this.jdField_d_of_type_Long = paramLong2;
  }
  
  public void a(long paramLong1, String paramString, long paramLong2, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, Bundle paramBundle, int paramInt)
  {
    if (this.jdField_b_of_type_Long != paramLong1) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      TroopFileTransferUtil.Log.b("TroopFileUploadSimpleWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFileScanResult. but had stop");
      return;
    }
    if (paramInt != 0)
    {
      this.jdField_b_of_type_Boolean = true;
      int i = TroopTechReportUtils.TroopFileReportResultCode.l;
      if (paramInt == -2) {
        i = TroopTechReportUtils.TroopFileReportResultCode.s;
      }
      for (;;)
      {
        TroopFileTransferUtil.Log.a("TroopFileUploadSimpleWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFileScanResult. errCode:" + paramInt);
        c(i);
        return;
        if (paramInt == -1) {
          i = TroopTechReportUtils.TroopFileReportResultCode.g;
        } else if (paramInt == -4) {
          i = TroopTechReportUtils.TroopFileReportResultCode.jdField_e_of_type_Int;
        } else if (paramInt == -3) {
          i = TroopTechReportUtils.TroopFileReportResultCode.j;
        }
      }
    }
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0) || (paramArrayOfByte2 == null) || (paramArrayOfByte2.length == 0))
    {
      TroopFileTransferUtil.Log.a("TroopFileUploadSimpleWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFileScanResult. md5 or sha is null");
      this.jdField_b_of_type_Boolean = true;
      c(TroopTechReportUtils.TroopFileReportResultCode.l);
      return;
    }
    TroopFileTransferUtil.Log.c("TroopFileUploadSimpleWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onFileScanResult. errCode:" + paramInt);
    if ((paramLong2 != 0L) && (this.jdField_d_of_type_Long == 0L)) {
      this.jdField_d_of_type_Long = paramLong2;
    }
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    if (paramBundle != null)
    {
      this.jdField_c_of_type_Int = paramBundle.getInt("_with_", 0);
      this.jdField_d_of_type_Int = paramBundle.getInt("_height_", 0);
      this.jdField_e_of_type_Int = paramBundle.getInt("_duration_", 0);
    }
    c();
  }
  
  public void a(TroopFileUploadMgr.ITroopFileUploadWorkerListener paramITroopFileUploadWorkerListener)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramITroopFileUploadWorkerListener);
  }
  
  public void a(String paramString)
  {
    TroopFileTransferUtil.Log.c("TroopFileUploadSimpleWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onChangeUrl:" + paramString);
  }
  
  protected void a(boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface = TroopFileTransferUtil.a();
    if (localQQAppInterface == null)
    {
      TroopFileTransferUtil.Log.a("TroopFileUploadSimpleWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startUpload app=null");
      this.jdField_b_of_type_Boolean = true;
      c(TroopTechReportUtils.TroopFileReportResultCode.w);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader.a();
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader.a(null);
    }
    TroopFileTransferUtil.Log.c("TroopFileUploadSimpleWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startUpload firstIP=" + this.jdField_e_of_type_JavaLangString);
    String str1 = HexUtil.bytes2HexStr(this.jdField_c_of_type_ArrayOfByte);
    String str2 = HexUtil.bytes2HexStr(this.jdField_b_of_type_ArrayOfByte);
    long l = TroopFileTransferUtil.a();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_e_of_type_JavaLangString);
    if ((!paramBoolean) && (!TextUtils.isEmpty(this.f)))
    {
      if (!FileIPv6StrateyController.a().a(localQQAppInterface, 3)) {
        break label488;
      }
      QLog.i("TroopFileUploadSimpleWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] upload troopfile. is config enable IPv6. domain[" + this.f + "]");
      Object localObject = new FileIPv6StrateyController.DomainInfo(this.f, 0);
      localObject = FileIPv6StrateyController.a().a(localQQAppInterface, (FileIPv6StrateyController.DomainInfo)localObject, 3);
      if ((localObject == null) || (((FileIPv6StrateyController.IPListInfo)localObject).a())) {
        break label439;
      }
      if (FileIPv6StrateyController.a())
      {
        QLog.d("TroopFileUploadSimpleWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] upload troopfile. debugIsDisableIPv4OnDoubleStack");
        localArrayList.clear();
      }
      FileIPv6StrateyController.a(((FileIPv6StrateyController.IPListInfo)localObject).jdField_a_of_type_JavaUtilList, localArrayList, true, false);
      QLog.i("TroopFileUploadSimpleWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] upload troopfile. use IPv6. iplist:" + localArrayList.toString());
    }
    for (;;)
    {
      paramBoolean = TroopFileUtils.a(localQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader = TroopFileUploader.a(localQQAppInterface, l, this.jdField_c_of_type_JavaLangString, str1, str2, localArrayList, "/ftn_handler", paramBoolean, this.f);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader != null) {
        break;
      }
      this.jdField_b_of_type_Boolean = true;
      c(TroopTechReportUtils.TroopFileReportResultCode.w);
      return;
      label439:
      QLog.i("TroopFileUploadSimpleWorker", 1, "[" + this.jdField_a_of_type_JavaLangString + "] [IPv6-File] upload troopfile. use IPv4:");
      localArrayList.add(this.f);
      continue;
      label488:
      localArrayList.add(this.f);
    }
    TroopFileTransferUtil.Log.c("TroopFileUploadSimpleWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] startUpload. nSessionId:" + l + " firstIP=" + this.jdField_e_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader.a(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerUploadITroopFileUploader.a();
    b(3);
  }
  
  public void a(boolean paramBoolean, long paramLong, int paramInt, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    while (!paramBoolean) {
      return;
    }
    TroopFileTransferUtil.Log.a("TroopFileUploadSimpleWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onHasErr. upload fail. errCode:" + paramInt + " transferedSize:" + paramLong + " rspHeader:" + paramString2 + " errMsg:" + paramString1);
    this.jdField_b_of_type_Boolean = true;
    c(paramInt);
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    while (!paramBoolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    c(TroopTechReportUtils.TroopFileReportResultCode.v);
  }
  
  public boolean a()
  {
    TroopFileTransferUtil.Log.c("TroopFileUploadSimpleWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] start filepath:" + this.jdField_c_of_type_JavaLangString);
    if (!NetworkUtil.g(BaseApplication.getContext()))
    {
      TroopFileTransferUtil.Log.a("TroopFileUploadSimpleWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] no network");
      b(6);
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    b();
    return true;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public long b()
  {
    return this.jdField_d_of_type_Long;
  }
  
  public String b()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  protected void b()
  {
    this.jdField_b_of_type_Long = TroopFileScaner.a().a(this.jdField_c_of_type_JavaLangString, this, null);
    if (this.jdField_b_of_type_Long == 0L)
    {
      this.jdField_b_of_type_Boolean = true;
      TroopFileTransferUtil.Log.a("TroopFileUploadSimpleWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] scanFile. startScan failed");
      c(TroopTechReportUtils.TroopFileReportResultCode.w);
      return;
    }
    TroopFileTransferUtil.Log.c("TroopFileUploadSimpleWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] scanFile. cookie:" + this.jdField_b_of_type_Long);
    b(1);
  }
  
  public void b(long paramLong1, long paramLong2, long paramLong3) {}
  
  public int c()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public String c()
  {
    return FileHttpUtils.a(this.jdField_a_of_type_ArrayOfByte);
  }
  
  public int d()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public String d()
  {
    return FileHttpUtils.a(this.jdField_b_of_type_ArrayOfByte);
  }
  
  public boolean d()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    b(true);
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    b(false);
  }
  
  public void h()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    TroopFileTransferUtil.Log.a("TroopFileUploadSimpleWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onOutDate. upload fail");
    c(206);
  }
  
  public void i()
  {
    TroopFileTransferUtil.Log.c("TroopFileUploadSimpleWorker", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_JavaLangString + "] onRetrySend");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.upload.TroopFileUploadSimpleWorker
 * JD-Core Version:    0.7.0.1
 */