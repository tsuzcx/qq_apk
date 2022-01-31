package com.tencent.mobileqq.data;

import afft;
import aiul;
import alrk;
import alto;
import alud;
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
import apey;
import apfc;
import apfd;
import aspy;
import aspz;
import ayzl;
import azjh;
import bdgc;
import bdgd;
import bdnn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
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
  public int highLightEnd;
  public int highLightStart;
  public String idiom = "";
  public int idiomSeq;
  public String lastPinyin = "";
  private String listId = "";
  public String memberUin;
  public int msgType;
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
      localHashMap.put("recv_uin", paramQQAppInterface.c() + "");
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
        localObject1 = (HotChatManager)paramQQAppInterface.getManager(60);
        if ((localObject1 != null) && (((HotChatManager)localObject1).b(this.frienduin)))
        {
          localObject1 = bdgc.q(paramQQAppInterface, paramQQAppInterface.getCurrentNickname());
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            break label356;
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
        localObject1 = bdgc.a(paramQQAppInterface, this.frienduin, this.memberUin);
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
        localObject1 = bdgc.q(paramQQAppInterface, paramQQAppInterface.getCurrentNickname());
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label351;
        }
        localObject1 = paramQQAppInterface.getCurrentNickname();
        i = 1;
        break;
      }
      label351:
      i = 1;
      continue;
      label356:
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
    aiul localaiul = (aiul)paramQQAppInterface.getManager(125);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    StringBuilder localStringBuilder = new StringBuilder();
    Matcher localMatcher = Pattern.compile("<([^>])+").matcher(paramString);
    LinkedList localLinkedList = new LinkedList();
    label1296:
    label1302:
    for (;;)
    {
      Object localObject3;
      Object localObject4;
      label372:
      label375:
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
            break label375;
          }
          localObject4 = ((JSONObject)localObject3).optString("icon");
          localObject3 = new SpannableString((CharSequence)localObject1);
          if (((String)localObject4).startsWith("qqwallet"))
          {
            j = getHbType();
            if (j == 524288) {
              localObject1 = localaiul.a("StatusIcon_IdiomHongBaoIcon", 2130846775);
            }
            while (localObject1 != null)
            {
              ((SpannableString)localObject3).setSpan(new MessageForQQWalletTips.CenterImageSpan(paramContext, (Bitmap)localObject1), 0, ((SpannableString)localObject3).length(), 33);
              localSpannableStringBuilder.append((CharSequence)localObject3);
              localSpannableStringBuilder.append(" ");
              break;
              if (j == 999) {
                localObject1 = localaiul.a("StatusIcon_GoldHongBaoIcon", 2130846773);
              } else {
                localObject1 = localaiul.a("StatusIcon_HongBaoIcon", 2130846837);
              }
            }
          }
          if ((!((String)localObject4).startsWith("http://")) && (!((String)localObject4).startsWith("https://"))) {
            break label1296;
          }
          ((SpannableString)localObject3).setSpan(new apey(paramContext, 0, (String)localObject4), 0, ((SpannableString)localObject3).length(), 33);
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
        localObject2 = bdgc.m(paramQQAppInterface, this.memberUin);
        continue;
        localObject2 = (HotChatManager)paramQQAppInterface.getManager(60);
        if ((localObject2 != null) && (((HotChatManager)localObject2).b(this.frienduin)))
        {
          localObject2 = ((alto)paramQQAppInterface.getManager(51)).e(this.memberUin);
          if ((localObject2 != null) && (((Friends)localObject2).isFriend()) && (!this.memberUin.equals(paramQQAppInterface.getCurrentAccountUin())))
          {
            localObject4 = bdgc.a(paramQQAppInterface, this.frienduin, this.memberUin);
            localObject3 = ((bdgd)localObject4).jdField_a_of_type_JavaLangString;
            localObject2 = localObject3;
            if (((bdgd)localObject4).jdField_a_of_type_Boolean)
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
              localObject4 = bdgc.a(paramQQAppInterface, this.frienduin, this.memberUin);
              localObject3 = ((bdgd)localObject4).jdField_a_of_type_JavaLangString;
              localObject2 = localObject3;
              if (((bdgd)localObject4).jdField_a_of_type_Boolean)
              {
                localLinkedList.add(this.memberUin);
                localObject2 = localObject3;
              }
            }
          }
        }
        else
        {
          localObject4 = bdgc.a(paramQQAppInterface, this.frienduin, this.memberUin);
          localObject3 = ((bdgd)localObject4).jdField_a_of_type_JavaLangString;
          localObject2 = localObject3;
          if (((bdgd)localObject4).jdField_a_of_type_Boolean)
          {
            localLinkedList.add(this.memberUin);
            localObject2 = localObject3;
            continue;
            localObject2 = ((alrk)paramQQAppInterface.getManager(53)).a(this.frienduin, this.memberUin);
            if (localObject2 != null)
            {
              localObject2 = ((DiscussionMemberInfo)localObject2).inteRemark;
            }
            else
            {
              localObject2 = bdgc.a(paramQQAppInterface, this.frienduin, this.memberUin);
              continue;
              localObject2 = (TroopManager)paramQQAppInterface.getManager(52);
              localObject4 = bdgc.a(paramQQAppInterface, this.frienduin, this.memberUin);
              localObject3 = ((bdgd)localObject4).jdField_a_of_type_JavaLangString;
              localObject2 = localObject3;
              if (((bdgd)localObject4).jdField_a_of_type_Boolean)
              {
                localLinkedList.add(this.memberUin);
                localObject2 = localObject3;
                continue;
                localObject2 = bdgc.a(paramQQAppInterface, this.senderuin, this.memberUin);
                continue;
                localObject2 = ((alto)paramQQAppInterface.getManager(51)).e(this.memberUin);
                if ((localObject2 != null) && (((Friends)localObject2).isFriend()) && (!this.memberUin.equals(paramQQAppInterface.getCurrentAccountUin())))
                {
                  localObject4 = bdgc.a(paramQQAppInterface, this.frienduin, this.memberUin);
                  localObject3 = ((bdgd)localObject4).jdField_a_of_type_JavaLangString;
                  localObject2 = localObject3;
                  if (((bdgd)localObject4).jdField_a_of_type_Boolean)
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
                    localObject4 = bdgc.a(paramQQAppInterface, this.frienduin, this.memberUin);
                    localObject3 = ((bdgd)localObject4).jdField_a_of_type_JavaLangString;
                    localObject2 = localObject3;
                    if (((bdgd)localObject4).jdField_a_of_type_Boolean)
                    {
                      localLinkedList.add(this.memberUin);
                      localObject2 = localObject3;
                      continue;
                      if ((!((JSONObject)localObject3).has("cmd")) && (!((JSONObject)localObject3).has("jump"))) {
                        break label372;
                      }
                      localObject2 = parseTag((JSONObject)localObject3, paramQQAppInterface, paramContext, paramString);
                      if (localObject2 != null) {
                        localSpannableStringBuilder.append((CharSequence)localObject2);
                      }
                      if (((JSONObject)localObject3).has("cmd"))
                      {
                        localStringBuilder.append(((JSONObject)localObject3).optString("text", ""));
                        break label1302;
                      }
                      localStringBuilder.append(((JSONObject)localObject3).optString("desc", ""));
                      break label1302;
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
  
  private afft getQWalletAIOLifeCycleHelper(Context paramContext)
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
          localObject1 = (afft)paramContext.a(27);
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
  
  private void syncIdiomRedbagStatus(QQAppInterface paramQQAppInterface, aiul paramaiul, String paramString)
  {
    if (paramaiul != null)
    {
      if (paramQQAppInterface.getCurrentAccountUin().equals(this.reciverUin)) {
        paramaiul.a(paramString, this.frienduin, this.istroop);
      }
      paramaiul.a(paramString, this.frienduin, this.istroop, this.idiomSeq, this.idiom, this.lastPinyin);
    }
  }
  
  public void addQQWalletTips(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    paramString1 = new aspy(this.frienduin, paramQQAppInterface.getCurrentAccountUin(), paramString1.toString(), this.istroop, -5020, 3145729, ayzl.a());
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
    aspz.a(paramQQAppInterface, paramString2);
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
    //   0: aconst_null
    //   1: astore 4
    //   3: new 575	java/io/ByteArrayInputStream
    //   6: dup
    //   7: aload_0
    //   8: getfield 579	com/tencent/mobileqq/data/MessageForQQWalletTips:msgData	[B
    //   11: invokespecial 582	java/io/ByteArrayInputStream:<init>	([B)V
    //   14: astore_3
    //   15: new 584	java/io/ObjectInputStream
    //   18: dup
    //   19: aload_3
    //   20: invokespecial 587	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   23: astore 5
    //   25: aload_0
    //   26: aload 5
    //   28: invokevirtual 590	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   31: putfield 524	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   34: aload_0
    //   35: aload 5
    //   37: invokevirtual 590	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   40: putfield 180	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   43: aload_0
    //   44: aload 5
    //   46: invokevirtual 590	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   49: putfield 526	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   52: aload_0
    //   53: aload 5
    //   55: invokevirtual 590	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   58: putfield 528	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   61: aload_0
    //   62: aload 5
    //   64: invokevirtual 590	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   67: putfield 592	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   70: aload_0
    //   71: iconst_0
    //   72: putfield 594	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   75: aload_0
    //   76: iconst_0
    //   77: putfield 228	com/tencent/mobileqq/data/MessageForQQWalletTips:subType	I
    //   80: aload 5
    //   82: invokevirtual 597	java/io/ObjectInputStream:available	()I
    //   85: ifle +12 -> 97
    //   88: aload_0
    //   89: aload 5
    //   91: invokevirtual 600	java/io/ObjectInputStream:readInt	()I
    //   94: putfield 594	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   97: aload 5
    //   99: invokevirtual 597	java/io/ObjectInputStream:available	()I
    //   102: ifle +12 -> 114
    //   105: aload_0
    //   106: aload 5
    //   108: invokevirtual 600	java/io/ObjectInputStream:readInt	()I
    //   111: putfield 228	com/tencent/mobileqq/data/MessageForQQWalletTips:subType	I
    //   114: aload_0
    //   115: iconst_0
    //   116: putfield 224	com/tencent/mobileqq/data/MessageForQQWalletTips:msgType	I
    //   119: aload 5
    //   121: invokevirtual 597	java/io/ObjectInputStream:available	()I
    //   124: istore_1
    //   125: iload_1
    //   126: ifle +12 -> 138
    //   129: aload_0
    //   130: aload 5
    //   132: invokevirtual 600	java/io/ObjectInputStream:readInt	()I
    //   135: putfield 224	com/tencent/mobileqq/data/MessageForQQWalletTips:msgType	I
    //   138: aload 5
    //   140: invokevirtual 597	java/io/ObjectInputStream:available	()I
    //   143: ifle +12 -> 155
    //   146: aload_0
    //   147: aload 5
    //   149: invokevirtual 600	java/io/ObjectInputStream:readInt	()I
    //   152: putfield 456	com/tencent/mobileqq/data/MessageForQQWalletTips:idiomSeq	I
    //   155: aload 5
    //   157: invokevirtual 597	java/io/ObjectInputStream:available	()I
    //   160: ifle +12 -> 172
    //   163: aload_0
    //   164: aload 5
    //   166: invokevirtual 590	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   169: putfield 72	com/tencent/mobileqq/data/MessageForQQWalletTips:idiom	Ljava/lang/String;
    //   172: aload 5
    //   174: invokevirtual 597	java/io/ObjectInputStream:available	()I
    //   177: ifle +12 -> 189
    //   180: aload_0
    //   181: aload 5
    //   183: invokevirtual 590	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   186: putfield 74	com/tencent/mobileqq/data/MessageForQQWalletTips:richContent	Ljava/lang/String;
    //   189: aload 5
    //   191: invokevirtual 597	java/io/ObjectInputStream:available	()I
    //   194: ifle +12 -> 206
    //   197: aload_0
    //   198: aload 5
    //   200: invokevirtual 590	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   203: putfield 76	com/tencent/mobileqq/data/MessageForQQWalletTips:lastPinyin	Ljava/lang/String;
    //   206: aload 5
    //   208: invokevirtual 597	java/io/ObjectInputStream:available	()I
    //   211: ifle +12 -> 223
    //   214: aload_0
    //   215: aload 5
    //   217: invokevirtual 590	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   220: putfield 78	com/tencent/mobileqq/data/MessageForQQWalletTips:bytes_jumpurl	Ljava/lang/String;
    //   223: aload 5
    //   225: invokevirtual 597	java/io/ObjectInputStream:available	()I
    //   228: ifle +12 -> 240
    //   231: aload_0
    //   232: aload 5
    //   234: invokevirtual 600	java/io/ObjectInputStream:readInt	()I
    //   237: putfield 602	com/tencent/mobileqq/data/MessageForQQWalletTips:subChannel	I
    //   240: aload 5
    //   242: ifnull +8 -> 250
    //   245: aload 5
    //   247: invokevirtual 605	java/io/ObjectInputStream:close	()V
    //   250: aload_3
    //   251: ifnull +7 -> 258
    //   254: aload_3
    //   255: invokevirtual 606	java/io/ByteArrayInputStream:close	()V
    //   258: return
    //   259: astore_2
    //   260: aload_0
    //   261: iconst_0
    //   262: putfield 224	com/tencent/mobileqq/data/MessageForQQWalletTips:msgType	I
    //   265: goto -127 -> 138
    //   268: astore_2
    //   269: aload 5
    //   271: astore 4
    //   273: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   276: ifeq +13 -> 289
    //   279: getstatic 50	com/tencent/mobileqq/data/MessageForQQWalletTips:TAG	Ljava/lang/String;
    //   282: iconst_1
    //   283: ldc_w 608
    //   286: invokestatic 511	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   289: aload_2
    //   290: invokevirtual 333	java/lang/Exception:printStackTrace	()V
    //   293: aload 4
    //   295: ifnull +8 -> 303
    //   298: aload 4
    //   300: invokevirtual 605	java/io/ObjectInputStream:close	()V
    //   303: aload_3
    //   304: ifnull -46 -> 258
    //   307: aload_3
    //   308: invokevirtual 606	java/io/ByteArrayInputStream:close	()V
    //   311: return
    //   312: astore_2
    //   313: aload_2
    //   314: invokevirtual 333	java/lang/Exception:printStackTrace	()V
    //   317: return
    //   318: astore_2
    //   319: aload_2
    //   320: invokevirtual 333	java/lang/Exception:printStackTrace	()V
    //   323: goto -73 -> 250
    //   326: astore_2
    //   327: aload_2
    //   328: invokevirtual 333	java/lang/Exception:printStackTrace	()V
    //   331: return
    //   332: astore_2
    //   333: aload_2
    //   334: invokevirtual 333	java/lang/Exception:printStackTrace	()V
    //   337: goto -34 -> 303
    //   340: astore_2
    //   341: aconst_null
    //   342: astore 4
    //   344: aconst_null
    //   345: astore_3
    //   346: aload_3
    //   347: ifnull +7 -> 354
    //   350: aload_3
    //   351: invokevirtual 605	java/io/ObjectInputStream:close	()V
    //   354: aload 4
    //   356: ifnull +8 -> 364
    //   359: aload 4
    //   361: invokevirtual 606	java/io/ByteArrayInputStream:close	()V
    //   364: aload_2
    //   365: athrow
    //   366: astore_3
    //   367: aload_3
    //   368: invokevirtual 333	java/lang/Exception:printStackTrace	()V
    //   371: goto -17 -> 354
    //   374: astore_3
    //   375: aload_3
    //   376: invokevirtual 333	java/lang/Exception:printStackTrace	()V
    //   379: goto -15 -> 364
    //   382: astore_2
    //   383: aconst_null
    //   384: astore 5
    //   386: aload_3
    //   387: astore 4
    //   389: aload 5
    //   391: astore_3
    //   392: goto -46 -> 346
    //   395: astore_2
    //   396: aload_3
    //   397: astore 4
    //   399: aload 5
    //   401: astore_3
    //   402: goto -56 -> 346
    //   405: astore_2
    //   406: aload 4
    //   408: astore 5
    //   410: aload_3
    //   411: astore 4
    //   413: aload 5
    //   415: astore_3
    //   416: goto -70 -> 346
    //   419: astore_2
    //   420: aconst_null
    //   421: astore_3
    //   422: goto -149 -> 273
    //   425: astore_2
    //   426: goto -153 -> 273
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	429	0	this	MessageForQQWalletTips
    //   124	2	1	i	int
    //   259	1	2	localThrowable	java.lang.Throwable
    //   268	22	2	localException1	Exception
    //   312	2	2	localException2	Exception
    //   318	2	2	localException3	Exception
    //   326	2	2	localException4	Exception
    //   332	2	2	localException5	Exception
    //   340	25	2	localObject1	Object
    //   382	1	2	localObject2	Object
    //   395	1	2	localObject3	Object
    //   405	1	2	localObject4	Object
    //   419	1	2	localException6	Exception
    //   425	1	2	localException7	Exception
    //   14	337	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   366	2	3	localException8	Exception
    //   374	13	3	localException9	Exception
    //   391	31	3	localObject5	Object
    //   1	411	4	localObject6	Object
    //   23	391	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   129	138	259	java/lang/Throwable
    //   25	97	268	java/lang/Exception
    //   97	114	268	java/lang/Exception
    //   114	125	268	java/lang/Exception
    //   129	138	268	java/lang/Exception
    //   138	155	268	java/lang/Exception
    //   155	172	268	java/lang/Exception
    //   172	189	268	java/lang/Exception
    //   189	206	268	java/lang/Exception
    //   206	223	268	java/lang/Exception
    //   223	240	268	java/lang/Exception
    //   260	265	268	java/lang/Exception
    //   307	311	312	java/lang/Exception
    //   245	250	318	java/lang/Exception
    //   254	258	326	java/lang/Exception
    //   298	303	332	java/lang/Exception
    //   3	15	340	finally
    //   350	354	366	java/lang/Exception
    //   359	364	374	java/lang/Exception
    //   15	25	382	finally
    //   25	97	395	finally
    //   97	114	395	finally
    //   114	125	395	finally
    //   129	138	395	finally
    //   138	155	395	finally
    //   155	172	395	finally
    //   172	189	395	finally
    //   189	206	395	finally
    //   206	223	395	finally
    //   223	240	395	finally
    //   260	265	395	finally
    //   273	289	405	finally
    //   289	293	405	finally
    //   3	15	419	java/lang/Exception
    //   15	25	425	java/lang/Exception
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
          azjh.a(localQQAppInterface).a(this.frienduin, this.istroop, (String)localObject1);
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
          break label262;
        }
        localObject1 = this.richContent;
        Matcher localMatcher = Pattern.compile("<([^>])+").matcher((CharSequence)localObject1);
        localObject3 = "";
        if (!localMatcher.find()) {
          break label308;
        }
        String str = parseListIdStr(new JSONObject(((String)localObject1).substring(localMatcher.start() + 1, localMatcher.end())));
        localObject3 = str;
        if (bdnn.a(str)) {
          continue;
        }
        localObject1 = str;
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "onReceiveGrapTips|listId: " + (String)localObject1);
        }
        localObject3 = (aiul)localQQAppInterface.getManager(125);
        if (this.msgType != 7) {
          break;
        }
        syncIdiomRedbagStatus(localQQAppInterface, (aiul)localObject3, (String)localObject1);
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      i = 0;
      break label46;
      label262:
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
        label308:
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
      paramJSONObject = (aiul)paramQQAppInterface.getManager(125);
      afft localafft = getQWalletAIOLifeCycleHelper(paramContext);
      ((SpannableString)localObject1).setSpan(new apfc(this, localSoftReference, (SoftReference)localObject2, paramQQAppInterface, paramContext, localafft, paramJSONObject, i), 0, ((SpannableString)localObject1).length(), 33);
      if ((paramJSONObject != null) && (paramString.contains(alud.a(2131706969))))
      {
        paramJSONObject.a(this.listId);
        if (paramQQAppInterface.getCurrentAccountUin().equals(this.reciverUin)) {
          paramJSONObject.a(this.listId, this.frienduin, this.istroop);
        }
        if (localafft != null) {
          localafft.a(this.listId);
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
      ((SpannableString)localObject).setSpan(new apfd(this, paramJSONObject.optString("data"), new SoftReference(paramContext), i), 0, ((SpannableString)localObject).length(), 33);
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
  
  /* Error */
  public void prewrite()
  {
    // Byte code:
    //   0: new 721	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 722	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 724	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 727	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: getfield 524	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   25: invokestatic 657	bdnn:a	(Ljava/lang/String;)Z
    //   28: ifne +275 -> 303
    //   31: aload_2
    //   32: astore_1
    //   33: aload_2
    //   34: aload_0
    //   35: getfield 524	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   38: invokevirtual 730	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   41: aload_2
    //   42: astore_1
    //   43: aload_0
    //   44: getfield 180	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   47: invokestatic 657	bdnn:a	(Ljava/lang/String;)Z
    //   50: ifne +316 -> 366
    //   53: aload_2
    //   54: astore_1
    //   55: aload_2
    //   56: aload_0
    //   57: getfield 180	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   60: invokevirtual 730	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   63: aload_2
    //   64: astore_1
    //   65: aload_0
    //   66: getfield 526	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   69: invokestatic 657	bdnn:a	(Ljava/lang/String;)Z
    //   72: ifne +330 -> 402
    //   75: aload_2
    //   76: astore_1
    //   77: aload_2
    //   78: aload_0
    //   79: getfield 526	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   82: invokevirtual 730	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   85: aload_2
    //   86: astore_1
    //   87: aload_0
    //   88: getfield 528	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   91: invokestatic 657	bdnn:a	(Ljava/lang/String;)Z
    //   94: ifne +319 -> 413
    //   97: aload_2
    //   98: astore_1
    //   99: aload_2
    //   100: aload_0
    //   101: getfield 528	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   104: invokevirtual 730	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   107: aload_2
    //   108: astore_1
    //   109: aload_0
    //   110: getfield 592	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   113: invokestatic 657	bdnn:a	(Ljava/lang/String;)Z
    //   116: ifne +308 -> 424
    //   119: aload_2
    //   120: astore_1
    //   121: aload_2
    //   122: aload_0
    //   123: getfield 592	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   126: invokevirtual 730	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   129: aload_2
    //   130: astore_1
    //   131: aload_2
    //   132: aload_0
    //   133: getfield 594	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   136: invokevirtual 733	java/io/ObjectOutputStream:writeInt	(I)V
    //   139: aload_2
    //   140: astore_1
    //   141: aload_2
    //   142: aload_0
    //   143: getfield 228	com/tencent/mobileqq/data/MessageForQQWalletTips:subType	I
    //   146: invokevirtual 733	java/io/ObjectOutputStream:writeInt	(I)V
    //   149: aload_2
    //   150: astore_1
    //   151: aload_2
    //   152: aload_0
    //   153: getfield 224	com/tencent/mobileqq/data/MessageForQQWalletTips:msgType	I
    //   156: invokevirtual 733	java/io/ObjectOutputStream:writeInt	(I)V
    //   159: aload_2
    //   160: astore_1
    //   161: aload_2
    //   162: aload_0
    //   163: getfield 456	com/tencent/mobileqq/data/MessageForQQWalletTips:idiomSeq	I
    //   166: invokevirtual 733	java/io/ObjectOutputStream:writeInt	(I)V
    //   169: aload_2
    //   170: astore_1
    //   171: aload_0
    //   172: getfield 72	com/tencent/mobileqq/data/MessageForQQWalletTips:idiom	Ljava/lang/String;
    //   175: invokestatic 657	bdnn:a	(Ljava/lang/String;)Z
    //   178: ifne +257 -> 435
    //   181: aload_2
    //   182: astore_1
    //   183: aload_2
    //   184: aload_0
    //   185: getfield 72	com/tencent/mobileqq/data/MessageForQQWalletTips:idiom	Ljava/lang/String;
    //   188: invokevirtual 730	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   191: aload_2
    //   192: astore_1
    //   193: aload_0
    //   194: getfield 74	com/tencent/mobileqq/data/MessageForQQWalletTips:richContent	Ljava/lang/String;
    //   197: invokestatic 657	bdnn:a	(Ljava/lang/String;)Z
    //   200: ifne +246 -> 446
    //   203: aload_2
    //   204: astore_1
    //   205: aload_2
    //   206: aload_0
    //   207: getfield 74	com/tencent/mobileqq/data/MessageForQQWalletTips:richContent	Ljava/lang/String;
    //   210: invokevirtual 730	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   213: aload_2
    //   214: astore_1
    //   215: aload_0
    //   216: getfield 76	com/tencent/mobileqq/data/MessageForQQWalletTips:lastPinyin	Ljava/lang/String;
    //   219: invokestatic 657	bdnn:a	(Ljava/lang/String;)Z
    //   222: ifne +235 -> 457
    //   225: aload_2
    //   226: astore_1
    //   227: aload_2
    //   228: aload_0
    //   229: getfield 76	com/tencent/mobileqq/data/MessageForQQWalletTips:lastPinyin	Ljava/lang/String;
    //   232: invokevirtual 730	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   235: aload_2
    //   236: astore_1
    //   237: aload_0
    //   238: getfield 78	com/tencent/mobileqq/data/MessageForQQWalletTips:bytes_jumpurl	Ljava/lang/String;
    //   241: invokestatic 657	bdnn:a	(Ljava/lang/String;)Z
    //   244: ifne +224 -> 468
    //   247: aload_2
    //   248: astore_1
    //   249: aload_2
    //   250: aload_0
    //   251: getfield 78	com/tencent/mobileqq/data/MessageForQQWalletTips:bytes_jumpurl	Ljava/lang/String;
    //   254: invokevirtual 730	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   257: aload_2
    //   258: astore_1
    //   259: aload_2
    //   260: aload_0
    //   261: getfield 602	com/tencent/mobileqq/data/MessageForQQWalletTips:subChannel	I
    //   264: invokevirtual 733	java/io/ObjectOutputStream:writeInt	(I)V
    //   267: aload_2
    //   268: astore_1
    //   269: aload_2
    //   270: invokevirtual 736	java/io/ObjectOutputStream:flush	()V
    //   273: aload_2
    //   274: astore_1
    //   275: aload_0
    //   276: aload 4
    //   278: invokevirtual 739	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   281: putfield 579	com/tencent/mobileqq/data/MessageForQQWalletTips:msgData	[B
    //   284: aload_2
    //   285: ifnull +7 -> 292
    //   288: aload_2
    //   289: invokevirtual 740	java/io/ObjectOutputStream:close	()V
    //   292: aload 4
    //   294: ifnull +8 -> 302
    //   297: aload 4
    //   299: invokevirtual 741	java/io/ByteArrayOutputStream:close	()V
    //   302: return
    //   303: aload_2
    //   304: astore_1
    //   305: aload_2
    //   306: ldc 66
    //   308: invokevirtual 730	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   311: goto -270 -> 41
    //   314: astore_3
    //   315: aload_2
    //   316: astore_1
    //   317: invokestatic 220	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   320: ifeq +15 -> 335
    //   323: aload_2
    //   324: astore_1
    //   325: getstatic 50	com/tencent/mobileqq/data/MessageForQQWalletTips:TAG	Ljava/lang/String;
    //   328: iconst_1
    //   329: ldc_w 743
    //   332: invokestatic 511	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: aload_2
    //   336: astore_1
    //   337: aload_3
    //   338: invokevirtual 333	java/lang/Exception:printStackTrace	()V
    //   341: aload_2
    //   342: ifnull +7 -> 349
    //   345: aload_2
    //   346: invokevirtual 740	java/io/ObjectOutputStream:close	()V
    //   349: aload 4
    //   351: ifnull -49 -> 302
    //   354: aload 4
    //   356: invokevirtual 741	java/io/ByteArrayOutputStream:close	()V
    //   359: return
    //   360: astore_1
    //   361: aload_1
    //   362: invokevirtual 333	java/lang/Exception:printStackTrace	()V
    //   365: return
    //   366: aload_2
    //   367: astore_1
    //   368: aload_2
    //   369: ldc 66
    //   371: invokevirtual 730	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   374: goto -311 -> 63
    //   377: astore_3
    //   378: aload_1
    //   379: astore_2
    //   380: aload_3
    //   381: astore_1
    //   382: aload_2
    //   383: ifnull +7 -> 390
    //   386: aload_2
    //   387: invokevirtual 740	java/io/ObjectOutputStream:close	()V
    //   390: aload 4
    //   392: ifnull +8 -> 400
    //   395: aload 4
    //   397: invokevirtual 741	java/io/ByteArrayOutputStream:close	()V
    //   400: aload_1
    //   401: athrow
    //   402: aload_2
    //   403: astore_1
    //   404: aload_2
    //   405: ldc 66
    //   407: invokevirtual 730	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   410: goto -325 -> 85
    //   413: aload_2
    //   414: astore_1
    //   415: aload_2
    //   416: ldc 66
    //   418: invokevirtual 730	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   421: goto -314 -> 107
    //   424: aload_2
    //   425: astore_1
    //   426: aload_2
    //   427: ldc 66
    //   429: invokevirtual 730	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   432: goto -303 -> 129
    //   435: aload_2
    //   436: astore_1
    //   437: aload_2
    //   438: ldc 66
    //   440: invokevirtual 730	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   443: goto -252 -> 191
    //   446: aload_2
    //   447: astore_1
    //   448: aload_2
    //   449: ldc 66
    //   451: invokevirtual 730	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   454: goto -241 -> 213
    //   457: aload_2
    //   458: astore_1
    //   459: aload_2
    //   460: ldc 66
    //   462: invokevirtual 730	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   465: goto -230 -> 235
    //   468: aload_2
    //   469: astore_1
    //   470: aload_2
    //   471: ldc 66
    //   473: invokevirtual 730	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   476: goto -219 -> 257
    //   479: astore_1
    //   480: aload_1
    //   481: invokevirtual 333	java/lang/Exception:printStackTrace	()V
    //   484: goto -192 -> 292
    //   487: astore_1
    //   488: aload_1
    //   489: invokevirtual 333	java/lang/Exception:printStackTrace	()V
    //   492: return
    //   493: astore_1
    //   494: aload_1
    //   495: invokevirtual 333	java/lang/Exception:printStackTrace	()V
    //   498: goto -149 -> 349
    //   501: astore_2
    //   502: aload_2
    //   503: invokevirtual 333	java/lang/Exception:printStackTrace	()V
    //   506: goto -116 -> 390
    //   509: astore_2
    //   510: aload_2
    //   511: invokevirtual 333	java/lang/Exception:printStackTrace	()V
    //   514: goto -114 -> 400
    //   517: astore_1
    //   518: aconst_null
    //   519: astore_2
    //   520: goto -138 -> 382
    //   523: astore_3
    //   524: aconst_null
    //   525: astore_2
    //   526: goto -211 -> 315
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	529	0	this	MessageForQQWalletTips
    //   20	317	1	localObject1	Object
    //   360	2	1	localException1	Exception
    //   367	103	1	localObject2	Object
    //   479	2	1	localException2	Exception
    //   487	2	1	localException3	Exception
    //   493	2	1	localException4	Exception
    //   517	1	1	localObject3	Object
    //   18	453	2	localObject4	Object
    //   501	2	2	localException5	Exception
    //   509	2	2	localException6	Exception
    //   519	7	2	localObject5	Object
    //   314	24	3	localException7	Exception
    //   377	4	3	localObject6	Object
    //   523	1	3	localException8	Exception
    //   7	389	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   21	31	314	java/lang/Exception
    //   33	41	314	java/lang/Exception
    //   43	53	314	java/lang/Exception
    //   55	63	314	java/lang/Exception
    //   65	75	314	java/lang/Exception
    //   77	85	314	java/lang/Exception
    //   87	97	314	java/lang/Exception
    //   99	107	314	java/lang/Exception
    //   109	119	314	java/lang/Exception
    //   121	129	314	java/lang/Exception
    //   131	139	314	java/lang/Exception
    //   141	149	314	java/lang/Exception
    //   151	159	314	java/lang/Exception
    //   161	169	314	java/lang/Exception
    //   171	181	314	java/lang/Exception
    //   183	191	314	java/lang/Exception
    //   193	203	314	java/lang/Exception
    //   205	213	314	java/lang/Exception
    //   215	225	314	java/lang/Exception
    //   227	235	314	java/lang/Exception
    //   237	247	314	java/lang/Exception
    //   249	257	314	java/lang/Exception
    //   259	267	314	java/lang/Exception
    //   269	273	314	java/lang/Exception
    //   275	284	314	java/lang/Exception
    //   305	311	314	java/lang/Exception
    //   368	374	314	java/lang/Exception
    //   404	410	314	java/lang/Exception
    //   415	421	314	java/lang/Exception
    //   426	432	314	java/lang/Exception
    //   437	443	314	java/lang/Exception
    //   448	454	314	java/lang/Exception
    //   459	465	314	java/lang/Exception
    //   470	476	314	java/lang/Exception
    //   354	359	360	java/lang/Exception
    //   21	31	377	finally
    //   33	41	377	finally
    //   43	53	377	finally
    //   55	63	377	finally
    //   65	75	377	finally
    //   77	85	377	finally
    //   87	97	377	finally
    //   99	107	377	finally
    //   109	119	377	finally
    //   121	129	377	finally
    //   131	139	377	finally
    //   141	149	377	finally
    //   151	159	377	finally
    //   161	169	377	finally
    //   171	181	377	finally
    //   183	191	377	finally
    //   193	203	377	finally
    //   205	213	377	finally
    //   215	225	377	finally
    //   227	235	377	finally
    //   237	247	377	finally
    //   249	257	377	finally
    //   259	267	377	finally
    //   269	273	377	finally
    //   275	284	377	finally
    //   305	311	377	finally
    //   317	323	377	finally
    //   325	335	377	finally
    //   337	341	377	finally
    //   368	374	377	finally
    //   404	410	377	finally
    //   415	421	377	finally
    //   426	432	377	finally
    //   437	443	377	finally
    //   448	454	377	finally
    //   459	465	377	finally
    //   470	476	377	finally
    //   288	292	479	java/lang/Exception
    //   297	302	487	java/lang/Exception
    //   345	349	493	java/lang/Exception
    //   386	390	501	java/lang/Exception
    //   395	400	509	java/lang/Exception
    //   9	19	517	finally
    //   9	19	523	java/lang/Exception
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQQWalletTips
 * JD-Core Version:    0.7.0.1
 */