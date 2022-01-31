package com.tencent.mobileqq.search.model;

import awmk;
import awml;
import awmm;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BusinessGroupWord
  implements Serializable
{
  public awmk clueWordItem;
  public awml groupID;
  public List<awmm> hotWordItemList;
  
  public BusinessGroupWord() {}
  
  public BusinessGroupWord(awml paramawml, List<awmm> paramList, awmk paramawmk)
  {
    this.groupID = paramawml;
    this.hotWordItemList = new ArrayList();
    this.hotWordItemList = paramList;
    this.clueWordItem = paramawmk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.BusinessGroupWord
 * JD-Core Version:    0.7.0.1
 */