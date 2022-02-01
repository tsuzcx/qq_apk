package com.tencent.mobileqq.triton.engine;

import com.tencent.mobileqq.triton.filesystem.GameDataFileSystem;
import com.tencent.mobileqq.triton.filesystem.GamePackage;
import com.tencent.mobileqq.triton.script.InspectorAgent;
import com.tencent.mobileqq.triton.statistic.JankTraceLevel;
import com.tencent.mobileqq.triton.view.GameView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/engine/GameLaunchParam;", "", "gamePackage", "Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "dataFileSystem", "Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "gameView", "Lcom/tencent/mobileqq/triton/view/GameView;", "inspectorAgent", "Lcom/tencent/mobileqq/triton/script/InspectorAgent;", "jankTraceLevel", "Lcom/tencent/mobileqq/triton/statistic/JankTraceLevel;", "userData", "", "Ljava/lang/Class;", "(Lcom/tencent/mobileqq/triton/filesystem/GamePackage;Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;Lcom/tencent/mobileqq/triton/view/GameView;Lcom/tencent/mobileqq/triton/script/InspectorAgent;Lcom/tencent/mobileqq/triton/statistic/JankTraceLevel;Ljava/util/Map;)V", "getDataFileSystem", "()Lcom/tencent/mobileqq/triton/filesystem/GameDataFileSystem;", "getGamePackage", "()Lcom/tencent/mobileqq/triton/filesystem/GamePackage;", "getGameView", "()Lcom/tencent/mobileqq/triton/view/GameView;", "getInspectorAgent", "()Lcom/tencent/mobileqq/triton/script/InspectorAgent;", "getJankTraceLevel", "()Lcom/tencent/mobileqq/triton/statistic/JankTraceLevel;", "getUserData", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "", "TritonAPI_release"}, k=1, mv={1, 1, 16})
public final class GameLaunchParam
{
  @NotNull
  private final GameDataFileSystem dataFileSystem;
  @NotNull
  private final GamePackage gamePackage;
  @NotNull
  private final GameView gameView;
  @Nullable
  private final InspectorAgent inspectorAgent;
  @NotNull
  private final JankTraceLevel jankTraceLevel;
  @NotNull
  private final Map<Class<?>, Object> userData;
  
  public GameLaunchParam(@NotNull GamePackage paramGamePackage, @NotNull GameDataFileSystem paramGameDataFileSystem, @NotNull GameView paramGameView, @Nullable InspectorAgent paramInspectorAgent, @NotNull JankTraceLevel paramJankTraceLevel, @NotNull Map<Class<?>, ? extends Object> paramMap)
  {
    this.gamePackage = paramGamePackage;
    this.dataFileSystem = paramGameDataFileSystem;
    this.gameView = paramGameView;
    this.inspectorAgent = paramInspectorAgent;
    this.jankTraceLevel = paramJankTraceLevel;
    this.userData = paramMap;
  }
  
  @NotNull
  public final GamePackage component1()
  {
    return this.gamePackage;
  }
  
  @NotNull
  public final GameDataFileSystem component2()
  {
    return this.dataFileSystem;
  }
  
  @NotNull
  public final GameView component3()
  {
    return this.gameView;
  }
  
  @Nullable
  public final InspectorAgent component4()
  {
    return this.inspectorAgent;
  }
  
  @NotNull
  public final JankTraceLevel component5()
  {
    return this.jankTraceLevel;
  }
  
  @NotNull
  public final Map<Class<?>, Object> component6()
  {
    return this.userData;
  }
  
  @NotNull
  public final GameLaunchParam copy(@NotNull GamePackage paramGamePackage, @NotNull GameDataFileSystem paramGameDataFileSystem, @NotNull GameView paramGameView, @Nullable InspectorAgent paramInspectorAgent, @NotNull JankTraceLevel paramJankTraceLevel, @NotNull Map<Class<?>, ? extends Object> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramGamePackage, "gamePackage");
    Intrinsics.checkParameterIsNotNull(paramGameDataFileSystem, "dataFileSystem");
    Intrinsics.checkParameterIsNotNull(paramGameView, "gameView");
    Intrinsics.checkParameterIsNotNull(paramJankTraceLevel, "jankTraceLevel");
    Intrinsics.checkParameterIsNotNull(paramMap, "userData");
    return new GameLaunchParam(paramGamePackage, paramGameDataFileSystem, paramGameView, paramInspectorAgent, paramJankTraceLevel, paramMap);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof GameLaunchParam))
      {
        paramObject = (GameLaunchParam)paramObject;
        if ((Intrinsics.areEqual(this.gamePackage, paramObject.gamePackage)) && (Intrinsics.areEqual(this.dataFileSystem, paramObject.dataFileSystem)) && (Intrinsics.areEqual(this.gameView, paramObject.gameView)) && (Intrinsics.areEqual(this.inspectorAgent, paramObject.inspectorAgent)) && (Intrinsics.areEqual(this.jankTraceLevel, paramObject.jankTraceLevel)) && (Intrinsics.areEqual(this.userData, paramObject.userData))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  @NotNull
  public final GameDataFileSystem getDataFileSystem()
  {
    return this.dataFileSystem;
  }
  
  @NotNull
  public final GamePackage getGamePackage()
  {
    return this.gamePackage;
  }
  
  @NotNull
  public final GameView getGameView()
  {
    return this.gameView;
  }
  
  @Nullable
  public final InspectorAgent getInspectorAgent()
  {
    return this.inspectorAgent;
  }
  
  @NotNull
  public final JankTraceLevel getJankTraceLevel()
  {
    return this.jankTraceLevel;
  }
  
  @NotNull
  public final Map<Class<?>, Object> getUserData()
  {
    return this.userData;
  }
  
  public int hashCode()
  {
    Object localObject = this.gamePackage;
    int i1 = 0;
    int i;
    if (localObject != null) {
      i = localObject.hashCode();
    } else {
      i = 0;
    }
    localObject = this.dataFileSystem;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.gameView;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.inspectorAgent;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.jankTraceLevel;
    int n;
    if (localObject != null) {
      n = localObject.hashCode();
    } else {
      n = 0;
    }
    localObject = this.userData;
    if (localObject != null) {
      i1 = localObject.hashCode();
    }
    return ((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GameLaunchParam(gamePackage=");
    localStringBuilder.append(this.gamePackage);
    localStringBuilder.append(", dataFileSystem=");
    localStringBuilder.append(this.dataFileSystem);
    localStringBuilder.append(", gameView=");
    localStringBuilder.append(this.gameView);
    localStringBuilder.append(", inspectorAgent=");
    localStringBuilder.append(this.inspectorAgent);
    localStringBuilder.append(", jankTraceLevel=");
    localStringBuilder.append(this.jankTraceLevel);
    localStringBuilder.append(", userData=");
    localStringBuilder.append(this.userData);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.GameLaunchParam
 * JD-Core Version:    0.7.0.1
 */