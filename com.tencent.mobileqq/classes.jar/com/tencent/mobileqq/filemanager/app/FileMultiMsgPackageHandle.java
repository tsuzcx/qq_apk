package com.tencent.mobileqq.filemanager.app;

import android.text.TextUtils;
import com.tencent.component.network.utils.Base64;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TroopFileData;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.QFileUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.troop.data.TroopFileStatusInfo;
import com.tencent.mobileqq.troop.utils.TroopFileDataManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm.GroupInfo;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.GroupFile;
import tencent.im.msg.im_msg_body.MsgBody;
import tencent.im.msg.im_msg_body.NotOnlineFile;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.TransElem;
import tencent.im.msg.obj_msg.MsgContentInfo;
import tencent.im.msg.obj_msg.MsgContentInfo.MsgFile;
import tencent.im.msg.obj_msg.ObjMsg;
import tencent.im.msg.resv21.hummer_resv_21.FileImgInfo;
import tencent.im.msg.resv21.hummer_resv_21.ForwardExtFileInfo;
import tencent.im.msg.resv21.hummer_resv_21.ResvAttr;
import tencent.im.s2c.msgtype0x211.submsgtype0x4.SubMsgType0x4.MsgBody;

public class FileMultiMsgPackageHandle
{
  QQAppInterface a;
  
