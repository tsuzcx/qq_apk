package com.tencent.mobileqq.kandian.repo.atlas;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;
import java.util.LinkedHashMap;

public class AtlasStackInfo
{
  private ArrayDeque<String> jdField_a_of_type_JavaUtilArrayDeque = new ArrayDeque();
  private LinkedHashMap<String, AtlasStackInfo.StackGallery> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  
  public String a()
  {
    if (!this.jdField_a_of_type_JavaUtilArrayDeque.isEmpty()) {
      return (String)this.jdField_a_of_type_JavaUtilArrayDeque.peekFirst();
    }
    return "";
  }
  
  public ArrayDeque<String> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayDeque;
  }
  
  public void a()
  {
    LinkedHashMap localLinkedHashMap = this.jdField_a_of_type_JavaUtilLinkedHashMap;
    if (localLinkedHashMap != null) {
      localLinkedHashMap.clear();
    }
    this.jdField_a_of_type_JavaUtilArrayDeque.clear();
  }
  
  public void a(AtlasModelImageList paramAtlasModelImageList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = (AtlasStackInfo.StackGallery)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(paramAtlasModelImageList.mParsedInfo.b);
    if (localObject == null)
    {
      localObject = new AtlasStackInfo.StackGallery(this, paramAtlasModelImageList, paramInt, paramBoolean1, paramBoolean2);
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramAtlasModelImageList.mParsedInfo.b, localObject);
      paramAtlasModelImageList = (AtlasModelImageList)localObject;
    }
    else
    {
      ((AtlasStackInfo.StackGallery)localObject).a(paramInt, paramBoolean1, paramBoolean2);
      paramAtlasModelImageList = (AtlasModelImageList)localObject;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[setStackGallery], gallery = ");
      ((StringBuilder)localObject).append(paramAtlasModelImageList);
      QLog.d("AtlasStackInfo", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayDeque.peekLast() == null) || (!((String)this.jdField_a_of_type_JavaUtilArrayDeque.peekLast()).equals(paramString))) {
      this.jdField_a_of_type_JavaUtilArrayDeque.add(paramString);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AtlasStackInfo{stackGalleryMap=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilLinkedHashMap);
    localStringBuilder.append("mScanStack=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayDeque.toString());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.atlas.AtlasStackInfo
 * JD-Core Version:    0.7.0.1
 */