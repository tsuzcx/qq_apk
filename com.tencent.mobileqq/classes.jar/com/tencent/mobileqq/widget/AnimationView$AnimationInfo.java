package com.tencent.mobileqq.widget;

import agwj;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import bace;
import com.tencent.qphone.base.util.QLog;
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
    int i = 0;
    if (!new File(paramString).exists()) {
      return 2;
    }
    String str = paramString + "Folder";
    File localFile = new File(str);
    if ((!localFile.exists()) && (!agwj.a(paramString, str))) {
      return 3;
    }
    paramString = localFile.listFiles();
    if ((paramString == null) || (paramString.length <= 0))
    {
      bace.a(str, false);
      return 4;
    }
    do
    {
      i += 1;
      if (i >= paramString.length) {
        break;
      }
    } while ((paramString[i] == null) || (!paramString[i].isFile()) || (!bace.e(paramString[i].getAbsolutePath())));
    return 1;
    return 5;
  }
  
  protected static AnimationInfo a(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    do
    {
      return null;
      try
      {
        paramFile = bace.b(paramFile);
        if (paramFile == null) {
          break;
        }
        paramFile = new String(paramFile, "UTF-8");
      }
      catch (Exception paramFile)
      {
        for (;;)
        {
          paramFile.printStackTrace();
          paramFile = null;
        }
      }
    } while (TextUtils.isEmpty(paramFile));
    return a(paramFile);
  }
  
  protected static AnimationInfo a(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    for (;;)
    {
      try
      {
        Object localObject = new JSONObject(paramString);
        int j = ((JSONObject)localObject).optInt("cycle", 0);
        int k = ((JSONObject)localObject).optInt("interval", 100);
        int m = ((JSONObject)localObject).optInt("delay", 100);
        paramString = new ArrayList();
        localObject = ((JSONObject)localObject).optJSONArray("play");
        if ((localObject != null) && (i < ((JSONArray)localObject).length()))
        {
          AnimationView.PlayItem localPlayItem = AnimationView.PlayItem.a(((JSONArray)localObject).getJSONObject(i));
          if (localPlayItem != null) {
            paramString.add(localPlayItem);
          }
        }
        else
        {
          if (paramString.size() <= 0) {
            break;
          }
          localObject = new AnimationInfo(j, k, m);
          ((AnimationInfo)localObject).mPlay = paramString;
          ((AnimationInfo)localObject).a();
          return localObject;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      i += 1;
    }
  }
  
  public static AnimationInfo loadFromFolder(String paramString)
  {
    int m = 0;
    int k = 0;
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = new File(paramString, "play.cfg");
    if (((File)localObject).exists()) {}
    for (localObject = a((File)localObject);; localObject = null)
    {
      if (localObject != null) {}
      for (ArrayList localArrayList1 = ((AnimationInfo)localObject).a();; localArrayList1 = null)
      {
        if ((localObject == null) || (localArrayList1 == null) || (localArrayList1.size() <= 0))
        {
          paramString = agwj.a(paramString);
          if ((paramString == null) || (paramString.length <= 0)) {
            return null;
          }
          localObject = new ArrayList();
          i = 0;
          while (i < paramString.length)
          {
            ((ArrayList)localObject).add(paramString[i]);
            i += 1;
          }
          return loadFromFrames((ArrayList)localObject, 100, 100);
        }
        paramString = new File(paramString).listFiles();
        if ((paramString == null) || (paramString.length <= 0))
        {
          if (QLog.isColorLevel()) {
            QLog.e("AnimationView", 2, "nothing in unzip folder");
          }
          return null;
        }
        agwj.a(paramString);
        ArrayList localArrayList2 = new ArrayList();
        int i = 0;
        while (i < paramString.length)
        {
          if ((paramString[i] != null) && (paramString[i].isFile()) && (bace.e(paramString[i].getAbsolutePath()))) {
            localArrayList2.add(paramString[i]);
          }
          i += 1;
        }
        SparseArray localSparseArray = new SparseArray();
        int j = 0;
        i = 0;
        if (j < localArrayList2.size())
        {
          if (!localArrayList1.contains(Integer.valueOf(j + 1))) {}
          for (;;)
          {
            j += 1;
            break;
            try
            {
              paramString = new BitmapDrawable(((File)localArrayList2.get(j)).getAbsolutePath());
              if ((i == 0) && (paramString != null) && (paramString.getBitmap() != null)) {
                break label424;
              }
              i = k;
              if (QLog.isColorLevel())
              {
                QLog.e("AnimationView", 2, "decode fail till" + ((File)localArrayList2.get(j)).getAbsolutePath());
                i = k;
              }
              while (i < localSparseArray.size())
              {
                agwj.a((Drawable)localSparseArray.valueAt(i));
                i += 1;
              }
            }
            catch (OutOfMemoryError paramString)
            {
              for (;;)
              {
                if (QLog.isColorLevel()) {
                  QLog.e("AnimationView", 2, "decode fail - OutOfMemoryError" + paramString);
                }
                i = 1;
                paramString = null;
              }
            }
            return null;
            label424:
            localSparseArray.append(j + 1, paramString);
          }
        }
        if (localArrayList1.size() != localSparseArray.size())
        {
          i = m;
          while (i < localSparseArray.size())
          {
            agwj.a((Drawable)localSparseArray.valueAt(i));
            i += 1;
          }
          return null;
        }
        ((AnimationInfo)localObject).mFrames = localSparseArray;
        return localObject;
      }
    }
  }
  
  public static AnimationInfo loadFromFrames(ArrayList<Drawable> paramArrayList, int paramInt1, int paramInt2)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
      return null;
    }
    AnimationInfo localAnimationInfo = new AnimationInfo(paramInt2, paramInt1, paramInt1);
    paramInt1 = 0;
    while (paramInt1 < paramArrayList.size())
    {
      localAnimationInfo.mPlay.add(new AnimationView.PlayItem(paramInt1 + 1));
      localAnimationInfo.mFrames.append(paramInt1 + 1, paramArrayList.get(paramInt1));
      paramInt1 += 1;
    }
    localAnimationInfo.a();
    return localAnimationInfo;
  }
  
  public static AnimationInfo loadFromZip(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (a(paramString) != 1) {
      return null;
    }
    return loadFromFolder(paramString + "Folder");
  }
  
  protected ArrayList<Integer> a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.mPlay != null) && (this.mPlay.size() > 0))
    {
      int i = 0;
      while (i < this.mPlay.size())
      {
        Object localObject = (AnimationView.PlayItem)this.mPlay.get(i);
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
    if (i < this.mPlay.size())
    {
      AnimationView.PlayItem localPlayItem = (AnimationView.PlayItem)this.mPlay.get(i);
      if (localPlayItem != null)
      {
        if (localPlayItem.mFrame <= 0) {
          break label79;
        }
        this.mOneCycleFrames.add(Integer.valueOf(localPlayItem.mFrame));
      }
      label79:
      do
      {
        do
        {
          i += 1;
          break;
        } while ((localPlayItem.mFrom <= 0) || (localPlayItem.mTo <= 0) || (localPlayItem.mTo <= localPlayItem.mFrom));
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
      } while (localPlayItem.mCycle != 0);
      this.mInfiniteFromInOnCycle = localPlayItem.mFrom;
      this.mInfiniteToInOnCycle = localPlayItem.mTo;
    }
  }
  
  public void destoryBitmaps()
  {
    int i = 0;
    while (i < this.mFrames.size())
    {
      agwj.a((Drawable)this.mFrames.valueAt(i));
      i += 1;
    }
    this.mFrames.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AnimationView.AnimationInfo
 * JD-Core Version:    0.7.0.1
 */