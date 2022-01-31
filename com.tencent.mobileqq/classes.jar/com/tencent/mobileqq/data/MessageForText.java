package com.tencent.mobileqq.data;

import ActionMsg.MsgBody;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.eqq.CrmIvrText;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.widgets.PubAccountQQText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.mobileqq.lovelanguage.LoveLanguageManager;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;

public class MessageForText
  extends RecommendCommonMessage
{
  private static final boolean DEBUG_LOG = true;
  public static final int SPAN_TYPE_EMOJI = 1;
  public static final int SPAN_TYPE_LINK = 0;
  public static final int SPAN_TYPE_SYS_EMOTCATION = 2;
  private static final String TAG = "MessageForText";
  public String action;
  public String latitude;
  public String location;
  public URL locationUrl;
  public String longitude;
  public boolean mIsMsgSignalOpen;
  public long mMsgSendTime;
  public int mMsgSignalCount;
  public int mMsgSignalNetType;
  public int mMsgSignalSum;
  public int mPasswdRedBagFlag;
  public long mPasswdRedBagSender;
  public long mWantGiftSenderUin;
  public int msgVia;
  public CharSequence sb;
  public CharSequence sb2;
  public String url;
  
  private void parseStickerMsg()
  {
    Object localObject;
    if ((EmojiStickerManager.a(this)) && ((this.extLong & 0x4) > 0) && (EmojiStickerManager.e))
    {
      System.currentTimeMillis();
      localObject = getExtInfoFromExtStr("sticker_info");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (this.msgtype == -1000) {
          this.msgtype = -2058;
        }
        localObject = EmojiStickerManager.StickerInfo.transformFromJson((String)localObject);
        if (localObject != null)
        {
          ((EmojiStickerManager.StickerInfo)localObject).isDisplayed = this.isread;
          this.stickerInfo = ((EmojiStickerManager.StickerInfo)localObject);
        }
      }
    }
    do
    {
      do
      {
        System.currentTimeMillis();
        do
        {
          return;
        } while (this.msgtype != -2058);
        localObject = getExtInfoFromExtStr("sticker_info");
      } while (TextUtils.isEmpty((CharSequence)localObject));
      localObject = EmojiStickerManager.StickerInfo.transformFromJson((String)localObject);
    } while (localObject == null);
    ((EmojiStickerManager.StickerInfo)localObject).isDisplayed = this.isread;
    this.stickerInfo = ((EmojiStickerManager.StickerInfo)localObject);
  }
  
  protected void doParse()
  {
    boolean bool3 = true;
    super.doParse();
    doParse(false);
    String str1 = getExtInfoFromExtStr("sens_msg_need_parse");
    if (!TextUtils.isEmpty(str1)) {}
    String str2;
    do
    {
      for (;;)
      {
        try
        {
          bool1 = Boolean.parseBoolean(str1);
          boolean bool2 = bool1;
          if (bool1) {
            if (!(BaseActivity.sTopActivity instanceof MultiForwardActivity))
            {
              bool2 = bool1;
              if (!(BaseActivity.sTopActivity instanceof ChatHistoryForC2C)) {}
            }
            else
            {
              bool2 = false;
            }
          }
          if (bool2) {
            break;
          }
          return;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        bool1 = true;
      }
      str2 = getExtInfoFromExtStr("sens_msg_ctrl_info");
    } while (TextUtils.isEmpty(str2));
    Object localObject = getExtInfoFromExtStr("sens_msg_confirmed");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equalsIgnoreCase("1"))) {}
    for (boolean bool1 = bool3;; bool1 = false)
    {
      if (!bool1) {
        saveExtInfoToExtStr("sens_msg_original_text", this.msg);
      }
      localObject = new CopyOnWriteArrayList();
      ((List)localObject).add(this);
      MQPSensitiveMsgUtil.a(this, (List)localObject, bool1, HexUtil.hexStr2Bytes(str2));
      return;
    }
  }
  
  protected void doParse(boolean paramBoolean)
  {
    boolean bool = false;
    Object localObject1 = this.msg;
    Object localObject2 = localObject1;
    if (this.msgtype == -1003)
    {
      localObject1 = ActionMsgUtil.a((String)localObject1);
      this.action = ((MsgBody)localObject1).action;
      localObject2 = ((MsgBody)localObject1).msg;
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    int i;
    if (!paramBoolean)
    {
      i = ((String)localObject1).indexOf("http://maps.google.com/maps?q=");
      if (i != -1)
      {
        this.url = ((String)localObject1).substring(i);
        localObject2 = MessageUtils.a(this.url);
        this.latitude = localObject2[0];
        this.longitude = localObject2[1];
        this.location = localObject2[2];
        if ((TextUtils.isEmpty(this.latitude)) || (TextUtils.isEmpty(this.longitude))) {
          break label832;
        }
      }
    }
    for (;;)
    {
      try
      {
        Float.parseFloat(this.latitude);
        Float.parseFloat(this.longitude);
        i = 1;
      }
      catch (Exception localException2)
      {
        try
        {
          i = AIOUtils.a(200.0F, BaseApplication.getContext().getResources());
          int j = AIOUtils.a(100.0F, BaseApplication.getContext().getResources());
          localObject2 = new StringBuilder("http://st.map.soso.com/api");
          ((StringBuilder)localObject2).append("?size=").append(i).append("*").append(j);
          ((StringBuilder)localObject2).append("&center=").append(this.longitude).append(",").append(this.latitude);
          ((StringBuilder)localObject2).append("&zoom=14");
          ((StringBuilder)localObject2).append("&markers=").append(this.longitude).append(",").append(this.latitude).append(",").append("red");
          this.locationUrl = new URL(((StringBuilder)localObject2).toString());
          if (this.istroop != 1008) {
            continue;
          }
          this.sb = new PubAccountQQText((CharSequence)localObject1, 13);
          ((PubAccountQQText)this.sb).a = this.selfuin;
          ((PubAccountQQText)this.sb).b = this.frienduin;
          return;
          localException2 = localException2;
          i = 0;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          this.locationUrl = null;
          localMalformedURLException.printStackTrace();
          continue;
        }
        this.locationUrl = null;
        continue;
        if ((this.istroop != 1024) || (isSendFromLocal())) {
          continue;
        }
        Object localObject3 = null;
        try
        {
          localAppRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.selfuin);
          localObject3 = localAppRuntime;
          if (!QQAppInterface.class.isInstance(localAppRuntime)) {
            continue;
          }
          localObject3 = localAppRuntime;
          paramBoolean = CrmUtils.a((QQAppInterface)localAppRuntime, this.frienduin, this.istroop);
        }
        catch (AccountNotMatchException localAccountNotMatchException)
        {
          AppRuntime localAppRuntime;
          localAccountNotMatchException.printStackTrace();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("MessageForText", 2, String.format("User %s don't match current accound", new Object[] { this.selfuin }));
          paramBoolean = bool;
          localObject4 = localObject3;
          continue;
          this.sb = new QQText((CharSequence)localObject1, 13, 32, this);
          return;
        }
        if (!paramBoolean) {
          continue;
        }
        this.sb = new CrmIvrText((CharSequence)localObject1, 13, 32, this, this.frienduin, this.selfuin, (QQAppInterface)localAppRuntime);
        return;
        localObject3 = localAppRuntime;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject3 = localAppRuntime;
        QLog.d("MessageForText", 2, "We get error AppRuntime");
        paramBoolean = false;
        continue;
        localObject3 = localObject1;
        if (!LoveLanguageManager.a(this)) {
          continue;
        }
        Object localObject4 = BaseApplicationImpl.sApplication.getRuntime();
        localObject3 = localObject1;
        if (!QQAppInterface.class.isInstance(localObject4)) {
          continue;
        }
        localObject3 = localObject1;
        if (!((LoveLanguageManager)((QQAppInterface)localObject4).getManager(273)).b()) {
          continue;
        }
        localObject3 = LoveLanguageManager.a((String)localObject1);
        this.sb = new QQText((CharSequence)localObject3, 13, 32, this);
        localObject1 = getExtInfoFromExtStr("disc_at_info_list");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          continue;
        }
        localObject3 = new StringBuilder((String)localObject3);
        try
        {
          localObject4 = BaseApplicationImpl.sApplication.getRuntime();
          if (QQAppInterface.class.isInstance(localObject4))
          {
            this.msg2 = AtTroopMemberSpan.a((QQAppInterface)localObject4, (StringBuilder)localObject3, (String)localObject1, this.frienduin, isSend()).toString();
            if ((LoveLanguageManager.a(this)) && (((LoveLanguageManager)((QQAppInterface)localObject4).getManager(273)).b())) {
              this.msg2 = LoveLanguageManager.a(this.msg2);
            }
            this.sb2 = new QQText(this.msg2, 13, 32, this);
            return;
          }
        }
        catch (Exception localException1)
        {
          QLog.e("MessageForText", 1, "replaceAtMsgByMarkName", localException1);
          return;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MessageForText", 2, "We get error AppRuntime");
        return;
      }
      if (i != 0) {}
      label832:
      i = 0;
    }
  }
  
  public String getSummaryMsg()
  {
    return this.sb.toString();
  }
  
  public boolean isSupportFTS()
  {
    return MsgProxyUtils.v(this.istroop);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  protected void postRead()
  {
    super.postRead();
    parseStickerMsg();
  }
  
  protected void prewrite()
  {
    String str2 = getExtInfoFromExtStr("sens_msg_original_text");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.msg;
    }
    this.msg = str1;
    this.msgData = str1.getBytes();
  }
  
  public void setSendMsgParams(ChatActivityFacade.SendMsgParams paramSendMsgParams)
  {
    this.mMsgSignalSum = paramSendMsgParams.jdField_a_of_type_Int;
    this.mMsgSignalCount = paramSendMsgParams.jdField_b_of_type_Int;
    this.mIsMsgSignalOpen = paramSendMsgParams.jdField_c_of_type_Boolean;
    this.mMsgSignalNetType = paramSendMsgParams.jdField_c_of_type_Int;
    this.mMsgSendTime = paramSendMsgParams.jdField_a_of_type_Long;
    this.mPasswdRedBagFlag = paramSendMsgParams.jdField_d_of_type_Int;
    this.mPasswdRedBagSender = paramSendMsgParams.jdField_b_of_type_Long;
    if ((this instanceof MessageForFoldMsg)) {
      ((MessageForFoldMsg)this).foldFlagTemp = paramSendMsgParams.jdField_d_of_type_Boolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForText
 * JD-Core Version:    0.7.0.1
 */