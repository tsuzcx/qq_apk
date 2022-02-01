package com.tencent.mobileqq.cmshow.engine.scene;

import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/scene/Scene;", "", "(Ljava/lang/String;I)V", "assetsPath", "", "assetsPath$cmshow_impl_release", "debugConfigKey", "preloadScripts", "", "preloadScripts$cmshow_impl_release", "worldPath", "worldPath$cmshow_impl_release", "AIO", "AIO_BACKGROUND", "DRAWER", "FRIEND_CARD", "MEME_PLAYER", "MAKEUP_PAGE", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public enum Scene
{
  static
  {
    Scene localScene1 = new Scene("AIO", 0);
    AIO = localScene1;
    Scene localScene2 = new Scene("AIO_BACKGROUND", 1);
    AIO_BACKGROUND = localScene2;
    Scene localScene3 = new Scene("DRAWER", 2);
    DRAWER = localScene3;
    Scene localScene4 = new Scene("FRIEND_CARD", 3);
    FRIEND_CARD = localScene4;
    Scene localScene5 = new Scene("MEME_PLAYER", 4);
    MEME_PLAYER = localScene5;
    Scene localScene6 = new Scene("MAKEUP_PAGE", 5);
    MAKEUP_PAGE = localScene6;
    $VALUES = new Scene[] { localScene1, localScene2, localScene3, localScene4, localScene5, localScene6 };
  }
  
  private Scene() {}
  
  @NotNull
  public final String assetsPath$cmshow_impl_release()
  {
    switch (Scene.WhenMappings.a[ordinal()])
    {
    default: 
      throw new NoWhenBranchMatchedException();
    }
    String str = ApolloConstant.j;
    Intrinsics.checkExpressionValueIsNotNull(str, "ApolloConstant.CROSSENGINE_ASSETS_ROOT");
    return str;
  }
  
  @NotNull
  public final String debugConfigKey()
  {
    switch (Scene.WhenMappings.d[ordinal()])
    {
    default: 
      throw new NoWhenBranchMatchedException();
    case 6: 
      return "";
    case 5: 
      return "test_cross_engine_player";
    case 4: 
      return "test_cross_engine_friendcard";
    case 3: 
      return "test_cross_engine_drawer";
    case 2: 
      return "test_cross_engine_aio_background";
    }
    return "test_cross_engine_aio";
  }
  
  @Nullable
  public final List<String> preloadScripts$cmshow_impl_release()
  {
    switch (Scene.WhenMappings.c[ordinal()])
    {
    default: 
      throw new NoWhenBranchMatchedException();
    case 6: 
      return CollectionsKt.listOf(new String[] { "Contents/JS/engine.js", "Contents/JS/ce3d.js", "Contents/JS/cmshow_script_0_ce.js" });
    }
    return CollectionsKt.listOf(new String[] { "Contents/JS/engine.js", "Contents/JS/ce3d.js" });
  }
  
  @NotNull
  public final String worldPath$cmshow_impl_release()
  {
    switch (Scene.WhenMappings.b[ordinal()])
    {
    default: 
      throw new NoWhenBranchMatchedException();
    }
    return "Contents/World/EmptyScene.nda";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.scene.Scene
 * JD-Core Version:    0.7.0.1
 */