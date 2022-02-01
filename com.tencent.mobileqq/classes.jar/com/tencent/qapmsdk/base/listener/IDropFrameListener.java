package com.tencent.qapmsdk.base.listener;

import com.tencent.qapmsdk.base.meta.DropFrameResultMeta;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/listener/IDropFrameListener;", "Lcom/tencent/qapmsdk/base/listener/IBaseListener;", "onRecordData", "", "meta", "Lcom/tencent/qapmsdk/base/meta/DropFrameResultMeta;", "qapmbase_release"}, k=1, mv={1, 1, 15})
public abstract interface IDropFrameListener
  extends IBaseListener
{
  public abstract void onRecordData(@Nullable DropFrameResultMeta paramDropFrameResultMeta);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.base.listener.IDropFrameListener
 * JD-Core Version:    0.7.0.1
 */