package com.tencent.mobileqq.portal;

import java.io.Serializable;
import java.util.ArrayList;

public class PortalManager$RedPacketConfig
  implements Serializable
{
  public ArrayList<PortalManager.BannerConfig> bannerConfigs = new ArrayList();
  public ArrayList<PortalManager.ComboNumber> comboNumberConfigs = new ArrayList();
  public long grebInterval = -1L;
  public int id;
  public long lastGrabTime = 0L;
  public ArrayList<PortalManager.PortalConfig> portalConfigs = new ArrayList();
  public long reportActiveInterval = -1L;
  public long reportNormalInterval = -1L;
  public int shareBaseLine;
  public long showGesturesTime = 0L;
  public int taskId;
  public int version;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("shareBaseLine=");
    localStringBuilder.append(this.shareBaseLine);
    localStringBuilder.append(", portalConfigs=");
    localStringBuilder.append(this.portalConfigs);
    localStringBuilder.append(", comboNumberConfigs=");
    localStringBuilder.append(this.comboNumberConfigs);
    localStringBuilder.append(", bannerConfigs=");
    localStringBuilder.append(this.bannerConfigs);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.PortalManager.RedPacketConfig
 * JD-Core Version:    0.7.0.1
 */