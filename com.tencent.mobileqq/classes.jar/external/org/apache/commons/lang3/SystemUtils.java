package external.org.apache.commons.lang3;

import java.io.File;
import java.io.PrintStream;

public class SystemUtils
{
  public static final String AWT_TOOLKIT;
  public static final String FILE_ENCODING;
  public static final String FILE_SEPARATOR;
  public static final boolean IS_JAVA_1_1;
  public static final boolean IS_JAVA_1_2;
  public static final boolean IS_JAVA_1_3;
  public static final boolean IS_JAVA_1_4;
  public static final boolean IS_JAVA_1_5;
  public static final boolean IS_JAVA_1_6;
  public static final boolean IS_JAVA_1_7;
  public static final boolean IS_OS_AIX;
  public static final boolean IS_OS_FREE_BSD;
  public static final boolean IS_OS_HP_UX;
  public static final boolean IS_OS_IRIX;
  public static final boolean IS_OS_LINUX;
  public static final boolean IS_OS_MAC;
  public static final boolean IS_OS_MAC_OSX;
  public static final boolean IS_OS_NET_BSD;
  public static final boolean IS_OS_OPEN_BSD;
  public static final boolean IS_OS_OS2;
  public static final boolean IS_OS_SOLARIS;
  public static final boolean IS_OS_SUN_OS;
  public static final boolean IS_OS_UNIX;
  public static final boolean IS_OS_WINDOWS;
  public static final boolean IS_OS_WINDOWS_2000;
  public static final boolean IS_OS_WINDOWS_2003;
  public static final boolean IS_OS_WINDOWS_2008;
  public static final boolean IS_OS_WINDOWS_7;
  public static final boolean IS_OS_WINDOWS_95;
  public static final boolean IS_OS_WINDOWS_98;
  public static final boolean IS_OS_WINDOWS_ME;
  public static final boolean IS_OS_WINDOWS_NT;
  public static final boolean IS_OS_WINDOWS_VISTA;
  public static final boolean IS_OS_WINDOWS_XP;
  public static final String JAVA_AWT_FONTS;
  public static final String JAVA_AWT_GRAPHICSENV;
  public static final String JAVA_AWT_HEADLESS;
  public static final String JAVA_AWT_PRINTERJOB;
  public static final String JAVA_CLASS_PATH;
  public static final String JAVA_CLASS_VERSION;
  public static final String JAVA_COMPILER;
  public static final String JAVA_ENDORSED_DIRS;
  public static final String JAVA_EXT_DIRS;
  public static final String JAVA_HOME;
  private static final String JAVA_HOME_KEY = "java.home";
  public static final String JAVA_IO_TMPDIR;
  private static final String JAVA_IO_TMPDIR_KEY = "java.io.tmpdir";
  public static final String JAVA_LIBRARY_PATH;
  public static final String JAVA_RUNTIME_NAME;
  public static final String JAVA_RUNTIME_VERSION;
  public static final String JAVA_SPECIFICATION_NAME;
  public static final String JAVA_SPECIFICATION_VENDOR;
  public static final String JAVA_SPECIFICATION_VERSION;
  private static final JavaVersion JAVA_SPECIFICATION_VERSION_AS_ENUM;
  public static final String JAVA_UTIL_PREFS_PREFERENCES_FACTORY;
  public static final String JAVA_VENDOR;
  public static final String JAVA_VENDOR_URL;
  public static final String JAVA_VERSION;
  public static final String JAVA_VM_INFO;
  public static final String JAVA_VM_NAME;
  public static final String JAVA_VM_SPECIFICATION_NAME;
  public static final String JAVA_VM_SPECIFICATION_VENDOR;
  public static final String JAVA_VM_SPECIFICATION_VERSION;
  public static final String JAVA_VM_VENDOR;
  public static final String JAVA_VM_VERSION;
  public static final String LINE_SEPARATOR;
  public static final String OS_ARCH;
  public static final String OS_NAME;
  private static final String OS_NAME_WINDOWS_PREFIX = "Windows";
  public static final String OS_VERSION;
  public static final String PATH_SEPARATOR;
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
    boolean bool2 = false;
    AWT_TOOLKIT = getSystemProperty("awt.toolkit");
    FILE_ENCODING = getSystemProperty("file.encoding");
    FILE_SEPARATOR = getSystemProperty("file.separator");
    JAVA_AWT_FONTS = getSystemProperty("java.awt.fonts");
    JAVA_AWT_GRAPHICSENV = getSystemProperty("java.awt.graphicsenv");
    JAVA_AWT_HEADLESS = getSystemProperty("java.awt.headless");
    JAVA_AWT_PRINTERJOB = getSystemProperty("java.awt.printerjob");
    JAVA_CLASS_PATH = getSystemProperty("java.class.path");
    JAVA_CLASS_VERSION = getSystemProperty("java.class.version");
    JAVA_COMPILER = getSystemProperty("java.compiler");
    JAVA_ENDORSED_DIRS = getSystemProperty("java.endorsed.dirs");
    JAVA_EXT_DIRS = getSystemProperty("java.ext.dirs");
    JAVA_HOME = getSystemProperty("java.home");
    JAVA_IO_TMPDIR = getSystemProperty("java.io.tmpdir");
    JAVA_LIBRARY_PATH = getSystemProperty("java.library.path");
    JAVA_RUNTIME_NAME = getSystemProperty("java.runtime.name");
    JAVA_RUNTIME_VERSION = getSystemProperty("java.runtime.version");
    JAVA_SPECIFICATION_NAME = getSystemProperty("java.specification.name");
    JAVA_SPECIFICATION_VENDOR = getSystemProperty("java.specification.vendor");
    JAVA_SPECIFICATION_VERSION = getSystemProperty("java.specification.version");
    JAVA_SPECIFICATION_VERSION_AS_ENUM = JavaVersion.get(JAVA_SPECIFICATION_VERSION);
    JAVA_UTIL_PREFS_PREFERENCES_FACTORY = getSystemProperty("java.util.prefs.PreferencesFactory");
    JAVA_VENDOR = getSystemProperty("java.vendor");
    JAVA_VENDOR_URL = getSystemProperty("java.vendor.url");
    JAVA_VERSION = getSystemProperty("java.version");
    JAVA_VM_INFO = getSystemProperty("java.vm.info");
    JAVA_VM_NAME = getSystemProperty("java.vm.name");
    JAVA_VM_SPECIFICATION_NAME = getSystemProperty("java.vm.specification.name");
    JAVA_VM_SPECIFICATION_VENDOR = getSystemProperty("java.vm.specification.vendor");
    JAVA_VM_SPECIFICATION_VERSION = getSystemProperty("java.vm.specification.version");
    JAVA_VM_VENDOR = getSystemProperty("java.vm.vendor");
    JAVA_VM_VERSION = getSystemProperty("java.vm.version");
    LINE_SEPARATOR = getSystemProperty("line.separator");
    OS_ARCH = getSystemProperty("os.arch");
    OS_NAME = getSystemProperty("os.name");
    OS_VERSION = getSystemProperty("os.version");
    PATH_SEPARATOR = getSystemProperty("path.separator");
    String str;
    if (getSystemProperty("user.country") == null)
    {
      str = getSystemProperty("user.region");
      USER_COUNTRY = str;
      USER_DIR = getSystemProperty("user.dir");
      USER_HOME = getSystemProperty("user.home");
      USER_LANGUAGE = getSystemProperty("user.language");
      USER_NAME = getSystemProperty("user.name");
      USER_TIMEZONE = getSystemProperty("user.timezone");
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
      if ((!getOSMatchesName("Linux")) && (!getOSMatchesName("LINUX"))) {
        break label743;
      }
    }
    label743:
    for (boolean bool1 = true;; bool1 = false)
    {
      IS_OS_LINUX = bool1;
      IS_OS_MAC = getOSMatchesName("Mac");
      IS_OS_MAC_OSX = getOSMatchesName("Mac OS X");
      IS_OS_FREE_BSD = getOSMatchesName("FreeBSD");
      IS_OS_OPEN_BSD = getOSMatchesName("OpenBSD");
      IS_OS_NET_BSD = getOSMatchesName("NetBSD");
      IS_OS_OS2 = getOSMatchesName("OS/2");
      IS_OS_SOLARIS = getOSMatchesName("Solaris");
      IS_OS_SUN_OS = getOSMatchesName("SunOS");
      if ((!IS_OS_AIX) && (!IS_OS_HP_UX) && (!IS_OS_IRIX) && (!IS_OS_LINUX) && (!IS_OS_MAC_OSX) && (!IS_OS_SOLARIS) && (!IS_OS_SUN_OS) && (!IS_OS_FREE_BSD) && (!IS_OS_OPEN_BSD))
      {
        bool1 = bool2;
        if (!IS_OS_NET_BSD) {}
      }
      else
      {
        bool1 = true;
      }
      IS_OS_UNIX = bool1;
      IS_OS_WINDOWS = getOSMatchesName("Windows");
      IS_OS_WINDOWS_2000 = getOSMatches("Windows", "5.0");
      IS_OS_WINDOWS_2003 = getOSMatches("Windows", "5.2");
      IS_OS_WINDOWS_2008 = getOSMatches("Windows Server 2008", "6.1");
      IS_OS_WINDOWS_95 = getOSMatches("Windows 9", "4.0");
      IS_OS_WINDOWS_98 = getOSMatches("Windows 9", "4.1");
      IS_OS_WINDOWS_ME = getOSMatches("Windows", "4.9");
      IS_OS_WINDOWS_NT = getOSMatchesName("Windows NT");
      IS_OS_WINDOWS_XP = getOSMatches("Windows", "5.1");
      IS_OS_WINDOWS_VISTA = getOSMatches("Windows", "6.0");
      IS_OS_WINDOWS_7 = getOSMatches("Windows", "6.1");
      return;
      str = getSystemProperty("user.country");
      break;
    }
  }
  
  public static File getJavaHome()
  {
    return new File(System.getProperty("java.home"));
  }
  
  public static File getJavaIoTmpDir()
  {
    return new File(System.getProperty("java.io.tmpdir"));
  }
  
  private static boolean getJavaVersionMatches(String paramString)
  {
    return isJavaVersionMatch(JAVA_SPECIFICATION_VERSION, paramString);
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
      String str = System.getProperty(paramString);
      return str;
    }
    catch (SecurityException localSecurityException)
    {
      System.err.println("Caught a SecurityException reading the system property '" + paramString + "'; the SystemUtils property value will default to null.");
    }
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
    if (JAVA_AWT_HEADLESS != null) {
      return JAVA_AWT_HEADLESS.equals(Boolean.TRUE.toString());
    }
    return false;
  }
  
  public static boolean isJavaVersionAtLeast(JavaVersion paramJavaVersion)
  {
    return JAVA_SPECIFICATION_VERSION_AS_ENUM.atLeast(paramJavaVersion);
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
    if ((paramString1 == null) || (paramString2 == null)) {}
    while ((!paramString1.startsWith(paramString3)) || (!paramString2.startsWith(paramString4))) {
      return false;
    }
    return true;
  }
  
  static boolean isOSNameMatch(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return false;
    }
    return paramString1.startsWith(paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     external.org.apache.commons.lang3.SystemUtils
 * JD-Core Version:    0.7.0.1
 */