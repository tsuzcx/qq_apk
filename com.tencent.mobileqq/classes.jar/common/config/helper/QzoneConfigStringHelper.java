package common.config.helper;

import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

public class QzoneConfigStringHelper
{
  private static final char[] LOWER_CASE = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 32, 0, 0, 35, 0, 0, 0, 0, 0, 0, 0, 0, 0, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 0, 0, 0, 0, 0, 63, 0, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 0, 0, 0, 0, 95, 0, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 0, 125, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  private static final String PROCESS_QZONE = "com.tencent.mobileqq:qzone";
  private static final String TAG = "QzoneConfigStringHelper";
  private volatile boolean mCanHandle = false;
  private ConcurrentHashMap<String, String> mLowerCaseMap;
  
  public QzoneConfigStringHelper()
  {
    if ("com.tencent.mobileqq:qzone".equals(getProcessName()))
    {
      this.mLowerCaseMap = new ConcurrentHashMap(1024);
      this.mCanHandle = true;
    }
  }
  
  private String getProcessName()
  {
    if (MobileQQ.sMobileQQ != null) {
      return MobileQQ.sMobileQQ.getQQProcessName();
    }
    return null;
  }
  
  private String toLowerCaseByTable(String paramString)
  {
    int k = 0;
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject = paramString.toCharArray();
        i = 0;
        int j = k;
        if (i < localObject.length)
        {
          localObject[i] = LOWER_CASE[localObject[i]];
          if (localObject[i] == 0) {
            j = 1;
          }
        }
        else
        {
          if (j != 0) {
            return paramString.toLowerCase();
          }
          localObject = new String((char[])localObject);
          return localObject;
        }
      }
      catch (Exception localException)
      {
        return paramString.toLowerCase();
      }
      i += 1;
    }
  }
  
  public boolean canHandle()
  {
    return this.mCanHandle;
  }
  
  public String toLowerCase(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (paramString == null) {
      localObject1 = localObject2;
    }
    do
    {
      do
      {
        return localObject1;
        localObject2 = localObject1;
        if (this.mLowerCaseMap != null)
        {
          localObject2 = localObject1;
          if (this.mLowerCaseMap.containsKey(paramString)) {
            localObject2 = (String)this.mLowerCaseMap.get(paramString);
          }
        }
        localObject1 = localObject2;
      } while (localObject2 != null);
      localObject2 = toLowerCaseByTable(paramString);
      localObject1 = localObject2;
    } while (this.mLowerCaseMap == null);
    this.mLowerCaseMap.put(paramString, localObject2);
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     common.config.helper.QzoneConfigStringHelper
 * JD-Core Version:    0.7.0.1
 */