package com.tencent.mobileqq.winkpublish.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.winkpublish.api.IDataManager;
import com.tencent.mobileqq.winkpublish.common.config.LocalConfig;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import com.tencent.mobileqq.winkpublish.model.ShuoshuoContent;
import com.tencent.mobileqq.winkpublish.util.AlbumUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DataManagerImpl
  implements IDataManager<DraftBean>
{
  private static final String TAG = "DataManagerImpl";
  private final String QFS_DRAFT_MISSION_LIST_KEY = "_QFS_DRAFT_MISSION_LIST_KEY_1";
  private final String SEPARATOR = ";";
  
  private String list2String(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramList.size())
      {
        if (!TextUtils.isEmpty((CharSequence)paramList.get(i))) {
          if (i == 0)
          {
            localStringBuilder.append((String)paramList.get(i));
          }
          else
          {
            localStringBuilder.append(";");
            localStringBuilder.append((String)paramList.get(i));
          }
        }
        i += 1;
      }
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private ArrayList<String> string2List(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new ArrayList();
    }
    return new ArrayList(Arrays.asList(paramString.split(";")));
  }
  
  public static DraftBean trans2DraftBean(String paramString, ShuoshuoContent paramShuoshuoContent)
  {
    DraftBean localDraftBean = new DraftBean();
    localDraftBean.setMissionId(paramString);
    localDraftBean.setContent(paramShuoshuoContent.r());
    localDraftBean.setUploadStatus(paramShuoshuoContent.b());
    localDraftBean.setToastStatus(paramShuoshuoContent.c());
    localDraftBean.setClientKey(paramShuoshuoContent.d());
    paramString = paramShuoshuoContent.k();
    HashMap localHashMap = paramShuoshuoContent.m();
    if ((paramString != null) && (localHashMap != null))
    {
      localDraftBean.setVideoCount(paramString.size());
      paramString = (LocalMediaInfo)localHashMap.get(paramString.get(0));
      if (paramString != null)
      {
        if (!TextUtils.isEmpty(paramString.thumbnailPath)) {
          localDraftBean.setCoverUrl(paramString.thumbnailPath);
        } else {
          localDraftBean.setCoverUrl(paramString.path);
        }
        if ((paramString.mOriginPath != null) && (paramString.mOriginPath.size() > 0) && (!TextUtils.isEmpty((CharSequence)paramString.mOriginPath.get(0)))) {
          localDraftBean.setOriginPath((String)paramString.mOriginPath.get(0));
        }
        if (AlbumUtil.c(paramString)) {
          localDraftBean.setMediaType(0);
        } else if (AlbumUtil.b(paramString)) {
          localDraftBean.setMediaType(1);
        }
      }
    }
    localDraftBean.setCreateTime(paramShuoshuoContent.e());
    return localDraftBean;
  }
  
  public DraftBean getData(long paramLong, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("_flash_show_publish_");
    localStringBuilder.append(paramString);
    return trans2DraftBean(paramString, LocalConfig.a(paramLong, localStringBuilder.toString()));
  }
  
  public List<DraftBean> getDatas(long paramLong)
  {
    Object localObject = getMissionIds(paramLong);
    ArrayList localArrayList = new ArrayList(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("_flash_show_publish_");
      localStringBuilder.append(str);
      localArrayList.add(trans2DraftBean(str, LocalConfig.a(paramLong, localStringBuilder.toString())));
    }
    return localArrayList;
  }
  
  public DraftBean getLastData(long paramLong)
  {
    String str = getLastMissionId(paramLong);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return getData(paramLong, str);
  }
  
  public String getLastMissionId(long paramLong)
  {
    List localList = getMissionIds(paramLong);
    if (localList.isEmpty()) {
      return "";
    }
    return (String)localList.get(0);
  }
  
  public List<String> getMissionIds(long paramLong)
  {
    return string2List(LocalConfig.d("_QFS_DRAFT_MISSION_LIST_KEY_1", "", paramLong));
  }
  
  public void putMissionId(long paramLong, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    List localList = getMissionIds(paramLong);
    if (!localList.contains(paramString))
    {
      localList.add(0, paramString);
      LocalConfig.c("_QFS_DRAFT_MISSION_LIST_KEY_1", list2String(localList), paramLong);
    }
  }
  
  public void removeMissionId(long paramLong, String paramString)
  {
    List localList = getMissionIds(paramLong);
    if (!localList.contains(paramString)) {
      return;
    }
    localList.remove(paramString);
    LocalConfig.c("_QFS_DRAFT_MISSION_LIST_KEY_1", list2String(localList), paramLong);
  }
  
  public void removeMissionIdAndData(long paramLong, String paramString)
  {
    Object localObject = getMissionIds(paramLong);
    if (!((List)localObject).contains(paramString)) {
      return;
    }
    ((List)localObject).remove(paramString);
    LocalConfig.c("_QFS_DRAFT_MISSION_LIST_KEY_1", list2String((List)localObject), paramLong);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("_flash_show_publish_");
    ((StringBuilder)localObject).append(paramString);
    LocalConfig.b(paramLong, ((StringBuilder)localObject).toString());
  }
  
  public void updateToastStatus(long paramLong, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("_flash_show_publish_");
    localStringBuilder.append(paramString);
    LocalConfig.c(localStringBuilder.toString(), paramInt, paramLong);
  }
  
  public void updateUploadStatus(long paramLong, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("_flash_show_publish_");
    localStringBuilder.append(paramString);
    LocalConfig.b(localStringBuilder.toString(), paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.winkpublish.api.impl.DataManagerImpl
 * JD-Core Version:    0.7.0.1
 */