package com.tencent.mobileqq.earlydownload;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.earlydownload.xmldata.XmlData;
import com.tencent.mobileqq.earlydownload.xmldata.saveInSP;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import mqq.app.MobileQQ;
import org.xml.sax.SAXException;

public class EarlyDataFactory
{
  /* Error */
  public static XmlData a(Class<? extends XmlData> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: aload_0
    //   7: invokevirtual 21	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   10: checkcast 23	com/tencent/mobileqq/earlydownload/xmldata/XmlData
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 27	com/tencent/mobileqq/earlydownload/xmldata/XmlData:getSharedPreferencesName	()Ljava/lang/String;
    //   18: astore 4
    //   20: getstatic 33	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   23: invokevirtual 37	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   26: aload 4
    //   28: iconst_4
    //   29: invokevirtual 43	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   32: astore 4
    //   34: aload_0
    //   35: invokestatic 46	com/tencent/mobileqq/earlydownload/EarlyDataFactory:a	(Ljava/lang/Class;)[Ljava/lang/reflect/Field;
    //   38: astore 5
    //   40: aload_3
    //   41: astore_0
    //   42: aload 5
    //   44: ifnull +286 -> 330
    //   47: aload 5
    //   49: arraylength
    //   50: istore_2
    //   51: iconst_0
    //   52: istore_1
    //   53: aload_3
    //   54: astore_0
    //   55: iload_1
    //   56: iload_2
    //   57: if_icmpge +273 -> 330
    //   60: aload 5
    //   62: iload_1
    //   63: aaload
    //   64: astore 7
    //   66: aload 7
    //   68: ldc 48
    //   70: invokevirtual 54	java/lang/reflect/Field:isAnnotationPresent	(Ljava/lang/Class;)Z
    //   73: ifeq +224 -> 297
    //   76: aload 7
    //   78: invokevirtual 58	java/lang/reflect/Field:isAccessible	()Z
    //   81: ifne +9 -> 90
    //   84: aload 7
    //   86: iconst_1
    //   87: invokevirtual 62	java/lang/reflect/Field:setAccessible	(Z)V
    //   90: aload 7
    //   92: invokevirtual 65	java/lang/reflect/Field:getName	()Ljava/lang/String;
    //   95: astore_0
    //   96: aload 7
    //   98: invokevirtual 69	java/lang/reflect/Field:getType	()Ljava/lang/Class;
    //   101: astore 6
    //   103: aload 6
    //   105: ldc 71
    //   107: if_acmpne +22 -> 129
    //   110: aload 7
    //   112: aload_3
    //   113: aload 4
    //   115: aload_0
    //   116: ldc 73
    //   118: invokeinterface 79 3 0
    //   123: invokevirtual 83	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   126: goto +171 -> 297
    //   129: aload 6
    //   131: getstatic 89	java/lang/Long:TYPE	Ljava/lang/Class;
    //   134: if_acmpne +21 -> 155
    //   137: aload 7
    //   139: aload_3
    //   140: aload 4
    //   142: aload_0
    //   143: lconst_0
    //   144: invokeinterface 93 4 0
    //   149: invokevirtual 97	java/lang/reflect/Field:setLong	(Ljava/lang/Object;J)V
    //   152: goto +145 -> 297
    //   155: aload 6
    //   157: getstatic 100	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   160: if_acmpne +21 -> 181
    //   163: aload 7
    //   165: aload_3
    //   166: aload 4
    //   168: aload_0
    //   169: iconst_0
    //   170: invokeinterface 104 3 0
    //   175: invokevirtual 108	java/lang/reflect/Field:setInt	(Ljava/lang/Object;I)V
    //   178: goto +119 -> 297
    //   181: aload 6
    //   183: getstatic 111	java/lang/Float:TYPE	Ljava/lang/Class;
    //   186: if_acmpne +21 -> 207
    //   189: aload 7
    //   191: aload_3
    //   192: aload 4
    //   194: aload_0
    //   195: fconst_0
    //   196: invokeinterface 115 3 0
    //   201: invokevirtual 119	java/lang/reflect/Field:setFloat	(Ljava/lang/Object;F)V
    //   204: goto +93 -> 297
    //   207: aload 6
    //   209: getstatic 122	java/lang/Boolean:TYPE	Ljava/lang/Class;
    //   212: if_acmpne +21 -> 233
    //   215: aload 7
    //   217: aload_3
    //   218: aload 4
    //   220: aload_0
    //   221: iconst_0
    //   222: invokeinterface 126 3 0
    //   227: invokevirtual 130	java/lang/reflect/Field:setBoolean	(Ljava/lang/Object;Z)V
    //   230: goto +67 -> 297
    //   233: new 132	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   240: astore 4
    //   242: aload 4
    //   244: ldc 135
    //   246: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 4
    //   252: aload_0
    //   253: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: pop
    //   257: aload 4
    //   259: ldc 141
    //   261: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload 4
    //   267: aload 6
    //   269: invokevirtual 144	java/lang/Object:toString	()Ljava/lang/String;
    //   272: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload 4
    //   278: ldc 146
    //   280: invokevirtual 139	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: pop
    //   284: new 148	java/lang/RuntimeException
    //   287: dup
    //   288: aload 4
    //   290: invokevirtual 149	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokespecial 152	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   296: athrow
    //   297: iload_1
    //   298: iconst_1
    //   299: iadd
    //   300: istore_1
    //   301: goto -248 -> 53
    //   304: astore_0
    //   305: goto +10 -> 315
    //   308: astore_0
    //   309: goto +15 -> 324
    //   312: astore_0
    //   313: aconst_null
    //   314: astore_3
    //   315: aload_0
    //   316: invokevirtual 155	java/lang/IllegalAccessException:printStackTrace	()V
    //   319: aload_3
    //   320: areturn
    //   321: astore_0
    //   322: aconst_null
    //   323: astore_3
    //   324: aload_0
    //   325: invokevirtual 156	java/lang/InstantiationException:printStackTrace	()V
    //   328: aload_3
    //   329: astore_0
    //   330: aload_0
    //   331: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	332	0	paramClass	Class<? extends XmlData>
    //   52	249	1	i	int
    //   50	8	2	j	int
    //   13	316	3	localXmlData	XmlData
    //   18	271	4	localObject	Object
    //   38	23	5	arrayOfField	Field[]
    //   101	167	6	localClass	Class
    //   64	152	7	localField	Field
    // Exception table:
    //   from	to	target	type
    //   14	40	304	java/lang/IllegalAccessException
    //   47	51	304	java/lang/IllegalAccessException
    //   66	90	304	java/lang/IllegalAccessException
    //   90	103	304	java/lang/IllegalAccessException
    //   110	126	304	java/lang/IllegalAccessException
    //   129	152	304	java/lang/IllegalAccessException
    //   155	178	304	java/lang/IllegalAccessException
    //   181	204	304	java/lang/IllegalAccessException
    //   207	230	304	java/lang/IllegalAccessException
    //   233	297	304	java/lang/IllegalAccessException
    //   14	40	308	java/lang/InstantiationException
    //   47	51	308	java/lang/InstantiationException
    //   66	90	308	java/lang/InstantiationException
    //   90	103	308	java/lang/InstantiationException
    //   110	126	308	java/lang/InstantiationException
    //   129	152	308	java/lang/InstantiationException
    //   155	178	308	java/lang/InstantiationException
    //   181	204	308	java/lang/InstantiationException
    //   207	230	308	java/lang/InstantiationException
    //   233	297	308	java/lang/InstantiationException
    //   6	14	312	java/lang/IllegalAccessException
    //   6	14	321	java/lang/InstantiationException
  }
  
