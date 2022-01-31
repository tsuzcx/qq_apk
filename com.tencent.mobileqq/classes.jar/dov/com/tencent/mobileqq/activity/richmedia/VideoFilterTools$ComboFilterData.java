package dov.com.tencent.mobileqq.activity.richmedia;

import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.data.ComboLockManager;
import dov.com.qq.im.capture.data.FilterCategory;
import dov.com.qq.im.capture.data.LockedCategory;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import dov.com.qq.im.capture.data.TransitionCategoryItem;
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
  
  public VideoFilterTools$ComboFilterData(String paramString, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$DataSet = new VideoFilterTools.DataSet();
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = a(paramString);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$DataSet = VideoFilterTools.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList, true, false);
    this.b = VideoFilterTools.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList, false, true);
    this.c = VideoFilterTools.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList, false, false);
    if (!paramBoolean) {
      VideoFilterTools.a().a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
    }
  }
  
  private TransitionCategoryItem a(int paramInt1, String paramString1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8)
  {
    TransitionCategoryItem localTransitionCategoryItem = new TransitionCategoryItem();
    localTransitionCategoryItem.jdField_a_of_type_JavaLangString = (paramInt1 + "");
    localTransitionCategoryItem.b = paramString1;
    localTransitionCategoryItem.c = paramString4;
    localTransitionCategoryItem.h = paramString3;
    localTransitionCategoryItem.jdField_a_of_type_Int = paramInt2;
    localTransitionCategoryItem.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
    localTransitionCategoryItem.jdField_a_of_type_JavaUtilArrayList.add(paramString2);
    localTransitionCategoryItem.i = paramString5;
    localTransitionCategoryItem.j = paramString7;
    localTransitionCategoryItem.k = paramString8;
    localTransitionCategoryItem.l = paramString6;
    return localTransitionCategoryItem;
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
  
  public TransitionCategoryItem a()
  {
    return a(4, "默认", 103, "tran_default", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_default.png", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_default_static.png", "LinearBlur", "1", "1", "Basic");
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
  
  public ArrayList a()
  {
    ArrayList localArrayList1 = new ArrayList(5);
    FilterCategory localFilterCategory = new FilterCategory(1001, "基础效果", false, false, 0);
    ArrayList localArrayList2 = new ArrayList(10);
    localArrayList2.add(a(4, "默认", 103, "tran_default", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_default.png", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_default_static.png", "LinearBlur", "1", "1", "Basic"));
    localArrayList2.add(a(5, "叠黑", 103, "tran_fade", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_fadecolor.png", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_fadecolor_static.png", "fadecolor", "1", "2", "Basic"));
    localArrayList2.add(a(6, "放大", 103, "tran_zoom", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_zoom.png", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_zoom_static.png", "simpleZoom", "1", "3", "Basic"));
    localArrayList2.add(a(7, "擦除", 103, "tran_wipe", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_wipe.png", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_wipe_static.png", "directionalwipe", "1", "4", "Basic"));
    localArrayList2.add(a(1, "瞬移", 103, "tran_move", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_move.png", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_move_static.png", "speedWipe", "1", "5", "Basic"));
    localFilterCategory.a = localArrayList2;
    localArrayList1.add(localFilterCategory);
    return localArrayList1;
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
    a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList);
    this.jdField_a_of_type_DovComTencentMobileqqActivityRichmediaVideoFilterTools$DataSet = VideoFilterTools.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList, true, false);
    this.b = VideoFilterTools.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList, false, true);
    this.c = VideoFilterTools.a(this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList, false, false);
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
  
  public ArrayList b()
  {
    ArrayList localArrayList = new ArrayList(10);
    localArrayList.add(a(6, "放大", 103, "tran_zoom", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_zoom.png", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_zoom_static.png", "simpleZoom", "0", "3", "Basic"));
    localArrayList.add(a(7, "擦除", 103, "tran_wipe", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_wipe.png", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_wipe_static.png", "directionalwipe", "0", "4", "Basic"));
    localArrayList.add(a(1, "瞬移", 103, "tran_move", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_move.png", "http://d.url.cn/myapp/qq_desk/shortvideo/transition/trans_move_static.png", "speedWipe", "0", "5", "Basic"));
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.ComboFilterData
 * JD-Core Version:    0.7.0.1
 */