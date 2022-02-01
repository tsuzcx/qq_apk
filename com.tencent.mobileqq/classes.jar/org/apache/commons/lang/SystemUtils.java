package org.apache.commons.lang;

import java.io.File;
import java.io.PrintStream;

public class SystemUtils
{
  public static final String AWT_TOOLKIT = getSystemProperty("awt.toolkit");
  public static final String FILE_ENCODING = getSystemProperty("file.encoding");
  public static final String FILE_SEPARATOR = getSystemProperty("file.separator");
  public static final boolean IS_JAVA_1_1;
  public static final boolean IS_JAVA_1_2;
  public static final boolean IS_JAVA_1_3;
  public static final boolean IS_JAVA_1_4;
  public static final boolean IS_JAVA_1_5;
  public static final boolean IS_JAVA_1_6;
  public static final boolean IS_JAVA_1_7;
  public static final boolean IS_OS_AIX;
  public static final boolean IS_OS_HP_UX;
  public static final boolean IS_OS_IRIX;
  public static final boolean IS_OS_LINUX;
  public static final boolean IS_OS_MAC;
  public static final boolean IS_OS_MAC_OSX;
  public static final boolean IS_OS_OS2;
  public static final boolean IS_OS_SOLARIS;
  public static final boolean IS_OS_SUN_OS;
  public static final boolean IS_OS_UNIX;
  public static final boolean IS_OS_WINDOWS;
  public static final boolean IS_OS_WINDOWS_2000;
  public static final boolean IS_OS_WINDOWS_7 = getOSMatches("Windows", "6.1");
  public static final boolean IS_OS_WINDOWS_95;
  public static final boolean IS_OS_WINDOWS_98;
  public static final boolean IS_OS_WINDOWS_ME;
  public static final boolean IS_OS_WINDOWS_NT;
  public static final boolean IS_OS_WINDOWS_VISTA;
  public static final boolean IS_OS_WINDOWS_XP;
  public static final String JAVA_AWT_FONTS = getSystemProperty("java.awt.fonts");
  public static final String JAVA_AWT_GRAPHICSENV = getSystemProperty("java.awt.graphicsenv");
  public static final String JAVA_AWT_HEADLESS = getSystemProperty("java.awt.headless");
  public static final String JAVA_AWT_PRINTERJOB = getSystemProperty("java.awt.printerjob");
  public static final String JAVA_CLASS_PATH = getSystemProperty("java.class.path");
  public static final String JAVA_CLASS_VERSION = getSystemProperty("java.class.version");
  public static final String JAVA_COMPILER = getSystemProperty("java.compiler");
  public static final String JAVA_ENDORSED_DIRS = getSystemProperty("java.endorsed.dirs");
  public static final String JAVA_EXT_DIRS = getSystemProperty("java.ext.dirs");
  public static final String JAVA_HOME = getSystemProperty("java.home");
  private static final String JAVA_HOME_KEY = "java.home";
  public static final String JAVA_IO_TMPDIR = getSystemProperty("java.io.tmpdir");
  private static final String JAVA_IO_TMPDIR_KEY = "java.io.tmpdir";
  public static final String JAVA_LIBRARY_PATH = getSystemProperty("java.library.path");
  public static final String JAVA_RUNTIME_NAME = getSystemProperty("java.runtime.name");
  public static final String JAVA_RUNTIME_VERSION = getSystemProperty("java.runtime.version");
  public static final String JAVA_SPECIFICATION_NAME = getSystemProperty("java.specification.name");
  public static final String JAVA_SPECIFICATION_VENDOR = getSystemProperty("java.specification.vendor");
  public static final String JAVA_SPECIFICATION_VERSION = getSystemProperty("java.specification.version");
  public static final String JAVA_UTIL_PREFS_PREFERENCES_FACTORY = getSystemProperty("java.util.prefs.PreferencesFactory");
  public static final String JAVA_VENDOR = getSystemProperty("java.vendor");
  public static final String JAVA_VENDOR_URL = getSystemProperty("java.vendor.url");
  public static final String JAVA_VERSION = getSystemProperty("java.version");
  public static final float JAVA_VERSION_FLOAT;
  public static final int JAVA_VERSION_INT;
  public static final String JAVA_VERSION_TRIMMED;
  private static final int JAVA_VERSION_TRIM_SIZE = 3;
  public static final String JAVA_VM_INFO = getSystemProperty("java.vm.info");
  public static final String JAVA_VM_NAME = getSystemProperty("java.vm.name");
  public static final String JAVA_VM_SPECIFICATION_NAME = getSystemProperty("java.vm.specification.name");
  public static final String JAVA_VM_SPECIFICATION_VENDOR = getSystemProperty("java.vm.specification.vendor");
  public static final String JAVA_VM_SPECIFICATION_VERSION = getSystemProperty("java.vm.specification.version");
  public static final String JAVA_VM_VENDOR = getSystemProperty("java.vm.vendor");
  public static final String JAVA_VM_VERSION = getSystemProperty("java.vm.version");
  public static final String LINE_SEPARATOR = getSystemProperty("line.separator");
  public static final String OS_ARCH = getSystemProperty("os.arch");
  public static final String OS_NAME = getSystemProperty("os.name");
  private static final String OS_NAME_WINDOWS_PREFIX = "Windows";
  public static final String OS_VERSION = getSystemProperty("os.version");
  public static final String PATH_SEPARATOR = getSystemProperty("path.separator");
  public static final String USER_COUNTRY;
  public static final String USER_DIR;
  private static final String USER_DIR_KEY = "user.dir";
  public static final String USER_HOME;
  private static final String USER_HOME_KEY = "user.home";
  public static final String USER_LANGUAGE;
  public static final String USER_NAME;
  public static final String USER_TIMEZONE;
  
