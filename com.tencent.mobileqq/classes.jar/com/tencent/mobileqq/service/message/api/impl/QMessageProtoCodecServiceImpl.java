package com.tencent.mobileqq.service.message.api.impl;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.hookparcel.ParcelHooker;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.message.QMessageProtoCodec;
import com.tencent.mobileqq.service.message.QMessageProtoCodec.EncodeRichTextFromStringMsgOne;
import com.tencent.mobileqq.service.message.api.IQMessageProtoCodecService;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AccountNotMatchException;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype33;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.Face;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.SmallEmoji;
import tencent.im.msg.im_msg_body.Text;

public class QMessageProtoCodecServiceImpl
  implements IQMessageProtoCodecService
{
  private static final String TAG = "MessageProtoCodecApiImpl";
  
  public boolean needProcessEmotion(String paramString, int paramInt)
  {
    return (paramString.charAt(paramInt) == '\024') && (paramInt + 1 < paramString.length());
  }
  
  public void processEmotion(QMessageProtoCodec.EncodeRichTextFromStringMsgOne paramEncodeRichTextFromStringMsgOne)
  {
    Object localObject1;
    if (paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_JavaLangStringBuilder.length() > 0)
    {
      localObject1 = paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_JavaLangStringBuilder.toString();
      QMessageProtoCodec.a(paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_TencentImMsgIm_msg_body$RichText, (String)localObject1);
      paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_JavaLangStringBuilder.delete(0, paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_JavaLangStringBuilder.length());
      paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_Int += 1;
    }
    int j = paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_JavaLangString.charAt(paramEncodeRichTextFromStringMsgOne.b + 1);
    int i = j;
    if (j == 250) {
      i = 10;
    }
    Object localObject3;
    if (QQSysFaceUtil.isValidFaceId(i))
    {
      j = QQSysFaceUtil.convertToServer(i);
      if (j >= 260)
      {
        localObject1 = new hummer_commelem.MsgElemInfo_servtype33();
        ((hummer_commelem.MsgElemInfo_servtype33)localObject1).uint32_index.set(j);
        localObject3 = QQSysFaceUtil.getFaceDescription(i);
        ((hummer_commelem.MsgElemInfo_servtype33)localObject1).bytes_text.set(ByteStringMicro.copyFromUtf8((String)localObject3));
        ((hummer_commelem.MsgElemInfo_servtype33)localObject1).bytes_compat.set(ByteStringMicro.copyFromUtf8((String)localObject3));
        localObject3 = new im_msg_body.CommonElem();
        ((im_msg_body.CommonElem)localObject3).uint32_service_type.set(33);
        ((im_msg_body.CommonElem)localObject3).uint32_business_type.set(1);
        ((im_msg_body.CommonElem)localObject3).bytes_pb_elem.set(ByteStringMicro.copyFrom(((hummer_commelem.MsgElemInfo_servtype33)localObject1).toByteArray()));
        localObject1 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject1).common_elem.set((MessageMicro)localObject3);
        paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_TencentImMsgIm_msg_body$RichText.elems.add((MessageMicro)localObject1);
      }
      else
      {
        localObject1 = new im_msg_body.Face();
        ((im_msg_body.Face)localObject1).index.set(j);
        localObject3 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject3).face.set((MessageMicro)localObject1);
        paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_TencentImMsgIm_msg_body$RichText.elems.add((MessageMicro)localObject3);
      }
      paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_Int += 1;
      paramEncodeRichTextFromStringMsgOne.b += 1;
      return;
    }
    if (paramEncodeRichTextFromStringMsgOne.b + 4 < paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_JavaLangString.length())
    {
      char[] arrayOfChar = new char[4];
      arrayOfChar[3] = paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_JavaLangString.charAt(paramEncodeRichTextFromStringMsgOne.b + 1);
      arrayOfChar[2] = paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_JavaLangString.charAt(paramEncodeRichTextFromStringMsgOne.b + 2);
      arrayOfChar[1] = paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_JavaLangString.charAt(paramEncodeRichTextFromStringMsgOne.b + 3);
      arrayOfChar[0] = paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_JavaLangString.charAt(paramEncodeRichTextFromStringMsgOne.b + 4);
      i = 0;
      while (i < 4)
      {
        if (arrayOfChar[i] == 'ú') {
          arrayOfChar[i] = '\n';
        } else if (arrayOfChar[i] == 'þ') {
          arrayOfChar[i] = '\r';
        }
        i += 1;
      }
      int[] arrayOfInt = EmosmUtils.a(arrayOfChar);
      localObject1 = BaseApplicationImpl.getContext();
      if (Build.VERSION.SDK_INT > 10) {
        i = 4;
      } else {
        i = 0;
      }
      localObject1 = ((BaseApplication)localObject1).getSharedPreferences("Last_Login", i).getString("uin", "");
      Object localObject4 = null;
      try
      {
        localObject3 = (AppInterface)BaseApplicationImpl.getApplication().getAppRuntime((String)localObject1);
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("[AccountNotMatchException],");
          ((StringBuilder)localObject3).append(localAccountNotMatchException.getMessage());
          QLog.d("MessageProtoCodecApiImpl", 2, ((StringBuilder)localObject3).toString());
        }
        localObject3 = null;
      }
      String str = QQText.SMALL_EMOJI_SYMBOL;
      Object localObject2 = str;
      if (localObject3 != null)
      {
        localObject2 = (IEmoticonManagerService)((AppInterface)localObject3).getRuntimeService(IEmoticonManagerService.class, "");
        localObject3 = localObject4;
        if (localObject2 != null) {
          localObject3 = ((IEmoticonManagerService)localObject2).syncFindEmoticonById(Integer.toString(arrayOfInt[0]), Integer.toString(arrayOfInt[1]));
        }
        localObject2 = str;
        if (localObject3 != null) {
          localObject2 = ((Emoticon)localObject3).character;
        }
      }
      i = arrayOfInt[0];
      j = arrayOfInt[1];
      localObject3 = new im_msg_body.SmallEmoji();
      ((im_msg_body.SmallEmoji)localObject3).packIdSum.set((i << 16) + j);
      if (arrayOfChar[3] == 'ÿ')
      {
        ((im_msg_body.SmallEmoji)localObject3).imageType.set(1);
      }
      else if (arrayOfChar[3] == 'ǿ')
      {
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("send apng epid = ");
          ((StringBuilder)localObject4).append(arrayOfInt[0]);
          ((StringBuilder)localObject4).append(" eid = ");
          ((StringBuilder)localObject4).append(arrayOfInt[1]);
          QLog.d("MessageProtoCodecApiImpl", 2, ((StringBuilder)localObject4).toString());
        }
        ((im_msg_body.SmallEmoji)localObject3).imageType.set(2);
      }
      localObject4 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject4).small_emoji.set((MessageMicro)localObject3);
      paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_TencentImMsgIm_msg_body$RichText.elems.add((MessageMicro)localObject4);
      paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_Int += 1;
      localObject3 = new im_msg_body.Text();
      ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localObject2 = new im_msg_body.Elem();
      ((im_msg_body.Elem)localObject2).text.set((MessageMicro)localObject3);
      paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_TencentImMsgIm_msg_body$RichText.elems.add((MessageMicro)localObject2);
      paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_Int += 1;
      paramEncodeRichTextFromStringMsgOne.b += 4;
    }
  }
  
  public void recordCookie(AppInterface paramAppInterface, byte[] paramArrayOfByte)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      ((QQAppInterface)paramAppInterface).getParcelHooker().a(paramArrayOfByte);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.api.impl.QMessageProtoCodecServiceImpl
 * JD-Core Version:    0.7.0.1
 */