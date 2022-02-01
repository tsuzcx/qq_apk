package com.tencent.mobileqq.filemanageraux.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.weiyun.api.IWeiyunCallback;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.CrossBidProxyOfflineFileGetListMsgRsp;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB.OfflineFileInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class WeiYunLogicCenter$2
  implements IWeiyunCallback<WeiyunPB.CrossBidProxyOfflineFileGetListMsgRsp>
{
  public void a(int paramInt, String paramString, WeiyunPB.CrossBidProxyOfflineFileGetListMsgRsp paramCrossBidProxyOfflineFileGetListMsgRsp)
  {
    if (QLog.isColorLevel())
    {
      paramCrossBidProxyOfflineFileGetListMsgRsp = new StringBuilder();
      paramCrossBidProxyOfflineFileGetListMsgRsp.append("queryOfflineFileList onFailed: errcode[");
      paramCrossBidProxyOfflineFileGetListMsgRsp.append(paramInt);
      paramCrossBidProxyOfflineFileGetListMsgRsp.append("], errmsg[");
      paramCrossBidProxyOfflineFileGetListMsgRsp.append(paramString);
      paramCrossBidProxyOfflineFileGetListMsgRsp.append("]");
      QLog.i("WeiYunLogicCenter<FileAssistant>", 2, paramCrossBidProxyOfflineFileGetListMsgRsp.toString());
    }
    WeiYunLogicCenter.c(this.b).getFileManagerNotifyCenter().a(false, 32, new Object[] { Integer.valueOf(paramInt), paramString });
  }
  
  public void a(WeiyunPB.CrossBidProxyOfflineFileGetListMsgRsp paramCrossBidProxyOfflineFileGetListMsgRsp)
  {
    int i = this.a;
    if ((i != 0) && (i != 2)) {
      i = 0;
    } else {
      i = paramCrossBidProxyOfflineFileGetListMsgRsp.rpt_msg_recv_offline_file.size() + 0;
    }
    int k = this.a;
    int j;
    if (k != 1)
    {
      j = i;
      if (k != 2) {}
    }
    else
    {
      j = i + paramCrossBidProxyOfflineFileGetListMsgRsp.rpt_msg_send_offline_file.size();
    }
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("queryOfflineFileList onSucceed, num[");
      ((StringBuilder)localObject1).append(j);
      ((StringBuilder)localObject1).append("]");
      QLog.d("WeiYunLogicCenter<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
    }
    ArrayList localArrayList = new ArrayList();
    i = this.a;
    Object localObject2;
    OfflineFileInfo localOfflineFileInfo;
    if ((i == 0) || (i == 2))
    {
      localObject1 = paramCrossBidProxyOfflineFileGetListMsgRsp.rpt_msg_recv_offline_file.get().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WeiyunPB.OfflineFileInfo)((Iterator)localObject1).next();
        localOfflineFileInfo = new OfflineFileInfo();
        localOfflineFileInfo.a = false;
        localOfflineFileInfo.e = ((WeiyunPB.OfflineFileInfo)localObject2).uint32_danger_evel.get();
        localOfflineFileInfo.g = ((WeiyunPB.OfflineFileInfo)localObject2).uint64_file_size.get();
        localOfflineFileInfo.h = (MessageCache.c() * 1000L + ((WeiyunPB.OfflineFileInfo)localObject2).uint32_life_time.get() * 1000L);
        localOfflineFileInfo.i = (((WeiyunPB.OfflineFileInfo)localObject2).uint32_upload_time.get() * 1000L);
        localOfflineFileInfo.f = ((WeiyunPB.OfflineFileInfo)localObject2).str_file_name.get();
        localOfflineFileInfo.b = new String(((WeiyunPB.OfflineFileInfo)localObject2).bytes_uuid.get().toByteArray());
        localOfflineFileInfo.d = ((WeiyunPB.OfflineFileInfo)localObject2).uint64_uin.get();
        localArrayList.add(localOfflineFileInfo);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("OfflineFileInfo[");
          ((StringBuilder)localObject2).append(localOfflineFileInfo.toString());
          ((StringBuilder)localObject2).append("]");
          QLog.d("WeiYunLogicCenter<FileAssistant>", 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
    i = this.a;
    if ((i == 1) || (i == 2))
    {
      localObject1 = paramCrossBidProxyOfflineFileGetListMsgRsp.rpt_msg_send_offline_file.get().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WeiyunPB.OfflineFileInfo)((Iterator)localObject1).next();
        localOfflineFileInfo = new OfflineFileInfo();
        localOfflineFileInfo.a = true;
        localOfflineFileInfo.e = ((WeiyunPB.OfflineFileInfo)localObject2).uint32_danger_evel.get();
        localOfflineFileInfo.g = ((WeiyunPB.OfflineFileInfo)localObject2).uint64_file_size.get();
        localOfflineFileInfo.h = (MessageCache.c() * 1000L + ((WeiyunPB.OfflineFileInfo)localObject2).uint32_life_time.get() * 1000L);
        localOfflineFileInfo.i = (((WeiyunPB.OfflineFileInfo)localObject2).uint32_upload_time.get() * 1000L);
        localOfflineFileInfo.f = ((WeiyunPB.OfflineFileInfo)localObject2).str_file_name.get();
        localOfflineFileInfo.b = new String(((WeiyunPB.OfflineFileInfo)localObject2).bytes_uuid.get().toByteArray());
        localOfflineFileInfo.d = ((WeiyunPB.OfflineFileInfo)localObject2).uint64_uin.get();
        localArrayList.add(localOfflineFileInfo);
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("OfflineFileInfo[");
          ((StringBuilder)localObject2).append(localOfflineFileInfo.toString());
          ((StringBuilder)localObject2).append("]");
          QLog.d("WeiYunLogicCenter<FileAssistant>", 2, ((StringBuilder)localObject2).toString());
        }
      }
    }
    i = this.a;
    if (i == 0) {
      if (paramCrossBidProxyOfflineFileGetListMsgRsp.uint32_recv_list_end.get() != 1) {}
    }
    boolean bool;
    for (;;)
    {
      bool = true;
      break;
      do
      {
        do
        {
          bool = false;
          break label700;
          if (i != 1) {
            break;
          }
        } while (paramCrossBidProxyOfflineFileGetListMsgRsp.uint32_send_list_end.get() != 1);
        break;
      } while ((paramCrossBidProxyOfflineFileGetListMsgRsp.uint32_recv_list_end.get() != 1) || (paramCrossBidProxyOfflineFileGetListMsgRsp.uint32_send_list_end.get() != 1));
    }
    label700:
    WeiYunLogicCenter.c(this.b).getFileManagerNotifyCenter().a(true, 32, new Object[] { Boolean.valueOf(bool), localArrayList });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanageraux.core.WeiYunLogicCenter.2
 * JD-Core Version:    0.7.0.1
 */