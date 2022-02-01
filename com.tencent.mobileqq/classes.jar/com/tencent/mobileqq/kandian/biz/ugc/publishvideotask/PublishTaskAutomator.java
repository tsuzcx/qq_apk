package com.tencent.mobileqq.kandian.biz.ugc.publishvideotask;

import com.tencent.mobileqq.kandian.base.automator.Automator;
import com.tencent.mobileqq.kandian.biz.ugc.entity.UgcVideo;
import org.jetbrains.annotations.NotNull;

public final class PublishTaskAutomator
  extends Automator
{
  @NotNull
  private UgcVideo a;
  
  public PublishTaskAutomator(@NotNull UgcVideo paramUgcVideo)
  {
    this.a = paramUgcVideo;
  }
  
  @NotNull
  public final UgcVideo a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.publishvideotask.PublishTaskAutomator
 * JD-Core Version:    0.7.0.1
 */