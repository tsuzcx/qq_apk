package com.tencent.mobileqq.qqslideshow;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowActionListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.util.DisplayUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

@QAPI(process={"peak"})
@QRouteFactory
public abstract interface ISlideShowController
  extends QRouteApi
{
  public static final int CODE_FROM_SLIDE_SHOW_CLIP = 24747;
  public static final String KEY_REPORT_FIRST_EXPOSURE = "report_first_exposure";
  public static final int RECYCLERVIEW_HEIGHT = DisplayUtil.a(MobileQQ.getContext(), 62.0F);
  
  public abstract List<SlideItemInfo> getPhotoList();
  
  public abstract List<SlideItemInfo> getTemp();
  
  public abstract void initPhotoListController(Activity paramActivity, View paramView, SlideShowActionListener paramSlideShowActionListener, boolean paramBoolean);
  
  public abstract void initPhotoPreviewController(Activity paramActivity, View paramView, SlideShowActionListener paramSlideShowActionListener);
  
  public abstract void onClipFinish(Intent paramIntent, Map<String, LocalMediaInfo> paramMap);
  
  public abstract void onItemsSelectChanged(List<String> paramList, HashMap<String, LocalMediaInfo> paramHashMap);
  
  public abstract void onItemsSelectChanged(List<String> paramList, HashMap<String, LocalMediaInfo> paramHashMap, boolean paramBoolean);
  
  public abstract void onPhotoListDestroy();
  
  public abstract void onPhotoPreviewDestroy();
  
  public abstract void onResume();
  
  public abstract void setData(List<SlideItemInfo> paramList);
  
  public abstract void setPhotoListController();
  
  public abstract void setPhotoPreviewController();
  
  public abstract void setTemp(List<SlideItemInfo> paramList);
  
  public abstract void updatePhotoPreviewSelectUI(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqslideshow.ISlideShowController
 * JD-Core Version:    0.7.0.1
 */