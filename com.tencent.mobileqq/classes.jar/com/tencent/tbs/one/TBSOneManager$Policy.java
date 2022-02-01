package com.tencent.tbs.one;

public enum TBSOneManager$Policy
{
  static
  {
    BUILTIN_FIRST = new Policy("BUILTIN_FIRST", 2);
    LOCAL_ONLY = new Policy("LOCAL_ONLY", 3);
  }
  
  private TBSOneManager$Policy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.TBSOneManager.Policy
 * JD-Core Version:    0.7.0.1
 */