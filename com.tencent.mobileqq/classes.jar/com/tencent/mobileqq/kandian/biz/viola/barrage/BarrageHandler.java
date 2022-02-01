package com.tencent.mobileqq.kandian.biz.viola.barrage;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xc15.oidb_0xc15.Barrage;
import tencent.im.oidb.cmd0xc15.oidb_0xc15.ReqBody;
import tencent.im.oidb.cmd0xc15.oidb_0xc15.RspBody;
import tencent.im.oidb.cmd0xc15.oidb_0xc15.Sender;

public class BarrageHandler
  extends BusinessHandler
{
  private String a;
  
  public BarrageHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private BarrageInfo.Sender a(oidb_0xc15.Barrage paramBarrage)
  {
    Object localObject2 = null;
    if (paramBarrage == null) {
      return null;
    }
    Object localObject1 = localObject2;
    if (paramBarrage.has())
    {
      localObject1 = localObject2;
      if (paramBarrage.get() != null)
      {
        localObject1 = localObject2;
        if (((oidb_0xc15.Barrage)paramBarrage.get()).rpt_sender.has())
        {
          localObject1 = localObject2;
          if (((oidb_0xc15.Barrage)paramBarrage.get()).rpt_sender.get() != null)
          {
            localObject1 = new BarrageInfo.Sender();
            paramBarrage = (oidb_0xc15.Sender)paramBarrage.rpt_sender.get();
            ((BarrageInfo.Sender)localObject1).b = a(paramBarrage.bytes_sender_name);
            ((BarrageInfo.Sender)localObject1).jdField_a_of_type_JavaLangString = a(paramBarrage.bytes_avatar_url);
            ((BarrageInfo.Sender)localObject1).c = a(paramBarrage.bytes_avatar_icon_url);
            int i = paramBarrage.uint32_is_author.get();
            boolean bool = true;
            if (i != 1) {
              bool = false;
            }
            ((BarrageInfo.Sender)localObject1).jdField_a_of_type_Boolean = bool;
          }
        }
      }
    }
    return localObject1;
  }
  
  private String a(PBBytesField paramPBBytesField)
  {
    if ((paramPBBytesField.has()) && (paramPBBytesField.get() != null)) {
      return paramPBBytesField.get().toStringUtf8();
    }
    return null;
  }
  
  private ArrayList<BarrageInfo> a(oidb_0xc15.RspBody paramRspBody)
  {
    Iterator localIterator = null;
    if (paramRspBody == null) {
      return null;
    }
    Object localObject = localIterator;
    if (paramRspBody.rpt_barrage_list.has())
    {
      localObject = localIterator;
      if (paramRspBody.rpt_barrage_list.get() != null)
      {
        localObject = new ArrayList();
        localIterator = paramRspBody.rpt_barrage_list.get().iterator();
        while (localIterator.hasNext())
        {
          paramRspBody = (oidb_0xc15.Barrage)localIterator.next();
          if ((paramRspBody.has()) && (paramRspBody.get() != null))
          {
            BarrageInfo localBarrageInfo = new BarrageInfo();
            localBarrageInfo.jdField_a_of_type_JavaLangString = a(paramRspBody.bytes_barrage_id);
            if (paramRspBody.uint32_barrage_type.has()) {
              localBarrageInfo.jdField_a_of_type_Int = paramRspBody.uint32_barrage_type.get();
            }
            localBarrageInfo.b = a(paramRspBody.bytes_comment);
            localBarrageInfo.a();
            localBarrageInfo.c = a(paramRspBody.bytes_comment_corner_url);
            localBarrageInfo.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageInfo$Sender = a(paramRspBody);
            localBarrageInfo.b();
            if (localBarrageInfo.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageInfo$Sender != null) {
              paramRspBody = localBarrageInfo.jdField_a_of_type_ComTencentMobileqqKandianBizViolaBarrageBarrageInfo$Sender.b;
            } else {
              paramRspBody = null;
            }
            if (!a(paramRspBody, localBarrageInfo.b))
            {
              ((ArrayList)localObject).add(localBarrageInfo);
            }
            else if (QLog.isColorLevel())
            {
              paramRspBody = new StringBuilder();
              paramRspBody.append("filter barrage info: ");
              paramRspBody.append(localBarrageInfo.toString());
              QLog.d("BarrageHandler", 2, paramRspBody.toString());
            }
          }
        }
      }
    }
    return localObject;
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new oidb_0xc15.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    boolean bool2 = true;
    boolean bool1;
    if (i == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleGetBarrageList: isSuccess=");
      paramFromServiceMsg.append(bool1);
      QLog.d("BarrageHandler", 2, paramFromServiceMsg.toString());
    }
    Bundle localBundle = new Bundle();
    paramToServiceMsg = (String)paramToServiceMsg.getAttribute("value_row_key");
    localBundle.putString("value_row_key", paramToServiceMsg);
    if (!TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramToServiceMsg))
    {
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleGetBarrageList ignore result for rowkey is not equal, mRequestRowkey:");
        paramFromServiceMsg.append(this.jdField_a_of_type_JavaLangString);
        paramFromServiceMsg.append(" rowKey:");
        paramFromServiceMsg.append(paramToServiceMsg);
        QLog.d("BarrageHandler", 2, paramFromServiceMsg.toString());
      }
      return;
    }
    if (bool1) {}
    for (;;)
    {
      try
      {
        paramFromServiceMsg = a(((oidb_0xc15.RspBody)localObject).bytes_cookie);
        paramObject = a(((oidb_0xc15.RspBody)localObject).bytes_common_data);
        localBundle.putString("value_cookie", paramFromServiceMsg);
        localBundle.putString("value_common_data", paramObject);
        i = -1;
        if (((oidb_0xc15.RspBody)localObject).uint32_barrage_time_interval.has())
        {
          i = ((oidb_0xc15.RspBody)localObject).uint32_barrage_time_interval.get();
          localBundle.putInt("value_barrage_time_interval", i);
        }
        ArrayList localArrayList = a((oidb_0xc15.RspBody)localObject);
        localBundle.putParcelableArrayList("value_barrage_list", localArrayList);
        if (((oidb_0xc15.RspBody)localObject).uint32_has_more_data.has())
        {
          if (((oidb_0xc15.RspBody)localObject).uint32_has_more_data.get() != 1) {
            break label498;
          }
          localBundle.putBoolean("value_has_more_data", bool2);
        }
        if (!QLog.isColorLevel()) {
          break label488;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(", barrage_time_interval: ");
        localStringBuilder.append(i);
        localStringBuilder.append(", rowKey: ");
        localStringBuilder.append(paramToServiceMsg);
        localStringBuilder.append(", barrageList:, ");
        localObject = "null";
        if (localArrayList == null) {
          break label504;
        }
        paramToServiceMsg = localArrayList.toString();
        localStringBuilder.append(paramToServiceMsg);
        localStringBuilder.append(", sessionParams: ");
        if (paramObject == null) {
          break label511;
        }
        paramToServiceMsg = paramObject;
        localStringBuilder.append(paramToServiceMsg);
        paramToServiceMsg = (ToServiceMsg)localObject;
        if (paramFromServiceMsg != null) {
          paramToServiceMsg = paramFromServiceMsg;
        }
        localStringBuilder.append(paramToServiceMsg);
        QLog.d("BarrageHandler", 2, localStringBuilder.toString());
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          break label488;
        }
      }
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("解析后台返回的数据出错：");
      paramFromServiceMsg.append(paramToServiceMsg.getMessage());
      QLog.d("BarrageHandler", 2, paramFromServiceMsg.toString());
      break label488;
      if (QLog.isColorLevel()) {
        QLog.d("BarrageHandler", 2, "后台返回的列表为空或者请求结果出错！");
      }
      label488:
      notifyUI(0, bool1, localBundle);
      return;
      label498:
      bool2 = false;
      continue;
      label504:
      paramToServiceMsg = "null";
      continue;
      label511:
      paramToServiceMsg = "null";
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    boolean bool1 = TextUtils.isEmpty(paramString1);
    boolean bool2 = false;
    int i;
    if ((!bool1) && (paramString1.trim().length() > 0)) {
      i = 0;
    } else {
      i = 1;
    }
    int j;
    if ((!TextUtils.isEmpty(paramString2)) && (paramString2.trim().length() > 0)) {
      j = 0;
    } else {
      j = 1;
    }
    bool1 = bool2;
    if (i != 0)
    {
      bool1 = bool2;
      if (j != 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void a(long paramLong, String paramString1, String paramString2, int paramInt1, int paramInt2, BarrageHandler.SessionParams paramSessionParams)
  {
    ThreadManagerV2.executeOnSubThread(new BarrageHandler.1(this, paramLong, paramString1, paramString2, paramInt1, paramSessionParams, paramInt2));
  }
  
  public void a(long paramLong, String paramString1, String paramString2, int paramInt1, BarrageHandler.SessionParams paramSessionParams, int paramInt2)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doFetchBarrageList articleId:");
        ((StringBuilder)localObject).append(paramLong);
        ((StringBuilder)localObject).append(" rowKey:");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(" puin:");
        ((StringBuilder)localObject).append(paramString2);
        QLog.d("BarrageHandler", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_JavaLangString = paramString1;
      Object localObject = new oidb_0xc15.ReqBody();
      ((oidb_0xc15.ReqBody)localObject).uint64_article_id.set(paramLong);
      if (!TextUtils.isEmpty(paramString1)) {
        ((oidb_0xc15.ReqBody)localObject).bytes_rowkey.set(ByteStringMicro.copyFromUtf8(paramString1));
      }
      if (TextUtils.isEmpty(paramString2)) {
        ((oidb_0xc15.ReqBody)localObject).bytes_puin.set(ByteStringMicro.copyFromUtf8(paramString2));
      }
      ((oidb_0xc15.ReqBody)localObject).uint32_want_count.set(paramInt1);
      if (paramSessionParams != null)
      {
        if (!TextUtils.isEmpty(paramSessionParams.jdField_a_of_type_JavaLangString)) {
          ((oidb_0xc15.ReqBody)localObject).bytes_cookie.set(ByteStringMicro.copyFromUtf8(paramSessionParams.jdField_a_of_type_JavaLangString));
        }
        if (!TextUtils.isEmpty(paramSessionParams.b)) {
          ((oidb_0xc15.ReqBody)localObject).bytes_common_data.set(ByteStringMicro.copyFromUtf8(paramSessionParams.b));
        }
      }
      paramString2 = makeOIDBPkg("OidbSvc.0xc15", 3093, paramInt2, ((oidb_0xc15.ReqBody)localObject).toByteArray());
      paramString2.addAttribute("value_row_key", paramString1);
      sendPbReq(paramString2);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("articleId: ");
        paramString2.append(paramLong);
        paramString2.append(", rowKey: ");
        paramString2.append(paramString1);
        paramString2.append(", barrageCounts: ");
        paramString2.append(paramInt1);
        paramString2.append(", serviceType: ");
        paramString2.append(paramInt2);
        paramString1 = new StringBuilder();
        paramString1.append("3ba package msg: ");
        paramString1.append(paramString2.toString());
        QLog.d("BarrageHandler", 2, paramString1.toString());
        return;
      }
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("make 3ba package error!!, ");
        paramString2.append(paramString1.getMessage());
        QLog.d("BarrageHandler", 2, paramString2.toString());
      }
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2, BarrageHandler.SessionParams paramSessionParams)
  {
    a(paramLong, paramString1, paramString2, 0, 0, paramSessionParams);
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return BarrageHandler.BarrageObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.barrage.BarrageHandler
 * JD-Core Version:    0.7.0.1
 */