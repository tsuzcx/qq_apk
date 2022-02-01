package com.tencent.mobileqq.richmediabrowser.model;

import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter;
import com.tencent.richmediabrowser.model.MainBrowserModel;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class AIOBrowserModel
  extends MainBrowserModel
{
  int jdField_a_of_type_Int;
  private AIOBrowserPresenter jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter;
  public RichMediaBrowserInfo a;
  List<RichMediaBrowserInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean = false;
  boolean c = false;
  
  public AIOBrowserModel(AIOBrowserPresenter paramAIOBrowserPresenter)
  {
    super(paramAIOBrowserPresenter);
    this.jdField_a_of_type_ComTencentMobileqqRichmediabrowserPresenterAIOBrowserPresenter = paramAIOBrowserPresenter;
  }
  
  public static boolean a(AIOBrowserBaseData paramAIOBrowserBaseData)
  {
    boolean bool = false;
    if (paramAIOBrowserBaseData == null) {
      return false;
    }
    if ((paramAIOBrowserBaseData.getType() == 100) || (paramAIOBrowserBaseData.getType() == 101) || (paramAIOBrowserBaseData.getType() == 102) || (paramAIOBrowserBaseData.getType() == 103)) {
      bool = true;
    }
    return bool;
  }
  
  public int a(long paramLong)
  {
    if (this.browserDataList != null)
    {
      Iterator localIterator = this.browserDataList.iterator();
      while (localIterator.hasNext())
      {
        AIOBrowserBaseData localAIOBrowserBaseData = (AIOBrowserBaseData)((RichMediaBrowserInfo)localIterator.next()).baseData;
        if ((localAIOBrowserBaseData != null) && (paramLong == localAIOBrowserBaseData.jdField_a_of_type_Long)) {
          return localAIOBrowserBaseData.getType();
        }
      }
    }
    return -1;
  }
  
  public int a(long paramLong, int paramInt)
  {
    if (this.browserDataList != null)
    {
      Iterator localIterator = this.browserDataList.iterator();
      while (localIterator.hasNext())
      {
        AIOBrowserBaseData localAIOBrowserBaseData = (AIOBrowserBaseData)((RichMediaBrowserInfo)localIterator.next()).baseData;
        if ((localAIOBrowserBaseData != null) && (paramLong == localAIOBrowserBaseData.jdField_a_of_type_Long) && (paramInt == localAIOBrowserBaseData.jdField_a_of_type_Int)) {
          return localAIOBrowserBaseData.getType();
        }
      }
    }
    return -1;
  }
  
  public int a(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    List localList = this.browserDataList;
    int i = 0;
    while (i < localList.size())
    {
      Object localObject = localList.get(i);
      if (RichMediaBrowserInfo.class.isInstance(localObject))
      {
        localObject = (AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData;
        if (AIOPictureData.class.isInstance(localObject))
        {
          localObject = (AIOPictureData)localObject;
          if ((((AIOPictureData)localObject).jdField_a_of_type_Long == paramLong) && (((AIOPictureData)localObject).jdField_a_of_type_Int == paramInt1))
          {
            new AIOPictureModel().a((AIOPictureData)localObject, paramInt2, paramString);
            return i;
          }
        }
        else if (AIOVideoData.class.isInstance(localObject))
        {
          localObject = (AIOVideoData)localObject;
          if (((AIOVideoData)localObject).jdField_a_of_type_Long == paramLong)
          {
            new AIOVideoModel().a((AIOVideoData)localObject, paramInt2, paramString);
            return i;
          }
        }
        else if (AIOFilePictureData.class.isInstance(localObject))
        {
          localObject = (AIOFilePictureData)localObject;
          if (((AIOFilePictureData)localObject).jdField_a_of_type_Long == paramLong)
          {
            new AIOFilePictureModel().a((AIOFilePictureData)localObject, paramInt2, paramString);
            return i;
          }
        }
        else if ((AIOFileVideoData.class.isInstance(localObject)) && (((AIOFileVideoData)localObject).jdField_a_of_type_Long == paramLong))
        {
          return i;
        }
      }
      i += 1;
    }
    return -1;
  }
  
  public RichMediaBrowserInfo a()
  {
    return this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo;
  }
  
  public RichMediaBrowserInfo a(long paramLong)
  {
    if (this.browserDataList != null)
    {
      Iterator localIterator = this.browserDataList.iterator();
      while (localIterator.hasNext())
      {
        RichMediaBrowserInfo localRichMediaBrowserInfo = (RichMediaBrowserInfo)localIterator.next();
        if (paramLong == ((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).jdField_a_of_type_Long) {
          return localRichMediaBrowserInfo;
        }
      }
    }
    return null;
  }
  
  public RichMediaBrowserInfo a(long paramLong1, long paramLong2)
  {
    if (this.browserDataList != null)
    {
      Iterator localIterator = this.browserDataList.iterator();
      while (localIterator.hasNext())
      {
        RichMediaBrowserInfo localRichMediaBrowserInfo = (RichMediaBrowserInfo)localIterator.next();
        AIOBrowserBaseData localAIOBrowserBaseData = (AIOBrowserBaseData)localRichMediaBrowserInfo.baseData;
        if ((paramLong1 == localAIOBrowserBaseData.jdField_a_of_type_Long) && (paramLong2 == localAIOBrowserBaseData.jdField_a_of_type_Int)) {
          return localRichMediaBrowserInfo;
        }
      }
    }
    return null;
  }
  
  public List<RichMediaBrowserInfo> a()
  {
    return this.browserDataList;
  }
  
  public List<RichMediaBrowserInfo> a(List<RichMediaBrowserInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RichMediaBrowserInfo localRichMediaBrowserInfo = (RichMediaBrowserInfo)paramList.next();
        if (a((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData)) {
          localArrayList.add(localRichMediaBrowserInfo);
        }
      }
    }
    return localArrayList;
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.browserDataList != null)
    {
      int j = this.browserDataList.size();
      int i = 0;
      while (i < j)
      {
        AIOBrowserBaseData localAIOBrowserBaseData = (AIOBrowserBaseData)((RichMediaBrowserInfo)this.browserDataList.get(i)).baseData;
        if ((paramLong == localAIOBrowserBaseData.jdField_a_of_type_Long) && (paramInt1 == localAIOBrowserBaseData.jdField_a_of_type_Int)) {
          ((RichMediaBrowserInfo)this.browserDataList.get(i)).baseData.updateStatus(paramInt2);
        }
        i += 1;
      }
    }
  }
  
  public void a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    this.browserDataList.clear();
    this.currentIndex = 0;
    this.currentBrowserInfo = paramRichMediaBrowserInfo;
    this.currentBrowserInfo.isEnterImage = true;
    this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo = this.currentBrowserInfo;
    this.browserDataList.add(paramRichMediaBrowserInfo);
  }
  
  public void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, long paramLong)
  {
    if ((a(paramRichMediaBrowserInfo)) && (paramRichMediaBrowserInfo.baseData.getType() == 101)) {
      ((AIOVideoData)paramRichMediaBrowserInfo.baseData).jdField_f_of_type_Long = paramLong;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_Boolean != paramBoolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      Collections.reverse(this.browserDataList);
      this.currentIndex = (this.browserDataList.size() - 1 - this.currentIndex);
    }
  }
  
  public boolean a()
  {
    if (!this.c) {
      return false;
    }
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (i > 0)
    {
      this.jdField_a_of_type_Int += i;
      this.jdField_b_of_type_Int += i;
      List localList = a(this.jdField_a_of_type_JavaUtilList);
      if (this.jdField_b_of_type_Boolean)
      {
        Collections.reverse(localList);
        this.browserDataList.addAll(localList);
      }
      else
      {
        this.currentIndex += localList.size();
        this.browserDataList.addAll(0, localList);
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      return true;
    }
    return false;
  }
  
  public boolean a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return (paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.baseData != null) && ((paramRichMediaBrowserInfo.baseData.getType() == 101) || (paramRichMediaBrowserInfo.baseData.getType() == 103));
  }
  
  public boolean a(AIOBrowserBaseData[] paramArrayOfAIOBrowserBaseData, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfAIOBrowserBaseData.length - 1;
    if (i >= 0)
    {
      localAIOBrowserBaseData = paramArrayOfAIOBrowserBaseData[i];
      if ((this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo == null) || (this.currentBrowserInfo == null))
      {
        localObject1 = new RichMediaBrowserInfo();
        ((RichMediaBrowserInfo)localObject1).baseData = localAIOBrowserBaseData;
        this.currentBrowserInfo = ((RichMediaBrowserInfo)localObject1);
        this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo = ((RichMediaBrowserInfo)localObject1);
      }
    }
    AIOBrowserBaseData localAIOBrowserBaseData = (AIOBrowserBaseData)this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo.baseData;
    Object localObject1 = (AIOBrowserBaseData)this.currentBrowserInfo.baseData;
    i = 0;
    while (i < paramArrayOfAIOBrowserBaseData.length)
    {
      Object localObject2 = paramArrayOfAIOBrowserBaseData[i];
      RichMediaBrowserInfo localRichMediaBrowserInfo;
      if (this.jdField_a_of_type_Boolean)
      {
        localRichMediaBrowserInfo = new RichMediaBrowserInfo();
        localRichMediaBrowserInfo.baseData = ((RichMediaBaseData)localObject2);
        localArrayList.add(localRichMediaBrowserInfo);
      }
      else if ((localAIOBrowserBaseData.jdField_a_of_type_Long == ((AIOBrowserBaseData)localObject2).jdField_a_of_type_Long) && (localAIOBrowserBaseData.jdField_a_of_type_Int == ((AIOBrowserBaseData)localObject2).jdField_a_of_type_Int))
      {
        localObject2 = this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo;
        ((RichMediaBrowserInfo)localObject2).isEnterImage = true;
        if (localObject2 == this.currentBrowserInfo) {
          this.c = true;
        }
        localArrayList.add(this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo);
      }
      else if ((((AIOBrowserBaseData)localObject1).jdField_a_of_type_Long == ((AIOBrowserBaseData)localObject2).jdField_a_of_type_Long) && (((AIOBrowserBaseData)localObject1).jdField_a_of_type_Int == ((AIOBrowserBaseData)localObject2).jdField_a_of_type_Int))
      {
        localArrayList.add(this.currentBrowserInfo);
      }
      else
      {
        localRichMediaBrowserInfo = new RichMediaBrowserInfo();
        localRichMediaBrowserInfo.baseData = ((RichMediaBaseData)localObject2);
        localArrayList.add(localRichMediaBrowserInfo);
      }
      i += 1;
    }
    if (paramInt >= 0) {
      paramInt = paramArrayOfAIOBrowserBaseData.length;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilList.addAll(0, localArrayList);
      return false;
    }
    if (!this.c) {
      return false;
    }
    this.browserDataList = a(localArrayList);
    if (this.jdField_b_of_type_Boolean) {
      Collections.reverse(this.browserDataList);
    }
    if (this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo != null) {
      this.currentIndex = this.browserDataList.indexOf(this.jdField_a_of_type_ComTencentRichmediabrowserModelRichMediaBrowserInfo);
    }
    if (a(getItem(this.currentIndex))) {
      updateItem(this.currentBrowserInfo, this.currentIndex);
    }
    this.jdField_a_of_type_Boolean = true;
    return true;
  }
  
  public RichMediaBrowserInfo b(long paramLong)
  {
    Object localObject3 = null;
    try
    {
      Iterator localIterator = this.browserDataList.iterator();
      Object localObject1;
      do
      {
        localObject1 = localObject3;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (RichMediaBrowserInfo)localIterator.next();
      } while (((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject1).baseData).jdField_a_of_type_Long != paramLong);
      if (localObject1 != null) {
        this.browserDataList.remove(localObject1);
      }
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void b(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if (a(paramRichMediaBrowserInfo))
    {
      if (paramRichMediaBrowserInfo.baseData.getType() == 101)
      {
        ((AIOVideoData)paramRichMediaBrowserInfo.baseData).jdField_f_of_type_Boolean = true;
        return;
      }
      if (paramRichMediaBrowserInfo.baseData.getType() == 103) {
        ((AIOFileVideoData)paramRichMediaBrowserInfo.baseData).h = true;
      }
    }
  }
  
  public void c(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if (a(paramRichMediaBrowserInfo))
    {
      if (paramRichMediaBrowserInfo.baseData.getType() == 101)
      {
        ((AIOVideoData)paramRichMediaBrowserInfo.baseData).g = true;
        return;
      }
      if (paramRichMediaBrowserInfo.baseData.getType() == 103) {
        ((AIOFileVideoData)paramRichMediaBrowserInfo.baseData).i = true;
      }
    }
  }
  
  public void updateItem(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if ((paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.baseData != null) && (this.browserDataList != null))
    {
      int j = this.browserDataList.size();
      AIOBrowserBaseData localAIOBrowserBaseData1 = (AIOBrowserBaseData)paramRichMediaBrowserInfo.baseData;
      int i = 0;
      while (i < j)
      {
        AIOBrowserBaseData localAIOBrowserBaseData2 = (AIOBrowserBaseData)((RichMediaBrowserInfo)this.browserDataList.get(i)).baseData;
        if ((localAIOBrowserBaseData1.jdField_a_of_type_Long == localAIOBrowserBaseData2.jdField_a_of_type_Long) && (localAIOBrowserBaseData1.jdField_a_of_type_Int == localAIOBrowserBaseData2.jdField_a_of_type_Int)) {
          this.browserDataList.set(i, paramRichMediaBrowserInfo);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.model.AIOBrowserModel
 * JD-Core Version:    0.7.0.1
 */