package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.opengl.EGLContext;
import android.opengl.ETC1Util.ETC1Texture;
import android.os.AsyncTask;
import com.tencent.ttpic.gameplaysdk.GamePlaySDK;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Load3DTextureManager
  implements LoadItemManager
{
  private String dataPath;
  private List<AsyncTask<Void, Integer, Boolean>> mImageTasks;
  private String[] textureImages;
  
  public Load3DTextureManager(String paramString, String[] paramArrayOfString)
  {
    this.dataPath = paramString;
    this.textureImages = paramArrayOfString;
  }
  
  public void clear()
  {
    GamePlaySDK.getInstance().clearItemImage();
    if (this.mImageTasks != null)
    {
      Iterator localIterator = this.mImageTasks.iterator();
      while (localIterator.hasNext()) {
        ((AsyncTask)localIterator.next()).cancel(true);
      }
    }
  }
  
  public ETC1Util.ETC1Texture loadETCAlphaTexture(int paramInt)
  {
    return null;
  }
  
  public ETC1Util.ETC1Texture loadETCRGBTexture(int paramInt)
  {
    return null;
  }
  
  public int loadImage(int paramInt1, int paramInt2)
  {
    return -1;
  }
  
  public int loadImage(int paramInt1, int paramInt2, EGLContext paramEGLContext)
  {
    return -1;
  }
  
  public Bitmap loadImage(int paramInt)
  {
    return null;
  }
  
  public Bitmap loadImage(String paramString)
  {
    return null;
  }
  
  public void prepareImages()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.textureImages != null) && (this.textureImages.length > 0))
    {
      this.mImageTasks = new ArrayList();
      int i = 0;
      while (i < 4)
      {
        localArrayList.add(new ArrayList());
        i += 1;
      }
      i = 0;
      int j = 0;
      while (j < this.textureImages.length)
      {
        ((List)localArrayList.get(i)).add(this.textureImages[j]);
        j += 1;
        i = (i + 1) % 4;
      }
      this.mImageTasks = new ArrayList();
      i = 0;
      while (i < localArrayList.size())
      {
        Load3DTextureTask localLoad3DTextureTask = new Load3DTextureTask(this.dataPath, (List)localArrayList.get(i));
        localLoad3DTextureTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        this.mImageTasks.add(localLoad3DTextureTask);
        i += 1;
      }
    }
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.cache.Load3DTextureManager
 * JD-Core Version:    0.7.0.1
 */