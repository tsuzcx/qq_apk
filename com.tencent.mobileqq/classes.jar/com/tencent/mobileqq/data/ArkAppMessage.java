package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import org.json.JSONObject;

public class ArkAppMessage
{
  public final String TAG = "ArkApp.Message";
  public String appDesc;
  public String appId;
  public String appMinVersion;
  public String appName;
  public String appView;
  public String compatibleText;
  public String config;
  public MessageRecord containStructMsg;
  public int from;
  public String mSourceActionData;
  public String mSourceName;
  public String mSourceUrl;
  public String mSource_A_ActionData;
  public String metaList;
  public String promptText;
  
  public ArkAppMessage()
  {
    reset();
  }
  
  public ArkAppMessage(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    this.promptText = paramString1;
    this.appDesc = paramString3;
    this.appName = paramString2;
    this.appView = paramString4;
    this.appMinVersion = paramString5;
    this.metaList = paramString6;
    this.config = paramString7;
    this.compatibleText = paramString8;
  }
  
  public boolean fromAppXml(String paramString)
  {
    reset();
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.appName = paramString.optString("app");
      this.appView = paramString.optString("view");
      this.appDesc = paramString.optString("desc");
      this.appMinVersion = paramString.optString("ver");
      this.promptText = paramString.optString("prompt");
      this.metaList = paramString.optString("meta");
      this.config = paramString.optString("config");
      this.from = paramString.optInt("from");
      this.appId = paramString.optString("appID");
      this.mSourceName = paramString.optString("sourceName");
      this.mSourceActionData = paramString.optString("actionData");
      this.mSource_A_ActionData = paramString.optString("actionData_A");
      this.mSourceUrl = paramString.optString("sourceUrl");
      return true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public boolean fromBytes(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return false;
    }
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    try
    {
      boolean bool = fromAppXml((String)new ObjectInputStream(paramArrayOfByte).readObject());
      return bool;
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return false;
  }
  
  public String getSummery()
  {
    if (!TextUtils.isEmpty(this.promptText)) {
      return this.promptText;
    }
    return BaseApplicationImpl.getApplication().getString(2131438243);
  }
  
  public void reset()
  {
    this.promptText = null;
    this.appName = null;
    this.appDesc = null;
    this.appView = null;
    this.appMinVersion = null;
    this.metaList = null;
    this.config = null;
    this.compatibleText = null;
  }
  
  /* Error */
  public String toAppXml()
  {
    // Byte code:
    //   0: new 64	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 155	org/json/JSONObject:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 42	com/tencent/mobileqq/data/ArkAppMessage:appName	Ljava/lang/String;
    //   12: ifnull +14 -> 26
    //   15: aload_1
    //   16: ldc 69
    //   18: aload_0
    //   19: getfield 42	com/tencent/mobileqq/data/ArkAppMessage:appName	Ljava/lang/String;
    //   22: invokevirtual 159	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   25: pop
    //   26: aload_0
    //   27: getfield 40	com/tencent/mobileqq/data/ArkAppMessage:appDesc	Ljava/lang/String;
    //   30: ifnull +14 -> 44
    //   33: aload_1
    //   34: ldc 77
    //   36: aload_0
    //   37: getfield 40	com/tencent/mobileqq/data/ArkAppMessage:appDesc	Ljava/lang/String;
    //   40: invokevirtual 159	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   43: pop
    //   44: aload_0
    //   45: getfield 44	com/tencent/mobileqq/data/ArkAppMessage:appView	Ljava/lang/String;
    //   48: ifnull +14 -> 62
    //   51: aload_1
    //   52: ldc 75
    //   54: aload_0
    //   55: getfield 44	com/tencent/mobileqq/data/ArkAppMessage:appView	Ljava/lang/String;
    //   58: invokevirtual 159	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   61: pop
    //   62: aload_0
    //   63: getfield 46	com/tencent/mobileqq/data/ArkAppMessage:appMinVersion	Ljava/lang/String;
    //   66: ifnull +14 -> 80
    //   69: aload_1
    //   70: ldc 79
    //   72: aload_0
    //   73: getfield 46	com/tencent/mobileqq/data/ArkAppMessage:appMinVersion	Ljava/lang/String;
    //   76: invokevirtual 159	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   79: pop
    //   80: aload_0
    //   81: getfield 38	com/tencent/mobileqq/data/ArkAppMessage:promptText	Ljava/lang/String;
    //   84: ifnull +14 -> 98
    //   87: aload_1
    //   88: ldc 81
    //   90: aload_0
    //   91: getfield 38	com/tencent/mobileqq/data/ArkAppMessage:promptText	Ljava/lang/String;
    //   94: invokevirtual 159	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   97: pop
    //   98: aload_0
    //   99: getfield 91	com/tencent/mobileqq/data/ArkAppMessage:from	I
    //   102: ifeq +14 -> 116
    //   105: aload_1
    //   106: ldc 85
    //   108: aload_0
    //   109: getfield 91	com/tencent/mobileqq/data/ArkAppMessage:from	I
    //   112: invokevirtual 162	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   115: pop
    //   116: aload_0
    //   117: getfield 95	com/tencent/mobileqq/data/ArkAppMessage:appId	Ljava/lang/String;
    //   120: ifnull +14 -> 134
    //   123: aload_1
    //   124: ldc 93
    //   126: aload_0
    //   127: getfield 95	com/tencent/mobileqq/data/ArkAppMessage:appId	Ljava/lang/String;
    //   130: invokevirtual 159	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   133: pop
    //   134: aload_0
    //   135: getfield 99	com/tencent/mobileqq/data/ArkAppMessage:mSourceName	Ljava/lang/String;
    //   138: ifnull +14 -> 152
    //   141: aload_1
    //   142: ldc 97
    //   144: aload_0
    //   145: getfield 99	com/tencent/mobileqq/data/ArkAppMessage:mSourceName	Ljava/lang/String;
    //   148: invokevirtual 159	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   151: pop
    //   152: aload_0
    //   153: getfield 103	com/tencent/mobileqq/data/ArkAppMessage:mSourceActionData	Ljava/lang/String;
    //   156: ifnull +14 -> 170
    //   159: aload_1
    //   160: ldc 101
    //   162: aload_0
    //   163: getfield 103	com/tencent/mobileqq/data/ArkAppMessage:mSourceActionData	Ljava/lang/String;
    //   166: invokevirtual 159	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   169: pop
    //   170: aload_0
    //   171: getfield 107	com/tencent/mobileqq/data/ArkAppMessage:mSource_A_ActionData	Ljava/lang/String;
    //   174: ifnull +14 -> 188
    //   177: aload_1
    //   178: ldc 105
    //   180: aload_0
    //   181: getfield 107	com/tencent/mobileqq/data/ArkAppMessage:mSource_A_ActionData	Ljava/lang/String;
    //   184: invokevirtual 159	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   187: pop
    //   188: aload_0
    //   189: getfield 111	com/tencent/mobileqq/data/ArkAppMessage:mSourceUrl	Ljava/lang/String;
    //   192: ifnull +14 -> 206
    //   195: aload_1
    //   196: ldc 109
    //   198: aload_0
    //   199: getfield 111	com/tencent/mobileqq/data/ArkAppMessage:mSourceUrl	Ljava/lang/String;
    //   202: invokevirtual 159	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   205: pop
    //   206: aload_0
    //   207: getfield 48	com/tencent/mobileqq/data/ArkAppMessage:metaList	Ljava/lang/String;
    //   210: astore_2
    //   211: aload_2
    //   212: ifnull +21 -> 233
    //   215: aload_1
    //   216: ldc 83
    //   218: new 64	org/json/JSONObject
    //   221: dup
    //   222: aload_0
    //   223: getfield 48	com/tencent/mobileqq/data/ArkAppMessage:metaList	Ljava/lang/String;
    //   226: invokespecial 67	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   229: invokevirtual 159	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   232: pop
    //   233: aload_0
    //   234: getfield 50	com/tencent/mobileqq/data/ArkAppMessage:config	Ljava/lang/String;
    //   237: astore_2
    //   238: aload_2
    //   239: ifnull +21 -> 260
    //   242: aload_1
    //   243: ldc 84
    //   245: new 64	org/json/JSONObject
    //   248: dup
    //   249: aload_0
    //   250: getfield 50	com/tencent/mobileqq/data/ArkAppMessage:config	Ljava/lang/String;
    //   253: invokespecial 67	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   256: invokevirtual 159	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   259: pop
    //   260: aload_1
    //   261: invokevirtual 165	org/json/JSONObject:toString	()Ljava/lang/String;
    //   264: areturn
    //   265: astore_2
    //   266: ldc 29
    //   268: new 167	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   275: ldc 170
    //   277: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload_2
    //   281: invokevirtual 177	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   284: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 184	com/tencent/mobileqq/ark/ArkAppCenter:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: goto -60 -> 233
    //   296: astore_1
    //   297: aload_1
    //   298: invokevirtual 185	org/json/JSONException:printStackTrace	()V
    //   301: aconst_null
    //   302: areturn
    //   303: astore_2
    //   304: ldc 29
    //   306: new 167	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 168	java/lang/StringBuilder:<init>	()V
    //   313: ldc 187
    //   315: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_2
    //   319: invokevirtual 177	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   322: invokevirtual 174	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 178	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 184	com/tencent/mobileqq/ark/ArkAppCenter:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   331: goto -71 -> 260
    //   334: astore_1
    //   335: aload_1
    //   336: invokevirtual 114	java/lang/Exception:printStackTrace	()V
    //   339: goto -38 -> 301
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	342	0	this	ArkAppMessage
    //   7	254	1	localJSONObject	JSONObject
    //   296	2	1	localJSONException	org.json.JSONException
    //   334	2	1	localException1	Exception
    //   210	29	2	str	String
    //   265	16	2	localException2	Exception
    //   303	16	2	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   215	233	265	java/lang/Exception
    //   0	26	296	org/json/JSONException
    //   26	44	296	org/json/JSONException
    //   44	62	296	org/json/JSONException
    //   62	80	296	org/json/JSONException
    //   80	98	296	org/json/JSONException
    //   98	116	296	org/json/JSONException
    //   116	134	296	org/json/JSONException
    //   134	152	296	org/json/JSONException
    //   152	170	296	org/json/JSONException
    //   170	188	296	org/json/JSONException
    //   188	206	296	org/json/JSONException
    //   206	211	296	org/json/JSONException
    //   215	233	296	org/json/JSONException
    //   233	238	296	org/json/JSONException
    //   242	260	296	org/json/JSONException
    //   260	265	296	org/json/JSONException
    //   266	293	296	org/json/JSONException
    //   304	331	296	org/json/JSONException
    //   242	260	303	java/lang/Exception
    //   0	26	334	java/lang/Exception
    //   26	44	334	java/lang/Exception
    //   44	62	334	java/lang/Exception
    //   62	80	334	java/lang/Exception
    //   80	98	334	java/lang/Exception
    //   98	116	334	java/lang/Exception
    //   116	134	334	java/lang/Exception
    //   134	152	334	java/lang/Exception
    //   152	170	334	java/lang/Exception
    //   170	188	334	java/lang/Exception
    //   188	206	334	java/lang/Exception
    //   206	211	334	java/lang/Exception
    //   233	238	334	java/lang/Exception
    //   260	265	334	java/lang/Exception
    //   266	293	334	java/lang/Exception
    //   304	331	334	java/lang/Exception
  }
  
  public byte[] toBytes()
  {
    Object localObject = new ByteArrayOutputStream();
    try
    {
      new ObjectOutputStream((OutputStream)localObject).writeObject(toAppXml());
      localObject = ((ByteArrayOutputStream)localObject).toByteArray();
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public byte[] toPbData()
  {
    Object localObject = toAppXml();
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = ((String)localObject).getBytes("utf-8");
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.ArkAppMessage
 * JD-Core Version:    0.7.0.1
 */