package shark;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/HprofVersion;", "", "versionString", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getVersionString", "()Ljava/lang/String;", "JDK1_2_BETA3", "JDK1_2_BETA4", "JDK_6", "ANDROID", "shark-hprof"}, k=1, mv={1, 4, 1})
public enum HprofVersion
{
  @NotNull
  private final String versionString;
  
  static
  {
    HprofVersion localHprofVersion1 = new HprofVersion("JDK1_2_BETA3", 0, "JAVA PROFILE 1.0");
    JDK1_2_BETA3 = localHprofVersion1;
    HprofVersion localHprofVersion2 = new HprofVersion("JDK1_2_BETA4", 1, "JAVA PROFILE 1.0.1");
    JDK1_2_BETA4 = localHprofVersion2;
    HprofVersion localHprofVersion3 = new HprofVersion("JDK_6", 2, "JAVA PROFILE 1.0.2");
    JDK_6 = localHprofVersion3;
    HprofVersion localHprofVersion4 = new HprofVersion("ANDROID", 3, "JAVA PROFILE 1.0.3");
    ANDROID = localHprofVersion4;
    $VALUES = new HprofVersion[] { localHprofVersion1, localHprofVersion2, localHprofVersion3, localHprofVersion4 };
  }
  
  private HprofVersion(String paramString)
  {
    this.versionString = paramString;
  }
  
  @NotNull
  public final String getVersionString()
  {
    return this.versionString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.HprofVersion
 * JD-Core Version:    0.7.0.1
 */