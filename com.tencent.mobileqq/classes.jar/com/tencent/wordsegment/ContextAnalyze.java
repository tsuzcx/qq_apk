package com.tencent.wordsegment;

import java.util.ArrayList;

public class ContextAnalyze
{
  public static final native boolean clear(String paramString);
  
  public static final native String descParser(String paramString, ArrayList<SemanticItem> paramArrayList);
  
  public static final native boolean parse(String paramString1, long paramLong, boolean paramBoolean1, boolean paramBoolean2, String paramString2, ArrayList<ContextItem> paramArrayList1, ArrayList<ContextItem> paramArrayList2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.wordsegment.ContextAnalyze
 * JD-Core Version:    0.7.0.1
 */