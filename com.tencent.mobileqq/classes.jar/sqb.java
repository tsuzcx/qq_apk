import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/VideoResumeManager;", "", "()V", "TAG", "", "config", "Lcom/tencent/aladdin/config/AladdinConfig;", "kotlin.jvm.PlatformType", "enable", "", "getEnable", "()Z", "map", "", "", "cacheVideoStatus", "", "key", "position", "rowKey", "vid", "duration", "getPlayPosition", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class sqb
{
  private static final AladdinConfig jdField_a_of_type_ComTencentAladdinConfigAladdinConfig = Aladdin.getConfig(391);
  private static final Map<String, Long> jdField_a_of_type_JavaUtilMap;
  public static final sqb a;
  
  static
  {
    jdField_a_of_type_Sqb = new sqb();
    jdField_a_of_type_JavaUtilMap = (Map)new LinkedHashMap();
  }
  
  public final long a(@Nullable String paramString1, @Nullable String paramString2)
  {
    if (a())
    {
      Object localObject = paramString1 + "_" + paramString2;
      localObject = (Long)jdField_a_of_type_JavaUtilMap.get(localObject);
      if (localObject != null) {}
      for (long l1 = ((Long)localObject).longValue();; l1 = 0L)
      {
        long l2 = l1;
        if (l1 < 1500) {
          l2 = 0L;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoResumeManager", 2, "getPlayPosition: rowKey=" + paramString1 + ", vid=" + paramString2 + ", result=" + l2);
        }
        return l2;
      }
    }
    return 0L;
  }
  
  public final void a(@NotNull String paramString, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoResumeManager", 2, "cacheVideoStatus: key=" + paramString + ", position=" + paramLong);
      }
      jdField_a_of_type_JavaUtilMap.put(paramString, Long.valueOf(paramLong));
    }
  }
  
  public final void a(@Nullable String paramString1, @Nullable String paramString2, long paramLong1, long paramLong2)
  {
    if (a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoResumeManager", 2, "cacheVideoStatus: rowKey=" + paramString1 + ", vid=" + paramString2 + ", position=" + paramLong1 + ", duration=" + paramLong2);
      }
      paramString1 = paramString1 + "_" + paramString2;
      paramString2 = jdField_a_of_type_JavaUtilMap;
      if (paramLong2 - paramLong1 <= 1500) {
        break label119;
      }
    }
    for (;;)
    {
      paramString2.put(paramString1, Long.valueOf(paramLong1));
      return;
      label119:
      paramLong1 = 0L;
    }
  }
  
  public final boolean a()
  {
    return jdField_a_of_type_ComTencentAladdinConfigAladdinConfig.getIntegerFromString("resume_enable", 0) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sqb
 * JD-Core Version:    0.7.0.1
 */