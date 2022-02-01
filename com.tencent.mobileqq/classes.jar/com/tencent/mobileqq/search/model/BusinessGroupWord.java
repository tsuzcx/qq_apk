package com.tencent.mobileqq.search.model;

import bcdt;
import bcdu;
import bcdv;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BusinessGroupWord
  implements Serializable
{
  public bcdt clueWordItem;
  public bcdu groupID;
  public List<bcdv> hotWordItemList;
  
  public BusinessGroupWord() {}
  
  public BusinessGroupWord(bcdu parambcdu, List<bcdv> paramList, bcdt parambcdt)
  {
    this.groupID = parambcdu;
    this.hotWordItemList = new ArrayList();
    this.hotWordItemList = paramList;
    this.clueWordItem = parambcdt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.BusinessGroupWord
 * JD-Core Version:    0.7.0.1
 */