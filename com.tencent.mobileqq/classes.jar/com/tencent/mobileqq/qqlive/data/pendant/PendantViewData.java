package com.tencent.mobileqq.qqlive.data.pendant;

import java.util.ArrayList;
import java.util.List;

public class PendantViewData
{
  public static final int PIC_URL_NUM_TYPE = 3;
  public static final int PIC_URL_TYPE = 2;
  public static final int UNKOWN_DEFAULT_TYPE = 0;
  public static final int UNVISIBLE = 0;
  public static final int VISIBLE = 1;
  public static final int WEBVIEW_TYPE = 1;
  public String businessData;
  public long maxUpdateDuration;
  public long minUpdateDuration;
  public List<PicPendantData> picInfos = new ArrayList();
  public String version;
  public float viewHeight;
  public long viewId;
  public long viewType;
  public float viewWidth;
  public long visible;
  public WebPendantData webPendantData;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PendantViewData{viewId=");
    localStringBuilder.append(this.viewId);
    localStringBuilder.append(", viewType=");
    localStringBuilder.append(this.viewType);
    localStringBuilder.append(", version='");
    localStringBuilder.append(this.version);
    localStringBuilder.append('\'');
    localStringBuilder.append(", visible=");
    localStringBuilder.append(this.visible);
    localStringBuilder.append(", minUpdateDuration=");
    localStringBuilder.append(this.minUpdateDuration);
    localStringBuilder.append(", maxUpdateDuration=");
    localStringBuilder.append(this.maxUpdateDuration);
    localStringBuilder.append(", viewWidth=");
    localStringBuilder.append(this.viewWidth);
    localStringBuilder.append(", viewHeight=");
    localStringBuilder.append(this.viewHeight);
    localStringBuilder.append(", webPendantBean=");
    localStringBuilder.append(this.webPendantData);
    localStringBuilder.append(", picInfos=");
    localStringBuilder.append(this.picInfos);
    localStringBuilder.append(", businessData='");
    localStringBuilder.append(this.businessData);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.pendant.PendantViewData
 * JD-Core Version:    0.7.0.1
 */