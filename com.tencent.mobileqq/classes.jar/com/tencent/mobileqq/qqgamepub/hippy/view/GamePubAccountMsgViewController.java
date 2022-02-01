package com.tencent.mobileqq.qqgamepub.hippy.view;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.uimanager.HippyViewController;

@HippyController(name="gpHeaderView")
public class GamePubAccountMsgViewController
  extends HippyViewController<GamePubAccountHeadView>
{
  public static final String CLASS_NAME = "gpHeaderView";
  
  protected View createViewImpl(Context paramContext)
  {
    return new GamePubAccountHeadView(paramContext);
  }
  
  protected View createViewImpl(Context paramContext, HippyMap paramHippyMap)
  {
    return new GamePubAccountHeadView(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.view.GamePubAccountMsgViewController
 * JD-Core Version:    0.7.0.1
 */