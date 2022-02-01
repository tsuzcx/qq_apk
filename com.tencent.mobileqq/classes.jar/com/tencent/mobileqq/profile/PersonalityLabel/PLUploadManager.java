package com.tencent.mobileqq.profile.PersonalityLabel;

import android.os.Looper;
import com.tencent.av.config.ByteBuffer;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class PLUploadManager
  implements Manager
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  PLUploadManager.UploadListener jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager$UploadListener;
  private TransProcessorHandler jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler = new PLTransProcessorHandler(this, Looper.getMainLooper());
  Vector<PLUploadManager.UploadItem> jdField_a_of_type_JavaUtilVector = new Vector();
  MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  
  public PLUploadManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler.addFilter(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).addHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    this.jdField_a_of_type_MqqOsMqqHandler = new MqqHandler(Looper.getMainLooper());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init this:");
      localStringBuilder.append(this);
      localStringBuilder.append(" app:");
      localStringBuilder.append(paramQQAppInterface);
      localStringBuilder.append(" handler:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      QLog.i("PLUploadManager", 2, localStringBuilder.toString());
    }
  }
  
  private PLUploadManager.UploadItem a(CompressInfo paramCompressInfo, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    long l = System.currentTimeMillis() / 1000L << 4 | paramInt3;
    Object localObject1 = new TransferRequest();
    ((TransferRequest)localObject1).mIsUp = true;
    ((TransferRequest)localObject1).mLocalPath = paramCompressInfo.c;
    ((TransferRequest)localObject1).mUniseq = l;
    int i = 56;
    ((TransferRequest)localObject1).mFileType = 56;
    Object localObject2 = new ByteBuffer();
    while (i >= 0)
    {
      ((ByteBuffer)localObject2).a((byte)(int)(paramLong >>> i & 0xFF));
      i -= 8;
    }
    ((ByteBuffer)localObject2).a(paramInt2);
    ((ByteBuffer)localObject2).a(paramInt3);
    ((ByteBuffer)localObject2).a(0);
    ((ByteBuffer)localObject2).a(0);
    ((ByteBuffer)localObject2).a(paramInt1);
    ((TransferRequest)localObject1).mExtentionInfo = ((ByteBuffer)localObject2).a();
    ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync((TransferRequest)localObject1);
    PersonalityLabelPhoto localPersonalityLabelPhoto = new PersonalityLabelPhoto();
    localPersonalityLabelPhoto.localThumbPath = paramCompressInfo.e;
    localPersonalityLabelPhoto.uniseq = l;
    localPersonalityLabelPhoto.local = true;
    localObject2 = new PLUploadManager.UploadItem(this);
    ((PLUploadManager.UploadItem)localObject2).jdField_a_of_type_Long = paramLong;
    ((PLUploadManager.UploadItem)localObject2).jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = ((TransferRequest)localObject1);
    ((PLUploadManager.UploadItem)localObject2).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto = localPersonalityLabelPhoto;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("personality_label uploadPhoto() makeRequst, img_path = ");
      ((StringBuilder)localObject1).append(paramCompressInfo.c);
      ((StringBuilder)localObject1).append(" uniseq:");
      ((StringBuilder)localObject1).append(l);
      QLog.i("PLUploadManager", 2, ((StringBuilder)localObject1).toString());
    }
    return localObject2;
  }
  
  public int a(long paramLong, PersonalityLabelInfo paramPersonalityLabelInfo, boolean paramBoolean)
  {
    List localList = paramPersonalityLabelInfo.personalityLabelPhotos;
    if ((!paramBoolean) && (localList.size() > 0))
    {
      i = localList.size() - 1;
      while (i >= 0)
      {
        if (((PersonalityLabelPhoto)localList.get(i)).fileId == -1L)
        {
          localList.remove(i);
          paramPersonalityLabelInfo.photoCount -= 1;
        }
        i -= 1;
      }
    }
    int i = 0;
    int j = 0;
    while (i < this.jdField_a_of_type_JavaUtilVector.size())
    {
      PLUploadManager.UploadItem localUploadItem = (PLUploadManager.UploadItem)this.jdField_a_of_type_JavaUtilVector.get(i);
      if (localUploadItem.jdField_a_of_type_Long == paramLong)
      {
        int k = localUploadItem.jdField_a_of_type_Int;
        if (k < localList.size()) {
          localList.add(k, localUploadItem.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto);
        } else {
          localList.add(localUploadItem.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto);
        }
        paramPersonalityLabelInfo.photoCount += 1;
        j += 1;
      }
      i += 1;
    }
    return j;
  }
  
  public PLUploadManager.UploadItem a(long paramLong, PersonalityLabelPhoto paramPersonalityLabelPhoto)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilVector.size())
    {
      if ((((PLUploadManager.UploadItem)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_Long == paramLong) && (((PLUploadManager.UploadItem)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq == paramPersonalityLabelPhoto.uniseq)) {
        return (PLUploadManager.UploadItem)this.jdField_a_of_type_JavaUtilVector.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public void a(long paramLong, PersonalityLabelPhoto paramPersonalityLabelPhoto)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilVector.size())
    {
      if ((((PLUploadManager.UploadItem)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_Long == paramLong) && (((PLUploadManager.UploadItem)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq == paramPersonalityLabelPhoto.uniseq))
      {
        paramPersonalityLabelPhoto = (PLUploadManager.UploadItem)this.jdField_a_of_type_JavaUtilVector.get(i);
        break label88;
      }
      i += 1;
    }
    paramPersonalityLabelPhoto = null;
    label88:
    if (paramPersonalityLabelPhoto != null)
    {
      ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(paramPersonalityLabelPhoto.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("retry ");
        localStringBuilder.append(paramPersonalityLabelPhoto.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mLocalPath);
        QLog.i("PLUploadManager", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(PLUploadManager.UploadListener paramUploadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager$UploadListener = paramUploadListener;
  }
  
  public boolean a(List<CompressInfo> paramList, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    int m = (int)(System.currentTimeMillis() / 1000L);
    boolean bool = false;
    int j = 0;
    int k;
    for (int i = 0; j < paramList.size(); i = k)
    {
      PLUploadManager.UploadItem localUploadItem = a((CompressInfo)paramList.get(j), paramLong, m, paramList.size(), j);
      k = i;
      if (localUploadItem != null)
      {
        k = i + 1;
        this.jdField_a_of_type_JavaUtilVector.add(0, localUploadItem);
        localArrayList.add(0, localUploadItem.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto);
      }
      j += 1;
    }
    if (i > 0)
    {
      j = 0;
      while (j < this.jdField_a_of_type_JavaUtilVector.size())
      {
        if (j < i)
        {
          ((PLUploadManager.UploadItem)this.jdField_a_of_type_JavaUtilVector.get(j)).jdField_a_of_type_Int = j;
        }
        else if (((PLUploadManager.UploadItem)this.jdField_a_of_type_JavaUtilVector.get(j)).jdField_a_of_type_Long == paramLong)
        {
          paramList = (PLUploadManager.UploadItem)this.jdField_a_of_type_JavaUtilVector.get(j);
          paramList.jdField_a_of_type_Int += i;
        }
        j += 1;
      }
      this.jdField_a_of_type_MqqOsMqqHandler.post(new PLUploadManager.1(this, localArrayList, paramLong));
    }
    if (localArrayList.size() > 0) {
      bool = true;
    }
    return bool;
  }
  
  public void b(long paramLong, PersonalityLabelPhoto paramPersonalityLabelPhoto)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilVector.size())
    {
      if ((((PLUploadManager.UploadItem)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_Long == paramLong) && (((PLUploadManager.UploadItem)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq == paramPersonalityLabelPhoto.uniseq))
      {
        paramPersonalityLabelPhoto = (PLUploadManager.UploadItem)this.jdField_a_of_type_JavaUtilVector.remove(i);
        break label91;
      }
      i += 1;
    }
    paramPersonalityLabelPhoto = null;
    i = -1;
    label91:
    Object localObject;
    if (i >= 0) {
      while (i < this.jdField_a_of_type_JavaUtilVector.size())
      {
        if (((PLUploadManager.UploadItem)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_Long == paramLong)
        {
          localObject = (PLUploadManager.UploadItem)this.jdField_a_of_type_JavaUtilVector.get(i);
          ((PLUploadManager.UploadItem)localObject).jdField_a_of_type_Int -= 1;
        }
        i += 1;
      }
    }
    if (paramPersonalityLabelPhoto != null)
    {
      ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).stop(paramPersonalityLabelPhoto.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("delete ");
        ((StringBuilder)localObject).append(paramPersonalityLabelPhoto.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mLocalPath);
        QLog.i("PLUploadManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy this:");
      localStringBuilder.append(this);
      localStringBuilder.append(" app:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      localStringBuilder.append(" handler:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
      QLog.i("PLUploadManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PLUploadManager
 * JD-Core Version:    0.7.0.1
 */