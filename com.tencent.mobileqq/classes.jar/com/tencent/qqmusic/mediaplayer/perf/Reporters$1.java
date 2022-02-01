package com.tencent.qqmusic.mediaplayer.perf;

import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class Reporters$1
  implements PerformanceTracer.Visitor
{
  Reporters$1(AudioInformation paramAudioInformation, Map paramMap) {}
  
  public void visitSpeedCheck(List<PerformanceTracer.SpeedCheck> paramList, PerformanceTracer.OverallInfo paramOverallInfo)
  {
    double d1 = paramOverallInfo.totalPcmToBePlayed;
    double d2 = paramOverallInfo.timeCostInMs;
    Double.isNaN(d1);
    Double.isNaN(d2);
    long l1 = Math.round(d1 / d2);
    long l2 = this.val$audioInformation.getPlaySample();
    long l3 = this.val$audioInformation.getChannels();
    int j = this.val$audioInformation.getBitDepth();
    int i = 1;
    if (j != 1) {
      i = 2;
    }
    d1 = l2 * l3 * i;
    Double.isNaN(d1);
    d1 /= 1000.0D;
    d2 = l1;
    Double.isNaN(d2);
    d2 /= d1;
    StringBuilder localStringBuilder = new StringBuilder("\n============== Info start ==============\n");
    localStringBuilder.append("媒体文件信息:\n");
    localStringBuilder.append("\t播放时间: ");
    localStringBuilder.append(new Date().toString());
    localStringBuilder.append("\n");
    localStringBuilder.append("\t音频类型: ");
    localStringBuilder.append(this.val$audioInformation.getAudioType().toString());
    localStringBuilder.append("\n");
    localStringBuilder.append("\t文件采样率: ");
    localStringBuilder.append(this.val$audioInformation.getSampleRate());
    localStringBuilder.append("\n");
    localStringBuilder.append("\t播放采样率: ");
    localStringBuilder.append(this.val$audioInformation.getPlaySample());
    localStringBuilder.append("\n");
    localStringBuilder.append("\t位深: ");
    localStringBuilder.append(this.val$audioInformation.getBitDepth());
    localStringBuilder.append("\n");
    localStringBuilder.append("\t声道数: ");
    localStringBuilder.append(this.val$audioInformation.getChannels());
    localStringBuilder.append("\n");
    localStringBuilder.append("\t时长: ");
    localStringBuilder.append(this.val$audioInformation.getDuration());
    localStringBuilder.append("\n");
    localStringBuilder.append("\n整体性能");
    localStringBuilder.append("\n");
    localStringBuilder.append("\t总耗时 (ms): ");
    localStringBuilder.append(paramOverallInfo.timeCostInMs);
    localStringBuilder.append("\n");
    localStringBuilder.append("\t播放PCM数据量 (byte): ");
    localStringBuilder.append(paramOverallInfo.totalPcmToBePlayed);
    localStringBuilder.append("\n");
    localStringBuilder.append("\t总速度 (byte/ms): ");
    localStringBuilder.append(l1);
    localStringBuilder.append(" (");
    localStringBuilder.append(Math.round(d2));
    localStringBuilder.append(" 倍于最低要求速度)");
    localStringBuilder.append("\n");
    localStringBuilder.append("\t最低要求速度 (byte/ms): ");
    localStringBuilder.append(d1);
    localStringBuilder.append("\n");
    localStringBuilder.append("\n额外信息:");
    Iterator localIterator = this.val$extra.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append("\n\t");
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append(": ");
      localStringBuilder.append((String)localEntry.getValue());
    }
    localStringBuilder.append("\n");
    Reporters.access$000(paramList, localStringBuilder, paramOverallInfo.timeCostInMs);
    localStringBuilder.append("============== Info end ==============");
    Logger.i("PERFORMANCE", localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.perf.Reporters.1
 * JD-Core Version:    0.7.0.1
 */