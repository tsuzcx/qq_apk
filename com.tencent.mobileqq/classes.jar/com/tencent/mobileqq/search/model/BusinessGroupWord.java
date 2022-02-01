package com.tencent.mobileqq.search.model;

import bcdl;
import bcdm;
import bcdn;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BusinessGroupWord
  implements Serializable
{
  public bcdl clueWordItem;
  public bcdm groupID;
  public List<bcdn> hotWordItemList;
  
  public BusinessGroupWord() {}
  
  public BusinessGroupWord(bcdm parambcdm, List<bcdn> paramList, bcdl parambcdl)
  {
    this.groupID = parambcdm;
    this.hotWordItemList = new ArrayList();
    this.hotWordItemList = paramList;
    this.clueWordItem = parambcdl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.BusinessGroupWord
 * JD-Core Version:    0.7.0.1
 */