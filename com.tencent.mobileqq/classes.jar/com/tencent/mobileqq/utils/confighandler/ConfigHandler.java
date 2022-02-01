package com.tencent.mobileqq.utils.confighandler;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.ParameterizedType;

public abstract class ConfigHandler<T extends ConfigInfo>
{
  protected final String TAG;
  private final Class<T> mConfigInfoClass;
  protected final String mUin;
  
  public ConfigHandler(String paramString1, String paramString2)
  {
    Object localObject = paramString1;
    if (paramString1 == null) {
      localObject = getClass().getSimpleName();
    }
    paramString1 = getClass().getGenericSuperclass();
    if (paramString1 != null)
    {
      if ((paramString1 instanceof ParameterizedType))
      {
        paramString1 = ((ParameterizedType)paramString1).getActualTypeArguments();
        if (paramString1 != null)
        {
          if (paramString1.length > 0)
          {
            this.mConfigInfoClass = ((Class)paramString1[0]);
            paramString1 = new StringBuilder();
            paramString1.append("ConfigInfoClass[");
            paramString1.append(this.mConfigInfoClass);
            paramString1.append("]");
            paramString1 = paramString1.toString();
          }
          else
          {
            this.mConfigInfoClass = null;
            paramString1 = "ActualTypeArguments长度为0";
          }
        }
        else
        {
          this.mConfigInfoClass = null;
          paramString1 = "getActualTypeArguments为空";
        }
      }
      else
      {
        this.mConfigInfoClass = null;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("type[");
        localStringBuilder.append(paramString1.getClass().getName());
        localStringBuilder.append("]");
        paramString1 = localStringBuilder.toString();
      }
    }
    else
    {
      this.mConfigInfoClass = null;
      paramString1 = "getGenericSuperclass为空";
    }
    this.TAG = ((String)localObject);
    this.mUin = paramString2;
    if (this.mConfigInfoClass == null)
    {
      paramString2 = this.TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ConfigHandler, get ConfigInfoClassType失败, ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.w(paramString2, 1, ((StringBuilder)localObject).toString());
    }
    else if (QQAudioHelper.f())
    {
      paramString2 = this.TAG;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ConfigHandler, get ConfigInfoClassType成功, ");
      ((StringBuilder)localObject).append(this.mConfigInfoClass);
      QLog.w(paramString2, 1, ((StringBuilder)localObject).toString());
    }
    if (this.mConfigInfoClass == null)
    {
      if (!QQAudioHelper.b()) {
        return;
      }
      paramString2 = new StringBuilder();
      paramString2.append(this.TAG);
      paramString2.append(" get ConfigInfoClassType失败, ");
      paramString2.append(paramString1);
      throw new IllegalArgumentException(paramString2.toString());
    }
  }
  
  public static void checkUin(String paramString1, String paramString2)
  {
    if (QQAudioHelper.b())
    {
      if (!TextUtils.isEmpty(paramString2)) {
        return;
      }
      paramString2 = new StringBuilder();
      paramString2.append(paramString1);
      paramString2.append(" 配置需要UIN");
      throw new IllegalArgumentException(paramString2.toString());
    }
  }
  
