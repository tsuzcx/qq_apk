package com.tencent.mobileqq.data;

import adiw;
import agvx;
import ajvi;
import ajxl;
import ajya;
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
import anji;
import anjm;
import anjn;
import aqvb;
import aqvc;
import awzy;
import axjs;
import bbcz;
import bbda;
import bbkk;
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
          localObject1 = bbcz.q(paramQQAppInterface, paramQQAppInterface.getCurrentNickname());
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
        localObject1 = bbcz.a(paramQQAppInterface, this.frienduin, this.memberUin);
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
        localObject1 = bbcz.q(paramQQAppInterface, paramQQAppInterface.getCurrentNickname());
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
    agvx localagvx = (agvx)paramQQAppInterface.getManager(125);
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
              localObject1 = localagvx.a("StatusIcon_IdiomHongBaoIcon", 2130846323);
            }
            while (localObject1 != null)
            {
              ((SpannableString)localObject3).setSpan(new MessageForQQWalletTips.CenterImageSpan(paramContext, (Bitmap)localObject1), 0, ((SpannableString)localObject3).length(), 33);
              localSpannableStringBuilder.append((CharSequence)localObject3);
              localSpannableStringBuilder.append(" ");
              break;
              if (j == 999) {
                localObject1 = localagvx.a("StatusIcon_GoldHongBaoIcon", 2130846321);
              } else {
                localObject1 = localagvx.a("StatusIcon_HongBaoIcon", 2130846381);
              }
            }
          }
          if ((!((String)localObject4).startsWith("http://")) && (!((String)localObject4).startsWith("https://"))) {
            break label1296;
          }
          ((SpannableString)localObject3).setSpan(new anji(paramContext, 0, (String)localObject4), 0, ((SpannableString)localObject3).length(), 33);
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
        localObject2 = bbcz.m(paramQQAppInterface, this.memberUin);
        continue;
        localObject2 = (HotChatManager)paramQQAppInterface.getManager(60);
        if ((localObject2 != null) && (((HotChatManager)localObject2).b(this.frienduin)))
        {
          localObject2 = ((ajxl)paramQQAppInterface.getManager(51)).e(this.memberUin);
          if ((localObject2 != null) && (((Friends)localObject2).isFriend()) && (!this.memberUin.equals(paramQQAppInterface.getCurrentAccountUin())))
          {
            localObject4 = bbcz.a(paramQQAppInterface, this.frienduin, this.memberUin);
            localObject3 = ((bbda)localObject4).jdField_a_of_type_JavaLangString;
            localObject2 = localObject3;
            if (((bbda)localObject4).jdField_a_of_type_Boolean)
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
              localObject4 = bbcz.a(paramQQAppInterface, this.frienduin, this.memberUin);
              localObject3 = ((bbda)localObject4).jdField_a_of_type_JavaLangString;
              localObject2 = localObject3;
              if (((bbda)localObject4).jdField_a_of_type_Boolean)
              {
                localLinkedList.add(this.memberUin);
                localObject2 = localObject3;
              }
            }
          }
        }
        else
        {
          localObject4 = bbcz.a(paramQQAppInterface, this.frienduin, this.memberUin);
          localObject3 = ((bbda)localObject4).jdField_a_of_type_JavaLangString;
          localObject2 = localObject3;
          if (((bbda)localObject4).jdField_a_of_type_Boolean)
          {
            localLinkedList.add(this.memberUin);
            localObject2 = localObject3;
            continue;
            localObject2 = ((ajvi)paramQQAppInterface.getManager(53)).a(this.frienduin, this.memberUin);
            if (localObject2 != null)
            {
              localObject2 = ((DiscussionMemberInfo)localObject2).inteRemark;
            }
            else
            {
              localObject2 = bbcz.a(paramQQAppInterface, this.frienduin, this.memberUin);
              continue;
              localObject2 = (TroopManager)paramQQAppInterface.getManager(52);
              localObject4 = bbcz.a(paramQQAppInterface, this.frienduin, this.memberUin);
              localObject3 = ((bbda)localObject4).jdField_a_of_type_JavaLangString;
              localObject2 = localObject3;
              if (((bbda)localObject4).jdField_a_of_type_Boolean)
              {
                localLinkedList.add(this.memberUin);
                localObject2 = localObject3;
                continue;
                localObject2 = bbcz.a(paramQQAppInterface, this.senderuin, this.memberUin);
                continue;
                localObject2 = ((ajxl)paramQQAppInterface.getManager(51)).e(this.memberUin);
                if ((localObject2 != null) && (((Friends)localObject2).isFriend()) && (!this.memberUin.equals(paramQQAppInterface.getCurrentAccountUin())))
                {
                  localObject4 = bbcz.a(paramQQAppInterface, this.frienduin, this.memberUin);
                  localObject3 = ((bbda)localObject4).jdField_a_of_type_JavaLangString;
                  localObject2 = localObject3;
                  if (((bbda)localObject4).jdField_a_of_type_Boolean)
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
                    localObject4 = bbcz.a(paramQQAppInterface, this.frienduin, this.memberUin);
                    localObject3 = ((bbda)localObject4).jdField_a_of_type_JavaLangString;
                    localObject2 = localObject3;
                    if (((bbda)localObject4).jdField_a_of_type_Boolean)
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
  
  private adiw getQWalletAIOLifeCycleHelper(Context paramContext)
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
          localObject1 = (adiw)paramContext.a(27);
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
  
  private void syncIdiomRedbagStatus(QQAppInterface paramQQAppInterface, agvx paramagvx, String paramString)
  {
    if (paramagvx != null)
    {
      if (paramQQAppInterface.getCurrentAccountUin().equals(this.reciverUin)) {
        paramagvx.a(paramString, this.frienduin, this.istroop);
      }
      paramagvx.a(paramString, this.frienduin, this.istroop, this.idiomSeq, this.idiom, this.lastPinyin);
    }
  }
  
  public void addQQWalletTips(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    paramString1 = new aqvb(this.frienduin, paramQQAppInterface.getCurrentAccountUin(), paramString1.toString(), this.istroop, -5020, 3145729, awzy.a());
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
    aqvc.a(paramQQAppInterface, paramString2);
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
    //   3: new 574	java/io/ByteArrayInputStream
    //   6: dup
    //   7: aload_0
    //   8: getfield 578	com/tencent/mobileqq/data/MessageForQQWalletTips:msgData	[B
    //   11: invokespecial 581	java/io/ByteArrayInputStream:<init>	([B)V
    //   14: astore_3
    //   15: new 583	java/io/ObjectInputStream
    //   18: dup
    //   19: aload_3
    //   20: invokespecial 586	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   23: astore 5
    //   25: aload_0
    //   26: aload 5
    //   28: invokevirtual 589	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   31: putfield 523	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   34: aload_0
    //   35: aload 5
    //   37: invokevirtual 589	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   40: putfield 179	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   43: aload_0
    //   44: aload 5
    //   46: invokevirtual 589	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   49: putfield 525	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   52: aload_0
    //   53: aload 5
    //   55: invokevirtual 589	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   58: putfield 527	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   61: aload_0
    //   62: aload 5
    //   64: invokevirtual 589	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   67: putfield 591	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   70: aload_0
    //   71: iconst_0
    //   72: putfield 593	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   75: aload_0
    //   76: iconst_0
    //   77: putfield 227	com/tencent/mobileqq/data/MessageForQQWalletTips:subType	I
    //   80: aload 5
    //   82: invokevirtual 596	java/io/ObjectInputStream:available	()I
    //   85: ifle +12 -> 97
    //   88: aload_0
    //   89: aload 5
    //   91: invokevirtual 599	java/io/ObjectInputStream:readInt	()I
    //   94: putfield 593	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   97: aload 5
    //   99: invokevirtual 596	java/io/ObjectInputStream:available	()I
    //   102: ifle +12 -> 114
    //   105: aload_0
    //   106: aload 5
    //   108: invokevirtual 599	java/io/ObjectInputStream:readInt	()I
    //   111: putfield 227	com/tencent/mobileqq/data/MessageForQQWalletTips:subType	I
    //   114: aload_0
    //   115: iconst_0
    //   116: putfield 223	com/tencent/mobileqq/data/MessageForQQWalletTips:msgType	I
    //   119: aload 5
    //   121: invokevirtual 596	java/io/ObjectInputStream:available	()I
    //   124: istore_1
    //   125: iload_1
    //   126: ifle +12 -> 138
    //   129: aload_0
    //   130: aload 5
    //   132: invokevirtual 599	java/io/ObjectInputStream:readInt	()I
    //   135: putfield 223	com/tencent/mobileqq/data/MessageForQQWalletTips:msgType	I
    //   138: aload 5
    //   140: invokevirtual 596	java/io/ObjectInputStream:available	()I
    //   143: ifle +12 -> 155
    //   146: aload_0
    //   147: aload 5
    //   149: invokevirtual 599	java/io/ObjectInputStream:readInt	()I
    //   152: putfield 455	com/tencent/mobileqq/data/MessageForQQWalletTips:idiomSeq	I
    //   155: aload 5
    //   157: invokevirtual 596	java/io/ObjectInputStream:available	()I
    //   160: ifle +12 -> 172
    //   163: aload_0
    //   164: aload 5
    //   166: invokevirtual 589	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   169: putfield 71	com/tencent/mobileqq/data/MessageForQQWalletTips:idiom	Ljava/lang/String;
    //   172: aload 5
    //   174: invokevirtual 596	java/io/ObjectInputStream:available	()I
    //   177: ifle +12 -> 189
    //   180: aload_0
    //   181: aload 5
    //   183: invokevirtual 589	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   186: putfield 73	com/tencent/mobileqq/data/MessageForQQWalletTips:richContent	Ljava/lang/String;
    //   189: aload 5
    //   191: invokevirtual 596	java/io/ObjectInputStream:available	()I
    //   194: ifle +12 -> 206
    //   197: aload_0
    //   198: aload 5
    //   200: invokevirtual 589	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   203: putfield 75	com/tencent/mobileqq/data/MessageForQQWalletTips:lastPinyin	Ljava/lang/String;
    //   206: aload 5
    //   208: invokevirtual 596	java/io/ObjectInputStream:available	()I
    //   211: ifle +12 -> 223
    //   214: aload_0
    //   215: aload 5
    //   217: invokevirtual 589	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   220: putfield 77	com/tencent/mobileqq/data/MessageForQQWalletTips:bytes_jumpurl	Ljava/lang/String;
    //   223: aload 5
    //   225: ifnull +8 -> 233
    //   228: aload 5
    //   230: invokevirtual 602	java/io/ObjectInputStream:close	()V
    //   233: aload_3
    //   234: ifnull +7 -> 241
    //   237: aload_3
    //   238: invokevirtual 603	java/io/ByteArrayInputStream:close	()V
    //   241: return
    //   242: astore_2
    //   243: aload_0
    //   244: iconst_0
    //   245: putfield 223	com/tencent/mobileqq/data/MessageForQQWalletTips:msgType	I
    //   248: goto -110 -> 138
    //   251: astore_2
    //   252: aload 5
    //   254: astore 4
    //   256: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   259: ifeq +13 -> 272
    //   262: getstatic 49	com/tencent/mobileqq/data/MessageForQQWalletTips:TAG	Ljava/lang/String;
    //   265: iconst_1
    //   266: ldc_w 605
    //   269: invokestatic 510	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   272: aload_2
    //   273: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   276: aload 4
    //   278: ifnull +8 -> 286
    //   281: aload 4
    //   283: invokevirtual 602	java/io/ObjectInputStream:close	()V
    //   286: aload_3
    //   287: ifnull -46 -> 241
    //   290: aload_3
    //   291: invokevirtual 603	java/io/ByteArrayInputStream:close	()V
    //   294: return
    //   295: astore_2
    //   296: aload_2
    //   297: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   300: return
    //   301: astore_2
    //   302: aload_2
    //   303: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   306: goto -73 -> 233
    //   309: astore_2
    //   310: aload_2
    //   311: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   314: return
    //   315: astore_2
    //   316: aload_2
    //   317: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   320: goto -34 -> 286
    //   323: astore_2
    //   324: aconst_null
    //   325: astore 4
    //   327: aconst_null
    //   328: astore_3
    //   329: aload_3
    //   330: ifnull +7 -> 337
    //   333: aload_3
    //   334: invokevirtual 602	java/io/ObjectInputStream:close	()V
    //   337: aload 4
    //   339: ifnull +8 -> 347
    //   342: aload 4
    //   344: invokevirtual 603	java/io/ByteArrayInputStream:close	()V
    //   347: aload_2
    //   348: athrow
    //   349: astore_3
    //   350: aload_3
    //   351: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   354: goto -17 -> 337
    //   357: astore_3
    //   358: aload_3
    //   359: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   362: goto -15 -> 347
    //   365: astore_2
    //   366: aconst_null
    //   367: astore 5
    //   369: aload_3
    //   370: astore 4
    //   372: aload 5
    //   374: astore_3
    //   375: goto -46 -> 329
    //   378: astore_2
    //   379: aload_3
    //   380: astore 4
    //   382: aload 5
    //   384: astore_3
    //   385: goto -56 -> 329
    //   388: astore_2
    //   389: aload 4
    //   391: astore 5
    //   393: aload_3
    //   394: astore 4
    //   396: aload 5
    //   398: astore_3
    //   399: goto -70 -> 329
    //   402: astore_2
    //   403: aconst_null
    //   404: astore_3
    //   405: goto -149 -> 256
    //   408: astore_2
    //   409: goto -153 -> 256
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	412	0	this	MessageForQQWalletTips
    //   124	2	1	i	int
    //   242	1	2	localThrowable	java.lang.Throwable
    //   251	22	2	localException1	Exception
    //   295	2	2	localException2	Exception
    //   301	2	2	localException3	Exception
    //   309	2	2	localException4	Exception
    //   315	2	2	localException5	Exception
    //   323	25	2	localObject1	Object
    //   365	1	2	localObject2	Object
    //   378	1	2	localObject3	Object
    //   388	1	2	localObject4	Object
    //   402	1	2	localException6	Exception
    //   408	1	2	localException7	Exception
    //   14	320	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   349	2	3	localException8	Exception
    //   357	13	3	localException9	Exception
    //   374	31	3	localObject5	Object
    //   1	394	4	localObject6	Object
    //   23	374	5	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   129	138	242	java/lang/Throwable
    //   25	97	251	java/lang/Exception
    //   97	114	251	java/lang/Exception
    //   114	125	251	java/lang/Exception
    //   129	138	251	java/lang/Exception
    //   138	155	251	java/lang/Exception
    //   155	172	251	java/lang/Exception
    //   172	189	251	java/lang/Exception
    //   189	206	251	java/lang/Exception
    //   206	223	251	java/lang/Exception
    //   243	248	251	java/lang/Exception
    //   290	294	295	java/lang/Exception
    //   228	233	301	java/lang/Exception
    //   237	241	309	java/lang/Exception
    //   281	286	315	java/lang/Exception
    //   3	15	323	finally
    //   333	337	349	java/lang/Exception
    //   342	347	357	java/lang/Exception
    //   15	25	365	finally
    //   25	97	378	finally
    //   97	114	378	finally
    //   114	125	378	finally
    //   129	138	378	finally
    //   138	155	378	finally
    //   155	172	378	finally
    //   172	189	378	finally
    //   189	206	378	finally
    //   206	223	378	finally
    //   243	248	378	finally
    //   256	272	388	finally
    //   272	276	388	finally
    //   3	15	402	java/lang/Exception
    //   15	25	408	java/lang/Exception
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
          axjs.a(localQQAppInterface).a(this.frienduin, this.istroop, (String)localObject1);
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
        if (bbkk.a(str)) {
          continue;
        }
        localObject1 = str;
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "onReceiveGrapTips|listId: " + (String)localObject1);
        }
        localObject3 = (agvx)localQQAppInterface.getManager(125);
        if (this.msgType != 7) {
          break;
        }
        syncIdiomRedbagStatus(localQQAppInterface, (agvx)localObject3, (String)localObject1);
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
      paramJSONObject = (agvx)paramQQAppInterface.getManager(125);
      adiw localadiw = getQWalletAIOLifeCycleHelper(paramContext);
      ((SpannableString)localObject1).setSpan(new anjm(this, localSoftReference, (SoftReference)localObject2, paramQQAppInterface, paramContext, localadiw, paramJSONObject, i), 0, ((SpannableString)localObject1).length(), 33);
      if ((paramJSONObject != null) && (paramString.contains(ajya.a(2131706585))))
      {
        paramJSONObject.a(this.listId);
        if (paramQQAppInterface.getCurrentAccountUin().equals(this.reciverUin)) {
          paramJSONObject.a(this.listId, this.frienduin, this.istroop);
        }
        if (localadiw != null) {
          localadiw.a(this.listId);
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
      ((SpannableString)localObject).setSpan(new anjn(this, paramJSONObject.optString("data"), new SoftReference(paramContext), i), 0, ((SpannableString)localObject).length(), 33);
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
    //   0: new 718	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 719	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 721	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 724	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: getfield 523	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   25: invokestatic 654	bbkk:a	(Ljava/lang/String;)Z
    //   28: ifne +265 -> 293
    //   31: aload_2
    //   32: astore_1
    //   33: aload_2
    //   34: aload_0
    //   35: getfield 523	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   38: invokevirtual 727	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   41: aload_2
    //   42: astore_1
    //   43: aload_0
    //   44: getfield 179	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   47: invokestatic 654	bbkk:a	(Ljava/lang/String;)Z
    //   50: ifne +306 -> 356
    //   53: aload_2
    //   54: astore_1
    //   55: aload_2
    //   56: aload_0
    //   57: getfield 179	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   60: invokevirtual 727	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   63: aload_2
    //   64: astore_1
    //   65: aload_0
    //   66: getfield 525	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   69: invokestatic 654	bbkk:a	(Ljava/lang/String;)Z
    //   72: ifne +320 -> 392
    //   75: aload_2
    //   76: astore_1
    //   77: aload_2
    //   78: aload_0
    //   79: getfield 525	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   82: invokevirtual 727	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   85: aload_2
    //   86: astore_1
    //   87: aload_0
    //   88: getfield 527	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   91: invokestatic 654	bbkk:a	(Ljava/lang/String;)Z
    //   94: ifne +309 -> 403
    //   97: aload_2
    //   98: astore_1
    //   99: aload_2
    //   100: aload_0
    //   101: getfield 527	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   104: invokevirtual 727	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   107: aload_2
    //   108: astore_1
    //   109: aload_0
    //   110: getfield 591	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   113: invokestatic 654	bbkk:a	(Ljava/lang/String;)Z
    //   116: ifne +298 -> 414
    //   119: aload_2
    //   120: astore_1
    //   121: aload_2
    //   122: aload_0
    //   123: getfield 591	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   126: invokevirtual 727	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   129: aload_2
    //   130: astore_1
    //   131: aload_2
    //   132: aload_0
    //   133: getfield 593	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   136: invokevirtual 730	java/io/ObjectOutputStream:writeInt	(I)V
    //   139: aload_2
    //   140: astore_1
    //   141: aload_2
    //   142: aload_0
    //   143: getfield 227	com/tencent/mobileqq/data/MessageForQQWalletTips:subType	I
    //   146: invokevirtual 730	java/io/ObjectOutputStream:writeInt	(I)V
    //   149: aload_2
    //   150: astore_1
    //   151: aload_2
    //   152: aload_0
    //   153: getfield 223	com/tencent/mobileqq/data/MessageForQQWalletTips:msgType	I
    //   156: invokevirtual 730	java/io/ObjectOutputStream:writeInt	(I)V
    //   159: aload_2
    //   160: astore_1
    //   161: aload_2
    //   162: aload_0
    //   163: getfield 455	com/tencent/mobileqq/data/MessageForQQWalletTips:idiomSeq	I
    //   166: invokevirtual 730	java/io/ObjectOutputStream:writeInt	(I)V
    //   169: aload_2
    //   170: astore_1
    //   171: aload_0
    //   172: getfield 71	com/tencent/mobileqq/data/MessageForQQWalletTips:idiom	Ljava/lang/String;
    //   175: invokestatic 654	bbkk:a	(Ljava/lang/String;)Z
    //   178: ifne +247 -> 425
    //   181: aload_2
    //   182: astore_1
    //   183: aload_2
    //   184: aload_0
    //   185: getfield 71	com/tencent/mobileqq/data/MessageForQQWalletTips:idiom	Ljava/lang/String;
    //   188: invokevirtual 727	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   191: aload_2
    //   192: astore_1
    //   193: aload_0
    //   194: getfield 73	com/tencent/mobileqq/data/MessageForQQWalletTips:richContent	Ljava/lang/String;
    //   197: invokestatic 654	bbkk:a	(Ljava/lang/String;)Z
    //   200: ifne +236 -> 436
    //   203: aload_2
    //   204: astore_1
    //   205: aload_2
    //   206: aload_0
    //   207: getfield 73	com/tencent/mobileqq/data/MessageForQQWalletTips:richContent	Ljava/lang/String;
    //   210: invokevirtual 727	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   213: aload_2
    //   214: astore_1
    //   215: aload_0
    //   216: getfield 75	com/tencent/mobileqq/data/MessageForQQWalletTips:lastPinyin	Ljava/lang/String;
    //   219: invokestatic 654	bbkk:a	(Ljava/lang/String;)Z
    //   222: ifne +225 -> 447
    //   225: aload_2
    //   226: astore_1
    //   227: aload_2
    //   228: aload_0
    //   229: getfield 75	com/tencent/mobileqq/data/MessageForQQWalletTips:lastPinyin	Ljava/lang/String;
    //   232: invokevirtual 727	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   235: aload_2
    //   236: astore_1
    //   237: aload_0
    //   238: getfield 77	com/tencent/mobileqq/data/MessageForQQWalletTips:bytes_jumpurl	Ljava/lang/String;
    //   241: invokestatic 654	bbkk:a	(Ljava/lang/String;)Z
    //   244: ifne +214 -> 458
    //   247: aload_2
    //   248: astore_1
    //   249: aload_2
    //   250: aload_0
    //   251: getfield 77	com/tencent/mobileqq/data/MessageForQQWalletTips:bytes_jumpurl	Ljava/lang/String;
    //   254: invokevirtual 727	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   257: aload_2
    //   258: astore_1
    //   259: aload_2
    //   260: invokevirtual 733	java/io/ObjectOutputStream:flush	()V
    //   263: aload_2
    //   264: astore_1
    //   265: aload_0
    //   266: aload 4
    //   268: invokevirtual 736	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   271: putfield 578	com/tencent/mobileqq/data/MessageForQQWalletTips:msgData	[B
    //   274: aload_2
    //   275: ifnull +7 -> 282
    //   278: aload_2
    //   279: invokevirtual 737	java/io/ObjectOutputStream:close	()V
    //   282: aload 4
    //   284: ifnull +8 -> 292
    //   287: aload 4
    //   289: invokevirtual 738	java/io/ByteArrayOutputStream:close	()V
    //   292: return
    //   293: aload_2
    //   294: astore_1
    //   295: aload_2
    //   296: ldc 65
    //   298: invokevirtual 727	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   301: goto -260 -> 41
    //   304: astore_3
    //   305: aload_2
    //   306: astore_1
    //   307: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   310: ifeq +15 -> 325
    //   313: aload_2
    //   314: astore_1
    //   315: getstatic 49	com/tencent/mobileqq/data/MessageForQQWalletTips:TAG	Ljava/lang/String;
    //   318: iconst_1
    //   319: ldc_w 740
    //   322: invokestatic 510	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   325: aload_2
    //   326: astore_1
    //   327: aload_3
    //   328: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   331: aload_2
    //   332: ifnull +7 -> 339
    //   335: aload_2
    //   336: invokevirtual 737	java/io/ObjectOutputStream:close	()V
    //   339: aload 4
    //   341: ifnull -49 -> 292
    //   344: aload 4
    //   346: invokevirtual 738	java/io/ByteArrayOutputStream:close	()V
    //   349: return
    //   350: astore_1
    //   351: aload_1
    //   352: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   355: return
    //   356: aload_2
    //   357: astore_1
    //   358: aload_2
    //   359: ldc 65
    //   361: invokevirtual 727	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   364: goto -301 -> 63
    //   367: astore_3
    //   368: aload_1
    //   369: astore_2
    //   370: aload_3
    //   371: astore_1
    //   372: aload_2
    //   373: ifnull +7 -> 380
    //   376: aload_2
    //   377: invokevirtual 737	java/io/ObjectOutputStream:close	()V
    //   380: aload 4
    //   382: ifnull +8 -> 390
    //   385: aload 4
    //   387: invokevirtual 738	java/io/ByteArrayOutputStream:close	()V
    //   390: aload_1
    //   391: athrow
    //   392: aload_2
    //   393: astore_1
    //   394: aload_2
    //   395: ldc 65
    //   397: invokevirtual 727	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   400: goto -315 -> 85
    //   403: aload_2
    //   404: astore_1
    //   405: aload_2
    //   406: ldc 65
    //   408: invokevirtual 727	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   411: goto -304 -> 107
    //   414: aload_2
    //   415: astore_1
    //   416: aload_2
    //   417: ldc 65
    //   419: invokevirtual 727	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   422: goto -293 -> 129
    //   425: aload_2
    //   426: astore_1
    //   427: aload_2
    //   428: ldc 65
    //   430: invokevirtual 727	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   433: goto -242 -> 191
    //   436: aload_2
    //   437: astore_1
    //   438: aload_2
    //   439: ldc 65
    //   441: invokevirtual 727	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   444: goto -231 -> 213
    //   447: aload_2
    //   448: astore_1
    //   449: aload_2
    //   450: ldc 65
    //   452: invokevirtual 727	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   455: goto -220 -> 235
    //   458: aload_2
    //   459: astore_1
    //   460: aload_2
    //   461: ldc 65
    //   463: invokevirtual 727	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   466: goto -209 -> 257
    //   469: astore_1
    //   470: aload_1
    //   471: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   474: goto -192 -> 282
    //   477: astore_1
    //   478: aload_1
    //   479: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   482: return
    //   483: astore_1
    //   484: aload_1
    //   485: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   488: goto -149 -> 339
    //   491: astore_2
    //   492: aload_2
    //   493: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   496: goto -116 -> 380
    //   499: astore_2
    //   500: aload_2
    //   501: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   504: goto -114 -> 390
    //   507: astore_1
    //   508: aconst_null
    //   509: astore_2
    //   510: goto -138 -> 372
    //   513: astore_3
    //   514: aconst_null
    //   515: astore_2
    //   516: goto -211 -> 305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	519	0	this	MessageForQQWalletTips
    //   20	307	1	localObject1	Object
    //   350	2	1	localException1	Exception
    //   357	103	1	localObject2	Object
    //   469	2	1	localException2	Exception
    //   477	2	1	localException3	Exception
    //   483	2	1	localException4	Exception
    //   507	1	1	localObject3	Object
    //   18	443	2	localObject4	Object
    //   491	2	2	localException5	Exception
    //   499	2	2	localException6	Exception
    //   509	7	2	localObject5	Object
    //   304	24	3	localException7	Exception
    //   367	4	3	localObject6	Object
    //   513	1	3	localException8	Exception
    //   7	379	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   21	31	304	java/lang/Exception
    //   33	41	304	java/lang/Exception
    //   43	53	304	java/lang/Exception
    //   55	63	304	java/lang/Exception
    //   65	75	304	java/lang/Exception
    //   77	85	304	java/lang/Exception
    //   87	97	304	java/lang/Exception
    //   99	107	304	java/lang/Exception
    //   109	119	304	java/lang/Exception
    //   121	129	304	java/lang/Exception
    //   131	139	304	java/lang/Exception
    //   141	149	304	java/lang/Exception
    //   151	159	304	java/lang/Exception
    //   161	169	304	java/lang/Exception
    //   171	181	304	java/lang/Exception
    //   183	191	304	java/lang/Exception
    //   193	203	304	java/lang/Exception
    //   205	213	304	java/lang/Exception
    //   215	225	304	java/lang/Exception
    //   227	235	304	java/lang/Exception
    //   237	247	304	java/lang/Exception
    //   249	257	304	java/lang/Exception
    //   259	263	304	java/lang/Exception
    //   265	274	304	java/lang/Exception
    //   295	301	304	java/lang/Exception
    //   358	364	304	java/lang/Exception
    //   394	400	304	java/lang/Exception
    //   405	411	304	java/lang/Exception
    //   416	422	304	java/lang/Exception
    //   427	433	304	java/lang/Exception
    //   438	444	304	java/lang/Exception
    //   449	455	304	java/lang/Exception
    //   460	466	304	java/lang/Exception
    //   344	349	350	java/lang/Exception
    //   21	31	367	finally
    //   33	41	367	finally
    //   43	53	367	finally
    //   55	63	367	finally
    //   65	75	367	finally
    //   77	85	367	finally
    //   87	97	367	finally
    //   99	107	367	finally
    //   109	119	367	finally
    //   121	129	367	finally
    //   131	139	367	finally
    //   141	149	367	finally
    //   151	159	367	finally
    //   161	169	367	finally
    //   171	181	367	finally
    //   183	191	367	finally
    //   193	203	367	finally
    //   205	213	367	finally
    //   215	225	367	finally
    //   227	235	367	finally
    //   237	247	367	finally
    //   249	257	367	finally
    //   259	263	367	finally
    //   265	274	367	finally
    //   295	301	367	finally
    //   307	313	367	finally
    //   315	325	367	finally
    //   327	331	367	finally
    //   358	364	367	finally
    //   394	400	367	finally
    //   405	411	367	finally
    //   416	422	367	finally
    //   427	433	367	finally
    //   438	444	367	finally
    //   449	455	367	finally
    //   460	466	367	finally
    //   278	282	469	java/lang/Exception
    //   287	292	477	java/lang/Exception
    //   335	339	483	java/lang/Exception
    //   376	380	491	java/lang/Exception
    //   385	390	499	java/lang/Exception
    //   9	19	507	finally
    //   9	19	513	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQQWalletTips
 * JD-Core Version:    0.7.0.1
 */