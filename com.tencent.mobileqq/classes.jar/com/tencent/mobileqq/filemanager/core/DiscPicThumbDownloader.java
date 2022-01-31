package com.tencent.mobileqq.filemanager.core;

import acks;
import ackt;
import acku;
import ackv;
import ackw;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.settings.FMSettings;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FilePicURLDrawlableHelper;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.securitysdk.utils.MD5;

public class DiscPicThumbDownloader
  extends BaseThumbDownloader
{
  private FileTransferObserver a;
  
  public DiscPicThumbDownloader(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver = new ackw(this);
  }
  
  private DiscPicThumbDownloader.PicSession a(long paramLong, boolean paramBoolean)
  {
    BaseThumbDownloader.Session localSession = a(paramLong);
    if (localSession == null) {
      return null;
    }
    if ((localSession instanceof DiscPicThumbDownloader.PicSession)) {
      return (DiscPicThumbDownloader.PicSession)localSession;
    }
    QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb] getSession  ID[" + paramLong + "] no instance");
    return null;
  }
  
  private String b(int paramInt, String paramString)
  {
    String str;
    switch (paramInt)
    {
    default: 
      str = "x-dsc-";
    }
    for (;;)
    {
      return str + paramString;
      str = "micro-dsc-";
      continue;
      str = "minni-dsc-";
      continue;
      str = "small-dsc-";
      continue;
      str = "middle-dsc-";
      continue;
      str = "large-dsc-";
      continue;
      str = "qlarge-dsc-";
      continue;
      str = "xlarge-dsc-";
      continue;
      str = "qxlarge-dsc-";
      continue;
      str = "screen-dsc-";
    }
  }
  
  public String a(FileManagerEntity paramFileManagerEntity, int paramInt)
  {
    if (TextUtils.isEmpty(paramFileManagerEntity.Uuid))
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb]  download. uuid = null nSession[" + paramFileManagerEntity.nSessionId + "]");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false, 50, new Object[] { paramFileManagerEntity, Integer.valueOf(paramInt) });
      return null;
    }
    a();
    if ((TextUtils.isEmpty(paramFileManagerEntity.Uuid)) && (QLog.isDevelopLevel())) {
      throw new NullPointerException("uuid is null!!!");
    }
    String str = FMSettings.a().d() + b(paramInt, MD5.a(paramFileManagerEntity.Uuid));
    if ((!FileUtil.b(str)) && (!TextUtils.isEmpty(paramFileManagerEntity.strFileMd5))) {
      str = FMSettings.a().d() + b(paramInt, MD5.a(paramFileManagerEntity.strFileMd5));
    }
    for (;;)
    {
      if (FileUtils.b(str) == true)
      {
        if (paramInt == 7)
        {
          paramFileManagerEntity.strLargeThumPath = str;
          if (FilePicURLDrawlableHelper.b(paramFileManagerEntity)) {
            ThreadManager.post(new acks(this, paramFileManagerEntity), 8, null, false);
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(paramFileManagerEntity);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 50, new Object[] { paramFileManagerEntity, Integer.valueOf(paramInt) });
          QLog.e("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb] Id[" + paramFileManagerEntity.nSessionId + "] thumb Downloaded:" + str);
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFileManagerEntity.nSessionId, "actFileDiscThumb", 0L, "", paramFileManagerEntity.peerUin, paramFileManagerEntity.Uuid, paramFileManagerEntity.strFileMd5, 0L, 0L, 0L, 0, null);
          return str;
          if (paramInt == 5)
          {
            paramFileManagerEntity.strMiddleThumPath = str;
            if (FilePicURLDrawlableHelper.b(paramFileManagerEntity)) {
              ThreadManager.post(new ackt(this, paramFileManagerEntity), 8, null, false);
            }
          }
          else
          {
            paramFileManagerEntity.strThumbPath = str;
          }
        }
      }
      DiscPicThumbDownloader.PicSession localPicSession = new DiscPicThumbDownloader.PicSession(paramFileManagerEntity);
      localPicSession.jdField_a_of_type_Int = paramInt;
      a(localPicSession, str);
      QLog.i("DiscPicThumbDownloader<FileAssistant>", 1, "[downloadThumb] download  nSession[" + paramFileManagerEntity.nSessionId + "], ThumbDownloadId[" + localPicSession.jdField_a_of_type_Long + "]");
      return null;
    }
  }
  
  public void a(long paramLong, int paramInt, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    paramDownloadTask = a(paramLong, false);
    if (paramDownloadTask == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 52, new Object[] { paramDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(paramInt) });
  }
  
  public void a(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    Object localObject = a(paramLong, false);
    if (localObject == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    int i;
    String str1;
    label76:
    QQAppInterface localQQAppInterface;
    long l1;
    String str2;
    String str3;
    String str4;
    String str5;
    long l2;
    long l3;
    long l4;
    long l5;
    String str6;
    if (paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null)
    {
      i = paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.f;
      if (paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null) {
        break label228;
      }
      str1 = paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.d();
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      paramLong = ((DiscPicThumbDownloader.PicSession)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      l1 = ((DiscPicThumbDownloader.PicSession)localObject).b;
      str2 = paramDownloadTask.jdField_a_of_type_JavaLangString;
      str3 = ((DiscPicThumbDownloader.PicSession)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      str4 = ((DiscPicThumbDownloader.PicSession)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      str5 = ((DiscPicThumbDownloader.PicSession)localObject).jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      l2 = i;
      l3 = paramDownloadTask.e;
      l4 = paramDownloadTask.jdField_c_of_type_Long;
      l5 = paramDownloadTask.jdField_a_of_type_Int;
      str6 = paramDownloadTask.jdField_a_of_type_JavaLangString;
      if (paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null) {
        break label236;
      }
    }
    label228:
    label236:
    for (localObject = paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.d;; localObject = "respose null")
    {
      FileManagerUtil.a(localQQAppInterface, paramLong, "actFileDiscThumbDetail", l1, str2, str3, str4, str5, l2, str1, l3, l4, l5, str6, (String)localObject, paramDownloadTask.jdField_c_of_type_Int, str1, "");
      return;
      i = 0;
      break;
      str1 = "start retry";
      break label76;
    }
  }
  
  public void a(long paramLong, HttpMsg paramHttpMsg)
  {
    DiscPicThumbDownloader.PicSession localPicSession = a(paramLong, false);
    if (localPicSession == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onSetHttpMsg no this session");
      return;
    }
    paramHttpMsg.jdField_c_of_type_Int = 3000;
    paramHttpMsg.a("Cookie", localPicSession.jdField_a_of_type_JavaLangString);
  }
  
  public void a(long paramLong, boolean paramBoolean, int paramInt, String paramString, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    DiscPicThumbDownloader.PicSession localPicSession = a(paramLong, false);
    if (localPicSession == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onDownloadCompleted no this session");
      return;
    }
    if (paramBoolean)
    {
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumb", System.currentTimeMillis() - localPicSession.b, paramDownloadTask.jdField_a_of_type_JavaLangString, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramDownloadTask.e, paramDownloadTask.jdField_c_of_type_Long, paramDownloadTask.jdField_a_of_type_Int, paramDownloadTask.jdField_b_of_type_Int, null);
      if (localPicSession.jdField_a_of_type_Int == 7)
      {
        localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strLargeThumPath = paramString;
        FileManagerUtil.e(localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        ThreadManager.post(new acku(this, localPicSession), 8, null, false);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramBoolean, 50, new Object[] { localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, Integer.valueOf(localPicSession.jdField_a_of_type_Int) });
      super.a(paramLong, paramBoolean, paramInt, paramString, paramDownloadTask);
      return;
      if (localPicSession.jdField_a_of_type_Int == 5)
      {
        localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strMiddleThumPath = paramString;
        FileManagerUtil.e(localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        if (!FilePicURLDrawlableHelper.b(localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity)) {
          break;
        }
        ThreadManager.post(new ackv(this, localPicSession), 8, null, false);
        break;
      }
      localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath = paramString;
      break;
      switch (paramInt)
      {
      }
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    long l1 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
    long l2 = localPicSession.b;
    Object localObject2 = paramDownloadTask.jdField_a_of_type_JavaLangString;
    String str2 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
    String str3 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
    String str4 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
    long l3 = paramDownloadTask.e;
    long l4 = paramDownloadTask.jdField_c_of_type_Long;
    long l5 = paramDownloadTask.jdField_a_of_type_Int;
    String str5 = paramDownloadTask.jdField_a_of_type_JavaLangString;
    if (paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null)
    {
      str1 = paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.d;
      label462:
      FileManagerUtil.a((QQAppInterface)localObject1, l1, "actFileDiscThumb", l2, (String)localObject2, str2, str3, str4, 9003L, "rename error", l3, l4, l5, str5, str1, paramDownloadTask.jdField_b_of_type_Int, "rename error", "");
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      l2 = localPicSession.b;
      localObject2 = paramDownloadTask.jdField_a_of_type_JavaLangString;
      str2 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      str3 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      str4 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      l3 = paramDownloadTask.e;
      l4 = paramDownloadTask.jdField_c_of_type_Long;
      l5 = paramDownloadTask.jdField_a_of_type_Int;
      str5 = paramDownloadTask.jdField_a_of_type_JavaLangString;
      if (paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null) {
        break label1994;
      }
    }
    label770:
    label1155:
    label1173:
    label1978:
    label1994:
    for (String str1 = paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.d;; str1 = "respose null")
    {
      FileManagerUtil.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, str2, str3, str4, 9003L, "rename error", l3, l4, l5, str5, str1, paramDownloadTask.jdField_c_of_type_Int, "rename error", "");
      break;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      l2 = localPicSession.b;
      localObject2 = paramDownloadTask.jdField_a_of_type_JavaLangString;
      str2 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      str3 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      str4 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      l3 = paramDownloadTask.e;
      l4 = paramDownloadTask.jdField_c_of_type_Long;
      l5 = localPicSession.jdField_a_of_type_Int;
      str5 = paramDownloadTask.jdField_a_of_type_JavaLangString;
      if (paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null)
      {
        str1 = paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.d;
        FileManagerUtil.a((QQAppInterface)localObject1, l1, "actFileDiscThumb", l2, (String)localObject2, str2, str3, str4, 9004L, "no network", l3, l4, l5, str5, str1, paramDownloadTask.jdField_b_of_type_Int, "no network", "");
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        l1 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
        l2 = localPicSession.b;
        localObject2 = paramDownloadTask.jdField_a_of_type_JavaLangString;
        str2 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
        str3 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
        str4 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
        l3 = paramDownloadTask.e;
        l4 = paramDownloadTask.jdField_c_of_type_Long;
        l5 = localPicSession.jdField_a_of_type_Int;
        str5 = paramDownloadTask.jdField_a_of_type_JavaLangString;
        if (paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null) {
          break label979;
        }
      }
      label979:
      for (str1 = paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.d;; str1 = "respose null")
      {
        FileManagerUtil.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, str2, str3, str4, 9004L, "no network", l3, l4, l5, str5, str1, paramDownloadTask.jdField_c_of_type_Int, "no network", "");
        break;
        str1 = "respose null";
        break label770;
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumb", localPicSession.b, paramDownloadTask.jdField_a_of_type_JavaLangString, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "FileNotFoundException", 0L, 0L, 0L, paramDownloadTask.jdField_a_of_type_JavaLangString, "", 0, "FileNotFoundException", "");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumbDetail", localPicSession.b, paramDownloadTask.jdField_a_of_type_JavaLangString, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "FileNotFoundException", 0L, 0L, 0L, paramDownloadTask.jdField_a_of_type_JavaLangString, "", 0, "size error", "");
      break;
      int i;
      long l6;
      String str6;
      if (paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null)
      {
        i = paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.f;
        if (paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null) {
          break label1491;
        }
        str1 = paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.d();
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        l1 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
        l2 = localPicSession.b;
        str2 = paramDownloadTask.jdField_a_of_type_JavaLangString;
        str3 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
        str4 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
        str5 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
        l3 = i;
        l4 = paramDownloadTask.e;
        l5 = paramDownloadTask.jdField_c_of_type_Long;
        l6 = paramDownloadTask.jdField_a_of_type_Int;
        str6 = paramDownloadTask.jdField_a_of_type_JavaLangString;
        if (paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null) {
          break label1499;
        }
        localObject1 = paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.d;
        FileManagerUtil.a((QQAppInterface)localObject2, l1, "actFileDiscThumb", l2, str2, str3, str4, str5, l3, str1, l4, l5, l6, str6, (String)localObject1, paramDownloadTask.jdField_b_of_type_Int, str1, "");
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        l1 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
        l2 = localPicSession.b;
        str2 = paramDownloadTask.jdField_a_of_type_JavaLangString;
        str3 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
        str4 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
        str5 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
        l3 = i;
        l4 = paramDownloadTask.e;
        l5 = paramDownloadTask.jdField_c_of_type_Long;
        l6 = paramDownloadTask.jdField_a_of_type_Int;
        str6 = paramDownloadTask.jdField_a_of_type_JavaLangString;
        if (paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null) {
          break label1507;
        }
      }
      label1491:
      label1499:
      label1507:
      for (localObject1 = paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.d;; localObject1 = "respose null")
      {
        FileManagerUtil.a((QQAppInterface)localObject2, l1, "actFileDiscThumbDetail", l2, str2, str3, str4, str5, l3, str1, l4, l5, l6, str6, (String)localObject1, paramDownloadTask.jdField_c_of_type_Int, str1, "");
        break;
        i = 0;
        break label1155;
        str1 = "http resp err";
        break label1173;
        localObject1 = "respose null";
        break label1285;
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumb", localPicSession.b, paramDownloadTask.jdField_a_of_type_JavaLangString, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, "noRs", 0L, 0L, 0L, paramDownloadTask.jdField_a_of_type_JavaLangString, "", 0, "noRs", "");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, "actFileDiscThumbDetail", localPicSession.b, paramDownloadTask.jdField_a_of_type_JavaLangString, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, "noRs", paramDownloadTask.e, paramDownloadTask.jdField_c_of_type_Long, paramDownloadTask.jdField_a_of_type_Int, paramDownloadTask.jdField_a_of_type_JavaLangString, "", 0, "noRs", "");
      break;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      l1 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
      l2 = localPicSession.b;
      localObject2 = paramDownloadTask.jdField_a_of_type_JavaLangString;
      str2 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
      str3 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
      str4 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
      l3 = paramDownloadTask.jdField_c_of_type_Long;
      l4 = paramDownloadTask.jdField_a_of_type_Int;
      str5 = paramDownloadTask.jdField_a_of_type_JavaLangString;
      if (paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null)
      {
        str1 = paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.d;
        label1778:
        FileManagerUtil.a((QQAppInterface)localObject1, l1, "actFileDiscThumb", l2, (String)localObject2, str2, str3, str4, 9003L, "revStream write Exception", 0L, l3, l4, str5, str1, paramDownloadTask.jdField_b_of_type_Int, "revStream write Exception", "");
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        l1 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId;
        l2 = localPicSession.b;
        localObject2 = paramDownloadTask.jdField_a_of_type_JavaLangString;
        str2 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin;
        str3 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
        str4 = localPicSession.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5;
        l3 = paramDownloadTask.jdField_c_of_type_Long;
        l4 = paramDownloadTask.jdField_a_of_type_Int;
        str5 = paramDownloadTask.jdField_a_of_type_JavaLangString;
        if (paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null) {
          break label1978;
        }
      }
      for (str1 = paramDownloadTask.jdField_b_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.d;; str1 = "respose null")
      {
        FileManagerUtil.a((QQAppInterface)localObject1, l1, "actFileDiscThumbDetail", l2, (String)localObject2, str2, str3, str4, 9003L, "revStream write Exception", 0L, l3, l4, str5, str1, paramDownloadTask.jdField_c_of_type_Int, "revStream write Exception", "");
        break;
        str1 = "respose null";
        break label1778;
      }
      str1 = "respose null";
      break label462;
    }
  }
  
  public boolean a(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask)
  {
    paramDownloadTask = a(paramLong, false);
    if (paramDownloadTask == null)
    {
      QLog.e("DiscPicThumbDownloader<FileAssistant>", 2, "[downloadThumb]  ID[" + paramLong + "] onGetDownloadUrl no this session");
      return false;
    }
    if (paramDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong, paramDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, Long.parseLong(paramDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin), paramDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramLong, paramDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, paramDownloadTask.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
    }
  }
  
  public void b(long paramLong, ThumbHttpDownloader.DownloadTask paramDownloadTask) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.DiscPicThumbDownloader
 * JD-Core Version:    0.7.0.1
 */