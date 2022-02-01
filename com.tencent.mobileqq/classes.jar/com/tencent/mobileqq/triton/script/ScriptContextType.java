package com.tencent.mobileqq.triton.script;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "", "(Ljava/lang/String;I)V", "MAIN", "OPEN_DATA", "WORKER", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public enum ScriptContextType
{
  static
  {
    ScriptContextType localScriptContextType1 = new ScriptContextType("MAIN", 0);
    MAIN = localScriptContextType1;
    ScriptContextType localScriptContextType2 = new ScriptContextType("OPEN_DATA", 1);
    OPEN_DATA = localScriptContextType2;
    ScriptContextType localScriptContextType3 = new ScriptContextType("WORKER", 2);
    WORKER = localScriptContextType3;
    $VALUES = new ScriptContextType[] { localScriptContextType1, localScriptContextType2, localScriptContextType3 };
  }
  
  private ScriptContextType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.script.ScriptContextType
 * JD-Core Version:    0.7.0.1
 */