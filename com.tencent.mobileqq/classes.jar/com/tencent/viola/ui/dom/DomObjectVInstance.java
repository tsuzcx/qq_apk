package com.tencent.viola.ui.dom;

import android.support.v4.util.ArrayMap;
import java.util.ArrayList;
import java.util.List;

public class DomObjectVInstance
  extends DomObject
  implements DomObject.Consumer
{
  private ArrayMap<String, DomObjectVInstance.AppearEventRectangle> appearEventRectangleMap;
  
  private void initEvent(DomObject paramDomObject)
  {
    ArrayList localArrayList = paramDomObject.getEvents();
    if ((localArrayList.contains("willAppear")) || (localArrayList.contains("didAppear")) || (localArrayList.contains("didDisappear")))
    {
      if (this.appearEventRectangleMap == null) {
        this.appearEventRectangleMap = new ArrayMap();
      }
      this.appearEventRectangleMap.put(paramDomObject.getRef(), new DomObjectVInstance.AppearEventRectangle(paramDomObject));
    }
  }
  
  public void accept(DomObject paramDomObject)
  {
    initEvent(paramDomObject);
  }
  
  public ArrayMap<String, DomObjectVInstance.AppearEventRectangle> getAppearEventRectangleMap()
  {
    return this.appearEventRectangleMap;
  }
  
  public String getId()
  {
    return (String)getAttributes().get("id");
  }
  
  public void tryAddAppearEvents()
  {
    traverseTree(new DomObject.Consumer[] { this });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.viola.ui.dom.DomObjectVInstance
 * JD-Core Version:    0.7.0.1
 */