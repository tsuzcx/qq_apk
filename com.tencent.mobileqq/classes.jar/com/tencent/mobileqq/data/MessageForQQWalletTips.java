package com.tencent.mobileqq.data;

import acxx;
import agjk;
import ajhh;
import ajjj;
import ajjy;
import amsw;
import amta;
import amtb;
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
import aqax;
import aqay;
import awao;
import awkk;
import babh;
import babi;
import baip;
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
          localObject1 = babh.q(paramQQAppInterface, paramQQAppInterface.getCurrentNickname());
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
        localObject1 = babh.a(paramQQAppInterface, this.frienduin, this.memberUin);
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
        localObject1 = babh.q(paramQQAppInterface, paramQQAppInterface.getCurrentNickname());
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
    agjk localagjk = (agjk)paramQQAppInterface.getManager(125);
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
              localObject1 = localagjk.a("StatusIcon_IdiomHongBaoIcon", 2130846136);
            }
            while (localObject1 != null)
            {
              ((SpannableString)localObject3).setSpan(new MessageForQQWalletTips.CenterImageSpan(paramContext, (Bitmap)localObject1), 0, ((SpannableString)localObject3).length(), 33);
              localSpannableStringBuilder.append((CharSequence)localObject3);
              localSpannableStringBuilder.append(" ");
              break;
              if (j == 999) {
                localObject1 = localagjk.a("StatusIcon_GoldHongBaoIcon", 2130846134);
              } else {
                localObject1 = localagjk.a("StatusIcon_HongBaoIcon", 2130846194);
              }
            }
          }
          if ((!((String)localObject4).startsWith("http://")) && (!((String)localObject4).startsWith("https://"))) {
            break label1296;
          }
          ((SpannableString)localObject3).setSpan(new amsw(paramContext, 0, (String)localObject4), 0, ((SpannableString)localObject3).length(), 33);
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
        localObject2 = babh.m(paramQQAppInterface, this.memberUin);
        continue;
        localObject2 = (HotChatManager)paramQQAppInterface.getManager(60);
        if ((localObject2 != null) && (((HotChatManager)localObject2).b(this.frienduin)))
        {
          localObject2 = ((ajjj)paramQQAppInterface.getManager(51)).e(this.memberUin);
          if ((localObject2 != null) && (((Friends)localObject2).isFriend()) && (!this.memberUin.equals(paramQQAppInterface.getCurrentAccountUin())))
          {
            localObject4 = babh.a(paramQQAppInterface, this.frienduin, this.memberUin);
            localObject3 = ((babi)localObject4).jdField_a_of_type_JavaLangString;
            localObject2 = localObject3;
            if (((babi)localObject4).jdField_a_of_type_Boolean)
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
              localObject4 = babh.a(paramQQAppInterface, this.frienduin, this.memberUin);
              localObject3 = ((babi)localObject4).jdField_a_of_type_JavaLangString;
              localObject2 = localObject3;
              if (((babi)localObject4).jdField_a_of_type_Boolean)
              {
                localLinkedList.add(this.memberUin);
                localObject2 = localObject3;
              }
            }
          }
        }
        else
        {
          localObject4 = babh.a(paramQQAppInterface, this.frienduin, this.memberUin);
          localObject3 = ((babi)localObject4).jdField_a_of_type_JavaLangString;
          localObject2 = localObject3;
          if (((babi)localObject4).jdField_a_of_type_Boolean)
          {
            localLinkedList.add(this.memberUin);
            localObject2 = localObject3;
            continue;
            localObject2 = ((ajhh)paramQQAppInterface.getManager(53)).a(this.frienduin, this.memberUin);
            if (localObject2 != null)
            {
              localObject2 = ((DiscussionMemberInfo)localObject2).inteRemark;
            }
            else
            {
              localObject2 = babh.a(paramQQAppInterface, this.frienduin, this.memberUin);
              continue;
              localObject2 = (TroopManager)paramQQAppInterface.getManager(52);
              localObject4 = babh.a(paramQQAppInterface, this.frienduin, this.memberUin);
              localObject3 = ((babi)localObject4).jdField_a_of_type_JavaLangString;
              localObject2 = localObject3;
              if (((babi)localObject4).jdField_a_of_type_Boolean)
              {
                localLinkedList.add(this.memberUin);
                localObject2 = localObject3;
                continue;
                localObject2 = babh.a(paramQQAppInterface, this.senderuin, this.memberUin);
                continue;
                localObject2 = ((ajjj)paramQQAppInterface.getManager(51)).e(this.memberUin);
                if ((localObject2 != null) && (((Friends)localObject2).isFriend()) && (!this.memberUin.equals(paramQQAppInterface.getCurrentAccountUin())))
                {
                  localObject4 = babh.a(paramQQAppInterface, this.frienduin, this.memberUin);
                  localObject3 = ((babi)localObject4).jdField_a_of_type_JavaLangString;
                  localObject2 = localObject3;
                  if (((babi)localObject4).jdField_a_of_type_Boolean)
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
                    localObject4 = babh.a(paramQQAppInterface, this.frienduin, this.memberUin);
                    localObject3 = ((babi)localObject4).jdField_a_of_type_JavaLangString;
                    localObject2 = localObject3;
                    if (((babi)localObject4).jdField_a_of_type_Boolean)
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
  
  private acxx getQWalletAIOLifeCycleHelper(Context paramContext)
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
          localObject1 = (acxx)paramContext.a(27);
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
  
  private void syncIdiomRedbagStatus(QQAppInterface paramQQAppInterface, agjk paramagjk, String paramString)
  {
    if (paramagjk != null)
    {
      if (paramQQAppInterface.getCurrentAccountUin().equals(this.reciverUin)) {
        paramagjk.a(paramString, this.frienduin, this.istroop);
      }
      paramagjk.a(paramString, this.frienduin, this.istroop, this.idiomSeq, this.idiom, this.lastPinyin);
    }
  }
  
  public void addQQWalletTips(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    paramString1 = new aqax(this.frienduin, paramQQAppInterface.getCurrentAccountUin(), paramString1.toString(), this.istroop, -5020, 3145729, awao.a());
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
    aqay.a(paramQQAppInterface, paramString2);
  }
  
  public void buildQQWalletTips(QQAppInterface paramQQAppInterface, Context paramContext, TextView paramTextView)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (this.msgType == 7)
    {
      str = this.richContent;
      paramQQAppInterface = getQQWalletTips(paramQQAppInterface, paramContext, str);
      if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface))) {
        break label93;
      }
    }
    label93:
    while (paramTextView == null)
    {
      return;
      if (str.equals(this.senderUin))
      {
        str = this.senderContent;
        break;
      }
      if (str.equals(this.reciverUin))
      {
        str = this.reciverContent;
        break;
      }
      str = this.reciverContent;
      break;
    }
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
    //   1: astore_3
    //   2: new 559	java/io/ByteArrayInputStream
    //   5: dup
    //   6: aload_0
    //   7: getfield 563	com/tencent/mobileqq/data/MessageForQQWalletTips:msgData	[B
    //   10: invokespecial 566	java/io/ByteArrayInputStream:<init>	([B)V
    //   13: astore_2
    //   14: new 568	java/io/ObjectInputStream
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 571	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   22: astore 4
    //   24: aload_0
    //   25: aload 4
    //   27: invokevirtual 574	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   30: putfield 509	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   33: aload_0
    //   34: aload 4
    //   36: invokevirtual 574	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   39: putfield 179	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   42: aload_0
    //   43: aload 4
    //   45: invokevirtual 574	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   48: putfield 511	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   51: aload_0
    //   52: aload 4
    //   54: invokevirtual 574	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   57: putfield 513	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   60: aload_0
    //   61: aload 4
    //   63: invokevirtual 574	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   66: putfield 576	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   69: aload_0
    //   70: aload 4
    //   72: invokevirtual 579	java/io/ObjectInputStream:readInt	()I
    //   75: putfield 581	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   78: aload_0
    //   79: aload 4
    //   81: invokevirtual 579	java/io/ObjectInputStream:readInt	()I
    //   84: putfield 227	com/tencent/mobileqq/data/MessageForQQWalletTips:subType	I
    //   87: aload_0
    //   88: aload 4
    //   90: invokevirtual 579	java/io/ObjectInputStream:readInt	()I
    //   93: putfield 223	com/tencent/mobileqq/data/MessageForQQWalletTips:msgType	I
    //   96: aload_0
    //   97: aload 4
    //   99: invokevirtual 579	java/io/ObjectInputStream:readInt	()I
    //   102: putfield 455	com/tencent/mobileqq/data/MessageForQQWalletTips:idiomSeq	I
    //   105: aload_0
    //   106: aload 4
    //   108: invokevirtual 574	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   111: putfield 71	com/tencent/mobileqq/data/MessageForQQWalletTips:idiom	Ljava/lang/String;
    //   114: aload_0
    //   115: aload 4
    //   117: invokevirtual 574	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   120: putfield 73	com/tencent/mobileqq/data/MessageForQQWalletTips:richContent	Ljava/lang/String;
    //   123: aload_0
    //   124: aload 4
    //   126: invokevirtual 574	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   129: putfield 75	com/tencent/mobileqq/data/MessageForQQWalletTips:lastPinyin	Ljava/lang/String;
    //   132: aload_0
    //   133: aload 4
    //   135: invokevirtual 574	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   138: putfield 77	com/tencent/mobileqq/data/MessageForQQWalletTips:bytes_jumpurl	Ljava/lang/String;
    //   141: aload 4
    //   143: ifnull +8 -> 151
    //   146: aload 4
    //   148: invokevirtual 584	java/io/ObjectInputStream:close	()V
    //   151: aload_2
    //   152: ifnull +7 -> 159
    //   155: aload_2
    //   156: invokevirtual 585	java/io/ByteArrayInputStream:close	()V
    //   159: return
    //   160: astore_1
    //   161: aload_1
    //   162: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   165: goto -14 -> 151
    //   168: astore_1
    //   169: aload_1
    //   170: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   173: return
    //   174: astore_1
    //   175: aconst_null
    //   176: astore_2
    //   177: aload_1
    //   178: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   181: aload_3
    //   182: ifnull +7 -> 189
    //   185: aload_3
    //   186: invokevirtual 584	java/io/ObjectInputStream:close	()V
    //   189: aload_2
    //   190: ifnull -31 -> 159
    //   193: aload_2
    //   194: invokevirtual 585	java/io/ByteArrayInputStream:close	()V
    //   197: return
    //   198: astore_1
    //   199: aload_1
    //   200: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   203: return
    //   204: astore_1
    //   205: aload_1
    //   206: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   209: goto -20 -> 189
    //   212: astore_1
    //   213: aconst_null
    //   214: astore_3
    //   215: aconst_null
    //   216: astore_2
    //   217: aload_2
    //   218: ifnull +7 -> 225
    //   221: aload_2
    //   222: invokevirtual 584	java/io/ObjectInputStream:close	()V
    //   225: aload_3
    //   226: ifnull +7 -> 233
    //   229: aload_3
    //   230: invokevirtual 585	java/io/ByteArrayInputStream:close	()V
    //   233: aload_1
    //   234: athrow
    //   235: astore_2
    //   236: aload_2
    //   237: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   240: goto -15 -> 225
    //   243: astore_2
    //   244: aload_2
    //   245: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   248: goto -15 -> 233
    //   251: astore_1
    //   252: aconst_null
    //   253: astore 4
    //   255: aload_2
    //   256: astore_3
    //   257: aload 4
    //   259: astore_2
    //   260: goto -43 -> 217
    //   263: astore_1
    //   264: aload_2
    //   265: astore_3
    //   266: aload 4
    //   268: astore_2
    //   269: goto -52 -> 217
    //   272: astore_1
    //   273: aload_3
    //   274: astore 4
    //   276: aload_2
    //   277: astore_3
    //   278: aload 4
    //   280: astore_2
    //   281: goto -64 -> 217
    //   284: astore_1
    //   285: goto -108 -> 177
    //   288: astore_1
    //   289: aload 4
    //   291: astore_3
    //   292: goto -115 -> 177
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	295	0	this	MessageForQQWalletTips
    //   160	2	1	localException1	Exception
    //   168	2	1	localException2	Exception
    //   174	4	1	localException3	Exception
    //   198	2	1	localException4	Exception
    //   204	2	1	localException5	Exception
    //   212	22	1	localObject1	Object
    //   251	1	1	localObject2	Object
    //   263	1	1	localObject3	Object
    //   272	1	1	localObject4	Object
    //   284	1	1	localException6	Exception
    //   288	1	1	localException7	Exception
    //   13	209	2	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   235	2	2	localException8	Exception
    //   243	13	2	localException9	Exception
    //   259	22	2	localObject5	Object
    //   1	291	3	localObject6	Object
    //   22	268	4	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   146	151	160	java/lang/Exception
    //   155	159	168	java/lang/Exception
    //   2	14	174	java/lang/Exception
    //   193	197	198	java/lang/Exception
    //   185	189	204	java/lang/Exception
    //   2	14	212	finally
    //   221	225	235	java/lang/Exception
    //   229	233	243	java/lang/Exception
    //   14	24	251	finally
    //   24	141	263	finally
    //   177	181	272	finally
    //   14	24	284	java/lang/Exception
    //   24	141	288	java/lang/Exception
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
          awkk.a(localQQAppInterface).a(this.frienduin, this.istroop, (String)localObject1);
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
        if (baip.a(str)) {
          continue;
        }
        localObject1 = str;
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "onReceiveGrapTips|listId: " + (String)localObject1);
        }
        localObject3 = (agjk)localQQAppInterface.getManager(125);
        if (this.msgType != 7) {
          break;
        }
        syncIdiomRedbagStatus(localQQAppInterface, (agjk)localObject3, (String)localObject1);
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
      paramJSONObject = (agjk)paramQQAppInterface.getManager(125);
      acxx localacxx = getQWalletAIOLifeCycleHelper(paramContext);
      ((SpannableString)localObject1).setSpan(new amta(this, localSoftReference, (SoftReference)localObject2, paramQQAppInterface, paramContext, localacxx, paramJSONObject, i), 0, ((SpannableString)localObject1).length(), 33);
      if ((paramJSONObject != null) && (paramString.contains(ajjy.a(2131640789))))
      {
        paramJSONObject.a(this.listId);
        if (paramQQAppInterface.getCurrentAccountUin().equals(this.reciverUin)) {
          paramJSONObject.a(this.listId, this.frienduin, this.istroop);
        }
        if (localacxx != null) {
          localacxx.a(this.listId);
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
      ((SpannableString)localObject).setSpan(new amtb(this, paramJSONObject.optString("data"), new SoftReference(paramContext), i), 0, ((SpannableString)localObject).length(), 33);
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
    //   0: new 701	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 702	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 704	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 707	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_2
    //   22: aload_0
    //   23: getfield 509	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   26: invokevirtual 710	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: aload_0
    //   33: getfield 179	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   36: invokevirtual 710	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: aload_0
    //   43: getfield 511	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   46: invokevirtual 710	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   49: aload_2
    //   50: astore_1
    //   51: aload_2
    //   52: aload_0
    //   53: getfield 513	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   56: invokevirtual 710	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   59: aload_2
    //   60: astore_1
    //   61: aload_2
    //   62: aload_0
    //   63: getfield 576	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   66: invokevirtual 710	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   69: aload_2
    //   70: astore_1
    //   71: aload_2
    //   72: aload_0
    //   73: getfield 581	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   76: invokevirtual 713	java/io/ObjectOutputStream:writeInt	(I)V
    //   79: aload_2
    //   80: astore_1
    //   81: aload_2
    //   82: aload_0
    //   83: getfield 227	com/tencent/mobileqq/data/MessageForQQWalletTips:subType	I
    //   86: invokevirtual 713	java/io/ObjectOutputStream:writeInt	(I)V
    //   89: aload_2
    //   90: astore_1
    //   91: aload_2
    //   92: aload_0
    //   93: getfield 223	com/tencent/mobileqq/data/MessageForQQWalletTips:msgType	I
    //   96: invokevirtual 713	java/io/ObjectOutputStream:writeInt	(I)V
    //   99: aload_2
    //   100: astore_1
    //   101: aload_2
    //   102: aload_0
    //   103: getfield 455	com/tencent/mobileqq/data/MessageForQQWalletTips:idiomSeq	I
    //   106: invokevirtual 713	java/io/ObjectOutputStream:writeInt	(I)V
    //   109: aload_2
    //   110: astore_1
    //   111: aload_2
    //   112: aload_0
    //   113: getfield 71	com/tencent/mobileqq/data/MessageForQQWalletTips:idiom	Ljava/lang/String;
    //   116: invokevirtual 710	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   119: aload_2
    //   120: astore_1
    //   121: aload_2
    //   122: aload_0
    //   123: getfield 73	com/tencent/mobileqq/data/MessageForQQWalletTips:richContent	Ljava/lang/String;
    //   126: invokevirtual 710	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   129: aload_2
    //   130: astore_1
    //   131: aload_2
    //   132: aload_0
    //   133: getfield 75	com/tencent/mobileqq/data/MessageForQQWalletTips:lastPinyin	Ljava/lang/String;
    //   136: invokevirtual 710	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   139: aload_2
    //   140: astore_1
    //   141: aload_2
    //   142: aload_0
    //   143: getfield 77	com/tencent/mobileqq/data/MessageForQQWalletTips:bytes_jumpurl	Ljava/lang/String;
    //   146: invokevirtual 710	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   149: aload_2
    //   150: astore_1
    //   151: aload_0
    //   152: aload 4
    //   154: invokevirtual 716	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   157: putfield 563	com/tencent/mobileqq/data/MessageForQQWalletTips:msgData	[B
    //   160: aload_2
    //   161: ifnull +7 -> 168
    //   164: aload_2
    //   165: invokevirtual 717	java/io/ObjectOutputStream:close	()V
    //   168: aload 4
    //   170: ifnull +8 -> 178
    //   173: aload 4
    //   175: invokevirtual 718	java/io/ByteArrayOutputStream:close	()V
    //   178: return
    //   179: astore_1
    //   180: aload_1
    //   181: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   184: goto -16 -> 168
    //   187: astore_1
    //   188: aload_1
    //   189: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   192: return
    //   193: astore_3
    //   194: aconst_null
    //   195: astore_2
    //   196: aload_2
    //   197: astore_1
    //   198: aload_3
    //   199: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   202: aload_2
    //   203: ifnull +7 -> 210
    //   206: aload_2
    //   207: invokevirtual 717	java/io/ObjectOutputStream:close	()V
    //   210: aload 4
    //   212: ifnull -34 -> 178
    //   215: aload 4
    //   217: invokevirtual 718	java/io/ByteArrayOutputStream:close	()V
    //   220: return
    //   221: astore_1
    //   222: aload_1
    //   223: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   226: return
    //   227: astore_1
    //   228: aload_1
    //   229: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   232: goto -22 -> 210
    //   235: astore_2
    //   236: aconst_null
    //   237: astore_1
    //   238: aload_1
    //   239: ifnull +7 -> 246
    //   242: aload_1
    //   243: invokevirtual 717	java/io/ObjectOutputStream:close	()V
    //   246: aload 4
    //   248: ifnull +8 -> 256
    //   251: aload 4
    //   253: invokevirtual 718	java/io/ByteArrayOutputStream:close	()V
    //   256: aload_2
    //   257: athrow
    //   258: astore_1
    //   259: aload_1
    //   260: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   263: goto -17 -> 246
    //   266: astore_1
    //   267: aload_1
    //   268: invokevirtual 332	java/lang/Exception:printStackTrace	()V
    //   271: goto -15 -> 256
    //   274: astore_2
    //   275: goto -37 -> 238
    //   278: astore_3
    //   279: goto -83 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	282	0	this	MessageForQQWalletTips
    //   20	131	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   179	2	1	localException1	Exception
    //   187	2	1	localException2	Exception
    //   197	1	1	localObjectOutputStream2	java.io.ObjectOutputStream
    //   221	2	1	localException3	Exception
    //   227	2	1	localException4	Exception
    //   237	6	1	localObject1	Object
    //   258	2	1	localException5	Exception
    //   266	2	1	localException6	Exception
    //   18	189	2	localObjectOutputStream3	java.io.ObjectOutputStream
    //   235	22	2	localObject2	Object
    //   274	1	2	localObject3	Object
    //   193	6	3	localException7	Exception
    //   278	1	3	localException8	Exception
    //   7	245	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   164	168	179	java/lang/Exception
    //   173	178	187	java/lang/Exception
    //   9	19	193	java/lang/Exception
    //   215	220	221	java/lang/Exception
    //   206	210	227	java/lang/Exception
    //   9	19	235	finally
    //   242	246	258	java/lang/Exception
    //   251	256	266	java/lang/Exception
    //   21	29	274	finally
    //   31	39	274	finally
    //   41	49	274	finally
    //   51	59	274	finally
    //   61	69	274	finally
    //   71	79	274	finally
    //   81	89	274	finally
    //   91	99	274	finally
    //   101	109	274	finally
    //   111	119	274	finally
    //   121	129	274	finally
    //   131	139	274	finally
    //   141	149	274	finally
    //   151	160	274	finally
    //   198	202	274	finally
    //   21	29	278	java/lang/Exception
    //   31	39	278	java/lang/Exception
    //   41	49	278	java/lang/Exception
    //   51	59	278	java/lang/Exception
    //   61	69	278	java/lang/Exception
    //   71	79	278	java/lang/Exception
    //   81	89	278	java/lang/Exception
    //   91	99	278	java/lang/Exception
    //   101	109	278	java/lang/Exception
    //   111	119	278	java/lang/Exception
    //   121	129	278	java/lang/Exception
    //   131	139	278	java/lang/Exception
    //   141	149	278	java/lang/Exception
    //   151	160	278	java/lang/Exception
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