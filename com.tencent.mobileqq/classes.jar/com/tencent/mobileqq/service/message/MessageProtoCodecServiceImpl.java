package com.tencent.mobileqq.service.message;

import android.content.SharedPreferences;
import android.os.Build.VERSION;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.message.hookparcel.ParcelHooker;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
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

public class MessageProtoCodecServiceImpl
  implements IQMessageProtoCodecService
{
  private static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "MessageProtoCodecServiceImpl";
  }
  
  public void a(AppInterface paramAppInterface, byte[] paramArrayOfByte)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      ((QQAppInterface)paramAppInterface).getParcelHooker().a(paramArrayOfByte);
    }
  }
  
  public void a(QMessageProtoCodec.EncodeRichTextFromStringMsgOne paramEncodeRichTextFromStringMsgOne)
  {
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
        paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_Int += 1;
        paramEncodeRichTextFromStringMsgOne.b += 1;
      }
    }
    while (paramEncodeRichTextFromStringMsgOne.b + 4 >= paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_JavaLangString.length()) {
      for (;;)
      {
        return;
        localObject1 = new im_msg_body.Face();
        ((im_msg_body.Face)localObject1).index.set(j);
        localObject3 = new im_msg_body.Elem();
        ((im_msg_body.Elem)localObject3).face.set((MessageMicro)localObject1);
        paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_TencentImMsgIm_msg_body$RichText.elems.add((MessageMicro)localObject3);
      }
    }
    Object localObject4 = new char[4];
    localObject4[3] = paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_JavaLangString.charAt(paramEncodeRichTextFromStringMsgOne.b + 1);
    localObject4[2] = paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_JavaLangString.charAt(paramEncodeRichTextFromStringMsgOne.b + 2);
    localObject4[1] = paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_JavaLangString.charAt(paramEncodeRichTextFromStringMsgOne.b + 3);
    localObject4[0] = paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_JavaLangString.charAt(paramEncodeRichTextFromStringMsgOne.b + 4);
    i = 0;
    if (i < 4)
    {
      if (localObject4[i] == 'ú') {
        localObject4[i] = 10;
      }
      for (;;)
      {
        i += 1;
        break;
        if (localObject4[i] == 'þ') {
          localObject4[i] = 13;
        }
      }
    }
    int[] arrayOfInt = EmosmUtils.a((char[])localObject4);
    Object localObject1 = BaseApplicationImpl.getContext();
    if (Build.VERSION.SDK_INT > 10) {
      i = 4;
    }
    for (;;)
    {
      localObject1 = ((BaseApplication)localObject1).getSharedPreferences("Last_Login", i).getString("uin", "");
      try
      {
        localObject1 = (AppInterface)BaseApplicationImpl.getApplication().getAppRuntime((String)localObject1);
        localObject3 = QQText.SMALL_EMOJI_SYMBOL;
        if (localObject1 != null)
        {
          localObject1 = (EmoticonManager)((AppInterface)localObject1).getManager(QQManagerFactory.EMOTICON_MANAGER);
          if (localObject1 == null) {
            break label846;
          }
          localObject1 = ((EmoticonManager)localObject1).a(Integer.toString(arrayOfInt[0]), Integer.toString(arrayOfInt[1]));
          if (localObject1 != null)
          {
            localObject1 = ((Emoticon)localObject1).character;
            i = arrayOfInt[0];
            j = arrayOfInt[1];
            localObject3 = new im_msg_body.SmallEmoji();
            ((im_msg_body.SmallEmoji)localObject3).packIdSum.set((i << 16) + j);
            if (localObject4[3] == 'ÿ')
            {
              ((im_msg_body.SmallEmoji)localObject3).imageType.set(1);
              localObject4 = new im_msg_body.Elem();
              ((im_msg_body.Elem)localObject4).small_emoji.set((MessageMicro)localObject3);
              paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_TencentImMsgIm_msg_body$RichText.elems.add((MessageMicro)localObject4);
              paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_Int += 1;
              localObject3 = new im_msg_body.Text();
              ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFromUtf8((String)localObject1));
              localObject1 = new im_msg_body.Elem();
              ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject3);
              paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_TencentImMsgIm_msg_body$RichText.elems.add((MessageMicro)localObject1);
              paramEncodeRichTextFromStringMsgOne.jdField_a_of_type_Int += 1;
              paramEncodeRichTextFromStringMsgOne.b += 4;
              return;
              i = 0;
            }
          }
        }
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "[AccountNotMatchException]," + localAccountNotMatchException.getMessage());
          }
          Object localObject2 = null;
          continue;
          if (localObject4[3] == 'ǿ')
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "send apng epid = " + arrayOfInt[0] + " eid = " + arrayOfInt[1]);
            }
            ((im_msg_body.SmallEmoji)localObject3).imageType.set(2);
            continue;
            localObject2 = localObject3;
            continue;
            label846:
            localObject2 = null;
          }
        }
      }
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return (paramString.charAt(paramInt) == '\024') && (paramInt + 1 < paramString.length());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.MessageProtoCodecServiceImpl
 * JD-Core Version:    0.7.0.1
 */