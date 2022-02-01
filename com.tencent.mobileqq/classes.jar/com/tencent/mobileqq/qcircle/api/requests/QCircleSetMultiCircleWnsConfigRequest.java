package com.tencent.mobileqq.qcircle.api.requests;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import qqcircle.QQCircleSwitch.SetMultiCircleSwitchReq;
import qqcircle.QQCircleSwitch.SetMultiCircleSwitchRsp;
import qqcircle.QQCircleSwitch.StSwitch;

public class QCircleSetMultiCircleWnsConfigRequest
  extends QCircleBaseRequest
{
  private QQCircleSwitch.SetMultiCircleSwitchReq mReq = new QQCircleSwitch.SetMultiCircleSwitchReq();
  
  public QCircleSetMultiCircleWnsConfigRequest(HashMap<String, HashMap<String, String>> paramHashMap)
  {
    try
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Object localObject1 = (Map.Entry)paramHashMap.next();
        String str1 = (String)((Map.Entry)localObject1).getKey();
        if (!TextUtils.isEmpty(str1))
        {
          localObject1 = (HashMap)((Map.Entry)localObject1).getValue();
          if ((localObject1 != null) && (!((HashMap)localObject1).isEmpty()))
          {
            localObject1 = ((HashMap)localObject1).entrySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
              if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)((Map.Entry)localObject2).getKey())) && (!TextUtils.isEmpty((CharSequence)((Map.Entry)localObject2).getValue())))
              {
                String str2 = (String)((Map.Entry)localObject2).getKey();
                localObject2 = (String)((Map.Entry)localObject2).getValue();
                QQCircleSwitch.StSwitch localStSwitch = new QQCircleSwitch.StSwitch();
                PBStringField localPBStringField = localStSwitch.key;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append(str1);
                localStringBuilder.append(".");
                localStringBuilder.append(str2);
                localPBStringField.set(localStringBuilder.toString());
                localStSwitch.value.set((String)localObject2);
                this.mReq.sws.add(localStSwitch);
              }
            }
          }
        }
      }
      return;
    }
    catch (Exception paramHashMap)
    {
      paramHashMap.printStackTrace();
    }
  }
  
  public MessageMicro decode(byte[] paramArrayOfByte)
  {
    QQCircleSwitch.SetMultiCircleSwitchRsp localSetMultiCircleSwitchRsp = new QQCircleSwitch.SetMultiCircleSwitchRsp();
    try
    {
      localSetMultiCircleSwitchRsp.mergeFrom(paramArrayOfByte);
      return localSetMultiCircleSwitchRsp;
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return localSetMultiCircleSwitchRsp;
  }
  
  public String getCmdName()
  {
    return "FeedCloudSvr.trpc.videocircle.circleswitch.CircleSwitch.SetMultiCircleSwitch";
  }
  
  protected byte[] getRequestByteData()
  {
    return this.mReq.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.requests.QCircleSetMultiCircleWnsConfigRequest
 * JD-Core Version:    0.7.0.1
 */