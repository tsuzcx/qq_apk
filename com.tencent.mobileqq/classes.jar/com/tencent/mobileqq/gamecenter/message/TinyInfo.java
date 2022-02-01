package com.tencent.mobileqq.gamecenter.message;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class TinyInfo
  implements Serializable
{
  public static final String EXT_KEY_GAME_MSG_INFO = "ext_key_game_msg_info";
  public static final String KEY_FROM_FOLE_ID = "key_from_role_id";
  public static final String KEY_FROM_OPEN_ID = "key_from_open_id";
  public static final String KEY_FROM_TINY_ID = "key_from_tiny_id";
  public static final String KEY_GAME_APP_ID = "key_game_app_id";
  public static final String KEY_REDPOINT_INFO = "key_redpoint_info";
  public static final String KEY_TO_FOLE_ID = "key_to_role_id";
  public static final String KEY_TO_OPEN_ID = "key_to_open_id";
  public static final String KEY_TO_TINY_ID = "key_to_tiny_id";
  public String fromOpenId;
  public String fromRoleId;
  public long fromTinyId;
  public long gameAppId;
  public String nickName;
  public int redpointSwitch;
  public String toOpenId;
  public String toRoleId;
  public long toTinyId;
  public long windowFlag;
  
  public TinyInfo() {}
  
  public TinyInfo(String paramString)
  {
    parseFromJson(paramString);
  }
  
  public TinyInfo(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, long paramLong3, int paramInt, String paramString5)
  {
    this.fromOpenId = paramString2;
    this.fromRoleId = paramString1;
    this.toOpenId = paramString4;
    this.toRoleId = paramString3;
    this.gameAppId = paramLong1;
    this.fromTinyId = paramLong2;
    this.toTinyId = paramLong3;
    this.windowFlag = paramInt;
    this.nickName = paramString5;
  }
  
  public TinyInfo(String paramString, boolean paramBoolean)
  {
    a(paramString, paramBoolean);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(paramString);
      if (paramBoolean)
      {
        paramString = localJSONObject.optString("key_to_role_id");
        this.fromRoleId = paramString;
        if (!paramBoolean) {
          break label192;
        }
        paramString = localJSONObject.optString("key_to_open_id");
        label39:
        this.fromOpenId = paramString;
        if (!paramBoolean) {
          break label203;
        }
        paramString = localJSONObject.optString("key_from_role_id");
        label56:
        this.toRoleId = paramString;
        if (!paramBoolean) {
          break label214;
        }
        paramString = localJSONObject.optString("key_from_open_id");
        label73:
        this.toOpenId = paramString;
        this.gameAppId = localJSONObject.optLong("key_game_app_id");
        if (!paramBoolean) {
          break label225;
        }
        l = localJSONObject.optLong("key_to_tiny_id");
        label101:
        this.fromTinyId = l;
        if (!paramBoolean) {
          break label236;
        }
      }
      label192:
      label203:
      label214:
      label225:
      label236:
      for (long l = localJSONObject.optLong("key_from_tiny_id");; l = localJSONObject.optLong("key_to_tiny_id"))
      {
        this.toTinyId = l;
        this.windowFlag = localJSONObject.optInt("key_window_flag");
        this.nickName = localJSONObject.optString("key_nick_name");
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("Q.tiny_msg.TinyInfo", 2, "parseFromJson 2 info: " + toString());
        return;
        paramString = localJSONObject.optString("key_from_role_id");
        break;
        paramString = localJSONObject.optString("key_from_open_id");
        break label39;
        paramString = localJSONObject.optString("key_to_role_id");
        break label56;
        paramString = localJSONObject.optString("key_to_open_id");
        break label73;
        l = localJSONObject.optLong("key_from_tiny_id");
        break label101;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  /* Error */
  public static String toJsonStr(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, long paramLong3, int paramInt1, String paramString5, int paramInt2)
  {
    // Byte code:
    //   0: new 82	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 134	org/json/JSONObject:<init>	()V
    //   7: astore 13
    //   9: aload 13
    //   11: ldc 13
    //   13: aload_0
    //   14: invokevirtual 138	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   17: pop
    //   18: aload 13
    //   20: ldc 16
    //   22: aload_1
    //   23: invokevirtual 138	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   26: pop
    //   27: aload 13
    //   29: ldc 28
    //   31: aload_2
    //   32: invokevirtual 138	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   35: pop
    //   36: aload 13
    //   38: ldc 31
    //   40: aload_3
    //   41: invokevirtual 138	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   44: pop
    //   45: aload 13
    //   47: ldc 22
    //   49: lload 4
    //   51: invokevirtual 141	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   54: pop
    //   55: aload 13
    //   57: ldc 19
    //   59: lload 6
    //   61: invokevirtual 141	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   64: pop
    //   65: aload 13
    //   67: ldc 34
    //   69: lload 8
    //   71: invokevirtual 141	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   74: pop
    //   75: aload 13
    //   77: ldc 94
    //   79: iload 10
    //   81: invokevirtual 144	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   84: pop
    //   85: aload 13
    //   87: ldc 100
    //   89: aload 11
    //   91: invokevirtual 138	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   94: pop
    //   95: aload 13
    //   97: ldc 25
    //   99: iload 12
    //   101: invokevirtual 144	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   104: pop
    //   105: aload 13
    //   107: invokevirtual 145	org/json/JSONObject:toString	()Ljava/lang/String;
    //   110: astore_0
    //   111: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq +28 -> 142
    //   117: ldc 108
    //   119: iconst_2
    //   120: new 110	java/lang/StringBuilder
    //   123: dup
    //   124: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   127: ldc 147
    //   129: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_0
    //   133: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: aload_0
    //   143: areturn
    //   144: astore_1
    //   145: ldc 149
    //   147: astore_0
    //   148: aload_1
    //   149: invokevirtual 150	java/lang/Exception:printStackTrace	()V
    //   152: aload_0
    //   153: areturn
    //   154: astore_1
    //   155: goto -7 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramString1	String
    //   0	158	1	paramString2	String
    //   0	158	2	paramString3	String
    //   0	158	3	paramString4	String
    //   0	158	4	paramLong1	long
    //   0	158	6	paramLong2	long
    //   0	158	8	paramLong3	long
    //   0	158	10	paramInt1	int
    //   0	158	11	paramString5	String
    //   0	158	12	paramInt2	int
    //   7	99	13	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	111	144	java/lang/Exception
    //   111	142	154	java/lang/Exception
  }
  
  public void parseFromJson(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString);
      this.fromRoleId = paramString.optString("key_from_role_id");
      this.fromOpenId = paramString.optString("key_from_open_id");
      this.toRoleId = paramString.optString("key_to_role_id");
      this.toOpenId = paramString.optString("key_to_open_id");
      this.gameAppId = paramString.optInt("key_game_app_id");
      this.fromTinyId = paramString.optLong("key_from_tiny_id");
      this.toTinyId = paramString.optLong("key_to_tiny_id");
      this.windowFlag = paramString.optInt("key_window_flag");
      this.nickName = paramString.optString("key_nick_name");
      this.redpointSwitch = paramString.optInt("key_redpoint_info");
      if (QLog.isColorLevel()) {
        QLog.d("Q.tiny_msg.TinyInfo", 2, "parseFromJson info: " + toString());
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void parseFromMessageRecord(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      QLog.e("Q.tiny_msg.TinyInfo", 1, "[parseFromMessageRecord], gameMsg is null.");
    }
    do
    {
      return;
      paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("ext_key_game_msg_info");
    } while (TextUtils.isEmpty(paramMessageRecord));
    parseFromJson(paramMessageRecord);
  }
  
  /* Error */
  public String toJsonStr()
  {
    // Byte code:
    //   0: new 82	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 134	org/json/JSONObject:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: ldc 13
    //   11: aload_0
    //   12: getfield 60	com/tencent/mobileqq/gamecenter/message/TinyInfo:fromRoleId	Ljava/lang/String;
    //   15: invokevirtual 138	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   18: pop
    //   19: aload_1
    //   20: ldc 16
    //   22: aload_0
    //   23: getfield 58	com/tencent/mobileqq/gamecenter/message/TinyInfo:fromOpenId	Ljava/lang/String;
    //   26: invokevirtual 138	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   29: pop
    //   30: aload_1
    //   31: ldc 28
    //   33: aload_0
    //   34: getfield 64	com/tencent/mobileqq/gamecenter/message/TinyInfo:toRoleId	Ljava/lang/String;
    //   37: invokevirtual 138	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   40: pop
    //   41: aload_1
    //   42: ldc 31
    //   44: aload_0
    //   45: getfield 62	com/tencent/mobileqq/gamecenter/message/TinyInfo:toOpenId	Ljava/lang/String;
    //   48: invokevirtual 138	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   51: pop
    //   52: aload_1
    //   53: ldc 22
    //   55: aload_0
    //   56: getfield 66	com/tencent/mobileqq/gamecenter/message/TinyInfo:gameAppId	J
    //   59: invokevirtual 141	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   62: pop
    //   63: aload_1
    //   64: ldc 19
    //   66: aload_0
    //   67: getfield 68	com/tencent/mobileqq/gamecenter/message/TinyInfo:fromTinyId	J
    //   70: invokevirtual 141	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   73: pop
    //   74: aload_1
    //   75: ldc 34
    //   77: aload_0
    //   78: getfield 70	com/tencent/mobileqq/gamecenter/message/TinyInfo:toTinyId	J
    //   81: invokevirtual 141	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   84: pop
    //   85: aload_1
    //   86: ldc 94
    //   88: aload_0
    //   89: getfield 72	com/tencent/mobileqq/gamecenter/message/TinyInfo:windowFlag	J
    //   92: invokevirtual 141	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   95: pop
    //   96: aload_1
    //   97: ldc 100
    //   99: aload_0
    //   100: getfield 74	com/tencent/mobileqq/gamecenter/message/TinyInfo:nickName	Ljava/lang/String;
    //   103: invokevirtual 138	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   106: pop
    //   107: aload_1
    //   108: ldc 25
    //   110: aload_0
    //   111: getfield 152	com/tencent/mobileqq/gamecenter/message/TinyInfo:redpointSwitch	I
    //   114: invokevirtual 144	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   117: pop
    //   118: aload_1
    //   119: invokevirtual 145	org/json/JSONObject:toString	()Ljava/lang/String;
    //   122: astore_1
    //   123: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +28 -> 154
    //   129: ldc 108
    //   131: iconst_2
    //   132: new 110	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   139: ldc 174
    //   141: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload_1
    //   145: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 126	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aload_1
    //   155: areturn
    //   156: astore_2
    //   157: ldc 149
    //   159: astore_1
    //   160: aload_2
    //   161: invokevirtual 150	java/lang/Exception:printStackTrace	()V
    //   164: aload_1
    //   165: areturn
    //   166: astore_2
    //   167: goto -7 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	TinyInfo
    //   7	158	1	localObject	Object
    //   156	5	2	localException1	java.lang.Exception
    //   166	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	123	156	java/lang/Exception
    //   123	154	166	java/lang/Exception
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[").append("fromRoleId").append("=").append(this.fromRoleId);
    localStringBuilder.append(" ").append("fromOpenId").append("=").append(this.fromOpenId);
    localStringBuilder.append(" ").append("toRoleId").append("=").append(this.toRoleId);
    localStringBuilder.append(" ").append("toOpenId").append("=").append(this.toOpenId);
    localStringBuilder.append(" ").append("gameAppId").append("=").append(this.gameAppId);
    localStringBuilder.append(" ").append("fromTinyId").append("=").append(this.fromTinyId);
    localStringBuilder.append(" ").append("toTinyId").append("=").append(this.toTinyId);
    localStringBuilder.append(" ").append("nickName").append("=").append(this.nickName);
    localStringBuilder.append(" ").append("windowFlag").append("=").append(this.windowFlag);
    localStringBuilder.append(" ").append("redpointR").append("=").append(this.redpointSwitch);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.TinyInfo
 * JD-Core Version:    0.7.0.1
 */