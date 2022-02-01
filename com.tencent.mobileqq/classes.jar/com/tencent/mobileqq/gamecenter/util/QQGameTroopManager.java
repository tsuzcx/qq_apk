package com.tencent.mobileqq.gamecenter.util;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.gamecenter.appointment.GameCenterUtils;
import com.tencent.gamecenter.wadl.api.IQQGameTrpcService;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcListReq;
import com.tencent.gamecenter.wadl.biz.listener.WadlTrpcListener;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard.GroupMemberInfo;
import com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard.sgame_qgroup_datacard.QueryGroupMemberInfoReq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.manager.Manager;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.qqgame.QQGameMemberSelectInfo.QueryOldFriendsReq;

public class QQGameTroopManager
  implements Manager
{
  public static List<String> b;
  public static List<Long> c = Collections.synchronizedList(new ArrayList());
  public static Map<String, sgame_qgroup_datacard.GroupMemberInfo> d = Collections.synchronizedMap(new LinkedHashMap());
  private static final Set<String> e = Collections.synchronizedSet(new LinkedHashSet());
  private static int k;
  private static long l;
  public WeakReference<QBaseActivity> a;
  private long f;
  private WadlTrpcListener g = new QQGameTroopManager.2(this);
  private WadlTrpcListener h = new QQGameTroopManager.3(this);
  private Comparator<TroopMemberInfo> i = new QQGameTroopManager.6(this);
  private boolean j = false;
  
  public QQGameTroopManager(QQAppInterface paramQQAppInterface) {}
  
  public static void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((paramInt == 0) || (paramInt == 1)) {
      if ((paramBoolean) && (paramInt != 1)) {}
    }
    for (;;)
    {
      try
      {
        if (Math.abs(System.currentTimeMillis() - l) <= 2000L) {
          return;
        }
        l = System.currentTimeMillis();
        HashMap localHashMap = new HashMap();
        if (!paramBoolean) {
          break label164;
        }
        localObject = "8";
        localHashMap.put(Integer.valueOf(4), localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("groupid", paramString);
        localHashMap.put(Integer.valueOf(27), ((JSONObject)localObject).toString());
        if (paramInt != 0) {
          break label176;
        }
        if (!paramBoolean) {
          break label170;
        }
        paramString = "207966";
        GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "1006", paramString, "", "100602", "1", "145", localHashMap);
        return;
      }
      catch (Throwable paramString)
      {
        QLog.e("QQGameTroopManager", 1, paramString, new Object[0]);
      }
      return;
      label164:
      Object localObject = "20";
      continue;
      label170:
      paramString = "207939";
      continue;
      label176:
      if (paramBoolean) {
        paramString = "207965";
      } else {
        paramString = "207940";
      }
    }
  }
  
  public static void a(Activity paramActivity, TroopMemberInfo paramTroopMemberInfo, TextView paramTextView1, ImageView paramImageView, TextView paramTextView2)
  {
    if (paramTroopMemberInfo != null) {
      try
      {
        paramTextView1.setVisibility(0);
        String str = paramActivity.getResources().getString(2131917490);
        paramTextView1.setText(str);
        paramImageView.setVisibility(8);
        sgame_qgroup_datacard.GroupMemberInfo localGroupMemberInfo = (sgame_qgroup_datacard.GroupMemberInfo)d.get(paramTroopMemberInfo.memberuin);
        if (localGroupMemberInfo != null) {
          if (localGroupMemberInfo.ret.get() == 0)
          {
            if (!TextUtils.isEmpty(localGroupMemberInfo.gradeName.get())) {
              str = localGroupMemberInfo.gradeName.get();
            }
            paramTextView1.setText(str);
            if (!TextUtils.isEmpty(localGroupMemberInfo.gradeIcon.get()))
            {
              paramTextView1 = URLDrawable.URLDrawableOptions.obtain();
              paramTextView1.mLoadingDrawable = URLDrawableHelperConstants.a;
              paramTextView1.mFailedDrawable = URLDrawableHelperConstants.a;
              paramImageView.setImageDrawable(URLDrawable.getDrawable(localGroupMemberInfo.gradeIcon.get(), paramTextView1));
              paramImageView.setVisibility(0);
            }
          }
          else if (localGroupMemberInfo.ret.get() == 200022)
          {
            paramTextView1.setText(paramActivity.getResources().getString(2131917491));
          }
        }
        if (b == null)
        {
          paramTextView2.setVisibility(8);
          return;
        }
        paramTextView2.setVisibility(0);
        if (b.contains(paramTroopMemberInfo.memberuin))
        {
          paramTextView2.setText(paramActivity.getResources().getString(2131916782));
          return;
        }
        paramTextView2.setText(paramActivity.getResources().getString(2131916781));
        return;
      }
      catch (Throwable paramActivity)
      {
        QLog.e("QQGameTroopManager", 1, paramActivity, new Object[0]);
      }
    }
  }
  
  private void a(Activity paramActivity, List<String> paramList, Map<String, List<TroopMemberInfo>> paramMap)
  {
    if (paramActivity != null)
    {
      if (paramMap == null) {
        return;
      }
      if (paramList != null) {}
      try
      {
        if (!paramList.isEmpty())
        {
          paramList = paramMap.keySet().iterator();
          while (paramList.hasNext()) {
            Collections.sort((List)paramMap.get((String)paramList.next()), this.i);
          }
        }
        ThreadManagerV2.getUIHandlerV2().post(new QQGameTroopManager.5(this, paramActivity));
        if (a(paramActivity))
        {
          a(0, 50, c());
          return;
        }
      }
      catch (Throwable paramActivity)
      {
        QLog.e("QQGameTroopManager", 1, paramActivity, new Object[0]);
      }
    }
  }
  
  public static void a(ImageView paramImageView, String paramString)
  {
    paramString = (sgame_qgroup_datacard.GroupMemberInfo)d.get(paramString);
    if ((paramString != null) && (!TextUtils.isEmpty(paramString.gradeIcon.get())))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = URLDrawableHelperConstants.a;
      localURLDrawableOptions.mFailedDrawable = URLDrawableHelperConstants.a;
      paramImageView.setImageDrawable(URLDrawable.getDrawable(paramString.gradeIcon.get(), localURLDrawableOptions));
      paramImageView.setVisibility(0);
      return;
    }
    paramImageView.setVisibility(4);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(4), "20");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("groupid", paramString1);
      paramString1 = new StringBuilder();
      paramString1.append(k);
      paramString1.append("");
      localJSONObject.put("roomnum", paramString1.toString());
      localJSONObject.put("guestuin", paramString2);
      localJSONObject.put("adtag", paramString3);
    }
    catch (JSONException paramString1)
    {
      QLog.e("QQGameTroopManager", 1, paramString1, new Object[0]);
    }
    localHashMap.put(Integer.valueOf(27), localJSONObject.toString());
    GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "1006", "207967", paramString4, "100602", "1", "145", localHashMap);
  }
  
  public static void a(String paramString1, ArrayList<ResultRecord> paramArrayList, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(4), "20");
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("groupid", paramString1);
        paramString1 = new StringBuilder();
        if (paramArrayList == null) {
          break label187;
        }
        m = paramArrayList.size();
        paramString1.append(m);
        paramString1.append("");
        localJSONObject.put("viewnum", paramString1.toString());
        paramString1 = new StringBuilder();
        paramString1.append(k);
        paramString1.append("");
        localJSONObject.put("roomnum", paramString1.toString());
      }
      catch (JSONException paramString1)
      {
        QLog.e("QQGameTroopManager", 1, paramString1, new Object[0]);
      }
      localHashMap.put(Integer.valueOf(27), localJSONObject.toString());
      GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "1006", "207968", paramString2, "100602", "1", "145", localHashMap);
      return;
      label187:
      int m = 0;
    }
  }
  
  public static void a(ArrayList<ResultRecord> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        ResultRecord localResultRecord = (ResultRecord)paramArrayList.next();
        sgame_qgroup_datacard.GroupMemberInfo localGroupMemberInfo = (sgame_qgroup_datacard.GroupMemberInfo)d.get(localResultRecord.uin);
        if (localGroupMemberInfo != null) {
          localResultRecord.gameLevelIcon = localGroupMemberInfo.gradeIcon.get();
        }
      }
    }
  }
  
  private void a(List<Long> paramList, String paramString, WadlTrpcListener paramWadlTrpcListener)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("doReqGameMemberInfo...friendsUinList size:");
        ((StringBuilder)localObject).append(paramList.size());
        ((StringBuilder)localObject).append(",troopUin：");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("QQGameTroopManager", 2, ((StringBuilder)localObject).toString());
      }
      try
      {
        localObject = new sgame_qgroup_datacard.QueryGroupMemberInfoReq();
        ((sgame_qgroup_datacard.QueryGroupMemberInfoReq)localObject).groupId.set(Long.parseLong(paramString));
        ((sgame_qgroup_datacard.QueryGroupMemberInfoReq)localObject).uinList.set(paramList);
        paramList = ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/14", false, ((sgame_qgroup_datacard.QueryGroupMemberInfoReq)localObject).toByteArray());
        paramString = new TrpcProxy.TrpcListReq();
        paramString.list.add(paramList);
        ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).addListener(paramWadlTrpcListener);
        ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).requestTrpc(paramString, null);
        return;
      }
      catch (Throwable paramList)
      {
        QLog.e("QQGameTroopManager", 1, paramList, new Object[0]);
      }
    }
  }
  
  public static boolean a(Activity paramActivity)
  {
    boolean bool = false;
    if (paramActivity == null) {
      return false;
    }
    if ((paramActivity.getIntent().getIntExtra("game_req_info_flag", 0) & 0x1) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean b(Activity paramActivity)
  {
    boolean bool2 = false;
    if (paramActivity == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramActivity.getIntent().getIntExtra("param_entrance", 0) == 43)
    {
      bool1 = bool2;
      if (paramActivity.getIntent().getIntExtra("GAME_H5_SELECT_BUSINESS_TYPE", 0) == 1) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private Activity c()
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && ((localWeakReference.get() instanceof Activity))) {
      return (Activity)this.a.get();
    }
    return null;
  }
  
  public void a()
  {
    e.add("member");
    e.add("friends");
    e.add("online");
  }
  
  public void a(int paramInt1, int paramInt2, Activity paramActivity)
  {
    ArrayList localArrayList;
    int m;
    if (paramActivity != null)
    {
      localArrayList = new ArrayList();
      m = 0;
      for (;;)
      {
        try
        {
          CharDividedFacePreloadBaseAdapter localCharDividedFacePreloadBaseAdapter = ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).getMemberListAdapter(paramActivity);
          int n = paramInt2;
          if (paramInt1 == 0)
          {
            m = localCharDividedFacePreloadBaseAdapter.getCount();
            try
            {
              n = Math.min(paramInt2, m - 1);
            }
            catch (Throwable localThrowable1)
            {
              continue;
            }
          }
          i1 = paramInt1;
          i2 = m;
          paramInt2 = n;
          if (i1 > n) {}
        }
        catch (Throwable localThrowable2)
        {
          int i1;
          TroopMemberInfo localTroopMemberInfo;
          m = 0;
          QLog.e("QQGameTroopManager", 1, localThrowable2, new Object[0]);
          int i2 = m;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("reqGameInfoByPosition,firstPosition:");
            localStringBuilder.append(paramInt1);
            localStringBuilder.append(",lastPosition:");
            localStringBuilder.append(paramInt2);
            localStringBuilder.append(",itemCount：");
            localStringBuilder.append(i2);
            QLog.i("QQGameTroopManager", 2, localStringBuilder.toString());
          }
          a(localArrayList, paramActivity.getIntent().getStringExtra("group_uin"), this.h);
        }
        try
        {
          localTroopMemberInfo = (TroopMemberInfo)localThrowable1.getItem(i1);
          if (localTroopMemberInfo != null)
          {
            long l1 = Long.parseLong(localTroopMemberInfo.memberuin);
            if (!d.containsKey(localTroopMemberInfo.memberuin)) {
              localArrayList.add(Long.valueOf(l1));
            }
          }
        }
        catch (Throwable localThrowable3)
        {
          continue;
        }
        i1 += 1;
      }
    }
  }
  
  public void a(Activity paramActivity, List<ResultRecord> paramList, int paramInt, String paramString1, String paramString2)
  {
    a((QBaseActivity)paramActivity);
    if ((paramInt == 3) || (paramInt == 2))
    {
      String str;
      if (paramInt == 3) {
        str = "1";
      } else {
        str = "2";
      }
      a(paramString2, paramString1, str, paramActivity.getIntent().getStringExtra("GAME_H5_SELECT_GAME_APPID"));
    }
    if (!a(paramActivity)) {
      return;
    }
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      if (QLog.isColorLevel())
      {
        paramActivity = new StringBuilder();
        paramActivity.append("onSearchBarDone,recordsSize：");
        paramActivity.append(paramList.size());
        paramActivity.append(",searchType:");
        paramActivity.append(paramInt);
        QLog.i("QQGameTroopManager", 2, paramActivity.toString());
      }
      paramActivity = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramString1 = (ResultRecord)paramList.next();
        if (paramString1 != null) {
          try
          {
            if (!d.containsKey(paramString1.uin)) {
              paramActivity.add(Long.valueOf(Long.parseLong(paramString1.uin)));
            }
          }
          catch (Throwable paramString1)
          {
            QLog.e("QQGameTroopManager", 1, paramString1, new Object[0]);
          }
        }
      }
      if (paramActivity.size() == 0) {
        return;
      }
      if (paramInt == 3) {
        paramInt = 500;
      } else {
        paramInt = 100;
      }
      ThreadManager.getSubThreadHandler().removeCallbacksAndMessages("reqGameInfo");
      ThreadManager.getSubThreadHandler().postAtTime(new QQGameTroopManager.4(this, paramActivity, paramString2), "reqGameInfo", SystemClock.uptimeMillis() + paramInt);
    }
  }
  
  public void a(QBaseActivity paramQBaseActivity)
  {
    this.a = new WeakReference(paramQBaseActivity);
  }
  
  public void a(PinnedDividerListView paramPinnedDividerListView, Activity paramActivity)
  {
    if (paramPinnedDividerListView != null) {
      a(paramPinnedDividerListView.getFirstVisiblePosition(), paramPinnedDividerListView.getLastVisiblePosition(), paramActivity);
    }
  }
  
  public void a(String paramString)
  {
    e.remove(paramString);
    Object localObject;
    if (e.size() == 0)
    {
      localObject = c();
      if (localObject != null)
      {
        Map localMap = ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).getIndexedFriends((Activity)localObject);
        if (localMap != null)
        {
          if (localMap.size() == 0) {
            return;
          }
          a((Activity)localObject, b, localMap);
        }
        else
        {
          return;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkNeedSortAndPreload,sTaskSet:");
      ((StringBuilder)localObject).append(e.toString());
      ((StringBuilder)localObject).append(",taskName:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("QQGameTroopManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(String paramString, QBaseActivity paramQBaseActivity)
  {
    try
    {
      a(paramQBaseActivity);
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = paramQBaseActivity.getIntent().getStringExtra("group_uin");
      }
      c.clear();
      paramString = new QQGameMemberSelectInfo.QueryOldFriendsReq();
      paramString.groupCode.set(Long.parseLong(str));
      paramString = ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/12", false, paramString.toByteArray());
      paramQBaseActivity = new TrpcProxy.TrpcListReq();
      paramQBaseActivity.list.add(paramString);
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).addListener(this.g);
      this.f = System.currentTimeMillis();
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).requestTrpc(paramQBaseActivity, null);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("doReqGameFriends...troopUin:");
        paramString.append(str);
        QLog.i("QQGameTroopManager", 2, paramString.toString());
        return;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("QQGameTroopManager", 1, paramString, new Object[0]);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.j) {
      return;
    }
    this.j = true;
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(4), "8");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("groupid", paramString1);
      paramString1 = new StringBuilder();
      paramString1.append(k);
      paramString1.append("");
      localJSONObject.put("roomnum", paramString1.toString());
    }
    catch (JSONException paramString1)
    {
      QLog.e("QQGameTroopManager", 1, paramString1, new Object[0]);
    }
    localHashMap.put(Integer.valueOf(27), localJSONObject.toString());
    GameCenterUtils.a(((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface(), "1006", "207851", paramString2, "100602", "1", "145", localHashMap);
  }
  
  public void a(List<String> paramList)
  {
    if (paramList != null) {
      b = Collections.synchronizedList(paramList);
    }
    a("online");
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        if (c() == null) {
          return;
        }
        localObject1 = c();
        localObject3 = ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).getIndexedFriends((Activity)localObject1);
        if ((localObject3 != null) && (((Map)localObject3).size() != 0))
        {
          k = 0;
          localObject2 = Collections.synchronizedList(new ArrayList());
          localList = Collections.synchronizedList(new ArrayList());
          localObject4 = ((Map)localObject3).keySet().iterator();
          if (((Iterator)localObject4).hasNext())
          {
            localObject5 = (List)((Map)localObject3).get((String)((Iterator)localObject4).next());
            if (localObject5 == null) {
              continue;
            }
            localObject5 = ((List)localObject5).iterator();
            if (!((Iterator)localObject5).hasNext()) {
              continue;
            }
            localObject6 = (TroopMemberInfo)((Iterator)localObject5).next();
            if (localObject6 == null) {
              continue;
            }
          }
        }
      }
      catch (Throwable localThrowable2)
      {
        Object localObject1;
        Object localObject3;
        Object localObject2;
        List localList;
        Object localObject4;
        Object localObject5;
        Object localObject6;
        int n;
        int m;
        QLog.e("QQGameTroopManager", 1, localThrowable2, new Object[0]);
        return;
      }
      try
      {
        if ((c != null) && (c.contains(Long.valueOf(Long.parseLong(((TroopMemberInfo)localObject6).memberuin)))))
        {
          localList.add(localObject6);
          continue;
        }
        ((List)localObject2).add(localObject6);
      }
      catch (Exception localException) {}
      k = localList.size() + ((List)localObject2).size();
      localObject3 = Collections.synchronizedMap(new LinkedHashMap());
      if (localList.size() > 0) {
        ((Map)localObject3).put(((Activity)localObject1).getResources().getString(2131917484), localList);
      }
      if (((List)localObject2).size() > 0) {
        if (localList.size() > 0) {
          ((Map)localObject3).put(((Activity)localObject1).getResources().getString(2131917494), localObject2);
        } else {
          ((Map)localObject3).put(((Activity)localObject1).getResources().getString(2131917488), localObject2);
        }
      }
      n = ((Map)localObject3).keySet().size();
      if (n == 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("QQGameTroopManager", 2, "groupSize=0");
        return;
      }
      localObject6 = ((Map)localObject3).keySet().iterator();
      localObject4 = new int[n];
      localObject5 = new String[n];
      localObject4[0] = 0;
      m = 1;
      if (m < localObject4.length)
      {
        localObject4[m] += localObject4[(m - 1)] + ((List)((Map)localObject3).get(((Iterator)localObject6).next())).size() + 1;
        m += 1;
      }
      else
      {
        localObject6 = ((Map)localObject3).keySet().iterator();
        m = 0;
        if (((Iterator)localObject6).hasNext())
        {
          localObject5[m] = ((String)((Iterator)localObject6).next());
          m += 1;
        }
        else
        {
          if (Looper.getMainLooper() == Looper.myLooper()) {
            ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).updateGameData((Activity)localObject1, (Map)localObject3, (int[])localObject4, (String[])localObject5);
          } else {
            ThreadManagerV2.getUIHandlerV2().post(new QQGameTroopManager.1(this, (Activity)localObject1, (Map)localObject3, (int[])localObject4, (String[])localObject5));
          }
          if (QLog.isColorLevel())
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("handleGameClockData...gameFriendList:");
            ((StringBuilder)localObject3).append(localList.size());
            ((StringBuilder)localObject3).append(",otherMemberList:");
            ((StringBuilder)localObject3).append(((List)localObject2).size());
            ((StringBuilder)localObject3).append(",groupSize:");
            ((StringBuilder)localObject3).append(n);
            QLog.i("QQGameTroopManager", 2, ((StringBuilder)localObject3).toString());
          }
          localObject2 = ((Activity)localObject1).getIntent().getStringExtra("group_uin");
          localObject1 = ((Activity)localObject1).getIntent().getStringExtra("GAME_H5_SELECT_GAME_APPID");
          try
          {
            a((String)localObject2, (String)localObject1);
            return;
          }
          catch (Throwable localThrowable1) {}
          return;
        }
      }
    }
  }
  
  /* Error */
  public void onDestroy()
  {
    // Byte code:
    //   0: ldc_w 434
    //   3: invokestatic 149	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   6: checkcast 434	com/tencent/gamecenter/wadl/api/IQQGameTrpcService
    //   9: aload_0
    //   10: getfield 76	com/tencent/mobileqq/gamecenter/util/QQGameTroopManager:g	Lcom/tencent/gamecenter/wadl/biz/listener/WadlTrpcListener;
    //   13: invokeinterface 675 2 0
    //   18: ldc_w 434
    //   21: invokestatic 149	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   24: checkcast 434	com/tencent/gamecenter/wadl/api/IQQGameTrpcService
    //   27: aload_0
    //   28: getfield 81	com/tencent/mobileqq/gamecenter/util/QQGameTroopManager:h	Lcom/tencent/gamecenter/wadl/biz/listener/WadlTrpcListener;
    //   31: invokeinterface 675 2 0
    //   36: aload_0
    //   37: iconst_0
    //   38: putfield 88	com/tencent/mobileqq/gamecenter/util/QQGameTroopManager:j	Z
    //   41: aload_0
    //   42: aconst_null
    //   43: putfield 485	com/tencent/mobileqq/gamecenter/util/QQGameTroopManager:a	Lmqq/util/WeakReference;
    //   46: getstatic 57	com/tencent/mobileqq/gamecenter/util/QQGameTroopManager:d	Ljava/util/Map;
    //   49: invokeinterface 676 1 0
    //   54: aconst_null
    //   55: putstatic 279	com/tencent/mobileqq/gamecenter/util/QQGameTroopManager:b	Ljava/util/List;
    //   58: getstatic 48	com/tencent/mobileqq/gamecenter/util/QQGameTroopManager:c	Ljava/util/List;
    //   61: invokeinterface 615 1 0
    //   66: getstatic 66	com/tencent/mobileqq/gamecenter/util/QQGameTroopManager:e	Ljava/util/Set;
    //   69: invokeinterface 677 1 0
    //   74: iconst_0
    //   75: putstatic 357	com/tencent/mobileqq/gamecenter/util/QQGameTroopManager:k	I
    //   78: invokestatic 397	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +37 -> 118
    //   84: goto +25 -> 109
    //   87: astore_1
    //   88: goto +31 -> 119
    //   91: astore_1
    //   92: ldc 170
    //   94: iconst_1
    //   95: aload_1
    //   96: iconst_0
    //   97: anewarray 4	java/lang/Object
    //   100: invokestatic 175	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   103: invokestatic 397	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq +12 -> 118
    //   109: ldc 170
    //   111: iconst_1
    //   112: ldc_w 678
    //   115: invokestatic 404	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: return
    //   119: invokestatic 397	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +12 -> 134
    //   125: ldc 170
    //   127: iconst_1
    //   128: ldc_w 678
    //   131: invokestatic 404	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   134: aload_1
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	QQGameTroopManager
    //   87	1	1	localObject	Object
    //   91	44	1	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	78	87	finally
    //   92	103	87	finally
    //   0	78	91	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.util.QQGameTroopManager
 * JD-Core Version:    0.7.0.1
 */