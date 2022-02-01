package com.tencent.mobileqq.troop.luckycharacter.config;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class TroopLuckyCharacterConfig
{
  private boolean a = false;
  private boolean b = false;
  private ArrayList<String> c = new ArrayList();
  
  /* Error */
  public static TroopLuckyCharacterConfig a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +38 -> 41
    //   6: new 35	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   13: astore 8
    //   15: aload 8
    //   17: ldc 38
    //   19: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 8
    //   25: aload_0
    //   26: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: ldc 44
    //   32: iconst_2
    //   33: aload 8
    //   35: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload_0
    //   42: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   45: ifeq +5 -> 50
    //   48: aconst_null
    //   49: areturn
    //   50: new 20	java/util/ArrayList
    //   53: dup
    //   54: invokespecial 21	java/util/ArrayList:<init>	()V
    //   57: astore 8
    //   59: iconst_0
    //   60: istore 7
    //   62: new 60	org/json/JSONObject
    //   65: dup
    //   66: aload_0
    //   67: invokespecial 63	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   70: astore_0
    //   71: aload_0
    //   72: ldc 65
    //   74: iconst_0
    //   75: invokevirtual 69	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   78: istore_1
    //   79: aload_0
    //   80: ldc 71
    //   82: iconst_0
    //   83: invokevirtual 69	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   86: istore_2
    //   87: aload_0
    //   88: ldc 73
    //   90: invokevirtual 77	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   93: astore_0
    //   94: iload_2
    //   95: istore 5
    //   97: iload_1
    //   98: istore_3
    //   99: aload_0
    //   100: ifnull +78 -> 178
    //   103: iload_2
    //   104: istore 5
    //   106: iload_1
    //   107: istore_3
    //   108: aload_0
    //   109: invokevirtual 83	org/json/JSONArray:length	()I
    //   112: ifle +66 -> 178
    //   115: iconst_0
    //   116: istore 4
    //   118: iload_2
    //   119: istore 5
    //   121: iload_1
    //   122: istore_3
    //   123: iload 4
    //   125: aload_0
    //   126: invokevirtual 83	org/json/JSONArray:length	()I
    //   129: if_icmpge +49 -> 178
    //   132: aload 8
    //   134: aload_0
    //   135: iload 4
    //   137: invokevirtual 87	org/json/JSONArray:getInt	(I)I
    //   140: invokestatic 93	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   143: invokevirtual 97	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   146: pop
    //   147: iload 4
    //   149: iconst_1
    //   150: iadd
    //   151: istore 4
    //   153: goto -35 -> 118
    //   156: astore_0
    //   157: goto +12 -> 169
    //   160: astore_0
    //   161: goto +6 -> 167
    //   164: astore_0
    //   165: iconst_0
    //   166: istore_1
    //   167: iconst_0
    //   168: istore_2
    //   169: aload_0
    //   170: invokevirtual 100	org/json/JSONException:printStackTrace	()V
    //   173: iload_1
    //   174: istore_3
    //   175: iload_2
    //   176: istore 5
    //   178: new 2	com/tencent/mobileqq/troop/luckycharacter/config/TroopLuckyCharacterConfig
    //   181: dup
    //   182: invokespecial 101	com/tencent/mobileqq/troop/luckycharacter/config/TroopLuckyCharacterConfig:<init>	()V
    //   185: astore_0
    //   186: iload_3
    //   187: ifeq +9 -> 196
    //   190: iconst_1
    //   191: istore 6
    //   193: goto +6 -> 199
    //   196: iconst_0
    //   197: istore 6
    //   199: aload_0
    //   200: iload 6
    //   202: putfield 16	com/tencent/mobileqq/troop/luckycharacter/config/TroopLuckyCharacterConfig:a	Z
    //   205: iload 7
    //   207: istore 6
    //   209: iload 5
    //   211: ifeq +6 -> 217
    //   214: iconst_1
    //   215: istore 6
    //   217: aload_0
    //   218: iload 6
    //   220: putfield 18	com/tencent/mobileqq/troop/luckycharacter/config/TroopLuckyCharacterConfig:b	Z
    //   223: aload_0
    //   224: aload 8
    //   226: putfield 23	com/tencent/mobileqq/troop/luckycharacter/config/TroopLuckyCharacterConfig:c	Ljava/util/ArrayList;
    //   229: invokestatic 33	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq +80 -> 312
    //   235: new 35	java/lang/StringBuilder
    //   238: dup
    //   239: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   242: astore 8
    //   244: aload 8
    //   246: ldc 103
    //   248: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload 8
    //   254: aload_0
    //   255: getfield 16	com/tencent/mobileqq/troop/luckycharacter/config/TroopLuckyCharacterConfig:a	Z
    //   258: invokevirtual 106	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   261: pop
    //   262: aload 8
    //   264: ldc 108
    //   266: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   269: pop
    //   270: aload 8
    //   272: aload_0
    //   273: getfield 18	com/tencent/mobileqq/troop/luckycharacter/config/TroopLuckyCharacterConfig:b	Z
    //   276: invokevirtual 106	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   279: pop
    //   280: aload 8
    //   282: ldc 110
    //   284: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 8
    //   290: aload_0
    //   291: getfield 23	com/tencent/mobileqq/troop/luckycharacter/config/TroopLuckyCharacterConfig:c	Ljava/util/ArrayList;
    //   294: invokevirtual 111	java/util/ArrayList:toString	()Ljava/lang/String;
    //   297: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: ldc 44
    //   303: iconst_2
    //   304: aload 8
    //   306: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokestatic 52	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   312: aload_0
    //   313: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	314	0	paramString	String
    //   78	96	1	i	int
    //   86	90	2	j	int
    //   98	89	3	k	int
    //   116	36	4	m	int
    //   95	115	5	n	int
    //   191	28	6	bool1	boolean
    //   60	146	7	bool2	boolean
    //   13	292	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   87	94	156	org/json/JSONException
    //   108	115	156	org/json/JSONException
    //   123	147	156	org/json/JSONException
    //   79	87	160	org/json/JSONException
    //   62	79	164	org/json/JSONException
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public boolean b(String paramString)
  {
    boolean bool1 = TextUtils.isEmpty(paramString);
    int i = 0;
    if (bool1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopLuckyCharacterConfig", 2, "isGrayTroop : troopUin error");
      }
      return false;
    }
    boolean bool2 = this.a;
    if (bool2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopLuckyCharacterConfig", 2, "isGrayTroop : true");
      }
      return bool2;
    }
    paramString = paramString.substring(paramString.length() - 1);
    for (;;)
    {
      bool1 = bool2;
      if (i >= this.c.size()) {
        break;
      }
      if (((String)this.c.get(i)).equals(paramString))
      {
        bool1 = true;
        break;
      }
      i += 1;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("isGrayTroop : ");
      paramString.append(bool1);
      QLog.d("TroopLuckyCharacterConfig", 2, paramString.toString());
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.luckycharacter.config.TroopLuckyCharacterConfig
 * JD-Core Version:    0.7.0.1
 */