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
    catch (Exception localException)
    {
      Util.report("MDC binding unsuccessful.", localException);
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
  }
  
  private static MDCAdapter bwCompatibleGetMDCAdapterFromBinder()
  {
    try
    {
      MDCAdapter localMDCAdapter = StaticMDCBinder.getSingleton().getMDCA();
      return localMDCAdapter;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      label9:
      break label9;
    }
    return StaticMDCBinder.SINGLETON.getMDCA();
  }
  
  public static void clear()
  {
    MDCAdapter localMDCAdapter = mdcAdapter;
    if (localMDCAdapter != null)
    {
      localMDCAdapter.clear();
      return;
    }
    throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
  }
  
  public static String get(String paramString)
  {
    if (paramString != null)
    {
      MDCAdapter localMDCAdapter = mdcAdapter;
      if (localMDCAdapter != null) {
        return localMDCAdapter.get(paramString);
      }
      throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }
    throw new IllegalArgumentException("key parameter cannot be null");
  }
  
  public static Map<String, String> getCopyOfContextMap()
  {
    MDCAdapter localMDCAdapter = mdcAdapter;
    if (localMDCAdapter != null) {
      return localMDCAdapter.getCopyOfContextMap();
    }
    throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
  }
  
  public static MDCAdapter getMDCAdapter()
  {
    return mdcAdapter;
  }
  
  public static void put(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      MDCAdapter localMDCAdapter = mdcAdapter;
      if (localMDCAdapter != null)
      {
        localMDCAdapter.put(paramString1, paramString2);
        return;
      }
      throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }
    throw new IllegalArgumentException("key parameter cannot be null");
  }
  
  public static MDC.MDCCloseable putCloseable(String paramString1, String paramString2)
  {
    put(paramString1, paramString2);
    return new MDC.MDCCloseable(paramString1, null);
  }
  
  public static void remove(String paramString)
  {
    if (paramString != null)
    {
      MDCAdapter localMDCAdapter = mdcAdapter;
      if (localMDCAdapter != null)
      {
        localMDCAdapter.remove(paramString);
        return;
      }
      throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
    }
    throw new IllegalArgumentException("key parameter cannot be null");
  }
  
  public static void setContextMap(Map<String, String> paramMap)
  {
    MDCAdapter localMDCAdapter = mdcAdapter;
    if (localMDCAdapter != null)
    {
      localMDCAdapter.setContextMap(paramMap);
      return;
    }
    throw new IllegalStateException("MDCAdapter cannot be null. See also http://www.slf4j.org/codes.html#null_MDCA");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     org.slf4j.MDC
 * JD-Core Version:    0.7.0.1
 */