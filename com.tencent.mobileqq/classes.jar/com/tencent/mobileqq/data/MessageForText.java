package com.tencent.mobileqq.data;

import ActionMsg.MsgBody;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.biz.eqq.CrmIvrText;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.widgets.PubAccountQQText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.MsgProxyUtils;
import com.tencent.mobileqq.activity.ChatActivityFacade.SendMsgParams;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.StickerInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.vas.ColorNickManager;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageForText
  extends RecommendCommonMessage
{
  private static final boolean DEBUG_LOG = true;
  public static final int SPAN_TYPE_EMOJI = 1;
  public static final int SPAN_TYPE_LINK = 0;
  public static final int SPAN_TYPE_SYS_EMOTCATION = 2;
  private static final String TAG = "MessageForText";
  public String action;
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
  
  public static ArrayList<AtTroopMemberInfo> getTroopMemberInfoFromExtrJson(String paramString)
  {
    String str = paramString;
    Object localObject2;
    Object localObject1;
    if (paramString.startsWith("{")) {
      try
      {
        localObject2 = new JSONObject(paramString).optJSONArray("0");
        str = paramString;
        if (localObject2 != null) {
          str = ((JSONArray)localObject2).toString();
        }
      }
      catch (Exception localException)
      {
        QLog.e("MessageForText", 1, localException, new Object[0]);
        localObject1 = paramString;
      }
    }
    paramString = new ArrayList();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return null;
    }
    try
    {
      localObject1 = new JSONArray((String)localObject1);
      int i = 0;
      while (i < ((JSONArray)localObject1).length())
      {
        localObject2 = AtTroopMemberInfo.setFromJson(((JSONArray)localObject1).getJSONObject(i));
        if (localObject2 != null) {
          paramString.add(localObject2);
        }
        i += 1;
      }
      return paramString;
    }
    catch (JSONException paramString)
    {
      QLog.e("MessageForText", 1, paramString, new Object[0]);
    }
    return null;
  }
  
  private void parseStickerMsg()
  {
    Object localObject;
    if ((EmojiStickerManager.a(this)) && ((this.extLong & 0x4) > 0) && (EmojiStickerManager.f))
    {
      System.currentTimeMillis();
      localObject = getExtInfoFromExtStr("sticker_info");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (this.msgtype == -1000) {
          this.msgtype = -2058;
        }
        localObject = StickerInfo.transformFromJson((String)localObject);
        if (localObject != null)
        {
          ((StickerInfo)localObject).isDisplayed = this.isread;
          this.stickerInfo = localObject;
          System.currentTimeMillis();
        }
      }
    }
    else if (this.msgtype == -2058)
    {
      localObject = getExtInfoFromExtStr("sticker_info");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = StickerInfo.transformFromJson((String)localObject);
        if (localObject != null)
        {
          ((StickerInfo)localObject).isDisplayed = this.isread;
          this.stickerInfo = localObject;
        }
      }
    }
  }
  
  protected void doParse()
  {
    super.doParse();
    boolean bool3 = false;
    doParse(false);
    String str1 = getExtInfoFromExtStr("sens_msg_need_parse");
    boolean bool1;
    if (!TextUtils.isEmpty(str1)) {
      try
      {
        bool1 = Boolean.parseBoolean(str1);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    } else {
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (bool1) {
      if (!(BaseActivity.sTopActivity instanceof MultiForwardActivity))
      {
        bool2 = bool1;
        if (!(BaseActivity.sTopActivity instanceof ChatHistoryActivity)) {}
      }
      else
      {
        bool2 = false;
      }
    }
    if (!bool2) {
      return;
    }
    String str2 = getExtInfoFromExtStr("sens_msg_ctrl_info");
    if (!TextUtils.isEmpty(str2))
    {
      Object localObject = getExtInfoFromExtStr("sens_msg_confirmed");
      bool1 = bool3;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        bool1 = bool3;
        if (((String)localObject).equalsIgnoreCase("1")) {
          bool1 = true;
        }
      }
      if (!bool1) {
        saveExtInfoToExtStr("sens_msg_original_text", this.msg);
      }
      localObject = new CopyOnWriteArrayList();
      ((List)localObject).add(this);
      MQPSensitiveMsgUtil.a(this, (List)localObject, bool1, HexUtil.hexStr2Bytes(str2));
    }
  }
  
  protected void doParse(boolean paramBoolean)
  {
    Object localObject3 = this.msg;
    Object localObject1 = localObject3;
    if (this.msgtype == -1003)
    {
      localObject1 = ActionMsgUtil.a((String)localObject3);
      this.action = ((MsgBody)localObject1).action;
      localObject1 = ((MsgBody)localObject1).msg;
    }
    localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = "";
    }
    if (this.istroop == 1008)
    {
      this.sb = new PubAccountQQText((CharSequence)localObject3, 13);
      ((PubAccountQQText)this.sb).a = this.selfuin;
      ((PubAccountQQText)this.sb).b = this.frienduin;
      ((PubAccountQQText)this.sb).setBizSrc(((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).getSourceId(this.frienduin));
    }
    else if ((this.istroop == 1024) && (!isSendFromLocal()))
    {
      localObject1 = null;
      boolean bool = false;
      Object localObject4;
      try
      {
        AppRuntime localAppRuntime1 = BaseApplicationImpl.sApplication.getAppRuntime(this.selfuin);
        localObject1 = localAppRuntime1;
        if (QQAppInterface.class.isInstance(localAppRuntime1))
        {
          localObject1 = localAppRuntime1;
          paramBoolean = CrmUtils.a((QQAppInterface)localAppRuntime1, this.frienduin, this.istroop);
          localObject4 = localAppRuntime1;
        }
        else
        {
          localObject1 = localAppRuntime1;
          paramBoolean = bool;
          localObject4 = localAppRuntime1;
          if (QLog.isColorLevel())
          {
            localObject1 = localAppRuntime1;
            QLog.d("MessageForText", 2, "We get error AppRuntime");
            paramBoolean = bool;
            localObject4 = localAppRuntime1;
          }
        }
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        localAccountNotMatchException.printStackTrace();
        paramBoolean = bool;
        localObject4 = localObject1;
        if (QLog.isColorLevel())
        {
          QLog.e("MessageForText", 2, String.format("User %s don't match current accound", new Object[] { this.selfuin }));
          localObject4 = localObject1;
          paramBoolean = bool;
        }
      }
      if (paramBoolean) {
        this.sb = new CrmIvrText((CharSequence)localObject3, 13, ChatTextSizeSettingActivity.a(), this, this.frienduin, this.selfuin, (QQAppInterface)localObject4);
      } else {
        this.sb = new QQText((CharSequence)localObject3, 13, ChatTextSizeSettingActivity.a(), this);
      }
      ((QQText)this.sb).setBizSrc("biz_src_jc_aio");
    }
    else if ((this.istroop != 1045) && (this.istroop != 1044))
    {
      this.sb = ColorNickManager.a((String)localObject3, this, ChatTextSizeSettingActivity.a(), 13);
      localObject1 = getExtInfoFromExtStr("disc_at_info_list");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject3 = new StringBuilder((String)localObject3);
        try
        {
          AppRuntime localAppRuntime2 = BaseApplicationImpl.sApplication.getRuntime();
          if (QQAppInterface.class.isInstance(localAppRuntime2))
          {
            this.msg2 = AtTroopMemberSpan.a((QQAppInterface)localAppRuntime2, (StringBuilder)localObject3, (String)localObject1, this.frienduin, isSend()).toString();
            this.sb2 = ColorNickManager.a(this.msg2, this, ChatTextSizeSettingActivity.a(), 13);
            if ((this.sb2 instanceof QQText)) {
              ((QQText)this.sb2).setBizSrc("biz_src_jc_aio");
            }
          }
          else if (QLog.isColorLevel())
          {
            QLog.d("MessageForText", 2, "We get error AppRuntime");
          }
        }
        catch (Exception localException)
        {
          QLog.e("MessageForText", 1, "replaceAtMsgByMarkName", localException);
        }
      }
    }
    else
    {
      this.sb = new QQText((CharSequence)localObject3, 5, ChatTextSizeSettingActivity.a(), this);
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("limit chat, dont parse url:");
        ((StringBuilder)localObject2).append(this.uniseq);
        QLog.d("MessageForText", 2, ((StringBuilder)localObject2).toString());
      }
    }
    Object localObject2 = this.sb;
    if ((localObject2 instanceof QQText)) {
      ((QQText)localObject2).setBizSrc("biz_src_jc_aio");
    }
  }
  
  public String getSummaryMsg()
  {
    CharSequence localCharSequence = this.sb;
    if (localCharSequence == null) {
      return this.msg;
    }
    return localCharSequence.toString();
  }
  
  public boolean isSupportFTS()
  {
    return MsgProxyUtils.m(this.istroop);
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
    this.mMsgSignalCount = paramSendMsgParams.b;
    this.mIsMsgSignalOpen = paramSendMsgParams.jdField_c_of_type_Boolean;
    this.mMsgSignalNetType = paramSendMsgParams.jdField_c_of_type_Int;
    this.mMsgSendTime = paramSendMsgParams.jdField_a_of_type_Long;
    this.mPasswdRedBagFlag = paramSendMsgParams.f;
    this.mPasswdRedBagSender = paramSendMsgParams.d;
    if ((this instanceof MessageForFoldMsg)) {
      ((MessageForFoldMsg)this).foldFlagTemp = paramSendMsgParams.e;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForText
 * JD-Core Version:    0.7.0.1
 */