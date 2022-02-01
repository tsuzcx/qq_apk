package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.filemanager.api.IExcitingTransferAdapter;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.IFileHttpBase;
import com.tencent.mobileqq.filemanager.excitingtransfer.downloader.c2cdownloader.C2CFileDownloader;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.filemanager.fileviewer.data.VideoForC2C;
import com.tencent.mobileqq.filemanager.fileviewer.data.VideoForDisc;
import com.tencent.mobileqq.filemanager.guild.GuildFileDownloader;
import com.tencent.mobileqq.filemanager.guild.VideoForGuild;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.managers.ShieldMsgManger;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.Utils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

public class FileManagerRSCenter
{
  QQAppInterface a;
  private FMObserver b = new FileManagerRSCenter.1(this);
  private LinkedHashMap<Long, IFileHttpBase> c = new LinkedHashMap();
  
  public FileManagerRSCenter(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.a.getFileManagerNotifyCenter().addObserver(this.b);
  }
  
  public int a(long paramLong1, String paramString, int paramInt, long paramLong2)
  {
    try
    {
      IFileHttpBase localIFileHttpBase = (IFileHttpBase)this.c.get(Long.valueOf(paramLong2));
      if (localIFileHttpBase != null)
      {
        paramInt = localIFileHttpBase.h();
        return paramInt;
      }
      paramString = this.a.getFileManagerDataCenter().a(paramLong1, paramString, paramInt, paramLong2);
      if (paramString == null) {
        return -1;
      }
      if ((IFileHttpBase)this.c.get(Long.valueOf(paramString.nSessionId)) != null)
      {
        paramInt = paramString.status;
        return paramInt;
      }
      if (QFileAssistantUtils.a(paramString.peerUin))
      {
        paramInt = paramString.status;
        return paramInt;
      }
      return -1;
    }
    finally {}
  }
  
  public long a(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    try
    {
      Object localObject = this.a.getFileManagerDataCenter().a(paramLong2, paramString, paramInt);
      if (localObject != null)
      {
        localObject = (IFileHttpBase)this.c.get(Long.valueOf(((FileManagerEntity)localObject).nSessionId));
        if (localObject != null)
        {
          paramInt = ((IFileHttpBase)localObject).i();
          paramLong1 = paramInt;
          return paramLong1;
        }
      }
      paramLong1 = this.a.getFileManagerDataCenter().a(paramString, paramLong1, paramLong2, paramInt);
      return paramLong1;
    }
    finally {}
  }
  
