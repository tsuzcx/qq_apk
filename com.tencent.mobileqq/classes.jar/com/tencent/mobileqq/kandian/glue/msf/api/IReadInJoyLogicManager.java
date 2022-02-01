package com.tencent.mobileqq.kandian.glue.msf.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import kotlin.Metadata;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.Nullable;

@Service(needUin=false, process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyLogicManager;", "Lmqq/app/api/IRuntimeService;", "getReadInJoyLogicEngine", "Lcom/tencent/mobileqq/kandian/glue/msf/api/IReadInJoyLogicEngine;", "initialize", "", "unInitialize", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyLogicManager
  extends IRuntimeService
{
  @Nullable
  public abstract IReadInJoyLogicEngine getReadInJoyLogicEngine();
  
  public abstract void initialize();
  
  public abstract void unInitialize();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyLogicManager
 * JD-Core Version:    0.7.0.1
 */