package com.tencent.mobileqq.nearby;

import amtj;
import android.os.Bundle;
import android.text.TextUtils;
import bcji;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

public class NearbyFlowerMessage
  implements Serializable
{
  public static final int FLOWER_SERVICE_ID = 52;
  public static final String FLOWER_TYPE_DATING = "2";
  public static final String FLOWER_TYPE_HOTCHAT = "3";
  public static final String FLOWER_TYPE_NEARBY = "1";
  public static final String FLOWER_TYPE_RANDOM = "4";
  private static final long serialVersionUID = 1L;
  public String bgPic = "";
  public String brief = "";
  public String cMean = "";
  public String common = "";
  public String fCount = "";
  public String fMean = "";
  public String fPic = "";
  public String frienduin;
  public String fromName = "";
  public String fromUrl = "";
  public String groupCode;
  public boolean is1v1;
  public boolean isAnonymous;
  public boolean isRead;
  public boolean isReceive;
  public boolean isSend;
  public long msgTime;
  public String pID = "";
  public String pURL = "";
  public String rNick = "";
  public String rUin = "";
  public String sID = "";
  public String sNick = "";
  public String sUin = "";
  public int score;
  public int serviceID = -1;
  public long time;
  public String toName = "";
  public String toUrl = "";
  public String version = "";
  
  public NearbyFlowerMessage(QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyFlowerMessage", 2, "msgType: " + paramMessageForStructing.msgtype + ", uinType: " + paramMessageForStructing.istroop + ", selfUin: " + paramMessageForStructing.selfuin + ", senderUin: " + paramMessageForStructing.senderuin + ", friendUin: " + paramMessageForStructing.frienduin);
    }
    bind(paramQQAppInterface, paramMessageForStructing);
  }
  
  public static String getFlowerMsgVersion(MessageForStructing paramMessageForStructing)
  {
    if ((paramMessageForStructing.structingMsg instanceof StructMsgForGeneralShare))
    {
      paramMessageForStructing = (StructMsgForGeneralShare)paramMessageForStructing.structingMsg;
      if ((paramMessageForStructing.mMsgServiceID == 52) && (paramMessageForStructing.getItemCount() > 0))
      {
        paramMessageForStructing = paramMessageForStructing.getItemByIndex(0);
        if ((paramMessageForStructing instanceof bcji))
        {
          paramMessageForStructing = (bcji)paramMessageForStructing;
          if (!paramMessageForStructing.jdField_a_of_type_Boolean) {
            paramMessageForStructing.a();
          }
          paramMessageForStructing = paramMessageForStructing.jdField_a_of_type_AndroidOsBundle.getString("version");
          if (paramMessageForStructing == null) {}
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("NearbyFlowerMessage", 2, "version: " + paramMessageForStructing);
      }
      return paramMessageForStructing;
      paramMessageForStructing = "";
    }
  }
  
  public void bind(QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing)
  {
    if (paramMessageForStructing == null) {}
    for (;;)
    {
      return;
      this.time = System.currentTimeMillis();
      this.frienduin = paramMessageForStructing.frienduin;
      this.isRead = paramMessageForStructing.isread;
      this.msgTime = paramMessageForStructing.time;
      if (!(paramMessageForStructing.structingMsg instanceof StructMsgForGeneralShare)) {
        continue;
      }
      paramMessageForStructing = (StructMsgForGeneralShare)paramMessageForStructing.structingMsg;
      this.serviceID = paramMessageForStructing.mMsgServiceID;
      if ((this.serviceID != 52) || (paramMessageForStructing.getItemCount() <= 0)) {
        continue;
      }
      paramMessageForStructing = paramMessageForStructing.getItemByIndex(0);
      if (!(paramMessageForStructing instanceof bcji)) {
        continue;
      }
      paramMessageForStructing = (bcji)paramMessageForStructing;
      if (!paramMessageForStructing.jdField_a_of_type_Boolean)
      {
        if (QLog.isColorLevel()) {
          QLog.i("NearbyFlowerMessage", 2, "need init data.");
        }
        paramMessageForStructing.a();
      }
      this.version = paramMessageForStructing.jdField_a_of_type_AndroidOsBundle.getString("version");
      this.bgPic = paramMessageForStructing.jdField_a_of_type_AndroidOsBundle.getString("bgPic");
      this.fPic = paramMessageForStructing.jdField_a_of_type_AndroidOsBundle.getString("fPic");
      this.sNick = paramMessageForStructing.jdField_a_of_type_AndroidOsBundle.getString("sNick");
      this.rNick = paramMessageForStructing.jdField_a_of_type_AndroidOsBundle.getString("rNick");
      this.common = paramMessageForStructing.jdField_a_of_type_AndroidOsBundle.getString("common");
      this.fMean = paramMessageForStructing.jdField_a_of_type_AndroidOsBundle.getString("fMean");
      this.cMean = paramMessageForStructing.jdField_a_of_type_AndroidOsBundle.getString("cMean");
      this.pID = paramMessageForStructing.jdField_a_of_type_AndroidOsBundle.getString("pID");
      this.pURL = paramMessageForStructing.jdField_a_of_type_AndroidOsBundle.getString("pURL");
      this.fCount = paramMessageForStructing.jdField_a_of_type_AndroidOsBundle.getString("fCount");
      this.sUin = paramMessageForStructing.jdField_a_of_type_AndroidOsBundle.getString("sUin");
      this.rUin = paramMessageForStructing.jdField_a_of_type_AndroidOsBundle.getString("rUin");
      this.groupCode = paramMessageForStructing.jdField_a_of_type_AndroidOsBundle.getString("groupCode");
      Object localObject = paramMessageForStructing.jdField_a_of_type_AndroidOsBundle.getString("score");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
      try
      {
        this.score = Integer.parseInt((String)localObject);
        this.sID = paramMessageForStructing.jdField_a_of_type_AndroidOsBundle.getString("sID");
        this.isSend = paramMessageForStructing.jdField_a_of_type_AndroidOsBundle.getBoolean("isSend", false);
        this.isReceive = paramMessageForStructing.jdField_a_of_type_AndroidOsBundle.getBoolean("isReceive", false);
        localObject = paramMessageForStructing.jdField_a_of_type_AndroidOsBundle.getString("anonyInfo");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = ((String)localObject).split("\\|");
          String str;
          int i;
          if ((localObject.length > 0) && (!TextUtils.isEmpty(localObject[0])))
          {
            str = paramQQAppInterface.getAVNotifyCenter().b(this.sUin);
            if (!TextUtils.isEmpty(str))
            {
              i = str.lastIndexOf("voice_hall_avatar_");
              this.fromUrl = (str.substring(0, i) + "voice_hall_avatar_" + localObject[0]);
            }
          }
          else
          {
            if (localObject.length > 1) {
              this.fromName = localObject[1];
            }
            if ((localObject.length > 2) && (!TextUtils.isEmpty(localObject[2])))
            {
              str = paramQQAppInterface.getAVNotifyCenter().b(this.rUin);
              if (TextUtils.isEmpty(str)) {
                break label845;
              }
              i = str.lastIndexOf("voice_hall_avatar_");
              this.toUrl = (str.substring(0, i) + "voice_hall_avatar_" + localObject[2]);
            }
            if (localObject.length > 3) {
              this.toName = localObject[3];
            }
            if (localObject.length > 4) {
              this.is1v1 = "1".equals(localObject[4]);
            }
            this.isAnonymous = true;
          }
        }
        else
        {
          if (!this.isAnonymous) {
            break label1011;
          }
          if (!this.is1v1) {
            break label962;
          }
          if (!this.isSend) {
            break label875;
          }
          this.brief = (amtj.a(2131706267) + this.toName + amtj.a(2131706272));
          if (QLog.isColorLevel()) {
            QLog.i("NearbyFlowerMessage", 2, paramMessageForStructing.jdField_a_of_type_AndroidOsBundle.toString());
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("NearbyFlowerMessage", 2, "isAnonymous: " + this.isAnonymous + ", fromUrl: " + this.fromUrl + ", fromName: " + this.fromName + ", toUrl: " + this.toUrl + ", toName: " + this.toName + ", brief: " + this.brief);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        label962:
        for (;;)
        {
          this.score = 0;
          continue;
          this.fromUrl = ("voice_hall_avatar_" + localThrowable[0]);
          continue;
          label845:
          this.toUrl = ("voice_hall_avatar_" + localThrowable[2]);
          continue;
          label875:
          if (this.isReceive)
          {
            if ((TextUtils.isEmpty(this.fromName)) || (TextUtils.equals(this.fromName, "null"))) {
              this.fromName = paramQQAppInterface.getAVNotifyCenter().a(this.sUin);
            }
            this.brief = (this.fromName + amtj.a(2131706271) + amtj.a(2131706264));
            continue;
            this.brief = (this.fromName + amtj.a(2131706263) + this.toName + amtj.a(2131706268));
            continue;
            label1011:
            this.brief = (this.sNick + amtj.a(2131706270) + this.rNick + amtj.a(2131706273));
          }
        }
      }
    }
  }
  
  public String toString()
  {
    return "isAnonymous: " + this.isAnonymous + ", isSend: " + this.isSend + ", isReceive: " + this.isReceive + ", fromUrl: " + this.fromUrl + ", fromName: " + this.fromName + ", toUrl: " + this.toUrl + ", toName: " + this.toName + ", brief: " + this.brief;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.NearbyFlowerMessage
 * JD-Core Version:    0.7.0.1
 */