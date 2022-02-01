package com.tencent.mobileqq.mixedmsg;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.UiCallBack.MultiMsgPicsUploadAdapter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.MixedMsg.Elem;
import localpb.richMsg.MixedMsg.Msg;
import localpb.richMsg.RichMsg.PicRec;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.NotOnlineImage;
import tencent.im.msg.im_msg_body.RichText;

class MixedMsgManager$2
  extends UiCallBack.MultiMsgPicsUploadAdapter
{
  MixedMsgManager$2(MixedMsgManager paramMixedMsgManager, MessageForMixedMsg paramMessageForMixedMsg, QQAppInterface paramQQAppInterface, String paramString, int paramInt) {}
  
  private boolean a(MessageForPic paramMessageForPic, PicResult paramPicResult)
  {
    im_msg_body.RichText localRichText = new im_msg_body.RichText();
    im_msg_body.Elem localElem = new im_msg_body.Elem();
    Object localObject = paramPicResult.d;
    boolean bool2 = false;
    boolean bool1;
    if (localObject != null)
    {
      bool1 = paramPicResult.d instanceof im_msg_body.NotOnlineImage;
      localObject = "";
      if (bool1)
      {
        localElem.not_online_image.set((im_msg_body.NotOnlineImage)paramPicResult.d);
        if (paramPicResult.f)
        {
          if (localElem.not_online_image.res_id.has()) {
            localObject = localElem.not_online_image.res_id.get().toStringUtf8();
          } else if (localElem.not_online_image.download_path.has()) {
            localObject = localElem.not_online_image.download_path.get().toStringUtf8();
          }
          paramMessageForPic.uuid = ((String)localObject);
          paramMessageForPic.path = ((String)localObject);
          paramMessageForPic.thumbMsgUrl = localElem.not_online_image.str_thumb_url.get();
          paramMessageForPic.thumbHeight = localElem.not_online_image.uint32_thumb_height.get();
          paramMessageForPic.thumbWidth = localElem.not_online_image.uint32_thumb_width.get();
          paramMessageForPic.md5 = FileUtils.calcMd5(MixedMsgManager.b());
          paramMessageForPic.msgData = paramMessageForPic.getSerialPB().toByteArray();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(" pic resp uuid = ");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append(" picMsgMD5 = ");
            localStringBuilder.append(paramMessageForPic.md5);
            localStringBuilder.append(" hasCode = ");
            localStringBuilder.append(paramMessageForPic.hashCode());
            QLog.d("MixedMsgManager", 2, localStringBuilder.toString());
          }
        }
      }
      for (;;)
      {
        i = 1;
        break label443;
        if (!(paramPicResult.d instanceof im_msg_body.CustomFace)) {
          break;
        }
        localElem.custom_face.set((im_msg_body.CustomFace)paramPicResult.d);
        if (paramPicResult.f)
        {
          if (localElem.custom_face.str_file_path.has()) {
            localObject = localElem.custom_face.str_file_path.get();
          }
          paramMessageForPic.path = ((String)localObject);
          paramMessageForPic.uuid = ((String)localObject);
          paramMessageForPic.md5 = FileUtils.calcMd5(MixedMsgManager.b());
          paramMessageForPic.msgData = paramMessageForPic.getSerialPB().toByteArray();
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("WTF, picResult.mExtraObj is ");
        ((StringBuilder)localObject).append(paramPicResult.d.getClass().getSimpleName());
        QLog.e("MixedMsgManager", 2, ((StringBuilder)localObject).toString());
      }
    }
    int i = 0;
    label443:
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "updateMessageForPic success");
      }
      localRichText.elems.add(localElem);
      if (paramPicResult.a == 0)
      {
        bool1 = true;
      }
      else
      {
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.e("MixedMsgManager", 2, "[requestUploadPics] Bad picture element");
          bool1 = bool2;
        }
      }
    }
    else
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.e("MixedMsgManager", 2, "updateMessageForPic failed, add empty element");
        bool1 = bool2;
      }
    }
    paramMessageForPic.richText = localRichText;
    return bool1;
  }
  
  private boolean a(ArrayList<PicResult> paramArrayList)
  {
    MessageForMixedMsg localMessageForMixedMsg = this.a;
    Object localObject = localMessageForMixedMsg.msgElemList;
    boolean bool1 = true;
    if (localObject != null)
    {
      int i = 0;
      bool1 = true;
      int k;
      for (int j = 0; i < localMessageForMixedMsg.msgElemList.size(); j = k)
      {
        localObject = (MessageRecord)localMessageForMixedMsg.msgElemList.get(i);
        boolean bool2 = bool1;
        k = j;
        if ((localObject instanceof MessageForPic))
        {
          localObject = (MessageForPic)localObject;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("updateMessageForPic for MessageForMixedMsg, subMsgIndex[");
            localStringBuilder.append(i);
            QLog.d("MixedMsgManager", 2, localStringBuilder.toString());
          }
          if (!a((MessageForPic)localObject, (PicResult)paramArrayList.get(j))) {
            bool1 = false;
          }
          k = j + 1;
          bool2 = bool1;
        }
        i += 1;
        bool1 = bool2;
      }
    }
    return bool1;
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, ArrayList<PicResult> paramArrayList)
  {
    if ((paramInt == 0) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onForwardMultiMsgPicsUpload success[");
        ((StringBuilder)localObject1).append(paramArrayList.size());
        ((StringBuilder)localObject1).append("]");
        QLog.d("MixedMsgManager", 2, ((StringBuilder)localObject1).toString());
      }
      boolean bool = a(paramArrayList);
      if (!bool)
      {
        if (QLog.isColorLevel()) {
          QLog.e("MixedMsgManager", 2, "onForwardMultiMsgPicsUpload : isAllPicUploadSuccessful = false ");
        }
        MixedMsgManager.a(this.e, this.a, false, "picUpload fail");
        return;
      }
      paramArrayList = new MixedMsg.Msg();
      localObject1 = this.a.msgElemList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (MessageRecord)((Iterator)localObject1).next();
        localObject2 = new MixedMsg.Elem();
        if ((localObject3 instanceof MessageForText))
        {
          if (TextUtils.isEmpty(((MessageRecord)localObject3).msg)) {
            continue;
          }
          ((MixedMsg.Elem)localObject2).textMsg.set(((MessageRecord)localObject3).msg);
        }
        else
        {
          Object localObject4;
          if (((MessageRecord)localObject3).msgtype == -2000)
          {
            localObject4 = new RichMsg.PicRec();
            try
            {
              localObject3 = (RichMsg.PicRec)((RichMsg.PicRec)localObject4).mergeFrom(((MessageRecord)localObject3).msgData);
              ((MixedMsg.Elem)localObject2).picMsg.set((MessageMicro)localObject3);
            }
            catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
            {
              QLog.e("MixedMsgManager", 1, "onForwardMultiMsgPicsUpload", localInvalidProtocolBufferMicroException);
            }
          }
          else if ((localInvalidProtocolBufferMicroException instanceof MessageForReplyText))
          {
            try
            {
              MessageForReplyText localMessageForReplyText = (MessageForReplyText)localInvalidProtocolBufferMicroException;
              if (localMessageForReplyText.mSourceMsgInfo != null) {
                localMessageForReplyText.mSourceMsgInfo.packSourceMsg(MessageForReplyText.getAppInterface(), localMessageForReplyText.getSourceMessage());
              }
              localObject4 = MessagePkgUtils.a(localMessageForReplyText.mSourceMsgInfo);
              ((MixedMsg.Elem)localObject2).sourceMsgInfo.set(HexUtil.bytes2HexStr((byte[])localObject4));
              if (!TextUtils.isEmpty(localMessageForReplyText.msg)) {
                ((MixedMsg.Elem)localObject2).textMsg.set(localMessageForReplyText.msg);
              }
            }
            catch (Exception localException)
            {
              if (QLog.isColorLevel()) {
                QLog.d("MixedMsgManager", 2, localException.getMessage());
              }
            }
          }
        }
        paramArrayList.elems.get().add(localObject2);
      }
      this.a.msgData = paramArrayList.toByteArray();
      if (QLog.isColorLevel()) {
        QLog.d("MixedMsgManager", 2, "updateMsgRecords done, goto onPackAndSendMsg");
      }
      MixedMsgManager.a(this.e, this.b, this.c, this.d, this.a, bool);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MixedMsgManager", 2, "onForwardMultiMsgPicsUpload failed");
    }
    paramArrayList = this.e;
    Object localObject1 = this.a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("picUpload fail : result = ");
    ((StringBuilder)localObject2).append(paramInt);
    MixedMsgManager.a(paramArrayList, (MessageForMixedMsg)localObject1, false, ((StringBuilder)localObject2).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mixedmsg.MixedMsgManager.2
 * JD-Core Version:    0.7.0.1
 */