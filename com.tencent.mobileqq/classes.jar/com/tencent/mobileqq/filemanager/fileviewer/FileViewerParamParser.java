package com.tencent.mobileqq.filemanager.fileviewer;

import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.TeamWorkExportUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FileViewerParamParser
{
  private QQAppInterface a;
  private FileManagerEntity b;
  private List<IFileViewerAdapter> c;
  private IFileViewerAdapter d;
  private int e = 0;
  private int f = 0;
  private String g;
  
  FileViewerParamParser(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  private FileManagerEntity a(WeiYunFileInfo paramWeiYunFileInfo)
  {
    FileManagerEntity localFileManagerEntity = new FileManagerEntity();
    localFileManagerEntity.WeiYunDirKey = paramWeiYunFileInfo.b;
    localFileManagerEntity.WeiYunFileId = paramWeiYunFileInfo.a;
    localFileManagerEntity.fileName = paramWeiYunFileInfo.c;
    localFileManagerEntity.strLargeThumPath = paramWeiYunFileInfo.i;
    localFileManagerEntity.strFileSHA = paramWeiYunFileInfo.n;
    localFileManagerEntity.strFileMd5 = paramWeiYunFileInfo.m;
    localFileManagerEntity.lastTime = paramWeiYunFileInfo.e;
    localFileManagerEntity.srvTime = paramWeiYunFileInfo.e;
    localFileManagerEntity.fileSize = paramWeiYunFileInfo.d;
    localFileManagerEntity.nFileType = 0;
    localFileManagerEntity.cloudType = 2;
    return localFileManagerEntity;
  }
  
  private static boolean a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0) {
      return false;
    }
    return paramInt2 != 0;
  }
  
  private boolean a(Intent paramIntent, ForwardFileInfo paramForwardFileInfo)
  {
    boolean bool;
    if (paramIntent.getBooleanExtra("is_in_zip", false))
    {
      bool = a(paramForwardFileInfo);
    }
    else
    {
      switch (paramForwardFileInfo.c())
      {
      case 10005: 
      case 10008: 
      default: 
        if (QLog.isDevelopLevel())
        {
          paramIntent = new StringBuilder();
          paramIntent.append("parseImageGallery: type[");
          paramIntent.append(paramForwardFileInfo.c());
          paramIntent.append("] is not implemented");
          QLog.w("FileViewerParamParser", 4, paramIntent.toString());
        }
        break;
      case 10010: 
        bool = g();
        break;
      case 10009: 
        bool = e(paramIntent);
        break;
      case 10007: 
        bool = f();
        break;
      case 10004: 
        bool = d(paramIntent);
        break;
      case 10003: 
        bool = c(paramIntent);
        break;
      case 10002: 
        if (QLog.isDevelopLevel()) {
          QLog.w("FileViewerParamParser", 4, "parseImageGallery: not support OfflineFile type");
        }
        break;
      case 10001: 
        bool = e();
        break;
      case 10000: 
      case 10006: 
        bool = b(paramIntent);
        break;
      }
      bool = false;
    }
    this.f = 1;
    if (!bool)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("parseImageGallery type[");
      paramIntent.append(paramForwardFileInfo.c());
      paramIntent.append("] return false");
      QLog.e("FileViewerParamParser", 1, paramIntent.toString());
      return bool;
    }
    if (this.c.size() == 0)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("parseImageGallery type[");
      paramIntent.append(paramForwardFileInfo.c());
      paramIntent.append("] list is empty");
      QLog.e("FileViewerParamParser", 1, paramIntent.toString());
      bool = false;
    }
    return bool;
  }
  
  private boolean a(ForwardFileInfo paramForwardFileInfo)
  {
    paramForwardFileInfo = paramForwardFileInfo.m();
    this.c = new ArrayList();
    paramForwardFileInfo = paramForwardFileInfo.iterator();
    int i = 0;
    while (paramForwardFileInfo.hasNext())
    {
      Object localObject = (Long)paramForwardFileInfo.next();
      localObject = this.a.getFileManagerDataCenter().b(((Long)localObject).longValue());
      if (localObject != null)
      {
        if (FileUtil.b(((FileManagerEntity)localObject).getFilePath())) {
          ((FileManagerEntity)localObject).status = 1;
        }
        if (((FileManagerEntity)localObject).nSessionId == this.b.nSessionId) {
          this.e = i;
        } else {
          if (!a(((FileManagerEntity)localObject).nFileType, ((FileManagerEntity)localObject).getCloudType())) {
            continue;
          }
        }
        i += 1;
        this.c.add(FileViewerAdapterBase.a(this.a, (FileManagerEntity)localObject));
      }
    }
    return true;
  }
  
  private boolean b(Intent paramIntent)
  {
    Object localObject = ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getFileViewerLocalFiles();
    int j = 0;
    if (localObject != null)
    {
      if (((ArrayList)localObject).size() == 0) {
        return false;
      }
      int k = paramIntent.getIntExtra("clicked_file_hashcode", 0);
      this.c = new ArrayList();
      paramIntent = ((ArrayList)localObject).iterator();
      int i = 0;
      while (paramIntent.hasNext())
      {
        localObject = (FileInfo)paramIntent.next();
        if ((j == 0) && (((FileInfo)localObject).hashCode() == k))
        {
          this.e = i;
          this.c.add(FileViewerAdapterBase.a(this.a, this.b));
          j = 1;
        }
        else
        {
          this.c.add(FileViewerAdapterBase.a((FileInfo)localObject));
        }
        i += 1;
      }
      ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).clearFileViewerLocalFiles();
      return true;
    }
    return false;
  }
  
  private boolean c(Intent paramIntent)
  {
    paramIntent = paramIntent.getParcelableArrayListExtra("local_weiyun_list");
    int i = 0;
    if (paramIntent != null)
    {
      if (paramIntent.size() == 0) {
        return false;
      }
      this.c = new ArrayList();
      paramIntent = paramIntent.iterator();
      while (paramIntent.hasNext())
      {
        WeiYunFileInfo localWeiYunFileInfo = (WeiYunFileInfo)paramIntent.next();
        if ((localWeiYunFileInfo.a != null) && (localWeiYunFileInfo.a.equalsIgnoreCase(this.b.WeiYunFileId))) {
          this.e = i;
        } else {
          if ((FileManagerUtil.c(localWeiYunFileInfo.c) != 0) && ((!localWeiYunFileInfo.o) || (!localWeiYunFileInfo.c.toLowerCase().endsWith("heic")))) {
            continue;
          }
        }
        i += 1;
        this.c.add(FileViewerAdapterBase.a(this.a, localWeiYunFileInfo));
      }
      return true;
    }
    return false;
  }
  
  private boolean d(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringArrayListExtra("Aio_Uinseq_ImageList");
    int i = 0;
    if (paramIntent == null) {
      return false;
    }
    this.c = new ArrayList();
    paramIntent = paramIntent.iterator();
    while (paramIntent.hasNext())
    {
      long l = Long.parseLong((String)paramIntent.next());
      FileManagerEntity localFileManagerEntity = this.a.getFileManagerDataCenter().a(l, this.b.peerUin, this.b.peerType, -1L);
      if (localFileManagerEntity != null)
      {
        if (localFileManagerEntity.nSessionId == this.b.nSessionId) {
          this.e = i;
        } else {
          if (!a(localFileManagerEntity.nFileType, localFileManagerEntity.getCloudType())) {
            continue;
          }
        }
        i += 1;
        this.c.add(FileViewerAdapterBase.a(this.a, localFileManagerEntity));
      }
    }
    return true;
  }
  
  private boolean e()
  {
    Object localObject = this.a.getFileManagerProxy().b();
    int i = 0;
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return false;
      }
      this.c = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
        String str = this.g;
        if ((str == null) || (str.trim().length() == 0) || (this.g.equals(localFileManagerEntity.peerUin)))
        {
          if (localFileManagerEntity.nSessionId == this.b.nSessionId) {
            this.e = i;
          } else {
            if (!a(localFileManagerEntity.nFileType, localFileManagerEntity.getCloudType())) {
              continue;
            }
          }
          i += 1;
          this.c.add(FileViewerAdapterBase.a(this.a, localFileManagerEntity));
        }
      }
      return true;
    }
    return false;
  }
  
  private boolean e(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringArrayListExtra("Aio_SessionId_ImageList");
    int i = 0;
    if (paramIntent == null) {
      return false;
    }
    this.c = new ArrayList();
    paramIntent = paramIntent.iterator();
    while (paramIntent.hasNext())
    {
      long l = Long.parseLong((String)paramIntent.next());
      FileManagerEntity localFileManagerEntity = this.a.getFileManagerDataCenter().a(0L, "", 0, l);
      if (localFileManagerEntity != null)
      {
        if (localFileManagerEntity.nSessionId == this.b.nSessionId) {
          this.e = i;
        } else {
          if (!a(localFileManagerEntity.nFileType, localFileManagerEntity.getCloudType())) {
            continue;
          }
        }
        i += 1;
        this.c.add(FileViewerAdapterBase.a(this.a, localFileManagerEntity));
      }
    }
    return true;
  }
  
  private boolean f()
  {
    Object localObject3 = ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getRecentFiles();
    Object localObject2 = ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getLocalFiles();
    Object localObject1 = ((IFMDataCacheApi)QRoute.api(IFMDataCacheApi.class)).getWeiYunFiles();
    this.c = new ArrayList();
    if ((localObject3 != null) && (((ArrayList)localObject3).size() > 0))
    {
      localObject3 = ((ArrayList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject3).next();
        if (localFileManagerEntity.nFileType == 0) {
          this.c.add(FileViewerAdapterBase.a(this.a, localFileManagerEntity));
        }
      }
    }
    if ((localObject2 != null) && (((Set)localObject2).size() > 0))
    {
      localObject2 = ((Set)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FileInfo)((Iterator)localObject2).next();
        if (((FileInfo)localObject3).l() == 0) {
          this.c.add(FileViewerAdapterBase.a((FileInfo)localObject3));
        }
      }
    }
    if ((localObject1 != null) && (((ArrayList)localObject1).size() > 0))
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (WeiYunFileInfo)((Iterator)localObject1).next();
        if (FileManagerUtil.c(((WeiYunFileInfo)localObject2).c) == 0) {
          this.c.add(FileViewerAdapterBase.a(this.a, (WeiYunFileInfo)localObject2));
        }
      }
    }
    return this.c.size() > 0;
  }
  
  private boolean g()
  {
    Object localObject = this.a.getFileManagerProxy().b();
    int i = 0;
    if (localObject != null)
    {
      if (((List)localObject).size() == 0) {
        return false;
      }
      this.c = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject).next();
        if ((5 == localFileManagerEntity.getCloudType()) && (this.b.nOlSenderProgress == localFileManagerEntity.nOlSenderProgress))
        {
          String str = this.g;
          if ((str == null) || (str.trim().length() == 0) || (this.g.equals(localFileManagerEntity.peerUin)))
          {
            if (localFileManagerEntity.nSessionId == this.b.nSessionId) {
              this.e = i;
            } else {
              if (!a(localFileManagerEntity.nFileType, localFileManagerEntity.getCloudType())) {
                continue;
              }
            }
            i += 1;
            this.c.add(FileViewerAdapterBase.a(this.a, localFileManagerEntity));
          }
        }
      }
      return true;
    }
    return false;
  }
  
  public int a()
  {
    return this.f;
  }
  
  public FileBrowserManager.IModelCreater a(BaseActivity paramBaseActivity)
  {
    return new FileViewerParamParser.1(this, paramBaseActivity);
  }
  
  public void a(String paramString)
  {
    this.g = paramString;
  }
  
  public boolean a(Intent paramIntent)
  {
    ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)paramIntent.getParcelableExtra("fileinfo");
    if (localForwardFileInfo == null) {
      return false;
    }
    long l = localForwardFileInfo.e();
    this.b = this.a.getFileManagerDataCenter().a(l);
    if (this.b == null) {
      if (localForwardFileInfo.o() == 9)
      {
        this.b = TeamWorkExportUtil.a(localForwardFileInfo);
      }
      else
      {
        localObject = localForwardFileInfo.l();
        if (localObject != null) {
          this.b = a((WeiYunFileInfo)localObject);
        }
      }
    }
    Object localObject = this.b;
    if (localObject == null)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("FileViewerParamParsernot found, bug. sessionid:");
      paramIntent.append(String.valueOf(l));
      QLog.e("FileViewerParamParser", 1, paramIntent.toString());
      return false;
    }
    if (5 != ((FileManagerEntity)localObject).cloudType) {
      FileManagerUtil.e(this.b);
    }
    if (a(this.b.nFileType, this.b.getCloudType()))
    {
      boolean bool = a(paramIntent, localForwardFileInfo);
      if (!bool)
      {
        paramIntent = this.c;
        if (((paramIntent == null) || (paramIntent.size() <= 0)) && (localForwardFileInfo != null) && (this.b != null))
        {
          this.c = new ArrayList();
          this.e = 0;
          this.c.add(FileViewerAdapterBase.a(this.a, this.b));
          return true;
        }
      }
      return bool;
    }
    this.d = FileViewerAdapterBase.a(this.a, this.b);
    this.f = 3;
    return true;
  }
  
  public int b()
  {
    return this.e;
  }
  
  public List<IFileViewerAdapter> c()
  {
    return this.c;
  }
  
  public IFileViewerAdapter d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileViewerParamParser
 * JD-Core Version:    0.7.0.1
 */