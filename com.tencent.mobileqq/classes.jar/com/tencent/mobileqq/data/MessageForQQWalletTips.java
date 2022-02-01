package com.tencent.mobileqq.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ContactUtils.NameInfo;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
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
  private static final String TAG = "MessageForQQWalletTips";
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
      Object localObject = ((TicketManager)paramQQAppInterface.getManager(2)).getPskey(paramQQAppInterface.getCurrentAccountUin(), "tenpay.com");
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pskey = ");
      localStringBuilder.append((String)localObject);
      QLog.i(str, 2, localStringBuilder.toString());
      localHashMap.put("pskey_type", "27");
      localHashMap.put("pskey", localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramQQAppInterface.getCurrentUin());
      ((StringBuilder)localObject).append("");
      localHashMap.put("recv_uin", ((StringBuilder)localObject).toString());
      paramQQAppInterface = getGroupInfo(paramQQAppInterface);
      localHashMap.put("recv_nickname", paramQQAppInterface.get("name"));
      localHashMap.put("recv_group_type", paramQQAppInterface.get("grouptype"));
      localHashMap.put("recv_group_id", paramQQAppInterface.get("groupId"));
    }
    return localHashMap;
  }
  
  private Map<String, String> getGroupInfo(QQAppInterface paramQQAppInterface)
  {
    String str2 = this.frienduin;
    int k = this.istroop;
    int j = 0;
    int i = 1;
    if (k != 0)
    {
      if (k != 1)
      {
        if (k != 1000)
        {
          if (k != 1001) {
            if (k != 1004)
            {
              if (k != 3000)
              {
                if ((k != 10002) && (k != 10004))
                {
                  localObject = "";
                  i = -1;
                  break label246;
                }
              }
              else
              {
                localObject = ContactUtils.a(paramQQAppInterface, this.frienduin, this.memberUin);
                i = 2;
                break label246;
              }
            }
            else
            {
              localObject = paramQQAppInterface.getCurrentNickname();
              j = 1;
              i = 4;
              break label246;
            }
          }
          str1 = ContactUtils.g(paramQQAppInterface, paramQQAppInterface.getCurrentNickname());
          localObject = str1;
          if (TextUtils.isEmpty(str1)) {
            localObject = paramQQAppInterface.getCurrentNickname();
          }
          j = 1;
          i = 6;
        }
        else
        {
          localObject = paramQQAppInterface.getCurrentNickname();
          j = 1;
          i = 3;
        }
      }
      else
      {
        localObject = (HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
        if ((localObject != null) && (((HotChatManager)localObject).b(this.frienduin)))
        {
          str1 = ContactUtils.g(paramQQAppInterface, paramQQAppInterface.getCurrentNickname());
          localObject = str1;
          if (TextUtils.isEmpty(str1)) {
            localObject = paramQQAppInterface.getCurrentNickname();
          }
          i = 5;
        }
        else
        {
          localObject = paramQQAppInterface.getCurrentNickname();
        }
      }
    }
    else
    {
      localObject = paramQQAppInterface.getCurrentNickname();
      j = 1;
      i = 0;
    }
    label246:
    String str1 = str2;
    if (j != 0)
    {
      str1 = str2;
      if (paramQQAppInterface.getCurrentAccountUin().equals(this.reciverUin)) {
        str1 = paramQQAppInterface.getCurrentAccountUin();
      }
    }
    paramQQAppInterface = new HashMap();
    paramQQAppInterface.put("name", localObject);
    paramQQAppInterface.put("groupId", str1);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("");
    paramQQAppInterface.put("grouptype", ((StringBuilder)localObject).toString());
    return paramQQAppInterface;
  }
  
  private int getHbType()
  {
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("msgtype: ");
      localStringBuilder.append(this.msgType);
      localStringBuilder.append(", subtype: ");
      localStringBuilder.append(this.subType);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    int i = this.msgType;
    if (i == 7) {
      return 524288;
    }
    if ((this.subType != 1) && (i != 8)) {
      return 1;
    }
    return 999;
  }
  
  private CharSequence getQQWalletTips(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    String str1 = "uin";
    String str2 = "icon";
    SpannableStringBuilder localSpannableStringBuilder;
    StringBuilder localStringBuilder;
    LinkedList localLinkedList;
    int i;
    int j;
    if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
    {
      IPasswdRedBagService localIPasswdRedBagService = (IPasswdRedBagService)paramQQAppInterface.getRuntimeService(IPasswdRedBagService.class);
      localSpannableStringBuilder = new SpannableStringBuilder();
      localStringBuilder = new StringBuilder();
      Matcher localMatcher = Pattern.compile("<([^>])+").matcher(paramString);
      localLinkedList = new LinkedList();
      i = 0;
      if (localMatcher.find())
      {
        int k = localMatcher.start();
        j = localMatcher.end();
        Object localObject1 = paramString.substring(k + 1, j);
        Object localObject2 = paramString.substring(i, k);
        localSpannableStringBuilder.append((CharSequence)localObject2);
        localStringBuilder.append((String)localObject2);
        boolean bool;
        Object localObject3;
        label267:
        try
        {
          localObject2 = new JSONObject((String)localObject1);
          bool = ((JSONObject)localObject2).has(str2);
          if (!bool) {}
        }
        catch (Exception localException3) {}
      }
    }
    for (;;)
    {
      try
      {
        localObject3 = ((JSONObject)localObject2).optString(str2);
        localObject2 = new SpannableString((CharSequence)localObject1);
        bool = ((String)localObject3).startsWith("qqwallet");
        if (!bool) {}
      }
      catch (Exception localException6)
      {
        break label1264;
        break label1142;
        break label1142;
      }
      try
      {
        i = getHbType();
        if (i != 524288) {
          break;
        }
      }
      catch (Exception localException5)
      {
        break label1264;
      }
    }
    try
    {
      localObject1 = localIPasswdRedBagService.getIconFromCacheByType("StatusIcon_IdiomHongBaoIcon", 2130847471);
      break label267;
      if (i == 999) {
        localObject1 = localIPasswdRedBagService.getIconFromCacheByType("StatusIcon_GoldHongBaoIcon", 2130847469);
      } else {
        localObject1 = localIPasswdRedBagService.getIconFromCacheByType("StatusIcon_HongBaoIcon", 2130847536);
      }
      if (localObject1 == null) {
        break label1354;
      }
      localObject1 = new MessageForQQWalletTips.CenterImageSpan(paramContext, (Bitmap)localObject1);
      i = ((SpannableString)localObject2).length();
      try
      {
        ((SpannableString)localObject2).setSpan(localObject1, 0, i, 33);
        localSpannableStringBuilder.append((CharSequence)localObject2);
        localSpannableStringBuilder.append(" ");
      }
      catch (Exception localException2) {}
      if (!((String)localObject3).startsWith("http://")) {
        if (!((String)localObject3).startsWith("https://")) {
          break label1362;
        }
      }
      ((SpannableString)localObject2).setSpan(new MessageForGrayTips.UrlCenterImageSpan(paramContext, 0, (String)localObject3), 0, ((SpannableString)localObject2).length(), 33);
      localSpannableStringBuilder.append((CharSequence)localObject2);
      localSpannableStringBuilder.append(" ");
    }
    catch (Exception localException4)
    {
      break label1269;
    }
    if (((JSONObject)localObject2).has(str1))
    {
      this.memberUin = ((JSONObject)localObject2).getString(str1);
      localObject1 = this.memberUin;
      i = this.istroop;
      if ((i != 0) && ((i != 1) && ((i != 1000) && ((i != 1001) && ((i != 1004) && ((i != 3000) && ((i != 10002) && (i != 10004)))))))) {}
    }
    try
    {
      localObject1 = ((DiscussionManager)paramQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(this.frienduin, this.memberUin);
      if (localObject1 != null) {
        localObject1 = ((DiscussionMemberInfo)localObject1).inteRemark;
      } else {
        localObject1 = ContactUtils.a(paramQQAppInterface, this.frienduin, this.memberUin);
      }
    }
    catch (Exception localException1)
    {
      break label1269;
    }
    localObject1 = ContactUtils.a(paramQQAppInterface, this.senderuin, this.memberUin);
    break label1142;
    localObject1 = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.memberUin);
    if ((localObject1 != null) && (((Friends)localObject1).isFriend()) && (!this.memberUin.equals(paramQQAppInterface.getCurrentAccountUin())))
    {
      localObject3 = ContactUtils.a(paramQQAppInterface, this.frienduin, this.memberUin);
      localObject2 = ((ContactUtils.NameInfo)localObject3).jdField_a_of_type_JavaLangString;
      localObject1 = localObject2;
      if (((ContactUtils.NameInfo)localObject3).jdField_a_of_type_Boolean)
      {
        localLinkedList.add(this.memberUin);
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = ((JSONObject)localObject2).optString("hotname");
      if (QLog.isDevelopLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("hotname=");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.i("MessageForQQWalletTips", 4, ((StringBuilder)localObject2).toString());
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        break label1370;
      }
      localObject3 = ContactUtils.a(paramQQAppInterface, this.frienduin, this.memberUin);
      localObject2 = ((ContactUtils.NameInfo)localObject3).jdField_a_of_type_JavaLangString;
      localObject1 = localObject2;
      if (!((ContactUtils.NameInfo)localObject3).jdField_a_of_type_Boolean) {
        break label1373;
      }
      localLinkedList.add(this.memberUin);
      localObject1 = localObject2;
      break label1373;
      localObject1 = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      localObject3 = ContactUtils.a(paramQQAppInterface, this.frienduin, this.memberUin);
      localObject2 = ((ContactUtils.NameInfo)localObject3).jdField_a_of_type_JavaLangString;
      localObject1 = localObject2;
      if (((ContactUtils.NameInfo)localObject3).jdField_a_of_type_Boolean)
      {
        localLinkedList.add(this.memberUin);
        localObject1 = localObject2;
        break label1142;
        localObject1 = (HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
        if ((localObject1 != null) && (((HotChatManager)localObject1).b(this.frienduin)))
        {
          localObject1 = ((FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(this.memberUin);
          if ((localObject1 != null) && (((Friends)localObject1).isFriend()) && (!this.memberUin.equals(paramQQAppInterface.getCurrentAccountUin())))
          {
            localObject3 = ContactUtils.a(paramQQAppInterface, this.frienduin, this.memberUin);
            localObject2 = ((ContactUtils.NameInfo)localObject3).jdField_a_of_type_JavaLangString;
            localObject1 = localObject2;
            if (!((ContactUtils.NameInfo)localObject3).jdField_a_of_type_Boolean) {
              break label1373;
            }
            localLinkedList.add(this.memberUin);
            localObject1 = localObject2;
            break label1373;
          }
          localObject1 = ((JSONObject)localObject2).optString("hotname");
          if (QLog.isDevelopLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("hotname=");
            ((StringBuilder)localObject2).append((String)localObject1);
            QLog.i("MessageForQQWalletTips", 4, ((StringBuilder)localObject2).toString());
          }
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label1370;
          }
          localObject3 = ContactUtils.a(paramQQAppInterface, this.frienduin, this.memberUin);
          localObject2 = ((ContactUtils.NameInfo)localObject3).jdField_a_of_type_JavaLangString;
          localObject1 = localObject2;
          if (!((ContactUtils.NameInfo)localObject3).jdField_a_of_type_Boolean) {
            break label1373;
          }
          localLinkedList.add(this.memberUin);
          localObject1 = localObject2;
          break label1373;
        }
        localObject3 = ContactUtils.a(paramQQAppInterface, this.frienduin, this.memberUin);
        localObject2 = ((ContactUtils.NameInfo)localObject3).jdField_a_of_type_JavaLangString;
        localObject1 = localObject2;
        if (((ContactUtils.NameInfo)localObject3).jdField_a_of_type_Boolean)
        {
          localLinkedList.add(this.memberUin);
          localObject1 = localObject2;
          break label1142;
          localObject1 = ContactUtils.f(paramQQAppInterface, this.memberUin);
        }
      }
    }
    label1142:
    localSpannableStringBuilder.append((CharSequence)localObject1);
    localStringBuilder.append((String)localObject1);
    break label1274;
    if ((((JSONObject)localObject2).has("cmd")) || (((JSONObject)localObject2).has("jump")))
    {
      localObject1 = parseTag((JSONObject)localObject2, paramQQAppInterface, paramContext, paramString);
      if (localObject1 != null) {
        localSpannableStringBuilder.append((CharSequence)localObject1);
      }
      bool = ((JSONObject)localObject2).has("cmd");
      if (bool)
      {
        localStringBuilder.append(((JSONObject)localObject2).optString("text", ""));
      }
      else
      {
        localStringBuilder.append(((JSONObject)localObject2).optString("desc", ""));
        break label1274;
        label1264:
        label1269:
        localException3.printStackTrace();
      }
    }
    label1354:
    label1362:
    for (;;)
    {
      label1274:
      i = j + 1;
      break;
      if (i != paramString.length())
      {
        localSpannableStringBuilder.append(paramString.subSequence(i, paramString.length()));
        localStringBuilder.append(paramString.subSequence(i, paramString.length()));
      }
      this.summary = localStringBuilder.toString();
      tryGetMemberInfosAsync(localLinkedList, paramQQAppInterface, this.frienduin);
      return localSpannableStringBuilder;
      return null;
    }
  }
  
  private QWalletAIOLifeCycleHelper getQWalletAIOLifeCycleHelper(Context paramContext)
  {
    if ((paramContext instanceof BaseActivity))
    {
      paramContext = (BaseActivity)paramContext;
      if (paramContext.getChatFragment() != null)
      {
        paramContext = paramContext.getChatFragment().a();
        if (paramContext != null) {
          return (QWalletAIOLifeCycleHelper)paramContext.a(27);
        }
      }
    }
    return null;
  }
  
  private String parseListIdStr(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optString("data");
    if (paramJSONObject != null)
    {
      int i = paramJSONObject.indexOf("listid=");
      if (i >= 0)
      {
        paramJSONObject = paramJSONObject.substring(i);
        i = paramJSONObject.indexOf("&");
        if ((i > 0) && (i > 7)) {
          return paramJSONObject.substring(7, i);
        }
        return paramJSONObject.substring(7);
      }
    }
    return "";
  }
  
  private void syncIdiomRedbagStatus(QQAppInterface paramQQAppInterface, IPasswdRedBagService paramIPasswdRedBagService, String paramString)
  {
    if (paramIPasswdRedBagService != null)
    {
      if (paramQQAppInterface.getCurrentAccountUin().equals(this.reciverUin)) {
        paramIPasswdRedBagService.setPasswdRedBagOpen(paramString, this.frienduin, this.istroop);
      }
      paramIPasswdRedBagService.updateIdiomRedbagsLastword(paramString, this.frienduin, this.istroop, this.idiomSeq, this.idiom, this.lastPinyin, this.poemRule);
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
    UniteGrayTipMsgUtil.a(paramQQAppInterface, paramString2);
  }
  
  public void buildQQWalletTips(QQAppInterface paramQQAppInterface, Context paramContext, TextView paramTextView)
  {
    if (paramTextView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 1, "buildQQWalletTips textview is null");
      }
    }
    else {
      paramTextView.setText("");
    }
    Object localObject = paramQQAppInterface.getCurrentAccountUin();
    if (this.msgType == 7) {
      localObject = this.richContent;
    } else if (((String)localObject).equals(this.senderUin)) {
      localObject = this.senderContent;
    } else if (((String)localObject).equals(this.reciverUin)) {
      localObject = this.reciverContent;
    } else {
      localObject = this.reciverContent;
    }
    if (QLog.isColorLevel()) {
      if (localObject != null)
      {
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("buildQQWalletTips content = ");
        localStringBuilder.append((String)localObject);
        QLog.d(str, 1, localStringBuilder.toString());
      }
      else
      {
        QLog.d(TAG, 1, "buildQQWalletTips content is null");
      }
    }
    paramQQAppInterface = getQQWalletTips(paramQQAppInterface, paramContext, (String)localObject);
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface)))
    {
      if (QLog.isColorLevel())
      {
        paramContext = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("buildQQWalletTips realContent =");
        ((StringBuilder)localObject).append(this.reciverContent);
        QLog.d(paramContext, 1, ((StringBuilder)localObject).toString());
      }
      if (paramTextView != null)
      {
        paramTextView.setText(paramQQAppInterface);
        paramTextView.setContentDescription(this.summary);
        paramTextView.setHighlightColor(0);
        paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
        paramTextView.setGravity(19);
        paramTextView.setPadding(paramTextView.getPaddingLeft(), 6, paramTextView.getPaddingRight(), 6);
        paramTextView.setIncludeFontPadding(true);
        paramTextView.setLineSpacing(0.0F, 1.0F);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 1, "buildQQWalletTips realContent is null");
    }
  }
  
  /* Error */
  protected void doParse()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_1
    //   5: new 598	com/tencent/mobileqq/data/QwSafeInputStream
    //   8: dup
    //   9: aload_0
    //   10: getfield 602	com/tencent/mobileqq/data/MessageForQQWalletTips:msgData	[B
    //   13: invokespecial 605	com/tencent/mobileqq/data/QwSafeInputStream:<init>	([B)V
    //   16: astore_2
    //   17: aload_0
    //   18: aload_2
    //   19: invokevirtual 609	com/tencent/mobileqq/data/MessageForQQWalletTips:readExternal	(Lcom/tencent/mobileqq/data/QwSafeInputStream;)V
    //   22: aload_2
    //   23: invokevirtual 612	com/tencent/mobileqq/data/QwSafeInputStream:close	()V
    //   26: return
    //   27: astore_1
    //   28: goto +56 -> 84
    //   31: astore_1
    //   32: aload_1
    //   33: astore_3
    //   34: goto +15 -> 49
    //   37: astore_3
    //   38: aload_1
    //   39: astore_2
    //   40: aload_3
    //   41: astore_1
    //   42: goto +42 -> 84
    //   45: astore_3
    //   46: aload 4
    //   48: astore_2
    //   49: aload_2
    //   50: astore_1
    //   51: invokestatic 235	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   54: ifeq +15 -> 69
    //   57: aload_2
    //   58: astore_1
    //   59: getstatic 91	com/tencent/mobileqq/data/MessageForQQWalletTips:TAG	Ljava/lang/String;
    //   62: iconst_1
    //   63: ldc_w 614
    //   66: invokestatic 536	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: aload_2
    //   70: astore_1
    //   71: aload_3
    //   72: invokevirtual 425	java/lang/Exception:printStackTrace	()V
    //   75: aload_2
    //   76: ifnull +7 -> 83
    //   79: aload_2
    //   80: invokevirtual 612	com/tencent/mobileqq/data/QwSafeInputStream:close	()V
    //   83: return
    //   84: aload_2
    //   85: ifnull +7 -> 92
    //   88: aload_2
    //   89: invokevirtual 612	com/tencent/mobileqq/data/QwSafeInputStream:close	()V
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	MessageForQQWalletTips
    //   4	1	1	localObject1	Object
    //   27	1	1	localObject2	Object
    //   31	8	1	localException1	Exception
    //   41	52	1	localObject3	Object
    //   16	73	2	localObject4	Object
    //   33	1	3	localException2	Exception
    //   37	4	3	localObject5	Object
    //   45	27	3	localException3	Exception
    //   1	46	4	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   17	22	27	finally
    //   17	22	31	java/lang/Exception
    //   5	17	37	finally
    //   51	57	37	finally
    //   59	69	37	finally
    //   71	75	37	finally
    //   5	17	45	java/lang/Exception
  }
  
  public byte[] flushMsgData(int paramInt)
  {
    Object localObject3 = null;
    Object localObject2;
    try
    {
      localObject1 = new QwSafeOutputStream();
      try
      {
        writeExternal((QwSafeOutputStream)localObject1);
        localObject2 = localObject1;
      }
      catch (Exception localException1) {}
      localObject2 = localObject1;
    }
    catch (Exception localException2)
    {
      localObject1 = null;
    }
    if (QLog.isColorLevel())
    {
      QLog.d("Q.msg.qqwalletmsg", 2, "QQWalletRedPacketMsg write Exception", localException2);
      localObject2 = localObject1;
    }
    Object localObject1 = localObject3;
    if (localObject2 != null) {
      localObject1 = localObject2.flushDataAndCloseStream();
    }
    return localObject1;
  }
  
  public byte[] getBytes()
  {
    prewrite();
    return this.msgData;
  }
  
  public String getQQWalletTips(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramString != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramQQAppInterface = new SpannableStringBuilder();
      Matcher localMatcher = Pattern.compile("<([^>])+").matcher(paramString);
      int i = 0;
      int j;
      for (;;)
      {
        j = i;
        if (!localMatcher.find()) {
          break;
        }
        j = localMatcher.start();
        int k = localMatcher.end();
        Object localObject = paramString.substring(j + 1, k);
        String str = paramString.substring(i, j);
        i = k + 1;
        paramQQAppInterface.append(str);
        try
        {
          localObject = new JSONObject((String)localObject);
          if (((JSONObject)localObject).has("jump"))
          {
            localObject = parseJumpTag((JSONObject)localObject);
            this.highLightStart = paramQQAppInterface.length();
            if (localObject != null) {
              paramQQAppInterface.append((CharSequence)localObject);
            }
            this.highLightEnd = paramQQAppInterface.length();
            j = i;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      if (j != paramString.length()) {
        paramQQAppInterface.append(paramString.subSequence(j, paramString.length()));
      }
      return paramQQAppInterface.toString();
    }
    return null;
  }
  
  public void onReceiveGrapTips()
  {
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    QQAppInterface localQQAppInterface;
    if ((localObject1 instanceof QQAppInterface)) {
      localQQAppInterface = (QQAppInterface)localObject1;
    } else {
      localQQAppInterface = null;
    }
    if (localQQAppInterface == null) {
      return;
    }
    if (localQQAppInterface != null) {
      try
      {
        localObject1 = localQQAppInterface.getCurrentAccountUin();
        if (getHbType() == 524288) {
          localObject1 = this.richContent;
        } else if (((String)localObject1).equals(this.senderUin)) {
          localObject1 = this.senderContent;
        } else if (((String)localObject1).equals(this.reciverUin)) {
          localObject1 = this.reciverContent;
        } else {
          localObject1 = this.reciverContent;
        }
        Matcher localMatcher = Pattern.compile("<([^>])+").matcher((CharSequence)localObject1);
        Object localObject2 = "";
        Object localObject3;
        while (localMatcher.find())
        {
          localObject3 = parseListIdStr(new JSONObject(((String)localObject1).substring(localMatcher.start() + 1, localMatcher.end())));
          localObject2 = localObject3;
          if (!StringUtil.a((String)localObject3)) {
            localObject2 = localObject3;
          }
        }
        if (QLog.isColorLevel())
        {
          localObject1 = TAG;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("onReceiveGrapTips|listId: ");
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append(",msgType:");
          ((StringBuilder)localObject3).append(this.msgType);
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
        }
        localObject1 = (IPasswdRedBagService)localQQAppInterface.getRuntimeService(IPasswdRedBagService.class);
        if (this.msgType == 7)
        {
          syncIdiomRedbagStatus(localQQAppInterface, (IPasswdRedBagService)localObject1, (String)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  protected SpannableString parseCmdTag(JSONObject paramJSONObject, QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    int i = paramJSONObject.optInt("cmd");
    if (i != 1) {
      return null;
    }
    int j = paramJSONObject.optInt("isLink");
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("parse cmd tag: ");
    ((StringBuilder)localObject2).append(i);
    QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    localObject1 = paramJSONObject.optString("text");
    localObject2 = paramJSONObject.optString("textColor");
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return null;
    }
    localObject1 = new SpannableString((CharSequence)localObject1);
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      i = -16777216;
    } else {
      i = (int)Long.parseLong(((String)localObject2).substring(2), 16) | 0xFF000000;
    }
    localObject2 = new SoftReference(paramQQAppInterface);
    SoftReference localSoftReference = new SoftReference(paramContext);
    this.listId = parseListIdStr(paramJSONObject);
    paramJSONObject = (IPasswdRedBagService)paramQQAppInterface.getRuntimeService(IPasswdRedBagService.class);
    QWalletAIOLifeCycleHelper localQWalletAIOLifeCycleHelper = getQWalletAIOLifeCycleHelper(paramContext);
    ((SpannableString)localObject1).setSpan(new MessageForQQWalletTips.2(this, localSoftReference, (SoftReference)localObject2, j, paramQQAppInterface, paramContext, localQWalletAIOLifeCycleHelper, paramJSONObject, i), 0, ((SpannableString)localObject1).length(), 33);
    if ((paramJSONObject != null) && (paramString.contains(HardCodeUtil.a(2131706610))))
    {
      paramJSONObject.setPasswdRedBagFinish(this.listId);
      if (paramQQAppInterface.getCurrentAccountUin().equals(this.reciverUin)) {
        paramJSONObject.setPasswdRedBagOpen(this.listId, this.frienduin, this.istroop);
      }
      if (localQWalletAIOLifeCycleHelper != null) {
        localQWalletAIOLifeCycleHelper.a(this.listId);
      }
    }
    return localObject1;
  }
  
  protected SpannableString parseJumpTag(QQAppInterface paramQQAppInterface, JSONObject paramJSONObject, Context paramContext)
  {
    if (!paramJSONObject.optString("jump").equals("1")) {
      return null;
    }
    Object localObject = paramJSONObject.optString("desc");
    paramQQAppInterface = paramJSONObject.optString("textColor");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    localObject = new SpannableString((CharSequence)localObject);
    boolean bool = TextUtils.isEmpty(paramQQAppInterface);
    int i = -16777216;
    if (!bool) {
      i = 0xFF000000 | (int)Long.parseLong(paramQQAppInterface.substring(2), 16);
    }
    ((SpannableString)localObject).setSpan(new MessageForQQWalletTips.3(this, paramJSONObject.optString("data"), new SoftReference(paramContext), i), 0, ((SpannableString)localObject).length(), 33);
    return localObject;
  }
  
  protected SpannableString parseJumpTag(JSONObject paramJSONObject)
  {
    if (!paramJSONObject.optString("jump").equals("1")) {
      return null;
    }
    Object localObject = paramJSONObject.optString("desc");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    SpannableString localSpannableString = new SpannableString((CharSequence)localObject);
    this.textColor = paramJSONObject.optString("textColor");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    if (!TextUtils.isEmpty(this.textColor))
    {
      if ((!this.textColor.startsWith("0x")) && (!this.textColor.startsWith("0X")))
      {
        if (this.textColor.length() == 6)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("#FF");
          ((StringBuilder)localObject).append(this.textColor);
          this.textColor = ((StringBuilder)localObject).toString();
        }
        else if (this.textColor.length() == 8)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("#");
          ((StringBuilder)localObject).append(this.textColor);
          this.textColor = ((StringBuilder)localObject).toString();
        }
        else
        {
          this.textColor = "#FF40A0FF";
        }
      }
      else if (this.textColor.length() == 8)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("#FF");
        ((StringBuilder)localObject).append(this.textColor.substring(2));
        this.textColor = ((StringBuilder)localObject).toString();
      }
      else if (this.textColor.length() == 10)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("#");
        ((StringBuilder)localObject).append(this.textColor.substring(2));
        this.textColor = ((StringBuilder)localObject).toString();
      }
      else
      {
        this.textColor = "#FF40A0FF";
      }
    }
    else {
      this.textColor = "#FF40A0FF";
    }
    this.url = paramJSONObject.optString("data");
    return localSpannableString;
  }
  
  protected SpannableString parseTag(JSONObject paramJSONObject, QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    if (paramJSONObject == null) {
      return null;
    }
    if (paramJSONObject.has("cmd")) {
      return parseCmdTag(paramJSONObject, paramQQAppInterface, paramContext, paramString);
    }
    if (paramJSONObject.has("jump")) {
      return parseJumpTag(paramQQAppInterface, paramJSONObject, paramContext);
    }
    return null;
  }
  
  protected void prewrite()
  {
    byte[] arrayOfByte = flushMsgData(this.msgType);
    if (arrayOfByte != null) {
      this.msgData = arrayOfByte;
    }
  }
  
  public void readExternal(QwSafeInputStream paramQwSafeInputStream)
  {
    this.senderUin = paramQwSafeInputStream.readUTF();
    this.reciverUin = paramQwSafeInputStream.readUTF();
    this.senderContent = paramQwSafeInputStream.readUTF();
    this.reciverContent = paramQwSafeInputStream.readUTF();
    this.authKey = paramQwSafeInputStream.readUTF();
    this.type = paramQwSafeInputStream.readInt();
    this.subType = paramQwSafeInputStream.readInt();
    this.msgType = paramQwSafeInputStream.readInt();
    this.idiomSeq = paramQwSafeInputStream.readInt();
    this.idiom = paramQwSafeInputStream.readUTF();
    this.richContent = paramQwSafeInputStream.readUTF();
    this.lastPinyin = paramQwSafeInputStream.readUTF();
    this.bytes_jumpurl = paramQwSafeInputStream.readUTF();
    this.subChannel = paramQwSafeInputStream.readInt();
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
    if (paramQQAppInterface == null) {
      return;
    }
    paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
    if (paramQQAppInterface != null)
    {
      Message localMessage = new Message();
      localMessage.what = 78;
      localMessage.arg1 = 890;
      Bundle localBundle = new Bundle();
      localBundle.putLong("messageUniseq", this.uniseq);
      localMessage.setData(localBundle);
      paramQQAppInterface.sendMessage(localMessage);
    }
  }
  
  public void writeExternal(QwSafeOutputStream paramQwSafeOutputStream)
  {
    paramQwSafeOutputStream.writeUTF(this.senderUin);
    paramQwSafeOutputStream.writeUTF(this.reciverUin);
    paramQwSafeOutputStream.writeUTF(this.senderContent);
    paramQwSafeOutputStream.writeUTF(this.reciverContent);
    paramQwSafeOutputStream.writeUTF(this.authKey);
    paramQwSafeOutputStream.writeInt(this.type);
    paramQwSafeOutputStream.writeInt(this.subType);
    paramQwSafeOutputStream.writeInt(this.msgType);
    paramQwSafeOutputStream.writeInt(this.idiomSeq);
    paramQwSafeOutputStream.writeUTF(this.idiom);
    paramQwSafeOutputStream.writeUTF(this.richContent);
    paramQwSafeOutputStream.writeUTF(this.lastPinyin);
    paramQwSafeOutputStream.writeUTF(this.bytes_jumpurl);
    paramQwSafeOutputStream.writeInt(this.subChannel);
  }
  
  public void writeHeader(QwSafeOutputStream paramQwSafeOutputStream, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQQWalletTips
 * JD-Core Version:    0.7.0.1
 */