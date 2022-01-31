package com.tencent.ttpic.openapi.model;

import android.graphics.Bitmap;
import android.graphics.RectF;
import android.text.TextUtils;
import com.tencent.ttpic.openapi.util.WMTextDrawer;
import com.tencent.ttpic.openapi.watermark.LogicDataManager;
import java.util.HashMap;

public class TextWMElement
  extends WMElement
{
  protected static final String INT_D = "%d";
  private long firstTimestamp;
  public boolean isLocalFont = true;
  public RectF mTextRect = new RectF();
  public int rotate = 0;
  private long timestamp;
  public WMTextDrawer wmTextDrawer = new WMTextDrawer();
  
  public TextWMElement() {}
  
  public TextWMElement(WMElementConfig paramWMElementConfig)
  {
    super(paramWMElementConfig);
  }
  
  private boolean isDateWatermark()
  {
    return (this.logic != null) && (this.logic.type != null) && ((this.logic.type.equals("since")) || (this.logic.type.equals("countdown")));
  }
  
  private boolean needUpdateTextBitmap(boolean paramBoolean)
  {
    return (!TextUtils.isEmpty(this.curValue)) && ((paramBoolean) || (!this.curValue.equals(this.lastValue)) || ((!TextUtils.isEmpty(this.curValue.trim())) && (!TextUtils.isEmpty(this.animateType))));
  }
  
  private boolean needUpdateTextShaderBmp(long paramLong)
  {
    return updateTextShaderBmp(paramLong);
  }
  
  public Bitmap getBitmap()
  {
    setContentChanged(false);
    return super.getBitmap();
  }
  
  public int getFrameIndex()
  {
    if (this.firstTimestamp <= 0L) {
      this.firstTimestamp = this.timestamp;
    }
    if (this.frames <= 0) {
      return 0;
    }
    return (int)((this.timestamp - this.firstTimestamp) / this.frameDuration) % this.frames;
  }
  
  public RectF getTextRect()
  {
    return this.mTextRect;
  }
  
  public String getValue()
  {
    if (this.ischeckin)
    {
      localObject1 = "";
      if (this.fmtstr != null) {
        localObject1 = new String(this.fmtstr);
      }
      localObject3 = localObject1;
      if (this.logic != null)
      {
        localObject3 = ((String)localObject1).replace("[logic]", this.logic.getValue(this.userValue, this));
        LogicDataManager.getInstance().mFollowData.put(this.id, String.valueOf(this.logic.getDays()));
      }
      localObject1 = LogicDataManager.getInstance().replaceWithData((String)localObject3, this.dataKeys, this);
      return String.valueOf(this.checkinDays) + (String)localObject1;
    }
    if ((this.userValue != null) && (!this.userValue.equals("")) && (!isDateWatermark())) {
      return this.userValue;
    }
    Object localObject3 = "";
    Object localObject1 = localObject3;
    if ((this.fmtstr == null) || ((this.numberSource != null) && (!this.numberSource.equals("")))) {}
    for (;;)
    {
      try
      {
        int i = Integer.parseInt((String)LogicDataManager.getInstance().mFollowData.get(this.numberSource));
        if (((!this.showCaseMin.equals("")) || (!this.showCaseMax.equals(""))) && ((i < Integer.parseInt(this.showCaseMin)) || (i > Integer.parseInt(this.showCaseMax)))) {
          break label349;
        }
        localObject1 = new String(this.fmtstr);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
        localObject2 = localObject3;
        continue;
      }
      localObject3 = localObject1;
      if (this.logic != null)
      {
        localObject3 = ((String)localObject1).replace("[logic]", this.logic.getValue(this.userValue, this));
        LogicDataManager.getInstance().mFollowData.put(this.id, String.valueOf(this.logic.getDays()));
      }
      return LogicDataManager.getInstance().replaceWithData((String)localObject3, this.dataKeys, this);
      Object localObject2 = new String(this.fmtstr);
      continue;
      label349:
      localObject2 = "";
    }
  }
  
  public void init()
  {
    super.init();
    if (this.vertical == 2) {
      this.rotate = 90;
    }
    for (;;)
    {
      this.curValue = getValue();
      if ((this.logic == null) && (!this.ischeckin)) {
        LogicDataManager.getInstance().mFollowData.put(this.id, this.curValue);
      }
      return;
      if (this.vertical == 3) {
        this.rotate = -90;
      }
    }
  }
  
  public boolean isAsyncDrawFinished()
  {
    return this.wmTextDrawer.isAsyncDrawFinished();
  }
  
  public void reset()
  {
    this.lastValue = "";
    this.curValue = "";
    this.wmTextDrawer.cancelAsyncDrawTask();
    setContentChanged(false);
  }
  
  public boolean updateBitmap(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    this.timestamp = paramLong;
    if (!isAsyncDrawFinished()) {
      return false;
    }
    this.curValue = getValue();
    if (needUpdateTextBitmap(paramBoolean1))
    {
      this.wmTextDrawer.drawTextToBitmap(this, this.curValue, false, paramBoolean2);
      this.firstDrew = true;
    }
    for (paramBoolean1 = bool;; paramBoolean1 = false)
    {
      this.lastValue = this.curValue;
      return paramBoolean1;
      if ((!TextUtils.isEmpty(this.shaderBmp)) && (!TextUtils.isEmpty(this.wmTextDrawer.lastDrawText))) {
        this.wmTextDrawer.drawTextToBitmap(this, this.lastValue, true, paramBoolean2);
      }
    }
  }
  
  public boolean updateTextShaderBmp(long paramLong)
  {
    if ((this.shaderBmp == null) || (!isAsyncDrawFinished())) {}
    String str;
    do
    {
      return false;
      this.timestamp = paramLong;
      str = this.shaderBmp.replace("%d", String.valueOf(getFrameIndex()));
    } while ((TextUtils.isEmpty(str)) || (str.equals(this.curShaderBmp)));
    this.wmTextDrawer.drawTextToBitmap(this, this.lastValue, true, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.openapi.model.TextWMElement
 * JD-Core Version:    0.7.0.1
 */