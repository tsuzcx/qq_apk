package com.tencent.mobileqq.triton.game;

import com.tencent.mobileqq.triton.filesystem.GamePackage.SubpackageListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/triton/game/GameLauncher$loadSubpackage$1$1", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage$SubpackageListener;", "onComplete", "", "result", "Lkotlin/Result;", "Lcom/tencent/mobileqq/triton/filesystem/ScriptPackage;", "(Ljava/lang/Object;)V", "onProgress", "totalBytes", "", "currentBytes", "Triton_release"}, k=1, mv={1, 1, 16})
public final class GameLauncher$loadSubpackage$1$1
  implements GamePackage.SubpackageListener
{
  public void onComplete(@NotNull Object paramObject)
  {
    GameLauncher.access$performLoadSubpackage(this.this$0.this$0, this.this$0.$name, paramObject, this.this$0.$onComplete);
  }
  
  public void onProgress(long paramLong1, long paramLong2)
  {
    this.this$0.$onProgress.invoke(Long.valueOf(paramLong1), Long.valueOf(paramLong2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.triton.game.GameLauncher.loadSubpackage.1.1
 * JD-Core Version:    0.7.0.1
 */