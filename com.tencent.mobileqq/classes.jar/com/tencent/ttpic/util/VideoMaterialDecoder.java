package com.tencent.ttpic.util;

import android.os.AsyncTask;
import android.util.Log;
import com.tencent.common.VideoPngDecoder;
import com.tencent.ttpic.thread.VideoThreadPool;
import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class VideoMaterialDecoder
{
  public static final String MATERIAL_PREFIX = "video_";
  private static final String TAG = VideoMaterialDecoder.class.getSimpleName();
  private static VideoMaterialDecoder ins = new VideoMaterialDecoder();
  private List<DecodeVideoTask> mTaskList = new ArrayList();
  
  public static VideoMaterialDecoder getInstance()
  {
    return ins;
  }
  
  public void saveVideoMaterialToImages(String paramString)
  {
    Object localObject1 = VideoMaterialUtil.getMaterialId(paramString);
    if ((localObject1 == null) || (!((String)localObject1).startsWith("video_"))) {}
    Object localObject2;
    do
    {
      do
      {
        return;
        paramString = new File(paramString).listFiles();
      } while (paramString == null);
      this.mTaskList.clear();
      int j = paramString.length;
      int i = 0;
      if (i < j)
      {
        localObject1 = paramString[i];
        if (!((File)localObject1).isDirectory()) {}
        for (;;)
        {
          i += 1;
          break;
          localObject2 = ((File)localObject1).listFiles(new FilenameFilter()
          {
            public boolean accept(File paramAnonymousFile, String paramAnonymousString)
            {
              return paramAnonymousString.endsWith(".mp4");
            }
          });
          if (localObject2 != null) {
            this.mTaskList.add(new DecodeVideoTask((File)localObject1, (File[])localObject2));
          }
        }
      }
    } while (this.mTaskList.size() == 0);
    paramString = new CountDownLatch(this.mTaskList.size());
    localObject1 = this.mTaskList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DecodeVideoTask)((Iterator)localObject1).next();
      ((DecodeVideoTask)localObject2).setCountDownLatch(paramString);
      ((DecodeVideoTask)localObject2).executeOnExecutor(VideoThreadPool.getInstance().getDualThreadExecutor(), new Void[0]);
    }
    try
    {
      paramString.await();
      return;
    }
    catch (InterruptedException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private static class DecodeVideoTask
    extends AsyncTask<Void, Integer, Boolean>
  {
    private CountDownLatch countDownLatch;
    private final File dir;
    private final File[] files;
    
    public DecodeVideoTask(File paramFile, File[] paramArrayOfFile)
    {
      this.dir = paramFile;
      this.files = paramArrayOfFile;
    }
    
    protected Boolean doInBackground(Void... paramVarArgs)
    {
      for (;;)
      {
        int i;
        int k;
        try
        {
          paramVarArgs = this.files;
          int m = paramVarArgs.length;
          i = 0;
          if (i < m)
          {
            Object localObject1 = paramVarArgs[i];
            VideoFileUtil.deleteFiles(this.dir.getAbsolutePath(), ".png");
            RandomAccessFile localRandomAccessFile = new RandomAccessFile(((File)localObject1).getAbsoluteFile(), "r");
            long l = localRandomAccessFile.length();
            localRandomAccessFile.seek(l - 4L);
            Object localObject2 = new byte[4];
            localRandomAccessFile.read((byte[])localObject2);
            int j = ByteUtil.readInt((byte[])localObject2);
            if ((j <= 12) || (j >= 400))
            {
              localRandomAccessFile.close();
            }
            else
            {
              localRandomAccessFile.seek(l - j + 8L);
              int n = (j - 12) / 4;
              int[] arrayOfInt = new int[n];
              j = 0;
              if (j < n)
              {
                localRandomAccessFile.read((byte[])localObject2);
                arrayOfInt[j] = ByteUtil.readInt((byte[])localObject2);
                j += 1;
                continue;
              }
              localObject1 = new VideoPngDecoder(((File)localObject1).getAbsolutePath());
              j = 0;
              k = 0;
              localObject2 = new ArrayList();
              if (k == 0)
              {
                ((List)localObject2).clear();
                k = 0;
                if (k < n)
                {
                  if (arrayOfInt[k] != j) {
                    break label393;
                  }
                  ((List)localObject2).add(this.dir.getAbsolutePath() + File.separator + VideoMaterialUtil.getMaterialId(this.dir.getAbsolutePath()) + "_" + k + ".png");
                  break label393;
                }
                k = ((VideoPngDecoder)localObject1).getNextPngFrame((List)localObject2);
                j += 1;
                continue;
              }
              ((VideoPngDecoder)localObject1).release();
              localRandomAccessFile.close();
            }
          }
        }
        catch (Exception paramVarArgs)
        {
          Log.e(VideoMaterialDecoder.TAG, paramVarArgs.toString());
          return Boolean.valueOf(true);
          if (this.countDownLatch == null) {
            continue;
          }
          this.countDownLatch.countDown();
          continue;
        }
        finally
        {
          if (this.countDownLatch != null) {
            this.countDownLatch.countDown();
          }
        }
        i += 1;
        continue;
        label393:
        k += 1;
      }
    }
    
    public void setCountDownLatch(CountDownLatch paramCountDownLatch)
    {
      this.countDownLatch = paramCountDownLatch;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoMaterialDecoder
 * JD-Core Version:    0.7.0.1
 */