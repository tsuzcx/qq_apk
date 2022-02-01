package com.tencent.mobileqq.cmshow.engine.script.task;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/script/task/ScriptTaskType;", "", "(Ljava/lang/String;I)V", "COMMON_INIT", "INIT_SPRITE", "PLAY_ACTION", "BACKGROUND_INIT", "BACKGROUND_PLAY_ACTION", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public enum ScriptTaskType
{
  static
  {
    ScriptTaskType localScriptTaskType1 = new ScriptTaskType("COMMON_INIT", 0);
    COMMON_INIT = localScriptTaskType1;
    ScriptTaskType localScriptTaskType2 = new ScriptTaskType("INIT_SPRITE", 1);
    INIT_SPRITE = localScriptTaskType2;
    ScriptTaskType localScriptTaskType3 = new ScriptTaskType("PLAY_ACTION", 2);
    PLAY_ACTION = localScriptTaskType3;
    ScriptTaskType localScriptTaskType4 = new ScriptTaskType("BACKGROUND_INIT", 3);
    BACKGROUND_INIT = localScriptTaskType4;
    ScriptTaskType localScriptTaskType5 = new ScriptTaskType("BACKGROUND_PLAY_ACTION", 4);
    BACKGROUND_PLAY_ACTION = localScriptTaskType5;
    $VALUES = new ScriptTaskType[] { localScriptTaskType1, localScriptTaskType2, localScriptTaskType3, localScriptTaskType4, localScriptTaskType5 };
  }
  
  private ScriptTaskType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.task.ScriptTaskType
 * JD-Core Version:    0.7.0.1
 */