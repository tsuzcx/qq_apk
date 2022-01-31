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
    if (this.mFilterRender != null)
    {
      this.mFilterRender.destroy();
      this.mFilterRender = null;
      SLog.i("avFilterRender", "destroyNewFilter");
    }
  }
  
  private String getLocalResFold(String paramString, FilterDesc paramFilterDesc)
  {
    String str2 = "";
    String str1 = str2;
    if (paramFilterDesc != null)
    {
      str1 = str2;
      if (paramFilterDesc.name.equals("EMPTY")) {
        str1 = null;
      }
      if (paramFilterDesc.name.equals("MANHUA")) {
        str1 = paramString + "COMIC";
      }
      if (paramFilterDesc.name.equals("SHENGXIA")) {
        str1 = paramString + "GESE";
      }
      if (paramFilterDesc.name.equals("NUANYANG")) {
        str1 = paramString + "BRIGHTFIRE";
      }
      if (paramFilterDesc.name.equals("YUEGUANG")) {
        str1 = paramString + "SKYLINE";
      }
      if (paramFilterDesc.name.equals("QIANGWEI")) {
        str1 = paramString + "G1";
      }
      if (paramFilterDesc.name.equals("YOULAN")) {
        str1 = paramString + "ORCHID";
      }
      if (paramFilterDesc.name.equals("SHENGDAE")) {
        str1 = paramString + "SHENGDAI";
      }
      if (paramFilterDesc.name.equals("BOHE")) {
        str1 = paramString + "AMARO";
      }
      if (paramFilterDesc.name.equals("LANGMAN")) {
        str1 = paramString + "FENBI";
      }
      if (paramFilterDesc.name.equals("NATURE")) {
        str1 = paramString + "NATURE";
      }
      if (paramFilterDesc.name.equals("VSCOG3")) {
        str1 = paramString + "VSCOG3";
      }
      if (paramFilterDesc.name.equals("VUEF1")) {
        str1 = paramString + "VUEF1";
      }
      if (paramFilterDesc.name.equals("VSCOC1")) {
        str1 = paramString + "VSCOC1";
      }
      if (paramFilterDesc.name.equals("FOODIEYU5")) {
        str1 = paramString + "FOODIEYU5";
      }
      if (paramFilterDesc.name.equals("FOODIECH1")) {
        str1 = paramString + "FOODIECH1";
      }
      if (paramFilterDesc.name.equals("ANALOGFILM04")) {
        str1 = paramString + "ANALOGFILM04";
      }
      if (paramFilterDesc.name.equals("INSLARK")) {
        str1 = paramString + "INSLARK";
      }
      if (paramFilterDesc.name.equals("BEAUTYCAM")) {
        str1 = paramString + "BEAUTYCAM";
      }
      if (paramFilterDesc.name.equals("ANALOGFILM02")) {
        str1 = paramString + "ANALOGFILM02";
      }
      if (paramFilterDesc.name.equals("BLACKWHITE")) {
        str1 = paramString + "BLACKWHITE";
      }
      if (paramFilterDesc.name.equals("B612HONGRUN")) {
        str1 = paramString + "B612HONGRUN";
      }
      if (paramFilterDesc.name.equals("INSTASIZETOKYO")) {
        str1 = paramString + "INSTASIZETOKYO";
      }
      if (paramFilterDesc.name.equals("MEITUJIAOPIAN")) {
        str1 = paramString + "MEITUJIAOPIAN";
      }
      if (paramFilterDesc.name.equals("MEIYANHUAYAN")) {
        str1 = paramString + "MEIYANHUAYAN";
      }
      if (paramFilterDesc.name.equals("VUELANMEIZHIYE")) {
        str1 = paramString + "VUELANMEIZHIYE";
      }
      if (paramFilterDesc.name.equals("HEAVYFELLING")) {
        str1 = paramString + "HEAVYFELLING";
      }
      if (paramFilterDesc.name.equals("ANHONG")) {
        str1 = paramString + "ANHONG";
      }
      if (paramFilterDesc.name.equals("BOPU")) {
        str1 = paramString + "BOPU";
      }
      if (paramFilterDesc.name.equals("KLEINBLUE")) {
        str1 = paramString + "KLEINBLUE";
      }
      if (paramFilterDesc.name.equals("PURPLEORANGE")) {
        str1 = paramString + "PURPLEORANGE";
      }
      if (paramFilterDesc.name.equals("TEATIME")) {
        str1 = paramString + "TEATIME";
      }
      if (paramFilterDesc.name.equals("FOREST")) {
        str1 = paramString + "FOREST";
      }
      if (paramFilterDesc.name.equals("NORGE")) {
        str1 = paramString + "NORGE";
      }
      if (paramFilterDesc.name.equals("SANTORINI")) {
        str1 = paramString + "SANTORINI";
      }
      if (paramFilterDesc.name.equals("SHIFTER")) {
        str1 = paramString + "SHIFTER";
      }
      if (paramFilterDesc.name.equals("BLACKNOISE")) {
        str1 = paramString + "BLACKNOISE";
      }
      if (paramFilterDesc.name.equals("STRONG")) {
        str1 = paramString + "STRONG";
      }
      if (paramFilterDesc.name.equals("DELICIOUS")) {
        str1 = paramString + "DELICIOUS";
      }
      if (paramFilterDesc.name.equals("WHITETEA")) {
        str1 = paramString + "WHITETEA";
      }
      if (paramFilterDesc.name.equals("SALIS")) {
        str1 = paramString + "SALIS";
      }
      if (paramFilterDesc.name.equals("CLEANCOLD")) {
        str1 = paramString + "CLEANCOLD";
      }
      if (paramFilterDesc.name.equals("FILM")) {
        str1 = paramString + "FILM";
      }
      if (paramFilterDesc.name.equals("MACAROON")) {
        str1 = paramString + "MACAROON";
      }
      if (paramFilterDesc.name.equals("GRASS")) {
        str1 = paramString + "GRASS";
      }
    }
    return str1;
  }
  
  public int getAVFilterType()
  {
    if (this.mFilterRender != null) {
      return this.mFilterRender.getFilterType();
    }
    return 0;
  }
  
  public boolean isFilterWork()
  {
    if (this.mFilterRender == null) {}
    while (this.mFilterRender.getFilterType() == -1) {
      return false;
    }
    return true;
  }
  
  public void onDrawFrame()
  {
    boolean bool = false;
    FilterBusinessOperation localFilterBusinessOperation = getQQFilterRenderManager().getBusinessOperation();
    localFilterBusinessOperation.getPresentTimeStamp();
    long l = localFilterBusinessOperation.getOrgTimeStamp();
    if (this.mFilterRender == null)
    {
      this.mFilterRender = new FilterRender(SdkContext.getInstance().getApplication());
      setCurrentId(localFilterBusinessOperation.getCurrentAVFilterIdByType(0), false);
    }
    int i;
    if (this.mFragmentFilterDescs.size() > 0) {
      i = 0;
    }
    for (;;)
    {
      QQAVFilter.FragmentFilterDesc localFragmentFilterDesc;
      if (i < this.mFragmentFilterDescs.size())
      {
        if (l >= ((QQAVFilter.FragmentFilterDesc)this.mFragmentFilterDescs.get(i)).timeSlamp.longValue()) {
          break label273;
        }
        localFragmentFilterDesc = (QQAVFilter.FragmentFilterDesc)this.mFragmentFilterDescs.get(i);
        FilterDesc localFilterDesc = localFilterBusinessOperation.getCurrentAVFilterIdByType(0);
        if (localFilterDesc == null) {
          break label248;
        }
        if (!localFilterDesc.name.equals(localFragmentFilterDesc.filterDesc.name))
        {
          this.mFilterRender.setFilterPath(localFragmentFilterDesc.filterPath);
          localFilterBusinessOperation.addSelectedFilterDesc(localFragmentFilterDesc.filterDesc);
        }
      }
      for (;;)
      {
        this.lastWidth = getQQFilterRenderManager().getFilterWidth();
        this.lastHeight = getQQFilterRenderManager().getFilterHeight();
        this.mOutputTextureID = this.mFilterRender.process(this.mInputTextureID, -1, this.lastWidth, this.lastHeight).getTextureId();
        if (this.mFilterRender.getFilterType() != -1) {
          bool = true;
        }
        QQFilterLogManager.setFilterStatus("QQAvFilter", bool);
        return;
        label248:
        this.mFilterRender.setFilterPath(localFragmentFilterDesc.filterPath);
        localFilterBusinessOperation.addSelectedFilterDesc(localFragmentFilterDesc.filterDesc);
      }
      label273:
      i += 1;
    }
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
    String str1 = "";
    if (paramFilterDesc != null) {
      if (TextUtils.isEmpty(paramFilterDesc.resRootPath)) {
        break label144;
      }
    }
    label144:
    for (str1 = paramFilterDesc.getResFold(paramFilterDesc.resRootPath);; str1 = paramFilterDesc.getResFold(str3))
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1)) {
        str2 = getLocalResFold(str3, paramFilterDesc);
      }
      if (this.mFilterRender == null) {
        this.mFilterRender = new FilterRender(SdkContext.getInstance().getApplication());
      }
      this.mFilterRender.setFilterPath(str2);
      if (TextUtils.isEmpty(str2)) {
        break;
      }
      SLog.i("avFilterRender", "setNewSdkFilterID path:" + str2);
      return;
    }
    SLog.i("avFilterRender", "set empty path~~");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.filter.QQAVFilter
 * JD-Core Version:    0.7.0.1
 */