  /* Error */
  public static <T extends ConfigInfo> T getConfigInfo(String paramString1, String paramString2, int paramInt, Class<T> paramClass, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 104	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: istore 10
    //   6: iconst_0
    //   7: istore 8
    //   9: aload_1
    //   10: astore 11
    //   12: iload_2
    //   13: istore 9
    //   15: iload 10
    //   17: ifeq +57 -> 74
    //   20: aload_0
    //   21: aload 4
    //   23: aload 5
    //   25: invokestatic 116	com/tencent/mobileqq/utils/configsp/BaseConfigSP:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   28: astore 5
    //   30: aload 5
    //   32: ifnull +33 -> 65
    //   35: aload 5
    //   37: aload 6
    //   39: aconst_null
    //   40: invokeinterface 122 3 0
    //   45: astore 11
    //   47: aload 5
    //   49: aload 7
    //   51: iconst_0
    //   52: invokeinterface 126 3 0
    //   57: istore 9
    //   59: iconst_1
    //   60: istore 8
    //   62: goto +12 -> 74
    //   65: iconst_2
    //   66: istore 8
    //   68: iload_2
    //   69: istore 9
    //   71: aload_1
    //   72: astore 11
    //   74: new 40	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   81: astore_1
    //   82: aload_1
    //   83: ldc 128
    //   85: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: pop
    //   89: aload_1
    //   90: iload 8
    //   92: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_1
    //   97: ldc 133
    //   99: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload_1
    //   104: aload 11
    //   106: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload_1
    //   111: ldc 135
    //   113: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload_1
    //   118: iload 9
    //   120: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload_1
    //   125: ldc 52
    //   127: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload_0
    //   132: iconst_1
    //   133: aload_1
    //   134: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 78	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   140: aload_3
    //   141: invokevirtual 64	java/lang/Class:getName	()Ljava/lang/String;
    //   144: astore 5
    //   146: aload_3
    //   147: invokevirtual 139	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   150: checkcast 141	com/tencent/mobileqq/utils/confighandler/ConfigInfo
    //   153: astore_1
    //   154: aload_1
    //   155: aload 4
    //   157: invokevirtual 144	com/tencent/mobileqq/utils/confighandler/ConfigInfo:setUin	(Ljava/lang/String;)V
    //   160: aload_1
    //   161: iload 9
    //   163: i2l
    //   164: putfield 148	com/tencent/mobileqq/utils/confighandler/ConfigInfo:serverVer	J
    //   167: aload_1
    //   168: astore_3
    //   169: aload_1
    //   170: aload_0
    //   171: aload 11
    //   173: invokevirtual 152	com/tencent/mobileqq/utils/confighandler/ConfigInfo:tryParse	(Ljava/lang/String;Ljava/lang/String;)Z
    //   176: ifne +106 -> 282
    //   179: new 40	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   186: astore_3
    //   187: aload_3
    //   188: aload_0
    //   189: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: aload_3
    //   194: ldc 153
    //   196: invokestatic 158	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   199: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: pop
    //   203: aload_3
    //   204: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 161	com/tencent/mobileqq/utils/QQAudioHelper:c	(Ljava/lang/String;)V
    //   210: aload_1
    //   211: areturn
    //   212: astore_3
    //   213: aload 5
    //   215: astore 4
    //   217: goto +19 -> 236
    //   220: astore_3
    //   221: aconst_null
    //   222: astore_1
    //   223: aload 5
    //   225: astore 4
    //   227: goto +9 -> 236
    //   230: astore_3
    //   231: aconst_null
    //   232: astore_1
    //   233: aload_1
    //   234: astore 4
    //   236: new 40	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   243: astore 5
    //   245: aload 5
    //   247: ldc 163
    //   249: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload 5
    //   255: aload 4
    //   257: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: pop
    //   261: aload 5
    //   263: ldc 52
    //   265: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: pop
    //   269: aload_0
    //   270: iconst_1
    //   271: aload 5
    //   273: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: aload_3
    //   277: invokestatic 166	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   280: aload_1
    //   281: astore_3
    //   282: aload_3
    //   283: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	284	0	paramString1	String
    //   0	284	1	paramString2	String
    //   0	284	2	paramInt	int
    //   0	284	3	paramClass	Class<T>
    //   0	284	4	paramString3	String
    //   0	284	5	paramString4	String
    //   0	284	6	paramString5	String
    //   0	284	7	paramString6	String
    //   7	84	8	i	int
    //   13	149	9	j	int
    //   4	12	10	bool	boolean
    //   10	162	11	str	String
    // Exception table:
    //   from	to	target	type
    //   154	167	212	java/lang/Exception
    //   169	210	212	java/lang/Exception
    //   146	154	220	java/lang/Exception
    //   140	146	230	java/lang/Exception
  }
  
