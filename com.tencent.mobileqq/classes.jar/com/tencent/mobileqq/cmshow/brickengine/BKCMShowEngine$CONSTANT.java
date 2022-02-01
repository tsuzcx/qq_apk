package com.tencent.mobileqq.cmshow.brickengine;

import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/brickengine/BKCMShowEngine$CONSTANT;", "", "()V", "TAG_PRE", "", "isEngineReady", "", "setPipeLog", "", "disablePipeLog", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class BKCMShowEngine$CONSTANT
{
  public final void a(boolean paramBoolean)
  {
    ApolloEngine.setPipeLog(paramBoolean);
  }
  
  public final boolean a()
  {
    return ApolloEngine.isEngineReady();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.BKCMShowEngine.CONSTANT
 * JD-Core Version:    0.7.0.1
 */