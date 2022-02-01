package com.tencent.richmediabrowser.model;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainBrowserModel
  extends BrowserBaseModel
{
  public List<RichMediaBrowserInfo> browserDataList = new ArrayList();
  private MainBrowserPresenter browserPresenter;
  public RichMediaBrowserInfo currentBrowserInfo;
  public int currentIndex;
  
  public MainBrowserModel(MainBrowserPresenter paramMainBrowserPresenter)
  {
    this.browserPresenter = paramMainBrowserPresenter;
  }
  
  public void buildComplete()
  {
    super.buildComplete();
  }
  
  public void buildModel()
  {
    super.buildModel();
  }
  
  public void buildParams(Intent paramIntent)
  {
    super.buildParams(paramIntent);
  }
  
  public int getCount()
  {
    if (!this.browserDataList.isEmpty()) {
      return this.browserDataList.size();
    }
    return super.getCount();
  }
  
  public RichMediaBrowserInfo getItem(int paramInt)
  {
    if ((!this.browserDataList.isEmpty()) && (paramInt >= 0) && (paramInt < this.browserDataList.size())) {
      return (RichMediaBrowserInfo)this.browserDataList.get(paramInt);
    }
    return super.getItem(paramInt);
  }
  
  public RichMediaBrowserInfo getItem(String paramString)
  {
    if ((!this.browserDataList.isEmpty()) && (!TextUtils.isEmpty(paramString)))
    {
      Iterator localIterator = this.browserDataList.iterator();
      while (localIterator.hasNext())
      {
        RichMediaBrowserInfo localRichMediaBrowserInfo = (RichMediaBrowserInfo)localIterator.next();
        if ((localRichMediaBrowserInfo.baseData != null) && (!TextUtils.isEmpty(localRichMediaBrowserInfo.baseData.id)) && (paramString.equals(localRichMediaBrowserInfo.baseData.id))) {
          return localRichMediaBrowserInfo;
        }
      }
    }
    return null;
  }
  
  public int getPosition(String paramString)
  {
    if ((!this.browserDataList.isEmpty()) && (!TextUtils.isEmpty(paramString)))
    {
      int j = this.browserDataList.size();
      int i = 0;
      while (i < j)
      {
        RichMediaBrowserInfo localRichMediaBrowserInfo = (RichMediaBrowserInfo)this.browserDataList.get(i);
        if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (paramString.equals(localRichMediaBrowserInfo.baseData.id))) {
          return i;
        }
        i += 1;
      }
    }
    return 0;
  }
  
  public int getSelectedIndex()
  {
    return this.currentIndex;
  }
  
  public RichMediaBrowserInfo getSelectedItem()
  {
    return this.currentBrowserInfo;
  }
  
  public void setSelectedIndex(int paramInt)
  {
    this.currentIndex = paramInt;
    this.currentBrowserInfo = getItem(paramInt);
  }
  
  public void updateItem(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if ((paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.baseData != null) && (!TextUtils.isEmpty(paramRichMediaBrowserInfo.baseData.id)) && (!this.browserDataList.isEmpty()))
    {
      int j = this.browserDataList.size();
      int i = 0;
      while (i < j)
      {
        RichMediaBrowserInfo localRichMediaBrowserInfo = (RichMediaBrowserInfo)this.browserDataList.get(i);
        if ((localRichMediaBrowserInfo != null) && (localRichMediaBrowserInfo.baseData != null) && (paramRichMediaBrowserInfo.baseData.id.equals(localRichMediaBrowserInfo.baseData.id))) {
          this.browserDataList.set(i, paramRichMediaBrowserInfo);
        }
        i += 1;
      }
    }
  }
  
  public void updateItem(RichMediaBrowserInfo paramRichMediaBrowserInfo, int paramInt)
  {
    if ((paramRichMediaBrowserInfo != null) && (paramRichMediaBrowserInfo.baseData != null) && (!this.browserDataList.isEmpty()) && (paramInt >= 0) && (paramInt < this.browserDataList.size())) {
      this.browserDataList.set(paramInt, paramRichMediaBrowserInfo);
    }
  }
  
  public void updateItemProgress(String paramString, int paramInt)
  {
    paramString = getItem(paramString);
    if ((paramString != null) && (paramString.baseData != null))
    {
      paramString.baseData.progress = paramInt;
      updateItem(paramString);
    }
  }
  
  public void updateItemStatus(String paramString, int paramInt)
  {
    paramString = getItem(paramString);
    if ((paramString != null) && (paramString.baseData != null))
    {
      paramString.baseData.status = paramInt;
      updateItem(paramString);
    }
  }
  
  public void updateList(List<RichMediaBrowserInfo> paramList)
  {
    this.browserDataList = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.richmediabrowser.model.MainBrowserModel
 * JD-Core Version:    0.7.0.1
 */