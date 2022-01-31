package com.tencent.mobileqq.emosm.favroaming;

import abzp;
import abzr;
import abzs;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FunnyPicHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqManager;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.manager.Manager;

public class FavroamingDBManager
  implements Manager
{
  public QQAppInterface a;
  private List a;
  
  public FavroamingDBManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = new CopyOnWriteArrayList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private CustomEmotionData a(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    CustomEmotionData localCustomEmotionData = null;
    Object localObject = localCustomEmotionData;
    if (paramString1 != null)
    {
      if (!TextUtils.isEmpty(paramString2)) {
        break label25;
      }
      localObject = localCustomEmotionData;
    }
    label25:
    String str1;
    ResidParser localResidParser;
    String str2;
    do
    {
      do
      {
        do
        {
          return localObject;
          str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          localResidParser = new ResidParser(paramString1);
          localObject = localCustomEmotionData;
        } while (TextUtils.isEmpty(localResidParser.a));
        str2 = localResidParser.jdField_c_of_type_JavaLangString;
        localObject = localCustomEmotionData;
      } while (str2 == null);
      localObject = localCustomEmotionData;
    } while ("".equals(str2));
    localCustomEmotionData = new CustomEmotionData();
    if (str2.equals("1"))
    {
      localCustomEmotionData.isMarkFace = true;
      localCustomEmotionData.uin = str1;
      localCustomEmotionData.emoPath = localResidParser.e;
      localCustomEmotionData.eId = localResidParser.f;
      localCustomEmotionData.resid = paramString1;
      localCustomEmotionData.RomaingType = paramString3;
      localCustomEmotionData.url = FavEmoConstant.a(paramString1, paramString2, str1);
      localCustomEmotionData.emoId = paramInt;
      localCustomEmotionData.isAPNG = paramBoolean;
    }
    while (!str2.equals("0"))
    {
      localObject = localCustomEmotionData;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FavroamingDBManager", 2, "createCustomEmotionDataByResIdList : emotionData = " + localCustomEmotionData + ", emotion name:" + paramString1);
      return localCustomEmotionData;
    }
    localObject = localResidParser.f;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (!((String)localObject).contains("qto@")) {
        break label378;
      }
      localObject = ((String)localObject).replace("qto@", "qto_");
      localCustomEmotionData.eId = ((String)localObject);
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingDBManager", 2, "download funnyPic name.original->" + (String)localObject);
      }
    }
    for (;;)
    {
      localCustomEmotionData.isMarkFace = false;
      localCustomEmotionData.uin = str1;
      localCustomEmotionData.emoPath = FavEmoConstant.a(paramString1);
      localCustomEmotionData.resid = paramString1;
      localCustomEmotionData.md5 = localResidParser.jdField_d_of_type_JavaLangString;
      localCustomEmotionData.url = FavEmoConstant.a(paramString1, paramString2, str1);
      localCustomEmotionData.RomaingType = paramString3;
      localCustomEmotionData.emoId = paramInt;
      break;
      label378:
      if (((String)localObject).contains("diydoutu@"))
      {
        localCustomEmotionData.eId = localResidParser.e;
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingDBManager", 2, "download diyemoji name.original->" + paramString1);
        }
      }
    }
  }
  
  private void a(Runnable paramRunnable, int paramInt)
  {
    if (paramRunnable != null)
    {
      if (Looper.myLooper() != Looper.getMainLooper()) {
        paramRunnable.run();
      }
    }
    else {
      return;
    }
    ThreadManager.post(paramRunnable, paramInt, null, true);
  }
  
  private void a(List paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.size() < 1)) {
      return;
    }
    a(new abzr(this, paramList, paramInt), 8);
  }
  
  private void b(CustomEmotionData paramCustomEmotionData, int paramInt)
  {
    if (paramCustomEmotionData == null) {}
    CustomEmotionData localCustomEmotionData;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext())
      {
        do
        {
          switch (paramInt)
          {
          }
        } while (!QLog.isColorLevel());
        QLog.d("FavroamingDBManager", 2, "can not update fav emoticon cache data, type:" + paramInt);
        return;
        this.jdField_a_of_type_JavaUtilList.add(paramCustomEmotionData);
        return;
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localCustomEmotionData = (CustomEmotionData)localIterator.next();
        } while (localCustomEmotionData.emoId != paramCustomEmotionData.emoId);
        localCustomEmotionData.replace(paramCustomEmotionData);
        return;
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      }
      localCustomEmotionData = (CustomEmotionData)localIterator.next();
    } while (localCustomEmotionData.emoId != paramCustomEmotionData.emoId);
    this.jdField_a_of_type_JavaUtilList.remove(localCustomEmotionData);
  }
  
  public CustomEmotionData a(String paramString)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    if (localEntityManager == null) {}
    do
    {
      return null;
      paramString = localEntityManager.a(CustomEmotionData.class, false, "url=?", new String[] { paramString }, null, null, null, null);
      localEntityManager.a();
    } while ((paramString == null) || (paramString.size() != 1));
    return (CustomEmotionData)paramString.get(0);
  }
  
  public CustomEmotionData a(List paramList, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((paramList == null) || (paramList.size() < 1)) {
      return null;
    }
    int j = paramList.size();
    int i = 0;
    CustomEmotionData localCustomEmotionData;
    for (;;)
    {
      if (i < j)
      {
        localCustomEmotionData = (CustomEmotionData)paramList.get(i);
        if (localCustomEmotionData == null) {
          label56:
          i += 1;
        } else if ((!TextUtils.isEmpty(localCustomEmotionData.resid)) && (localCustomEmotionData.resid.equals(paramString))) {
          paramList = localCustomEmotionData;
        }
      }
    }
    for (;;)
    {
      label89:
      return paramList;
      Object localObject = new ResidParser(paramString);
      if (!((ResidParser)localObject).a())
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("FavroamingDBManager", 2, "res id is not valid:" + paramString);
        return null;
      }
      if (localCustomEmotionData.isMarkFace)
      {
        str = ((ResidParser)localObject).e;
        localObject = ((ResidParser)localObject).f;
        if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty((CharSequence)localObject)) || (!str.equals(localCustomEmotionData.emoPath)) || (!((String)localObject).equals(localCustomEmotionData.eId))) {
          break label56;
        }
        localCustomEmotionData.resid = paramString;
        paramList = localCustomEmotionData;
        continue;
      }
      localObject = ((ResidParser)localObject).jdField_d_of_type_JavaLangString;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label56;
      }
      if (!TextUtils.isEmpty(localCustomEmotionData.md5)) {}
      for (String str = localCustomEmotionData.md5;; str = HexUtil.bytes2HexStr(MD5.getFileMd5(localCustomEmotionData.emoPath)))
      {
        localCustomEmotionData.md5 = str;
        if (!((String)localObject).equals(str)) {
          break;
        }
        localCustomEmotionData.resid = paramString;
        paramList = localCustomEmotionData;
        break label89;
      }
      paramList = null;
    }
  }
  
  public String a(CustomEmotionData paramCustomEmotionData)
  {
    Object localObject1;
    if (paramCustomEmotionData == null) {
      localObject1 = "";
    }
    Object localObject2;
    do
    {
      return localObject1;
      if (!TextUtils.isEmpty(paramCustomEmotionData.emoPath)) {
        return paramCustomEmotionData.emoPath;
      }
      localObject1 = AppConstants.aU;
      localObject2 = (VipComicMqqManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(140);
      if ((localObject2 != null) && (((VipComicMqqManager)localObject2).a(paramCustomEmotionData)))
      {
        if ((!TextUtils.isEmpty(paramCustomEmotionData.emoPath)) && (paramCustomEmotionData.emoPath.startsWith(AppConstants.aU))) {
          return paramCustomEmotionData.emoPath;
        }
        if (!TextUtils.isEmpty(paramCustomEmotionData.md5)) {
          return ((VipComicMqqManager)localObject2).a(paramCustomEmotionData.md5);
        }
        if (!TextUtils.isEmpty(paramCustomEmotionData.resid)) {
          return (String)localObject1 + paramCustomEmotionData.resid;
        }
        return (String)localObject1 + paramCustomEmotionData.url.substring(paramCustomEmotionData.url.lastIndexOf("/") + 1);
      }
      if (paramCustomEmotionData.url.contains("qto_")) {
        return (String)localObject1 + FunnyPicHelper.a(paramCustomEmotionData.url);
      }
      if (TextUtils.isEmpty(FunnyPicHelper.a(paramCustomEmotionData.eId))) {
        break;
      }
      localObject2 = (String)localObject1 + paramCustomEmotionData.eId;
      localObject1 = localObject2;
    } while (!QLog.isColorLevel());
    QLog.d("FavroamingDBManager", 2, "emotion is FunnyPic path download from server->" + paramCustomEmotionData.eId);
    return localObject2;
    return (String)localObject1 + paramCustomEmotionData.resid;
  }
  
  public List a()
  {
    int j = 0;
    Object localObject;
    try
    {
      ArrayList localArrayList = new ArrayList();
      if (this.jdField_a_of_type_JavaUtilList.size() <= 0) {
        break label120;
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject).next();
        if (localCustomEmotionData != null) {
          localArrayList.add(localCustomEmotionData);
        }
      }
      if (!QLog.isColorLevel()) {
        break label116;
      }
    }
    finally {}
    QLog.d("FavroamingDBManager", 2, "getFavEmoticonList from cache: data size = " + localList1.size());
    for (;;)
    {
      label116:
      return localList1;
      label120:
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      List localList2;
      if (localObject != null)
      {
        localList2 = ((EntityManager)localObject).a(CustomEmotionData.class, false, null, null, null, null, null, null);
        ((EntityManager)localObject).a();
      }
      int i;
      if ((localList2 != null) && (localList2.size() > 0))
      {
        i = 0;
        while (j < localList2.size())
        {
          localObject = (CustomEmotionData)localList2.get(j);
          if (TextUtils.isEmpty(((CustomEmotionData)localObject).RomaingType))
          {
            ((CustomEmotionData)localObject).RomaingType = "init";
            i = 1;
          }
          b((CustomEmotionData)localObject, 1);
          j += 1;
        }
      }
      for (;;)
      {
        if (i != 0) {
          a(localList2, 2);
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        if (localList2 != null)
        {
          QLog.d("FavroamingDBManager", 2, "getFavEmoticonList from db : data size = " + localList2.size());
          break;
        }
        QLog.d("FavroamingDBManager", 2, "getFavEmoticonList from db : data size = null");
        break;
        i = 0;
      }
    }
  }
  
  public List a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    if (TextUtils.isEmpty(paramString)) {
      return localArrayList;
    }
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getFavEmoticonList from getFavEmoticonResIdsByType.");
    }
    List localList = a();
    if ((localList != null) && (localList.size() > 0))
    {
      int i = 0;
      while (i < localList.size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(i);
        String str = localCustomEmotionData.resid;
        if ((localCustomEmotionData.RomaingType.equals(paramString)) && (str != null) && (!"".equals(str))) {
          localArrayList.add(str);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public List a(List paramList1, List paramList2)
  {
    if ((paramList1 == null) && (paramList2 == null)) {}
    ArrayList localArrayList;
    do
    {
      do
      {
        return null;
      } while ((paramList1 != null) && (paramList1.size() < 1));
      localArrayList = new ArrayList();
      if (paramList1 != null) {
        localArrayList.addAll(paramList1);
      }
      if (paramList2 != null) {
        localArrayList.addAll(paramList2);
      }
      paramList1 = a("isUpdate");
    } while (paramList1 == null);
    paramList2 = new ArrayList();
    int i = 0;
    while (i < paramList1.size())
    {
      if (!localArrayList.contains(paramList1.get(i))) {
        paramList2.add(paramList1.get(i));
      }
      i += 1;
    }
    return paramList2;
  }
  
  public List a(List paramList1, List paramList2, String paramString, List paramList3)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = a(paramList1, paramList2);
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localArrayList.addAll((Collection)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingDBManager", 1, "localUpdatedNotInServerList=" + ((List)localObject1).size());
      }
    }
    if ((paramList1 != null) && (paramList1.size() > 0)) {
      localArrayList.addAll(paramList1);
    }
    int i;
    if (localArrayList.size() > 0)
    {
      paramList1 = new ArrayList();
      if (QLog.isColorLevel()) {
        QLog.i("FavroamingDBManager", 2, "Call getFavEmoticonList from updateFavEmotionsInLocalEx-1.");
      }
      localObject1 = a();
      i = 0;
      while (i < localArrayList.size())
      {
        localObject2 = a((List)localObject1, (String)localArrayList.get(i));
        if (localObject2 != null) {
          paramList1.add(localObject2);
        }
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingDBManager", 1, "deleDatas=" + paramList1.size());
      }
      c(paramList1);
    }
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getFavEmoticonList from updateFavEmotionsInLocalEx-2.");
    }
    Object localObject2 = a();
    int k;
    if (localObject2 != null)
    {
      i = 1;
      k = 0;
      for (;;)
      {
        j = i;
        if (k >= ((List)localObject2).size()) {
          break;
        }
        int m = ((CustomEmotionData)((List)localObject2).get(k)).emoId;
        j = i;
        if (i < m) {
          j = m;
        }
        k += 1;
        i = j;
      }
    }
    int j = 1;
    localArrayList = new ArrayList();
    if (paramList2 != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FavroamingDBManager", 2, "Call getFavEmoticonList from updateFavEmotionsInLocalEx-3.");
      }
      List localList = a();
      i = 0;
      if (i < paramList2.size())
      {
        String str = (String)paramList2.get(i);
        localObject1 = a(localList, str);
        boolean bool1;
        if (localObject1 == null)
        {
          boolean bool2 = false;
          bool1 = bool2;
          if (paramList3 != null)
          {
            bool1 = bool2;
            if (i <= paramList3.size())
            {
              if (((Integer)paramList3.get(i)).intValue() != 2) {
                break label506;
              }
              bool1 = true;
            }
          }
          label463:
          k = j + 1;
          paramList1 = a(str, paramString, "needDownload", k, bool1);
        }
        for (;;)
        {
          localArrayList.add(paramList1);
          i += 1;
          j = k;
          break;
          label506:
          bool1 = false;
          break label463;
          paramList1 = (List)localObject1;
          k = j;
          if (localObject2 != null)
          {
            if ("init".equals(((CustomEmotionData)localObject1).RomaingType)) {
              ((CustomEmotionData)localObject1).RomaingType = "isUpdate";
            }
            if (TextUtils.isEmpty(((CustomEmotionData)localObject1).url))
            {
              if (QLog.isColorLevel()) {
                QLog.d("FavroamingDBManager", 2, "url is null because of old db data exception, fix it");
              }
              ((CustomEmotionData)localObject1).url = FavEmoConstant.a(str, paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            }
            ((List)localObject2).remove(localObject1);
            paramList1 = (List)localObject1;
            k = j;
          }
        }
      }
    }
    if ((localObject2 != null) && (((List)localObject2).size() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingDBManager", 1, "localNew=" + ((List)localObject2).size());
      }
      localArrayList.addAll((Collection)localObject2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingDBManager", 1, "mergeSize=" + localArrayList.size());
    }
    if (localArrayList.size() > FavEmoConstant.b) {}
    for (paramList1 = localArrayList.subList(0, FavEmoConstant.b);; paramList1 = localArrayList)
    {
      i = 0;
      if (i < paramList1.size())
      {
        paramList2 = (CustomEmotionData)paramList1.get(i);
        if (QLog.isColorLevel()) {
          QLog.d("FavroamingDBManager", 2, "local emo: " + paramList2);
        }
        if (i <= FavEmoConstant.a) {
          if (paramList2.RomaingType != null) {
            if (paramList2.RomaingType.equals("overflow_downloaded")) {
              paramList2.RomaingType = "isUpdate";
            }
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if ((!paramList2.RomaingType.equals("isUpdate")) && (!paramList2.RomaingType.equals("init")))
          {
            paramList2.RomaingType = "needDownload";
            continue;
            paramList2.RomaingType = "needDownload";
            continue;
            if (i <= FavEmoConstant.b) {
              if (paramList2.RomaingType != null)
              {
                if (paramList2.RomaingType.equals("isUpdate")) {
                  paramList2.RomaingType = "overflow_downloaded";
                } else if ((!paramList2.RomaingType.equals("overflow_downloaded")) && (!paramList2.RomaingType.equals("init"))) {
                  paramList2.RomaingType = "overflow";
                }
              }
              else {
                paramList2.RomaingType = "overflow";
              }
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("FavroamingDBManager", 2, "Call getFavEmoticonList from updateFavEmotionsInLocalEx-4.");
      }
      paramList2 = a();
      i = 0;
      if (paramList2 != null)
      {
        i = paramList2.size();
        c(paramList2);
      }
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(paramList1);
      a(paramList1, 1);
      j = 0;
      if (localObject2 != null)
      {
        j = ((List)localObject2).size() - 1;
        while (j >= 0)
        {
          paramList2 = (CustomEmotionData)((List)localObject2).get(j);
          if ((paramList2 != null) && (!paramList1.contains(paramList2))) {
            ((List)localObject2).remove(j);
          }
          j -= 1;
        }
        j = ((List)localObject2).size();
      }
      if (QLog.isColorLevel()) {
        QLog.d("FavroamingDBManager", 2, "updateFavEmotionsInLocalEx final cache size: " + paramList1.size() + ",delete size:" + i + ",upload size:" + j);
      }
      return localObject2;
    }
  }
  
  public void a(CustomEmotionData paramCustomEmotionData)
  {
    if (paramCustomEmotionData != null)
    {
      b(paramCustomEmotionData, 4);
      a(paramCustomEmotionData, 4);
    }
  }
  
  public void a(CustomEmotionData paramCustomEmotionData, int paramInt)
  {
    if (paramCustomEmotionData == null) {
      return;
    }
    a(new abzs(this, paramInt, paramCustomEmotionData), 8);
  }
  
  public void a(FavroamingDBManager.FavEmotionDataInPanelCallback paramFavEmotionDataInPanelCallback)
  {
    if (paramFavEmotionDataInPanelCallback == null) {
      return;
    }
    ThreadManager.post(new abzp(this, paramFavEmotionDataInPanelCallback), 5, null, true);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getFavEmoticonList from updateUpload.");
    }
    CustomEmotionData localCustomEmotionData = a(a(), paramString);
    if (localCustomEmotionData != null)
    {
      localCustomEmotionData.resid = paramString;
      localCustomEmotionData.RomaingType = "isUpdate";
      b(localCustomEmotionData);
    }
  }
  
  public void a(List paramList)
  {
    if (paramList == null) {
      return;
    }
    c(paramList);
  }
  
  public boolean a(CustomEmotionData paramCustomEmotionData, int paramInt)
  {
    if (paramCustomEmotionData == null) {}
    while (!"needDel".equals(paramCustomEmotionData.RomaingType)) {
      return false;
    }
    if (paramInt <= FavEmoConstant.a) {}
    for (Object localObject = "isUpdate";; localObject = "overflow_downloaded")
    {
      paramCustomEmotionData.RomaingType = ((String)localObject);
      b(paramCustomEmotionData);
      localObject = (FavroamingManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(102);
      if (localObject != null) {
        ((FavroamingManager)localObject).a(paramCustomEmotionData);
      }
      return true;
    }
  }
  
  public List b()
  {
    StartupTracker.a("AIO_EmoticonPanel_Refresh", null);
    Map localMap = ((VipComicMqqManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(140)).a();
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getFavEmoticonList from getFavEmotionInfoShowedInPanel.");
    }
    List localList = a();
    ArrayList localArrayList = new ArrayList();
    if (localList != null)
    {
      int i = localList.size() - 1;
      if (i >= 0)
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(i);
        if ("needDel".equals(localCustomEmotionData.RomaingType)) {
          QLog.d("FavroamingDBManager", 1, "data need delete, do not need display -> resId:" + localCustomEmotionData.resid);
        }
        for (;;)
        {
          i -= 1;
          break;
          Object localObject;
          if (localCustomEmotionData.isMarkFace)
          {
            localObject = new PicEmoticonInfo(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            ((PicEmoticonInfo)localObject).jdField_c_of_type_Int = 6;
            String str1 = localCustomEmotionData.eId;
            String str2 = localCustomEmotionData.emoPath;
            ((PicEmoticonInfo)localObject).b = localCustomEmotionData.isAPNG;
            ((PicEmoticonInfo)localObject).a = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(str2, str1);
            ((PicEmoticonInfo)localObject).jdField_d_of_type_Int = 2;
            if (((PicEmoticonInfo)localObject).a != null) {
              localArrayList.add(localObject);
            } else {
              QLog.e("FavroamingDBManager", 1, "PicEmoticonInfo.emoticon is null, " + localCustomEmotionData.toString());
            }
          }
          else
          {
            localObject = new FavoriteEmoticonInfo();
            ((FavoriteEmoticonInfo)localObject).jdField_c_of_type_Int = 4;
            ((FavoriteEmoticonInfo)localObject).jdField_d_of_type_JavaLangString = a(localCustomEmotionData);
            ((FavoriteEmoticonInfo)localObject).jdField_d_of_type_Int = 2;
            ((FavoriteEmoticonInfo)localObject).jdField_c_of_type_JavaLangString = localCustomEmotionData.eId;
            ((FavoriteEmoticonInfo)localObject).e = localCustomEmotionData.url;
            ((FavoriteEmoticonInfo)localObject).f = FavoriteEmoticonInfo.a(localMap, localCustomEmotionData.md5);
            if ((TextUtils.isEmpty(((FavoriteEmoticonInfo)localObject).jdField_d_of_type_JavaLangString)) && (TextUtils.isEmpty(((FavoriteEmoticonInfo)localObject).e))) {
              QLog.e("FavroamingDBManager", 1, "path and url is null! " + ((FavoriteEmoticonInfo)localObject).toString());
            } else {
              localArrayList.add(localObject);
            }
          }
        }
      }
      StartupTracker.a(null, "AIO_EmoticonPanel_Refresh");
    }
    if (QLog.isColorLevel()) {
      QLog.d("FavroamingDBManager", 2, "getFavEmotionInfoShowedInPanel, display size:" + localArrayList.size());
    }
    return localArrayList;
  }
  
  public List b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    List localList;
    do
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.i("FavroamingDBManager", 2, "Call getFavEmoticonList from getFavEmoticonsByType.");
      }
      localList = a();
    } while ((localList == null) || (localList.size() <= 0));
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < localList.size())
    {
      CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(i);
      if (localCustomEmotionData.RomaingType.equals(paramString)) {
        localArrayList.add(localCustomEmotionData);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void b(CustomEmotionData paramCustomEmotionData)
  {
    if (paramCustomEmotionData != null)
    {
      b(paramCustomEmotionData, 2);
      a(paramCustomEmotionData, 2);
    }
  }
  
  public void b(List paramList)
  {
    if (paramList == null) {}
    List localList;
    do
    {
      return;
      localList = b("needDel");
    } while (localList == null);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      String str = (String)paramList.get(i);
      int j = 0;
      while (j < localList.size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(i);
        if ((localCustomEmotionData.resid != null) && (!"".equals(localCustomEmotionData.resid)) && (localCustomEmotionData.resid.equals(str)))
        {
          b(localCustomEmotionData, 4);
          localArrayList.add(localCustomEmotionData);
        }
        j += 1;
      }
      i += 1;
    }
    a(localArrayList, 4);
  }
  
  public List c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getFavEmoticonList from findMagicEmosById.");
    }
    List localList = a();
    ArrayList localArrayList = new ArrayList();
    if ((localList != null) && (localList.size() > 0))
    {
      int i = 0;
      while (i < localList.size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(i);
        if ((localCustomEmotionData != null) && (localCustomEmotionData.emoPath.equals(paramString))) {
          localArrayList.add(localCustomEmotionData);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public void c(CustomEmotionData paramCustomEmotionData)
  {
    if (paramCustomEmotionData != null)
    {
      b(paramCustomEmotionData, 1);
      a(paramCustomEmotionData, 1);
    }
  }
  
  public void c(List paramList)
  {
    if ((paramList == null) || (paramList.size() < 1)) {
      return;
    }
    int i = 0;
    while (i < paramList.size())
    {
      b((CustomEmotionData)paramList.get(i), 4);
      i += 1;
    }
    a(paramList, 4);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavroamingDBManager
 * JD-Core Version:    0.7.0.1
 */