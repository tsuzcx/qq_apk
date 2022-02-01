package com.tencent.ttpic.cache;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.util.ByteUtil;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Map;

public class LoadVideoTask2
  extends AsyncTask<Void, Integer, Boolean>
{
  private static final String TAG = LoadVideoTask2.class.getSimpleName();
  private Map<String, Bitmap> cache;
  private final String dataPath;
  private final String itemId;
  private final String materialId;
  private final int sampleSize;
  
  public LoadVideoTask2(Map<String, Bitmap> paramMap, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.cache = paramMap;
    this.dataPath = paramString1;
    this.itemId = paramString2;
    this.materialId = paramString3;
    this.sampleSize = paramInt;
  }
  
  protected Boolean doInBackground(Void... paramVarArgs)
  {
    int i = 0;
    try
    {
      paramVarArgs = new RandomAccessFile(this.dataPath + File.separator + this.itemId + File.separator + this.itemId + ".mp4", "r");
      long l = paramVarArgs.length();
      paramVarArgs.seek(l - 4L);
      byte[] arrayOfByte = new byte[4];
      paramVarArgs.read(arrayOfByte);
      int j = ByteUtil.readInt(arrayOfByte);
      if ((j <= 12) || (j >= 400))
      {
        paramVarArgs.close();
        return Boolean.valueOf(false);
      }
      paramVarArgs.seek(l - j + 8L);
      j = (j - 12) / 4;
      int[] arrayOfInt = new int[j];
      while (i < j)
      {
        paramVarArgs.read(arrayOfByte);
        arrayOfInt[i] = ByteUtil.readInt(arrayOfByte);
        i += 1;
      }
      paramVarArgs.close();
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        paramVarArgs = paramVarArgs;
        LogUtils.e(TAG, paramVarArgs.toString());
      }
    }
    finally {}
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.cache.LoadVideoTask2
 * JD-Core Version:    0.7.0.1
 */