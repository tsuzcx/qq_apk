package kotlin.reflect.jvm.internal.impl.utils;

import org.jetbrains.annotations.NotNull;

public enum ReportLevel
{
  public static final ReportLevel.Companion Companion = new ReportLevel.Companion(null);
  @NotNull
  private final String description;
  
  static
  {
    ReportLevel localReportLevel1 = new ReportLevel("IGNORE", 0, "ignore");
    IGNORE = localReportLevel1;
    ReportLevel localReportLevel2 = new ReportLevel("WARN", 1, "warn");
    WARN = localReportLevel2;
    ReportLevel localReportLevel3 = new ReportLevel("STRICT", 2, "strict");
    STRICT = localReportLevel3;
    $VALUES = new ReportLevel[] { localReportLevel1, localReportLevel2, localReportLevel3 };
  }
  
  private ReportLevel(String paramString)
  {
    this.description = paramString;
  }
  
  @NotNull
  public final String getDescription()
  {
    return this.description;
  }
  
  public final boolean isIgnore()
  {
    return (ReportLevel)this == IGNORE;
  }
  
  public final boolean isWarning()
  {
    return (ReportLevel)this == WARN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.reflect.jvm.internal.impl.utils.ReportLevel
 * JD-Core Version:    0.7.0.1
 */