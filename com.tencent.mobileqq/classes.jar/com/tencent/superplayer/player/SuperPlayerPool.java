package com.tencent.superplayer.player;

import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayerPool;
import com.tencent.superplayer.utils.LogUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SuperPlayerPool
  implements ISuperPlayerPool
{
  private static final String TAG = "MediaPlayerMgr.SuperPlayerPool";
  private Map<String, ISuperPlayer> mPoolMap = new ConcurrentHashMap();
  
  public ISuperPlayer get(String paramString)
  {
    return (ISuperPlayer)this.mPoolMap.get(paramString);
  }
  
  public void put(ISuperPlayer paramISuperPlayer)
  {
    if (paramISuperPlayer == null) {
      return;
    }
    LogUtil.d("MediaPlayerMgr.SuperPlayerPool", "SuperPlayerPool put player:" + paramISuperPlayer.getToken() + ", size:" + size());
    this.mPoolMap.put(paramISuperPlayer.getToken(), paramISuperPlayer);
  }
  
  public boolean remove(ISuperPlayer paramISuperPlayer)
  {
    if (paramISuperPlayer == null) {}
    do
    {
      return false;
      LogUtil.d("MediaPlayerMgr.SuperPlayerPool", "SuperPlayerPool remove player:" + paramISuperPlayer.getToken() + ", size:" + size());
    } while (this.mPoolMap.remove(paramISuperPlayer.getToken()) == null);
    return true;
  }
  
  public int size()
  {
    return this.mPoolMap.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerPool
 * JD-Core Version:    0.7.0.1
 */