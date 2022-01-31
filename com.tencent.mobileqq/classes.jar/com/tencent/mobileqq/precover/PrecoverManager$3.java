package com.tencent.mobileqq.precover;

import attv;
import com.tencent.mobileqq.data.PrecoverResource;
import com.tencent.mobileqq.data.PrecoverResourceBusiness;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PrecoverManager$3
  implements Runnable
{
  public void run()
  {
    synchronized (attv.a(this.this$0))
    {
      Object localObject1 = (List)attv.a(this.this$0).remove(this.jdField_a_of_type_JavaLangString);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject4 = (PrecoverResource)((Iterator)localObject1).next();
          attv.b(this.this$0).remove(attv.a((PrecoverResource)localObject4));
        }
      }
    }
    attv.a(this.this$0, this.jdField_a_of_type_JavaLangString, PrecoverResourceBusiness.class);
    Object localObject3 = attv.a(this.this$0, this.jdField_a_of_type_JavaLangString, PrecoverResource.class);
    Object localObject4 = this.jdField_a_of_type_JavaUtilList.iterator();
    PrecoverResource localPrecoverResource;
    while (((Iterator)localObject4).hasNext())
    {
      localPrecoverResource = (PrecoverResource)((Iterator)localObject4).next();
      attv.b(this.this$0).put(attv.a(localPrecoverResource), localPrecoverResource);
      attv.a(this.this$0, localPrecoverResource);
    }
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      localObject4 = ((List)localObject3).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localPrecoverResource = (PrecoverResource)((Iterator)localObject4).next();
        attv.b(this.this$0).put(attv.a(localPrecoverResource), localPrecoverResource);
      }
    }
    localObject4 = new ArrayList();
    ((List)localObject4).addAll(this.jdField_a_of_type_JavaUtilList);
    if ((localObject3 != null) && (((List)localObject3).size() > 0))
    {
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localPrecoverResource = (PrecoverResource)((Iterator)localObject3).next();
        if (!((List)localObject4).contains(localPrecoverResource)) {
          ((List)localObject4).add(localPrecoverResource);
        }
      }
    }
    attv.a(this.this$0).put(this.jdField_a_of_type_JavaLangString, localObject4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.precover.PrecoverManager.3
 * JD-Core Version:    0.7.0.1
 */