package org.xwalk.core.extension;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xwalk.core.Log;

class ReflectionHelper
{
  private static final String TAG = "JsStubReflectHelper";
  static Set<Class<?>> primitives = new HashSet();
  private Map<String, String> bindingClasses = new HashMap();
  private Map<String, ReflectionHelper> constructorReflections = new HashMap();
  private ReflectionHelper.MemberInfo entryPoint = null;
  private String[] eventList = null;
  private Map<String, ReflectionHelper.MemberInfo> members = new HashMap();
  private Class<?> myClass;
  
  public ReflectionHelper(Class<?> paramClass)
  {
    this.myClass = paramClass;
    init();
  }
  
  public static boolean isSerializable(Object paramObject)
  {
    Class localClass = paramObject.getClass();
    return (localClass.isPrimitive()) || (primitives.contains(localClass)) || ((paramObject instanceof String)) || ((paramObject instanceof Map)) || ((paramObject instanceof JSONArray)) || ((paramObject instanceof JSONObject));
  }
  
  public static String objToJSON(Object paramObject)
  {
    if (paramObject == null) {
      return "null";
    }
    paramObject = toSerializableObject(paramObject);
    if (paramObject == null) {
      return "null";
    }
    if ((paramObject instanceof String)) {
      return JSONObject.quote(paramObject.toString());
    }
    return paramObject.toString();
  }
  
