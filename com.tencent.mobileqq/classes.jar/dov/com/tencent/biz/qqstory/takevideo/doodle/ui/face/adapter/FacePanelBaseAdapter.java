package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class FacePanelBaseAdapter
  implements FacePanelAdapter
{
  private List a = new ArrayList();
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((AdapterObserver)localIterator.next()).h();
    }
  }
  
  public void a(int paramInt)
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((AdapterObserver)localIterator.next()).b(paramInt);
    }
  }
  
  public void a(AdapterObserver paramAdapterObserver)
  {
    if (paramAdapterObserver == null) {
      throw new IllegalArgumentException("the observer is null.");
    }
    if (this.a.contains(paramAdapterObserver)) {
      throw new IllegalStateException("Observer " + paramAdapterObserver + " is already registered.");
    }
    this.a.add(paramAdapterObserver);
  }
  
  public void b(AdapterObserver paramAdapterObserver)
  {
    if (paramAdapterObserver == null) {
      throw new IllegalArgumentException("The observer is null.");
    }
    synchronized (this.a)
    {
      int i = this.a.indexOf(paramAdapterObserver);
      if (i != -1) {
        this.a.remove(i);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.FacePanelBaseAdapter
 * JD-Core Version:    0.7.0.1
 */