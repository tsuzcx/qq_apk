package com.tencent.thumbplayer.utils;

import android.content.Context;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.ArrayList;

public class TPDiskReadWrite
{
  public static final String TAG = "TPDiskReadWrite";
  private ArrayList<String> mKey = new ArrayList();
  private LocalCache mKeyCache = null;
  private String mKeyCacheName = null;
  private LocalCache mMessageCache = null;
  
  public TPDiskReadWrite(Context paramContext, String paramString)
  {
    this.mMessageCache = LocalCache.get(paramContext, paramString);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_key");
    this.mKeyCacheName = localStringBuilder.toString();
    this.mKeyCache = LocalCache.get(paramContext, this.mKeyCacheName);
  }
  
  public Object readAllFile()
  {
    try
    {
      localArrayList = (ArrayList)this.mKeyCache.getAsObject(this.mKeyCacheName);
      localObject1 = null;
      if (localArrayList == null) {
        break label134;
      }
      if (localArrayList.size() > 0) {
        break label149;
      }
    }
    finally
    {
      for (;;)
      {
        ArrayList localArrayList;
        Object localObject1;
        Object localObject3;
        Object localObject4;
        for (;;)
        {
          label134:
          throw localObject2;
        }
        label149:
        int i = 0;
        continue;
        i += 1;
      }
    }
    if (i < localArrayList.size())
    {
      localObject3 = (String)localArrayList.get(i);
      if (!TextUtils.isEmpty((CharSequence)localObject3))
      {
        localObject4 = this.mMessageCache.getAsObject((String)localObject3);
        if (localObject4 != null)
        {
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = new ArrayList();
          }
          ((ArrayList)localObject3).add(localObject4);
          localObject1 = localObject3;
        }
      }
    }
    else
    {
      this.mMessageCache.clear();
      this.mKeyCache.clear();
      this.mKey.clear();
      return localObject1;
      return null;
    }
  }
  
  public void rmFile(String paramString)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      this.mMessageCache.remove(paramString);
      this.mKey.remove(paramString);
      this.mKeyCache.remove(this.mKeyCacheName);
      this.mKeyCache.put(this.mKeyCacheName, this.mKey);
      return;
    }
    finally {}
  }
  
  public void writeFile(String paramString, Serializable paramSerializable)
  {
    if (paramSerializable != null) {
      try
      {
        if (!TextUtils.isEmpty(paramString))
        {
          this.mMessageCache.remove(paramString);
          this.mMessageCache.put(paramString, paramSerializable);
          this.mKey.remove(paramString);
          this.mKey.add(paramString);
          this.mKeyCache.remove(this.mKeyCacheName);
          this.mKeyCache.put(this.mKeyCacheName, this.mKey);
          return;
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.thumbplayer.utils.TPDiskReadWrite
 * JD-Core Version:    0.7.0.1
 */