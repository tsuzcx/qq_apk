package com.tencent.viola.ui.dom;

import android.text.TextUtils;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.utils.ViolaUtils;
import java.util.ArrayList;
import org.json.JSONObject;

public class DomObjectWaterfallList
  extends DomObject
{
  private int mCellWidth;
  private int mColumn = 1;
  private int[] mInsetArry = new int[4];
  private int mItemSpacing;
  private int mLineSpacing;
  
  public int getCellWidth()
  {
    return this.mCellWidth;
  }
  
  public int getColumn()
  {
    return this.mColumn;
  }
  
  public int[] getInsetArry()
  {
    return this.mInsetArry;
  }
  
  public int getItemSpacing()
  {
    return this.mItemSpacing;
  }
  
  public int getLineSpacing()
  {
    return this.mLineSpacing;
  }
  
  public void layoutAfter()
  {
    super.layoutAfter();
    float f1 = ViolaUtils.getListContentWidth(this);
    float f2 = ViolaUtils.getListContentHeight(this);
    if (((this.mLastLayoutWidth != f1) || (this.mLastLayoutHeight != f2)) && (getEvents().contains("contentSizeChanged")))
    {
      ViolaUtils.fireContentSizeChange(this, f1, f2);
      this.mLastLayoutWidth = f1;
      this.mLastLayoutHeight = f2;
    }
  }
  
  public void parseFromJson(JSONObject paramJSONObject)
  {
    super.parseFromJson(paramJSONObject);
    if (getAttributes().containsKey("column"))
    {
      paramJSONObject = getAttributes().get("column");
      if ((paramJSONObject instanceof Integer)) {
        this.mColumn = ((Integer)paramJSONObject).intValue();
      } else {
        this.mColumn = Integer.valueOf((String)paramJSONObject).intValue();
      }
    }
    if (getAttributes().containsKey("lineSpacing"))
    {
      paramJSONObject = (String)getAttributes().get("lineSpacing");
      if (!TextUtils.isEmpty(paramJSONObject)) {
        this.mLineSpacing = ((int)FlexConvertUtils.converPxByViewportToRealPx(paramJSONObject, 750));
      }
    }
    if (getAttributes().containsKey("itemSpacing"))
    {
      paramJSONObject = (String)getAttributes().get("itemSpacing");
      if (!TextUtils.isEmpty(paramJSONObject)) {
        this.mItemSpacing = ((int)FlexConvertUtils.converPxByViewportToRealPx(paramJSONObject, 750));
      }
    }
    if (getAttributes().containsKey("inset"))
    {
      paramJSONObject = (String)getAttributes().get("inset");
      if (!TextUtils.isEmpty(paramJSONObject))
      {
        paramJSONObject = paramJSONObject.substring(1, paramJSONObject.length() - 1);
        if (!TextUtils.isEmpty(paramJSONObject)) {
          this.mInsetArry = FlexConvertUtils.converStringArrayToIntArray(paramJSONObject);
        }
      }
    }
    int i = FlexConvertUtils.getScreenWidth();
    paramJSONObject = this.mInsetArry;
    int j = paramJSONObject[3];
    int k = paramJSONObject[1];
    int m = this.mColumn;
    this.mCellWidth = ((i - j - k - (m - 1) * this.mItemSpacing) / m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.viola.ui.dom.DomObjectWaterfallList
 * JD-Core Version:    0.7.0.1
 */