  static
  {
    String str = "user.country";
    if (getSystemProperty("user.country") == null) {
      str = "user.region";
    }
    USER_COUNTRY = getSystemProperty(str);
    USER_DIR = getSystemProperty("user.dir");
    USER_HOME = getSystemProperty("user.home");
    USER_LANGUAGE = getSystemProperty("user.language");
    USER_NAME = getSystemProperty("user.name");
    USER_TIMEZONE = getSystemProperty("user.timezone");
    JAVA_VERSION_TRIMMED = getJavaVersionTrimmed();
    JAVA_VERSION_FLOAT = getJavaVersionAsFloat();
    JAVA_VERSION_INT = getJavaVersionAsInt();
    IS_JAVA_1_1 = getJavaVersionMatches("1.1");
    IS_JAVA_1_2 = getJavaVersionMatches("1.2");
    IS_JAVA_1_3 = getJavaVersionMatches("1.3");
    IS_JAVA_1_4 = getJavaVersionMatches("1.4");
    IS_JAVA_1_5 = getJavaVersionMatches("1.5");
    IS_JAVA_1_6 = getJavaVersionMatches("1.6");
    IS_JAVA_1_7 = getJavaVersionMatches("1.7");
    IS_OS_AIX = getOSMatchesName("AIX");
    IS_OS_HP_UX = getOSMatchesName("HP-UX");
    IS_OS_IRIX = getOSMatchesName("Irix");
    boolean bool1 = getOSMatchesName("Linux");
    boolean bool2 = false;
    if ((!bool1) && (!getOSMatchesName("LINUX"))) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    IS_OS_LINUX = bool1;
    IS_OS_MAC = getOSMatchesName("Mac");
    IS_OS_MAC_OSX = getOSMatchesName("Mac OS X");
    IS_OS_OS2 = getOSMatchesName("OS/2");
    IS_OS_SOLARIS = getOSMatchesName("Solaris");
    IS_OS_SUN_OS = getOSMatchesName("SunOS");
    if ((!IS_OS_AIX) && (!IS_OS_HP_UX) && (!IS_OS_IRIX) && (!IS_OS_LINUX) && (!IS_OS_MAC_OSX) && (!IS_OS_SOLARIS))
    {
      bool1 = bool2;
      if (!IS_OS_SUN_OS) {}
    }
    else
    {
      bool1 = true;
    }
    IS_OS_UNIX = bool1;
    IS_OS_WINDOWS = getOSMatchesName("Windows");
    IS_OS_WINDOWS_2000 = getOSMatches("Windows", "5.0");
    IS_OS_WINDOWS_95 = getOSMatches("Windows 9", "4.0");
    IS_OS_WINDOWS_98 = getOSMatches("Windows 9", "4.1");
    IS_OS_WINDOWS_ME = getOSMatches("Windows", "4.9");
    IS_OS_WINDOWS_NT = getOSMatchesName("Windows NT");
    IS_OS_WINDOWS_XP = getOSMatches("Windows", "5.1");
    IS_OS_WINDOWS_VISTA = getOSMatches("Windows", "6.0");
  }
  
  public static File getJavaHome()
  {
    return new File(System.getProperty("java.home"));
  }
  
  public static File getJavaIoTmpDir()
  {
    return new File(System.getProperty("java.io.tmpdir"));
  }
  
  public static float getJavaVersion()
  {
    return JAVA_VERSION_FLOAT;
  }
  
  private static float getJavaVersionAsFloat()
  {
    return toVersionFloat(toJavaVersionIntArray(JAVA_VERSION, 3));
  }
  
  private static int getJavaVersionAsInt()
  {
    return toVersionInt(toJavaVersionIntArray(JAVA_VERSION, 3));
  }
  
  private static boolean getJavaVersionMatches(String paramString)
  {
    return isJavaVersionMatch(JAVA_VERSION_TRIMMED, paramString);
  }
  
