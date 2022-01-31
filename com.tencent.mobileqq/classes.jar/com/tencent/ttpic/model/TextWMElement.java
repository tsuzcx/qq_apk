package com.tencent.ttpic.model;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.ttpic.logic.watermark.LogicDataManager;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.WMTextDrawer;

public class TextWMElement
  extends WMElement
{
  public RectF mTextRect = new RectF();
  public WMTextDrawer wmTextDrawer = new WMTextDrawer();
  
  private String getValue()
  {
    if ((!TextUtils.isEmpty(this.userValue)) && (!isDateWatermark())) {
      return this.userValue;
    }
    String str1 = "";
    if (this.fmtstr != null) {
      str1 = new String(this.fmtstr);
    }
    String str2 = str1;
    if (this.logic != null) {
      str2 = str1.replace("[logic]", this.logic.getValue(this.userValue));
    }
    BenchUtil.benchStart("replaceWithData");
    str1 = LogicDataManager.getInstance().replaceWithData(str2, this.dataKeys);
    BenchUtil.benchEnd("replaceWithData");
    return str1;
  }
  
  private boolean isDateWatermark()
  {
    return (this.logic != null) && (this.logic.type != null) && ((this.logic.type.equals("since")) || (this.logic.type.equals("countdown")));
  }
  
  public Bitmap getBitmap()
  {
    this.lastValue = this.curValue;
    return super.getBitmap();
  }
  
  public RectF getTextRect()
  {
    return this.mTextRect;
  }
  
  public void init()
  {
    super.init();
    this.curValue = getValue();
  }
  
  public void updateBitmap(long paramLong)
  {
    BenchUtil.benchStart("TextUpdateBitmap");
    this.curValue = getValue();
    if (needUpdate()) {
      this.wmTextDrawer.drawTextToBitmap(this, this.curValue);
    }
    BenchUtil.benchEnd("TextUpdateBitmap");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.model.TextWMElement
 * JD-Core Version:    0.7.0.1
 */