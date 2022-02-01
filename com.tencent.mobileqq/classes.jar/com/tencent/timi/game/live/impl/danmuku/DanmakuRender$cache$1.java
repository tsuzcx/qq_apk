package com.tencent.timi.game.live.impl.danmuku;

import android.text.Layout;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/live/impl/danmuku/DanmakuRender$cache$1", "Ljava/util/LinkedHashMap;", "", "Landroid/text/Layout;", "Lkotlin/collections/LinkedHashMap;", "removeEldestEntry", "", "eldest", "", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class DanmakuRender$cache$1
  extends LinkedHashMap<String, Layout>
{
  DanmakuRender$cache$1(int paramInt)
  {
    super(paramInt);
  }
  
  public final Set<Map.Entry<String, Layout>> entrySet()
  {
    return getEntries();
  }
  
  public Set getEntries()
  {
    return super.entrySet();
  }
  
  public Set getKeys()
  {
    return super.keySet();
  }
  
  public int getSize()
  {
    return super.size();
  }
  
  public Collection getValues()
  {
    return super.values();
  }
  
  public final Set<String> keySet()
  {
    return getKeys();
  }
  
  protected boolean removeEldestEntry(@Nullable Map.Entry<String, Layout> paramEntry)
  {
    return size() > 25;
  }
  
  public final int size()
  {
    return getSize();
  }
  
  public final Collection<Layout> values()
  {
    return getValues();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.live.impl.danmuku.DanmakuRender.cache.1
 * JD-Core Version:    0.7.0.1
 */