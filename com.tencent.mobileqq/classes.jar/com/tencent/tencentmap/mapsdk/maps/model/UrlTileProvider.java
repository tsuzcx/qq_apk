package com.tencent.tencentmap.mapsdk.maps.model;

import com.tencent.map.sdk.a.or;
import com.tencent.map.sdk.a.qk;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;
import java.net.URL;

public abstract class UrlTileProvider
  implements TileProvider
{
  private final int a;
  private final int b;
  
  public UrlTileProvider(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }
  
  public final Tile getTile(int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = getTileUrl(paramInt1, paramInt2, paramInt3);
    Tile localTile2 = NO_TILE;
    if (localObject == null)
    {
      or.b("TileOverlay", "Tile的请求URL为NULL，返回空瓦块");
      return localTile2;
    }
    NetResponse localNetResponse = requestTileData(((URL)localObject).toString());
    Tile localTile1 = null;
    localObject = localTile1;
    if (localNetResponse != null) {
      if (localNetResponse.available())
      {
        localObject = localNetResponse.data;
      }
      else
      {
        localObject = localTile1;
        if ((localNetResponse.exception instanceof qk)) {
          return new Tile(this.a, this.b, null);
        }
      }
    }
    localTile1 = localTile2;
    if (localObject != null)
    {
      localTile1 = localTile2;
      if (localObject.length != 0) {
        localTile1 = new Tile(this.a, this.b, (byte[])localObject);
      }
    }
    return localTile1;
  }
  
  public abstract URL getTileUrl(int paramInt1, int paramInt2, int paramInt3);
  
  protected NetResponse requestTileData(String paramString)
  {
    try
    {
      NetResponse localNetResponse = NetManager.getInstance().doGet(paramString);
      return localNetResponse;
    }
    catch (Exception localException)
    {
      or.b("UrlTileProvider getTile failed url:".concat(String.valueOf(paramString)), localException);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.UrlTileProvider
 * JD-Core Version:    0.7.0.1
 */