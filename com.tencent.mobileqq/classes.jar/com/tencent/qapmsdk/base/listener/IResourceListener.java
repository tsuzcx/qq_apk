package com.tencent.qapmsdk.base.listener;

import com.tencent.qapmsdk.base.meta.SceneMeta;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/listener/IResourceListener;", "Lcom/tencent/qapmsdk/base/listener/IBaseListener;", "onEndScene", "", "meta", "Lcom/tencent/qapmsdk/base/meta/SceneMeta;", "qapmbase_release"}, k=1, mv={1, 1, 15})
public abstract interface IResourceListener
  extends IBaseListener
{
  public abstract void onEndScene(@Nullable SceneMeta paramSceneMeta);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qapmsdk.base.listener.IResourceListener
 * JD-Core Version:    0.7.0.1
 */