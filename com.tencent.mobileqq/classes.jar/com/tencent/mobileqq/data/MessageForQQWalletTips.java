package com.tencent.mobileqq.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.QWalletAIOLifeCycleHelper;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ContactUtils.NameInfo;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.safestream.ISafeStream;
import cooperation.qwallet.safestream.QwSafeInputStream;
import cooperation.qwallet.safestream.QwSafeOutputStream;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class MessageForQQWalletTips
  extends ChatMessage
  implements ISafeStream
{
  public static final int HB_GOLD_CHANNEL = 999;
  private static final int MSG_SUBTYPE_GOLD = 1;
  private static final int MSG_TYPE_GOLD = 8;
  private static final int MSG_TYPE_IDOM = 7;
  private static final String TAG = MessageForQQWalletTips.class.getSimpleName();
  protected final String TAG_CMD = "cmd";
  protected final String TAG_JUMP = "jump";
  public String authKey;
  public boolean bGetTroopMemberInfo = true;
  public String bytes_jumpurl = "";
  public int highLightEnd = 0;
  public int highLightStart = 0;
  public String idiom = "";
  public int idiomSeq = 0;
  public String lastPinyin = "";
  private String listId = "";
  public String memberUin;
  public int msgType = 0;
  public String poemRule = "";
  public String reciverContent;
  public String reciverUin;
  public String richContent = "";
  public String senderContent;
  public String senderUin;
  public int subChannel;
  public int subType;
  public String summary;
  public String textColor = "";
  public int type;
  public String url = "";
  
  private Map<String, String> genComJmpumpParams(QQAppInterface paramQQAppInterface)
  {
    HashMap localHashMap = new HashMap();
    if (getHbType() == 999)
    {
      String str = ((TicketManager)paramQQAppInterface.getManager(2)).getPskey(paramQQAppInterface.getCurrentAccountUin(), "tenpay.com");
      QLog.i(TAG, 2, "pskey = " + str);
      localHashMap.put("pskey_type", "27");
      localHashMap.put("pskey", str);
      localHashMap.put("recv_uin", paramQQAppInterface.getCurrentUin() + "");
      paramQQAppInterface = getGroupInfo(paramQQAppInterface);
      localHashMap.put("recv_nickname", paramQQAppInterface.get("name"));
      localHashMap.put("recv_group_type", paramQQAppInterface.get("grouptype"));
      localHashMap.put("recv_group_id", paramQQAppInterface.get("groupId"));
    }
    return localHashMap;
  }
  
  private Map<String, String> getGroupInfo(QQAppInterface paramQQAppInterface)
  {
    int j = 0;
    Object localObject2 = this.frienduin;
    Object localObject1;
    int i;
    switch (this.istroop)
    {
    default: 
      localObject1 = "";
      i = 0;
      j = -1;
    }
    for (;;)
    {
      if ((i != 0) && (paramQQAppInterface.getCurrentAccountUin().equals(this.reciverUin))) {}
      for (paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();; paramQQAppInterface = (QQAppInterface)localObject2)
      {
        localObject2 = new HashMap();
        ((Map)localObject2).put("name", localObject1);
        ((Map)localObject2).put("groupId", paramQQAppInterface);
        ((Map)localObject2).put("grouptype", j + "");
        return localObject2;
        localObject1 = paramQQAppInterface.getCurrentNickname();
        i = 1;
        break;
        localObject1 = (HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
        if ((localObject1 != null) && (((HotChatManager)localObject1).b(this.frienduin)))
        {
          localObject1 = ContactUtils.q(paramQQAppInterface, paramQQAppInterface.getCurrentNickname());
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label357;
          }
          localObject1 = paramQQAppInterface.getCurrentNickname();
          j = 5;
          i = 0;
          break;
        }
        localObject1 = paramQQAppInterface.getCurrentNickname();
        j = 1;
        i = 0;
        break;
        localObject1 = ContactUtils.a(paramQQAppInterface, this.frienduin, this.memberUin);
        j = 2;
        i = 0;
        break;
        j = 3;
        localObject1 = paramQQAppInterface.getCurrentNickname();
        i = 1;
        break;
        j = 4;
        localObject1 = paramQQAppInterface.getCurrentNickname();
        i = 1;
        break;
        j = 6;
        localObject1 = ContactUtils.q(paramQQAppInterface, paramQQAppInterface.getCurrentNickname());
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label352;
        }
        localObject1 = paramQQAppInterface.getCurrentNickname();
        i = 1;
        break;
      }
      label352:
      i = 1;
      continue;
      label357:
      j = 5;
      i = 0;
    }
  }
  
  private int getHbType()
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "msgtype: " + this.msgType + ", subtype: " + this.subType);
    }
    if (this.msgType == 7) {
      i = 524288;
    }
    while ((this.subType != 1) && (this.msgType != 8)) {
      return i;
    }
    return 999;
  }
  
  private CharSequence getQQWalletTips(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    int i = 0;
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    PasswdRedBagManager localPasswdRedBagManager = (PasswdRedBagManager)paramQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    StringBuilder localStringBuilder = new StringBuilder();
    Matcher localMatcher = Pattern.compile("<([^>])+").matcher(paramString);
    LinkedList localLinkedList = new LinkedList();
    label1301:
    label1307:
    for (;;)
    {
      Object localObject3;
      Object localObject4;
      label374:
      label377:
      Object localObject2;
      if (localMatcher.find())
      {
        int j = localMatcher.start();
        int k = localMatcher.end();
        Object localObject1 = paramString.substring(j + 1, k);
        localObject3 = paramString.substring(i, j);
        i = k + 1;
        localSpannableStringBuilder.append((CharSequence)localObject3);
        localStringBuilder.append((String)localObject3);
        try
        {
          localObject3 = new JSONObject((String)localObject1);
          if (!((JSONObject)localObject3).has("icon")) {
            break label377;
          }
          localObject4 = ((JSONObject)localObject3).optString("icon");
          localObject3 = new SpannableString((CharSequence)localObject1);
          if (((String)localObject4).startsWith("qqwallet"))
          {
            j = getHbType();
            if (j == 524288) {
              localObject1 = localPasswdRedBagManager.a("StatusIcon_IdiomHongBaoIcon", 2130847604);
            }
            while (localObject1 != null)
            {
              ((SpannableString)localObject3).setSpan(new MessageForQQWalletTips.CenterImageSpan(paramContext, (Bitmap)localObject1), 0, ((SpannableString)localObject3).length(), 33);
              localSpannableStringBuilder.append((CharSequence)localObject3);
              localSpannableStringBuilder.append(" ");
              break;
              if (j == 999) {
                localObject1 = localPasswdRedBagManager.a("StatusIcon_GoldHongBaoIcon", 2130847602);
              } else {
                localObject1 = localPasswdRedBagManager.a("StatusIcon_HongBaoIcon", 2130847668);
              }
            }
          }
          if ((!((String)localObject4).startsWith("http://")) && (!((String)localObject4).startsWith("https://"))) {
            break label1301;
          }
          ((SpannableString)localObject3).setSpan(new MessageForGrayTips.UrlCenterImageSpan(paramContext, 0, (String)localObject4), 0, ((SpannableString)localObject3).length(), 33);
          localSpannableStringBuilder.append((CharSequence)localObject3);
          localSpannableStringBuilder.append(" ");
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        continue;
        if (((JSONObject)localObject3).has("uin"))
        {
          this.memberUin = ((JSONObject)localObject3).getString("uin");
          localObject2 = this.memberUin;
          switch (this.istroop)
          {
          }
        }
      }
      for (;;)
      {
        localSpannableStringBuilder.append((CharSequence)localObject2);
        localStringBuilder.append((String)localObject2);
        break;
        localObject2 = ContactUtils.m(paramQQAppInterface, this.memberUin);
        continue;
        localObject2 = (HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
        if ((localObject2 != null) && (((HotChatManager)localObject2).b(this.frienduin)))
        {
          localObject2 = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.memberUin);
          if ((localObject2 != null) && (((Friends)localObject2).isFriend()) && (!this.memberUin.equals(paramQQAppInterface.getCurrentAccountUin())))
          {
            localObject4 = ContactUtils.a(paramQQAppInterface, this.frienduin, this.memberUin);
            localObject3 = ((ContactUtils.NameInfo)localObject4).jdField_a_of_type_JavaLangString;
            localObject2 = localObject3;
            if (((ContactUtils.NameInfo)localObject4).jdField_a_of_type_Boolean)
            {
              localLinkedList.add(this.memberUin);
              localObject2 = localObject3;
            }
          }
          else
          {
            localObject3 = ((JSONObject)localObject3).optString("hotname");
            if (QLog.isDevelopLevel()) {
              QLog.i("MessageForQQWalletTips", 4, "hotname=" + (String)localObject3);
            }
            localObject2 = localObject3;
            if (TextUtils.isEmpty((CharSequence)localObject3))
            {
              localObject4 = ContactUtils.a(paramQQAppInterface, this.frienduin, this.memberUin);
              localObject3 = ((ContactUtils.NameInfo)localObject4).jdField_a_of_type_JavaLangString;
              localObject2 = localObject3;
              if (((ContactUtils.NameInfo)localObject4).jdField_a_of_type_Boolean)
              {
                localLinkedList.add(this.memberUin);
                localObject2 = localObject3;
              }
            }
          }
        }
        else
        {
          localObject4 = ContactUtils.a(paramQQAppInterface, this.frienduin, this.memberUin);
          localObject3 = ((ContactUtils.NameInfo)localObject4).jdField_a_of_type_JavaLangString;
          localObject2 = localObject3;
          if (((ContactUtils.NameInfo)localObject4).jdField_a_of_type_Boolean)
          {
            localLinkedList.add(this.memberUin);
            localObject2 = localObject3;
            continue;
            localObject2 = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(this.frienduin, this.memberUin);
            if (localObject2 != null)
            {
              localObject2 = ((DiscussionMemberInfo)localObject2).inteRemark;
            }
            else
            {
              localObject2 = ContactUtils.a(paramQQAppInterface, this.frienduin, this.memberUin);
              continue;
              localObject2 = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
              localObject4 = ContactUtils.a(paramQQAppInterface, this.frienduin, this.memberUin);
              localObject3 = ((ContactUtils.NameInfo)localObject4).jdField_a_of_type_JavaLangString;
              localObject2 = localObject3;
              if (((ContactUtils.NameInfo)localObject4).jdField_a_of_type_Boolean)
              {
                localLinkedList.add(this.memberUin);
                localObject2 = localObject3;
                continue;
                localObject2 = ContactUtils.a(paramQQAppInterface, this.senderuin, this.memberUin);
                continue;
                localObject2 = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.memberUin);
                if ((localObject2 != null) && (((Friends)localObject2).isFriend()) && (!this.memberUin.equals(paramQQAppInterface.getCurrentAccountUin())))
                {
                  localObject4 = ContactUtils.a(paramQQAppInterface, this.frienduin, this.memberUin);
                  localObject3 = ((ContactUtils.NameInfo)localObject4).jdField_a_of_type_JavaLangString;
                  localObject2 = localObject3;
                  if (((ContactUtils.NameInfo)localObject4).jdField_a_of_type_Boolean)
                  {
                    localLinkedList.add(this.memberUin);
                    localObject2 = localObject3;
                  }
                }
                else
                {
                  localObject3 = ((JSONObject)localObject3).optString("hotname");
                  if (QLog.isDevelopLevel()) {
                    QLog.i("MessageForQQWalletTips", 4, "hotname=" + (String)localObject3);
                  }
                  localObject2 = localObject3;
                  if (TextUtils.isEmpty((CharSequence)localObject3))
                  {
                    localObject4 = ContactUtils.a(paramQQAppInterface, this.frienduin, this.memberUin);
                    localObject3 = ((ContactUtils.NameInfo)localObject4).jdField_a_of_type_JavaLangString;
                    localObject2 = localObject3;
                    if (((ContactUtils.NameInfo)localObject4).jdField_a_of_type_Boolean)
                    {
                      localLinkedList.add(this.memberUin);
                      localObject2 = localObject3;
                      continue;
                      if ((!((JSONObject)localObject3).has("cmd")) && (!((JSONObject)localObject3).has("jump"))) {
                        break label374;
                      }
                      localObject2 = parseTag((JSONObject)localObject3, paramQQAppInterface, paramContext, paramString);
                      if (localObject2 != null) {
                        localSpannableStringBuilder.append((CharSequence)localObject2);
                      }
                      if (((JSONObject)localObject3).has("cmd"))
                      {
                        localStringBuilder.append(((JSONObject)localObject3).optString("text", ""));
                        break label1307;
                      }
                      localStringBuilder.append(((JSONObject)localObject3).optString("desc", ""));
                      break label1307;
                      if (i != paramString.length())
                      {
                        localSpannableStringBuilder.append(paramString.subSequence(i, paramString.length()));
                        localStringBuilder.append(paramString.subSequence(i, paramString.length()));
                      }
                      this.summary = localStringBuilder.toString();
                      tryGetMemberInfosAsync(localLinkedList, paramQQAppInterface, this.frienduin);
                      return localSpannableStringBuilder;
                      break;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private QWalletAIOLifeCycleHelper getQWalletAIOLifeCycleHelper(Context paramContext)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((paramContext instanceof FragmentActivity))
    {
      paramContext = (FragmentActivity)paramContext;
      localObject1 = localObject2;
      if (paramContext.getChatFragment() != null)
      {
        paramContext = paramContext.getChatFragment().a();
        localObject1 = localObject2;
        if (paramContext != null) {
          localObject1 = (QWalletAIOLifeCycleHelper)paramContext.a(27);
        }
      }
    }
    return localObject1;
  }
  
  private String parseListIdStr(JSONObject paramJSONObject)
  {
    String str2 = paramJSONObject.optString("data");
    String str1 = "";
    paramJSONObject = str1;
    int i;
    if (str2 != null)
    {
      i = str2.indexOf("listid=");
      paramJSONObject = str1;
      if (i >= 0)
      {
        paramJSONObject = str2.substring(i);
        i = "listid=".length();
        int j = paramJSONObject.indexOf("&");
        if ((j <= 0) || (j <= i)) {
          break label77;
        }
        paramJSONObject = paramJSONObject.substring(i, j);
      }
    }
    return paramJSONObject;
    label77:
    return paramJSONObject.substring(i);
  }
  
  private void syncIdiomRedbagStatus(QQAppInterface paramQQAppInterface, PasswdRedBagManager paramPasswdRedBagManager, String paramString)
  {
    if (paramPasswdRedBagManager != null)
    {
      if (paramQQAppInterface.getCurrentAccountUin().equals(this.reciverUin)) {
        paramPasswdRedBagManager.a(paramString, this.frienduin, this.istroop);
      }
      paramPasswdRedBagManager.a(paramString, this.frienduin, this.istroop, this.idiomSeq, this.idiom, this.lastPinyin, this.poemRule);
    }
  }
  
  public void addQQWalletTips(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    paramString1 = new UniteGrayTipParam(this.frienduin, paramQQAppInterface.getCurrentAccountUin(), paramString1.toString(), this.istroop, -5020, 3145729, MessageCache.a());
    Bundle localBundle = new Bundle();
    localBundle.putString("textColor", paramString2);
    if (!TextUtils.isEmpty(paramString3))
    {
      localBundle.putInt("key_action", 1);
      localBundle.putString("key_action_DATA", paramString3);
    }
    paramString1.a(paramInt1, paramInt2, localBundle);
    paramString2 = new MessageForUniteGrayTip();
    paramString2.initGrayTipMsg(paramQQAppInterface, paramString1);
    UniteGrayTipUtil.a(paramQQAppInterface, paramString2);
  }
  
  public void buildQQWalletTips(QQAppInterface paramQQAppInterface, Context paramContext, TextView paramTextView)
  {
    String str;
    if (paramTextView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 1, "buildQQWalletTips textview is null");
      }
      str = paramQQAppInterface.getCurrentAccountUin();
      if (this.msgType != 7) {
        break label126;
      }
      str = this.richContent;
      label41:
      if (QLog.isColorLevel())
      {
        if (str == null) {
          break label177;
        }
        QLog.d(TAG, 1, "buildQQWalletTips content = " + str);
      }
      label80:
      paramQQAppInterface = getQQWalletTips(paramQQAppInterface, paramContext, str);
      if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface))) {
        break label190;
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 1, "buildQQWalletTips realContent is null");
      }
    }
    label126:
    do
    {
      return;
      paramTextView.setText("");
      break;
      if (str.equals(this.senderUin))
      {
        str = this.senderContent;
        break label41;
      }
      if (str.equals(this.reciverUin))
      {
        str = this.reciverContent;
        break label41;
      }
      str = this.reciverContent;
      break label41;
      QLog.d(TAG, 1, "buildQQWalletTips content is null");
      break label80;
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 1, "buildQQWalletTips realContent =" + this.reciverContent);
      }
    } while (paramTextView == null);
    label177:
    label190:
    paramTextView.setText(paramQQAppInterface);
    paramTextView.setContentDescription(this.summary);
    paramTextView.setHighlightColor(0);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
    paramTextView.setGravity(19);
    paramTextView.setPadding(paramTextView.getPaddingLeft(), 6, paramTextView.getPaddingRight(), 6);
    paramTextView.setIncludeFontPadding(true);
    paramTextView.setLineSpacing(0.0F, 1.0F);
  }
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: new 599	cooperation/qwallet/safestream/QwSafeInputStream
    //   3: dup
    //   4: aload_0
    //   5: getfield 603	com/tencent/mobileqq/data/MessageForQQWalletTips:msgData	[B
    //   8: invokespecial 606	cooperation/qwallet/safestream/QwSafeInputStream:<init>	([B)V
    //   11: astore_2
    //   12: aload_2
    //   13: astore_1
    //   14: aload_0
    //   15: aload_2
    //   16: invokevirtual 610	com/tencent/mobileqq/data/MessageForQQWalletTips:readExternal	(Lcooperation/qwallet/safestream/QwSafeInputStream;)V
    //   19: aload_2
    //   20: ifnull +7 -> 27
    //   23: aload_2
    //   24: invokevirtual 612	cooperation/qwallet/safestream/QwSafeInputStream:a	()V
    //   27: return
    //   28: astore_3
    //   29: aconst_null
    //   30: astore_2
    //   31: aload_2
    //   32: astore_1
    //   33: invokestatic 238	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +15 -> 51
    //   39: aload_2
    //   40: astore_1
    //   41: getstatic 53	com/tencent/mobileqq/data/MessageForQQWalletTips:TAG	Ljava/lang/String;
    //   44: iconst_1
    //   45: ldc_w 614
    //   48: invokestatic 537	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_2
    //   52: astore_1
    //   53: aload_3
    //   54: invokevirtual 352	java/lang/Exception:printStackTrace	()V
    //   57: aload_2
    //   58: ifnull -31 -> 27
    //   61: aload_2
    //   62: invokevirtual 612	cooperation/qwallet/safestream/QwSafeInputStream:a	()V
    //   65: return
    //   66: astore_2
    //   67: aconst_null
    //   68: astore_1
    //   69: aload_1
    //   70: ifnull +7 -> 77
    //   73: aload_1
    //   74: invokevirtual 612	cooperation/qwallet/safestream/QwSafeInputStream:a	()V
    //   77: aload_2
    //   78: athrow
    //   79: astore_2
    //   80: goto -11 -> 69
    //   83: astore_3
    //   84: goto -53 -> 31
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	MessageForQQWalletTips
    //   13	61	1	localQwSafeInputStream1	QwSafeInputStream
    //   11	51	2	localQwSafeInputStream2	QwSafeInputStream
    //   66	12	2	localObject1	Object
    //   79	1	2	localObject2	Object
    //   28	26	3	localException1	Exception
    //   83	1	3	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	12	28	java/lang/Exception
    //   0	12	66	finally
    //   14	19	79	finally
    //   33	39	79	finally
    //   41	51	79	finally
    //   53	57	79	finally
    //   14	19	83	java/lang/Exception
  }
  
  public byte[] flushMsgData(int paramInt)
  {
    Object localObject3 = null;
    for (;;)
    {
      try
      {
        localObject1 = new QwSafeOutputStream();
        localObject2 = localObject1;
      }
      catch (Exception localException1)
      {
        try
        {
          writeExternal((QwSafeOutputStream)localObject1);
          localObject2 = localObject1;
          localObject1 = localObject3;
          if (localObject2 != null) {
            localObject1 = localObject2.a();
          }
          return localObject1;
        }
        catch (Exception localException2)
        {
          Object localObject1;
          Object localObject2;
          break label36;
        }
        localException1 = localException1;
        localObject1 = null;
      }
      label36:
      if (QLog.isColorLevel())
      {
        QLog.d("Q.msg.qqwalletmsg", 2, "QQWalletRedPacketMsg write Exception", localException1);
        localObject2 = localObject1;
      }
    }
  }
  
  public byte[] getBytes()
  {
    prewrite();
    return this.msgData;
  }
  
  public String getQQWalletTips(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    paramQQAppInterface = new SpannableStringBuilder();
    Matcher localMatcher = Pattern.compile("<([^>])+").matcher(paramString);
    int i = 0;
    for (;;)
    {
      int j = i;
      Object localObject;
      if (localMatcher.find())
      {
        j = localMatcher.start();
        int k = localMatcher.end();
        localObject = paramString.substring(j + 1, k);
        String str = paramString.substring(i, j);
        j = k + 1;
        paramQQAppInterface.append(str);
      }
      try
      {
        localObject = new JSONObject((String)localObject);
        i = j;
        if (((JSONObject)localObject).has("jump"))
        {
          localObject = parseJumpTag((JSONObject)localObject);
          this.highLightStart = paramQQAppInterface.length();
          if (localObject != null) {
            paramQQAppInterface.append((CharSequence)localObject);
          }
          this.highLightEnd = paramQQAppInterface.length();
          if (j != paramString.length()) {
            paramQQAppInterface.append(paramString.subSequence(j, paramString.length()));
          }
          return paramQQAppInterface.toString();
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        i = j;
      }
    }
  }
  
  public void onReceiveGrapTips()
  {
    QQAppInterface localQQAppInterface = null;
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)localObject1;
    }
    if (localQQAppInterface == null) {}
    int i;
    label46:
    do
    {
      return;
      if (localQQAppInterface.getCurrentAccountUin().equals(this.senderUin)) {
        break;
      }
      i = 1;
      if (i != 0)
      {
        localObject1 = Pattern.compile("feedsid=(\\d+).*hb_from=video_reward").matcher(this.reciverContent);
        if (((Matcher)localObject1).find())
        {
          localObject1 = ((Matcher)localObject1).group(1);
          RedBagVideoManager.a(localQQAppInterface).a(this.frienduin, this.istroop, (String)localObject1);
          VideoRedbagData.updateRewardStat((String)localObject1);
        }
      }
    } while (localQQAppInterface == null);
    for (;;)
    {
      Object localObject3;
      try
      {
        localObject1 = localQQAppInterface.getCurrentAccountUin();
        if (getHbType() != 524288) {
          break label277;
        }
        localObject1 = this.richContent;
        Matcher localMatcher = Pattern.compile("<([^>])+").matcher((CharSequence)localObject1);
        localObject3 = "";
        if (!localMatcher.find()) {
          break label323;
        }
        String str = parseListIdStr(new JSONObject(((String)localObject1).substring(localMatcher.start() + 1, localMatcher.end())));
        localObject3 = str;
        if (StringUtil.a(str)) {
          continue;
        }
        localObject1 = str;
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "onReceiveGrapTips|listId: " + (String)localObject1 + ",msgType:" + this.msgType);
        }
        localObject3 = (PasswdRedBagManager)localQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
        if (this.msgType != 7) {
          break;
        }
        syncIdiomRedbagStatus(localQQAppInterface, (PasswdRedBagManager)localObject3, (String)localObject1);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      i = 0;
      break label46;
      label277:
      Object localObject2;
      if (localException.equals(this.senderUin))
      {
        localObject2 = this.senderContent;
      }
      else if (((String)localObject2).equals(this.reciverUin))
      {
        localObject2 = this.reciverContent;
      }
      else
      {
        localObject2 = this.reciverContent;
        continue;
        label323:
        localObject2 = localObject3;
      }
    }
  }
  
  protected SpannableString parseCmdTag(JSONObject paramJSONObject, QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    int i = -16777216;
    int j = paramJSONObject.optInt("cmd");
    if (j != 1) {}
    Object localObject2;
    do
    {
      return null;
      QLog.i(TAG, 2, "parse cmd tag: " + j);
      localObject1 = paramJSONObject.optString("text");
      localObject2 = paramJSONObject.optString("textColor");
    } while (TextUtils.isEmpty((CharSequence)localObject1));
    Object localObject1 = new SpannableString((CharSequence)localObject1);
    if (TextUtils.isEmpty((CharSequence)localObject2)) {}
    for (;;)
    {
      localObject2 = new SoftReference(paramQQAppInterface);
      SoftReference localSoftReference = new SoftReference(paramContext);
      this.listId = parseListIdStr(paramJSONObject);
      paramJSONObject = (PasswdRedBagManager)paramQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
      QWalletAIOLifeCycleHelper localQWalletAIOLifeCycleHelper = getQWalletAIOLifeCycleHelper(paramContext);
      ((SpannableString)localObject1).setSpan(new MessageForQQWalletTips.2(this, localSoftReference, (SoftReference)localObject2, paramQQAppInterface, paramContext, localQWalletAIOLifeCycleHelper, paramJSONObject, i), 0, ((SpannableString)localObject1).length(), 33);
      if ((paramJSONObject != null) && (paramString.contains(HardCodeUtil.a(2131706588))))
      {
        paramJSONObject.a(this.listId);
        if (paramQQAppInterface.getCurrentAccountUin().equals(this.reciverUin)) {
          paramJSONObject.a(this.listId, this.frienduin, this.istroop);
        }
        if (localQWalletAIOLifeCycleHelper != null) {
          localQWalletAIOLifeCycleHelper.a(this.listId);
        }
      }
      return localObject1;
      i = 0xFF000000 | (int)Long.parseLong(((String)localObject2).substring(2), 16);
    }
  }
  
  protected SpannableString parseJumpTag(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject, Context paramContext)
  {
    int i = -16777216;
    if (!paramJSONObject.optString("jump").equals("1")) {
      return null;
    }
    Object localObject = paramJSONObject.optString("desc");
    paramQQAppInterface = paramJSONObject.optString("textColor");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    localObject = new SpannableString((CharSequence)localObject);
    if (TextUtils.isEmpty(paramQQAppInterface)) {}
    for (;;)
    {
      ((SpannableString)localObject).setSpan(new MessageForQQWalletTips.3(this, paramJSONObject.optString("data"), new SoftReference(paramContext), i), 0, ((SpannableString)localObject).length(), 33);
      return localObject;
      i = 0xFF000000 | (int)Long.parseLong(paramQQAppInterface.substring(2), 16);
    }
  }
  
  protected SpannableString parseJumpTag(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.optString("jump").equals("1")) {}
    String str;
    SpannableString localSpannableString;
    do
    {
      do
      {
        return null;
        str = paramJSONObject.optString("desc");
      } while (TextUtils.isEmpty(str));
      localSpannableString = new SpannableString(str);
      this.textColor = paramJSONObject.optString("textColor");
    } while (TextUtils.isEmpty(str));
    if (!TextUtils.isEmpty(this.textColor)) {
      if ((this.textColor.startsWith("0x")) || (this.textColor.startsWith("0X"))) {
        if (this.textColor.length() == 8) {
          this.textColor = ("#FF" + this.textColor.substring(2));
        }
      }
    }
    for (;;)
    {
      this.url = paramJSONObject.optString("data");
      return localSpannableString;
      if (this.textColor.length() == 10)
      {
        this.textColor = ("#" + this.textColor.substring(2));
      }
      else
      {
        this.textColor = "#FF40A0FF";
        continue;
        if (this.textColor.length() == 6)
        {
          this.textColor = ("#FF" + this.textColor);
        }
        else if (this.textColor.length() == 8)
        {
          this.textColor = ("#" + this.textColor);
        }
        else
        {
          this.textColor = "#FF40A0FF";
          continue;
          this.textColor = "#FF40A0FF";
        }
      }
    }
  }
  
  protected SpannableString parseTag(JSONObject paramJSONObject, QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if (paramJSONObject == null) {}
    do
    {
      return null;
      if (paramJSONObject.has("cmd")) {
        return parseCmdTag(paramJSONObject, paramQQAppInterface, paramContext, paramString);
      }
    } while (!paramJSONObject.has("jump"));
    return parseJumpTag(paramQQAppInterface, paramJSONObject, paramContext);
  }
  
  public void prewrite()
  {
    byte[] arrayOfByte = flushMsgData(this.msgType);
    if (arrayOfByte != null) {
      this.msgData = arrayOfByte;
    }
  }
  
  public void readExternal(QwSafeInputStream paramQwSafeInputStream)
  {
    this.senderUin = paramQwSafeInputStream.a();
    this.reciverUin = paramQwSafeInputStream.a();
    this.senderContent = paramQwSafeInputStream.a();
    this.reciverContent = paramQwSafeInputStream.a();
    this.authKey = paramQwSafeInputStream.a();
    this.type = paramQwSafeInputStream.a();
    this.subType = paramQwSafeInputStream.a();
    this.msgType = paramQwSafeInputStream.a();
    this.idiomSeq = paramQwSafeInputStream.a();
    this.idiom = paramQwSafeInputStream.a();
    this.richContent = paramQwSafeInputStream.a();
    this.lastPinyin = paramQwSafeInputStream.a();
    this.bytes_jumpurl = paramQwSafeInputStream.a();
    this.subChannel = paramQwSafeInputStream.a();
  }
  
  public void tryGetMemberInfosAsync(List<String> paramList, QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramList != null) && (paramList.size() > 0) && (paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramQQAppInterface = new WeakReference(paramQQAppInterface);
      ThreadManager.getFileThreadHandler().post(new MessageForQQWalletTips.1(this, paramQQAppInterface, paramList, paramString));
    }
  }
  
  public void updateMsg(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
    } while (paramQQAppInterface == null);
    Message localMessage = new Message();
    localMessage.what = 78;
    localMessage.arg1 = 890;
    Bundle localBundle = new Bundle();
    localBundle.putLong("messageUniseq", this.uniseq);
    localMessage.setData(localBundle);
    paramQQAppInterface.sendMessage(localMessage);
  }
  
  public void writeExternal(QwSafeOutputStream paramQwSafeOutputStream)
  {
    paramQwSafeOutputStream.a(this.senderUin);
    paramQwSafeOutputStream.a(this.reciverUin);
    paramQwSafeOutputStream.a(this.senderContent);
    paramQwSafeOutputStream.a(this.reciverContent);
    paramQwSafeOutputStream.a(this.authKey);
    paramQwSafeOutputStream.a(this.type);
    paramQwSafeOutputStream.a(this.subType);
    paramQwSafeOutputStream.a(this.msgType);
    paramQwSafeOutputStream.a(this.idiomSeq);
    paramQwSafeOutputStream.a(this.idiom);
    paramQwSafeOutputStream.a(this.richContent);
    paramQwSafeOutputStream.a(this.lastPinyin);
    paramQwSafeOutputStream.a(this.bytes_jumpurl);
    paramQwSafeOutputStream.a(this.subChannel);
  }
  
  public void writeHeader(QwSafeOutputStream paramQwSafeOutputStream, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQQWalletTips
 * JD-Core Version:    0.7.0.1
 */