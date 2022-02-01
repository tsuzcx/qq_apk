package com.tencent.mobileqq.kandian.repo.atlas;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;
import java.util.LinkedHashMap;

public class AtlasStackInfo
{
  private LinkedHashMap<String, AtlasStackInfo.StackGallery> a = new LinkedHashMap();
  private ArrayDeque<String> b = new ArrayDeque();
  
  public ArrayDeque<String> a()
  {
    return this.b;
  }
  
  public void a(AtlasModelImageList paramAtlasModelImageList, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = (AtlasStackInfo.StackGallery)this.a.get(paramAtlasModelImageList.mParsedInfo.d);
    if (localObject == null)
    {
      localObject = new AtlasStackInfo.StackGallery(this, paramAtlasModelImageList, paramInt, paramBoolean1, paramBoolean2);
      this.a.put(paramAtlasModelImageList.mParsedInfo.d, localObject);
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
    if ((this.b.peekLast() == null) || (!((String)this.b.peekLast()).equals(paramString))) {
      this.b.add(paramString);
    }
  }
  
  public String b()
  {
    if (!this.b.isEmpty()) {
      return (String)this.b.peekFirst();
    }
    return "";
  }
  
  public void c()
  {
    LinkedHashMap localLinkedHashMap = this.a;
    if (localLinkedHashMap != null) {
      localLinkedHashMap.clear();
    }
    this.b.clear();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AtlasStackInfo{stackGalleryMap=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("mScanStack=");
    localStringBuilder.append(this.b.toString());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.atlas.AtlasStackInfo
 * JD-Core Version:    0.7.0.1
 */