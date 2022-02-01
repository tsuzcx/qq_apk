package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.util.Pair;
import com.tencent.util.UiThreadUtil;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map<Ljava.lang.String;Lcom.tencent.mobileqq.activity.photo.LocalMediaInfo;>;

public class SendByFile
{
  private long a = a();
  private long b = 1048576000L;
  private long c = 104345600L;
  private boolean d = true;
  
  public static void a(QQAppInterface paramQQAppInterface, List<String> paramList, String paramString, int paramInt)
  {
    if (paramQQAppInterface != null)
    {
      if (paramList == null) {
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        if (paramInt == 1) {
          paramQQAppInterface.getFileManagerEngine().a(str, paramString);
        } else if (paramInt == 10014) {
          paramQQAppInterface.getFileManagerEngine().e(str, paramString);
        } else {
          paramQQAppInterface.getFileManagerEngine().a(str, paramString, paramString, paramInt, true);
        }
      }
    }
  }
  
  protected int a()
  {
    return (int)((IPicBus)QRoute.api(IPicBus.class)).getC2CPicSizeLimit();
  }
  
  public SendByFile a(long paramLong)
  {
    this.a = paramLong;
    return this;
  }
  
  public SendByFile a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public Pair<ArrayList<String>, ArrayList<String>> a(List<String> paramList, boolean paramBoolean, Map<String, LocalMediaInfo> paramMap1, Map<String, LocalMediaInfo> paramMap2)
  {
    Pair localPair = new Pair(new ArrayList(), new ArrayList());
    if (paramList == null) {
      return localPair;
    }
    ((ArrayList)localPair.first).clear();
    ((ArrayList)localPair.second).clear();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (ImageManager.isNetworkUrl(str))
      {
        ((ArrayList)localPair.first).add(str);
      }
      else
      {
        paramList = null;
        if (paramMap1 != null) {
          paramList = (LocalMediaInfo)paramMap1.get(str);
        }
        Object localObject = paramList;
        if (paramList == null)
        {
          localObject = paramList;
          if (paramMap2 != null) {
            localObject = (LocalMediaInfo)paramMap2.get(str);
          }
        }
        if (localObject == null)
        {
          ((ArrayList)localPair.first).add(str);
        }
        else
        {
          int i = AlbumUtil.getMediaType((LocalMediaInfo)localObject);
          long l2 = ((LocalMediaInfo)localObject).fileSize;
          long l1 = l2;
          if (l2 <= 0L)
          {
            paramList = new File(str);
            l1 = l2;
            if (paramList.exists()) {
              l1 = paramList.length();
            }
          }
          if (i == 1)
          {
            if ((l1 <= this.b) && ((l1 <= this.c) || (!paramBoolean)))
            {
              ((ArrayList)localPair.first).add(str);
            }
            else if (this.d)
            {
              ((ArrayList)localPair.second).add(str);
              AlbumUtil.f();
            }
          }
          else if ((l1 > this.a) && (paramBoolean))
          {
            if (this.d) {
              ((ArrayList)localPair.second).add(str);
            }
          }
          else {
            ((ArrayList)localPair.first).add(str);
          }
        }
      }
    }
    return localPair;
  }
  
  public boolean a(Context paramContext, String paramString, boolean paramBoolean1, Map<String, LocalMediaInfo> paramMap1, Map<String, LocalMediaInfo> paramMap2, boolean paramBoolean2)
  {
    if (ImageManager.isNetworkUrl(paramString)) {
      return false;
    }
    Object localObject = null;
    if (paramMap1 != null) {
      localObject = (LocalMediaInfo)paramMap1.get(paramString);
    }
    paramMap1 = (Map<String, LocalMediaInfo>)localObject;
    if (localObject == null)
    {
      paramMap1 = (Map<String, LocalMediaInfo>)localObject;
      if (paramMap2 != null) {
        paramMap1 = (LocalMediaInfo)paramMap2.get(paramString);
      }
    }
    if (paramMap1 == null) {
      return false;
    }
    int i = AlbumUtil.getMediaType(paramMap1);
    long l2 = paramMap1.fileSize;
    long l1 = l2;
    if (l2 <= 0L)
    {
      paramString = new File(paramString);
      l1 = l2;
      if (paramString.exists()) {
        l1 = paramString.length();
      }
    }
    paramString = "";
    boolean bool = true;
    if (i == 1)
    {
      if ((l1 > this.b) || ((l1 > this.c) && (paramBoolean1)))
      {
        if (this.d)
        {
          paramBoolean1 = bool;
          if (!paramBoolean2) {
            break label586;
          }
          paramMap1 = new DecimalFormat("#.##");
          l2 = this.b;
          paramString = "M";
          double d1;
          if (l1 > l2)
          {
            double d2 = (float)l2 * 1.0F / 1024.0F / 1024.0F + 1.0F;
            d1 = d2;
            if (d2 > 1000.0D)
            {
              Double.isNaN(d2);
              d1 = d2 / 1024.0D;
              paramString = "G";
            }
          }
          else
          {
            d1 = this.c / 1024L / 1024L + 1L;
          }
          paramMap2 = paramContext.getResources().getString(2131886611);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("");
          ((StringBuilder)localObject).append(paramMap1.format(d1));
          paramString = String.format(paramMap2, new Object[] { ((StringBuilder)localObject).toString(), paramString });
          paramBoolean1 = bool;
          break label586;
        }
        paramBoolean1 = bool;
        if (!paramBoolean2) {
          break label586;
        }
        paramString = paramContext.getResources().getString(2131886612);
        paramMap1 = new StringBuilder();
        paramMap1.append("");
        paramMap1.append(this.c / 1024L / 1024L + 1L);
        paramString = String.format(paramString, new Object[] { paramMap1.toString() });
        paramBoolean1 = bool;
        break label586;
      }
    }
    else if ((l1 > this.a) && (paramBoolean1))
    {
      if (this.d)
      {
        paramBoolean1 = bool;
        if (!paramBoolean2) {
          break label586;
        }
        paramString = paramContext.getResources().getString(2131886559);
        paramMap1 = new StringBuilder();
        paramMap1.append("");
        paramMap1.append(this.a / 1024L / 1024L);
        paramString = String.format(paramString, new Object[] { paramMap1.toString() });
        paramBoolean1 = bool;
        break label586;
      }
      paramBoolean1 = bool;
      if (!paramBoolean2) {
        break label586;
      }
      paramString = paramContext.getResources().getString(2131886560);
      paramMap1 = new StringBuilder();
      paramMap1.append("");
      paramMap1.append(this.a / 1024L / 1024L);
      paramString = String.format(paramString, new Object[] { paramMap1.toString() });
      paramBoolean1 = bool;
      break label586;
    }
    paramBoolean1 = false;
    label586:
    paramMap1 = paramString;
    if (paramBoolean1)
    {
      paramMap1 = paramString;
      if (!paramBoolean2) {
        if (this.d) {
          paramMap1 = paramContext.getResources().getString(2131886473);
        } else {
          paramMap1 = paramContext.getResources().getString(2131886474);
        }
      }
    }
    if (paramBoolean1) {
      UiThreadUtil.a(new SendByFile.1(this, paramContext, paramMap1));
    }
    return paramBoolean1;
  }
  
  public boolean a(Context paramContext, List<String> paramList, boolean paramBoolean, Map<String, LocalMediaInfo> paramMap1, Map<String, LocalMediaInfo> paramMap2)
  {
    if (paramList == null) {
      return false;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (a(paramContext, (String)paramList.next(), paramBoolean, paramMap1, paramMap2, false)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.SendByFile
 * JD-Core Version:    0.7.0.1
 */