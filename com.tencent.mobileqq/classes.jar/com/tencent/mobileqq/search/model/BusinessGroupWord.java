package com.tencent.mobileqq.search.model;

import bawv;
import baww;
import bawx;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BusinessGroupWord
  implements Serializable
{
  public bawv clueWordItem;
  public baww groupID;
  public List<bawx> hotWordItemList;
  
  public BusinessGroupWord() {}
  
  public BusinessGroupWord(baww parambaww, List<bawx> paramList, bawv parambawv)
  {
    this.groupID = parambaww;
    this.hotWordItemList = new ArrayList();
    this.hotWordItemList = paramList;
    this.clueWordItem = parambawv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.BusinessGroupWord
 * JD-Core Version:    0.7.0.1
 */