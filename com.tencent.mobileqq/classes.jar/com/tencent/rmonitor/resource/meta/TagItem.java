package com.tencent.rmonitor.resource.meta;

import com.tencent.rmonitor.base.meta.SceneMeta;

public class TagItem
{
  public double duringTime = (0.0D / 0.0D);
  public double eventTime = (0.0D / 0.0D);
  public String extraInfo = "";
  public long fps = 9223372036854775807L;
  public long ioBytes = 9223372036854775807L;
  public long ioCount = 9223372036854775807L;
  public boolean isSlow = false;
  public TagItem matchTagItem = null;
  public long netFlowPackets = 9223372036854775807L;
  public long netFlowReceiveBytes = 9223372036854775807L;
  public long netFlowSendBytes = 9223372036854775807L;
  public SceneMeta sceneMeta = new SceneMeta();
  public String stage = "";
  public String subStage = "";
  public long tagId = 9223372036854775807L;
  public String tagKey = "";
  public int type = -1;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.resource.meta.TagItem
 * JD-Core Version:    0.7.0.1
 */