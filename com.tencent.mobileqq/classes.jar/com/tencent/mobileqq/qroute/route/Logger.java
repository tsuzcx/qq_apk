package com.tencent.mobileqq.qroute.route;

class Logger
{
  public static final String TAG = "UIRoute";
  static ILogger logger = null;
  
  public static void debug(String paramString)
  {
    if (logger != null) {
      logger.info("UIRoute", paramString);
    }
  }
  
  public static void info(String paramString)
  {
    if (logger != null) {
      logger.info("UIRoute", paramString);
    }
  }
  
  public static void warning(String paramString)
  {
    if (logger != null) {
      logger.warning("UIRoute", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.route.Logger
 * JD-Core Version:    0.7.0.1
 */