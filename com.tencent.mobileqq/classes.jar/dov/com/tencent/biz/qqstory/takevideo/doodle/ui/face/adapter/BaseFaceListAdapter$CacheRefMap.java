package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashMap;

public class BaseFaceListAdapter$CacheRefMap<K, V>
{
  private ReferenceQueue<V> jdField_a_of_type_JavaLangRefReferenceQueue = new ReferenceQueue();
  private HashMap<K, CacheRefMap<K, V>.CacheRef> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  @Nullable
  public V a(K paramK)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramK))
    {
      paramK = (BaseFaceListAdapter.CacheRefMap.CacheRef)this.jdField_a_of_type_JavaUtilHashMap.get(paramK);
      if (paramK.get() != null) {
        return paramK.get();
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
      this.jdField_a_of_type_JavaUtilHashMap.remove(((BaseFaceListAdapter.CacheRefMap.CacheRef)localReference).a());
    }
  }
  
  public void a(@NonNull K paramK, @NonNull V paramV)
  {
    if ((paramK == null) || (paramV == null)) {
      throw new IllegalArgumentException("key-value cannot be null");
    }
    if ((this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramK)) && (((BaseFaceListAdapter.CacheRefMap.CacheRef)this.jdField_a_of_type_JavaUtilHashMap.get(paramK)).get() != null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramK, new BaseFaceListAdapter.CacheRefMap.CacheRef(this, paramK, paramV, this.jdField_a_of_type_JavaLangRefReferenceQueue));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.BaseFaceListAdapter.CacheRefMap
 * JD-Core Version:    0.7.0.1
 */