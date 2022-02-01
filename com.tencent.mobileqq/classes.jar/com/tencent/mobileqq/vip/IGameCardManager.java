package com.tencent.mobileqq.vip;

import android.content.Context;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.vas.api.IVasManager;

public abstract interface IGameCardManager
  extends IVasManager
{
  public static final String AIO = "qunliao";
  public static final String CARD = "ziliaoka";
  public static final String DRAWER = "choutiye";
  public static final int EXT_ICON = 2;
  public static final int ICON = 1;
  public static final String LIST = "list";
  public static final String OWNER = "owner";
  public static final int QQSETTING_ICON_HEIGHT = 15;
  public static final int QQSETTING_ICON_MARGIN = 5;
  public static final int QQSETTING_ICON_WIDTH = 47;
  public static final String VISITOR = "visitor";
  
  public abstract boolean checkGameCardAble(boolean paramBoolean, int paramInt);
  
  public abstract String getCardResPath(int paramInt1, int paramInt2);
  
  public abstract URLDrawable getGameCardDrawable(boolean paramBoolean, IGameCardManager.GameCardInfo paramGameCardInfo, IGameCardManager.OnResultCallBack paramOnResultCallBack);
  
  public abstract void gotoGameIconSetWeb(Context paramContext, String paramString, boolean paramBoolean, int paramInt);
  
  public abstract void gotoKingIconSetWeb(Context paramContext);
  
  public abstract boolean isSelf(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vip.IGameCardManager
 * JD-Core Version:    0.7.0.1
 */