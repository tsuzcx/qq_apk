package com.tencent.qqmini.sdk.widget.actionsheet;

import java.util.HashMap;

public class ActionMenuItem
{
  public static final int TYPE_NORMAL = 1;
  public static final int TYPE_WARN = 2;
  public int action;
  public String content;
  public HashMap<String, Object> tag = new HashMap();
  public int type = 1;
  public int viewid;
  public int visibility;
  
  public ActionMenuItem(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this(paramInt1, paramString, paramInt2, paramInt3, 1);
  }
  
  public ActionMenuItem(int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4)
  {
    this.viewid = paramInt1;
    this.content = paramString;
    this.action = paramInt2;
    this.visibility = paramInt3;
    this.type = paramInt4;
  }
  
  public ActionMenuItem(String paramString, int paramInt1, int paramInt2)
  {
    this(0, paramString, paramInt1, paramInt2);
  }
  
  public Object getTag(String paramString)
  {
    return this.tag.get(paramString);
  }
  
  public void setTag(String paramString, Object paramObject)
  {
    this.tag.put(paramString, paramObject);
  }
  
  public void setVisibility(int paramInt)
  {
    this.visibility = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.actionsheet.ActionMenuItem
 * JD-Core Version:    0.7.0.1
 */