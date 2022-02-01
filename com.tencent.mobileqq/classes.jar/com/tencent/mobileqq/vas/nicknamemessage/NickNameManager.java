package com.tencent.mobileqq.vas.nicknamemessage;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.structmsg.StructMsgUtils;
import com.tencent.mobileqq.utils.VasUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import tencent.im.msg.hummer.resv.generalflags.ResvAttr;
import tencent.im.msg.im_msg_body.GeneralFlags;

public class NickNameManager
{
  /* Error */
  public static SpannableString a(QQAppInterface paramQQAppInterface, com.tencent.imcore.message.Message paramMessage, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 19	com/tencent/imcore/message/Message:mExJsonObject	Lorg/json/JSONObject;
    //   4: ifnull +220 -> 224
    //   7: iconst_0
    //   8: istore 5
    //   10: iconst_m1
    //   11: istore_3
    //   12: new 21	org/json/JSONObject
    //   15: dup
    //   16: new 21	org/json/JSONObject
    //   19: dup
    //   20: aload_1
    //   21: getfield 19	com/tencent/imcore/message/Message:mExJsonObject	Lorg/json/JSONObject;
    //   24: ldc 23
    //   26: ldc 25
    //   28: invokevirtual 29	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   31: invokespecial 32	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   34: ldc 34
    //   36: ldc 25
    //   38: invokevirtual 29	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   41: invokespecial 32	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   44: astore 9
    //   46: aload 9
    //   48: ldc 36
    //   50: aconst_null
    //   51: invokevirtual 29	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   54: astore 6
    //   56: aload 9
    //   58: ldc 38
    //   60: ldc 40
    //   62: invokevirtual 29	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   65: astore 8
    //   67: aload 6
    //   69: astore_1
    //   70: aload 6
    //   72: astore 7
    //   74: iload_3
    //   75: istore 4
    //   77: aload 6
    //   79: invokestatic 46	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   82: ifeq +5 -> 87
    //   85: aconst_null
    //   86: astore_1
    //   87: aload_1
    //   88: astore 7
    //   90: iload_3
    //   91: istore 4
    //   93: aload 9
    //   95: ldc 48
    //   97: invokevirtual 52	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   100: astore 6
    //   102: iload_3
    //   103: istore 4
    //   105: aload 6
    //   107: ifnull +37 -> 144
    //   110: aload_1
    //   111: astore 7
    //   113: iload_3
    //   114: istore 4
    //   116: aload 6
    //   118: ldc 54
    //   120: iconst_m1
    //   121: invokevirtual 58	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   124: istore_3
    //   125: aload_1
    //   126: astore 7
    //   128: iload_3
    //   129: istore 4
    //   131: aload 6
    //   133: ldc 60
    //   135: iconst_0
    //   136: invokevirtual 58	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   139: istore 5
    //   141: iload_3
    //   142: istore 4
    //   144: iload 4
    //   146: istore_3
    //   147: aload 8
    //   149: astore 6
    //   151: goto +52 -> 203
    //   154: astore 9
    //   156: aload 7
    //   158: astore_1
    //   159: iload 4
    //   161: istore_3
    //   162: aload 8
    //   164: astore 6
    //   166: aload 9
    //   168: astore 7
    //   170: goto +25 -> 195
    //   173: astore 7
    //   175: aconst_null
    //   176: astore 8
    //   178: aload 6
    //   180: astore_1
    //   181: aload 8
    //   183: astore 6
    //   185: goto +10 -> 195
    //   188: astore 7
    //   190: aconst_null
    //   191: astore_1
    //   192: aload_1
    //   193: astore 6
    //   195: aload 7
    //   197: invokevirtual 63	org/json/JSONException:printStackTrace	()V
    //   200: iconst_0
    //   201: istore 5
    //   203: aload_0
    //   204: invokestatic 66	com/tencent/mobileqq/vas/nicknamemessage/NickNameManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   207: astore_0
    //   208: aload_1
    //   209: ifnull +15 -> 224
    //   212: iload_2
    //   213: aload_1
    //   214: aload 6
    //   216: iload_3
    //   217: iload 5
    //   219: aload_0
    //   220: invokestatic 69	com/tencent/mobileqq/vas/nicknamemessage/NickNameManager:a	(ZLjava/lang/String;Ljava/lang/String;IILjava/lang/String;)Landroid/text/SpannableString;
    //   223: areturn
    //   224: aconst_null
    //   225: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	paramQQAppInterface	QQAppInterface
    //   0	226	1	paramMessage	com.tencent.imcore.message.Message
    //   0	226	2	paramBoolean	boolean
    //   11	206	3	i	int
    //   75	85	4	j	int
    //   8	210	5	k	int
    //   54	161	6	localObject1	Object
    //   72	97	7	localObject2	Object
    //   173	1	7	localJSONException1	org.json.JSONException
    //   188	8	7	localJSONException2	org.json.JSONException
    //   65	117	8	str	String
    //   44	50	9	localJSONObject	JSONObject
    //   154	13	9	localJSONException3	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   77	85	154	org/json/JSONException
    //   93	102	154	org/json/JSONException
    //   116	125	154	org/json/JSONException
    //   131	141	154	org/json/JSONException
    //   56	67	173	org/json/JSONException
    //   12	56	188	org/json/JSONException
  }
  