  public FileMultiMsgPackageHandle(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, paramString2);
    }
  }
  
  private boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    return !TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileType"));
  }
  
  private boolean a(hummer_resv_21.ResvAttr paramResvAttr)
  {
    if (paramResvAttr == null) {
      return false;
    }
    return paramResvAttr.forward_ext_file_info.has();
  }
  
  public TroopFileStatusInfo a(MessageForTroopFile paramMessageForTroopFile)
  {
    return TroopFileUtils.a(this.a, paramMessageForTroopFile);
  }
  
  public TroopFileDataManager a(long paramLong)
  {
    return TroopFileDataManager.a(paramLong);
  }
  
  public im_msg_body.MsgBody a(int paramInt, MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null)
    {
      QLog.e("FileMultiMsgPackageHandle<QFile>", 1, "getMultiMsgBody : message is null");
      return null;
    }
    Object localObject;
    if (paramInt == 1)
    {
      localObject = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileType");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("process type:");
      localStringBuilder.append((String)localObject);
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, localStringBuilder.toString());
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        QLog.e("FileMultiMsgPackageHandle<QFile>", 1, "getMultiMsgBody : message extInfo type null");
        return null;
      }
    }
    paramInt = paramMessageRecord.istroop;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3000)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("attention, this is a default way to handle, peerType[");
          ((StringBuilder)localObject).append(paramMessageRecord.istroop);
          ((StringBuilder)localObject).append("] ");
          ((StringBuilder)localObject).append(QFileUtils.a(this.a, paramMessageRecord));
          QLog.i("FileMultiMsgPackageHandle<QFile>", 1, ((StringBuilder)localObject).toString());
          return c(paramMessageRecord);
        }
        return b(paramMessageRecord);
      }
      return a(paramMessageRecord);
    }
    return c(paramMessageRecord);
  }
  
  public im_msg_body.MsgBody a(MessageRecord paramMessageRecord)
  {
    im_msg_body.MsgBody localMsgBody = new im_msg_body.MsgBody();
    Object localObject1 = new obj_msg.ObjMsg();
    Object localObject2 = new obj_msg.MsgContentInfo();
    Object localObject3 = new obj_msg.MsgContentInfo.MsgFile();
    Object localObject4;
    int i;
    long l;
    Object localObject6;
    int j;
    Object localObject5;
    if (a(paramMessageRecord))
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("handleTroopFileMessage: package multi troop file message. ");
      ((StringBuilder)localObject4).append(QFileUtils.a(this.a, paramMessageRecord));
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, ((StringBuilder)localObject4).toString());
      localObject4 = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
      ((obj_msg.MsgContentInfo.MsgFile)localObject3).bytes_file_path.set(ByteStringMicro.copyFrom(((String)localObject4).getBytes()));
      localObject4 = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardBusType");
      if (!TextUtils.isEmpty((CharSequence)localObject4))
      {
        i = Integer.parseInt((String)localObject4);
        ((obj_msg.MsgContentInfo.MsgFile)localObject3).uint32_bus_id.set(i);
      }
      localObject4 = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
      ((obj_msg.MsgContentInfo.MsgFile)localObject3).str_file_name.set((String)localObject4);
      l = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
      ((obj_msg.MsgContentInfo.MsgFile)localObject3).uint64_file_size.set(l);
      String str = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardDeadTime");
      if (!TextUtils.isEmpty(str))
      {
        l = Long.parseLong(str);
        ((obj_msg.MsgContentInfo.MsgFile)localObject3).int64_dead_time.set(l);
      }
      str = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSha");
      if (str != null) {
        ((obj_msg.MsgContentInfo.MsgFile)localObject3).bytes_file_sha1.set(ByteStringMicro.copyFrom(str.getBytes()));
      }
      str = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
      if (str != null) {
        ((obj_msg.MsgContentInfo.MsgFile)localObject3).bytes_file_md5.set(ByteStringMicro.copyFrom(str.getBytes()));
      }
      localObject6 = new StringBuilder();
      ((StringBuilder)localObject6).append("handleTroopFileMessage fileMd5 is ");
      ((StringBuilder)localObject6).append(str);
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, ((StringBuilder)localObject6).toString());
      i = FileManagerUtil.a((String)localObject4);
      localObject4 = new JSONObject();
      if ((i == 0) || (i == 2))
      {
        try
        {
          i = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth"));
          j = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight"));
          ((JSONObject)localObject4).put("width", i);
          ((JSONObject)localObject4).put("height", j);
        }
        catch (JSONException paramMessageRecord)
        {
          break label435;
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          localNumberFormatException1.printStackTrace();
        }
        localObject5 = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardDuration");
        if (!TextUtils.isEmpty((CharSequence)localObject5)) {
          ((JSONObject)localObject4).put("duration", Integer.parseInt((String)localObject5));
        }
      }
      ((JSONObject)localObject4).put("ExtInfo", Base64.encodeToString(a(paramMessageRecord).toByteArray(), 2));
      break label439;
      label435:
      paramMessageRecord.printStackTrace();
      label439:
      ((obj_msg.MsgContentInfo.MsgFile)localObject3).bytes_ext.set(ByteStringMicro.copyFrom(((JSONObject)localObject4).toString().getBytes()));
    }
    else
    {
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("handleTroopFileMessage: package normal troop file message. ");
      ((StringBuilder)localObject4).append(QFileUtils.a(this.a, paramMessageRecord));
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, ((StringBuilder)localObject4).toString());
      localObject4 = (MessageForTroopFile)paramMessageRecord;
      localObject5 = a((MessageForTroopFile)localObject4);
      if (localObject5 != null)
      {
        localObject6 = ((TroopFileStatusInfo)localObject5).e;
        if (!TextUtils.isEmpty((CharSequence)localObject6))
        {
          ((obj_msg.MsgContentInfo.MsgFile)localObject3).bytes_file_path.set(ByteStringMicro.copyFrom(((String)localObject6).getBytes()));
          if (QLog.isDebugVersion())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("handleTroopFileMessage: get troop fileId[");
            localStringBuilder.append((String)localObject6);
            localStringBuilder.append("] ");
            localStringBuilder.append(QFileUtils.a(this.a, paramMessageRecord));
            QLog.i("FileMultiMsgPackageHandle<QFile>", 1, localStringBuilder.toString());
          }
        }
        else
        {
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("handleTroopFileMessage: error, can not get troop fileId. ");
          ((StringBuilder)localObject6).append(QFileUtils.a(this.a, paramMessageRecord));
          QLog.i("FileMultiMsgPackageHandle<QFile>", 1, ((StringBuilder)localObject6).toString());
        }
        ((obj_msg.MsgContentInfo.MsgFile)localObject3).uint32_bus_id.set(((TroopFileStatusInfo)localObject5).h);
        localObject6 = ((TroopFileStatusInfo)localObject5).g;
        ((obj_msg.MsgContentInfo.MsgFile)localObject3).str_file_name.set((String)localObject6);
        l = ((TroopFileStatusInfo)localObject5).c;
        ((obj_msg.MsgContentInfo.MsgFile)localObject3).uint64_file_size.set(l);
        l = ((MessageForTroopFile)localObject4).lastTime;
        ((obj_msg.MsgContentInfo.MsgFile)localObject3).int64_dead_time.set(l);
        localObject5 = ((TroopFileStatusInfo)localObject5).f;
        if (!TextUtils.isEmpty((CharSequence)localObject5))
        {
          ((obj_msg.MsgContentInfo.MsgFile)localObject3).bytes_file_sha1.set(ByteStringMicro.copyFrom(((String)localObject5).getBytes()));
        }
        else if (QLog.isDebugVersion())
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("handleTroopFileMessage: error, can not get sha. ");
          ((StringBuilder)localObject5).append(QFileUtils.a(this.a, paramMessageRecord));
          QLog.i("FileMultiMsgPackageHandle<QFile>", 1, ((StringBuilder)localObject5).toString());
        }
        i = FileManagerUtil.a((String)localObject6);
        paramMessageRecord = new JSONObject();
        if ((i == 0) || (i == 2))
        {
          try
          {
            i = ((MessageForTroopFile)localObject4).width;
            j = ((MessageForTroopFile)localObject4).height;
            paramMessageRecord.put("width", i);
            paramMessageRecord.put("height", j);
          }
          catch (JSONException localJSONException)
          {
            break label893;
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            localNumberFormatException2.printStackTrace();
          }
          paramMessageRecord.put("duration", localJSONException.duration);
          break label898;
          label893:
          localJSONException.printStackTrace();
        }
        label898:
        ((obj_msg.MsgContentInfo.MsgFile)localObject3).bytes_ext.set(ByteStringMicro.copyFrom(paramMessageRecord.toString().getBytes()));
      }
    }
    ((obj_msg.MsgContentInfo)localObject2).msg_file.set((MessageMicro)localObject3);
    ((obj_msg.ObjMsg)localObject1).uint32_msg_type.set(6);
    ((obj_msg.ObjMsg)localObject1).msg_content_info.add((MessageMicro)localObject2);
    paramMessageRecord = new im_msg_body.TransElem();
    localObject1 = ((obj_msg.ObjMsg)localObject1).toByteArray();
    paramMessageRecord.elem_type.set(24);
    localObject2 = ByteBuffer.allocate(2);
    ((ByteBuffer)localObject2).putShort((short)localObject1.length);
    localObject3 = new byte[localObject1.length + 3];
    localObject3[0] = 1;
    System.arraycopy(((ByteBuffer)localObject2).array(), 0, localObject3, 1, 2);
    System.arraycopy(localObject1, 0, localObject3, 3, localObject1.length);
    paramMessageRecord.elem_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
    localObject1 = new im_msg_body.Elem();
    ((im_msg_body.Elem)localObject1).trans_elem_info.set(paramMessageRecord);
    paramMessageRecord = new im_msg_body.RichText();
    paramMessageRecord.elems.add((MessageMicro)localObject1);
    localMsgBody.rich_text.set(paramMessageRecord);
    return localMsgBody;
  }
  
  public hummer_resv_21.ResvAttr a(MessageRecord paramMessageRecord)
  {
    hummer_resv_21.ResvAttr localResvAttr = new hummer_resv_21.ResvAttr();
    hummer_resv_21.ForwardExtFileInfo localForwardExtFileInfo = new hummer_resv_21.ForwardExtFileInfo();
    int i = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileType"));
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleFrowardExtFileInfo fileType:");
      ((StringBuilder)localObject).append(i);
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, ((StringBuilder)localObject).toString());
    }
    localForwardExtFileInfo.uint32_file_type.set(i);
    long l = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSenderUin"));
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleFrowardExtFileInfo sendUin:");
      ((StringBuilder)localObject).append(l);
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, ((StringBuilder)localObject).toString());
    }
    localForwardExtFileInfo.uint64_sender_uin.set(l);
    l = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardReceiverUin"));
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleFrowardExtFileInfo recvUin:");
      ((StringBuilder)localObject).append(l);
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, ((StringBuilder)localObject).toString());
    }
    localForwardExtFileInfo.uint64_receiver_uin.set(l);
    Object localObject = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
    StringBuilder localStringBuilder;
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleFrowardExtFileInfo fileUuid:");
      localStringBuilder.append((String)localObject);
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, localStringBuilder.toString());
    }
    localForwardExtFileInfo.bytes_file_uuid.set(ByteStringMicro.copyFrom(((String)localObject).getBytes()));
    localObject = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileIdCrc");
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleFrowardExtFileInfo fileIdCrc:");
      localStringBuilder.append((String)localObject);
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, localStringBuilder.toString());
    }
    localForwardExtFileInfo.str_fileidcrc.set((String)localObject);
    localObject = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleFrowardExtFileInfo fileName:");
      localStringBuilder.append((String)localObject);
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, localStringBuilder.toString());
    }
    localForwardExtFileInfo.str_file_name.set((String)localObject);
    l = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleFrowardExtFileInfo fileSize:");
      ((StringBuilder)localObject).append(l);
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, ((StringBuilder)localObject).toString());
    }
    localForwardExtFileInfo.uint64_file_size.set(l);
    localObject = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSha");
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleFrowardExtFileInfo strSHA1:");
      localStringBuilder.append((String)localObject);
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, localStringBuilder.toString());
    }
    localForwardExtFileInfo.bytes_file_sha1.set(ByteStringMicro.copyFrom(((String)localObject).getBytes()));
    localObject = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
    if (QLog.isDevelopLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleFrowardExtFileInfo fileMd5:");
      localStringBuilder.append((String)localObject);
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, localStringBuilder.toString());
    }
    localForwardExtFileInfo.bytes_file_md5.set(ByteStringMicro.copyFrom(((String)localObject).getBytes()));
    localObject = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardDeadTime");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      l = Long.parseLong((String)localObject);
      if (QLog.isDevelopLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleFrowardExtFileInfo deadTime:");
        localStringBuilder.append((String)localObject);
        QLog.i("FileMultiMsgPackageHandle<QFile>", 1, localStringBuilder.toString());
      }
      localForwardExtFileInfo.int64_dead_time.set(l);
    }
    localObject = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      i = Integer.parseInt((String)localObject);
      if (QLog.isDevelopLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleFrowardExtFileInfo imgWidth:");
        localStringBuilder.append((String)localObject);
        QLog.i("FileMultiMsgPackageHandle<QFile>", 1, localStringBuilder.toString());
      }
      localForwardExtFileInfo.uint32_img_width.set(i);
    }
    localObject = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      i = Integer.parseInt((String)localObject);
      if (QLog.isDevelopLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleFrowardExtFileInfo imgWidth:");
        localStringBuilder.append((String)localObject);
        QLog.i("FileMultiMsgPackageHandle<QFile>", 1, localStringBuilder.toString());
      }
      localForwardExtFileInfo.uint32_img_height.set(i);
    }
    localObject = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardDuration");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      l = Long.parseLong((String)localObject);
      if (QLog.isDevelopLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleFrowardExtFileInfo videoDur:");
        localStringBuilder.append((String)localObject);
        QLog.i("FileMultiMsgPackageHandle<QFile>", 1, localStringBuilder.toString());
      }
      localForwardExtFileInfo.uint64_video_duration.set(l);
    }
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardBusType");
    if (!TextUtils.isEmpty(paramMessageRecord))
    {
      i = Integer.parseInt(paramMessageRecord);
      if (QLog.isDevelopLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleFrowardExtFileInfo bizId:");
        ((StringBuilder)localObject).append(paramMessageRecord);
        QLog.i("FileMultiMsgPackageHandle<QFile>", 1, ((StringBuilder)localObject).toString());
      }
      localForwardExtFileInfo.uint32_bus_id.set(i);
    }
    localResvAttr.forward_ext_file_info.set(localForwardExtFileInfo);
    return localResvAttr;
  }
  
  public void a(ArrayList<MessageRecord> paramArrayList, ByteStringMicro paramByteStringMicro)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("decodeBuddyFilePBMsg: startTime[");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      ((StringBuilder)localObject1).append("]");
      QLog.i("FileMultiMsgPackageHandle<QFile>", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = MessageRecordFactory.a(-2005);
    Object localObject2 = new SubMsgType0x4.MsgBody();
    try
    {
      paramByteStringMicro = (SubMsgType0x4.MsgBody)((SubMsgType0x4.MsgBody)localObject2).mergeFrom(paramByteStringMicro.toByteArray());
      localObject2 = (hummer_resv_21.ResvAttr)paramByteStringMicro.resv_attr.get();
      if (a((hummer_resv_21.ResvAttr)localObject2))
      {
        paramByteStringMicro = new StringBuilder();
        paramByteStringMicro.append("decodeBuddyFilePBMsg: decode multi buddy file message. ");
        paramByteStringMicro.append(QFileUtils.a(this.a, (MessageRecord)localObject1, false));
        QLog.i("FileMultiMsgPackageHandle<QFile>", 1, paramByteStringMicro.toString());
        if (a((hummer_resv_21.ResvAttr)localObject2, (MessageRecord)localObject1))
        {
          ((MessageRecord)localObject1).isMultiMsg = true;
          paramArrayList.add(localObject1);
        }
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("decodeBuddyFilePBMsg: decode normal buddy file message. ");
        ((StringBuilder)localObject2).append(QFileUtils.a(this.a, (MessageRecord)localObject1, false));
        QLog.i("FileMultiMsgPackageHandle<QFile>", 1, ((StringBuilder)localObject2).toString());
        if (!paramByteStringMicro.msg_not_online_file.has()) {
          return;
        }
        localObject2 = (im_msg_body.NotOnlineFile)paramByteStringMicro.msg_not_online_file.get();
        Object localObject3;
        StringBuilder localStringBuilder;
        if (((im_msg_body.NotOnlineFile)localObject2).bytes_file_name.has())
        {
          localObject3 = ((im_msg_body.NotOnlineFile)localObject2).bytes_file_name.get().toStringUtf8();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("decodeBuddyFilePBMsg: decode normal buddy fileName[");
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append("]");
          QLog.i("FileMultiMsgPackageHandle<QFile>", 1, localStringBuilder.toString());
          ((MessageRecord)localObject1).saveExtInfoToExtStr("_backup_ForwardFileName", (String)localObject3);
        }
        else
        {
          QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeBuddyFilePBMsg: decode normal buddy fileName is null");
        }
        int i;
        if (((im_msg_body.NotOnlineFile)localObject2).uint32_file_type.has())
        {
          i = ((im_msg_body.NotOnlineFile)localObject2).uint32_file_type.get();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("decodeBuddyFilePBMsg: decode normal buddy fileType[");
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append("]");
          QLog.i("FileMultiMsgPackageHandle<QFile>", 1, ((StringBuilder)localObject3).toString());
          ((MessageRecord)localObject1).saveExtInfoToExtStr("_backup_ForwardFileType", String.valueOf(i));
        }
        else
        {
          QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeBuddyFilePBMsg: decode normal buddy fileType is null");
        }
        if (((im_msg_body.NotOnlineFile)localObject2).bytes_file_md5.has()) {
          ((MessageRecord)localObject1).saveExtInfoToExtStr("_backup_ForwardMd5", FileHttpUtils.a(((im_msg_body.NotOnlineFile)localObject2).bytes_file_md5.get().toByteArray()));
        }
        if (((im_msg_body.NotOnlineFile)localObject2).bytes_file_uuid.has())
        {
          localObject3 = ((im_msg_body.NotOnlineFile)localObject2).bytes_file_uuid.get().toStringUtf8();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("decodeBuddyFilePBMsg: decode normal buddy uuid[");
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append("]");
          QLog.i("FileMultiMsgPackageHandle<QFile>", 1, localStringBuilder.toString());
          ((MessageRecord)localObject1).saveExtInfoToExtStr("_backup_ForwardUuid", (String)localObject3);
        }
        else
        {
          QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeBuddyFilePBMsg: decode normal buddy uuid is null");
        }
        if (((im_msg_body.NotOnlineFile)localObject2).uint64_file_size.has()) {
          ((MessageRecord)localObject1).saveExtInfoToExtStr("_backup_ForwardSize", String.valueOf(((im_msg_body.NotOnlineFile)localObject2).uint64_file_size.get()));
        }
        if (paramByteStringMicro.file_image_info.has())
        {
          paramByteStringMicro = (hummer_resv_21.FileImgInfo)paramByteStringMicro.file_image_info.get();
          if (paramByteStringMicro.uint32_file_width.has())
          {
            i = paramByteStringMicro.uint32_file_width.get();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(i);
            ((StringBuilder)localObject2).append("");
            ((MessageRecord)localObject1).saveExtInfoToExtStr("_backup_ForwardImgWidth", ((StringBuilder)localObject2).toString());
          }
          if (paramByteStringMicro.uint32_file_height.has())
          {
            i = paramByteStringMicro.uint32_file_height.get();
            paramByteStringMicro = new StringBuilder();
            paramByteStringMicro.append(i);
            paramByteStringMicro.append("");
            ((MessageRecord)localObject1).saveExtInfoToExtStr("_backup_ForwardImgHeight", paramByteStringMicro.toString());
          }
        }
        paramArrayList.add(localObject1);
        if (QLog.isColorLevel())
        {
          paramArrayList = new StringBuilder();
          paramArrayList.append("decodeBuddyFilePBMsg: endTime[");
          paramArrayList.append(System.currentTimeMillis());
          paramArrayList.append("]");
          QLog.i("FileMultiMsgPackageHandle<QFile>", 2, paramArrayList.toString());
        }
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramArrayList)
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileMultiMsgPackageHandle<QFile>", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x4] failed", paramArrayList);
      }
    }
  }
  
  public boolean a(ArrayList<MessageRecord> paramArrayList, msg_comm.Msg paramMsg)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("decodeGroupFilePb: startTime[");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      ((StringBuilder)localObject1).append("]");
      QLog.i("FileMultiMsgPackageHandle<QFile>", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramMsg == null)
    {
      QLog.e("FileMultiMsgPackageHandle<QFile>", 2, "<FileAssistant>decodeGroupFilePb : msg is null");
      return false;
    }
    if (!paramMsg.msg_body.has())
    {
      QLog.e("FileMultiMsgPackageHandle<QFile>", 2, "<FileAssistant>decodeGroupFilePb : msg has not body");
      return false;
    }
    Object localObject1 = (im_msg_body.MsgBody)paramMsg.msg_body.get();
    if (!((im_msg_body.MsgBody)localObject1).rich_text.has())
    {
      QLog.e("FileMultiMsgPackageHandle<QFile>", 2, "<FileAssistant>decodeGroupFilePb : rich_text has not body");
      return false;
    }
    localObject1 = (im_msg_body.RichText)((im_msg_body.MsgBody)localObject1).rich_text.get();
    if (!((im_msg_body.RichText)localObject1).elems.has())
    {
      QLog.e("FileMultiMsgPackageHandle<QFile>", 2, "<FileAssistant>decodeGroupFilePb : rich_text has not elems");
      return false;
    }
    Iterator localIterator = ((im_msg_body.RichText)localObject1).elems.get().iterator();
    bool1 = false;
    while (localIterator.hasNext())
    {
      localObject1 = (im_msg_body.Elem)localIterator.next();
      bool2 = bool1;
      if (((im_msg_body.Elem)localObject1).trans_elem_info.has())
      {
        if (!((im_msg_body.Elem)localObject1).trans_elem_info.has())
        {
          QLog.e("FileMultiMsgPackageHandle<QFile>", 2, "<FileAssistant>decodeGroupFilePb : elem has not trans_elem_info");
        }
        else
        {
          localObject1 = (im_msg_body.TransElem)((im_msg_body.Elem)localObject1).trans_elem_info.get();
          int i = ((im_msg_body.TransElem)localObject1).elem_type.get();
          if (i != 24)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("<FileAssistant>decodeGroupFilePb : trans_elem_info type:");
            ((StringBuilder)localObject1).append(i);
            QLog.e("FileMultiMsgPackageHandle<QFile>", 2, ((StringBuilder)localObject1).toString());
          }
          else
          {
            i = ((im_msg_body.TransElem)localObject1).elem_value.get().size();
            byte[] arrayOfByte = ((im_msg_body.TransElem)localObject1).elem_value.get().toByteArray();
            int k = 0;
            int j = 0;
            while ((i > 3) && (j <= 100))
            {
              int i1 = arrayOfByte[k];
              int i2 = PkgTools.getShortData(arrayOfByte, k + 1);
              int n = i2 + 3;
              int m = i - n;
              Object localObject3;
              if (i1 != 1)
              {
                bool2 = bool1;
              }
              else
              {
                localObject1 = new byte[i2];
                PkgTools.copyData((byte[])localObject1, 0, arrayOfByte, k + 3, i2);
                localObject3 = new obj_msg.ObjMsg();
              }
              try
              {
                localObject3 = (obj_msg.ObjMsg)((obj_msg.ObjMsg)localObject3).mergeFrom((byte[])localObject1);
                Object localObject4;
                if (((obj_msg.MsgContentInfo)((obj_msg.ObjMsg)localObject3).msg_content_info.get(0)).msg_file.bytes_ext.has())
                {
                  localObject1 = ((obj_msg.MsgContentInfo)((obj_msg.ObjMsg)localObject3).msg_content_info.get(0)).msg_file.bytes_ext.get().toStringUtf8();
                  try
                  {
                    localObject4 = Base64.decode(new JSONObject((String)localObject1).optString("ExtInfo"), 0);
                    localObject1 = new hummer_resv_21.ResvAttr();
                    ((hummer_resv_21.ResvAttr)localObject1).mergeFrom((byte[])localObject4);
                    localObject4 = (MessageForTroopFile)MessageRecordFactory.a(-2017);
                    if (a((hummer_resv_21.ResvAttr)localObject1, (MessageRecord)localObject4))
                    {
                      paramArrayList.add(localObject4);
                      try
                      {
                        ((MessageForTroopFile)localObject4).isMultiMsg = true;
                        i = 1;
                      }
                      catch (Exception localException1)
                      {
                        break label575;
                      }
                    }
                    else
                    {
                      i = 0;
                    }
                    bool1 = true;
                  }
                  catch (Exception localException2)
                  {
                    label575:
                    localException2.printStackTrace();
                  }
                }
                else
                {
                  i = 0;
                }
                bool2 = bool1;
                if (i == 0)
                {
                  Object localObject2 = TroopFileUtils.a((obj_msg.ObjMsg)localObject3);
                  if (localObject2 == null)
                  {
                    bool2 = bool1;
                  }
                  else
                  {
                    localObject4 = a(paramMsg.msg_head.group_info.group_code.get());
                    localObject3 = ((TroopFileDataManager)localObject4).a(this.a, ((TroopFileData)localObject2).fileUrl);
                    if (localObject3 == null) {
                      ((TroopFileDataManager)localObject4).a(this.a, ((TroopFileData)localObject2).fileUrl, (TroopFileData)localObject2);
                    } else {
                      localObject2 = localObject3;
                    }
                    localObject3 = (MessageForTroopFile)MessageRecordFactory.a(-2017);
                    ((MessageForTroopFile)localObject3).msgtype = -2017;
                    ((MessageForTroopFile)localObject3).msg = HardCodeUtil.a(2131704664);
                    try
                    {
                      ((MessageForTroopFile)localObject3).msgData = MessagePkgUtils.a((Serializable)localObject2);
                    }
                    catch (Exception localException3)
                    {
                      localException3.printStackTrace();
                    }
                    ((MessageForTroopFile)localObject3).parse();
                    paramArrayList.add(localObject3);
                    bool2 = true;
                  }
                }
              }
              catch (Exception localException4)
              {
                for (;;)
                {
                  bool2 = bool1;
                }
              }
              j += 1;
              k = n + k;
              i = m;
              bool1 = bool2;
            }
            bool2 = bool1;
          }
        }
      }
      else {
        bool1 = bool2;
      }
    }
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("decodeGroupFilePb: endTime[");
      paramArrayList.append(System.currentTimeMillis());
      paramArrayList.append("]");
      QLog.i("FileMultiMsgPackageHandle<QFile>", 2, paramArrayList.toString());
    }
    return bool1;
  }
  
  public boolean a(hummer_resv_21.ResvAttr paramResvAttr, MessageRecord paramMessageRecord)
  {
    if (!paramResvAttr.forward_ext_file_info.has())
    {
      QLog.e("FileMultiMsgPackageHandle<QFile>", 1, "saveResvAttrToMr : resvAttr has no forward_ext_file_info");
      return false;
    }
    paramResvAttr = (hummer_resv_21.ForwardExtFileInfo)paramResvAttr.forward_ext_file_info.get();
    if (!paramResvAttr.uint32_file_type.has()) {
      a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no uint32_file_type");
    } else {
      paramMessageRecord.saveExtInfoToExtStr("_m_ForwardFileType", String.valueOf(paramResvAttr.uint32_file_type.get()));
    }
    if (!paramResvAttr.uint64_sender_uin.has()) {
      a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no uint64_sender_uin");
    } else {
      paramMessageRecord.saveExtInfoToExtStr("_m_ForwardSenderUin", String.valueOf(paramResvAttr.uint64_sender_uin.get()));
    }
    if (!paramResvAttr.uint64_receiver_uin.has()) {
      a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no uint64_receiver_uin");
    } else {
      paramMessageRecord.saveExtInfoToExtStr("_m_ForwardReceiverUin", String.valueOf(paramResvAttr.uint64_receiver_uin.get()));
    }
    Object localObject;
    StringBuilder localStringBuilder;
    if (!paramResvAttr.bytes_file_uuid.has())
    {
      a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no bytes_file_uuid");
    }
    else
    {
      localObject = new String(paramResvAttr.bytes_file_uuid.get().toByteArray());
      paramMessageRecord.saveExtInfoToExtStr("_m_ForwardUuid", (String)localObject);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveResvAttrToMr uuid:");
      localStringBuilder.append((String)localObject);
      a("FileMultiMsgPackageHandle<QFile>", localStringBuilder.toString());
    }
    if (paramResvAttr.str_fileidcrc.has())
    {
      localObject = paramResvAttr.str_fileidcrc.get();
      paramMessageRecord.saveExtInfoToExtStr("_m_ForwardFileIdCrc", (String)localObject);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveResvAttrToMr fileIdCrc:");
      localStringBuilder.append((String)localObject);
      a("FileMultiMsgPackageHandle<QFile>", localStringBuilder.toString());
    }
    if (!paramResvAttr.str_file_name.has()) {
      a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no str_file_name");
    } else {
      paramMessageRecord.saveExtInfoToExtStr("_m_ForwardFileName", paramResvAttr.str_file_name.get());
    }
    if (!paramResvAttr.uint64_file_size.has()) {
      a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no uint64_file_size");
    } else {
      paramMessageRecord.saveExtInfoToExtStr("_m_ForwardSize", String.valueOf(paramResvAttr.uint64_file_size.get()));
    }
    if (!paramResvAttr.bytes_file_sha1.has()) {
      a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no bytes_file_sha1");
    } else {
      paramMessageRecord.saveExtInfoToExtStr("_m_ForwardSha", paramResvAttr.bytes_file_sha1.get().toStringUtf8());
    }
    if (!paramResvAttr.bytes_file_md5.has()) {
      a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no bytes_file_md5");
    } else {
      paramMessageRecord.saveExtInfoToExtStr("_m_ForwardMd5", paramResvAttr.bytes_file_md5.get().toStringUtf8());
    }
    if (!paramResvAttr.uint32_bus_id.has())
    {
      a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no uint32_bus_id");
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramResvAttr.uint32_bus_id.get());
      ((StringBuilder)localObject).append("");
      paramMessageRecord.saveExtInfoToExtStr("_m_ForwardBusType", ((StringBuilder)localObject).toString());
    }
    if (!paramResvAttr.int64_dead_time.has()) {
      a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no int64_dead_time");
    } else {
      paramMessageRecord.saveExtInfoToExtStr("_m_ForwardDeadTime", String.valueOf(paramResvAttr.int64_dead_time.get()));
    }
    if (!paramResvAttr.uint32_img_width.has()) {
      a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no uint32_img_width");
    } else {
      paramMessageRecord.saveExtInfoToExtStr("_m_ForwardImgWidth", String.valueOf(paramResvAttr.uint32_img_width.get()));
    }
    if (!paramResvAttr.uint32_img_height.has()) {
      a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no uint32_img_height");
    } else {
      paramMessageRecord.saveExtInfoToExtStr("_m_ForwardImgHeight", String.valueOf(paramResvAttr.uint32_img_height.get()));
    }
    if (!paramResvAttr.uint64_video_duration.has())
    {
      a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no uint64_video_duration");
      return true;
    }
    paramMessageRecord.saveExtInfoToExtStr("_m_ForwardDuration", String.valueOf(paramResvAttr.uint64_video_duration.get()));
    return true;
  }
  
  public im_msg_body.MsgBody b(MessageRecord paramMessageRecord)
  {
    im_msg_body.MsgBody localMsgBody = new im_msg_body.MsgBody();
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    im_msg_body.GroupFile localGroupFile = new im_msg_body.GroupFile();
    Object localObject1;
    Object localObject2;
    long l;
    int i;
    hummer_resv_21.FileImgInfo localFileImgInfo;
    if (a(paramMessageRecord))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleDiscFileMessage: package multi disc file message. ");
      ((StringBuilder)localObject1).append(QFileUtils.a(this.a, paramMessageRecord));
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, ((StringBuilder)localObject1).toString());
      localObject2 = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
      localGroupFile.bytes_filename.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
      l = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
      localGroupFile.uint64_file_size.set(l);
      localObject1 = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
      localGroupFile.bytes_file_id.set(ByteStringMicro.copyFrom(((String)localObject1).getBytes()));
      localObject1 = a(paramMessageRecord);
      i = FileManagerUtil.a((String)localObject2);
      if ((i == 0) || (i == 2))
      {
        localObject2 = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
        paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
        if ((!TextUtils.isEmpty(paramMessageRecord)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
        {
          localFileImgInfo = new hummer_resv_21.FileImgInfo();
          localFileImgInfo.uint32_file_width.set(Integer.valueOf((String)localObject2).intValue());
          localFileImgInfo.uint32_file_height.set(Integer.valueOf(paramMessageRecord).intValue());
          ((hummer_resv_21.ResvAttr)localObject1).file_image_info.set(localFileImgInfo);
        }
      }
      localGroupFile.bytes_pb_reserve.set(ByteStringMicro.copyFrom(((hummer_resv_21.ResvAttr)localObject1).toByteArray()));
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleDiscFileMessage: package normal disc file message. ");
      ((StringBuilder)localObject1).append(QFileUtils.a(this.a, paramMessageRecord));
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, ((StringBuilder)localObject1).toString());
      localObject1 = this.a.getFileManagerDataCenter().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
      if (localObject1 != null)
      {
        paramMessageRecord = ((FileManagerEntity)localObject1).fileName;
        localGroupFile.bytes_filename.set(ByteStringMicro.copyFrom(paramMessageRecord.getBytes()));
        l = ((FileManagerEntity)localObject1).fileSize;
        localGroupFile.uint64_file_size.set(l);
        localObject2 = ((FileManagerEntity)localObject1).Uuid;
        localGroupFile.bytes_file_id.set(ByteStringMicro.copyFrom(((String)localObject2).getBytes()));
        localObject2 = new hummer_resv_21.ResvAttr();
        localFileImgInfo = new hummer_resv_21.FileImgInfo();
        i = FileManagerUtil.a(paramMessageRecord);
        if ((i == 0) || (i == 2))
        {
          localFileImgInfo.uint32_file_width.set(((FileManagerEntity)localObject1).imgWidth);
          localFileImgInfo.uint32_file_height.set(((FileManagerEntity)localObject1).imgHeight);
        }
        ((hummer_resv_21.ResvAttr)localObject2).file_image_info.set(localFileImgInfo);
        localGroupFile.bytes_pb_reserve.set(ByteStringMicro.copyFrom(((hummer_resv_21.ResvAttr)localObject2).toByteArray()));
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleDiscFileMessage. error, get file entity is null. msgUniseq[");
        ((StringBuilder)localObject1).append(paramMessageRecord.uniseq);
        ((StringBuilder)localObject1).append("]");
        QLog.i("FileMultiMsgPackageHandle<QFile>", 1, ((StringBuilder)localObject1).toString());
      }
    }
    paramMessageRecord = new im_msg_body.Elem();
    paramMessageRecord.group_file.set(localGroupFile);
    localRichText.elems.add(paramMessageRecord);
    localMsgBody.rich_text.set(localRichText);
    return localMsgBody;
  }
  
  public boolean b(ArrayList<MessageRecord> paramArrayList, msg_comm.Msg paramMsg)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("decodeDiscFilepb: startTime[");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      ((StringBuilder)localObject1).append("]");
      QLog.i("FileMultiMsgPackageHandle<QFile>", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramMsg == null)
    {
      QLog.e("FileMultiMsgPackageHandle<QFile>", 2, "<FileAssistant>decodeDiscFilepb : msg is null");
      return false;
    }
    if (!paramMsg.msg_body.has())
    {
      QLog.e("FileMultiMsgPackageHandle<QFile>", 2, "<FileAssistant>decodeDiscFilepb : msg has not body");
      return false;
    }
    paramMsg = (im_msg_body.MsgBody)paramMsg.msg_body.get();
    if (!paramMsg.rich_text.has())
    {
      QLog.e("FileMultiMsgPackageHandle<QFile>", 2, "<FileAssistant>decodeDiscFilepb : rich_text has not body");
      return false;
    }
    paramMsg = (im_msg_body.RichText)paramMsg.rich_text.get();
    if (!paramMsg.elems.has())
    {
      QLog.e("FileMultiMsgPackageHandle<QFile>", 2, "<FileAssistant>decodeDiscFilepb : rich_text has not elems");
      return false;
    }
    paramMsg = paramMsg.elems.get().iterator();
    for (;;)
    {
      if (paramMsg.hasNext())
      {
        localObject1 = (im_msg_body.Elem)paramMsg.next();
        if (!((im_msg_body.Elem)localObject1).group_file.has())
        {
          QLog.e("FileMultiMsgPackageHandle<QFile>", 2, "<FileAssistant>decodeDiscFilepb : elem has not group_file");
        }
        else
        {
          Object localObject2 = (im_msg_body.GroupFile)((im_msg_body.Elem)localObject1).group_file.get();
          if (!((im_msg_body.GroupFile)localObject2).bytes_pb_reserve.has())
          {
            QLog.e("FileMultiMsgPackageHandle<QFile>", 2, "<FileAssistant>decodeDiscFilepb : elem has not reserve info");
            return false;
          }
          Object localObject3 = ((im_msg_body.GroupFile)localObject2).bytes_pb_reserve.get().toByteArray();
          localObject1 = new hummer_resv_21.ResvAttr();
          paramMsg = (MessageForFile)MessageRecordFactory.a(-2005);
          try
          {
            ((hummer_resv_21.ResvAttr)localObject1).mergeFrom((byte[])localObject3);
            if (a((hummer_resv_21.ResvAttr)localObject1))
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("decodeDiscFilepb: decode multi disc file message. ");
              ((StringBuilder)localObject2).append(QFileUtils.a(this.a, paramMsg, false));
              QLog.i("FileMultiMsgPackageHandle<QFile>", 1, ((StringBuilder)localObject2).toString());
              if (a((hummer_resv_21.ResvAttr)localObject1, paramMsg)) {
                paramMsg.isMultiMsg = true;
              }
              paramArrayList.add(paramMsg);
              return true;
            }
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("decodeDiscFilepb: decode normal disc file message. ");
            ((StringBuilder)localObject3).append(QFileUtils.a(this.a, paramMsg, false));
            QLog.i("FileMultiMsgPackageHandle<QFile>", 1, ((StringBuilder)localObject3).toString());
            if (((im_msg_body.GroupFile)localObject2).bytes_filename.has())
            {
              localObject3 = ((im_msg_body.GroupFile)localObject2).bytes_filename.get().toStringUtf8();
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("decodeDiscFilepb: decode normal disc, fileName[");
              localStringBuilder.append((String)localObject3);
              localStringBuilder.append("]");
              QLog.i("FileMultiMsgPackageHandle<QFile>", 1, localStringBuilder.toString());
              paramMsg.saveExtInfoToExtStr("_backup_ForwardFileName", FileManagerUtil.a((String)localObject3));
            }
            else
            {
              QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeDiscFilepb: decode normal disc, fileName is null");
            }
            if (((im_msg_body.GroupFile)localObject2).uint64_file_size.has())
            {
              long l = ((im_msg_body.GroupFile)localObject2).uint64_file_size.get();
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append(l);
              ((StringBuilder)localObject3).append("");
              paramMsg.saveExtInfoToExtStr("_backup_ForwardSize", ((StringBuilder)localObject3).toString());
            }
            if (((im_msg_body.GroupFile)localObject2).bytes_file_id.has())
            {
              localObject2 = ((im_msg_body.GroupFile)localObject2).bytes_file_id.get().toStringUtf8();
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("decodeDiscFilepb: decode normal disc, fileId[");
              ((StringBuilder)localObject3).append((String)localObject2);
              ((StringBuilder)localObject3).append("]");
              QLog.i("FileMultiMsgPackageHandle<QFile>", 1, ((StringBuilder)localObject3).toString());
              paramMsg.saveExtInfoToExtStr("_backup_ForwardUuid", (String)localObject2);
            }
            else
            {
              QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeDiscFilepb: decode normal disc, fileId is null");
            }
            if (((hummer_resv_21.ResvAttr)localObject1).file_image_info.has())
            {
              localObject1 = (hummer_resv_21.FileImgInfo)((hummer_resv_21.ResvAttr)localObject1).file_image_info.get();
              int i;
              if (((hummer_resv_21.FileImgInfo)localObject1).uint32_file_width.has())
              {
                i = ((hummer_resv_21.FileImgInfo)localObject1).uint32_file_width.get();
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append(i);
                ((StringBuilder)localObject2).append("");
                paramMsg.saveExtInfoToExtStr("_backup_ForwardImgWidth", ((StringBuilder)localObject2).toString());
              }
              if (((hummer_resv_21.FileImgInfo)localObject1).uint32_file_height.has())
              {
                i = ((hummer_resv_21.FileImgInfo)localObject1).uint32_file_height.get();
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append(i);
                ((StringBuilder)localObject1).append("");
                paramMsg.saveExtInfoToExtStr("_backup_ForwardImgHeight", ((StringBuilder)localObject1).toString());
              }
            }
            paramArrayList.add(paramMsg);
            if (QLog.isColorLevel())
            {
              paramArrayList = new StringBuilder();
              paramArrayList.append("decodeDiscFilepb: endTime[");
              paramArrayList.append(System.currentTimeMillis());
              paramArrayList.append("]");
              QLog.i("FileMultiMsgPackageHandle<QFile>", 2, paramArrayList.toString());
            }
            return true;
          }
          catch (InvalidProtocolBufferMicroException paramArrayList)
          {
            paramArrayList.printStackTrace();
          }
        }
      }
    }
    return false;
  }
  
  public im_msg_body.MsgBody c(MessageRecord paramMessageRecord)
  {
    Object localObject1 = new im_msg_body.MsgBody();
    SubMsgType0x4.MsgBody localMsgBody = new SubMsgType0x4.MsgBody();
    Object localObject2 = new im_msg_body.NotOnlineFile();
    ((im_msg_body.NotOnlineFile)localObject2).uint32_client_type.set(0);
    Object localObject3;
    Object localObject4;
    int i;
    if (a(paramMessageRecord))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("handleBuddyFileMessage: package multi buddy file message. ");
      ((StringBuilder)localObject3).append(QFileUtils.a(this.a, paramMessageRecord));
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, ((StringBuilder)localObject3).toString());
      localObject3 = this.a.getFileManagerDataCenter().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
      if ((localObject3 != null) && (((FileManagerEntity)localObject3).getCloudType() == 0))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleBuddyFileMessage: package multi buddy file message but found online file.");
        ((StringBuilder)localObject1).append(QFileUtils.a(this.a, paramMessageRecord));
        QLog.i("FileMultiMsgPackageHandle<QFile>", 1, ((StringBuilder)localObject1).toString());
        return null;
      }
      localObject3 = a(paramMessageRecord);
      long l = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
      ((im_msg_body.NotOnlineFile)localObject2).uint64_file_size.set(l);
      localObject4 = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
      ((im_msg_body.NotOnlineFile)localObject2).bytes_file_name.set(ByteStringMicro.copyFrom(((String)localObject4).getBytes()));
      ((im_msg_body.NotOnlineFile)localObject2).uint32_subcmd.set(2);
      String str = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
      if (!TextUtils.isEmpty(str)) {
        ((im_msg_body.NotOnlineFile)localObject2).bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(str)));
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleBuddyFileMessage fileMd5 is ");
      localStringBuilder.append(str);
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, localStringBuilder.toString());
      localMsgBody.msg_not_online_file.set((MessageMicro)localObject2);
      i = FileManagerUtil.a((String)localObject4);
      if ((i == 0) || (i == 2))
      {
        localObject2 = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
        paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty(paramMessageRecord)))
        {
          localObject4 = new hummer_resv_21.FileImgInfo();
          ((hummer_resv_21.FileImgInfo)localObject4).uint32_file_height.set(Integer.valueOf(paramMessageRecord).intValue());
          ((hummer_resv_21.FileImgInfo)localObject4).uint32_file_width.set(Integer.valueOf((String)localObject2).intValue());
          localMsgBody.file_image_info.set((MessageMicro)localObject4);
        }
      }
      localMsgBody.resv_attr.set((MessageMicro)localObject3);
    }
    else
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("handleBuddyFileMessage: package normal buddy file message. ");
      ((StringBuilder)localObject3).append(QFileUtils.a(this.a, paramMessageRecord));
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, ((StringBuilder)localObject3).toString());
      localObject3 = this.a.getFileManagerDataCenter().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
      if (localObject3 != null)
      {
        if (((FileManagerEntity)localObject3).getCloudType() == 0)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("handleBuddyFileMessage: package normal buddy file message but found online file.");
          ((StringBuilder)localObject1).append(QFileUtils.a(this.a, paramMessageRecord));
          QLog.i("FileMultiMsgPackageHandle<QFile>", 1, ((StringBuilder)localObject1).toString());
          return null;
        }
        ((im_msg_body.NotOnlineFile)localObject2).uint64_file_size.set(((FileManagerEntity)localObject3).fileSize);
        if (!TextUtils.isEmpty(((FileManagerEntity)localObject3).fileName))
        {
          ((im_msg_body.NotOnlineFile)localObject2).bytes_file_name.set(ByteStringMicro.copyFrom(((FileManagerEntity)localObject3).fileName.getBytes()));
        }
        else
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("handleBuddyFileMessage: offline file name is null. ");
          ((StringBuilder)localObject4).append(QFileUtils.a(this.a, paramMessageRecord));
          QLog.i("FileMultiMsgPackageHandle<QFile>", 1, ((StringBuilder)localObject4).toString());
        }
        if (!TextUtils.isEmpty(((FileManagerEntity)localObject3).Uuid))
        {
          ((im_msg_body.NotOnlineFile)localObject2).bytes_file_uuid.set(ByteStringMicro.copyFrom(((FileManagerEntity)localObject3).Uuid.getBytes()));
        }
        else
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("handleBuddyFileMessage: offline file uuid is null. ");
          ((StringBuilder)localObject4).append(QFileUtils.a(this.a, paramMessageRecord));
          QLog.i("FileMultiMsgPackageHandle<QFile>", 1, ((StringBuilder)localObject4).toString());
        }
        if (!TextUtils.isEmpty(((FileManagerEntity)localObject3).strFileMd5)) {
          ((im_msg_body.NotOnlineFile)localObject2).bytes_file_md5.set(ByteStringMicro.copyFrom(((FileManagerEntity)localObject3).strFileMd5.getBytes()));
        } else if (!TextUtils.isEmpty(((FileManagerEntity)localObject3).str10Md5)) {
          ((im_msg_body.NotOnlineFile)localObject2).bytes_file_md5.set(ByteStringMicro.copyFrom(((FileManagerEntity)localObject3).str10Md5.getBytes()));
        }
        paramMessageRecord = new hummer_resv_21.FileImgInfo();
        i = FileManagerUtil.a(((FileManagerEntity)localObject3).fileName);
        if ((i == 0) || (i == 2))
        {
          paramMessageRecord.uint32_file_width.set(((FileManagerEntity)localObject3).imgWidth);
          paramMessageRecord.uint32_file_height.set(((FileManagerEntity)localObject3).imgHeight);
        }
        ((im_msg_body.NotOnlineFile)localObject2).uint32_subcmd.set(2);
        localMsgBody.msg_not_online_file.set((MessageMicro)localObject2);
        localMsgBody.file_image_info.set(paramMessageRecord);
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handleBuddyFileMessage. error, get file entity is null. msgUniseq[");
        ((StringBuilder)localObject2).append(paramMessageRecord.uniseq);
        ((StringBuilder)localObject2).append("]");
        QLog.i("FileMultiMsgPackageHandle<QFile>", 1, ((StringBuilder)localObject2).toString());
      }
    }
    paramMessageRecord = localMsgBody.toByteArray();
    ((im_msg_body.MsgBody)localObject1).msg_content.set(ByteStringMicro.copyFrom(paramMessageRecord));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileMultiMsgPackageHandle
 * JD-Core Version:    0.7.0.1
 */