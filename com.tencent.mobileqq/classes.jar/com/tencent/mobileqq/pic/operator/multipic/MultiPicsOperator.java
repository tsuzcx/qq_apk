package com.tencent.mobileqq.pic.operator.multipic;

import android.os.AsyncTask;
import com.tencent.mobileqq.PicBusUtil;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.mixedmsg.api.IMsgMixed;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.PicDownloadInfo.Builder;
import com.tencent.mobileqq.pic.PicFowardInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicResult;
import com.tencent.mobileqq.pic.PicUploadInfo;
import com.tencent.mobileqq.pic.PicUploadInfo.Builder;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.operator.BaseForwardPicOperator;
import com.tencent.mobileqq.pic.operator.IPicInfoBuilder.MixedPicMsgInfoBuilder;
import com.tencent.mobileqq.pic.operator.IPicInfoBuilder.MultiPicsInfoBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.ActionMsgUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MultiPicsOperator
  extends BaseForwardPicOperator
  implements IPicInfoBuilder.MixedPicMsgInfoBuilder, IPicInfoBuilder.MultiPicsInfoBuilder
{
  protected static int b = 20;
  protected int a;
  public ArrayList<PicResult> a;
  protected ArrayList<PicFowardInfo> b;
  
  public PicFowardInfo a(MessageForPic paramMessageForPic, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    Object localObject1 = null;
    long l;
    Object localObject2;
    if ((paramMessageForPic != null) && (paramInt >= 0) && (paramString1 != null) && (paramString2 != null))
    {
      if (paramString3 == null) {
        return null;
      }
      l = System.currentTimeMillis();
      int i;
      if ((!ActionMsgUtil.a(paramMessageForPic.msgtype)) && (paramMessageForPic.msgtype != -3001) && (paramMessageForPic.msgtype != -30002) && (paramMessageForPic.msgtype != -30003)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0) {
        i = 65537;
      } else {
        i = 1;
      }
      localObject2 = ((IPicHelper)QRoute.api(IPicHelper.class)).getURL(paramMessageForPic, i, null);
      if (localObject2 != null) {
        localObject1 = ((URL)localObject2).toString();
      }
      localObject2 = new PicFowardInfo();
      ((PicFowardInfo)localObject2).b = paramMessageForPic.isSendFromLocal();
      PicUploadInfo.Builder localBuilder = new PicUploadInfo.Builder();
      localBuilder.d(1009);
      localBuilder.a(paramMessageForPic.path);
      localBuilder.c(paramString3);
      localBuilder.c(10);
      localBuilder.g((int)paramMessageForPic.width);
      localBuilder.h((int)paramMessageForPic.height);
      String str1 = this.jdField_b_of_type_JavaLangString;
      String str2 = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("picMsg.width = ");
      localStringBuilder.append(paramMessageForPic.width);
      localStringBuilder.append(",picMsg.height = ");
      localStringBuilder.append(paramMessageForPic.height);
      Logger.a(str1, str2, "createForwardPicInfo", localStringBuilder.toString());
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
      if ((paramString1.h < 0) && (PicBusUtil.a(paramMessageForPic.path))) {
        LogTag.a();
      }
    }
    try
    {
      paramString1.jdField_a_of_type_JavaUtilArrayList = PicBusUtil.a(paramMessageForPic.path);
    }
    catch (OutOfMemoryError paramString1)
    {
      label448:
      boolean bool;
      break label448;
    }
    if (QLog.isColorLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("OutOfMemoryError occurred in PeakUtils.getSliceInfos， ");
      paramString1.append(paramMessageForPic.path);
      paramString1.append("'s size is ");
      paramString1.append(FileUtils.getFileSizes(paramMessageForPic.path));
      QLog.w("peak_pgjpeg", 2, paramString1.toString());
    }
    paramString1 = new StringBuilder();
    paramString1.append("PeakUtils.getSliceInfos(");
    paramString1.append(paramMessageForPic.path);
    paramString1.append(")");
    LogTag.a("peak_pgjpeg", paramString1.toString());
    if ((paramMessageForPic.isMultiMsg) || (!FileUtils.fileExistsAndNotEmpty(paramMessageForPic.path)))
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
    paramMessageForPic = this.jdField_b_of_type_JavaLangString;
    paramString1 = this.jdField_a_of_type_JavaLangString;
    paramString2 = new StringBuilder();
    paramString2.append("cost:");
    paramString2.append(System.currentTimeMillis() - l);
    Logger.a(paramMessageForPic, paramString1, "createForwardPicInfo", paramString2.toString());
    paramMessageForPic = this.jdField_b_of_type_JavaLangString;
    paramString1 = this.jdField_a_of_type_JavaLangString;
    paramString2 = new StringBuilder();
    paramString2.append("retry:");
    if (((PicFowardInfo)localObject2).jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo$RetryInfo != null) {
      bool = true;
    } else {
      bool = false;
    }
    paramString2.append(bool);
    Logger.a(paramMessageForPic, paramString1, "createForwardPicInfo", paramString2.toString());
    return localObject2;
    return null;
  }
  
  public ArrayList<PicFowardInfo> a(MessageRecord paramMessageRecord, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if ((paramMessageRecord != null) && (paramInt >= 0) && (paramString1 != null) && (paramString2 != null))
    {
      if (paramString3 == null) {
        return null;
      }
      Object localObject = ((IMsgMixed)QRoute.api(IMsgMixed.class)).getElementList(paramMessageRecord);
      if (localObject == null) {
        return null;
      }
      long l = System.currentTimeMillis();
      paramMessageRecord = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((localMessageRecord instanceof MessageForPic)) {
          paramMessageRecord.add(a((MessageForPic)localMessageRecord, paramInt, paramString1, paramString2, paramString3));
        }
      }
      paramString1 = this.jdField_b_of_type_JavaLangString;
      paramString2 = this.jdField_a_of_type_JavaLangString;
      paramString3 = new StringBuilder();
      paramString3.append("cost:");
      paramString3.append(System.currentTimeMillis() - l);
      Logger.a(paramString1, paramString2, "createForwardPicInfos", paramString3.toString());
      return paramMessageRecord;
    }
    return null;
  }
  
  public void a()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_JavaUtilArrayList);
  }
  
  public void a(ArrayList<PicFowardInfo> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      ((PicFowardInfo)paramArrayList.get(0)).jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a((PicFowardInfo)paramArrayList.get(0));
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramArrayList.size());
      this.jdField_b_of_type_JavaUtilArrayList = paramArrayList;
      this.jdField_a_of_type_Int = 0;
      System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("MultiPicsOperator", 2, "[uploadForwardMultiMsgPics] start");
      }
      b();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("MultiPicsOperator", 2, "[uploadForwardMultiMsgPics] error, infoList is null");
    }
    a(5, -1, null);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int >= this.jdField_b_of_type_JavaUtilArrayList.size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("MultiPicsOperator", 2, String.format("createPicsUploadTask total:%d finished and notifyUI", new Object[] { Integer.valueOf(this.jdField_b_of_type_JavaUtilArrayList.size()) }));
      }
      a(5, 0, this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    int i;
    if (this.jdField_a_of_type_Int + jdField_b_of_type_Int < this.jdField_b_of_type_JavaUtilArrayList.size()) {
      i = this.jdField_a_of_type_Int + jdField_b_of_type_Int;
    } else {
      i = this.jdField_b_of_type_JavaUtilArrayList.size();
    }
    if (QLog.isColorLevel()) {
      QLog.d("MultiPicsOperator", 2, String.format("createPicsUploadTask startIdx:%d, finishIdx:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(i) }));
    }
    List localList = this.jdField_b_of_type_JavaUtilArrayList.subList(this.jdField_a_of_type_Int, i);
    this.jdField_a_of_type_Int = i;
    new MultiPicsOperator.MultiPicsUploadTask(this, this.jdField_a_of_type_ComTencentCommonAppAppInterface, localList).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.pic.operator.multipic.MultiPicsOperator
 * JD-Core Version:    0.7.0.1
 */