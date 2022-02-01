package org.xwalk.core;

public class XWalkPreferences
{
  public static final String ALLOW_UNIVERSAL_ACCESS_FROM_FILE = "allow-universal-access-from-file";
  public static final String ANIMATABLE_XWALK_VIEW = "animatable-xwalk-view";
  public static final String ENABLE_EXTENSIONS = "enable-extensions";
  public static final String ENABLE_JAVASCRIPT = "enable-javascript";
  public static final String ENABLE_THEME_COLOR = "enable-theme-color";
  public static final String JAVASCRIPT_CAN_OPEN_WINDOW = "javascript-can-open-window";
  public static final String PROFILE_NAME = "profile-name";
  public static final String REMOTE_DEBUGGING = "remote-debugging";
  public static final String SPATIAL_NAVIGATION = "enable-spatial-navigation";
  public static final String SUPPORT_MULTIPLE_WINDOWS = "support-multiple-windows";
  public static final String XWEBSDK_VERSION = "xwebsdk-version";
  public static final String XWEB_VERSION = "xweb-version";
  private static XWalkCoreWrapper coreWrapper;
  private static ReflectMethod getBooleanValueStringMethod = new ReflectMethod(null, "getBooleanValue", new Class[0]);
  private static ReflectMethod getIntegerValueStringMethod = new ReflectMethod(null, "getIntegerValue", new Class[0]);
  private static ReflectMethod getStringValueStringMethod = new ReflectMethod(null, "getStringValue", new Class[0]);
  private static ReflectMethod getValueStringMethod;
  private static ReflectMethod setValueStringStringMethod;
  private static ReflectMethod setValueStringbooleanMethod = new ReflectMethod(null, "setValue", new Class[0]);
  private static ReflectMethod setValueStringintMethod = new ReflectMethod(null, "setValue", new Class[0]);
  
  static
  {
    setValueStringStringMethod = new ReflectMethod(null, "setValue", new Class[0]);
    getValueStringMethod = new ReflectMethod(null, "getValue", new Class[0]);
  }
  
  public static boolean getBooleanValue(String paramString)
  {
    
    try
    {
      boolean bool = ((Boolean)getBooleanValueStringMethod.invoke(new Object[] { paramString })).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramString);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public static int getIntegerValue(String paramString)
  {
    
    try
    {
      int i = ((Integer)getIntegerValueStringMethod.invoke(new Object[] { paramString })).intValue();
      return i;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramString);
        return 0;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public static String getStringValue(String paramString)
  {
    
    try
    {
      paramString = (String)getStringValueStringMethod.invoke(new Object[] { paramString });
      return paramString;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramString);
        return null;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  public static boolean getValue(String paramString)
  {
    
    try
    {
      boolean bool = ((Boolean)getValueStringMethod.invoke(new Object[] { paramString })).booleanValue();
      return bool;
    }
    catch (UnsupportedOperationException paramString)
    {
      if (coreWrapper != null)
      {
        XWalkCoreWrapper.handleRuntimeError(paramString);
        return false;
      }
      throw new RuntimeException("Crosswalk's APIs are not ready yet");
    }
  }
  
  static void reflectionInit()
  {
    if (coreWrapper != null) {
      return;
    }
    XWalkCoreWrapper.initEmbeddedMode();
    coreWrapper = XWalkCoreWrapper.getInstance();
    Object localObject = coreWrapper;
    if (localObject == null)
    {
      XWalkCoreWrapper.reserveReflectClass(XWalkPreferences.class);
      return;
    }
    localObject = ((XWalkCoreWrapper)localObject).getBridgeClass("XWalkPreferencesBridge");
    setValueStringbooleanMethod.init(null, (Class)localObject, "setValue", new Class[] { String.class, Boolean.TYPE });
    setValueStringintMethod.init(null, (Class)localObject, "setValue", new Class[] { String.class, Integer.TYPE });
    setValueStringStringMethod.init(null, (Class)localObject, "setValue", new Class[] { String.class, String.class });
    getValueStringMethod.init(null, (Class)localObject, "getValue", new Class[] { String.class });
    getBooleanValueStringMethod.init(null, (Class)localObject, "getBooleanValue", new Class[] { String.class });
    getIntegerValueStringMethod.init(null, (Class)localObject, "getIntegerValue", new Class[] { String.class });
    getStringValueStringMethod.init(null, (Class)localObject, "getStringValue", new Class[] { String.class });
  }
  
  public static void setValue(String paramString, int paramInt)
  {
    
    try
    {
      setValueStringintMethod.invoke(new Object[] { paramString, Integer.valueOf(paramInt) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (coreWrapper == null)
      {
        setValueStringintMethod.setArguments(new Object[] { paramString, Integer.valueOf(paramInt) });
        XWalkCoreWrapper.reserveReflectMethod(setValueStringintMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public static void setValue(String paramString1, String paramString2)
  {
    
    try
    {
      setValueStringStringMethod.invoke(new Object[] { paramString1, paramString2 });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (coreWrapper == null)
      {
        setValueStringStringMethod.setArguments(new Object[] { paramString1, paramString2 });
        XWalkCoreWrapper.reserveReflectMethod(setValueStringStringMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
  
  public static void setValue(String paramString, boolean paramBoolean)
  {
    
    try
    {
      setValueStringbooleanMethod.invoke(new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      return;
    }
    catch (UnsupportedOperationException localUnsupportedOperationException)
    {
      if (coreWrapper == null)
      {
        setValueStringbooleanMethod.setArguments(new Object[] { paramString, Boolean.valueOf(paramBoolean) });
        XWalkCoreWrapper.reserveReflectMethod(setValueStringbooleanMethod);
        return;
      }
      XWalkCoreWrapper.handleRuntimeError(localUnsupportedOperationException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkPreferences
 * JD-Core Version:    0.7.0.1
 */