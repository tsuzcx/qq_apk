package cooperation.qzone.zipanimate.life;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleOwner;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class PageLiveCycleProxy
  implements PageLifeCycle
{
  private static final String TAG = "PageLiveCycleProxy";
  private static ArrayList<Lifecycle> mLifeCycleList = new ArrayList();
  private static ArrayList<PageLifeCycle> mPageLifeCycleList = new ArrayList();
  private static PageLiveCycleProxy mProxy = new PageLiveCycleProxy();
  
  public static void addPageLifeCycle(PageLifeCycle paramPageLifeCycle)
  {
    if ((paramPageLifeCycle == null) || (mPageLifeCycleList.contains(paramPageLifeCycle))) {
      return;
    }
    mPageLifeCycleList.add(paramPageLifeCycle);
  }
  
  public static void sBindLifeCycle(Lifecycle paramLifecycle)
  {
    if (paramLifecycle != null)
    {
      QLog.i("PageLiveCycleProxy", 1, "sBindLifeCycle = " + paramLifecycle.getClass().getName() + " data = " + paramLifecycle);
      if (!mLifeCycleList.contains(paramLifecycle)) {}
    }
    else
    {
      return;
    }
    paramLifecycle.addObserver(mProxy);
    mLifeCycleList.add(paramLifecycle);
  }
  
  public static void sUnBindLifeCycle(Lifecycle paramLifecycle)
  {
    if (paramLifecycle != null)
    {
      QLog.i("PageLiveCycleProxy", 1, "sUnBindLifeCycle = " + paramLifecycle.getClass().getName());
      paramLifecycle.removeObserver(mProxy);
      mLifeCycleList.remove(paramLifecycle);
    }
  }
  
  public void onLifecycleChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent)
  {
    Iterator localIterator = mPageLifeCycleList.iterator();
    while (localIterator.hasNext()) {
      ((PageLifeCycle)localIterator.next()).onLifecycleChanged(paramLifecycleOwner, paramEvent);
    }
  }
  
  public void onPageCreate(LifecycleOwner paramLifecycleOwner)
  {
    Iterator localIterator = mPageLifeCycleList.iterator();
    while (localIterator.hasNext()) {
      ((PageLifeCycle)localIterator.next()).onPageCreate(paramLifecycleOwner);
    }
  }
  
  public void onPageDestroy(LifecycleOwner paramLifecycleOwner)
  {
    Iterator localIterator = mPageLifeCycleList.iterator();
    while (localIterator.hasNext()) {
      ((PageLifeCycle)localIterator.next()).onPageDestroy(paramLifecycleOwner);
    }
    mPageLifeCycleList.clear();
  }
  
  public void onPagePause(LifecycleOwner paramLifecycleOwner)
  {
    Iterator localIterator = mPageLifeCycleList.iterator();
    while (localIterator.hasNext()) {
      ((PageLifeCycle)localIterator.next()).onPagePause(paramLifecycleOwner);
    }
  }
  
  public void onPageResume(LifecycleOwner paramLifecycleOwner)
  {
    Iterator localIterator = mPageLifeCycleList.iterator();
    while (localIterator.hasNext()) {
      ((PageLifeCycle)localIterator.next()).onPageResume(paramLifecycleOwner);
    }
  }
  
  public void onPageStart(LifecycleOwner paramLifecycleOwner)
  {
    Iterator localIterator = mPageLifeCycleList.iterator();
    while (localIterator.hasNext()) {
      ((PageLifeCycle)localIterator.next()).onPageStart(paramLifecycleOwner);
    }
  }
  
  public void onPageStop(LifecycleOwner paramLifecycleOwner)
  {
    Iterator localIterator = mPageLifeCycleList.iterator();
    while (localIterator.hasNext()) {
      ((PageLifeCycle)localIterator.next()).onPageStop(paramLifecycleOwner);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.zipanimate.life.PageLiveCycleProxy
 * JD-Core Version:    0.7.0.1
 */