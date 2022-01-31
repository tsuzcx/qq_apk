package com.tencent.mobileqq.data;

import ActionMsg.MsgBody;
import aaok;
import actn;
import akpy;
import android.text.TextUtils;
import axas;
import ayki;
import bafh;
import bbbg;
import bboe;
import bcwm;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.mobileqq.emoticon.EmojiStickerManager.StickerInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import nba;
import nbc;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import sgj;
import xnp;

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
  
  public static ArrayList<MessageForText.AtTroopMemberInfo> getTroopMemberInfoFromExtrJson(String paramString)
  {
    String str = paramString;
    if (paramString.startsWith("{")) {}
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
      Object localObject2;
      Object localObject1;
      for (;;)
      {
        QLog.e("MessageForText", 1, localException, new Object[0]);
        localObject1 = paramString;
      }
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          localObject2 = MessageForText.AtTroopMemberInfo.setFromJson(((JSONArray)localObject1).getJSONObject(i));
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
        return null;
      }
    }
    paramString = new ArrayList();
    if (TextUtils.isEmpty(str)) {
      return null;
    }
  }
  
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
              if (!(BaseActivity.sTopActivity instanceof ChatHistoryActivity)) {}
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
      bcwm.a(this, (List)localObject, bool1, HexUtil.hexStr2Bytes(str2));
      return;
    }
  }
  
  protected void doParse(boolean paramBoolean)
  {
    AppRuntime localAppRuntime = null;
    boolean bool = false;
    Object localObject3 = this.msg;
    Object localObject1 = localObject3;
    if (this.msgtype == -1003)
    {
      localObject1 = bbbg.a((String)localObject3);
      this.action = ((MsgBody)localObject1).action;
      localObject1 = ((MsgBody)localObject1).msg;
    }
    localObject3 = localObject1;
    if (localObject1 == null) {
      localObject3 = "";
    }
    int i;
    if (!paramBoolean)
    {
      i = ((String)localObject3).indexOf("http://maps.google.com/maps?q=");
      if (i != -1)
      {
        this.url = ((String)localObject3).substring(i);
        localObject1 = axas.a(this.url);
        this.latitude = localObject1[0];
        this.longitude = localObject1[1];
        this.location = localObject1[2];
        if ((TextUtils.isEmpty(this.latitude)) || (TextUtils.isEmpty(this.longitude))) {
          break label903;
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
      catch (Exception localException1)
      {
        try
        {
          i = actn.a(200.0F, BaseApplication.getContext().getResources());
          int j = actn.a(100.0F, BaseApplication.getContext().getResources());
          localObject1 = new StringBuilder("http://st.map.soso.com/api");
          ((StringBuilder)localObject1).append("?size=").append(i).append("*").append(j);
          ((StringBuilder)localObject1).append("&center=").append(this.longitude).append(",").append(this.latitude);
          ((StringBuilder)localObject1).append("&zoom=14");
          ((StringBuilder)localObject1).append("&markers=").append(this.longitude).append(",").append(this.latitude).append(",").append("red");
          this.locationUrl = new URL(((StringBuilder)localObject1).toString());
          if (this.istroop != 1008) {
            continue;
          }
          this.sb = new xnp((CharSequence)localObject3, 13);
          ((xnp)this.sb).a = this.selfuin;
          ((xnp)this.sb).b = this.frienduin;
          ((xnp)this.sb).a(sgj.b(this.frienduin));
          if ((this.sb instanceof ayki)) {
            ((ayki)this.sb).a("biz_src_jc_aio");
          }
          return;
          localException1 = localException1;
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
        Object localObject2 = localAppRuntime;
        try
        {
          localAppRuntime = BaseApplicationImpl.sApplication.getAppRuntime(this.selfuin);
          localObject2 = localAppRuntime;
          if (!QQAppInterface.class.isInstance(localAppRuntime)) {
            continue;
          }
          localObject2 = localAppRuntime;
          paramBoolean = nbc.a((QQAppInterface)localAppRuntime, this.frienduin, this.istroop);
        }
        catch (AccountNotMatchException localAccountNotMatchException)
        {
          localAccountNotMatchException.printStackTrace();
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("MessageForText", 2, String.format("User %s don't match current accound", new Object[] { this.selfuin }));
          paramBoolean = bool;
          localObject4 = localObject2;
          continue;
          this.sb = new ayki((CharSequence)localObject3, 13, ChatTextSizeSettingActivity.a(), this);
          continue;
        }
        if (!paramBoolean) {
          continue;
        }
        this.sb = new nba((CharSequence)localObject3, 13, ChatTextSizeSettingActivity.a(), this, this.frienduin, this.selfuin, (QQAppInterface)localAppRuntime);
        ((ayki)this.sb).a("biz_src_jc_aio");
        continue;
        localObject2 = localAppRuntime;
        if (!QLog.isColorLevel()) {
          continue;
        }
        localObject2 = localAppRuntime;
        QLog.d("MessageForText", 2, "We get error AppRuntime");
        paramBoolean = false;
        continue;
        Object localObject4;
        if ((this.istroop != 1037) && (this.istroop != 1044)) {
          continue;
        }
        this.sb = new ayki((CharSequence)localObject3, 5, ChatTextSizeSettingActivity.a(), this);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MessageForText", 2, "limit chat, dont parse url:" + this.uniseq);
        continue;
        this.sb = bboe.a((String)localObject3, this, ChatTextSizeSettingActivity.a(), 13);
        localObject2 = getExtInfoFromExtStr("disc_at_info_list");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          continue;
        }
        localObject3 = new StringBuilder((String)localObject3);
        try
        {
          localObject4 = BaseApplicationImpl.sApplication.getRuntime();
          if (!QQAppInterface.class.isInstance(localObject4)) {
            continue;
          }
          this.msg2 = bafh.a((QQAppInterface)localObject4, (StringBuilder)localObject3, (String)localObject2, this.frienduin, isSend()).toString();
          this.sb2 = bboe.a(this.msg2, this, ChatTextSizeSettingActivity.a(), 13);
          if (!(this.sb2 instanceof ayki)) {
            continue;
          }
          ((ayki)this.sb2).a("biz_src_jc_aio");
        }
        catch (Exception localException2)
        {
          QLog.e("MessageForText", 1, "replaceAtMsgByMarkName", localException2);
        }
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("MessageForText", 2, "We get error AppRuntime");
        continue;
      }
      if (i != 0) {}
      label903:
      i = 0;
    }
  }
  
  public String getSummaryMsg()
  {
    if (this.sb == null) {
      return this.msg;
    }
    return this.sb.toString();
  }
  
  public boolean isSupportFTS()
  {
    return akpy.v(this.istroop);
  }
  
  public boolean isSupportReply()
  {
    return true;
  }
  
  public void postRead()
  {
    super.postRead();
    parseStickerMsg();
  }
  
  public void prewrite()
  {
    String str2 = getExtInfoFromExtStr("sens_msg_original_text");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = this.msg;
    }
    this.msg = str1;
    this.msgData = str1.getBytes();
  }
  
  public void setSendMsgParams(aaok paramaaok)
  {
    this.mMsgSignalSum = paramaaok.jdField_a_of_type_Int;
    this.mMsgSignalCount = paramaaok.b;
    this.mIsMsgSignalOpen = paramaaok.jdField_c_of_type_Boolean;
    this.mMsgSignalNetType = paramaaok.jdField_c_of_type_Int;
    this.mMsgSendTime = paramaaok.jdField_a_of_type_Long;
    this.mPasswdRedBagFlag = paramaaok.f;
    this.mPasswdRedBagSender = paramaaok.d;
    if ((this instanceof MessageForFoldMsg)) {
      ((MessageForFoldMsg)this).foldFlagTemp = paramaaok.e;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForText
 * JD-Core Version:    0.7.0.1
 */