package com.tencent.mobileqq.search.model;

import aylw;
import aylx;
import ayly;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BusinessGroupWord
  implements Serializable
{
  public aylw clueWordItem;
  public aylx groupID;
  public List<ayly> hotWordItemList;
  
  public BusinessGroupWord() {}
  
  public BusinessGroupWord(aylx paramaylx, List<ayly> paramList, aylw paramaylw)
  {
    this.groupID = paramaylx;
    this.hotWordItemList = new ArrayList();
    this.hotWordItemList = paramList;
    this.clueWordItem = paramaylw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.BusinessGroupWord
 * JD-Core Version:    0.7.0.1
 */