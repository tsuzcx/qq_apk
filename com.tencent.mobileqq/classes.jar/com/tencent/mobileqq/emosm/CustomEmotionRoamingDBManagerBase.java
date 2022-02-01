package com.tencent.mobileqq.emosm;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionBase;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

public abstract class CustomEmotionRoamingDBManagerBase<T extends CustomEmotionBase>
  implements IRuntimeService
{
  protected static final int DELETE = 4;
  protected static final int INSERT = 1;
  public static final String TAG = "CustomEmotionRoamingDBManagerBase";
  protected static final int UPDATE = 2;
  protected BaseQQAppInterface app;
  protected List<T> customEmotionDbCache = new CopyOnWriteArrayList();
  
  public void asyncGetFavEmotionInfoShowedInPanel(CustomEmotionRoamingDBManagerBase.CustomEmotionDataInPanelCallback paramCustomEmotionDataInPanelCallback)
  {
    if (paramCustomEmotionDataInPanelCallback == null) {
      return;
    }
    ThreadManager.post(new CustomEmotionRoamingDBManagerBase.3(this, paramCustomEmotionDataInPanelCallback), 5, null, true);
  }
  
  public void asyncGetFavEmotionInfoShowedInPreview(CustomEmotionRoamingDBManagerBase.CustomEmotionDataInPanelCallback paramCustomEmotionDataInPanelCallback)
  {
    if (paramCustomEmotionDataInPanelCallback == null) {
      return;
    }
    ThreadManager.post(new CustomEmotionRoamingDBManagerBase.4(this, paramCustomEmotionDataInPanelCallback), 5, null, true);
  }
  
  public abstract EmoticonInfo convertEmotionDataToInfo(T paramT);
  
  public void deleteCustomEmotion(T paramT)
  {
    if (paramT != null)
    {
      updateCache(paramT, 4);
      updateCustomEmotionDataInDB(paramT, 4);
    }
  }
  
  public void deleteCustomEmotionList(List<T> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() < 1) {
        return;
      }
      int i = 0;
      while (i < paramList.size())
      {
        updateCache((CustomEmotionBase)paramList.get(i), 4);
        i += 1;
      }
      updateCustomEmotionDataListInDB(paramList, 4);
    }
  }
  
  public List<T> findMagicEmosById(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CustomEmotionRoamingDBManagerBase", 2, "Call getEmoticonDataList from findMagicEmosById.");
    }
    List localList = getEmoticonDataList();
    ArrayList localArrayList = new ArrayList();
    if ((localList != null) && (localList.size() > 0))
    {
      int i = 0;
      while (i < localList.size())
      {
        CustomEmotionBase localCustomEmotionBase = (CustomEmotionBase)localList.get(i);
        if ((localCustomEmotionBase != null) && (localCustomEmotionBase.emoPath.equals(paramString))) {
          localArrayList.add(localCustomEmotionBase);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public abstract String getCustomEmoticonPath(T paramT);
  
  public List<String> getCustomEmoticonResIdsByType(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CustomEmotionRoamingDBManagerBase", 2, "Call getEmoticonDataList from getCustomEmoticonResIdsByType.");
    }
    Object localObject = getEmoticonDataList();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CustomEmotionBase localCustomEmotionBase = (CustomEmotionBase)((Iterator)localObject).next();
        String str = localCustomEmotionBase.resid;
        if ((localCustomEmotionBase.RomaingType.equals(paramString)) && (str != null) && (!"".equals(str))) {
          localArrayList.add(str);
        }
      }
    }
    return localArrayList;
  }
  
  public abstract T getCustomEmotionDataBYResId(List<T> paramList, String paramString);
  
  public abstract Class getDBClass();
  
  public abstract List<T> getEmoticonDataList();
  
  public List<T> getEmoticonDatasByType(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    ArrayList localArrayList = null;
    if (bool) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CustomEmotionRoamingDBManagerBase", 2, "Call getEmoticonDataList from getEmoticonDatasByType.");
    }
    List localList = getEmoticonDataList();
    Object localObject = localArrayList;
    if (localList != null)
    {
      localObject = localArrayList;
      if (localList.size() > 0)
      {
        localArrayList = new ArrayList();
        int i = 0;
        for (;;)
        {
          localObject = localArrayList;
          if (i >= localList.size()) {
            break;
          }
          localObject = (CustomEmotionBase)localList.get(i);
          if (((CustomEmotionBase)localObject).RomaingType.equals(paramString)) {
            localArrayList.add(localObject);
          }
          i += 1;
        }
      }
    }
    return localObject;
  }
  
  public T getEmotionDataByUrl(String paramString)
  {
    Object localObject = this.app;
    if (localObject == null) {
      return null;
    }
    localObject = ((BaseQQAppInterface)localObject).getEntityManagerFactory().createEntityManager();
    if (localObject == null) {
      return null;
    }
    paramString = ((EntityManager)localObject).query(getDBClass(), false, "url=?", new String[] { paramString }, null, null, null, null);
    ((EntityManager)localObject).close();
    if ((paramString != null) && (paramString.size() == 1)) {
      return (CustomEmotionBase)paramString.get(0);
    }
    return null;
  }
  
  public abstract CustomEmotionRoamingManagerBase<T> getRoamingManager();
  
  public void insertCustomEmotion(T paramT)
  {
    if (paramT != null)
    {
      updateCache(paramT, 1);
      updateCustomEmotionDataInDB(paramT, 1);
    }
  }
  
  public void insertCustomEmotionList(List<T> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() < 1) {
        return;
      }
      int i = 0;
      while (i < paramList.size())
      {
        updateCache((CustomEmotionBase)paramList.get(i), 1);
        i += 1;
      }
      updateCustomEmotionDataListInDB(paramList, 1);
    }
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = ((BaseQQAppInterface)paramAppRuntime);
  }
  
  public void onDestroy()
  {
    this.customEmotionDbCache.clear();
    this.app = null;
  }
  
  public void runInCurrentThread(Runnable paramRunnable, int paramInt)
  {
    if (paramRunnable != null)
    {
      if (Looper.myLooper() != Looper.getMainLooper())
      {
        paramRunnable.run();
        return;
      }
      ThreadManager.post(paramRunnable, paramInt, null, true);
    }
  }
  
  public abstract List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPanel();
  
  protected abstract List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPreview();
  
  public void trimCache()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.customEmotionDbCache.iterator();
    while (localIterator.hasNext())
    {
      CustomEmotionBase localCustomEmotionBase = (CustomEmotionBase)localIterator.next();
      if (localCustomEmotionBase.RomaingType.equals("failed")) {
        localArrayList.add(localCustomEmotionBase);
      }
    }
    this.customEmotionDbCache.removeAll(localArrayList);
    this.customEmotionDbCache.addAll(localArrayList);
  }
  
  protected void updateCache(T paramT, int paramInt)
  {
    if (paramT == null) {
      return;
    }
    if (paramInt != 1)
    {
      Iterator localIterator;
      CustomEmotionBase localCustomEmotionBase;
      if (paramInt != 2)
      {
        if (paramInt != 4)
        {
          if (QLog.isColorLevel())
          {
            paramT = new StringBuilder();
            paramT.append("can not update fav emoticon cache data, type:");
            paramT.append(paramInt);
            QLog.d("CustomEmotionRoamingDBManagerBase", 2, paramT.toString());
          }
        }
        else
        {
          localIterator = this.customEmotionDbCache.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localCustomEmotionBase = (CustomEmotionBase)localIterator.next();
          } while (localCustomEmotionBase.emoId != paramT.emoId);
          this.customEmotionDbCache.remove(localCustomEmotionBase);
        }
      }
      else
      {
        localIterator = this.customEmotionDbCache.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localCustomEmotionBase = (CustomEmotionBase)localIterator.next();
        } while (localCustomEmotionBase.emoId != paramT.emoId);
        localCustomEmotionBase.replace(paramT);
      }
    }
    else
    {
      this.customEmotionDbCache.add(paramT);
    }
  }
  
  public void updateCustomEmotion(T paramT)
  {
    if (paramT != null)
    {
      updateCache(paramT, 2);
      updateCustomEmotionDataInDB(paramT, 2);
    }
  }
  
  public void updateCustomEmotionDataInDB(T paramT, int paramInt)
  {
    if (paramT == null) {
      return;
    }
    runInCurrentThread(new CustomEmotionRoamingDBManagerBase.2(this, paramInt, paramT), 8);
  }
  
  protected void updateCustomEmotionDataListInDB(List<T> paramList, int paramInt)
  {
    if (paramList != null)
    {
      if (paramList.size() < 1) {
        return;
      }
      runInCurrentThread(new CustomEmotionRoamingDBManagerBase.1(this, paramList, paramInt), 8);
    }
  }
  
  public void updateCustomEmotionList(List<T> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() < 1) {
        return;
      }
      int i = 0;
      while (i < paramList.size())
      {
        updateCache((CustomEmotionBase)paramList.get(i), 2);
        i += 1;
      }
      updateCustomEmotionDataListInDB(paramList, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase
 * JD-Core Version:    0.7.0.1
 */