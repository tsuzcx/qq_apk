package org.apache.commons.lang.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.NullArgumentException;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;

public class ExceptionUtils
{
  private static String[] CAUSE_METHOD_NAMES;
  private static final Object CAUSE_METHOD_NAMES_LOCK = new Object();
  private static final Method THROWABLE_CAUSE_METHOD;
  private static final Method THROWABLE_INITCAUSE_METHOD;
  static final String WRAPPED_MARKER = " [wrapped] ";
  static Class class$java$lang$Throwable;
  
  static
  {
    CAUSE_METHOD_NAMES = new String[] { "getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable" };
    localObject3 = null;
    try
    {
      if (class$java$lang$Throwable == null)
      {
        localObject1 = class$("java.lang.Throwable");
        class$java$lang$Throwable = (Class)localObject1;
      }
      else
      {
        localObject1 = class$java$lang$Throwable;
      }
      localObject1 = ((Class)localObject1).getMethod("getCause", null);
    }
    catch (Exception localException1)
    {
      Object localObject1;
      label120:
      break label120;
    }
    localObject1 = null;
    THROWABLE_CAUSE_METHOD = (Method)localObject1;
    try
    {
      if (class$java$lang$Throwable == null)
      {
        localObject1 = class$("java.lang.Throwable");
        class$java$lang$Throwable = (Class)localObject1;
      }
      else
      {
        localObject1 = class$java$lang$Throwable;
      }
      Class localClass;
      if (class$java$lang$Throwable == null)
      {
        localClass = class$("java.lang.Throwable");
        class$java$lang$Throwable = localClass;
      }
      else
      {
        localClass = class$java$lang$Throwable;
      }
      localObject1 = ((Class)localObject1).getMethod("initCause", new Class[] { localClass });
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        Object localObject2 = localObject3;
      }
    }
    THROWABLE_INITCAUSE_METHOD = (Method)localObject1;
  }
  
  public static void addCauseMethodName(String arg0)
  {
    if ((StringUtils.isNotEmpty(???)) && (!isCauseMethodName(???)))
    {
      ArrayList localArrayList = getCauseMethodNameList();
      if (localArrayList.add(???)) {
        synchronized (CAUSE_METHOD_NAMES_LOCK)
        {
          CAUSE_METHOD_NAMES = toArray(localArrayList);
          return;
        }
      }
    }
  }
  
  static Class class$(String paramString)
  {
    try
    {
      paramString = Class.forName(paramString);
      return paramString;
    }
    catch (ClassNotFoundException paramString)
    {
      throw new NoClassDefFoundError(paramString.getMessage());
    }
  }
  
  public static Throwable getCause(Throwable paramThrowable)
  {
    synchronized (CAUSE_METHOD_NAMES_LOCK)
    {
      paramThrowable = getCause(paramThrowable, CAUSE_METHOD_NAMES);
      return paramThrowable;
    }
  }
  
  public static Throwable getCause(Throwable paramThrowable, String[] arg1)
  {
    if (paramThrowable == null) {
      return null;
    }
    Object localObject1 = getCauseUsingWellKnownTypes(paramThrowable);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = ???;
      if (??? == null) {
        synchronized (CAUSE_METHOD_NAMES_LOCK)
        {
          localObject2 = CAUSE_METHOD_NAMES;
        }
      }
      int i = 0;
      ??? = (String[])localObject1;
      for (;;)
      {
        localObject1 = ???;
        if (i >= localObject2.length) {
          break;
        }
        localObject1 = localObject2[i];
        if (localObject1 != null)
        {
          localObject1 = getCauseUsingMethodName(paramThrowable, (String)localObject1);
          ??? = (String[])localObject1;
          if (localObject1 != null) {
            break;
          }
        }
        i += 1;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = getCauseUsingFieldName(paramThrowable, "detail");
      }
    }
    return localObject2;
  }
  
  private static ArrayList getCauseMethodNameList()
  {
    synchronized (CAUSE_METHOD_NAMES_LOCK)
    {
      ArrayList localArrayList = new ArrayList(Arrays.asList(CAUSE_METHOD_NAMES));
      return localArrayList;
    }
  }
  
  private static Throwable getCauseUsingFieldName(Throwable paramThrowable, String paramString)
  {
    try
    {
      paramString = paramThrowable.getClass().getField(paramString);
    }
    catch (NoSuchFieldException|SecurityException paramString)
    {
      label12:
      Class localClass2;
      Class localClass1;
      break label12;
    }
    paramString = null;
    if (paramString != null)
    {
      localClass2 = class$java$lang$Throwable;
      localClass1 = localClass2;
      if (localClass2 == null)
      {
        localClass1 = class$("java.lang.Throwable");
        class$java$lang$Throwable = localClass1;
      }
      if (!localClass1.isAssignableFrom(paramString.getType())) {}
    }
    try
    {
      paramThrowable = (Throwable)paramString.get(paramThrowable);
      return paramThrowable;
    }
    catch (IllegalAccessException|IllegalArgumentException paramThrowable) {}
    return null;
    return null;
  }
  
  private static Throwable getCauseUsingMethodName(Throwable paramThrowable, String paramString)
  {
    try
    {
      paramString = paramThrowable.getClass().getMethod(paramString, null);
    }
    catch (NoSuchMethodException|SecurityException paramString)
    {
      label13:
      Class localClass2;
      Class localClass1;
      break label13;
    }
    paramString = null;
    if (paramString != null)
    {
      localClass2 = class$java$lang$Throwable;
      localClass1 = localClass2;
      if (localClass2 == null)
      {
        localClass1 = class$("java.lang.Throwable");
        class$java$lang$Throwable = localClass1;
      }
      if (!localClass1.isAssignableFrom(paramString.getReturnType())) {}
    }
    try
    {
      paramThrowable = (Throwable)paramString.invoke(paramThrowable, ArrayUtils.EMPTY_OBJECT_ARRAY);
      return paramThrowable;
    }
    catch (IllegalAccessException|IllegalArgumentException|InvocationTargetException paramThrowable) {}
    return null;
    return null;
  }
  
  private static Throwable getCauseUsingWellKnownTypes(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof Nestable)) {
      return ((Nestable)paramThrowable).getCause();
    }
    if ((paramThrowable instanceof SQLException)) {
      return ((SQLException)paramThrowable).getNextException();
    }
    if ((paramThrowable instanceof InvocationTargetException)) {
      return ((InvocationTargetException)paramThrowable).getTargetException();
    }
    return null;
  }
  
  public static String getFullStackTrace(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter, true);
    paramThrowable = getThrowables(paramThrowable);
    int i = 0;
    while (i < paramThrowable.length)
    {
      paramThrowable[i].printStackTrace(localPrintWriter);
      if (isNestedThrowable(paramThrowable[i])) {
        break;
      }
      i += 1;
    }
    return localStringWriter.getBuffer().toString();
  }
  
  public static String getMessage(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    String str = ClassUtils.getShortClassName(paramThrowable, null);
    paramThrowable = paramThrowable.getMessage();
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(str);
    localStringBuffer.append(": ");
    localStringBuffer.append(StringUtils.defaultString(paramThrowable));
    return localStringBuffer.toString();
  }
  
  public static Throwable getRootCause(Throwable paramThrowable)
  {
    paramThrowable = getThrowableList(paramThrowable);
    if (paramThrowable.size() < 2) {
      return null;
    }
    return (Throwable)paramThrowable.get(paramThrowable.size() - 1);
  }
  
  public static String getRootCauseMessage(Throwable paramThrowable)
  {
    Throwable localThrowable = getRootCause(paramThrowable);
    if (localThrowable != null) {
      paramThrowable = localThrowable;
    }
    return getMessage(paramThrowable);
  }
  
  public static String[] getRootCauseStackTrace(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return ArrayUtils.EMPTY_STRING_ARRAY;
    }
    Throwable[] arrayOfThrowable = getThrowables(paramThrowable);
    int i = arrayOfThrowable.length;
    ArrayList localArrayList = new ArrayList();
    int k = i - 1;
    paramThrowable = getStackFrameList(arrayOfThrowable[k]);
    for (;;)
    {
      int j = i - 1;
      i = 0;
      if (j < 0) {
        break;
      }
      Object localObject;
      if (j != 0)
      {
        localObject = getStackFrameList(arrayOfThrowable[(j - 1)]);
        removeCommonFrames(paramThrowable, (List)localObject);
      }
      else
      {
        localObject = paramThrowable;
      }
      if (j == k)
      {
        localArrayList.add(arrayOfThrowable[j].toString());
      }
      else
      {
        StringBuffer localStringBuffer = new StringBuffer();
        localStringBuffer.append(" [wrapped] ");
        localStringBuffer.append(arrayOfThrowable[j].toString());
        localArrayList.add(localStringBuffer.toString());
      }
      while (i < paramThrowable.size())
      {
        localArrayList.add(paramThrowable.get(i));
        i += 1;
      }
      paramThrowable = (Throwable)localObject;
      i = j;
    }
    return (String[])localArrayList.toArray(new String[0]);
  }
  
  static List getStackFrameList(Throwable paramThrowable)
  {
    paramThrowable = new StringTokenizer(getStackTrace(paramThrowable), SystemUtils.LINE_SEPARATOR);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    do
    {
      for (;;)
      {
        if (!paramThrowable.hasMoreTokens()) {
          return localArrayList;
        }
        String str = paramThrowable.nextToken();
        int j = str.indexOf("at");
        if ((j == -1) || (str.substring(0, j).trim().length() != 0)) {
          break;
        }
        i = 1;
        localArrayList.add(str);
      }
    } while (i == 0);
    return localArrayList;
  }
  
  static String[] getStackFrames(String paramString)
  {
    paramString = new StringTokenizer(paramString, SystemUtils.LINE_SEPARATOR);
    ArrayList localArrayList = new ArrayList();
    while (paramString.hasMoreTokens()) {
      localArrayList.add(paramString.nextToken());
    }
    return toArray(localArrayList);
  }
  
  public static String[] getStackFrames(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return ArrayUtils.EMPTY_STRING_ARRAY;
    }
    return getStackFrames(getStackTrace(paramThrowable));
  }
  
  public static String getStackTrace(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter, true));
    return localStringWriter.getBuffer().toString();
  }
  
  public static int getThrowableCount(Throwable paramThrowable)
  {
    return getThrowableList(paramThrowable).size();
  }
  
  public static List getThrowableList(Throwable paramThrowable)
  {
    ArrayList localArrayList = new ArrayList();
    while ((paramThrowable != null) && (!localArrayList.contains(paramThrowable)))
    {
      localArrayList.add(paramThrowable);
      paramThrowable = getCause(paramThrowable);
    }
    return localArrayList;
  }
  
  public static Throwable[] getThrowables(Throwable paramThrowable)
  {
    paramThrowable = getThrowableList(paramThrowable);
    return (Throwable[])paramThrowable.toArray(new Throwable[paramThrowable.size()]);
  }
  
  private static int indexOf(Throwable paramThrowable, Class paramClass, int paramInt, boolean paramBoolean)
  {
    if (paramThrowable != null)
    {
      if (paramClass == null) {
        return -1;
      }
      int i = paramInt;
      if (paramInt < 0) {
        i = 0;
      }
      paramThrowable = getThrowables(paramThrowable);
      if (i >= paramThrowable.length) {
        return -1;
      }
      paramInt = i;
      if (paramBoolean) {
        while (i < paramThrowable.length)
        {
          if (paramClass.isAssignableFrom(paramThrowable[i].getClass())) {
            return i;
          }
          i += 1;
        }
      }
      while (paramInt < paramThrowable.length)
      {
        if (paramClass.equals(paramThrowable[paramInt].getClass())) {
          return paramInt;
        }
        paramInt += 1;
      }
    }
    return -1;
  }
  
  public static int indexOfThrowable(Throwable paramThrowable, Class paramClass)
  {
    return indexOf(paramThrowable, paramClass, 0, false);
  }
  
  public static int indexOfThrowable(Throwable paramThrowable, Class paramClass, int paramInt)
  {
    return indexOf(paramThrowable, paramClass, paramInt, false);
  }
  
  public static int indexOfType(Throwable paramThrowable, Class paramClass)
  {
    return indexOf(paramThrowable, paramClass, 0, true);
  }
  
  public static int indexOfType(Throwable paramThrowable, Class paramClass, int paramInt)
  {
    return indexOf(paramThrowable, paramClass, paramInt, true);
  }
  
  public static boolean isCauseMethodName(String paramString)
  {
    for (;;)
    {
      synchronized (CAUSE_METHOD_NAMES_LOCK)
      {
        if (ArrayUtils.indexOf(CAUSE_METHOD_NAMES, paramString) >= 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public static boolean isNestedThrowable(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return false;
    }
    if ((paramThrowable instanceof Nestable)) {
      return true;
    }
    if ((paramThrowable instanceof SQLException)) {
      return true;
    }
    if ((paramThrowable instanceof InvocationTargetException)) {
      return true;
    }
    if (isThrowableNested()) {
      return true;
    }
    Class localClass = paramThrowable.getClass();
    synchronized (CAUSE_METHOD_NAMES_LOCK)
    {
      int j = CAUSE_METHOD_NAMES.length;
      int i = 0;
      if (i < j) {}
      try
      {
        Method localMethod = localClass.getMethod(CAUSE_METHOD_NAMES[i], null);
        if (localMethod != null)
        {
          if (class$java$lang$Throwable == null)
          {
            paramThrowable = class$("java.lang.Throwable");
            class$java$lang$Throwable = paramThrowable;
          }
          else
          {
            paramThrowable = class$java$lang$Throwable;
          }
          boolean bool = paramThrowable.isAssignableFrom(localMethod.getReturnType());
          if (bool) {
            return true;
          }
        }
      }
      catch (NoSuchMethodException|SecurityException paramThrowable)
      {
        i += 1;
      }
    }
  }
  
  public static boolean isThrowableNested()
  {
    return THROWABLE_CAUSE_METHOD != null;
  }
  
  public static void printRootCauseStackTrace(Throwable paramThrowable)
  {
    printRootCauseStackTrace(paramThrowable, System.err);
  }
  
  public static void printRootCauseStackTrace(Throwable paramThrowable, PrintStream paramPrintStream)
  {
    if (paramThrowable == null) {
      return;
    }
    if (paramPrintStream != null)
    {
      paramThrowable = getRootCauseStackTrace(paramThrowable);
      int i = 0;
      while (i < paramThrowable.length)
      {
        paramPrintStream.println(paramThrowable[i]);
        i += 1;
      }
      paramPrintStream.flush();
      return;
    }
    paramThrowable = new IllegalArgumentException("The PrintStream must not be null");
    for (;;)
    {
      throw paramThrowable;
    }
  }
  
  public static void printRootCauseStackTrace(Throwable paramThrowable, PrintWriter paramPrintWriter)
  {
    if (paramThrowable == null) {
      return;
    }
    if (paramPrintWriter != null)
    {
      paramThrowable = getRootCauseStackTrace(paramThrowable);
      int i = 0;
      while (i < paramThrowable.length)
      {
        paramPrintWriter.println(paramThrowable[i]);
        i += 1;
      }
      paramPrintWriter.flush();
      return;
    }
    paramThrowable = new IllegalArgumentException("The PrintWriter must not be null");
    for (;;)
    {
      throw paramThrowable;
    }
  }
  
  public static void removeCauseMethodName(String arg0)
  {
    if (StringUtils.isNotEmpty(???))
    {
      ArrayList localArrayList = getCauseMethodNameList();
      if (localArrayList.remove(???)) {
        synchronized (CAUSE_METHOD_NAMES_LOCK)
        {
          CAUSE_METHOD_NAMES = toArray(localArrayList);
          return;
        }
      }
    }
  }
  
  public static void removeCommonFrames(List paramList1, List paramList2)
  {
    if ((paramList1 != null) && (paramList2 != null))
    {
      int j = paramList1.size() - 1;
      int i = paramList2.size() - 1;
      while ((j >= 0) && (i >= 0))
      {
        if (((String)paramList1.get(j)).equals((String)paramList2.get(i))) {
          paramList1.remove(j);
        }
        j -= 1;
        i -= 1;
      }
      return;
    }
    paramList1 = new IllegalArgumentException("The List must not be null");
    for (;;)
    {
      throw paramList1;
    }
  }
  
  public static boolean setCause(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    Object[] arrayOfObject;
    if (paramThrowable1 != null)
    {
      arrayOfObject = new Object[1];
      arrayOfObject[0] = paramThrowable2;
      paramThrowable2 = THROWABLE_INITCAUSE_METHOD;
      if (paramThrowable2 == null) {}
    }
    try
    {
      paramThrowable2.invoke(paramThrowable1, arrayOfObject);
      bool = true;
    }
    catch (IllegalAccessException|InvocationTargetException paramThrowable2)
    {
      label33:
      break label33;
    }
    boolean bool = false;
    try
    {
      Class localClass = paramThrowable1.getClass();
      if (class$java$lang$Throwable == null)
      {
        paramThrowable2 = class$("java.lang.Throwable");
        class$java$lang$Throwable = paramThrowable2;
      }
      else
      {
        paramThrowable2 = class$java$lang$Throwable;
      }
      localClass.getMethod("setCause", new Class[] { paramThrowable2 }).invoke(paramThrowable1, arrayOfObject);
      return true;
    }
    catch (NoSuchMethodException|IllegalAccessException|InvocationTargetException paramThrowable1) {}
    throw new NullArgumentException("target");
    return bool;
  }
  
  private static String[] toArray(List paramList)
  {
    return (String[])paramList.toArray(new String[paramList.size()]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.exception.ExceptionUtils
 * JD-Core Version:    0.7.0.1
 */