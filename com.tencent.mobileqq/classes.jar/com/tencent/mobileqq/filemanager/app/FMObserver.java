package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public class FMObserver
  implements Observer
{
  private Map<Integer, FMObserver.FileEventOperator> a;
  
  private void A(Object[] paramArrayOfObject)
  {
    Object localObject = (Object[])paramArrayOfObject[2];
    long l = ((Long)localObject[0]).longValue();
    int i = ((Integer)localObject[1]).intValue();
    int j = ((Integer)localObject[2]).intValue();
    paramArrayOfObject = (String)localObject[3];
    String str = (String)localObject[4];
    localObject = (Bundle)localObject[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onMMApkFileSafeCheckResult sessionId[");
    localStringBuilder.append(l);
    localStringBuilder.append("] errCode[");
    localStringBuilder.append(i);
    localStringBuilder.append("] safeLevel [");
    localStringBuilder.append(j);
    localStringBuilder.append("] tipString [");
    localStringBuilder.append(paramArrayOfObject);
    localStringBuilder.append("] jumpDetailUrl [");
    localStringBuilder.append(str);
    localStringBuilder.append("]");
    QLog.i("FMObserver<FileAssistant>", 1, localStringBuilder.toString());
    a(l, i, j, paramArrayOfObject, str, (Bundle)localObject);
  }
  
  private void a(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    int i = ((Integer)paramObject[0]).intValue();
    f();
    FMObserver.FileEventOperator localFileEventOperator = (FMObserver.FileEventOperator)this.a.get(Integer.valueOf(i));
    if (localFileEventOperator != null)
    {
      localFileEventOperator.a(paramObject);
      return;
    }
    paramObject = new StringBuilder();
    paramObject.append("OnUpdate : Status[");
    paramObject.append(i);
    paramObject.append("] not processed");
    QLog.e("FMObserver<FileAssistant>", 1, paramObject.toString());
  }
  
  private void a(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    long l = ((Long)localObject[0]).longValue();
    int i = ((Integer)localObject[1]).intValue();
    paramArrayOfObject = (String)localObject[2];
    localObject = (String)localObject[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnZipImageThumbDownloadCompleted thumbUrl[");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("]");
    QLog.i("FMObserver<FileAssistant>", 1, localStringBuilder.toString());
    a(bool, i, l, (String)localObject, paramArrayOfObject);
  }
  
  private void b(Object paramObject)
  {
    paramObject = (Long)((Object[])(Object[])paramObject)[0];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnOnlineFileQueryUpProgressTimeOut, nSessionId=");
    localStringBuilder.append(paramObject);
    QLog.i("FMObserver<FileAssistant>", 1, localStringBuilder.toString());
    c(paramObject.longValue());
  }
  
  private void b(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)localObject[0]).intValue();
    paramArrayOfObject = (String)localObject[1];
    String str1 = (String)localObject[2];
    String str2 = (String)localObject[3];
    String str3 = (String)localObject[4];
    String str4 = (String)localObject[5];
    int j = ((Integer)localObject[6]).intValue();
    String str5 = (String)localObject[7];
    long l = ((Long)localObject[8]).longValue();
    localObject = (Bundle)localObject[9];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnGetDiscVideoThumbInfo retCode[");
    localStringBuilder.append(String.valueOf(i));
    localStringBuilder.append("],retMsg[");
    localStringBuilder.append(paramArrayOfObject);
    localStringBuilder.append("], downloadKey[");
    localStringBuilder.append(str2);
    localStringBuilder.append("], downloadIp[");
    localStringBuilder.append(str3);
    localStringBuilder.append("], downloadDomain[");
    localStringBuilder.append(str4);
    localStringBuilder.append("], port[");
    localStringBuilder.append(String.valueOf(j));
    localStringBuilder.append("]");
    QLog.i("FMObserver<FileAssistant>", 1, localStringBuilder.toString());
    c(bool, i, paramArrayOfObject, str1, str2, str3, str4, j, str5, l, (Bundle)localObject);
  }
  
  private void c(Object paramObject)
  {
    paramObject = (Long)((Object[])(Object[])paramObject)[0];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnOnlineFileRecvButSenderReplayTimeOut, nSessionId=");
    localStringBuilder.append(paramObject);
    QLog.i("FMObserver<FileAssistant>", 1, localStringBuilder.toString());
    b(paramObject.longValue());
  }
  
  private void c(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)localObject[0]).intValue();
    paramArrayOfObject = (String)localObject[1];
    String str1 = (String)localObject[2];
    String str2 = (String)localObject[3];
    String str3 = (String)localObject[4];
    String str4 = (String)localObject[5];
    int j = ((Integer)localObject[6]).intValue();
    String str5 = (String)localObject[7];
    long l = ((Long)localObject[8]).longValue();
    localObject = (Bundle)localObject[9];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnGetOfflineVideoThumbInfo retCode[");
    localStringBuilder.append(String.valueOf(i));
    localStringBuilder.append("],retMsg[");
    localStringBuilder.append(paramArrayOfObject);
    localStringBuilder.append("], downloadKey[");
    localStringBuilder.append(str2);
    localStringBuilder.append("], downloadIp[");
    localStringBuilder.append(str3);
    localStringBuilder.append("], downloadDomain[");
    localStringBuilder.append(str4);
    localStringBuilder.append("], port[");
    localStringBuilder.append(String.valueOf(j));
    localStringBuilder.append("]");
    QLog.i("FMObserver<FileAssistant>", 1, localStringBuilder.toString());
    a(bool, i, paramArrayOfObject, str1, str2, str3, str4, j, str5, l, (Bundle)localObject);
  }
  
  private void d(Object paramObject)
  {
    paramObject = (Long)((Object[])(Object[])paramObject)[0];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnOnlineFileProgressDirectDone, nSessionId=");
    localStringBuilder.append(paramObject);
    QLog.i("FMObserver<FileAssistant>", 1, localStringBuilder.toString());
    a(paramObject.longValue());
  }
  
  private void d(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)localObject[0]).intValue();
    paramArrayOfObject = (String)localObject[1];
    String str1 = (String)localObject[2];
    String str2 = (String)localObject[3];
    String str3 = (String)localObject[4];
    String str4 = (String)localObject[5];
    int j = ((Integer)localObject[6]).intValue();
    String str5 = (String)localObject[7];
    long l = ((Long)localObject[8]).longValue();
    localObject = (Bundle)localObject[9];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnGetOfflineVideoThumbInfo retCode[");
    localStringBuilder.append(String.valueOf(i));
    localStringBuilder.append("],retMsg[");
    localStringBuilder.append(paramArrayOfObject);
    localStringBuilder.append("], downloadKey[");
    localStringBuilder.append(str2);
    localStringBuilder.append("], downloadIp[");
    localStringBuilder.append(str3);
    localStringBuilder.append("], downloadDomain[");
    localStringBuilder.append(str4);
    localStringBuilder.append("], port[");
    localStringBuilder.append(String.valueOf(j));
    localStringBuilder.append("]");
    QLog.i("FMObserver<FileAssistant>", 1, localStringBuilder.toString());
    b(bool, i, paramArrayOfObject, str1, str2, str3, str4, j, str5, l, (Bundle)localObject);
  }
  
  private void e(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    a(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue());
  }
  
  private void e(Object[] paramArrayOfObject)
  {
    ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    paramArrayOfObject = (FileManagerEntity)localObject[0];
    int i = ((Integer)localObject[1]).intValue();
    localObject = new ThumbnailInfo();
    ((ThumbnailInfo)localObject).c = paramArrayOfObject;
    ((ThumbnailInfo)localObject).a = paramArrayOfObject.Uuid;
    ((ThumbnailInfo)localObject).d = null;
    ((ThumbnailInfo)localObject).e = paramArrayOfObject.nSessionId;
    a((ThumbnailInfo)localObject, i);
  }
  
  private void f(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    int i = 0;
    paramArrayOfObject = (FileManagerEntity)localObject[0];
    if (localObject.length > 1) {
      i = ((Integer)localObject[1]).intValue();
    }
    if (bool)
    {
      localObject = new ThumbnailInfo();
      ((ThumbnailInfo)localObject).c = paramArrayOfObject;
      ((ThumbnailInfo)localObject).a = paramArrayOfObject.Uuid;
      ((ThumbnailInfo)localObject).f = i;
      if (i == 7) {
        ((ThumbnailInfo)localObject).d = paramArrayOfObject.strLargeThumPath;
      } else if (i == 5) {
        ((ThumbnailInfo)localObject).d = paramArrayOfObject.strMiddleThumPath;
      } else {
        ((ThumbnailInfo)localObject).d = paramArrayOfObject.strThumbPath;
      }
      ((ThumbnailInfo)localObject).e = paramArrayOfObject.nSessionId;
      a((ThumbnailInfo)localObject);
      return;
    }
    localObject = new ThumbnailInfo();
    ((ThumbnailInfo)localObject).c = paramArrayOfObject;
    ((ThumbnailInfo)localObject).a = paramArrayOfObject.Uuid;
    ((ThumbnailInfo)localObject).d = null;
    ((ThumbnailInfo)localObject).f = i;
    ((ThumbnailInfo)localObject).e = paramArrayOfObject.nSessionId;
    a((ThumbnailInfo)localObject);
  }
  
  private void g(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    paramArrayOfObject = (Integer)localObject[0];
    localObject = (String)localObject[1];
    if (!bool)
    {
      QLog.i("FMObserver<FileAssistant>", 1, "OnVerifyPwdFailed");
      a(paramArrayOfObject.intValue(), (String)localObject);
      return;
    }
    QLog.i("FMObserver<FileAssistant>", 1, "OnVerifyPwdSuccess");
    e();
  }
  
  private void h(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    paramArrayOfObject = (Object[])paramArrayOfObject[2];
    Object localObject = (Integer)paramArrayOfObject[0];
    String str = (String)paramArrayOfObject[1];
    if (!bool)
    {
      QLog.i("FMObserver<FileAssistant>", 1, "OnNeedVerifyPwdFailed");
      b(((Integer)localObject).intValue(), str);
      return;
    }
    paramArrayOfObject = (Boolean)paramArrayOfObject[2];
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OnNeedVerifyPwdSuccess,  need verify[");
    ((StringBuilder)localObject).append(paramArrayOfObject);
    ((StringBuilder)localObject).append("]");
    QLog.i("FMObserver<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    a(paramArrayOfObject.booleanValue());
  }
  
  private void i(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject2 = (Object[])paramArrayOfObject[2];
    Object localObject1 = (Integer)localObject2[0];
    String str2 = (String)localObject2[1];
    paramArrayOfObject = (String)localObject2[2];
    String str1 = (String)localObject2[3];
    localObject2 = (Boolean)localObject2[4];
    if (!bool)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnDelClouldFileFaild,  uuid[");
      localStringBuilder.append(paramArrayOfObject);
      localStringBuilder.append("]strFileName[");
      localStringBuilder.append(String.valueOf(str1));
      localStringBuilder.append("]errorCode[");
      localStringBuilder.append(String.valueOf(localObject1));
      localStringBuilder.append("],retMsg[");
      localStringBuilder.append(str2);
      localStringBuilder.append("],bOffline[");
      localStringBuilder.append(String.valueOf(localObject2));
      localStringBuilder.append("]");
      QLog.i("FMObserver<FileAssistant>", 1, localStringBuilder.toString());
      a(paramArrayOfObject, str1, (Integer)localObject1, str2, ((Boolean)localObject2).booleanValue());
      return;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("OnDelClouldFileSuccess,  uuid[");
    ((StringBuilder)localObject1).append(paramArrayOfObject);
    ((StringBuilder)localObject1).append("]strFileName[");
    ((StringBuilder)localObject1).append(String.valueOf(str1));
    ((StringBuilder)localObject1).append("],bOffline[");
    ((StringBuilder)localObject1).append(String.valueOf(localObject2));
    ((StringBuilder)localObject1).append("]");
    QLog.i("FMObserver<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
    a(paramArrayOfObject, str1, ((Boolean)localObject2).booleanValue());
  }
  
  private void j(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)localObject[0]).intValue();
    paramArrayOfObject = (String)localObject[1];
    long l1 = ((Long)localObject[2]).longValue();
    long l2 = ((Long)localObject[3]).longValue();
    String str = (String)localObject[4];
    long l3 = ((Long)localObject[5]).longValue();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OnForwardOfflineFile, bSuccess[");
    ((StringBuilder)localObject).append(String.valueOf(bool));
    ((StringBuilder)localObject).append("], retCode[");
    ((StringBuilder)localObject).append(String.valueOf(i));
    ((StringBuilder)localObject).append("], retMsg[");
    ((StringBuilder)localObject).append(String.valueOf(paramArrayOfObject));
    ((StringBuilder)localObject).append("], totalSpace[");
    ((StringBuilder)localObject).append(String.valueOf(l1));
    ((StringBuilder)localObject).append("], usedSpace[");
    ((StringBuilder)localObject).append(String.valueOf(l2));
    ((StringBuilder)localObject).append("], strUuid[");
    ((StringBuilder)localObject).append(String.valueOf(str));
    ((StringBuilder)localObject).append("], nSessionId[");
    ((StringBuilder)localObject).append(String.valueOf(l3));
    ((StringBuilder)localObject).append("]");
    QLog.i("FMObserver<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    a(bool, i, paramArrayOfObject, l1, l2, str, l3);
  }
  
  private void k(Object[] paramArrayOfObject)
  {
    try
    {
      bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    }
    catch (Exception paramArrayOfObject)
    {
      boolean bool;
      label13:
      break label13;
    }
    if (QLog.isColorLevel()) {
      QLog.e("FMObserver<FileAssistant>", 1, "OnRefreshList param error!");
    }
    bool = false;
    if (bool) {
      b();
    }
  }
  
  private void l(Object[] paramArrayOfObject)
  {
    if (((Boolean)paramArrayOfObject[1]).booleanValue())
    {
      localObject1 = (Object[])paramArrayOfObject[2];
      paramArrayOfObject = new ThumbnailInfo();
      paramArrayOfObject.a = ((String)localObject1[0]);
      paramArrayOfObject.b = ((Integer)localObject1[1]).intValue();
      paramArrayOfObject.d = ((String)localObject1[2]);
      paramArrayOfObject.c = localObject1[3];
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("OnThumbDownLoadSuccess,fileId[");
      ((StringBuilder)localObject1).append(paramArrayOfObject.a);
      ((StringBuilder)localObject1).append("],filePath[");
      ((StringBuilder)localObject1).append(paramArrayOfObject.d);
      ((StringBuilder)localObject1).append("]");
      QLog.i("FMObserver<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
      if ((paramArrayOfObject.c != null) && (paramArrayOfObject.d != null) && (paramArrayOfObject.d.length() > 0)) {
        if ((paramArrayOfObject.c instanceof WeiYunFileInfo)) {
          ((WeiYunFileInfo)paramArrayOfObject.c).l = paramArrayOfObject.d;
        } else if ((paramArrayOfObject.c instanceof OfflineFileInfo)) {
          ((OfflineFileInfo)paramArrayOfObject.c).k = paramArrayOfObject.d;
        } else if ((paramArrayOfObject.c instanceof FileManagerEntity)) {
          ((FileManagerEntity)paramArrayOfObject.c).strThumbPath = paramArrayOfObject.d;
        }
      }
      a(paramArrayOfObject);
      return;
    }
    Object localObject1 = (Object[])paramArrayOfObject[2];
    Object localObject2 = (String)localObject1[0];
    paramArrayOfObject = new ThumbnailInfo();
    paramArrayOfObject.d = null;
    paramArrayOfObject.a = ((String)localObject2);
    paramArrayOfObject.c = localObject1[1];
    localObject1 = new Handler();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("OnThumbDownLoadSuccess(faild),fileId[");
    ((StringBuilder)localObject2).append(paramArrayOfObject.a);
    ((StringBuilder)localObject2).append("],delay 1000ms");
    QLog.i("FMObserver<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
    ((Handler)localObject1).postDelayed(new FMObserver.46(this, paramArrayOfObject), 1000L);
  }
  
  private void m(Object[] paramArrayOfObject)
  {
    if (((Boolean)paramArrayOfObject[1]).booleanValue())
    {
      localObject2 = (Object[])paramArrayOfObject[2];
      i = ((Integer)localObject2[0]).intValue();
      paramArrayOfObject = (String)localObject2[1];
      localObject1 = (String)localObject2[2];
      l = ((Long)localObject2[3]).longValue();
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("OnOfflineSendToWeiYunSuccess, nSessionId[");
        ((StringBuilder)localObject2).append(String.valueOf(l));
        ((StringBuilder)localObject2).append("]");
        QLog.d("FMObserver<FileAssistant>", 2, ((StringBuilder)localObject2).toString());
      }
      a(l, (String)localObject1, i, paramArrayOfObject);
      return;
    }
    Object localObject1 = (Object[])paramArrayOfObject[2];
    int i = ((Integer)localObject1[0]).intValue();
    paramArrayOfObject = (String)localObject1[1];
    Object localObject2 = (String)localObject1[2];
    long l = ((Long)localObject1[3]).longValue();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("OnWeiYunSendToOfflineFaild, , nSessionId[");
    ((StringBuilder)localObject1).append(String.valueOf(l));
    ((StringBuilder)localObject1).append("], errorCode[");
    ((StringBuilder)localObject1).append(String.valueOf(i));
    ((StringBuilder)localObject1).append("], strErrMsg[");
    ((StringBuilder)localObject1).append(String.valueOf(paramArrayOfObject));
    ((StringBuilder)localObject1).append("]");
    QLog.e("FMObserver<FileAssistant>", 1, ((StringBuilder)localObject1).toString());
    a(i, l, paramArrayOfObject);
  }
  
  private void n(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    paramArrayOfObject = (Object[])paramArrayOfObject[2];
    a(((Long)paramArrayOfObject[0]).longValue(), bool, ((Integer)paramArrayOfObject[1]).intValue(), (String)paramArrayOfObject[2]);
  }
  
  private void o(Object[] paramArrayOfObject)
  {
    if (((Boolean)paramArrayOfObject[1]).booleanValue())
    {
      if (QLog.isColorLevel()) {
        QLog.d("FMObserver<FileAssistant>", 2, "OnWeiYunSendToOfflineSuccess");
      }
      d();
      return;
    }
    Object localObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)localObject[0]).intValue();
    paramArrayOfObject = (String)localObject[1];
    long l = ((Long)localObject[2]).longValue();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OnWeiYunSendToOfflineFaild, , nSessionId[");
    ((StringBuilder)localObject).append(String.valueOf(l));
    ((StringBuilder)localObject).append("], errorCode[");
    ((StringBuilder)localObject).append(String.valueOf(i));
    ((StringBuilder)localObject).append("], strErrMsg[");
    ((StringBuilder)localObject).append(String.valueOf(paramArrayOfObject));
    ((StringBuilder)localObject).append("]");
    QLog.e("FMObserver<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    a(Integer.valueOf(i), l, paramArrayOfObject);
  }
  
  private void p(Object[] paramArrayOfObject)
  {
    if (((Boolean)paramArrayOfObject[1]).booleanValue())
    {
      paramArrayOfObject = (Object[])paramArrayOfObject[2];
      int i = 0;
      boolean bool = ((Boolean)paramArrayOfObject[0]).booleanValue();
      paramArrayOfObject = (List)paramArrayOfObject[1];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("OnWeiYunOfflineListSucess, , isEnd[");
      localStringBuilder.append(String.valueOf(bool));
      localStringBuilder.append("], List<OfflineFileInfo> size[");
      if (paramArrayOfObject != null) {
        i = paramArrayOfObject.size();
      }
      localStringBuilder.append(String.valueOf(i));
      localStringBuilder.append("]");
      QLog.i("FMObserver<FileAssistant>", 1, localStringBuilder.toString());
      a(Boolean.valueOf(bool), paramArrayOfObject);
    }
  }
  
  private void q(Object[] paramArrayOfObject)
  {
    if (((Boolean)paramArrayOfObject[1]).booleanValue())
    {
      Object localObject3 = (Object[])paramArrayOfObject[2];
      paramArrayOfObject = (String)localObject3[0];
      boolean bool = ((Boolean)localObject3[1]).booleanValue();
      i = ((Integer)localObject3[2]).intValue();
      localObject1 = (String)localObject3[3];
      localObject2 = (List)localObject3[4];
      int j = ((Integer)localObject3[5]).intValue();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("OnWeiYunOneClassificationInfoSuccess, categoryId[");
      ((StringBuilder)localObject3).append(paramArrayOfObject);
      ((StringBuilder)localObject3).append("], isEnd[");
      ((StringBuilder)localObject3).append(String.valueOf(bool));
      ((StringBuilder)localObject3).append("], count[");
      ((StringBuilder)localObject3).append(String.valueOf(i));
      ((StringBuilder)localObject3).append("], localVersion[");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("], List<WeiYunFileInfo> size[");
      ((StringBuilder)localObject3).append(((List)localObject2).size());
      ((StringBuilder)localObject3).append("], index[");
      ((StringBuilder)localObject3).append(String.valueOf(j));
      ((StringBuilder)localObject3).append("]");
      QLog.i("FMObserver<FileAssistant>", 1, ((StringBuilder)localObject3).toString());
      a(paramArrayOfObject, bool, i, (String)localObject1, (List)localObject2, j);
      return;
    }
    Object localObject1 = (Object[])paramArrayOfObject[2];
    int i = ((Integer)localObject1[0]).intValue();
    paramArrayOfObject = (String)localObject1[1];
    localObject1 = (String)localObject1[2];
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("OnWeiYunOneClassificationInfoFaild, , errorCode[");
    ((StringBuilder)localObject2).append(String.valueOf(i));
    ((StringBuilder)localObject2).append("], strErrMsg[");
    ((StringBuilder)localObject2).append(String.valueOf(paramArrayOfObject));
    ((StringBuilder)localObject2).append("], strCategoryId[");
    ((StringBuilder)localObject2).append(String.valueOf(localObject1));
    ((StringBuilder)localObject2).append("]");
    QLog.i("FMObserver<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
    a(i, paramArrayOfObject, (String)localObject1);
  }
  
  private void r(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    paramArrayOfObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)paramArrayOfObject[0]).intValue();
    String str1 = (String)paramArrayOfObject[1];
    String str2 = (String)paramArrayOfObject[2];
    String str3 = (String)paramArrayOfObject[3];
    String str4 = (String)paramArrayOfObject[4];
    String str5 = (String)paramArrayOfObject[5];
    int j = ((Integer)paramArrayOfObject[6]).intValue();
    if ((paramArrayOfObject.length > 7) && (paramArrayOfObject[7] != null)) {
      paramArrayOfObject = (String)paramArrayOfObject[7];
    } else {
      paramArrayOfObject = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnWeiYunFilePreview retCode[");
    localStringBuilder.append(String.valueOf(i));
    localStringBuilder.append("],retMsg[");
    localStringBuilder.append(str1);
    localStringBuilder.append("], downloadKey[");
    localStringBuilder.append(str2);
    localStringBuilder.append("], downloadIp[");
    localStringBuilder.append(str4);
    localStringBuilder.append("], downloadDomain[");
    localStringBuilder.append(str5);
    localStringBuilder.append("], port[");
    localStringBuilder.append(String.valueOf(j));
    localStringBuilder.append("]");
    QLog.i("FMObserver<FileAssistant>", 1, localStringBuilder.toString());
    a(bool, i, str1, str2, str3, str4, str5, j, paramArrayOfObject);
  }
  
  private void s(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)localObject[0]).intValue();
    paramArrayOfObject = (String)localObject[1];
    String str1 = (String)localObject[2];
    String str2 = (String)localObject[3];
    String str3 = (String)localObject[4];
    String str4 = (String)localObject[5];
    int j = ((Integer)localObject[6]).intValue();
    localObject = (Bundle)localObject[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnDiscFilePreview retCode[");
    localStringBuilder.append(String.valueOf(i));
    localStringBuilder.append("],retMsg[");
    localStringBuilder.append(paramArrayOfObject);
    localStringBuilder.append("], downloadKey[");
    localStringBuilder.append(str2);
    localStringBuilder.append("], downloadIp[");
    localStringBuilder.append(str3);
    localStringBuilder.append("], downloadDomain[");
    localStringBuilder.append(str4);
    localStringBuilder.append("], port[");
    localStringBuilder.append(String.valueOf(j));
    localStringBuilder.append("]");
    QLog.i("FMObserver<FileAssistant>", 1, localStringBuilder.toString());
    a(bool, i, paramArrayOfObject, str1, str2, str3, str4, j, null, (Bundle)localObject);
  }
  
  private void t(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)localObject[0]).intValue();
    paramArrayOfObject = (String)localObject[1];
    String str1 = (String)localObject[2];
    String str2 = (String)localObject[3];
    String str3 = (String)localObject[4];
    String str4 = (String)localObject[5];
    int j = ((Integer)localObject[6]).intValue();
    localObject = (Bundle)localObject[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnFileOfflinePreview retCode[");
    localStringBuilder.append(String.valueOf(i));
    localStringBuilder.append("],retMsg[");
    localStringBuilder.append(paramArrayOfObject);
    localStringBuilder.append("], downloadKey[");
    localStringBuilder.append(str2);
    localStringBuilder.append("], downloadIp[");
    localStringBuilder.append(str3);
    localStringBuilder.append("], downloadDomain[");
    localStringBuilder.append(str4);
    localStringBuilder.append("], port[");
    localStringBuilder.append(String.valueOf(j));
    localStringBuilder.append("]");
    QLog.i("FMObserver<FileAssistant>", 1, localStringBuilder.toString());
    b(bool, i, str1, paramArrayOfObject, str2, str3, str4, j, null, (Bundle)localObject);
  }
  
  private void u(Object[] paramArrayOfObject)
  {
    long l1 = ((Long)paramArrayOfObject[1]).longValue();
    long l2 = ((Long)paramArrayOfObject[2]).longValue();
    Object localObject = (String)paramArrayOfObject[3];
    int i = ((Integer)paramArrayOfObject[4]).intValue();
    int j = ((Integer)paramArrayOfObject[5]).intValue();
    if (paramArrayOfObject[6] == null) {
      paramArrayOfObject = null;
    } else {
      paramArrayOfObject = (String)paramArrayOfObject[6];
    }
    a();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("OnFileTransferEnd uniseq[");
    ((StringBuilder)localObject).append(String.valueOf(l1));
    ((StringBuilder)localObject).append("],nSessionId[");
    ((StringBuilder)localObject).append(String.valueOf(l2));
    ((StringBuilder)localObject).append("],errCode[");
    ((StringBuilder)localObject).append(String.valueOf(j));
    ((StringBuilder)localObject).append("],errMsg[");
    ((StringBuilder)localObject).append(String.valueOf(paramArrayOfObject));
    ((StringBuilder)localObject).append("], peerType[");
    ((StringBuilder)localObject).append(String.valueOf(i));
    ((StringBuilder)localObject).append("]");
    QLog.i("FMObserver<FileAssistant>", 1, ((StringBuilder)localObject).toString());
    c(j, paramArrayOfObject);
  }
  
  private void v(Object[] paramArrayOfObject)
  {
    long l1 = ((Long)paramArrayOfObject[1]).longValue();
    long l2 = ((Long)paramArrayOfObject[2]).longValue();
    String str = (String)paramArrayOfObject[3];
    int i = ((Integer)paramArrayOfObject[4]).intValue();
    int j = ((Integer)paramArrayOfObject[5]).intValue();
    if (paramArrayOfObject[6] == null) {
      paramArrayOfObject = null;
    } else {
      paramArrayOfObject = (String)paramArrayOfObject[6];
    }
    a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("OnFileTransferEnd uniseq[");
    localStringBuilder.append(String.valueOf(l1));
    localStringBuilder.append("],nSessionId[");
    localStringBuilder.append(String.valueOf(l2));
    localStringBuilder.append("],errCode[");
    localStringBuilder.append(String.valueOf(j));
    localStringBuilder.append("],errMsg[");
    localStringBuilder.append(String.valueOf(paramArrayOfObject));
    localStringBuilder.append("], peerType[");
    localStringBuilder.append(String.valueOf(i));
    localStringBuilder.append("]");
    QLog.i("FMObserver<FileAssistant>", 1, localStringBuilder.toString());
    a(false, l1, l2, str, i, j, paramArrayOfObject);
  }
  
  private void w(Object[] paramArrayOfObject)
  {
    long l1 = ((Long)paramArrayOfObject[1]).longValue();
    long l2 = ((Long)paramArrayOfObject[2]).longValue();
    String str = (String)paramArrayOfObject[3];
    int i = ((Integer)paramArrayOfObject[4]).intValue();
    a();
    paramArrayOfObject = new StringBuilder();
    paramArrayOfObject.append("OnFileTransferEnd uniseq[");
    paramArrayOfObject.append(l1);
    paramArrayOfObject.append("],nSessionId[");
    paramArrayOfObject.append(l2);
    paramArrayOfObject.append("], peerType[");
    paramArrayOfObject.append(i);
    paramArrayOfObject.append("]");
    QLog.i("FMObserver<FileAssistant>", 1, paramArrayOfObject.toString());
    a(true, l1, l2, str, i, 0, null);
  }
  
  private void x(Object[] paramArrayOfObject)
  {
    long l1 = ((Long)paramArrayOfObject[1]).longValue();
    long l2 = ((Long)paramArrayOfObject[2]).longValue();
    String str = (String)paramArrayOfObject[3];
    int i = ((Integer)paramArrayOfObject[4]).intValue();
    if (((Integer)paramArrayOfObject[5]).intValue() == 14)
    {
      a(false, l1, l2, str, i);
      return;
    }
    a(true, l1, l2, str, i);
  }
  
  private void y(Object[] paramArrayOfObject)
  {
    long l1 = ((Long)paramArrayOfObject[1]).longValue();
    long l2 = ((Long)paramArrayOfObject[2]).longValue();
    String str = (String)paramArrayOfObject[3];
    int i = ((Integer)paramArrayOfObject[4]).intValue();
    if (QLog.isColorLevel())
    {
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append("OnFileTransferStart uniseq[");
      paramArrayOfObject.append(String.valueOf(l1));
      paramArrayOfObject.append("],nSessionId[");
      paramArrayOfObject.append(String.valueOf(l2));
      paramArrayOfObject.append("], strUin[");
      paramArrayOfObject.append(str);
      paramArrayOfObject.append("], peerType[");
      paramArrayOfObject.append(String.valueOf(i));
      paramArrayOfObject.append("]");
      QLog.i("FMObserver<FileAssistant>", 1, paramArrayOfObject.toString());
    }
    a(l1, l2, str, i);
  }
  
  private void z(Object[] paramArrayOfObject)
  {
    long l1 = ((Long)paramArrayOfObject[1]).longValue();
    long l2 = ((Long)paramArrayOfObject[2]).longValue();
    String str = (String)paramArrayOfObject[3];
    int i = ((Integer)paramArrayOfObject[4]).intValue();
    if (QLog.isColorLevel())
    {
      paramArrayOfObject = new StringBuilder();
      paramArrayOfObject.append("OnFileCome uniseq[");
      paramArrayOfObject.append(String.valueOf(l1));
      paramArrayOfObject.append("],nSessionId[");
      paramArrayOfObject.append(String.valueOf(l2));
      paramArrayOfObject.append("], strUin[");
      paramArrayOfObject.append(str);
      paramArrayOfObject.append("], peerType[");
      paramArrayOfObject.append(String.valueOf(i));
      paramArrayOfObject.append("]");
      QLog.i("FMObserver<FileAssistant>", 1, paramArrayOfObject.toString());
    }
    b(l1, l2, str, i);
  }
  
  protected void a() {}
  
  protected void a(int paramInt, long paramLong, String paramString) {}
  
  protected void a(int paramInt, String paramString) {}
  
  protected void a(int paramInt, String paramString1, String paramString2) {}
  
  protected void a(long paramLong) {}
  
  protected void a(long paramLong, int paramInt1, int paramInt2, String paramString1, String paramString2, Bundle paramBundle) {}
  
  protected void a(long paramLong1, long paramLong2) {}
  
  protected void a(long paramLong1, long paramLong2, String paramString, int paramInt) {}
  
  protected void a(long paramLong, String paramString1, int paramInt, String paramString2) {}
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt, String paramString) {}
  
  protected void a(ThumbnailInfo paramThumbnailInfo) {}
  
  protected void a(ThumbnailInfo paramThumbnailInfo, int paramInt) {}
  
  protected void a(Boolean paramBoolean, List<OfflineFileInfo> paramList) {}
  
  protected void a(Integer paramInteger, long paramLong, String paramString) {}
  
  protected void a(String paramString1, String paramString2, Integer paramInteger, String paramString3, boolean paramBoolean) {}
  
  protected void a(String paramString1, String paramString2, boolean paramBoolean) {}
  
  protected void a(String paramString1, boolean paramBoolean, int paramInt1, String paramString2, List<WeiYunFileInfo> paramList, int paramInt2) {}
  
  protected void a(boolean paramBoolean) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString1, String paramString2) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString1, long paramLong1, long paramLong2, String paramString2, long paramLong3) {}
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6) {}
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, long paramLong, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, Bundle paramBundle) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString, int paramInt) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, String paramString1, int paramInt1, int paramInt2, String paramString2) {}
  
  protected void b() {}
  
  protected void b(int paramInt, String paramString) {}
  
  protected void b(long paramLong) {}
  
  protected void b(long paramLong1, long paramLong2, String paramString, int paramInt) {}
  
  protected void b(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, long paramLong, Bundle paramBundle) {}
  
  protected void b(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, Bundle paramBundle) {}
  
  protected void c() {}
  
  protected void c(int paramInt, String paramString) {}
  
  protected void c(long paramLong) {}
  
  protected void c(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, long paramLong, Bundle paramBundle) {}
  
  protected void d() {}
  
  protected void e() {}
  
  protected final void f()
  {
    if (this.a != null) {
      return;
    }
    this.a = new HashMap();
    this.a.put(Integer.valueOf(17), new FMObserver.2(this));
    this.a.put(Integer.valueOf(0), new FMObserver.3(this));
    this.a.put(Integer.valueOf(25), new FMObserver.4(this));
    this.a.put(Integer.valueOf(10), new FMObserver.5(this));
    this.a.put(Integer.valueOf(13), new FMObserver.6(this));
    this.a.put(Integer.valueOf(16), new FMObserver.7(this));
    this.a.put(Integer.valueOf(14), new FMObserver.8(this));
    this.a.put(Integer.valueOf(11), new FMObserver.9(this));
    this.a.put(Integer.valueOf(35), new FMObserver.10(this));
    this.a.put(Integer.valueOf(37), new FMObserver.11(this));
    this.a.put(Integer.valueOf(1), new FMObserver.12(this));
    this.a.put(Integer.valueOf(15), new FMObserver.13(this));
    this.a.put(Integer.valueOf(12), new FMObserver.14(this));
    this.a.put(Integer.valueOf(36), new FMObserver.15(this));
    this.a.put(Integer.valueOf(38), new FMObserver.16(this));
    this.a.put(Integer.valueOf(22), new FMObserver.17(this));
    this.a.put(Integer.valueOf(4), new FMObserver.18(this));
    this.a.put(Integer.valueOf(18), new FMObserver.19(this));
    this.a.put(Integer.valueOf(21), new FMObserver.20(this));
    this.a.put(Integer.valueOf(278), new FMObserver.21(this));
    this.a.put(Integer.valueOf(31), new FMObserver.22(this));
    this.a.put(Integer.valueOf(32), new FMObserver.23(this));
    this.a.put(Integer.valueOf(33), new FMObserver.24(this));
    this.a.put(Integer.valueOf(46), new FMObserver.25(this));
    this.a.put(Integer.valueOf(34), new FMObserver.26(this));
    this.a.put(Integer.valueOf(39), new FMObserver.27(this));
    this.a.put(Integer.valueOf(3), new FMObserver.28(this));
    this.a.put(Integer.valueOf(19), new FMObserver.29(this));
    this.a.put(Integer.valueOf(20), new FMObserver.30(this));
    this.a.put(Integer.valueOf(41), new FMObserver.31(this));
    this.a.put(Integer.valueOf(42), new FMObserver.32(this));
    this.a.put(Integer.valueOf(43), new FMObserver.33(this));
    this.a.put(Integer.valueOf(44), new FMObserver.34(this));
    this.a.put(Integer.valueOf(45), new FMObserver.35(this));
    this.a.put(Integer.valueOf(51), new FMObserver.36(this));
    this.a.put(Integer.valueOf(50), new FMObserver.37(this));
    this.a.put(Integer.valueOf(52), new FMObserver.38(this));
    this.a.put(Integer.valueOf(54), new FMObserver.39(this));
    this.a.put(Integer.valueOf(55), new FMObserver.40(this));
    this.a.put(Integer.valueOf(191), new FMObserver.41(this));
    this.a.put(Integer.valueOf(193), new FMObserver.42(this));
    this.a.put(Integer.valueOf(192), new FMObserver.43(this));
    this.a.put(Integer.valueOf(60), new FMObserver.44(this));
    this.a.put(Integer.valueOf(200), new FMObserver.45(this));
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = Looper.getMainLooper();
    if (Thread.currentThread() != paramObservable.getThread())
    {
      new Handler(paramObservable).post(new FMObserver.1(this, paramObject));
      return;
    }
    a(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FMObserver
 * JD-Core Version:    0.7.0.1
 */