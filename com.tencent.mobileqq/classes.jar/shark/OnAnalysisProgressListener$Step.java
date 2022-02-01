package shark;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lshark/OnAnalysisProgressListener$Step;", "", "(Ljava/lang/String;I)V", "PARSING_HEAP_DUMP", "EXTRACTING_METADATA", "FINDING_RETAINED_OBJECTS", "FINDING_PATHS_TO_RETAINED_OBJECTS", "FINDING_DOMINATORS", "INSPECTING_OBJECTS", "COMPUTING_NATIVE_RETAINED_SIZE", "COMPUTING_RETAINED_SIZE", "BUILDING_LEAK_TRACES", "REPORTING_HEAP_ANALYSIS", "shark"}, k=1, mv={1, 4, 1})
public enum OnAnalysisProgressListener$Step
{
  static
  {
    Step localStep1 = new Step("PARSING_HEAP_DUMP", 0);
    PARSING_HEAP_DUMP = localStep1;
    Step localStep2 = new Step("EXTRACTING_METADATA", 1);
    EXTRACTING_METADATA = localStep2;
    Step localStep3 = new Step("FINDING_RETAINED_OBJECTS", 2);
    FINDING_RETAINED_OBJECTS = localStep3;
    Step localStep4 = new Step("FINDING_PATHS_TO_RETAINED_OBJECTS", 3);
    FINDING_PATHS_TO_RETAINED_OBJECTS = localStep4;
    Step localStep5 = new Step("FINDING_DOMINATORS", 4);
    FINDING_DOMINATORS = localStep5;
    Step localStep6 = new Step("INSPECTING_OBJECTS", 5);
    INSPECTING_OBJECTS = localStep6;
    Step localStep7 = new Step("COMPUTING_NATIVE_RETAINED_SIZE", 6);
    COMPUTING_NATIVE_RETAINED_SIZE = localStep7;
    Step localStep8 = new Step("COMPUTING_RETAINED_SIZE", 7);
    COMPUTING_RETAINED_SIZE = localStep8;
    Step localStep9 = new Step("BUILDING_LEAK_TRACES", 8);
    BUILDING_LEAK_TRACES = localStep9;
    Step localStep10 = new Step("REPORTING_HEAP_ANALYSIS", 9);
    REPORTING_HEAP_ANALYSIS = localStep10;
    $VALUES = new Step[] { localStep1, localStep2, localStep3, localStep4, localStep5, localStep6, localStep7, localStep8, localStep9, localStep10 };
  }
  
  private OnAnalysisProgressListener$Step() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     shark.OnAnalysisProgressListener.Step
 * JD-Core Version:    0.7.0.1
 */