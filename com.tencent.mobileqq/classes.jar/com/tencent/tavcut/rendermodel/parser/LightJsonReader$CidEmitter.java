package com.tencent.tavcut.rendermodel.parser;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/rendermodel/parser/LightJsonReader$CidEmitter;", "", "max", "", "(I)V", "getMax", "()I", "setMax", "next", "lib_tavcut_model_release"}, k=1, mv={1, 1, 16})
final class LightJsonReader$CidEmitter
{
  private int max;
  
  public LightJsonReader$CidEmitter(int paramInt)
  {
    this.max = paramInt;
  }
  
  public final int getMax()
  {
    return this.max;
  }
  
  public final int next()
  {
    this.max += 1;
    return this.max;
  }
  
  public final void setMax(int paramInt)
  {
    this.max = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.rendermodel.parser.LightJsonReader.CidEmitter
 * JD-Core Version:    0.7.0.1
 */