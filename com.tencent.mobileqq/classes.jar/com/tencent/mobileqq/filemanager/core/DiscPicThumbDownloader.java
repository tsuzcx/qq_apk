package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IFMSettings;
import com.tencent.mobileqq.filemanager.api.IFileIPv6StrateyController;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.MD5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DiscPicThumbDownloader
  extends BaseThumbDownloader
{
  private SparseArray<String> c = new SparseArray();
  private FileTransferObserver d = new DiscPicThumbDownloader.5(this);
  
  public DiscPicThumbDownloader(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    b();
  }
  
  private DiscPicThumbDownloader.PicSession a(long paramLong, boolean paramBoolean)
  {
    Object localObject = b(paramLong);
    if (localObject == null) {
      return null;
    }
    if ((localObject instanceof DiscPicThumbDownloader.PicSession)) {
      return (DiscPicThumbDownloader.PicSession)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[downloadThumb] getSession  ID[");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("] no instance");
    QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    return null;
  }
  
  private void a(int paramInt, DiscPicThumbDownloader.PicSession paramPicSession, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    Object localObject2;
    long l1;
    long l2;
    Object localObject3;
    String str1;
    String str2;
    String str3;
    long l3;
    long l4;
    long l5;
    String str4;
    Object localObject1;
    switch (paramInt)
    {
    default: 
    case -2: 
      FileManagerUtil.a(this.a, paramPicSession.b.nSessionId, "actFileDiscThumb", paramPicSession.e, paramDownloadTask.b, paramPicSession.b.peerUin, paramPicSession.b.Uuid, paramPicSession.b.strFileMd5, 9003L, "FileNotFoundException", 0L, 0L, 0L, paramDownloadTask.b, "", 0, "FileNotFoundException", "");
      FileManagerUtil.a(this.a, paramPicSession.b.nSessionId, "actFileDiscThumbDetail", paramPicSession.e, paramDownloadTask.b, paramPicSession.b.peerUin, paramPicSession.b.Uuid, paramPicSession.b.strFileMd5, 9003L, "FileNotFoundException", 0L, 0L, 0L, paramDownloadTask.b, "", 0, "size error", "");
      return;
    case -3: 
      localObject2 = this.a;
      l1 = paramPicSession.b.nSessionId;
      l2 = paramPicSession.e;
      localObject3 = paramDownloadTask.b;
      str1 = paramPicSession.b.peerUin;
      str2 = paramPicSession.b.Uuid;
      str3 = paramPicSession.b.strFileMd5;
      l3 = paramDownloadTask.t;
      l4 = paramDownloadTask.j;
      l5 = paramPicSession.c;
      str4 = paramDownloadTask.b;
      if (paramDownloadTask.s != null) {
        localObject1 = paramDownloadTask.s.rawRespHeader;
      } else {
        localObject1 = "respose null";
      }
      FileManagerUtil.a((QQAppInterface)localObject2, l1, "actFileDiscThumb", l2, (String)localObject3, str1, str2, str3, 9004L, "no network", l3, l4, l5, str4, (String)localObject1, paramDownloadTask.l, "no network", "");
      localObject1 = this.a;
      l1 = paramPicSession.b.nSessionId;
      l2 = paramPicSession.e;
      localObject2 = paramDownloadTask.b;
      localObject3 = paramPicSession.b.peerUin;
      str1 = paramPicSession.b.Uuid;
      str2 = paramPicSession.b.strFileMd5;
      l3 = paramDownloadTask.t;
      l4 = paramDownloadTask.j;
      l5 = paramPicSession.c;
      str3 = paramDownloadTask.b;
      if (paramDownloadTask.s != null) {
        paramPicSession = paramDownloadTask.s.rawRespHeader;
      } else {
        paramPicSession = "respose null";
      }
      FileManagerUtil.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, (String)localObject3, str1, str2, 9004L, "no network", l3, l4, l5, str3, paramPicSession, paramDownloadTask.n, "no network", "");
      return;
    case -7: 
      FileManagerUtil.a(this.a, paramPicSession.b.nSessionId, "actFileDiscThumb", paramPicSession.e, paramDownloadTask.b, paramPicSession.b.peerUin, paramPicSession.b.Uuid, paramPicSession.b.strFileMd5, 9005L, "noRs", 0L, 0L, 0L, paramDownloadTask.b, "", 0, "noRs", "");
      FileManagerUtil.a(this.a, paramPicSession.b.nSessionId, "actFileDiscThumbDetail", paramPicSession.e, paramDownloadTask.b, paramPicSession.b.peerUin, paramPicSession.b.Uuid, paramPicSession.b.strFileMd5, 9005L, "noRs", paramDownloadTask.t, paramDownloadTask.j, paramDownloadTask.k, paramDownloadTask.b, "", 0, "noRs", "");
      return;
    case -8: 
      localObject2 = this.a;
      l1 = paramPicSession.b.nSessionId;
      l2 = paramPicSession.e;
      localObject3 = paramDownloadTask.b;
      str1 = paramPicSession.b.peerUin;
      str2 = paramPicSession.b.Uuid;
      str3 = paramPicSession.b.strFileMd5;
      l3 = paramDownloadTask.j;
      l4 = paramDownloadTask.k;
      str4 = paramDownloadTask.b;
      if (paramDownloadTask.s != null) {
        localObject1 = paramDownloadTask.s.rawRespHeader;
      } else {
        localObject1 = "respose null";
      }
      FileManagerUtil.a((QQAppInterface)localObject2, l1, "actFileDiscThumb", l2, (String)localObject3, str1, str2, str3, 9003L, "revStream write Exception", 0L, l3, l4, str4, (String)localObject1, paramDownloadTask.l, "revStream write Exception", "");
      localObject1 = this.a;
      l1 = paramPicSession.b.nSessionId;
      l2 = paramPicSession.e;
      localObject2 = paramDownloadTask.b;
      localObject3 = paramPicSession.b.peerUin;
      str1 = paramPicSession.b.Uuid;
      str2 = paramPicSession.b.strFileMd5;
      l3 = paramDownloadTask.j;
      l4 = paramDownloadTask.k;
      str3 = paramDownloadTask.b;
      if (paramDownloadTask.s != null) {
        paramPicSession = paramDownloadTask.s.rawRespHeader;
      } else {
        paramPicSession = "respose null";
      }
      FileManagerUtil.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, (String)localObject3, str1, str2, 9003L, "revStream write Exception", 0L, l3, l4, str3, paramPicSession, paramDownloadTask.n, "revStream write Exception", "");
      return;
    case -9: 
      localObject2 = this.a;
      l1 = paramPicSession.b.nSessionId;
      l2 = paramPicSession.e;
      localObject3 = paramDownloadTask.b;
      str1 = paramPicSession.b.peerUin;
      str2 = paramPicSession.b.Uuid;
      str3 = paramPicSession.b.strFileMd5;
      l3 = paramDownloadTask.t;
      l4 = paramDownloadTask.j;
      l5 = paramDownloadTask.k;
      str4 = paramDownloadTask.b;
      if (paramDownloadTask.s != null) {
        localObject1 = paramDownloadTask.s.rawRespHeader;
      } else {
        localObject1 = "respose null";
      }
      FileManagerUtil.a((QQAppInterface)localObject2, l1, "actFileDiscThumb", l2, (String)localObject3, str1, str2, str3, 9003L, "rename error", l3, l4, l5, str4, (String)localObject1, paramDownloadTask.l, "rename error", "");
      localObject1 = this.a;
      l1 = paramPicSession.b.nSessionId;
      l2 = paramPicSession.e;
      localObject2 = paramDownloadTask.b;
      localObject3 = paramPicSession.b.peerUin;
      str1 = paramPicSession.b.Uuid;
      str2 = paramPicSession.b.strFileMd5;
      l3 = paramDownloadTask.t;
      l4 = paramDownloadTask.j;
      l5 = paramDownloadTask.k;
      str3 = paramDownloadTask.b;
      if (paramDownloadTask.s != null) {
        paramPicSession = paramDownloadTask.s.rawRespHeader;
      } else {
        paramPicSession = "respose null";
      }
      FileManagerUtil.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, (String)localObject3, str1, str2, 9003L, "rename error", l3, l4, l5, str3, paramPicSession, paramDownloadTask.n, "rename error", "");
      return;
    case -10: 
      if (paramPicSession.b != null)
      {
        paramPicSession.b.thumbInvalidCode = 1;
        return;
      }
      break;
    case -11: 
    case -6: 
    case -5: 
    case -4: 
      if (paramDownloadTask.s != null) {
        paramInt = paramDownloadTask.s.errCode;
      } else {
        paramInt = 0;
      }
      if (paramDownloadTask.s != null) {
        localObject1 = paramDownloadTask.s.getErrorString();
      } else {
        localObject1 = "http resp err";
      }
      localObject3 = this.a;
      l2 = paramPicSession.b.nSessionId;
      l3 = paramPicSession.e;
      str1 = paramDownloadTask.b;
      str2 = paramPicSession.b.peerUin;
      str3 = paramPicSession.b.Uuid;
      str4 = paramPicSession.b.strFileMd5;
      l1 = paramInt;
      l4 = paramDownloadTask.t;
      l5 = paramDownloadTask.j;
      long l6 = paramDownloadTask.k;
      String str5 = paramDownloadTask.b;
      if (paramDownloadTask.s != null) {
        localObject2 = paramDownloadTask.s.rawRespHeader;
      } else {
        localObject2 = "respose null";
      }
      FileManagerUtil.a((QQAppInterface)localObject3, l2, "actFileDiscThumb", l3, str1, str2, str3, str4, l1, (String)localObject1, l4, l5, l6, str5, (String)localObject2, paramDownloadTask.l, (String)localObject1, "");
      localObject3 = this.a;
      l2 = paramPicSession.b.nSessionId;
      l3 = paramPicSession.e;
      str1 = paramDownloadTask.b;
      str2 = paramPicSession.b.peerUin;
      str3 = paramPicSession.b.Uuid;
      str4 = paramPicSession.b.strFileMd5;
      l4 = paramDownloadTask.t;
      l5 = paramDownloadTask.j;
      l6 = paramDownloadTask.k;
      str5 = paramDownloadTask.b;
      if (paramDownloadTask.s != null) {
        localObject2 = paramDownloadTask.s.rawRespHeader;
      } else {
        localObject2 = "respose null";
      }
      FileManagerUtil.a((QQAppInterface)localObject3, l2, "actFileDiscThumbDetail", l3, str1, str2, str3, str4, l1, (String)localObject1, l4, l5, l6, str5, (String)localObject2, paramDownloadTask.n, (String)localObject1, "");
      paramPicSession.b.thumbInvalidCode = 2;
    }
  }
  
  private void a(long paramLong1, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, boolean paramBoolean, String paramString3, short paramShort, String paramString4, String paramString5, long paramLong2, Bundle paramBundle)
  {
    if (paramBoolean)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString4);
      ((StringBuilder)localObject).append("&isthumb=1");
      paramString4 = ((StringBuilder)localObject).toString();
    }
    Object localObject = a(paramLong2, false);
    if (localObject == null)
    {
      paramString1 = new StringBuilder();
      paramString1.append("onUpdateGetOfflineDownloadInfo, mapDowload is not existed taskid[");
      paramString1.append(String.valueOf(paramLong2));
      paramString1.append("]");
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, paramString1.toString());
      a(paramLong2, false, null, 0, null, null, paramString2, false, null, (short)0, null);
      return;
    }
    if ((TextUtils.isEmpty(((DiscPicThumbDownloader.PicSession)localObject).b.strFileMd5)) && (!TextUtils.isEmpty(paramString5))) {
      ((DiscPicThumbDownloader.PicSession)localObject).b.strFileMd5 = paramString5;
    }
    FileManagerUtil.a(((DiscPicThumbDownloader.PicSession)localObject).b, this.a, null);
    boolean bool = true;
    if (paramLong1 != 0L)
    {
      paramByteStringMicro = new StringBuilder();
      paramByteStringMicro.append("[downloadThumb]  ID[");
      paramByteStringMicro.append(paramLong2);
      paramByteStringMicro.append("] OnDiscDownloadInfo isSuccess[false],retCode[");
      paramByteStringMicro.append(String.valueOf(paramLong1));
      paramByteStringMicro.append("],retMsg[");
      paramByteStringMicro.append(String.valueOf(paramString1));
      paramByteStringMicro.append("]");
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, paramByteStringMicro.toString());
      if ((paramLong1 != -100001L) && ((paramLong1 == -25081L) || (paramLong1 == -6101L) || (paramLong1 == -7003L)))
      {
        ((DiscPicThumbDownloader.PicSession)localObject).b.status = 16;
        this.a.getFileManagerDataCenter().c(((DiscPicThumbDownloader.PicSession)localObject).b);
      }
      this.a.getFileManagerNotifyCenter().a(false, 51, new Object[] { ((DiscPicThumbDownloader.PicSession)localObject).b, Integer.valueOf(((DiscPicThumbDownloader.PicSession)localObject).c) });
      a(paramLong2);
      a(paramLong2, false, null, 0, null, null, paramString2, false, null, (short)0, null);
      return;
    }
    if ((paramString3 != null) && (paramByteStringMicro != null))
    {
      if ((TextUtils.isEmpty(((DiscPicThumbDownloader.PicSession)localObject).b.strFileMd5)) && (!TextUtils.isEmpty(paramString5))) {
        ((DiscPicThumbDownloader.PicSession)localObject).b.strFileMd5 = paramString5;
      }
      paramString1 = (String)this.c.get(((DiscPicThumbDownloader.PicSession)localObject).c, "");
      if (TextUtils.isEmpty(paramString1))
      {
        paramString1 = new StringBuilder();
        paramString1.append("[downloadThumb]  ID[");
        paramString1.append(paramLong2);
        paramString1.append("] unknow thumbSize!!!info:");
        paramString1.append(localObject.toString());
        QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, paramString1.toString());
        this.a.getFileManagerNotifyCenter().a(false, 51, new Object[] { ((DiscPicThumbDownloader.PicSession)localObject).b, Integer.valueOf(((DiscPicThumbDownloader.PicSession)localObject).c) });
        a(paramLong2);
        a(paramLong2, false, paramString3, paramShort, paramString4, null, paramString2, false, null, (short)0, null);
        return;
      }
      paramByteStringMicro = new StringBuilder();
      paramByteStringMicro.append(paramString4);
      paramByteStringMicro.append(paramString1);
      paramString5 = paramByteStringMicro.toString();
      if ((((IFMConfig)QRoute.api(IFMConfig.class)).isEnableHttpsThumb4C2C(this.a)) && (paramBundle != null))
      {
        paramString1 = paramBundle.getString("strHttpsDomain");
        if (!TextUtils.isEmpty(paramString1))
        {
          s = paramBundle.getShort("httpsPort", (short)0);
          if (s == 0)
          {
            s = 443;
            break label657;
          }
          break label657;
        }
      }
      bool = false;
      paramString1 = null;
      short s = 0;
      label657:
      if (paramBundle != null)
      {
        paramString4 = paramBundle.getString("IPv6Dns");
        paramByteStringMicro = paramBundle.getStringArrayList("ipv6list");
      }
      else
      {
        paramString4 = "";
        paramByteStringMicro = null;
      }
      paramBundle = new Bundle();
      paramBundle.putBoolean("usemediaplatform", paramBoolean);
      if ((paramByteStringMicro != null) && (paramByteStringMicro.size() > 0)) {
        paramBundle.putStringArrayList("ipv6list", paramByteStringMicro);
      }
      a(paramLong2, true, paramString3, paramShort, paramString5, null, paramString2, bool, paramString1, s, paramString4, paramBundle);
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("[downloadThumb]  ID[");
    paramString1.append(paramLong2);
    paramString1.append("]  get DiscdownLoad info Url is null ");
    QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, paramString1.toString());
    if ((paramLong1 == -25081L) || (paramLong1 == -6101L) || (paramLong1 == -7003L))
    {
      ((DiscPicThumbDownloader.PicSession)localObject).b.status = 16;
      this.a.getFileManagerDataCenter().c(((DiscPicThumbDownloader.PicSession)localObject).b);
    }
    a(paramLong2);
    a(paramLong2, false, null, 0, null, null, paramString2, false, null, (short)0, null);
  }
  
  private void a(DiscPicThumbDownloader.PicSession paramPicSession, String paramString, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    FileManagerUtil.a(this.a, paramPicSession.b.nSessionId, "actFileDiscThumb", System.currentTimeMillis() - paramPicSession.e, paramDownloadTask.b, paramPicSession.b.peerUin, paramPicSession.b.Uuid, paramPicSession.b.strFileMd5, paramDownloadTask.t, paramDownloadTask.j, paramDownloadTask.k, paramDownloadTask.l, null);
    if (paramPicSession.c == 7)
    {
      paramPicSession.b.strLargeThumPath = paramString;
      FileManagerUtil.n(paramPicSession.b);
      ThreadManager.post(new DiscPicThumbDownloader.3(this, paramPicSession), 8, null, false);
    }
    else if (paramPicSession.c == 5)
    {
      paramPicSession.b.strMiddleThumPath = paramString;
      FileManagerUtil.n(paramPicSession.b);
      if (FilePicURLDrawlableHelper.i(paramPicSession.b)) {
        ThreadManager.post(new DiscPicThumbDownloader.4(this, paramPicSession), 8, null, false);
      }
    }
    else
    {
      paramPicSession.b.strThumbPath = paramString;
    }
    this.a.getFileManagerDataCenter().c(paramPicSession.b);
  }
  
  private String b(int paramInt, String paramString)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "x-dsc-";
      break;
    case 8: 
      str = "screen-dsc-";
      break;
    case 7: 
      str = "qxlarge-dsc-";
      break;
    case 6: 
      str = "xlarge-dsc-";
      break;
    case 5: 
      str = "qlarge-dsc-";
      break;
    case 4: 
      str = "large-dsc-";
      break;
    case 3: 
      str = "middle-dsc-";
      break;
    case 2: 
      str = "small-dsc-";
      break;
    case 1: 
      str = "minni-dsc-";
      break;
    case 0: 
      str = "micro-dsc-";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private void b()
  {
    this.c.put(0, "?pictype=scaled&size=16*16");
    this.c.put(1, "?pictype=scaled&size=32*32");
    this.c.put(2, "?pictype=scaled&size=64*64");
    this.c.put(3, "?pictype=scaled&size=128*128");
    this.c.put(4, "?pictype=scaled&size=320*320");
    this.c.put(5, "?pictype=scaled&size=384*384");
    this.c.put(6, "?pictype=scaled&size=640*640");
    this.c.put(7, "?pictype=scaled&size=750*750");
    this.c.put(8, "?pictype=scaled&size=1024*1024");
  }
  
  public String a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (TextUtils.isEmpty(paramFileManagerEntity.Uuid))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("[downloadThumb]  download. uuid = null nSession[");
      ((StringBuilder)localObject1).append(paramFileManagerEntity.nSessionId);
      ((StringBuilder)localObject1).append("]");
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      this.a.getFileManagerNotifyCenter().a(false, 50, new Object[] { paramFileManagerEntity, Integer.valueOf(paramInt) });
      return null;
    }
    a();
    if ((TextUtils.isEmpty(paramFileManagerEntity.Uuid)) && (QLog.isDevelopLevel())) {
      throw new NullPointerException("uuid is null!!!");
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(FMSettings.a().getDefaultThumbPath());
    ((StringBuilder)localObject1).append(b(paramInt, MD5.b(paramFileManagerEntity.Uuid)));
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = localObject2;
    if (!FileUtil.b((String)localObject2))
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(FMSettings.a().getDefaultThumbPath());
        ((StringBuilder)localObject1).append(b(paramInt, MD5.b(paramFileManagerEntity.strFileMd5)));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    if (FileUtils.fileExistsAndNotEmpty((String)localObject1) == true)
    {
      if (paramInt == 7)
      {
        paramFileManagerEntity.strLargeThumPath = ((String)localObject1);
        if (FilePicURLDrawlableHelper.i(paramFileManagerEntity)) {
          ThreadManager.post(new DiscPicThumbDownloader.1(this, paramFileManagerEntity), 8, null, false);
        }
      }
      else if (paramInt == 5)
      {
        paramFileManagerEntity.strMiddleThumPath = ((String)localObject1);
        if (FilePicURLDrawlableHelper.i(paramFileManagerEntity)) {
          ThreadManager.post(new DiscPicThumbDownloader.2(this, paramFileManagerEntity), 8, null, false);
        }
      }
      else
      {
        paramFileManagerEntity.strThumbPath = ((String)localObject1);
      }
      this.a.getFileManagerDataCenter().c(paramFileManagerEntity);
      this.a.getFileManagerNotifyCenter().a(true, 50, new Object[] { paramFileManagerEntity, Integer.valueOf(paramInt) });
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[downloadThumb] Id[");
      ((StringBuilder)localObject2).append(paramFileManagerEntity.nSessionId);
      ((StringBuilder)localObject2).append("] thumb Downloaded:");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
      FileManagerUtil.a(this.a, paramFileManagerEntity.nSessionId, "actFileDiscThumb", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 0L, 0L, 0L, 0, null);
      return localObject1;
    }
    localObject2 = new DiscPicThumbDownloader.PicSession(paramFileManagerEntity);
    ((DiscPicThumbDownloader.PicSession)localObject2).c = paramInt;
    a((BaseThumbDownloader.Session)localObject2, (String)localObject1, true);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[downloadThumb] download  nSession[");
    ((StringBuilder)localObject1).append(paramFileManagerEntity.nSessionId);
    ((StringBuilder)localObject1).append("], ThumbDownloadId[");
    ((StringBuilder)localObject1).append(((DiscPicThumbDownloader.PicSession)localObject2).a);
    ((StringBuilder)localObject1).append("]");
    QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
    return null;
  }
  
  public List<String> a(long paramLong, String paramString, int paramInt, boolean paramBoolean, List<String> paramList)
  {
    Object localObject = a(paramLong, false);
    if ((localObject != null) && (((DiscPicThumbDownloader.PicSession)localObject).b != null))
    {
      int i;
      if (((DiscPicThumbDownloader.PicSession)localObject).b.peerType == 3000) {
        i = 5;
      } else {
        i = 1;
      }
      if (!FileIPv6StrateyController.b().isConfigEnableIPV6(this.a, i)) {
        return null;
      }
      StringBuilder localStringBuilder;
      if ((paramBoolean) && (paramList != null) && (paramList.size() > 0))
      {
        paramString = new StringBuilder();
        paramString.append("[downloadThumb]  ID[");
        paramString.append(paramLong);
        paramString.append("] [IPv6-File] image thumb mediaplatform. is config enable IPv6. v6ipsize[");
        paramString.append(paramList.size());
        paramString.append("] busiType:");
        paramString.append(i);
        QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, paramString.toString());
        paramList = FileIPv6StrateyController.b().getIPV6listForMediaPlatfrom(this.a, i, paramList);
        if ((paramList != null) && (paramList.size() > 0))
        {
          paramString = new ArrayList();
          int j = paramList.size();
          i = 0;
          while (i < j)
          {
            localObject = (String)paramList.get(i);
            if (!TextUtils.isEmpty((CharSequence)localObject))
            {
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("[");
              localStringBuilder.append((String)localObject);
              localStringBuilder.append("]:");
              localStringBuilder.append(paramInt);
              paramString.add(0, localStringBuilder.toString());
            }
            i += 1;
          }
          paramList = new StringBuilder();
          paramList.append("[downloadThumb]  ID[");
          paramList.append(paramLong);
          paramList.append("] [IPv6-File] image thumb mediaplatform. use IPv6. hostlist:");
          paramList.append(paramString.toString());
          QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, paramList.toString());
          return paramString;
        }
        paramString = new StringBuilder();
        paramString.append("[downloadThumb]  ID[");
        paramString.append(paramLong);
        paramString.append("] [IPv6-File] image thumb mediaplatform. use IPv4:");
        QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, paramString.toString());
        return null;
      }
      if (!TextUtils.isEmpty(paramString))
      {
        paramList = new StringBuilder();
        paramList.append("[downloadThumb]  ID[");
        paramList.append(paramLong);
        paramList.append("] [IPv6-File] image thumb. is config enable IPv6. domain[");
        paramList.append(paramString);
        paramList.append("] busiType:");
        paramList.append(i);
        QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, paramList.toString());
        paramString = new FileIPv6StrateyController.DomainInfo(paramString, paramInt);
        paramList = FileIPv6StrateyController.b().getIPlistForV6Domain(this.a, paramString, i);
        if ((paramList != null) && (!paramList.a()))
        {
          paramString = new ArrayList();
          paramList = paramList.b.iterator();
          while (paramList.hasNext())
          {
            localObject = (FileIPv6StrateyController.IPInfo)paramList.next();
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(((FileIPv6StrateyController.IPInfo)localObject).a);
            localStringBuilder.append(":");
            localStringBuilder.append(((FileIPv6StrateyController.IPInfo)localObject).b);
            paramString.add(localStringBuilder.toString());
          }
          paramList = new StringBuilder();
          paramList.append("[downloadThumb]  ID[");
          paramList.append(paramLong);
          paramList.append("] [IPv6-File] image thumb. use IPv6. hostlist:");
          paramList.append(paramString.toString());
          QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, paramList.toString());
          return paramString;
        }
        paramString = new StringBuilder();
        paramString.append("[downloadThumb]  ID[");
        paramString.append(paramLong);
        paramString.append("] [IPv6-File] image thumb. use IPv4:");
        QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, paramString.toString());
      }
    }
    return null;
  }
  
  public void a(long paramLong, int paramInt, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    paramDownloadTask = a(paramLong, false);
    if (paramDownloadTask == null)
    {
      paramDownloadTask = new StringBuilder();
      paramDownloadTask.append("[downloadThumb]  ID[");
      paramDownloadTask.append(paramLong);
      paramDownloadTask.append("] onDownloadCompleted no this session");
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, paramDownloadTask.toString());
      return;
    }
    this.a.getFileManagerNotifyCenter().a(true, 52, new Object[] { paramDownloadTask.b, Integer.valueOf(paramInt) });
  }
  
  public void a(long paramLong, HttpMsg paramHttpMsg)
  {
    DiscPicThumbDownloader.PicSession localPicSession = a(paramLong, false);
    if (localPicSession == null)
    {
      paramHttpMsg = new StringBuilder();
      paramHttpMsg.append("[downloadThumb]  ID[");
      paramHttpMsg.append(paramLong);
      paramHttpMsg.append("] onSetHttpMsg no this session");
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, paramHttpMsg.toString());
      return;
    }
    paramHttpMsg.busiType = 3000;
    paramHttpMsg.setRequestProperty("Cookie", localPicSession.d);
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    DiscPicThumbDownloader.PicSession localPicSession = a(paramLong, false);
    if (localPicSession == null)
    {
      paramString = new StringBuilder();
      paramString.append("[downloadThumb]  ID[");
      paramString.append(paramLong);
      paramString.append("] onDownloadCompleted no this session");
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, paramString.toString());
      return;
    }
    if (paramBoolean) {
      a(localPicSession, paramString, paramDownloadTask);
    } else {
      a(paramInt, localPicSession, paramDownloadTask);
    }
    this.a.getFileManagerNotifyCenter().a(paramBoolean, 50, new Object[] { localPicSession.b, Integer.valueOf(localPicSession.c) });
    super.a(paramLong, paramBoolean, paramInt, paramString, paramDownloadTask);
  }
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, int paramInt1, String paramString3, String paramString4, int paramInt2, long paramLong2, Bundle paramBundle)
  {
    Object localObject2 = a(paramLong2, false);
    if (localObject2 == null)
    {
      paramString1 = new StringBuilder();
      paramString1.append("OnDiscDownloadInfo, mapDowload is not existed taskid[");
      paramString1.append(String.valueOf(paramLong2));
      paramString1.append("]");
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, paramString1.toString());
      FileManagerUtil.a(this.a, 0L, "actFileDiscThumb", 0L, "", "", "", "", 9005L, "get info null", 0L, 0L, 0L, "", "", 0, "get info null", "");
      FileManagerUtil.a(this.a, 0L, "actFileDiscThumbDetail", 0L, "", "", "", "", 9005L, "get info null", 0L, 0L, 0L, "", "", 0, "get info null", "");
      a(paramLong2, false, null, 0, null, null, paramString4, false, null, (short)0, null);
      return;
    }
    boolean bool = true;
    if (!paramBoolean)
    {
      paramString2 = new StringBuilder();
      paramString2.append("[downloadThumb]  ID[");
      paramString2.append(paramLong2);
      paramString2.append("] OnDiscDownloadInfo isSuccess[false],retCode[");
      paramString2.append(String.valueOf(paramLong1));
      paramString2.append("],retMsg[");
      paramString2.append(String.valueOf(paramString1));
      paramString2.append("]");
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, paramString2.toString());
      long l1 = 0L;
      if (paramLong1 == -100001L)
      {
        l1 = 9043L;
      }
      else if ((paramLong1 != -25081L) && (paramLong1 != -6101L) && (paramLong1 != -7003L))
      {
        l1 = 9045L;
      }
      else
      {
        ((DiscPicThumbDownloader.PicSession)localObject2).b.status = 16;
        this.a.getFileManagerDataCenter().c(((DiscPicThumbDownloader.PicSession)localObject2).b);
      }
      paramString1 = this.a;
      long l2 = ((DiscPicThumbDownloader.PicSession)localObject2).b.nSessionId;
      long l3 = ((DiscPicThumbDownloader.PicSession)localObject2).e;
      paramString2 = ((DiscPicThumbDownloader.PicSession)localObject2).b.peerUin;
      paramString3 = ((DiscPicThumbDownloader.PicSession)localObject2).b.Uuid;
      paramBundle = ((DiscPicThumbDownloader.PicSession)localObject2).b.strFileMd5;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(String.valueOf(paramInt2));
      ((StringBuilder)localObject1).append("&");
      ((StringBuilder)localObject1).append(String.valueOf(paramLong1));
      FileManagerUtil.a(paramString1, l2, "actFileDiscThumb", l3, "", paramString2, paramString3, paramBundle, l1, ((StringBuilder)localObject1).toString(), 0L, 0L, 0L, "", "", 0, "ret error", null);
      paramString1 = this.a;
      l2 = ((DiscPicThumbDownloader.PicSession)localObject2).b.nSessionId;
      l3 = ((DiscPicThumbDownloader.PicSession)localObject2).e;
      paramString2 = ((DiscPicThumbDownloader.PicSession)localObject2).b.peerUin;
      paramString3 = ((DiscPicThumbDownloader.PicSession)localObject2).b.Uuid;
      paramBundle = ((DiscPicThumbDownloader.PicSession)localObject2).b.strFileMd5;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(String.valueOf(paramInt2));
      ((StringBuilder)localObject1).append("&");
      ((StringBuilder)localObject1).append(String.valueOf(paramLong1));
      FileManagerUtil.a(paramString1, l2, "actFileDiscThumbDetail", l3, "", paramString2, paramString3, paramBundle, l1, ((StringBuilder)localObject1).toString(), 0L, 0L, 0L, "", "", 0, "ret error", null);
      this.a.getFileManagerNotifyCenter().a(false, 50, new Object[] { ((DiscPicThumbDownloader.PicSession)localObject2).b, Integer.valueOf(((DiscPicThumbDownloader.PicSession)localObject2).c) });
      a(paramLong2);
      a(paramLong2, false, null, 0, null, null, paramString4, false, null, (short)0, null);
      return;
    }
    ((DiscPicThumbDownloader.PicSession)localObject2).d = paramString4;
    paramString1 = this.c;
    paramInt2 = ((DiscPicThumbDownloader.PicSession)localObject2).c;
    Object localObject1 = "";
    paramString1 = (String)paramString1.get(paramInt2, "");
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = new StringBuilder();
      paramString1.append("http://");
      paramString1.append(paramString2);
      paramString1.append(":");
      paramString1.append(String.valueOf(paramInt1));
      paramString1.append("/ftn_handler/");
      paramString1.append(paramString3);
      paramString1 = paramString1.toString();
      paramBundle = new StringBuilder();
      paramBundle.append("[downloadThumb]  ID[");
      paramBundle.append(paramLong2);
      paramBundle.append("] unknow thumbSize!!!info:");
      paramBundle.append(localObject2.toString());
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, paramBundle.toString());
      this.a.getFileManagerNotifyCenter().a(false, 50, new Object[] { ((DiscPicThumbDownloader.PicSession)localObject2).b, Integer.valueOf(((DiscPicThumbDownloader.PicSession)localObject2).c) });
      FileManagerUtil.a(this.a, ((DiscPicThumbDownloader.PicSession)localObject2).b.nSessionId, "actFileDiscThumb", ((DiscPicThumbDownloader.PicSession)localObject2).e, paramString1, ((DiscPicThumbDownloader.PicSession)localObject2).b.peerUin, ((DiscPicThumbDownloader.PicSession)localObject2).b.Uuid, ((DiscPicThumbDownloader.PicSession)localObject2).b.strFileMd5, 9005L, "size error", 0L, 0L, 0L, paramString1, "", 0, "size error", "");
      FileManagerUtil.a(this.a, ((DiscPicThumbDownloader.PicSession)localObject2).b.nSessionId, "actFileDiscThumbDetail", ((DiscPicThumbDownloader.PicSession)localObject2).e, paramString1, ((DiscPicThumbDownloader.PicSession)localObject2).b.peerUin, ((DiscPicThumbDownloader.PicSession)localObject2).b.Uuid, ((DiscPicThumbDownloader.PicSession)localObject2).b.strFileMd5, 9005L, "size error", 0L, 0L, 0L, paramString1, "", 0, "size error", "");
      a(paramLong2);
      paramString1 = new StringBuilder();
      paramString1.append("/ftn_handler/");
      paramString1.append(paramString3);
      a(paramLong2, false, paramString2, paramInt1, paramString1.toString(), null, paramString4, false, null, (short)0, null);
      return;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("/ftn_handler/");
    ((StringBuilder)localObject2).append(paramString3);
    ((StringBuilder)localObject2).append(paramString1);
    localObject2 = ((StringBuilder)localObject2).toString();
    if ((((IFMConfig)QRoute.api(IFMConfig.class)).isEnableHttpsThumb4Disc(this.a)) && (paramBundle != null))
    {
      paramString1 = paramBundle.getString("strHttpsDomain");
      if (!TextUtils.isEmpty(paramString1))
      {
        s = paramBundle.getShort("httpsPort", (short)0);
        if (s == 0)
        {
          s = 443;
          paramBoolean = bool;
          break label1161;
        }
        paramBoolean = bool;
        break label1161;
      }
    }
    paramString1 = null;
    paramBoolean = false;
    short s = 0;
    label1161:
    paramString3 = (String)localObject1;
    if (paramBundle != null) {
      paramString3 = paramBundle.getString("IPv6Dns");
    }
    a(paramLong2, true, paramString2, paramInt1, (String)localObject2, null, paramString4, paramBoolean, paramString1, s, paramString3);
  }
  
  public boolean a(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    paramDownloadTask = a(paramLong, false);
    if (paramDownloadTask == null)
    {
      paramDownloadTask = new StringBuilder();
      paramDownloadTask.append("[downloadThumb]  ID[");
      paramDownloadTask.append(paramLong);
      paramDownloadTask.append("] onGetDownloadUrl no this session");
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, paramDownloadTask.toString());
      return false;
    }
    if (paramDownloadTask.b.peerType == 3000) {
      this.a.getFileTransferHandler().a(paramLong, paramDownloadTask.b.fileName, Long.parseLong(paramDownloadTask.b.peerUin), paramDownloadTask.b.Uuid, this.d);
    } else {
      this.a.getFileTransferHandler().a(paramLong, paramDownloadTask.b.Uuid, paramDownloadTask.b.fileIdCrc, paramDownloadTask.b.bSend, this.d);
    }
    return true;
  }
  
  public void b(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    int i = 0;
    Object localObject = a(paramLong, false);
    if (localObject == null)
    {
      paramDownloadTask = new StringBuilder();
      paramDownloadTask.append("[downloadThumb]  ID[");
      paramDownloadTask.append(paramLong);
      paramDownloadTask.append("] onDownloadCompleted no this session");
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, paramDownloadTask.toString());
      return;
    }
    if (paramDownloadTask.s != null) {
      i = paramDownloadTask.s.errCode;
    }
    String str1;
    if (paramDownloadTask.s != null) {
      str1 = paramDownloadTask.s.getErrorString();
    } else {
      str1 = "start retry";
    }
    QQAppInterface localQQAppInterface = this.a;
    paramLong = ((DiscPicThumbDownloader.PicSession)localObject).b.nSessionId;
    long l1 = ((DiscPicThumbDownloader.PicSession)localObject).e;
    String str2 = paramDownloadTask.b;
    String str3 = ((DiscPicThumbDownloader.PicSession)localObject).b.peerUin;
    String str4 = ((DiscPicThumbDownloader.PicSession)localObject).b.Uuid;
    String str5 = ((DiscPicThumbDownloader.PicSession)localObject).b.strFileMd5;
    long l2 = i;
    long l3 = paramDownloadTask.t;
    long l4 = paramDownloadTask.j;
    long l5 = paramDownloadTask.k;
    String str6 = paramDownloadTask.b;
    if (paramDownloadTask.s != null) {
      localObject = paramDownloadTask.s.rawRespHeader;
    } else {
      localObject = "respose null";
    }
    FileManagerUtil.a(localQQAppInterface, paramLong, "actFileDiscThumbDetail", l1, str2, str3, str4, str5, l2, str1, l3, l4, l5, str6, (String)localObject, paramDownloadTask.n, str1, "");
  }
  
  public void c(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader
 * JD-Core Version:    0.7.0.1
 */