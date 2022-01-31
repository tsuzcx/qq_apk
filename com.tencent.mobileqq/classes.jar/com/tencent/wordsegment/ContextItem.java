package com.tencent.wordsegment;

import java.util.ArrayList;

public class ContextItem
{
  public int contextId;
  public String contextName;
  public boolean ignoreOldMeta;
  public int matchPosition;
  public int matchType;
  public ArrayList<SemanticItem> semantic = new ArrayList();
  public int toUser;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.wordsegment.ContextItem
 * JD-Core Version:    0.7.0.1
 */