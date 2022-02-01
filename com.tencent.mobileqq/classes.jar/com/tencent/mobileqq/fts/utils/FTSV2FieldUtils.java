package com.tencent.mobileqq.fts.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.fts.v2.entity.FTSEntityV2;
import com.tencent.mobileqq.fts.v2.entity.index;
import com.tencent.mobileqq.fts.v2.entity.notColumn;
import com.tencent.mobileqq.fts.v2.entity.notIndex;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class FTSV2FieldUtils
{
  public static final Map<Class<?>, String> a;
  public static ConcurrentHashMap<Class, LinkedHashMap<String, Field>> a;
  public static ConcurrentHashMap<Class, LinkedHashSet<Field>> b = new ConcurrentHashMap();
  public static ConcurrentHashMap<Class, LinkedHashSet<Field>> c = new ConcurrentHashMap();
  public static ConcurrentHashMap<Class, FTSEntityV2> d = new ConcurrentHashMap();
  
  static
  {
    jdField_a_of_type_JavaUtilMap = new HashMap();
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static int a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int i = 0;
    if (bool) {
      return 0;
    }
    paramString = paramString.split(" ");
    if (paramString != null) {
      i = paramString.length;
    }
    return i;
  }
  
  public static FTSEntityV2 a(Class<? extends FTSEntityV2> paramClass)
  {
    FTSEntityV2 localFTSEntityV2 = (FTSEntityV2)d.get(paramClass);
    if (localFTSEntityV2 == null) {
      try
      {
        localFTSEntityV2 = (FTSEntityV2)paramClass.newInstance();
        d.put(paramClass, localFTSEntityV2);
        return localFTSEntityV2;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramClass.getSimpleName());
        localStringBuilder.append(" must have an empty constructor. ");
        throw new RuntimeException(localStringBuilder.toString(), localException);
      }
    }
    return localException;
  }
  
  /* Error */
  public static String a(String paramString)
  {
    // Byte code:
    //   0: new 72	java/lang/StringBuilder
    //   3: dup
    //   4: bipush 64
    //   6: invokespecial 101	java/lang/StringBuilder:<init>	(I)V
    //   9: astore_2
    //   10: new 103	com/tencent/mobileqq/fts/v2/tokenizer/cjk/CJKTokenizer
    //   13: dup
    //   14: new 105	java/io/StringReader
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 108	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   22: aload_0
    //   23: invokevirtual 112	java/lang/String:length	()I
    //   26: invokespecial 115	com/tencent/mobileqq/fts/v2/tokenizer/cjk/CJKTokenizer:<init>	(Ljava/io/Reader;I)V
    //   29: astore_3
    //   30: aconst_null
    //   31: astore_0
    //   32: aload_3
    //   33: invokevirtual 118	com/tencent/mobileqq/fts/v2/tokenizer/cjk/CJKTokenizer:a	()Lcom/tencent/mobileqq/fts/v2/tokenizer/Token;
    //   36: astore_1
    //   37: aload_1
    //   38: ifnonnull +60 -> 98
    //   41: aload_0
    //   42: ifnull +199 -> 241
    //   45: aload_0
    //   46: invokevirtual 122	com/tencent/mobileqq/fts/v2/tokenizer/Token:b	()Ljava/lang/String;
    //   49: ldc 124
    //   51: invokestatic 128	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   54: ifeq +187 -> 241
    //   57: aload_0
    //   58: invokevirtual 130	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   61: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifne +177 -> 241
    //   67: aload_2
    //   68: aload_0
    //   69: invokevirtual 130	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   72: aload_0
    //   73: invokevirtual 130	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   76: invokevirtual 112	java/lang/String:length	()I
    //   79: iconst_1
    //   80: isub
    //   81: invokevirtual 134	java/lang/String:charAt	(I)C
    //   84: invokevirtual 137	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_2
    //   89: ldc 139
    //   91: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: goto +146 -> 241
    //   98: aload_0
    //   99: ifnull +83 -> 182
    //   102: aload_0
    //   103: invokevirtual 122	com/tencent/mobileqq/fts/v2/tokenizer/Token:b	()Ljava/lang/String;
    //   106: ldc 124
    //   108: invokestatic 128	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   111: ifeq +71 -> 182
    //   114: aload_1
    //   115: invokevirtual 122	com/tencent/mobileqq/fts/v2/tokenizer/Token:b	()Ljava/lang/String;
    //   118: ldc 124
    //   120: invokestatic 128	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   123: ifeq +14 -> 137
    //   126: aload_0
    //   127: invokevirtual 141	com/tencent/mobileqq/fts/v2/tokenizer/Token:b	()I
    //   130: aload_1
    //   131: invokevirtual 143	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()I
    //   134: if_icmpge +48 -> 182
    //   137: aload_0
    //   138: invokevirtual 130	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   141: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   144: ifne +38 -> 182
    //   147: aload_2
    //   148: aload_0
    //   149: invokevirtual 130	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   152: aload_0
    //   153: invokevirtual 130	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   156: invokevirtual 112	java/lang/String:length	()I
    //   159: iconst_1
    //   160: isub
    //   161: invokevirtual 134	java/lang/String:charAt	(I)C
    //   164: invokevirtual 137	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload_2
    //   169: ldc 139
    //   171: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_2
    //   176: bipush 32
    //   178: invokevirtual 137	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload_1
    //   183: invokevirtual 130	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   186: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   189: ifne +42 -> 231
    //   192: aload_1
    //   193: invokevirtual 122	com/tencent/mobileqq/fts/v2/tokenizer/Token:b	()Ljava/lang/String;
    //   196: ldc 124
    //   198: invokestatic 128	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   201: ifeq +14 -> 215
    //   204: aload_1
    //   205: invokevirtual 130	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   208: invokevirtual 112	java/lang/String:length	()I
    //   211: iconst_1
    //   212: if_icmpeq +19 -> 231
    //   215: aload_2
    //   216: aload_1
    //   217: invokevirtual 130	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   220: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_2
    //   225: bipush 32
    //   227: invokevirtual 137	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload_1
    //   232: astore_0
    //   233: goto -201 -> 32
    //   236: astore_0
    //   237: aload_0
    //   238: invokevirtual 146	java/io/IOException:printStackTrace	()V
    //   241: aload_2
    //   242: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: astore_0
    //   246: aload_0
    //   247: areturn
    //   248: astore_0
    //   249: aload_0
    //   250: invokevirtual 147	java/lang/Throwable:printStackTrace	()V
    //   253: aconst_null
    //   254: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	paramString	String
    //   36	196	1	localToken	com.tencent.mobileqq.fts.v2.tokenizer.Token
    //   9	233	2	localStringBuilder	StringBuilder
    //   29	4	3	localCJKTokenizer	com.tencent.mobileqq.fts.v2.tokenizer.cjk.CJKTokenizer
    // Exception table:
    //   from	to	target	type
    //   32	37	236	java/io/IOException
    //   45	95	236	java/io/IOException
    //   102	137	236	java/io/IOException
    //   137	182	236	java/io/IOException
    //   182	215	236	java/io/IOException
    //   215	231	236	java/io/IOException
    //   0	30	248	java/lang/Throwable
    //   32	37	248	java/lang/Throwable
    //   45	95	248	java/lang/Throwable
    //   102	137	248	java/lang/Throwable
    //   137	182	248	java/lang/Throwable
    //   182	215	248	java/lang/Throwable
    //   215	231	248	java/lang/Throwable
    //   237	241	248	java/lang/Throwable
    //   241	246	248	java/lang/Throwable
  }
  
  public static Map<String, Field> a(Class<? extends FTSEntityV2> paramClass)
  {
    Object localObject2 = (LinkedHashMap)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramClass);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      Field[] arrayOfField = paramClass.getFields();
      LinkedHashMap localLinkedHashMap = new LinkedHashMap();
      localObject2 = (LinkedHashSet)b.get(paramClass);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new LinkedHashSet();
        b.put(paramClass, localObject1);
      }
      Object localObject3 = (LinkedHashSet)c.get(paramClass);
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject2 = new LinkedHashSet();
        c.put(paramClass, localObject2);
      }
      int i = 0;
      int j = arrayOfField.length;
      while (i < j)
      {
        localObject3 = arrayOfField[i];
        if (!((Field)localObject3).isAnnotationPresent(notColumn.class))
        {
          if (!((Field)localObject3).getDeclaringClass().equals(FTSEntityV2.class))
          {
            localObject4 = ((Field)localObject3).getName();
            if ((((String)localObject4).equals("ext1")) || (((String)localObject4).equals("ext2")) || (((String)localObject4).equals("ext3")) || (((String)localObject4).equals("exts")))
            {
              paramClass = new StringBuilder();
              paramClass.append("Field '");
              paramClass.append((String)localObject4);
              paramClass.append("' cannot be declared in subclass. It is a reserved field in FTSEntity.");
              throw new RuntimeException(paramClass.toString());
            }
          }
          if (((Field)localObject3).isAnnotationPresent(index.class)) {
            if (((Field)localObject3).getType().equals(String.class))
            {
              ((LinkedHashSet)localObject1).add(localObject3);
            }
            else
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(paramClass.getSimpleName());
              ((StringBuilder)localObject1).append("The type of Filed declared with @index must be String. Field is ");
              ((StringBuilder)localObject1).append(((Field)localObject3).getName());
              throw new RuntimeException(((StringBuilder)localObject1).toString());
            }
          }
          if (((Field)localObject3).isAnnotationPresent(notIndex.class)) {
            ((LinkedHashSet)localObject2).add(localObject3);
          }
          ((Field)localObject3).getName();
          Object localObject4 = ((Field)localObject3).getType();
          if ((String)jdField_a_of_type_JavaUtilMap.get(localObject4) != null) {
            localLinkedHashMap.put(((Field)localObject3).getName(), localObject3);
          }
        }
        i += 1;
      }
      jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramClass, localLinkedHashMap);
      localObject1 = localLinkedHashMap;
    }
    return localObject1;
  }
  
  public static Set<Field> a(Class<? extends FTSEntityV2> paramClass)
  {
    Set localSet2 = (Set)b.get(paramClass);
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      a(paramClass);
      localSet1 = (Set)b.get(paramClass);
    }
    return localSet1;
  }
  
  /* Error */
  public static String b(String paramString)
  {
    // Byte code:
    //   0: new 72	java/lang/StringBuilder
    //   3: dup
    //   4: bipush 64
    //   6: invokespecial 101	java/lang/StringBuilder:<init>	(I)V
    //   9: astore_2
    //   10: new 103	com/tencent/mobileqq/fts/v2/tokenizer/cjk/CJKTokenizer
    //   13: dup
    //   14: new 105	java/io/StringReader
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 108	java/io/StringReader:<init>	(Ljava/lang/String;)V
    //   22: aload_0
    //   23: invokevirtual 112	java/lang/String:length	()I
    //   26: invokespecial 115	com/tencent/mobileqq/fts/v2/tokenizer/cjk/CJKTokenizer:<init>	(Ljava/io/Reader;I)V
    //   29: astore_3
    //   30: aconst_null
    //   31: astore_0
    //   32: aload_3
    //   33: invokevirtual 118	com/tencent/mobileqq/fts/v2/tokenizer/cjk/CJKTokenizer:a	()Lcom/tencent/mobileqq/fts/v2/tokenizer/Token;
    //   36: astore_1
    //   37: aload_1
    //   38: ifnonnull +60 -> 98
    //   41: aload_0
    //   42: ifnull +214 -> 256
    //   45: aload_0
    //   46: invokevirtual 122	com/tencent/mobileqq/fts/v2/tokenizer/Token:b	()Ljava/lang/String;
    //   49: ldc 124
    //   51: invokestatic 128	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   54: ifeq +202 -> 256
    //   57: aload_0
    //   58: invokevirtual 130	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   61: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifne +192 -> 256
    //   67: aload_2
    //   68: aload_0
    //   69: invokevirtual 130	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   72: aload_0
    //   73: invokevirtual 130	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   76: invokevirtual 112	java/lang/String:length	()I
    //   79: iconst_1
    //   80: isub
    //   81: invokevirtual 134	java/lang/String:charAt	(I)C
    //   84: invokevirtual 137	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   87: pop
    //   88: aload_2
    //   89: ldc 139
    //   91: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: goto +161 -> 256
    //   98: aload_0
    //   99: ifnull +83 -> 182
    //   102: aload_0
    //   103: invokevirtual 122	com/tencent/mobileqq/fts/v2/tokenizer/Token:b	()Ljava/lang/String;
    //   106: ldc 124
    //   108: invokestatic 128	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   111: ifeq +71 -> 182
    //   114: aload_1
    //   115: invokevirtual 122	com/tencent/mobileqq/fts/v2/tokenizer/Token:b	()Ljava/lang/String;
    //   118: ldc 124
    //   120: invokestatic 128	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   123: ifeq +14 -> 137
    //   126: aload_0
    //   127: invokevirtual 141	com/tencent/mobileqq/fts/v2/tokenizer/Token:b	()I
    //   130: aload_1
    //   131: invokevirtual 143	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()I
    //   134: if_icmpge +48 -> 182
    //   137: aload_0
    //   138: invokevirtual 130	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   141: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   144: ifne +38 -> 182
    //   147: aload_2
    //   148: aload_0
    //   149: invokevirtual 130	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   152: aload_0
    //   153: invokevirtual 130	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   156: invokevirtual 112	java/lang/String:length	()I
    //   159: iconst_1
    //   160: isub
    //   161: invokevirtual 134	java/lang/String:charAt	(I)C
    //   164: invokevirtual 137	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: aload_2
    //   169: ldc 139
    //   171: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_2
    //   176: bipush 32
    //   178: invokevirtual 137	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload_1
    //   183: invokevirtual 130	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   186: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   189: ifne +42 -> 231
    //   192: aload_1
    //   193: invokevirtual 122	com/tencent/mobileqq/fts/v2/tokenizer/Token:b	()Ljava/lang/String;
    //   196: ldc 124
    //   198: invokestatic 128	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   201: ifeq +14 -> 215
    //   204: aload_1
    //   205: invokevirtual 130	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   208: invokevirtual 112	java/lang/String:length	()I
    //   211: iconst_1
    //   212: if_icmpeq +19 -> 231
    //   215: aload_2
    //   216: aload_1
    //   217: invokevirtual 130	com/tencent/mobileqq/fts/v2/tokenizer/Token:a	()Ljava/lang/String;
    //   220: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_2
    //   225: bipush 32
    //   227: invokevirtual 137	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload_1
    //   232: astore_0
    //   233: goto -201 -> 32
    //   236: astore_0
    //   237: aload_0
    //   238: invokevirtual 146	java/io/IOException:printStackTrace	()V
    //   241: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   244: ifeq +12 -> 256
    //   247: ldc 221
    //   249: iconst_2
    //   250: ldc 223
    //   252: aload_0
    //   253: invokestatic 227	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   256: aload_2
    //   257: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: astore_0
    //   261: aload_0
    //   262: areturn
    //   263: astore_0
    //   264: aload_0
    //   265: invokevirtual 147	java/lang/Throwable:printStackTrace	()V
    //   268: invokestatic 219	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   271: ifeq +12 -> 283
    //   274: ldc 221
    //   276: iconst_2
    //   277: ldc 223
    //   279: aload_0
    //   280: invokestatic 227	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   283: aconst_null
    //   284: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	paramString	String
    //   36	196	1	localToken	com.tencent.mobileqq.fts.v2.tokenizer.Token
    //   9	248	2	localStringBuilder	StringBuilder
    //   29	4	3	localCJKTokenizer	com.tencent.mobileqq.fts.v2.tokenizer.cjk.CJKTokenizer
    // Exception table:
    //   from	to	target	type
    //   32	37	236	java/io/IOException
    //   45	95	236	java/io/IOException
    //   102	137	236	java/io/IOException
    //   137	182	236	java/io/IOException
    //   182	215	236	java/io/IOException
    //   215	231	236	java/io/IOException
    //   0	30	263	java/lang/Throwable
    //   32	37	263	java/lang/Throwable
    //   45	95	263	java/lang/Throwable
    //   102	137	263	java/lang/Throwable
    //   137	182	263	java/lang/Throwable
    //   182	215	263	java/lang/Throwable
    //   215	231	263	java/lang/Throwable
    //   237	256	263	java/lang/Throwable
    //   256	261	263	java/lang/Throwable
  }
  
  public static Set<Field> b(Class<? extends FTSEntityV2> paramClass)
  {
    Set localSet2 = (Set)c.get(paramClass);
    Set localSet1 = localSet2;
    if (localSet2 == null)
    {
      a(paramClass);
      localSet1 = (Set)c.get(paramClass);
    }
    return localSet1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.utils.FTSV2FieldUtils
 * JD-Core Version:    0.7.0.1
 */