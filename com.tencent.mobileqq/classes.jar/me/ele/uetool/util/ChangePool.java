package me.ele.uetool.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.uetool.UETool;
import me.ele.uetool.base.Element;

public class ChangePool
{
  private static ChangePool instance;
  private List<String> changePool = new ArrayList();
  private List<Element> mayChangeList = new ArrayList();
  
  public static ChangePool getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new ChangePool();
      }
      return instance;
    }
    finally {}
  }
  
  public void addToPool(Element paramElement)
  {
    UETool localUETool = UETool.getInstance();
    if ((localUETool.getLastTimeActivityClassName() != null) && (!localUETool.getLastTimeActivityClassName().equals(localUETool.getTargetActivity().getClass())))
    {
      this.mayChangeList.clear();
      this.changePool.clear();
    }
    if (!this.mayChangeList.contains(paramElement))
    {
      this.mayChangeList.add(paramElement);
      paramElement.setChangeLog(Util.getReportData(paramElement, Boolean.valueOf(false)));
      paramElement.setChangeItem(Util.getItems(paramElement));
    }
  }
  
  public void clearAll()
  {
    clearChangePool();
    clearElementList();
  }
  
  public void clearChangePool()
  {
    this.mayChangeList.clear();
  }
  
  public void clearElementList()
  {
    this.mayChangeList.clear();
  }
  
  public void getAllChange()
  {
    this.changePool.clear();
    Iterator localIterator = this.mayChangeList.iterator();
    while (localIterator.hasNext())
    {
      Element localElement = (Element)localIterator.next();
      if (!Util.getReportData(localElement, Boolean.valueOf(false)).equals(localElement.getChangeLog())) {
        this.changePool.add(Util.findDiffReport(localElement));
      }
    }
  }
  
  public String getChangePool()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.changePool.iterator();
    while (localIterator.hasNext()) {
      localStringBuilder.append((String)localIterator.next());
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     me.ele.uetool.util.ChangePool
 * JD-Core Version:    0.7.0.1
 */