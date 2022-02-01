package com.tencent.mobileqq.pic.operator.multipic;

import android.os.AsyncTask;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicDownloadInfo.Builder;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.operator.BaseForwardPicOperator;
import com.tencent.mobileqq.pic.operator.IPicInfoBuilder.MixedPicMsgInfoBuilder;
import com.tencent.mobileqq.pic.operator.IPicInfoBuilder.MultiPicsInfoBuilder;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.TranDbRecord.PicDbRecord;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakUtils;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiPicsOperator
  extends BaseForwardPicOperator
  implements IPicInfoBuilder.MixedPicMsgInfoBuilder, IPicInfoBuilder.MultiPicsInfoBuilder
{
  protected static int b;
  protected int a;
  public ArrayList<PicResult> a;
  protected ArrayList<PicFowardInfo> b;
  
  static
  {
    jdField_b_of_type_Int = 20;
  }
  
  public PicFowardInfo a(MessageForPic paramMessageForPic, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramMessageForPic == null) || (paramInt < 0) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return null;
    }
    long l = System.currentTimeMillis();
    int i;
    if ((ActionMsgUtil.a(paramMessageForPic.msgtype)) || (paramMessageForPic.msgtype == -3001) || (paramMessageForPic.msgtype == -30002) || (paramMessageForPic.msgtype == -30003)) {
      i = 1;
    }
    for (;;)
    {
      Object localObject2;
      if (i == 0)
      {
        i = 65537;
        localObject2 = URLDrawableHelper.getURL(paramMessageForPic, i);
        Object localObject1 = null;
        if (localObject2 != null) {
          localObject1 = ((URL)localObject2).toString();
        }
        localObject2 = new PicFowardInfo();
        ((PicFowardInfo)localObject2).b = paramMessageForPic.isSendFromLocal();
        PicUploadInfo.Builder localBuilder = new PicUploadInfo.Builder();
        localBuilder.d(1009);
        localBuilder.a(paramMessageForPic.path);
        localBuilder.c(paramString3);
        localBuilder.c(TranDbRecord.PicDbRecord.EXTRA_FLAG_FOWARD_PHOTO);
        localBuilder.g((int)paramMessageForPic.width);
        localBuilder.h((int)paramMessageForPic.height);
        Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "picMsg.width = " + paramMessageForPic.width + ",picMsg.height = " + paramMessageForPic.height);
        localBuilder.a((int)paramMessageForPic.size);
        localBuilder.i(paramMessageForPic.fileSizeFlag);
        localBuilder.a(paramMessageForPic.thumbWidth);
        localBuilder.b(paramMessageForPic.thumbHeight);
        localBuilder.j(paramMessageForPic.imageType);
        localObject1 = AbsDownloader.getFile((String)localObject1);
        if (localObject1 != null) {
          localBuilder.b(((File)localObject1).getAbsolutePath());
        }
        localBuilder.e(paramInt);
        localBuilder.e(paramString1);
        localBuilder.d(paramString2);
        localBuilder.f(paramMessageForPic.md5);
        ((PicFowardInfo)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo = localBuilder.a();
        ((PicFowardInfo)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_JavaLangString = paramMessageForPic.localUUID;
        ((PicFowardInfo)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_e_of_type_JavaLangString = "chatimg";
        paramString1 = ((PicFowardInfo)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo;
        if ((paramString1.h < 0) && (PeakUtils.a(paramMessageForPic.path))) {
          LogTag.a();
        }
      }
      try
      {
        paramString1.jdField_a_of_type_JavaUtilArrayList = PeakUtils.a(paramMessageForPic.path);
        LogTag.a("peak_pgjpeg", "PeakUtils.getSliceInfos(" + paramMessageForPic.path + ")");
        if ((paramMessageForPic.isMultiMsg) || (!FileUtils.b(paramMessageForPic.path)))
        {
          paramString1 = new PicDownloadInfo.Builder();
          paramString1.a(1009);
          paramString1.a(paramString3);
          paramString1.b(paramMessageForPic.frienduin);
          paramString1.b(paramMessageForPic.istroop);
          paramString1.c(paramMessageForPic.uuid);
          paramString1.a(paramMessageForPic.uniseq);
          paramString1.d(paramMessageForPic.md5);
          paramString1.c(paramMessageForPic.issend);
          paramString1.b(paramMessageForPic.time);
          ((PicFowardInfo)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo = paramString1.a();
          ((PicFowardInfo)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_e_of_type_JavaLangString = "chatimg";
          ((PicFowardInfo)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_e_of_type_Int = paramMessageForPic.fileSizeFlag;
          ((PicFowardInfo)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.b = paramMessageForPic.groupFileID;
        }
        Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "createForwardPicInfo", "cost:" + (System.currentTimeMillis() - l));
        paramMessageForPic = this.jdField_b_of_type_JavaLangString;
        paramString1 = this.jdField_a_of_type_JavaLangString;
        paramString2 = new StringBuilder().append("retry:");
        if (((PicFowardInfo)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo != null)
        {
          bool = true;
          Logger.a(paramMessageForPic, paramString1, "createForwardPicInfo", bool);
          return localObject2;
          i = 0;
          continue;
          i = 1;
        }
      }
      catch (OutOfMemoryError paramString1)
      {
        for (;;)
        {
          boolean bool;
          if (QLog.isColorLevel())
          {
            QLog.w("peak_pgjpeg", 2, "OutOfMemoryError occurred in PeakUtils.getSliceInfos， " + paramMessageForPic.path + "'s size is " + FileUtils.a(paramMessageForPic.path));
            continue;
            bool = false;
          }
        }
      }
    }
  }
  
  public ArrayList<PicFowardInfo> a(MessageForMixedMsg paramMessageForMixedMsg, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramMessageForMixedMsg == null) || (paramInt < 0) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null) || (paramMessageForMixedMsg.msgElemList == null)) {
      return null;
    }
    long l = System.currentTimeMillis();
    ArrayList localArrayList = new ArrayList();
    paramMessageForMixedMsg = paramMessageForMixedMsg.msgElemList.iterator();
    while (paramMessageForMixedMsg.hasNext())
    {
      MessageRecord localMessageRecord = (MessageRecord)paramMessageForMixedMsg.next();
      if ((localMessageRecord instanceof MessageForPic)) {
        localArrayList.add(a((MessageForPic)localMessageRecord, paramInt, paramString1, paramString2, paramString3));
      }
    }
    Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "createForwardPicInfos", "cost:" + (System.currentTimeMillis() - l));
    return localArrayList;
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a(ArrayList<PicFowardInfo> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] error, infoList is null");
      }
      a(5, -1, null);
      return;
    }
    ((PicFowardInfo)paramArrayList.get(0)).jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a((PicFowardInfo)paramArrayList.get(0));
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList.size());
    this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Int = 0;
    System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] start");
    }
    b();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int >= this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, String.format("createPicsUploadTask total:%d finished and notifyUI", new Object[] { Integer.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()) }));
      }
      a(5, 0, this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    if (this.jdField_a_of_type_Int + jdField_b_of_type_Int < this.jdField_b_of_type_JavaUtilArrayList.size()) {}
    for (int i = this.jdField_a_of_type_Int + jdField_b_of_type_Int;; i = this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiMsg_TAG", 2, String.format("createPicsUploadTask startIdx:%d, finishIdx:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(i) }));
      }
      List localList = this.jdField_b_of_type_JavaUtilArrayList.subList(this.jdField_a_of_type_Int, i);
      this.jdField_a_of_type_Int = i;
      new MultiPicsOperator.MultiPicsUploadTask(this, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localList).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.multipic.MultiPicsOperator
 * JD-Core Version:    0.7.0.1
 */