package com.tencent.mobileqq.filemanager.data;

import android.content.res.Resources;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FMDataCache
{
  public static int a = 2;
  public static int b = 4;
  private static Set<FileInfo> c = new HashSet();
  private static ArrayList<WeiYunFileInfo> d = new ArrayList();
  private static ArrayList<OfflineFileInfo> e = new ArrayList();
  private static ArrayList<FileManagerEntity> f = new ArrayList();
  private static ArrayList<FavFileInfo> g = new ArrayList();
  private static int h = 20;
  private static long i = 0L;
  private static ArrayList<FileInfo> j = new ArrayList();
  private static ArrayList<String> k = new ArrayList();
  private static int l = 0;
  private static Map<String, FMDataCache.TmpSignature> m = new HashMap();
  
  public static ArrayList<FileInfo> a()
  {
    return j;
  }
  
  public static void a(int paramInt)
  {
    h = paramInt;
  }
  
  public static void a(long paramLong)
  {
    i = paramLong;
  }
  
  public static void a(FavFileInfo paramFavFileInfo)
  {
    if (!c(paramFavFileInfo.f)) {
      return;
    }
    g.add(paramFavFileInfo);
  }
  
  public static void a(String paramString, byte[] paramArrayOfByte)
  {
    FMDataCache.TmpSignature localTmpSignature = new FMDataCache.TmpSignature();
    localTmpSignature.a = paramString;
    localTmpSignature.b = paramArrayOfByte;
    m.put(paramString, localTmpSignature);
  }
  
  public static void a(ArrayList<FileInfo> paramArrayList)
  {
    j.clear();
    j.addAll(paramArrayList);
  }
  
  public static void a(List<FileInfo> paramList)
  {
    c.addAll(paramList);
  }
  
  public static boolean a(FileInfo paramFileInfo)
  {
    return c.contains(paramFileInfo);
  }
  
  public static boolean a(FileManagerEntity paramFileManagerEntity)
  {
    return f.contains(paramFileManagerEntity);
  }
  
  public static boolean a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    Iterator localIterator = d.iterator();
    while (localIterator.hasNext()) {
      if (((WeiYunFileInfo)localIterator.next()).a.equals(paramWeiYunFileInfo.a)) {
        return true;
      }
    }
    return false;
  }
  
  public static void b()
  {
    j.clear();
  }
  
  public static void b(int paramInt)
  {
    l = paramInt | l;
  }
  
  public static void b(long paramLong)
  {
    Iterator localIterator = g.iterator();
    while (localIterator.hasNext())
    {
      FavFileInfo localFavFileInfo = (FavFileInfo)localIterator.next();
      if (localFavFileInfo.a == paramLong) {
        g.remove(localFavFileInfo);
      }
    }
  }
  
  public static void b(FavFileInfo paramFavFileInfo)
  {
    Iterator localIterator = g.iterator();
    while (localIterator.hasNext())
    {
      FavFileInfo localFavFileInfo = (FavFileInfo)localIterator.next();
      if (localFavFileInfo.c.equals(paramFavFileInfo.c)) {
        g.remove(localFavFileInfo);
      }
    }
  }
  
  public static void b(FileInfo paramFileInfo)
  {
    if (!c(paramFileInfo.f())) {
      return;
    }
    if (c.contains(paramFileInfo)) {
      return;
    }
    c.add(paramFileInfo);
  }
  
  public static void b(FileManagerEntity paramFileManagerEntity)
  {
    if (!c(paramFileManagerEntity.fileSize)) {
      return;
    }
    f.add(paramFileManagerEntity);
  }
  
  public static void b(WeiYunFileInfo paramWeiYunFileInfo)
  {
    if (!c(paramWeiYunFileInfo.d)) {
      return;
    }
    d.add(paramWeiYunFileInfo);
  }
  
  public static long c()
  {
    return i;
  }
  
  public static void c(FileInfo paramFileInfo)
  {
    c.remove(paramFileInfo);
  }
  
  public static void c(FileManagerEntity paramFileManagerEntity)
  {
    f.remove(paramFileManagerEntity);
  }
  
  public static void c(WeiYunFileInfo paramWeiYunFileInfo)
  {
    Iterator localIterator = d.iterator();
    while (localIterator.hasNext())
    {
      WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)localIterator.next();
      if (localWeiYunFileInfo.a.equals(paramWeiYunFileInfo.a)) {
        d.remove(localWeiYunFileInfo);
      }
    }
  }
  
  public static boolean c(int paramInt)
  {
    return (l & paramInt) == paramInt;
  }
  
  private static boolean c(long paramLong)
  {
    if ((h > 0) && (e() >= h))
    {
      FMToastUtil.d(String.format(BaseApplication.getContext().getResources().getString(2131889574), new Object[] { Integer.valueOf(h) }));
      return false;
    }
    if ((i > 0L) && (m() + paramLong > i))
    {
      String str = BaseApplication.getContext().getResources().getString(2131889581);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(FileUtil.a(i));
      FMToastUtil.d(localStringBuilder.toString());
      return false;
    }
    return true;
  }
  
  public static boolean c(FavFileInfo paramFavFileInfo)
  {
    Iterator localIterator = g.iterator();
    while (localIterator.hasNext()) {
      if (((FavFileInfo)localIterator.next()).c.equals(paramFavFileInfo.c)) {
        return true;
      }
    }
    return false;
  }
  
  public static void d()
  {
    c.clear();
    f.clear();
    e.clear();
    d.clear();
    g.clear();
    o();
  }
  
  public static boolean d(FileInfo paramFileInfo)
  {
    paramFileInfo = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getExtension(paramFileInfo.e());
    if (paramFileInfo != null)
    {
      if (paramFileInfo.length() == 0) {
        return false;
      }
      paramFileInfo = paramFileInfo.toLowerCase();
      return ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsFile(paramFileInfo);
    }
    return false;
  }
  
  public static boolean d(FileManagerEntity paramFileManagerEntity)
  {
    paramFileManagerEntity = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getExtension(paramFileManagerEntity.fileName);
    if (paramFileManagerEntity != null)
    {
      if (paramFileManagerEntity.length() == 0) {
        return false;
      }
      paramFileManagerEntity = paramFileManagerEntity.toLowerCase();
      return ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsFile(paramFileManagerEntity);
    }
    return false;
  }
  
  public static long e()
  {
    return c.size() + f.size() + e.size() + d.size() + g.size();
  }
  
  public static boolean f()
  {
    Iterator localIterator = f.iterator();
    while (localIterator.hasNext()) {
      if (((FileManagerEntity)localIterator.next()).nFileType == 13) {
        return true;
      }
    }
    return false;
  }
  
  public static Set<FileInfo> g()
  {
    return c;
  }
  
  public static ArrayList<FileManagerEntity> h()
  {
    return f;
  }
  
  public static ArrayList<OfflineFileInfo> i()
  {
    return e;
  }
  
  public static ArrayList<WeiYunFileInfo> j()
  {
    return d;
  }
  
  public static ArrayList<FavFileInfo> k()
  {
    return g;
  }
  
  public static long l()
  {
    Object localObject = c.iterator();
    for (long l1 = 0L; ((Iterator)localObject).hasNext(); l1 += ((FileInfo)((Iterator)localObject).next()).f()) {}
    localObject = (IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class);
    Iterator localIterator = f.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      if (((IQQFileTempUtils)localObject).bShowFlowDialog(localFileManagerEntity, false)) {
        l1 += ((IQQFileTempUtils)localObject).getFileSize(localFileManagerEntity.getFilePath());
      }
    }
    return l1;
  }
  
  public static long m()
  {
    Iterator localIterator = c.iterator();
    for (long l1 = 0L; localIterator.hasNext(); l1 += ((FileInfo)localIterator.next()).f()) {}
    localIterator = d.iterator();
    while (localIterator.hasNext()) {
      l1 += ((WeiYunFileInfo)localIterator.next()).d;
    }
    localIterator = e.iterator();
    while (localIterator.hasNext()) {
      l1 += ((OfflineFileInfo)localIterator.next()).g;
    }
    localIterator = f.iterator();
    while (localIterator.hasNext()) {
      l1 += ((FileManagerEntity)localIterator.next()).fileSize;
    }
    localIterator = g.iterator();
    while (localIterator.hasNext()) {
      l1 += ((FavFileInfo)localIterator.next()).f;
    }
    return l1;
  }
  
  public static long n()
  {
    Iterator localIterator = d.iterator();
    for (long l1 = 0L; localIterator.hasNext(); l1 += ((WeiYunFileInfo)localIterator.next()).d) {}
    localIterator = e.iterator();
    while (localIterator.hasNext()) {
      l1 += ((OfflineFileInfo)localIterator.next()).g;
    }
    localIterator = f.iterator();
    while (localIterator.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)localIterator.next();
      int n = localFileManagerEntity.getCloudType();
      if ((n == 1) || (n == 2)) {
        l1 += localFileManagerEntity.fileSize;
      }
    }
    return l1;
  }
  
  public static void o()
  {
    l = 0;
  }
  
  public static boolean p()
  {
    if (e() == 0L) {
      return false;
    }
    if (d.size() > 0) {
      return false;
    }
    Iterator localIterator = c.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (FileInfo)localIterator.next();
      localObject = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getExtension(((FileInfo)localObject).e());
      if (localObject != null)
      {
        if (((String)localObject).length() == 0) {
          return false;
        }
        localObject = ((String)localObject).toLowerCase();
        if (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsFile((String)localObject)) {
          break;
        }
      }
      else
      {
        return false;
      }
    }
    localIterator = f.iterator();
    while (localIterator.hasNext())
    {
      localObject = (FileManagerEntity)localIterator.next();
      localObject = ((IQQFileTempUtils)QRoute.api(IQQFileTempUtils.class)).getExtension(((FileManagerEntity)localObject).fileName);
      if (localObject != null)
      {
        if (((String)localObject).length() == 0) {
          return false;
        }
        localObject = ((String)localObject).toLowerCase();
        if (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isDocsFile((String)localObject)) {
          break;
        }
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public static boolean q()
  {
    if (e() == 0L) {
      return false;
    }
    Iterator localIterator = c.iterator();
    while (localIterator.hasNext()) {
      if (d((FileInfo)localIterator.next())) {
        return true;
      }
    }
    localIterator = f.iterator();
    while (localIterator.hasNext()) {
      if (d((FileManagerEntity)localIterator.next())) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FMDataCache
 * JD-Core Version:    0.7.0.1
 */