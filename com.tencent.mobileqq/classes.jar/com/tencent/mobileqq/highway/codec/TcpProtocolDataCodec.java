package com.tencent.mobileqq.highway.codec;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.SystemClock;
import com.tencent.mobileqq.highway.config.ConfigManager;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.DataHighwayHead;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.LoginSigHead;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.ReqDataHighwayHead;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.RspDataHighwayHead;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.SegHead;
import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.segment.HwResponse;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhUtils;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class TcpProtocolDataCodec
{
  private static final int ETX_C = 41;
  public static final int MAX_PKG_SIZE = 1048576;
  private static final int PROTO_COSNST_LEN = 10;
  private static final int STX_C = 40;
  private static final int VERSION_CODE_1 = 1;
  private static final int VERSION_CODE_2 = 2;
  protected IProtocolCodecListener codecListener;
  protected byte[] revData;
  public String versionCode = null;
  
  private CSDataHighwayHead.DataHighwayHead buildHWHead(HwRequest paramHwRequest)
  {
    CSDataHighwayHead.DataHighwayHead localDataHighwayHead = new CSDataHighwayHead.DataHighwayHead();
    if (paramHwRequest.isOpenUpEnable) {
      localDataHighwayHead.uint32_version.set(2);
    } else {
      localDataHighwayHead.uint32_version.set(1);
    }
    localDataHighwayHead.uint32_appid.set(paramHwRequest.appid);
    localDataHighwayHead.uint32_seq.set(paramHwRequest.getHwSeq());
    localDataHighwayHead.uint32_dataflag.set(paramHwRequest.dataFlag);
    localDataHighwayHead.uint32_retry_times.set(paramHwRequest.retryCount);
    localDataHighwayHead.uint32_command_id.set(paramHwRequest.mBuCmdId);
    Object localObject = null;
    byte[] arrayOfByte2;
    try
    {
      byte[] arrayOfByte1 = paramHwRequest.account.getBytes("utf-8");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      localUnsupportedEncodingException1.printStackTrace();
      arrayOfByte2 = null;
    }
    try
    {
      byte[] arrayOfByte3 = paramHwRequest.hwCmd.getBytes("utf-8");
      localObject = arrayOfByte3;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException3)
    {
      localUnsupportedEncodingException3.printStackTrace();
    }
    localDataHighwayHead.bytes_uin.set(ByteStringMicro.copyFrom(arrayOfByte2));
    localDataHighwayHead.bytes_command.set(ByteStringMicro.copyFrom(localObject));
    if (paramHwRequest.isOpenUpEnable) {
      try
      {
        arrayOfByte2 = getVersionCode().getBytes("utf-8");
        if (arrayOfByte2 != null) {
          localDataHighwayHead.bytes_build_ver.set(ByteStringMicro.copyFrom(arrayOfByte2));
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException2)
      {
        localUnsupportedEncodingException2.printStackTrace();
      }
    }
    if (paramHwRequest.localeId > 0)
    {
      localDataHighwayHead.locale_id.set(paramHwRequest.localeId);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("buildHWHead,locale_id = ");
      localStringBuilder.append(paramHwRequest.localeId);
      BdhLogUtil.LogEvent("R", localStringBuilder.toString());
    }
    int i = ConfigManager.getCustomEnvId();
    if (i > 0) {
      localDataHighwayHead.env_id.set(i);
    }
    return localDataHighwayHead;
  }
  
  private int decodePackage(byte[] paramArrayOfByte, List<HwResponse> paramList)
  {
    int i = paramArrayOfByte.length;
    boolean bool2 = false;
    if (i != 0)
    {
      if (i < 10) {
        return 0;
      }
      if (i > 1048576)
      {
        BdhLogUtil.LogEvent("N", "Decode Error : BufLen > MAX_PKG_SIZE");
        paramArrayOfByte = this.codecListener;
        if (paramArrayOfByte != null) {
          paramArrayOfByte.onDecodeInvalidData(1);
        }
        return 0;
      }
      if (paramArrayOfByte[0] != 40)
      {
        BdhLogUtil.LogEvent("N", "Decode Error : revData[0] != STX_C");
        paramArrayOfByte = this.codecListener;
        if (paramArrayOfByte != null) {
          paramArrayOfByte.onDecodeInvalidData(2);
        }
        return 0;
      }
      int k = (int)BdhUtils.getLongData(paramArrayOfByte, 1);
      i = (int)BdhUtils.getLongData(paramArrayOfByte, 5);
      int j = k + 10 + i;
      if (paramArrayOfByte.length < j) {
        return 0;
      }
      Object localObject2 = new byte[k];
      Object localObject1 = new byte[i];
      BdhUtils.copyData((byte[])localObject2, 0, paramArrayOfByte, 9, k);
      k = 9 + k;
      BdhUtils.copyData((byte[])localObject1, 0, paramArrayOfByte, k, i);
      if (paramArrayOfByte[(k + i)] != 41)
      {
        paramArrayOfByte = this.codecListener;
        if (paramArrayOfByte != null) {
          paramArrayOfByte.onDecodeInvalidData(2);
        }
        return 0;
      }
      CSDataHighwayHead.RspDataHighwayHead localRspDataHighwayHead = new CSDataHighwayHead.RspDataHighwayHead();
      try
      {
        localRspDataHighwayHead.mergeFrom((byte[])localObject2);
        i = 1;
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        i = 0;
      }
      if (i == 0)
      {
        paramArrayOfByte = this.codecListener;
        if (paramArrayOfByte != null) {
          paramArrayOfByte.onDecodeInvalidData(2);
        }
        return 0;
      }
      paramArrayOfByte = (CSDataHighwayHead.DataHighwayHead)localRspDataHighwayHead.msg_basehead.get();
      localObject2 = new HwResponse();
      ((HwResponse)localObject2).hwSeq = paramArrayOfByte.uint32_seq.get();
      ((HwResponse)localObject2).retCode = localRspDataHighwayHead.uint32_error_code.get();
      ((HwResponse)localObject2).mRespData = ((byte[])localObject1);
      ((HwResponse)localObject2).mBuExtendinfo = localRspDataHighwayHead.bytes_rsp_extendinfo.get().toByteArray();
      ((HwResponse)localObject2).recvTime = SystemClock.uptimeMillis();
      if (localRspDataHighwayHead.uint64_range.has()) {
        ((HwResponse)localObject2).range = ((int)localRspDataHighwayHead.uint64_range.get());
      }
      boolean bool1;
      if (localRspDataHighwayHead.uint32_is_reset.has())
      {
        if (localRspDataHighwayHead.uint32_is_reset.get() == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        ((HwResponse)localObject2).needReUpload = bool1;
      }
      localObject1 = paramArrayOfByte.bytes_command.get().toByteArray();
      paramArrayOfByte = null;
      try
      {
        localObject1 = new String((byte[])localObject1, "utf-8");
        paramArrayOfByte = (byte[])localObject1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
      }
      ((HwResponse)localObject2).cmd = paramArrayOfByte;
      if (localRspDataHighwayHead.uint32_htcost.has()) {
        ((HwResponse)localObject2).htCost = localRspDataHighwayHead.uint32_htcost.get();
      }
      if (localRspDataHighwayHead.uint32_cachecost.has()) {
        ((HwResponse)localObject2).cacheCost = localRspDataHighwayHead.uint32_cachecost.get();
      }
      if (localRspDataHighwayHead.uint32_allow_retry.has())
      {
        if (localRspDataHighwayHead.uint32_allow_retry.get() == 1) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        ((HwResponse)localObject2).shouldRetry = bool1;
      }
      if (localRspDataHighwayHead.msg_seghead.has())
      {
        paramArrayOfByte = (CSDataHighwayHead.SegHead)localRspDataHighwayHead.msg_seghead.get();
        ((HwResponse)localObject2).segmentResp = paramArrayOfByte;
        ((HwResponse)localObject2).buzRetCode = paramArrayOfByte.uint32_rtcode.get();
        bool1 = bool2;
        if ((paramArrayOfByte.uint32_flag.get() & 0x1) == 1) {
          bool1 = true;
        }
        ((HwResponse)localObject2).isFinish = bool1;
      }
      ((HwResponse)localObject2).respLength = j;
      paramList.add(localObject2);
      return j;
    }
    return 0;
  }
  
  public boolean decodeS2CData(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      if (paramArrayOfByte.length <= 0) {
        return false;
      }
      Object localObject = this.revData;
      int i;
      byte[] arrayOfByte;
      if (localObject != null)
      {
        i = localObject.length;
        arrayOfByte = new byte[paramArrayOfByte.length + i];
        BdhUtils.copyData(arrayOfByte, 0, (byte[])localObject, 0, i);
        BdhUtils.copyData(arrayOfByte, i, paramArrayOfByte, 0, paramArrayOfByte.length);
        this.revData = arrayOfByte;
      }
      else
      {
        this.revData = paramArrayOfByte;
      }
      paramArrayOfByte = new ArrayList();
      for (;;)
      {
        i = decodePackage(this.revData, paramArrayOfByte);
        if (i <= 0) {
          break;
        }
        localObject = this.revData;
        arrayOfByte = new byte[localObject.length - i];
        BdhUtils.copyData(arrayOfByte, 0, (byte[])localObject, i, localObject.length - i);
        this.revData = arrayOfByte;
      }
      if (paramArrayOfByte.size() > 0)
      {
        localObject = this.codecListener;
        if (localObject != null) {
          ((IProtocolCodecListener)localObject).onDecodeSucessfully(paramArrayOfByte);
        }
        return true;
      }
    }
    return false;
  }
  
  public byte[] encodeC2SData(EndPoint paramEndPoint, HwRequest paramHwRequest, byte[] paramArrayOfByte)
  {
    paramEndPoint = new CSDataHighwayHead.ReqDataHighwayHead();
    Object localObject = buildHWHead(paramHwRequest);
    if (localObject != null) {
      paramEndPoint.msg_basehead.set((MessageMicro)localObject);
    }
    localObject = paramHwRequest.getSegmentHead();
    if (localObject != null) {
      paramEndPoint.msg_seghead.set((MessageMicro)localObject);
    }
    localObject = paramHwRequest.getExtendInfo();
    if (localObject != null) {
      paramEndPoint.bytes_req_extendinfo.set(ByteStringMicro.copyFrom((byte[])localObject));
    }
    localObject = paramHwRequest.getLoginSigHead();
    if (localObject != null) {
      paramEndPoint.msg_login_sig_head.set((MessageMicro)localObject);
    }
    int i;
    if (paramArrayOfByte != null) {
      i = paramArrayOfByte.length;
    } else {
      i = 0;
    }
    paramEndPoint = paramEndPoint.toByteArray();
    localObject = new byte[paramEndPoint.length + 10 + i];
    paramHwRequest.bodyLength = i;
    paramHwRequest.headLength = (paramEndPoint.length + 10);
    localObject[0] = 40;
    BdhUtils.DWord2Byte((byte[])localObject, 1, paramEndPoint.length);
    BdhUtils.DWord2Byte((byte[])localObject, 5, i);
    BdhUtils.copyData((byte[])localObject, 9, paramEndPoint, 0, paramEndPoint.length);
    int j = paramEndPoint.length;
    if (i != 0) {
      BdhUtils.copyData((byte[])localObject, 9 + j, paramArrayOfByte, 0, i);
    }
    localObject[(localObject.length - 1)] = 41;
    return localObject;
  }
  
  public String getVersionCode()
  {
    Object localObject = this.versionCode;
    if (localObject != null) {
      return localObject;
    }
    this.versionCode = "unkownVersion";
    try
    {
      localObject = BaseApplication.getContext().getPackageManager().getPackageInfo(BaseApplication.getContext().getPackageName(), 0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((PackageInfo)localObject).versionName);
      localStringBuilder.append(".");
      localStringBuilder.append(((PackageInfo)localObject).versionCode);
      this.versionCode = localStringBuilder.toString();
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      this.versionCode = "unkownVersion";
      localNameNotFoundException.printStackTrace();
    }
    return this.versionCode;
  }
  
  public void onRecvData(MsfSocketInputBuffer paramMsfSocketInputBuffer)
  {
    byte[] arrayOfByte = new byte[paramMsfSocketInputBuffer.getBufferlen()];
    System.arraycopy(paramMsfSocketInputBuffer.getBuffer(), 0, arrayOfByte, 0, arrayOfByte.length);
    decodeS2CData(arrayOfByte);
  }
  
  public void setProtocolCodecListener(IProtocolCodecListener paramIProtocolCodecListener)
  {
    this.codecListener = paramIProtocolCodecListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.codec.TcpProtocolDataCodec
 * JD-Core Version:    0.7.0.1
 */