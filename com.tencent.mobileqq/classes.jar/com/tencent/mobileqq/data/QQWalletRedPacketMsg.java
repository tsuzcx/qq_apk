package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qwallet.hb.aio.QQWalletBaseMsgElem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import tencent.im.msg.im_msg_body.QQWalletAioBody;

public class QQWalletRedPacketMsg
  implements ISafeStream
{
  public String authkey;
  public QQWalletAioBodyReserve body;
  private int channelId;
  public int conftype;
  public QQWalletBaseMsgElem elem;
  public String envelopeName;
  public int envelopeid;
  public boolean isOpened;
  public int msgFrom;
  public int redChannel;
  public String redPacketId;
  public String redPacketIndex;
  public int redtype;
  private int resend;
  public List<Long> specifyUinList = new ArrayList();
  public int templateId;
  
  public QQWalletRedPacketMsg()
  {
    this.body = new QQWalletAioBodyReserve();
  }
  
  public QQWalletRedPacketMsg(im_msg_body.QQWalletAioBody paramQQWalletAioBody, String paramString)
  {
    if ((paramQQWalletAioBody != null) && (!TextUtils.isEmpty(paramString)))
    {
      this.elem = new QQWalletBaseMsgElem(paramQQWalletAioBody.receiver);
      this.body = new QQWalletAioBodyReserve(paramQQWalletAioBody);
      this.channelId = paramQQWalletAioBody.sint32_channelid.get();
      this.templateId = paramQQWalletAioBody.sint32_templateid.get();
      this.resend = paramQQWalletAioBody.uint32_resend.get();
      this.redtype = paramQQWalletAioBody.sint32_redtype.get();
      this.redPacketId = paramQQWalletAioBody.bytes_billno.get().toStringUtf8();
      this.authkey = paramQQWalletAioBody.bytes_authkey.get().toStringUtf8();
      this.envelopeid = paramQQWalletAioBody.sint32_envelopeid.get();
      this.envelopeName = paramQQWalletAioBody.bytes_name.get().toStringUtf8();
      this.conftype = paramQQWalletAioBody.sint32_redtype.get();
      this.msgFrom = paramQQWalletAioBody.sint32_msg_from.get();
      this.redPacketIndex = paramQQWalletAioBody.string_index.get().toStringUtf8();
      paramString = paramQQWalletAioBody.uint64_grap_uin.get();
      if (paramString != null) {
        this.specifyUinList = paramString;
      }
      this.redChannel = paramQQWalletAioBody.uint32_redchannel.get();
      return;
    }
    this.body = new QQWalletAioBodyReserve();
  }
  
  public byte[] flushMsgData(int paramInt)
  {
    QwSafeOutputStream localQwSafeOutputStream1;
    QwSafeOutputStream localQwSafeOutputStream2;
    try
    {
      localQwSafeOutputStream1 = new QwSafeOutputStream();
      try
      {
        writeHeader(localQwSafeOutputStream1, paramInt);
        writeExternal(localQwSafeOutputStream1);
        localQwSafeOutputStream2 = localQwSafeOutputStream1;
      }
      catch (Exception localException1) {}
      localQwSafeOutputStream2 = localQwSafeOutputStream1;
    }
    catch (Exception localException2)
    {
      localQwSafeOutputStream1 = null;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.msg.qqwalletmsg", 2, "QQWalletRedPacketMsg write Exception", localException2);
      localQwSafeOutputStream2 = localQwSafeOutputStream1;
    }
    if (localQwSafeOutputStream2 != null) {
      return localQwSafeOutputStream2.flushDataAndCloseStream();
    }
    return null;
  }
  
  public void readExternal(QwSafeInputStream paramQwSafeInputStream)
  {
    this.elem = new QQWalletBaseMsgElem();
    this.elem.jdField_a_of_type_Int = paramQwSafeInputStream.readInt();
    this.elem.jdField_b_of_type_Int = paramQwSafeInputStream.readInt();
    this.elem.jdField_a_of_type_JavaLangString = paramQwSafeInputStream.readUTF();
    this.elem.jdField_b_of_type_JavaLangString = paramQwSafeInputStream.readUTF();
    this.elem.jdField_c_of_type_JavaLangString = paramQwSafeInputStream.readUTF();
    this.elem.jdField_d_of_type_JavaLangString = paramQwSafeInputStream.readUTF();
    this.elem.jdField_e_of_type_JavaLangString = paramQwSafeInputStream.readUTF();
    this.elem.jdField_f_of_type_JavaLangString = paramQwSafeInputStream.readUTF();
    this.channelId = paramQwSafeInputStream.readInt();
    this.templateId = paramQwSafeInputStream.readInt();
    this.resend = paramQwSafeInputStream.readInt();
    this.redtype = paramQwSafeInputStream.readInt();
    this.redPacketId = paramQwSafeInputStream.readUTF();
    this.authkey = paramQwSafeInputStream.readUTF();
    this.isOpened = paramQwSafeInputStream.readBoolean();
    this.elem.jdField_c_of_type_Int = paramQwSafeInputStream.readInt();
    this.elem.jdField_d_of_type_Int = paramQwSafeInputStream.readInt();
    this.elem.jdField_g_of_type_JavaLangString = paramQwSafeInputStream.readUTF();
    this.elem.jdField_h_of_type_JavaLangString = paramQwSafeInputStream.readUTF();
    this.elem.jdField_i_of_type_JavaLangString = paramQwSafeInputStream.readUTF();
    this.elem.jdField_j_of_type_JavaLangString = paramQwSafeInputStream.readUTF();
    this.elem.jdField_e_of_type_Int = paramQwSafeInputStream.readInt(13487565);
    this.elem.jdField_f_of_type_Int = paramQwSafeInputStream.readInt(-1);
    this.elem.jdField_k_of_type_JavaLangString = paramQwSafeInputStream.readUTF();
    this.elem.jdField_l_of_type_JavaLangString = paramQwSafeInputStream.readUTF();
    this.elem.jdField_m_of_type_JavaLangString = paramQwSafeInputStream.readUTF();
    this.envelopeid = paramQwSafeInputStream.readInt(-1);
    this.envelopeName = paramQwSafeInputStream.readUTF();
    this.conftype = paramQwSafeInputStream.readInt(-1);
    this.msgFrom = paramQwSafeInputStream.readInt(-1);
    this.redPacketIndex = paramQwSafeInputStream.readUTF();
    this.redChannel = paramQwSafeInputStream.readInt();
    this.specifyUinList = ((List)paramQwSafeInputStream.readObject(new ArrayList()));
    this.elem.jdField_g_of_type_Int = paramQwSafeInputStream.readInt(12000);
    this.elem.jdField_h_of_type_Int = paramQwSafeInputStream.readInt();
    this.elem.jdField_i_of_type_Int = paramQwSafeInputStream.readInt();
    this.elem.jdField_j_of_type_Int = paramQwSafeInputStream.readInt();
    this.elem.jdField_k_of_type_Int = paramQwSafeInputStream.readInt();
    this.elem.jdField_l_of_type_Int = paramQwSafeInputStream.readInt();
    this.elem.jdField_m_of_type_Int = paramQwSafeInputStream.readInt();
    this.elem.jdField_n_of_type_Int = paramQwSafeInputStream.readInt();
    this.elem.o = paramQwSafeInputStream.readInt();
    this.body.feedId = paramQwSafeInputStream.readUTF();
    this.elem.jdField_n_of_type_JavaLangString = paramQwSafeInputStream.readUTF();
    this.body.subChannel = paramQwSafeInputStream.readInt();
    this.body.poemRule = paramQwSafeInputStream.readUTF();
    this.body.makeHbExtend = paramQwSafeInputStream.readUTF();
    this.body.shengpiziMask = paramQwSafeInputStream.readUTF();
    this.body.shengpiziMD5 = paramQwSafeInputStream.readUTF();
    if (QLog.isColorLevel())
    {
      paramQwSafeInputStream = new StringBuilder();
      paramQwSafeInputStream.append("readExternal redtype=");
      paramQwSafeInputStream.append(this.redtype);
      paramQwSafeInputStream.append(", skinId=");
      paramQwSafeInputStream.append(this.elem.jdField_i_of_type_Int);
      paramQwSafeInputStream.append(", effectsId=");
      paramQwSafeInputStream.append(this.elem.jdField_j_of_type_Int);
      paramQwSafeInputStream.append(", special_pop_id=");
      paramQwSafeInputStream.append(this.elem.jdField_k_of_type_Int);
      paramQwSafeInputStream.append(", themeId=");
      paramQwSafeInputStream.append(this.elem.jdField_l_of_type_Int);
      QLog.d("QQWalletRedPacketMsg", 2, paramQwSafeInputStream.toString());
    }
  }
  
  public void writeExternal(QwSafeOutputStream paramQwSafeOutputStream)
  {
    paramQwSafeOutputStream.writeInt(this.elem.jdField_a_of_type_Int);
    paramQwSafeOutputStream.writeInt(this.elem.jdField_b_of_type_Int);
    paramQwSafeOutputStream.writeUTF(this.elem.jdField_a_of_type_JavaLangString);
    paramQwSafeOutputStream.writeUTF(this.elem.jdField_b_of_type_JavaLangString);
    paramQwSafeOutputStream.writeUTF(this.elem.jdField_c_of_type_JavaLangString);
    paramQwSafeOutputStream.writeUTF(this.elem.jdField_d_of_type_JavaLangString);
    paramQwSafeOutputStream.writeUTF(this.elem.jdField_e_of_type_JavaLangString);
    paramQwSafeOutputStream.writeUTF(this.elem.jdField_f_of_type_JavaLangString);
    paramQwSafeOutputStream.writeInt(this.channelId);
    paramQwSafeOutputStream.writeInt(this.templateId);
    paramQwSafeOutputStream.writeInt(this.resend);
    paramQwSafeOutputStream.writeInt(this.redtype);
    paramQwSafeOutputStream.writeUTF(this.redPacketId);
    paramQwSafeOutputStream.writeUTF(this.authkey);
    paramQwSafeOutputStream.writeBoolean(this.isOpened);
    paramQwSafeOutputStream.writeInt(this.elem.jdField_c_of_type_Int);
    paramQwSafeOutputStream.writeInt(this.elem.jdField_d_of_type_Int);
    paramQwSafeOutputStream.writeUTF(this.elem.jdField_g_of_type_JavaLangString);
    paramQwSafeOutputStream.writeUTF(this.elem.jdField_h_of_type_JavaLangString);
    paramQwSafeOutputStream.writeUTF(this.elem.jdField_i_of_type_JavaLangString);
    paramQwSafeOutputStream.writeUTF(this.elem.jdField_j_of_type_JavaLangString);
    paramQwSafeOutputStream.writeInt(this.elem.jdField_e_of_type_Int);
    paramQwSafeOutputStream.writeInt(this.elem.jdField_f_of_type_Int);
    paramQwSafeOutputStream.writeUTF(this.elem.jdField_k_of_type_JavaLangString);
    paramQwSafeOutputStream.writeUTF(this.elem.jdField_l_of_type_JavaLangString);
    paramQwSafeOutputStream.writeUTF(this.elem.jdField_m_of_type_JavaLangString);
    paramQwSafeOutputStream.writeInt(this.envelopeid);
    paramQwSafeOutputStream.writeUTF(this.envelopeName);
    paramQwSafeOutputStream.writeInt(this.conftype);
    paramQwSafeOutputStream.writeInt(this.msgFrom);
    paramQwSafeOutputStream.writeUTF(this.redPacketIndex);
    paramQwSafeOutputStream.writeInt(this.redChannel);
    paramQwSafeOutputStream.writeObject(this.specifyUinList);
    paramQwSafeOutputStream.writeInt(this.elem.jdField_g_of_type_Int);
    paramQwSafeOutputStream.writeInt(this.elem.jdField_h_of_type_Int);
    paramQwSafeOutputStream.writeInt(this.elem.jdField_i_of_type_Int);
    paramQwSafeOutputStream.writeInt(this.elem.jdField_j_of_type_Int);
    paramQwSafeOutputStream.writeInt(this.elem.jdField_k_of_type_Int);
    paramQwSafeOutputStream.writeInt(this.elem.jdField_l_of_type_Int);
    paramQwSafeOutputStream.writeInt(this.elem.jdField_m_of_type_Int);
    paramQwSafeOutputStream.writeInt(this.elem.jdField_n_of_type_Int);
    paramQwSafeOutputStream.writeInt(this.elem.o);
    paramQwSafeOutputStream.writeUTF(this.body.feedId);
    paramQwSafeOutputStream.writeUTF(this.elem.jdField_n_of_type_JavaLangString);
    paramQwSafeOutputStream.writeInt(this.body.subChannel);
    paramQwSafeOutputStream.writeUTF(this.body.poemRule);
    paramQwSafeOutputStream.writeUTF(this.body.makeHbExtend);
    paramQwSafeOutputStream.writeUTF(this.body.shengpiziMask);
    paramQwSafeOutputStream.writeUTF(this.body.shengpiziMD5);
  }
  
  public void writeHeader(QwSafeOutputStream paramQwSafeOutputStream, int paramInt)
  {
    paramQwSafeOutputStream.writeInt(32);
    paramQwSafeOutputStream.writeInt(2);
    paramQwSafeOutputStream.writeInt(2);
    paramQwSafeOutputStream.writeInt(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.QQWalletRedPacketMsg
 * JD-Core Version:    0.7.0.1
 */