  public FileManagerEntity a(String paramString)
  {
    try
    {
      int i = this.c.size();
      if (i < 1) {
        return null;
      }
      Iterator localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Long)localIterator.next();
        localObject = (IFileHttpBase)this.c.get(localObject);
        if (paramString.equalsIgnoreCase(((IFileHttpBase)localObject).p()))
        {
          paramString = ((IFileHttpBase)localObject).q();
          return paramString;
        }
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  public FileManagerEntity a(String paramString1, String paramString2)
  {
    try
    {
      int i = this.c.size();
      if (i < 1) {
        return null;
      }
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
      {
        Iterator localIterator = this.c.keySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Long)localIterator.next();
          localObject = (IFileHttpBase)this.c.get(localObject);
          FileManagerEntity localFileManagerEntity = ((IFileHttpBase)localObject).q();
          if ((paramString1.equalsIgnoreCase((String)localFileManagerEntity.mContext)) && (paramString2.equals(localFileManagerEntity.zipInnerPath)))
          {
            paramString1 = ((IFileHttpBase)localObject).q();
            return paramString1;
          }
        }
        return null;
      }
      return null;
    }
    finally {}
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public void a()
  {
    try
    {
      i = Utils.a(BaseApplication.getContext());
      if (i == 1) {
        break label671;
      }
      if (i != 2) {
        break label665;
      }
    }
    finally
    {
      for (;;)
      {
        int i;
        Object localObject2;
        long[] arrayOfLong;
        String str2;
        String str1;
        Iterator localIterator;
        int k;
        for (;;)
        {
          throw localObject1;
        }
        label665:
        int m = 2;
        continue;
        label671:
        m = 1;
        continue;
        label677:
        int j = 0;
        continue;
        label682:
        j = 1;
        continue;
        label687:
        j = 0;
        continue;
        label692:
        j += 1;
        continue;
        label699:
        j = 0;
        continue;
        label704:
        if (j != 1)
        {
          k = i;
          if (j != 2)
          {
            label719:
            localObject2[j] += 1;
            label729:
            i = k;
          }
        }
      }
    }
    localObject2 = new int[3];
    arrayOfLong = new long[4];
    str2 = "";
    str1 = "";
    localIterator = this.c.keySet().iterator();
    i = 0;
    while (localIterator.hasNext())
    {
      Object localObject3 = (Long)localIterator.next();
      Object localObject4 = (IFileHttpBase)this.c.get(localObject3);
      if (localObject4 == null)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(str2);
        ((StringBuilder)localObject4).append("!!!!runRSWorker error, get worker null!!! sessionID[");
        ((StringBuilder)localObject4).append(localObject3);
        ((StringBuilder)localObject4).append("]\n");
        str2 = ((StringBuilder)localObject4).toString();
      }
      else
      {
        if ((((IFileHttpBase)localObject4).b() == 0) || (((IFileHttpBase)localObject4).b() == 6)) {
          break label682;
        }
        if ((((IFileHttpBase)localObject4).b() == 1) || (((IFileHttpBase)localObject4).b() == 8) || (((IFileHttpBase)localObject4).b() == 5) || (((IFileHttpBase)localObject4).b() == 50)) {
          break label677;
        }
        if (((IFileHttpBase)localObject4).b() == 41)
        {
          j = 2;
        }
        else
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(str1);
          ((StringBuilder)localObject3).append("type[");
          ((StringBuilder)localObject3).append(((IFileHttpBase)localObject4).b());
          ((StringBuilder)localObject3).append("] is not processed, maxtype is ");
          ((StringBuilder)localObject3).append(8);
          ((StringBuilder)localObject3).append("\n");
          str1 = ((StringBuilder)localObject3).toString();
          continue;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("run worker[");
        localStringBuilder.append(localObject3);
        localStringBuilder.append("],direction Type : ");
        localStringBuilder.append(j);
        QLog.i("FileManagerRSCenter<FileAssistant>", 1, localStringBuilder.toString());
        if (!((IFileHttpBase)localObject4).a()) {
          break label704;
        }
        k = i;
        if (localObject2[j] >= m) {
          break label729;
        }
        if (j == 1) {
          break label687;
        }
        if (j == 2)
        {
          break label687;
          if (j >= arrayOfLong.length) {
            break label699;
          }
          if (arrayOfLong[j] != ((IFileHttpBase)localObject4).c()) {
            break label692;
          }
          j = 1;
          if (j != 0)
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("run worker[");
            ((StringBuilder)localObject4).append(localObject3);
            ((StringBuilder)localObject4).append("],file is uploadding continue ");
            QLog.i("FileManagerRSCenter<FileAssistant>", 1, ((StringBuilder)localObject4).toString());
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("!!!run worker[");
            ((StringBuilder)localObject2).append(localObject3);
            ((StringBuilder)localObject2).append("]!!!");
            QLog.i("FileManagerRSCenter<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
          }
        }
        else
        {
          ((IFileHttpBase)localObject4).m();
          break;
          long l = ((IFileHttpBase)localObject4).c();
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("work[");
          ((StringBuilder)localObject4).append(localObject3);
          ((StringBuilder)localObject4).append("] is running, setIndex[");
          ((StringBuilder)localObject4).append(i);
          ((StringBuilder)localObject4).append("] fileSize:");
          ((StringBuilder)localObject4).append(l);
          QLog.i("FileManagerRSCenter<FileAssistant>", 1, ((StringBuilder)localObject4).toString());
          arrayOfLong[i] = l;
          k = i + 1;
          break label719;
        }
      }
    }
    if (!TextUtils.isEmpty(str2)) {
      QLog.e("FileManagerRSCenter<FileAssistant>", 1, str2);
    }
    if (!TextUtils.isEmpty(str1)) {
      QLog.i("FileManagerRSCenter<FileAssistant>", 1, str1);
    }
  }
  
  public void a(long paramLong1, long paramLong2, String paramString, int paramInt1, int paramInt2)
  {
    FileManagerEntity localFileManagerEntity2 = this.a.getFileManagerDataCenter().a(paramLong1);
    FileManagerEntity localFileManagerEntity1 = localFileManagerEntity2;
    if (localFileManagerEntity2 == null) {
      localFileManagerEntity1 = this.a.getFileManagerDataCenter().a(paramLong2, paramString, paramInt1);
    }
    if (localFileManagerEntity1 == null)
    {
      QLog.e("FileManagerRSCenter<FileAssistant>", 1, "=_= v! entity is null ,why you can choose!!!");
      return;
    }
    if ((localFileManagerEntity1.cloudType != 2) && (localFileManagerEntity1.cloudType != 0) && (localFileManagerEntity1.cloudType != 12))
    {
      if (FileUtil.b(localFileManagerEntity1.getFilePath()))
      {
        localFileManagerEntity1.status = 1;
        localFileManagerEntity1.cloudType = 3;
        this.a.getFileManagerDataCenter().c(localFileManagerEntity1);
        this.a.getFileManagerNotifyCenter().a(true, 3, null);
        paramString = new StringBuilder();
        paramString.append("=_= v! entity[");
        paramString.append(localFileManagerEntity1.nSessionId);
        paramString.append("] local existed so notify Success");
        QLog.e("FileManagerRSCenter<FileAssistant>", 1, paramString.toString());
        return;
      }
      if ((TextUtils.isEmpty(localFileManagerEntity1.Uuid)) && (!localFileManagerEntity1.isZipInnerFile))
      {
        FileManagerUtil.l(BaseApplicationImpl.getContext().getString(2131889788));
        localFileManagerEntity1.status = 16;
        this.a.getFileManagerDataCenter().c(localFileManagerEntity1);
        this.a.getFileManagerNotifyCenter().a(true, 3, null);
        paramString = new StringBuilder();
        paramString.append("=_= v! entity[");
        paramString.append(localFileManagerEntity1.nSessionId);
        paramString.append("] uuid null, but not Zipfile, set invalid!");
        QLog.e("FileManagerRSCenter<FileAssistant>", 1, paramString.toString());
        return;
      }
    }
    if ((localFileManagerEntity1.nFileType == 2) && (!localFileManagerEntity1.isZipInnerFile) && (localFileManagerEntity1.cloudType != 2) && ((localFileManagerEntity1.peerType == 3000) || (localFileManagerEntity1.peerType == 0)))
    {
      localFileManagerEntity1.nOpType = 8;
      paramString = new StringBuilder();
      paramString.append("=_= v> entity[");
      paramString.append(localFileManagerEntity1.nSessionId);
      paramString.append("] is video, start init video sdk");
      QLog.e("FileManagerRSCenter<FileAssistant>", 1, paramString.toString());
      if (localFileManagerEntity1.getCloudType() == 12) {
        paramString = new VideoForGuild(this.a, localFileManagerEntity1);
      } else if (localFileManagerEntity1.peerType == 3000) {
        paramString = new VideoForDisc(this.a, localFileManagerEntity1);
      } else {
        paramString = new VideoForC2C(this.a, localFileManagerEntity1);
      }
      FileVideoDownloadManager.b(paramString).c();
      this.a.getFileManagerNotifyCenter().a(true, 3, null);
      return;
    }
    localFileManagerEntity1.nOpType = paramInt2;
    if (this.c.containsKey(Long.valueOf(paramLong1)) == true)
    {
      paramString = new StringBuilder();
      paramString.append("=_= v! entity[");
      paramString.append(paramLong1);
      paramString.append("] is processing");
      QLog.e("FileManagerRSCenter<FileAssistant>", 1, paramString.toString());
      return;
    }
    a(localFileManagerEntity1);
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity.bDelInFM == true)
    {
      paramFileManagerEntity.bDelInFM = false;
      this.a.getFileManagerDataCenter().b(paramFileManagerEntity);
      this.a.getFileManagerNotifyCenter().a(true, 3, null);
    }
    if ((paramFileManagerEntity.nFileType == 2) && (!paramFileManagerEntity.isZipInnerFile) && (paramFileManagerEntity.cloudType != 2))
    {
      if (paramFileManagerEntity.getCloudType() == 12) {
        paramFileManagerEntity = new VideoForGuild(this.a, paramFileManagerEntity);
      } else if (paramFileManagerEntity.peerType == 3000) {
        paramFileManagerEntity = new VideoForDisc(this.a, paramFileManagerEntity);
      } else {
        paramFileManagerEntity = new VideoForC2C(this.a, paramFileManagerEntity);
      }
      FileVideoDownloadManager.b(paramFileManagerEntity).c();
      return;
    }
    Object localObject = (IExcitingTransferAdapter)this.a.getRuntimeService(IExcitingTransferAdapter.class, "");
    if (paramFileManagerEntity.peerType == 10014) {
      localObject = new GuildFileDownloader(this.a, paramFileManagerEntity);
    } else if ((paramFileManagerEntity.peerType == 0) && (paramFileManagerEntity.nOpType != 5) && (paramFileManagerEntity.nOpType != 50) && (((IExcitingTransferAdapter)localObject).isEnableC2CDownload()) && (paramFileManagerEntity.fileSize > ((IExcitingTransferAdapter)localObject).getC2CDownloadLimitedSize()) && (!TextUtils.isEmpty(paramFileManagerEntity.Uuid))) {
      localObject = new C2CFileDownloader(this.a, paramFileManagerEntity);
    } else {
      localObject = new FileManagerRSWorker(this.a, paramFileManagerEntity);
    }
    try
    {
      this.c.put(Long.valueOf(paramFileManagerEntity.nSessionId), localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("=_= v> entity[");
      ((StringBuilder)localObject).append(paramFileManagerEntity.nSessionId);
      ((StringBuilder)localObject).append("] is add to download list");
      QLog.i("FileManagerRSCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      a();
      return;
    }
    finally {}
  }
  
  public void a(FileManagerEntity paramFileManagerEntity, Bundle paramBundle)
  {
    if (paramFileManagerEntity.nOpType == 0)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("**** nSessionId[");
      paramBundle.append(String.valueOf(paramFileManagerEntity.nSessionId));
      paramBundle.append("] FileManagerRSCenter had not support send c2c offlinefile, please check!!!!");
      QLog.e("FileManagerRSCenter<FileAssistant>", 1, paramBundle.toString());
      return;
    }
    if (paramFileManagerEntity.peerType == 3000)
    {
      paramBundle = new StringBuilder();
      paramBundle.append("**** nSessionId[");
      paramBundle.append(String.valueOf(paramFileManagerEntity.nSessionId));
      paramBundle.append("] FileManagerRSCenter had not support send disc offlinefile, please check!!!!");
      QLog.e("FileManagerRSCenter<FileAssistant>", 1, paramBundle.toString());
      return;
    }
    boolean bool = paramFileManagerEntity.bDelInFM;
    int i = 0;
    if (bool == true)
    {
      paramFileManagerEntity.bDelInFM = false;
      this.a.getFileManagerDataCenter().b(paramFileManagerEntity);
      this.a.getFileManagerNotifyCenter().a(true, 3, null);
    }
    if (!FileUtils.fileExistsAndNotEmpty(paramFileManagerEntity.getFilePath()))
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("nSessionId[");
      ((StringBuilder)localObject1).append(String.valueOf(paramFileManagerEntity.nSessionId));
      ((StringBuilder)localObject1).append("]file is not exist or empty,path[");
      ((StringBuilder)localObject1).append(paramFileManagerEntity.getFilePath());
      ((StringBuilder)localObject1).append("], please check file!");
      QLog.e("FileManagerRSCenter<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      localObject1 = FileManagerUtil.d();
      if ((paramFileManagerEntity.getFilePath() != null) && (paramFileManagerEntity.getFilePath().length() != 0)) {
        if (!FileManagerUtil.n(paramFileManagerEntity.getFilePath()))
        {
          i = 9042;
          paramBundle = new StringBuilder();
          paramBundle.append("fileNotExists:");
          paramBundle.append((String)localObject1);
          paramBundle = paramBundle.toString();
        }
      }
      for (;;)
      {
        break;
        if (FileManagerUtil.h(paramFileManagerEntity.getFilePath()) == 0L)
        {
          i = 9071;
          paramBundle = new StringBuilder();
          paramBundle.append("fileExistsEmpty:");
          paramBundle.append((String)localObject1);
          paramBundle = paramBundle.toString();
        }
        else
        {
          paramBundle = (Bundle)localObject1;
          i = 0;
          break;
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("filePathNull:");
          ((StringBuilder)localObject2).append((String)localObject1);
          localObject2 = ((StringBuilder)localObject2).toString();
          localObject1 = localObject2;
          if (paramBundle != null)
          {
            paramBundle = paramBundle.getString("emptyPathCallStack");
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(paramBundle))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("filePathNull sendLocalFile api callstack:");
              ((StringBuilder)localObject1).append(paramBundle);
              localObject1 = ((StringBuilder)localObject1).toString();
            }
          }
          paramBundle = (Bundle)localObject1;
          i = 9005;
        }
      }
      if (paramFileManagerEntity.nOpType == 6)
      {
        paramFileManagerEntity.status = 0;
        paramFileManagerEntity.isReaded = false;
        this.a.getFileManagerDataCenter().c(paramFileManagerEntity);
        this.a.getFileManagerNotifyCenter().a(paramFileManagerEntity.uniseq, paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 38, null, 1, null);
        this.a.getFileManagerDataCenter().a();
        FileManagerUtil.a(this.a, paramFileManagerEntity.nSessionId, "actFileWyUp", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, i, "", 0L, 0L, paramFileManagerEntity.fileSize, "", "", 0, paramBundle, null);
      }
      paramFileManagerEntity.status = 16;
      paramFileManagerEntity.fProgress = 1.0F;
      this.a.getFileManagerDataCenter().c(paramFileManagerEntity);
      return;
    }
    paramBundle = (ShieldMsgManger)this.a.getManager(QQManagerFactory.SHIELD_LIST_MANAGER);
    if ((paramBundle != null) && (paramBundle.a(paramFileManagerEntity.peerUin)))
    {
      paramFileManagerEntity.isReaded = false;
      if (paramFileManagerEntity.status == 16) {
        i = 16;
      }
      paramFileManagerEntity.status = i;
      this.a.getFileManagerDataCenter().c(paramFileManagerEntity);
      paramBundle = new StringBuilder();
      paramBundle.append("=_= ! Id[");
      paramBundle.append(paramFileManagerEntity.nSessionId);
      paramBundle.append("] frend in blacklist!");
      QLog.e("FileManagerRSCenter<FileAssistant>", 1, paramBundle.toString());
      this.a.getFileManagerNotifyCenter().a(paramFileManagerEntity.uniseq, paramFileManagerEntity.nSessionId, paramFileManagerEntity.peerUin, paramFileManagerEntity.peerType, 15, null, -1, HardCodeUtil.a(2131902543));
      return;
    }
    paramBundle = new FileManagerRSWorker(this.a, paramFileManagerEntity);
    try
    {
      this.c.put(Long.valueOf(paramFileManagerEntity.nSessionId), paramBundle);
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("Add a New Send Work!, sessionId[");
        paramBundle.append(String.valueOf(paramFileManagerEntity.nSessionId));
        paramBundle.append("]");
        QLog.d("FileManagerRSCenter<FileAssistant>", 2, paramBundle.toString());
      }
      a();
      return;
    }
    finally {}
    for (;;)
    {
      throw paramFileManagerEntity;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      int i = this.c.size();
      if (i < 1) {
        return;
      }
      Object localObject1 = new ArrayList();
      Object localObject3 = this.c.values().iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((List)localObject1).add(0, (IFileHttpBase)((Iterator)localObject3).next());
      }
      this.c.clear();
      localObject1 = ((List)localObject1).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (IFileHttpBase)((Iterator)localObject1).next();
        ((IFileHttpBase)localObject3).j();
        if (!paramBoolean)
        {
          ((IFileHttpBase)localObject3).k();
        }
        else
        {
          ((IFileHttpBase)localObject3).a(null, 0);
          i = 1;
        }
      }
      if ((paramBoolean) && (i == 0)) {
        FileManagerUtil.l(BaseApplicationImpl.getContext().getString(2131889818));
      }
      this.a.getFileManagerNotifyCenter().a(true, 3, null);
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public boolean a(long paramLong)
  {
    try
    {
      Object localObject1 = (IFileHttpBase)this.c.get(Long.valueOf(paramLong));
      if (localObject1 != null)
      {
        ((IFileHttpBase)localObject1).l();
        this.c.remove(Long.valueOf(paramLong));
        a();
      }
      localObject1 = this.a.getFileManagerDataCenter().a(paramLong);
      if ((localObject1 != null) && (((FileManagerEntity)localObject1).nFileType == 2))
      {
        FileVideoDownloadManager.a(String.valueOf(((FileManagerEntity)localObject1).nSessionId));
        if ((((FileManagerEntity)localObject1).status == 2) || (((FileManagerEntity)localObject1).status == -1)) {
          ((FileManagerEntity)localObject1).status = 3;
        }
        this.a.getFileManagerDataCenter().c((FileManagerEntity)localObject1);
        this.a.getFileManagerNotifyCenter().a(true, 0, null);
      }
      if ((localObject1 != null) && (((FileManagerEntity)localObject1).status == 2))
      {
        ((FileManagerEntity)localObject1).status = 3;
        this.a.getFileManagerDataCenter().c((FileManagerEntity)localObject1);
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public boolean a(String paramString, long paramLong, int paramInt)
  {
    try
    {
      paramString = this.a.getFileManagerDataCenter().a(paramLong, paramString, paramInt, -1L);
      if (paramString == null) {
        return false;
      }
      boolean bool = a(paramString.nSessionId);
      return bool;
    }
    finally {}
  }
  
  public void b(long paramLong)
  {
    try
    {
      Object localObject1 = (IFileHttpBase)this.c.get(Long.valueOf(paramLong));
      if (localObject1 != null) {
        ((IFileHttpBase)localObject1).f();
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("remove worker, sessionId[");
        ((StringBuilder)localObject1).append(String.valueOf(paramLong));
        ((StringBuilder)localObject1).append("]");
        QLog.d("FileManagerRSCenter<FileAssistant>", 2, ((StringBuilder)localObject1).toString());
      }
      this.c.remove(Long.valueOf(paramLong));
      a();
      return;
    }
    finally {}
  }
  
  public void b(FileManagerEntity paramFileManagerEntity)
  {
    if (paramFileManagerEntity == null) {}
    try
    {
      QLog.e("FileManagerRSCenter<FileAssistant>", 1, "entry is null, retry ge mao!");
      return;
    }
    finally {}
    Object localObject = (IFileHttpBase)this.c.get(Long.valueOf(paramFileManagerEntity.nSessionId));
    if ((localObject != null) && (!((IFileHttpBase)localObject).a()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uniseq[ ");
      ((StringBuilder)localObject).append(String.valueOf(paramFileManagerEntity.uniseq));
      ((StringBuilder)localObject).append(" ],sessionid[ ");
      ((StringBuilder)localObject).append(String.valueOf(paramFileManagerEntity.nSessionId));
      ((StringBuilder)localObject).append(" ] work,is procressing!");
      QLog.i("FileManagerRSCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      return;
    }
    int i = paramFileManagerEntity.nOpType;
    if ((i != 1) && (i != 8) && (i != 50) && (i != 53) && (i != 5))
    {
      if (i != 6)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unknow actionType!");
        ((StringBuilder)localObject).append(paramFileManagerEntity.nOpType);
        QLog.e("FileManagerRSCenter<FileAssistant>", 1, ((StringBuilder)localObject).toString());
      }
      else
      {
        a(paramFileManagerEntity, null);
      }
    }
    else {
      a(paramFileManagerEntity);
    }
  }
  
  public boolean b(String paramString)
  {
    try
    {
      int i = this.c.size();
      if (i < 1) {
        return false;
      }
      Iterator localIterator = this.c.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Long)localIterator.next();
        localObject = ((IFileHttpBase)this.c.get(localObject)).q();
        if (((FileManagerEntity)localObject).getFilePath() != null)
        {
          boolean bool = ((FileManagerEntity)localObject).getFilePath().equalsIgnoreCase(paramString);
          if (bool) {
            return true;
          }
        }
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSCenter
 * JD-Core Version:    0.7.0.1
 */