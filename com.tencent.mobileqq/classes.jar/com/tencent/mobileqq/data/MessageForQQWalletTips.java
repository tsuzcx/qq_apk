package com.tencent.mobileqq.data;

import abnj;
import abns;
import abnt;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgChatHelper;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.graytip.UniteGrayTipUtil;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.shortvideo.redbag.VideoRedbagData;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class MessageForQQWalletTips
  extends ChatMessage
{
  protected final String TAG_CMD = "cmd";
  protected final String TAG_JUMP = "jump";
  public String authKey;
  public boolean bGetTroopMemberInfo = true;
  public int highLightEnd;
  public int highLightStart;
  public String memberUin;
  public String reciverContent;
  public String reciverUin;
  public String senderContent;
  public String senderUin;
  public int subType;
  public String summary;
  public String textColor = "";
  public int type;
  public String url = "";
  
  private CharSequence getQQWalletTips(QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    int i = 0;
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
      return null;
    }
    PasswdRedBagManager localPasswdRedBagManager = (PasswdRedBagManager)paramQQAppInterface.getManager(124);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    StringBuilder localStringBuilder = new StringBuilder();
    Matcher localMatcher = Pattern.compile("<([^>])+").matcher(paramString);
    label297:
    label300:
    label994:
    for (;;)
    {
      Object localObject3;
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
            break label300;
          }
          localObject3 = ((JSONObject)localObject3).optString("icon");
          localObject1 = new SpannableString((CharSequence)localObject1);
          if (((String)localObject3).startsWith("qqwallet"))
          {
            localObject3 = localPasswdRedBagManager.a();
            if (localObject3 != null)
            {
              ((SpannableString)localObject1).setSpan(new MessageForQQWalletTips.CenterImageSpan(paramContext, (Bitmap)localObject3), 0, ((SpannableString)localObject1).length(), 33);
              localSpannableStringBuilder.append((CharSequence)localObject1);
              localSpannableStringBuilder.append(" ");
            }
          }
          else if ((((String)localObject3).startsWith("http://")) || (((String)localObject3).startsWith("https://")))
          {
            ((SpannableString)localObject1).setSpan(new abnj(paramContext, 0, (String)localObject3), 0, ((SpannableString)localObject1).length(), 33);
            localSpannableStringBuilder.append((CharSequence)localObject1);
            localSpannableStringBuilder.append(" ");
          }
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
        localObject2 = ContactUtils.n(paramQQAppInterface, this.memberUin);
        continue;
        localObject2 = (HotChatManager)paramQQAppInterface.getManager(59);
        if ((localObject2 != null) && (((HotChatManager)localObject2).b(this.frienduin)))
        {
          localObject2 = ((FriendsManager)paramQQAppInterface.getManager(50)).c(this.memberUin);
          if ((localObject2 != null) && (((Friends)localObject2).isFriend()) && (!this.memberUin.equals(paramQQAppInterface.getCurrentAccountUin())))
          {
            localObject2 = ContactUtils.b(paramQQAppInterface, this.frienduin, this.memberUin);
          }
          else
          {
            localObject3 = ((JSONObject)localObject3).optString("hotname");
            if (QLog.isDevelopLevel()) {
              QLog.i("MessageForQQWalletTips", 4, "hotname=" + (String)localObject3);
            }
            localObject2 = localObject3;
            if (TextUtils.isEmpty((CharSequence)localObject3)) {
              localObject2 = ContactUtils.b(paramQQAppInterface, this.frienduin, this.memberUin);
            }
          }
        }
        else
        {
          localObject2 = ContactUtils.b(paramQQAppInterface, this.frienduin, this.memberUin);
          continue;
          localObject2 = ((DiscussionManager)paramQQAppInterface.getManager(52)).a(this.frienduin, this.memberUin);
          if (localObject2 != null)
          {
            localObject2 = ((DiscussionMemberInfo)localObject2).inteRemark;
          }
          else
          {
            localObject2 = ContactUtils.a(paramQQAppInterface, this.frienduin, this.memberUin);
            continue;
            localObject2 = ContactUtils.b(paramQQAppInterface, ((TroopManager)paramQQAppInterface.getManager(51)).c(this.senderuin), this.memberUin);
            continue;
            localObject2 = ContactUtils.a(paramQQAppInterface, this.senderuin, this.memberUin);
            continue;
            localObject2 = ((FriendsManager)paramQQAppInterface.getManager(50)).c(this.memberUin);
            if ((localObject2 != null) && (((Friends)localObject2).isFriend()) && (!this.memberUin.equals(paramQQAppInterface.getCurrentAccountUin())))
            {
              localObject2 = ContactUtils.b(paramQQAppInterface, this.frienduin, this.memberUin);
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
                localObject2 = ContactUtils.b(paramQQAppInterface, this.frienduin, this.memberUin);
                continue;
                if ((!((JSONObject)localObject3).has("cmd")) && (!((JSONObject)localObject3).has("jump"))) {
                  break label297;
                }
                localObject2 = parseTag((JSONObject)localObject3, paramQQAppInterface, paramContext, paramString);
                if (localObject2 != null) {
                  localSpannableStringBuilder.append((CharSequence)localObject2);
                }
                if (((JSONObject)localObject3).has("cmd"))
                {
                  localStringBuilder.append(((JSONObject)localObject3).optString("text", ""));
                  break label994;
                }
                localStringBuilder.append(((JSONObject)localObject3).optString("desc", ""));
                break label994;
                if (i != paramString.length())
                {
                  localSpannableStringBuilder.append(paramString.subSequence(i, paramString.length()));
                  localStringBuilder.append(paramString.subSequence(i, paramString.length()));
                }
                this.summary = localStringBuilder.toString();
                return localSpannableStringBuilder;
                break;
              }
            }
          }
        }
      }
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
    String str = paramQQAppInterface.getCurrentAccountUin();
    if (str.equals(this.senderUin))
    {
      str = this.senderContent;
      paramQQAppInterface = getQQWalletTips(paramQQAppInterface, paramContext, str);
      if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface))) {
        break label75;
      }
    }
    label75:
    while (paramTextView == null)
    {
      return;
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
    //   2: new 368	java/io/ByteArrayInputStream
    //   5: dup
    //   6: aload_0
    //   7: getfield 372	com/tencent/mobileqq/data/MessageForQQWalletTips:msgData	[B
    //   10: invokespecial 375	java/io/ByteArrayInputStream:<init>	([B)V
    //   13: astore_2
    //   14: new 377	java/io/ObjectInputStream
    //   17: dup
    //   18: aload_2
    //   19: invokespecial 380	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   22: astore 4
    //   24: aload_0
    //   25: aload 4
    //   27: invokevirtual 383	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   30: putfield 314	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   33: aload_0
    //   34: aload 4
    //   36: invokevirtual 383	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   39: putfield 320	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   42: aload_0
    //   43: aload 4
    //   45: invokevirtual 383	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   48: putfield 316	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   51: aload_0
    //   52: aload 4
    //   54: invokevirtual 383	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   57: putfield 322	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   60: aload_0
    //   61: aload 4
    //   63: invokevirtual 383	java/io/ObjectInputStream:readUTF	()Ljava/lang/String;
    //   66: putfield 385	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   69: aload_0
    //   70: iconst_0
    //   71: putfield 387	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   74: aload_0
    //   75: iconst_0
    //   76: putfield 389	com/tencent/mobileqq/data/MessageForQQWalletTips:subType	I
    //   79: aload 4
    //   81: invokevirtual 392	java/io/ObjectInputStream:available	()I
    //   84: ifle +21 -> 105
    //   87: aload_0
    //   88: aload 4
    //   90: invokevirtual 395	java/io/ObjectInputStream:readInt	()I
    //   93: putfield 387	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   96: aload_0
    //   97: aload 4
    //   99: invokevirtual 395	java/io/ObjectInputStream:readInt	()I
    //   102: putfield 389	com/tencent/mobileqq/data/MessageForQQWalletTips:subType	I
    //   105: aload 4
    //   107: ifnull +8 -> 115
    //   110: aload 4
    //   112: invokevirtual 398	java/io/ObjectInputStream:close	()V
    //   115: aload_2
    //   116: ifnull +7 -> 123
    //   119: aload_2
    //   120: invokevirtual 399	java/io/ByteArrayInputStream:close	()V
    //   123: return
    //   124: astore_1
    //   125: aload_1
    //   126: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   129: goto -14 -> 115
    //   132: astore_1
    //   133: aload_1
    //   134: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   137: return
    //   138: astore_1
    //   139: aconst_null
    //   140: astore_2
    //   141: aload_1
    //   142: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   145: aload_3
    //   146: ifnull +7 -> 153
    //   149: aload_3
    //   150: invokevirtual 398	java/io/ObjectInputStream:close	()V
    //   153: aload_2
    //   154: ifnull -31 -> 123
    //   157: aload_2
    //   158: invokevirtual 399	java/io/ByteArrayInputStream:close	()V
    //   161: return
    //   162: astore_1
    //   163: aload_1
    //   164: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   167: return
    //   168: astore_1
    //   169: aload_1
    //   170: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   173: goto -20 -> 153
    //   176: astore_1
    //   177: aconst_null
    //   178: astore_3
    //   179: aconst_null
    //   180: astore_2
    //   181: aload_2
    //   182: ifnull +7 -> 189
    //   185: aload_2
    //   186: invokevirtual 398	java/io/ObjectInputStream:close	()V
    //   189: aload_3
    //   190: ifnull +7 -> 197
    //   193: aload_3
    //   194: invokevirtual 399	java/io/ByteArrayInputStream:close	()V
    //   197: aload_1
    //   198: athrow
    //   199: astore_2
    //   200: aload_2
    //   201: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   204: goto -15 -> 189
    //   207: astore_2
    //   208: aload_2
    //   209: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   212: goto -15 -> 197
    //   215: astore_1
    //   216: aconst_null
    //   217: astore 4
    //   219: aload_2
    //   220: astore_3
    //   221: aload 4
    //   223: astore_2
    //   224: goto -43 -> 181
    //   227: astore_1
    //   228: aload_2
    //   229: astore_3
    //   230: aload 4
    //   232: astore_2
    //   233: goto -52 -> 181
    //   236: astore_1
    //   237: aload_3
    //   238: astore 4
    //   240: aload_2
    //   241: astore_3
    //   242: aload 4
    //   244: astore_2
    //   245: goto -64 -> 181
    //   248: astore_1
    //   249: goto -108 -> 141
    //   252: astore_1
    //   253: aload 4
    //   255: astore_3
    //   256: goto -115 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	259	0	this	MessageForQQWalletTips
    //   124	2	1	localException1	Exception
    //   132	2	1	localException2	Exception
    //   138	4	1	localException3	Exception
    //   162	2	1	localException4	Exception
    //   168	2	1	localException5	Exception
    //   176	22	1	localObject1	Object
    //   215	1	1	localObject2	Object
    //   227	1	1	localObject3	Object
    //   236	1	1	localObject4	Object
    //   248	1	1	localException6	Exception
    //   252	1	1	localException7	Exception
    //   13	173	2	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   199	2	2	localException8	Exception
    //   207	13	2	localException9	Exception
    //   223	22	2	localObject5	Object
    //   1	255	3	localObject6	Object
    //   22	232	4	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   110	115	124	java/lang/Exception
    //   119	123	132	java/lang/Exception
    //   2	14	138	java/lang/Exception
    //   157	161	162	java/lang/Exception
    //   149	153	168	java/lang/Exception
    //   2	14	176	finally
    //   185	189	199	java/lang/Exception
    //   193	197	207	java/lang/Exception
    //   14	24	215	finally
    //   24	105	227	finally
    //   141	145	236	finally
    //   14	24	248	java/lang/Exception
    //   24	105	252	java/lang/Exception
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
    Object localObject1 = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject1 instanceof QQAppInterface)) {}
    for (localObject1 = (QQAppInterface)localObject1;; localObject1 = null)
    {
      if (localObject1 == null) {}
      label237:
      for (;;)
      {
        return;
        Object localObject2 = ((QQAppInterface)localObject1).getCurrentAccountUin();
        if (this.type == 1)
        {
          if ((this.subType == 1) || (this.subType == 2) || (this.subType == 5)) {
            GoldMsgChatHelper.a().a(this.frienduin, (String)localObject2, null);
          }
          if ((this.subType == 1) && (!((QQAppInterface)localObject1).getCurrentAccountUin().equals(this.senderuin)) && (QWalletSetting.a((String)localObject2, "goldmsg_is_first_be_setted", true)))
          {
            QWalletSetting.a((String)localObject2, "goldmsg_is_first_be_setted", false);
            GoldMsgChatHelper.a(this, 1);
          }
          if ((this.subType == 2) && (!((QQAppInterface)localObject1).getCurrentAccountUin().equals(this.senderuin)) && (QWalletSetting.a((String)localObject2, "goldmsg_is_first_send_normalmsg_fail", true)))
          {
            QWalletSetting.a((String)localObject2, "goldmsg_is_first_send_normalmsg_fail", false);
            GoldMsgChatHelper.a(this, 1);
          }
        }
        if (!((QQAppInterface)localObject1).getCurrentAccountUin().equals(this.senderUin)) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label237;
          }
          localObject2 = Pattern.compile("feedsid=(\\d+).*hb_from=video_reward").matcher(this.reciverContent);
          if (!((Matcher)localObject2).find()) {
            break;
          }
          localObject2 = ((Matcher)localObject2).group(1);
          RedBagVideoManager.a((AppInterface)localObject1).a(this.frienduin, this.istroop, (String)localObject2);
          VideoRedbagData.updateRewardStat((String)localObject2);
          return;
        }
      }
    }
  }
  
  protected SpannableString parseCmdTag(JSONObject paramJSONObject, QQAppInterface paramQQAppInterface, Context paramContext, String paramString)
  {
    int i = -16777216;
    if (!paramJSONObject.optString("cmd").equals("1")) {}
    Object localObject1;
    do
    {
      return null;
      localObject2 = paramJSONObject.optString("text");
      localObject1 = paramJSONObject.optString("textColor");
    } while (TextUtils.isEmpty((CharSequence)localObject2));
    Object localObject2 = new SpannableString((CharSequence)localObject2);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      String str = paramJSONObject.optString("data");
      localObject1 = "";
      paramJSONObject = (JSONObject)localObject1;
      if (str != null)
      {
        int j = str.indexOf("listid=");
        paramJSONObject = (JSONObject)localObject1;
        if (j >= 0)
        {
          str = str.substring(j);
          j = "listid=".length();
          int k = str.indexOf("&");
          paramJSONObject = (JSONObject)localObject1;
          if (k > 0)
          {
            paramJSONObject = (JSONObject)localObject1;
            if (k > j) {
              paramJSONObject = str.substring(j, k);
            }
          }
        }
      }
      localObject1 = new SoftReference(paramQQAppInterface);
      ((SpannableString)localObject2).setSpan(new abns(this, new SoftReference(paramContext), (SoftReference)localObject1, paramJSONObject, i), 0, ((SpannableString)localObject2).length(), 33);
      paramQQAppInterface = (PasswdRedBagManager)paramQQAppInterface.getManager(124);
      if (paramString.contains("运气王")) {
        paramQQAppInterface.a(paramJSONObject);
      }
      return localObject2;
      i = 0xFF000000 | (int)Long.parseLong(((String)localObject1).substring(2), 16);
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
        this.textColor = "#FF00a5e0";
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
          this.textColor = "#FF00a5e0";
          continue;
          this.textColor = "#FF00a5e0";
        }
      }
    }
  }
  
  protected SpannableString parseJumpTag(JSONObject paramJSONObject, Context paramContext)
  {
    int i = -16777216;
    if (!paramJSONObject.optString("jump").equals("1")) {
      return null;
    }
    Object localObject = paramJSONObject.optString("desc");
    String str = paramJSONObject.optString("textColor");
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    localObject = new SpannableString((CharSequence)localObject);
    if (TextUtils.isEmpty(str)) {}
    for (;;)
    {
      ((SpannableString)localObject).setSpan(new abnt(this, paramJSONObject.optString("data"), new SoftReference(paramContext), i), 0, ((SpannableString)localObject).length(), 33);
      return localObject;
      i = 0xFF000000 | (int)Long.parseLong(str.substring(2), 16);
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
    return parseJumpTag(paramJSONObject, paramContext);
  }
  
  /* Error */
  protected void prewrite()
  {
    // Byte code:
    //   0: new 527	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 528	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 530	java/io/ObjectOutputStream
    //   12: dup
    //   13: aload 4
    //   15: invokespecial 533	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_2
    //   22: aload_0
    //   23: getfield 314	com/tencent/mobileqq/data/MessageForQQWalletTips:senderUin	Ljava/lang/String;
    //   26: invokevirtual 536	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   29: aload_2
    //   30: astore_1
    //   31: aload_2
    //   32: aload_0
    //   33: getfield 320	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverUin	Ljava/lang/String;
    //   36: invokevirtual 536	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: aload_0
    //   43: getfield 316	com/tencent/mobileqq/data/MessageForQQWalletTips:senderContent	Ljava/lang/String;
    //   46: invokevirtual 536	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   49: aload_2
    //   50: astore_1
    //   51: aload_2
    //   52: aload_0
    //   53: getfield 322	com/tencent/mobileqq/data/MessageForQQWalletTips:reciverContent	Ljava/lang/String;
    //   56: invokevirtual 536	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   59: aload_2
    //   60: astore_1
    //   61: aload_2
    //   62: aload_0
    //   63: getfield 385	com/tencent/mobileqq/data/MessageForQQWalletTips:authKey	Ljava/lang/String;
    //   66: invokevirtual 536	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   69: aload_2
    //   70: astore_1
    //   71: aload_2
    //   72: aload_0
    //   73: getfield 387	com/tencent/mobileqq/data/MessageForQQWalletTips:type	I
    //   76: invokevirtual 539	java/io/ObjectOutputStream:writeInt	(I)V
    //   79: aload_2
    //   80: astore_1
    //   81: aload_2
    //   82: aload_0
    //   83: getfield 389	com/tencent/mobileqq/data/MessageForQQWalletTips:subType	I
    //   86: invokevirtual 539	java/io/ObjectOutputStream:writeInt	(I)V
    //   89: aload_2
    //   90: astore_1
    //   91: aload_2
    //   92: invokevirtual 540	java/io/ObjectOutputStream:close	()V
    //   95: aload_2
    //   96: astore_1
    //   97: aload_0
    //   98: aload 4
    //   100: invokevirtual 543	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   103: putfield 372	com/tencent/mobileqq/data/MessageForQQWalletTips:msgData	[B
    //   106: aload_2
    //   107: ifnull +7 -> 114
    //   110: aload_2
    //   111: invokevirtual 540	java/io/ObjectOutputStream:close	()V
    //   114: aload 4
    //   116: ifnull +8 -> 124
    //   119: aload 4
    //   121: invokevirtual 544	java/io/ByteArrayOutputStream:close	()V
    //   124: return
    //   125: astore_1
    //   126: aload_1
    //   127: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   130: goto -16 -> 114
    //   133: astore_1
    //   134: aload_1
    //   135: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   138: return
    //   139: astore_3
    //   140: aconst_null
    //   141: astore_2
    //   142: aload_2
    //   143: astore_1
    //   144: aload_3
    //   145: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   148: aload_2
    //   149: ifnull +7 -> 156
    //   152: aload_2
    //   153: invokevirtual 540	java/io/ObjectOutputStream:close	()V
    //   156: aload 4
    //   158: ifnull -34 -> 124
    //   161: aload 4
    //   163: invokevirtual 544	java/io/ByteArrayOutputStream:close	()V
    //   166: return
    //   167: astore_1
    //   168: aload_1
    //   169: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   172: return
    //   173: astore_1
    //   174: aload_1
    //   175: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   178: goto -22 -> 156
    //   181: astore_2
    //   182: aconst_null
    //   183: astore_1
    //   184: aload_1
    //   185: ifnull +7 -> 192
    //   188: aload_1
    //   189: invokevirtual 540	java/io/ObjectOutputStream:close	()V
    //   192: aload 4
    //   194: ifnull +8 -> 202
    //   197: aload 4
    //   199: invokevirtual 544	java/io/ByteArrayOutputStream:close	()V
    //   202: aload_2
    //   203: athrow
    //   204: astore_1
    //   205: aload_1
    //   206: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   209: goto -17 -> 192
    //   212: astore_1
    //   213: aload_1
    //   214: invokevirtual 161	java/lang/Exception:printStackTrace	()V
    //   217: goto -15 -> 202
    //   220: astore_2
    //   221: goto -37 -> 184
    //   224: astore_3
    //   225: goto -83 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	this	MessageForQQWalletTips
    //   20	77	1	localObjectOutputStream1	java.io.ObjectOutputStream
    //   125	2	1	localException1	Exception
    //   133	2	1	localException2	Exception
    //   143	1	1	localObjectOutputStream2	java.io.ObjectOutputStream
    //   167	2	1	localException3	Exception
    //   173	2	1	localException4	Exception
    //   183	6	1	localObject1	Object
    //   204	2	1	localException5	Exception
    //   212	2	1	localException6	Exception
    //   18	135	2	localObjectOutputStream3	java.io.ObjectOutputStream
    //   181	22	2	localObject2	Object
    //   220	1	2	localObject3	Object
    //   139	6	3	localException7	Exception
    //   224	1	3	localException8	Exception
    //   7	191	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   110	114	125	java/lang/Exception
    //   119	124	133	java/lang/Exception
    //   9	19	139	java/lang/Exception
    //   161	166	167	java/lang/Exception
    //   152	156	173	java/lang/Exception
    //   9	19	181	finally
    //   188	192	204	java/lang/Exception
    //   197	202	212	java/lang/Exception
    //   21	29	220	finally
    //   31	39	220	finally
    //   41	49	220	finally
    //   51	59	220	finally
    //   61	69	220	finally
    //   71	79	220	finally
    //   81	89	220	finally
    //   91	95	220	finally
    //   97	106	220	finally
    //   144	148	220	finally
    //   21	29	224	java/lang/Exception
    //   31	39	224	java/lang/Exception
    //   41	49	224	java/lang/Exception
    //   51	59	224	java/lang/Exception
    //   61	69	224	java/lang/Exception
    //   71	79	224	java/lang/Exception
    //   81	89	224	java/lang/Exception
    //   91	95	224	java/lang/Exception
    //   97	106	224	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForQQWalletTips
 * JD-Core Version:    0.7.0.1
 */