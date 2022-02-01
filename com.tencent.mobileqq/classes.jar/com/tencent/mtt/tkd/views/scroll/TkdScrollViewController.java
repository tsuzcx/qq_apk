package com.tencent.mtt.tkd.views.scroll;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewController;

@HippyController(name="tkdScrollView")
public class TkdScrollViewController
  extends HippyScrollViewController
{
  public static final String CLASS_NAME = "tkdScrollView";
  private static final String LOAD_MORE_FINISH = "loadMoreFinish";
  private static final String SCROLL_TO_POSITION = "scrollToPosition";
  private static final String SCROLL_TO_TOP = "scrollToTop";
  
  public View createViewImpl(Context paramContext)
  {
    return null;
  }
  
  public View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    if ((paramHippyMap != null) && (paramHippyMap.containsKey("horizontal"))) {
      return new TkdHorizontalScrollView(paramContext);
    }
    return new TkdVerticalScrollView(paramContext);
  }
  
  public void dispatchFunction(View paramView, String paramString, HippyArray paramHippyArray)
  {
    super.dispatchFunction(paramView, paramString, paramHippyArray);
    int i;
    int j;
    if ((paramView instanceof TkdScrollView))
    {
      if (!TextUtils.equals("scrollTo", paramString)) {
        break label81;
      }
      i = Math.round(PixelUtil.dp2px(paramHippyArray.getDouble(0)));
      j = Math.round(PixelUtil.dp2px(paramHippyArray.getDouble(1)));
      if (!paramHippyArray.getBoolean(2)) {
        break label72;
      }
      ((TkdScrollView)paramView).callSmoothScrollTo(i, j, 0);
    }
    label72:
    label81:
    do
    {
      return;
      paramView.scrollTo(i, j);
      return;
      if (TextUtils.equals("loadMoreFinish", paramString))
      {
        ((TkdScrollView)paramView).callLoadMoreFinish();
        return;
      }
    } while (!TextUtils.equals("scrollToTop", paramString));
    boolean bool = paramHippyArray.getBoolean(0);
    ((TkdScrollView)paramView).callScrollToTop(bool);
  }
  
  public void dispatchFunction(View paramView, String paramString, HippyArray paramHippyArray, Promise paramPromise)
  {
    int i = 0;
    super.dispatchFunction(paramView, paramString, paramHippyArray, paramPromise);
    int j;
    if (((paramView instanceof TkdScrollView)) && (TextUtils.equals("scrollToPosition", paramString)))
    {
      if ((paramHippyArray == null) || (paramHippyArray.size() <= 0)) {
        break label129;
      }
      paramString = paramHippyArray.getMap(0);
      if (paramString == null) {
        break label147;
      }
      j = (int)PixelUtil.dp2px(paramString.getInt("distance"));
      i = paramString.getInt("duration");
    }
    for (;;)
    {
      paramString = "";
      if (j != 0) {
        ((TkdScrollView)paramView).callScrollToPosition(j, i, paramPromise);
      }
      for (;;)
      {
        if ((!TextUtils.isEmpty(paramString)) && (paramPromise != null))
        {
          paramView = new HippyMap();
          paramView.pushString("msg", paramString);
          paramPromise.resolve(paramView);
        }
        return;
        label129:
        j = 0;
        paramString = "invalid parameter!";
        i = 0;
        break;
        paramString = "invalid distance parameter!";
      }
      label147:
      j = 0;
    }
  }
  
  @HippyControllerProps(defaultNumber=200.0D, defaultType="number", name="preloadDistance")
  public void setPreloadDistance(TkdScrollView paramTkdScrollView, int paramInt)
  {
    paramTkdScrollView.setPreloadDistance(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.tkd.views.scroll.TkdScrollViewController
 * JD-Core Version:    0.7.0.1
 */