  /* Error */
  public static <T extends ConfigInfo> T getConfigInfoNew(String paramString1, String paramString2, int paramInt, Class<T> paramClass, String paramString3)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 104	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +15 -> 19
    //   7: iload_2
    //   8: invokestatic 175	com/tencent/av/ManageConfig/QAVConfig:b	(I)Lcom/tencent/av/ManageConfig/QAVConfItem;
    //   11: getfield 179	com/tencent/av/ManageConfig/QAVConfItem:b	Ljava/lang/String;
    //   14: astore 5
    //   16: goto +48 -> 64
    //   19: new 40	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   26: astore 5
    //   28: aload 5
    //   30: ldc 181
    //   32: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload 5
    //   38: aload_1
    //   39: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload 5
    //   45: ldc 52
    //   47: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_0
    //   52: iconst_1
    //   53: aload 5
    //   55: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 78	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: aload_1
    //   62: astore 5
    //   64: aload_3
    //   65: invokevirtual 64	java/lang/Class:getName	()Ljava/lang/String;
    //   68: astore 6
    //   70: aload_3
    //   71: invokevirtual 139	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   74: checkcast 141	com/tencent/mobileqq/utils/confighandler/ConfigInfo
    //   77: astore_1
    //   78: aload_1
    //   79: aload 4
    //   81: invokevirtual 144	com/tencent/mobileqq/utils/confighandler/ConfigInfo:setUin	(Ljava/lang/String;)V
    //   84: aload_1
    //   85: iload_2
    //   86: invokestatic 184	com/tencent/av/ManageConfig/QAVConfig:c	(I)I
    //   89: i2l
    //   90: putfield 148	com/tencent/mobileqq/utils/confighandler/ConfigInfo:serverVer	J
    //   93: aload_1
    //   94: astore_3
    //   95: aload_1
    //   96: aload_0
    //   97: aload 5
    //   99: invokevirtual 152	com/tencent/mobileqq/utils/confighandler/ConfigInfo:tryParse	(Ljava/lang/String;Ljava/lang/String;)Z
    //   102: ifne +106 -> 208
    //   105: new 40	java/lang/StringBuilder
    //   108: dup
    //   109: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   112: astore_3
    //   113: aload_3
    //   114: aload_0
    //   115: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_3
    //   120: ldc 185
    //   122: invokestatic 158	com/tencent/mobileqq/app/HardCodeUtil:a	(I)Ljava/lang/String;
    //   125: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload_3
    //   130: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 161	com/tencent/mobileqq/utils/QQAudioHelper:c	(Ljava/lang/String;)V
    //   136: aload_1
    //   137: areturn
    //   138: astore_3
    //   139: aload 6
    //   141: astore 4
    //   143: goto +19 -> 162
    //   146: astore_3
    //   147: aconst_null
    //   148: astore_1
    //   149: aload 6
    //   151: astore 4
    //   153: goto +9 -> 162
    //   156: astore_3
    //   157: aconst_null
    //   158: astore_1
    //   159: aload_1
    //   160: astore 4
    //   162: new 40	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   169: astore 5
    //   171: aload 5
    //   173: ldc 163
    //   175: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: aload 5
    //   181: aload 4
    //   183: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: pop
    //   187: aload 5
    //   189: ldc 52
    //   191: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: aload_0
    //   196: iconst_1
    //   197: aload 5
    //   199: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: aload_3
    //   203: invokestatic 166	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   206: aload_1
    //   207: astore_3
    //   208: aload_3
    //   209: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	paramString1	String
    //   0	210	1	paramString2	String
    //   0	210	2	paramInt	int
    //   0	210	3	paramClass	Class<T>
    //   0	210	4	paramString3	String
    //   14	184	5	localObject	Object
    //   68	82	6	str	String
    // Exception table:
    //   from	to	target	type
    //   78	93	138	java/lang/Exception
    //   95	136	138	java/lang/Exception
    //   70	78	146	java/lang/Exception
    //   64	70	156	java/lang/Exception
  }
  
  public static int getConfigVer(SharedPreferences paramSharedPreferences, String paramString1, String paramString2)
  {
    int j = 0;
    int i = j;
    if (paramSharedPreferences != null)
    {
      i = j;
      if (!TextUtils.isEmpty(paramSharedPreferences.getString(paramString1, null))) {
        i = paramSharedPreferences.getInt(paramString2, 0);
      }
    }
    return i;
  }
  
  public static void saveConfigSP(String paramString1, SharedPreferences paramSharedPreferences, String paramString2, int paramInt, String paramString3, String paramString4)
  {
    if (paramSharedPreferences != null)
    {
      if (TextUtils.isEmpty(paramString2)) {
        paramSharedPreferences.edit().remove(paramString3);
      } else {
        paramSharedPreferences.edit().putString(paramString3, paramString2);
      }
      paramSharedPreferences.edit().putInt(paramString4, paramInt);
      paramSharedPreferences.edit().commit();
      return;
    }
    QLog.w(paramString1, 1, "saveConfig, sp为null");
  }
  
  public void doOnReconnect(QQAppInterface paramQQAppInterface) {}
  
  public final Class<T> getConfigInfoClass()
  {
    return this.mConfigInfoClass;
  }
  
  public abstract int getConfigVer();
  
  public final String getTag()
  {
    return this.TAG;
  }
  
  public abstract void onGetConfigFinish(QQAppInterface paramQQAppInterface, String paramString, T paramT);
  
  public abstract void saveConfig(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.confighandler.ConfigHandler
 * JD-Core Version:    0.7.0.1
 */