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
  QQAppInterface a;
  PLUploadManager.UploadListener b;
  MqqHandler c;
  Vector<PLUploadManager.UploadItem> d = new Vector();
  private TransProcessorHandler e = new PLTransProcessorHandler(this, Looper.getMainLooper());
  
  public PLUploadManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.e.addFilter(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class)).addHandle(this.e);
    this.c = new MqqHandler(Looper.getMainLooper());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init this:");
      localStringBuilder.append(this);
      localStringBuilder.append(" app:");
      localStringBuilder.append(paramQQAppInterface);
      localStringBuilder.append(" handler:");
      localStringBuilder.append(this.e);
      QLog.i("PLUploadManager", 2, localStringBuilder.toString());
    }
  }
  
  private PLUploadManager.UploadItem a(CompressInfo paramCompressInfo, long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    long l = System.currentTimeMillis() / 1000L << 4 | paramInt3;
    Object localObject1 = new TransferRequest();
    ((TransferRequest)localObject1).mIsUp = true;
    ((TransferRequest)localObject1).mLocalPath = paramCompressInfo.h;
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
    ((ITransFileController)this.a.getRuntimeService(ITransFileController.class)).transferAsync((TransferRequest)localObject1);
    PersonalityLabelPhoto localPersonalityLabelPhoto = new PersonalityLabelPhoto();
    localPersonalityLabelPhoto.localThumbPath = paramCompressInfo.l;
    localPersonalityLabelPhoto.uniseq = l;
    localPersonalityLabelPhoto.local = true;
    localObject2 = new PLUploadManager.UploadItem(this);
    ((PLUploadManager.UploadItem)localObject2).b = paramLong;
    ((PLUploadManager.UploadItem)localObject2).d = ((TransferRequest)localObject1);
    ((PLUploadManager.UploadItem)localObject2).c = localPersonalityLabelPhoto;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("personality_label uploadPhoto() makeRequst, img_path = ");
      ((StringBuilder)localObject1).append(paramCompressInfo.h);
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
    while (i < this.d.size())
    {
      PLUploadManager.UploadItem localUploadItem = (PLUploadManager.UploadItem)this.d.get(i);
      if (localUploadItem.b == paramLong)
      {
        int k = localUploadItem.a;
        if (k < localList.size()) {
          localList.add(k, localUploadItem.c);
        } else {
          localList.add(localUploadItem.c);
        }
        paramPersonalityLabelInfo.photoCount += 1;
        j += 1;
      }
      i += 1;
    }
    return j;
  }
  
  public void a(long paramLong, PersonalityLabelPhoto paramPersonalityLabelPhoto)
  {
    int i = 0;
    while (i < this.d.size())
    {
      if ((((PLUploadManager.UploadItem)this.d.get(i)).b == paramLong) && (((PLUploadManager.UploadItem)this.d.get(i)).c.uniseq == paramPersonalityLabelPhoto.uniseq))
      {
        paramPersonalityLabelPhoto = (PLUploadManager.UploadItem)this.d.get(i);
        break label88;
      }
      i += 1;
    }
    paramPersonalityLabelPhoto = null;
    label88:
    if (paramPersonalityLabelPhoto != null)
    {
      ((ITransFileController)this.a.getRuntimeService(ITransFileController.class)).transferAsync(paramPersonalityLabelPhoto.d);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("retry ");
        localStringBuilder.append(paramPersonalityLabelPhoto.d.mLocalPath);
        QLog.i("PLUploadManager", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(PLUploadManager.UploadListener paramUploadListener)
  {
    this.b = paramUploadListener;
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
        this.d.add(0, localUploadItem);
        localArrayList.add(0, localUploadItem.c);
      }
      j += 1;
    }
    if (i > 0)
    {
      j = 0;
      while (j < this.d.size())
      {
        if (j < i)
        {
          ((PLUploadManager.UploadItem)this.d.get(j)).a = j;
        }
        else if (((PLUploadManager.UploadItem)this.d.get(j)).b == paramLong)
        {
          paramList = (PLUploadManager.UploadItem)this.d.get(j);
          paramList.a += i;
        }
        j += 1;
      }
      this.c.post(new PLUploadManager.1(this, localArrayList, paramLong));
    }
    if (localArrayList.size() > 0) {
      bool = true;
    }
    return bool;
  }
  
  public void b(long paramLong, PersonalityLabelPhoto paramPersonalityLabelPhoto)
  {
    int i = 0;
    while (i < this.d.size())
    {
      if ((((PLUploadManager.UploadItem)this.d.get(i)).b == paramLong) && (((PLUploadManager.UploadItem)this.d.get(i)).c.uniseq == paramPersonalityLabelPhoto.uniseq))
      {
        paramPersonalityLabelPhoto = (PLUploadManager.UploadItem)this.d.remove(i);
        break label91;
      }
      i += 1;
    }
    paramPersonalityLabelPhoto = null;
    i = -1;
    label91:
    Object localObject;
    if (i >= 0) {
      while (i < this.d.size())
      {
        if (((PLUploadManager.UploadItem)this.d.get(i)).b == paramLong)
        {
          localObject = (PLUploadManager.UploadItem)this.d.get(i);
          ((PLUploadManager.UploadItem)localObject).a -= 1;
        }
        i += 1;
      }
    }
    if (paramPersonalityLabelPhoto != null)
    {
      ((ITransFileController)this.a.getRuntimeService(ITransFileController.class)).stop(paramPersonalityLabelPhoto.d);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("delete ");
        ((StringBuilder)localObject).append(paramPersonalityLabelPhoto.d.mLocalPath);
        QLog.i("PLUploadManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public PLUploadManager.UploadItem c(long paramLong, PersonalityLabelPhoto paramPersonalityLabelPhoto)
  {
    int i = 0;
    while (i < this.d.size())
    {
      if ((((PLUploadManager.UploadItem)this.d.get(i)).b == paramLong) && (((PLUploadManager.UploadItem)this.d.get(i)).c.uniseq == paramPersonalityLabelPhoto.uniseq)) {
        return (PLUploadManager.UploadItem)this.d.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public void onDestroy()
  {
    this.c.removeCallbacksAndMessages(null);
    ((ITransFileController)this.a.getRuntimeService(ITransFileController.class)).removeHandle(this.e);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDestroy this:");
      localStringBuilder.append(this);
      localStringBuilder.append(" app:");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" handler:");
      localStringBuilder.append(this.e);
      QLog.i("PLUploadManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PLUploadManager
 * JD-Core Version:    0.7.0.1
 */