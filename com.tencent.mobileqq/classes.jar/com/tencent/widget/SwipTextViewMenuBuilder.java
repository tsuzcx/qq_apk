package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;

public abstract class SwipTextViewMenuBuilder
  extends SwipRightMenuBuilder
{
  public static final int TAG_MENU_STR_ID = -2;
  public static final int TAG_POSITION = -1;
  public static final String TAG_SWIP_ICON_MENU_ITEM = "tag_swip_icon_menu_item";
  protected final int[] MENU_BG_IDS;
  protected final int MENU_HEIGHT;
  protected final int[] MENU_IDS;
  protected final int[] MENU_STR_IDS;
  protected final int[] MENU_WIDTH;
  
  public SwipTextViewMenuBuilder(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    super(paramInt1, paramInt2);
    this.MENU_WIDTH = paramArrayOfInt1;
    this.MENU_HEIGHT = paramInt3;
    this.MENU_IDS = paramArrayOfInt2;
    this.MENU_STR_IDS = paramArrayOfInt3;
    this.MENU_BG_IDS = paramArrayOfInt4;
  }
  
  public View createRightMenuItem(Context paramContext, int paramInt)
  {
    paramContext = new SimpleTextView(paramContext);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(this.MENU_WIDTH[paramInt], this.MENU_HEIGHT));
    paramContext.setGravity(17);
    paramContext.setTextSize(16.0F);
    paramContext.setTextColor(-1);
    return paramContext;
  }
  
  public View updateRightMenuItem(int paramInt, Object paramObject, SwipRightMenuBuilder.SwipRightMenuItem paramSwipRightMenuItem, View.OnClickListener paramOnClickListener)
  {
    Object localObject2 = null;
    paramObject = null;
    Object localObject1 = localObject2;
    if (paramSwipRightMenuItem != null)
    {
      localObject1 = localObject2;
      if (paramSwipRightMenuItem.menuType >= 0)
      {
        if (paramSwipRightMenuItem.menuId < 0) {
          return null;
        }
        if ((paramSwipRightMenuItem.menuView instanceof SimpleTextView)) {
          paramObject = (SimpleTextView)paramSwipRightMenuItem.menuView;
        }
        int i = this.MENU_STR_IDS[paramSwipRightMenuItem.menuId];
        int j = this.MENU_BG_IDS[paramSwipRightMenuItem.menuId];
        int k = this.MENU_IDS[paramSwipRightMenuItem.menuId];
        localObject1 = paramObject;
        if (paramObject != null)
        {
          paramObject.setVisibility(0);
          paramObject.setText(paramObject.getContext().getResources().getString(i));
          paramObject.setBackgroundResource(j);
          paramObject.setId(k);
          paramObject.setTag("tag_swip_icon_menu_item");
          paramObject.setTag(-2, Integer.valueOf(i));
          paramObject.setTag(-1, Integer.valueOf(paramInt));
          paramObject.setContentDescription(paramObject.getResources().getString(i));
          paramObject.setOnClickListener(paramOnClickListener);
          paramSwipRightMenuItem.menuWidth = this.MENU_WIDTH[paramSwipRightMenuItem.menuType];
          paramSwipRightMenuItem.menuHeight = this.MENU_HEIGHT;
          localObject1 = paramObject;
        }
      }
    }
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.SwipTextViewMenuBuilder
 * JD-Core Version:    0.7.0.1
 */