  public static XmlData a(Class<? extends XmlData> paramClass, String paramString1, String paramString2, String paramString3, long paramLong, String paramString4, String paramString5)
  {
    StringBuilder localStringBuilder = null;
    if ((paramClass != null) && (paramString1 != null) && (paramString1.length() != 0) && (paramString2 != null) && (paramString2.length() != 0) && (paramString3 != null) && (paramString3.length() != 0) && (paramString4 != null) && (paramString4.length() != 0))
    {
      try
      {
        paramClass = new EarlyXmlParser(paramClass);
        SAXParserFactory.newInstance().newSAXParser().parse(new ByteArrayInputStream(paramString3.getBytes()), paramClass);
        paramClass = paramClass.a();
      }
      catch (IOException paramString3)
      {
        paramClass = localStringBuilder;
        if (QLog.isColorLevel())
        {
          paramClass = new StringBuilder();
          paramClass.append("parse() throw Exception:");
          paramClass.append(paramString3.getMessage());
          QLog.e("EarlyDown", 2, paramClass.toString());
          paramClass = localStringBuilder;
        }
      }
      catch (SAXException paramString3)
      {
        paramClass = localStringBuilder;
        if (QLog.isColorLevel())
        {
          paramClass = new StringBuilder();
          paramClass.append("parse() throw Exception:");
          paramClass.append(paramString3.getMessage());
          QLog.e("EarlyDown", 2, paramClass.toString());
          paramClass = localStringBuilder;
        }
      }
      catch (ParserConfigurationException paramString3)
      {
        paramClass = localStringBuilder;
        if (QLog.isColorLevel())
        {
          paramClass = new StringBuilder();
          paramClass.append("parse() throw Exception:");
          paramClass.append(paramString3.getMessage());
          QLog.e("EarlyDown", 2, paramClass.toString());
          paramClass = localStringBuilder;
        }
      }
      if (paramClass != null)
      {
        paramClass.strResName = paramString1;
        paramClass.strPkgName = paramString2;
        paramClass.strResURL_big = paramString4;
        paramClass.strResURL_small = paramString5;
        paramClass.Version = ((int)paramLong);
      }
      return paramClass;
    }
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuffer();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("class=");
      if (paramClass == null) {
        paramClass = "null";
      } else {
        paramClass = paramClass.getCanonicalName();
      }
      localStringBuilder.append(paramClass);
      paramString2.append(localStringBuilder.toString());
      paramClass = new StringBuilder();
      paramClass.append(" resName=");
      paramClass.append(paramString1);
      paramString2.append(paramClass.toString());
      paramClass = new StringBuilder();
      paramClass.append(" resConf=");
      paramClass.append(paramString3);
      paramString2.append(paramClass.toString());
      paramClass = new StringBuilder();
      paramClass.append(" uiNewVer=");
      paramClass.append(paramLong);
      paramString2.append(paramClass.toString());
      paramClass = new StringBuilder();
      paramClass.append(" urlBig=");
      paramClass.append(paramString4);
      paramString2.append(paramClass.toString());
      paramClass = new StringBuilder();
      paramClass.append(" urlSmall=");
      paramClass.append(paramString5);
      paramString2.append(paramClass.toString());
      paramClass = new StringBuilder();
      paramClass.append("parse() return.");
      paramClass.append(paramString2.toString());
      QLog.d("EarlyDown", 2, paramClass.toString());
    }
    return null;
  }
  
  public static Field a(Class<? extends XmlData> paramClass, String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    Object localObject2 = localObject3;
    if (paramClass != null)
    {
      localObject2 = localObject3;
      if (paramString != null)
      {
        if (paramString.length() == 0) {
          return null;
        }
        for (;;)
        {
          localObject2 = localObject1;
          if (paramClass == Entity.class) {
            break;
          }
          try
          {
            localObject2 = paramClass.getDeclaredField(paramString);
            localObject1 = localObject2;
          }
          catch (NoSuchFieldException localNoSuchFieldException)
          {
            label45:
            break label45;
          }
          localObject2 = localObject1;
          if (localObject1 != null) {
            break;
          }
          paramClass = paramClass.getSuperclass();
        }
      }
    }
    return localObject2;
  }
  
  public static void a(XmlData paramXmlData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("freeSP() data=");
      String str;
      if (paramXmlData == null) {
        str = "null";
      } else {
        str = paramXmlData.getSharedPreferencesName();
      }
      localStringBuilder.append(str);
      QLog.d("EarlyDown", 2, localStringBuilder.toString());
    }
    if (paramXmlData == null) {
      return;
    }
    paramXmlData = paramXmlData.getSharedPreferencesName();
    paramXmlData = MobileQQ.sMobileQQ.getApplicationContext().getSharedPreferences(paramXmlData, 0).edit();
    paramXmlData.clear();
    paramXmlData.commit();
  }
  
  public static void a(XmlData paramXmlData, String... paramVarArgs)
  {
    if (paramXmlData == null) {
      return;
    }
    try
    {
      localObject1 = paramXmlData.getSharedPreferencesName();
      localObject2 = MobileQQ.sMobileQQ.getApplicationContext();
      j = 0;
      localEditor = ((Context)localObject2).getSharedPreferences((String)localObject1, 0).edit();
      localObject3 = paramXmlData.getClass();
      if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
        break label114;
      }
      localObject2 = new Field[paramVarArgs.length];
      i = 0;
    }
    finally
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        int j;
        SharedPreferences.Editor localEditor;
        Object localObject3;
        int i;
        label114:
        int k;
        for (;;)
        {
          throw paramXmlData;
        }
        i += 1;
        continue;
        i += 1;
      }
    }
    localObject1 = localObject2;
    if (i < paramVarArgs.length)
    {
      localObject1 = paramVarArgs[i];
      if ((localObject1 != null) && (((String)localObject1).length() != 0))
      {
        localObject2[i] = a((Class)localObject3, (String)localObject1);
        break label483;
        localObject1 = a((Class)localObject3);
      }
    }
    else
    {
      if (localObject1 != null)
      {
        k = localObject1.length;
        i = j;
        if (i < k)
        {
          localObject2 = localObject1[i];
          try
          {
            if ((!((Field)localObject2).isAnnotationPresent(saveInSP.class)) || (!((saveInSP)((Field)localObject2).getAnnotation(saveInSP.class)).b())) {
              break label490;
            }
            if (!((Field)localObject2).isAccessible()) {
              ((Field)localObject2).setAccessible(true);
            }
            paramVarArgs = ((Field)localObject2).getName();
            localObject3 = ((Field)localObject2).get(paramXmlData);
            if ((localObject3 instanceof String))
            {
              localEditor.putString(paramVarArgs, String.valueOf(localObject3));
              break label490;
            }
            if ((localObject3 instanceof Long))
            {
              localEditor.putLong(paramVarArgs, ((Long)localObject3).longValue());
              break label490;
            }
            if ((localObject3 instanceof Integer))
            {
              localEditor.putInt(paramVarArgs, ((Integer)localObject3).intValue());
              break label490;
            }
            if ((localObject3 instanceof Float))
            {
              localEditor.putFloat(paramVarArgs, ((Float)localObject3).floatValue());
              break label490;
            }
            if ((localObject3 instanceof Boolean))
            {
              localEditor.putBoolean(paramVarArgs, ((Boolean)localObject3).booleanValue());
              break label490;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Member name:");
            ((StringBuilder)localObject2).append(paramVarArgs);
            ((StringBuilder)localObject2).append("->Type:");
            if (localObject3 == null) {
              paramVarArgs = "NULL";
            } else {
              paramVarArgs = localObject3.getClass().getSimpleName().toString();
            }
            ((StringBuilder)localObject2).append(paramVarArgs);
            ((StringBuilder)localObject2).append(" is NOT SUPPORT!");
            throw new RuntimeException(((StringBuilder)localObject2).toString());
          }
          catch (IncompatibleClassChangeError paramVarArgs)
          {
            if (!QLog.isColorLevel()) {
              break label490;
            }
            QLog.d("earlyDown", 2, "EarlyDataFactory.saveToSP, IncompatibleClassChangeError", paramVarArgs);
          }
          catch (IllegalAccessException paramVarArgs)
          {
            paramVarArgs.printStackTrace();
          }
          catch (IllegalArgumentException paramVarArgs)
          {
            paramVarArgs.printStackTrace();
          }
        }
      }
      localEditor.commit();
      return;
    }
  }
  
  public static Field[] a(Class<? extends XmlData> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    int j;
    for (;;)
    {
      j = 0;
      i = 0;
      if (paramClass == Entity.class) {
        break;
      }
      Field[] arrayOfField = paramClass.getDeclaredFields();
      if (arrayOfField != null)
      {
        j = arrayOfField.length;
        while (i < j)
        {
          Field localField = arrayOfField[i];
          if ((localField != null) && (!Modifier.isStatic(localField.getModifiers()))) {
            localArrayList.add(localField);
          }
          i += 1;
        }
      }
      paramClass = paramClass.getSuperclass();
    }
    int k = localArrayList.size();
    paramClass = new Field[k];
    int i = j;
    while (i < k)
    {
      paramClass[i] = ((Field)localArrayList.get(i));
      i += 1;
    }
    return paramClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.earlydownload.EarlyDataFactory
 * JD-Core Version:    0.7.0.1
 */