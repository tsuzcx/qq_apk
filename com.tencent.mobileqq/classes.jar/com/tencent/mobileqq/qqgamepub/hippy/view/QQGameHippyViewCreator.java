package com.tencent.mobileqq.qqgamepub.hippy.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyCustomViewCreator;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerViewController;
import com.tencent.mtt.hippy.views.hippylist.HippyRecyclerViewWrapper;

public class QQGameHippyViewCreator
  implements HippyCustomViewCreator
{
  public View createCustomView(String paramString, Context paramContext, HippyMap paramHippyMap)
  {
    if (TextUtils.equals("RecyclerView", paramString)) {
      return new HippyRecyclerViewWrapper(paramContext, HippyRecyclerViewController.initDefault(paramContext, paramHippyMap, new QQGameHippyRecyclerView(paramContext)));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.view.QQGameHippyViewCreator
 * JD-Core Version:    0.7.0.1
 */