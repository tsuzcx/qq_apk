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
  public static final String KEY_FROM_FOLE_ID = "key_from_role_id";
  public static final String KEY_FROM_OPEN_ID = "key_from_open_id";
  public static final String KEY_FROM_TINY_ID = "key_from_tiny_id";
  public static final String KEY_GAME_APP_ID = "key_game_app_id";
  public static final String KEY_TO_FOLE_ID = "key_to_role_id";
  public static final String KEY_TO_OPEN_ID = "key_to_open_id";
  public static final String KEY_TO_TINY_ID = "key_to_tiny_id";
  public String fromOpenId;
  public String fromRoleId;
  public long fromTinyId;
  public long gameAppId;
  public String nickName;
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
  public static String toJsonStr(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, long paramLong3, int paramInt, String paramString5)
  {
    // Byte code:
    //   0: new 74	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 126	org/json/JSONObject:<init>	()V
    //   7: astore 12
    //   9: aload 12
    //   11: ldc 10
    //   13: aload_0
    //   14: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   17: pop
    //   18: aload 12
    //   20: ldc 13
    //   22: aload_1
    //   23: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   26: pop
    //   27: aload 12
    //   29: ldc 22
    //   31: aload_2
    //   32: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   35: pop
    //   36: aload 12
    //   38: ldc 25
    //   40: aload_3
    //   41: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   44: pop
    //   45: aload 12
    //   47: ldc 19
    //   49: lload 4
    //   51: invokevirtual 133	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   54: pop
    //   55: aload 12
    //   57: ldc 16
    //   59: lload 6
    //   61: invokevirtual 133	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   64: pop
    //   65: aload 12
    //   67: ldc 28
    //   69: lload 8
    //   71: invokevirtual 133	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   74: pop
    //   75: aload 12
    //   77: ldc 86
    //   79: iload 10
    //   81: invokevirtual 136	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   84: pop
    //   85: aload 12
    //   87: ldc 92
    //   89: aload 11
    //   91: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   94: pop
    //   95: aload 12
    //   97: invokevirtual 137	org/json/JSONObject:toString	()Ljava/lang/String;
    //   100: astore_0
    //   101: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   104: ifeq +28 -> 132
    //   107: ldc 100
    //   109: iconst_2
    //   110: new 102	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   117: ldc 139
    //   119: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_0
    //   123: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: aload_0
    //   133: areturn
    //   134: astore_1
    //   135: ldc 141
    //   137: astore_0
    //   138: aload_1
    //   139: invokevirtual 142	java/lang/Exception:printStackTrace	()V
    //   142: aload_0
    //   143: areturn
    //   144: astore_1
    //   145: goto -7 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	paramString1	String
    //   0	148	1	paramString2	String
    //   0	148	2	paramString3	String
    //   0	148	3	paramString4	String
    //   0	148	4	paramLong1	long
    //   0	148	6	paramLong2	long
    //   0	148	8	paramLong3	long
    //   0	148	10	paramInt	int
    //   0	148	11	paramString5	String
    //   7	89	12	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   0	101	134	java/lang/Exception
    //   101	132	144	java/lang/Exception
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
    paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("ext_key_game_msg_info");
    if (!TextUtils.isEmpty(paramMessageRecord)) {
      parseFromJson(paramMessageRecord);
    }
  }
  
  /* Error */
  public String toJsonStr()
  {
    // Byte code:
    //   0: new 74	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 126	org/json/JSONObject:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: ldc 10
    //   11: aload_0
    //   12: getfield 52	com/tencent/mobileqq/gamecenter/message/TinyInfo:fromRoleId	Ljava/lang/String;
    //   15: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   18: pop
    //   19: aload_1
    //   20: ldc 13
    //   22: aload_0
    //   23: getfield 50	com/tencent/mobileqq/gamecenter/message/TinyInfo:fromOpenId	Ljava/lang/String;
    //   26: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   29: pop
    //   30: aload_1
    //   31: ldc 22
    //   33: aload_0
    //   34: getfield 56	com/tencent/mobileqq/gamecenter/message/TinyInfo:toRoleId	Ljava/lang/String;
    //   37: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   40: pop
    //   41: aload_1
    //   42: ldc 25
    //   44: aload_0
    //   45: getfield 54	com/tencent/mobileqq/gamecenter/message/TinyInfo:toOpenId	Ljava/lang/String;
    //   48: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   51: pop
    //   52: aload_1
    //   53: ldc 19
    //   55: aload_0
    //   56: getfield 58	com/tencent/mobileqq/gamecenter/message/TinyInfo:gameAppId	J
    //   59: invokevirtual 133	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   62: pop
    //   63: aload_1
    //   64: ldc 16
    //   66: aload_0
    //   67: getfield 60	com/tencent/mobileqq/gamecenter/message/TinyInfo:fromTinyId	J
    //   70: invokevirtual 133	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   73: pop
    //   74: aload_1
    //   75: ldc 28
    //   77: aload_0
    //   78: getfield 62	com/tencent/mobileqq/gamecenter/message/TinyInfo:toTinyId	J
    //   81: invokevirtual 133	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   84: pop
    //   85: aload_1
    //   86: ldc 86
    //   88: aload_0
    //   89: getfield 64	com/tencent/mobileqq/gamecenter/message/TinyInfo:windowFlag	J
    //   92: invokevirtual 133	org/json/JSONObject:put	(Ljava/lang/String;J)Lorg/json/JSONObject;
    //   95: pop
    //   96: aload_1
    //   97: ldc 92
    //   99: aload_0
    //   100: getfield 66	com/tencent/mobileqq/gamecenter/message/TinyInfo:nickName	Ljava/lang/String;
    //   103: invokevirtual 130	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   106: pop
    //   107: aload_1
    //   108: invokevirtual 137	org/json/JSONObject:toString	()Ljava/lang/String;
    //   111: astore_1
    //   112: invokestatic 98	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +28 -> 143
    //   118: ldc 100
    //   120: iconst_2
    //   121: new 102	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   128: ldc 161
    //   130: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: aload_1
    //   134: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 118	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   143: aload_1
    //   144: areturn
    //   145: astore_2
    //   146: ldc 141
    //   148: astore_1
    //   149: aload_2
    //   150: invokevirtual 142	java/lang/Exception:printStackTrace	()V
    //   153: aload_1
    //   154: areturn
    //   155: astore_2
    //   156: goto -7 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	TinyInfo
    //   7	147	1	localObject	Object
    //   145	5	2	localException1	java.lang.Exception
    //   155	1	2	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	112	145	java/lang/Exception
    //   112	143	155	java/lang/Exception
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
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.message.TinyInfo
 * JD-Core Version:    0.7.0.1
 */