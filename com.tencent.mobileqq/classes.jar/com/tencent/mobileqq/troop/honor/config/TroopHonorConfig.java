package com.tencent.mobileqq.troop.honor.config;

import android.util.SparseArray;
import com.tencent.mobileqq.troop.honor.util.TroopHonorUtils;

public class TroopHonorConfig
{
  public boolean a;
  public int b = 3;
  private SparseArray<TroopHonor> c = new SparseArray();
  private SparseArray<TroopHonor> d = new SparseArray();
  
  public TroopHonorConfig()
  {
    a();
  }
  
  /* Error */
  public static TroopHonorConfig a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 37	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 7
    //   6: aconst_null
    //   7: astore 9
    //   9: iload 7
    //   11: ifeq +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: new 18	android/util/SparseArray
    //   19: dup
    //   20: invokespecial 19	android/util/SparseArray:<init>	()V
    //   23: astore 10
    //   25: iconst_3
    //   26: istore_1
    //   27: iconst_0
    //   28: istore 7
    //   30: new 39	org/json/JSONObject
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 42	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   38: astore 8
    //   40: aload 8
    //   42: ldc 44
    //   44: iconst_0
    //   45: invokevirtual 48	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   48: istore_2
    //   49: aload 8
    //   51: ldc 50
    //   53: iconst_3
    //   54: invokevirtual 48	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   57: istore_3
    //   58: iload_3
    //   59: istore_1
    //   60: aload 8
    //   62: ldc 52
    //   64: invokevirtual 56	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   67: astore 8
    //   69: iload_3
    //   70: istore 6
    //   72: iload_2
    //   73: istore 5
    //   75: aload 8
    //   77: ifnull +168 -> 245
    //   80: iload_3
    //   81: istore_1
    //   82: iload_3
    //   83: istore 6
    //   85: iload_2
    //   86: istore 5
    //   88: aload 8
    //   90: invokevirtual 62	org/json/JSONArray:length	()I
    //   93: ifle +152 -> 245
    //   96: iconst_0
    //   97: istore 4
    //   99: iload_3
    //   100: istore_1
    //   101: iload_3
    //   102: istore 6
    //   104: iload_2
    //   105: istore 5
    //   107: iload 4
    //   109: aload 8
    //   111: invokevirtual 62	org/json/JSONArray:length	()I
    //   114: if_icmpge +131 -> 245
    //   117: iload_3
    //   118: istore_1
    //   119: aload 8
    //   121: iload 4
    //   123: invokevirtual 66	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   126: astore 11
    //   128: iload_3
    //   129: istore_1
    //   130: aload 11
    //   132: ldc 68
    //   134: invokevirtual 71	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   137: istore 5
    //   139: iload_3
    //   140: istore_1
    //   141: aload 11
    //   143: ldc 73
    //   145: invokevirtual 77	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   148: astore 12
    //   150: iload_3
    //   151: istore_1
    //   152: aload 11
    //   154: ldc 79
    //   156: invokevirtual 82	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   159: astore 13
    //   161: iload_3
    //   162: istore_1
    //   163: aload 11
    //   165: ldc 84
    //   167: invokevirtual 87	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   170: istore 6
    //   172: iload_3
    //   173: istore_1
    //   174: aload 12
    //   176: invokestatic 37	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   179: ifne +37 -> 216
    //   182: iload_3
    //   183: istore_1
    //   184: aload 13
    //   186: invokestatic 37	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   189: ifne +27 -> 216
    //   192: iload_3
    //   193: istore_1
    //   194: aload 10
    //   196: iload 5
    //   198: new 89	com/tencent/mobileqq/troop/honor/config/TroopHonor
    //   201: dup
    //   202: iload 5
    //   204: aload 13
    //   206: aload 12
    //   208: iload 6
    //   210: invokespecial 92	com/tencent/mobileqq/troop/honor/config/TroopHonor:<init>	(ILjava/lang/String;Ljava/lang/String;I)V
    //   213: invokevirtual 96	android/util/SparseArray:append	(ILjava/lang/Object;)V
    //   216: iload 4
    //   218: iconst_1
    //   219: iadd
    //   220: istore 4
    //   222: goto -123 -> 99
    //   225: astore 8
    //   227: goto +7 -> 234
    //   230: astore 8
    //   232: iconst_0
    //   233: istore_2
    //   234: aload 8
    //   236: invokevirtual 99	org/json/JSONException:printStackTrace	()V
    //   239: iload_2
    //   240: istore 5
    //   242: iload_1
    //   243: istore 6
    //   245: aload 10
    //   247: invokevirtual 102	android/util/SparseArray:size	()I
    //   250: ifle +45 -> 295
    //   253: new 2	com/tencent/mobileqq/troop/honor/config/TroopHonorConfig
    //   256: dup
    //   257: invokespecial 103	com/tencent/mobileqq/troop/honor/config/TroopHonorConfig:<init>	()V
    //   260: astore 8
    //   262: aload 8
    //   264: aload 10
    //   266: putfield 21	com/tencent/mobileqq/troop/honor/config/TroopHonorConfig:c	Landroid/util/SparseArray;
    //   269: iload 5
    //   271: iconst_1
    //   272: if_icmpne +6 -> 278
    //   275: iconst_1
    //   276: istore 7
    //   278: aload 8
    //   280: iload 7
    //   282: putfield 105	com/tencent/mobileqq/troop/honor/config/TroopHonorConfig:a	Z
    //   285: aload 8
    //   287: iload 6
    //   289: putfield 25	com/tencent/mobileqq/troop/honor/config/TroopHonorConfig:b	I
    //   292: goto +15 -> 307
    //   295: ldc 107
    //   297: iconst_1
    //   298: ldc 109
    //   300: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   303: aload 9
    //   305: astore 8
    //   307: invokestatic 118	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   310: ifeq +54 -> 364
    //   313: new 120	java/lang/StringBuilder
    //   316: dup
    //   317: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   320: astore 9
    //   322: aload 9
    //   324: ldc 123
    //   326: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload 9
    //   332: aload_0
    //   333: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: pop
    //   337: aload 9
    //   339: ldc 128
    //   341: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload 9
    //   347: aload 8
    //   349: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: ldc 107
    //   355: iconst_2
    //   356: aload 9
    //   358: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   361: invokestatic 114	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   364: aload 8
    //   366: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	paramString	String
    //   26	217	1	i	int
    //   48	192	2	j	int
    //   57	136	3	k	int
    //   97	124	4	m	int
    //   73	200	5	n	int
    //   70	218	6	i1	int
    //   4	277	7	bool	boolean
    //   38	82	8	localObject1	Object
    //   225	1	8	localJSONException1	org.json.JSONException
    //   230	5	8	localJSONException2	org.json.JSONException
    //   260	105	8	localObject2	Object
    //   7	350	9	localStringBuilder	StringBuilder
    //   23	242	10	localSparseArray	SparseArray
    //   126	38	11	localJSONObject	org.json.JSONObject
    //   148	59	12	str1	String
    //   159	46	13	str2	String
    // Exception table:
    //   from	to	target	type
    //   49	58	225	org/json/JSONException
    //   60	69	225	org/json/JSONException
    //   88	96	225	org/json/JSONException
    //   107	117	225	org/json/JSONException
    //   119	128	225	org/json/JSONException
    //   130	139	225	org/json/JSONException
    //   141	150	225	org/json/JSONException
    //   152	161	225	org/json/JSONException
    //   163	172	225	org/json/JSONException
    //   174	182	225	org/json/JSONException
    //   184	192	225	org/json/JSONException
    //   194	216	225	org/json/JSONException
    //   30	49	230	org/json/JSONException
  }
  
  private void a()
  {
    TroopHonor localTroopHonor1 = new TroopHonor(1, "龙王", "https://qzonestyle.gtimg.cn/aoi/sola/20200213150116_n4PxCiurbm.png", 1);
    TroopHonor localTroopHonor2 = new TroopHonor(2, "群聊之火", "https://qzonestyle.gtimg.cn/aoi/sola/20200217190136_92JEGFKC5k.png", 3);
    TroopHonor localTroopHonor3 = new TroopHonor(3, "群聊炽焰", "https://qzonestyle.gtimg.cn/aoi/sola/20200217190204_zgCTeSrMq1.png", 4);
    TroopHonor localTroopHonor4 = new TroopHonor(5, "冒尖小春笋", "https://qzonestyle.gtimg.cn/aoi/sola/20200213150335_tUJCAtoKVP.png", 5);
    TroopHonor localTroopHonor5 = new TroopHonor(6, "快乐源泉", "https://qzonestyle.gtimg.cn/aoi/sola/20200213150434_3tDmsJExCP.png", 7);
    TroopHonor localTroopHonor6 = new TroopHonor(7, "学术新星", "https://sola.gtimg.cn/aoi/sola/20200515140645_j0X6gbuHNP.png", 8);
    TroopHonor localTroopHonor7 = new TroopHonor(8, "顶尖学霸", "https://sola.gtimg.cn/aoi/sola/20200515140639_0CtWOpfVzK.png", 9);
    TroopHonor localTroopHonor8 = new TroopHonor(9, "至尊学神", "https://sola.gtimg.cn/aoi/sola/20200515140628_P8UEYBjMBT.png", 10);
    TroopHonor localTroopHonor9 = new TroopHonor(10, "一笔当先", "https://sola.gtimg.cn/aoi/sola/20200515140654_4r94tSCdaB.png", 11);
    TroopHonor localTroopHonor10 = new TroopHonor(11, "奋进小翠竹", "https://sola.gtimg.cn/aoi/sola/20200812151819_wbj6z2NGoB.png", 6);
    TroopHonor localTroopHonor11 = new TroopHonor(12, "氛围魔杖", "https://sola.gtimg.cn/aoi/sola/20200812151831_4ZJgQCaD1H.png", 2);
    TroopHonor localTroopHonor12 = new TroopHonor(13, "壕礼皇冠", "https://sola.gtimg.cn/aoi/sola/20200930154050_juZOAMg7pt.png", 12);
    a(localTroopHonor1);
    a(localTroopHonor2);
    a(localTroopHonor3);
    a(localTroopHonor4);
    a(localTroopHonor5);
    a(localTroopHonor6);
    a(localTroopHonor7);
    a(localTroopHonor8);
    a(localTroopHonor9);
    a(localTroopHonor10);
    a(localTroopHonor11);
    a(localTroopHonor12);
  }
  
  public TroopHonor a(int paramInt)
  {
    SparseArray localSparseArray = this.c;
    if (localSparseArray != null) {
      return (TroopHonor)localSparseArray.get(paramInt);
    }
    return null;
  }
  
  public TroopHonor a(int paramInt1, int paramInt2)
  {
    Object localObject = this.d;
    if (localObject == null) {
      return null;
    }
    TroopHonor localTroopHonor1 = (TroopHonor)((SparseArray)localObject).get(paramInt1);
    localObject = localTroopHonor1;
    if (localTroopHonor1 == null)
    {
      TroopHonor localTroopHonor2 = (TroopHonor)this.c.get(paramInt1);
      localObject = localTroopHonor1;
      if (localTroopHonor2 != null)
      {
        localObject = new TroopHonor(localTroopHonor2.a, localTroopHonor2.b, TroopHonorUtils.a(paramInt1, paramInt2), localTroopHonor2.d);
        this.d.put(paramInt1, localObject);
      }
    }
    return localObject;
  }
  
  public void a(TroopHonor paramTroopHonor)
  {
    SparseArray localSparseArray = this.c;
    if (localSparseArray != null) {
      localSparseArray.put(paramTroopHonor.a, paramTroopHonor);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TroopHonorConfig{mHonorMap=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", isSupport=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.config.TroopHonorConfig
 * JD-Core Version:    0.7.0.1
 */