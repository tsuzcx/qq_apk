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
    String str1;
    while (i < paramInt)
    {
      str1 = this.id + "_" + String.format(new StringBuilder().append("%0").append(LoadETCItemManager.FORMAT_COUNT).append("d").toString(), new Object[] { Integer.valueOf(i) }) + paramString;
      str1 = this.materialId + File.separator + str1;
      if (!this.cache.containsKey(str1)) {
        break label401;
      }
      i += 1;
    }
    for (;;)
    {
      int j;
      if ((!this.cache.containsKey(str1)) && (j > 0))
      {
        j -= 1;
        str1 = this.id + "_" + String.format(new StringBuilder().append("%0").append(LoadETCItemManager.FORMAT_COUNT).append("d").toString(), new Object[] { Integer.valueOf(j) }) + paramString;
        str1 = this.materialId + File.separator + str1;
      }
      else
      {
        if (!this.cache.containsKey(str1)) {
          break;
        }
        String str2 = this.id + "_" + String.format(new StringBuilder().append("%0").append(LoadETCItemManager.FORMAT_COUNT).append("d").toString(), new Object[] { Integer.valueOf(i) }) + paramString;
        str2 = this.materialId + File.separator + str2;
        this.cache.put(str2, this.cache.get(str1));
        break;
        return;
        label401:
        j = i;
      }
    }
  }
  
  protected Boolean doInBackground(Void... paramVarArgs)
  {
    if (this.cache == null) {
      return Boolean.valueOf(false);
    }
    paramVarArgs = new ZipPkmReader(this.dataPath);
    paramVarArgs.open();
    for (;;)
    {
      ETC1File localETC1File = paramVarArgs.getNextEntry();
      if (localETC1File == null) {
        break;
      }
      if (isCancelled()) {
        return Boolean.valueOf(false);
      }
      String str = this.materialId + File.separator + localETC1File.getName();
      this.cache.put(str, localETC1File.getTexutre());
    }
    paramVarArgs.close();
    fillCache(this.frames, ".pkm");
    fillCache(this.frames, "_alpha.pkm");
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadETCTextureTask
 * JD-Core Version:    0.7.0.1
 */