package shark;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;

@Deprecated(message="Moved to top level class", replaceWith=@ReplaceWith(expression="shark.HprofVersion", imports={}))
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/Hprof$HprofVersion;", "", "(Ljava/lang/String;I)V", "versionString", "", "getVersionString", "()Ljava/lang/String;", "JDK1_2_BETA3", "JDK1_2_BETA4", "JDK_6", "ANDROID", "shark-hprof"}, k=1, mv={1, 4, 1})
public enum Hprof$HprofVersion
{
  static
  {
    HprofVersion localHprofVersion1 = new HprofVersion("JDK1_2_BETA3", 0);
    JDK1_2_BETA3 = localHprofVersion1;
    HprofVersion localHprofVersion2 = new HprofVersion("JDK1_2_BETA4", 1);
    JDK1_2_BETA4 = localHprofVersion2;
    HprofVersion localHprofVersion3 = new HprofVersion("JDK_6", 2);
    JDK_6 = localHprofVersion3;
    HprofVersion localHprofVersion4 = new HprofVersion("ANDROID", 3);
    ANDROID = localHprofVersion4;
    $VALUES = new HprofVersion[] { localHprofVersion1, localHprofVersion2, localHprofVersion3, localHprofVersion4 };
  }
  
  private Hprof$HprofVersion() {}
  
  @NotNull
  public final String getVersionString()
  {
    return HprofVersion.valueOf(name()).getVersionString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.Hprof.HprofVersion
 * JD-Core Version:    0.7.0.1
 */