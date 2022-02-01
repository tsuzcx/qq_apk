package com.tencent.mobileqq.dating;

import android.content.SharedPreferences;
import android.text.TextUtils;
import appoint.define.appoint_define.RichText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.freshnews.FreshNewsUtil;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MsgBoxUtil
{
  public static final Pattern a = Pattern.compile("\\{\\{(.\\d+):(.\\d?)\\}\\}", 2);
  
  public static QQText a(appoint_define.RichText paramRichText)
  {
    return a(paramRichText, 16);
  }
  
  public static QQText a(appoint_define.RichText paramRichText, int paramInt)
  {
    return a(FreshNewsUtil.a(paramRichText), paramInt);
  }
  
  public static QQText a(String paramString, int paramInt)
  {
    return new QQText(paramString, 5, paramInt);
  }
  
  public static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    try
    {
      localObject4 = new JSONObject(paramString);
      localObject2 = ((JSONObject)localObject4).optString("content");
      localObject3 = localObject2;
    }
    catch (JSONException localJSONException1)
    {
      Object localObject4;
      Object localObject2;
      Object localObject3;
      Object localObject1;
      int i;
      label279:
      String str;
      label447:
      label450:
      break label450;
    }
    try
    {
      if (((JSONObject)localObject4).has("audio_list"))
      {
        localObject1 = localObject2;
        localObject3 = localObject2;
        if (((JSONObject)localObject4).optJSONArray("audio_list").length() <= 0) {
          break label496;
        }
        localObject3 = localObject2;
        localObject1 = new StringBuilder();
        localObject3 = localObject2;
        ((StringBuilder)localObject1).append((String)localObject2);
        localObject3 = localObject2;
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131904818));
        localObject3 = localObject2;
        localObject1 = ((StringBuilder)localObject1).toString();
        break label496;
      }
      localObject3 = localObject2;
      if (((JSONObject)localObject4).has("video_list"))
      {
        localObject1 = localObject2;
        localObject3 = localObject2;
        if (((JSONObject)localObject4).optJSONArray("video_list").length() <= 0) {
          break label496;
        }
        localObject3 = localObject2;
        localObject1 = new StringBuilder();
        localObject3 = localObject2;
        ((StringBuilder)localObject1).append((String)localObject2);
        localObject3 = localObject2;
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131904819));
        localObject3 = localObject2;
        localObject1 = ((StringBuilder)localObject1).toString();
        break label496;
      }
      localObject3 = localObject2;
      if (((JSONObject)localObject4).has("pic_list"))
      {
        localObject1 = localObject2;
        localObject3 = localObject2;
        if (((JSONObject)localObject4).optJSONArray("pic_list").length() <= 0) {
          break label496;
        }
        localObject3 = localObject2;
        localObject1 = new StringBuilder();
        localObject3 = localObject2;
        ((StringBuilder)localObject1).append((String)localObject2);
        localObject3 = localObject2;
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131904817));
        localObject3 = localObject2;
        localObject1 = ((StringBuilder)localObject1).toString();
        break label496;
      }
      localObject1 = localObject2;
      localObject3 = localObject2;
      if (!((JSONObject)localObject4).has("post_array")) {
        break label496;
      }
      localObject3 = localObject2;
      localObject4 = ((JSONObject)localObject4).optJSONArray("post_array");
      i = 0;
      localObject1 = localObject2;
      localObject3 = localObject2;
      if (i >= ((JSONArray)localObject4).length()) {
        break label496;
      }
      localObject3 = localObject2;
      str = ((JSONArray)localObject4).optJSONObject(i).optString("type");
      localObject3 = localObject2;
      if (TextUtils.isEmpty(str))
      {
        localObject1 = localObject2;
      }
      else
      {
        localObject3 = localObject2;
        if (str.equals("qqmusic"))
        {
          localObject3 = localObject2;
          localObject1 = new StringBuilder();
          localObject3 = localObject2;
          ((StringBuilder)localObject1).append((String)localObject2);
          localObject3 = localObject2;
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131904815));
          localObject3 = localObject2;
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        else
        {
          localObject1 = localObject2;
          localObject3 = localObject2;
          if (str.equals("audio"))
          {
            localObject3 = localObject2;
            localObject1 = new StringBuilder();
            localObject3 = localObject2;
            ((StringBuilder)localObject1).append((String)localObject2);
            localObject3 = localObject2;
            ((StringBuilder)localObject1).append(HardCodeUtil.a(2131904816));
            localObject3 = localObject2;
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
      }
      i += 1;
      localObject2 = localObject1;
      break label279;
    }
    catch (JSONException localJSONException2)
    {
      break label447;
    }
    localObject3 = paramString;
    localObject1 = localObject3;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getTribeJsonContent content:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.e("Q..msgbox.util", 2, ((StringBuilder)localObject1).toString());
      localObject1 = localObject3;
    }
    label496:
    paramString = a.matcher((CharSequence)localObject1);
    while (paramString.find())
    {
      localObject2 = paramString.group(1);
      localObject1 = ((String)localObject1).replace(paramString.group(0), (CharSequence)localObject2);
    }
    return localObject1;
  }
  
  public static boolean a()
  {
    return "0".equals(BaseApplicationImpl.getContext().getSharedPreferences("nearby_callback", 4).getString("nearby_settings_greetings_receive", "0"));
  }
  
  public static boolean a(int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
  {
    return ((!a()) || (paramInt1 != 1001) || (a(paramInt2, paramString))) && (!paramBoolean);
  }
  
  public static boolean a(int paramInt, String paramString)
  {
    return (paramInt == -2053) && (!paramString.equals(String.valueOf(AppConstants.NOW_LIVE_TIP_UIN_BASE + 1822701914L))) && (!paramString.equals("1822701914"));
  }
  
  public static boolean a(Message paramMessage, QQAppInterface paramQQAppInterface)
  {
    if (paramMessage.msgtype == -2011) {
      paramQQAppInterface = paramQQAppInterface.getMessageProxy(1001).b(AppConstants.NEARBY_LBS_HELLO_UIN, 1001, paramMessage.uniseq);
    } else {
      paramQQAppInterface = null;
    }
    return a(paramMessage.istroop, paramMessage.msgtype, a(paramQQAppInterface), paramMessage.senderuin);
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return false;
    }
    if ((paramMessageRecord instanceof MessageForStructing))
    {
      MessageForStructing localMessageForStructing = (MessageForStructing)paramMessageRecord;
      if ((localMessageForStructing.structingMsg != null) && (localMessageForStructing.structingMsg.mMsgServiceID == 98))
      {
        i = 1;
        break label44;
      }
    }
    int i = 0;
    label44:
    if (i == 0) {
      return paramMessageRecord.msgtype == -2070;
    }
    return true;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (paramString.indexOf("/") == -1) {
      return paramString;
    }
    int i = 0;
    String str = paramString;
    for (;;)
    {
      try
      {
        j = EmotcationConstants.SYS_EMOTICON_SYMBOL.length;
        if (i >= j) {
          break label371;
        }
        str = paramString;
        localStringBuilder = new StringBuilder();
        str = paramString;
        localStringBuilder.append('\024');
        str = paramString;
        localStringBuilder.append(EmotcationConstants.SYS_EMOTICON_SYMBOL[i]);
        str = paramString;
        localObject = paramString;
        if (paramString.indexOf(localStringBuilder.toString()) == -1) {
          break label361;
        }
        str = paramString;
        localObject = new StringBuilder();
        str = paramString;
        ((StringBuilder)localObject).append('\024');
        str = paramString;
        ((StringBuilder)localObject).append(EmotcationConstants.SYS_EMOTICON_SYMBOL[i]);
        str = paramString;
        localObject = ((StringBuilder)localObject).toString();
        str = paramString;
        localStringBuilder = new StringBuilder();
        str = paramString;
        localStringBuilder.append("\024");
        str = paramString;
        localStringBuilder.append((char)i);
        str = paramString;
        localObject = paramString.replace((CharSequence)localObject, localStringBuilder.toString());
      }
      catch (Exception paramString)
      {
        StringBuilder localStringBuilder;
        paramString.printStackTrace();
        localObject = str;
        if (!QLog.isColorLevel()) {
          break label358;
        }
        paramString = new StringBuilder();
        paramString.append("TextUtils:");
        int j = str.length();
        i = 200;
        if (j > 200) {
          continue;
        }
        i = str.length() - 1;
        paramString.append(str.substring(0, i));
        QLog.e("Q..msgbox.util", 2, paramString.toString());
        localObject = str;
      }
      str = paramString;
      Object localObject = paramString;
      if (i < EmotcationConstants.SYS_EMOTICON_SYMBOL.length)
      {
        localObject = paramString;
        str = paramString;
        if (paramString.indexOf(EmotcationConstants.SYS_EMOTICON_SYMBOL[i]) != -1)
        {
          str = paramString;
          localObject = EmotcationConstants.SYS_EMOTICON_SYMBOL[i];
          str = paramString;
          localStringBuilder = new StringBuilder();
          str = paramString;
          localStringBuilder.append("\024");
          str = paramString;
          localStringBuilder.append((char)i);
          str = paramString;
          localObject = paramString.replace((CharSequence)localObject, localStringBuilder.toString());
        }
        i += 1;
        paramString = (String)localObject;
      }
      else
      {
        label358:
        return localObject;
        label361:
        i += 1;
        paramString = (String)localObject;
        break;
        label371:
        i = 0;
      }
    }
  }
  
  public static boolean b(MessageRecord paramMessageRecord)
  {
    return a(paramMessageRecord.istroop, paramMessageRecord.msgtype, a(paramMessageRecord), paramMessageRecord.senderuin);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.MsgBoxUtil
 * JD-Core Version:    0.7.0.1
 */