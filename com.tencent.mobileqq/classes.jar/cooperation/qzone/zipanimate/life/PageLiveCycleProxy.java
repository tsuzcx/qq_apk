package cooperation.qzone.zipanimate.life;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

public class PageLiveCycleProxy
  implements PageLifeCycle
{
  private static final String TAG = "PageLiveCycleProxy";
  private static Stack<Lifecycle> mLifeCycleList = new Stack();
  private static HashMap<Lifecycle, ArrayList<PageLifeCycle>> mPageLifeCycleList = new HashMap();
  private static PageLiveCycleProxy mProxy = new PageLiveCycleProxy();
  
  public static void addPageLifeCycle(PageLifeCycle paramPageLifeCycle)
  {
    if (paramPageLifeCycle != null)
    {
      ArrayList localArrayList = getPageLifeCycleList();
      if (localArrayList == null) {
        return;
      }
      if (localArrayList.contains(paramPageLifeCycle)) {
        return;
      }
      localArrayList.add(paramPageLifeCycle);
    }
  }
  
  private static Lifecycle getCurrentLifecycle()
  {
    if (mLifeCycleList.isEmpty()) {
      return null;
    }
    return (Lifecycle)mLifeCycleList.peek();
  }
  
  private static ArrayList<PageLifeCycle> getPageLifeCycleList()
  {
    Lifecycle localLifecycle = getCurrentLifecycle();
    if (localLifecycle == null) {
      return null;
    }
    if ((mPageLifeCycleList.containsKey(localLifecycle)) && (mPageLifeCycleList.get(localLifecycle) != null)) {
      return (ArrayList)mPageLifeCycleList.get(localLifecycle);
    }
    ArrayList localArrayList = new ArrayList();
    mPageLifeCycleList.put(localLifecycle, localArrayList);
    return localArrayList;
  }
  
  private static void onLifeCycleDestory()
  {
    ArrayList localArrayList = getPageLifeCycleList();
    if (localArrayList == null) {
      return;
    }
    Lifecycle localLifecycle = getCurrentLifecycle();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext()) {
      ((PageLifeCycle)localIterator.next()).onPageDestroy(null);
    }
    localArrayList.clear();
    mPageLifeCycleList.remove(localLifecycle);
  }
  
  public static void sBindLifeCycle(Lifecycle paramLifecycle)
  {
    if (paramLifecycle != null) {
      try
      {
        if (mLifeCycleList.search(paramLifecycle) == 1) {
          return;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sBindLifeCycle = ");
        localStringBuilder.append(paramLifecycle.getClass().getName());
        localStringBuilder.append(" data = ");
        localStringBuilder.append(paramLifecycle);
        QLog.i("PageLiveCycleProxy", 1, localStringBuilder.toString());
        paramLifecycle.addObserver(mProxy);
        mLifeCycleList.push(paramLifecycle);
        return;
      }
      catch (Exception paramLifecycle)
      {
        paramLifecycle.printStackTrace();
      }
    }
  }
  
  public static void sUnBindLifeCycle(Lifecycle paramLifecycle)
  {
    if (paramLifecycle != null) {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("sUnBindLifeCycle = ");
        localStringBuilder.append(paramLifecycle.getClass().getName());
        QLog.i("PageLiveCycleProxy", 1, localStringBuilder.toString());
        paramLifecycle.removeObserver(mProxy);
        if (!mLifeCycleList.isEmpty())
        {
          onLifeCycleDestory();
          mLifeCycleList.pop();
          return;
        }
      }
      catch (Exception paramLifecycle)
      {
        paramLifecycle.printStackTrace();
      }
    }
  }
  
  public void onLifecycleChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent)
  {
    Object localObject = getPageLifeCycleList();
    if (localObject == null) {
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((PageLifeCycle)((Iterator)localObject).next()).onLifecycleChanged(paramLifecycleOwner, paramEvent);
    }
  }
  
  public void onPageCreate(LifecycleOwner paramLifecycleOwner)
  {
    Object localObject = getPageLifeCycleList();
    if (localObject == null) {
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((PageLifeCycle)((Iterator)localObject).next()).onPageCreate(paramLifecycleOwner);
    }
  }
  
  public void onPageDestroy(LifecycleOwner paramLifecycleOwner) {}
  
  public void onPagePause(LifecycleOwner paramLifecycleOwner)
  {
    Object localObject = getPageLifeCycleList();
    if (localObject == null) {
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((PageLifeCycle)((Iterator)localObject).next()).onPagePause(paramLifecycleOwner);
    }
  }
  
  public void onPageResume(LifecycleOwner paramLifecycleOwner)
  {
    Object localObject = getPageLifeCycleList();
    if (localObject == null) {
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((PageLifeCycle)((Iterator)localObject).next()).onPageResume(paramLifecycleOwner);
    }
  }
  
  public void onPageStart(LifecycleOwner paramLifecycleOwner)
  {
    Object localObject = getPageLifeCycleList();
    if (localObject == null) {
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((PageLifeCycle)((Iterator)localObject).next()).onPageStart(paramLifecycleOwner);
    }
  }
  
  public void onPageStop(LifecycleOwner paramLifecycleOwner)
  {
    Object localObject = getPageLifeCycleList();
    if (localObject == null) {
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((PageLifeCycle)((Iterator)localObject).next()).onPageStop(paramLifecycleOwner);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.zipanimate.life.PageLiveCycleProxy
 * JD-Core Version:    0.7.0.1
 */