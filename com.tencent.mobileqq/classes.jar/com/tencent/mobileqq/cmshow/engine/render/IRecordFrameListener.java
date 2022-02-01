package com.tencent.mobileqq.cmshow.engine.render;

import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/render/IRecordFrameListener;", "", "getAction", "Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;", "onRecordFrameEnd", "", "actionComplete", "onRecordFrameStart", "frameTime", "", "onRecordSingleFrame", "pixels", "", "width", "", "height", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public abstract interface IRecordFrameListener
{
  @NotNull
  public abstract MemeAction a();
  
  public abstract boolean a(float paramFloat);
  
  public abstract boolean a(boolean paramBoolean);
  
  public abstract boolean a(@NotNull byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.render.IRecordFrameListener
 * JD-Core Version:    0.7.0.1
 */