package com.tencent.mtt.tkd.views.list;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.list.HippyListView;
import com.tencent.mtt.hippy.views.list.HippyListViewController;

@HippyController(name="tkdListView")
public class TkdListViewController
  extends HippyListViewController
{
  public static final String CLASS_NAME = "tkdListView";
  private static final String SCROLL_TO_POSITION = "scrollToPosition";
  
  public View createViewImpl(Context paramContext)
  {
    return new TkdListView(paramContext);
  }
  
  public View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    int j = 1;
    int i = j;
    if (paramHippyMap != null) {
      if ((!paramHippyMap.containsKey("direction")) || (!paramHippyMap.getString("direction").equals("horizontal")))
      {
        i = j;
        if (!paramHippyMap.containsKey("horizontal")) {}
      }
      else
      {
        i = 0;
      }
    }
    return new TkdListView(paramContext, i);
  }
  
  public void dispatchFunction(HippyListView paramHippyListView, String paramString, HippyArray paramHippyArray)
  {
    super.dispatchFunction(paramHippyListView, paramString, paramHippyArray);
    if ((!TextUtils.isEmpty(paramString)) && ((paramHippyListView instanceof TkdListView)) && (paramString.equals("loadMoreFinish"))) {
      ((TkdListView)paramHippyListView).setIsLoading(false);
    }
  }
  
  public void dispatchFunction(HippyListView paramHippyListView, String paramString, HippyArray paramHippyArray, Promise paramPromise)
  {
    int i = 0;
    super.dispatchFunction(paramHippyListView, paramString, paramHippyArray, paramPromise);
    int j;
    if (((paramHippyListView instanceof TkdListView)) && (TextUtils.equals("scrollToPosition", paramString)))
    {
      if ((paramHippyArray == null) || (paramHippyArray.size() <= 0)) {
        break label127;
      }
      paramString = paramHippyArray.getMap(0);
      if (paramString == null) {
        break label145;
      }
      j = (int)PixelUtil.dp2px(paramString.getInt("distance"));
      i = paramString.getInt("duration");
    }
    for (;;)
    {
      paramString = "";
      if (j != 0) {
        ((TkdListView)paramHippyListView).scrollWithDistance(j, i, paramPromise);
      }
      for (;;)
      {
        if ((!TextUtils.isEmpty(paramString)) && (paramPromise != null))
        {
          paramHippyListView = new HippyMap();
          paramHippyListView.pushString("msg", paramString);
          paramPromise.resolve(paramHippyListView);
        }
        return;
        label127:
        j = 0;
        paramString = "invalid parameter!";
        i = 0;
        break;
        paramString = "invalid distance parameter!";
      }
      label145:
      j = 0;
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="preloadDistance")
  public void setPreloadDistance(HippyListView paramHippyListView, int paramInt)
  {
    if ((paramHippyListView instanceof TkdListView)) {
      ((TkdListView)paramHippyListView).setPreloadDistance(paramInt);
    }
  }
  
  @HippyControllerProps(defaultNumber=0.0D, defaultType="number", name="scrollMinOffset")
  public void setScrollMinOffset(HippyListView paramHippyListView, int paramInt)
  {
    if ((paramHippyListView instanceof TkdListView)) {
      ((TkdListView)paramHippyListView).setScrollMinOffset(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.tkd.views.list.TkdListViewController
 * JD-Core Version:    0.7.0.1
 */