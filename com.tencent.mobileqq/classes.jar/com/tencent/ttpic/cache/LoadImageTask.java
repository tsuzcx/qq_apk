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

public class LoadImageTask
  extends AsyncTask<Void, Integer, Boolean>
{
  private Map<String, Bitmap> cache;
  private String dataPath;
  private final String materialId;
  private List<String> resourceList;
  private final int sampleSize;
  
  public LoadImageTask(Map<String, Bitmap> paramMap, List<String> paramList, String paramString1, String paramString2, int paramInt)
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
    paramVarArgs = this.cache;
    Boolean localBoolean = Boolean.valueOf(false);
    if (paramVarArgs == null) {
      return localBoolean;
    }
    paramVarArgs = null;
    Iterator localIterator = this.resourceList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (isCancelled()) {
        return localBoolean;
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.dataPath);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
      localObject = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), (String)localObject, this.sampleSize);
      if (!TextUtils.isEmpty(this.materialId))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.materialId);
        localStringBuilder.append(File.separator);
        localStringBuilder.append(str);
        str = localStringBuilder.toString();
      }
      if (BitmapUtils.isLegal((Bitmap)localObject))
      {
        this.cache.put(str, localObject);
        paramVarArgs = (Void[])localObject;
      }
      else if (BitmapUtils.isLegal(paramVarArgs))
      {
        this.cache.put(str, paramVarArgs);
      }
    }
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadImageTask
 * JD-Core Version:    0.7.0.1
 */