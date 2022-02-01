package com.tencent.ttpic.openapi.ttpicmodule;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class AEGlobalBoard
{
  private static final String FAIL = "失败";
  public static boolean PTGlobalBoard_Enable = true;
  private static final String SUCCESS = "成功";
  private static Map<String, String> boardRecords = new Hashtable();
  
  public static String getBoard()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Object localObject1 = AEGlobalBoard.PTStatus.values();
    int j = localObject1.length;
    int i = 0;
    Object localObject2;
    while (i < j)
    {
      localObject2 = localObject1[i];
      localStringBuffer.append(AEGlobalBoard.PTStatus.access$100((AEGlobalBoard.PTStatus)localObject2) + " : " + AEGlobalBoard.PTStatus.access$000((AEGlobalBoard.PTStatus)localObject2) + "\n");
      i += 1;
    }
    localObject1 = boardRecords.entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      localStringBuffer.append((String)((Map.Entry)localObject2).getKey() + " : " + (String)((Map.Entry)localObject2).getValue() + "\n");
    }
    return localStringBuffer.toString();
  }
  
  public static void writeBoard(AEGlobalBoard.PTStatus paramPTStatus, int paramInt)
  {
    if (PTGlobalBoard_Enable)
    {
      if (paramInt == 0) {
        AEGlobalBoard.PTStatus.access$002(paramPTStatus, "成功");
      }
    }
    else {
      return;
    }
    AEGlobalBoard.PTStatus.access$002(paramPTStatus, "失败");
  }
  
  public static void writeBoard(AEGlobalBoard.PTStatus paramPTStatus, String paramString)
  {
    if (PTGlobalBoard_Enable) {
      AEGlobalBoard.PTStatus.access$002(paramPTStatus, paramString);
    }
  }
  
  public static void writeBoard(String paramString1, String paramString2)
  {
    if (PTGlobalBoard_Enable) {
      boardRecords.put(paramString1, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.ttpicmodule.AEGlobalBoard
 * JD-Core Version:    0.7.0.1
 */