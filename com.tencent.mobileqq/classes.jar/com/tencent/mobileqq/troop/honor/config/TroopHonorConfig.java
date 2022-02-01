package com.tencent.mobileqq.troop.honor.config;

import android.util.SparseArray;
import com.tencent.mobileqq.troop.honor.util.TroopHonorUtils;

public class TroopHonorConfig
{
  public int a;
  private SparseArray<TroopHonor> a;
  public boolean a;
  private SparseArray<TroopHonor> b = new SparseArray();
  
  public TroopHonorConfig()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    this.jdField_a_of_type_Int = 3;
    a();
  }
  
  /* Error */
  public static TroopHonorConfig a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: new 16	android/util/SparseArray
    //   12: dup
    //   13: invokespecial 17	android/util/SparseArray:<init>	()V
    //   16: astore 8
    //   18: new 37	org/json/JSONObject
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 40	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   26: astore 7
    //   28: aload 7
    //   30: ldc 42
    //   32: iconst_0
    //   33: invokevirtual 46	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   36: istore_2
    //   37: aload 7
    //   39: ldc 48
    //   41: iconst_3
    //   42: invokevirtual 46	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   45: istore_1
    //   46: aload 7
    //   48: ldc 50
    //   50: invokevirtual 54	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   53: astore 7
    //   55: iload_1
    //   56: istore 5
    //   58: iload_2
    //   59: istore 4
    //   61: aload 7
    //   63: ifnull +140 -> 203
    //   66: iload_1
    //   67: istore 5
    //   69: iload_2
    //   70: istore 4
    //   72: aload 7
    //   74: invokevirtual 60	org/json/JSONArray:length	()I
    //   77: ifle +126 -> 203
    //   80: iconst_0
    //   81: istore_3
    //   82: iload_1
    //   83: istore 5
    //   85: iload_2
    //   86: istore 4
    //   88: iload_3
    //   89: aload 7
    //   91: invokevirtual 60	org/json/JSONArray:length	()I
    //   94: if_icmpge +109 -> 203
    //   97: aload 7
    //   99: iload_3
    //   100: invokevirtual 64	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   103: astore 9
    //   105: aload 9
    //   107: ldc 66
    //   109: invokevirtual 69	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   112: istore 4
    //   114: aload 9
    //   116: ldc 71
    //   118: invokevirtual 75	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   121: astore 10
    //   123: aload 9
    //   125: ldc 77
    //   127: invokevirtual 80	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   130: astore 11
    //   132: aload 9
    //   134: ldc 82
    //   136: invokevirtual 85	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   139: istore 5
    //   141: aload 10
    //   143: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   146: ifne +33 -> 179
    //   149: aload 11
    //   151: invokestatic 35	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   154: ifne +25 -> 179
    //   157: aload 8
    //   159: iload 4
    //   161: new 87	com/tencent/mobileqq/troop/honor/config/TroopHonor
    //   164: dup
    //   165: iload 4
    //   167: aload 11
    //   169: aload 10
    //   171: iload 5
    //   173: invokespecial 90	com/tencent/mobileqq/troop/honor/config/TroopHonor:<init>	(ILjava/lang/String;Ljava/lang/String;I)V
    //   176: invokevirtual 94	android/util/SparseArray:append	(ILjava/lang/Object;)V
    //   179: iload_3
    //   180: iconst_1
    //   181: iadd
    //   182: istore_3
    //   183: goto -101 -> 82
    //   186: astore 7
    //   188: iconst_0
    //   189: istore_2
    //   190: iconst_3
    //   191: istore_1
    //   192: aload 7
    //   194: invokevirtual 97	org/json/JSONException:printStackTrace	()V
    //   197: iload_2
    //   198: istore 4
    //   200: iload_1
    //   201: istore 5
    //   203: aload 8
    //   205: invokevirtual 100	android/util/SparseArray:size	()I
    //   208: ifle +92 -> 300
    //   211: new 2	com/tencent/mobileqq/troop/honor/config/TroopHonorConfig
    //   214: dup
    //   215: invokespecial 101	com/tencent/mobileqq/troop/honor/config/TroopHonorConfig:<init>	()V
    //   218: astore 7
    //   220: aload 7
    //   222: aload 8
    //   224: putfield 19	com/tencent/mobileqq/troop/honor/config/TroopHonorConfig:jdField_a_of_type_AndroidUtilSparseArray	Landroid/util/SparseArray;
    //   227: iload 4
    //   229: iconst_1
    //   230: if_icmpne +64 -> 294
    //   233: iconst_1
    //   234: istore 6
    //   236: aload 7
    //   238: iload 6
    //   240: putfield 103	com/tencent/mobileqq/troop/honor/config/TroopHonorConfig:jdField_a_of_type_Boolean	Z
    //   243: aload 7
    //   245: iload 5
    //   247: putfield 23	com/tencent/mobileqq/troop/honor/config/TroopHonorConfig:jdField_a_of_type_Int	I
    //   250: invokestatic 109	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   253: ifeq +38 -> 291
    //   256: ldc 111
    //   258: iconst_2
    //   259: new 113	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   266: ldc 116
    //   268: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   271: aload_0
    //   272: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: ldc 121
    //   277: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload 7
    //   282: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   285: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   288: invokestatic 132	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   291: aload 7
    //   293: areturn
    //   294: iconst_0
    //   295: istore 6
    //   297: goto -61 -> 236
    //   300: ldc 111
    //   302: iconst_1
    //   303: ldc 134
    //   305: invokestatic 132	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   308: aconst_null
    //   309: astore 7
    //   311: goto -61 -> 250
    //   314: astore 7
    //   316: iconst_3
    //   317: istore_1
    //   318: goto -126 -> 192
    //   321: astore 7
    //   323: goto -131 -> 192
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	326	0	paramString	String
    //   45	273	1	i	int
    //   36	162	2	j	int
    //   81	102	3	k	int
    //   59	172	4	m	int
    //   56	190	5	n	int
    //   234	62	6	bool	boolean
    //   26	72	7	localObject	Object
    //   186	7	7	localJSONException1	org.json.JSONException
    //   218	92	7	localTroopHonorConfig	TroopHonorConfig
    //   314	1	7	localJSONException2	org.json.JSONException
    //   321	1	7	localJSONException3	org.json.JSONException
    //   16	207	8	localSparseArray	SparseArray
    //   103	30	9	localJSONObject	org.json.JSONObject
    //   121	49	10	str1	String
    //   130	38	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   18	37	186	org/json/JSONException
    //   37	46	314	org/json/JSONException
    //   46	55	321	org/json/JSONException
    //   72	80	321	org/json/JSONException
    //   88	179	321	org/json/JSONException
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
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      return (TroopHonor)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    }
    return null;
  }
  
  public TroopHonor a(int paramInt1, int paramInt2)
  {
    if (this.b == null) {
      localObject = null;
    }
    TroopHonor localTroopHonor2;
    do
    {
      TroopHonor localTroopHonor1;
      do
      {
        return localObject;
        localTroopHonor1 = (TroopHonor)this.b.get(paramInt1);
        localObject = localTroopHonor1;
      } while (localTroopHonor1 != null);
      localTroopHonor2 = (TroopHonor)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt1);
      localObject = localTroopHonor1;
    } while (localTroopHonor2 == null);
    Object localObject = new TroopHonor(localTroopHonor2.jdField_a_of_type_Int, localTroopHonor2.jdField_a_of_type_JavaLangString, TroopHonorUtils.a(paramInt1, paramInt2), localTroopHonor2.b);
    this.b.put(paramInt1, localObject);
    return localObject;
  }
  
  public void a(TroopHonor paramTroopHonor)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramTroopHonor.jdField_a_of_type_Int, paramTroopHonor);
    }
  }
  
  public String toString()
  {
    return "TroopHonorConfig{mHonorMap=" + this.jdField_a_of_type_AndroidUtilSparseArray + ", isSupport=" + this.jdField_a_of_type_Boolean + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.honor.config.TroopHonorConfig
 * JD-Core Version:    0.7.0.1
 */