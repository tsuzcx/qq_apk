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
    if (QLog.isColorLevel()) {
      QLog.i("PLUploadManager", 2, "init this:" + this + " app:" + paramQQAppInterface + " handler:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    }
  }
  
  private PLUploadManager.UploadItem a(CompressInfo paramCompressInfo, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    long l = System.currentTimeMillis() / 1000L;
    l = paramInt3 | l << 4;
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mIsUp = true;
    localTransferRequest.mLocalPath = paramCompressInfo.c;
    localTransferRequest.mUniseq = l;
    localTransferRequest.mFileType = 56;
    Object localObject = new ByteBuffer();
    int i = 56;
    while (i >= 0)
    {
      ((ByteBuffer)localObject).a((byte)(int)(paramLong >>> i & 0xFF));
      i -= 8;
    }
    ((ByteBuffer)localObject).a(paramInt2);
    ((ByteBuffer)localObject).a(paramInt3);
    ((ByteBuffer)localObject).a(0);
    ((ByteBuffer)localObject).a(0);
    ((ByteBuffer)localObject).a(paramInt1);
    localTransferRequest.mExtentionInfo = ((ByteBuffer)localObject).a();
    ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
    localObject = new PersonalityLabelPhoto();
    ((PersonalityLabelPhoto)localObject).localThumbPath = paramCompressInfo.e;
    ((PersonalityLabelPhoto)localObject).uniseq = l;
    ((PersonalityLabelPhoto)localObject).local = true;
    PLUploadManager.UploadItem localUploadItem = new PLUploadManager.UploadItem(this);
    localUploadItem.jdField_a_of_type_Long = paramLong;
    localUploadItem.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = localTransferRequest;
    localUploadItem.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto = ((PersonalityLabelPhoto)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("PLUploadManager", 2, "personality_label uploadPhoto() makeRequst, img_path = " + paramCompressInfo.c + " uniseq:" + l);
    }
    return localUploadItem;
  }
  
  public int a(long paramLong, PersonalityLabelInfo paramPersonalityLabelInfo, boolean paramBoolean)
  {
    int k = 0;
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
    int j = 0;
    int i = k;
    while (i < this.jdField_a_of_type_JavaUtilVector.size())
    {
      PLUploadManager.UploadItem localUploadItem = (PLUploadManager.UploadItem)this.jdField_a_of_type_JavaUtilVector.get(i);
      if (localUploadItem.jdField_a_of_type_Long != paramLong)
      {
        i += 1;
      }
      else
      {
        k = localUploadItem.jdField_a_of_type_Int;
        if (k < localList.size()) {
          localList.add(k, localUploadItem.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto);
        }
        for (;;)
        {
          paramPersonalityLabelInfo.photoCount += 1;
          j += 1;
          break;
          localList.add(localUploadItem.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto);
        }
      }
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
    if (i < this.jdField_a_of_type_JavaUtilVector.size()) {
      if ((((PLUploadManager.UploadItem)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_Long != paramLong) || (((PLUploadManager.UploadItem)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq != paramPersonalityLabelPhoto.uniseq)) {}
    }
    for (paramPersonalityLabelPhoto = (PLUploadManager.UploadItem)this.jdField_a_of_type_JavaUtilVector.get(i);; paramPersonalityLabelPhoto = null)
    {
      if (paramPersonalityLabelPhoto != null)
      {
        ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).transferAsync(paramPersonalityLabelPhoto.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
        if (QLog.isColorLevel()) {
          QLog.i("PLUploadManager", 2, "retry " + paramPersonalityLabelPhoto.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mLocalPath);
        }
      }
      return;
      i += 1;
      break;
    }
  }
  
  public void a(PLUploadManager.UploadListener paramUploadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPLUploadManager$UploadListener = paramUploadListener;
  }
  
  public boolean a(List<CompressInfo> paramList, long paramLong)
  {
    boolean bool = false;
    ArrayList localArrayList = new ArrayList();
    int k = (int)(System.currentTimeMillis() / 1000L);
    int j = 0;
    int i = 0;
    if (j < paramList.size())
    {
      PLUploadManager.UploadItem localUploadItem = a((CompressInfo)paramList.get(j), paramLong, k, paramList.size(), j);
      if (localUploadItem == null) {
        break label245;
      }
      i += 1;
      this.jdField_a_of_type_JavaUtilVector.add(0, localUploadItem);
      localArrayList.add(0, localUploadItem.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto);
    }
    label245:
    for (;;)
    {
      j += 1;
      break;
      if (i > 0)
      {
        j = 0;
        if (j < this.jdField_a_of_type_JavaUtilVector.size())
        {
          if (j < i) {
            ((PLUploadManager.UploadItem)this.jdField_a_of_type_JavaUtilVector.get(j)).jdField_a_of_type_Int = j;
          }
          for (;;)
          {
            j += 1;
            break;
            if (((PLUploadManager.UploadItem)this.jdField_a_of_type_JavaUtilVector.get(j)).jdField_a_of_type_Long == paramLong)
            {
              paramList = (PLUploadManager.UploadItem)this.jdField_a_of_type_JavaUtilVector.get(j);
              paramList.jdField_a_of_type_Int += i;
            }
          }
        }
        this.jdField_a_of_type_MqqOsMqqHandler.post(new PLUploadManager.1(this, localArrayList, paramLong));
      }
      if (localArrayList.size() > 0) {
        bool = true;
      }
      return bool;
    }
  }
  
  public void b(long paramLong, PersonalityLabelPhoto paramPersonalityLabelPhoto)
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilVector.size()) {
      if ((((PLUploadManager.UploadItem)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_Long != paramLong) || (((PLUploadManager.UploadItem)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelPhoto.uniseq != paramPersonalityLabelPhoto.uniseq)) {}
    }
    for (paramPersonalityLabelPhoto = (PLUploadManager.UploadItem)this.jdField_a_of_type_JavaUtilVector.remove(i);; paramPersonalityLabelPhoto = null)
    {
      if (i >= 0) {
        for (;;)
        {
          if (i < this.jdField_a_of_type_JavaUtilVector.size())
          {
            if (((PLUploadManager.UploadItem)this.jdField_a_of_type_JavaUtilVector.get(i)).jdField_a_of_type_Long == paramLong)
            {
              PLUploadManager.UploadItem localUploadItem = (PLUploadManager.UploadItem)this.jdField_a_of_type_JavaUtilVector.get(i);
              localUploadItem.jdField_a_of_type_Int -= 1;
            }
            i += 1;
            continue;
            i += 1;
            break;
          }
        }
      }
      if (paramPersonalityLabelPhoto != null)
      {
        ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).stop(paramPersonalityLabelPhoto.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest);
        if (QLog.isColorLevel()) {
          QLog.i("PLUploadManager", 2, "delete " + paramPersonalityLabelPhoto.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.mLocalPath);
        }
      }
      return;
      i = -1;
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    ((ITransFileController)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).removeHandle(this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    if (QLog.isColorLevel()) {
      QLog.i("PLUploadManager", 2, "onDestroy this:" + this + " app:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface + " handler:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransProcessorHandler);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PLUploadManager
 * JD-Core Version:    0.7.0.1
 */