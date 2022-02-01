package com.tencent.mobileqq.business.sougou;

import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;

class WordMatchManager$4
  implements HttpWebCgiAsyncTask.Callback
{
  WordMatchManager$4(WordMatchManager paramWordMatchManager) {}
  
  /* Error */
  public void a(org.json.JSONObject paramJSONObject, int paramInt, android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +39 -> 40
    //   4: aload_1
    //   5: ldc 21
    //   7: invokevirtual 27	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   10: istore 4
    //   12: iload 4
    //   14: ifeq +6 -> 20
    //   17: goto +23 -> 40
    //   20: iconst_1
    //   21: istore 4
    //   23: goto +20 -> 43
    //   26: astore_1
    //   27: goto +11 -> 38
    //   30: astore_3
    //   31: aload_3
    //   32: invokevirtual 30	org/json/JSONException:printStackTrace	()V
    //   35: goto +74 -> 109
    //   38: aload_1
    //   39: athrow
    //   40: iconst_0
    //   41: istore 4
    //   43: iload 4
    //   45: ifne +64 -> 109
    //   48: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   51: ifeq +49 -> 100
    //   54: new 38	java/lang/StringBuilder
    //   57: dup
    //   58: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   61: astore_1
    //   62: aload_1
    //   63: ldc 41
    //   65: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_1
    //   70: iload_2
    //   71: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload_1
    //   76: ldc 50
    //   78: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_1
    //   83: invokestatic 56	java/lang/System:currentTimeMillis	()J
    //   86: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: ldc 61
    //   92: iconst_2
    //   93: aload_1
    //   94: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   100: aload_0
    //   101: getfield 12	com/tencent/mobileqq/business/sougou/WordMatchManager$4:a	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   104: iconst_0
    //   105: invokevirtual 74	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(Z)V
    //   108: return
    //   109: new 76	com/tencent/mobileqq/business/sougou/WordMatchManager$DictLocalMetaInfo
    //   112: dup
    //   113: invokespecial 77	com/tencent/mobileqq/business/sougou/WordMatchManager$DictLocalMetaInfo:<init>	()V
    //   116: astore_3
    //   117: aload_1
    //   118: ldc 79
    //   120: invokevirtual 83	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   123: ifeq +179 -> 302
    //   126: aload_1
    //   127: ldc 79
    //   129: invokevirtual 87	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   132: astore_1
    //   133: aload_1
    //   134: ldc 89
    //   136: invokevirtual 83	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   139: ifeq +13 -> 152
    //   142: aload_3
    //   143: aload_1
    //   144: ldc 89
    //   146: invokevirtual 93	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   149: putfield 97	com/tencent/mobileqq/business/sougou/WordMatchManager$DictLocalMetaInfo:f	Ljava/lang/String;
    //   152: aload_1
    //   153: ldc 99
    //   155: invokevirtual 83	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   158: ifeq +13 -> 171
    //   161: aload_3
    //   162: aload_1
    //   163: ldc 99
    //   165: invokevirtual 93	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   168: putfield 101	com/tencent/mobileqq/business/sougou/WordMatchManager$DictLocalMetaInfo:d	Ljava/lang/String;
    //   171: aload_1
    //   172: ldc 103
    //   174: invokevirtual 83	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   177: ifeq +13 -> 190
    //   180: aload_3
    //   181: aload_1
    //   182: ldc 103
    //   184: invokevirtual 27	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   187: putfield 106	com/tencent/mobileqq/business/sougou/WordMatchManager$DictLocalMetaInfo:a	I
    //   190: aload_1
    //   191: ldc 108
    //   193: invokevirtual 83	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   196: ifeq +13 -> 209
    //   199: aload_3
    //   200: aload_1
    //   201: ldc 108
    //   203: invokevirtual 27	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   206: putfield 111	com/tencent/mobileqq/business/sougou/WordMatchManager$DictLocalMetaInfo:b	I
    //   209: aload_1
    //   210: ldc 113
    //   212: invokevirtual 83	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   215: ifeq +13 -> 228
    //   218: aload_3
    //   219: aload_1
    //   220: ldc 113
    //   222: invokevirtual 117	org/json/JSONObject:getLong	(Ljava/lang/String;)J
    //   225: putfield 121	com/tencent/mobileqq/business/sougou/WordMatchManager$DictLocalMetaInfo:c	J
    //   228: aload_1
    //   229: ldc 123
    //   231: invokevirtual 83	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   234: ifeq +68 -> 302
    //   237: aload_3
    //   238: aload_1
    //   239: ldc 123
    //   241: invokevirtual 93	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   244: putfield 126	com/tencent/mobileqq/business/sougou/WordMatchManager$DictLocalMetaInfo:e	Ljava/lang/String;
    //   247: goto +55 -> 302
    //   250: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq +49 -> 302
    //   256: new 38	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   263: astore_1
    //   264: aload_1
    //   265: ldc 128
    //   267: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload_1
    //   272: iload_2
    //   273: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   276: pop
    //   277: aload_1
    //   278: ldc 50
    //   280: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: aload_1
    //   285: invokestatic 56	java/lang/System:currentTimeMillis	()J
    //   288: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: ldc 61
    //   294: iconst_2
    //   295: aload_1
    //   296: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   302: invokestatic 36	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   305: ifeq +49 -> 354
    //   308: new 38	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 39	java/lang/StringBuilder:<init>	()V
    //   315: astore_1
    //   316: aload_1
    //   317: ldc 130
    //   319: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload_1
    //   324: iload_2
    //   325: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload_1
    //   330: ldc 50
    //   332: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload_1
    //   337: invokestatic 56	java/lang/System:currentTimeMillis	()J
    //   340: invokevirtual 59	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: ldc 61
    //   346: iconst_2
    //   347: aload_1
    //   348: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 69	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: aload_3
    //   355: getfield 106	com/tencent/mobileqq/business/sougou/WordMatchManager$DictLocalMetaInfo:a	I
    //   358: iload_2
    //   359: if_icmpeq +12 -> 371
    //   362: aload_0
    //   363: getfield 12	com/tencent/mobileqq/business/sougou/WordMatchManager$4:a	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   366: iconst_0
    //   367: invokevirtual 74	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(Z)V
    //   370: return
    //   371: aload_0
    //   372: getfield 12	com/tencent/mobileqq/business/sougou/WordMatchManager$4:a	Lcom/tencent/mobileqq/business/sougou/WordMatchManager;
    //   375: aload_3
    //   376: invokevirtual 133	com/tencent/mobileqq/business/sougou/WordMatchManager:a	(Lcom/tencent/mobileqq/business/sougou/WordMatchManager$DictLocalMetaInfo;)V
    //   379: return
    //   380: astore_1
    //   381: goto -131 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	this	4
    //   0	384	1	paramJSONObject	org.json.JSONObject
    //   0	384	2	paramInt	int
    //   0	384	3	paramBundle	android.os.Bundle
    //   10	34	4	i	int
    // Exception table:
    //   from	to	target	type
    //   4	12	26	finally
    //   31	35	26	finally
    //   4	12	30	org/json/JSONException
    //   117	152	380	org/json/JSONException
    //   152	171	380	org/json/JSONException
    //   171	190	380	org/json/JSONException
    //   190	209	380	org/json/JSONException
    //   209	228	380	org/json/JSONException
    //   228	247	380	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.business.sougou.WordMatchManager.4
 * JD-Core Version:    0.7.0.1
 */