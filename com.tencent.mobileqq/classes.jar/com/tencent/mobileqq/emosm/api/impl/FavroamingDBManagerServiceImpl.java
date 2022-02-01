package com.tencent.mobileqq.emosm.api.impl;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.FunnyPicHelperConstant;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingDBManagerBase;
import com.tencent.mobileqq.emosm.CustomEmotionRoamingManagerBase;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.api.IVipComicMqqManagerService;
import com.tencent.mobileqq.emosm.control.EmoCaptureAsyncControl;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.FavEmoSendControl;
import com.tencent.mobileqq.emosm.favroaming.FavEmoSendControlConstant;
import com.tencent.mobileqq.emosm.favroaming.ResidParser;
import com.tencent.mobileqq.emosm.vipcomic.VipComicMqqManagerConstants;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.FavoriteEmoticonInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class FavroamingDBManagerServiceImpl
  extends CustomEmotionRoamingDBManagerBase<CustomEmotionData>
  implements IFavroamingDBManagerService<CustomEmotionData>
{
  public static final String TAG = "FavroamingDBManager";
  private boolean hasReportProcessInterrupt;
  
  private CustomEmotionData createCustomEmotionDataByResId(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean)
  {
    CustomEmotionData localCustomEmotionData = null;
    Object localObject1 = localCustomEmotionData;
    if (paramString1 != null)
    {
      localObject1 = localCustomEmotionData;
      if (!TextUtils.isEmpty(paramString2))
      {
        if (this.app == null) {
          return null;
        }
        String str = this.app.getCurrentAccountUin();
        ResidParser localResidParser = new ResidParser(paramString1);
        if (TextUtils.isEmpty(localResidParser.a)) {
          return null;
        }
        Object localObject2 = localResidParser.c;
        localObject1 = localCustomEmotionData;
        if (localObject2 != null)
        {
          if ("".equals(localObject2)) {
            return null;
          }
          localCustomEmotionData = new CustomEmotionData();
          if (((String)localObject2).equals("1"))
          {
            localCustomEmotionData.isMarkFace = true;
            localCustomEmotionData.uin = str;
            localCustomEmotionData.emoPath = localResidParser.e;
            localCustomEmotionData.eId = localResidParser.f;
            localCustomEmotionData.resid = paramString1;
            localCustomEmotionData.RomaingType = paramString3;
            localCustomEmotionData.url = FavEmoConstant.a(paramString1, paramString2, str);
            localCustomEmotionData.emoId = paramInt;
            localCustomEmotionData.isAPNG = paramBoolean;
            localCustomEmotionData.checkMarketFace("createCustomEmotionDataByResId");
          }
          else if (((String)localObject2).equals("0"))
          {
            localObject1 = localResidParser.f;
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              if (((String)localObject1).contains("qto@"))
              {
                localObject1 = ((String)localObject1).replace("qto@", "qto_");
                localCustomEmotionData.eId = ((String)localObject1);
                if (QLog.isColorLevel())
                {
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("download funnyPic name.original->");
                  ((StringBuilder)localObject2).append((String)localObject1);
                  QLog.d("FavroamingDBManager", 2, ((StringBuilder)localObject2).toString());
                }
              }
              else if (((String)localObject1).contains("diydoutu@"))
              {
                localCustomEmotionData.eId = localResidParser.e;
                if (QLog.isColorLevel())
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("download diyemoji name.original->");
                  ((StringBuilder)localObject1).append(paramString1);
                  QLog.d("FavroamingDBManager", 2, ((StringBuilder)localObject1).toString());
                }
              }
            }
            localCustomEmotionData.isMarkFace = false;
            localCustomEmotionData.uin = str;
            localCustomEmotionData.emoPath = FavEmoConstant.a(paramString1);
            localCustomEmotionData.resid = paramString1;
            localCustomEmotionData.md5 = localResidParser.d;
            localCustomEmotionData.url = FavEmoConstant.a(paramString1, paramString2, str);
            localCustomEmotionData.RomaingType = paramString3;
            localCustomEmotionData.emoId = paramInt;
          }
          localObject1 = localCustomEmotionData;
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder();
            paramString2.append("createCustomEmotionDataByResIdList : emotionData = ");
            paramString2.append(localCustomEmotionData);
            paramString2.append(", emotion name:");
            paramString2.append(paramString1);
            QLog.d("FavroamingDBManager", 2, paramString2.toString());
            localObject1 = localCustomEmotionData;
          }
        }
      }
    }
    return localObject1;
  }
  
  private int getMaxEmoId(List<CustomEmotionData> paramList)
  {
    int j = 1;
    int i = 1;
    if (paramList != null)
    {
      paramList = paramList.iterator();
      for (;;)
      {
        j = i;
        if (!paramList.hasNext()) {
          break;
        }
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)paramList.next();
        if (i < localCustomEmotionData.emoId) {
          i = localCustomEmotionData.emoId;
        }
      }
    }
    return j;
  }
  
  private int getUploadSize(List<CustomEmotionData> paramList1, List<CustomEmotionData> paramList2)
  {
    if (paramList1 != null)
    {
      int i = paramList1.size() - 1;
      while (i >= 0)
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)paramList1.get(i);
        if ((localCustomEmotionData != null) && (!paramList2.contains(localCustomEmotionData))) {
          paramList1.remove(i);
        }
        i -= 1;
      }
      return paramList1.size();
    }
    return 0;
  }
  
  private void removeMergeEmoticon(List<String> paramList, String paramString, List<Integer> paramList1, int paramInt, List<CustomEmotionData> paramList2, List<CustomEmotionData> paramList3)
  {
    if (paramList != null)
    {
      List localList = getEmoticonDataList();
      if (localList != null) {
        QLog.d("FavroamingDBManager", 1, new Object[] { "rm emo data tempList: ", Integer.valueOf(localList.size()) });
      }
      int i = paramInt;
      paramInt = 0;
      while (paramInt < paramList.size())
      {
        String str = (String)paramList.get(paramInt);
        CustomEmotionData localCustomEmotionData = getCustomEmotionDataBYResId(localList, str);
        if (localCustomEmotionData == null)
        {
          QLog.d("FavroamingDBManager", 1, "rm emo data create.");
          boolean bool;
          if ((paramList1 != null) && (paramInt <= paramList1.size()))
          {
            if (((Integer)paramList1.get(paramInt)).intValue() == 2) {
              bool = true;
            } else {
              bool = false;
            }
          }
          else {
            bool = false;
          }
          i += 1;
          localCustomEmotionData = createCustomEmotionDataByResId(str, paramString, "needDownload", i, bool);
        }
        else if (paramList2 != null)
        {
          if ("init".equals(localCustomEmotionData.RomaingType)) {
            localCustomEmotionData.RomaingType = "isUpdate";
          }
          if ((TextUtils.isEmpty(localCustomEmotionData.url)) && (this.app != null))
          {
            if (QLog.isColorLevel()) {
              QLog.d("FavroamingDBManager", 2, "url is null because of old db data exception, fix it");
            }
            localCustomEmotionData.url = FavEmoConstant.a(str, paramString, this.app.getCurrentAccountUin());
          }
          paramList2.remove(localCustomEmotionData);
        }
        paramList3.add(localCustomEmotionData);
        paramInt += 1;
      }
    }
    if ((paramList2 != null) && (paramList2.size() > 0))
    {
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("localNew=");
        paramList.append(paramList2.size());
        QLog.d("FavroamingDBManager", 1, paramList.toString());
      }
      paramList3.addAll(paramList2);
    }
  }
  
  private void removeRedundancyEmoticonList(List<String> paramList)
  {
    if (paramList.size() > 0)
    {
      ArrayList localArrayList = new ArrayList();
      List localList = getEmoticonDataList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        CustomEmotionData localCustomEmotionData = getCustomEmotionDataBYResId(localList, (String)paramList.next());
        if (localCustomEmotionData != null) {
          localArrayList.add(localCustomEmotionData);
        }
      }
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("deleDatas=");
        paramList.append(localArrayList.size());
        QLog.d("FavroamingDBManager", 1, paramList.toString());
      }
      deleteCustomEmotionList(localArrayList);
    }
  }
  
  private List<CustomEmotionData> updateCustomEmotionData(List<CustomEmotionData> paramList)
  {
    int k = paramList.size();
    int m = FavEmoConstant.b;
    int j = 0;
    int i = j;
    Object localObject = paramList;
    if (k > m)
    {
      localObject = paramList.subList(0, FavEmoConstant.b);
      i = j;
    }
    while (i < ((List)localObject).size())
    {
      paramList = (CustomEmotionData)((List)localObject).get(i);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("local emo: ");
        localStringBuilder.append(paramList);
        QLog.d("FavroamingDBManager", 2, localStringBuilder.toString());
      }
      if (i <= FavEmoConstant.a)
      {
        if (paramList.RomaingType != null)
        {
          if (paramList.RomaingType.equals("overflow_downloaded")) {
            paramList.RomaingType = "isUpdate";
          } else if ((!paramList.RomaingType.equals("isUpdate")) && (!paramList.RomaingType.equals("init")) && (!paramList.RomaingType.equals("needUpload")) && (!paramList.RomaingType.equals("failed"))) {
            paramList.RomaingType = "needDownload";
          }
        }
        else {
          paramList.RomaingType = "needDownload";
        }
      }
      else if (i <= FavEmoConstant.b) {
        if (paramList.RomaingType != null)
        {
          if (paramList.RomaingType.equals("isUpdate")) {
            paramList.RomaingType = "overflow_downloaded";
          } else if ((!paramList.RomaingType.equals("overflow_downloaded")) && (!paramList.RomaingType.equals("init")) && (!paramList.RomaingType.equals("needUpload")) && (!paramList.RomaingType.equals("failed"))) {
            paramList.RomaingType = "overflow";
          }
        }
        else {
          paramList.RomaingType = "overflow";
        }
      }
      if ((!TextUtils.isEmpty(paramList.url)) && (paramList.url.startsWith("http://"))) {
        paramList.url = paramList.url.replace("http://", "https://");
      }
      i += 1;
    }
    return localObject;
  }
  
  public EmoticonInfo convertEmotionDataToInfo(CustomEmotionData paramCustomEmotionData)
  {
    if (paramCustomEmotionData.isMarkFace)
    {
      localObject1 = new PicEmoticonInfo(this.app.getCurrentAccountUin());
      ((PicEmoticonInfo)localObject1).type = 6;
      localObject2 = paramCustomEmotionData.eId;
      String str = paramCustomEmotionData.emoPath;
      ((PicEmoticonInfo)localObject1).isAPNG = paramCustomEmotionData.isAPNG;
      ((PicEmoticonInfo)localObject1).emoticon = ((IEmoticonManagerService)this.app.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonById(str, (String)localObject2);
      ((PicEmoticonInfo)localObject1).srcType = 2;
      ((PicEmoticonInfo)localObject1).roamingType = paramCustomEmotionData.RomaingType;
      ((PicEmoticonInfo)localObject1).emoId = paramCustomEmotionData.emoId;
      return localObject1;
    }
    Object localObject1 = ((IVipComicMqqManagerService)this.app.getRuntimeService(IVipComicMqqManagerService.class)).getComicStructInfoMap();
    Object localObject2 = new FavoriteEmoticonInfo();
    ((FavoriteEmoticonInfo)localObject2).type = 4;
    ((FavoriteEmoticonInfo)localObject2).path = getCustomEmoticonPath(paramCustomEmotionData);
    ((FavoriteEmoticonInfo)localObject2).srcType = 2;
    ((FavoriteEmoticonInfo)localObject2).eId = paramCustomEmotionData.eId;
    ((FavoriteEmoticonInfo)localObject2).url = paramCustomEmotionData.url;
    if (localObject1 != null) {
      ((FavoriteEmoticonInfo)localObject2).actionData = VipComicMqqManagerConstants.a((Map)localObject1, paramCustomEmotionData.md5);
    }
    ((FavoriteEmoticonInfo)localObject2).roamingType = paramCustomEmotionData.RomaingType;
    ((FavoriteEmoticonInfo)localObject2).emoId = paramCustomEmotionData.emoId;
    ((FavoriteEmoticonInfo)localObject2).resID = paramCustomEmotionData.resid;
    return localObject2;
  }
  
  public void delOverflow(List<CustomEmotionData> paramList)
  {
    if (paramList == null) {
      return;
    }
    deleteCustomEmotionList(paramList);
  }
  
  public void deleteDB(List<String> paramList)
  {
    if (paramList == null) {
      return;
    }
    List localList = getEmoticonDatasByType("needDel");
    if (localList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      String str = (String)paramList.get(i);
      int j = 0;
      while (j < localList.size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(j);
        if ((localCustomEmotionData.resid != null) && (!"".equals(localCustomEmotionData.resid)) && (localCustomEmotionData.resid.equals(str)))
        {
          updateCache(localCustomEmotionData, 4);
          localArrayList.add(localCustomEmotionData);
        }
        j += 1;
      }
      i += 1;
    }
    updateCustomEmotionDataListInDB(localArrayList, 4);
  }
  
  public String getCustomEmoticonPath(CustomEmotionData paramCustomEmotionData)
  {
    if (paramCustomEmotionData == null) {
      return "";
    }
    if (!TextUtils.isEmpty(paramCustomEmotionData.emoPath)) {
      return paramCustomEmotionData.emoPath;
    }
    String str = AppConstants.SDCARD_IMG_FAVORITE;
    Object localObject = (IVipComicMqqManagerService)this.app.getRuntimeService(IVipComicMqqManagerService.class, "");
    if ((localObject != null) && (((IVipComicMqqManagerService)localObject).isComicEmoticon(paramCustomEmotionData)))
    {
      if ((!TextUtils.isEmpty(paramCustomEmotionData.emoPath)) && (paramCustomEmotionData.emoPath.startsWith(AppConstants.SDCARD_IMG_FAVORITE))) {
        return paramCustomEmotionData.emoPath;
      }
      if (!TextUtils.isEmpty(paramCustomEmotionData.md5)) {
        return ((IVipComicMqqManagerService)localObject).getFilePath(paramCustomEmotionData.md5);
      }
      if (!TextUtils.isEmpty(paramCustomEmotionData.resid))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(DiySecureFileHelper.a(paramCustomEmotionData.resid));
        return ((StringBuilder)localObject).toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(paramCustomEmotionData.url.substring(paramCustomEmotionData.url.lastIndexOf("/") + 1));
      return ((StringBuilder)localObject).toString();
    }
    if ((paramCustomEmotionData.url != null) && (paramCustomEmotionData.url.contains("qto_")))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(FunnyPicHelperConstant.a(paramCustomEmotionData.url));
      return ((StringBuilder)localObject).toString();
    }
    if (!TextUtils.isEmpty(FunnyPicHelperConstant.a(paramCustomEmotionData.eId)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(paramCustomEmotionData.eId);
      str = ((StringBuilder)localObject).toString();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("emotion is FunnyPic path download from server->");
        ((StringBuilder)localObject).append(paramCustomEmotionData.eId);
        QLog.d("FavroamingDBManager", 2, ((StringBuilder)localObject).toString());
      }
      return str;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(paramCustomEmotionData.resid);
    return ((StringBuilder)localObject).toString();
  }
  
  public CustomEmotionData getCustomEmotionDataBYResId(List<CustomEmotionData> paramList, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("FavroamingDBManager", 1, "fav custom data resId is empty.");
      return null;
    }
    if (paramList != null)
    {
      if (paramList.size() < 1) {
        return null;
      }
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)paramList.get(i);
        Object localObject1;
        boolean bool;
        if ((localCustomEmotionData != null) && ((localCustomEmotionData.RomaingType == null) || (!localCustomEmotionData.RomaingType.equals("needUpload"))) && ((localCustomEmotionData.RomaingType == null) || (!localCustomEmotionData.RomaingType.equals("failed"))))
        {
          if ((TextUtils.isEmpty(localCustomEmotionData.resid)) || (!localCustomEmotionData.resid.equals(paramString)))
          {
            Object localObject2 = new ResidParser(paramString);
            if (!((ResidParser)localObject2).a())
            {
              QLog.e("FavroamingDBManager", 1, new Object[] { "res id is not valid:", paramString });
              return null;
            }
            if (localCustomEmotionData.isMarkFace)
            {
              localObject1 = ((ResidParser)localObject2).e;
              localObject2 = ((ResidParser)localObject2).f;
              if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
              {
                if ((!((String)localObject1).equals(localCustomEmotionData.emoPath)) || (!((String)localObject2).equals(localCustomEmotionData.eId))) {
                  break label528;
                }
                localCustomEmotionData.resid = paramString;
              }
              else
              {
                QLog.d("FavroamingDBManager", 1, new Object[] { "epId is: ", Boolean.valueOf(TextUtils.isEmpty((CharSequence)localObject1)), " eid is: ", Boolean.valueOf(TextUtils.isEmpty((CharSequence)localObject2)) });
                break label528;
              }
            }
            else
            {
              localObject2 = ((ResidParser)localObject2).d;
              if (TextUtils.isEmpty((CharSequence)localObject2))
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("md5 id is empty. md5:");
                if (localObject2 == null) {
                  bool = true;
                } else {
                  bool = false;
                }
                ((StringBuilder)localObject1).append(bool);
                QLog.d("FavroamingDBManager", 1, ((StringBuilder)localObject1).toString());
                break label528;
              }
              if (!TextUtils.isEmpty(localCustomEmotionData.md5)) {
                localObject1 = localCustomEmotionData.md5;
              } else {
                localObject1 = HexUtil.bytes2HexStr(MD5.getFileMd5(localCustomEmotionData.emoPath));
              }
              localCustomEmotionData.md5 = ((String)localObject1);
              if (!((String)localObject2).equals(localObject1)) {
                break label528;
              }
              localCustomEmotionData.resid = paramString;
            }
          }
          return localCustomEmotionData;
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("fav custom data emotionData: ");
          if (localCustomEmotionData == null) {
            bool = true;
          } else {
            bool = false;
          }
          ((StringBuilder)localObject1).append(bool);
          QLog.d("FavroamingDBManager", 1, ((StringBuilder)localObject1).toString());
          if (localCustomEmotionData != null)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("fav custom data emotionData type: ");
            ((StringBuilder)localObject1).append(localCustomEmotionData.RomaingType);
            QLog.d("FavroamingDBManager", 1, ((StringBuilder)localObject1).toString());
          }
        }
        label528:
        i += 1;
      }
    }
    return null;
  }
  
  public Class getDBClass()
  {
    return CustomEmotionData.class;
  }
  
  public List<CustomEmotionData> getEmoticonDataList()
  {
    try
    {
      Object localObject1 = new ArrayList();
      if (this.customEmotionDbCache.size() > 0)
      {
        Object localObject3 = this.customEmotionDbCache.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          CustomEmotionData localCustomEmotionData = (CustomEmotionData)((Iterator)localObject3).next();
          if (localCustomEmotionData != null) {
            ((List)localObject1).add(localCustomEmotionData);
          }
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("getEmoticonDataList from cache: data size = ");
          ((StringBuilder)localObject3).append(((List)localObject1).size());
          QLog.d("FavroamingDBManager", 2, ((StringBuilder)localObject3).toString());
        }
        return localObject1;
      }
      localObject1 = getEmoticonDataListFromDB();
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  /* Error */
  public List<CustomEmotionData> getEmoticonDataListFromDB()
  {
    // Byte code:
    //   0: new 250	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 251	java/util/ArrayList:<init>	()V
    //   7: astore 8
    //   9: aload_0
    //   10: getfield 30	com/tencent/mobileqq/emosm/api/impl/FavroamingDBManagerServiceImpl:app	Lcom/tencent/common/app/business/BaseQQAppInterface;
    //   13: ifnonnull +6 -> 19
    //   16: aload 8
    //   18: areturn
    //   19: aload_0
    //   20: getfield 30	com/tencent/mobileqq/emosm/api/impl/FavroamingDBManagerServiceImpl:app	Lcom/tencent/common/app/business/BaseQQAppInterface;
    //   23: invokevirtual 468	com/tencent/common/app/business/BaseQQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   26: invokevirtual 474	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   29: astore 11
    //   31: iconst_0
    //   32: istore 7
    //   34: iconst_0
    //   35: istore 6
    //   37: aload 11
    //   39: ifnull +515 -> 554
    //   42: aload 11
    //   44: aload_0
    //   45: invokevirtual 476	com/tencent/mobileqq/emosm/api/impl/FavroamingDBManagerServiceImpl:getDBClass	()Ljava/lang/Class;
    //   48: iconst_0
    //   49: aconst_null
    //   50: aconst_null
    //   51: aconst_null
    //   52: aconst_null
    //   53: aconst_null
    //   54: aconst_null
    //   55: invokevirtual 482	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   58: astore 9
    //   60: ldc_w 484
    //   63: aload_0
    //   64: getfield 30	com/tencent/mobileqq/emosm/api/impl/FavroamingDBManagerServiceImpl:app	Lcom/tencent/common/app/business/BaseQQAppInterface;
    //   67: invokevirtual 487	com/tencent/common/app/business/BaseQQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   70: invokestatic 490	com/tencent/mobileqq/app/utils/DiySecureFileHelper:a	(Ljava/lang/String;Ljava/lang/String;)I
    //   73: iconst_1
    //   74: if_icmpge +471 -> 545
    //   77: aload 11
    //   79: invokevirtual 494	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   82: astore 10
    //   84: aload 9
    //   86: ifnonnull +8 -> 94
    //   89: iconst_0
    //   90: istore_1
    //   91: goto +11 -> 102
    //   94: aload 9
    //   96: invokeinterface 183 1 0
    //   101: istore_1
    //   102: iload_1
    //   103: iconst_1
    //   104: isub
    //   105: istore 5
    //   107: iconst_0
    //   108: istore_1
    //   109: iload 5
    //   111: iconst_m1
    //   112: if_icmple +351 -> 463
    //   115: iload_1
    //   116: istore_2
    //   117: iload_1
    //   118: istore 4
    //   120: aload 9
    //   122: iload 5
    //   124: invokeinterface 187 2 0
    //   129: checkcast 57	com/tencent/mobileqq/data/CustomEmotionData
    //   132: astore 8
    //   134: iload_1
    //   135: istore_2
    //   136: iload_1
    //   137: istore 4
    //   139: aload 8
    //   141: getfield 72	com/tencent/mobileqq/data/CustomEmotionData:emoPath	Ljava/lang/String;
    //   144: astore 12
    //   146: iload_1
    //   147: istore_2
    //   148: iload_1
    //   149: istore 4
    //   151: new 125	java/lang/StringBuilder
    //   154: dup
    //   155: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   158: astore 13
    //   160: iload_1
    //   161: istore_2
    //   162: iload_1
    //   163: istore 4
    //   165: aload 13
    //   167: getstatic 380	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_FAVORITE	Ljava/lang/String;
    //   170: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: iload_1
    //   175: istore_2
    //   176: iload_1
    //   177: istore 4
    //   179: aload 13
    //   181: aload 8
    //   183: getfield 81	com/tencent/mobileqq/data/CustomEmotionData:resid	Ljava/lang/String;
    //   186: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: iload_1
    //   191: istore_2
    //   192: iload_1
    //   193: istore 4
    //   195: aload 12
    //   197: aload 13
    //   199: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   202: invokevirtual 55	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   205: ifeq +99 -> 304
    //   208: iload_1
    //   209: istore_2
    //   210: iload_1
    //   211: istore 4
    //   213: new 125	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   220: astore 12
    //   222: iload_1
    //   223: istore_2
    //   224: iload_1
    //   225: istore 4
    //   227: aload 12
    //   229: getstatic 380	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_FAVORITE	Ljava/lang/String;
    //   232: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: pop
    //   236: iload_1
    //   237: istore_2
    //   238: iload_1
    //   239: istore 4
    //   241: aload 12
    //   243: aload 8
    //   245: getfield 81	com/tencent/mobileqq/data/CustomEmotionData:resid	Ljava/lang/String;
    //   248: invokestatic 393	com/tencent/mobileqq/app/utils/DiySecureFileHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   251: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: pop
    //   255: iload_1
    //   256: istore_2
    //   257: iload_1
    //   258: istore 4
    //   260: aload 8
    //   262: aload 12
    //   264: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: putfield 72	com/tencent/mobileqq/data/CustomEmotionData:emoPath	Ljava/lang/String;
    //   270: iload_1
    //   271: istore_3
    //   272: iload_1
    //   273: ifne +15 -> 288
    //   276: iload_1
    //   277: istore_2
    //   278: iload_1
    //   279: istore 4
    //   281: aload 10
    //   283: invokevirtual 499	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   286: iconst_1
    //   287: istore_3
    //   288: iload_3
    //   289: istore_2
    //   290: iload_3
    //   291: istore 4
    //   293: aload 11
    //   295: aload 8
    //   297: invokevirtual 503	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   300: pop
    //   301: goto +495 -> 796
    //   304: iload_1
    //   305: istore_2
    //   306: iload_1
    //   307: istore 4
    //   309: aload 8
    //   311: getfield 72	com/tencent/mobileqq/data/CustomEmotionData:emoPath	Ljava/lang/String;
    //   314: astore 12
    //   316: iload_1
    //   317: istore_2
    //   318: iload_1
    //   319: istore 4
    //   321: new 125	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   328: astore 13
    //   330: iload_1
    //   331: istore_2
    //   332: iload_1
    //   333: istore 4
    //   335: aload 13
    //   337: getstatic 380	com/tencent/mobileqq/app/AppConstants:SDCARD_IMG_FAVORITE	Ljava/lang/String;
    //   340: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: iload_1
    //   345: istore_2
    //   346: iload_1
    //   347: istore 4
    //   349: aload 13
    //   351: aload 8
    //   353: getfield 66	com/tencent/mobileqq/data/CustomEmotionData:uin	Ljava/lang/String;
    //   356: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: pop
    //   360: iload_1
    //   361: istore_2
    //   362: iload_1
    //   363: istore 4
    //   365: aload 13
    //   367: ldc_w 505
    //   370: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: iload_1
    //   375: istore_2
    //   376: iload_1
    //   377: istore 4
    //   379: aload 12
    //   381: aload 13
    //   383: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokevirtual 508	java/lang/String:matches	(Ljava/lang/String;)Z
    //   389: ifeq +397 -> 786
    //   392: iload_1
    //   393: istore_2
    //   394: iload_1
    //   395: istore 4
    //   397: aload 8
    //   399: getfield 66	com/tencent/mobileqq/data/CustomEmotionData:uin	Ljava/lang/String;
    //   402: astore 12
    //   404: iload_1
    //   405: istore_2
    //   406: iload_1
    //   407: istore 4
    //   409: aload 8
    //   411: aload 8
    //   413: getfield 72	com/tencent/mobileqq/data/CustomEmotionData:emoPath	Ljava/lang/String;
    //   416: aload 12
    //   418: aload 12
    //   420: invokestatic 393	com/tencent/mobileqq/app/utils/DiySecureFileHelper:a	(Ljava/lang/String;)Ljava/lang/String;
    //   423: invokevirtual 117	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   426: putfield 72	com/tencent/mobileqq/data/CustomEmotionData:emoPath	Ljava/lang/String;
    //   429: iload_1
    //   430: istore_3
    //   431: iload_1
    //   432: ifne +15 -> 447
    //   435: iload_1
    //   436: istore_2
    //   437: iload_1
    //   438: istore 4
    //   440: aload 10
    //   442: invokevirtual 499	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   445: iconst_1
    //   446: istore_3
    //   447: iload_3
    //   448: istore_2
    //   449: iload_3
    //   450: istore 4
    //   452: aload 11
    //   454: aload 8
    //   456: invokevirtual 503	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   459: pop
    //   460: goto +336 -> 796
    //   463: iload_1
    //   464: ifeq +13 -> 477
    //   467: iload_1
    //   468: istore_2
    //   469: iload_1
    //   470: istore 4
    //   472: aload 10
    //   474: invokevirtual 511	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   477: iload_1
    //   478: ifeq +36 -> 514
    //   481: goto +28 -> 509
    //   484: astore 8
    //   486: iconst_0
    //   487: istore_2
    //   488: goto +45 -> 533
    //   491: astore 8
    //   493: iconst_0
    //   494: istore 4
    //   496: iload 4
    //   498: istore_2
    //   499: aload 8
    //   501: invokevirtual 514	java/lang/Exception:printStackTrace	()V
    //   504: iload 4
    //   506: ifeq +8 -> 514
    //   509: aload 10
    //   511: invokevirtual 517	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   514: ldc_w 484
    //   517: aload_0
    //   518: getfield 30	com/tencent/mobileqq/emosm/api/impl/FavroamingDBManagerServiceImpl:app	Lcom/tencent/common/app/business/BaseQQAppInterface;
    //   521: invokevirtual 487	com/tencent/common/app/business/BaseQQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   524: iconst_1
    //   525: invokestatic 520	com/tencent/mobileqq/app/utils/DiySecureFileHelper:a	(Ljava/lang/String;Ljava/lang/String;I)V
    //   528: goto +17 -> 545
    //   531: astore 8
    //   533: iload_2
    //   534: ifeq +8 -> 542
    //   537: aload 10
    //   539: invokevirtual 517	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   542: aload 8
    //   544: athrow
    //   545: aload 11
    //   547: invokevirtual 523	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   550: aload 9
    //   552: astore 8
    //   554: iload 7
    //   556: istore_2
    //   557: aload 8
    //   559: ifnull +143 -> 702
    //   562: iload 7
    //   564: istore_2
    //   565: aload 8
    //   567: invokeinterface 183 1 0
    //   572: ifle +130 -> 702
    //   575: new 250	java/util/ArrayList
    //   578: dup
    //   579: invokespecial 251	java/util/ArrayList:<init>	()V
    //   582: astore 9
    //   584: aload 8
    //   586: invokeinterface 166 1 0
    //   591: astore 10
    //   593: iload 6
    //   595: istore_1
    //   596: iload_1
    //   597: istore_2
    //   598: aload 10
    //   600: invokeinterface 171 1 0
    //   605: ifeq +97 -> 702
    //   608: aload 10
    //   610: invokeinterface 175 1 0
    //   615: checkcast 57	com/tencent/mobileqq/data/CustomEmotionData
    //   618: astore 11
    //   620: aload 11
    //   622: getfield 84	com/tencent/mobileqq/data/CustomEmotionData:RomaingType	Ljava/lang/String;
    //   625: invokestatic 26	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   628: ifeq +25 -> 653
    //   631: aload 11
    //   633: ldc 227
    //   635: putfield 84	com/tencent/mobileqq/data/CustomEmotionData:RomaingType	Ljava/lang/String;
    //   638: aload 9
    //   640: aload 11
    //   642: invokeinterface 236 2 0
    //   647: pop
    //   648: iconst_1
    //   649: istore_1
    //   650: goto +42 -> 692
    //   653: aload 11
    //   655: getfield 84	com/tencent/mobileqq/data/CustomEmotionData:RomaingType	Ljava/lang/String;
    //   658: ldc_w 274
    //   661: invokevirtual 55	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   664: ifeq +28 -> 692
    //   667: aload 11
    //   669: ldc_w 276
    //   672: putfield 84	com/tencent/mobileqq/data/CustomEmotionData:RomaingType	Ljava/lang/String;
    //   675: aload 9
    //   677: aload 11
    //   679: invokeinterface 236 2 0
    //   684: pop
    //   685: aload_0
    //   686: invokevirtual 526	com/tencent/mobileqq/emosm/api/impl/FavroamingDBManagerServiceImpl:reportProcessInterruptError	()V
    //   689: goto -41 -> 648
    //   692: aload_0
    //   693: aload 11
    //   695: iconst_1
    //   696: invokevirtual 370	com/tencent/mobileqq/emosm/api/impl/FavroamingDBManagerServiceImpl:updateCache	(Lcom/tencent/mobileqq/data/CustomEmotionData;I)V
    //   699: goto -103 -> 596
    //   702: aload_0
    //   703: invokevirtual 529	com/tencent/mobileqq/emosm/api/impl/FavroamingDBManagerServiceImpl:trimCache	()V
    //   706: iload_2
    //   707: ifeq +10 -> 717
    //   710: aload_0
    //   711: aload 8
    //   713: iconst_2
    //   714: invokevirtual 374	com/tencent/mobileqq/emosm/api/impl/FavroamingDBManagerServiceImpl:updateCustomEmotionDataListInDB	(Ljava/util/List;I)V
    //   717: aload 8
    //   719: astore 9
    //   721: aload 8
    //   723: ifnonnull +12 -> 735
    //   726: new 250	java/util/ArrayList
    //   729: dup
    //   730: invokespecial 251	java/util/ArrayList:<init>	()V
    //   733: astore 9
    //   735: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   738: ifeq +45 -> 783
    //   741: new 125	java/lang/StringBuilder
    //   744: dup
    //   745: invokespecial 126	java/lang/StringBuilder:<init>	()V
    //   748: astore 8
    //   750: aload 8
    //   752: ldc_w 531
    //   755: invokevirtual 132	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: pop
    //   759: aload 8
    //   761: aload 9
    //   763: invokeinterface 183 1 0
    //   768: invokevirtual 241	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   771: pop
    //   772: ldc 11
    //   774: iconst_2
    //   775: aload 8
    //   777: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   780: invokestatic 139	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   783: aload 9
    //   785: areturn
    //   786: iload_1
    //   787: istore_3
    //   788: iload 5
    //   790: ifne +6 -> 796
    //   793: goto -330 -> 463
    //   796: iload 5
    //   798: iconst_1
    //   799: isub
    //   800: istore 5
    //   802: iload_3
    //   803: istore_1
    //   804: goto -695 -> 109
    //   807: astore 8
    //   809: goto -313 -> 496
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	812	0	this	FavroamingDBManagerServiceImpl
    //   90	714	1	i	int
    //   116	591	2	j	int
    //   271	532	3	k	int
    //   118	387	4	m	int
    //   105	696	5	n	int
    //   35	559	6	i1	int
    //   32	531	7	i2	int
    //   7	448	8	localObject1	Object
    //   484	1	8	localObject2	Object
    //   491	9	8	localException1	java.lang.Exception
    //   531	12	8	localObject3	Object
    //   552	224	8	localObject4	Object
    //   807	1	8	localException2	java.lang.Exception
    //   58	726	9	localObject5	Object
    //   82	527	10	localObject6	Object
    //   29	665	11	localObject7	Object
    //   144	275	12	localObject8	Object
    //   158	224	13	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   94	102	484	finally
    //   94	102	491	java/lang/Exception
    //   120	134	531	finally
    //   139	146	531	finally
    //   151	160	531	finally
    //   165	174	531	finally
    //   179	190	531	finally
    //   195	208	531	finally
    //   213	222	531	finally
    //   227	236	531	finally
    //   241	255	531	finally
    //   260	270	531	finally
    //   281	286	531	finally
    //   293	301	531	finally
    //   309	316	531	finally
    //   321	330	531	finally
    //   335	344	531	finally
    //   349	360	531	finally
    //   365	374	531	finally
    //   379	392	531	finally
    //   397	404	531	finally
    //   409	429	531	finally
    //   440	445	531	finally
    //   452	460	531	finally
    //   472	477	531	finally
    //   499	504	531	finally
    //   120	134	807	java/lang/Exception
    //   139	146	807	java/lang/Exception
    //   151	160	807	java/lang/Exception
    //   165	174	807	java/lang/Exception
    //   179	190	807	java/lang/Exception
    //   195	208	807	java/lang/Exception
    //   213	222	807	java/lang/Exception
    //   227	236	807	java/lang/Exception
    //   241	255	807	java/lang/Exception
    //   260	270	807	java/lang/Exception
    //   281	286	807	java/lang/Exception
    //   293	301	807	java/lang/Exception
    //   309	316	807	java/lang/Exception
    //   321	330	807	java/lang/Exception
    //   335	344	807	java/lang/Exception
    //   349	360	807	java/lang/Exception
    //   365	374	807	java/lang/Exception
    //   379	392	807	java/lang/Exception
    //   397	404	807	java/lang/Exception
    //   409	429	807	java/lang/Exception
    //   440	445	807	java/lang/Exception
    //   452	460	807	java/lang/Exception
    //   472	477	807	java/lang/Exception
  }
  
  public List<String> getLocalFavDataNotInServer(List<String> paramList1, List<String> paramList2)
  {
    if ((paramList1 == null) && (paramList2 == null)) {
      return null;
    }
    if ((paramList1 != null) && (paramList1.size() < 1)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (paramList1 != null) {
      localArrayList.addAll(paramList1);
    }
    if (paramList2 != null) {
      localArrayList.addAll(paramList2);
    }
    paramList2 = getCustomEmoticonResIdsByType("isUpdate");
    if (paramList2 == null) {
      return null;
    }
    paramList1 = new ArrayList();
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      String str = (String)paramList2.next();
      if (!localArrayList.contains(str)) {
        paramList1.add(str);
      }
    }
    return paramList1;
  }
  
  public CustomEmotionRoamingManagerBase<CustomEmotionData> getRoamingManager()
  {
    return (CustomEmotionRoamingManagerBase)this.app.getRuntimeService(IFavroamingManagerService.class);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    FavEmoSendControl.a.a();
  }
  
  public void reportProcessInterruptError()
  {
    if (!this.hasReportProcessInterrupt)
    {
      this.hasReportProcessInterrupt = true;
      FavEmoSendControlConstant.a(false, 8, 0);
    }
  }
  
  public List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPanel()
  {
    StartupTracker.a("AIO_EmoticonPanel_Refresh", null);
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from getFavEmotionInfoShowedInPanel.");
    }
    Object localObject1 = getEmoticonDataList();
    ArrayList localArrayList = new ArrayList();
    if (localObject1 != null) {}
    try
    {
      int i = ((List)localObject1).size() - 1;
      while (i >= 0)
      {
        Object localObject2 = (CustomEmotionData)((List)localObject1).get(i);
        Object localObject3;
        if ("needDel".equals(((CustomEmotionData)localObject2).RomaingType))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("data need delete, do not need display -> resId:");
          ((StringBuilder)localObject3).append(((CustomEmotionData)localObject2).resid);
          QLog.d("FavroamingDBManager", 1, ((StringBuilder)localObject3).toString());
        }
        else
        {
          localObject3 = convertEmotionDataToInfo((CustomEmotionData)localObject2);
          if ((localObject3 instanceof PicEmoticonInfo))
          {
            localObject3 = (PicEmoticonInfo)localObject3;
            if (((PicEmoticonInfo)localObject3).emoticon != null)
            {
              localArrayList.add(localObject3);
            }
            else
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("PicEmoticonInfo.emoticon is null, ");
              ((StringBuilder)localObject3).append(((CustomEmotionData)localObject2).toString());
              QLog.e("FavroamingDBManager", 1, ((StringBuilder)localObject3).toString());
            }
          }
          else if ((localObject3 instanceof FavoriteEmoticonInfo))
          {
            localObject2 = (FavoriteEmoticonInfo)localObject3;
            if ((TextUtils.isEmpty(((FavoriteEmoticonInfo)localObject2).path)) && (TextUtils.isEmpty(((FavoriteEmoticonInfo)localObject2).url)))
            {
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("path and url is null! ");
              ((StringBuilder)localObject3).append(((FavoriteEmoticonInfo)localObject2).toString());
              QLog.e("FavroamingDBManager", 1, ((StringBuilder)localObject3).toString());
            }
            else
            {
              localArrayList.add(localObject2);
            }
          }
        }
        i -= 1;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label303:
      break label303;
    }
    QLog.e("FavroamingDBManager", 1, "syncGetCustomEmotionInfoShowedInPanel oom");
    StartupTracker.a(null, "AIO_EmoticonPanel_Refresh");
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getFavEmotionInfoShowedInPanel, display size:");
      ((StringBuilder)localObject1).append(localArrayList.size());
      QLog.d("FavroamingDBManager", 2, ((StringBuilder)localObject1).toString());
    }
    return localArrayList;
  }
  
  public List<EmoticonInfo> syncGetCustomEmotionInfoShowedInPreview()
  {
    Object localObject1 = ((IVipComicMqqManagerService)this.app.getRuntimeService(IVipComicMqqManagerService.class, "")).getComicStructInfoMap();
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from syncGetCustomEmotionInfoShowedInPreview.");
    }
    List localList = getEmoticonDataList();
    ArrayList localArrayList = new ArrayList();
    if (localList != null) {}
    try
    {
      int i = localList.size() - 1;
      while (i >= 0)
      {
        Object localObject2 = (CustomEmotionData)localList.get(i);
        Object localObject3;
        if (!"isUpdate".equals(((CustomEmotionData)localObject2).RomaingType))
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("data need hidden, do not need display -> resId:");
          ((StringBuilder)localObject3).append(((CustomEmotionData)localObject2).resid);
          QLog.d("FavroamingDBManager", 1, ((StringBuilder)localObject3).toString());
        }
        else if (((CustomEmotionData)localObject2).isMarkFace)
        {
          localObject3 = new PicEmoticonInfo(this.app.getCurrentAccountUin());
          ((PicEmoticonInfo)localObject3).type = 6;
          String str1 = ((CustomEmotionData)localObject2).eId;
          String str2 = ((CustomEmotionData)localObject2).emoPath;
          ((PicEmoticonInfo)localObject3).isAPNG = ((CustomEmotionData)localObject2).isAPNG;
          ((PicEmoticonInfo)localObject3).emoticon = ((IEmoticonManagerService)this.app.getRuntimeService(IEmoticonManagerService.class)).syncFindEmoticonById(str2, str1);
          ((PicEmoticonInfo)localObject3).srcType = 2;
          if (((PicEmoticonInfo)localObject3).emoticon != null)
          {
            localArrayList.add(localObject3);
          }
          else
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("PicEmoticonInfo.emoticon is null, ");
            ((StringBuilder)localObject3).append(((CustomEmotionData)localObject2).toString());
            QLog.e("FavroamingDBManager", 1, ((StringBuilder)localObject3).toString());
          }
        }
        else
        {
          localObject3 = new FavoriteEmoticonInfo();
          ((FavoriteEmoticonInfo)localObject3).type = 4;
          ((FavoriteEmoticonInfo)localObject3).path = getCustomEmoticonPath((CustomEmotionData)localObject2);
          ((FavoriteEmoticonInfo)localObject3).srcType = 2;
          ((FavoriteEmoticonInfo)localObject3).eId = ((CustomEmotionData)localObject2).eId;
          ((FavoriteEmoticonInfo)localObject3).url = ((CustomEmotionData)localObject2).url;
          ((FavoriteEmoticonInfo)localObject3).actionData = VipComicMqqManagerConstants.a((Map)localObject1, ((CustomEmotionData)localObject2).md5);
          ((FavoriteEmoticonInfo)localObject3).roamingType = ((CustomEmotionData)localObject2).RomaingType;
          ((FavoriteEmoticonInfo)localObject3).emoId = ((CustomEmotionData)localObject2).emoId;
          ((FavoriteEmoticonInfo)localObject3).resID = ((CustomEmotionData)localObject2).resid;
          if ((TextUtils.isEmpty(((FavoriteEmoticonInfo)localObject3).path)) && (TextUtils.isEmpty(((FavoriteEmoticonInfo)localObject3).url)))
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("path and url is null! ");
            ((StringBuilder)localObject2).append(((FavoriteEmoticonInfo)localObject3).toString());
            QLog.e("FavroamingDBManager", 1, ((StringBuilder)localObject2).toString());
          }
          else
          {
            localArrayList.add(localObject3);
          }
        }
        i -= 1;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label466:
      break label466;
    }
    QLog.e("FavroamingDBManager", 1, "syncGetCustomEmotionInfoShowedInPreview oom");
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("syncGetCustomEmotionInfoShowedInPreview, display size:");
      ((StringBuilder)localObject1).append(localArrayList.size());
      QLog.d("FavroamingDBManager", 2, ((StringBuilder)localObject1).toString());
    }
    return localArrayList;
  }
  
  public void updateCache(CustomEmotionData paramCustomEmotionData, int paramInt)
  {
    super.updateCache(paramCustomEmotionData, paramInt);
  }
  
  public void updateCustomEmotionDataListInDB(List<CustomEmotionData> paramList, int paramInt)
  {
    super.updateCustomEmotionDataListInDB(paramList, paramInt);
  }
  
  public boolean updateDeletedEmoticon(CustomEmotionData paramCustomEmotionData, int paramInt)
  {
    if (paramCustomEmotionData == null) {
      return false;
    }
    if ("needDel".equals(paramCustomEmotionData.RomaingType))
    {
      if (paramInt <= FavEmoConstant.a) {
        localObject = "isUpdate";
      } else {
        localObject = "overflow_downloaded";
      }
      paramCustomEmotionData.RomaingType = ((String)localObject);
      updateCustomEmotion(paramCustomEmotionData);
      Object localObject = (IFavroamingManagerService)this.app.getRuntimeService(IFavroamingManagerService.class, "");
      if (localObject != null) {
        ((IFavroamingManagerService)localObject).syncUpload(paramCustomEmotionData);
      }
      return true;
    }
    return false;
  }
  
  public List<CustomEmotionData> updateFavEmotionsInLocalEx(List<String> paramList1, List<String> paramList2, String paramString, List<Integer> paramList)
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      List localList = getLocalFavDataNotInServer(paramList1, paramList2);
      int i = 0;
      if ((localList != null) && (localList.size() > 0))
      {
        localArrayList.addAll(localList);
        QLog.d("FavroamingDBManager", 1, new Object[] { "localUpdatedNotInServerList= ", Integer.valueOf(localList.size()) });
      }
      if ((paramList1 != null) && (paramList1.size() > 0)) {
        localArrayList.addAll(paramList1);
      }
      if (QLog.isColorLevel()) {
        QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateFavEmotionsInLocalEx-1.");
      }
      removeRedundancyEmoticonList(localArrayList);
      if (QLog.isColorLevel()) {
        QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateFavEmotionsInLocalEx-2.");
      }
      paramList1 = getEmoticonDataList();
      int j = getMaxEmoId(paramList1);
      if (QLog.isColorLevel()) {
        QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateFavEmotionsInLocalEx-3.");
      }
      localArrayList = new ArrayList();
      removeMergeEmoticon(paramList2, paramString, paramList, j, paramList1, localArrayList);
      QLog.d("FavroamingDBManager", 1, new Object[] { "mergeSize= ", Integer.valueOf(localArrayList.size()) });
      paramList2 = updateCustomEmotionData(localArrayList);
      QLog.d("FavroamingDBManager", 1, new Object[] { "updateSize= ", Integer.valueOf(paramList2.size()) });
      if (QLog.isColorLevel()) {
        QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateFavEmotionsInLocalEx-4.");
      }
      paramString = getEmoticonDataList();
      if (paramString != null)
      {
        i = paramString.size();
        deleteCustomEmotionList(paramString);
      }
      this.customEmotionDbCache.clear();
      this.customEmotionDbCache.addAll(paramList2);
      updateCustomEmotionDataListInDB(paramList2, 1);
      if (QLog.isColorLevel()) {
        QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateFavEmotionsInLocalEx-4.");
      }
      paramString = (FavEmoRoamingHandler)this.app.getBusinessHandler(FavEmoRoamingHandler.a);
      if (paramList2.size() > 0) {
        paramString.a(paramList2, 2);
      }
      j = getUploadSize(paramList1, paramList2);
      paramString = new StringBuilder();
      paramString.append("updateFavEmotionsInLocalEx final cache size: ");
      paramString.append(paramList2.size());
      paramString.append(",delete size:");
      paramString.append(i);
      paramString.append(",upload size:");
      paramString.append(j);
      QLog.d("FavroamingDBManager", 1, paramString.toString());
      return paramList1;
    }
    finally {}
  }
  
  public CustomEmotionData updateUpload(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FavroamingDBManager", 2, "Call getEmoticonDataList from updateUpload.");
    }
    CustomEmotionData localCustomEmotionData = getCustomEmotionDataBYResId(getEmoticonDataList(), paramString);
    if (localCustomEmotionData != null)
    {
      localCustomEmotionData.resid = paramString;
      localCustomEmotionData.RomaingType = "isUpdate";
      updateCustomEmotion(localCustomEmotionData);
    }
    return localCustomEmotionData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.FavroamingDBManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */