package kotlin.script.dependencies;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/script/dependencies/ScriptDependenciesResolver$ReportSeverity;", "", "(Ljava/lang/String;I)V", "FATAL", "ERROR", "WARNING", "INFO", "DEBUG", "kotlin-script-runtime"}, k=1, mv={1, 1, 16})
public enum ScriptDependenciesResolver$ReportSeverity
{
  static
  {
    ReportSeverity localReportSeverity1 = new ReportSeverity("FATAL", 0);
    FATAL = localReportSeverity1;
    ReportSeverity localReportSeverity2 = new ReportSeverity("ERROR", 1);
    ERROR = localReportSeverity2;
    ReportSeverity localReportSeverity3 = new ReportSeverity("WARNING", 2);
    WARNING = localReportSeverity3;
    ReportSeverity localReportSeverity4 = new ReportSeverity("INFO", 3);
    INFO = localReportSeverity4;
    ReportSeverity localReportSeverity5 = new ReportSeverity("DEBUG", 4);
    DEBUG = localReportSeverity5;
    $VALUES = new ReportSeverity[] { localReportSeverity1, localReportSeverity2, localReportSeverity3, localReportSeverity4, localReportSeverity5 };
  }
  
  private ScriptDependenciesResolver$ReportSeverity() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.dependencies.ScriptDependenciesResolver.ReportSeverity
 * JD-Core Version:    0.7.0.1
 */