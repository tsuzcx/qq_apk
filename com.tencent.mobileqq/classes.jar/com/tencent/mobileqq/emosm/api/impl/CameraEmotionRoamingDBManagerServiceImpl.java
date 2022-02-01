package com.tencent.mobileqq.emosm.api.impl;

import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.app.CameraEmoImg;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingManagerBase;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoConstant;
import com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSendControl;
import com.tencent.mobileqq.emosm.control.EmoCaptureAsyncControl;
import com.tencent.mobileqq.emoticonview.CameraEmoticonInfo;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CameraEmotionRoamingDBManagerServiceImpl
  extends CustomEmotionRoamingDBManagerBase<CameraEmotionData>
  implements ICameraEmotionRoamingDBManagerService
{
  public static final String TAG = "CameraEmotionRoamingDBManager";
  private boolean hasEmoCacheFlags;
  private boolean hasReportProcessInterrupt;
  
  private void addLocalList(List<CameraEmoImg> paramList1, List<CameraEmoImg> paramList2)
  {
    int i = paramList2.size();
    int j = paramList1.size();
    int k = 0;
    boolean bool;
    if (i < j)
    {
      paramList2 = paramList2.iterator();
      while (paramList2.hasNext()) {
        paramList1.remove((CameraEmoImg)paramList2.next());
      }
      bool = true;
    }
    else
    {
      bool = false;
    }
    if (bool)
    {
      paramList2 = getEmoticonDataList();
      if (paramList2 != null) {
        for (i = 1;; i = j)
        {
          j = i;
          if (k >= paramList2.size()) {
            break;
          }
          int m = ((CameraEmotionData)paramList2.get(k)).emoId;
          j = i;
          if (i < m) {
            j = m;
          }
          k += 1;
        }
      }
      j = 1;
      paramList2 = new ArrayList();
      Iterator localIterator = paramList1.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (CameraEmoImg)localIterator.next();
        j += 1;
        localObject = createNewEmoByEmoImg((CameraEmoImg)localObject, j);
        if (localObject != null)
        {
          ((CameraEmotionData)localObject).RomaingType = "normal";
          updateCache((CustomEmotionBase)localObject, 1);
          paramList2.add(localObject);
        }
      }
      updateCustomEmotionDataListInDB(paramList2, 1);
    }
    if (QLog.isColorLevel())
    {
      paramList2 = new StringBuilder();
      paramList2.append("updateLocalDBFromServer, needAdd = ");
      paramList2.append(bool);
      paramList2.append("| remoteImgList.size = ");
      paramList2.append(paramList1.size());
      QLog.d("CameraEmotionRoamingDBManager", 2, paramList2.toString());
    }
  }
  
  private CameraEmotionData createNewEmoByEmoImg(CameraEmoImg paramCameraEmoImg, int paramInt)
  {
    if ((paramCameraEmoImg != null) && (this.app != null))
    {
      CameraEmotionData localCameraEmotionData = new CameraEmotionData();
      localCameraEmotionData.uin = this.app.getCurrentAccountUin();
      localCameraEmotionData.emoId = (paramInt + 1);
      localCameraEmotionData.resid = paramCameraEmoImg.a;
      localCameraEmotionData.strContext = paramCameraEmoImg.b;
      localCameraEmotionData.templateId = paramCameraEmoImg.e;
      if (StringUtil.a(paramCameraEmoImg.d)) {
        localCameraEmotionData.md5 = CameraEmoConstant.a(paramCameraEmoImg.a);
      } else {
        localCameraEmotionData.md5 = paramCameraEmoImg.d;
      }
      localCameraEmotionData.url = paramCameraEmoImg.c;
      return localCameraEmotionData;
    }
    return null;
  }
  
  private void delLocalList(List<String> paramList, List<CameraEmotionData> paramList1, boolean paramBoolean)
  {
    Object localObject2 = getEmoticonDatasByType("needDel");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new ArrayList();
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      if (((List)localObject1).size() > 0)
      {
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext()) {
          if (!paramList.contains(((CameraEmotionData)((Iterator)localObject2).next()).resid)) {
            ((Iterator)localObject2).remove();
          }
        }
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("updateLocalDBFromServer, locNeedDelList.size = ");
        paramList.append(((List)localObject1).size());
        QLog.d("CameraEmotionRoamingDBManager", 2, paramList.toString());
      }
    }
    if (paramBoolean) {
      ((List)localObject1).addAll(paramList1);
    }
    if (((List)localObject1).size() > 0)
    {
      paramList = ((List)localObject1).iterator();
      while (paramList.hasNext()) {
        updateCache((CameraEmotionData)paramList.next(), 4);
      }
      updateCustomEmotionDataListInDB((List)localObject1, 4);
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("updateLocalDBFromServer, needDelete = ");
      paramList.append(paramBoolean);
      paramList.append("| localNotInServerList.size = ");
      paramList.append(paramList1.size());
      QLog.d("CameraEmotionRoamingDBManager", 2, paramList.toString());
    }
  }
  
  public EmoticonInfo convertEmotionDataToInfo(CameraEmotionData paramCameraEmotionData)
  {
    CameraEmoticonInfo localCameraEmoticonInfo = new CameraEmoticonInfo();
    localCameraEmoticonInfo.type = 11;
    localCameraEmoticonInfo.path = getCustomEmoticonPath(paramCameraEmotionData);
    localCameraEmoticonInfo.contextKey = paramCameraEmotionData.strContext;
    localCameraEmoticonInfo.templateId = paramCameraEmotionData.templateId;
    localCameraEmoticonInfo.url = paramCameraEmotionData.url;
    localCameraEmoticonInfo.emoId = paramCameraEmotionData.emoId;
    localCameraEmoticonInfo.eId = paramCameraEmotionData.resid;
    localCameraEmoticonInfo.roamingType = paramCameraEmotionData.RomaingType;
    localCameraEmoticonInfo.thumbPath = paramCameraEmotionData.thumbPath;
    localCameraEmoticonInfo.resID = paramCameraEmotionData.resid;
    return localCameraEmoticonInfo;
  }
  
  public int getCatchDataCount()
  {
    Object localObject = this.customEmotionDbCache;
    int i = 0;
    if (localObject == null) {
      return 0;
    }
    localObject = this.customEmotionDbCache.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!"needDel".equals(((CameraEmotionData)((Iterator)localObject).next()).RomaingType)) {
        i += 1;
      }
    }
    return i;
  }
  
  public String getCustomEmoticonPath(CameraEmotionData paramCameraEmotionData)
  {
    if (paramCameraEmotionData != null)
    {
      if (this.app == null) {
        return "";
      }
      if (!TextUtils.isEmpty(paramCameraEmotionData.emoPath)) {
        return paramCameraEmotionData.emoPath;
      }
      String str2 = paramCameraEmotionData.md5;
      String str1 = str2;
      if (TextUtils.isEmpty(str2))
      {
        if (TextUtils.isEmpty(paramCameraEmotionData.resid)) {
          return "";
        }
        str1 = CameraEmoConstant.a(paramCameraEmotionData.resid);
      }
      return CameraEmoConstant.a(str1, this.app.getCurrentUin());
    }
    return "";
  }
  
  public CameraEmotionData getCustomEmotionDataBYResId(List<CameraEmotionData> paramList, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (paramList != null)
    {
      if (paramList.size() < 1) {
        return null;
      }
      int i = 0;
      int j = paramList.size();
      while (i < j)
      {
        CameraEmotionData localCameraEmotionData = (CameraEmotionData)paramList.get(i);
        if ((localCameraEmotionData != null) && (!TextUtils.isEmpty(localCameraEmotionData.resid)) && (localCameraEmotionData.resid.equals(paramString))) {
          return localCameraEmotionData;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public Class getDBClass()
  {
    return CameraEmotionData.class;
  }
  
  public List<CameraEmotionData> getEmoticonDataList()
  {
    for (;;)
    {
      try
      {
        localObject1 = new ArrayList();
        if (this.customEmotionDbCache.size() > 0)
        {
          localObject3 = this.customEmotionDbCache.iterator();
          if (((Iterator)localObject3).hasNext())
          {
            localObject4 = (CameraEmotionData)((Iterator)localObject3).next();
            if (localObject4 == null) {
              continue;
            }
            ((List)localObject1).add(localObject4);
            continue;
          }
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("getEmoticonDataList from cache: data size = ");
            ((StringBuilder)localObject3).append(((List)localObject1).size());
            QLog.d("CameraEmotionRoamingDBManager", 2, ((StringBuilder)localObject3).toString());
          }
          return localObject1;
        }
        localObject3 = this.app;
        if (localObject3 == null) {
          return localObject1;
        }
        localObject3 = this.app.getEntityManagerFactory().createEntityManager();
        if (localObject3 == null) {
          continue;
        }
        localObject3 = ((EntityManager)localObject3).query(getDBClass(), false, null, null, null, null, null, null);
        localObject1 = new ArrayList();
        int k = 0;
        i = 0;
        j = k;
        if (localObject3 == null) {
          continue;
        }
        j = k;
        if (((List)localObject3).size() <= 0) {
          continue;
        }
        Object localObject4 = ((List)localObject3).iterator();
        j = i;
        if (!((Iterator)localObject4).hasNext()) {
          continue;
        }
        localCameraEmotionData = (CameraEmotionData)((Iterator)localObject4).next();
        if (TextUtils.isEmpty(localCameraEmotionData.RomaingType))
        {
          localCameraEmotionData.RomaingType = "init";
          ((List)localObject1).add(localCameraEmotionData);
        }
        else if (localCameraEmotionData.RomaingType.equals("needUpload"))
        {
          localCameraEmotionData.RomaingType = "failed";
          ((List)localObject1).add(localCameraEmotionData);
          reportProcessInterruptError();
        }
      }
      finally
      {
        Object localObject1;
        Object localObject3;
        int j;
        CameraEmotionData localCameraEmotionData;
        continue;
        throw localObject2;
        continue;
        int i = 1;
        continue;
      }
      updateCache(localCameraEmotionData, 1);
    }
    trimCache();
    if (j != 0) {
      updateCustomEmotionDataListInDB((List)localObject1, 2);
    }
    localObject1 = localObject3;
    if (QLog.isColorLevel()) {
      if (localObject3 != null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getEmoticonDataList from db : data size = ");
        ((StringBuilder)localObject1).append(((List)localObject3).size());
        QLog.d("CameraEmotionRoamingDBManager", 2, ((StringBuilder)localObject1).toString());
        this.hasEmoCacheFlags = true;
        localObject1 = localObject3;
      }
      else
      {
        localObject3 = new ArrayList();
        QLog.d("CameraEmotionRoamingDBManager", 2, "getEmoticonDataList from db : data size = null");
        localObject1 = localObject3;
        if (this.hasEmoCacheFlags)
        {
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "CameraEmoDBError", true, 0L, 0L, null, "");
          localObject1 = localObject3;
        }
      }
    }
    return localObject1;
  }
  
  public CustomEmotionRoamingManagerBase<CameraEmotionData> getRoamingManager()
  {
    return (CameraEmoRoamingManagerServiceImpl)this.app.getRuntimeService(ICameraEmoRoamingManagerService.class);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    CameraEmoSendControl.a().a.a();
  }
  
  public void reportProcessInterruptError()
  {
    if (!this.hasReportProcessInterrupt)
    {
      this.hasReportProcessInterrupt = true;
      HashMap localHashMap = new HashMap();
      localHashMap.put("sucFlag", "0");
      localHashMap.put("retCode", String.valueOf(15));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "CamEmoUpload", false, 0L, 0L, localHashMap, null);
    }
  }
  
  public List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPanel()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraEmotionRoamingDBManager", 2, "Call CameraEmotionRoamingDBManager syncGetCustomEmotionInfoShowedInPanel.");
    }
    Object localObject = getEmoticonDataList();
    ArrayList localArrayList = new ArrayList();
    if (localObject != null) {}
    try
    {
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        CameraEmotionData localCameraEmotionData = (CameraEmotionData)((List)localObject).get(i);
        if ("needDel".equals(localCameraEmotionData.RomaingType))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("data need delete, do not need display -> resId:");
          localStringBuilder.append(localCameraEmotionData.resid);
          QLog.d("CameraEmotionRoamingDBManager", 1, localStringBuilder.toString());
        }
        else
        {
          localArrayList.add(convertEmotionDataToInfo(localCameraEmotionData));
        }
        i -= 1;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label133:
      break label133;
    }
    QLog.e("CameraEmotionRoamingDBManager", 1, "syncGetCustomEmotionInfoShowedInPanel oom");
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("syncGetCustomEmotionInfoShowedInPanel, display size:");
      ((StringBuilder)localObject).append(localArrayList.size());
      QLog.d("CameraEmotionRoamingDBManager", 2, ((StringBuilder)localObject).toString());
    }
    return localArrayList;
  }
  
  protected List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPreview()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CameraEmotionRoamingDBManager", 2, "Call CameraEmotionRoamingDBManager syncGetCustomEmotionInfoShowedInPreview.");
    }
    Object localObject1 = getEmoticonDataList();
    ArrayList localArrayList = new ArrayList();
    if (localObject1 != null) {}
    try
    {
      int i = ((List)localObject1).size() - 1;
      while (i >= 0)
      {
        CameraEmotionData localCameraEmotionData = (CameraEmotionData)((List)localObject1).get(i);
        Object localObject2;
        if (!"normal".equals(localCameraEmotionData.RomaingType))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("data need hidden, do not need display -> resId:");
          ((StringBuilder)localObject2).append(localCameraEmotionData.resid);
          QLog.d("CameraEmotionRoamingDBManager", 1, ((StringBuilder)localObject2).toString());
        }
        else
        {
          localObject2 = new CameraEmoticonInfo();
          ((CameraEmoticonInfo)localObject2).type = 11;
          ((CameraEmoticonInfo)localObject2).path = getCustomEmoticonPath(localCameraEmotionData);
          ((CameraEmoticonInfo)localObject2).contextKey = localCameraEmotionData.strContext;
          ((CameraEmoticonInfo)localObject2).templateId = localCameraEmotionData.templateId;
          ((CameraEmoticonInfo)localObject2).url = localCameraEmotionData.url;
          ((CameraEmoticonInfo)localObject2).emoId = localCameraEmotionData.emoId;
          ((CameraEmoticonInfo)localObject2).eId = localCameraEmotionData.resid;
          ((CameraEmoticonInfo)localObject2).roamingType = localCameraEmotionData.RomaingType;
          ((CameraEmoticonInfo)localObject2).thumbPath = localCameraEmotionData.thumbPath;
          ((CameraEmoticonInfo)localObject2).resID = localCameraEmotionData.resid;
          localArrayList.add(localObject2);
        }
        i -= 1;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label236:
      break label236;
    }
    QLog.e("CameraEmotionRoamingDBManager", 1, "syncGetCustomEmotionInfoShowedInPreview oom");
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("syncGetCustomEmotionInfoShowedInPreview, display size:");
      ((StringBuilder)localObject1).append(localArrayList.size());
      QLog.d("CameraEmotionRoamingDBManager", 2, ((StringBuilder)localObject1).toString());
    }
    return localArrayList;
  }
  
  public void updateCustomEmotionDataInDB(CameraEmotionData paramCameraEmotionData, int paramInt)
  {
    super.updateCustomEmotionDataInDB(paramCameraEmotionData, paramInt);
    if (this.app != null) {
      StickerRecManagerImpl.get(this.app).updateKeywordForCameraEmotion();
    }
  }
  
  protected void updateCustomEmotionDataListInDB(List<CameraEmotionData> paramList, int paramInt)
  {
    super.updateCustomEmotionDataListInDB(paramList, paramInt);
    if (this.app != null) {
      StickerRecManagerImpl.get(this.app).updateKeywordForCameraEmotion();
    }
  }
  
  public void updateLocalDBFromServer(List<CameraEmoImg> paramList, List<String> paramList1, List<String> paramList2)
  {
    if (paramList != null)
    {
      if (paramList1 == null) {
        return;
      }
      boolean bool3 = QLog.isColorLevel();
      boolean bool2 = false;
      boolean bool1 = false;
      int i;
      if (bool3)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("updateLocalDBFromServer, start remoteImgList.size = ");
        ((StringBuilder)localObject1).append(paramList.size());
        ((StringBuilder)localObject1).append("| deleteSize =");
        if (paramList2 == null) {
          i = 0;
        } else {
          i = paramList2.size();
        }
        ((StringBuilder)localObject1).append(i);
        QLog.d("CameraEmotionRoamingDBManager", 2, ((StringBuilder)localObject1).toString());
      }
      Object localObject1 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = getEmoticonDataList();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        for (;;)
        {
          bool2 = bool1;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          CameraEmotionData localCameraEmotionData = (CameraEmotionData)((Iterator)localObject2).next();
          if ((!localCameraEmotionData.RomaingType.equals("needDel")) && (!localCameraEmotionData.RomaingType.equals("failed")) && (!localCameraEmotionData.RomaingType.equals("needUpload")))
          {
            i = paramList1.indexOf(localCameraEmotionData.resid);
            if (i < 0)
            {
              bool1 = true;
              ((List)localObject1).add(localCameraEmotionData);
            }
            else
            {
              localArrayList.add(paramList.get(i));
            }
          }
        }
      }
      delLocalList(paramList2, (List)localObject1, bool2);
      addLocalList(paramList, localArrayList);
      trimCache();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.CameraEmotionRoamingDBManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */