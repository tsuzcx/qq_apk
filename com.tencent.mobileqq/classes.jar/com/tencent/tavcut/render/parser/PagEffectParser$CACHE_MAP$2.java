package com.tencent.tavcut.render.parser;

import android.util.LruCache;
import com.tencent.tavcut.model.PagEffectData;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Landroid/util/LruCache;", "", "Lcom/tencent/tavcut/model/PagEffectData;", "invoke"}, k=3, mv={1, 1, 16})
final class PagEffectParser$CACHE_MAP$2
  extends Lambda
  implements Function0<LruCache<String, PagEffectData>>
{
  public static final 2 INSTANCE = new 2();
  
  PagEffectParser$CACHE_MAP$2()
  {
    super(0);
  }
  
  @NotNull
  public final LruCache<String, PagEffectData> invoke()
  {
    return new LruCache(10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.parser.PagEffectParser.CACHE_MAP.2
 * JD-Core Version:    0.7.0.1
 */