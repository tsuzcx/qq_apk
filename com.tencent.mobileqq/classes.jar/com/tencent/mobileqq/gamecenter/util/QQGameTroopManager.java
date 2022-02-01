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
  private static int jdField_a_of_type_Int;
  public static List<String> a;
  public static Map<String, sgame_qgroup_datacard.GroupMemberInfo> a;
  private static final Set<String> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new LinkedHashSet());
  private static long jdField_b_of_type_Long;
  public static List<Long> b;
  private long jdField_a_of_type_Long;
  private WadlTrpcListener jdField_a_of_type_ComTencentGamecenterWadlBizListenerWadlTrpcListener = new QQGameTroopManager.2(this);
  private Comparator<TroopMemberInfo> jdField_a_of_type_JavaUtilComparator = new QQGameTroopManager.6(this);
  public WeakReference<QBaseActivity> a;
  private boolean jdField_a_of_type_Boolean = false;
  private WadlTrpcListener jdField_b_of_type_ComTencentGamecenterWadlBizListenerWadlTrpcListener = new QQGameTroopManager.3(this);
  
  static
  {
    jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
  }
  
  public QQGameTroopManager(QQAppInterface paramQQAppInterface) {}
  
  private Activity a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_MqqUtilWeakReference;
    if ((localWeakReference != null) && ((localWeakReference.get() instanceof Activity))) {
      return (Activity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    }
    return null;
  }
  
  public static void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((paramInt == 0) || (paramInt == 1)) {
      if ((paramBoolean) && (paramInt != 1)) {}
    }
    for (;;)
    {
      try
      {
        if (Math.abs(System.currentTimeMillis() - jdField_b_of_type_Long) <= 2000L) {
          return;
        }
        jdField_b_of_type_Long = System.currentTimeMillis();
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
        String str = paramActivity.getResources().getString(2131719885);
        paramTextView1.setText(str);
        paramImageView.setVisibility(8);
        sgame_qgroup_datacard.GroupMemberInfo localGroupMemberInfo = (sgame_qgroup_datacard.GroupMemberInfo)jdField_a_of_type_JavaUtilMap.get(paramTroopMemberInfo.memberuin);
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
            paramTextView1.setText(paramActivity.getResources().getString(2131719886));
          }
        }
        if (jdField_a_of_type_JavaUtilList == null)
        {
          paramTextView2.setVisibility(8);
          return;
        }
        paramTextView2.setVisibility(0);
        if (jdField_a_of_type_JavaUtilList.contains(paramTroopMemberInfo.memberuin))
        {
          paramTextView2.setText(paramActivity.getResources().getString(2131719230));
          return;
        }
        paramTextView2.setText(paramActivity.getResources().getString(2131719229));
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
            Collections.sort((List)paramMap.get((String)paramList.next()), this.jdField_a_of_type_JavaUtilComparator);
          }
        }
        ThreadManagerV2.getUIHandlerV2().post(new QQGameTroopManager.5(this, paramActivity));
        if (a(paramActivity))
        {
          a(0, 50, a());
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
    paramString = (sgame_qgroup_datacard.GroupMemberInfo)jdField_a_of_type_JavaUtilMap.get(paramString);
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
      paramString1.append(jdField_a_of_type_Int);
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
        i = paramArrayList.size();
        paramString1.append(i);
        paramString1.append("");
        localJSONObject.put("viewnum", paramString1.toString());
        paramString1 = new StringBuilder();
        paramString1.append(jdField_a_of_type_Int);
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
      int i = 0;
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
        sgame_qgroup_datacard.GroupMemberInfo localGroupMemberInfo = (sgame_qgroup_datacard.GroupMemberInfo)jdField_a_of_type_JavaUtilMap.get(localResultRecord.uin);
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
  
  public void a()
  {
    jdField_a_of_type_JavaUtilSet.add("member");
    jdField_a_of_type_JavaUtilSet.add("friends");
    jdField_a_of_type_JavaUtilSet.add("online");
  }
  
  public void a(int paramInt1, int paramInt2, Activity paramActivity)
  {
    ArrayList localArrayList;
    int i;
    if (paramActivity != null)
    {
      localArrayList = new ArrayList();
      i = 0;
      for (;;)
      {
        try
        {
          CharDividedFacePreloadBaseAdapter localCharDividedFacePreloadBaseAdapter = ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).getMemberListAdapter(paramActivity);
          int j = paramInt2;
          if (paramInt1 == 0)
          {
            i = localCharDividedFacePreloadBaseAdapter.getCount();
            try
            {
              j = Math.min(paramInt2, i - 1);
            }
            catch (Throwable localThrowable1)
            {
              continue;
            }
          }
          k = paramInt1;
          m = i;
          paramInt2 = j;
          if (k > j) {}
        }
        catch (Throwable localThrowable2)
        {
          int k;
          TroopMemberInfo localTroopMemberInfo;
          i = 0;
          QLog.e("QQGameTroopManager", 1, localThrowable2, new Object[0]);
          int m = i;
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("reqGameInfoByPosition,firstPosition:");
            localStringBuilder.append(paramInt1);
            localStringBuilder.append(",lastPosition:");
            localStringBuilder.append(paramInt2);
            localStringBuilder.append(",itemCount：");
            localStringBuilder.append(m);
            QLog.i("QQGameTroopManager", 2, localStringBuilder.toString());
          }
          a(localArrayList, paramActivity.getIntent().getStringExtra("group_uin"), this.jdField_b_of_type_ComTencentGamecenterWadlBizListenerWadlTrpcListener);
        }
        try
        {
          localTroopMemberInfo = (TroopMemberInfo)localThrowable1.getItem(k);
          if (localTroopMemberInfo != null)
          {
            long l = Long.parseLong(localTroopMemberInfo.memberuin);
            if (!jdField_a_of_type_JavaUtilMap.containsKey(localTroopMemberInfo.memberuin)) {
              localArrayList.add(Long.valueOf(l));
            }
          }
        }
        catch (Throwable localThrowable3)
        {
          continue;
        }
        k += 1;
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
            if (!jdField_a_of_type_JavaUtilMap.containsKey(paramString1.uin)) {
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
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramQBaseActivity);
  }
  
  public void a(PinnedDividerListView paramPinnedDividerListView, Activity paramActivity)
  {
    if (paramPinnedDividerListView != null) {
      a(paramPinnedDividerListView.getFirstVisiblePosition(), paramPinnedDividerListView.getLastVisiblePosition(), paramActivity);
    }
  }
  
  public void a(String paramString)
  {
    jdField_a_of_type_JavaUtilSet.remove(paramString);
    Object localObject;
    if (jdField_a_of_type_JavaUtilSet.size() == 0)
    {
      localObject = a();
      if (localObject != null)
      {
        Map localMap = ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).getIndexedFriends((Activity)localObject);
        if (localMap != null)
        {
          if (localMap.size() == 0) {
            return;
          }
          a((Activity)localObject, jdField_a_of_type_JavaUtilList, localMap);
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
      ((StringBuilder)localObject).append(jdField_a_of_type_JavaUtilSet.toString());
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
      jdField_b_of_type_JavaUtilList.clear();
      paramString = new QQGameMemberSelectInfo.QueryOldFriendsReq();
      paramString.groupCode.set(Long.parseLong(str));
      paramString = ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/12", false, paramString.toByteArray());
      paramQBaseActivity = new TrpcProxy.TrpcListReq();
      paramQBaseActivity.list.add(paramString);
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).addListener(this.jdField_a_of_type_ComTencentGamecenterWadlBizListenerWadlTrpcListener);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
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
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(4), "8");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("groupid", paramString1);
      paramString1 = new StringBuilder();
      paramString1.append(jdField_a_of_type_Int);
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
      jdField_a_of_type_JavaUtilList = Collections.synchronizedList(paramList);
    }
    a("online");
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        if (a() == null) {
          return;
        }
        localObject1 = a();
        localObject3 = ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).getIndexedFriends((Activity)localObject1);
        if ((localObject3 != null) && (((Map)localObject3).size() != 0))
        {
          jdField_a_of_type_Int = 0;
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
        int j;
        int i;
        QLog.e("QQGameTroopManager", 1, localThrowable2, new Object[0]);
        return;
      }
      try
      {
        if ((jdField_b_of_type_JavaUtilList != null) && (jdField_b_of_type_JavaUtilList.contains(Long.valueOf(Long.parseLong(((TroopMemberInfo)localObject6).memberuin)))))
        {
          localList.add(localObject6);
          continue;
        }
        ((List)localObject2).add(localObject6);
      }
      catch (Exception localException) {}
      jdField_a_of_type_Int = localList.size() + ((List)localObject2).size();
      localObject3 = Collections.synchronizedMap(new LinkedHashMap());
      if (localList.size() > 0) {
        ((Map)localObject3).put(((Activity)localObject1).getResources().getString(2131719879), localList);
      }
      if (((List)localObject2).size() > 0) {
        if (localList.size() > 0) {
          ((Map)localObject3).put(((Activity)localObject1).getResources().getString(2131719889), localObject2);
        } else {
          ((Map)localObject3).put(((Activity)localObject1).getResources().getString(2131719883), localObject2);
        }
      }
      j = ((Map)localObject3).keySet().size();
      if (j == 0)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("QQGameTroopManager", 2, "groupSize=0");
        return;
      }
      localObject6 = ((Map)localObject3).keySet().iterator();
      localObject4 = new int[j];
      localObject5 = new String[j];
      localObject4[0] = 0;
      i = 1;
      if (i < localObject4.length)
      {
        localObject4[i] += localObject4[(i - 1)] + ((List)((Map)localObject3).get(((Iterator)localObject6).next())).size() + 1;
        i += 1;
      }
      else
      {
        localObject6 = ((Map)localObject3).keySet().iterator();
        i = 0;
        if (((Iterator)localObject6).hasNext())
        {
          localObject5[i] = ((String)((Iterator)localObject6).next());
          i += 1;
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
            ((StringBuilder)localObject3).append(j);
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
    //   3: invokestatic 154	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   6: checkcast 434	com/tencent/gamecenter/wadl/api/IQQGameTrpcService
    //   9: aload_0
    //   10: getfield 66	com/tencent/mobileqq/gamecenter/util/QQGameTroopManager:jdField_a_of_type_ComTencentGamecenterWadlBizListenerWadlTrpcListener	Lcom/tencent/gamecenter/wadl/biz/listener/WadlTrpcListener;
    //   13: invokeinterface 667 2 0
    //   18: ldc_w 434
    //   21: invokestatic 154	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   24: checkcast 434	com/tencent/gamecenter/wadl/api/IQQGameTrpcService
    //   27: aload_0
    //   28: getfield 71	com/tencent/mobileqq/gamecenter/util/QQGameTroopManager:jdField_b_of_type_ComTencentGamecenterWadlBizListenerWadlTrpcListener	Lcom/tencent/gamecenter/wadl/biz/listener/WadlTrpcListener;
    //   31: invokeinterface 667 2 0
    //   36: aload_0
    //   37: iconst_0
    //   38: putfield 78	com/tencent/mobileqq/gamecenter/util/QQGameTroopManager:jdField_a_of_type_Boolean	Z
    //   41: aload_0
    //   42: aconst_null
    //   43: putfield 84	com/tencent/mobileqq/gamecenter/util/QQGameTroopManager:jdField_a_of_type_MqqUtilWeakReference	Lmqq/util/WeakReference;
    //   46: getstatic 47	com/tencent/mobileqq/gamecenter/util/QQGameTroopManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   49: invokeinterface 668 1 0
    //   54: aconst_null
    //   55: putstatic 282	com/tencent/mobileqq/gamecenter/util/QQGameTroopManager:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   58: getstatic 38	com/tencent/mobileqq/gamecenter/util/QQGameTroopManager:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   61: invokeinterface 607 1 0
    //   66: getstatic 56	com/tencent/mobileqq/gamecenter/util/QQGameTroopManager:jdField_a_of_type_JavaUtilSet	Ljava/util/Set;
    //   69: invokeinterface 669 1 0
    //   74: iconst_0
    //   75: putstatic 356	com/tencent/mobileqq/gamecenter/util/QQGameTroopManager:jdField_a_of_type_Int	I
    //   78: invokestatic 396	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   81: ifeq +37 -> 118
    //   84: goto +25 -> 109
    //   87: astore_1
    //   88: goto +31 -> 119
    //   91: astore_1
    //   92: ldc 175
    //   94: iconst_1
    //   95: aload_1
    //   96: iconst_0
    //   97: anewarray 4	java/lang/Object
    //   100: invokestatic 181	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   103: invokestatic 396	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq +12 -> 118
    //   109: ldc 175
    //   111: iconst_1
    //   112: ldc_w 670
    //   115: invokestatic 404	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: return
    //   119: invokestatic 396	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   122: ifeq +12 -> 134
    //   125: ldc 175
    //   127: iconst_1
    //   128: ldc_w 670
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.util.QQGameTroopManager
 * JD-Core Version:    0.7.0.1
 */