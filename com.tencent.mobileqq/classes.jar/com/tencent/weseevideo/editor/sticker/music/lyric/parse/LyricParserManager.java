package com.tencent.weseevideo.editor.sticker.music.lyric.parse;

import android.support.annotation.NonNull;
import com.tencent.weseevideo.editor.sticker.music.lyric.parse.provider.IParserProvider;
import com.tencent.weseevideo.editor.sticker.music.lyric.parse.provider.WEmptyLineProvider;
import com.tencent.weseevideo.editor.sticker.music.lyric.parse.provider.WOEmptyLineProvider;
import java.util.HashMap;

public class LyricParserManager
{
  private HashMap<String, IParserProvider> mProviderMap = new HashMap();
  
  private LyricParserManager()
  {
    registerProvider(WEmptyLineProvider.class, WEmptyLineProvider.getInstance());
    registerProvider(WOEmptyLineProvider.class, WOEmptyLineProvider.getInstance());
  }
  
  public static LyricParserManager getInstance()
  {
    return LyricParserManager.InstanceHolder.INSTANCE;
  }
  
  public <T extends IParserProvider> IParserProvider getProvider()
  {
    return WOEmptyLineProvider.getInstance();
  }
  
  public <T extends IParserProvider> IParserProvider getProvider(@NonNull Class<T> paramClass)
  {
    IParserProvider localIParserProvider = (IParserProvider)this.mProviderMap.get(paramClass.getName());
    paramClass = localIParserProvider;
    if (localIParserProvider == null) {
      paramClass = getProvider();
    }
    return paramClass;
  }
  
  public <T extends IParserProvider> void registerProvider(@NonNull Class<T> paramClass, @NonNull T paramT)
  {
    this.mProviderMap.put(paramClass.getName(), paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.editor.sticker.music.lyric.parse.LyricParserManager
 * JD-Core Version:    0.7.0.1
 */