package com.tencent.mobileqq.vas.nicknamemessage;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import org.json.JSONException;
import org.json.JSONObject;

public class NickNameManager
{
  public static SpannableString a(QQAppInterface paramQQAppInterface, Message paramMessage, boolean paramBoolean)
  {
    int j = 0;
    if (paramMessage.mExJsonObject != null)
    {
      label216:
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(new JSONObject(paramMessage.mExJsonObject.optString("report_key_bytes_oac_msg_extend", "")).optString("sp_brief", ""));
          Object localObject1 = localJSONObject.optString("brief", null);
          Object localObject3;
          int k;
          label125:
          int m;
          localJSONException1.printStackTrace();
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            try
            {
              str = localJSONObject.optString("color", "#ff0000");
              paramMessage = (Message)localObject1;
              localObject3 = localObject1;
            }
            catch (JSONException localJSONException4)
            {
              String str = null;
              i = -1;
              paramMessage = localJSONException1;
              Object localObject2 = localJSONException4;
              continue;
            }
            for (;;)
            {
              try
              {
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  paramMessage = null;
                }
                localObject3 = paramMessage;
                localObject1 = localJSONObject.optJSONObject("range");
                if (localObject1 == null) {
                  continue;
                }
                localObject3 = paramMessage;
                i = ((JSONObject)localObject1).optInt("location", -1);
              }
              catch (JSONException localJSONException2)
              {
                i = -1;
                paramMessage = localJSONException4;
                break label216;
                i = -1;
                break label125;
              }
              try
              {
                k = ((JSONObject)localObject1).optInt("length", 0);
                j = k;
                paramQQAppInterface = a(paramQQAppInterface);
                if (paramMessage == null) {
                  break label306;
                }
                k = paramMessage.indexOf("[nick]");
                m = paramQQAppInterface.length();
                paramQQAppInterface = paramMessage.replace("[nick]", paramQQAppInterface);
                if (k <= -1) {
                  break label231;
                }
                paramQQAppInterface = new SpannableString(paramQQAppInterface);
                if ((str == null) || (!paramBoolean)) {}
              }
              catch (JSONException localJSONException3)
              {
                break label216;
              }
            }
            try
            {
              paramQQAppInterface.setSpan(new ForegroundColorSpan(Color.parseColor(str)), k, m + k, 18);
              return paramQQAppInterface;
            }
            catch (IllegalArgumentException paramMessage)
            {
              paramMessage.printStackTrace();
              return paramQQAppInterface;
            }
          }
          localJSONException1 = localJSONException1;
          str = null;
          paramMessage = null;
          i = -1;
        }
      }
      label231:
      if ((paramBoolean) && (i > -1) && (j > 0)) {
        try
        {
          if ((!TextUtils.isEmpty(paramQQAppInterface)) && (!TextUtils.isEmpty(str)))
          {
            paramMessage = new SpannableString(paramQQAppInterface);
            paramMessage.setSpan(new ForegroundColorSpan(Color.parseColor(str)), i, j, 33);
            return paramMessage;
          }
        }
        catch (Exception paramMessage)
        {
          paramMessage.printStackTrace();
        }
      }
      return new SpannableString(paramQQAppInterface);
    }
    label306:
    return null;
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
  
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte, tencent.im.msg.im_msg_body.GeneralFlags paramGeneralFlags, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: ifnull +287 -> 291
    //   7: aload_1
    //   8: getfield 123	tencent/im/msg/im_msg_body$GeneralFlags:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11: invokevirtual 129	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   14: ifeq +277 -> 291
    //   17: new 131	tencent/im/msg/hummer/resv/generalflags$ResvAttr
    //   20: dup
    //   21: invokespecial 132	tencent/im/msg/hummer/resv/generalflags$ResvAttr:<init>	()V
    //   24: astore 4
    //   26: aload 4
    //   28: aload_1
    //   29: getfield 123	tencent/im/msg/im_msg_body$GeneralFlags:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   32: invokevirtual 136	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   35: invokevirtual 142	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   38: invokevirtual 146	tencent/im/msg/hummer/resv/generalflags$ResvAttr:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   41: pop
    //   42: aload 4
    //   44: getfield 149	tencent/im/msg/hummer/resv/generalflags$ResvAttr:bytes_oac_msg_extend	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   47: invokevirtual 129	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   50: ifeq +236 -> 286
    //   53: new 25	org/json/JSONObject
    //   56: dup
    //   57: new 25	org/json/JSONObject
    //   60: dup
    //   61: aload 4
    //   63: getfield 149	tencent/im/msg/hummer/resv/generalflags$ResvAttr:bytes_oac_msg_extend	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   66: invokevirtual 136	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   69: invokevirtual 152	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   72: invokespecial 36	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   75: ldc 38
    //   77: ldc 29
    //   79: invokevirtual 33	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   82: invokespecial 36	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   85: astore_1
    //   86: aload_1
    //   87: ldc 154
    //   89: aload_1
    //   90: ldc 40
    //   92: aconst_null
    //   93: invokevirtual 33	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   96: invokevirtual 33	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   99: astore_1
    //   100: aload_1
    //   101: invokestatic 50	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   104: istore_3
    //   105: iload_3
    //   106: ifeq +5 -> 111
    //   109: aconst_null
    //   110: astore_1
    //   111: aload 5
    //   113: astore 4
    //   115: aload_1
    //   116: ifnull +132 -> 248
    //   119: aload 5
    //   121: astore 4
    //   123: aload_0
    //   124: arraylength
    //   125: ifle +123 -> 248
    //   128: invokestatic 160	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   131: invokevirtual 164	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   134: astore 4
    //   136: aload 4
    //   138: instanceof 108
    //   141: ifeq +142 -> 283
    //   144: aload_1
    //   145: ldc 69
    //   147: aload 4
    //   149: checkcast 108	com/tencent/mobileqq/app/QQAppInterface
    //   152: invokestatic 67	com/tencent/mobileqq/vas/nicknamemessage/NickNameManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   155: invokevirtual 82	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   158: astore_1
    //   159: new 71	java/lang/String
    //   162: dup
    //   163: aload_0
    //   164: iload_2
    //   165: invokestatic 169	com/tencent/mobileqq/structmsg/StructMsgUtils:a	([BI)[B
    //   168: ldc 171
    //   170: invokespecial 174	java/lang/String:<init>	([BLjava/lang/String;)V
    //   173: astore_0
    //   174: aload 5
    //   176: astore 4
    //   178: aload_0
    //   179: ldc 176
    //   181: invokevirtual 179	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   184: ifeq +64 -> 248
    //   187: getstatic 184	com/tencent/mobileqq/utils/VasUtils:a	Ljava/lang/String;
    //   190: iconst_1
    //   191: new 186	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   198: ldc 189
    //   200: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_1
    //   204: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 202	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: aload_0
    //   214: ldc 204
    //   216: new 186	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   223: ldc 176
    //   225: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: aload_1
    //   229: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: ldc 206
    //   234: invokevirtual 193	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokevirtual 209	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   243: invokevirtual 212	java/lang/String:getBytes	()[B
    //   246: astore 4
    //   248: aload 4
    //   250: areturn
    //   251: astore 4
    //   253: aconst_null
    //   254: astore_1
    //   255: getstatic 184	com/tencent/mobileqq/utils/VasUtils:a	Ljava/lang/String;
    //   258: iconst_1
    //   259: aload 4
    //   261: iconst_0
    //   262: anewarray 4	java/lang/Object
    //   265: invokestatic 216	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   268: goto -157 -> 111
    //   271: astore_0
    //   272: aload_0
    //   273: invokevirtual 217	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   276: aconst_null
    //   277: areturn
    //   278: astore 4
    //   280: goto -25 -> 255
    //   283: goto -124 -> 159
    //   286: aconst_null
    //   287: astore_1
    //   288: goto -177 -> 111
    //   291: aconst_null
    //   292: astore_1
    //   293: goto -182 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	paramArrayOfByte	byte[]
    //   0	296	1	paramGeneralFlags	tencent.im.msg.im_msg_body.GeneralFlags
    //   0	296	2	paramInt	int
    //   104	2	3	bool	boolean
    //   24	225	4	localObject1	Object
    //   251	9	4	localException1	Exception
    //   278	1	4	localException2	Exception
    //   1	174	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   26	100	251	java/lang/Exception
    //   159	174	271	java/io/UnsupportedEncodingException
    //   178	248	271	java/io/UnsupportedEncodingException
    //   100	105	278	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.nicknamemessage.NickNameManager
 * JD-Core Version:    0.7.0.1
 */