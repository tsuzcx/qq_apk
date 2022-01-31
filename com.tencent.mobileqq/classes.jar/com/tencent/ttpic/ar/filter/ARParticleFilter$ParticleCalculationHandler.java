package com.tencent.ttpic.ar.filter;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.oscarcamera.particlesystem.FrameParticleData;
import com.tencent.oscarcamera.particlesystem.ParticleSystemEx;
import com.tencent.oscarcamera.particlesystem.Sprite;
import java.io.File;
import java.util.List;

class ARParticleFilter$ParticleCalculationHandler
  extends Handler
{
  public boolean isStopped = false;
  
  public ARParticleFilter$ParticleCalculationHandler(ARParticleFilter paramARParticleFilter, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (this.isStopped) {}
    int j;
    List localList;
    do
    {
      return;
      j = paramMessage.what;
      paramMessage = new ARParticleFilter.FrameData(this.this$0);
      localList = ARParticleFilter.access$600(this.this$0).advance();
    } while (localList == null);
    int i = 0;
    while ((i < localList.size()) && (i < ARParticleFilter.access$100(this.this$0).size()) && (i < ARParticleFilter.access$200(this.this$0).size()))
    {
      FrameParticleData localFrameParticleData = (FrameParticleData)localList.get(i);
      Sprite localSprite = (Sprite)ARParticleFilter.access$100(this.this$0).get(i);
      ARParticleFilter.FrameParticleData localFrameParticleData1 = new ARParticleFilter.FrameParticleData(this.this$0);
      localFrameParticleData1.blendMode = localFrameParticleData.blendMode;
      localFrameParticleData1.particleCount = localFrameParticleData.particleCount;
      localFrameParticleData1.tex = localSprite.path;
      localFrameParticleData1.positionIndex = localFrameParticleData.positionIndex;
      localFrameParticleData1.particleCenter = localFrameParticleData.particleCenter;
      localFrameParticleData1.particleSize = localFrameParticleData.particleSize;
      localFrameParticleData1.texCoords = localFrameParticleData.texCoords;
      localFrameParticleData1.particleColor = localFrameParticleData.particleColor;
      localFrameParticleData1.audioPath = (ARParticleFilter.access$700(this.this$0) + File.separator + (String)ARParticleFilter.access$200(this.this$0).get(i) + File.separator + localSprite.audioPath);
      if ((!paramMessage.needPlayMusic) && (!TextUtils.isEmpty(localFrameParticleData.audioPath))) {
        paramMessage.needPlayMusic = localFrameParticleData.playAudio;
      }
      paramMessage.frameParticleData.add(localFrameParticleData1);
      i += 1;
    }
    ARParticleFilter.access$800(this.this$0)[j] = paramMessage;
    ARParticleFilter.access$800(this.this$0)[j].ready = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.ar.filter.ARParticleFilter.ParticleCalculationHandler
 * JD-Core Version:    0.7.0.1
 */