import android.text.TextUtils;
import com.tencent.av.core.VcControllerImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class lll
{
  private final VcControllerImpl jdField_a_of_type_ComTencentAvCoreVcControllerImpl;
  private final HashMap<Long, HashMap<String, Object>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public lll(VcControllerImpl paramVcControllerImpl)
  {
    this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl = paramVcControllerImpl;
  }
  
  private int a(long paramLong, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    boolean bool3 = true;
    Object localObject;
    int i;
    boolean bool1;
    if (a(paramBoolean1, paramBoolean2, false))
    {
      localObject = a(paramLong, paramString);
      if ((localObject instanceof Integer))
      {
        i = ((Integer)localObject).intValue();
        if (i != paramInt) {
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      boolean bool2 = bool1;
      int j = i;
      if (b(paramBoolean1, paramBoolean2, bool1))
      {
        localObject = this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.getAVSDKInfo(paramLong, paramString);
        bool2 = bool1;
        j = i;
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
      }
      for (;;)
      {
        try
        {
          j = Integer.parseInt((String)localObject);
          i = j;
          a(paramLong, paramString, Integer.valueOf(j));
          if (j == paramInt) {
            continue;
          }
          bool1 = bool3;
          bool2 = bool1;
        }
        catch (Throwable localThrowable)
        {
          bool2 = bool1;
          j = i;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.i("JniSimpleInfoMng", 2, "getIntegerValue, [peerUin: " + paramLong + ", onlyFromCache: " + paramBoolean1 + ", onlyFromAVSDK: " + paramBoolean2 + ", ret: " + bool2 + ", key: " + paramString + ", value: " + j + ", default: " + paramInt + "]");
        }
        return j;
        bool1 = false;
        break;
        bool1 = false;
      }
      bool1 = false;
      i = paramInt;
    }
  }
  
  public static long a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0";
    }
    paramString = str;
    if (str.startsWith("+")) {
      paramString = str.substring(1);
    }
    try
    {
      long l = mry.a(paramString);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      QLog.i("JniSimpleInfoMng", 1, "parseUin", paramString);
      return -1L;
    }
    catch (Throwable paramString)
    {
      QLog.i("JniSimpleInfoMng", 1, "parseUin", paramString);
    }
    return -1L;
  }
  
  private HashMap<String, Object> a(long paramLong)
  {
    Object localObject = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    if (localObject == null) {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        HashMap localHashMap1 = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
        localObject = localHashMap1;
        if (localHashMap1 == null)
        {
          localObject = new HashMap();
          this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(paramLong), localObject);
        }
        return localObject;
      }
    }
    return localHashMap;
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return (paramBoolean1) || ((!paramBoolean2) && (!paramBoolean3));
  }
  
  private boolean b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return (paramBoolean2) || ((!paramBoolean1) && (!paramBoolean3));
  }
  
  public int a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(paramLong, "WatchTogetherFlag", paramBoolean1, paramBoolean2, -1);
  }
  
  public int a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(a(paramString), "PeerTerminalType", paramBoolean1, paramBoolean2, 0);
  }
  
  public Object a(long paramLong, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return a(paramLong).get(paramString);
  }
  
  public void a(long paramLong)
  {
    HashMap localHashMap = a(paramLong);
    if (localHashMap != null) {
      localHashMap.clear();
    }
    if (QLog.isColorLevel()) {
      QLog.i("JniSimpleInfoMng", 2, "clearInfoForClose, peerUin[" + paramLong + "]");
    }
  }
  
  public void a(long paramLong, String paramString, Object paramObject)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    a(paramLong).put(paramString, paramObject);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    long l = a(paramString);
    a(l, "WatchTogetherFlag", Integer.valueOf(paramInt));
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentAvCoreVcControllerImpl.setAVSDKInfo(l, "WatchTogetherFlag", String.valueOf(paramInt));
    }
    if (QLog.isColorLevel()) {
      QLog.i("JniSimpleInfoMng", 2, "setWatchTogetherFlag, peerUin[" + paramString + "], flag[" + paramInt + "], toAVSDK[" + paramBoolean + "]");
    }
  }
  
  public int b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return a(a(paramString), "PeerSdkVersion", paramBoolean1, paramBoolean2, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lll
 * JD-Core Version:    0.7.0.1
 */