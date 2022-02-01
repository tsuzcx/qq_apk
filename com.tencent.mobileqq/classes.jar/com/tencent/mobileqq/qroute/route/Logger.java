package com.tencent.mobileqq.qroute.route;

class Logger
{
  public static final String TAG = "UIRoute";
  static ILogger logger;
  
  public static void debug(String paramString)
  {
    ILogger localILogger = logger;
    if (localILogger != null) {
      localILogger.info("UIRoute", paramString);
    }
  }
  
  public static void info(String paramString)
  {
    ILogger localILogger = logger;
    if (localILogger != null) {
      localILogger.info("UIRoute", paramString);
    }
  }
  
  public static void warning(String paramString)
  {
    ILogger localILogger = logger;
    if (localILogger != null) {
      localILogger.warning("UIRoute", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.Logger
 * JD-Core Version:    0.7.0.1
 */