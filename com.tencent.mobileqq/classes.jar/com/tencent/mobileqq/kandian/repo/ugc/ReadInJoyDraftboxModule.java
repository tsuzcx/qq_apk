package com.tencent.mobileqq.kandian.repo.ugc;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.msf.ReadInJoyMSFService;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyEngineModule;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.ParcelableUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class ReadInJoyDraftboxModule
  extends ReadInJoyEngineModule
{
  private static String a = "ReadInJoyDraftboxModule";
  
  public ReadInJoyDraftboxModule(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, ReadInJoyMSFService paramReadInJoyMSFService, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramReadInJoyMSFService, paramHandler);
  }
  
  private List<ReadInJoyDraftboxItem> a()
  {
    List localList = this.mEntityManager.query(ReadInJoyDraftboxItem.class);
    if ((localList != null) && (localList.size() > 0))
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        ReadInJoyDraftboxItem localReadInJoyDraftboxItem = (ReadInJoyDraftboxItem)localIterator.next();
        localReadInJoyDraftboxItem.firstPicData = ((ReadInJoyDraftboxItem.PicData)ParcelableUtil.a(localReadInJoyDraftboxItem.firstPic, ReadInJoyDraftboxItem.PicData.CREATOR));
      }
    }
    return localList;
  }
  
  public long a(long paramLong, ReadInJoyDraftboxItem.ReadInJoyDraftboxContent paramReadInJoyDraftboxContent)
  {
    long l = -1L;
    if (paramReadInJoyDraftboxContent == null) {
      return -1L;
    }
    Object localObject = new ReadInJoyDraftboxItem();
    ((ReadInJoyDraftboxItem)localObject).type = paramReadInJoyDraftboxContent.articleType;
    ((ReadInJoyDraftboxItem)localObject).setId(paramLong);
    int i;
    if (paramLong == -1L) {
      i = 1000;
    } else {
      i = 1001;
    }
    ((ReadInJoyDraftboxItem)localObject).setStatus(i);
    String str = paramReadInJoyDraftboxContent.commentString;
    paramLong = System.currentTimeMillis() / 1000L;
    ((ReadInJoyDraftboxItem)localObject).time = paramLong;
    ((ReadInJoyDraftboxItem)localObject).digest = str;
    ((ReadInJoyDraftboxItem)localObject).title = paramReadInJoyDraftboxContent.answerTitle;
    if (TextUtils.isEmpty(((ReadInJoyDraftboxItem)localObject).title)) {
      if ((str != null) && (str.length() == 0) && (paramReadInJoyDraftboxContent != null) && (paramReadInJoyDraftboxContent.adapterList != null) && (paramReadInJoyDraftboxContent.adapterList.size() > 0) && (((ReadInJoyDraftboxItem.PicData)paramReadInJoyDraftboxContent.adapterList.get(0)).a != -1) && (paramReadInJoyDraftboxContent.articleType != 3)) {
        ((ReadInJoyDraftboxItem)localObject).title = HardCodeUtil.a(2131712695);
      } else {
        ((ReadInJoyDraftboxItem)localObject).title = "";
      }
    }
    ((ReadInJoyDraftboxItem)localObject).content = ParcelableUtil.a(paramReadInJoyDraftboxContent);
    ((ReadInJoyDraftboxItem)localObject).firstPic = null;
    paramReadInJoyDraftboxContent = paramReadInJoyDraftboxContent.adapterList;
    if ((paramReadInJoyDraftboxContent != null) && (paramReadInJoyDraftboxContent.size() > 0)) {
      ((ReadInJoyDraftboxItem)localObject).firstPic = ParcelableUtil.a((ReadInJoyDraftboxItem.PicData)paramReadInJoyDraftboxContent.get(0));
    }
    if (updateEntity((Entity)localObject))
    {
      paramReadInJoyDraftboxContent = this.mEntityManager;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("");
      localObject = (ReadInJoyDraftboxItem)paramReadInJoyDraftboxContent.find(ReadInJoyDraftboxItem.class, "time = ?", new String[] { ((StringBuilder)localObject).toString() });
      if (QLog.isColorLevel())
      {
        str = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveDraftBox: ");
        if (localObject != null)
        {
          paramReadInJoyDraftboxContent = new StringBuilder();
          paramReadInJoyDraftboxContent.append("success ");
          paramReadInJoyDraftboxContent.append(localObject);
          paramReadInJoyDraftboxContent = paramReadInJoyDraftboxContent.toString();
        }
        else
        {
          paramReadInJoyDraftboxContent = "failed: -1";
        }
        localStringBuilder.append(paramReadInJoyDraftboxContent);
        QLog.d(str, 2, localStringBuilder.toString());
      }
      paramLong = l;
      if (localObject != null) {
        paramLong = ((ReadInJoyDraftboxItem)localObject).getId();
      }
      return paramLong;
    }
    if (QLog.isColorLevel()) {
      QLog.d(a, 2, "saveDraftBox: failed: -1");
    }
    return -1L;
  }
  
  public ReadInJoyDraftboxItem.ReadInJoyDraftboxContent a(long paramLong)
  {
    Object localObject = a(paramLong);
    if ((localObject != null) && (((ReadInJoyDraftboxItem)localObject).content != null) && (((ReadInJoyDraftboxItem)localObject).content.length > 0))
    {
      ReadInJoyDraftboxItem.ReadInJoyDraftboxContent localReadInJoyDraftboxContent = (ReadInJoyDraftboxItem.ReadInJoyDraftboxContent)ParcelableUtil.a(((ReadInJoyDraftboxItem)localObject).content, ReadInJoyDraftboxItem.ReadInJoyDraftboxContent.CREATOR);
      localObject = localReadInJoyDraftboxContent;
      if (QLog.isColorLevel())
      {
        localObject = a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getReadInJoyContentById: ");
        localStringBuilder.append(paramLong);
        localStringBuilder.append(" ");
        localStringBuilder.append(localReadInJoyDraftboxContent.toString());
        QLog.d((String)localObject, 2, localStringBuilder.toString());
        return localReadInJoyDraftboxContent;
      }
    }
    else
    {
      localObject = null;
    }
    return localObject;
  }
  
  public ReadInJoyDraftboxItem a(long paramLong)
  {
    ReadInJoyDraftboxItem localReadInJoyDraftboxItem = (ReadInJoyDraftboxItem)this.mEntityManager.find(ReadInJoyDraftboxItem.class, paramLong);
    if (QLog.isColorLevel())
    {
      String str2 = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadDraftboxFromDbById: ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" ");
      String str1;
      if (localReadInJoyDraftboxItem != null) {
        str1 = localReadInJoyDraftboxItem.toString();
      } else {
        str1 = "null";
      }
      localStringBuilder.append(str1);
      QLog.d(str2, 2, localStringBuilder.toString());
    }
    if ((localReadInJoyDraftboxItem != null) && (localReadInJoyDraftboxItem.firstPic != null)) {
      localReadInJoyDraftboxItem.firstPicData = ((ReadInJoyDraftboxItem.PicData)ParcelableUtil.a(localReadInJoyDraftboxItem.firstPic, ReadInJoyDraftboxItem.PicData.CREATOR));
    }
    return localReadInJoyDraftboxItem;
  }
  
  public void a(ReadInJoyDraftboxModule.LoadDraftCallback paramLoadDraftCallback)
  {
    List localList = a();
    if (QLog.isColorLevel())
    {
      QLog.d(a, 2, "loadAllDraftsFromDb:\n");
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          ReadInJoyDraftboxItem localReadInJoyDraftboxItem = (ReadInJoyDraftboxItem)localIterator.next();
          QLog.d(a, 2, new Object[] { localReadInJoyDraftboxItem });
        }
      }
      QLog.d(a, 2, "loadAllDraftsFromDb: empty\n");
    }
    paramLoadDraftCallback.a(localList);
  }
  
  public boolean a()
  {
    boolean bool = this.mEntityManager.drop(ReadInJoyDraftboxItem.class);
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteAllDraftsFromDb: ");
      localStringBuilder.append(bool);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  public boolean a(long paramLong)
  {
    Object localObject = a(paramLong);
    localObject = Boolean.valueOf(this.mEntityManager.remove((Entity)localObject));
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deleteDraftboxFromDb: ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" : ");
      localStringBuilder.append(localObject);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void unInitialize() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.ugc.ReadInJoyDraftboxModule
 * JD-Core Version:    0.7.0.1
 */