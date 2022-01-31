package dov.com.tencent.mobileqq.activity.richmedia;

import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.data.ComboLockManager;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.LockedCategory;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.paster.PasterDataManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class VideoFilterTools$ComboFilterData
{
  public VideoFilterTools.DataSet a;
  String jdField_a_of_type_JavaLangString;
  public HashMap a;
  CopyOnWriteArrayList jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList;
  public VideoFilterTools.DataSet b = new VideoFilterTools.DataSet();
  public VideoFilterTools.DataSet c = new VideoFilterTools.DataSet();
  
  public VideoFilterTools$ComboFilterData(String paramString)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$DataSet = new VideoFilterTools.DataSet();
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = a(paramString);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$DataSet = VideoFilterTools.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList, true, false);
    this.b = VideoFilterTools.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList, false, true);
    this.c = VideoFilterTools.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList, false, false);
    VideoFilterTools.a().a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
  }
  
  private void a(VideoFilterTools.DataSet paramDataSet1, VideoFilterTools.DataSet paramDataSet2)
  {
    PasterDataManager localPasterDataManager = (PasterDataManager)QIMManager.a(4);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramDataSet1.jdField_a_of_type_JavaUtilArrayList.size())
    {
      if (!localPasterDataManager.a(((FilterCategory)paramDataSet1.jdField_a_of_type_JavaUtilArrayList.get(i)).jdField_b_of_type_Int)) {
        localArrayList.add(paramDataSet1.jdField_a_of_type_JavaUtilArrayList.get(i));
      }
      i += 1;
    }
    paramDataSet2.jdField_a_of_type_JavaUtilArrayList = localArrayList;
    paramDataSet2.jdField_b_of_type_JavaUtilArrayList = paramDataSet1.jdField_b_of_type_JavaUtilArrayList;
    paramDataSet2.c = paramDataSet1.c;
    paramDataSet2.d = paramDataSet1.d;
    paramDataSet2.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem = paramDataSet1.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem;
    paramDataSet2.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem = paramDataSet1.jdField_b_of_type_DovComQqImCaptureDataQIMFilterCategoryItem;
  }
  
  public VideoFilterTools.DataSet a(int paramInt)
  {
    VideoFilterTools.DataSet localDataSet2 = new VideoFilterTools.DataSet();
    VideoFilterTools.DataSet localDataSet1 = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$DataSet;
    switch (paramInt)
    {
    }
    for (;;)
    {
      a(localDataSet1, localDataSet2);
      return localDataSet2;
      localDataSet1 = this.b;
      continue;
      localDataSet1 = this.c;
      continue;
      localDataSet1 = this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$DataSet;
    }
  }
  
  public CopyOnWriteArrayList a(String paramString)
  {
    int j = 0;
    CopyOnWriteArrayList localCopyOnWriteArrayList = new CopyOnWriteArrayList();
    paramString = new JSONObject(paramString);
    Object localObject1 = FilterDesc.a(paramString.getJSONArray("filters")).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FilterDesc)((Iterator)localObject1).next();
      VideoFilterTools.jdField_a_of_type_JavaUtilHashMap.put(((FilterDesc)localObject2).e, localObject2);
    }
    localObject1 = paramString.getJSONArray("categorys");
    Object localObject2 = new ArrayList(((JSONArray)localObject1).length());
    int i = 0;
    while (i < ((JSONArray)localObject1).length())
    {
      ((ArrayList)localObject2).add(new FilterCategory(((JSONArray)localObject1).getJSONObject(i), null));
      i += 1;
    }
    localCopyOnWriteArrayList.clear();
    localCopyOnWriteArrayList.addAll((Collection)localObject2);
    ((CaptureComboManager)QIMManager.a(5)).a((List)localObject2);
    paramString = paramString.optJSONArray("locked_categorys");
    if (paramString != null)
    {
      i = j;
      while (i < paramString.length())
      {
        localObject2 = paramString.optJSONObject(i);
        if (localObject2 != null)
        {
          localObject1 = ((JSONObject)localObject2).optString("comboId");
          localObject2 = new LockedCategory((JSONObject)localObject2);
          this.jdField_a_of_type_JavaUtilHashMap.put(localObject1, localObject2);
        }
        i += 1;
      }
    }
    return localCopyOnWriteArrayList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) {
      VideoFilterTools.a().a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
    }
  }
  
  public void a(CopyOnWriteArrayList paramCopyOnWriteArrayList)
  {
    ComboLockManager localComboLockManager = ((CaptureComboManager)QIMManager.a(5)).a();
    paramCopyOnWriteArrayList = paramCopyOnWriteArrayList.iterator();
    while (paramCopyOnWriteArrayList.hasNext())
    {
      FilterCategory localFilterCategory = (FilterCategory)paramCopyOnWriteArrayList.next();
      if (localFilterCategory.jdField_b_of_type_Boolean)
      {
        QIMFilterCategoryItem localQIMFilterCategoryItem1 = (QIMFilterCategoryItem)localFilterCategory.a.remove(0);
        Object localObject1 = new LinkedList();
        Object localObject2 = new LinkedList();
        LinkedList localLinkedList = new LinkedList();
        Iterator localIterator = localFilterCategory.a.iterator();
        while (localIterator.hasNext())
        {
          QIMFilterCategoryItem localQIMFilterCategoryItem2 = (QIMFilterCategoryItem)localIterator.next();
          if (localComboLockManager.a(localQIMFilterCategoryItem2.jdField_a_of_type_JavaLangString)) {
            ((List)localObject1).add(localQIMFilterCategoryItem2);
          } else if (VideoFilterTools.a().a(3, localQIMFilterCategoryItem2.jdField_a_of_type_Int, localQIMFilterCategoryItem2.jdField_a_of_type_JavaLangString)) {
            ((List)localObject2).add(localQIMFilterCategoryItem2);
          } else {
            localLinkedList.add(localQIMFilterCategoryItem2);
          }
        }
        Collections.shuffle(localLinkedList);
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          localLinkedList.add(0, (QIMFilterCategoryItem)((Iterator)localObject2).next());
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          localLinkedList.add(0, (QIMFilterCategoryItem)((Iterator)localObject1).next());
        }
        localLinkedList.add(0, localQIMFilterCategoryItem1);
        localFilterCategory.a = localLinkedList;
      }
    }
  }
  
  public void b()
  {
    a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$DataSet = VideoFilterTools.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList, true, false);
    this.b = VideoFilterTools.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList, false, true);
    this.c = VideoFilterTools.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.ComboFilterData
 * JD-Core Version:    0.7.0.1
 */