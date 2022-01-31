package com.tencent.mobileqq.search.model;

import avmp;
import avmq;
import avmr;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BusinessGroupWord
  implements Serializable
{
  public avmp clueWordItem;
  public avmq groupID;
  public List<avmr> hotWordItemList;
  
  public BusinessGroupWord() {}
  
  public BusinessGroupWord(avmq paramavmq, List<avmr> paramList, avmp paramavmp)
  {
    this.groupID = paramavmq;
    this.hotWordItemList = new ArrayList();
    this.hotWordItemList = paramList;
    this.clueWordItem = paramavmp;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.BusinessGroupWord
 * JD-Core Version:    0.7.0.1
 */