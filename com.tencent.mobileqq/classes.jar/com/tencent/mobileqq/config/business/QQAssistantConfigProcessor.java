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
      localQAssistantConfigContent.jdField_a_of_type_Int = paramArrayOfQConfItem.jdField_a_of_type_Int;
      localQAssistantConfigContent.jdField_a_of_type_JavaLangString = paramArrayOfQConfItem.jdField_a_of_type_JavaLangString;
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfQConfItem = new StringBuilder();
      paramArrayOfQConfItem.append("onParsed taskId = ");
      paramArrayOfQConfItem.append(localQAssistantConfigContent.jdField_a_of_type_Int);
      paramArrayOfQConfItem.append(" | content = ");
      paramArrayOfQConfItem.append(localQAssistantConfigContent.jdField_a_of_type_JavaLangString);
      QLog.d("QQAssistantConfigProcessor", 2, paramArrayOfQConfItem.toString());
    }
    return localQAssistantConfigContent;
  }
  
  /* Error */
  public void a(QQAssistantConfigProcessor.QAssistantConfigContent paramQAssistantConfigContent)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +857 -> 858
    //   4: aload_1
    //   5: getfield 102	com/tencent/mobileqq/config/business/QQAssistantConfigProcessor$QAssistantConfigContent:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8: ifnull +850 -> 858
    //   11: aload_1
    //   12: getfield 102	com/tencent/mobileqq/config/business/QQAssistantConfigProcessor$QAssistantConfigContent:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   15: astore 4
    //   17: invokestatic 71	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +41 -> 61
    //   23: new 73	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   30: astore 4
    //   32: aload 4
    //   34: ldc 111
    //   36: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 4
    //   42: aload_1
    //   43: getfield 102	com/tencent/mobileqq/config/business/QQAssistantConfigProcessor$QAssistantConfigContent:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   66: getfield 102	com/tencent/mobileqq/config/business/QQAssistantConfigProcessor$QAssistantConfigContent:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   69: invokespecial 114	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   72: astore 5
    //   74: getstatic 120	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   77: ldc 122
    //   79: iconst_4
    //   80: invokevirtual 126	mqq/app/MobileQQ:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   83: invokeinterface 132 1 0
    //   88: astore 4
    //   90: invokestatic 137	com/tencent/mobileqq/utils/DeviceInfoUtil:f	()Ljava/lang/String;
    //   93: astore_1
    //   94: new 73	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   101: astore 6
    //   103: aload 6
    //   105: ldc 139
    //   107: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: aload 6
    //   113: getstatic 40	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   116: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload 6
    //   122: ldc 141
    //   124: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: pop
    //   128: aload 6
    //   130: getstatic 45	android/os/Build:BRAND	Ljava/lang/String;
    //   133: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 6
    //   139: ldc 143
    //   141: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: pop
    //   145: aload 6
    //   147: getstatic 50	android/os/Build:MODEL	Ljava/lang/String;
    //   150: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 6
    //   156: ldc 145
    //   158: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 6
    //   164: getstatic 55	android/os/Build:FINGERPRINT	Ljava/lang/String;
    //   167: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload 6
    //   173: ldc 147
    //   175: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 6
    //   181: aload_1
    //   182: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: ldc 149
    //   188: aload 6
    //   190: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 154	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   196: aload 5
    //   198: ldc 156
    //   200: invokevirtual 22	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   203: ifeq +688 -> 891
    //   206: aload 5
    //   208: ldc 156
    //   210: invokevirtual 160	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   213: astore 6
    //   215: iconst_0
    //   216: istore_2
    //   217: iload_2
    //   218: aload 6
    //   220: invokevirtual 166	org/json/JSONArray:length	()I
    //   223: if_icmpge +39 -> 262
    //   226: aload 6
    //   228: iload_2
    //   229: invokevirtual 170	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   232: astore 7
    //   234: aload_0
    //   235: aload 7
    //   237: aload_1
    //   238: invokespecial 172	com/tencent/mobileqq/config/business/QQAssistantConfigProcessor:a	(Lorg/json/JSONObject;Ljava/lang/String;)Z
    //   241: istore_3
    //   242: iload_3
    //   243: ifeq +8 -> 251
    //   246: iconst_1
    //   247: istore_3
    //   248: goto +60 -> 308
    //   251: iload_2
    //   252: iconst_1
    //   253: iadd
    //   254: istore_2
    //   255: goto -38 -> 217
    //   258: astore_1
    //   259: goto +9 -> 268
    //   262: iconst_0
    //   263: istore_3
    //   264: goto +44 -> 308
    //   267: astore_1
    //   268: new 73	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   275: astore 6
    //   277: aload 6
    //   279: ldc 174
    //   281: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload 6
    //   287: aload_1
    //   288: invokevirtual 177	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   291: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: ldc 149
    //   297: aload 6
    //   299: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 154	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   305: goto -43 -> 262
    //   308: new 73	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   315: astore_1
    //   316: aload_1
    //   317: ldc 179
    //   319: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload_1
    //   324: iload_3
    //   325: invokevirtual 182	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: ldc 149
    //   331: aload_1
    //   332: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 154	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   338: aload 4
    //   340: ldc 156
    //   342: iload_3
    //   343: invokeinterface 188 3 0
    //   348: pop
    //   349: invokestatic 193	com/tencent/mobileqq/qassistant/wake/WakeManager:a	()Lcom/tencent/mobileqq/qassistant/wake/WakeManager;
    //   352: iload_3
    //   353: putfield 197	com/tencent/mobileqq/qassistant/wake/WakeManager:e	Z
    //   356: goto +3 -> 359
    //   359: aload 5
    //   361: ldc 199
    //   363: invokevirtual 22	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   366: ifeq +91 -> 457
    //   369: aload 5
    //   371: ldc 199
    //   373: invokevirtual 202	org/json/JSONObject:getBoolean	(Ljava/lang/String;)Z
    //   376: istore_3
    //   377: new 73	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   384: astore_1
    //   385: aload_1
    //   386: ldc 204
    //   388: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload_1
    //   393: iload_3
    //   394: invokevirtual 182	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: ldc 149
    //   400: aload_1
    //   401: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokestatic 154	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   407: aload 4
    //   409: invokestatic 206	com/tencent/mobileqq/qassistant/wake/WakeManager:a	()Ljava/lang/String;
    //   412: iload_3
    //   413: invokeinterface 188 3 0
    //   418: pop
    //   419: invokestatic 193	com/tencent/mobileqq/qassistant/wake/WakeManager:a	()Lcom/tencent/mobileqq/qassistant/wake/WakeManager;
    //   422: iload_3
    //   423: putfield 208	com/tencent/mobileqq/qassistant/wake/WakeManager:d	Z
    //   426: invokestatic 193	com/tencent/mobileqq/qassistant/wake/WakeManager:a	()Lcom/tencent/mobileqq/qassistant/wake/WakeManager;
    //   429: invokevirtual 211	com/tencent/mobileqq/qassistant/wake/WakeManager:b	()Z
    //   432: ifeq +25 -> 457
    //   435: invokestatic 214	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	()Lcom/tencent/mobileqq/qassistant/api/IVoiceAssistantCore;
    //   438: astore_1
    //   439: aload_1
    //   440: ifnull +9 -> 449
    //   443: aload_1
    //   444: invokeinterface 219 1 0
    //   449: invokestatic 193	com/tencent/mobileqq/qassistant/wake/WakeManager:a	()Lcom/tencent/mobileqq/qassistant/wake/WakeManager;
    //   452: ldc 221
    //   454: invokevirtual 223	com/tencent/mobileqq/qassistant/wake/WakeManager:a	(Ljava/lang/String;)V
    //   457: aload 5
    //   459: ldc 225
    //   461: invokevirtual 22	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   464: ifeq +56 -> 520
    //   467: aload 5
    //   469: ldc 225
    //   471: invokevirtual 26	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   474: astore_1
    //   475: new 73	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   482: astore 6
    //   484: aload 6
    //   486: ldc 227
    //   488: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   491: pop
    //   492: aload 6
    //   494: aload_1
    //   495: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: pop
    //   499: ldc 149
    //   501: aload 6
    //   503: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   506: invokestatic 154	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   509: aload 4
    //   511: ldc 225
    //   513: aload_1
    //   514: invokeinterface 231 3 0
    //   519: pop
    //   520: aload 5
    //   522: ldc 233
    //   524: invokevirtual 22	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   527: ifeq +56 -> 583
    //   530: aload 5
    //   532: ldc 233
    //   534: invokevirtual 26	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   537: astore_1
    //   538: new 73	java/lang/StringBuilder
    //   541: dup
    //   542: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   545: astore 6
    //   547: aload 6
    //   549: ldc 235
    //   551: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   554: pop
    //   555: aload 6
    //   557: aload_1
    //   558: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: pop
    //   562: ldc 149
    //   564: aload 6
    //   566: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: invokestatic 154	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   572: aload 4
    //   574: ldc 233
    //   576: aload_1
    //   577: invokeinterface 231 3 0
    //   582: pop
    //   583: aload 5
    //   585: ldc 237
    //   587: invokevirtual 22	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   590: ifeq +56 -> 646
    //   593: aload 5
    //   595: ldc 237
    //   597: invokevirtual 26	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   600: astore_1
    //   601: new 73	java/lang/StringBuilder
    //   604: dup
    //   605: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   608: astore 6
    //   610: aload 6
    //   612: ldc 239
    //   614: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: pop
    //   618: aload 6
    //   620: aload_1
    //   621: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   624: pop
    //   625: ldc 149
    //   627: aload 6
    //   629: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   632: invokestatic 154	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   635: aload 4
    //   637: ldc 237
    //   639: aload_1
    //   640: invokeinterface 231 3 0
    //   645: pop
    //   646: aload 5
    //   648: ldc 241
    //   650: invokevirtual 22	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   653: ifeq +61 -> 714
    //   656: aload 5
    //   658: ldc 241
    //   660: invokevirtual 26	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   663: astore_1
    //   664: new 73	java/lang/StringBuilder
    //   667: dup
    //   668: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   671: astore 6
    //   673: aload 6
    //   675: ldc 243
    //   677: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: pop
    //   681: aload 6
    //   683: aload_1
    //   684: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: pop
    //   688: ldc 149
    //   690: aload 6
    //   692: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   695: invokestatic 154	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   698: aload_1
    //   699: invokestatic 248	com/tencent/mobileqq/qassistant/core/FriendSortHelper:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/qassistant/config/FriendSortConfig;
    //   702: pop
    //   703: aload 4
    //   705: ldc 241
    //   707: aload_1
    //   708: invokeinterface 231 3 0
    //   713: pop
    //   714: aload 5
    //   716: ldc 250
    //   718: invokevirtual 22	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   721: ifeq +60 -> 781
    //   724: aload 5
    //   726: ldc 250
    //   728: invokevirtual 26	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   731: astore_1
    //   732: new 73	java/lang/StringBuilder
    //   735: dup
    //   736: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   739: astore 5
    //   741: aload 5
    //   743: ldc 252
    //   745: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: aload 5
    //   751: aload_1
    //   752: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: pop
    //   756: ldc 149
    //   758: aload 5
    //   760: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   763: invokestatic 154	com/tencent/mobileqq/qassistant/core/AssistantUtils:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   766: aload_1
    //   767: invokestatic 253	com/tencent/mobileqq/qassistant/core/FriendSortHelper:a	(Ljava/lang/String;)V
    //   770: aload 4
    //   772: ldc 250
    //   774: aload_1
    //   775: invokeinterface 231 3 0
    //   780: pop
    //   781: aload 4
    //   783: invokeinterface 256 1 0
    //   788: return
    //   789: astore_1
    //   790: goto +4 -> 794
    //   793: astore_1
    //   794: aload_1
    //   795: invokevirtual 259	org/json/JSONException:printStackTrace	()V
    //   798: new 73	java/lang/StringBuilder
    //   801: dup
    //   802: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   805: astore 4
    //   807: aload 4
    //   809: ldc_w 261
    //   812: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   815: pop
    //   816: aload 4
    //   818: aload_1
    //   819: invokevirtual 262	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   822: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: pop
    //   826: ldc 85
    //   828: iconst_2
    //   829: aload 4
    //   831: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   834: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   837: return
    //   838: astore_1
    //   839: goto +4 -> 843
    //   842: astore_1
    //   843: aload_1
    //   844: invokevirtual 265	java/lang/Exception:printStackTrace	()V
    //   847: ldc 85
    //   849: iconst_2
    //   850: ldc_w 267
    //   853: aload_1
    //   854: invokestatic 270	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   857: return
    //   858: new 73	java/lang/StringBuilder
    //   861: dup
    //   862: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   865: astore_1
    //   866: aload_1
    //   867: ldc_w 272
    //   870: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: pop
    //   874: aload_1
    //   875: aconst_null
    //   876: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   879: pop
    //   880: ldc 85
    //   882: iconst_2
    //   883: aload_1
    //   884: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   887: invokestatic 264	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   890: return
    //   891: goto -532 -> 359
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	894	0	this	QQAssistantConfigProcessor
    //   0	894	1	paramQAssistantConfigContent	QQAssistantConfigProcessor.QAssistantConfigContent
    //   216	39	2	i	int
    //   241	182	3	bool	boolean
    //   15	815	4	localObject1	java.lang.Object
    //   72	687	5	localObject2	java.lang.Object
    //   101	590	6	localObject3	java.lang.Object
    //   232	4	7	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   234	242	258	java/lang/Exception
    //   217	234	267	java/lang/Exception
    //   234	242	789	org/json/JSONException
    //   268	305	789	org/json/JSONException
    //   308	356	789	org/json/JSONException
    //   359	439	789	org/json/JSONException
    //   443	449	789	org/json/JSONException
    //   449	457	789	org/json/JSONException
    //   457	520	789	org/json/JSONException
    //   520	583	789	org/json/JSONException
    //   583	646	789	org/json/JSONException
    //   646	714	789	org/json/JSONException
    //   714	781	789	org/json/JSONException
    //   781	788	789	org/json/JSONException
    //   61	215	793	org/json/JSONException
    //   217	234	793	org/json/JSONException
    //   268	305	838	java/lang/Exception
    //   308	356	838	java/lang/Exception
    //   359	439	838	java/lang/Exception
    //   443	449	838	java/lang/Exception
    //   449	457	838	java/lang/Exception
    //   457	520	838	java/lang/Exception
    //   520	583	838	java/lang/Exception
    //   583	646	838	java/lang/Exception
    //   646	714	838	java/lang/Exception
    //   714	781	838	java/lang/Exception
    //   781	788	838	java/lang/Exception
    //   794	837	838	java/lang/Exception
    //   11	61	842	java/lang/Exception
    //   61	215	842	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQAssistantConfigProcessor
 * JD-Core Version:    0.7.0.1
 */