package com.tencent.mobileqq.richmediabrowser;

import android.support.v4.util.ArraySet;
import android.text.TextUtils;
import com.tencent.mobileqq.comment.DanmuItemBean;
import com.tencent.mobileqq.comment.config.DanmuConfProcessor;
import com.tencent.mobileqq.comment.danmaku.CommentDanmakuManager;
import com.tencent.mobileqq.comment.danmaku.data.CommentDanmaku;
import com.tencent.mobileqq.danmaku.data.BaseDanmaku;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class BrowserDanmakuUtils
{
  public static List<BaseDanmaku> a(long paramLong1, long paramLong2, CommentDanmakuManager paramCommentDanmakuManager, ConcurrentHashMap<Long, Set<DanmuItemBean>> paramConcurrentHashMap)
  {
    paramConcurrentHashMap = (Set)paramConcurrentHashMap.get(Long.valueOf(paramLong1));
    if (paramConcurrentHashMap != null) {
      return a(a(paramConcurrentHashMap, paramLong2), paramCommentDanmakuManager);
    }
    return null;
  }
  
  public static List<BaseDanmaku> a(long paramLong, List<DanmuItemBean> paramList, CommentDanmakuManager paramCommentDanmakuManager, ConcurrentHashMap<Long, Set<DanmuItemBean>> paramConcurrentHashMap)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && (paramCommentDanmakuManager != null))
    {
      paramConcurrentHashMap = a(paramLong, paramList, paramConcurrentHashMap);
      if ((paramConcurrentHashMap != null) && (!paramConcurrentHashMap.isEmpty()))
      {
        paramList = new ArrayList();
        paramConcurrentHashMap = paramConcurrentHashMap.iterator();
        while (paramConcurrentHashMap.hasNext())
        {
          BaseDanmaku localBaseDanmaku = paramCommentDanmakuManager.a(new CommentDanmaku((DanmuItemBean)paramConcurrentHashMap.next()));
          if (localBaseDanmaku != null)
          {
            localBaseDanmaku.a(5000);
            localBaseDanmaku.e(true);
            paramList.add(localBaseDanmaku);
          }
        }
        return paramList;
      }
      return null;
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("BrowserDanmakuUtils", 4, "buildPictureDanmakuList list is null");
    return null;
  }
  
  public static List<BaseDanmaku> a(long paramLong1, List<DanmuItemBean> paramList, CommentDanmakuManager paramCommentDanmakuManager, ConcurrentHashMap<Long, Set<DanmuItemBean>> paramConcurrentHashMap, long paramLong2)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      return a(a(paramLong1, paramList, paramConcurrentHashMap, paramLong2), paramCommentDanmakuManager);
    }
    BrowserLogHelper.getInstance().getGalleryLog().d("BrowserDanmakuUtils", 4, "buildVideoDanmakuList list is null");
    return null;
  }
  
  private static List<DanmuItemBean> a(long paramLong, List<DanmuItemBean> paramList, ConcurrentHashMap<Long, Set<DanmuItemBean>> paramConcurrentHashMap)
  {
    Object localObject = (Set)paramConcurrentHashMap.get(Long.valueOf(paramLong));
    if (localObject == null)
    {
      localObject = new ArraySet();
      ((Set)localObject).addAll(paramList);
      paramConcurrentHashMap.put(Long.valueOf(paramLong), localObject);
      return paramList;
    }
    paramConcurrentHashMap.clear();
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      DanmuItemBean localDanmuItemBean = (DanmuItemBean)paramList.next();
      if (!((Set)localObject).contains(localDanmuItemBean)) {
        localArrayList.add(localDanmuItemBean);
      }
    }
    ((Set)localObject).addAll(localArrayList);
    paramConcurrentHashMap.put(Long.valueOf(paramLong), localObject);
    return localArrayList;
  }
  
  private static List<DanmuItemBean> a(long paramLong1, List<DanmuItemBean> paramList, ConcurrentHashMap<Long, Set<DanmuItemBean>> paramConcurrentHashMap, long paramLong2)
  {
    Set localSet = (Set)paramConcurrentHashMap.get(Long.valueOf(paramLong1));
    Object localObject = new ArraySet();
    ((Set)localObject).addAll(paramList);
    if (localSet == null)
    {
      paramConcurrentHashMap.put(Long.valueOf(paramLong1), localObject);
      return a((Set)localObject, paramLong2);
    }
    paramConcurrentHashMap.clear();
    paramList = new ArraySet();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      DanmuItemBean localDanmuItemBean = (DanmuItemBean)((Iterator)localObject).next();
      if (!localSet.contains(localDanmuItemBean)) {
        paramList.add(localDanmuItemBean);
      }
    }
    localSet.addAll(paramList);
    paramConcurrentHashMap.put(Long.valueOf(paramLong1), localSet);
    return a(paramList, paramLong2);
  }
  
  private static List<BaseDanmaku> a(List<DanmuItemBean> paramList, CommentDanmakuManager paramCommentDanmakuManager)
  {
    if ((paramList != null) && (!paramList.isEmpty()) && (paramCommentDanmakuManager != null))
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (DanmuItemBean)paramList.next();
        CommentDanmaku localCommentDanmaku = new CommentDanmaku((DanmuItemBean)localObject);
        BaseDanmaku localBaseDanmaku = paramCommentDanmakuManager.a(localCommentDanmaku);
        if (localBaseDanmaku != null)
        {
          localBaseDanmaku.b(((DanmuItemBean)localObject).c);
          if (!TextUtils.isEmpty(localCommentDanmaku.a))
          {
            localObject = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
            if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(localCommentDanmaku.a))) {
              localBaseDanmaku.e(true);
            }
          }
          localArrayList.add(localBaseDanmaku);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  private static List<DanmuItemBean> a(Set<DanmuItemBean> paramSet, long paramLong)
  {
    if ((paramSet != null) && (!paramSet.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList();
      paramSet = paramSet.iterator();
      while (paramSet.hasNext())
      {
        DanmuItemBean localDanmuItemBean = (DanmuItemBean)paramSet.next();
        if (localDanmuItemBean.c + 1000L >= paramLong) {
          localArrayList.add(localDanmuItemBean);
        }
      }
      return localArrayList;
    }
    return null;
  }
  
  public static boolean a()
  {
    return (DanmuConfProcessor.a()) && (ParamsManager.a().a() == 1);
  }
  
  public static boolean a(RichMediaBrowserInfo paramRichMediaBrowserInfo)
  {
    if (!DanmuConfProcessor.a()) {
      return false;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("shouldShowDanmakuBtn, paramsManager.isFromMultiMsg() = ");
      localStringBuilder.append(ParamsManager.a().d());
      localStringBuilder.append(" , paramsManager.getmCurType() = ");
      localStringBuilder.append(ParamsManager.a().a());
      localStringBuilder.append(" , paramsManager.getSourceEntrance() = ");
      localStringBuilder.append(ParamsManager.a().c());
      localStringBuilder.append(" , paramsManager.isReplyMsgFromSameSession() = ");
      localStringBuilder.append(ParamsManager.a().h());
      localStringBuilder.append(" , paramsManager.isMixedMsg = ");
      localStringBuilder.append(ParamsManager.a().b);
      localStringBuilder.append(" , paramsManager.isReplySrcMsgExist = ");
      localStringBuilder.append(ParamsManager.a().c);
      if ((paramRichMediaBrowserInfo != null) && ((paramRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)))
      {
        AIOBrowserBaseData localAIOBrowserBaseData = (AIOBrowserBaseData)paramRichMediaBrowserInfo.baseData;
        localStringBuilder.append(", galleryInfo.mData.isInMixedMsg = ");
        localStringBuilder.append(localAIOBrowserBaseData.b);
        localStringBuilder.append(" isMsgSeqReady = ");
        localStringBuilder.append(localAIOBrowserBaseData.c);
      }
      QLog.d("BrowserDanmakuUtils", 2, localStringBuilder.toString());
    }
    if ((!ParamsManager.a().d()) && (ParamsManager.a().a() == 1) && (ParamsManager.a().c() != 4) && (ParamsManager.a().h()) && (ParamsManager.a().c) && ((paramRichMediaBrowserInfo == null) || (!(paramRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)) || (!((AIOBrowserBaseData)paramRichMediaBrowserInfo.baseData).b))) {
      return (paramRichMediaBrowserInfo == null) || (!(paramRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)) || (((AIOBrowserBaseData)paramRichMediaBrowserInfo.baseData).c);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.BrowserDanmakuUtils
 * JD-Core Version:    0.7.0.1
 */