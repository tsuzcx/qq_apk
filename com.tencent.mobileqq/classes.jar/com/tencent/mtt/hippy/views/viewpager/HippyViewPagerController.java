package com.tencent.mtt.hippy.views.viewpager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.utils.PixelUtil;

@HippyController(name="ViewPager")
public class HippyViewPagerController
  extends HippyViewController<HippyViewPager>
{
  public static final String CLASS_NAME = "ViewPager";
  private static final String FUNC_NEXT_PAGE = "next";
  private static final String FUNC_PREV_PAGE = "prev";
  private static final String FUNC_SET_INDEX = "setIndex";
  private static final String FUNC_SET_PAGE = "setPage";
  private static final String FUNC_SET_PAGE_WITHOUT_ANIM = "setPageWithoutAnimation";
  private static final String TAG = "HippyViewPagerController";
  
  protected void addView(ViewGroup paramViewGroup, View paramView, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addView: ");
    localStringBuilder.append(paramViewGroup.hashCode());
    localStringBuilder.append(", index=");
    localStringBuilder.append(paramInt);
    LogUtils.d("HippyViewPagerController", localStringBuilder.toString());
    if (((paramViewGroup instanceof HippyViewPager)) && ((paramView instanceof HippyViewPagerItem)))
    {
      ((HippyViewPager)paramViewGroup).addViewToAdapter((HippyViewPagerItem)paramView, paramInt);
      return;
    }
    LogUtils.e("HippyViewPagerController", "add view got invalid params");
  }
  
  protected View createViewImpl(Context paramContext)
  {
    return new HippyViewPager(paramContext);
  }
  
  protected View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    boolean bool;
    if ((paramHippyMap != null) && (((paramHippyMap.containsKey("direction")) && (paramHippyMap.getString("direction").equals("vertical"))) || (paramHippyMap.containsKey("vertical")))) {
      bool = true;
    } else {
      bool = false;
    }
    return new HippyViewPager(paramContext, bool);
  }
  
  protected void deleteChild(ViewGroup paramViewGroup, View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("deleteChild: ");
    localStringBuilder.append(paramViewGroup.hashCode());
    LogUtils.d("HippyViewPagerController", localStringBuilder.toString());
    if (((paramViewGroup instanceof HippyViewPager)) && ((paramView instanceof HippyViewPagerItem)))
    {
      ((HippyViewPager)paramViewGroup).removeViewFromAdapter((HippyViewPagerItem)paramView);
      return;
    }
    LogUtils.e("HippyViewPagerController", "delete view got invalid params");
  }
  
  public void dispatchFunction(HippyViewPager paramHippyViewPager, String paramString, HippyArray paramHippyArray)
  {
    if (paramHippyViewPager == null) {
      return;
    }
    int j = paramHippyViewPager.getCurrentItem();
    int i = -1;
    int k = paramString.hashCode();
    boolean bool = false;
    switch (k)
    {
    default: 
      break;
    case 1984860689: 
      if (paramString.equals("setPage")) {
        i = 0;
      }
      break;
    case 1395059088: 
      if (paramString.equals("setIndex")) {
        i = 2;
      }
      break;
    case 3449395: 
      if (paramString.equals("prev")) {
        i = 4;
      }
      break;
    case 3377907: 
      if (paramString.equals("next")) {
        i = 3;
      }
      break;
    case -445763635: 
      if (paramString.equals("setPageWithoutAnimation")) {
        i = 1;
      }
      break;
    }
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4) {
              return;
            }
            if (j <= 0) {
              return;
            }
            i = j - 1;
          }
          else
          {
            if (j >= paramHippyViewPager.getAdapter().getCount() - 1) {
              return;
            }
            i = j + 1;
          }
          paramHippyViewPager.switchToPage(i, true);
        }
        else if ((paramHippyArray != null) && (paramHippyArray.size() > 0))
        {
          paramString = paramHippyArray.getMap(0);
          if ((paramString != null) && (paramString.size() > 0) && (paramString.containsKey("index")))
          {
            i = paramString.getInt("index");
            if ((!paramString.containsKey("animated")) || (paramString.getBoolean("animated"))) {
              bool = true;
            }
            paramHippyViewPager.switchToPage(i, bool);
          }
        }
      }
      else if (paramHippyArray != null)
      {
        paramString = paramHippyArray.get(0);
        if ((paramString instanceof Integer)) {
          paramHippyViewPager.switchToPage(((Integer)paramString).intValue(), false);
        }
      }
    }
    else if (paramHippyArray != null)
    {
      paramString = paramHippyArray.get(0);
      if ((paramString instanceof Integer)) {
        paramHippyViewPager.switchToPage(((Integer)paramString).intValue(), true);
      }
    }
  }
  
  public void dispatchFunction(HippyViewPager paramHippyViewPager, String paramString, HippyArray paramHippyArray, Promise paramPromise)
  {
    if (paramHippyViewPager == null) {
      return;
    }
    int i = -1;
    int j = paramString.hashCode();
    boolean bool = false;
    if ((j == 1395059088) && (paramString.equals("setIndex"))) {
      i = 0;
    }
    if (i != 0) {
      return;
    }
    if ((paramHippyArray != null) && (paramHippyArray.size() > 0))
    {
      paramString = paramHippyArray.getMap(0);
      if ((paramString != null) && (paramString.size() > 0) && (paramString.containsKey("index")))
      {
        i = paramString.getInt("index");
        if ((!paramString.containsKey("animated")) || (paramString.getBoolean("animated"))) {
          bool = true;
        }
        paramHippyViewPager.setCallBackPromise(paramPromise);
        paramHippyViewPager.switchToPage(i, bool);
        return;
      }
    }
    if (paramPromise != null)
    {
      paramHippyViewPager = new HippyMap();
      paramHippyViewPager.pushString("msg", "invalid parameter!");
      paramPromise.resolve(paramHippyViewPager);
    }
  }
  
  public View getChildAt(HippyViewPager paramHippyViewPager, int paramInt)
  {
    return paramHippyViewPager.getViewFromAdapter(paramInt);
  }
  
  public int getChildCount(HippyViewPager paramHippyViewPager)
  {
    return paramHippyViewPager.getAdapter().getCount();
  }
  
  protected void onManageChildComplete(HippyViewPager paramHippyViewPager)
  {
    paramHippyViewPager.setChildCountAndUpdate(paramHippyViewPager.getAdapter().getItemViewSize());
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="initialPage")
  public void setInitialPage(HippyViewPager paramHippyViewPager, int paramInt)
  {
    paramHippyViewPager.setInitialPageIndex(paramInt);
  }
  
  @HippyControllerProps(defaultString="visible", defaultType="string", name="overflow")
  public void setOverflow(HippyViewPager paramHippyViewPager, String paramString)
  {
    paramHippyViewPager.setOverflow(paramString);
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="pageMargin")
  public void setPageMargin(HippyViewPager paramHippyViewPager, float paramFloat)
  {
    paramHippyViewPager.setPageMargin((int)PixelUtil.dp2px(paramFloat));
  }
  
  @HippyControllerProps(defaultBoolean=true, defaultType="boolean", name="scrollEnabled")
  public void setScrollEnabled(HippyViewPager paramHippyViewPager, boolean paramBoolean)
  {
    paramHippyViewPager.setScrollEnabled(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.viewpager.HippyViewPagerController
 * JD-Core Version:    0.7.0.1
 */