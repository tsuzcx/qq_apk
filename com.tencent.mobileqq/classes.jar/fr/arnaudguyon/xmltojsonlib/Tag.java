package fr.arnaudguyon.xmltojsonlib;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Tag
{
  private ArrayList<Tag> mChildren = new ArrayList();
  private String mContent;
  private String mName;
  private String mPath;
  
  Tag(String paramString1, String paramString2)
  {
    this.mPath = paramString1;
    this.mName = paramString2;
  }
  
  void addChild(Tag paramTag)
  {
    this.mChildren.add(paramTag);
  }
  
  Tag getChild(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mChildren.size())) {
      return (Tag)this.mChildren.get(paramInt);
    }
    return null;
  }
  
  ArrayList<Tag> getChildren()
  {
    return this.mChildren;
  }
  
  int getChildrenCount()
  {
    return this.mChildren.size();
  }
  
  String getContent()
  {
    return this.mContent;
  }
  
  HashMap<String, ArrayList<Tag>> getGroupedElements()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.mChildren.iterator();
    while (localIterator.hasNext())
    {
      Tag localTag = (Tag)localIterator.next();
      String str = localTag.getName();
      ArrayList localArrayList2 = (ArrayList)localHashMap.get(str);
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2 == null)
      {
        localArrayList1 = new ArrayList();
        localHashMap.put(str, localArrayList1);
      }
      localArrayList1.add(localTag);
    }
    return localHashMap;
  }
  
  String getName()
  {
    return this.mName;
  }
  
  String getPath()
  {
    return this.mPath;
  }
  
  boolean hasChildren()
  {
    return this.mChildren.size() > 0;
  }
  
  void setContent(String paramString)
  {
    int k = 0;
    int j = k;
    int i;
    if (paramString != null) {
      i = 0;
    }
    for (;;)
    {
      j = k;
      if (i < paramString.length())
      {
        j = paramString.charAt(i);
        if ((j != 32) && (j != 10)) {
          j = 1;
        }
      }
      else
      {
        if (j != 0) {
          this.mContent = paramString;
        }
        return;
      }
      i += 1;
    }
  }
  
  public String toString()
  {
    return "Tag: " + this.mName + ", " + this.mChildren.size() + " children, Content: " + this.mContent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     fr.arnaudguyon.xmltojsonlib.Tag
 * JD-Core Version:    0.7.0.1
 */