  @NotNull
  private static SpannableString a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2, String paramString3)
  {
    int i = paramString1.indexOf("[nick]");
    int j = paramString3.length();
    paramString1 = paramString1.replace("[nick]", paramString3);
    if (i > -1)
    {
      paramString1 = new SpannableString(paramString1);
      if ((paramString2 != null) && (paramBoolean)) {
        try
        {
          paramString1.setSpan(new ForegroundColorSpan(Color.parseColor(paramString2)), i, j + i, 18);
          return paramString1;
        }
        catch (IllegalArgumentException paramString2)
        {
          paramString2.printStackTrace();
        }
      }
      return paramString1;
    }
    if ((paramBoolean) && (paramInt1 > -1) && (paramInt2 > 0)) {
      try
      {
        if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
        {
          paramString3 = new SpannableString(paramString1);
          paramString3.setSpan(new ForegroundColorSpan(Color.parseColor(paramString2)), paramInt1, paramInt2, 33);
          return paramString3;
        }
      }
      catch (Exception paramString2)
      {
        paramString2.printStackTrace();
      }
    }
    return new SpannableString(paramString1);
  }
  
  private static String a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      String str = paramQQAppInterface.getCurrentNickname();
      paramQQAppInterface = str;
      if (TextUtils.isEmpty(str)) {
        paramQQAppInterface = "亲爱的用户";
      }
      return paramQQAppInterface;
    }
    return "";
  }
  
  public static byte[] a(byte[] paramArrayOfByte, im_msg_body.GeneralFlags paramGeneralFlags, int paramInt)
  {
    if ((paramGeneralFlags != null) && (paramGeneralFlags.bytes_pb_reserve.has()))
    {
      generalflags.ResvAttr localResvAttr = new generalflags.ResvAttr();
      try
      {
        localResvAttr.mergeFrom(paramGeneralFlags.bytes_pb_reserve.get().toByteArray());
        if (!localResvAttr.bytes_oac_msg_extend.has()) {
          break label134;
        }
        paramGeneralFlags = new JSONObject(new JSONObject(localResvAttr.bytes_oac_msg_extend.get().toStringUtf8()).optString("sp_brief", ""));
        paramGeneralFlags = paramGeneralFlags.optString("title", paramGeneralFlags.optString("brief", null));
        try
        {
          boolean bool = TextUtils.isEmpty(paramGeneralFlags);
          if (!bool) {
            break label136;
          }
        }
        catch (Exception localException1) {}
        QLog.e(VasUtils.a, 1, localException2, new Object[0]);
      }
      catch (Exception localException2)
      {
        paramGeneralFlags = null;
      }
      break label136;
    }
    label134:
    paramGeneralFlags = null;
    label136:
    if ((paramGeneralFlags != null) && (paramArrayOfByte.length > 0))
    {
      Object localObject2 = BaseApplicationImpl.getApplication().getRuntime();
      Object localObject1 = paramGeneralFlags;
      if ((localObject2 instanceof QQAppInterface)) {
        localObject1 = paramGeneralFlags.replace("[nick]", a((QQAppInterface)localObject2));
      }
      try
      {
        paramArrayOfByte = new String(StructMsgUtils.a(paramArrayOfByte, paramInt), "utf-8");
        if (paramArrayOfByte.contains("<title>"))
        {
          paramGeneralFlags = VasUtils.a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("replacedXMLBuff to ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.i(paramGeneralFlags, 1, ((StringBuilder)localObject2).toString());
          paramGeneralFlags = new StringBuilder();
          paramGeneralFlags.append("<title>");
          paramGeneralFlags.append((String)localObject1);
          paramGeneralFlags.append("</title>");
          paramArrayOfByte = paramArrayOfByte.replaceFirst("<title>.*</title>", paramGeneralFlags.toString()).getBytes();
          return paramArrayOfByte;
        }
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.nicknamemessage.NickNameManager
 * JD-Core Version:    0.7.0.1
 */