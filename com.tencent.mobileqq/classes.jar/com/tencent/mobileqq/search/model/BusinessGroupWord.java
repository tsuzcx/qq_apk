package com.tencent.mobileqq.search.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BusinessGroupWord
  implements Serializable
{
  public BusinessGroupWord.ClueWordItem clueWordItem;
  public BusinessGroupWord.GroupID groupID;
  public List<BusinessGroupWord.HotWordItem> hotWordItemList;
  
  public BusinessGroupWord() {}
  
  public BusinessGroupWord(BusinessGroupWord.GroupID paramGroupID, List<BusinessGroupWord.HotWordItem> paramList, BusinessGroupWord.ClueWordItem paramClueWordItem)
  {
    this.groupID = paramGroupID;
    this.hotWordItemList = new ArrayList();
    this.hotWordItemList = paramList;
    this.clueWordItem = paramClueWordItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.model.BusinessGroupWord
 * JD-Core Version:    0.7.0.1
 */