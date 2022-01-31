package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import ankw;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;

public class NormalFaceAdapter$CacheRefMap
{
  private ReferenceQueue jdField_a_of_type_JavaLangRefReferenceQueue = new ReferenceQueue();
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  @Nullable
  public Object a(Object paramObject)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramObject))
    {
      paramObject = (ankw)this.jdField_a_of_type_JavaUtilHashMap.get(paramObject);
      if (paramObject.get() != null) {
        return paramObject.get();
      }
    }
    return null;
  }
  
  public void a()
  {
    for (;;)
    {
      Reference localReference = this.jdField_a_of_type_JavaLangRefReferenceQueue.poll();
      if (localReference == null) {
        break;
      }
      this.jdField_a_of_type_JavaUtilHashMap.remove(((ankw)localReference).a());
    }
  }
  
  public void a(@NonNull Object paramObject1, @NonNull Object paramObject2)
  {
    if ((paramObject1 == null) || (paramObject2 == null)) {
      throw new IllegalArgumentException("key-value cannot be null");
    }
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramObject1)) && (((ankw)this.jdField_a_of_type_JavaUtilHashMap.get(paramObject1)).get() != null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramObject1, new ankw(this, paramObject1, paramObject2, this.jdField_a_of_type_JavaLangRefReferenceQueue));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.NormalFaceAdapter.CacheRefMap
 * JD-Core Version:    0.7.0.1
 */