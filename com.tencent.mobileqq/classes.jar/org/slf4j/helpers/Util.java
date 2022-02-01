package org.slf4j.helpers;

import java.io.PrintStream;

public final class Util
{
  private static Util.ClassContextSecurityManager SECURITY_MANAGER;
  private static boolean SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED = false;
  
  public static Class<?> getCallingClass()
  {
    Object localObject = getSecurityManager();
    if (localObject == null) {
      return null;
    }
    localObject = ((Util.ClassContextSecurityManager)localObject).getClassContext();
    String str = Util.class.getName();
    int i = 0;
    while ((i < localObject.length) && (!str.equals(localObject[i].getName()))) {
      i += 1;
    }
    if (i < localObject.length)
    {
      i += 2;
      if (i < localObject.length) {
        return localObject[i];
      }
    }
    localObject = new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  private static Util.ClassContextSecurityManager getSecurityManager()
  {
    Util.ClassContextSecurityManager localClassContextSecurityManager = SECURITY_MANAGER;
    if (localClassContextSecurityManager != null) {
      return localClassContextSecurityManager;
    }
    if (SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED) {
      return null;
    }
    SECURITY_MANAGER = safeCreateSecurityManager();
    SECURITY_MANAGER_CREATION_ALREADY_ATTEMPTED = true;
    return SECURITY_MANAGER;
  }
  
  public static final void report(String paramString)
  {
    PrintStream localPrintStream = System.err;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SLF4J: ");
    localStringBuilder.append(paramString);
    localPrintStream.println(localStringBuilder.toString());
  }
  
  public static final void report(String paramString, Throwable paramThrowable)
  {
    System.err.println(paramString);
    System.err.println("Reported exception:");
    paramThrowable.printStackTrace();
  }
  
  private static Util.ClassContextSecurityManager safeCreateSecurityManager()
  {
    try
    {
      Util.ClassContextSecurityManager localClassContextSecurityManager = new Util.ClassContextSecurityManager(null);
      return localClassContextSecurityManager;
    }
    catch (SecurityException localSecurityException) {}
    return null;
  }
  
  public static boolean safeGetBooleanSystemProperty(String paramString)
  {
    paramString = safeGetSystemProperty(paramString);
    if (paramString == null) {
      return false;
    }
    return paramString.equalsIgnoreCase("true");
  }
  
  public static String safeGetSystemProperty(String paramString)
  {
    if (paramString != null) {}
    try
    {
      paramString = System.getProperty(paramString);
      return paramString;
    }
    catch (SecurityException paramString) {}
    throw new IllegalArgumentException("null input");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.slf4j.helpers.Util
 * JD-Core Version:    0.7.0.1
 */