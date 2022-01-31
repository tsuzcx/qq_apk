package junit.runner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.NumberFormat;
import java.util.Properties;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestListener;
import junit.framework.TestSuite;

public abstract class BaseTestRunner
  implements TestListener
{
  public static final String SUITE_METHODNAME = "suite";
  private static Properties fPreferences;
  static boolean fgFilterStack = true;
  static int fgMaxMessageLength = getPreference("maxmessage", fgMaxMessageLength);
  boolean fLoading = true;
  
  static boolean filterLine(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = new String[8];
    arrayOfString[0] = "junit.framework.TestCase";
    arrayOfString[1] = "junit.framework.TestResult";
    arrayOfString[2] = "junit.framework.TestSuite";
    arrayOfString[3] = "junit.framework.Assert.";
    arrayOfString[4] = "junit.swingui.TestRunner";
    arrayOfString[5] = "junit.awtui.TestRunner";
    arrayOfString[6] = "junit.textui.TestRunner";
    arrayOfString[7] = "java.lang.reflect.Method.invoke(";
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < arrayOfString.length)
      {
        if (paramString.indexOf(arrayOfString[i]) > 0) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static String getFilteredTrace(String paramString)
  {
    if (showStackRaw()) {
      return paramString;
    }
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    BufferedReader localBufferedReader = new BufferedReader(new StringReader(paramString));
    try
    {
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        if (!filterLine(str)) {
          localPrintWriter.println(str);
        }
      }
      return localException.toString();
    }
    catch (Exception localException)
    {
      return paramString;
    }
  }
  
  public static String getFilteredTrace(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return getFilteredTrace(localStringWriter.toString());
  }
  
  public static int getPreference(String paramString, int paramInt)
  {
    paramString = getPreference(paramString);
    if (paramString == null) {
      return paramInt;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString) {}
    return paramInt;
  }
  
  public static String getPreference(String paramString)
  {
    return getPreferences().getProperty(paramString);
  }
  
  protected static Properties getPreferences()
  {
    if (fPreferences == null)
    {
      fPreferences = new Properties();
      fPreferences.put("loading", "true");
      fPreferences.put("filterstack", "true");
      readPreferences();
    }
    return fPreferences;
  }
  
  private static File getPreferencesFile()
  {
    return new File(System.getProperty("user.home"), "junit.properties");
  }
  
  /* Error */
  private static void readPreferences()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 158	java/io/FileInputStream
    //   5: dup
    //   6: invokestatic 160	junit/runner/BaseTestRunner:getPreferencesFile	()Ljava/io/File;
    //   9: invokespecial 163	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   12: astore_0
    //   13: new 121	java/util/Properties
    //   16: dup
    //   17: invokestatic 119	junit/runner/BaseTestRunner:getPreferences	()Ljava/util/Properties;
    //   20: invokespecial 166	java/util/Properties:<init>	(Ljava/util/Properties;)V
    //   23: invokestatic 169	junit/runner/BaseTestRunner:setPreferences	(Ljava/util/Properties;)V
    //   26: invokestatic 119	junit/runner/BaseTestRunner:getPreferences	()Ljava/util/Properties;
    //   29: aload_0
    //   30: invokevirtual 173	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   33: aload_0
    //   34: ifnull +7 -> 41
    //   37: aload_0
    //   38: invokevirtual 178	java/io/InputStream:close	()V
    //   41: return
    //   42: astore_0
    //   43: aconst_null
    //   44: astore_0
    //   45: aload_0
    //   46: ifnull -5 -> 41
    //   49: aload_0
    //   50: invokevirtual 178	java/io/InputStream:close	()V
    //   53: return
    //   54: astore_0
    //   55: return
    //   56: astore_0
    //   57: aload_1
    //   58: ifnull +7 -> 65
    //   61: aload_1
    //   62: invokevirtual 178	java/io/InputStream:close	()V
    //   65: aload_0
    //   66: athrow
    //   67: astore_0
    //   68: return
    //   69: astore_1
    //   70: goto -5 -> 65
    //   73: astore_2
    //   74: aload_0
    //   75: astore_1
    //   76: aload_2
    //   77: astore_0
    //   78: goto -21 -> 57
    //   81: astore_1
    //   82: goto -37 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	26	0	localFileInputStream	java.io.FileInputStream
    //   42	1	0	localIOException1	java.io.IOException
    //   44	6	0	localObject1	Object
    //   54	1	0	localIOException2	java.io.IOException
    //   56	10	0	localObject2	Object
    //   67	8	0	localIOException3	java.io.IOException
    //   77	1	0	localObject3	Object
    //   1	61	1	localObject4	Object
    //   69	1	1	localIOException4	java.io.IOException
    //   75	1	1	localObject5	Object
    //   81	1	1	localIOException5	java.io.IOException
    //   73	4	2	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	42	java/io/IOException
    //   49	53	54	java/io/IOException
    //   2	13	56	finally
    //   37	41	67	java/io/IOException
    //   61	65	69	java/io/IOException
    //   13	33	73	finally
    //   13	33	81	java/io/IOException
  }
  
  public static void savePreferences()
  {
    FileOutputStream localFileOutputStream = new FileOutputStream(getPreferencesFile());
    try
    {
      getPreferences().store(localFileOutputStream, "");
      return;
    }
    finally
    {
      localFileOutputStream.close();
    }
  }
  
  public static void setPreference(String paramString1, String paramString2)
  {
    getPreferences().put(paramString1, paramString2);
  }
  
  protected static void setPreferences(Properties paramProperties)
  {
    fPreferences = paramProperties;
  }
  
  protected static boolean showStackRaw()
  {
    return (!getPreference("filterstack").equals("true")) || (!fgFilterStack);
  }
  
  public static String truncate(String paramString)
  {
    String str = paramString;
    if (fgMaxMessageLength != -1)
    {
      str = paramString;
      if (paramString.length() > fgMaxMessageLength) {
        str = paramString.substring(0, fgMaxMessageLength) + "...";
      }
    }
    return str;
  }
  
  public void addError(Test paramTest, Throwable paramThrowable)
  {
    try
    {
      testFailed(1, paramTest, paramThrowable);
      return;
    }
    finally
    {
      paramTest = finally;
      throw paramTest;
    }
  }
  
  public void addFailure(Test paramTest, AssertionFailedError paramAssertionFailedError)
  {
    try
    {
      testFailed(2, paramTest, paramAssertionFailedError);
      return;
    }
    finally
    {
      paramTest = finally;
      throw paramTest;
    }
  }
  
  protected void clearStatus() {}
  
  public String elapsedTimeAsString(long paramLong)
  {
    return NumberFormat.getInstance().format(paramLong / 1000.0D);
  }
  
  public void endTest(Test paramTest)
  {
    try
    {
      testEnded(paramTest.toString());
      return;
    }
    finally
    {
      paramTest = finally;
      throw paramTest;
    }
  }
  
  public String extractClassName(String paramString)
  {
    String str = paramString;
    if (paramString.startsWith("Default package for")) {
      str = paramString.substring(paramString.lastIndexOf(".") + 1);
    }
    return str;
  }
  
  public Test getTest(String paramString)
  {
    if (paramString.length() <= 0)
    {
      clearStatus();
      paramString = null;
      return paramString;
    }
    for (;;)
    {
      Object localObject;
      try
      {
        for (;;)
        {
          Class localClass = loadSuiteClass(paramString);
          try
          {
            localObject = (Test)paramString.invoke(null, new Object[0]);
            paramString = (String)localObject;
            if (localObject == null) {
              break;
            }
            clearStatus();
            return localObject;
          }
          catch (InvocationTargetException paramString)
          {
            runFailed("Failed to invoke suite():" + paramString.getTargetException().toString());
            return null;
          }
          catch (IllegalAccessException paramString)
          {
            runFailed("Failed to invoke suite():" + paramString.toString());
            return null;
          }
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        try
        {
          paramString = localClass.getMethod("suite", new Class[0]);
          if (Modifier.isStatic(paramString.getModifiers())) {
            break label137;
          }
          runFailed("Suite() method must be static");
          return null;
        }
        catch (Exception paramString)
        {
          clearStatus();
          return new TestSuite((Class)localObject);
        }
        localClassNotFoundException = localClassNotFoundException;
        localObject = localClassNotFoundException.getMessage();
        if (localObject == null)
        {
          runFailed("Class not found \"" + paramString + "\"");
          return null;
        }
      }
      catch (Exception paramString)
      {
        runFailed("Error: " + paramString.toString());
        return null;
      }
      label137:
      paramString = (String)localObject;
    }
  }
  
  protected Class<?> loadSuiteClass(String paramString)
  {
    return Class.forName(paramString);
  }
  
  protected String processArguments(String[] paramArrayOfString)
  {
    String str = null;
    int i = 0;
    if (i < paramArrayOfString.length)
    {
      if (paramArrayOfString[i].equals("-noloading")) {
        setLoading(false);
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramArrayOfString[i].equals("-nofilterstack"))
        {
          fgFilterStack = false;
        }
        else
        {
          if (paramArrayOfString[i].equals("-c"))
          {
            if (paramArrayOfString.length > i + 1) {
              str = extractClassName(paramArrayOfString[(i + 1)]);
            }
            for (;;)
            {
              i += 1;
              break;
              System.out.println("Missing Test class name");
            }
          }
          str = paramArrayOfString[i];
        }
      }
    }
    return str;
  }
  
  protected abstract void runFailed(String paramString);
  
  public void setLoading(boolean paramBoolean)
  {
    this.fLoading = paramBoolean;
  }
  
  public void startTest(Test paramTest)
  {
    try
    {
      testStarted(paramTest.toString());
      return;
    }
    finally
    {
      paramTest = finally;
      throw paramTest;
    }
  }
  
  public abstract void testEnded(String paramString);
  
  public abstract void testFailed(int paramInt, Test paramTest, Throwable paramThrowable);
  
  public abstract void testStarted(String paramString);
  
  protected boolean useReloadingTestSuiteLoader()
  {
    return (getPreference("loading").equals("true")) && (this.fLoading);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     junit.runner.BaseTestRunner
 * JD-Core Version:    0.7.0.1
 */