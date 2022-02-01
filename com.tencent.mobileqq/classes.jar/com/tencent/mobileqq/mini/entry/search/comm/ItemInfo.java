package com.tencent.mobileqq.mini.entry.search.comm;

public abstract interface ItemInfo
{
  public static final int TYPE_GUESS_YOU_LIKE = 4;
  public static final int TYPE_LIVE = 3;
  public static final int TYPE_PLAY = 2;
  public static final int TYPE_RECOMMEND_FOR_YOU = 5;
  public static final int TYPE_TITLE = 1;
  
  public abstract int getType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.search.comm.ItemInfo
 * JD-Core Version:    0.7.0.1
 */