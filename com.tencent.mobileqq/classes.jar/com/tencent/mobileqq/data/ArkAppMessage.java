package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
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
  public int forwardID;
  public int from;
  public List<ArkAppMessage> mAppList;
  public String mExtra;
  public String mSourceActionData;
  public String mSourceAd;
  public String mSourceName;
  public String mSourceUrl;
  public String mSource_A_ActionData;
  public String mText;
  public String metaList;
  public String promptText;
  public long uniSeq;
  
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
    if (QLog.isColorLevel()) {
      QLog.i("ArkApp.Message", 2, "app_xml: " + paramString);
    }
    reset();
    if ((paramString == null) || (paramString.length() == 0)) {
      return false;
    }
    for (;;)
    {
      int i;
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
        this.mAppList = new ArrayList();
        this.mText = paramString.optString("text");
        this.mExtra = paramString.optString("extra");
        JSONArray localJSONArray = paramString.optJSONArray("extraApps");
        if ((localJSONArray != null) && (localJSONArray.length() != 0))
        {
          int j = localJSONArray.length();
          i = 0;
          if (i < j)
          {
            JSONObject localJSONObject = localJSONArray.optJSONObject(i);
            if (localJSONObject == null) {
              break label324;
            }
            ArkAppMessage localArkAppMessage = new ArkAppMessage();
            if (!localArkAppMessage.fromAppXml(localJSONObject.toString())) {
              break label324;
            }
            this.mAppList.add(localArkAppMessage);
          }
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return false;
      }
      this.mSourceAd = paramString.optString("sourceAd");
      return true;
      label324:
      i += 1;
    }
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
  
  public String getAppIdFromMeta()
  {
    if (TextUtils.isEmpty(this.metaList)) {
      return "";
    }
    try
    {
      Object localObject1 = new JSONObject(this.metaList);
      Iterator localIterator = ((JSONObject)localObject1).keys();
      while ((localIterator != null) && (localIterator.hasNext()))
      {
        Object localObject2 = (String)localIterator.next();
        if ("appid".equals(localObject2)) {
          return ((JSONObject)localObject1).optString("appid", "");
        }
        localObject2 = ((JSONObject)localObject1).opt((String)localObject2);
        if (((localObject2 instanceof JSONObject)) && (((JSONObject)localObject2).has("appid")))
        {
          localObject1 = ((JSONObject)localObject2).optString("appid", "");
          return localObject1;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("ArkApp.Message", 1, "arkMessage getAppIdFromMeta error : " + localException.getMessage());
      return "";
    }
    return "";
  }
  
  public String getFilterExtra()
  {
    try
    {
      Object localObject = new JSONObject(this.mExtra);
      ((JSONObject)localObject).remove("msg_seq");
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ArkApp.Message", 1, "JSONException", localJSONException);
    }
    return new JSONObject().toString();
  }
  
  public String getSummery()
  {
    if (!TextUtils.isEmpty(this.promptText)) {
      return this.promptText;
    }
    return BaseApplicationImpl.getApplication().getString(2131690124);
  }
  
  public long optMsgSeq()
  {
    if (TextUtils.isEmpty(this.mExtra)) {
      return -1L;
    }
    try
    {
      long l = new JSONObject(this.mExtra).optLong("msg_seq", -1L);
      return l;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ArkApp.Message", 1, "JSONException", localJSONException);
    }
    return -1L;
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
    //   0: new 96	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 260	org/json/JSONObject:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 51	com/tencent/mobileqq/data/ArkAppMessage:appName	Ljava/lang/String;
    //   12: ifnull +14 -> 26
    //   15: aload_1
    //   16: ldc 101
    //   18: aload_0
    //   19: getfield 51	com/tencent/mobileqq/data/ArkAppMessage:appName	Ljava/lang/String;
    //   22: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   25: pop
    //   26: aload_0
    //   27: getfield 49	com/tencent/mobileqq/data/ArkAppMessage:appDesc	Ljava/lang/String;
    //   30: ifnull +14 -> 44
    //   33: aload_1
    //   34: ldc 109
    //   36: aload_0
    //   37: getfield 49	com/tencent/mobileqq/data/ArkAppMessage:appDesc	Ljava/lang/String;
    //   40: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   43: pop
    //   44: aload_0
    //   45: getfield 53	com/tencent/mobileqq/data/ArkAppMessage:appView	Ljava/lang/String;
    //   48: ifnull +14 -> 62
    //   51: aload_1
    //   52: ldc 107
    //   54: aload_0
    //   55: getfield 53	com/tencent/mobileqq/data/ArkAppMessage:appView	Ljava/lang/String;
    //   58: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   61: pop
    //   62: aload_0
    //   63: getfield 55	com/tencent/mobileqq/data/ArkAppMessage:appMinVersion	Ljava/lang/String;
    //   66: ifnull +14 -> 80
    //   69: aload_1
    //   70: ldc 111
    //   72: aload_0
    //   73: getfield 55	com/tencent/mobileqq/data/ArkAppMessage:appMinVersion	Ljava/lang/String;
    //   76: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   79: pop
    //   80: aload_0
    //   81: getfield 47	com/tencent/mobileqq/data/ArkAppMessage:promptText	Ljava/lang/String;
    //   84: ifnull +14 -> 98
    //   87: aload_1
    //   88: ldc 113
    //   90: aload_0
    //   91: getfield 47	com/tencent/mobileqq/data/ArkAppMessage:promptText	Ljava/lang/String;
    //   94: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   97: pop
    //   98: aload_0
    //   99: getfield 123	com/tencent/mobileqq/data/ArkAppMessage:from	I
    //   102: ifeq +14 -> 116
    //   105: aload_1
    //   106: ldc 117
    //   108: aload_0
    //   109: getfield 123	com/tencent/mobileqq/data/ArkAppMessage:from	I
    //   112: invokevirtual 288	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   115: pop
    //   116: aload_0
    //   117: getfield 127	com/tencent/mobileqq/data/ArkAppMessage:appId	Ljava/lang/String;
    //   120: ifnull +14 -> 134
    //   123: aload_1
    //   124: ldc 125
    //   126: aload_0
    //   127: getfield 127	com/tencent/mobileqq/data/ArkAppMessage:appId	Ljava/lang/String;
    //   130: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   133: pop
    //   134: aload_0
    //   135: getfield 131	com/tencent/mobileqq/data/ArkAppMessage:mSourceName	Ljava/lang/String;
    //   138: ifnull +14 -> 152
    //   141: aload_1
    //   142: ldc 129
    //   144: aload_0
    //   145: getfield 131	com/tencent/mobileqq/data/ArkAppMessage:mSourceName	Ljava/lang/String;
    //   148: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   151: pop
    //   152: aload_0
    //   153: getfield 135	com/tencent/mobileqq/data/ArkAppMessage:mSourceActionData	Ljava/lang/String;
    //   156: ifnull +14 -> 170
    //   159: aload_1
    //   160: ldc 133
    //   162: aload_0
    //   163: getfield 135	com/tencent/mobileqq/data/ArkAppMessage:mSourceActionData	Ljava/lang/String;
    //   166: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   169: pop
    //   170: aload_0
    //   171: getfield 139	com/tencent/mobileqq/data/ArkAppMessage:mSource_A_ActionData	Ljava/lang/String;
    //   174: ifnull +14 -> 188
    //   177: aload_1
    //   178: ldc 137
    //   180: aload_0
    //   181: getfield 139	com/tencent/mobileqq/data/ArkAppMessage:mSource_A_ActionData	Ljava/lang/String;
    //   184: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   187: pop
    //   188: aload_0
    //   189: getfield 143	com/tencent/mobileqq/data/ArkAppMessage:mSourceUrl	Ljava/lang/String;
    //   192: ifnull +14 -> 206
    //   195: aload_1
    //   196: ldc 141
    //   198: aload_0
    //   199: getfield 143	com/tencent/mobileqq/data/ArkAppMessage:mSourceUrl	Ljava/lang/String;
    //   202: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   205: pop
    //   206: aload_0
    //   207: getfield 57	com/tencent/mobileqq/data/ArkAppMessage:metaList	Ljava/lang/String;
    //   210: astore_2
    //   211: aload_2
    //   212: ifnull +21 -> 233
    //   215: aload_1
    //   216: ldc 115
    //   218: new 96	org/json/JSONObject
    //   221: dup
    //   222: aload_0
    //   223: getfield 57	com/tencent/mobileqq/data/ArkAppMessage:metaList	Ljava/lang/String;
    //   226: invokespecial 99	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   229: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   232: pop
    //   233: aload_0
    //   234: getfield 59	com/tencent/mobileqq/data/ArkAppMessage:config	Ljava/lang/String;
    //   237: astore_2
    //   238: aload_2
    //   239: ifnull +21 -> 260
    //   242: aload_1
    //   243: ldc 116
    //   245: new 96	org/json/JSONObject
    //   248: dup
    //   249: aload_0
    //   250: getfield 59	com/tencent/mobileqq/data/ArkAppMessage:config	Ljava/lang/String;
    //   253: invokespecial 99	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   256: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   259: pop
    //   260: aload_0
    //   261: getfield 152	com/tencent/mobileqq/data/ArkAppMessage:mText	Ljava/lang/String;
    //   264: ifnull +14 -> 278
    //   267: aload_1
    //   268: ldc 150
    //   270: aload_0
    //   271: getfield 152	com/tencent/mobileqq/data/ArkAppMessage:mText	Ljava/lang/String;
    //   274: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   277: pop
    //   278: aload_0
    //   279: getfield 148	com/tencent/mobileqq/data/ArkAppMessage:mAppList	Ljava/util/List;
    //   282: astore_2
    //   283: aload_2
    //   284: ifnull +86 -> 370
    //   287: new 164	org/json/JSONArray
    //   290: dup
    //   291: invokespecial 289	org/json/JSONArray:<init>	()V
    //   294: astore_2
    //   295: aload_0
    //   296: getfield 148	com/tencent/mobileqq/data/ArkAppMessage:mAppList	Ljava/util/List;
    //   299: invokeinterface 292 1 0
    //   304: astore_3
    //   305: aload_3
    //   306: invokeinterface 220 1 0
    //   311: ifeq +179 -> 490
    //   314: aload_2
    //   315: new 96	org/json/JSONObject
    //   318: dup
    //   319: aload_3
    //   320: invokeinterface 223 1 0
    //   325: checkcast 2	com/tencent/mobileqq/data/ArkAppMessage
    //   328: invokevirtual 294	com/tencent/mobileqq/data/ArkAppMessage:toAppXml	()Ljava/lang/String;
    //   331: invokespecial 99	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   334: invokevirtual 297	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   337: pop
    //   338: goto -33 -> 305
    //   341: astore_2
    //   342: ldc 38
    //   344: new 73	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   351: ldc_w 299
    //   354: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: aload_2
    //   358: invokevirtual 243	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   361: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 305	com/tencent/mobileqq/ark/ArkAppCenter:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   370: aload_0
    //   371: getfield 186	com/tencent/mobileqq/data/ArkAppMessage:mSourceAd	Ljava/lang/String;
    //   374: ifnull +14 -> 388
    //   377: aload_1
    //   378: ldc 184
    //   380: aload_0
    //   381: getfield 186	com/tencent/mobileqq/data/ArkAppMessage:mSourceAd	Ljava/lang/String;
    //   384: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   387: pop
    //   388: aload_0
    //   389: getfield 156	com/tencent/mobileqq/data/ArkAppMessage:mExtra	Ljava/lang/String;
    //   392: ifnull +14 -> 406
    //   395: aload_1
    //   396: ldc 154
    //   398: aload_0
    //   399: getfield 156	com/tencent/mobileqq/data/ArkAppMessage:mExtra	Ljava/lang/String;
    //   402: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   405: pop
    //   406: aload_1
    //   407: invokevirtual 171	org/json/JSONObject:toString	()Ljava/lang/String;
    //   410: areturn
    //   411: astore_2
    //   412: ldc 38
    //   414: new 73	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   421: ldc_w 307
    //   424: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload_2
    //   428: invokevirtual 243	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   431: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 305	com/tencent/mobileqq/ark/ArkAppCenter:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   440: goto -207 -> 233
    //   443: astore_1
    //   444: aload_1
    //   445: invokevirtual 308	org/json/JSONException:printStackTrace	()V
    //   448: aconst_null
    //   449: areturn
    //   450: astore_2
    //   451: ldc 38
    //   453: new 73	java/lang/StringBuilder
    //   456: dup
    //   457: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   460: ldc_w 299
    //   463: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: aload_2
    //   467: invokevirtual 243	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   470: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokestatic 305	com/tencent/mobileqq/ark/ArkAppCenter:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   479: goto -219 -> 260
    //   482: astore_1
    //   483: aload_1
    //   484: invokevirtual 182	java/lang/Exception:printStackTrace	()V
    //   487: goto -39 -> 448
    //   490: aload_1
    //   491: ldc 158
    //   493: aload_2
    //   494: invokevirtual 285	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   497: pop
    //   498: goto -128 -> 370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	501	0	this	ArkAppMessage
    //   7	400	1	localJSONObject	JSONObject
    //   443	2	1	localJSONException	JSONException
    //   482	9	1	localException1	Exception
    //   210	105	2	localObject	Object
    //   341	17	2	localException2	Exception
    //   411	17	2	localException3	Exception
    //   450	44	2	localException4	Exception
    //   304	16	3	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   287	305	341	java/lang/Exception
    //   305	338	341	java/lang/Exception
    //   490	498	341	java/lang/Exception
    //   215	233	411	java/lang/Exception
    //   0	26	443	org/json/JSONException
    //   26	44	443	org/json/JSONException
    //   44	62	443	org/json/JSONException
    //   62	80	443	org/json/JSONException
    //   80	98	443	org/json/JSONException
    //   98	116	443	org/json/JSONException
    //   116	134	443	org/json/JSONException
    //   134	152	443	org/json/JSONException
    //   152	170	443	org/json/JSONException
    //   170	188	443	org/json/JSONException
    //   188	206	443	org/json/JSONException
    //   206	211	443	org/json/JSONException
    //   215	233	443	org/json/JSONException
    //   233	238	443	org/json/JSONException
    //   242	260	443	org/json/JSONException
    //   260	278	443	org/json/JSONException
    //   278	283	443	org/json/JSONException
    //   287	305	443	org/json/JSONException
    //   305	338	443	org/json/JSONException
    //   342	370	443	org/json/JSONException
    //   370	388	443	org/json/JSONException
    //   388	406	443	org/json/JSONException
    //   406	411	443	org/json/JSONException
    //   412	440	443	org/json/JSONException
    //   451	479	443	org/json/JSONException
    //   490	498	443	org/json/JSONException
    //   242	260	450	java/lang/Exception
    //   0	26	482	java/lang/Exception
    //   26	44	482	java/lang/Exception
    //   44	62	482	java/lang/Exception
    //   62	80	482	java/lang/Exception
    //   80	98	482	java/lang/Exception
    //   98	116	482	java/lang/Exception
    //   116	134	482	java/lang/Exception
    //   134	152	482	java/lang/Exception
    //   152	170	482	java/lang/Exception
    //   170	188	482	java/lang/Exception
    //   188	206	482	java/lang/Exception
    //   206	211	482	java/lang/Exception
    //   233	238	482	java/lang/Exception
    //   260	278	482	java/lang/Exception
    //   278	283	482	java/lang/Exception
    //   342	370	482	java/lang/Exception
    //   370	388	482	java/lang/Exception
    //   388	406	482	java/lang/Exception
    //   406	411	482	java/lang/Exception
    //   412	440	482	java/lang/Exception
    //   451	479	482	java/lang/Exception
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
  
  public JSONObject toShareMsgJSONObject()
  {
    localJSONObject = new JSONObject();
    try
    {
      if (this.appName != null) {
        localJSONObject.put("forward_ark_app_name", this.appName);
      }
      if (this.appDesc != null) {
        localJSONObject.put("forward_ark_app_desc", this.appDesc);
      }
      if (this.appView != null) {
        localJSONObject.put("forward_ark_app_view", this.appView);
      }
      if (this.appMinVersion != null) {
        localJSONObject.put("forward_ark_app_ver", this.appMinVersion);
      }
      if (this.promptText != null) {
        localJSONObject.put("forward_ark_app_prompt", this.promptText);
      }
      String str = this.metaList;
      if (str != null) {}
      try
      {
        localJSONObject.put("forward_ark_app_meta", new JSONObject(this.metaList));
        str = this.config;
        if (str == null) {}
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            localJSONObject.put("forward_ark_app_config", new JSONObject(this.config));
            return localJSONObject;
          }
          catch (Exception localException2)
          {
            QLog.e("ArkApp.Message", 1, "toShareMsgJSONObject fail, config, err=", localException2);
          }
          localException1 = localException1;
          QLog.e("ArkApp.Message", 1, "toShareMsgJSONObject fail, metaList, err=", localException1);
        }
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ArkApp.Message", 1, "toShareMsgJSONObject fail, err=", localJSONException);
      return localJSONObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.ArkAppMessage
 * JD-Core Version:    0.7.0.1
 */