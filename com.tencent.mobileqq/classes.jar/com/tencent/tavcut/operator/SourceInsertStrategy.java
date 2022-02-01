package com.tencent.tavcut.operator;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/operator/SourceInsertStrategy;", "", "(Ljava/lang/String;I)V", "AFTER_CURRENT_SOURCE", "BEFORE_CURRENT_SOURCE", "SOURCES_START", "SOURCES_END", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public enum SourceInsertStrategy
{
  static
  {
    SourceInsertStrategy localSourceInsertStrategy1 = new SourceInsertStrategy("AFTER_CURRENT_SOURCE", 0);
    AFTER_CURRENT_SOURCE = localSourceInsertStrategy1;
    SourceInsertStrategy localSourceInsertStrategy2 = new SourceInsertStrategy("BEFORE_CURRENT_SOURCE", 1);
    BEFORE_CURRENT_SOURCE = localSourceInsertStrategy2;
    SourceInsertStrategy localSourceInsertStrategy3 = new SourceInsertStrategy("SOURCES_START", 2);
    SOURCES_START = localSourceInsertStrategy3;
    SourceInsertStrategy localSourceInsertStrategy4 = new SourceInsertStrategy("SOURCES_END", 3);
    SOURCES_END = localSourceInsertStrategy4;
    $VALUES = new SourceInsertStrategy[] { localSourceInsertStrategy1, localSourceInsertStrategy2, localSourceInsertStrategy3, localSourceInsertStrategy4 };
  }
  
  private SourceInsertStrategy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.operator.SourceInsertStrategy
 * JD-Core Version:    0.7.0.1
 */