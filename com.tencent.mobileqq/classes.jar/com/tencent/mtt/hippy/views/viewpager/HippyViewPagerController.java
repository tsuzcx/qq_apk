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
  
  public void addView(ViewGroup paramViewGroup, View paramView, int paramInt)
  {
    LogUtils.d("HippyViewPagerController", "addView: " + paramViewGroup.hashCode() + ", index=" + paramInt);
    if (((paramViewGroup instanceof HippyViewPager)) && ((paramView instanceof HippyViewPagerItem)))
    {
      ((HippyViewPager)paramViewGroup).addViewToAdapter((HippyViewPagerItem)paramView, paramInt);
      return;
    }
    LogUtils.e("HippyViewPagerController", "add view got invalid params");
  }
  
  public View createViewImpl(Context paramContext)
  {
    return new HippyViewPager(paramContext);
  }
  
  public View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramHippyMap != null) {
      if ((!paramHippyMap.containsKey("direction")) || (!paramHippyMap.getString("direction").equals("vertical")))
      {
        bool1 = bool2;
        if (!paramHippyMap.containsKey("vertical")) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return new HippyViewPager(paramContext, bool1);
  }
  
  public void deleteChild(ViewGroup paramViewGroup, View paramView)
  {
    LogUtils.d("HippyViewPagerController", "deleteChild: " + paramViewGroup.hashCode());
    if (((paramViewGroup instanceof HippyViewPager)) && ((paramView instanceof HippyViewPagerItem)))
    {
      ((HippyViewPager)paramViewGroup).removeViewFromAdapter((HippyViewPagerItem)paramView);
      return;
    }
    LogUtils.e("HippyViewPagerController", "delete view got invalid params");
  }
  
  public void dispatchFunction(HippyViewPager paramHippyViewPager, String paramString, HippyArray paramHippyArray)
  {
    if (paramHippyViewPager == null) {}
    label4:
    int j;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                j = paramHippyViewPager.getCurrentItem();
                i = -1;
                switch (paramString.hashCode())
                {
                }
                for (;;)
                {
                  switch (i)
                  {
                  default: 
                    return;
                  case 0: 
                    if (paramHippyArray == null) {
                      break label4;
                    }
                    paramString = paramHippyArray.get(0);
                    if (!(paramString instanceof Integer)) {
                      break label4;
                    }
                    paramHippyViewPager.switchToPage(((Integer)paramString).intValue(), true);
                    return;
                    if (paramString.equals("setPage"))
                    {
                      i = 0;
                      continue;
                      if (paramString.equals("setPageWithoutAnimation"))
                      {
                        i = 1;
                        continue;
                        if (paramString.equals("setIndex"))
                        {
                          i = 2;
                          continue;
                          if (paramString.equals("next"))
                          {
                            i = 3;
                            continue;
                            if (paramString.equals("prev")) {
                              i = 4;
                            }
                          }
                        }
                      }
                    }
                    break;
                  }
                }
              } while (paramHippyArray == null);
              paramString = paramHippyArray.get(0);
            } while (!(paramString instanceof Integer));
            paramHippyViewPager.switchToPage(((Integer)paramString).intValue(), false);
            return;
          } while ((paramHippyArray == null) || (paramHippyArray.size() <= 0));
          paramString = paramHippyArray.getMap(0);
        } while ((paramString == null) || (paramString.size() <= 0) || (!paramString.containsKey("index")));
        int i = paramString.getInt("index");
        if (paramString.containsKey("animated")) {}
        for (boolean bool = paramString.getBoolean("animated");; bool = true)
        {
          paramHippyViewPager.switchToPage(i, bool);
          return;
        }
      } while (j >= paramHippyViewPager.getAdapter().getCount() - 1);
      paramHippyViewPager.switchToPage(j + 1, true);
      return;
    } while (j <= 0);
    paramHippyViewPager.switchToPage(j - 1, true);
  }
  
  public void dispatchFunction(HippyViewPager paramHippyViewPager, String paramString, HippyArray paramHippyArray, Promise paramPromise)
  {
    if (paramHippyViewPager == null) {}
    do
    {
      return;
      int i = -1;
      switch (paramString.hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          return;
        }
        if ((paramHippyArray == null) || (paramHippyArray.size() <= 0)) {
          continue;
        }
        paramString = paramHippyArray.getMap(0);
        if ((paramString == null) || (paramString.size() <= 0) || (!paramString.containsKey("index"))) {
          continue;
        }
        i = paramString.getInt("index");
        if (!paramString.containsKey("animated")) {
          break;
        }
      }
      for (boolean bool = paramString.getBoolean("animated");; bool = true)
      {
        paramHippyViewPager.setCallBackPromise(paramPromise);
        paramHippyViewPager.switchToPage(i, bool);
        return;
        if (!paramString.equals("setIndex")) {
          break;
        }
        i = 0;
        break;
      }
    } while (paramPromise == null);
    paramHippyViewPager = new HippyMap();
    paramHippyViewPager.pushString("msg", "invalid parameter!");
    paramPromise.resolve(paramHippyViewPager);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.views.viewpager.HippyViewPagerController
 * JD-Core Version:    0.7.0.1
 */