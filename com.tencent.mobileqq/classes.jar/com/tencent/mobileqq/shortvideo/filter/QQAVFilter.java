package com.tencent.mobileqq.shortvideo.filter;

import android.text.TextUtils;
import com.tencent.av.video.effect.core.EffectTexture;
import com.tencent.av.video.effect.filter.FilterRender;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.shortvideo.resource.AVFilterResource;
import com.tencent.mobileqq.shortvideo.resource.Resources;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class QQAVFilter
  extends QQBaseFilter
{
  private int lastHeight = 0;
  private int lastWidth = 0;
  private FilterRender mFilterRender;
  private List<QQAVFilter.FragmentFilterDesc> mFragmentFilterDescs = new CopyOnWriteArrayList();
  
  public QQAVFilter(int paramInt, QQFilterRenderManager paramQQFilterRenderManager)
  {
    super(paramInt, paramQQFilterRenderManager);
  }
  
  private void doInternaldestroyFilter()
  {
    FilterRender localFilterRender = this.mFilterRender;
    if (localFilterRender != null)
    {
      localFilterRender.destroy();
      this.mFilterRender = null;
      SLog.i("avFilterRender", "destroyNewFilter");
    }
  }
  
  private String getLocalResFold(String paramString, FilterDesc paramFilterDesc)
  {
    String str = "";
    Object localObject = str;
    if (paramFilterDesc != null)
    {
      localObject = str;
      if (paramFilterDesc.name.equals("EMPTY")) {
        localObject = null;
      }
      if (paramFilterDesc.name.equals("MANHUA"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("COMIC");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("SHENGXIA"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("GESE");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("NUANYANG"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("BRIGHTFIRE");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("YUEGUANG"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("SKYLINE");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("QIANGWEI"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("G1");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("YOULAN"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("ORCHID");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("SHENGDAE"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("SHENGDAI");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("BOHE"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("AMARO");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("LANGMAN"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("FENBI");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("NATURE"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("NATURE");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("VSCOG3"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("VSCOG3");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("VUEF1"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("VUEF1");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("VSCOC1"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("VSCOC1");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("FOODIEYU5"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("FOODIEYU5");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("FOODIECH1"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("FOODIECH1");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("ANALOGFILM04"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("ANALOGFILM04");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("INSLARK"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("INSLARK");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("BEAUTYCAM"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("BEAUTYCAM");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("ANALOGFILM02"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("ANALOGFILM02");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("BLACKWHITE"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("BLACKWHITE");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("B612HONGRUN"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("B612HONGRUN");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("INSTASIZETOKYO"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("INSTASIZETOKYO");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("MEITUJIAOPIAN"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("MEITUJIAOPIAN");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("MEIYANHUAYAN"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("MEIYANHUAYAN");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("VUELANMEIZHIYE"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("VUELANMEIZHIYE");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("HEAVYFELLING"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("HEAVYFELLING");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("ANHONG"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("ANHONG");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("BOPU"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("BOPU");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("KLEINBLUE"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("KLEINBLUE");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("PURPLEORANGE"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("PURPLEORANGE");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("TEATIME"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("TEATIME");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("FOREST"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("FOREST");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("NORGE"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("NORGE");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("SANTORINI"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("SANTORINI");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("SHIFTER"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("SHIFTER");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("BLACKNOISE"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("BLACKNOISE");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("STRONG"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("STRONG");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("DELICIOUS"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("DELICIOUS");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("WHITETEA"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("WHITETEA");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("SALIS"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("SALIS");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("CLEANCOLD"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("CLEANCOLD");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("FILM"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("FILM");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("MACAROON"))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("MACAROON");
        localObject = ((StringBuilder)localObject).toString();
      }
      if (paramFilterDesc.name.equals("GRASS"))
      {
        paramFilterDesc = new StringBuilder();
        paramFilterDesc.append(paramString);
        paramFilterDesc.append("GRASS");
        localObject = paramFilterDesc.toString();
      }
    }
    return localObject;
  }
  
  public int getAVFilterType()
  {
    FilterRender localFilterRender = this.mFilterRender;
    if (localFilterRender != null) {
      return localFilterRender.getFilterType();
    }
    return 0;
  }
  
  public boolean isFilterWork()
  {
    FilterRender localFilterRender = this.mFilterRender;
    boolean bool = false;
    if (localFilterRender == null) {
      return false;
    }
    if (localFilterRender.getFilterType() != -1) {
      bool = true;
    }
    return bool;
  }
  
  public void onDrawFrame()
  {
    FilterBusinessOperation localFilterBusinessOperation = getQQFilterRenderManager().getBusinessOperation();
    localFilterBusinessOperation.getPresentTimeStamp();
    long l = localFilterBusinessOperation.getOrgTimeStamp();
    Object localObject = this.mFilterRender;
    boolean bool = false;
    if (localObject == null)
    {
      this.mFilterRender = new FilterRender(SdkContext.getInstance().getApplication());
      setCurrentId(localFilterBusinessOperation.getCurrentAVFilterIdByType(0), false);
    }
    if (this.mFragmentFilterDescs.size() > 0)
    {
      int i = 0;
      while (i < this.mFragmentFilterDescs.size())
      {
        if (l < ((QQAVFilter.FragmentFilterDesc)this.mFragmentFilterDescs.get(i)).timeSlamp.longValue())
        {
          localObject = (QQAVFilter.FragmentFilterDesc)this.mFragmentFilterDescs.get(i);
          FilterDesc localFilterDesc = localFilterBusinessOperation.getCurrentAVFilterIdByType(0);
          if (localFilterDesc != null)
          {
            if (localFilterDesc.name.equals(((QQAVFilter.FragmentFilterDesc)localObject).filterDesc.name)) {
              break;
            }
            this.mFilterRender.setFilterPath(((QQAVFilter.FragmentFilterDesc)localObject).filterPath);
            localFilterBusinessOperation.addSelectedFilterDesc(((QQAVFilter.FragmentFilterDesc)localObject).filterDesc);
            break;
          }
          this.mFilterRender.setFilterPath(((QQAVFilter.FragmentFilterDesc)localObject).filterPath);
          localFilterBusinessOperation.addSelectedFilterDesc(((QQAVFilter.FragmentFilterDesc)localObject).filterDesc);
          break;
        }
        i += 1;
      }
    }
    this.lastWidth = getQQFilterRenderManager().getFilterWidth();
    this.lastHeight = getQQFilterRenderManager().getFilterHeight();
    this.mOutputTextureID = this.mFilterRender.process(this.mInputTextureID, -1, this.lastWidth, this.lastHeight).getTextureId();
    if (this.mFilterRender.getFilterType() != -1) {
      bool = true;
    }
    QQFilterLogManager.setFilterStatus("QQAvFilter", bool);
  }
  
  public void onSurfaceChange(int paramInt1, int paramInt2)
  {
    if ((this.lastWidth != paramInt1) || (this.lastHeight != paramInt2)) {
      doInternaldestroyFilter();
    }
    if (this.mFilterRender == null) {
      this.mFilterRender = new FilterRender(SdkContext.getInstance().getApplication());
    }
    setCurrentId(getQQFilterRenderManager().getBusinessOperation().getCurrentAVFilterIdByType(0), false);
    SLog.i("avFilterRender", "AVFILTER onSurfaceChange");
  }
  
  public void onSurfaceCreate()
  {
    if (this.mFilterRender != null) {
      doInternaldestroyFilter();
    }
    if (this.mFilterRender == null)
    {
      this.mFilterRender = new FilterRender(SdkContext.getInstance().getApplication());
      this.lastWidth = getQQFilterRenderManager().getFilterWidth();
      this.lastHeight = getQQFilterRenderManager().getFilterHeight();
      this.mFilterRender.preProcess(this.lastWidth, this.lastHeight);
    }
  }
  
  public void onSurfaceDestroy()
  {
    doInternaldestroyFilter();
    SLog.i("avFilterRender", "AVFILTER onSurfaceDestroy");
  }
  
  public void setAVListAndTimeSlamp(List<FilterDesc> paramList, List<Long> paramList1)
  {
    SLog.i("avFilterRender", "setAVListAndTimeSlamp");
    if (this.mFilterRender == null) {
      this.mFilterRender = new FilterRender(SdkContext.getInstance().getApplication());
    }
    String str = SdkContext.getInstance().getResources().getAvFilterResource().getFilterResPath();
    if ((paramList != null) && (paramList1 != null) && (paramList.size() == paramList1.size()))
    {
      this.mFragmentFilterDescs.clear();
      int i = 0;
      while (i < paramList.size())
      {
        FilterDesc localFilterDesc = (FilterDesc)paramList.get(i);
        QQAVFilter.FragmentFilterDesc localFragmentFilterDesc = new QQAVFilter.FragmentFilterDesc();
        if (localFilterDesc != null) {
          localFragmentFilterDesc.filterPath = localFilterDesc.getResFold(str);
        }
        if (TextUtils.isEmpty(localFragmentFilterDesc.filterPath)) {
          localFragmentFilterDesc.filterPath = getLocalResFold(str, localFilterDesc);
        }
        localFragmentFilterDesc.filterDesc = localFilterDesc;
        localFragmentFilterDesc.timeSlamp = ((Long)paramList1.get(i));
        this.mFragmentFilterDescs.add(localFragmentFilterDesc);
        if (i == 0)
        {
          this.mFilterRender.setFilterPath(localFragmentFilterDesc.filterPath);
          getQQFilterRenderManager().getBusinessOperation().addSelectedFilterDesc(localFragmentFilterDesc.filterDesc);
        }
        i += 1;
      }
    }
  }
  
  public void setCurrentId(FilterDesc paramFilterDesc, boolean paramBoolean)
  {
    if (paramBoolean) {
      this.mFragmentFilterDescs.clear();
    }
    String str3 = SdkContext.getInstance().getResources().getAvFilterResource().getFilterResPath();
    String str1;
    if (paramFilterDesc != null)
    {
      if (!TextUtils.isEmpty(paramFilterDesc.resRootPath)) {
        str1 = paramFilterDesc.getResFold(paramFilterDesc.resRootPath);
      } else {
        str1 = paramFilterDesc.getResFold(str3);
      }
    }
    else {
      str1 = "";
    }
    String str2 = str1;
    if (TextUtils.isEmpty(str1)) {
      str2 = getLocalResFold(str3, paramFilterDesc);
    }
    if (this.mFilterRender == null) {
      this.mFilterRender = new FilterRender(SdkContext.getInstance().getApplication());
    }
    this.mFilterRender.setFilterPath(str2);
    if (!TextUtils.isEmpty(str2))
    {
      paramFilterDesc = new StringBuilder();
      paramFilterDesc.append("setNewSdkFilterID path:");
      paramFilterDesc.append(str2);
      SLog.i("avFilterRender", paramFilterDesc.toString());
      return;
    }
    SLog.i("avFilterRender", "set empty path~~");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQAVFilter
 * JD-Core Version:    0.7.0.1
 */