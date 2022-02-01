package org.xwalk.core.extension;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class JsStubGenerator
{
  public static final String MSG_TO_CLASS = "postMessageToClass";
  public static final String MSG_TO_EXTENSION = "postMessageToExtension";
  public static final String MSG_TO_OBJECT = "postMessageToObject";
  public static String TAG = "JsStubGenerator";
  String jsHeader = "var v8tools = requireNative(\"v8tools\");\nvar jsStubModule = requireNative(\"jsStub\");\njsStubModule.init(extension, v8tools);\nvar jsStub = jsStubModule.jsStub;\nvar helper = jsStub.createRootStub(exports);\n";
  ReflectionHelper reflection;
  
  JsStubGenerator(ReflectionHelper paramReflectionHelper)
  {
    this.reflection = paramReflectionHelper;
  }
  
  String[] classGenerator(ReflectionHelper paramReflectionHelper)
  {
    String str;
    Object localObject1;
    if (paramReflectionHelper.getEventList() != null)
    {
      str = generateEventTarget(paramReflectionHelper);
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(str);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      ((StringBuilder)localObject2).append(str);
      str = ((StringBuilder)localObject2).toString();
    }
    else
    {
      str = "";
      localObject1 = str;
    }
    Object localObject2 = paramReflectionHelper.getMembers();
    Iterator localIterator = ((Map)localObject2).keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject3 = (ReflectionHelper.MemberInfo)((Map)localObject2).get((String)localIterator.next());
      if (((ReflectionHelper.MemberInfo)localObject3).isStatic) {
        paramReflectionHelper = "postMessageToClass";
      } else {
        paramReflectionHelper = "postMessageToObject";
      }
      int i = JsStubGenerator.1.$SwitchMap$org$xwalk$core$extension$ReflectionHelper$MemberType[localObject3.type.ordinal()];
      if (i != 1)
      {
        if (i != 2) {
          paramReflectionHelper = "";
        } else {
          paramReflectionHelper = generateMethod(paramReflectionHelper, (ReflectionHelper.MemberInfo)localObject3, true);
        }
      }
      else {
        paramReflectionHelper = generateProperty(paramReflectionHelper, (ReflectionHelper.MemberInfo)localObject3);
      }
      if (((ReflectionHelper.MemberInfo)localObject3).isStatic)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(str);
        ((StringBuilder)localObject3).append(paramReflectionHelper);
        str = ((StringBuilder)localObject3).toString();
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(paramReflectionHelper);
        localObject1 = ((StringBuilder)localObject3).toString();
      }
    }
    return new String[] { localObject1, str };
  }
  
  String destroyBindingObject(ReflectionHelper paramReflectionHelper)
  {
    Object localObject = paramReflectionHelper.getMembers().keySet().iterator();
    StringBuilder localStringBuilder;
    for (paramReflectionHelper = "exports.destroy = function() {\n"; ((Iterator)localObject).hasNext(); paramReflectionHelper = localStringBuilder.toString())
    {
      String str = (String)((Iterator)localObject).next();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramReflectionHelper);
      localStringBuilder.append("delete exports[\"");
      localStringBuilder.append(str);
      localStringBuilder.append("\"];\n");
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramReflectionHelper);
    ((StringBuilder)localObject).append("helper.destroy();\n");
    paramReflectionHelper = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramReflectionHelper);
    ((StringBuilder)localObject).append("delete exports[\"__stubHelper\"];\n");
    paramReflectionHelper = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramReflectionHelper);
    ((StringBuilder)localObject).append("delete exports[\"destroy\"];\n");
    paramReflectionHelper = ((StringBuilder)localObject).toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramReflectionHelper);
    ((StringBuilder)localObject).append("};");
    return ((StringBuilder)localObject).toString();
  }
  
  String generate()
  {
    Object localObject1 = this.reflection.getEntryPoint();
    if (localObject1 != null) {
      localObject2 = generateEntryPoint((ReflectionHelper.MemberInfo)localObject1);
    } else {
      localObject2 = "";
    }
    if (((String)localObject2).length() <= 0) {
      localObject2 = this.jsHeader;
    }
    localObject1 = localObject2;
    if (this.reflection.getEventList() != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(generateEventTarget(this.reflection));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    Object localObject2 = this.reflection.getMembers();
    Iterator localIterator = ((Map)localObject2).keySet().iterator();
    while (localIterator.hasNext())
    {
      ReflectionHelper.MemberInfo localMemberInfo = (ReflectionHelper.MemberInfo)((Map)localObject2).get((String)localIterator.next());
      if (!localMemberInfo.isEntryPoint)
      {
        int i = JsStubGenerator.1.$SwitchMap$org$xwalk$core$extension$ReflectionHelper$MemberType[localMemberInfo.type.ordinal()];
        StringBuilder localStringBuilder;
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 3)
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append((String)localObject1);
              localStringBuilder.append(generateConstructor(localMemberInfo, true));
              localObject1 = localStringBuilder.toString();
            }
          }
          else
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append(generateMethod("postMessageToExtension", localMemberInfo, true));
            localObject1 = localStringBuilder.toString();
          }
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append(generateProperty("postMessageToExtension", localMemberInfo));
          localObject1 = localStringBuilder.toString();
        }
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("\n");
    return ((StringBuilder)localObject2).toString();
  }
  
  String generateConstructor(ReflectionHelper.MemberInfo paramMemberInfo, boolean paramBoolean)
  {
    Object localObject2 = paramMemberInfo.jsName;
    String str1 = getPrototypeName((String)localObject2);
    String str2 = getArgString((Method)paramMemberInfo.accesser, false);
    Object localObject1 = this.reflection.getConstructorReflection((String)localObject2);
    paramMemberInfo = classGenerator((ReflectionHelper)localObject1);
    localObject1 = String.format("function %s(exports, helper){\n%s\n%s\n}\n", new Object[] { str1, paramMemberInfo[0], destroyBindingObject((ReflectionHelper)localObject1) });
    str1 = String.format("function %s(%s) {\nvar newObject = this;\nvar objectId =\nNumber(helper.invokeNative(\"%s\", \"+%s\", [%s], true));\nif (!objectId) throw \"Error to create instance for constructor:%s.\";\nvar objectHelper = jsStub.getHelper(newObject, helper);\nobjectHelper.objectId = objectId;\nobjectHelper.constructorJsName = \"%s\";\nobjectHelper.registerLifecycleTracker();%s(newObject, objectHelper);\nhelper.addBindingObject(objectId, newObject);}\nhelper.constructors[\"%s\"] = %s;\n", new Object[] { localObject2, str2, "postMessageToExtension", localObject2, str2, localObject2, localObject2, str1, localObject2, localObject2 });
    str2 = String.format("(function(exports, helper){\n  helper.constructorJsName = \"%s\";\n%s\n})(%s, jsStub.getHelper(%s, helper));\n", new Object[] { localObject2, paramMemberInfo[1], localObject2, localObject2 });
    if (paramBoolean) {
      paramMemberInfo = String.format("exports[\"%s\"] = %s;\n", new Object[] { localObject2, localObject2 });
    } else {
      paramMemberInfo = "";
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(str1);
    ((StringBuilder)localObject2).append(str2);
    ((StringBuilder)localObject2).append(paramMemberInfo);
    return ((StringBuilder)localObject2).toString();
  }
  
  String generateEntryPoint(ReflectionHelper.MemberInfo paramMemberInfo)
  {
    if (paramMemberInfo.type == ReflectionHelper.MemberType.JS_PROPERTY)
    {
      paramMemberInfo = ((Field)paramMemberInfo.accesser).getType().getSimpleName();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jsHeader);
      localStringBuilder.append(String.format("%s(exports, helper);\n", new Object[] { getPrototypeName(paramMemberInfo) }));
      return localStringBuilder.toString();
    }
    if (paramMemberInfo.type == ReflectionHelper.MemberType.JS_METHOD) {
      return String.format("exports = %s;\n %s\n %s", new Object[] { getInternalName(paramMemberInfo.jsName), this.jsHeader, generateMethod("postMessageToExtension", paramMemberInfo, false) });
    }
    if (paramMemberInfo.type == ReflectionHelper.MemberType.JS_CONSTRUCTOR) {
      return String.format("exports = %s;\n %s\n %s", new Object[] { paramMemberInfo.jsName, this.jsHeader, generateConstructor(paramMemberInfo, false) });
    }
    return "";
  }
  
  String generateEventTarget(ReflectionHelper paramReflectionHelper)
  {
    String[] arrayOfString = paramReflectionHelper.getEventList();
    if ((arrayOfString != null) && (arrayOfString.length != 0))
    {
      int j = arrayOfString.length;
      int i = 0;
      paramReflectionHelper = "jsStub.makeEventTarget(exports);\n";
      while (i < j)
      {
        String str = arrayOfString[i];
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramReflectionHelper);
        localStringBuilder.append("helper.addEvent(\"");
        localStringBuilder.append(str);
        localStringBuilder.append("\");\n");
        paramReflectionHelper = localStringBuilder.toString();
        i += 1;
      }
      return paramReflectionHelper;
    }
    return "";
  }
  
  String generateMethod(String paramString, ReflectionHelper.MemberInfo paramMemberInfo, boolean paramBoolean)
  {
    if (paramMemberInfo.withPromise) {
      return generatePromiseMethod(paramString, paramMemberInfo);
    }
    Object localObject1 = paramMemberInfo.jsName;
    Object localObject2 = (Method)paramMemberInfo.accesser;
    String str1 = getInternalName((String)localObject1);
    ((Method)localObject2).getParameterAnnotations();
    String str2 = getArgString((Method)localObject2, paramMemberInfo.withPromise);
    boolean bool = ((Method)localObject2).getReturnType().equals(Void.TYPE) ^ true;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("function %s(%s) {\n");
    if (bool) {
      paramMemberInfo = "  return ";
    } else {
      paramMemberInfo = "  ";
    }
    ((StringBuilder)localObject2).append(paramMemberInfo);
    ((StringBuilder)localObject2).append("helper.invokeNative(\"%s\", \"%s\", [%s], %b);\n};\n");
    paramMemberInfo = String.format(((StringBuilder)localObject2).toString(), new Object[] { str1, str2, paramString, localObject1, str2, Boolean.valueOf(bool) });
    if (paramBoolean) {
      paramString = String.format("exports[\"%s\"] = %s;\n", new Object[] { localObject1, str1 });
    } else {
      paramString = "";
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramMemberInfo);
    ((StringBuilder)localObject1).append(paramString);
    return ((StringBuilder)localObject1).toString();
  }
  
  String generatePromiseMethod(String paramString, ReflectionHelper.MemberInfo paramMemberInfo)
  {
    String str3 = paramMemberInfo.jsName;
    int i = paramMemberInfo.wrapArgs.length();
    String str2 = "null";
    String str1;
    if (i > 0) {
      str1 = paramMemberInfo.wrapArgs;
    } else {
      str1 = "null";
    }
    if (paramMemberInfo.wrapReturns.length() > 0) {
      str2 = paramMemberInfo.wrapReturns;
    }
    return String.format("jsStub.addMethodWithPromise(\"%s\", exports, \"%s\", %s, %s);\n", new Object[] { paramString, str3, str1, str2 });
  }
  
  String generateProperty(String paramString, ReflectionHelper.MemberInfo paramMemberInfo)
  {
    return String.format("jsStub.defineProperty(\"%s\", exports, \"%s\", %b);\n", new Object[] { paramString, paramMemberInfo.jsName, Boolean.valueOf(paramMemberInfo.isWritable) });
  }
  
  String getArgString(Method paramMethod, boolean paramBoolean)
  {
    Object localObject1 = "";
    if (paramMethod == null) {
      return "";
    }
    Class[] arrayOfClass = paramMethod.getParameterTypes();
    paramMethod.getParameterAnnotations();
    int i;
    if (paramBoolean) {
      i = arrayOfClass.length - 1;
    } else {
      i = arrayOfClass.length;
    }
    int j = 0;
    paramMethod = (Method)localObject1;
    while (j < i)
    {
      localObject1 = arrayOfClass[j];
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("arg");
      ((StringBuilder)localObject2).append(j);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(((Class)localObject1).getSimpleName());
      localObject2 = ((StringBuilder)localObject2).toString();
      localObject1 = paramMethod;
      if (paramMethod.length() > 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramMethod);
        ((StringBuilder)localObject1).append(", ");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      paramMethod = new StringBuilder();
      paramMethod.append((String)localObject1);
      paramMethod.append((String)localObject2);
      paramMethod = paramMethod.toString();
      j += 1;
    }
    return paramMethod;
  }
  
  String getInternalName(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("__");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  String getPrototypeName(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("__");
    localStringBuilder.append(paramString);
    localStringBuilder.append("_prototype");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.extension.JsStubGenerator
 * JD-Core Version:    0.7.0.1
 */