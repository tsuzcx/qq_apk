package com.tencent.mobileqq.search.model;

import ayhn;
import ayho;
import ayhp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BusinessGroupWord
  implements Serializable
{
  public ayhn clueWordItem;
  public ayho groupID;
  public List<ayhp> hotWordItemList;
  
  public BusinessGroupWord() {}
  
  public BusinessGroupWord(ayho paramayho, List<ayhp> paramList, ayhn paramayhn)
  {
    this.groupID = paramayho;
    this.hotWordItemList = new ArrayList();
    this.hotWordItemList = paramList;
    this.clueWordItem = paramayhn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.BusinessGroupWord
 * JD-Core Version:    0.7.0.1
 */