package com.tencent.mobileqq.triton.statistic;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/statistic/ScriptLoadResult;", "", "isSuccess", "", "(Ljava/lang/String;IZ)V", "()Z", "FAIL_INVALID_STATE", "FAIL_EXECUTE", "FAIL_COMPILE", "FAIL_READ_SCRIPT", "SUCCESS_WITH_CACHE", "SUCCESS_WITHOUT_CACHE", "SUCCESS_BUT_CACHE_REJECTED", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public enum ScriptLoadResult
{
  private final boolean isSuccess;
  
  static
  {
    ScriptLoadResult localScriptLoadResult1 = new ScriptLoadResult("FAIL_INVALID_STATE", 0, false);
    FAIL_INVALID_STATE = localScriptLoadResult1;
    ScriptLoadResult localScriptLoadResult2 = new ScriptLoadResult("FAIL_EXECUTE", 1, false);
    FAIL_EXECUTE = localScriptLoadResult2;
    ScriptLoadResult localScriptLoadResult3 = new ScriptLoadResult("FAIL_COMPILE", 2, false);
    FAIL_COMPILE = localScriptLoadResult3;
    ScriptLoadResult localScriptLoadResult4 = new ScriptLoadResult("FAIL_READ_SCRIPT", 3, false);
    FAIL_READ_SCRIPT = localScriptLoadResult4;
    ScriptLoadResult localScriptLoadResult5 = new ScriptLoadResult("SUCCESS_WITH_CACHE", 4, true);
    SUCCESS_WITH_CACHE = localScriptLoadResult5;
    ScriptLoadResult localScriptLoadResult6 = new ScriptLoadResult("SUCCESS_WITHOUT_CACHE", 5, true);
    SUCCESS_WITHOUT_CACHE = localScriptLoadResult6;
    ScriptLoadResult localScriptLoadResult7 = new ScriptLoadResult("SUCCESS_BUT_CACHE_REJECTED", 6, true);
    SUCCESS_BUT_CACHE_REJECTED = localScriptLoadResult7;
    $VALUES = new ScriptLoadResult[] { localScriptLoadResult1, localScriptLoadResult2, localScriptLoadResult3, localScriptLoadResult4, localScriptLoadResult5, localScriptLoadResult6, localScriptLoadResult7 };
  }
  
  private ScriptLoadResult(boolean paramBoolean)
  {
    this.isSuccess = paramBoolean;
  }
  
  public final boolean isSuccess()
  {
    return this.isSuccess;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.statistic.ScriptLoadResult
 * JD-Core Version:    0.7.0.1
 */