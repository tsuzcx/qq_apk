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
    while (i < arrayOfString.length)
    {
      if (paramString.indexOf(arrayOfString[i]) > 0) {
        return true;
      }
      i += 1;
    }
    return false;
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
      return localStringWriter.toString();
    }
    catch (Exception localException) {}
    return paramString;
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
    //   0: new 158	java/io/FileInputStream
    //   3: dup
    //   4: invokestatic 160	junit/runner/BaseTestRunner:getPreferencesFile	()Ljava/io/File;
    //   7: invokespecial 163	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   10: astore_0
    //   11: new 121	java/util/Properties
    //   14: dup
    //   15: invokestatic 119	junit/runner/BaseTestRunner:getPreferences	()Ljava/util/Properties;
    //   18: invokespecial 166	java/util/Properties:<init>	(Ljava/util/Properties;)V
    //   21: invokestatic 169	junit/runner/BaseTestRunner:setPreferences	(Ljava/util/Properties;)V
    //   24: invokestatic 119	junit/runner/BaseTestRunner:getPreferences	()Ljava/util/Properties;
    //   27: aload_0
    //   28: invokevirtual 173	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   31: aload_0
    //   32: invokevirtual 178	java/io/InputStream:close	()V
    //   35: return
    //   36: astore_1
    //   37: goto +6 -> 43
    //   40: astore_1
    //   41: aconst_null
    //   42: astore_0
    //   43: aload_0
    //   44: ifnull +7 -> 51
    //   47: aload_0
    //   48: invokevirtual 178	java/io/InputStream:close	()V
    //   51: aload_1
    //   52: athrow
    //   53: aconst_null
    //   54: astore_0
    //   55: aload_0
    //   56: ifnull +6 -> 62
    //   59: goto -28 -> 31
    //   62: return
    //   63: astore_0
    //   64: goto -11 -> 53
    //   67: astore_1
    //   68: goto -13 -> 55
    //   71: astore_0
    //   72: return
    //   73: astore_0
    //   74: goto -23 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   10	46	0	localFileInputStream	java.io.FileInputStream
    //   63	1	0	localIOException1	java.io.IOException
    //   71	1	0	localIOException2	java.io.IOException
    //   73	1	0	localIOException3	java.io.IOException
    //   36	1	1	localObject1	Object
    //   40	12	1	localObject2	Object
    //   67	1	1	localIOException4	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   11	31	36	finally
    //   0	11	40	finally
    //   0	11	63	java/io/IOException
    //   11	31	67	java/io/IOException
    //   31	35	71	java/io/IOException
    //   47	51	73	java/io/IOException
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
    Object localObject = paramString;
    if (fgMaxMessageLength != -1)
    {
      localObject = paramString;
      if (paramString.length() > fgMaxMessageLength)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.substring(0, fgMaxMessageLength));
        ((StringBuilder)localObject).append("...");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
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
    NumberFormat localNumberFormat = NumberFormat.getInstance();
    double d = paramLong;
    Double.isNaN(d);
    return localNumberFormat.format(d / 1000.0D);
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
      return null;
    }
    try
    {
      localObject1 = loadSuiteClass(paramString);
    }
    catch (Exception paramString)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Error: ");
      ((StringBuilder)localObject1).append(paramString.toString());
      runFailed(((StringBuilder)localObject1).toString());
      return null;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label149:
      Object localObject2 = localClassNotFoundException.getMessage();
      if (localObject2 != null) {
        paramString = (String)localObject2;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Class not found \"");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append("\"");
      runFailed(((StringBuilder)localObject2).toString());
      return null;
    }
    try
    {
      paramString = ((Class)localObject1).getMethod("suite", new Class[0]);
      if (!Modifier.isStatic(paramString.getModifiers()))
      {
        runFailed("Suite() method must be static");
        return null;
      }
      try
      {
        paramString = (Test)paramString.invoke(null, new Object[0]);
        if (paramString == null) {
          return paramString;
        }
        clearStatus();
        return paramString;
      }
      catch (IllegalAccessException paramString)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Failed to invoke suite():");
        ((StringBuilder)localObject1).append(paramString.toString());
        runFailed(((StringBuilder)localObject1).toString());
        return null;
      }
      catch (InvocationTargetException paramString)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Failed to invoke suite():");
        ((StringBuilder)localObject1).append(paramString.getTargetException().toString());
        runFailed(((StringBuilder)localObject1).toString());
        return null;
      }
    }
    catch (Exception paramString)
    {
      break label149;
    }
    clearStatus();
    return new TestSuite((Class)localObject1);
  }
  
  protected Class<?> loadSuiteClass(String paramString)
  {
    return Class.forName(paramString);
  }
  
  protected String processArguments(String[] paramArrayOfString)
  {
    String str = null;
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      if (paramArrayOfString[i].equals("-noloading"))
      {
        setLoading(false);
      }
      else if (paramArrayOfString[i].equals("-nofilterstack"))
      {
        fgFilterStack = false;
      }
      else if (paramArrayOfString[i].equals("-c"))
      {
        int j = paramArrayOfString.length;
        i += 1;
        if (j > i) {
          str = extractClassName(paramArrayOfString[i]);
        } else {
          System.out.println("Missing Test class name");
        }
      }
      else
      {
        str = paramArrayOfString[i];
      }
      i += 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     junit.runner.BaseTestRunner
 * JD-Core Version:    0.7.0.1
 */