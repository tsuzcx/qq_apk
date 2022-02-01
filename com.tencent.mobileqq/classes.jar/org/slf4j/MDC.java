package org.slf4j;

import java.util.Map;
import org.slf4j.helpers.NOPMDCAdapter;
import org.slf4j.helpers.Util;
import org.slf4j.impl.StaticMDCBinder;
import org.slf4j.spi.MDCAdapter;

public class MDC
{
  static final String NO_STATIC_MDC_BINDER_URL = "http://www.slf4j.org/codes.html#no_static_mdc_binder";
  static final String NULL_MDCA_URL = "http://www.slf4j.org/codes.html#null_MDCA";
  static MDCAdapter mdcAdapter;
  
  static
  {
    try
    {
      mdcAdapter = bwCompatibleGetMDCAdapterFromBinder();
      return;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      mdcAdapter = new NOPMDCAdapter();
      String str = localNoClassDefFoundError.getMessage();
      if ((str != null) && (str.contains("StaticMDCBinder")))
      {
        Util.report("Failed to load class \"org.slf4j.impl.StaticMDCBinder\".");
        Util.report("Defaulting to no-operation MDCAdapter implementation.");
        Util.report("See http://www.slf4j.org/codes.html#no_static_mdc_binder for further details.");
        return;
      }
      throw localNoClassDefFoundError;
    }
    catch (Exception localException)
    {
      Util.report("MDC binding unsuccessful.", localException);
    }
  }
  
  private static MDCAdapter bwCompatibleGetMDCAdapterFromBinder()
  {
    try
    {
      MDCAdapter localMDCAdapter = StaticMDCBinder.getSingleton().getMDCA();
      return localMDCAdapter;
    }
    catch (NoSuchMethodError localNoSuchMethodError) {}
    return StaticMDCBinder.SINGLETON.getMDCA();
  }
  
  public static void clear()
  {
    if (mdcAdapter == null) {
      throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }
    mdcAdapter.clear();
  }
  
  public static String get(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("key parameter cannot be null");
    }
    if (mdcAdapter == null) {
      throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }
    return mdcAdapter.get(paramString);
  }
  
  public static Map<String, String> getCopyOfContextMap()
  {
    if (mdcAdapter == null) {
      throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }
    return mdcAdapter.getCopyOfContextMap();
  }
  
  public static MDCAdapter getMDCAdapter()
  {
    return mdcAdapter;
  }
  
  public static void put(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("key parameter cannot be null");
    }
    if (mdcAdapter == null) {
      throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }
    mdcAdapter.put(paramString1, paramString2);
  }
  
  public static MDC.MDCCloseable putCloseable(String paramString1, String paramString2)
  {
    put(paramString1, paramString2);
    return new MDC.MDCCloseable(paramString1, null);
  }
  
  public static void remove(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("key parameter cannot be null");
    }
    if (mdcAdapter == null) {
      throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }
    mdcAdapter.remove(paramString);
  }
  
  public static void setContextMap(Map<String, String> paramMap)
  {
    if (mdcAdapter == null) {
      throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }
    mdcAdapter.setContextMap(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.slf4j.MDC
 * JD-Core Version:    0.7.0.1
 */