  public static void registerHandlers(ReflectionHelper paramReflectionHelper, MessageHandler paramMessageHandler, Object paramObject)
  {
    if (paramReflectionHelper != null)
    {
      if (paramMessageHandler == null) {
        return;
      }
      Iterator localIterator = paramReflectionHelper.getMembers().keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        localObject = (ReflectionHelper.MemberInfo)paramReflectionHelper.getMembers().get(localObject);
        paramMessageHandler.register(((ReflectionHelper.MemberInfo)localObject).jsName, ((ReflectionHelper.MemberInfo)localObject).javaName, ((ReflectionHelper.MemberInfo)localObject).type, paramObject, paramReflectionHelper);
      }
    }
  }
  
  public static Object toSerializableObject(Object paramObject)
  {
    boolean bool = paramObject.getClass().isArray();
    int i = 0;
    int j = 0;
    Object localObject1;
    if (bool)
    {
      localObject1 = new JSONArray();
      paramObject = (Object[])paramObject;
      i = j;
      while (i < paramObject.length)
      {
        try
        {
          ((JSONArray)localObject1).put(i, toSerializableObject(paramObject[i]));
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
        }
        i += 1;
      }
      return localObject1;
    }
    if (isSerializable(paramObject)) {
      return paramObject;
    }
    try
    {
      localObject1 = (String)paramObject.getClass().getMethod("toJSONString", new Class[0]).invoke(paramObject, new Object[0]);
      if (((String)localObject1).trim().charAt(0) == '[') {
        return new JSONArray((String)localObject1);
      }
      localObject1 = new JSONObject((String)localObject1);
      return localObject1;
    }
    catch (Exception localException1)
    {
      label150:
      break label150;
    }
    Log.w("JsStubReflectHelper", "No serialization method: \"toJSONString\", or errors happened.");
    try
    {
      Object localObject2 = paramObject.getClass();
      localObject1 = new JSONObject();
      localObject2 = ((Class)localObject2).getFields();
      j = localObject2.length;
      while (i < j)
      {
        Object localObject3 = localObject2[i];
        ((JSONObject)localObject1).put(localObject3.getName(), localObject3.get(paramObject));
        i += 1;
      }
      return localObject1;
    }
    catch (Exception paramObject)
    {
      Log.e("JsStubReflectHelper", "Field to serialize object to JSON.");
      paramObject.printStackTrace();
      return null;
    }
  }
  
  Object[] getArgsFromJson(XWalkExternalExtension paramXWalkExternalExtension, int paramInt, Method paramMethod, JSONArray paramJSONArray)
  {
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    Object[] arrayOfObject = new Object[arrayOfClass.length];
    boolean bool1 = Modifier.isStatic(paramMethod.getModifiers());
    int i = 0;
    while (i < arrayOfClass.length)
    {
      Class localClass = arrayOfClass[i];
      if (bool1) {}
      try
      {
        boolean bool2 = localClass.equals(JsContextInfo.class);
        if (bool2)
        {
          int j = i + 1;
          try
          {
            arrayOfObject[i] = new JsContextInfo(paramInt, paramXWalkExternalExtension, paramMethod.getClass(), Integer.toString(0));
            i = j;
          }
          catch (Exception localException1)
          {
            i = j;
            break label121;
          }
        }
        else
        {
          arrayOfObject[i] = paramJSONArray.get(i);
        }
      }
      catch (Exception localException2)
      {
        label121:
        localException2.printStackTrace();
      }
      i += 1;
    }
    return arrayOfObject;
  }
  
  ReflectionHelper getConstructorReflection(String paramString)
  {
    if (!this.constructorReflections.containsKey(paramString)) {
      return null;
    }
    return (ReflectionHelper)this.constructorReflections.get(paramString);
  }
  
  ReflectionHelper.MemberInfo getEntryPoint()
  {
    return this.entryPoint;
  }
  
  String[] getEventList()
  {
    return this.eventList;
  }
  
  ReflectionHelper.MemberInfo getMemberInfo(String paramString)
  {
    return (ReflectionHelper.MemberInfo)this.members.get(paramString);
  }
  
  void getMemberInfo(AccessibleObject[] paramArrayOfAccessibleObject, ReflectionHelper.MemberType paramMemberType)
  {
    int j = paramArrayOfAccessibleObject.length;
    int i = 0;
    while (i < j)
    {
      Object localObject2 = paramArrayOfAccessibleObject[i];
      if ((((AccessibleObject)localObject2).isAnnotationPresent(JsApi.class)) || (((AccessibleObject)localObject2).isAnnotationPresent(JsConstructor.class)))
      {
        Object localObject1 = new ReflectionHelper.MemberInfo(this);
        Object localObject3 = (Member)localObject2;
        String str = ((Member)localObject3).getName();
        ((ReflectionHelper.MemberInfo)localObject1).javaName = str;
        ((ReflectionHelper.MemberInfo)localObject1).accesser = ((AccessibleObject)localObject2);
        ((ReflectionHelper.MemberInfo)localObject1).isStatic = Modifier.isStatic(((Member)localObject3).getModifiers());
        if (((AccessibleObject)localObject2).isAnnotationPresent(JsApi.class))
        {
          localObject3 = (JsApi)((AccessibleObject)localObject2).getAnnotation(JsApi.class);
          if ((paramMemberType == ReflectionHelper.MemberType.JS_PROPERTY) && (((JsApi)localObject3).isEventList()))
          {
            if (!((Field)localObject2).getType().equals([Ljava.lang.String.class))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Invalid type for Supported JS event list");
              ((StringBuilder)localObject1).append(str);
              Log.w("JsStubReflectHelper", ((StringBuilder)localObject1).toString());
              break label695;
            }
            try
            {
              this.eventList = ((String[])((Field)localObject2).get(null));
            }
            catch (IllegalAccessException localIllegalAccessException) {}catch (IllegalArgumentException localIllegalArgumentException) {}
            localIllegalArgumentException.printStackTrace();
            break label695;
          }
          ((ReflectionHelper.MemberInfo)localObject1).type = paramMemberType;
          ((ReflectionHelper.MemberInfo)localObject1).isWritable = ((JsApi)localObject3).isWritable();
          ((ReflectionHelper.MemberInfo)localObject1).isEntryPoint = ((JsApi)localObject3).isEntryPoint();
          ((ReflectionHelper.MemberInfo)localObject1).withPromise = ((JsApi)localObject3).withPromise();
          ((ReflectionHelper.MemberInfo)localObject1).jsName = localIllegalArgumentException;
          ((ReflectionHelper.MemberInfo)localObject1).wrapArgs = ((JsApi)localObject3).wrapArgs();
          ((ReflectionHelper.MemberInfo)localObject1).wrapReturns = ((JsApi)localObject3).wrapReturns();
        }
        else if (((AccessibleObject)localObject2).isAnnotationPresent(JsConstructor.class))
        {
          if (paramMemberType != ReflectionHelper.MemberType.JS_METHOD)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Invalid @JsConstructor on non-function member:");
            ((StringBuilder)localObject1).append(localIllegalArgumentException);
            Log.w("JsStubReflectHelper", ((StringBuilder)localObject1).toString());
            break label695;
          }
          localObject2 = (JsConstructor)((AccessibleObject)localObject2).getAnnotation(JsConstructor.class);
          ((ReflectionHelper.MemberInfo)localObject1).type = ReflectionHelper.MemberType.JS_CONSTRUCTOR;
          ((ReflectionHelper.MemberInfo)localObject1).isEntryPoint = ((JsConstructor)localObject2).isEntryPoint();
          ((ReflectionHelper.MemberInfo)localObject1).mainClass = ((JsConstructor)localObject2).mainClass();
          ((ReflectionHelper.MemberInfo)localObject1).withPromise = false;
          if (((ReflectionHelper.MemberInfo)localObject1).mainClass == null) {
            break label695;
          }
          ((ReflectionHelper.MemberInfo)localObject1).jsName = ((ReflectionHelper.MemberInfo)localObject1).mainClass.getSimpleName();
          this.bindingClasses.put(((ReflectionHelper.MemberInfo)localObject1).mainClass.getName(), ((ReflectionHelper.MemberInfo)localObject1).jsName);
          this.constructorReflections.put(((ReflectionHelper.MemberInfo)localObject1).jsName, new ReflectionHelper(((ReflectionHelper.MemberInfo)localObject1).mainClass));
        }
        StringBuilder localStringBuilder;
        if (((ReflectionHelper.MemberInfo)localObject1).isEntryPoint)
        {
          if (this.entryPoint != null)
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("Entry point already exist, try to set another:");
            localStringBuilder.append(((ReflectionHelper.MemberInfo)localObject1).jsName);
            Log.w("JsStubReflectHelper", localStringBuilder.toString());
          }
          else if ((paramMemberType == ReflectionHelper.MemberType.JS_PROPERTY) && (!isBindingClass(((Field)((ReflectionHelper.MemberInfo)localObject1).accesser).getType())))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("Invalid entry point setting on property:");
            ((StringBuilder)localObject1).append(localStringBuilder);
            Log.w("JsStubReflectHelper", ((StringBuilder)localObject1).toString());
          }
          else
          {
            this.entryPoint = ((ReflectionHelper.MemberInfo)localObject1);
          }
        }
        else if (this.members.containsKey(((ReflectionHelper.MemberInfo)localObject1).jsName))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("Conflict namespace - ");
          localStringBuilder.append(((ReflectionHelper.MemberInfo)localObject1).jsName);
          Log.w("JsStubReflectHelper", localStringBuilder.toString());
        }
        else
        {
          this.members.put(((ReflectionHelper.MemberInfo)localObject1).jsName, localObject1);
        }
      }
      label695:
      i += 1;
    }
  }
  
  Map<String, ReflectionHelper.MemberInfo> getMembers()
  {
    return this.members;
  }
  
  Object getProperty(Object paramObject, String paramString)
  {
    if (hasProperty(paramString).booleanValue())
    {
      if ((!getMemberInfo(paramString).isStatic) && (!this.myClass.isInstance(paramObject)))
      {
        paramObject = new StringBuilder();
        paramObject.append("Invalid target to set property:");
        paramObject.append(paramString);
        throw new InvocationTargetException(new Exception(paramObject.toString()));
      }
      paramString = (Field)((ReflectionHelper.MemberInfo)this.members.get(paramString)).accesser;
      if (!paramString.isAccessible()) {
        paramString.setAccessible(true);
      }
      return paramString.get(paramObject);
    }
    paramObject = new StringBuilder();
    paramObject.append("No such property:");
    paramObject.append(paramString);
    throw new NoSuchFieldException(paramObject.toString());
  }
  
  ReflectionHelper getReflectionByBindingClass(String paramString)
  {
    if (!this.bindingClasses.containsKey(paramString)) {
      return null;
    }
    return getConstructorReflection((String)this.bindingClasses.get(paramString));
  }
  
  public Object handleMessage(MessageInfo paramMessageInfo, Object paramObject)
  {
    for (;;)
    {
      try
      {
        String str1 = paramMessageInfo.getCmd();
        JSONArray localJSONArray;
        if (paramMessageInfo.getBinaryArgs() != null)
        {
          localJSONArray = new JSONArray();
          localJSONArray.put(paramMessageInfo.getBinaryArgs());
          localJSONArray.put(paramMessageInfo.getCallbackId());
        }
        else
        {
          localJSONArray = paramMessageInfo.getArgs();
        }
        String str2 = paramMessageInfo.getJsName();
        XWalkExternalExtension localXWalkExternalExtension = paramMessageInfo.getExtension();
        int j = paramMessageInfo.getInstanceId();
        int i = -1;
        switch (str1.hashCode())
        {
        case 1811874389: 
          if (str1.equals("newInstance")) {
            i = 1;
          }
          break;
        case 1084758859: 
          if (str1.equals("getProperty")) {
            i = 2;
          }
          break;
        case 996179031: 
          if (str1.equals("setProperty")) {
            i = 3;
          }
          break;
        case -633190737: 
          if (str1.equals("invokeNative")) {
            i = 0;
          }
          if (i != 0)
          {
            if (i != 1)
            {
              if (i != 2)
              {
                if (i != 3)
                {
                  paramMessageInfo = new StringBuilder();
                  paramMessageInfo.append("Unsupported cmd: ");
                  paramMessageInfo.append(str1);
                  Log.w("JsStubReflectHelper", paramMessageInfo.toString());
                  return null;
                }
                setProperty(paramObject, str2, localJSONArray.get(0));
                return null;
              }
              paramMessageInfo = getProperty(paramObject, str2);
            }
            else
            {
              paramObject = (BindingObject)invokeMethod(localXWalkExternalExtension, j, paramObject, str2, localJSONArray);
              paramMessageInfo = Boolean.valueOf(paramMessageInfo.getInstanceHelper().addBindingObject(paramMessageInfo.getObjectId(), paramObject));
            }
          }
          else {
            paramMessageInfo = invokeMethod(localXWalkExternalExtension, j, paramObject, str2, localJSONArray);
          }
          return paramMessageInfo;
        }
      }
      catch (Exception paramMessageInfo)
      {
        paramObject = new StringBuilder();
        paramObject.append("Invalid message, error msg:\n");
        paramObject.append(paramMessageInfo.toString());
        Log.w("JsStubReflectHelper", paramObject.toString());
        paramMessageInfo.printStackTrace();
        return null;
      }
    }
  }
  
  Boolean hasMethod(String paramString)
  {
    boolean bool2 = this.members.containsKey(paramString);
    boolean bool1 = false;
    if (!bool2) {
      return Boolean.valueOf(false);
    }
    paramString = (ReflectionHelper.MemberInfo)this.members.get(paramString);
    if ((paramString.type == ReflectionHelper.MemberType.JS_METHOD) || (paramString.type == ReflectionHelper.MemberType.JS_CONSTRUCTOR)) {
      bool1 = true;
    }
    return Boolean.valueOf(bool1);
  }
  
  Boolean hasProperty(String paramString)
  {
    boolean bool2 = this.members.containsKey(paramString);
    boolean bool1 = false;
    if (!bool2) {
      return Boolean.valueOf(false);
    }
    if (((ReflectionHelper.MemberInfo)this.members.get(paramString)).type == ReflectionHelper.MemberType.JS_PROPERTY) {
      bool1 = true;
    }
    return Boolean.valueOf(bool1);
  }
  
  void init()
  {
    primitives.add(Byte.class);
    primitives.add(Integer.class);
    primitives.add(Long.class);
    primitives.add(Double.class);
    primitives.add(Character.class);
    primitives.add(Float.class);
    primitives.add(Boolean.class);
    primitives.add(Short.class);
    getMemberInfo(this.myClass.getDeclaredMethods(), ReflectionHelper.MemberType.JS_METHOD);
    getMemberInfo(this.myClass.getDeclaredFields(), ReflectionHelper.MemberType.JS_PROPERTY);
  }
  
  Object invokeMethod(XWalkExternalExtension paramXWalkExternalExtension, int paramInt, Object paramObject, String paramString, JSONArray paramJSONArray)
  {
    if (hasMethod(paramString).booleanValue())
    {
      if ((!getMemberInfo(paramString).isStatic) && (!this.myClass.isInstance(paramObject)))
      {
        paramXWalkExternalExtension = new StringBuilder();
        paramXWalkExternalExtension.append("Invalid target to set property:");
        paramXWalkExternalExtension.append(paramString);
        throw new InvocationTargetException(new Exception(paramXWalkExternalExtension.toString()));
      }
      paramString = (Method)((ReflectionHelper.MemberInfo)this.members.get(paramString)).accesser;
      if (!paramString.isAccessible()) {
        paramString.setAccessible(true);
      }
      return paramString.invoke(paramObject, getArgsFromJson(paramXWalkExternalExtension, paramInt, paramString, paramJSONArray));
    }
    paramXWalkExternalExtension = new StringBuilder();
    paramXWalkExternalExtension.append("No such method:");
    paramXWalkExternalExtension.append(paramString);
    throw new NoSuchMethodException(paramXWalkExternalExtension.toString());
  }
  
  boolean isBindingClass(Class<?> paramClass)
  {
    return BindingObject.class.isAssignableFrom(paramClass);
  }
  
  boolean isEventSupported(String paramString)
  {
    if (this.eventList == null) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      String[] arrayOfString = this.eventList;
      if (i >= arrayOfString.length) {
        break;
      }
      if (arrayOfString[i].equals(paramString)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  boolean isInstance(Object paramObject)
  {
    return this.myClass.isInstance(paramObject);
  }
  
  void setProperty(Object paramObject1, String paramString, Object paramObject2)
  {
    if (hasProperty(paramString).booleanValue())
    {
      if ((!getMemberInfo(paramString).isStatic) && (!this.myClass.isInstance(paramObject1)))
      {
        paramObject1 = new StringBuilder();
        paramObject1.append("Invalid target to set property:");
        paramObject1.append(paramString);
        throw new InvocationTargetException(new Exception(paramObject1.toString()));
      }
      paramString = (Field)((ReflectionHelper.MemberInfo)this.members.get(paramString)).accesser;
      if (!paramString.isAccessible()) {
        paramString.setAccessible(true);
      }
      paramString.set(paramObject1, paramObject2);
      return;
    }
    paramObject1 = new StringBuilder();
    paramObject1.append("No such property:");
    paramObject1.append(paramString);
    throw new NoSuchFieldException(paramObject1.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.extension.ReflectionHelper
 * JD-Core Version:    0.7.0.1
 */