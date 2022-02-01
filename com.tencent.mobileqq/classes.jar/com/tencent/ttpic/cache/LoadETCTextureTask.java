package com.tencent.ttpic.cache;

import android.opengl.ETC1Util.ETC1Texture;
import android.os.AsyncTask;
import com.tencent.ttpic.etc.ETC1File;
import com.tencent.ttpic.util.ZipPkmReader;
import java.io.File;
import java.util.Map;

public class LoadETCTextureTask
  extends AsyncTask<Void, Integer, Boolean>
{
  private Map<String, ETC1Util.ETC1Texture> cache;
  private String dataPath;
  private final int frames;
  private final String id;
  private final String materialId;
  
  public LoadETCTextureTask(Map<String, ETC1Util.ETC1Texture> paramMap, String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.cache = paramMap;
    this.dataPath = paramString2;
    this.materialId = paramString3;
    this.id = paramString1;
    this.frames = paramInt;
  }
  
  private void fillCache(int paramInt, String paramString)
  {
    int i = 0;
    while (i < paramInt)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.id);
      ((StringBuilder)localObject1).append("_");
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("%0");
      ((StringBuilder)localObject2).append(LoadETCItemManager.FORMAT_COUNT);
      ((StringBuilder)localObject2).append("d");
      ((StringBuilder)localObject1).append(String.format(((StringBuilder)localObject2).toString(), new Object[] { Integer.valueOf(i) }));
      ((StringBuilder)localObject1).append(paramString);
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.materialId);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject2).toString();
      if (!this.cache.containsKey(localObject1))
      {
        int j = i;
        while ((!this.cache.containsKey(localObject1)) && (j > 0))
        {
          j -= 1;
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this.id);
          ((StringBuilder)localObject1).append("_");
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("%0");
          ((StringBuilder)localObject2).append(LoadETCItemManager.FORMAT_COUNT);
          ((StringBuilder)localObject2).append("d");
          ((StringBuilder)localObject1).append(String.format(((StringBuilder)localObject2).toString(), new Object[] { Integer.valueOf(j) }));
          ((StringBuilder)localObject1).append(paramString);
          localObject1 = ((StringBuilder)localObject1).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.materialId);
          ((StringBuilder)localObject2).append(File.separator);
          ((StringBuilder)localObject2).append((String)localObject1);
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        if (this.cache.containsKey(localObject1))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(this.id);
          ((StringBuilder)localObject2).append("_");
          Object localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("%0");
          ((StringBuilder)localObject3).append(LoadETCItemManager.FORMAT_COUNT);
          ((StringBuilder)localObject3).append("d");
          ((StringBuilder)localObject2).append(String.format(((StringBuilder)localObject3).toString(), new Object[] { Integer.valueOf(i) }));
          ((StringBuilder)localObject2).append(paramString);
          localObject2 = ((StringBuilder)localObject2).toString();
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(this.materialId);
          ((StringBuilder)localObject3).append(File.separator);
          ((StringBuilder)localObject3).append((String)localObject2);
          localObject2 = ((StringBuilder)localObject3).toString();
          localObject3 = this.cache;
          ((Map)localObject3).put(localObject2, ((Map)localObject3).get(localObject1));
        }
      }
      i += 1;
    }
  }
  
  protected Boolean doInBackground(Void... paramVarArgs)
  {
    Object localObject1 = this.cache;
    paramVarArgs = Boolean.valueOf(false);
    if (localObject1 == null) {
      return paramVarArgs;
    }
    localObject1 = new ZipPkmReader(this.dataPath);
    ((ZipPkmReader)localObject1).open();
    for (;;)
    {
      ETC1File localETC1File = ((ZipPkmReader)localObject1).getNextEntry();
      if (localETC1File == null) {
        break;
      }
      if (isCancelled()) {
        return paramVarArgs;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.materialId);
      ((StringBuilder)localObject2).append(File.separator);
      ((StringBuilder)localObject2).append(localETC1File.getName());
      localObject2 = ((StringBuilder)localObject2).toString();
      this.cache.put(localObject2, localETC1File.getTexutre());
    }
    ((ZipPkmReader)localObject1).close();
    fillCache(this.frames, ".pkm");
    fillCache(this.frames, "_alpha.pkm");
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadETCTextureTask
 * JD-Core Version:    0.7.0.1
 */