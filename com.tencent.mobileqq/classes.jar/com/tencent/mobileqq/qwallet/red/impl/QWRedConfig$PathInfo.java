package com.tencent.mobileqq.qwallet.red.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.qwallet.red.IQWalletRedService.ShowInfo;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class QWRedConfig$PathInfo
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  public String path;
  public List<QWRedConfig.RedInfo> redInfos = new LinkedList();
  
  public static PathInfo parseToPathInfo(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      String str = paramJSONObject.optString("path");
      if (TextUtils.isEmpty(str)) {
        return null;
      }
      PathInfo localPathInfo = new PathInfo();
      localPathInfo.path = str;
      paramJSONObject = paramJSONObject.optJSONArray("infos");
      if (paramJSONObject != null)
      {
        int i = 0;
        while (i < paramJSONObject.length())
        {
          QWRedConfig.RedInfo localRedInfo = QWRedConfig.RedInfo.parseToRedInfo(paramJSONObject.optJSONObject(i), str);
          if (localRedInfo != null) {
            localPathInfo.redInfos.add(localRedInfo);
          }
          i += 1;
        }
      }
      return localPathInfo;
    }
    catch (Throwable paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return null;
  }
  
  public List<QWRedConfig.RedInfo> getCurShowRedInfos()
  {
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.redInfos.iterator();
    int j = 0;
    int i = 0;
    int m;
    do
    {
      int k;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        QWRedConfig.RedInfo localRedInfo = (QWRedConfig.RedInfo)localIterator.next();
        k = j;
        m = i;
        if (localRedInfo.isShow()) {
          if ((localRedInfo.showPos == 2) && (j == 0))
          {
            localLinkedList.add(localRedInfo);
            k = 1;
            m = i;
          }
          else
          {
            k = j;
            m = i;
            if (localRedInfo.showPos == 0)
            {
              k = j;
              m = i;
              if (i == 0)
              {
                localLinkedList.add(localRedInfo);
                m = 1;
                k = j;
              }
            }
          }
        }
        j = k;
        i = m;
      } while (k == 0);
      j = k;
      i = m;
    } while (m == 0);
    return localLinkedList;
  }
  
  public IQWalletRedService.ShowInfo getShowInfo()
  {
    Iterator localIterator = this.redInfos.iterator();
    Object localObject2 = "";
    boolean bool2 = false;
    Object localObject1 = "";
    boolean bool1 = false;
    Object localObject3;
    boolean bool3;
    Object localObject4;
    boolean bool4;
    do
    {
      do
      {
        localObject3 = localObject2;
        bool3 = bool2;
        localObject4 = localObject1;
        bool4 = bool1;
        if (!localIterator.hasNext()) {
          break;
        }
        QWRedConfig.RedInfo localRedInfo = (QWRedConfig.RedInfo)localIterator.next();
        localObject3 = localObject2;
        bool3 = bool2;
        localObject4 = localObject1;
        bool4 = bool1;
        if (localRedInfo.isShow()) {
          if (localRedInfo.type == 0)
          {
            localObject3 = localObject2;
            bool3 = bool2;
            localObject4 = localObject1;
            bool4 = bool1;
            if (!bool2)
            {
              localObject4 = localRedInfo.buffer;
              bool3 = true;
              localObject3 = localObject2;
              bool4 = bool1;
            }
          }
          else
          {
            localObject3 = localObject2;
            bool3 = bool2;
            localObject4 = localObject1;
            bool4 = bool1;
            if (localRedInfo.type == 3)
            {
              localObject3 = localObject2;
              bool3 = bool2;
              localObject4 = localObject1;
              bool4 = bool1;
              if (!bool1)
              {
                localObject3 = localRedInfo.content;
                bool4 = true;
                localObject4 = localObject1;
                bool3 = bool2;
              }
            }
          }
        }
        localObject2 = localObject3;
        bool2 = bool3;
        localObject1 = localObject4;
        bool1 = bool4;
      } while (!bool3);
      localObject2 = localObject3;
      bool2 = bool3;
      localObject1 = localObject4;
      bool1 = bool4;
    } while (!bool4);
    return new IQWalletRedService.ShowInfo(bool3, bool4, (String)localObject3, (String)localObject4);
  }
  
  public boolean isMatchPath(String paramString)
  {
    if (!this.path.equals(paramString))
    {
      String str = this.path;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(".");
      localStringBuilder.append(paramString);
      if (!str.endsWith(localStringBuilder.toString())) {
        return false;
      }
    }
    return true;
  }
  
  public boolean isShow()
  {
    Iterator localIterator = this.redInfos.iterator();
    while (localIterator.hasNext()) {
      if (((QWRedConfig.RedInfo)localIterator.next()).isShow()) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PathInfo{path='");
    localStringBuilder.append(this.path);
    localStringBuilder.append('\'');
    localStringBuilder.append(", redInfos=");
    localStringBuilder.append(this.redInfos);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.red.impl.QWRedConfig.PathInfo
 * JD-Core Version:    0.7.0.1
 */