package me.ele.uetool.base;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;
import java.util.List;
import me.ele.uetool.base.item.Item;

public class Element
{
  private List<Item> changeItem;
  private String changeLog;
  private int[] location = new int[2];
  private Rect originRect = new Rect();
  private Element parentElement;
  private Rect rect = new Rect();
  private View view;
  
  public Element(View paramView)
  {
    this.view = paramView;
    reset();
    this.originRect.set(this.rect.left, this.rect.top, this.rect.right, this.rect.bottom);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (Element)paramObject;
      if (this.view != null) {
        return this.view.equals(paramObject.view);
      }
    } while (paramObject.view == null);
    return false;
  }
  
  public int getArea()
  {
    return this.view.getWidth() * this.view.getHeight();
  }
  
  public List<Item> getChangeItem()
  {
    return this.changeItem;
  }
  
  public String getChangeLog()
  {
    return this.changeLog;
  }
  
  public Rect getOriginRect()
  {
    return this.originRect;
  }
  
  public Element getParentElement()
  {
    if (this.parentElement == null)
    {
      ViewParent localViewParent = this.view.getParent();
      if ((localViewParent instanceof View)) {
        this.parentElement = new Element((View)localViewParent);
      }
    }
    return this.parentElement;
  }
  
  public Rect getRect()
  {
    return this.rect;
  }
  
  public View getView()
  {
    return this.view;
  }
  
  public int hashCode()
  {
    if (this.view != null) {
      return this.view.hashCode();
    }
    return 0;
  }
  
  public void reset()
  {
    this.view.getLocationOnScreen(this.location);
    int k = this.view.getWidth();
    int m = this.view.getHeight();
    int n = this.location[0];
    int j = this.location[1];
    int i = j;
    if (Build.VERSION.SDK_INT <= 19) {
      i = j - DimenUtil.getStatusBarHeight();
    }
    this.rect.set(n, i, n + k, m + i);
  }
  
  public void setChangeItem(List<Item> paramList)
  {
    this.changeItem = paramList;
  }
  
  public void setChangeLog(String paramString)
  {
    this.changeLog = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.ele.uetool.base.Element
 * JD-Core Version:    0.7.0.1
 */