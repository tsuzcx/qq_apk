package com.tencent.mobileqq.qcircle.api.global;

import android.util.SparseArray;
import com.tencent.biz.richframework.delegate.impl.RFLog;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleEnvHub.ExposeTipsRsp;
import qqcircle.QQCircleEnvHub.GetUserFullEnvRsp;
import qqcircle.QQCircleEnvHub.Tips;

public class QCircleTipsConfig
{
  private static final String TAG = "QCircleTipsConfig";
  private static volatile QCircleTipsConfig sInstance;
  private SparseArray<QQCircleEnvHub.Tips> mTipsSparseArray = new SparseArray();
  
  public static QCircleTipsConfig getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new QCircleTipsConfig();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public byte[] getTipConfig(int paramInt)
  {
    QQCircleEnvHub.Tips localTips = (QQCircleEnvHub.Tips)this.mTipsSparseArray.get(paramInt);
    if (localTips != null) {
      return localTips.toByteArray();
    }
    return null;
  }
  
  public void initTipsConfig(QQCircleEnvHub.GetUserFullEnvRsp paramGetUserFullEnvRsp)
  {
    if (paramGetUserFullEnvRsp == null)
    {
      RFLog.d("QCircleTipsConfig", RFLog.USR, "saveTipsConfig() -> exposeTipsRsp is null");
      return;
    }
    paramGetUserFullEnvRsp = paramGetUserFullEnvRsp.tipsList.get();
    if (paramGetUserFullEnvRsp != null)
    {
      paramGetUserFullEnvRsp = paramGetUserFullEnvRsp.iterator();
      while (paramGetUserFullEnvRsp.hasNext())
      {
        QQCircleEnvHub.Tips localTips = (QQCircleEnvHub.Tips)paramGetUserFullEnvRsp.next();
        this.mTipsSparseArray.put(localTips.id.get(), localTips);
      }
    }
    RFLog.d("QCircleTipsConfig", RFLog.USR, "tipsInfoList is null");
  }
  
  public void updateTipsConfig(byte[] paramArrayOfByte)
  {
    QQCircleEnvHub.ExposeTipsRsp localExposeTipsRsp = new QQCircleEnvHub.ExposeTipsRsp();
    try
    {
      localExposeTipsRsp.mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (QQCircleEnvHub.Tips)localExposeTipsRsp.tips.get();
      if (paramArrayOfByte != null)
      {
        this.mTipsSparseArray.put(paramArrayOfByte.id.get(), paramArrayOfByte);
        return;
      }
      RFLog.d("QCircleTipsConfig", RFLog.USR, "tips is null");
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.global.QCircleTipsConfig
 * JD-Core Version:    0.7.0.1
 */