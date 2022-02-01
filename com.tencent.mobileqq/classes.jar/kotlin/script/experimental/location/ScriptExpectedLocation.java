package kotlin.script.experimental.location;

import kotlin.Deprecated;
import kotlin.Metadata;

@Deprecated(message="Experimental API")
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/script/experimental/location/ScriptExpectedLocation;", "", "(Ljava/lang/String;I)V", "SourcesOnly", "TestsOnly", "Libraries", "Project", "Everywhere", "kotlin-script-runtime"}, k=1, mv={1, 1, 16})
public enum ScriptExpectedLocation
{
  static
  {
    ScriptExpectedLocation localScriptExpectedLocation1 = new ScriptExpectedLocation("SourcesOnly", 0);
    SourcesOnly = localScriptExpectedLocation1;
    ScriptExpectedLocation localScriptExpectedLocation2 = new ScriptExpectedLocation("TestsOnly", 1);
    TestsOnly = localScriptExpectedLocation2;
    ScriptExpectedLocation localScriptExpectedLocation3 = new ScriptExpectedLocation("Libraries", 2);
    Libraries = localScriptExpectedLocation3;
    ScriptExpectedLocation localScriptExpectedLocation4 = new ScriptExpectedLocation("Project", 3);
    Project = localScriptExpectedLocation4;
    ScriptExpectedLocation localScriptExpectedLocation5 = new ScriptExpectedLocation("Everywhere", 4);
    Everywhere = localScriptExpectedLocation5;
    $VALUES = new ScriptExpectedLocation[] { localScriptExpectedLocation1, localScriptExpectedLocation2, localScriptExpectedLocation3, localScriptExpectedLocation4, localScriptExpectedLocation5 };
  }
  
  private ScriptExpectedLocation() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     kotlin.script.experimental.location.ScriptExpectedLocation
 * JD-Core Version:    0.7.0.1
 */