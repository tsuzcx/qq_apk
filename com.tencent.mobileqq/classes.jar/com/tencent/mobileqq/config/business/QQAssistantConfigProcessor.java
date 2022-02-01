package com.tencent.mobileqq.config.business;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QQAssistantConfigProcessor
  extends IQConfigProcessor<QQAssistantConfigProcessor.QAssistantConfigContent>
{
  private boolean a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null) {
      return false;
    }
    try
    {
      boolean bool = paramJSONObject.has("manufacturer");
      String str;
      if (bool)
      {
        str = paramJSONObject.getString("manufacturer");
        if ((str != null) && (!"".equals(str)) && (!Build.MANUFACTURER.equals(str))) {
          return false;
        }
      }
      if (paramJSONObject.has("brand"))
      {
        str = paramJSONObject.getString("brand");
        if ((str != null) && (!"".equals(str)) && (!Build.BRAND.equals(str))) {
          return false;
        }
      }
      if (paramJSONObject.has("model"))
      {
        str = paramJSONObject.getString("model");
        if ((str != null) && (!"".equals(str)) && (!Build.MODEL.equals(str))) {
          return false;
        }
      }
      if (paramJSONObject.has("fingerprint"))
      {
        str = paramJSONObject.getString("fingerprint");
        if ((str != null) && (!"".equals(str)) && (!Build.FINGERPRINT.equals(str))) {
          return false;
        }
      }
      if (paramJSONObject.has("androidId"))
      {
        paramJSONObject = paramJSONObject.getString("androidId");
        if ((paramJSONObject != null) && (!"".equals(paramJSONObject)) && (!"".equals(paramString)))
        {
          bool = paramString.equals(paramJSONObject);
          if (!bool) {
            return false;
          }
        }
      }
      return true;
    }
    catch (Exception paramJSONObject) {}
    return false;
  }
  
  @NonNull
  public QQAssistantConfigProcessor.QAssistantConfigContent a(int paramInt)
  {
    return new QQAssistantConfigProcessor.QAssistantConfigContent();
  }
  
  @Nullable
  public QQAssistantConfigProcessor.QAssistantConfigContent a(QConfItem[] paramArrayOfQConfItem)
  {
    QQAssistantConfigProcessor.QAssistantConfigContent localQAssistantConfigContent = new QQAssistantConfigProcessor.QAssistantConfigContent();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onParsed confFiles.length = ");
      localStringBuilder.append(paramArrayOfQConfItem.length);
      QLog.d("QQAssistantConfigProcessor", 2, localStringBuilder.toString());
    }
    if (paramArrayOfQConfItem.length > 0)
    {
      paramArrayOfQConfItem = paramArrayOfQConfItem[0];
      localQAssistantConfigContent.a = paramArrayOfQConfItem.a;
      localQAssistantConfigContent.b = paramArrayOfQConfItem.b;
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfQConfItem = new StringBuilder();
      paramArrayOfQConfItem.append("onParsed taskId = ");
      paramArrayOfQConfItem.append(localQAssistantConfigContent.a);
      paramArrayOfQConfItem.append(" | content = ");
      paramArrayOfQConfItem.append(localQAssistantConfigContent.b);
      QLog.d("QQAssistantConfigProcessor", 2, paramArrayOfQConfItem.toString());
    }
    return localQAssistantConfigContent;
  }
  
  /* Error */
  public void a(QQAssistantConfigProcessor.QAssistantConfigContent paramQAssistantConfigContent)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +912 -> 913
    //   4: aload_1
    //   5: getfield 103	com/tencent/mobileqq/config/business/QQAssistantConfigProcessor$QAssistantConfigContent:b	Ljava/lang/String;
    //   8: ifnull +905 -> 913
    //   11: aload_1
    //   12: getfield 103	com/tencent/mobileqq/config/business/QQAssistantConfigProcessor$QAssistantConfigContent:b	Ljava/lang/String;
    //   15: astore 4
    //   17: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +41 -> 61
    //   23: new 73	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   30: astore 4
    //   32: aload 4
    //   34: ldc 112
    //   36: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 4
    //   42: aload_1
    //   43: getfield 103	com/tencent/mobileqq/config/business/QQAssistantConfigProcessor$QAssistantConfigContent:b	Ljava/lang/String;
    //   46: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: ldc 85
    //   52: iconst_2
    //   53: aload 4
    //   55: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 93	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: new 18	org/json/JSONObject
    //   64: dup
    //   65: aload_1
    //   66: getfield 103	com/tencent/mobileqq/config/business/QQAssistantConfigProcessor$QAssistantConfigContent:b	Ljava/lang/String;
    //   69: invokespecial 115	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   72: astore 5
    //   74: getstatic 121	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   77: ldc 123
    //   79: iconst_4
    //   80: invokevirtual 127	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   83: invokeinterface 133 1 0
    //   88: astore 4
    //   90: invokestatic 138	com/tencent/mobileqq/utils/DeviceInfoUtil:j	()Ljava/lang/String;
    //   93: astore 6
    //   95: new 73	java/lang/StringBuilder
    //   98: dup
    //   99: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   102: astore_1
    //   103: aload_1
    //   104: ldc 140
    //   106: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_1
    //   111: getstatic 40	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   114: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: pop
    //   118: aload_1
    //   119: ldc 142
    //   121: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: pop
    //   125: aload_1
    //   126: getstatic 45	android/os/Build:BRAND	Ljava/lang/String;
    //   129: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: pop
    //   133: aload_1
    //   134: ldc 144
    //   136: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: pop
    //   140: aload_1
    //   141: getstatic 50	android/os/Build:MODEL	Ljava/lang/String;
    //   144: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload_1
    //   149: ldc 146
    //   151: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: pop
    //   155: aload_1
    //   156: getstatic 55	android/os/Build:FINGERPRINT	Ljava/lang/String;
    //   159: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload_1
    //   164: ldc 148
    //   166: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_1
    //   171: aload 6
    //   173: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: ldc 150
    //   179: aload_1
    //   180: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 155	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: aload 5
    //   188: ldc 157
    //   190: invokevirtual 22	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   193: ifeq +753 -> 946
    //   196: aload 5
    //   198: ldc 157
    //   200: invokevirtual 161	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   203: astore_1
    //   204: iconst_0
    //   205: istore_2
    //   206: iload_2
    //   207: aload_1
    //   208: invokevirtual 167	org/json/JSONArray:length	()I
    //   211: if_icmpge +39 -> 250
    //   214: aload_1
    //   215: iload_2
    //   216: invokevirtual 171	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   219: astore 7
    //   221: aload_0
    //   222: aload 7
    //   224: aload 6
    //   226: invokespecial 173	com/tencent/mobileqq/config/business/QQAssistantConfigProcessor:a	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   229: istore_3
    //   230: iload_3
    //   231: ifeq +8 -> 239
    //   234: iconst_1
    //   235: istore_3
    //   236: goto +60 -> 296
    //   239: iload_2
    //   240: iconst_1
    //   241: iadd
    //   242: istore_2
    //   243: goto -37 -> 206
    //   246: astore_1
    //   247: goto +9 -> 256
    //   250: iconst_0
    //   251: istore_3
    //   252: goto +44 -> 296
    //   255: astore_1
    //   256: new 73	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   263: astore 6
    //   265: aload 6
    //   267: ldc 175
    //   269: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 6
    //   275: aload_1
    //   276: invokevirtual 178	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   279: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: ldc 150
    //   285: aload 6
    //   287: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokestatic 155	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   293: goto -43 -> 250
    //   296: new 73	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   303: astore_1
    //   304: aload_1
    //   305: ldc 180
    //   307: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload_1
    //   312: iload_3
    //   313: invokevirtual 183	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: ldc 150
    //   319: aload_1
    //   320: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 155	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   326: aload 4
    //   328: ldc 157
    //   330: iload_3
    //   331: invokeinterface 189 3 0
    //   336: pop
    //   337: invokestatic 194	com/tencent/mobileqq/qassistant/wake/WakeManager:a	()Lcom/tencent/mobileqq/qassistant/wake/WakeManager;
    //   340: iload_3
    //   341: putfield 198	com/tencent/mobileqq/qassistant/wake/WakeManager:e	Z
    //   344: goto +3 -> 347
    //   347: aload 5
    //   349: ldc 200
    //   351: invokevirtual 22	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   354: ifeq +91 -> 445
    //   357: aload 5
    //   359: ldc 200
    //   361: invokevirtual 203	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   364: istore_3
    //   365: new 73	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   372: astore_1
    //   373: aload_1
    //   374: ldc 205
    //   376: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: pop
    //   380: aload_1
    //   381: iload_3
    //   382: invokevirtual 183	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: ldc 150
    //   388: aload_1
    //   389: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 155	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   395: aload 4
    //   397: invokestatic 208	com/tencent/mobileqq/qassistant/wake/WakeManager:i	()Ljava/lang/String;
    //   400: iload_3
    //   401: invokeinterface 189 3 0
    //   406: pop
    //   407: invokestatic 194	com/tencent/mobileqq/qassistant/wake/WakeManager:a	()Lcom/tencent/mobileqq/qassistant/wake/WakeManager;
    //   410: iload_3
    //   411: putfield 210	com/tencent/mobileqq/qassistant/wake/WakeManager:d	Z
    //   414: invokestatic 194	com/tencent/mobileqq/qassistant/wake/WakeManager:a	()Lcom/tencent/mobileqq/qassistant/wake/WakeManager;
    //   417: invokevirtual 213	com/tencent/mobileqq/qassistant/wake/WakeManager:h	()Z
    //   420: ifeq +25 -> 445
    //   423: invokestatic 216	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	()Lcom/tencent/mobileqq/qassistant/api/IVoiceAssistantCore;
    //   426: astore_1
    //   427: aload_1
    //   428: ifnull +9 -> 437
    //   431: aload_1
    //   432: invokeinterface 221 1 0
    //   437: invokestatic 194	com/tencent/mobileqq/qassistant/wake/WakeManager:a	()Lcom/tencent/mobileqq/qassistant/wake/WakeManager;
    //   440: ldc 223
    //   442: invokevirtual 225	com/tencent/mobileqq/qassistant/wake/WakeManager:a	(Ljava/lang/String;)V
    //   445: aload 5
    //   447: ldc 227
    //   449: invokevirtual 22	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   452: ifeq +56 -> 508
    //   455: aload 5
    //   457: ldc 227
    //   459: invokevirtual 26	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   462: astore_1
    //   463: new 73	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   470: astore 6
    //   472: aload 6
    //   474: ldc 229
    //   476: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: pop
    //   480: aload 6
    //   482: aload_1
    //   483: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: ldc 150
    //   489: aload 6
    //   491: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   494: invokestatic 155	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   497: aload 4
    //   499: ldc 227
    //   501: aload_1
    //   502: invokeinterface 233 3 0
    //   507: pop
    //   508: aload 5
    //   510: ldc 235
    //   512: invokevirtual 22	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   515: ifeq +56 -> 571
    //   518: aload 5
    //   520: ldc 235
    //   522: invokevirtual 26	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   525: astore_1
    //   526: new 73	java/lang/StringBuilder
    //   529: dup
    //   530: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   533: astore 6
    //   535: aload 6
    //   537: ldc 237
    //   539: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: aload 6
    //   545: aload_1
    //   546: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: ldc 150
    //   552: aload 6
    //   554: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: invokestatic 155	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   560: aload 4
    //   562: ldc 235
    //   564: aload_1
    //   565: invokeinterface 233 3 0
    //   570: pop
    //   571: aload 5
    //   573: ldc 239
    //   575: invokevirtual 22	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   578: ifeq +56 -> 634
    //   581: aload 5
    //   583: ldc 239
    //   585: invokevirtual 26	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   588: astore_1
    //   589: new 73	java/lang/StringBuilder
    //   592: dup
    //   593: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   596: astore 6
    //   598: aload 6
    //   600: ldc 241
    //   602: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: pop
    //   606: aload 6
    //   608: aload_1
    //   609: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: ldc 150
    //   615: aload 6
    //   617: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: invokestatic 155	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   623: aload 4
    //   625: ldc 239
    //   627: aload_1
    //   628: invokeinterface 233 3 0
    //   633: pop
    //   634: aload 5
    //   636: ldc 243
    //   638: invokevirtual 22	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   641: ifeq +56 -> 697
    //   644: aload 5
    //   646: ldc 243
    //   648: invokevirtual 26	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   651: astore_1
    //   652: new 73	java/lang/StringBuilder
    //   655: dup
    //   656: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   659: astore 6
    //   661: aload 6
    //   663: ldc 245
    //   665: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: pop
    //   669: aload 6
    //   671: aload_1
    //   672: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: pop
    //   676: ldc 150
    //   678: aload 6
    //   680: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   683: invokestatic 155	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   686: aload 4
    //   688: ldc 243
    //   690: aload_1
    //   691: invokeinterface 233 3 0
    //   696: pop
    //   697: aload 5
    //   699: ldc 247
    //   701: invokevirtual 22	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   704: ifeq +61 -> 765
    //   707: aload 5
    //   709: ldc 247
    //   711: invokevirtual 26	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   714: astore_1
    //   715: new 73	java/lang/StringBuilder
    //   718: dup
    //   719: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   722: astore 6
    //   724: aload 6
    //   726: ldc 249
    //   728: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: pop
    //   732: aload 6
    //   734: aload_1
    //   735: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: pop
    //   739: ldc 150
    //   741: aload 6
    //   743: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   746: invokestatic 155	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   749: aload_1
    //   750: invokestatic 254	com/tencent/mobileqq/qassistant/core/FriendSortHelper:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/qassistant/config/FriendSortConfig;
    //   753: pop
    //   754: aload 4
    //   756: ldc 247
    //   758: aload_1
    //   759: invokeinterface 233 3 0
    //   764: pop
    //   765: aload 5
    //   767: ldc_w 256
    //   770: invokevirtual 22	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   773: ifeq +63 -> 836
    //   776: aload 5
    //   778: ldc_w 256
    //   781: invokevirtual 26	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   784: astore_1
    //   785: new 73	java/lang/StringBuilder
    //   788: dup
    //   789: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   792: astore 5
    //   794: aload 5
    //   796: ldc_w 258
    //   799: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: pop
    //   803: aload 5
    //   805: aload_1
    //   806: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: pop
    //   810: ldc 150
    //   812: aload 5
    //   814: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   817: invokestatic 155	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   820: aload_1
    //   821: invokestatic 261	com/tencent/mobileqq/qassistant/core/FriendSortHelper:c	(Ljava/lang/String;)V
    //   824: aload 4
    //   826: ldc_w 256
    //   829: aload_1
    //   830: invokeinterface 233 3 0
    //   835: pop
    //   836: aload 4
    //   838: invokeinterface 264 1 0
    //   843: return
    //   844: astore_1
    //   845: goto +4 -> 849
    //   848: astore_1
    //   849: aload_1
    //   850: invokevirtual 267	org/json/JSONException:printStackTrace	()V
    //   853: new 73	java/lang/StringBuilder
    //   856: dup
    //   857: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   860: astore 4
    //   862: aload 4
    //   864: ldc_w 269
    //   867: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: pop
    //   871: aload 4
    //   873: aload_1
    //   874: invokevirtual 270	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   877: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: pop
    //   881: ldc 85
    //   883: iconst_2
    //   884: aload 4
    //   886: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   889: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   892: return
    //   893: astore_1
    //   894: goto +4 -> 898
    //   897: astore_1
    //   898: aload_1
    //   899: invokevirtual 273	java/lang/Exception:printStackTrace	()V
    //   902: ldc 85
    //   904: iconst_2
    //   905: ldc_w 275
    //   908: aload_1
    //   909: invokestatic 278	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   912: return
    //   913: new 73	java/lang/StringBuilder
    //   916: dup
    //   917: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   920: astore_1
    //   921: aload_1
    //   922: ldc_w 280
    //   925: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: pop
    //   929: aload_1
    //   930: aconst_null
    //   931: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   934: pop
    //   935: ldc 85
    //   937: iconst_2
    //   938: aload_1
    //   939: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   942: invokestatic 272	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   945: return
    //   946: goto -599 -> 347
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	949	0	this	QQAssistantConfigProcessor
    //   0	949	1	paramQAssistantConfigContent	QQAssistantConfigProcessor.QAssistantConfigContent
    //   205	38	2	i	int
    //   229	182	3	bool	boolean
    //   15	870	4	localObject1	java.lang.Object
    //   72	741	5	localObject2	java.lang.Object
    //   93	649	6	localObject3	java.lang.Object
    //   219	4	7	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   221	230	246	java/lang/Exception
    //   206	221	255	java/lang/Exception
    //   221	230	844	org/json/JSONException
    //   256	293	844	org/json/JSONException
    //   296	344	844	org/json/JSONException
    //   347	427	844	org/json/JSONException
    //   431	437	844	org/json/JSONException
    //   437	445	844	org/json/JSONException
    //   445	508	844	org/json/JSONException
    //   508	571	844	org/json/JSONException
    //   571	634	844	org/json/JSONException
    //   634	697	844	org/json/JSONException
    //   697	765	844	org/json/JSONException
    //   765	836	844	org/json/JSONException
    //   836	843	844	org/json/JSONException
    //   61	204	848	org/json/JSONException
    //   206	221	848	org/json/JSONException
    //   256	293	893	java/lang/Exception
    //   296	344	893	java/lang/Exception
    //   347	427	893	java/lang/Exception
    //   431	437	893	java/lang/Exception
    //   437	445	893	java/lang/Exception
    //   445	508	893	java/lang/Exception
    //   508	571	893	java/lang/Exception
    //   571	634	893	java/lang/Exception
    //   634	697	893	java/lang/Exception
    //   697	765	893	java/lang/Exception
    //   765	836	893	java/lang/Exception
    //   836	843	893	java/lang/Exception
    //   849	892	893	java/lang/Exception
    //   11	61	897	java/lang/Exception
    //   61	204	897	java/lang/Exception
  }
  
  public Class<QQAssistantConfigProcessor.QAssistantConfigContent> clazz()
  {
    return QQAssistantConfigProcessor.QAssistantConfigContent.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQAssistantConfigProcessor", 2, "migrateOldVersion");
    }
    return 0;
  }
  
  public void onReqFailed(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReqFailed, code = ");
      localStringBuilder.append(paramInt);
      QLog.d("QQAssistantConfigProcessor", 2, localStringBuilder.toString());
    }
  }
  
  public int type()
  {
    return 679;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQAssistantConfigProcessor
 * JD-Core Version:    0.7.0.1
 */