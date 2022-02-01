package com.tencent.qqmini.sdk.utils;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBFixed64Field;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBPrimitiveField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBSFixed32Field;
import com.tencent.mobileqq.pb.PBSFixed64Field;
import com.tencent.mobileqq.pb.PBSInt32Field;
import com.tencent.mobileqq.pb.PBSInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GdtJsonPbUtil
{
  private static final String TAG = "GdtJsonPbUtil";
  
  private static void addOfPB(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == null) || (paramObject2 == null))
    {
      QMLog.e("GdtJsonPbUtil", "addOfPB error");
      return;
    }
    Method localMethod = null;
    for (;;)
    {
      try
      {
        if ((paramObject1 instanceof PBRepeatMessageField))
        {
          localMethod = PBRepeatMessageField.class.getDeclaredMethod("add", new Class[] { MessageMicro.class });
          if (localMethod != null) {
            break;
          }
          QMLog.e("GdtJsonPbUtil", "addOfPB error");
          return;
        }
      }
      catch (Throwable paramObject1)
      {
        QMLog.e("GdtJsonPbUtil", "addOfPB", paramObject1);
        return;
      }
      if ((paramObject1 instanceof PBRepeatField)) {
        localMethod = PBRepeatField.class.getDeclaredMethod("add", new Class[] { Object.class });
      }
    }
    localMethod.invoke(paramObject1, new Object[] { paramObject2 });
  }
  
  private static Object getOfPB(Object paramObject)
  {
    if (paramObject == null)
    {
      QMLog.e("GdtJsonPbUtil", "getOfPB error");
      return null;
    }
    try
    {
      paramObject = paramObject.getClass().getMethod("get", new Class[] { Void.class }).invoke(paramObject, new Object[0]);
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      QMLog.e("GdtJsonPbUtil", "getOfPB", paramObject);
    }
    return null;
  }
  
  /* Error */
  private static PBField getPbArrayField(PBField paramPBField)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokevirtual 57	java/lang/Object:getClass	()Ljava/lang/Class;
    //   6: ldc 75
    //   8: invokevirtual 79	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   11: astore_2
    //   12: aload_2
    //   13: invokevirtual 85	java/lang/reflect/Field:isAccessible	()Z
    //   16: istore_1
    //   17: aload_2
    //   18: iconst_1
    //   19: invokevirtual 89	java/lang/reflect/Field:setAccessible	(Z)V
    //   22: aload_2
    //   23: aload_0
    //   24: invokevirtual 91	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   27: astore_0
    //   28: aload_2
    //   29: iload_1
    //   30: invokevirtual 89	java/lang/reflect/Field:setAccessible	(Z)V
    //   33: aload_0
    //   34: instanceof 93
    //   37: ifeq +43 -> 80
    //   40: ldc 93
    //   42: aload_0
    //   43: invokevirtual 96	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   46: checkcast 93	com/tencent/mobileqq/pb/PBField
    //   49: astore_2
    //   50: aload_2
    //   51: areturn
    //   52: astore_2
    //   53: aconst_null
    //   54: astore_0
    //   55: ldc 8
    //   57: ldc 98
    //   59: aload_2
    //   60: invokestatic 41	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   63: goto -30 -> 33
    //   66: astore_2
    //   67: aconst_null
    //   68: astore_0
    //   69: ldc 8
    //   71: ldc 98
    //   73: aload_2
    //   74: invokestatic 41	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   77: goto -44 -> 33
    //   80: aload_3
    //   81: astore_2
    //   82: aload_0
    //   83: instanceof 31
    //   86: ifeq -36 -> 50
    //   89: aload_3
    //   90: astore_2
    //   91: aload_0
    //   92: checkcast 31	java/lang/Class
    //   95: invokevirtual 101	java/lang/Class:getSuperclass	()Ljava/lang/Class;
    //   98: ldc 33
    //   100: if_acmpne -50 -> 50
    //   103: ldc 31
    //   105: aload_0
    //   106: invokevirtual 96	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   109: checkcast 31	java/lang/Class
    //   112: invokevirtual 105	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   115: astore_0
    //   116: aload_3
    //   117: astore_2
    //   118: aload_0
    //   119: instanceof 33
    //   122: ifeq -72 -> 50
    //   125: ldc 33
    //   127: aload_0
    //   128: invokevirtual 96	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   131: checkcast 93	com/tencent/mobileqq/pb/PBField
    //   134: areturn
    //   135: astore_0
    //   136: ldc 8
    //   138: ldc 98
    //   140: aload_0
    //   141: invokestatic 41	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   144: aconst_null
    //   145: astore_0
    //   146: goto -30 -> 116
    //   149: astore_2
    //   150: goto -81 -> 69
    //   153: astore_2
    //   154: goto -99 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramPBField	PBField
    //   16	14	1	bool	boolean
    //   11	40	2	localObject1	Object
    //   52	8	2	localNoSuchFieldException1	NoSuchFieldException
    //   66	8	2	localIllegalAccessException1	IllegalAccessException
    //   81	37	2	localObject2	Object
    //   149	1	2	localIllegalAccessException2	IllegalAccessException
    //   153	1	2	localNoSuchFieldException2	NoSuchFieldException
    //   1	116	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	28	52	java/lang/NoSuchFieldException
    //   2	28	66	java/lang/IllegalAccessException
    //   103	116	135	java/lang/Exception
    //   28	33	149	java/lang/IllegalAccessException
    //   28	33	153	java/lang/NoSuchFieldException
  }
  
  private static PBPrimitiveField getPbPrimitiveFromJsonPrimitive(PBPrimitiveField paramPBPrimitiveField, Object paramObject)
  {
    try
    {
      if ((paramPBPrimitiveField instanceof PBBoolField)) {
        return PBField.initBool(Boolean.parseBoolean(paramObject.toString()));
      }
      if ((paramPBPrimitiveField instanceof PBDoubleField)) {
        return PBField.initDouble(Double.parseDouble(paramObject.toString()));
      }
      if ((paramPBPrimitiveField instanceof PBEnumField)) {
        return PBField.initEnum(Integer.parseInt(paramObject.toString()));
      }
      if ((paramPBPrimitiveField instanceof PBFixed32Field)) {
        return PBField.initFixed32(Integer.parseInt(paramObject.toString()));
      }
      if ((paramPBPrimitiveField instanceof PBFixed64Field)) {
        return PBField.initFixed64(Long.parseLong(paramObject.toString()));
      }
      if ((paramPBPrimitiveField instanceof PBFloatField)) {
        return PBField.initFloat(Float.parseFloat(paramObject.toString()));
      }
      if ((paramPBPrimitiveField instanceof PBInt32Field)) {
        return PBField.initInt32(Integer.parseInt(paramObject.toString()));
      }
      if ((paramPBPrimitiveField instanceof PBInt64Field)) {
        return PBField.initInt64(Long.parseLong(paramObject.toString()));
      }
      if ((paramPBPrimitiveField instanceof PBSFixed32Field)) {
        return PBField.initSFixed32(Integer.parseInt(paramObject.toString()));
      }
      if ((paramPBPrimitiveField instanceof PBSFixed64Field)) {
        return PBField.initSFixed64(Long.parseLong(paramObject.toString()));
      }
      if ((paramPBPrimitiveField instanceof PBSInt32Field)) {
        return PBField.initSInt32(Integer.parseInt(paramObject.toString()));
      }
      if ((paramPBPrimitiveField instanceof PBSInt64Field)) {
        return PBField.initSInt64(Long.parseLong(paramObject.toString()));
      }
      if (((paramPBPrimitiveField instanceof PBStringField)) && (paramObject.getClass() == String.class)) {
        return PBField.initString((String)String.class.cast(paramObject));
      }
      if ((paramPBPrimitiveField instanceof PBUInt32Field)) {
        return PBField.initUInt32(Integer.parseInt(paramObject.toString()));
      }
      if ((paramPBPrimitiveField instanceof PBUInt64Field))
      {
        paramPBPrimitiveField = PBField.initUInt64(Long.parseLong(paramObject.toString()));
        return paramPBPrimitiveField;
      }
    }
    catch (Throwable paramPBPrimitiveField)
    {
      QMLog.e("GdtJsonPbUtil", "pbFromJsonPrimitive", paramPBPrimitiveField);
    }
    return null;
  }
  
  private static Class getValueClassOfPBField(Class paramClass)
  {
    if (paramClass == null)
    {
      QMLog.e("GdtJsonPbUtil", "getValueClassOfPBField error");
      return null;
    }
    try
    {
      paramClass = paramClass.getMethod("get", new Class[0]).getReturnType();
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      QMLog.e("GdtJsonPbUtil", "getValueClassOfPBField", paramClass);
    }
    return null;
  }
  
  private static boolean isPBMessage(Class paramClass)
  {
    return (paramClass != null) && (paramClass.getSuperclass() == MessageMicro.class) && (!isPBRepeat(paramClass));
  }
  
  private static boolean isPBPrimitive(Class paramClass)
  {
    return (paramClass == PBBoolField.class) || (paramClass == PBDoubleField.class) || (paramClass == PBEnumField.class) || (paramClass == PBFixed32Field.class) || (paramClass == PBFixed64Field.class) || (paramClass == PBFloatField.class) || (paramClass == PBInt32Field.class) || (paramClass == PBInt64Field.class) || (paramClass == PBSFixed32Field.class) || (paramClass == PBSFixed64Field.class) || (paramClass == PBSInt32Field.class) || (paramClass == PBSInt64Field.class) || (paramClass == PBStringField.class) || (paramClass == PBUInt32Field.class) || (paramClass == PBUInt64Field.class);
  }
  
  private static boolean isPBRepeat(Class paramClass)
  {
    return (paramClass == PBRepeatField.class) || (paramClass == PBRepeatMessageField.class);
  }
  
  public static PBField pbFromJson(PBField paramPBField, Object paramObject)
  {
    if ((paramPBField == null) || (paramPBField.getClass() == PBBytesField.class) || (paramObject == null) || (paramObject == JSONObject.NULL))
    {
      QMLog.e("GdtJsonPbUtil", "pbFromJson error");
      return null;
    }
    if (isPBPrimitive(paramPBField.getClass())) {
      return pbPrimitiveFromJsonPrimitive((PBPrimitiveField)PBPrimitiveField.class.cast(paramPBField), paramObject);
    }
    if ((isPBRepeat(paramPBField.getClass())) && ((paramObject instanceof JSONArray))) {
      return pbRepeatFromJsonArray(paramPBField, (JSONArray)JSONArray.class.cast(paramObject));
    }
    if ((isPBMessage(paramPBField.getClass())) && ((paramObject instanceof JSONObject))) {
      return pbMessageFromJsonObject((MessageMicro)MessageMicro.class.cast(paramPBField), (JSONObject)JSONObject.class.cast(paramObject));
    }
    QMLog.e("GdtJsonPbUtil", "pbFromJson error");
    return null;
  }
  
  /* Error */
  private static MessageMicro pbMessageFromJsonObject(MessageMicro paramMessageMicro, JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +24 -> 25
    //   4: aload_0
    //   5: invokevirtual 57	java/lang/Object:getClass	()Ljava/lang/Class;
    //   8: invokestatic 278	com/tencent/qqmini/sdk/utils/GdtJsonPbUtil:isPBMessage	(Ljava/lang/Class;)Z
    //   11: ifeq +14 -> 25
    //   14: aload_1
    //   15: ifnull +10 -> 25
    //   18: aload_1
    //   19: getstatic 261	org/json/JSONObject:NULL	Ljava/lang/Object;
    //   22: if_acmpne +13 -> 35
    //   25: ldc 8
    //   27: ldc_w 288
    //   30: invokestatic 25	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: aconst_null
    //   34: areturn
    //   35: aload_0
    //   36: invokevirtual 57	java/lang/Object:getClass	()Ljava/lang/Class;
    //   39: invokevirtual 105	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   42: astore_0
    //   43: aload_1
    //   44: invokevirtual 292	org/json/JSONObject:keys	()Ljava/util/Iterator;
    //   47: astore_3
    //   48: aload_3
    //   49: invokeinterface 297 1 0
    //   54: ifeq +238 -> 292
    //   57: ldc 217
    //   59: aload_3
    //   60: invokeinterface 300 1 0
    //   65: invokevirtual 96	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   68: checkcast 217	java/lang/String
    //   71: astore 5
    //   73: aload 5
    //   75: invokestatic 306	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   78: ifeq +38 -> 116
    //   81: ldc 8
    //   83: ldc_w 308
    //   86: invokestatic 25	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: goto -41 -> 48
    //   92: astore_0
    //   93: ldc 8
    //   95: ldc_w 309
    //   98: aload_0
    //   99: invokestatic 41	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   102: aconst_null
    //   103: areturn
    //   104: astore_0
    //   105: ldc 8
    //   107: ldc_w 309
    //   110: aload_0
    //   111: invokestatic 41	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   114: aconst_null
    //   115: areturn
    //   116: aload_1
    //   117: aload 5
    //   119: invokevirtual 312	org/json/JSONObject:get	(Ljava/lang/String;)Ljava/lang/Object;
    //   122: astore 4
    //   124: aload 4
    //   126: ifnull -78 -> 48
    //   129: aload 4
    //   131: getstatic 261	org/json/JSONObject:NULL	Ljava/lang/Object;
    //   134: if_acmpeq -86 -> 48
    //   137: aload_0
    //   138: invokevirtual 57	java/lang/Object:getClass	()Ljava/lang/Class;
    //   141: aload 5
    //   143: invokevirtual 79	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   146: astore 6
    //   148: aload 6
    //   150: invokevirtual 85	java/lang/reflect/Field:isAccessible	()Z
    //   153: istore_2
    //   154: aload 6
    //   156: iconst_1
    //   157: invokevirtual 89	java/lang/reflect/Field:setAccessible	(Z)V
    //   160: aload 6
    //   162: aload_0
    //   163: invokevirtual 91	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   166: astore 5
    //   168: aload 6
    //   170: iload_2
    //   171: invokevirtual 89	java/lang/reflect/Field:setAccessible	(Z)V
    //   174: aload 5
    //   176: instanceof 93
    //   179: ifne +59 -> 238
    //   182: ldc 8
    //   184: ldc_w 308
    //   187: invokestatic 25	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: goto -142 -> 48
    //   193: astore 4
    //   195: ldc 8
    //   197: ldc_w 309
    //   200: aload 4
    //   202: invokestatic 41	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   205: goto -157 -> 48
    //   208: astore 4
    //   210: ldc 8
    //   212: ldc_w 309
    //   215: aload 4
    //   217: invokestatic 41	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   220: goto -172 -> 48
    //   223: astore 4
    //   225: ldc 8
    //   227: ldc_w 309
    //   230: aload 4
    //   232: invokestatic 41	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   235: goto -187 -> 48
    //   238: ldc 93
    //   240: aload 5
    //   242: invokevirtual 96	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   245: checkcast 93	com/tencent/mobileqq/pb/PBField
    //   248: aload 4
    //   250: invokestatic 314	com/tencent/qqmini/sdk/utils/GdtJsonPbUtil:pbFromJson	(Lcom/tencent/mobileqq/pb/PBField;Ljava/lang/Object;)Lcom/tencent/mobileqq/pb/PBField;
    //   253: astore 4
    //   255: aload 4
    //   257: ifnonnull +14 -> 271
    //   260: ldc 8
    //   262: ldc_w 308
    //   265: invokestatic 25	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: goto -220 -> 48
    //   271: aload 5
    //   273: aload 4
    //   275: invokestatic 316	com/tencent/qqmini/sdk/utils/GdtJsonPbUtil:getOfPB	(Ljava/lang/Object;)Ljava/lang/Object;
    //   278: aload 5
    //   280: invokevirtual 57	java/lang/Object:getClass	()Ljava/lang/Class;
    //   283: invokestatic 318	com/tencent/qqmini/sdk/utils/GdtJsonPbUtil:getValueClassOfPBField	(Ljava/lang/Class;)Ljava/lang/Class;
    //   286: invokestatic 322	com/tencent/qqmini/sdk/utils/GdtJsonPbUtil:setOfPB	(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Class;)V
    //   289: goto -241 -> 48
    //   292: aload_0
    //   293: instanceof 33
    //   296: ifeq +13 -> 309
    //   299: ldc 33
    //   301: aload_0
    //   302: invokevirtual 96	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   305: checkcast 33	com/tencent/mobileqq/pb/MessageMicro
    //   308: areturn
    //   309: ldc 8
    //   311: ldc_w 308
    //   314: invokestatic 25	com/tencent/qqmini/sdk/launcher/log/QMLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   317: aconst_null
    //   318: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	paramMessageMicro	MessageMicro
    //   0	319	1	paramJSONObject	JSONObject
    //   153	18	2	bool	boolean
    //   47	13	3	localIterator	Iterator
    //   122	8	4	localObject1	Object
    //   193	8	4	localJSONException	JSONException
    //   208	8	4	localNoSuchFieldException	NoSuchFieldException
    //   223	26	4	localIllegalAccessException	IllegalAccessException
    //   253	21	4	localPBField	PBField
    //   71	208	5	localObject2	Object
    //   146	23	6	localField	Field
    // Exception table:
    //   from	to	target	type
    //   35	43	92	java/lang/InstantiationException
    //   35	43	104	java/lang/IllegalAccessException
    //   116	124	193	org/json/JSONException
    //   137	174	208	java/lang/NoSuchFieldException
    //   137	174	223	java/lang/IllegalAccessException
  }
  
  private static JSONObject pbMessageToJson(MessageMicro paramMessageMicro)
  {
    if (paramMessageMicro == null) {}
    Field[] arrayOfField;
    do
    {
      return null;
      arrayOfField = paramMessageMicro.getClass().getDeclaredFields();
    } while (arrayOfField == null);
    JSONObject localJSONObject = new JSONObject();
    int j = arrayOfField.length;
    int i = 0;
    if (i < j)
    {
      Object localObject1 = arrayOfField[i];
      if (!Modifier.isPublic(((Field)localObject1).getModifiers())) {}
      for (;;)
      {
        i += 1;
        break;
        boolean bool = ((Field)localObject1).isAccessible();
        ((Field)localObject1).setAccessible(true);
        String str = ((Field)localObject1).getName();
        Object localObject2;
        try
        {
          localObject2 = ((Field)localObject1).get(paramMessageMicro);
          ((Field)localObject1).setAccessible(bool);
          if (((Modifier.isStatic(((Field)localObject1).getModifiers())) || (Modifier.isFinal(((Field)localObject1).getModifiers()))) && (localObject2 != null) && ((localObject2.getClass() == Integer.TYPE) || (localObject2.getClass() == Integer.class))) {
            continue;
          }
          if ((localObject2 instanceof PBField)) {
            break label179;
          }
          QMLog.e("GdtJsonPbUtil", "pbMessagebToJson error");
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          QMLog.e("GdtJsonPbUtil", "pbMessagebToJson", localIllegalAccessException);
        }
        continue;
        label179:
        localObject1 = pbToJson((PBField)PBField.class.cast(localObject2));
        if ((localObject1 != null) && (localObject1 != JSONObject.NULL)) {
          try
          {
            localJSONObject.put(localIllegalAccessException, localObject1);
          }
          catch (JSONException localJSONException)
          {
            QMLog.e("GdtJsonPbUtil", "pbMessagebToJson", localJSONException);
          }
        }
      }
    }
    return localJSONObject;
  }
  
  private static Object pbPrimitiveFieldToJson(PBPrimitiveField<?> paramPBPrimitiveField)
  {
    Object localObject1;
    if ((paramPBPrimitiveField == null) || ((paramPBPrimitiveField instanceof PBBytesField)) || (!paramPBPrimitiveField.has())) {
      localObject1 = null;
    }
    Object localObject2;
    do
    {
      return localObject1;
      localObject2 = getOfPB(paramPBPrimitiveField);
      if (((paramPBPrimitiveField instanceof PBFixed64Field)) || ((paramPBPrimitiveField instanceof PBInt64Field)) || ((paramPBPrimitiveField instanceof PBSFixed64Field)) || ((paramPBPrimitiveField instanceof PBSInt64Field))) {
        break;
      }
      localObject1 = localObject2;
    } while (!(paramPBPrimitiveField instanceof PBUInt64Field));
    if (localObject2 == null) {
      return "";
    }
    try
    {
      paramPBPrimitiveField = String.valueOf(localObject2);
      return paramPBPrimitiveField;
    }
    catch (Throwable paramPBPrimitiveField)
    {
      QMLog.e("GdtJsonPbUtil", "pbPrimitiveFieldToJson", paramPBPrimitiveField);
    }
    return "";
  }
  
  private static PBPrimitiveField pbPrimitiveFromJsonPrimitive(PBPrimitiveField paramPBPrimitiveField, Object paramObject)
  {
    if ((paramPBPrimitiveField == null) || (!isPBPrimitive(paramPBPrimitiveField.getClass())) || (paramObject == null) || (paramObject == JSONObject.NULL))
    {
      QMLog.e("GdtJsonPbUtil", "pbFromJsonPrimitive error");
      paramObject = null;
    }
    PBPrimitiveField localPBPrimitiveField;
    do
    {
      return paramObject;
      localPBPrimitiveField = getPbPrimitiveFromJsonPrimitive(paramPBPrimitiveField, paramObject);
      if (localPBPrimitiveField == null) {
        break;
      }
      paramObject = localPBPrimitiveField;
    } while (localPBPrimitiveField.getClass() == paramPBPrimitiveField.getClass());
    QMLog.e("GdtJsonPbUtil", "pbFromJsonPrimitive error");
    return null;
  }
  
  private static PBField pbRepeatFromJsonArray(PBField paramPBField, JSONArray paramJSONArray)
  {
    if ((paramPBField == null) || (paramJSONArray == null) || (paramJSONArray == JSONObject.NULL))
    {
      QMLog.e("GdtJsonPbUtil", "pbRepeatFromJsonArray error");
      return null;
    }
    PBField localPBField = getPbArrayField(paramPBField);
    if (localPBField == null)
    {
      QMLog.e("GdtJsonPbUtil", "pbRepeatFromJsonArray error");
      return null;
    }
    if (isPBPrimitive(localPBField.getClass())) {}
    for (;;)
    {
      try
      {
        paramPBField = localPBField.getClass().getField("__repeatHelper__").get(localPBField);
        if (!(paramPBField instanceof PBField)) {
          break label237;
        }
        paramPBField = PBField.initRepeat((PBField)PBField.class.cast(paramPBField));
        if (paramPBField != null) {
          break label162;
        }
        QMLog.e("GdtJsonPbUtil", "pbRepeatFromJsonArray error");
        return null;
      }
      catch (NoSuchFieldException paramPBField)
      {
        QMLog.e("GdtJsonPbUtil", "pbRepeatFromJsonArray", paramPBField);
        paramPBField = null;
        continue;
      }
      catch (IllegalAccessException paramPBField)
      {
        QMLog.e("GdtJsonPbUtil", "pbRepeatFromJsonArray", paramPBField);
        paramPBField = null;
        continue;
      }
      if (isPBMessage(localPBField.getClass()))
      {
        paramPBField = PBField.initRepeatMessage(((MessageMicro)MessageMicro.class.cast(localPBField)).getClass());
        continue;
        label162:
        int i = 0;
        for (;;)
        {
          if (i >= paramJSONArray.length()) {
            break label230;
          }
          try
          {
            Object localObject = paramJSONArray.get(i);
            if (localObject != null) {
              if (localObject != JSONObject.NULL) {
                break;
              }
            }
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              QMLog.e("GdtJsonPbUtil", "pbRepeatFromJsonArray", localJSONException);
              continue;
              addOfPB(paramPBField, getOfPB(pbFromJson(localPBField, localJSONException)));
            }
          }
          i += 1;
        }
        label230:
        return paramPBField;
      }
      else
      {
        paramPBField = null;
        continue;
        label237:
        paramPBField = null;
      }
    }
  }
  
  private static JSONArray pbRepeatToJson(PBField paramPBField)
  {
    if ((paramPBField == null) || (!isPBRepeat(paramPBField.getClass()))) {
      return null;
    }
    paramPBField = getOfPB(paramPBField);
    if (paramPBField == null) {
      return null;
    }
    if (!(paramPBField instanceof List))
    {
      QMLog.e("GdtJsonPbUtil", "pbRepeatToJson error");
      return null;
    }
    paramPBField = (List)List.class.cast(paramPBField);
    if (paramPBField == null)
    {
      QMLog.e("GdtJsonPbUtil", "pbRepeatToJson error");
      return null;
    }
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = paramPBField.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      paramPBField = localObject;
      if ((localObject instanceof PBField)) {
        paramPBField = pbToJson((PBField)PBField.class.cast(localObject));
      }
      if ((paramPBField != null) && (paramPBField != JSONObject.NULL)) {
        localJSONArray.put(paramPBField);
      }
    }
    return localJSONArray;
  }
  
  public static Object pbToJson(PBField paramPBField)
  {
    if (paramPBField == null)
    {
      QMLog.e("GdtJsonPbUtil", "pbToJson error");
      return null;
    }
    if (isPBPrimitive(paramPBField.getClass())) {
      return pbPrimitiveFieldToJson((PBPrimitiveField)PBPrimitiveField.class.cast(paramPBField));
    }
    if (isPBRepeat(paramPBField.getClass())) {
      return pbRepeatToJson(paramPBField);
    }
    if (isPBMessage(paramPBField.getClass())) {
      return pbMessageToJson((MessageMicro)MessageMicro.class.cast(paramPBField));
    }
    QMLog.e("GdtJsonPbUtil", "pbToJson error, " + paramPBField.getClass().getName() + " is not supported");
    return null;
  }
  
  private static void setOfPB(Object paramObject1, Object paramObject2, Class paramClass)
  {
    if ((paramObject1 == null) || (paramObject2 == null) || (paramClass == null))
    {
      QMLog.e("GdtJsonPbUtil", "setOfPB error");
      return;
    }
    try
    {
      paramObject1.getClass().getMethod("set", new Class[] { paramClass }).invoke(paramObject1, new Object[] { paramObject2 });
      return;
    }
    catch (Throwable paramObject1)
    {
      QMLog.e("GdtJsonPbUtil", "setOfPB", paramObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.GdtJsonPbUtil
 * JD-Core Version:    0.7.0.1
 */