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
  public RichMediaBrowserInfo a;
  int b;
  int c;
  List<RichMediaBrowserInfo> d = new ArrayList();
  boolean e = false;
  boolean f = false;
  boolean g = false;
  private AIOBrowserPresenter h;
  
  public AIOBrowserModel(AIOBrowserPresenter paramAIOBrowserPresenter)
  {
    super(paramAIOBrowserPresenter);
    this.h = paramAIOBrowserPresenter;
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
        if ((localAIOBrowserBaseData != null) && (paramLong == localAIOBrowserBaseData.a)) {
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
        if ((localAIOBrowserBaseData != null) && (paramLong == localAIOBrowserBaseData.a) && (paramInt == localAIOBrowserBaseData.b)) {
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
          if ((((AIOPictureData)localObject).a == paramLong) && (((AIOPictureData)localObject).b == paramInt1))
          {
            new AIOPictureModel().a((AIOPictureData)localObject, paramInt2, paramString);
            return i;
          }
        }
        else if (AIOVideoData.class.isInstance(localObject))
        {
          localObject = (AIOVideoData)localObject;
          if (((AIOVideoData)localObject).a == paramLong)
          {
            new AIOVideoModel().a((AIOVideoData)localObject, paramInt2, paramString);
            return i;
          }
        }
        else if (AIOFilePictureData.class.isInstance(localObject))
        {
          localObject = (AIOFilePictureData)localObject;
          if (((AIOFilePictureData)localObject).a == paramLong)
          {
            new AIOFilePictureModel().a((AIOFilePictureData)localObject, paramInt2, paramString);
            return i;
          }
        }
        else if ((AIOFileVideoData.class.isInstance(localObject)) && (((AIOFileVideoData)localObject).a == paramLong))
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
    return this.a;
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
        if ((paramLong1 == localAIOBrowserBaseData.a) && (paramLong2 == localAIOBrowserBaseData.b)) {
          return localRichMediaBrowserInfo;
        }
      }
    }
    return null;
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
        if ((paramLong == localAIOBrowserBaseData.a) && (paramInt1 == localAIOBrowserBaseData.b)) {
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
    this.a = this.currentBrowserInfo;
    this.browserDataList.add(paramRichMediaBrowserInfo);
  }
  
  public void a(RichMediaBrowserInfo paramRichMediaBrowserInfo, long paramLong)
  {
    if ((b(paramRichMediaBrowserInfo)) && (paramRichMediaBrowserInfo.baseData.getType() == 101)) {
      ((AIOVideoData)paramRichMediaBrowserInfo.baseData).x = paramLong;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.f != paramBoolean)
    {
      this.f = paramBoolean;
      Collections.reverse(this.browserDataList);
      this.currentIndex = (this.browserDataList.size() - 1 - this.currentIndex);
    }
  }
  
  public boolean a(AIOBrowserBaseData[] paramArrayOfAIOBrowserBaseData, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfAIOBrowserBaseData.length - 1;
    if (i >= 0)
    {
      localAIOBrowserBaseData = paramArrayOfAIOBrowserBaseData[i];
      if ((this.a == null) || (this.currentBrowserInfo == null))
      {
        localObject1 = new RichMediaBrowserInfo();
        ((RichMediaBrowserInfo)localObject1).baseData = localAIOBrowserBaseData;
        this.currentBrowserInfo = ((RichMediaBrowserInfo)localObject1);
        this.a = ((RichMediaBrowserInfo)localObject1);
      }
    }
    AIOBrowserBaseData localAIOBrowserBaseData = (AIOBrowserBaseData)this.a.baseData;
    Object localObject1 = (AIOBrowserBaseData)this.currentBrowserInfo.baseData;
    i = 0;
    while (i < paramArrayOfAIOBrowserBaseData.length)
    {
      Object localObject2 = paramArrayOfAIOBrowserBaseData[i];
      RichMediaBrowserInfo localRichMediaBrowserInfo;
      if (this.e)
      {
        localRichMediaBrowserInfo = new RichMediaBrowserInfo();
        localRichMediaBrowserInfo.baseData = ((RichMediaBaseData)localObject2);
        localArrayList.add(localRichMediaBrowserInfo);
      }
      else if ((localAIOBrowserBaseData.a == ((AIOBrowserBaseData)localObject2).a) && (localAIOBrowserBaseData.b == ((AIOBrowserBaseData)localObject2).b))
      {
        localObject2 = this.a;
        ((RichMediaBrowserInfo)localObject2).isEnterImage = true;
        if (localObject2 == this.currentBrowserInfo) {
          this.g = true;
        }
        localArrayList.add(this.a);
      }
      else if ((((AIOBrowserBaseData)localObject1).a == ((AIOBrowserBaseData)localObject2).a) && (((AIOBrowserBaseData)localObject1).b == ((AIOBrowserBaseData)localObject2).b))
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
    if (this.e)
    {
      this.d.addAll(0, localArrayList);
      return false;
    }
    if (!this.g) {
      return false;
    }
    this.browserDataList = a(localArrayList);
    if (this.f) {
      Collections.reverse(this.browserDataList);
    }
    if (this.a != null) {
      this.currentIndex = this.browserDataList.indexOf(this.a);
    }
    if (b(getItem(this.currentIndex))) {
      updateItem(this.currentBrowserInfo, this.currentIndex);
    }
    this.e = true;
    return true;
  }
  
  public RichMediaBrowserInfo b(long paramLong)
  {
    if (this.browserDataList != null)
    {
      Iterator localIterator = this.browserDataList.iterator();
      while (localIterator.hasNext())
      {
        RichMediaBrowserInfo localRichMediaBrowserInfo = (RichMediaBrowserInfo)localIterator.next();
        if (paramLong == ((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).a) {
          return localRichMediaBrowserInfo;
        }
      }
    }
    return null;
  }
  
  public boolean b()
  {
    if (!this.g) {
      return false;
    }
    int i = this.d.size();
    if (i > 0)
    {
      this.b += i;
      this.c += i;
      List localList = a(this.d);
      if (this.f)
      {
        Collections.reverse(localList);
        this.browserDataList.addAll(localList);
      }
      else
      {
        this.currentIndex += localList.size();
        this.browserDataList.addAll(0, localList);
      }
      this.d.clear();
      return true;
    }
    return false;
  }
  
  public boolean b(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    return (paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.baseData != null) && ((paramRichMediaBrowserInfo.baseData.getType() == 101) || (paramRichMediaBrowserInfo.baseData.getType() == 103));
  }
  
  public RichMediaBrowserInfo c(long paramLong)
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
      } while (((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject1).baseData).a != paramLong);
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
  
  public List<RichMediaBrowserInfo> c()
  {
    return this.browserDataList;
  }
  
  public void c(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if (b(paramRichMediaBrowserInfo))
    {
      if (paramRichMediaBrowserInfo.baseData.getType() == 101)
      {
        ((AIOVideoData)paramRichMediaBrowserInfo.baseData).v = true;
        return;
      }
      if (paramRichMediaBrowserInfo.baseData.getType() == 103) {
        ((AIOFileVideoData)paramRichMediaBrowserInfo.baseData).y = true;
      }
    }
  }
  
  public void d(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if (b(paramRichMediaBrowserInfo))
    {
      if (paramRichMediaBrowserInfo.baseData.getType() == 101)
      {
        ((AIOVideoData)paramRichMediaBrowserInfo.baseData).w = true;
        return;
      }
      if (paramRichMediaBrowserInfo.baseData.getType() == 103) {
        ((AIOFileVideoData)paramRichMediaBrowserInfo.baseData).z = true;
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
        if ((localAIOBrowserBaseData1.a == localAIOBrowserBaseData2.a) && (localAIOBrowserBaseData1.b == localAIOBrowserBaseData2.b)) {
          this.browserDataList.set(i, paramRichMediaBrowserInfo);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.model.AIOBrowserModel
 * JD-Core Version:    0.7.0.1
 */