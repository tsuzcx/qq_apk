package com.tencent.superplayer.player;

import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayerPool;
import com.tencent.superplayer.utils.LogUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SuperPlayerPool
  implements ISuperPlayerPool
{
  private static final String TAG = "SuperPlayerPool";
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SuperPlayerPool put player:");
    localStringBuilder.append(paramISuperPlayer.getToken());
    localStringBuilder.append(", size:");
    localStringBuilder.append(size());
    LogUtil.d("SuperPlayerPool", localStringBuilder.toString());
    this.mPoolMap.put(paramISuperPlayer.getToken(), paramISuperPlayer);
  }
  
  public boolean remove(ISuperPlayer paramISuperPlayer)
  {
    boolean bool = false;
    if (paramISuperPlayer == null) {
      return false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SuperPlayerPool remove player:");
    localStringBuilder.append(paramISuperPlayer.getToken());
    localStringBuilder.append(", size:");
    localStringBuilder.append(size());
    LogUtil.d("SuperPlayerPool", localStringBuilder.toString());
    if (this.mPoolMap.remove(paramISuperPlayer.getToken()) != null) {
      bool = true;
    }
    return bool;
  }
  
  public int size()
  {
    return this.mPoolMap.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerPool
 * JD-Core Version:    0.7.0.1
 */