  private static String getJavaVersionTrimmed()
  {
    if (JAVA_VERSION != null)
    {
      int i = 0;
      while (i < JAVA_VERSION.length())
      {
        int j = JAVA_VERSION.charAt(i);
        if ((j >= 48) && (j <= 57)) {
          return JAVA_VERSION.substring(i);
        }
        i += 1;
      }
    }
    return null;
  }
  
  private static boolean getOSMatches(String paramString1, String paramString2)
  {
    return isOSMatch(OS_NAME, OS_VERSION, paramString1, paramString2);
  }
  
  private static boolean getOSMatchesName(String paramString)
  {
    return isOSNameMatch(OS_NAME, paramString);
  }
  
  private static String getSystemProperty(String paramString)
  {
    try
    {
      localObject = System.getProperty(paramString);
      return localObject;
    }
    catch (SecurityException localSecurityException)
    {
      Object localObject;
      label7:
      StringBuffer localStringBuffer;
      break label7;
    }
    localObject = System.err;
    localStringBuffer = new StringBuffer();
    localStringBuffer.append("Caught a SecurityException reading the system property '");
    localStringBuffer.append(paramString);
    localStringBuffer.append("'; the SystemUtils property value will default to null.");
    ((PrintStream)localObject).println(localStringBuffer.toString());
    return null;
  }
  
  public static File getUserDir()
  {
    return new File(System.getProperty("user.dir"));
  }
  
  public static File getUserHome()
  {
    return new File(System.getProperty("user.home"));
  }
  
  public static boolean isJavaAwtHeadless()
  {
    String str = JAVA_AWT_HEADLESS;
    if (str != null) {
      return str.equals(Boolean.TRUE.toString());
    }
    return false;
  }
  
  public static boolean isJavaVersionAtLeast(float paramFloat)
  {
    return JAVA_VERSION_FLOAT >= paramFloat;
  }
  
  public static boolean isJavaVersionAtLeast(int paramInt)
  {
    return JAVA_VERSION_INT >= paramInt;
  }
  
  static boolean isJavaVersionMatch(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return false;
    }
    return paramString1.startsWith(paramString2);
  }
  
  static boolean isOSMatch(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return false;
      }
      bool1 = bool2;
      if (paramString1.startsWith(paramString3))
      {
        bool1 = bool2;
        if (paramString2.startsWith(paramString4)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  static boolean isOSNameMatch(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return false;
    }
    return paramString1.startsWith(paramString2);
  }
  
  static float toJavaVersionFloat(String paramString)
  {
    return toVersionFloat(toJavaVersionIntArray(paramString, 3));
  }
  
  static int toJavaVersionInt(String paramString)
  {
    return toVersionInt(toJavaVersionIntArray(paramString, 3));
  }
  
  static int[] toJavaVersionIntArray(String paramString)
  {
    return toJavaVersionIntArray(paramString, 2147483647);
  }
  
  private static int[] toJavaVersionIntArray(String paramString, int paramInt)
  {
    if (paramString == null) {
      return ArrayUtils.EMPTY_INT_ARRAY;
    }
    Object localObject = StringUtils.split(paramString, "._- ");
    paramString = new int[Math.min(paramInt, localObject.length)];
    int i = 0;
    for (j = 0; (i < localObject.length) && (j < paramInt); j = k)
    {
      String str = localObject[i];
      k = j;
      if (str.length() > 0) {}
      try
      {
        paramString[j] = Integer.parseInt(str);
        k = j + 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          k = j;
        }
      }
      i += 1;
    }
    if (paramString.length > j)
    {
      localObject = new int[j];
      System.arraycopy(paramString, 0, localObject, 0, j);
      return localObject;
    }
    return paramString;
  }
  
  private static float toVersionFloat(int[] paramArrayOfInt)
  {
    StringBuffer localStringBuffer;
    if (paramArrayOfInt != null)
    {
      if (paramArrayOfInt.length == 0) {
        return 0.0F;
      }
      int j = paramArrayOfInt.length;
      int i = 1;
      if (j == 1) {
        return paramArrayOfInt[0];
      }
      localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramArrayOfInt[0]);
      localStringBuffer.append('.');
      while (i < paramArrayOfInt.length)
      {
        localStringBuffer.append(paramArrayOfInt[i]);
        i += 1;
      }
    }
    try
    {
      float f = Float.parseFloat(localStringBuffer.toString());
      return f;
    }
    catch (Exception paramArrayOfInt) {}
    return 0.0F;
    return 0.0F;
  }
  
  private static int toVersionInt(int[] paramArrayOfInt)
  {
    int j = 0;
    if (paramArrayOfInt == null) {
      return 0;
    }
    int k = paramArrayOfInt.length;
    if (k >= 1) {
      j = paramArrayOfInt[0] * 100;
    }
    int i = j;
    if (k >= 2) {
      i = j + paramArrayOfInt[1] * 10;
    }
    j = i;
    if (k >= 3) {
      j = i + paramArrayOfInt[2];
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     org.apache.commons.lang.SystemUtils
 * JD-Core Version:    0.7.0.1
 */