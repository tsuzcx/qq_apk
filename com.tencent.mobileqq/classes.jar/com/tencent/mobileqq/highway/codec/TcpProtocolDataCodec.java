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
  public String versionCode;
  
  private CSDataHighwayHead.DataHighwayHead buildHWHead(HwRequest paramHwRequest)
  {
    Object localObject2 = null;
    CSDataHighwayHead.DataHighwayHead localDataHighwayHead = new CSDataHighwayHead.DataHighwayHead();
    if (paramHwRequest.isOpenUpEnable) {
      localDataHighwayHead.uint32_version.set(2);
    }
    for (;;)
    {
      localDataHighwayHead.uint32_appid.set(paramHwRequest.appid);
      localDataHighwayHead.uint32_seq.set(paramHwRequest.getHwSeq());
      localDataHighwayHead.uint32_dataflag.set(paramHwRequest.dataFlag);
      localDataHighwayHead.uint32_retry_times.set(paramHwRequest.retryCount);
      localDataHighwayHead.uint32_command_id.set(paramHwRequest.mBuCmdId);
      try
      {
        byte[] arrayOfByte1 = paramHwRequest.account.getBytes("utf-8");
        try
        {
          byte[] arrayOfByte2 = paramHwRequest.hwCmd.getBytes("utf-8");
          localObject2 = arrayOfByte2;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException3)
        {
          for (;;)
          {
            localUnsupportedEncodingException3.printStackTrace();
          }
        }
        localDataHighwayHead.bytes_uin.set(ByteStringMicro.copyFrom(arrayOfByte1));
        localDataHighwayHead.bytes_command.set(ByteStringMicro.copyFrom(localObject2));
        if (paramHwRequest.isOpenUpEnable) {}
        try
        {
          arrayOfByte1 = getVersionCode().getBytes("utf-8");
          if (arrayOfByte1 != null) {
            localDataHighwayHead.bytes_build_ver.set(ByteStringMicro.copyFrom(arrayOfByte1));
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException2)
        {
          for (;;)
          {
            int i;
            Object localObject1;
            localUnsupportedEncodingException2.printStackTrace();
          }
        }
        if (paramHwRequest.localeId > 0)
        {
          localDataHighwayHead.locale_id.set(paramHwRequest.localeId);
          BdhLogUtil.LogEvent("R", "buildHWHead,locale_id = " + paramHwRequest.localeId);
        }
        i = ConfigManager.getCustomEnvId();
        if (i > 0) {
          localDataHighwayHead.env_id.set(i);
        }
        return localDataHighwayHead;
        localDataHighwayHead.uint32_version.set(1);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException1)
      {
        for (;;)
        {
          localUnsupportedEncodingException1.printStackTrace();
          localObject1 = null;
        }
      }
    }
  }
  
  private int decodePackage(byte[] paramArrayOfByte, List<HwResponse> paramList)
  {
    boolean bool2 = true;
    int i = paramArrayOfByte.length;
    if ((i == 0) || (i < 10)) {}
    int j;
    Object localObject;
    byte[] arrayOfByte;
    CSDataHighwayHead.RspDataHighwayHead localRspDataHighwayHead;
    do
    {
      do
      {
        int k;
        do
        {
          do
          {
            do
            {
              return 0;
              if (i <= 1048576) {
                break;
              }
              BdhLogUtil.LogEvent("N", "Decode Error : BufLen > MAX_PKG_SIZE");
            } while (this.codecListener == null);
            this.codecListener.onDecodeInvalidData(1);
            return 0;
            if (paramArrayOfByte[0] == 40) {
              break;
            }
            BdhLogUtil.LogEvent("N", "Decode Error : revData[0] != STX_C");
          } while (this.codecListener == null);
          this.codecListener.onDecodeInvalidData(2);
          return 0;
          k = (int)BdhUtils.getLongData(paramArrayOfByte, 1);
          i = (int)BdhUtils.getLongData(paramArrayOfByte, 5);
          j = k + 10 + i;
        } while (paramArrayOfByte.length < j);
        localObject = new byte[k];
        arrayOfByte = new byte[i];
        BdhUtils.copyData((byte[])localObject, 0, paramArrayOfByte, 9, k);
        k += 9;
        BdhUtils.copyData(arrayOfByte, 0, paramArrayOfByte, k, i);
        i = k + i;
        if (paramArrayOfByte[i] == 41) {
          break;
        }
      } while (this.codecListener == null);
      this.codecListener.onDecodeInvalidData(2);
      return 0;
      localRspDataHighwayHead = new CSDataHighwayHead.RspDataHighwayHead();
      try
      {
        localRspDataHighwayHead.mergeFrom((byte[])localObject);
        i = 1;
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          i = 0;
        }
        paramArrayOfByte = (CSDataHighwayHead.DataHighwayHead)localRspDataHighwayHead.msg_basehead.get();
        localObject = new HwResponse();
        ((HwResponse)localObject).hwSeq = paramArrayOfByte.uint32_seq.get();
        ((HwResponse)localObject).retCode = localRspDataHighwayHead.uint32_error_code.get();
        ((HwResponse)localObject).mRespData = arrayOfByte;
        ((HwResponse)localObject).mBuExtendinfo = localRspDataHighwayHead.bytes_rsp_extendinfo.get().toByteArray();
        ((HwResponse)localObject).recvTime = SystemClock.uptimeMillis();
        if (!localRspDataHighwayHead.uint64_range.has()) {
          break label340;
        }
        ((HwResponse)localObject).range = ((int)localRspDataHighwayHead.uint64_range.get());
        if (!localRspDataHighwayHead.uint32_is_reset.has()) {
          break label373;
        }
      }
      if (i != 0) {
        break;
      }
    } while (this.codecListener == null);
    this.codecListener.onDecodeInvalidData(2);
    return 0;
    label340:
    boolean bool1;
    if (localRspDataHighwayHead.uint32_is_reset.get() == 1) {
      bool1 = true;
    }
    for (;;)
    {
      ((HwResponse)localObject).needReUpload = bool1;
      label373:
      paramArrayOfByte = paramArrayOfByte.bytes_command.get().toByteArray();
      try
      {
        paramArrayOfByte = new String(paramArrayOfByte, "utf-8");
        ((HwResponse)localObject).cmd = paramArrayOfByte;
        if (localRspDataHighwayHead.uint32_htcost.has()) {
          ((HwResponse)localObject).htCost = localRspDataHighwayHead.uint32_htcost.get();
        }
        if (localRspDataHighwayHead.uint32_cachecost.has()) {
          ((HwResponse)localObject).cacheCost = localRspDataHighwayHead.uint32_cachecost.get();
        }
        if (localRspDataHighwayHead.uint32_allow_retry.has())
        {
          if (localRspDataHighwayHead.uint32_allow_retry.get() == 1)
          {
            bool1 = true;
            ((HwResponse)localObject).shouldRetry = bool1;
          }
        }
        else
        {
          if (localRspDataHighwayHead.msg_seghead.has())
          {
            paramArrayOfByte = (CSDataHighwayHead.SegHead)localRspDataHighwayHead.msg_seghead.get();
            ((HwResponse)localObject).segmentResp = paramArrayOfByte;
            ((HwResponse)localObject).buzRetCode = paramArrayOfByte.uint32_rtcode.get();
            if ((paramArrayOfByte.uint32_flag.get() & 0x1) != 1) {
              break label590;
            }
            bool1 = bool2;
            ((HwResponse)localObject).isFinish = bool1;
          }
          ((HwResponse)localObject).respLength = j;
          paramList.add(localObject);
          return j;
          bool1 = false;
        }
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        for (;;)
        {
          paramArrayOfByte.printStackTrace();
          paramArrayOfByte = null;
          continue;
          bool1 = false;
          continue;
          label590:
          bool1 = false;
        }
      }
    }
  }
  
  public boolean decodeS2CData(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {}
    do
    {
      return false;
      int i;
      byte[] arrayOfByte;
      if (this.revData != null)
      {
        i = this.revData.length;
        arrayOfByte = new byte[paramArrayOfByte.length + i];
        BdhUtils.copyData(arrayOfByte, 0, this.revData, 0, i);
        BdhUtils.copyData(arrayOfByte, i, paramArrayOfByte, 0, paramArrayOfByte.length);
      }
      for (this.revData = arrayOfByte;; this.revData = paramArrayOfByte)
      {
        paramArrayOfByte = new ArrayList();
        for (;;)
        {
          i = decodePackage(this.revData, paramArrayOfByte);
          if (i <= 0) {
            break;
          }
          arrayOfByte = new byte[this.revData.length - i];
          BdhUtils.copyData(arrayOfByte, 0, this.revData, i, this.revData.length - i);
          this.revData = arrayOfByte;
        }
      }
    } while (paramArrayOfByte.size() <= 0);
    if (this.codecListener != null) {
      this.codecListener.onDecodeSucessfully(paramArrayOfByte);
    }
    return true;
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
    if (paramArrayOfByte != null) {}
    for (int i = paramArrayOfByte.length;; i = 0)
    {
      paramEndPoint = paramEndPoint.toByteArray();
      localObject = new byte[paramEndPoint.length + 10 + i];
      paramHwRequest.bodyLength = i;
      paramHwRequest.headLength = (paramEndPoint.length + 10);
      localObject[0] = 40;
      BdhUtils.DWord2Byte((byte[])localObject, 1, paramEndPoint.length);
      BdhUtils.DWord2Byte((byte[])localObject, 5, i);
      BdhUtils.copyData((byte[])localObject, 9, paramEndPoint, 0, paramEndPoint.length);
      int j = paramEndPoint.length + 9;
      if (i != 0) {
        BdhUtils.copyData((byte[])localObject, j, paramArrayOfByte, 0, i);
      }
      localObject[(localObject.length - 1)] = 41;
      return localObject;
    }
  }
  
  public String getVersionCode()
  {
    if (this.versionCode != null) {
      return this.versionCode;
    }
    this.versionCode = "unkownVersion";
    try
    {
      PackageInfo localPackageInfo = BaseApplication.getContext().getPackageManager().getPackageInfo(BaseApplication.getContext().getPackageName(), 0);
      this.versionCode = (localPackageInfo.versionName + "." + localPackageInfo.versionCode);
      return this.versionCode;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        this.versionCode = "unkownVersion";
        localNameNotFoundException.printStackTrace();
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.codec.TcpProtocolDataCodec
 * JD-Core Version:    0.7.0.1
 */