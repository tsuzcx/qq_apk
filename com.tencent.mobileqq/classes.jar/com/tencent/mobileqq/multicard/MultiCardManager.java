package com.tencent.mobileqq.multicard;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.friends.intimate.IntimateInfoHandler;
import com.tencent.mobileqq.friends.intimate.IntimateInfoManager;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;

public class MultiCardManager
  implements Manager
{
  private QQAppInterface a;
  private boolean b = true;
  private long c = 0L;
  private MultiCardManager.GroupCardIntimateInfoObserver d;
  private MultiCardManager.MyFriendObserver e;
  private MultiCardManager.MyTroopBusinessObserver f;
  private HashMap<Long, WeakReference<MultiCardManager.GetGroupRecommendUinListsListener>> g = new HashMap(5);
  private HashMap<Long, WeakReference<MultiCardManager.GetGroupIntimateInfoListListener>> h = new HashMap(20);
  private LruCache<Long, IntimateInfo> i = new LruCache(200);
  private HashMap<Long, Boolean> j = new HashMap(200);
  private HashMap<Long, WeakReference<MultiCardManager.GetGroupMemberNickListener>> k = new HashMap(5);
  private HashMap<Long, ArrayList<Long>> l = new HashMap(5);
  private HashMap<Long, ArrayList<Long>> m = new HashMap(5);
  private IntimateInfoManager n;
  
  public MultiCardManager(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    this.n = ((IntimateInfoManager)this.a.getManager(QQManagerFactory.INTIMATE_INFO_MANAGER));
  }
  
  private void a(long paramLong, MultiCardManager.GetGroupRecommendUinListsListener paramGetGroupRecommendUinListsListener)
  {
    ThreadManager.getSubThreadHandler().post(new MultiCardManager.3(this, paramLong, paramGetGroupRecommendUinListsListener));
  }
  
  private void a(long paramLong, ArrayList<Long> paramArrayList, MultiCardManager.GetGroupIntimateInfoListListener paramGetGroupIntimateInfoListListener)
  {
    ThreadManager.getSubThreadHandler().post(new MultiCardManager.2(this, paramLong, paramArrayList, paramGetGroupIntimateInfoListListener));
  }
  
  private void a(long paramLong, ArrayList<Long> paramArrayList, MultiCardManager.GetGroupMemberNickListener paramGetGroupMemberNickListener)
  {
    ThreadManager.getSubThreadHandler().post(new MultiCardManager.1(this, paramArrayList, paramLong, paramGetGroupMemberNickListener));
  }
  
  private ArrayList<Long> c(long paramLong)
  {
    Object localObject1 = this.a.getApp();
    int i1 = 0;
    localObject1 = ((BaseApplication)localObject1).getSharedPreferences("group_intimate_recommend_uin_list", 0);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.a.getCurrentUin());
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(paramLong);
    localObject2 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), "");
    boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
    JSONArray localJSONArray = null;
    localObject1 = null;
    Object localObject3;
    if (!bool)
    {
      try
      {
        localJSONArray = new JSONArray((String)localObject2);
        localObject2 = new ArrayList(localJSONArray.length());
        try
        {
          int i2 = localJSONArray.length();
          while (i1 < i2)
          {
            ((ArrayList)localObject2).add(Long.valueOf(localJSONArray.optLong(i1)));
            i1 += 1;
          }
          return localObject2;
        }
        catch (JSONException localJSONException2)
        {
          localObject1 = localObject2;
          localObject2 = localJSONException2;
        }
        localObject3 = localObject1;
      }
      catch (JSONException localJSONException1) {}
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("getGroupRecommendUinLists ");
        ((StringBuilder)localObject3).append(localJSONException1.toString());
        QLog.d("intimate_relationship", 2, ((StringBuilder)localObject3).toString());
        localObject3 = localObject1;
      }
    }
    return localObject3;
  }
  
  public IntimateInfo a(long paramLong1, long paramLong2)
  {
    Object localObject2 = (IntimateInfo)this.i.get(Long.valueOf(paramLong2));
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramLong1);
      ((StringBuilder)localObject1).append("");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramLong2);
      ((StringBuilder)localObject2).append("");
      String str = IntimateInfo.convertUinKeyForGroupCard((String)localObject1, ((StringBuilder)localObject2).toString());
      localObject2 = this.n.a(str);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        ((IntimateInfo)localObject2).friendUin = IntimateInfo.getUinFromGroupCardKey(str);
        localObject1 = localObject2;
      }
    }
    return localObject1;
  }
  
  public void a()
  {
    try
    {
      b(this.c);
      return;
    }
    finally {}
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("enter ");
      localStringBuilder.append(paramLong);
      QLog.d("intimate_relationship", 2, localStringBuilder.toString());
    }
    this.c = paramLong;
    this.b = false;
    if (this.d == null) {
      this.d = new MultiCardManager.GroupCardIntimateInfoObserver(this, null);
    }
    if (this.e == null) {
      this.e = new MultiCardManager.MyFriendObserver(this, null);
    }
    if (this.f == null) {
      this.f = new MultiCardManager.MyTroopBusinessObserver(this, null);
    }
    this.a.addObserver(this.d);
    this.a.addObserver(this.e);
    this.a.addObserver(this.f);
  }
  
  public void a(long paramLong, ArrayList<Long> paramArrayList)
  {
    Object localObject2 = this.a.getApp().getSharedPreferences("group_intimate_recommend_uin_list", 0);
    Object localObject1;
    if (paramArrayList != null)
    {
      localObject1 = new JSONArray();
      Object localObject3 = paramArrayList.iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((JSONArray)localObject1).put((Long)((Iterator)localObject3).next());
      }
      localObject2 = ((SharedPreferences)localObject2).edit();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.a.getCurrentUin());
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append(paramLong);
      ((SharedPreferences.Editor)localObject2).putString(((StringBuilder)localObject3).toString(), ((JSONArray)localObject1).toString()).commit();
    }
    else
    {
      localObject1 = ((SharedPreferences)localObject2).edit();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.a.getCurrentUin());
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(paramLong);
      ((SharedPreferences.Editor)localObject1).remove(((StringBuilder)localObject2).toString()).commit();
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("updateGroupRecommendUinListDiskCache, uin: ");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(" ");
      if (paramArrayList != null) {
        paramArrayList = paramArrayList.toString();
      } else {
        paramArrayList = "null";
      }
      ((StringBuilder)localObject1).append(paramArrayList);
      QLog.d("intimate_relationship", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(Context arg1, long paramLong, MultiCardManager.GetGroupRecommendUinListsListener paramGetGroupRecommendUinListsListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardManager", 2, String.format("getGroupRecommendUinLists, uin: %d", new Object[] { Long.valueOf(paramLong) }));
    }
    if ((this.a != null) && (paramGetGroupRecommendUinListsListener != null))
    {
      if (!NetworkUtil.isNetSupport(???))
      {
        a(paramLong, paramGetGroupRecommendUinListsListener);
        return;
      }
      synchronized (this.m)
      {
        ArrayList localArrayList = (ArrayList)this.m.get(Long.valueOf(paramLong));
        if (localArrayList != null)
        {
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder();
            ???.append("getGroupRecommendUinLists return cache ");
            ???.append(paramLong);
            QLog.d("MultiCardManager", 2, ???.toString());
          }
          paramGetGroupRecommendUinListsListener.a(paramLong, localArrayList);
          return;
        }
        paramGetGroupRecommendUinListsListener = new WeakReference(paramGetGroupRecommendUinListsListener);
        synchronized (this.g)
        {
          this.g.put(Long.valueOf(paramLong), paramGetGroupRecommendUinListsListener);
          ((IntimateInfoHandler)this.a.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER)).a(paramLong, 10000L);
          return;
        }
      }
    }
  }
  
  public void a(Context paramContext, long paramLong, ArrayList<Long> arg4, MultiCardManager.GetGroupIntimateInfoListListener paramGetGroupIntimateInfoListListener)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("getGroupIntimateInfoList, uinList: ");
      ((StringBuilder)???).append(paramLong);
      ((StringBuilder)???).append(" ");
      if (??? != null) {
        localObject1 = ???.toString();
      } else {
        localObject1 = "null";
      }
      ((StringBuilder)???).append((String)localObject1);
      QLog.d("MultiCardManager", 2, ((StringBuilder)???).toString());
    }
    if ((this.a != null) && (paramGetGroupIntimateInfoListListener != null) && (??? != null))
    {
      if (!NetworkUtil.isNetSupport(paramContext))
      {
        a(paramLong, ???, paramGetGroupIntimateInfoListListener);
        return;
      }
      localObject1 = new ArrayList(???.size());
      paramContext = new ArrayList(???.size());
      Iterator localIterator = ???.iterator();
      while (localIterator.hasNext())
      {
        Long localLong = (Long)localIterator.next();
        if ((IntimateInfo)this.i.get(localLong) != null) {
          ((ArrayList)localObject1).add(localLong);
        } else {
          synchronized (this.j)
          {
            if (!this.j.containsKey(localLong))
            {
              paramContext.add(localLong);
              this.j.put(localLong, Boolean.TRUE);
            }
            else
            {
              ((ArrayList)localObject1).add(localLong);
            }
          }
        }
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("getGroupIntimateInfoList  alreadyRequest: ");
        ((StringBuilder)???).append(((ArrayList)localObject1).toString());
        ((StringBuilder)???).append(" notRequest:");
        ((StringBuilder)???).append(paramContext.toString());
        QLog.d("MultiCardManager", 2, ((StringBuilder)???).toString());
      }
      if (paramContext.isEmpty())
      {
        a(paramLong, ???, paramGetGroupIntimateInfoListListener);
        return;
      }
      a(paramLong, ???, paramGetGroupIntimateInfoListListener);
      paramGetGroupIntimateInfoListListener = new WeakReference(paramGetGroupIntimateInfoListListener);
      synchronized (this.h)
      {
        this.h.put(Long.valueOf(paramLong), paramGetGroupIntimateInfoListListener);
        ??? = new HashMap(5);
        ???.put("alreadyRequest", localObject1);
        ???.put("notRequest", paramContext);
        paramGetGroupIntimateInfoListListener = new ArrayList(1);
        paramGetGroupIntimateInfoListListener.add(Long.valueOf(paramLong));
        ???.put("groupUin", paramGetGroupIntimateInfoListListener);
        ((IntimateInfoHandler)this.a.getBusinessHandler(BusinessHandlerFactory.INTIMATE_INFO_HANDLER)).a(paramLong, paramContext, ???);
        return;
      }
    }
  }
  
  public void a(Context arg1, long paramLong, ArrayList<Long> paramArrayList, MultiCardManager.GetGroupMemberNickListener paramGetGroupMemberNickListener)
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getGroupMemberNick, uinList: ");
      ((StringBuilder)localObject2).append(paramLong);
      ((StringBuilder)localObject2).append(" ");
      if (paramArrayList != null) {
        localObject1 = paramArrayList.toString();
      } else {
        localObject1 = "null";
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("MultiCardManager", 2, ((StringBuilder)localObject2).toString());
    }
    if ((this.a != null) && (paramGetGroupMemberNickListener != null) && (paramArrayList != null))
    {
      if (!NetworkUtil.isNetSupport(???))
      {
        a(paramLong, paramArrayList, paramGetGroupMemberNickListener);
        return;
      }
      synchronized (this.l)
      {
        int i1;
        if (this.l.containsKey(Long.valueOf(paramLong)))
        {
          int i2 = 1;
          localObject1 = (ArrayList)this.l.get(Long.valueOf(paramLong));
          i1 = i2;
          if (localObject1 != null)
          {
            localObject1 = (ArrayList)((ArrayList)localObject1).clone();
            localObject2 = paramArrayList.iterator();
            while (((Iterator)localObject2).hasNext())
            {
              Long localLong = (Long)((Iterator)localObject2).next();
              if (!((ArrayList)localObject1).contains(localLong)) {
                ((ArrayList)localObject1).add(localLong);
              }
            }
            this.l.put(Long.valueOf(paramLong), localObject1);
            i1 = i2;
          }
        }
        else
        {
          this.l.put(Long.valueOf(paramLong), (ArrayList)paramArrayList.clone());
          i1 = 0;
        }
        a(paramLong, paramArrayList, paramGetGroupMemberNickListener);
        if (i1 != 0) {
          return;
        }
        paramArrayList = new WeakReference(paramGetGroupMemberNickListener);
        synchronized (this.k)
        {
          this.k.put(Long.valueOf(paramLong), paramArrayList);
          ??? = (ITroopMemberListHandler)this.a.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER);
          paramArrayList = new StringBuilder();
          paramArrayList.append(paramLong);
          paramArrayList.append("");
          ???.a(false, paramArrayList.toString(), "0", 9);
          return;
        }
      }
    }
  }
  
  public void a(String paramString, IntimateInfo paramIntimateInfo)
  {
    if (paramIntimateInfo != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("saveGroupCardIntimateInfo ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" ");
        localStringBuilder.append(paramIntimateInfo.toString());
        QLog.d("intimate_relationship", 2, localStringBuilder.toString());
      }
      try
      {
        long l1 = Long.parseLong(paramIntimateInfo.friendUin);
        if (!this.b) {
          this.i.put(Long.valueOf(l1), paramIntimateInfo);
        }
        paramString = IntimateInfo.convertUinKeyForGroupCard(paramString, paramIntimateInfo.friendUin);
        paramIntimateInfo.friendUin = paramString;
        paramIntimateInfo.lastAnimAfterFriendDays = paramIntimateInfo.beFriendDays;
        paramIntimateInfo.lastAnimAfterScore = paramIntimateInfo.currentScore;
        this.n.a(paramString, paramIntimateInfo);
        paramString = new StringBuilder();
        paramString.append(l1);
        paramString.append("");
        paramIntimateInfo.friendUin = paramString.toString();
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          paramIntimateInfo = new StringBuilder();
          paramIntimateInfo.append("saveGroupCardIntimateInfo ");
          paramIntimateInfo.append(paramString.toString());
          QLog.d("intimate_relationship", 2, paramIntimateInfo.toString());
        }
      }
    }
  }
  
  public HashMap<Long, IntimateInfo> b(long paramLong, ArrayList<Long> paramArrayList)
  {
    Object localObject2;
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getIntimateInfoListCache, uinList: ");
      if (paramArrayList != null) {
        localObject1 = paramArrayList.toString();
      } else {
        localObject1 = "null";
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(" ");
      ((StringBuilder)localObject2).append(paramLong);
      QLog.d("MultiCardManager", 2, ((StringBuilder)localObject2).toString());
    }
    if (paramArrayList != null)
    {
      localObject1 = new HashMap(paramArrayList.size() * 2);
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject2 = (Long)paramArrayList.next();
        IntimateInfo localIntimateInfo = a(paramLong, ((Long)localObject2).longValue());
        if (localIntimateInfo != null) {
          ((HashMap)localObject1).put(localObject2, localIntimateInfo);
        }
      }
      return localObject1;
    }
    return null;
  }
  
  public void b(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("exit ");
      ((StringBuilder)localObject1).append(paramLong);
      QLog.d("intimate_relationship", 2, ((StringBuilder)localObject1).toString());
    }
    this.b = true;
    this.c = 0L;
    Object localObject1 = this.d;
    if (localObject1 != null)
    {
      this.a.removeObserver((BusinessObserver)localObject1);
      this.d = null;
    }
    localObject1 = this.e;
    if (localObject1 != null)
    {
      this.a.removeObserver((BusinessObserver)localObject1);
      this.e = null;
    }
    localObject1 = this.f;
    if (localObject1 != null)
    {
      this.a.removeObserver((BusinessObserver)localObject1);
      this.f = null;
    }
    localObject1 = this.g;
    if (localObject1 != null) {
      try
      {
        this.g.clear();
      }
      finally {}
    }
    localObject1 = this.h;
    if (localObject1 != null) {
      try
      {
        this.h.clear();
      }
      finally {}
    }
    localObject1 = this.i;
    if (localObject1 != null) {
      ((LruCache)localObject1).evictAll();
    }
    localObject1 = this.m;
    if (localObject1 != null) {
      try
      {
        this.m.clear();
      }
      finally {}
    }
    localObject1 = this.k;
    if (localObject1 != null) {
      try
      {
        this.k.clear();
      }
      finally {}
    }
    localObject1 = this.l;
    if (localObject1 != null) {
      try
      {
        this.l.clear();
      }
      finally {}
    }
    localObject1 = this.j;
    if (localObject1 != null) {
      try
      {
        this.j.clear();
        return;
      }
      finally {}
    }
  }
  
  public void onDestroy()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardManager
 * JD-Core Version:    0.7.0.1
 */