package com.tencent.qqmini.sdk.utils;

import android.text.TextUtils;
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
    if ((paramObject1 != null) && (paramObject2 != null))
    {
      Method localMethod = null;
      try
      {
        boolean bool = paramObject1 instanceof PBRepeatMessageField;
        if (bool) {
          localMethod = PBRepeatMessageField.class.getDeclaredMethod("add", new Class[] { MessageMicro.class });
        } else if ((paramObject1 instanceof PBRepeatField)) {
          localMethod = PBRepeatField.class.getDeclaredMethod("add", new Class[] { Object.class });
        }
        if (localMethod == null)
        {
          QMLog.e("GdtJsonPbUtil", "addOfPB error");
          return;
        }
        localMethod.invoke(paramObject1, new Object[] { paramObject2 });
        return;
      }
      catch (Throwable paramObject1)
      {
        QMLog.e("GdtJsonPbUtil", "addOfPB", paramObject1);
        return;
      }
    }
    QMLog.e("GdtJsonPbUtil", "addOfPB error");
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
  
  private static PBField getPbArrayField(PBField paramPBField)
  {
    Object localObject2 = null;
    try
    {
      Field localField = paramPBField.getClass().getDeclaredField("helper");
      boolean bool = localField.isAccessible();
      localField.setAccessible(true);
      paramPBField = localField.get(paramPBField);
      try
      {
        localField.setAccessible(bool);
      }
      catch (IllegalAccessException localIllegalAccessException1) {}catch (NoSuchFieldException localNoSuchFieldException1) {}
      QMLog.e("GdtJsonPbUtil", "getClassOfPBArray", localNoSuchFieldException2);
    }
    catch (IllegalAccessException localIllegalAccessException2)
    {
      paramPBField = null;
      QMLog.e("GdtJsonPbUtil", "getClassOfPBArray", localIllegalAccessException2);
    }
    catch (NoSuchFieldException localNoSuchFieldException2)
    {
      paramPBField = null;
    }
    if ((paramPBField instanceof PBField)) {
      return (PBField)PBField.class.cast(paramPBField);
    }
    Object localObject1 = localObject2;
    if ((paramPBField instanceof Class))
    {
      localObject1 = localObject2;
      if (((Class)paramPBField).getSuperclass() == MessageMicro.class)
      {
        try
        {
          paramPBField = ((Class)Class.class.cast(paramPBField)).newInstance();
        }
        catch (Exception paramPBField)
        {
          QMLog.e("GdtJsonPbUtil", "getClassOfPBArray", paramPBField);
          paramPBField = null;
        }
        localObject1 = localObject2;
        if ((paramPBField instanceof MessageMicro)) {
          localObject1 = (PBField)MessageMicro.class.cast(paramPBField);
        }
      }
    }
    return localObject1;
  }
  
  private static PBPrimitiveField getPbPrimitiveFromJsonPrimitive(PBPrimitiveField paramPBPrimitiveField, Object paramObject)
  {
    try
    {
      if ((paramPBPrimitiveField instanceof PBBoolField)) {
        paramPBPrimitiveField = PBField.initBool(Boolean.parseBoolean(paramObject.toString()));
      } else if ((paramPBPrimitiveField instanceof PBDoubleField)) {
        paramPBPrimitiveField = PBField.initDouble(Double.parseDouble(paramObject.toString()));
      } else if ((paramPBPrimitiveField instanceof PBEnumField)) {
        paramPBPrimitiveField = PBField.initEnum(Integer.parseInt(paramObject.toString()));
      } else if ((paramPBPrimitiveField instanceof PBFixed32Field)) {
        paramPBPrimitiveField = PBField.initFixed32(Integer.parseInt(paramObject.toString()));
      } else if ((paramPBPrimitiveField instanceof PBFixed64Field)) {
        paramPBPrimitiveField = PBField.initFixed64(Long.parseLong(paramObject.toString()));
      } else if ((paramPBPrimitiveField instanceof PBFloatField)) {
        paramPBPrimitiveField = PBField.initFloat(Float.parseFloat(paramObject.toString()));
      } else if ((paramPBPrimitiveField instanceof PBInt32Field)) {
        paramPBPrimitiveField = PBField.initInt32(Integer.parseInt(paramObject.toString()));
      } else if ((paramPBPrimitiveField instanceof PBInt64Field)) {
        paramPBPrimitiveField = PBField.initInt64(Long.parseLong(paramObject.toString()));
      } else if ((paramPBPrimitiveField instanceof PBSFixed32Field)) {
        paramPBPrimitiveField = PBField.initSFixed32(Integer.parseInt(paramObject.toString()));
      } else if ((paramPBPrimitiveField instanceof PBSFixed64Field)) {
        paramPBPrimitiveField = PBField.initSFixed64(Long.parseLong(paramObject.toString()));
      } else if ((paramPBPrimitiveField instanceof PBSInt32Field)) {
        paramPBPrimitiveField = PBField.initSInt32(Integer.parseInt(paramObject.toString()));
      } else if ((paramPBPrimitiveField instanceof PBSInt64Field)) {
        paramPBPrimitiveField = PBField.initSInt64(Long.parseLong(paramObject.toString()));
      } else if (((paramPBPrimitiveField instanceof PBStringField)) && (paramObject.getClass() == String.class)) {
        paramPBPrimitiveField = PBField.initString((String)String.class.cast(paramObject));
      } else if ((paramPBPrimitiveField instanceof PBUInt32Field)) {
        paramPBPrimitiveField = PBField.initUInt32(Integer.parseInt(paramObject.toString()));
      } else if ((paramPBPrimitiveField instanceof PBUInt64Field)) {
        paramPBPrimitiveField = PBField.initUInt64(Long.parseLong(paramObject.toString()));
      }
    }
    catch (Throwable paramPBPrimitiveField)
    {
      QMLog.e("GdtJsonPbUtil", "pbFromJsonPrimitive", paramPBPrimitiveField);
    }
    return null;
    return paramPBPrimitiveField;
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
  
  private static void parsePbMsgField(MessageMicro paramMessageMicro, JSONObject paramJSONObject, Field paramField)
  {
    if (!Modifier.isPublic(paramField.getModifiers())) {
      return;
    }
    boolean bool = paramField.isAccessible();
    paramField.setAccessible(true);
    String str = paramField.getName();
    try
    {
      paramMessageMicro = paramField.get(paramMessageMicro);
      paramField.setAccessible(bool);
      if (((Modifier.isStatic(paramField.getModifiers())) || (Modifier.isFinal(paramField.getModifiers()))) && (paramMessageMicro != null) && ((paramMessageMicro.getClass() == Integer.TYPE) || (paramMessageMicro.getClass() == Integer.class))) {
        return;
      }
      if (!(paramMessageMicro instanceof PBField))
      {
        QMLog.e("GdtJsonPbUtil", "pbMessagebToJson error");
        return;
      }
      paramMessageMicro = pbToJson((PBField)PBField.class.cast(paramMessageMicro));
      if (paramMessageMicro != null)
      {
        if (paramMessageMicro == JSONObject.NULL) {
          return;
        }
        try
        {
          paramJSONObject.put(str, paramMessageMicro);
          return;
        }
        catch (JSONException paramMessageMicro)
        {
          QMLog.e("GdtJsonPbUtil", "pbMessagebToJson", paramMessageMicro);
        }
      }
      return;
    }
    catch (IllegalAccessException paramMessageMicro)
    {
      QMLog.e("GdtJsonPbUtil", "pbMessagebToJson", paramMessageMicro);
    }
  }
  
  public static PBField pbFromJson(PBField paramPBField, Object paramObject)
  {
    if ((paramPBField != null) && (paramPBField.getClass() != PBBytesField.class) && (paramObject != null) && (paramObject != JSONObject.NULL))
    {
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
    QMLog.e("GdtJsonPbUtil", "pbFromJson error");
    return null;
  }
  
  private static MessageMicro pbMessageFromJsonObject(MessageMicro paramMessageMicro, JSONObject paramJSONObject)
  {
    if ((paramMessageMicro != null) && (isPBMessage(paramMessageMicro.getClass())) && (paramJSONObject != null) && (paramJSONObject != JSONObject.NULL)) {
      try
      {
        paramMessageMicro = paramMessageMicro.getClass().newInstance();
        Iterator localIterator = paramJSONObject.keys();
        while (localIterator.hasNext())
        {
          Object localObject2 = (String)String.class.cast(localIterator.next());
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            QMLog.e("GdtJsonPbUtil", "pbMessageFromJsonObject error");
          } else {
            try
            {
              Object localObject1 = paramJSONObject.get((String)localObject2);
              if ((localObject1 != null) && (localObject1 != JSONObject.NULL)) {
                try
                {
                  Field localField = paramMessageMicro.getClass().getDeclaredField((String)localObject2);
                  boolean bool = localField.isAccessible();
                  localField.setAccessible(true);
                  localObject2 = localField.get(paramMessageMicro);
                  localField.setAccessible(bool);
                  if (!(localObject2 instanceof PBField))
                  {
                    QMLog.e("GdtJsonPbUtil", "pbMessageFromJsonObject error");
                  }
                  else
                  {
                    localObject1 = pbFromJson((PBField)PBField.class.cast(localObject2), localObject1);
                    if (localObject1 == null) {
                      QMLog.e("GdtJsonPbUtil", "pbMessageFromJsonObject error");
                    } else {
                      setOfPB(localObject2, getOfPB(localObject1), getValueClassOfPBField(localObject2.getClass()));
                    }
                  }
                }
                catch (IllegalAccessException localIllegalAccessException)
                {
                  QMLog.e("GdtJsonPbUtil", "pbMessageFromJsonObject", localIllegalAccessException);
                }
                catch (NoSuchFieldException localNoSuchFieldException)
                {
                  QMLog.e("GdtJsonPbUtil", "pbMessageFromJsonObject", localNoSuchFieldException);
                }
              }
            }
            catch (JSONException localJSONException)
            {
              QMLog.e("GdtJsonPbUtil", "pbMessageFromJsonObject", localJSONException);
            }
          }
        }
        if ((paramMessageMicro instanceof MessageMicro)) {
          return (MessageMicro)MessageMicro.class.cast(paramMessageMicro);
        }
        QMLog.e("GdtJsonPbUtil", "pbMessageFromJsonObject error");
        return null;
      }
      catch (IllegalAccessException paramMessageMicro)
      {
        QMLog.e("GdtJsonPbUtil", "pbMessageFromJsonObject", paramMessageMicro);
        return null;
      }
      catch (InstantiationException paramMessageMicro)
      {
        QMLog.e("GdtJsonPbUtil", "pbMessageFromJsonObject", paramMessageMicro);
        return null;
      }
    }
    QMLog.e("GdtJsonPbUtil", "pbFromJsonPrimitive error");
    return null;
  }
  
  private static JSONObject pbMessageToJson(MessageMicro paramMessageMicro)
  {
    if (paramMessageMicro == null) {
      return null;
    }
    Field[] arrayOfField = paramMessageMicro.getClass().getDeclaredFields();
    if (arrayOfField == null) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      parsePbMsgField(paramMessageMicro, localJSONObject, arrayOfField[i]);
      i += 1;
    }
    return localJSONObject;
  }
  
  private static Object pbPrimitiveFieldToJson(PBPrimitiveField<?> paramPBPrimitiveField)
  {
    if ((paramPBPrimitiveField != null) && (!(paramPBPrimitiveField instanceof PBBytesField)) && (paramPBPrimitiveField.has()))
    {
      Object localObject = getOfPB(paramPBPrimitiveField);
      if ((!(paramPBPrimitiveField instanceof PBFixed64Field)) && (!(paramPBPrimitiveField instanceof PBInt64Field)) && (!(paramPBPrimitiveField instanceof PBSFixed64Field)) && (!(paramPBPrimitiveField instanceof PBSInt64Field)) && (!(paramPBPrimitiveField instanceof PBUInt64Field))) {
        return localObject;
      }
      if (localObject == null) {
        return "";
      }
      try
      {
        paramPBPrimitiveField = String.valueOf(localObject);
        return paramPBPrimitiveField;
      }
      catch (Throwable paramPBPrimitiveField)
      {
        QMLog.e("GdtJsonPbUtil", "pbPrimitiveFieldToJson", paramPBPrimitiveField);
        return "";
      }
    }
    return null;
  }
  
  private static PBPrimitiveField pbPrimitiveFromJsonPrimitive(PBPrimitiveField paramPBPrimitiveField, Object paramObject)
  {
    if ((paramPBPrimitiveField != null) && (isPBPrimitive(paramPBPrimitiveField.getClass())) && (paramObject != null) && (paramObject != JSONObject.NULL))
    {
      paramObject = getPbPrimitiveFromJsonPrimitive(paramPBPrimitiveField, paramObject);
      if ((paramObject != null) && (paramObject.getClass() == paramPBPrimitiveField.getClass())) {
        return paramObject;
      }
      QMLog.e("GdtJsonPbUtil", "pbFromJsonPrimitive error");
      return null;
    }
    QMLog.e("GdtJsonPbUtil", "pbFromJsonPrimitive error");
    return null;
  }
  
  private static PBField pbRepeatFromJsonArray(PBField paramPBField, JSONArray paramJSONArray)
  {
    if ((paramPBField != null) && (paramJSONArray != null) && (paramJSONArray != JSONObject.NULL))
    {
      PBField localPBField = getPbArrayField(paramPBField);
      if (localPBField == null)
      {
        QMLog.e("GdtJsonPbUtil", "pbRepeatFromJsonArray error");
        return null;
      }
      if (isPBPrimitive(localPBField.getClass()))
      {
        try
        {
          paramPBField = localPBField.getClass().getField("__repeatHelper__").get(localPBField);
        }
        catch (IllegalAccessException paramPBField)
        {
          QMLog.e("GdtJsonPbUtil", "pbRepeatFromJsonArray", paramPBField);
        }
        catch (NoSuchFieldException paramPBField)
        {
          QMLog.e("GdtJsonPbUtil", "pbRepeatFromJsonArray", paramPBField);
        }
        paramPBField = null;
        if ((paramPBField instanceof PBField))
        {
          paramPBField = PBField.initRepeat((PBField)PBField.class.cast(paramPBField));
          break label144;
        }
      }
      else if (isPBMessage(localPBField.getClass()))
      {
        paramPBField = PBField.initRepeatMessage(((MessageMicro)MessageMicro.class.cast(localPBField)).getClass());
        break label144;
      }
      paramPBField = null;
      label144:
      if (paramPBField == null)
      {
        QMLog.e("GdtJsonPbUtil", "pbRepeatFromJsonArray error");
        return null;
      }
      int i = 0;
      while (i < paramJSONArray.length())
      {
        try
        {
          Object localObject = paramJSONArray.get(i);
          if ((localObject != null) && (localObject != JSONObject.NULL)) {
            addOfPB(paramPBField, getOfPB(pbFromJson(localPBField, localObject)));
          }
        }
        catch (JSONException localJSONException)
        {
          QMLog.e("GdtJsonPbUtil", "pbRepeatFromJsonArray", localJSONException);
        }
        i += 1;
      }
      return paramPBField;
    }
    QMLog.e("GdtJsonPbUtil", "pbRepeatFromJsonArray error");
    return null;
  }
  
  private static JSONArray pbRepeatToJson(PBField paramPBField)
  {
    Object localObject = null;
    if (paramPBField != null)
    {
      if (!isPBRepeat(paramPBField.getClass())) {
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
      for (;;)
      {
        localObject = localJSONArray;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = localIterator.next();
        paramPBField = localObject;
        if ((localObject instanceof PBField)) {
          paramPBField = pbToJson((PBField)PBField.class.cast(localObject));
        }
        if ((paramPBField != null) && (paramPBField != JSONObject.NULL)) {
          localJSONArray.put(paramPBField);
        }
      }
    }
    return localObject;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pbToJson error, ");
    localStringBuilder.append(paramPBField.getClass().getName());
    localStringBuilder.append(" is not supported");
    QMLog.e("GdtJsonPbUtil", localStringBuilder.toString());
    return null;
  }
  
  private static void setOfPB(Object paramObject1, Object paramObject2, Class paramClass)
  {
    if ((paramObject1 != null) && (paramObject2 != null) && (paramClass != null)) {
      try
      {
        paramObject1.getClass().getMethod("set", new Class[] { paramClass }).invoke(paramObject1, new Object[] { paramObject2 });
        return;
      }
      catch (Throwable paramObject1)
      {
        QMLog.e("GdtJsonPbUtil", "setOfPB", paramObject1);
        return;
      }
    }
    QMLog.e("GdtJsonPbUtil", "setOfPB error");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.utils.GdtJsonPbUtil
 * JD-Core Version:    0.7.0.1
 */