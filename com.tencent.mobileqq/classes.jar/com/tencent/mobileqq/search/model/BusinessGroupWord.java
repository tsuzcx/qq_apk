package com.tencent.mobileqq.search.model;

import awmi;
import awmj;
import awmk;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BusinessGroupWord
  implements Serializable
{
  public awmi clueWordItem;
  public awmj groupID;
  public List<awmk> hotWordItemList;
  
  public BusinessGroupWord() {}
  
  public BusinessGroupWord(awmj paramawmj, List<awmk> paramList, awmi paramawmi)
  {
    this.groupID = paramawmj;
    this.hotWordItemList = new ArrayList();
    this.hotWordItemList = paramList;
    this.clueWordItem = paramawmi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.BusinessGroupWord
 * JD-Core Version:    0.7.0.1
 */