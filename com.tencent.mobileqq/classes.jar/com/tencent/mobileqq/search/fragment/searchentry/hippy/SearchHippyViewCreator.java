package com.tencent.mobileqq.search.fragment.searchentry.hippy;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.hippy.qq.view.tkd.image.HippyTKDGifImageView;
import com.tencent.hippy.qq.view.tkd.image.HippyTKDImageView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListView;
import com.tencent.hippy.qq.view.tkd.text.HippyTKDTextView;
import com.tencent.hippy.qq.view.tkd.view.HippyTKDViewGroup;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;

public class SearchHippyViewCreator
  implements HippyCustomViewCreator
{
  public View createCustomView(String paramString, Context paramContext, HippyMap paramHippyMap)
  {
    if (TextUtils.equals("ListView", paramString)) {
      return new HippyTKDListView(paramContext);
    }
    if (TextUtils.equals("Text", paramString)) {
      return new HippyTKDTextView(paramContext);
    }
    if (TextUtils.equals("View", paramString)) {
      return new HippyTKDViewGroup(paramContext);
    }
    if (TextUtils.equals("Image", paramString)) {
      return new HippyTKDImageView(paramContext);
    }
    if (TextUtils.equals("TKDGifImageView", paramString)) {
      return new HippyTKDGifImageView(paramContext);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.fragment.searchentry.hippy.SearchHippyViewCreator
 * JD-Core Version:    0.7.0.1
 */