package com.tencent.qqmini.miniapp.action;

import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.CoverView;

@MiniKeep
public class CoverViewAction
  implements Action<Object>
{
  private static final int ADD_COVER_VIEW = 2;
  private static final int DEL_COVER_VIEW = 3;
  private static final int GET_COVER_VIEW = 1;
  private static final String TAG = "CoverViewAction";
  private static final int UNKNOWN_ACTION = 0;
  private int action = 0;
  private CoverView coverView;
  private int coverViewId;
  private boolean fixed;
  private IMiniAppContext miniAppContext;
  private int parentViewId;
  
  public static CoverViewAction obtain(IMiniAppContext paramIMiniAppContext)
  {
    CoverViewAction localCoverViewAction = new CoverViewAction();
    localCoverViewAction.miniAppContext = paramIMiniAppContext;
    return localCoverViewAction;
  }
  
  public boolean add(int paramInt1, int paramInt2, CoverView paramCoverView)
  {
    return add(paramInt1, paramInt2, paramCoverView, false);
  }
  
  public boolean add(int paramInt1, int paramInt2, CoverView paramCoverView, boolean paramBoolean)
  {
    this.action = 2;
    this.parentViewId = paramInt1;
    this.coverViewId = paramInt2;
    this.coverView = paramCoverView;
    this.fixed = paramBoolean;
    return Boolean.parseBoolean(this.miniAppContext.performAction(this).toString());
  }
  
  public boolean del(int paramInt)
  {
    this.action = 3;
    this.coverViewId = paramInt;
    return Boolean.parseBoolean(this.miniAppContext.performAction(this).toString());
  }
  
  public CoverView get(int paramInt)
  {
    this.action = 1;
    this.coverViewId = paramInt;
    return (CoverView)this.miniAppContext.performAction(this);
  }
  
  public Object perform(BaseRuntime paramBaseRuntime)
  {
    Object localObject = paramBaseRuntime.getPage();
    boolean bool = localObject instanceof AppBrandPageContainer;
    paramBaseRuntime = Boolean.valueOf(false);
    if (!bool)
    {
      QMLog.d("CoverViewAction", "Page is invalid");
      if (this.action == 1) {
        paramBaseRuntime = null;
      }
      return paramBaseRuntime;
    }
    localObject = (AppBrandPageContainer)localObject;
    int i = this.action;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          QMLog.e("CoverViewAction", "Unknown action");
          return paramBaseRuntime;
        }
        return Boolean.valueOf(((AppBrandPageContainer)localObject).removeCoverView(this.coverViewId));
      }
      return Boolean.valueOf(((AppBrandPageContainer)localObject).addCoverView(this.parentViewId, this.coverViewId, this.coverView, this.fixed));
    }
    return ((AppBrandPageContainer)localObject).getCoverView(this.coverViewId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.action.CoverViewAction
 * JD-Core Version:    0.7.0.1
 */