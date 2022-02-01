package com.tencent.mobileqq.widget;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AnimationTools;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AnimationView$AnimationInfo
{
  public static final int DEFAULT_FRAME_RATE = 100;
  public static final int ZIP_STATE_EMPTY_ZIP = 4;
  public static final int ZIP_STATE_NOT_EXIST = 2;
  public static final int ZIP_STATE_NO_IMAGE_FILE = 5;
  public static final int ZIP_STATE_UNZIP_FAILURE = 3;
  public static final int ZIP_STATE_VALID = 1;
  public int mCycle;
  public int mDelay;
  public SparseArray<Drawable> mFrames = new SparseArray();
  public int mInfiniteFromInOnCycle = -1;
  public int mInfiniteToInOnCycle = -1;
  public int mInterval;
  public ArrayList<Integer> mOneCycleFrames = new ArrayList();
  public ArrayList<AnimationView.PlayItem> mPlay = new ArrayList();
  
  public AnimationView$AnimationInfo()
  {
    this.mCycle = 0;
    this.mInterval = 100;
    this.mDelay = 100;
    this.mInfiniteFromInOnCycle = -1;
    this.mInfiniteToInOnCycle = -1;
  }
  
  public AnimationView$AnimationInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mCycle = paramInt1;
    this.mInterval = paramInt2;
    this.mDelay = paramInt3;
    if (this.mInterval <= 0) {
      this.mInterval = 100;
    }
    if (this.mDelay <= 0) {
      this.mDelay = 100;
    }
    this.mInfiniteFromInOnCycle = -1;
    this.mInfiniteToInOnCycle = -1;
  }
  
  protected static int a(String paramString)
  {
    if (!new File(paramString).exists()) {
      return 2;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("Folder");
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File((String)localObject);
    if ((!localFile.exists()) && (!AnimationTools.a(paramString, (String)localObject))) {
      return 3;
    }
    paramString = localFile.listFiles();
    int i = 0;
    if ((paramString != null) && (paramString.length > 0))
    {
      while (i < paramString.length)
      {
        if ((paramString[i] != null) && (paramString[i].isFile()) && (FileUtils.isPicFile(paramString[i].getAbsolutePath()))) {
          return 1;
        }
        i += 1;
      }
      return 5;
    }
    FileUtils.delete((String)localObject, false);
    return 4;
  }
  
  protected static AnimationInfo a(File paramFile)
  {
    if (paramFile != null)
    {
      if (!paramFile.exists()) {
        return null;
      }
      try
      {
        paramFile = FileUtils.getByte(paramFile);
        if (paramFile != null) {
          paramFile = new String(paramFile, "UTF-8");
        }
      }
      catch (Exception paramFile)
      {
        paramFile.printStackTrace();
        paramFile = null;
      }
      if (TextUtils.isEmpty(paramFile)) {
        return null;
      }
      return a(paramFile);
    }
    return null;
  }
  
  protected static AnimationInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new JSONObject(paramString);
        i = 0;
        int j = ((JSONObject)localObject).optInt("cycle", 0);
        int k = ((JSONObject)localObject).optInt("interval", 100);
        int m = ((JSONObject)localObject).optInt("delay", 100);
        paramString = new ArrayList();
        localObject = ((JSONObject)localObject).optJSONArray("play");
        if ((localObject != null) && (i < ((JSONArray)localObject).length()))
        {
          AnimationView.PlayItem localPlayItem = AnimationView.PlayItem.a(((JSONArray)localObject).getJSONObject(i));
          if (localPlayItem == null) {
            break label156;
          }
          paramString.add(localPlayItem);
          break label156;
        }
        if (paramString.size() > 0)
        {
          localObject = new AnimationInfo(j, k, m);
          ((AnimationInfo)localObject).mPlay = paramString;
          ((AnimationInfo)localObject).a();
          return localObject;
        }
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      return null;
      label156:
      i += 1;
    }
  }
  
  public static AnimationInfo loadFromFolder(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = new File(paramString, "play.cfg");
    if (((File)localObject).exists()) {
      localObject = a((File)localObject);
    } else {
      localObject = null;
    }
    ArrayList localArrayList1;
    if (localObject != null) {
      localArrayList1 = ((AnimationInfo)localObject).a();
    } else {
      localArrayList1 = null;
    }
    int m = 0;
    int i = 0;
    int k = 0;
    if ((localObject != null) && (localArrayList1 != null) && (localArrayList1.size() > 0))
    {
      paramString = new File(paramString).listFiles();
      if ((paramString != null) && (paramString.length > 0))
      {
        AnimationTools.a(paramString);
        ArrayList localArrayList2 = new ArrayList();
        i = 0;
        while (i < paramString.length)
        {
          if ((paramString[i] != null) && (paramString[i].isFile()) && (FileUtils.isPicFile(paramString[i].getAbsolutePath()))) {
            localArrayList2.add(paramString[i]);
          }
          i += 1;
        }
        SparseArray localSparseArray = new SparseArray();
        int j = 0;
        i = 0;
        while (j < localArrayList2.size())
        {
          int n = j + 1;
          if (localArrayList1.contains(Integer.valueOf(n)))
          {
            try
            {
              paramString = new BitmapDrawable(((File)localArrayList2.get(j)).getAbsolutePath());
            }
            catch (OutOfMemoryError paramString)
            {
              if (QLog.isColorLevel())
              {
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("decode fail - OutOfMemoryError");
                localStringBuilder.append(paramString);
                QLog.e("AnimationView", 2, localStringBuilder.toString());
              }
              i = 1;
              paramString = null;
            }
            if ((i == 0) && (paramString != null) && (paramString.getBitmap() != null)) {
              localSparseArray.append(n, paramString);
            }
          }
          else
          {
            j = n;
            continue;
          }
          i = k;
          if (QLog.isColorLevel())
          {
            paramString = new StringBuilder();
            paramString.append("decode fail till");
            paramString.append(((File)localArrayList2.get(j)).getAbsolutePath());
            QLog.e("AnimationView", 2, paramString.toString());
            i = k;
          }
          while (i < localSparseArray.size())
          {
            AnimationTools.a((Drawable)localSparseArray.valueAt(i));
            i += 1;
          }
          return null;
        }
        if (localArrayList1.size() != localSparseArray.size())
        {
          i = m;
          while (i < localSparseArray.size())
          {
            AnimationTools.a((Drawable)localSparseArray.valueAt(i));
            i += 1;
          }
          return null;
        }
        ((AnimationInfo)localObject).mFrames = localSparseArray;
        return localObject;
      }
      if (QLog.isColorLevel()) {
        QLog.e("AnimationView", 2, "nothing in unzip folder");
      }
      return null;
    }
    paramString = AnimationTools.a(paramString);
    if (paramString != null)
    {
      if (paramString.length <= 0) {
        return null;
      }
      localObject = new ArrayList();
      while (i < paramString.length)
      {
        ((ArrayList)localObject).add(paramString[i]);
        i += 1;
      }
      return loadFromFrames((ArrayList)localObject, 100, 100);
    }
    return null;
  }
  
  public static AnimationInfo loadFromFrames(ArrayList<Drawable> paramArrayList, int paramInt1, int paramInt2)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      AnimationInfo localAnimationInfo = new AnimationInfo(paramInt2, paramInt1, paramInt1);
      for (paramInt1 = 0; paramInt1 < paramArrayList.size(); paramInt1 = paramInt2)
      {
        ArrayList localArrayList = localAnimationInfo.mPlay;
        paramInt2 = paramInt1 + 1;
        localArrayList.add(new AnimationView.PlayItem(paramInt2));
        localAnimationInfo.mFrames.append(paramInt2, paramArrayList.get(paramInt1));
      }
      localAnimationInfo.a();
      return localAnimationInfo;
    }
    return null;
  }
  
  public static AnimationInfo loadFromZip(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (a(paramString) != 1) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("Folder");
    return loadFromFolder(localStringBuilder.toString());
  }
  
  protected ArrayList<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.mPlay;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      int i = 0;
      while (i < this.mPlay.size())
      {
        localObject = (AnimationView.PlayItem)this.mPlay.get(i);
        if (localObject != null)
        {
          localObject = ((AnimationView.PlayItem)localObject).getFrames();
          int j = 0;
          while (j < ((ArrayList)localObject).size())
          {
            if (!localArrayList.contains(((ArrayList)localObject).get(j))) {
              localArrayList.add(((ArrayList)localObject).get(j));
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  protected void a()
  {
    this.mInfiniteFromInOnCycle = -1;
    this.mInfiniteToInOnCycle = -1;
    this.mOneCycleFrames.clear();
    int i = 0;
    while (i < this.mPlay.size())
    {
      AnimationView.PlayItem localPlayItem = (AnimationView.PlayItem)this.mPlay.get(i);
      if (localPlayItem != null) {
        if (localPlayItem.mFrame > 0)
        {
          this.mOneCycleFrames.add(Integer.valueOf(localPlayItem.mFrame));
        }
        else if ((localPlayItem.mFrom > 0) && (localPlayItem.mTo > 0) && (localPlayItem.mTo > localPlayItem.mFrom))
        {
          int k = localPlayItem.mCycle;
          int j = k;
          if (k <= 0) {
            j = 1;
          }
          k = 0;
          while (k < j)
          {
            int m = localPlayItem.mFrom;
            while (m < localPlayItem.mTo + 1)
            {
              this.mOneCycleFrames.add(Integer.valueOf(m));
              m += 1;
            }
            k += 1;
          }
          if (localPlayItem.mCycle == 0)
          {
            this.mInfiniteFromInOnCycle = localPlayItem.mFrom;
            this.mInfiniteToInOnCycle = localPlayItem.mTo;
            return;
          }
        }
      }
      i += 1;
    }
  }
  
  public void destoryBitmaps()
  {
    int i = 0;
    while (i < this.mFrames.size())
    {
      AnimationTools.a((Drawable)this.mFrames.valueAt(i));
      i += 1;
    }
    this.mFrames.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AnimationView.AnimationInfo
 * JD-Core Version:    0.7.0.1
 */