package com.tencent.mobileqq.filemanager.app;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.util.ArrayMap;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.data.ThumbnailInfo;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class FMObserver
  implements Observer
{
  private ArrayMap<Integer, FMObserver.FileEventOperator> a;
  
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
    QLog.e("FMObserver<FileAssistant>", 1, "OnUpdate : Status[" + i + "] not processed");
  }
  
  private void a(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    long l = ((Long)localObject[0]).longValue();
    int i = ((Integer)localObject[1]).intValue();
    paramArrayOfObject = (String)localObject[2];
    localObject = (String)localObject[3];
    QLog.i("FMObserver<FileAssistant>", 1, "OnZipImageThumbDownloadCompleted thumbUrl[" + (String)localObject + "]");
    a(bool, i, l, (String)localObject, paramArrayOfObject);
  }
  
  private void b(Object paramObject)
  {
    paramObject = (Long)((Object[])(Object[])paramObject)[0];
    QLog.i("FMObserver<FileAssistant>", 1, "OnOnlineFileQueryUpProgressTimeOut, nSessionId=" + paramObject);
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
    QLog.i("FMObserver<FileAssistant>", 1, "OnGetDiscVideoThumbInfo retCode[" + String.valueOf(i) + "],retMsg[" + paramArrayOfObject + "], downloadKey[" + str2 + "], downloadIp[" + str3 + "], downloadDomain[" + str4 + "], port[" + String.valueOf(j) + "]");
    b(bool, i, paramArrayOfObject, str1, str2, str3, str4, j, str5, l, (Bundle)localObject);
  }
  
  private void c(Object paramObject)
  {
    paramObject = (Long)((Object[])(Object[])paramObject)[0];
    QLog.i("FMObserver<FileAssistant>", 1, "OnOnlineFileRecvButSenderReplayTimeOut, nSessionId=" + paramObject);
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
    QLog.i("FMObserver<FileAssistant>", 1, "OnGetOfflineVideoThumbInfo retCode[" + String.valueOf(i) + "],retMsg[" + paramArrayOfObject + "], downloadKey[" + str2 + "], downloadIp[" + str3 + "], downloadDomain[" + str4 + "], port[" + String.valueOf(j) + "]");
    a(bool, i, paramArrayOfObject, str1, str2, str3, str4, j, str5, l, (Bundle)localObject);
  }
  
  private void d(Object paramObject)
  {
    paramObject = (Long)((Object[])(Object[])paramObject)[0];
    QLog.i("FMObserver<FileAssistant>", 1, "OnOnlineFileProgressDirectDone, nSessionId=" + paramObject);
    a(paramObject.longValue());
  }
  
  private void d(Object[] paramArrayOfObject)
  {
    ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    paramArrayOfObject = (FileManagerEntity)localObject[0];
    int i = ((Integer)localObject[1]).intValue();
    localObject = new ThumbnailInfo();
    ((ThumbnailInfo)localObject).jdField_a_of_type_JavaLangObject = paramArrayOfObject;
    ((ThumbnailInfo)localObject).jdField_a_of_type_JavaLangString = paramArrayOfObject.Uuid;
    ((ThumbnailInfo)localObject).jdField_b_of_type_JavaLangString = null;
    ((ThumbnailInfo)localObject).jdField_a_of_type_Long = paramArrayOfObject.nSessionId;
    a((ThumbnailInfo)localObject, i);
  }
  
  private void e(Object paramObject)
  {
    paramObject = (Object[])paramObject;
    a(((Long)paramObject[0]).longValue(), ((Long)paramObject[1]).longValue());
  }
  
  private void e(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    paramArrayOfObject = (FileManagerEntity)localObject[0];
    if (localObject.length > 1) {}
    for (int i = ((Integer)localObject[1]).intValue();; i = 0)
    {
      if (bool)
      {
        localObject = new ThumbnailInfo();
        ((ThumbnailInfo)localObject).jdField_a_of_type_JavaLangObject = paramArrayOfObject;
        ((ThumbnailInfo)localObject).jdField_a_of_type_JavaLangString = paramArrayOfObject.Uuid;
        ((ThumbnailInfo)localObject).jdField_b_of_type_Int = i;
        if (i == 7) {
          ((ThumbnailInfo)localObject).jdField_b_of_type_JavaLangString = paramArrayOfObject.strLargeThumPath;
        }
        for (;;)
        {
          ((ThumbnailInfo)localObject).jdField_a_of_type_Long = paramArrayOfObject.nSessionId;
          a((ThumbnailInfo)localObject);
          return;
          if (i == 5) {
            ((ThumbnailInfo)localObject).jdField_b_of_type_JavaLangString = paramArrayOfObject.strMiddleThumPath;
          } else {
            ((ThumbnailInfo)localObject).jdField_b_of_type_JavaLangString = paramArrayOfObject.strThumbPath;
          }
        }
      }
      localObject = new ThumbnailInfo();
      ((ThumbnailInfo)localObject).jdField_a_of_type_JavaLangObject = paramArrayOfObject;
      ((ThumbnailInfo)localObject).jdField_a_of_type_JavaLangString = paramArrayOfObject.Uuid;
      ((ThumbnailInfo)localObject).jdField_b_of_type_JavaLangString = null;
      ((ThumbnailInfo)localObject).jdField_b_of_type_Int = i;
      ((ThumbnailInfo)localObject).jdField_a_of_type_Long = paramArrayOfObject.nSessionId;
      a((ThumbnailInfo)localObject);
      return;
    }
  }
  
  private void f(Object[] paramArrayOfObject)
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
  
  private void g(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    paramArrayOfObject = (Object[])paramArrayOfObject[2];
    Integer localInteger = (Integer)paramArrayOfObject[0];
    String str = (String)paramArrayOfObject[1];
    if (!bool)
    {
      QLog.i("FMObserver<FileAssistant>", 1, "OnNeedVerifyPwdFailed");
      b(localInteger.intValue(), str);
      return;
    }
    paramArrayOfObject = (Boolean)paramArrayOfObject[2];
    QLog.i("FMObserver<FileAssistant>", 1, "OnNeedVerifyPwdSuccess,  need verify[" + paramArrayOfObject + "]");
    a(paramArrayOfObject.booleanValue());
  }
  
  private void h(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object localObject = (Object[])paramArrayOfObject[2];
    paramArrayOfObject = (Integer)localObject[0];
    String str1 = (String)localObject[1];
    String str2 = (String)localObject[2];
    String str3 = (String)localObject[3];
    localObject = (Boolean)localObject[4];
    if (!bool)
    {
      QLog.i("FMObserver<FileAssistant>", 1, "OnDelClouldFileFaild,  uuid[" + str2 + "]strFileName[" + String.valueOf(str3) + "]errorCode[" + String.valueOf(paramArrayOfObject) + "],retMsg[" + str1 + "],bOffline[" + String.valueOf(localObject) + "]");
      a(str2, str3, paramArrayOfObject, str1, ((Boolean)localObject).booleanValue());
      return;
    }
    QLog.i("FMObserver<FileAssistant>", 1, "OnDelClouldFileSuccess,  uuid[" + str2 + "]strFileName[" + String.valueOf(str3) + "],bOffline[" + String.valueOf(localObject) + "]");
    a(str2, str3, ((Boolean)localObject).booleanValue());
  }
  
  private void i(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    paramArrayOfObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)paramArrayOfObject[0]).intValue();
    String str1 = (String)paramArrayOfObject[1];
    long l1 = ((Long)paramArrayOfObject[2]).longValue();
    long l2 = ((Long)paramArrayOfObject[3]).longValue();
    String str2 = (String)paramArrayOfObject[4];
    long l3 = ((Long)paramArrayOfObject[5]).longValue();
    QLog.i("FMObserver<FileAssistant>", 1, "OnForwardOfflineFile, bSuccess[" + String.valueOf(bool) + "], retCode[" + String.valueOf(i) + "], retMsg[" + String.valueOf(str1) + "], totalSpace[" + String.valueOf(l1) + "], usedSpace[" + String.valueOf(l2) + "], strUuid[" + String.valueOf(str2) + "], nSessionId[" + String.valueOf(l3) + "]");
    a(bool, i, str1, l1, l2, str2, l3);
  }
  
  private void j(Object[] paramArrayOfObject)
  {
    try
    {
      bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
      if (bool) {
        b();
      }
      return;
    }
    catch (Exception paramArrayOfObject)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FMObserver<FileAssistant>", 1, "OnRefreshList param error!");
        }
        boolean bool = false;
      }
    }
  }
  
  private void k(Object[] paramArrayOfObject)
  {
    if (((Boolean)paramArrayOfObject[1]).booleanValue())
    {
      paramArrayOfObject = (Object[])paramArrayOfObject[2];
      localObject = new ThumbnailInfo();
      ((ThumbnailInfo)localObject).jdField_a_of_type_JavaLangString = ((String)paramArrayOfObject[0]);
      ((ThumbnailInfo)localObject).jdField_a_of_type_Int = ((Integer)paramArrayOfObject[1]).intValue();
      ((ThumbnailInfo)localObject).jdField_b_of_type_JavaLangString = ((String)paramArrayOfObject[2]);
      ((ThumbnailInfo)localObject).jdField_a_of_type_JavaLangObject = paramArrayOfObject[3];
      QLog.i("FMObserver<FileAssistant>", 1, "OnThumbDownLoadSuccess,fileId[" + ((ThumbnailInfo)localObject).jdField_a_of_type_JavaLangString + "],filePath[" + ((ThumbnailInfo)localObject).jdField_b_of_type_JavaLangString + "]");
      if ((((ThumbnailInfo)localObject).jdField_a_of_type_JavaLangObject != null) && (((ThumbnailInfo)localObject).jdField_b_of_type_JavaLangString != null) && (((ThumbnailInfo)localObject).jdField_b_of_type_JavaLangString.length() > 0))
      {
        if (!(((ThumbnailInfo)localObject).jdField_a_of_type_JavaLangObject instanceof WeiYunFileInfo)) {
          break label171;
        }
        ((WeiYunFileInfo)((ThumbnailInfo)localObject).jdField_a_of_type_JavaLangObject).h = ((ThumbnailInfo)localObject).jdField_b_of_type_JavaLangString;
      }
      for (;;)
      {
        a((ThumbnailInfo)localObject);
        return;
        label171:
        if ((((ThumbnailInfo)localObject).jdField_a_of_type_JavaLangObject instanceof OfflineFileInfo)) {
          ((OfflineFileInfo)((ThumbnailInfo)localObject).jdField_a_of_type_JavaLangObject).e = ((ThumbnailInfo)localObject).jdField_b_of_type_JavaLangString;
        } else if ((((ThumbnailInfo)localObject).jdField_a_of_type_JavaLangObject instanceof FileManagerEntity)) {
          ((FileManagerEntity)((ThumbnailInfo)localObject).jdField_a_of_type_JavaLangObject).strThumbPath = ((ThumbnailInfo)localObject).jdField_b_of_type_JavaLangString;
        }
      }
    }
    Object localObject = (Object[])paramArrayOfObject[2];
    String str = (String)localObject[0];
    paramArrayOfObject = new ThumbnailInfo();
    paramArrayOfObject.jdField_b_of_type_JavaLangString = null;
    paramArrayOfObject.jdField_a_of_type_JavaLangString = str;
    paramArrayOfObject.jdField_a_of_type_JavaLangObject = localObject[1];
    localObject = new Handler();
    QLog.i("FMObserver<FileAssistant>", 1, "OnThumbDownLoadSuccess(faild),fileId[" + paramArrayOfObject.jdField_a_of_type_JavaLangString + "],delay 1000ms");
    ((Handler)localObject).postDelayed(new FMObserver.43(this, paramArrayOfObject), 1000L);
  }
  
  private void l(Object[] paramArrayOfObject)
  {
    if (((Boolean)paramArrayOfObject[1]).booleanValue())
    {
      paramArrayOfObject = (Object[])paramArrayOfObject[2];
      i = ((Integer)paramArrayOfObject[0]).intValue();
      str1 = (String)paramArrayOfObject[1];
      str2 = (String)paramArrayOfObject[2];
      l = ((Long)paramArrayOfObject[3]).longValue();
      if (QLog.isColorLevel()) {
        QLog.d("FMObserver<FileAssistant>", 2, "OnOfflineSendToWeiYunSuccess, nSessionId[" + String.valueOf(l) + "]");
      }
      a(l, str2, i, str1);
      return;
    }
    paramArrayOfObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)paramArrayOfObject[0]).intValue();
    String str1 = (String)paramArrayOfObject[1];
    String str2 = (String)paramArrayOfObject[2];
    long l = ((Long)paramArrayOfObject[3]).longValue();
    QLog.e("FMObserver<FileAssistant>", 1, "OnWeiYunSendToOfflineFaild, , nSessionId[" + String.valueOf(l) + "], errorCode[" + String.valueOf(i) + "], strErrMsg[" + String.valueOf(str1) + "]");
    a(i, l, str1);
  }
  
  private void m(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    paramArrayOfObject = (Object[])paramArrayOfObject[2];
    a(((Long)paramArrayOfObject[0]).longValue(), bool, ((Integer)paramArrayOfObject[1]).intValue(), (String)paramArrayOfObject[2]);
  }
  
  private void n(Object[] paramArrayOfObject)
  {
    if (((Boolean)paramArrayOfObject[1]).booleanValue())
    {
      if (QLog.isColorLevel()) {
        QLog.d("FMObserver<FileAssistant>", 2, "OnWeiYunSendToOfflineSuccess");
      }
      d();
      return;
    }
    paramArrayOfObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)paramArrayOfObject[0]).intValue();
    String str = (String)paramArrayOfObject[1];
    long l = ((Long)paramArrayOfObject[2]).longValue();
    QLog.e("FMObserver<FileAssistant>", 1, "OnWeiYunSendToOfflineFaild, , nSessionId[" + String.valueOf(l) + "], errorCode[" + String.valueOf(i) + "], strErrMsg[" + String.valueOf(str) + "]");
    a(Integer.valueOf(i), l, str);
  }
  
  private void o(Object[] paramArrayOfObject)
  {
    boolean bool;
    StringBuilder localStringBuilder;
    if (((Boolean)paramArrayOfObject[1]).booleanValue())
    {
      paramArrayOfObject = (Object[])paramArrayOfObject[2];
      bool = ((Boolean)paramArrayOfObject[0]).booleanValue();
      paramArrayOfObject = (List)paramArrayOfObject[1];
      localStringBuilder = new StringBuilder().append("OnWeiYunOfflineListSucess, , isEnd[").append(String.valueOf(bool)).append("], List<OfflineFileInfo> size[");
      if (paramArrayOfObject == null) {
        break label111;
      }
    }
    label111:
    for (int i = paramArrayOfObject.size();; i = 0)
    {
      QLog.i("FMObserver<FileAssistant>", 1, String.valueOf(i) + "]");
      a(Boolean.valueOf(bool), paramArrayOfObject);
      return;
    }
  }
  
  private void p(Object[] paramArrayOfObject)
  {
    if (((Boolean)paramArrayOfObject[1]).booleanValue())
    {
      paramArrayOfObject = (Object[])paramArrayOfObject[2];
      localObject = (String)paramArrayOfObject[0];
      boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
      i = ((Integer)paramArrayOfObject[2]).intValue();
      String str = (String)paramArrayOfObject[3];
      List localList = (List)paramArrayOfObject[4];
      int j = ((Integer)paramArrayOfObject[5]).intValue();
      QLog.i("FMObserver<FileAssistant>", 1, "OnWeiYunOneClassificationInfoSuccess, categoryId[" + (String)localObject + "], isEnd[" + String.valueOf(bool) + "], count[" + String.valueOf(i) + "], localVersion[" + str + "], List<WeiYunFileInfo> size[" + localList.size() + "], index[" + String.valueOf(j) + "]");
      a((String)localObject, bool, i, str, localList, j);
      return;
    }
    Object localObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)localObject[0]).intValue();
    paramArrayOfObject = (String)localObject[1];
    localObject = (String)localObject[2];
    QLog.i("FMObserver<FileAssistant>", 1, "OnWeiYunOneClassificationInfoFaild, , errorCode[" + String.valueOf(i) + "], strErrMsg[" + String.valueOf(paramArrayOfObject) + "], strCategoryId[" + String.valueOf(localObject) + "]");
    a(i, paramArrayOfObject, (String)localObject);
  }
  
  private void q(Object[] paramArrayOfObject)
  {
    boolean bool = ((Boolean)paramArrayOfObject[1]).booleanValue();
    Object[] arrayOfObject = (Object[])paramArrayOfObject[2];
    int i = ((Integer)arrayOfObject[0]).intValue();
    String str1 = (String)arrayOfObject[1];
    String str2 = (String)arrayOfObject[2];
    String str3 = (String)arrayOfObject[3];
    String str4 = (String)arrayOfObject[4];
    String str5 = (String)arrayOfObject[5];
    int j = ((Integer)arrayOfObject[6]).intValue();
    Object localObject = null;
    paramArrayOfObject = localObject;
    if (arrayOfObject.length > 7)
    {
      paramArrayOfObject = localObject;
      if (arrayOfObject[7] != null) {
        paramArrayOfObject = (String)arrayOfObject[7];
      }
    }
    QLog.i("FMObserver<FileAssistant>", 1, "OnWeiYunFilePreview retCode[" + String.valueOf(i) + "],retMsg[" + str1 + "], downloadKey[" + str2 + "], downloadIp[" + str4 + "], downloadDomain[" + str5 + "], port[" + String.valueOf(j) + "]");
    a(bool, i, str1, str2, str3, str4, str5, j, paramArrayOfObject);
  }
  
  private void r(Object[] paramArrayOfObject)
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
    QLog.i("FMObserver<FileAssistant>", 1, "OnDiscFilePreview retCode[" + String.valueOf(i) + "],retMsg[" + paramArrayOfObject + "], downloadKey[" + str2 + "], downloadIp[" + str3 + "], downloadDomain[" + str4 + "], port[" + String.valueOf(j) + "]");
    a(bool, i, paramArrayOfObject, str1, str2, str3, str4, j, null, (Bundle)localObject);
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
    QLog.i("FMObserver<FileAssistant>", 1, "OnFileOfflinePreview retCode[" + String.valueOf(i) + "],retMsg[" + paramArrayOfObject + "], downloadKey[" + str2 + "], downloadIp[" + str3 + "], downloadDomain[" + str4 + "], port[" + String.valueOf(j) + "]");
    b(bool, i, str1, paramArrayOfObject, str2, str3, str4, j, null, (Bundle)localObject);
  }
  
  private void t(Object[] paramArrayOfObject)
  {
    long l1 = ((Long)paramArrayOfObject[1]).longValue();
    long l2 = ((Long)paramArrayOfObject[2]).longValue();
    String str = (String)paramArrayOfObject[3];
    int i = ((Integer)paramArrayOfObject[4]).intValue();
    int j = ((Integer)paramArrayOfObject[5]).intValue();
    if (paramArrayOfObject[6] == null) {}
    for (paramArrayOfObject = null;; paramArrayOfObject = (String)paramArrayOfObject[6])
    {
      a();
      QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferEnd uniseq[" + String.valueOf(l1) + "],nSessionId[" + String.valueOf(l2) + "],errCode[" + String.valueOf(j) + "],errMsg[" + String.valueOf(paramArrayOfObject) + "], peerType[" + String.valueOf(i) + "]");
      c(j, paramArrayOfObject);
      return;
    }
  }
  
  private void u(Object[] paramArrayOfObject)
  {
    long l1 = ((Long)paramArrayOfObject[1]).longValue();
    long l2 = ((Long)paramArrayOfObject[2]).longValue();
    String str = (String)paramArrayOfObject[3];
    int i = ((Integer)paramArrayOfObject[4]).intValue();
    int j = ((Integer)paramArrayOfObject[5]).intValue();
    if (paramArrayOfObject[6] == null) {}
    for (paramArrayOfObject = null;; paramArrayOfObject = (String)paramArrayOfObject[6])
    {
      a();
      QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferEnd uniseq[" + String.valueOf(l1) + "],nSessionId[" + String.valueOf(l2) + "],errCode[" + String.valueOf(j) + "],errMsg[" + String.valueOf(paramArrayOfObject) + "], peerType[" + String.valueOf(i) + "]");
      a(false, l1, l2, str, i, j, paramArrayOfObject);
      return;
    }
  }
  
  private void v(Object[] paramArrayOfObject)
  {
    long l1 = ((Long)paramArrayOfObject[1]).longValue();
    long l2 = ((Long)paramArrayOfObject[2]).longValue();
    String str = (String)paramArrayOfObject[3];
    int i = ((Integer)paramArrayOfObject[4]).intValue();
    a();
    QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferEnd uniseq[" + l1 + "],nSessionId[" + l2 + "], peerType[" + i + "]");
    a(true, l1, l2, str, i, 0, null);
  }
  
  private void w(Object[] paramArrayOfObject)
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
  
  private void x(Object[] paramArrayOfObject)
  {
    long l1 = ((Long)paramArrayOfObject[1]).longValue();
    long l2 = ((Long)paramArrayOfObject[2]).longValue();
    String str = (String)paramArrayOfObject[3];
    int i = ((Integer)paramArrayOfObject[4]).intValue();
    QLog.i("FMObserver<FileAssistant>", 1, "OnFileTransferStart uniseq[" + String.valueOf(l1) + "],nSessionId[" + String.valueOf(l2) + "], strUin[" + FileManagerUtil.e(str) + "], peerType[" + String.valueOf(i) + "]");
    a(l1, l2, str, i);
  }
  
  private void y(Object[] paramArrayOfObject)
  {
    long l1 = ((Long)paramArrayOfObject[1]).longValue();
    long l2 = ((Long)paramArrayOfObject[2]).longValue();
    String str = (String)paramArrayOfObject[3];
    int i = ((Integer)paramArrayOfObject[4]).intValue();
    QLog.i("FMObserver<FileAssistant>", 1, "OnFileCome uniseq[" + String.valueOf(l1) + "],nSessionId[" + String.valueOf(l2) + "], strUin[" + FileManagerUtil.e(str) + "], peerType[" + String.valueOf(i) + "]");
    b(l1, l2, str, i);
  }
  
  private void z(Object[] paramArrayOfObject)
  {
    Object localObject = (Object[])paramArrayOfObject[2];
    long l = ((Long)localObject[0]).longValue();
    int i = ((Integer)localObject[1]).intValue();
    int j = ((Integer)localObject[2]).intValue();
    paramArrayOfObject = (String)localObject[3];
    String str = (String)localObject[4];
    localObject = (Bundle)localObject[5];
    QLog.i("FMObserver<FileAssistant>", 1, "onMMApkFileSafeCheckResult sessionId[" + l + "] errCode[" + i + "] safeLevel [" + j + "] tipString [" + paramArrayOfObject + "] jumpDetailUrl [" + str + "]");
    a(l, i, j, paramArrayOfObject, str, (Bundle)localObject);
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
  
  protected void d() {}
  
  protected void e() {}
  
  protected final void f()
  {
    if (this.a != null) {
      return;
    }
    this.a = new ArrayMap();
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
    this.a.put(Integer.valueOf(191), new FMObserver.39(this));
    this.a.put(Integer.valueOf(192), new FMObserver.40(this));
    this.a.put(Integer.valueOf(60), new FMObserver.41(this));
    this.a.put(Integer.valueOf(200), new FMObserver.42(this));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.app.FMObserver
 * JD-Core Version:    0.7.0.1
 */