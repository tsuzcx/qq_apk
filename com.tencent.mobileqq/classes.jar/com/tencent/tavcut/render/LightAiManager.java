package com.tencent.tavcut.render;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.light.Config;
import org.light.MovieConfig;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/LightAiManager;", "", "()V", "SHORT_EDGE_LENGTH", "", "agentPath", "", "", "buildMovieConfig", "Lorg/light/Config;", "registerAiPath", "", "agent", "path", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public final class LightAiManager
{
  public static final LightAiManager a = new LightAiManager();
  private static final Map<String, String> b = (Map)new LinkedHashMap();
  
  @NotNull
  public final Config a()
  {
    MovieConfig localMovieConfig = MovieConfig.make();
    Iterator localIterator = b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localMovieConfig.setLightAIModelPath((String)localEntry.getKey(), (String)localEntry.getValue());
    }
    localMovieConfig.setSyncMode(true);
    localMovieConfig.setDetectShorterEdgeLength(180, "");
    Intrinsics.checkExpressionValueIsNotNull(localMovieConfig, "movieConfig");
    return (Config)localMovieConfig;
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "agent");
    Intrinsics.checkParameterIsNotNull(paramString2, "path");
    b.put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.LightAiManager
 * JD-Core Version:    0.7.0.1
 */