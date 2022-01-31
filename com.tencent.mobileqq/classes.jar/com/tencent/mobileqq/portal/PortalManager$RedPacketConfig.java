package com.tencent.mobileqq.portal;

import java.io.Serializable;
import java.util.ArrayList;

public class PortalManager$RedPacketConfig
  implements Serializable
{
  public ArrayList bannerConfigs = new ArrayList();
  public ArrayList comboNumberConfigs = new ArrayList();
  public long grebInterval = -1L;
  public int id;
  public long lastGrabTime;
  public ArrayList portalConfigs = new ArrayList();
  public long reportActiveInterval = -1L;
  public long reportNormalInterval = -1L;
  public int shareBaseLine;
  public long showGesturesTime;
  public int taskId;
  public int version;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shareBaseLine=").append(this.shareBaseLine);
    localStringBuilder.append(", portalConfigs=").append(this.portalConfigs);
    localStringBuilder.append(", comboNumberConfigs=").append(this.comboNumberConfigs);
    localStringBuilder.append(", bannerConfigs=").append(this.bannerConfigs);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager.RedPacketConfig
 * JD-Core Version:    0.7.0.1
 */