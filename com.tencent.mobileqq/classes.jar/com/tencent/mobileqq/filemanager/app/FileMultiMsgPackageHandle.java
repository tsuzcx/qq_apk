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
    if (paramMessageRecord == null) {}
    while (TextUtils.isEmpty(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileType"))) {
      return false;
    }
    return true;
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
    if (paramInt == 1)
    {
      String str = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileType");
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "process type:" + str);
      if (TextUtils.isEmpty(str))
      {
        QLog.e("FileMultiMsgPackageHandle<QFile>", 1, "getMultiMsgBody : message extInfo type null");
        return null;
      }
    }
    switch (paramMessageRecord.istroop)
    {
    default: 
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "attention, this is a default way to handle, peerType[" + paramMessageRecord.istroop + "] " + QFileUtils.a(this.a, paramMessageRecord));
      return c(paramMessageRecord);
    case 0: 
      return c(paramMessageRecord);
    case 3000: 
      return b(paramMessageRecord);
    }
    return a(paramMessageRecord);
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
    String str1;
    if (a(paramMessageRecord))
    {
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleTroopFileMessage: package multi troop file message. " + QFileUtils.a(this.a, paramMessageRecord));
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
      str1 = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardDeadTime");
      if (!TextUtils.isEmpty(str1))
      {
        l = Long.parseLong(str1);
        ((obj_msg.MsgContentInfo.MsgFile)localObject3).int64_dead_time.set(l);
      }
      str1 = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSha");
      if (str1 != null) {
        ((obj_msg.MsgContentInfo.MsgFile)localObject3).bytes_file_sha1.set(ByteStringMicro.copyFrom(str1.getBytes()));
      }
      str1 = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
      if (str1 != null) {
        ((obj_msg.MsgContentInfo.MsgFile)localObject3).bytes_file_md5.set(ByteStringMicro.copyFrom(str1.getBytes()));
      }
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleTroopFileMessage fileMd5 is " + str1);
      i = FileManagerUtil.a((String)localObject4);
      localObject4 = new JSONObject();
      if ((i != 0) && (i != 2)) {}
    }
    for (;;)
    {
      int j;
      try
      {
        i = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth"));
        j = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight"));
        ((JSONObject)localObject4).put("width", i);
        ((JSONObject)localObject4).put("height", j);
        str1 = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardDuration");
        if (!TextUtils.isEmpty(str1)) {
          ((JSONObject)localObject4).put("duration", Integer.parseInt(str1));
        }
        ((JSONObject)localObject4).put("ExtInfo", Base64.encodeToString(a(paramMessageRecord).toByteArray(), 2));
        ((obj_msg.MsgContentInfo.MsgFile)localObject3).bytes_ext.set(ByteStringMicro.copyFrom(((JSONObject)localObject4).toString().getBytes()));
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
      catch (NumberFormatException localNumberFormatException1)
      {
        localNumberFormatException1.printStackTrace();
        continue;
      }
      catch (JSONException paramMessageRecord)
      {
        paramMessageRecord.printStackTrace();
        continue;
      }
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleTroopFileMessage: package normal troop file message. " + QFileUtils.a(this.a, paramMessageRecord));
      localObject4 = (MessageForTroopFile)paramMessageRecord;
      Object localObject5 = a((MessageForTroopFile)localObject4);
      if (localObject5 == null) {
        continue;
      }
      String str2 = ((TroopFileStatusInfo)localObject5).e;
      if (!TextUtils.isEmpty(str2))
      {
        ((obj_msg.MsgContentInfo.MsgFile)localObject3).bytes_file_path.set(ByteStringMicro.copyFrom(str2.getBytes()));
        if (QLog.isDebugVersion()) {
          QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleTroopFileMessage: get troop fileId[" + str2 + "] " + QFileUtils.a(this.a, paramMessageRecord));
        }
        label735:
        ((obj_msg.MsgContentInfo.MsgFile)localObject3).uint32_bus_id.set(((TroopFileStatusInfo)localObject5).h);
        str2 = ((TroopFileStatusInfo)localObject5).g;
        ((obj_msg.MsgContentInfo.MsgFile)localObject3).str_file_name.set(str2);
        l = ((TroopFileStatusInfo)localObject5).c;
        ((obj_msg.MsgContentInfo.MsgFile)localObject3).uint64_file_size.set(l);
        l = ((MessageForTroopFile)localObject4).lastTime;
        ((obj_msg.MsgContentInfo.MsgFile)localObject3).int64_dead_time.set(l);
        localObject5 = ((TroopFileStatusInfo)localObject5).f;
        if (TextUtils.isEmpty((CharSequence)localObject5)) {
          break label950;
        }
        ((obj_msg.MsgContentInfo.MsgFile)localObject3).bytes_file_sha1.set(ByteStringMicro.copyFrom(((String)localObject5).getBytes()));
        label830:
        i = FileManagerUtil.a(str2);
        paramMessageRecord = new JSONObject();
        if ((i != 0) && (i != 2)) {}
      }
      try
      {
        i = ((MessageForTroopFile)localObject4).width;
        j = ((MessageForTroopFile)localObject4).height;
        paramMessageRecord.put("width", i);
        paramMessageRecord.put("height", j);
        paramMessageRecord.put("duration", ((MessageForTroopFile)localObject4).duration);
        ((obj_msg.MsgContentInfo.MsgFile)localObject3).bytes_ext.set(ByteStringMicro.copyFrom(paramMessageRecord.toString().getBytes()));
        continue;
        QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleTroopFileMessage: error, can not get troop fileId. " + QFileUtils.a(this.a, paramMessageRecord));
        break label735;
        label950:
        if (!QLog.isDebugVersion()) {
          break label830;
        }
        QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleTroopFileMessage: error, can not get sha. " + QFileUtils.a(this.a, paramMessageRecord));
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        for (;;)
        {
          localNumberFormatException2.printStackTrace();
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public hummer_resv_21.ResvAttr a(MessageRecord paramMessageRecord)
  {
    hummer_resv_21.ResvAttr localResvAttr = new hummer_resv_21.ResvAttr();
    hummer_resv_21.ForwardExtFileInfo localForwardExtFileInfo = new hummer_resv_21.ForwardExtFileInfo();
    int i = Integer.parseInt(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileType"));
    if (QLog.isDevelopLevel()) {
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo fileType:" + i);
    }
    localForwardExtFileInfo.uint32_file_type.set(i);
    long l = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSenderUin"));
    if (QLog.isDevelopLevel()) {
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo sendUin:" + l);
    }
    localForwardExtFileInfo.uint64_sender_uin.set(l);
    l = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardReceiverUin"));
    if (QLog.isDevelopLevel()) {
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo recvUin:" + l);
    }
    localForwardExtFileInfo.uint64_receiver_uin.set(l);
    String str = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardUuid");
    if (QLog.isDevelopLevel()) {
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo fileUuid:" + str);
    }
    localForwardExtFileInfo.bytes_file_uuid.set(ByteStringMicro.copyFrom(str.getBytes()));
    str = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileIdCrc");
    if (QLog.isDevelopLevel()) {
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo fileIdCrc:" + str);
    }
    localForwardExtFileInfo.str_fileidcrc.set(str);
    str = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
    if (QLog.isDevelopLevel()) {
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo fileName:" + str);
    }
    localForwardExtFileInfo.str_file_name.set(str);
    l = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
    if (QLog.isDevelopLevel()) {
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo fileSize:" + l);
    }
    localForwardExtFileInfo.uint64_file_size.set(l);
    str = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSha");
    if (QLog.isDevelopLevel()) {
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo strSHA1:" + str);
    }
    localForwardExtFileInfo.bytes_file_sha1.set(ByteStringMicro.copyFrom(str.getBytes()));
    str = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
    if (QLog.isDevelopLevel()) {
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo fileMd5:" + str);
    }
    localForwardExtFileInfo.bytes_file_md5.set(ByteStringMicro.copyFrom(str.getBytes()));
    str = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardDeadTime");
    if (!TextUtils.isEmpty(str))
    {
      l = Long.parseLong(str);
      if (QLog.isDevelopLevel()) {
        QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo deadTime:" + str);
      }
      localForwardExtFileInfo.int64_dead_time.set(l);
    }
    str = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
    if (!TextUtils.isEmpty(str))
    {
      i = Integer.parseInt(str);
      if (QLog.isDevelopLevel()) {
        QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo imgWidth:" + str);
      }
      localForwardExtFileInfo.uint32_img_width.set(i);
    }
    str = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
    if (!TextUtils.isEmpty(str))
    {
      i = Integer.parseInt(str);
      if (QLog.isDevelopLevel()) {
        QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo imgWidth:" + str);
      }
      localForwardExtFileInfo.uint32_img_height.set(i);
    }
    str = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardDuration");
    if (!TextUtils.isEmpty(str))
    {
      l = Long.parseLong(str);
      if (QLog.isDevelopLevel()) {
        QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo videoDur:" + str);
      }
      localForwardExtFileInfo.uint64_video_duration.set(l);
    }
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardBusType");
    if (!TextUtils.isEmpty(paramMessageRecord))
    {
      i = Integer.parseInt(paramMessageRecord);
      if (QLog.isDevelopLevel()) {
        QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleFrowardExtFileInfo bizId:" + paramMessageRecord);
      }
      localForwardExtFileInfo.uint32_bus_id.set(i);
    }
    localResvAttr.forward_ext_file_info.set(localForwardExtFileInfo);
    return localResvAttr;
  }
  
  public void a(ArrayList<MessageRecord> paramArrayList, ByteStringMicro paramByteStringMicro)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgPackageHandle<QFile>", 2, "decodeBuddyFilePBMsg: startTime[" + System.currentTimeMillis() + "]");
    }
    MessageRecord localMessageRecord = MessageRecordFactory.a(-2005);
    Object localObject = new SubMsgType0x4.MsgBody();
    do
    {
      try
      {
        paramByteStringMicro = (SubMsgType0x4.MsgBody)((SubMsgType0x4.MsgBody)localObject).mergeFrom(paramByteStringMicro.toByteArray());
        localObject = (hummer_resv_21.ResvAttr)paramByteStringMicro.resv_attr.get();
        if (a((hummer_resv_21.ResvAttr)localObject))
        {
          QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeBuddyFilePBMsg: decode multi buddy file message. " + QFileUtils.a(this.a, localMessageRecord, false));
          if (a((hummer_resv_21.ResvAttr)localObject, localMessageRecord))
          {
            localMessageRecord.isMultiMsg = true;
            paramArrayList.add(localMessageRecord);
          }
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayList)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("FileMultiMsgPackageHandle<QFile>", 2, "<FileAssistant><---decodeC2CMsgPkg_MsgType0x211 : subMsgType[0x4] failed", paramArrayList);
        return;
      }
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeBuddyFilePBMsg: decode normal buddy file message. " + QFileUtils.a(this.a, localMessageRecord, false));
    } while (!paramByteStringMicro.msg_not_online_file.has());
    localObject = (im_msg_body.NotOnlineFile)paramByteStringMicro.msg_not_online_file.get();
    label293:
    int i;
    if (((im_msg_body.NotOnlineFile)localObject).bytes_file_name.has())
    {
      String str = ((im_msg_body.NotOnlineFile)localObject).bytes_file_name.get().toStringUtf8();
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeBuddyFilePBMsg: decode normal buddy fileName[" + str + "]");
      localMessageRecord.saveExtInfoToExtStr("_backup_ForwardFileName", str);
      if (!((im_msg_body.NotOnlineFile)localObject).uint32_file_type.has()) {
        break label660;
      }
      i = ((im_msg_body.NotOnlineFile)localObject).uint32_file_type.get();
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeBuddyFilePBMsg: decode normal buddy fileType[" + i + "]");
      localMessageRecord.saveExtInfoToExtStr("_backup_ForwardFileType", String.valueOf(i));
      label357:
      if (((im_msg_body.NotOnlineFile)localObject).bytes_file_md5.has()) {
        localMessageRecord.saveExtInfoToExtStr("_backup_ForwardMd5", FileHttpUtils.a(((im_msg_body.NotOnlineFile)localObject).bytes_file_md5.get().toByteArray()));
      }
      if (!((im_msg_body.NotOnlineFile)localObject).bytes_file_uuid.has()) {
        break label672;
      }
      str = ((im_msg_body.NotOnlineFile)localObject).bytes_file_uuid.get().toStringUtf8();
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeBuddyFilePBMsg: decode normal buddy uuid[" + str + "]");
      localMessageRecord.saveExtInfoToExtStr("_backup_ForwardUuid", str);
    }
    for (;;)
    {
      if (((im_msg_body.NotOnlineFile)localObject).uint64_file_size.has()) {
        localMessageRecord.saveExtInfoToExtStr("_backup_ForwardSize", String.valueOf(((im_msg_body.NotOnlineFile)localObject).uint64_file_size.get()));
      }
      if (paramByteStringMicro.file_image_info.has())
      {
        paramByteStringMicro = (hummer_resv_21.FileImgInfo)paramByteStringMicro.file_image_info.get();
        if (paramByteStringMicro.uint32_file_width.has())
        {
          i = paramByteStringMicro.uint32_file_width.get();
          localMessageRecord.saveExtInfoToExtStr("_backup_ForwardImgWidth", i + "");
        }
        if (paramByteStringMicro.uint32_file_height.has())
        {
          i = paramByteStringMicro.uint32_file_height.get();
          localMessageRecord.saveExtInfoToExtStr("_backup_ForwardImgHeight", i + "");
        }
      }
      paramArrayList.add(localMessageRecord);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("FileMultiMsgPackageHandle<QFile>", 2, "decodeBuddyFilePBMsg: endTime[" + System.currentTimeMillis() + "]");
      return;
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeBuddyFilePBMsg: decode normal buddy fileName is null");
      break label293;
      label660:
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeBuddyFilePBMsg: decode normal buddy fileType is null");
      break label357;
      label672:
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeBuddyFilePBMsg: decode normal buddy uuid is null");
    }
  }
  
  public boolean a(ArrayList<MessageRecord> paramArrayList, msg_comm.Msg paramMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgPackageHandle<QFile>", 2, "decodeGroupFilePb: startTime[" + System.currentTimeMillis() + "]");
    }
    boolean bool2;
    if (paramMsg == null)
    {
      QLog.e("FileMultiMsgPackageHandle<QFile>", 2, "<FileAssistant>decodeGroupFilePb : msg is null");
      bool2 = false;
      return bool2;
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
    boolean bool1 = false;
    int i;
    int k;
    byte[] arrayOfByte;
    int j;
    label311:
    int m;
    do
    {
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label760;
        }
        localObject1 = (im_msg_body.Elem)localIterator.next();
        if (!((im_msg_body.Elem)localObject1).trans_elem_info.has()) {
          break label818;
        }
        if (!((im_msg_body.Elem)localObject1).trans_elem_info.has())
        {
          QLog.e("FileMultiMsgPackageHandle<QFile>", 2, "<FileAssistant>decodeGroupFilePb : elem has not trans_elem_info");
        }
        else
        {
          localObject1 = (im_msg_body.TransElem)((im_msg_body.Elem)localObject1).trans_elem_info.get();
          i = ((im_msg_body.TransElem)localObject1).elem_type.get();
          if (i == 24) {
            break;
          }
          QLog.e("FileMultiMsgPackageHandle<QFile>", 2, "<FileAssistant>decodeGroupFilePb : trans_elem_info type:" + i);
        }
      }
      k = ((im_msg_body.TransElem)localObject1).elem_value.get().size();
      arrayOfByte = ((im_msg_body.TransElem)localObject1).elem_value.get().toByteArray();
      j = 0;
      i = 0;
      if (k <= 3) {
        break label815;
      }
      m = j + 1;
    } while (j > 100);
    label807:
    label810:
    label815:
    label818:
    for (;;)
    {
      int n = arrayOfByte[i];
      int i1 = PkgTools.getShortData(arrayOfByte, i + 1);
      j = k - (i1 + 3);
      k = i + (i1 + 3);
      if (n != 1)
      {
        i = k;
        k = j;
        j = m;
        break label311;
      }
      localObject1 = new byte[i1];
      PkgTools.copyData((byte[])localObject1, 0, arrayOfByte, i + 3, i1);
      Object localObject3 = new obj_msg.ObjMsg();
      for (;;)
      {
        try
        {
          localObject1 = (obj_msg.ObjMsg)((obj_msg.ObjMsg)localObject3).mergeFrom((byte[])localObject1);
          i = 0;
          if (!((obj_msg.MsgContentInfo)((obj_msg.ObjMsg)localObject1).msg_content_info.get(0)).msg_file.bytes_ext.has()) {
            break label614;
          }
          localObject3 = ((obj_msg.MsgContentInfo)((obj_msg.ObjMsg)localObject1).msg_content_info.get(0)).msg_file.bytes_ext.get().toStringUtf8();
        }
        catch (Exception localException1)
        {
          try
          {
            localObject4 = Base64.decode(new JSONObject((String)localObject3).optString("ExtInfo"), 0);
            localObject3 = new hummer_resv_21.ResvAttr();
            ((hummer_resv_21.ResvAttr)localObject3).mergeFrom((byte[])localObject4);
            localObject4 = (MessageForTroopFile)MessageRecordFactory.a(-2017);
            if (!a((hummer_resv_21.ResvAttr)localObject3, (MessageRecord)localObject4)) {
              break label810;
            }
            paramArrayList.add(localObject4);
            ((MessageForTroopFile)localObject4).isMultiMsg = true;
            i = 1;
            bool1 = true;
            if (i != 0) {
              break label807;
            }
            localObject3 = TroopFileUtils.a((obj_msg.ObjMsg)localObject1);
            if (localObject3 != null) {
              break label617;
            }
            i = m;
            m = j;
            j = i;
            i = k;
            k = m;
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
          }
          localException1 = localException1;
          i = k;
          k = j;
          j = m;
        }
        break label311;
        label614:
        continue;
        label617:
        TroopFileDataManager localTroopFileDataManager = a(paramMsg.msg_head.group_info.group_code.get());
        Object localObject4 = localTroopFileDataManager.a(this.a, localException3.fileUrl);
        Object localObject2 = localObject4;
        if (localObject4 == null)
        {
          localTroopFileDataManager.a(this.a, localException3.fileUrl, localException3);
          localObject2 = localException3;
        }
        MessageForTroopFile localMessageForTroopFile = (MessageForTroopFile)MessageRecordFactory.a(-2017);
        localMessageForTroopFile.msgtype = -2017;
        localMessageForTroopFile.msg = HardCodeUtil.a(2131704584);
        for (;;)
        {
          try
          {
            localMessageForTroopFile.msgData = MessagePkgUtils.a(localObject2);
            localMessageForTroopFile.parse();
            paramArrayList.add(localMessageForTroopFile);
            bool1 = true;
            i = k;
            k = j;
            j = m;
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
            continue;
          }
          label760:
          bool2 = bool1;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("FileMultiMsgPackageHandle<QFile>", 2, "decodeGroupFilePb: endTime[" + System.currentTimeMillis() + "]");
          return bool1;
        }
        i = 0;
      }
    }
  }
  
  public boolean a(hummer_resv_21.ResvAttr paramResvAttr, MessageRecord paramMessageRecord)
  {
    if (!paramResvAttr.forward_ext_file_info.has())
    {
      QLog.e("FileMultiMsgPackageHandle<QFile>", 1, "saveResvAttrToMr : resvAttr has no forward_ext_file_info");
      return false;
    }
    paramResvAttr = (hummer_resv_21.ForwardExtFileInfo)paramResvAttr.forward_ext_file_info.get();
    label70:
    label89:
    label108:
    String str;
    if (!paramResvAttr.uint32_file_type.has())
    {
      a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no uint32_file_type");
      if (paramResvAttr.uint64_sender_uin.has()) {
        break label352;
      }
      a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no uint64_sender_uin");
      if (paramResvAttr.uint64_receiver_uin.has()) {
        break label372;
      }
      a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no uint64_receiver_uin");
      if (paramResvAttr.bytes_file_uuid.has()) {
        break label392;
      }
      a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no bytes_file_uuid");
      if (paramResvAttr.str_fileidcrc.has())
      {
        str = paramResvAttr.str_fileidcrc.get();
        paramMessageRecord.saveExtInfoToExtStr("_m_ForwardFileIdCrc", str);
        a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr fileIdCrc:" + str);
      }
      if (paramResvAttr.str_file_name.has()) {
        break label446;
      }
      a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no str_file_name");
      label179:
      if (paramResvAttr.uint64_file_size.has()) {
        break label462;
      }
      a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no uint64_file_size");
      label198:
      if (paramResvAttr.bytes_file_sha1.has()) {
        break label481;
      }
      a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no bytes_file_sha1");
      label217:
      if (paramResvAttr.bytes_file_md5.has()) {
        break label500;
      }
      a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no bytes_file_md5");
      label236:
      if (paramResvAttr.uint32_bus_id.has()) {
        break label519;
      }
      a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no uint32_bus_id");
      label255:
      if (paramResvAttr.int64_dead_time.has()) {
        break label554;
      }
      a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no int64_dead_time");
      label274:
      if (paramResvAttr.uint32_img_width.has()) {
        break label573;
      }
      a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no uint32_img_width");
      label293:
      if (paramResvAttr.uint32_img_height.has()) {
        break label592;
      }
      a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no uint32_img_height");
      label312:
      if (paramResvAttr.uint64_video_duration.has()) {
        break label611;
      }
      a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr no uint64_video_duration");
    }
    for (;;)
    {
      return true;
      paramMessageRecord.saveExtInfoToExtStr("_m_ForwardFileType", String.valueOf(paramResvAttr.uint32_file_type.get()));
      break;
      label352:
      paramMessageRecord.saveExtInfoToExtStr("_m_ForwardSenderUin", String.valueOf(paramResvAttr.uint64_sender_uin.get()));
      break label70;
      label372:
      paramMessageRecord.saveExtInfoToExtStr("_m_ForwardReceiverUin", String.valueOf(paramResvAttr.uint64_receiver_uin.get()));
      break label89;
      label392:
      str = new String(paramResvAttr.bytes_file_uuid.get().toByteArray());
      paramMessageRecord.saveExtInfoToExtStr("_m_ForwardUuid", str);
      a("FileMultiMsgPackageHandle<QFile>", "saveResvAttrToMr uuid:" + str);
      break label108;
      label446:
      paramMessageRecord.saveExtInfoToExtStr("_m_ForwardFileName", paramResvAttr.str_file_name.get());
      break label179;
      label462:
      paramMessageRecord.saveExtInfoToExtStr("_m_ForwardSize", String.valueOf(paramResvAttr.uint64_file_size.get()));
      break label198;
      label481:
      paramMessageRecord.saveExtInfoToExtStr("_m_ForwardSha", paramResvAttr.bytes_file_sha1.get().toStringUtf8());
      break label217;
      label500:
      paramMessageRecord.saveExtInfoToExtStr("_m_ForwardMd5", paramResvAttr.bytes_file_md5.get().toStringUtf8());
      break label236;
      label519:
      paramMessageRecord.saveExtInfoToExtStr("_m_ForwardBusType", paramResvAttr.uint32_bus_id.get() + "");
      break label255;
      label554:
      paramMessageRecord.saveExtInfoToExtStr("_m_ForwardDeadTime", String.valueOf(paramResvAttr.int64_dead_time.get()));
      break label274;
      label573:
      paramMessageRecord.saveExtInfoToExtStr("_m_ForwardImgWidth", String.valueOf(paramResvAttr.uint32_img_width.get()));
      break label293;
      label592:
      paramMessageRecord.saveExtInfoToExtStr("_m_ForwardImgHeight", String.valueOf(paramResvAttr.uint32_img_height.get()));
      break label312;
      label611:
      paramMessageRecord.saveExtInfoToExtStr("_m_ForwardDuration", String.valueOf(paramResvAttr.uint64_video_duration.get()));
    }
  }
  
  public im_msg_body.MsgBody b(MessageRecord paramMessageRecord)
  {
    im_msg_body.MsgBody localMsgBody = new im_msg_body.MsgBody();
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    im_msg_body.GroupFile localGroupFile = new im_msg_body.GroupFile();
    Object localObject2;
    long l;
    Object localObject1;
    int i;
    hummer_resv_21.FileImgInfo localFileImgInfo;
    if (a(paramMessageRecord))
    {
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleDiscFileMessage: package multi disc file message. " + QFileUtils.a(this.a, paramMessageRecord));
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
    for (;;)
    {
      paramMessageRecord = new im_msg_body.Elem();
      paramMessageRecord.group_file.set(localGroupFile);
      localRichText.elems.add(paramMessageRecord);
      localMsgBody.rich_text.set(localRichText);
      return localMsgBody;
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleDiscFileMessage: package normal disc file message. " + QFileUtils.a(this.a, paramMessageRecord));
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
        QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleDiscFileMessage. error, get file entity is null. msgUniseq[" + paramMessageRecord.uniseq + "]");
      }
    }
  }
  
  public boolean b(ArrayList<MessageRecord> paramArrayList, msg_comm.Msg paramMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileMultiMsgPackageHandle<QFile>", 2, "decodeDiscFilepb: startTime[" + System.currentTimeMillis() + "]");
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
    while (paramMsg.hasNext())
    {
      Object localObject1 = (im_msg_body.Elem)paramMsg.next();
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
            QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeDiscFilepb: decode multi disc file message. " + QFileUtils.a(this.a, paramMsg, false));
            if (a((hummer_resv_21.ResvAttr)localObject1, paramMsg)) {
              paramMsg.isMultiMsg = true;
            }
            paramArrayList.add(paramMsg);
            return true;
          }
        }
        catch (InvalidProtocolBufferMicroException paramArrayList)
        {
          paramArrayList.printStackTrace();
          return false;
        }
        QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeDiscFilepb: decode normal disc file message. " + QFileUtils.a(this.a, paramMsg, false));
        if (((im_msg_body.GroupFile)localObject2).bytes_filename.has())
        {
          localObject3 = ((im_msg_body.GroupFile)localObject2).bytes_filename.get().toStringUtf8();
          QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeDiscFilepb: decode normal disc, fileName[" + (String)localObject3 + "]");
          paramMsg.saveExtInfoToExtStr("_backup_ForwardFileName", FileManagerUtil.a((String)localObject3));
          label447:
          if (((im_msg_body.GroupFile)localObject2).uint64_file_size.has())
          {
            long l = ((im_msg_body.GroupFile)localObject2).uint64_file_size.get();
            paramMsg.saveExtInfoToExtStr("_backup_ForwardSize", l + "");
          }
          if (!((im_msg_body.GroupFile)localObject2).bytes_file_id.has()) {
            break label741;
          }
          localObject2 = ((im_msg_body.GroupFile)localObject2).bytes_file_id.get().toStringUtf8();
          QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeDiscFilepb: decode normal disc, fileId[" + (String)localObject2 + "]");
          paramMsg.saveExtInfoToExtStr("_backup_ForwardUuid", (String)localObject2);
        }
        for (;;)
        {
          if (((hummer_resv_21.ResvAttr)localObject1).file_image_info.has())
          {
            localObject1 = (hummer_resv_21.FileImgInfo)((hummer_resv_21.ResvAttr)localObject1).file_image_info.get();
            int i;
            if (((hummer_resv_21.FileImgInfo)localObject1).uint32_file_width.has())
            {
              i = ((hummer_resv_21.FileImgInfo)localObject1).uint32_file_width.get();
              paramMsg.saveExtInfoToExtStr("_backup_ForwardImgWidth", i + "");
            }
            if (((hummer_resv_21.FileImgInfo)localObject1).uint32_file_height.has())
            {
              i = ((hummer_resv_21.FileImgInfo)localObject1).uint32_file_height.get();
              paramMsg.saveExtInfoToExtStr("_backup_ForwardImgHeight", i + "");
            }
          }
          paramArrayList.add(paramMsg);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("FileMultiMsgPackageHandle<QFile>", 2, "decodeDiscFilepb: endTime[" + System.currentTimeMillis() + "]");
          break;
          QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeDiscFilepb: decode normal disc, fileName is null");
          break label447;
          label741:
          QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "decodeDiscFilepb: decode normal disc, fileId is null");
        }
      }
    }
    return false;
  }
  
  public im_msg_body.MsgBody c(MessageRecord paramMessageRecord)
  {
    im_msg_body.MsgBody localMsgBody = new im_msg_body.MsgBody();
    SubMsgType0x4.MsgBody localMsgBody1 = new SubMsgType0x4.MsgBody();
    Object localObject1 = new im_msg_body.NotOnlineFile();
    ((im_msg_body.NotOnlineFile)localObject1).uint32_client_type.set(0);
    Object localObject2;
    int i;
    if (a(paramMessageRecord))
    {
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleBuddyFileMessage: package multi buddy file message. " + QFileUtils.a(this.a, paramMessageRecord));
      localObject2 = this.a.getFileManagerDataCenter().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
      if ((localObject2 != null) && (((FileManagerEntity)localObject2).getCloudType() == 0))
      {
        QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleBuddyFileMessage: package multi buddy file message but found online file." + QFileUtils.a(this.a, paramMessageRecord));
        return null;
      }
      localObject2 = a(paramMessageRecord);
      long l = Long.parseLong(paramMessageRecord.getExtInfoFromExtStr("_m_ForwardSize"));
      ((im_msg_body.NotOnlineFile)localObject1).uint64_file_size.set(l);
      Object localObject3 = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardFileName");
      ((im_msg_body.NotOnlineFile)localObject1).bytes_file_name.set(ByteStringMicro.copyFrom(((String)localObject3).getBytes()));
      ((im_msg_body.NotOnlineFile)localObject1).uint32_subcmd.set(2);
      String str = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardMd5");
      if (!TextUtils.isEmpty(str)) {
        ((im_msg_body.NotOnlineFile)localObject1).bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(str)));
      }
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleBuddyFileMessage fileMd5 is " + str);
      localMsgBody1.msg_not_online_file.set((MessageMicro)localObject1);
      i = FileManagerUtil.a((String)localObject3);
      if ((i == 0) || (i == 2))
      {
        localObject1 = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgWidth");
        paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("_m_ForwardImgHeight");
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(paramMessageRecord)))
        {
          localObject3 = new hummer_resv_21.FileImgInfo();
          ((hummer_resv_21.FileImgInfo)localObject3).uint32_file_height.set(Integer.valueOf(paramMessageRecord).intValue());
          ((hummer_resv_21.FileImgInfo)localObject3).uint32_file_width.set(Integer.valueOf((String)localObject1).intValue());
          localMsgBody1.file_image_info.set((MessageMicro)localObject3);
        }
      }
      localMsgBody1.resv_attr.set((MessageMicro)localObject2);
    }
    for (;;)
    {
      paramMessageRecord = localMsgBody1.toByteArray();
      localMsgBody.msg_content.set(ByteStringMicro.copyFrom(paramMessageRecord));
      return localMsgBody;
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleBuddyFileMessage: package normal buddy file message. " + QFileUtils.a(this.a, paramMessageRecord));
      localObject2 = this.a.getFileManagerDataCenter().a(paramMessageRecord.uniseq, paramMessageRecord.frienduin, paramMessageRecord.istroop);
      if (localObject2 != null)
      {
        if (((FileManagerEntity)localObject2).getCloudType() == 0)
        {
          QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleBuddyFileMessage: package normal buddy file message but found online file." + QFileUtils.a(this.a, paramMessageRecord));
          return null;
        }
        ((im_msg_body.NotOnlineFile)localObject1).uint64_file_size.set(((FileManagerEntity)localObject2).fileSize);
        if (!TextUtils.isEmpty(((FileManagerEntity)localObject2).fileName))
        {
          ((im_msg_body.NotOnlineFile)localObject1).bytes_file_name.set(ByteStringMicro.copyFrom(((FileManagerEntity)localObject2).fileName.getBytes()));
          label551:
          if (TextUtils.isEmpty(((FileManagerEntity)localObject2).Uuid)) {
            break label728;
          }
          ((im_msg_body.NotOnlineFile)localObject1).bytes_file_uuid.set(ByteStringMicro.copyFrom(((FileManagerEntity)localObject2).Uuid.getBytes()));
          label581:
          if (TextUtils.isEmpty(((FileManagerEntity)localObject2).strFileMd5)) {
            break label764;
          }
          ((im_msg_body.NotOnlineFile)localObject1).bytes_file_md5.set(ByteStringMicro.copyFrom(((FileManagerEntity)localObject2).strFileMd5.getBytes()));
        }
        for (;;)
        {
          paramMessageRecord = new hummer_resv_21.FileImgInfo();
          i = FileManagerUtil.a(((FileManagerEntity)localObject2).fileName);
          if ((i == 0) || (i == 2))
          {
            paramMessageRecord.uint32_file_width.set(((FileManagerEntity)localObject2).imgWidth);
            paramMessageRecord.uint32_file_height.set(((FileManagerEntity)localObject2).imgHeight);
          }
          ((im_msg_body.NotOnlineFile)localObject1).uint32_subcmd.set(2);
          localMsgBody1.msg_not_online_file.set((MessageMicro)localObject1);
          localMsgBody1.file_image_info.set(paramMessageRecord);
          break;
          QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleBuddyFileMessage: offline file name is null. " + QFileUtils.a(this.a, paramMessageRecord));
          break label551;
          label728:
          QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleBuddyFileMessage: offline file uuid is null. " + QFileUtils.a(this.a, paramMessageRecord));
          break label581;
          label764:
          if (!TextUtils.isEmpty(((FileManagerEntity)localObject2).str10Md5)) {
            ((im_msg_body.NotOnlineFile)localObject1).bytes_file_md5.set(ByteStringMicro.copyFrom(((FileManagerEntity)localObject2).str10Md5.getBytes()));
          }
        }
      }
      QLog.i("FileMultiMsgPackageHandle<QFile>", 1, "handleBuddyFileMessage. error, get file entity is null. msgUniseq[" + paramMessageRecord.uniseq + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FileMultiMsgPackageHandle
 * JD-Core Version:    0.7.0.1
 */