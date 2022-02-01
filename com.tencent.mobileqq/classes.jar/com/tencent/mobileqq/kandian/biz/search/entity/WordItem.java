package com.tencent.mobileqq.kandian.biz.search.entity;

import java.io.Serializable;

public class WordItem
  implements Serializable
{
  public static final int HOT_WORD_TYPE_DIRECT = 2;
  public static final int HOT_WORD_TYPE_HOT = 1;
  private static final long serialVersionUID = 1L;
  public String contentDescription;
  public int frameColor;
  public String id;
  public String jumpUrl;
  public int textColor;
  public int type = 1;
  public String word;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.search.entity.WordItem
 * JD-Core Version:    0.7.0.1
 */