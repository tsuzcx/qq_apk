package kotlin.script.experimental.dependencies;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/script/experimental/dependencies/ScriptReport$Severity;", "", "(Ljava/lang/String;I)V", "FATAL", "ERROR", "WARNING", "INFO", "DEBUG", "kotlin-script-runtime"}, k=1, mv={1, 1, 16})
public enum ScriptReport$Severity
{
  static
  {
    Severity localSeverity1 = new Severity("FATAL", 0);
    FATAL = localSeverity1;
    Severity localSeverity2 = new Severity("ERROR", 1);
    ERROR = localSeverity2;
    Severity localSeverity3 = new Severity("WARNING", 2);
    WARNING = localSeverity3;
    Severity localSeverity4 = new Severity("INFO", 3);
    INFO = localSeverity4;
    Severity localSeverity5 = new Severity("DEBUG", 4);
    DEBUG = localSeverity5;
    $VALUES = new Severity[] { localSeverity1, localSeverity2, localSeverity3, localSeverity4, localSeverity5 };
  }
  
  private ScriptReport$Severity() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.experimental.dependencies.ScriptReport.Severity
 * JD-Core Version:    0.7.0.1
 */