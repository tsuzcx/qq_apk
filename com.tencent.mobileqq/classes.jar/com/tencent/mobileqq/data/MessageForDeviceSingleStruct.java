package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.service.message.MessageCache;

public class MessageForDeviceSingleStruct
  extends ChatMessage
{
  public static final int DATATYPE_SINGLESTRUCT_PIC = 1;
  public static final int DATATYPE_SINGLESTRUCT_VIDEO = 2;
  private static final String TAG = "MessageForDeviceSingleStruct";
  public long entityID;
  public String ext = "";
  public String faceRect = "";
  public long nAppearTime = MessageCache.a();
  public int nCoverChannelType = 0;
  public long nCoverSessionID = 0L;
  public int nDataType = 1;
  public int nMediaChannelType = 0;
  public long nMediaFileSize = 0L;
  public int nMediaFileStatus = 1;
  public float nMediaProgress = 0.0F;
  public long nMediaSessionID = 0L;
  public String strCoverKey = "";
  public String strCoverKey2;
  public String strCoverMD5 = "";
  public String strCoverPath = "";
  public String strDigest = "";
  public String strFileKey2;
  public String strGuideWords = "";
  public String strMediaFileName = "";
  public String strMediaKey = "";
  public String strMediaPath = "";
  public String strTitle = "";
  public String url = "";
  
  protected void doParse()
  {
    try
    {
      MessageForDeviceSingleStruct.SingleStructMsgSerial localSingleStructMsgSerial = (MessageForDeviceSingleStruct.SingleStructMsgSerial)MessagePkgUtils.a(this.msgData);
      if (localSingleStructMsgSerial != null)
      {
        this.nDataType = localSingleStructMsgSerial.nDataType;
        this.strTitle = localSingleStructMsgSerial.strTitle;
        this.nAppearTime = localSingleStructMsgSerial.nAppearTime;
        this.strDigest = localSingleStructMsgSerial.strDigest;
        this.strGuideWords = localSingleStructMsgSerial.strGuideWords;
        this.nCoverSessionID = localSingleStructMsgSerial.nCoverSessionID;
        this.strCoverPath = localSingleStructMsgSerial.strCoverPath;
        this.nMediaSessionID = localSingleStructMsgSerial.nMediaSessionID;
        this.strMediaPath = localSingleStructMsgSerial.strMediaPath;
        this.nMediaFileStatus = localSingleStructMsgSerial.nMediaFileStatus;
        this.nMediaProgress = localSingleStructMsgSerial.nMediaProgress;
        this.strMediaFileName = localSingleStructMsgSerial.strMediaFileName;
        this.nMediaFileSize = localSingleStructMsgSerial.nMediaFileSize;
        this.strCoverMD5 = localSingleStructMsgSerial.strCoverMD5;
        this.nMediaChannelType = localSingleStructMsgSerial.nMediaChannelType;
        this.nCoverChannelType = localSingleStructMsgSerial.nCoverChannelType;
        this.strMediaKey = localSingleStructMsgSerial.strMediaKey;
        this.strCoverKey = localSingleStructMsgSerial.strCoverKey;
        this.strFileKey2 = localSingleStructMsgSerial.strFileKey2;
        this.strCoverKey2 = localSingleStructMsgSerial.strCoverKey2;
        this.ext = localSingleStructMsgSerial.ext;
        this.msg = localSingleStructMsgSerial.strRecentMsg;
        this.faceRect = localSingleStructMsgSerial.faceRect;
        this.url = localSingleStructMsgSerial.url;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject = null;
      }
    }
  }
  
  /* Error */
  public boolean parseFromJson(String paramString)
  {
    // Byte code:
    //   0: new 150	org/json/JSONObject
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 153	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_0
    //   10: aload_1
    //   11: ldc 155
    //   13: invokestatic 55	com/tencent/mobileqq/service/message/MessageCache:a	()J
    //   16: invokevirtual 159	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   19: putfield 162	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:time	J
    //   22: aload_0
    //   23: aload_1
    //   24: ldc 164
    //   26: ldc 166
    //   28: invokevirtual 170	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   31: putfield 49	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:strTitle	Ljava/lang/String;
    //   34: aload_1
    //   35: ldc 172
    //   37: ldc 47
    //   39: invokevirtual 170	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   42: astore_2
    //   43: aload_0
    //   44: iconst_1
    //   45: putfield 45	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:nDataType	I
    //   48: aload_2
    //   49: ldc 174
    //   51: invokevirtual 180	java/lang/String:compareToIgnoreCase	(Ljava/lang/String;)I
    //   54: ifne +316 -> 370
    //   57: aload_0
    //   58: iconst_1
    //   59: putfield 45	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:nDataType	I
    //   62: aload_0
    //   63: aload_1
    //   64: ldc 182
    //   66: invokestatic 55	com/tencent/mobileqq/service/message/MessageCache:a	()J
    //   69: invokevirtual 159	org/json/JSONObject:optLong	(Ljava/lang/String;J)J
    //   72: putfield 57	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:nAppearTime	J
    //   75: aload_0
    //   76: aload_1
    //   77: ldc 184
    //   79: ldc 47
    //   81: invokevirtual 170	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   84: putfield 59	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:strDigest	Ljava/lang/String;
    //   87: aload_0
    //   88: aload_1
    //   89: ldc 186
    //   91: ldc 47
    //   93: invokevirtual 170	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   96: putfield 61	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:strGuideWords	Ljava/lang/String;
    //   99: aload_1
    //   100: ldc 188
    //   102: ldc 47
    //   104: invokevirtual 170	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   107: astore_2
    //   108: aload_2
    //   109: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   112: ifne +13 -> 125
    //   115: aload_0
    //   116: aload_2
    //   117: putfield 87	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:strCoverKey	Ljava/lang/String;
    //   120: aload_0
    //   121: iconst_1
    //   122: putfield 83	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:nCoverChannelType	I
    //   125: aload_1
    //   126: ldc 196
    //   128: ldc 47
    //   130: invokevirtual 170	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   133: astore_2
    //   134: aload_2
    //   135: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   138: ifne +13 -> 151
    //   141: aload_0
    //   142: aload_2
    //   143: putfield 85	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:strMediaKey	Ljava/lang/String;
    //   146: aload_0
    //   147: iconst_1
    //   148: putfield 81	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:nMediaChannelType	I
    //   151: aload_1
    //   152: ldc 198
    //   154: ldc 47
    //   156: invokevirtual 170	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   159: astore_2
    //   160: aload_2
    //   161: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   164: ifne +13 -> 177
    //   167: aload_0
    //   168: aload_2
    //   169: putfield 87	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:strCoverKey	Ljava/lang/String;
    //   172: aload_0
    //   173: iconst_2
    //   174: putfield 83	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:nCoverChannelType	I
    //   177: aload_1
    //   178: ldc 200
    //   180: ldc 47
    //   182: invokevirtual 170	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   185: astore_2
    //   186: aload_2
    //   187: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   190: ifne +13 -> 203
    //   193: aload_0
    //   194: aload_2
    //   195: putfield 85	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:strMediaKey	Ljava/lang/String;
    //   198: aload_0
    //   199: iconst_2
    //   200: putfield 81	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:nMediaChannelType	I
    //   203: aload_1
    //   204: ldc 202
    //   206: ldc 47
    //   208: invokevirtual 170	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   211: astore_2
    //   212: aload_2
    //   213: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   216: ifne +34 -> 250
    //   219: aload_0
    //   220: aload_2
    //   221: putfield 87	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:strCoverKey	Ljava/lang/String;
    //   224: aload_0
    //   225: iconst_3
    //   226: putfield 83	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:nCoverChannelType	I
    //   229: aload_1
    //   230: ldc 204
    //   232: ldc 47
    //   234: invokevirtual 170	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   237: astore_2
    //   238: aload_2
    //   239: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   242: ifne +8 -> 250
    //   245: aload_0
    //   246: aload_2
    //   247: putfield 132	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:strCoverKey2	Ljava/lang/String;
    //   250: aload_1
    //   251: ldc 206
    //   253: ldc 47
    //   255: invokevirtual 170	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   258: astore_2
    //   259: aload_2
    //   260: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   263: ifne +34 -> 297
    //   266: aload_0
    //   267: aload_2
    //   268: putfield 85	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:strMediaKey	Ljava/lang/String;
    //   271: aload_0
    //   272: iconst_3
    //   273: putfield 81	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:nMediaChannelType	I
    //   276: aload_1
    //   277: ldc 208
    //   279: ldc 47
    //   281: invokevirtual 170	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   284: astore_2
    //   285: aload_2
    //   286: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   289: ifne +8 -> 297
    //   292: aload_0
    //   293: aload_2
    //   294: putfield 129	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:strFileKey2	Ljava/lang/String;
    //   297: aload_1
    //   298: ldc 210
    //   300: invokevirtual 214	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   303: astore_2
    //   304: aload_2
    //   305: ifnull +39 -> 344
    //   308: aload_2
    //   309: invokevirtual 220	org/json/JSONArray:length	()I
    //   312: ifle +32 -> 344
    //   315: aload_2
    //   316: iconst_0
    //   317: invokevirtual 224	org/json/JSONArray:isNull	(I)Z
    //   320: ifne +24 -> 344
    //   323: aload_2
    //   324: iconst_0
    //   325: invokevirtual 228	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   328: invokevirtual 232	org/json/JSONObject:toString	()Ljava/lang/String;
    //   331: astore_2
    //   332: aload_2
    //   333: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   336: ifne +8 -> 344
    //   339: aload_0
    //   340: aload_2
    //   341: putfield 89	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:faceRect	Ljava/lang/String;
    //   344: aload_0
    //   345: aload_1
    //   346: ldc 233
    //   348: ldc 47
    //   350: invokevirtual 170	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   353: putfield 91	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:url	Ljava/lang/String;
    //   356: aload_0
    //   357: aload_1
    //   358: ldc 234
    //   360: ldc 47
    //   362: invokevirtual 170	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   365: putfield 93	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:ext	Ljava/lang/String;
    //   368: iconst_1
    //   369: ireturn
    //   370: aload_2
    //   371: ldc 236
    //   373: invokevirtual 180	java/lang/String:compareToIgnoreCase	(Ljava/lang/String;)I
    //   376: ifne -314 -> 62
    //   379: aload_0
    //   380: iconst_2
    //   381: putfield 45	com/tencent/mobileqq/data/MessageForDeviceSingleStruct:nDataType	I
    //   384: goto -322 -> 62
    //   387: astore_1
    //   388: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   391: ifeq +31 -> 422
    //   394: ldc 13
    //   396: iconst_2
    //   397: new 244	java/lang/StringBuilder
    //   400: dup
    //   401: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   404: ldc 247
    //   406: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: aload_1
    //   410: invokevirtual 254	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   413: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   419: invokestatic 259	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   422: iconst_0
    //   423: ireturn
    //   424: astore_1
    //   425: invokestatic 242	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   428: ifeq -6 -> 422
    //   431: ldc 13
    //   433: iconst_2
    //   434: new 244	java/lang/StringBuilder
    //   437: dup
    //   438: invokespecial 245	java/lang/StringBuilder:<init>	()V
    //   441: ldc_w 261
    //   444: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: aload_1
    //   448: invokevirtual 262	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   451: invokevirtual 251	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: invokevirtual 255	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   457: invokestatic 259	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   460: goto -38 -> 422
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	463	0	this	MessageForDeviceSingleStruct
    //   0	463	1	paramString	String
    //   42	329	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	62	387	org/json/JSONException
    //   62	125	387	org/json/JSONException
    //   125	151	387	org/json/JSONException
    //   151	177	387	org/json/JSONException
    //   177	203	387	org/json/JSONException
    //   203	250	387	org/json/JSONException
    //   250	297	387	org/json/JSONException
    //   297	304	387	org/json/JSONException
    //   308	344	387	org/json/JSONException
    //   344	368	387	org/json/JSONException
    //   370	384	387	org/json/JSONException
    //   0	62	424	java/lang/Exception
    //   62	125	424	java/lang/Exception
    //   125	151	424	java/lang/Exception
    //   151	177	424	java/lang/Exception
    //   177	203	424	java/lang/Exception
    //   203	250	424	java/lang/Exception
    //   250	297	424	java/lang/Exception
    //   297	304	424	java/lang/Exception
    //   308	344	424	java/lang/Exception
    //   344	368	424	java/lang/Exception
    //   370	384	424	java/lang/Exception
  }
  
  protected void postRead()
  {
    parse();
  }
  
  protected void prewrite()
  {
    serial();
  }
  
  public void serial()
  {
    MessageForDeviceSingleStruct.SingleStructMsgSerial localSingleStructMsgSerial = new MessageForDeviceSingleStruct.SingleStructMsgSerial(null);
    localSingleStructMsgSerial.nDataType = this.nDataType;
    localSingleStructMsgSerial.strTitle = this.strTitle;
    localSingleStructMsgSerial.nAppearTime = this.nAppearTime;
    localSingleStructMsgSerial.strDigest = this.strDigest;
    localSingleStructMsgSerial.strGuideWords = this.strGuideWords;
    localSingleStructMsgSerial.nCoverSessionID = this.nCoverSessionID;
    localSingleStructMsgSerial.strMediaKey = this.strMediaKey;
    localSingleStructMsgSerial.strCoverPath = this.strCoverPath;
    localSingleStructMsgSerial.strFileKey2 = this.strFileKey2;
    localSingleStructMsgSerial.strCoverKey2 = this.strCoverKey2;
    localSingleStructMsgSerial.nMediaSessionID = this.nMediaSessionID;
    localSingleStructMsgSerial.strCoverKey = this.strCoverKey;
    localSingleStructMsgSerial.strMediaPath = this.strMediaPath;
    localSingleStructMsgSerial.nMediaFileStatus = this.nMediaFileStatus;
    localSingleStructMsgSerial.nMediaProgress = this.nMediaProgress;
    localSingleStructMsgSerial.strMediaFileName = this.strMediaFileName;
    localSingleStructMsgSerial.nMediaFileSize = this.nMediaFileSize;
    localSingleStructMsgSerial.strCoverMD5 = this.strCoverMD5;
    localSingleStructMsgSerial.nMediaChannelType = this.nMediaChannelType;
    localSingleStructMsgSerial.nCoverChannelType = this.nCoverChannelType;
    localSingleStructMsgSerial.strRecentMsg = this.msg;
    localSingleStructMsgSerial.faceRect = this.faceRect;
    localSingleStructMsgSerial.url = this.url;
    localSingleStructMsgSerial.ext = this.ext;
    try
    {
      this.msgData = MessagePkgUtils.a(localSingleStructMsgSerial);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForDeviceSingleStruct
 * JD-Core Version:    0.7.0.1
 */