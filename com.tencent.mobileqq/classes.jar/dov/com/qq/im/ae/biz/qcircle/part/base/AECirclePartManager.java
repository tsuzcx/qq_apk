package dov.com.qq.im.ae.biz.qcircle.part.base;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class AECirclePartManager
  implements Application.ActivityLifecycleCallbacks
{
  private View jdField_a_of_type_AndroidViewView;
  private AECircleBasePartFragment jdField_a_of_type_DovComQqImAeBizQcirclePartBaseAECircleBasePartFragment;
  private final LinkedHashMap<String, AECircleBasePart> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  
  public AECirclePartManager(AECircleBasePartFragment paramAECircleBasePartFragment, View paramView)
  {
    this.jdField_a_of_type_DovComQqImAeBizQcirclePartBaseAECircleBasePartFragment = paramAECircleBasePartFragment;
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (AECircleBasePart)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((AECircleBasePart)localObject).a(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (AECircleBasePart)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((AECircleBasePart)localObject).a(paramConfiguration);
      }
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(List<AECircleBasePart> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      AECircleBasePart localAECircleBasePart = (AECircleBasePart)paramList.next();
      localAECircleBasePart.a(this.jdField_a_of_type_DovComQqImAeBizQcirclePartBaseAECircleBasePartFragment, this.jdField_a_of_type_AndroidViewView, this);
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localAECircleBasePart.getClass().getSimpleName(), localAECircleBasePart);
    }
  }
  
  public boolean a()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (AECircleBasePart)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if ((localObject != null) && (((AECircleBasePart)localObject).b())) {
        return true;
      }
    }
    return false;
  }
  
  public boolean b()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (AECircleBasePart)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if ((localObject != null) && (!((AECircleBasePart)localObject).a())) {
        return false;
      }
    }
    return true;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (AECircleBasePart)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null)
      {
        ((AECircleBasePart)localObject).onActivityCreated(paramActivity, paramBundle);
        ((AECircleBasePart)localObject).a(this.jdField_a_of_type_AndroidViewView);
      }
    }
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (AECircleBasePart)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((AECircleBasePart)localObject).onActivityDestroyed(paramActivity);
      }
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
    this.jdField_a_of_type_DovComQqImAeBizQcirclePartBaseAECircleBasePartFragment = null;
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (AECircleBasePart)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((AECircleBasePart)localObject).onActivityPaused(paramActivity);
      }
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    paramActivity = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (paramActivity.hasNext())
    {
      Object localObject = (String)paramActivity.next();
      localObject = (AECircleBasePart)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((AECircleBasePart)localObject).onActivityResumed(this.jdField_a_of_type_DovComQqImAeBizQcirclePartBaseAECircleBasePartFragment.getActivity());
      }
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (AECircleBasePart)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((AECircleBasePart)localObject).onActivityStarted(paramActivity);
      }
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (AECircleBasePart)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localObject);
      if (localObject != null) {
        ((AECircleBasePart)localObject).onActivityStopped(paramActivity);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.biz.qcircle.part.base.AECirclePartManager
 * JD-Core Version:    0.7.0.1
 */