package com.tencent.mobileqq.emosm.api.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.im.msg.hummer.resv12.MarketFaceExtPb.ResvAttr;
import com.tencent.im.msg.hummer.resv12.MarketFaceExtPb.SupportSize;
import com.tencent.mobileqq.EmotionUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecEmoticon;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecLocalData;
import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.SVIPObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.core.util.EmotionSharedPreUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonKeywords;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.EmoticonResp;
import com.tencent.mobileqq.data.EmoticonTab;
import com.tencent.mobileqq.data.EmotionKeyword;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.PromotionEmoticonPkg;
import com.tencent.mobileqq.data.RecentEmotion;
import com.tencent.mobileqq.data.VipIPSiteInfo;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.EmoticonManagerConstants;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import com.tencent.mobileqq.emoticonview.QueryTask;
import com.tencent.mobileqq.emoticonview.ipc.QQEmoticonMainPanelApp;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandlerProxy;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.pb.emosm.EmosmPb.STAIOFixRecommend;
import com.tencent.pb.emosm.EmosmPb.STRecommendTabInfo;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x5RspBQRecommend;
import com.tencent.pb.emosm.EmosmPb.SupportSize;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.data.EmoticonPackage;>;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EmoticonManagerServiceImpl
  implements IEmoticonManagerService
{
  public static final String TAG = "EmoticonManager";
  public static HashMap<Double, Integer> betterDisplaySize = new HashMap();
  public BaseQQAppInterface app;
  public Handler dbThreadHandler;
  public EntityManager em;
  public QQLruCache<String, Emoticon> emoticonCache = new QQLruCache(2004, 400, 260);
  public Map<String, CopyOnWriteArrayList<EmotionKeyword>> emotionKeywordCache;
  public Handler fileThreadHandler;
  public SharedPreferences fixRecommendExposSp;
  public Map<String, Integer> fixRecommendExposeCount = new HashMap();
  public Map<String, Integer> hotWords = new HashMap();
  public List<String> kanDianTabCache = new CopyOnWriteArrayList();
  public QQLruCache<String, List<Emoticon>> keywordEmoticonsCache = new QQLruCache(2020, 50, 260);
  private Map<String, EmoticonKeywords> keywordReqTimeInfo = new ConcurrentHashMap(40);
  public double mScreenInch = 0.0D;
  protected SVIPObserver mVipStatusObserver = new EmoticonManagerServiceImpl.23(this);
  public List<EmotionKeyword> needToDBEmotionKeyword = new CopyOnWriteArrayList();
  public List<RecentEmotion> needToDBRecentEmotion = new CopyOnWriteArrayList();
  public QQLruCache<String, EmoticonPackage> pkgCache = new QQLruCache(2013, 100, 580);
  public Map<String, CopyOnWriteArrayList<RecentEmotion>> recentEmotionData = new QQConcurrentHashMap(1021, 0, 80);
  public Map<String, Integer> recommendExposeCount = new HashMap();
  public SharedPreferences recommendExposeSp;
  public SparseArray<List<PromotionEmoticonPkg>> recommendPanelShowInfoMap = new SparseArray();
  public SparseArray<EmosmPb.SubCmd0x5RspBQRecommend> recommendRspMap = new SparseArray();
  public QQLruCache<String, List<Emoticon>> subEmoticonsCache = new QQLruCache(2005, 50, 260);
  public List<String> tabCache = new CopyOnWriteArrayList();
  public Handler uiHandler;
  
  private boolean checkLocalEmoticonPackage(EmoticonPackage paramEmoticonPackage1, EmoticonPackage paramEmoticonPackage2)
  {
    return (paramEmoticonPackage2 != null) && ((paramEmoticonPackage2.valid != paramEmoticonPackage1.valid) || (paramEmoticonPackage2.wordingId != paramEmoticonPackage1.wordingId) || (paramEmoticonPackage2.expiretime != paramEmoticonPackage1.expiretime) || (paramEmoticonPackage2.jobType != paramEmoticonPackage1.jobType) || (paramEmoticonPackage1.aio) || (paramEmoticonPackage1.kandian)) && (!TextUtils.isEmpty(paramEmoticonPackage2.name));
  }
  
  private void clearFixRecommendExposeNum()
  {
    QLog.d("EmoticonManager", 1, "clearFixRecommendExposeNum");
    MobileQQ localMobileQQ = this.app.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("recommendFixExposeCountSp_");
    localStringBuilder.append(this.app.getCurrentAccountUin());
    localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).edit().clear().apply();
    this.fixRecommendExposeCount.clear();
  }
  
  private void clearNotFixRecommendExposeNum()
  {
    QLog.d("EmoticonManager", 1, "clearNotFixRecommendExposeNum");
    MobileQQ localMobileQQ = this.app.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("recommendExposeCountSp_");
    localStringBuilder.append(this.app.getCurrentAccountUin());
    localMobileQQ.getSharedPreferences(localStringBuilder.toString(), 0).edit().clear().apply();
    this.recommendExposeCount.clear();
  }
  
  private double fetchScreenInch()
  {
    double d1 = this.mScreenInch;
    double d2 = 0.0D;
    if (d1 != 0.0D) {
      return d1;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)this.app.getApplication().getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    d1 = d2;
    if (localDisplayMetrics.xdpi != 0.0F)
    {
      d1 = d2;
      if (localDisplayMetrics.ydpi != 0.0F)
      {
        d1 = Math.round(Math.sqrt(Math.pow(localDisplayMetrics.widthPixels / localDisplayMetrics.xdpi, 2.0D) + Math.pow(localDisplayMetrics.heightPixels / localDisplayMetrics.ydpi, 2.0D)) * 100.0D);
        Double.isNaN(d1);
        d1 /= 100.0D;
      }
    }
    if ((d1 >= 4.6D) && (localDisplayMetrics.widthPixels >= 720) && (localDisplayMetrics.heightPixels >= 1280)) {
      this.mScreenInch = 4.7D;
    } else {
      this.mScreenInch = -1.0D;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("screen inches-> screenInch: ");
    localStringBuilder.append(d1);
    localStringBuilder.append(", formatInch: ");
    localStringBuilder.append(this.mScreenInch);
    localStringBuilder.append(", widthPixels: ");
    localStringBuilder.append(localDisplayMetrics.widthPixels);
    localStringBuilder.append(" ,heightPixels: ");
    localStringBuilder.append(localDisplayMetrics.heightPixels);
    localStringBuilder.append(" , xdpi: ");
    localStringBuilder.append(localDisplayMetrics.xdpi);
    localStringBuilder.append(" , ydpi: ");
    localStringBuilder.append(localDisplayMetrics.ydpi);
    localStringBuilder.append(", densityDpi: ");
    localStringBuilder.append(localDisplayMetrics.densityDpi);
    localStringBuilder.append(" , density: ");
    localStringBuilder.append(localDisplayMetrics.density);
    QLog.d("screenInch", 1, localStringBuilder.toString());
    return this.mScreenInch;
  }
  
  private CopyOnWriteArrayList<EmotionKeyword> getEmotionKeywordData(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    CopyOnWriteArrayList localCopyOnWriteArrayList = null;
    if (bool) {
      return null;
    }
    if (this.emotionKeywordCache.containsKey(paramString)) {
      return (CopyOnWriteArrayList)this.emotionKeywordCache.get(paramString);
    }
    List localList = this.em.query(EmotionKeyword.class, false, "keyword=?", new String[] { paramString }, null, null, null, null);
    if (localList != null)
    {
      localCopyOnWriteArrayList = new CopyOnWriteArrayList(localList);
      this.emotionKeywordCache.put(paramString, localCopyOnWriteArrayList);
    }
    return localCopyOnWriteArrayList;
  }
  
  private List<EmotionKeyword> getEmotionKeywordDataFromCache(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (this.emotionKeywordCache.containsKey(paramString)) {
      return new ArrayList((Collection)this.emotionKeywordCache.get(paramString));
    }
    return null;
  }
  
  private SparseArray<PromotionEmoticonPkg> getFixRecommendTabList(int paramInt)
  {
    int i = 0;
    if (paramInt != 0)
    {
      if ((paramInt == 1) && (this.recommendRspMap.indexOfKey(1) >= 0))
      {
        localObject1 = (EmosmPb.SubCmd0x5RspBQRecommend)this.recommendRspMap.get(paramInt);
        break label68;
      }
    }
    else if (this.recommendRspMap.indexOfKey(0) >= 0)
    {
      localObject1 = (EmosmPb.SubCmd0x5RspBQRecommend)this.recommendRspMap.get(paramInt);
      break label68;
    }
    Object localObject1 = null;
    label68:
    if (localObject1 == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "getFixRecommendTabList");
    }
    List localList = syncGetTabEmoticonPackages(paramInt);
    localObject1 = ((EmosmPb.SubCmd0x5RspBQRecommend)localObject1).st_fixinfo.get();
    SparseArray localSparseArray = new SparseArray();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      paramInt = i;
      while (paramInt < ((List)localObject1).size())
      {
        Object localObject2 = (EmosmPb.STAIOFixRecommend)((List)localObject1).get(paramInt);
        i = ((EmosmPb.STAIOFixRecommend)localObject2).u32_pos.get();
        localObject2 = ((EmosmPb.STAIOFixRecommend)localObject2).rpt_list.get();
        PromotionEmoticonPkg localPromotionEmoticonPkg = getFixRecommendTadInfo((List)localObject2, localList);
        if (localPromotionEmoticonPkg != null)
        {
          localSparseArray.put(i - 1, localPromotionEmoticonPkg);
        }
        else
        {
          clearFixRecommendExposeNum();
          localObject2 = getFixRecommendTadInfo((List)localObject2, localList);
          if (localObject2 != null)
          {
            localSparseArray.put(i - 1, localObject2);
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("getFixRecommendTabList : fix emotion error, index = ");
            ((StringBuilder)localObject2).append(i);
            QLog.e("EmoticonManager", 1, ((StringBuilder)localObject2).toString());
          }
        }
        paramInt += 1;
      }
    }
    return localSparseArray;
  }
  
  private PromotionEmoticonPkg getFixRecommendTadInfo(List<EmosmPb.STRecommendTabInfo> paramList, List<EmoticonPackage> paramList1)
  {
    if (paramList != null)
    {
      if (paramList.size() < 1) {
        return null;
      }
      int i = 0;
      while (i < paramList.size())
      {
        PromotionEmoticonPkg localPromotionEmoticonPkg = getRecommendPkg((EmosmPb.STRecommendTabInfo)paramList.get(i), paramList1, true);
        if (localPromotionEmoticonPkg != null) {
          return localPromotionEmoticonPkg;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private List<PromotionEmoticonPkg> getKanDianRecommendList()
  {
    if (this.recommendRspMap.indexOfKey(1) >= 0) {
      localObject = (EmosmPb.SubCmd0x5RspBQRecommend)this.recommendRspMap.get(1);
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "getNotFixRecommendList");
    }
    ArrayList localArrayList = new ArrayList();
    List localList = syncGetTabEmoticonPackages(1);
    Object localObject = ((EmosmPb.SubCmd0x5RspBQRecommend)localObject).st_new_tab_info.get();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      int i = 0;
      while (i < ((List)localObject).size())
      {
        PromotionEmoticonPkg localPromotionEmoticonPkg = getRecommendPkg((EmosmPb.STRecommendTabInfo)((List)localObject).get(i), localList, false, 1);
        if (localPromotionEmoticonPkg != null) {
          localArrayList.add(localPromotionEmoticonPkg);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private List<PromotionEmoticonPkg> getNotFixRecommendList(int paramInt1, int paramInt2)
  {
    List localList2 = getNotFixRecommendListWithExposeNum(paramInt1, paramInt2);
    List localList1;
    if (localList2 != null)
    {
      localList1 = localList2;
      if (localList2.size() >= 1) {}
    }
    else
    {
      clearNotFixRecommendExposeNum();
      localList2 = getNotFixRecommendListWithExposeNum(paramInt1, paramInt2);
      if (localList2 != null)
      {
        localList1 = localList2;
        if (localList2.size() >= 1) {}
      }
      else
      {
        QLog.e("EmoticonManager", 1, "getNotFixRecommendList error data = null");
        localList1 = localList2;
      }
    }
    return localList1;
  }
  
  private List<PromotionEmoticonPkg> getNotFixRecommendListWithExposeNum(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      if ((paramInt2 == 1) && (this.recommendRspMap.indexOfKey(1) >= 0))
      {
        localObject = (EmosmPb.SubCmd0x5RspBQRecommend)this.recommendRspMap.get(paramInt2);
        break label69;
      }
    }
    else if (this.recommendRspMap.indexOfKey(0) >= 0)
    {
      localObject = (EmosmPb.SubCmd0x5RspBQRecommend)this.recommendRspMap.get(paramInt2);
      break label69;
    }
    Object localObject = null;
    label69:
    if (localObject == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "getNotFixRecommendList");
    }
    ArrayList localArrayList = new ArrayList();
    List localList = syncGetTabEmoticonPackages(paramInt2);
    localObject = ((EmosmPb.SubCmd0x5RspBQRecommend)localObject).st_new_tab_info.get();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      paramInt2 = 0;
      int j;
      for (int i = 0; paramInt2 < ((List)localObject).size(); i = j)
      {
        if (i >= EmoticonManagerConstants.RECOMMEND_SHOW_NUM_MAX - paramInt1) {
          return localArrayList;
        }
        PromotionEmoticonPkg localPromotionEmoticonPkg = getRecommendPkg((EmosmPb.STRecommendTabInfo)((List)localObject).get(paramInt2), localList, false);
        j = i;
        if (localPromotionEmoticonPkg != null)
        {
          localArrayList.add(localPromotionEmoticonPkg);
          j = i + 1;
        }
        paramInt2 += 1;
      }
    }
    return localArrayList;
  }
  
  @NotNull
  private List<PromotionEmoticonPkg> getPromotionEmoticonPkgs(int paramInt, EmosmPb.SubCmd0x5RspBQRecommend paramSubCmd0x5RspBQRecommend)
  {
    Object localObject = new ArrayList();
    if (paramSubCmd0x5RspBQRecommend != null)
    {
      if (paramInt == 1) {
        return getKanDianRecommendList();
      }
      int j = paramSubCmd0x5RspBQRecommend.int32_show_num.get();
      if (j > 0) {
        EmoticonManagerConstants.RECOMMEND_SHOW_NUM_MAX = j;
      }
      int i = paramSubCmd0x5RspBQRecommend.int32_exposure_num.get();
      if (i > 0) {
        EmoticonManagerConstants.RECOMMEND_EXPOSE_MAX = i;
      }
      paramSubCmd0x5RspBQRecommend = getFixRecommendTabList(paramInt);
      int k = 0;
      if (paramSubCmd0x5RspBQRecommend != null) {
        i = paramSubCmd0x5RspBQRecommend.size();
      } else {
        i = 0;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getProEmoticonPkgs showNum = ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(",fixRecommendSize = ");
        ((StringBuilder)localObject).append(i);
        QLog.d("EmoticonManager", 2, ((StringBuilder)localObject).toString());
      }
      localObject = getNotFixRecommendList(i, paramInt);
      if ((paramSubCmd0x5RspBQRecommend != null) && (i > 0) && (localObject != null))
      {
        paramInt = 0;
        while (paramInt < i)
        {
          PromotionEmoticonPkg localPromotionEmoticonPkg = (PromotionEmoticonPkg)paramSubCmd0x5RspBQRecommend.valueAt(paramInt);
          int m = paramSubCmd0x5RspBQRecommend.keyAt(paramInt);
          j = m;
          if (m < 0) {
            j = 0;
          }
          if (j > ((List)localObject).size()) {
            ((List)localObject).add(((List)localObject).size(), localPromotionEmoticonPkg);
          } else {
            ((List)localObject).add(j, localPromotionEmoticonPkg);
          }
          paramInt += 1;
        }
      }
      paramInt = k;
      if (localObject != null) {
        paramInt = ((List)localObject).size();
      }
      paramSubCmd0x5RspBQRecommend = new StringBuilder();
      paramSubCmd0x5RspBQRecommend.append("getProEmoticonPkgs data size = ");
      paramSubCmd0x5RspBQRecommend.append(paramInt);
      QLog.d("EmoticonManager", 2, paramSubCmd0x5RspBQRecommend.toString());
      return localObject;
    }
    QLog.d("EmoticonManager", 1, "getProEmoticonPkgs recommendRsp == NULL");
    if (paramInt == 0)
    {
      writeRecommendInfoFromFileToCache();
      return localObject;
    }
    if (paramInt == 1)
    {
      paramSubCmd0x5RspBQRecommend = (EmoticonHandler)this.app.getBusinessHandler(EmoticonHandler.a);
      if (paramSubCmd0x5RspBQRecommend != null) {
        paramSubCmd0x5RspBQRecommend.c();
      }
    }
    return localObject;
  }
  
  private CopyOnWriteArrayList<RecentEmotion> getRecentEmotionData(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    CopyOnWriteArrayList localCopyOnWriteArrayList = null;
    if (bool) {
      return null;
    }
    if (this.recentEmotionData.containsKey(paramString)) {
      return (CopyOnWriteArrayList)this.recentEmotionData.get(paramString);
    }
    List localList = this.em.query(RecentEmotion.class, false, "keyword=?", new String[] { paramString }, null, null, null, null);
    if (localList != null)
    {
      localCopyOnWriteArrayList = new CopyOnWriteArrayList(localList);
      this.recentEmotionData.put(paramString, localCopyOnWriteArrayList);
    }
    return localCopyOnWriteArrayList;
  }
  
  private CopyOnWriteArrayList<RecentEmotion> getRecentEmotionDataFromCache(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (this.recentEmotionData.containsKey(paramString)) {
      return (CopyOnWriteArrayList)this.recentEmotionData.get(paramString);
    }
    return null;
  }
  
  private int getRecommendExposeNum(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    int i;
    if (paramBoolean)
    {
      if (this.fixRecommendExposeCount.containsKey(paramString)) {
        i = ((Integer)this.fixRecommendExposeCount.get(paramString)).intValue();
      } else {
        i = this.recommendExposeSp.getInt(paramString, 0);
      }
    }
    else if (this.recommendExposeCount.containsKey(paramString)) {
      i = ((Integer)this.recommendExposeCount.get(paramString)).intValue();
    } else {
      i = this.recommendExposeSp.getInt(paramString, 0);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getRecommendExposeNum epId = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",isFix = ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", exposeNum = ");
      localStringBuilder.append(i);
      QLog.d("EmoticonManager", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  private PromotionEmoticonPkg getRecommendPkg(EmosmPb.STRecommendTabInfo paramSTRecommendTabInfo, List<EmoticonPackage> paramList, boolean paramBoolean)
  {
    return getRecommendPkg(paramSTRecommendTabInfo, paramList, paramBoolean, 0);
  }
  
  private PromotionEmoticonPkg getRecommendPkg(EmosmPb.STRecommendTabInfo paramSTRecommendTabInfo, List<EmoticonPackage> paramList, boolean paramBoolean, int paramInt)
  {
    if (paramSTRecommendTabInfo == null) {
      return null;
    }
    String str = String.valueOf(paramSTRecommendTabInfo.u32_tab_id.get());
    if (paramInt == 0)
    {
      paramInt = getRecommendExposeNum(str, paramBoolean);
      if (paramInt >= EmoticonManagerConstants.RECOMMEND_EXPOSE_MAX)
      {
        if (QLog.isColorLevel())
        {
          paramSTRecommendTabInfo = new StringBuilder();
          paramSTRecommendTabInfo.append("getProEmoticonPkgs exposeNum > max ; epId = ");
          paramSTRecommendTabInfo.append(str);
          paramSTRecommendTabInfo.append(",isFixEmoticon = ");
          paramSTRecommendTabInfo.append(paramBoolean);
          paramSTRecommendTabInfo.append(", exposeNum = ");
          paramSTRecommendTabInfo.append(paramInt);
          QLog.d("EmoticonManager", 2, paramSTRecommendTabInfo.toString());
        }
        return null;
      }
    }
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramInt = 0;
      while (paramInt < paramList.size())
      {
        if (((EmoticonPackage)paramList.get(paramInt)).epId.equals(str)) {
          return null;
        }
        paramInt += 1;
      }
    }
    PromotionEmoticonPkg localPromotionEmoticonPkg = new PromotionEmoticonPkg();
    localPromotionEmoticonPkg.id = str;
    localPromotionEmoticonPkg.pkgDesc = paramSTRecommendTabInfo.str_tab_name.get();
    localPromotionEmoticonPkg.type = paramSTRecommendTabInfo.i32_tab_type.get();
    localPromotionEmoticonPkg.feeType = paramSTRecommendTabInfo.i32_feetype.get();
    localPromotionEmoticonPkg.imgUrl = paramSTRecommendTabInfo.str_thumb_nail_url.get();
    localPromotionEmoticonPkg.titleColor = paramSTRecommendTabInfo.str_title_color.get();
    localPromotionEmoticonPkg.bgColor = paramSTRecommendTabInfo.str_bg_color.get();
    localPromotionEmoticonPkg.price = paramSTRecommendTabInfo.i32_price.get();
    localPromotionEmoticonPkg.recommendType = paramSTRecommendTabInfo.i32_recommend_mode.get();
    localPromotionEmoticonPkg.redpointFlag = paramSTRecommendTabInfo.int32_red_point_flag.get();
    localPromotionEmoticonPkg.detailUrl = paramSTRecommendTabInfo.str_button_url.get();
    paramList = HardCodeUtil.a(2131699759);
    if (localPromotionEmoticonPkg.feeType == 6)
    {
      paramSTRecommendTabInfo = HardCodeUtil.a(2131704159);
    }
    else if (localPromotionEmoticonPkg.feeType == 1)
    {
      paramSTRecommendTabInfo = HardCodeUtil.a(2131704200);
    }
    else if (localPromotionEmoticonPkg.feeType == 4)
    {
      paramSTRecommendTabInfo = "VIP";
    }
    else if (localPromotionEmoticonPkg.feeType == 5)
    {
      paramSTRecommendTabInfo = "SVIP";
    }
    else
    {
      paramSTRecommendTabInfo = paramList;
      if (localPromotionEmoticonPkg.feeType == 2) {
        if (localPromotionEmoticonPkg.price == PromotionEmoticonPkg.PAY_LIMIT_FREE)
        {
          paramSTRecommendTabInfo = HardCodeUtil.a(2131704165);
        }
        else if (localPromotionEmoticonPkg.price == PromotionEmoticonPkg.PAY_1_YUAN)
        {
          paramSTRecommendTabInfo = "￥1.00";
        }
        else
        {
          paramSTRecommendTabInfo = paramList;
          if (localPromotionEmoticonPkg.price == PromotionEmoticonPkg.PAY_6_YUAN) {
            paramSTRecommendTabInfo = "￥6.00";
          }
        }
      }
    }
    localPromotionEmoticonPkg.btnDesc = paramSTRecommendTabInfo;
    localPromotionEmoticonPkg.isFixedEmoticon = paramBoolean;
    if (localPromotionEmoticonPkg.type == PromotionEmoticonPkg.SMALL) {
      localPromotionEmoticonPkg.type = 4;
    } else if (localPromotionEmoticonPkg.type == PromotionEmoticonPkg.MAGIC) {
      localPromotionEmoticonPkg.type = 3;
    } else if ((localPromotionEmoticonPkg.type != PromotionEmoticonPkg.GIF) && (localPromotionEmoticonPkg.type != PromotionEmoticonPkg.PNG))
    {
      if (localPromotionEmoticonPkg.type == PromotionEmoticonPkg.H5MAGIC) {
        localPromotionEmoticonPkg.type = 5;
      }
    }
    else {
      localPromotionEmoticonPkg.type = 0;
    }
    if (QLog.isColorLevel())
    {
      paramSTRecommendTabInfo = new StringBuilder();
      paramSTRecommendTabInfo.append("recommendemos epid = ");
      paramSTRecommendTabInfo.append(localPromotionEmoticonPkg.id);
      paramSTRecommendTabInfo.append(";pkgname = ");
      paramSTRecommendTabInfo.append(localPromotionEmoticonPkg.pkgDesc);
      paramSTRecommendTabInfo.append(";type = ");
      paramSTRecommendTabInfo.append(localPromotionEmoticonPkg.type);
      paramSTRecommendTabInfo.append(";feeType");
      paramSTRecommendTabInfo.append(localPromotionEmoticonPkg.feeType);
      paramSTRecommendTabInfo.append(";imgurl = ");
      paramSTRecommendTabInfo.append(localPromotionEmoticonPkg.imgUrl);
      paramSTRecommendTabInfo.append(";btndec = ");
      paramSTRecommendTabInfo.append(localPromotionEmoticonPkg.btnDesc);
      paramSTRecommendTabInfo.append(";price = ");
      paramSTRecommendTabInfo.append(localPromotionEmoticonPkg.price);
      QLog.d("EmoticonManager", 2, paramSTRecommendTabInfo.toString());
    }
    return localPromotionEmoticonPkg;
  }
  
  private void initTabs()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "initTabs begins");
    }
    long l = System.currentTimeMillis();
    Object localObject = (ArrayList)this.em.query(EmoticonTab.class, false, null, null, null, null, null, null);
    this.tabCache.clear();
    this.kanDianTabCache.clear();
    if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonTab localEmoticonTab = (EmoticonTab)((Iterator)localObject).next();
        if (localEmoticonTab != null)
        {
          if (localEmoticonTab.aioHave) {
            this.tabCache.add(localEmoticonTab.epId);
          }
          if (localEmoticonTab.kandianHave) {
            this.kanDianTabCache.add(localEmoticonTab.epId);
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("initTabs ends, tabCache.size:");
      ((StringBuilder)localObject).append(this.tabCache.size());
      ((StringBuilder)localObject).append(", kanDianCache.size = ");
      ((StringBuilder)localObject).append(this.kanDianTabCache.size());
      ((StringBuilder)localObject).append(",time:");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      QLog.d("EmoticonManager", 2, ((StringBuilder)localObject).toString());
    }
    preloadOtherEmotionData();
    EmotionUtils.a(new QQEmoticonMainPanelApp(this.app), 0);
  }
  
  private void insertOrUpdateEmoticonTab(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    EmoticonTab localEmoticonTab = (EmoticonTab)this.em.find(EmoticonTab.class, paramString);
    if (localEmoticonTab != null)
    {
      if (paramBoolean1) {
        localEmoticonTab.aioHave = true;
      }
      paramString = localEmoticonTab;
      if (paramBoolean2)
      {
        localEmoticonTab.kandianHave = true;
        paramString = localEmoticonTab;
      }
    }
    else
    {
      localEmoticonTab = new EmoticonTab();
      localEmoticonTab.setStatus(1000);
      localEmoticonTab.epId = paramString;
      localEmoticonTab.aioHave = paramBoolean1;
      localEmoticonTab.kandianHave = paramBoolean2;
      paramString = localEmoticonTab;
    }
    updateEntity(paramString);
  }
  
  private boolean isEmoticonMagic(EmoticonPackage paramEmoticonPackage)
  {
    return (paramEmoticonPackage != null) && ((paramEmoticonPackage.jobType == 5) || (paramEmoticonPackage.jobType == 3));
  }
  
  private boolean isKeywordEmotionValid(String paramString)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = false;
    if (bool3) {
      return false;
    }
    Object localObject = syncFindEmoticonPackageById(paramString);
    if (localObject == null) {
      return false;
    }
    int i = ((ISVIPHandler)this.app.getBusinessHandler(((ISVIPHandlerProxy)QRoute.api(ISVIPHandlerProxy.class)).getImplClassName())).g();
    int j = ((EmoticonPackage)localObject).mobileFeetype;
    if (j == 1) {
      return true;
    }
    if (j == 4)
    {
      if ((i == 1) || (i == 3)) {
        bool1 = true;
      }
      return bool1;
    }
    if (j == 5)
    {
      bool1 = bool2;
      if (i == 3) {
        bool1 = true;
      }
      return bool1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isKeywordEmotionValid isActivity or other epId = ");
    ((StringBuilder)localObject).append(paramString);
    QLog.d("EmoticonManager", 1, ((StringBuilder)localObject).toString());
    return false;
  }
  
  private boolean isRecommendRedpointEffective(int paramInt)
  {
    if (paramInt != 0)
    {
      if ((paramInt == 1) && (this.recommendRspMap.indexOfKey(1) >= 0))
      {
        localSubCmd0x5RspBQRecommend = (EmosmPb.SubCmd0x5RspBQRecommend)this.recommendRspMap.get(paramInt);
        break label69;
      }
    }
    else if (this.recommendRspMap.indexOfKey(0) >= 0)
    {
      localSubCmd0x5RspBQRecommend = (EmosmPb.SubCmd0x5RspBQRecommend)this.recommendRspMap.get(paramInt);
      break label69;
    }
    EmosmPb.SubCmd0x5RspBQRecommend localSubCmd0x5RspBQRecommend = null;
    label69:
    if (localSubCmd0x5RspBQRecommend == null)
    {
      QLog.d("EmoticonManager", 1, "isRecommendRedpointEffective recommendRsp is null");
      writeRecommendInfoFromFileToCache();
      return false;
    }
    if (localSubCmd0x5RspBQRecommend.int32_red_point_flag.get() == 1) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    if (paramInt == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 1, "isRecommendRedpointEffective is not white num");
      }
      return false;
    }
    long l1 = this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getLong("recommendRedpointStartTime", 0L);
    long l2 = localSubCmd0x5RspBQRecommend.int32_light_out_interval.get() * 1000;
    if (System.currentTimeMillis() - l1 > l2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 1, "isRecommendRedpointEffective redpoint is overtime");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 1, "isRecommendRedpointEffective show redpoint");
    }
    return true;
  }
  
  private void preloadOtherEmotionData()
  {
    writeRecommendInfoFromFileToCache();
    parseCloudKeywordsJson();
  }
  
  private void pushFixRecommendExposeInfoToSP()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "pushNotFixRecommendExposeInfoToSP");
    }
    Iterator localIterator = this.fixRecommendExposeCount.entrySet().iterator();
    SharedPreferences.Editor localEditor = this.fixRecommendExposSp.edit();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if (!TextUtils.isEmpty(str))
      {
        int i = ((Integer)localEntry.getValue()).intValue();
        if (i > 0) {
          localEditor.putInt(str, i);
        }
      }
    }
    localEditor.apply();
  }
  
  private void pushNotFixRecommendExposeInfoToSP()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "pushNotFixRecommendExposeInfoToSP");
    }
    Iterator localIterator = this.recommendExposeCount.entrySet().iterator();
    SharedPreferences.Editor localEditor = this.recommendExposeSp.edit();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if (!TextUtils.isEmpty(str))
      {
        int i = ((Integer)localEntry.getValue()).intValue();
        if (i > 0) {
          localEditor.putInt(str, i);
        }
      }
    }
    localEditor.apply();
  }
  
  private ArrayList<Emoticon> queryEmoticonsByKeyWordFromDB(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ArrayList localArrayList = (ArrayList)this.em.query(Emoticon.class, false, "name=? and jobType= ?", new String[] { paramString, "0" }, null, null, null, null);
    if (localArrayList != null) {
      synchronized (this.keywordEmoticonsCache)
      {
        this.keywordEmoticonsCache.put(paramString, localArrayList);
        paramString = localArrayList.iterator();
        while (paramString.hasNext())
        {
          Emoticon localEmoticon = (Emoticon)paramString.next();
          this.emoticonCache.put(localEmoticon.getMapKey(), localEmoticon);
        }
        return localArrayList;
      }
    }
    ??? = new StringBuilder();
    ((StringBuilder)???).append("queryEmoticonsByKeyWordFromDB data is null , keyWord = ");
    ((StringBuilder)???).append(paramString);
    QLog.e("EmoticonManager", 1, ((StringBuilder)???).toString());
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append(" queryEmoticonsByKeyWordFromDB keywordEmoticonsCache.size:");
      ((StringBuilder)???).append(this.keywordEmoticonsCache.size());
      ((StringBuilder)???).append(",keyWord:");
      ((StringBuilder)???).append(paramString);
      QLog.d("EmoticonManager", 2, ((StringBuilder)???).toString());
    }
    return null;
  }
  
  private ArrayList<Emoticon> queryEmoticonsByPackageIdFromDB(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ArrayList localArrayList = (ArrayList)this.em.query(Emoticon.class, false, "epId=?", new String[] { paramString }, null, null, null, null);
    Object localObject1 = this.subEmoticonsCache;
    if (localArrayList != null) {}
    try
    {
      this.subEmoticonsCache.put(paramString, localArrayList);
      Object localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Emoticon localEmoticon = (Emoticon)((Iterator)localObject2).next();
        this.emoticonCache.put(localEmoticon.getMapKey(), localEmoticon);
        continue;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("queryEmoticonsByPackageIdFromDB data is null , epId = ");
        ((StringBuilder)localObject2).append(paramString);
        QLog.e("EmoticonManager", 1, ((StringBuilder)localObject2).toString());
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" queryEmoticonsByPackageIdFromDB subEmoticonsCache.size:");
        ((StringBuilder)localObject1).append(this.subEmoticonsCache.size());
        ((StringBuilder)localObject1).append(",epId:");
        ((StringBuilder)localObject1).append(paramString);
        QLog.d("EmoticonManager", 2, ((StringBuilder)localObject1).toString());
      }
      return localArrayList;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  private void removeKeywordEmoticonCache(Emoticon paramEmoticon)
  {
    List localList = (List)this.keywordEmoticonsCache.get(paramEmoticon.name);
    if ((localList != null) && (localList.contains(paramEmoticon))) {
      synchronized (this.keywordEmoticonsCache)
      {
        localList.remove(paramEmoticon);
        this.keywordEmoticonsCache.put(paramEmoticon.name, localList);
        return;
      }
    }
  }
  
  private void runInCurrentThread(Runnable paramRunnable, int paramInt)
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
  
  private void saveRecommendEpInfoFromCacheToFile()
  {
    saveRecommendEpInfoFromCacheToFile(0);
  }
  
  private void saveRecommendEpInfoFromCacheToFile(int paramInt)
  {
    if (paramInt != 0)
    {
      if ((paramInt == 1) && (this.recommendRspMap.indexOfKey(1) >= 0))
      {
        localSubCmd0x5RspBQRecommend = (EmosmPb.SubCmd0x5RspBQRecommend)this.recommendRspMap.get(paramInt);
        break label66;
      }
    }
    else if (this.recommendRspMap.indexOfKey(0) >= 0)
    {
      localSubCmd0x5RspBQRecommend = (EmosmPb.SubCmd0x5RspBQRecommend)this.recommendRspMap.get(paramInt);
      break label66;
    }
    EmosmPb.SubCmd0x5RspBQRecommend localSubCmd0x5RspBQRecommend = null;
    label66:
    if (localSubCmd0x5RspBQRecommend == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveRecommendEpInfoToFile businessType = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("EmoticonManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.fileThreadHandler;
    if (localObject != null) {
      ((Handler)localObject).post(new EmoticonManagerServiceImpl.27(this, paramInt, localSubCmd0x5RspBQRecommend));
    }
  }
  
  private void updateEmoticonCache(Emoticon paramEmoticon)
  {
    Object localObject2;
    if (TextUtils.isEmpty(paramEmoticon.encryptKey))
    {
      localObject2 = (Emoticon)this.emoticonCache.get(paramEmoticon.getMapKey());
      if (localObject2 != null)
      {
        ??? = localObject2;
        if (!TextUtils.isEmpty(((Emoticon)localObject2).encryptKey)) {}
      }
      else
      {
        ??? = (Emoticon)this.em.find(Emoticon.class, "epId=? and eId=?", new String[] { paramEmoticon.epId, paramEmoticon.eId });
      }
      if ((??? != null) && (!TextUtils.isEmpty(((Emoticon)???).encryptKey))) {
        paramEmoticon.encryptKey = ((Emoticon)???).encryptKey;
      }
    }
    this.emoticonCache.put(paramEmoticon.getMapKey(), paramEmoticon);
    synchronized (this.subEmoticonsCache)
    {
      localObject2 = (List)this.subEmoticonsCache.get(paramEmoticon.epId);
      if (localObject2 != null)
      {
        Iterator localIterator = ((List)localObject2).iterator();
        while (localIterator.hasNext())
        {
          Emoticon localEmoticon = (Emoticon)localIterator.next();
          if (paramEmoticon.eId.equals(localEmoticon.eId))
          {
            ((List)localObject2).remove(localEmoticon);
            ((List)localObject2).add(paramEmoticon);
          }
        }
        this.subEmoticonsCache.put(paramEmoticon.epId, localObject2);
      }
      updateKeywordEmoticonsCache(paramEmoticon);
      return;
    }
    for (;;)
    {
      throw paramEmoticon;
    }
  }
  
  private boolean updateEntity(Entity paramEntity)
  {
    int i = paramEntity.getStatus();
    boolean bool = false;
    if (i == 1000)
    {
      this.em.persistOrReplace(paramEntity);
      if (paramEntity.getStatus() == 1001) {
        bool = true;
      }
      return bool;
    }
    if ((paramEntity.getStatus() != 1001) && (paramEntity.getStatus() != 1002)) {
      return false;
    }
    return this.em.update(paramEntity);
  }
  
  private void updateExtensionSize(String paramString, Emoticon paramEmoticon, byte[] paramArrayOfByte, Integer paramInteger)
  {
    MarketFaceExtPb.ResvAttr localResvAttr = new MarketFaceExtPb.ResvAttr();
    try
    {
      localResvAttr.mergeFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    boolean bool = localResvAttr.uint32_emoji_type.has();
    int k = 0;
    int j = 0;
    int i;
    if ((bool) && (localResvAttr.uint32_emoji_type.get() == 2)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if ((localResvAttr.rpt_apng_support_size != null) && (paramEmoticon.extensionWidth == 0) && (paramEmoticon.extensionHeight == 0))
      {
        i = j;
        while (i < localResvAttr.rpt_apng_support_size.size())
        {
          paramArrayOfByte = (MarketFaceExtPb.SupportSize)localResvAttr.rpt_apng_support_size.get(i);
          j = paramArrayOfByte.uint32_width.get();
          k = paramArrayOfByte.uint32_height.get();
          if ((j == paramInteger.intValue()) && (k == paramInteger.intValue()))
          {
            paramEmoticon.extensionWidth = paramInteger.intValue();
            paramEmoticon.extensionHeight = paramInteger.intValue();
            if (!QLog.isColorLevel()) {
              break;
            }
            paramArrayOfByte = new StringBuilder();
            paramArrayOfByte.append("get apng support size from resvAttr, betterSize: ");
            paramArrayOfByte.append(paramInteger);
            paramArrayOfByte.append(", epId: ");
            paramArrayOfByte.append(paramString);
            paramArrayOfByte.append(" , eId: ");
            paramArrayOfByte.append(paramEmoticon.eId);
            QLog.d("EmoticonManager", 2, paramArrayOfByte.toString());
            return;
          }
          i += 1;
        }
      }
    }
    else if ((localResvAttr.rpt_support_size != null) && (paramEmoticon.extensionHeight == 0) && (paramEmoticon.extensionWidth == 0))
    {
      i = k;
      while (i < localResvAttr.rpt_support_size.size())
      {
        paramArrayOfByte = (MarketFaceExtPb.SupportSize)localResvAttr.rpt_support_size.get(i);
        j = paramArrayOfByte.uint32_width.get();
        k = paramArrayOfByte.uint32_height.get();
        if ((j == paramInteger.intValue()) && (k == paramInteger.intValue()))
        {
          paramEmoticon.extensionWidth = paramInteger.intValue();
          paramEmoticon.extensionHeight = paramInteger.intValue();
          if (!QLog.isColorLevel()) {
            break;
          }
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("get support size from resvAttr, betterSize: ");
          paramArrayOfByte.append(paramInteger);
          paramArrayOfByte.append(", epId: ");
          paramArrayOfByte.append(paramString);
          paramArrayOfByte.append(" , eId: ");
          paramArrayOfByte.append(paramEmoticon.eId);
          QLog.d("EmoticonManager", 2, paramArrayOfByte.toString());
          return;
        }
        i += 1;
      }
    }
  }
  
  private void updateKeywordEmoticonsCache(Emoticon paramEmoticon)
  {
    synchronized (this.keywordEmoticonsCache)
    {
      List localList = (List)this.keywordEmoticonsCache.get(paramEmoticon.name);
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          Emoticon localEmoticon = (Emoticon)localIterator.next();
          if (paramEmoticon.eId.equals(localEmoticon.eId))
          {
            localList.remove(localEmoticon);
            localList.add(paramEmoticon);
          }
        }
        this.keywordEmoticonsCache.put(paramEmoticon.name, localList);
      }
      return;
    }
    for (;;)
    {
      throw paramEmoticon;
    }
  }
  
  private void updateKeywordReqTimeToDB(EmoticonKeywords paramEmoticonKeywords)
  {
    if (paramEmoticonKeywords == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "saveKeywordReqTimeToDB");
    }
    ThreadManager.post(new EmoticonManagerServiceImpl.22(this, paramEmoticonKeywords), 5, null, true);
  }
  
  private void writeRecommendInfoFromFileToCache()
  {
    writeRecommendInfoFromFileToCache(0);
  }
  
  private void writeRecommendInfoFromFileToCache(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("writeRecommendInfoFromFileToCache businessType = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("EmoticonManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.fileThreadHandler;
    if (localObject == null)
    {
      QLog.e("EmoticonManager", 1, "writeRecommendInfoFromFileToCache fileThreadHandler == null");
      return;
    }
    ((Handler)localObject).post(new EmoticonManagerServiceImpl.26(this, paramInt));
  }
  
  public void addEmotionKeywordExpose(EmotionKeyword paramEmotionKeyword, boolean paramBoolean)
  {
    if (paramEmotionKeyword != null)
    {
      if (TextUtils.isEmpty(paramEmotionKeyword.keyword)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("addEmotionKeywordExpose emotion keyword = ");
        ((StringBuilder)localObject).append(paramEmotionKeyword);
        ((StringBuilder)localObject).append(",isReset = ");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("EmoticonManager", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = getEmotionKeywordDataFromCache(paramEmotionKeyword.keyword);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          EmotionKeyword localEmotionKeyword = (EmotionKeyword)((Iterator)localObject).next();
          if (paramEmotionKeyword.equals(localEmotionKeyword))
          {
            if (paramBoolean) {
              localEmotionKeyword.exposeNum = 0;
            } else {
              localEmotionKeyword.exposeNum += 1;
            }
            this.needToDBEmotionKeyword.remove(paramEmotionKeyword);
            this.needToDBEmotionKeyword.add(localEmotionKeyword);
          }
        }
      }
    }
  }
  
  public void addEmotionKeywordToCache(EmotionKeyword paramEmotionKeyword)
  {
    if (paramEmotionKeyword == null) {
      return;
    }
    Object localObject1 = paramEmotionKeyword.keyword;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return;
    }
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("addEmotionKeywordToCache emotionKeyword = ");
      ((StringBuilder)localObject2).append(paramEmotionKeyword);
      QLog.d("EmoticonManager", 2, ((StringBuilder)localObject2).toString());
    }
    CopyOnWriteArrayList localCopyOnWriteArrayList = getEmotionKeywordData((String)localObject1);
    if (localCopyOnWriteArrayList != null)
    {
      localObject2 = null;
      Iterator localIterator = localCopyOnWriteArrayList.iterator();
      do
      {
        localObject1 = localObject2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject1 = (EmotionKeyword)localIterator.next();
      } while (!paramEmotionKeyword.equals(localObject1));
      if (localObject1 != null)
      {
        ((EmotionKeyword)localObject1).replace(paramEmotionKeyword);
        paramEmotionKeyword = (EmotionKeyword)localObject1;
      }
      else
      {
        localCopyOnWriteArrayList.add(paramEmotionKeyword);
      }
    }
    else
    {
      localObject2 = new CopyOnWriteArrayList();
      ((CopyOnWriteArrayList)localObject2).add(paramEmotionKeyword);
      this.emotionKeywordCache.put(localObject1, localObject2);
    }
    this.needToDBEmotionKeyword.remove(paramEmotionKeyword);
    this.needToDBEmotionKeyword.add(paramEmotionKeyword);
  }
  
  public void addExtensionSizeByScreenSize(String paramString, Emoticon paramEmoticon, byte[] paramArrayOfByte)
  {
    Integer localInteger = (Integer)betterDisplaySize.get(Double.valueOf(fetchScreenInch()));
    if (localInteger != null)
    {
      if (localInteger.intValue() == 0) {
        return;
      }
      if ((paramString != null) && (paramEmoticon.extensionHeight == 0) && (paramEmoticon.extensionWidth == 0))
      {
        int i = getExtensionSizeByScreenSize(paramString);
        if (i != -1)
        {
          paramEmoticon.extensionHeight = i;
          paramEmoticon.extensionWidth = i;
        }
      }
      else
      {
        if (paramArrayOfByte != null)
        {
          updateExtensionSize(paramString, paramEmoticon, paramArrayOfByte, localInteger);
          return;
        }
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("get support size ");
          paramArrayOfByte.append(localInteger);
          paramArrayOfByte.append(", epId: ");
          paramArrayOfByte.append(paramString);
          paramArrayOfByte.append(" , eId: ");
          paramArrayOfByte.append(paramEmoticon.eId);
          paramArrayOfByte.append(", height: ");
          paramArrayOfByte.append(paramEmoticon.extensionHeight);
          paramArrayOfByte.append(", width: ");
          paramArrayOfByte.append(paramEmoticon.extensionWidth);
          QLog.d("EmoticonManager", 2, paramArrayOfByte.toString());
        }
      }
    }
  }
  
  public void addExtensionSizeByScreenSizeFromKeyword(String paramString, Emoticon paramEmoticon, List<EmosmPb.SupportSize> paramList)
  {
    if (paramList != null)
    {
      if (paramEmoticon == null) {
        return;
      }
      Integer localInteger = (Integer)betterDisplaySize.get(Double.valueOf(fetchScreenInch()));
      if (localInteger != null)
      {
        if (localInteger.intValue() == 0) {
          return;
        }
        if (syncFindEmoticonPackageById(paramString) != null)
        {
          if (QLog.isColorLevel())
          {
            paramList = new StringBuilder();
            paramList.append("get support size from cloud: local exists, better size");
            paramList.append(localInteger);
            paramList.append(", epId: ");
            paramList.append(paramString);
            paramList.append(" , eId: ");
            paramList.append(paramEmoticon.eId);
            QLog.d("EmoticonManager", 2, paramList.toString());
          }
          addExtensionSizeByScreenSize(paramString, paramEmoticon, null);
          return;
        }
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          EmosmPb.SupportSize localSupportSize = (EmosmPb.SupportSize)paramList.next();
          int i = localSupportSize.u32_Width.get();
          int j = localSupportSize.u32_height.get();
          if ((i == localInteger.intValue()) && (j == localInteger.intValue()))
          {
            paramEmoticon.extensionWidth = localInteger.intValue();
            paramEmoticon.extensionHeight = localInteger.intValue();
            if (QLog.isColorLevel())
            {
              paramList = new StringBuilder();
              paramList.append("get support size from cloud: , better size");
              paramList.append(localInteger);
              paramList.append(", epId: ");
              paramList.append(paramString);
              paramList.append(" , eId: ");
              paramList.append(paramEmoticon.eId);
              QLog.d("EmoticonManager", 2, paramList.toString());
            }
          }
        }
      }
    }
  }
  
  public void addKeywordEmoticonsCache(String arg1)
  {
    Object localObject1 = syncGetSubEmoticonsByPackageId(???);
    if (localObject1 == null) {
      return;
    }
    synchronized (this.keywordEmoticonsCache)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Emoticon localEmoticon = (Emoticon)((Iterator)localObject1).next();
        List localList = (List)this.keywordEmoticonsCache.get(localEmoticon.name);
        if ((localList != null) && (!localList.contains(localEmoticon)))
        {
          localList.add(localEmoticon);
          this.keywordEmoticonsCache.put(localEmoticon.name, localList);
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void addRecentEmotionExposeNum(EmotionKeyword paramEmotionKeyword, boolean paramBoolean)
  {
    if ((paramEmotionKeyword != null) && (!TextUtils.isEmpty(paramEmotionKeyword.keyword)) && (!TextUtils.isEmpty(paramEmotionKeyword.epId)))
    {
      if (TextUtils.isEmpty(paramEmotionKeyword.eId)) {
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("addRecentEmotionExposeNum emotion keyword = ");
        ((StringBuilder)localObject).append(paramEmotionKeyword);
        QLog.d("EmoticonManager", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = getRecentEmotionDataFromCache(paramEmotionKeyword.keyword);
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          RecentEmotion localRecentEmotion = (RecentEmotion)((Iterator)localObject).next();
          if ((paramEmotionKeyword.keyword.equals(localRecentEmotion.keyword)) && (paramEmotionKeyword.epId.equals(localRecentEmotion.epId)) && (paramEmotionKeyword.eId.equals(localRecentEmotion.eId)))
          {
            if (paramBoolean) {
              localRecentEmotion.exposeNum = 0;
            } else {
              localRecentEmotion.exposeNum += 1;
            }
            this.needToDBRecentEmotion.remove(localRecentEmotion);
            this.needToDBRecentEmotion.add(0, localRecentEmotion);
          }
        }
      }
    }
  }
  
  public void addRecentEmotionToCache(RecentEmotion paramRecentEmotion)
  {
    ThreadManager.post(new EmoticonManagerServiceImpl.19(this, paramRecentEmotion), 5, null, true);
  }
  
  public void addTabEmoticonPackage(String paramString, int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addTabEmoticonPackage, emoticonTabId = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" businessType = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("EmoticonManager", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt != 1)
    {
      this.tabCache.remove(paramString);
      this.tabCache.add(0, paramString);
      localObject = (EmoticonHandler)this.app.getBusinessHandler(EmoticonHandler.a);
      if (localObject != null) {
        ((EmoticonHandler)localObject).a(this.tabCache, true, 0);
      }
    }
    else
    {
      this.kanDianTabCache.remove(paramString);
      this.kanDianTabCache.add(0, paramString);
    }
    runInCurrentThread(new EmoticonManagerServiceImpl.18(this, paramString), 5);
  }
  
  public void asyncFindEmoticon(String paramString1, String paramString2, QueryCallback<Emoticon> paramQueryCallback)
  {
    new QueryTask(new EmoticonManagerServiceImpl.4(this), paramQueryCallback).execute(new Pair(paramString1, paramString2));
  }
  
  public void asyncFindEmoticonPackage(String paramString, int paramInt, QueryCallback<EmoticonPackage> paramQueryCallback)
  {
    new QueryTask(new EmoticonManagerServiceImpl.5(this), paramQueryCallback).execute(new Pair(paramString, Integer.valueOf(paramInt)));
  }
  
  public void asyncFindEmoticonPackage(String paramString, QueryCallback<EmoticonPackage> paramQueryCallback)
  {
    asyncFindEmoticonPackage(paramString, 0, paramQueryCallback);
  }
  
  public void asyncFindTabEmoticonPackageById(String paramString, int paramInt, QueryCallback<EmoticonPackage> paramQueryCallback)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("asyncFindTabEmoticonPackageById epId = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" businessType = ");
      localStringBuilder.append(paramInt);
      QLog.i("EmoticonManager", 2, localStringBuilder.toString());
    }
    new QueryTask(new EmoticonManagerServiceImpl.15(this), paramQueryCallback).execute(new Pair(paramString, Integer.valueOf(paramInt)));
  }
  
  public void asyncFindTabEmoticonPackageById(String paramString, QueryCallback<EmoticonPackage> paramQueryCallback)
  {
    asyncFindTabEmoticonPackageById(paramString, 0, paramQueryCallback);
  }
  
  public void asyncGetEmoticonInfo(MarkFaceMessage paramMarkFaceMessage, QueryCallback paramQueryCallback)
  {
    new QueryTask(new EmoticonManagerServiceImpl.12(this, paramMarkFaceMessage), paramQueryCallback).execute(paramMarkFaceMessage);
  }
  
  public void asyncGetTabEmoticonPackages(int paramInt, QueryCallback<List<EmoticonPackage>> paramQueryCallback)
  {
    new QueryTask(new EmoticonManagerServiceImpl.11(this), paramQueryCallback).execute(Integer.valueOf(paramInt));
  }
  
  public void asyncIncreaseEmotionClickNum(Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {
      return;
    }
    Object localObject = (List)this.keywordEmoticonsCache.get(paramEmoticon.name);
    if (localObject == null)
    {
      paramEmoticon.increaseExposeNum();
      this.emoticonCache.put(paramEmoticon.getMapKey(), paramEmoticon);
      this.em.update(paramEmoticon);
      return;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Emoticon localEmoticon = (Emoticon)((Iterator)localObject).next();
      if ((localEmoticon != null) && (paramEmoticon.getMapKey().equals(localEmoticon.getMapKey())))
      {
        localEmoticon.increaseClickNum();
        this.emoticonCache.put(localEmoticon.getMapKey(), localEmoticon);
        this.dbThreadHandler.post(new EmoticonManagerServiceImpl.28(this, localEmoticon));
      }
    }
  }
  
  public void clearAllRecommendExposeNum()
  {
    clearFixRecommendExposeNum();
    clearNotFixRecommendExposeNum();
  }
  
  public void clearCache()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "clearCache begins");
    }
    this.tabCache.clear();
    this.kanDianTabCache.clear();
    this.pkgCache.evictAll();
    this.emoticonCache.evictAll();
    this.subEmoticonsCache.evictAll();
    this.keywordEmoticonsCache.evictAll();
    Map localMap = this.hotWords;
    if (localMap != null) {
      localMap.clear();
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "clearCache ends");
    }
  }
  
  /* Error */
  public void clearEmotionKeyword(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 195	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: invokestatic 417	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +35 -> 46
    //   14: new 213	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   21: astore_2
    //   22: aload_2
    //   23: ldc_w 1241
    //   26: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload_2
    //   31: aload_1
    //   32: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: ldc 10
    //   38: iconst_2
    //   39: aload_2
    //   40: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: aload_0
    //   47: aload_1
    //   48: invokespecial 1076	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl:getEmotionKeywordData	(Ljava/lang/String;)Ljava/util/concurrent/CopyOnWriteArrayList;
    //   51: astore_1
    //   52: aload_1
    //   53: ifnonnull +4 -> 57
    //   56: return
    //   57: new 213	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   64: astore_3
    //   65: aload_3
    //   66: ldc_w 1243
    //   69: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: new 398	java/util/ArrayList
    //   76: dup
    //   77: invokespecial 477	java/util/ArrayList:<init>	()V
    //   80: astore_2
    //   81: aload_1
    //   82: invokeinterface 965 1 0
    //   87: astore 4
    //   89: aload 4
    //   91: invokeinterface 757 1 0
    //   96: ifeq +63 -> 159
    //   99: aload 4
    //   101: invokeinterface 761 1 0
    //   106: checkcast 375	com/tencent/mobileqq/data/EmotionKeyword
    //   109: astore 5
    //   111: aload 5
    //   113: ifnonnull +6 -> 119
    //   116: goto -27 -> 89
    //   119: aload 5
    //   121: getfield 1070	com/tencent/mobileqq/data/EmotionKeyword:exposeNum	I
    //   124: iconst_3
    //   125: if_icmplt -36 -> 89
    //   128: aload_0
    //   129: getfield 95	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl:needToDBEmotionKeyword	Ljava/util/List;
    //   132: aload 5
    //   134: invokeinterface 914 2 0
    //   139: pop
    //   140: aload_2
    //   141: aload 5
    //   143: invokeinterface 486 2 0
    //   148: pop
    //   149: aload_3
    //   150: aload 5
    //   152: invokevirtual 1026	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: goto -67 -> 89
    //   159: invokestatic 417	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   162: ifeq +13 -> 175
    //   165: ldc 10
    //   167: iconst_2
    //   168: aload_3
    //   169: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 203	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   175: aload_2
    //   176: invokeinterface 437 1 0
    //   181: ifle +169 -> 350
    //   184: aload_1
    //   185: aload_2
    //   186: invokeinterface 1247 2 0
    //   191: pop
    //   192: aload_0
    //   193: getfield 373	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   196: invokevirtual 1251	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   199: astore_1
    //   200: aload_1
    //   201: invokevirtual 1256	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   204: aload_2
    //   205: invokeinterface 965 1 0
    //   210: astore_2
    //   211: aload_2
    //   212: invokeinterface 757 1 0
    //   217: ifeq +75 -> 292
    //   220: aload_2
    //   221: invokeinterface 761 1 0
    //   226: checkcast 375	com/tencent/mobileqq/data/EmotionKeyword
    //   229: astore_3
    //   230: aload_3
    //   231: ifnull -20 -> 211
    //   234: aload_0
    //   235: getfield 373	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   238: ldc_w 375
    //   241: ldc_w 1258
    //   244: iconst_3
    //   245: anewarray 379	java/lang/String
    //   248: dup
    //   249: iconst_0
    //   250: aload_3
    //   251: getfield 1125	com/tencent/mobileqq/data/EmotionKeyword:epId	Ljava/lang/String;
    //   254: aastore
    //   255: dup
    //   256: iconst_1
    //   257: aload_3
    //   258: getfield 1126	com/tencent/mobileqq/data/EmotionKeyword:eId	Ljava/lang/String;
    //   261: aastore
    //   262: dup
    //   263: iconst_2
    //   264: aload_3
    //   265: getfield 1060	com/tencent/mobileqq/data/EmotionKeyword:keyword	Ljava/lang/String;
    //   268: aastore
    //   269: invokevirtual 964	com/tencent/mobileqq/persistence/EntityManager:find	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   272: checkcast 375	com/tencent/mobileqq/data/EmotionKeyword
    //   275: astore_3
    //   276: aload_3
    //   277: ifnull -66 -> 211
    //   280: aload_0
    //   281: getfield 373	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   284: aload_3
    //   285: invokevirtual 1260	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   288: pop
    //   289: goto -78 -> 211
    //   292: aload_1
    //   293: invokevirtual 1263	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   296: aload_1
    //   297: invokevirtual 1266	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   300: return
    //   301: astore_2
    //   302: goto +42 -> 344
    //   305: astore_2
    //   306: new 213	java/lang/StringBuilder
    //   309: dup
    //   310: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   313: astore_3
    //   314: aload_3
    //   315: ldc_w 1268
    //   318: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: pop
    //   322: aload_3
    //   323: aload_2
    //   324: invokevirtual 1271	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   327: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: ldc 10
    //   333: iconst_1
    //   334: aload_3
    //   335: invokevirtual 227	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokestatic 465	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   341: goto -45 -> 296
    //   344: aload_1
    //   345: invokevirtual 1266	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   348: aload_2
    //   349: athrow
    //   350: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	EmoticonManagerServiceImpl
    //   0	351	1	paramString	String
    //   21	200	2	localObject1	Object
    //   301	1	2	localObject2	Object
    //   305	44	2	localException	Exception
    //   64	271	3	localObject3	Object
    //   87	13	4	localIterator	Iterator
    //   109	42	5	localEmotionKeyword	EmotionKeyword
    // Exception table:
    //   from	to	target	type
    //   200	211	301	finally
    //   211	230	301	finally
    //   234	276	301	finally
    //   280	289	301	finally
    //   292	296	301	finally
    //   306	341	301	finally
    //   200	211	305	java/lang/Exception
    //   211	230	305	java/lang/Exception
    //   234	276	305	java/lang/Exception
    //   280	289	305	java/lang/Exception
    //   292	296	305	java/lang/Exception
  }
  
  protected void downloadPackageUncomplete(int paramInt, IEmojiManagerService paramIEmojiManagerService, EmoticonPackage paramEmoticonPackage, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleFetchEmoticonPackagesResp : emoPackage does not exists: ");
        localStringBuilder.append(paramEmoticonPackage.epId);
        QLog.i("EmoticonManager", 2, localStringBuilder.toString());
      }
      saveEmoticonPackage(paramEmoticonPackage);
      if (4 == paramEmoticonPackage.jobType) {
        paramIEmojiManagerService.startDownloadEmosmJson(paramEmoticonPackage.epId, EmojiManagerServiceConstant.JSON_EMOSM_MALL, null, true, paramInt);
      } else {
        paramIEmojiManagerService.startDownloadEmosmJson(paramEmoticonPackage.epId, EmojiManagerServiceConstant.JSON_EMOSM_MALL, null, false, paramInt);
      }
      if ((paramEmoticonPackage.jobType != 0) && (4 != paramEmoticonPackage.jobType))
      {
        paramIEmojiManagerService = EmosmUtils.b(2, paramEmoticonPackage.epId);
        paramEmoticonPackage = new File(EmosmUtils.a(2, paramEmoticonPackage.epId));
        if (!paramEmoticonPackage.exists())
        {
          paramIEmojiManagerService = new DownloadTask(paramIEmojiManagerService, paramEmoticonPackage);
          ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).getDownloader(1).startDownload(paramIEmojiManagerService, null, null);
        }
      }
      else
      {
        paramIEmojiManagerService.startCoverDownload(paramEmoticonPackage);
        return;
      }
    }
  }
  
  public EmoticonTab findEmoticonTabById(String paramString)
  {
    return (EmoticonTab)this.em.find(EmoticonTab.class, paramString);
  }
  
  public List<Emoticon> findKeywordEmotion(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "findKeywordEmotion");
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject = getRecentEmotionByKeyword(paramString);
    if (localObject != null) {
      localArrayList.add(localObject);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("findKeywordEmotion, find from local:");
    paramString = getEmotionKeywordData(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        EmotionKeyword localEmotionKeyword = (EmotionKeyword)paramString.next();
        if ((localEmotionKeyword != null) && (localEmotionKeyword.exposeNum < 3))
        {
          Emoticon localEmoticon = syncFindEmoticonById(localEmotionKeyword.epId, localEmotionKeyword.eId);
          if (localEmoticon == null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("findKeywordEmotion emoticon = null, epId = ");
            localStringBuilder.append(localEmotionKeyword.epId);
            localStringBuilder.append(",eId = ");
            localStringBuilder.append(localEmotionKeyword.eId);
            QLog.e("EmoticonManager", 1, localStringBuilder.toString());
          }
          if ((localEmoticon != null) && (!localArrayList.contains(localEmoticon)) && (isKeywordEmotionValid(localEmoticon.epId)))
          {
            localArrayList.add(localEmoticon);
            ((StringBuilder)localObject).append(localEmoticon.eId);
            ((StringBuilder)localObject).append(",");
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, ((StringBuilder)localObject).toString());
    }
    return localArrayList;
  }
  
  public int getExtensionSizeByScreenSize(String paramString)
  {
    Integer localInteger = (Integer)betterDisplaySize.get(Double.valueOf(fetchScreenInch()));
    if (localInteger != null)
    {
      if (localInteger.intValue() == 0) {
        return -1;
      }
      EmoticonPackage localEmoticonPackage = syncFindEmoticonPackageById(paramString);
      JSONObject localJSONObject = null;
      int i = 0;
      Object localObject1 = localJSONObject;
      Object localObject2;
      if (localEmoticonPackage != null)
      {
        localObject1 = localJSONObject;
        if (!TextUtils.isEmpty(localEmoticonPackage.supportSize)) {
          try
          {
            localObject1 = new JSONArray(localEmoticonPackage.supportSize);
          }
          catch (JSONException localJSONException)
          {
            QLog.e("EmoticonManager", 1, localJSONException, new Object[0]);
            localObject2 = localJSONObject;
          }
        }
      }
      if (localObject2 == null) {
        return -1;
      }
      try
      {
        while (i < ((JSONArray)localObject2).length())
        {
          localJSONObject = ((JSONArray)localObject2).getJSONObject(i);
          int j = localJSONObject.getInt("Width");
          int k = localJSONObject.getInt("Height");
          if ((j == localInteger.intValue()) && (k == localInteger.intValue()))
          {
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("get support size from db, betterSize ");
              ((StringBuilder)localObject2).append(localInteger);
              ((StringBuilder)localObject2).append(", epId: ");
              ((StringBuilder)localObject2).append(paramString);
              QLog.d("EmoticonManager", 2, ((StringBuilder)localObject2).toString());
            }
            i = localInteger.intValue();
            return i;
          }
          i += 1;
        }
        return -1;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public VipIPSiteInfo getIPSiteInfoFromBytes(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
    {
      localObject = Parcel.obtain();
      ((Parcel)localObject).unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
      ((Parcel)localObject).setDataPosition(0);
      paramArrayOfByte = (VipIPSiteInfo)VipIPSiteInfo.CREATOR.createFromParcel((Parcel)localObject);
      ((Parcel)localObject).recycle();
      return paramArrayOfByte;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getIPSiteInfoFromBytes, error data = ");
    ((StringBuilder)localObject).append(paramArrayOfByte);
    QLog.e("EmoticonManager", 1, ((StringBuilder)localObject).toString());
    return null;
  }
  
  public long getKeywordLastReqTime(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    long l = 0L;
    if (bool) {
      return 0L;
    }
    Object localObject;
    if (this.keywordReqTimeInfo.containsKey(paramString))
    {
      localObject = (EmoticonKeywords)this.keywordReqTimeInfo.get(paramString);
      if (localObject != null) {
        l = ((EmoticonKeywords)localObject).lastReqTime;
      }
    }
    else
    {
      localObject = (EmoticonKeywords)this.em.find(EmoticonKeywords.class, "keyword=?", new String[] { paramString });
      if (localObject != null)
      {
        l = ((EmoticonKeywords)localObject).lastReqTime;
        this.keywordReqTimeInfo.put(paramString, localObject);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getKeywordLastReqTime keyword = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", lastReqTime = ");
      ((StringBuilder)localObject).append(l);
      QLog.d("EmoticonManager", 2, ((StringBuilder)localObject).toString());
    }
    return l;
  }
  
  public int getKeywordTotalCount(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = (Integer)this.hotWords.get(paramString);
      if (paramString != null) {
        return paramString.intValue();
      }
    }
    return 0;
  }
  
  public List<String> getKeywordsByEmoticon(Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {
      return null;
    }
    try
    {
      localObject = new ArrayList();
      if (paramEmoticon.keywords != null) {
        paramEmoticon = new JSONArray(paramEmoticon.keywords);
      } else {
        paramEmoticon = new JSONArray();
      }
      if (paramEmoticon.length() > 0)
      {
        int i = 0;
        while (i < paramEmoticon.length())
        {
          String str = paramEmoticon.getString(i);
          if (!TextUtils.isEmpty(str)) {
            ((List)localObject).add(str);
          }
          i += 1;
        }
      }
      return localObject;
    }
    catch (Exception paramEmoticon)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getKeywordsByEmoticon exception e = ");
      ((StringBuilder)localObject).append(paramEmoticon.getMessage());
      QLog.e("EmoticonManager", 2, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public List<String> getLocalExposeNumFullKeyword(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getLocalExposeNumFullKeyword : ids,");
    paramString = getEmotionKeywordData(paramString);
    if (paramString != null)
    {
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        Object localObject = (EmotionKeyword)paramString.next();
        if ((localObject != null) && (((EmotionKeyword)localObject).exposeNum >= 3))
        {
          localObject = ((EmotionKeyword)localObject).eId;
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (!localArrayList.contains(localObject)))
          {
            localArrayList.add(localObject);
            localStringBuilder.append(",eId=");
            localStringBuilder.append((String)localObject);
          }
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, localStringBuilder.toString());
    }
    return localArrayList;
  }
  
  public List<EmoticonInfo> getMagicEmoticonInfoList(int paramInt)
  {
    Object localObject2 = new ArrayList();
    Object localObject3 = syncGetTabEmoticonPackages(paramInt);
    Object localObject1 = new ArrayList();
    int j = 0;
    if (localObject3 != null)
    {
      paramInt = 0;
      while (paramInt < ((List)localObject3).size())
      {
        localObject4 = (EmoticonPackage)((List)localObject3).get(paramInt);
        if ((3 == ((EmoticonPackage)localObject4).jobType) || (5 == ((EmoticonPackage)localObject4).jobType)) {
          ((List)localObject1).add(localObject4);
        }
        paramInt += 1;
      }
    }
    Object localObject4 = new ArrayList();
    localObject3 = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    paramInt = 0;
    int i;
    while (((Iterator)localObject1).hasNext())
    {
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject1).next();
      Object localObject5 = syncGetSubEmoticonsByPackageId(localEmoticonPackage.epId, false);
      if (localObject5 != null)
      {
        localObject5 = ((List)localObject5).iterator();
        i = paramInt;
        for (;;)
        {
          paramInt = i;
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          Emoticon localEmoticon = (Emoticon)((Iterator)localObject5).next();
          if (QLog.isColorLevel())
          {
            localObject6 = new StringBuilder();
            ((StringBuilder)localObject6).append("try to get pack data, id:");
            ((StringBuilder)localObject6).append(localEmoticonPackage.epId);
            ((StringBuilder)localObject6).append(",valid:");
            ((StringBuilder)localObject6).append(localEmoticonPackage.valid);
            ((StringBuilder)localObject6).append(",status:");
            ((StringBuilder)localObject6).append(localEmoticonPackage.status);
            QLog.d("EmoticonManager", 2, ((StringBuilder)localObject6).toString());
          }
          if (localEmoticonPackage.jobType == 3) {
            localEmoticon.jobType = 2;
          } else if (localEmoticonPackage.jobType == 5) {
            localEmoticon.jobType = 4;
          }
          if (!TextUtils.isEmpty(localEmoticonPackage.name)) {
            localEmoticon.name = localEmoticonPackage.name;
          }
          localEmoticon.value = localEmoticonPackage.valid;
          Object localObject6 = new PicEmoticonInfo(this.app.getCurrentAccountUin());
          ((PicEmoticonInfo)localObject6).type = 9;
          ((PicEmoticonInfo)localObject6).emoticon = localEmoticon;
          ((List)localObject2).add(localObject6);
          if ((localEmoticonPackage.valid) && (localEmoticonPackage.status == 2)) {
            ((List)localObject4).add(Integer.valueOf(i));
          } else {
            ((List)localObject3).add(Integer.valueOf(i));
          }
          i += 1;
        }
      }
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("getMagicEmoticonInfoList, emoticons is null, epId = ");
      ((StringBuilder)localObject5).append(localEmoticonPackage.epId);
      QLog.e("EmoticonManager", 1, ((StringBuilder)localObject5).toString());
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("comp size:");
      ((StringBuilder)localObject1).append(((List)localObject4).size());
      ((StringBuilder)localObject1).append(",inComp size:");
      ((StringBuilder)localObject1).append(((List)localObject3).size());
      QLog.d("EmoticonManager", 2, ((StringBuilder)localObject1).toString());
    }
    localObject1 = localObject2;
    if (((List)localObject4).size() > 0)
    {
      localObject1 = localObject2;
      if (((List)localObject3).size() > 0)
      {
        localObject1 = localObject2;
        if (((Integer)((List)localObject4).get(((List)localObject4).size() - 1)).intValue() > ((Integer)((List)localObject3).get(0)).intValue())
        {
          localObject1 = new ArrayList();
          paramInt = 0;
          for (;;)
          {
            i = j;
            if (paramInt >= ((List)localObject4).size()) {
              break;
            }
            ((List)localObject1).add(((List)localObject2).get(((Integer)((List)localObject4).get(paramInt)).intValue()));
            paramInt += 1;
          }
          while (i < ((List)localObject3).size())
          {
            ((List)localObject1).add(((List)localObject2).get(((Integer)((List)localObject3).get(i)).intValue()));
            i += 1;
          }
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("final size:");
      ((StringBuilder)localObject2).append(((List)localObject1).size());
      ((StringBuilder)localObject2).append(",inComp size:");
      ((StringBuilder)localObject2).append(((List)localObject3).size());
      QLog.d("EmoticonManager", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public QQLruCache<String, EmoticonPackage> getPkgCache()
  {
    return this.pkgCache;
  }
  
  public List<PromotionEmoticonPkg> getProEmoticonPkgs(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getProEmoticonPkgs isFromCache = ");
      ((StringBuilder)localObject1).append(paramBoolean1);
      ((StringBuilder)localObject1).append(" businessType = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" kanDianBiu = ");
      ((StringBuilder)localObject1).append(paramBoolean2);
      QLog.d("EmoticonManager", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject3 = null;
    Object localObject2 = null;
    int i;
    if (paramInt != 0) {
      if (paramInt != 1)
      {
        localObject2 = null;
        localObject1 = localObject2;
        i = 0;
      }
    }
    int j;
    for (;;)
    {
      j = 0;
      break;
      if (this.recommendRspMap.indexOfKey(1) >= 0) {
        localObject1 = (EmosmPb.SubCmd0x5RspBQRecommend)this.recommendRspMap.get(paramInt);
      } else {
        localObject1 = null;
      }
      if (this.recommendPanelShowInfoMap.indexOfKey(1) >= 0) {
        localObject2 = (List)this.recommendPanelShowInfoMap.get(paramInt);
      }
      localObject3 = localObject2;
      i = 0;
      j = 1;
      localObject2 = localObject1;
      localObject1 = localObject3;
      break;
      if (this.recommendRspMap.indexOfKey(0) >= 0) {
        localObject1 = (EmosmPb.SubCmd0x5RspBQRecommend)this.recommendRspMap.get(paramInt);
      } else {
        localObject1 = null;
      }
      localObject2 = localObject3;
      if (this.recommendPanelShowInfoMap.indexOfKey(0) >= 0) {
        localObject2 = (List)this.recommendPanelShowInfoMap.get(paramInt);
      }
      localObject3 = localObject2;
      i = 1;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    if (paramBoolean1)
    {
      if ((paramBoolean2) && (localObject1 != null))
      {
        localObject2 = new ArrayList();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (PromotionEmoticonPkg)((Iterator)localObject1).next();
          if (((PromotionEmoticonPkg)localObject3).type == 6) {
            ((List)localObject2).add(localObject3);
          }
        }
        return localObject2;
      }
      return localObject1;
    }
    localObject2 = getPromotionEmoticonPkgs(paramInt, (EmosmPb.SubCmd0x5RspBQRecommend)localObject2);
    if (i != 0) {
      this.recommendPanelShowInfoMap.put(0, localObject2);
    } else if (j != 0) {
      this.recommendPanelShowInfoMap.put(1, localObject2);
    }
    if ((paramBoolean2) && (localObject2 != null))
    {
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (PromotionEmoticonPkg)((Iterator)localObject2).next();
        if (((PromotionEmoticonPkg)localObject3).type == 6) {
          ((List)localObject1).add(localObject3);
        }
      }
      return localObject1;
    }
    return localObject2;
  }
  
  public Emoticon getRecentEmotionByKeyword(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getRecentEmotionByKeyword, keyword = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("EmoticonManager", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = getRecentEmotionData(paramString);
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      int i = 0;
      while (i < ((List)localObject1).size())
      {
        Object localObject2 = (RecentEmotion)((List)localObject1).get(i);
        if ((localObject2 != null) && (((RecentEmotion)localObject2).exposeNum < 3))
        {
          localObject2 = syncFindEmoticonById(((RecentEmotion)localObject2).epId, ((RecentEmotion)localObject2).eId);
          if ((localObject2 != null) && (isKeywordEmotionValid(((Emoticon)localObject2).epId)))
          {
            if (QLog.isColorLevel())
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("getRecentEmotionByKeyword, keyword = ");
              ((StringBuilder)localObject1).append(paramString);
              ((StringBuilder)localObject1).append(", emoticon = ");
              ((StringBuilder)localObject1).append(((Emoticon)localObject2).getMapKey());
              QLog.d("EmoticonManager", 2, ((StringBuilder)localObject1).toString());
            }
            return localObject2;
          }
        }
        i += 1;
      }
    }
    return null;
  }
  
  public String getSmallEmoticonDescription(String paramString1, String paramString2)
  {
    Object localObject = this.emoticonCache;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    localObject = (Emoticon)((QQLruCache)localObject).get(localStringBuilder.toString());
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("can not find small emotion in cache, but pkg in cache: epId = ");
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(", eId = ");
        ((StringBuilder)localObject).append(paramString2);
        QLog.d("EmoticonManager", 2, ((StringBuilder)localObject).toString());
      }
      runInCurrentThread(new EmoticonManagerServiceImpl.6(this, paramString1, paramString2), 5);
      return "";
    }
    return ((Emoticon)localObject).character;
  }
  
  public List<String> getTabCache()
  {
    return this.tabCache;
  }
  
  public boolean handleFetchEmoticonPackagesResp(boolean paramBoolean, int paramInt1, EmoticonResp paramEmoticonResp, int paramInt2)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("handleFetchEmoticonPackagesResp isSuccess = ");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append(" businessType = ");
    ((StringBuilder)localObject1).append(paramInt2);
    QLog.i("EmoticonManager", 1, ((StringBuilder)localObject1).toString());
    ArrayList localArrayList1;
    if ((paramInt1 == 2) && (paramBoolean))
    {
      localArrayList1 = new ArrayList();
      localArrayList1.addAll(paramEmoticonResp.data);
      localArrayList1.addAll(paramEmoticonResp.magicData);
      localArrayList1.addAll(paramEmoticonResp.smallEmoticonData);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder("handleFetchEmoticonPackagesResp, big emoticon list=");
        ((StringBuilder)localObject1).append(paramEmoticonResp.data);
        ((StringBuilder)localObject1).append("magic emoticon list=");
        ((StringBuilder)localObject1).append(paramEmoticonResp.magicData);
        ((StringBuilder)localObject1).append("small emoticon list=");
        ((StringBuilder)localObject1).append(paramEmoticonResp.smallEmoticonData);
        ((StringBuilder)localObject1).append("emoticon tab order list=");
        ((StringBuilder)localObject1).append(paramEmoticonResp.tabOrderList);
        ((StringBuilder)localObject1).append("roaming emoji size:");
        ((StringBuilder)localObject1).append(localArrayList1.size());
        QLog.d("EmoticonManager", 2, ((StringBuilder)localObject1).toString());
      }
      localObject1 = (IEmojiManagerService)this.app.getRuntimeService(IEmojiManagerService.class);
    }
    label778:
    label804:
    label810:
    label816:
    for (;;)
    {
      boolean bool1;
      try
      {
        ArrayList localArrayList2 = new ArrayList();
        paramInt1 = 0;
        bool1 = false;
        paramBoolean = false;
        boolean bool4 = bool1;
        boolean bool3 = paramBoolean;
        try
        {
          if (paramInt1 < localArrayList1.size())
          {
            bool4 = bool1;
            bool3 = paramBoolean;
            EmoticonPackage localEmoticonPackage1 = (EmoticonPackage)localArrayList1.get(paramInt1);
            bool4 = bool1;
            bool3 = paramBoolean;
            EmoticonPackage localEmoticonPackage2 = syncFindEmoticonPackageById(localEmoticonPackage1.epId, -1);
            if (localEmoticonPackage2 != null) {
              break label804;
            }
            bool2 = true;
            bool6 = bool2;
            bool4 = bool1;
            bool3 = paramBoolean;
            Object localObject2;
            if (isEmoticonMagic(localEmoticonPackage2))
            {
              bool4 = bool1;
              bool3 = paramBoolean;
              localObject2 = syncGetSubEmoticonsByPackageId(localEmoticonPackage2.epId, false);
              if (localObject2 == null) {
                break label810;
              }
              bool6 = bool2;
              bool4 = bool1;
              bool3 = paramBoolean;
              if (((List)localObject2).size() == 0) {
                break label810;
              }
            }
            bool2 = bool1;
            boolean bool5 = paramBoolean;
            bool4 = bool1;
            bool3 = paramBoolean;
            if (checkLocalEmoticonPackage(localEmoticonPackage1, localEmoticonPackage2))
            {
              bool4 = bool1;
              bool3 = paramBoolean;
              if (QLog.isColorLevel())
              {
                bool4 = bool1;
                bool3 = paramBoolean;
                localObject2 = new StringBuilder();
                bool4 = bool1;
                bool3 = paramBoolean;
                ((StringBuilder)localObject2).append("handleFetchEmoticonPackagesResp : updateLocalep epDb = ");
                bool4 = bool1;
                bool3 = paramBoolean;
                ((StringBuilder)localObject2).append(localEmoticonPackage2);
                bool4 = bool1;
                bool3 = paramBoolean;
                ((StringBuilder)localObject2).append(";ep = ");
                bool4 = bool1;
                bool3 = paramBoolean;
                ((StringBuilder)localObject2).append(localEmoticonPackage1);
                bool4 = bool1;
                bool3 = paramBoolean;
                QLog.d("EmoticonManager", 2, ((StringBuilder)localObject2).toString());
              }
              bool4 = bool1;
              bool3 = paramBoolean;
              localEmoticonPackage2.expiretime = localEmoticonPackage1.expiretime;
              bool4 = bool1;
              bool3 = paramBoolean;
              localEmoticonPackage2.valid = localEmoticonPackage1.valid;
              bool4 = bool1;
              bool3 = paramBoolean;
              localEmoticonPackage2.wordingId = localEmoticonPackage1.wordingId;
              bool4 = bool1;
              bool3 = paramBoolean;
              localEmoticonPackage2.jobType = localEmoticonPackage1.jobType;
              bool4 = bool1;
              bool3 = paramBoolean;
              if (!localEmoticonPackage1.aio) {
                break label816;
              }
              bool4 = bool1;
              bool3 = paramBoolean;
              localEmoticonPackage2.aio = true;
              bool4 = bool1;
              bool3 = paramBoolean;
              if (localEmoticonPackage1.kandian)
              {
                bool4 = bool1;
                bool3 = paramBoolean;
                localEmoticonPackage2.kandian = true;
              }
              bool4 = bool1;
              bool3 = paramBoolean;
              localArrayList2.add(localEmoticonPackage2);
              try
              {
                int i = localEmoticonPackage1.jobType;
                if (i == 3)
                {
                  bool2 = true;
                  bool5 = true;
                }
                else
                {
                  bool2 = true;
                  bool5 = paramBoolean;
                }
              }
              catch (Exception localException1)
              {
                bool1 = true;
                break label778;
              }
            }
            bool4 = bool2;
            bool3 = bool5;
            downloadPackageUncomplete(paramInt2, localException1, localEmoticonPackage1, bool6);
            paramInt1 += 1;
            bool1 = bool2;
            paramBoolean = bool5;
            continue;
          }
          bool4 = bool1;
          bool3 = paramBoolean;
          saveEmoticonPackages(localArrayList2);
        }
        catch (Exception localException2)
        {
          bool1 = bool4;
          paramBoolean = bool3;
        }
        QLog.e("EmoticonManager", 1, "handleFetchEmoticonPackagesResp", localException3);
      }
      catch (Exception localException3)
      {
        bool1 = false;
        paramBoolean = false;
      }
      updateEmoticonOrder(paramEmoticonResp, paramInt2, bool1, localArrayList1);
      return paramBoolean;
      return false;
      boolean bool2 = false;
      continue;
      boolean bool6 = true;
    }
  }
  
  public boolean isEpidInTabcache(String paramString)
  {
    return this.tabCache.contains(paramString);
  }
  
  public boolean isKeywordsInHotWordList(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isKeywordsInHotWordList keyword: ");
      localStringBuilder.append(MessageRecordUtil.a(paramString));
      QLog.d("EmoticonManager", 2, localStringBuilder.toString());
    }
    return (!TextUtils.isEmpty(paramString)) && (this.hotWords.get(paramString) != null);
  }
  
  public boolean isShowRecommendTabRedPoint(int paramInt)
  {
    if (!isRecommendRedpointEffective(paramInt))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 1, "isShowRecommendRedPoint red isRedEffective");
      }
      return false;
    }
    if (this.app.getApplication().getSharedPreferences("recommendEmotion_sp_name", 0).getBoolean("isClickRecommendRedpoint", false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonManager", 1, "isShowRecommendRedPoint is click");
      }
      return false;
    }
    Object localObject = null;
    if (paramInt != 0)
    {
      if ((paramInt == 1) && (this.recommendRspMap.indexOfKey(1) >= 0)) {
        localObject = (EmosmPb.SubCmd0x5RspBQRecommend)this.recommendRspMap.get(paramInt);
      }
    }
    else if (this.recommendRspMap.indexOfKey(0) >= 0) {
      localObject = (EmosmPb.SubCmd0x5RspBQRecommend)this.recommendRspMap.get(paramInt);
    }
    if (localObject == null)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isShowRecommendTabRedPoint recommendRsp == null, businessType = ");
        ((StringBuilder)localObject).append(paramInt);
        QLog.d("EmoticonManager", 2, ((StringBuilder)localObject).toString());
      }
      return false;
    }
    localObject = ((EmosmPb.SubCmd0x5RspBQRecommend)localObject).st_new_tab_info.get();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      paramInt = 0;
      int i;
      do
      {
        EmosmPb.STRecommendTabInfo localSTRecommendTabInfo;
        String str;
        do
        {
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localSTRecommendTabInfo = (EmosmPb.STRecommendTabInfo)((Iterator)localObject).next();
          str = String.valueOf(localSTRecommendTabInfo.u32_tab_id.get());
        } while (TextUtils.isEmpty(str));
        if ((localSTRecommendTabInfo.int32_red_point_flag.get() == 1) && ((!this.recommendExposeCount.containsKey(str)) || (((Integer)this.recommendExposeCount.get(str)).intValue() < EmoticonManagerConstants.RECOMMEND_EXPOSE_MAX)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("EmoticonManager", 2, "isShowRecommendRedPoint showRedpoint");
          }
          return true;
        }
        i = paramInt + 1;
        paramInt = i;
      } while (i < 2);
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "isShowRecommendRedPoint not show");
    }
    return false;
  }
  
  public boolean isWifiOrG3OrG4()
  {
    int i = NetworkUtil.getSystemNetwork(BaseApplication.getContext());
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isWifiOrG3OrG4 netType = ");
      localStringBuilder.append(i);
      QLog.d("EmoticonManager", 2, localStringBuilder.toString());
    }
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (i != 1)
    {
      bool1 = bool2;
      if (i != 3)
      {
        bool1 = bool2;
        if (i != 4)
        {
          if (i == 6) {
            return true;
          }
          bool1 = false;
        }
      }
    }
    return bool1;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = ((BaseQQAppInterface)paramAppRuntime);
    this.em = this.app.getEntityManagerFactory().createEntityManager();
    betterDisplaySize.put(Double.valueOf(4.7D), Integer.valueOf(300));
    paramAppRuntime = this.app.getApplication();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("recommendExposeCountSp_");
    localStringBuilder.append(this.app.getCurrentAccountUin());
    this.recommendExposeSp = paramAppRuntime.getSharedPreferences(localStringBuilder.toString(), 0);
    paramAppRuntime = this.app.getApplication();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("recommendFixExposeCountSp_");
    localStringBuilder.append(this.app.getCurrentAccountUin());
    this.fixRecommendExposSp = paramAppRuntime.getSharedPreferences(localStringBuilder.toString(), 0);
    this.uiHandler = new Handler(Looper.getMainLooper());
    paramAppRuntime = ThreadManager.getFileThreadLooper();
    if (paramAppRuntime != null) {
      this.fileThreadHandler = new Handler(paramAppRuntime);
    }
    if (paramAppRuntime != null) {
      this.dbThreadHandler = new Handler(paramAppRuntime);
    }
    this.app.addObserver(this.mVipStatusObserver);
    this.emotionKeywordCache = new EmoticonManagerServiceImpl.1(this, 1002, 0, 80);
    ThreadManager.postImmediately(new EmoticonManagerServiceImpl.2(this), null, true);
  }
  
  public void onDestroy()
  {
    this.app.removeObserver(this.mVipStatusObserver);
  }
  
  public void parseCloudKeywordsJson()
  {
    int i = ((ISVIPHandler)this.app.getBusinessHandler(((ISVIPHandlerProxy)QRoute.api(ISVIPHandlerProxy.class)).getImplClassName())).g();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseCloudKeywordsJson user vip type = ");
      ((StringBuilder)localObject).append(i);
      QLog.d("EmoticonManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.fileThreadHandler;
    if (localObject != null) {
      ((Handler)localObject).post(new EmoticonManagerServiceImpl.24(this, i));
    }
  }
  
  public byte[] parseIPSiteInfoToBytes(VipIPSiteInfo paramVipIPSiteInfo)
  {
    if (paramVipIPSiteInfo == null)
    {
      QLog.e("EmoticonManager", 1, "parseIPSiteInfoToBytes, error vipSiteInfo == null");
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    paramVipIPSiteInfo.writeToParcel(localParcel, 0);
    paramVipIPSiteInfo = localParcel.marshall();
    localParcel.recycle();
    return paramVipIPSiteInfo;
  }
  
  public void pushRecommendExposeInfoToSP()
  {
    pushFixRecommendExposeInfoToSP();
    pushNotFixRecommendExposeInfoToSP();
  }
  
  public List<Emoticon> queryBigEmoticonsFromDB()
  {
    return this.em.query(Emoticon.class, false, "jobType= ?", new String[] { "0" }, null, null, null, null);
  }
  
  public void reconstructAllTabEmoticonPackage(List<String> paramList, int paramInt)
  {
    int j = 0;
    int i = 0;
    String str;
    if (paramInt != 1)
    {
      this.tabCache.clear();
      j = paramList.size();
      paramInt = i;
      while (paramInt < j)
      {
        str = (String)paramList.get(paramInt);
        if (!this.tabCache.contains(str)) {
          this.tabCache.add(str);
        }
        paramInt += 1;
      }
    }
    this.kanDianTabCache.clear();
    i = paramList.size();
    paramInt = j;
    while (paramInt < i)
    {
      str = (String)paramList.get(paramInt);
      if (!this.kanDianTabCache.contains(str)) {
        this.kanDianTabCache.add(str);
      }
      paramInt += 1;
    }
    ThreadManager.post(new EmoticonManagerServiceImpl.17(this), 5, null, true);
  }
  
  /* Error */
  public void reconstructEmoticonPackage(String paramString, List<Emoticon> paramList)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 1123	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl:syncGetSubEmoticonsByPackageId	(Ljava/lang/String;)Ljava/util/List;
    //   5: checkcast 398	java/util/ArrayList
    //   8: astore 4
    //   10: aload_0
    //   11: getfield 373	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   14: invokevirtual 1251	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   17: astore_3
    //   18: aload_3
    //   19: invokevirtual 1256	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   22: aload 4
    //   24: ifnull +96 -> 120
    //   27: aload 4
    //   29: invokevirtual 1689	java/util/ArrayList:size	()I
    //   32: ifle +88 -> 120
    //   35: aload 4
    //   37: invokevirtual 752	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   40: astore 5
    //   42: aload 5
    //   44: invokeinterface 757 1 0
    //   49: ifeq +55 -> 104
    //   52: aload 5
    //   54: invokeinterface 761 1 0
    //   59: checkcast 880	com/tencent/mobileqq/data/Emoticon
    //   62: astore 6
    //   64: aload_0
    //   65: getfield 87	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl:emoticonCache	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   68: aload 6
    //   70: invokevirtual 888	com/tencent/mobileqq/data/Emoticon:getMapKey	()Ljava/lang/String;
    //   73: invokevirtual 1691	com/tencent/commonsdk/cache/QQLruCache:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   76: pop
    //   77: aload 6
    //   79: sipush 1001
    //   82: invokevirtual 1692	com/tencent/mobileqq/data/Emoticon:setStatus	(I)V
    //   85: aload_0
    //   86: getfield 373	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl:em	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   89: aload 6
    //   91: invokevirtual 1260	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   94: pop
    //   95: aload_0
    //   96: aload 6
    //   98: invokespecial 1694	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl:removeKeywordEmoticonCache	(Lcom/tencent/mobileqq/data/Emoticon;)V
    //   101: goto -59 -> 42
    //   104: aload 4
    //   106: invokevirtual 1695	java/util/ArrayList:clear	()V
    //   109: aload_0
    //   110: getfield 89	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl:subEmoticonsCache	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   113: aload_1
    //   114: aload 4
    //   116: invokevirtual 885	com/tencent/commonsdk/cache/QQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   119: pop
    //   120: aload_2
    //   121: ifnull +77 -> 198
    //   124: aload_2
    //   125: invokeinterface 437 1 0
    //   130: ifle +68 -> 198
    //   133: aload_0
    //   134: getfield 89	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl:subEmoticonsCache	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   137: aload_1
    //   138: aload_2
    //   139: invokevirtual 885	com/tencent/commonsdk/cache/QQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   142: pop
    //   143: aload_2
    //   144: invokeinterface 965 1 0
    //   149: astore_1
    //   150: aload_1
    //   151: invokeinterface 757 1 0
    //   156: ifeq +42 -> 198
    //   159: aload_1
    //   160: invokeinterface 761 1 0
    //   165: checkcast 880	com/tencent/mobileqq/data/Emoticon
    //   168: astore_2
    //   169: aload_2
    //   170: sipush 1000
    //   173: invokevirtual 1692	com/tencent/mobileqq/data/Emoticon:setStatus	(I)V
    //   176: aload_0
    //   177: aload_2
    //   178: invokespecial 139	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl:updateEntity	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   181: pop
    //   182: aload_0
    //   183: getfield 87	com/tencent/mobileqq/emosm/api/impl/EmoticonManagerServiceImpl:emoticonCache	Lcom/tencent/commonsdk/cache/QQLruCache;
    //   186: aload_2
    //   187: invokevirtual 888	com/tencent/mobileqq/data/Emoticon:getMapKey	()Ljava/lang/String;
    //   190: aload_2
    //   191: invokevirtual 885	com/tencent/commonsdk/cache/QQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   194: pop
    //   195: goto -45 -> 150
    //   198: aload_3
    //   199: invokevirtual 1263	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   202: goto +12 -> 214
    //   205: astore_1
    //   206: goto +13 -> 219
    //   209: astore_1
    //   210: aload_1
    //   211: invokevirtual 1696	java/lang/Exception:printStackTrace	()V
    //   214: aload_3
    //   215: invokevirtual 1266	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   218: return
    //   219: aload_3
    //   220: invokevirtual 1266	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   223: goto +5 -> 228
    //   226: aload_1
    //   227: athrow
    //   228: goto -2 -> 226
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	this	EmoticonManagerServiceImpl
    //   0	231	1	paramString	String
    //   0	231	2	paramList	List<Emoticon>
    //   17	203	3	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   8	107	4	localArrayList	ArrayList
    //   40	13	5	localIterator	Iterator
    //   62	35	6	localEmoticon	Emoticon
    // Exception table:
    //   from	to	target	type
    //   18	22	205	finally
    //   27	42	205	finally
    //   42	101	205	finally
    //   104	120	205	finally
    //   124	150	205	finally
    //   150	195	205	finally
    //   198	202	205	finally
    //   210	214	205	finally
    //   18	22	209	java/lang/Exception
    //   27	42	209	java/lang/Exception
    //   42	101	209	java/lang/Exception
    //   104	120	209	java/lang/Exception
    //   124	150	209	java/lang/Exception
    //   150	195	209	java/lang/Exception
    //   198	202	209	java/lang/Exception
  }
  
  public void recordRecommendEpExpose(PromotionEmoticonPkg paramPromotionEmoticonPkg)
  {
    if (paramPromotionEmoticonPkg != null)
    {
      if (TextUtils.isEmpty(paramPromotionEmoticonPkg.id)) {
        return;
      }
      int i = getRecommendExposeNum(paramPromotionEmoticonPkg.id, paramPromotionEmoticonPkg.isFixedEmoticon);
      if (paramPromotionEmoticonPkg.isFixedEmoticon) {
        this.fixRecommendExposeCount.put(paramPromotionEmoticonPkg.id, Integer.valueOf(i + 1));
      } else {
        this.recommendExposeCount.put(paramPromotionEmoticonPkg.id, Integer.valueOf(i + 1));
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("recordRecommendEpExpose epid = ");
        localStringBuilder.append(paramPromotionEmoticonPkg.id);
        localStringBuilder.append(";exposeNum = ");
        localStringBuilder.append(i + 1);
        QLog.d("EmoticonManager", 2, localStringBuilder.toString());
      }
    }
  }
  
  public boolean removeEmoticonPackage(EmoticonPackage paramEmoticonPackage)
  {
    paramEmoticonPackage.setStatus(1001);
    this.em.remove(paramEmoticonPackage);
    this.pkgCache.remove(paramEmoticonPackage.epId);
    return true;
  }
  
  public void removeKeywordEmoticonsCache(String arg1)
  {
    Object localObject1 = syncGetSubEmoticonsByPackageId(???);
    if (localObject1 == null) {
      return;
    }
    synchronized (this.keywordEmoticonsCache)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Emoticon localEmoticon = (Emoticon)((Iterator)localObject1).next();
        List localList = (List)this.keywordEmoticonsCache.get(localEmoticon.name);
        if ((localList != null) && (localList.contains(localEmoticon)))
        {
          localList.remove(localEmoticon);
          this.keywordEmoticonsCache.put(localEmoticon.name, localList);
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void removeTabEmoticonPackage(String paramString, int paramInt)
  {
    boolean bool1 = false;
    boolean bool2;
    if (paramInt != 1)
    {
      this.tabCache.remove(paramString);
      bool2 = false;
      bool1 = true;
    }
    else
    {
      this.kanDianTabCache.remove(paramString);
      bool2 = true;
    }
    ThreadManager.post(new EmoticonManagerServiceImpl.16(this, paramString, bool1, bool2), 5, null, true);
  }
  
  public void reportSwitchSpeakerPhoneClick(ChatMessage paramChatMessage, BaseSessionInfo paramBaseSessionInfo, boolean paramBoolean)
  {
    if ((paramChatMessage instanceof MessageForMarketFace))
    {
      paramChatMessage = (MessageForMarketFace)paramChatMessage;
      if (paramChatMessage.isNewSoundType()) {
        asyncGetEmoticonInfo(paramChatMessage.mMarkFaceMessage, new EmoticonManagerServiceImpl.3(this, paramBoolean, paramBaseSessionInfo));
      }
    }
  }
  
  public void saveAndUpdateRecommendEmosInfo(EmosmPb.SubCmd0x5RspBQRecommend paramSubCmd0x5RspBQRecommend, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "saveAndUpdateRecommendEmosInfo");
    }
    this.uiHandler.post(new EmoticonManagerServiceImpl.25(this, paramSubCmd0x5RspBQRecommend, paramInt));
  }
  
  public void saveEmoticon(Emoticon paramEmoticon)
  {
    if (paramEmoticon == null) {
      return;
    }
    runInCurrentThread(new EmoticonManagerServiceImpl.9(this, paramEmoticon), 8);
  }
  
  public void saveEmoticonPackage(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage != null)
    {
      this.pkgCache.put(paramEmoticonPackage.epId, paramEmoticonPackage);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveEmoticonPackages, pkgCache.size:");
        localStringBuilder.append(this.pkgCache.size());
        localStringBuilder.append(",epId:");
        localStringBuilder.append(paramEmoticonPackage.epId);
        localStringBuilder.append(",status:");
        localStringBuilder.append(paramEmoticonPackage.getStatus());
        QLog.d("EmoticonManager", 2, localStringBuilder.toString());
      }
      runInCurrentThread(new EmoticonManagerServiceImpl.8(this, paramEmoticonPackage), 8);
    }
  }
  
  public void saveEmoticonPackageKeywordJson(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      paramString2 = new StringBuilder();
      paramString2.append("saveEmoticonPackageKeywordJson epId = ");
      paramString2.append(paramString1);
      paramString2.append(" businessType = ");
      paramString2.append(paramInt3);
      QLog.i("EmoticonManager", 2, paramString2.toString());
    }
    paramString2 = syncFindTabEmoticonPackageById(paramString1, paramInt3);
    if (paramString2 == null) {
      return;
    }
    paramString2.jsonVersion = paramInt1;
    saveEmoticonPackage(paramString2);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("==========KeywordJsonUpdate============");
      localStringBuilder.append(paramString1);
      QLog.d("EmoticonManager", 2, localStringBuilder.toString());
    }
    ((IEmojiManagerService)this.app.getRuntimeService(IEmojiManagerService.class)).startDownloadEmosmJson(paramString2.epId, EmojiManagerServiceConstant.JSON_EMOSM_KEYWORD, paramInt3);
  }
  
  public void saveEmoticonPackages(List<EmoticonPackage> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)localIterator.next();
        if (localEmoticonPackage != null)
        {
          this.pkgCache.put(localEmoticonPackage.epId, localEmoticonPackage);
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("saveEmoticonPackages, pkgCache.size:");
            localStringBuilder.append(this.pkgCache.size());
            localStringBuilder.append(",epId:");
            localStringBuilder.append(localEmoticonPackage.epId);
            QLog.d("EmoticonManager", 2, localStringBuilder.toString());
          }
        }
      }
      ThreadManager.post(new EmoticonManagerServiceImpl.7(this, paramList), 5, null, true);
    }
  }
  
  public void saveEmoticonPkgUpdateStatus(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("saveEmoticonPkgUpdateStatus epId = ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" businessType = ");
      ((StringBuilder)localObject).append(paramInt3);
      QLog.i("EmoticonManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = syncFindTabEmoticonPackageById(paramString1, paramInt3);
    if (localObject != null)
    {
      paramInt3 = ((EmoticonPackage)localObject).latestVersion;
      ((EmoticonPackage)localObject).updateFlag = paramInt2;
      ((EmoticonPackage)localObject).updateTip = paramString2;
      ((EmoticonPackage)localObject).latestVersion = paramInt1;
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("epId=");
        paramString2.append(paramString1);
        paramString2.append(" localVersion=");
        paramString2.append(((EmoticonPackage)localObject).localVersion);
        paramString2.append(" version=");
        paramString2.append(paramInt1);
        paramString2.append(" updateFlag: ");
        paramString2.append(paramInt2);
        paramString2.append(" latestVersion= ");
        paramString2.append(paramInt3);
        QLog.d("EmoticonManager", 2, paramString2.toString());
      }
      if ((EmoticonPanelUtils.a(paramInt2)) && (paramInt3 < paramInt1))
      {
        ((EmoticonPackage)localObject).hasReadUpdatePage = false;
        saveEmoticonPackage((EmoticonPackage)localObject);
      }
    }
  }
  
  public void saveEmoticons(List<Emoticon> paramList)
  {
    if (paramList == null) {
      return;
    }
    runInCurrentThread(new EmoticonManagerServiceImpl.10(this, paramList), 8);
  }
  
  public void saveEmotionKeywordToDB()
  {
    if (this.needToDBEmotionKeyword.size() < 1) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "saveEmotionKeywordToDB");
    }
    List localList = this.needToDBEmotionKeyword;
    if (localList.size() > 0)
    {
      Handler localHandler = this.dbThreadHandler;
      if (localHandler != null) {
        localHandler.post(new EmoticonManagerServiceImpl.21(this, localList));
      }
    }
  }
  
  public void saveRecentEmotionToDB()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonManager", 2, "saveRecentEmotionToDB start");
    }
    if (this.needToDBRecentEmotion.size() < 1) {
      return;
    }
    ArrayList localArrayList = new ArrayList(this.needToDBRecentEmotion);
    this.needToDBRecentEmotion.clear();
    if (localArrayList.size() > 0)
    {
      Handler localHandler = this.dbThreadHandler;
      if (localHandler != null) {
        localHandler.post(new EmoticonManagerServiceImpl.20(this, localArrayList));
      }
    }
  }
  
  public void setHasReadUpdatePage(String paramString, Boolean paramBoolean, int paramInt)
  {
    paramString = syncFindTabEmoticonPackageById(paramString, paramInt);
    if ((paramString != null) && (paramString.hasReadUpdatePage != paramBoolean.booleanValue()))
    {
      paramString.hasReadUpdatePage = paramBoolean.booleanValue();
      saveEmoticonPackage(paramString);
    }
  }
  
  public void setRecommendEpRedFlag(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    EmosmPb.SubCmd0x5RspBQRecommend localSubCmd0x5RspBQRecommend = null;
    if (paramInt != 0)
    {
      if ((paramInt == 1) && (this.recommendRspMap.indexOfKey(1) >= 0)) {
        localSubCmd0x5RspBQRecommend = (EmosmPb.SubCmd0x5RspBQRecommend)this.recommendRspMap.get(paramInt);
      }
    }
    else if (this.recommendRspMap.indexOfKey(0) >= 0) {
      localSubCmd0x5RspBQRecommend = (EmosmPb.SubCmd0x5RspBQRecommend)this.recommendRspMap.get(paramInt);
    }
    if (localSubCmd0x5RspBQRecommend == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setRecommendEpRedFlag epid = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("EmoticonManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = localSubCmd0x5RspBQRecommend.st_new_tab_info.get();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      Iterator localIterator = ((List)localObject).iterator();
      while (localIterator.hasNext())
      {
        EmosmPb.STRecommendTabInfo localSTRecommendTabInfo = (EmosmPb.STRecommendTabInfo)localIterator.next();
        if (paramString.equals(String.valueOf(localSTRecommendTabInfo.u32_tab_id.get()))) {
          localSTRecommendTabInfo.int32_red_point_flag.set(0);
        }
      }
    }
    localSubCmd0x5RspBQRecommend.st_new_tab_info.set((List)localObject);
  }
  
  public Emoticon syncFindEmoticonById(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("syncFindEmoticonById epId = ");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(", eId = ");
      ((StringBuilder)localObject1).append(paramString2);
      QLog.d("EmoticonManager", 2, ((StringBuilder)localObject1).toString());
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      localObject1 = this.emoticonCache;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString1);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(paramString2);
      localObject2 = (Emoticon)((QQLruCache)localObject1).get(((StringBuilder)localObject2).toString());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = (Emoticon)this.em.find(Emoticon.class, "epId=? and eId=?", new String[] { paramString1, paramString2 });
        if (localObject2 != null)
        {
          this.emoticonCache.put(((Emoticon)localObject2).getMapKey(), localObject2);
          return localObject2;
        }
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("can not findEmoticonById epId = ");
          ((StringBuilder)localObject1).append(paramString1);
          ((StringBuilder)localObject1).append(", eId = ");
          ((StringBuilder)localObject1).append(paramString2);
          QLog.d("EmoticonManager", 2, ((StringBuilder)localObject1).toString());
          localObject1 = localObject2;
        }
      }
      return localObject1;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("syncFindEmoticonById error epId = ");
    ((StringBuilder)localObject1).append(paramString1);
    ((StringBuilder)localObject1).append(",eId = ");
    ((StringBuilder)localObject1).append(paramString2);
    QLog.e("EmoticonManager", 1, ((StringBuilder)localObject1).toString());
    return null;
  }
  
  public EmoticonPackage syncFindEmoticonPackageById(String paramString)
  {
    return syncFindEmoticonPackageById(paramString, 0);
  }
  
  public EmoticonPackage syncFindEmoticonPackageById(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("syncFindEmoticonPackageById epId = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", type = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("EmoticonManager", 2, ((StringBuilder)localObject).toString());
    }
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)this.pkgCache.get(paramString);
    Object localObject = localEmoticonPackage;
    if (localEmoticonPackage == null)
    {
      localEmoticonPackage = (EmoticonPackage)this.em.find(EmoticonPackage.class, paramString);
      if (localEmoticonPackage != null)
      {
        this.pkgCache.put(paramString, localEmoticonPackage);
        localObject = localEmoticonPackage;
      }
      else
      {
        localObject = localEmoticonPackage;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("can not find package:");
          ((StringBuilder)localObject).append(paramString);
          QLog.d("EmoticonManager", 2, ((StringBuilder)localObject).toString());
          localObject = localEmoticonPackage;
        }
      }
    }
    if (localObject != null)
    {
      if (paramInt == -1) {
        return localObject;
      }
      localEmoticonPackage = null;
      paramString = null;
      if (paramInt == 0)
      {
        if (((EmoticonPackage)localObject).aio) {
          paramString = (String)localObject;
        }
        return paramString;
      }
      if (paramInt == 1)
      {
        paramString = localEmoticonPackage;
        if (((EmoticonPackage)localObject).kandian) {
          paramString = (String)localObject;
        }
        return paramString;
      }
    }
    return localObject;
  }
  
  public EmoticonPackage syncFindEmoticonPackageInCache(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("syncFindEmoticonPackageInCache epId = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", type = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("EmoticonManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (EmoticonPackage)this.pkgCache.get(paramString);
    paramString = (String)localObject;
    if (localObject != null)
    {
      if (paramInt == -1) {
        return localObject;
      }
      if (paramInt == 0)
      {
        if (((EmoticonPackage)localObject).aio) {
          return localObject;
        }
        return null;
      }
      paramString = (String)localObject;
      if (paramInt == 1)
      {
        if (((EmoticonPackage)localObject).kandian) {
          return localObject;
        }
        paramString = null;
      }
    }
    return paramString;
  }
  
  public EmoticonPackage syncFindTabEmoticonPackageById(String paramString)
  {
    return syncFindTabEmoticonPackageById(paramString, 0);
  }
  
  public EmoticonPackage syncFindTabEmoticonPackageById(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("syncFindTabEmoticonPackageById epId = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" businessType = ");
      localStringBuilder.append(paramInt);
      QLog.i("EmoticonManager", 2, localStringBuilder.toString());
    }
    if (paramString == null) {
      return null;
    }
    if (paramInt != 1)
    {
      if (this.tabCache.contains(paramString)) {
        return syncFindEmoticonPackageById(paramString, paramInt);
      }
    }
    else if (this.kanDianTabCache.contains(paramString)) {
      return syncFindEmoticonPackageById(paramString, paramInt);
    }
    return null;
  }
  
  public PicEmoticonInfo syncGetEmoticonInfo(MarkFaceMessage paramMarkFaceMessage)
  {
    if (paramMarkFaceMessage == null) {
      return null;
    }
    Object localObject1 = EmosmUtils.a(paramMarkFaceMessage.sbufID, paramMarkFaceMessage.mediaType);
    if (localObject1 == null) {
      return null;
    }
    String str = String.valueOf(paramMarkFaceMessage.dwTabID);
    int i = paramMarkFaceMessage.imageWidth;
    int j = paramMarkFaceMessage.imageHeight;
    Object localObject2 = syncFindEmoticonById(str, (String)localObject1);
    if (localObject2 != null)
    {
      localObject1 = new PicEmoticonInfo(this.app.getCurrentAccountUin());
      ((PicEmoticonInfo)localObject1).type = 6;
      ((PicEmoticonInfo)localObject1).emoticon = ((Emoticon)localObject2);
      ((PicEmoticonInfo)localObject1).isAPNG = paramMarkFaceMessage.isAPNG;
      ((Emoticon)localObject2).encryptKey = new String(paramMarkFaceMessage.sbfKey);
      if (((Emoticon)localObject2).width == 0) {
        ((Emoticon)localObject2).width = i;
      }
      if (((Emoticon)localObject2).height == 0) {
        ((Emoticon)localObject2).height = j;
      }
      if ((paramMarkFaceMessage.mobileparam != null) && (paramMarkFaceMessage.mobileparam.length > 0))
      {
        ((Emoticon)localObject2).jobType = 2;
        ((Emoticon)localObject2).magicValue = new String(paramMarkFaceMessage.mobileparam);
      }
      if (paramMarkFaceMessage.mediaType == 3) {
        ((Emoticon)localObject2).jobType = 4;
      }
      if ((((Emoticon)localObject2).parseSoundPrintString() == null) || (((Emoticon)localObject2).parseSoundPrintString().isEmpty()))
      {
        ((Emoticon)localObject2).voicePrintItems = paramMarkFaceMessage.voicePrintItems;
        ((Emoticon)localObject2).voicePrint = ((Emoticon)localObject2).toSoundPrintString();
      }
      if (TextUtils.isEmpty(((Emoticon)localObject2).backColor)) {
        ((Emoticon)localObject2).backColor = paramMarkFaceMessage.backColor;
      }
      if (TextUtils.isEmpty(((Emoticon)localObject2).volumeColor)) {
        ((Emoticon)localObject2).volumeColor = paramMarkFaceMessage.volumeColor;
      }
      ((PicEmoticonInfo)localObject1).imageType = paramMarkFaceMessage.cSubType;
      addExtensionSizeByScreenSize(str, (Emoticon)localObject2, paramMarkFaceMessage.resvAttr);
      return localObject1;
    }
    localObject2 = new PicEmoticonInfo(this.app.getCurrentAccountUin());
    ((PicEmoticonInfo)localObject2).type = 6;
    ((PicEmoticonInfo)localObject2).isAPNG = paramMarkFaceMessage.isAPNG;
    Emoticon localEmoticon = new Emoticon();
    if (paramMarkFaceMessage.mediaType == 1) {
      localEmoticon.isSound = true;
    } else if (paramMarkFaceMessage.mediaType == 2) {
      localEmoticon.jobType = 1;
    } else if (paramMarkFaceMessage.mediaType == 3) {
      localEmoticon.jobType = 4;
    }
    if ((paramMarkFaceMessage.mobileparam != null) && (paramMarkFaceMessage.mobileparam.length > 0))
    {
      localEmoticon.jobType = 2;
      localEmoticon.magicValue = new String(paramMarkFaceMessage.mobileparam);
    }
    localEmoticon.epId = str;
    localEmoticon.eId = ((String)localObject1);
    localEmoticon.encryptKey = new String(paramMarkFaceMessage.sbfKey);
    localEmoticon.width = i;
    localEmoticon.height = j;
    localEmoticon.name = paramMarkFaceMessage.faceName;
    localEmoticon.volumeColor = paramMarkFaceMessage.volumeColor;
    localEmoticon.backColor = paramMarkFaceMessage.backColor;
    localEmoticon.voicePrintItems = paramMarkFaceMessage.voicePrintItems;
    localEmoticon.voicePrint = localEmoticon.toSoundPrintString();
    ((PicEmoticonInfo)localObject2).emoticon = localEmoticon;
    ((PicEmoticonInfo)localObject2).imageType = paramMarkFaceMessage.cSubType;
    addExtensionSizeByScreenSize(null, localEmoticon, paramMarkFaceMessage.resvAttr);
    return localObject2;
  }
  
  public List<Emoticon> syncGetEmoticonsByKeyword(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    ArrayList localArrayList = (ArrayList)this.keywordEmoticonsCache.get(paramString);
    Object localObject;
    if (localArrayList == null)
    {
      localObject = queryEmoticonsByKeyWordFromDB(paramString);
    }
    else
    {
      localObject = localArrayList;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("syncGetEmoticonsByKeyword from cache arrEmoticon.size:");
        ((StringBuilder)localObject).append(localArrayList.size());
        ((StringBuilder)localObject).append(",keyWord: ");
        ((StringBuilder)localObject).append(MessageRecordUtil.a(paramString));
        QLog.d("EmoticonManager", 2, ((StringBuilder)localObject).toString());
        localObject = localArrayList;
      }
    }
    if ((paramBoolean) && (localObject != null) && (!((ArrayList)localObject).isEmpty())) {
      return (List)((ArrayList)localObject).clone();
    }
    return localObject;
  }
  
  public List<Emoticon> syncGetSubEmoticonsByPackageId(String paramString)
  {
    return syncGetSubEmoticonsByPackageId(paramString, false);
  }
  
  public List<Emoticon> syncGetSubEmoticonsByPackageId(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    ArrayList localArrayList = (ArrayList)this.subEmoticonsCache.get(paramString);
    Object localObject;
    if (localArrayList == null)
    {
      localObject = queryEmoticonsByPackageIdFromDB(paramString);
    }
    else
    {
      localObject = localArrayList;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("syncGetSubEmoticonsByPackageId from cache subEmoticonsCache.size:");
        ((StringBuilder)localObject).append(this.subEmoticonsCache.size());
        ((StringBuilder)localObject).append(",epId:");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("EmoticonManager", 2, ((StringBuilder)localObject).toString());
        localObject = localArrayList;
      }
    }
    if ((localObject != null) && (paramBoolean)) {
      return (List)((ArrayList)localObject).clone();
    }
    return localObject;
  }
  
  public List<EmoticonPackage> syncGetTabEmoticonPackages()
  {
    return syncGetTabEmoticonPackages(0);
  }
  
  public List<EmoticonPackage> syncGetTabEmoticonPackages(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("syncGetTabEmoticonPackages begins, kanDianTabCache.size:");
      ((StringBuilder)localObject1).append(this.kanDianTabCache.size());
      ((StringBuilder)localObject1).append(" tabCache.size:");
      ((StringBuilder)localObject1).append(this.tabCache.size());
      ((StringBuilder)localObject1).append(",pkgCache.size:");
      ((StringBuilder)localObject1).append(this.pkgCache.size());
      ((StringBuilder)localObject1).append(" businessType = ");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("EmoticonManager", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new ArrayList();
    Object localObject3;
    if (paramInt != 1)
    {
      localObject2 = this.tabCache.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (String)((Iterator)localObject2).next();
        if (localObject3 != null)
        {
          localObject3 = syncFindEmoticonPackageById((String)localObject3, paramInt);
          if (localObject3 != null) {
            ((ArrayList)localObject1).add(localObject3);
          }
        }
      }
    }
    Object localObject2 = this.kanDianTabCache.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (String)((Iterator)localObject2).next();
      if (localObject3 != null)
      {
        localObject3 = syncFindEmoticonPackageById((String)localObject3, paramInt);
        if (localObject3 != null) {
          ((ArrayList)localObject1).add(localObject3);
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("syncGetTabEmoticonPackages ends, list.size:");
      ((StringBuilder)localObject2).append(((ArrayList)localObject1).size());
      QLog.d("EmoticonManager", 2, ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public void syncIncreaseEmoticonExposeNum(IStickerRecEmoticon paramIStickerRecEmoticon)
  {
    if ((paramIStickerRecEmoticon instanceof StickerRecLocalData))
    {
      paramIStickerRecEmoticon = (StickerRecLocalData)paramIStickerRecEmoticon;
      if (paramIStickerRecEmoticon.a == null) {
        return;
      }
      paramIStickerRecEmoticon = paramIStickerRecEmoticon.a;
      Object localObject = (List)this.keywordEmoticonsCache.get(paramIStickerRecEmoticon.name);
      if (localObject == null)
      {
        paramIStickerRecEmoticon.increaseExposeNum();
        this.emoticonCache.put(paramIStickerRecEmoticon.getMapKey(), paramIStickerRecEmoticon);
        this.em.update(paramIStickerRecEmoticon);
        return;
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Emoticon localEmoticon = (Emoticon)((Iterator)localObject).next();
        if ((localEmoticon != null) && (paramIStickerRecEmoticon.getMapKey().equals(localEmoticon.getMapKey())))
        {
          localEmoticon.increaseExposeNum();
          this.emoticonCache.put(localEmoticon.getMapKey(), localEmoticon);
          this.em.update(localEmoticon);
        }
      }
    }
  }
  
  public void syncPcTabEmoticonPackage(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("syncPcTabEmoticonPackage epId = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" businessType = ");
      localStringBuilder.append(paramInt);
      QLog.i("EmoticonManager", 2, localStringBuilder.toString());
    }
    if (paramString == null) {
      return;
    }
    if (paramInt != 1)
    {
      if (!this.tabCache.contains(paramString))
      {
        this.tabCache.add(0, paramString);
        ThreadManager.post(new EmoticonManagerServiceImpl.14(this, paramString), 5, null, true);
      }
    }
    else if (!this.kanDianTabCache.contains(paramString))
    {
      this.kanDianTabCache.add(0, paramString);
      ThreadManager.post(new EmoticonManagerServiceImpl.13(this, paramString), 5, null, true);
    }
  }
  
  protected void updateEmoticonOrder(EmoticonResp paramEmoticonResp, int paramInt, boolean paramBoolean, List<EmoticonPackage> paramList)
  {
    if ((paramList.size() > 0) && (paramEmoticonResp.tabOrderList.size() == 0))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleFetchEmoticonPackagesResp, svr data wrong, no order list, but allEpList.size()=");
        ((StringBuilder)localObject).append(paramList.size());
        QLog.e("EmoticonManager", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new ArrayList();
      int i = paramEmoticonResp.data.size() - 1;
      while (i >= 0)
      {
        paramList = (EmoticonPackage)paramEmoticonResp.data.get(i);
        if (paramList != null) {
          ((List)localObject).add(paramList.epId);
        }
        i -= 1;
      }
      i = paramEmoticonResp.magicData.size() - 1;
      while (i >= 0)
      {
        paramList = (EmoticonPackage)paramEmoticonResp.magicData.get(i);
        if (paramList != null) {
          ((List)localObject).add(paramList.epId);
        }
        i -= 1;
      }
      i = paramEmoticonResp.smallEmoticonData.size() - 1;
      for (;;)
      {
        paramList = (List<EmoticonPackage>)localObject;
        if (i < 0) {
          break;
        }
        paramList = (EmoticonPackage)paramEmoticonResp.smallEmoticonData.get(i);
        if (paramList != null) {
          ((List)localObject).add(paramList.epId);
        }
        i -= 1;
      }
    }
    paramList = paramEmoticonResp.tabOrderList;
    if (QLog.isColorLevel())
    {
      paramEmoticonResp = new StringBuilder();
      paramEmoticonResp.append("handleFetchEmoticonPackagesResp, save order, orderList=");
      paramEmoticonResp.append(paramList);
      paramEmoticonResp.append(",dataChanged: ");
      paramEmoticonResp.append(paramBoolean);
      QLog.d("EmoticonManager", 2, paramEmoticonResp.toString());
    }
    reconstructAllTabEmoticonPackage(paramList, paramInt);
    if (paramBoolean) {
      EmotionSharedPreUtils.a(this.app.getApp(), this.app.getCurrentUin(), System.currentTimeMillis());
    }
  }
  
  public void updateKeywordReqTime(EmoticonKeywords paramEmoticonKeywords)
  {
    if (paramEmoticonKeywords == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updateKeywordReqTime, emoticonKeywords = ");
      ((StringBuilder)localObject).append(paramEmoticonKeywords);
      QLog.d("EmoticonManager", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramEmoticonKeywords.keyword.toLowerCase();
    EmoticonKeywords localEmoticonKeywords = (EmoticonKeywords)this.keywordReqTimeInfo.get(localObject);
    if (localEmoticonKeywords != null)
    {
      localEmoticonKeywords.lastReqTime = paramEmoticonKeywords.lastReqTime;
      updateKeywordReqTimeToDB(localEmoticonKeywords);
      return;
    }
    this.keywordReqTimeInfo.put(localObject, paramEmoticonKeywords);
    updateKeywordReqTimeToDB(paramEmoticonKeywords);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl
 * JD-Core Version:    0.7.0.1
 */