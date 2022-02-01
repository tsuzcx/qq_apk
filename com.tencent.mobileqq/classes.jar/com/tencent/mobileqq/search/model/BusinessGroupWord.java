package com.tencent.mobileqq.search.model;

import bbla;
import bblb;
import bblc;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BusinessGroupWord
  implements Serializable
{
  public bbla clueWordItem;
  public bblb groupID;
  public List<bblc> hotWordItemList;
  
  public BusinessGroupWord() {}
  
  public BusinessGroupWord(bblb parambblb, List<bblc> paramList, bbla parambbla)
  {
    this.groupID = parambblb;
    this.hotWordItemList = new ArrayList();
    this.hotWordItemList = paramList;
    this.clueWordItem = parambbla;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.BusinessGroupWord
 * JD-Core Version:    0.7.0.1
 */