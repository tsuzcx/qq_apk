package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LoadImageTask2
  extends AsyncTask<Void, Integer, Boolean>
{
  private Map<String, Bitmap> cache;
  private String dataPath;
  private final String materialId;
  private List<String> resourceList;
  private final int sampleSize;
  
  public LoadImageTask2(Map<String, Bitmap> paramMap, List<String> paramList, String paramString1, String paramString2, int paramInt)
  {
    this.cache = paramMap;
    this.resourceList = paramList;
    if (this.resourceList == null) {
      this.resourceList = new ArrayList();
    }
    this.dataPath = paramString1;
    this.materialId = paramString2;
    this.sampleSize = paramInt;
  }
  
  protected Boolean doInBackground(Void... paramVarArgs)
  {
    if (this.cache == null) {
      return Boolean.valueOf(false);
    }
    Iterator localIterator = this.resourceList.iterator();
    label167:
    while (localIterator.hasNext())
    {
      paramVarArgs = (String)localIterator.next();
      if (isCancelled()) {
        return Boolean.valueOf(false);
      }
      Object localObject = this.dataPath + File.separator + paramVarArgs;
      localObject = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject, this.sampleSize);
      if (TextUtils.isEmpty(this.materialId)) {}
      for (;;)
      {
        if ((!BitmapUtils.isLegal((Bitmap)localObject)) || (this.cache.containsKey(paramVarArgs))) {
          break label167;
        }
        this.cache.put(paramVarArgs, localObject);
        break;
        paramVarArgs = this.materialId + File.separator + paramVarArgs;
      }
    }
    return Boolean.valueOf(true);
  }
  
  protected void onCancelled(Boolean paramBoolean)
  {
    super.onCancelled(paramBoolean);
    if (this.cache == null) {
      return;
    }
    Iterator localIterator = this.resourceList.iterator();
    label23:
    label79:
    label108:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        paramBoolean = (String)localIterator.next();
        if (!TextUtils.isEmpty(this.materialId)) {
          break label79;
        }
      }
      for (;;)
      {
        if (!this.cache.containsKey(paramBoolean)) {
          break label108;
        }
        this.cache.remove(paramBoolean);
        break label23;
        break;
        paramBoolean = this.materialId + File.separator + paramBoolean;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadImageTask2
 * JD-Core Version:    0.7.0.1
 */