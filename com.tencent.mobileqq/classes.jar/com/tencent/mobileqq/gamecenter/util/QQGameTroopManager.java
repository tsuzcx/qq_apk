package com.tencent.mobileqq.gamecenter.util;

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
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
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
  public WeakReference<BaseActivity> a;
  private boolean jdField_a_of_type_Boolean = false;
  private WadlTrpcListener jdField_b_of_type_ComTencentGamecenterWadlBizListenerWadlTrpcListener = new QQGameTroopManager.3(this);
  
  static
  {
    jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
  }
  
  public QQGameTroopManager(QQAppInterface paramQQAppInterface) {}
  
  private SelectMemberActivity a()
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && ((this.jdField_a_of_type_MqqUtilWeakReference.get() instanceof SelectMemberActivity))) {
      return (SelectMemberActivity)this.jdField_a_of_type_MqqUtilWeakReference.get();
    }
    return null;
  }
  
  public static void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((paramInt == 0) || (paramInt == 1)) {
      if ((paramBoolean) && (paramInt != 1)) {}
    }
    label151:
    label167:
    label173:
    label180:
    for (;;)
    {
      try
      {
        if (Math.abs(System.currentTimeMillis() - jdField_b_of_type_Long) <= 2000L) {
          return;
        }
        jdField_b_of_type_Long = System.currentTimeMillis();
        localHashMap = new HashMap();
        if (!paramBoolean) {
          break label151;
        }
        localObject = "8";
        localHashMap.put(Integer.valueOf(4), localObject);
        localObject = new JSONObject();
        ((JSONObject)localObject).put("groupid", paramString);
        localHashMap.put(Integer.valueOf(27), ((JSONObject)localObject).toString());
        if (paramInt != 0) {
          break label173;
        }
        if (!paramBoolean) {
          break label167;
        }
        paramString = "207966";
      }
      catch (Throwable paramString)
      {
        HashMap localHashMap;
        QLog.e("QQGameTroopManager", 1, paramString, new Object[0]);
        return;
      }
      GameCenterUtils.a(CmGameUtil.a(), "1006", paramString, "", "100602", "1", "145", localHashMap);
      return;
      Object localObject = "20";
      continue;
      do
      {
        paramString = "207940";
        break label180;
        return;
        for (;;)
        {
          break;
          paramString = "207939";
        }
      } while (!paramBoolean);
      paramString = "207965";
    }
  }
  
  public static void a(ImageView paramImageView, String paramString)
  {
    paramString = (sgame_qgroup_datacard.GroupMemberInfo)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((paramString != null) && (!TextUtils.isEmpty(paramString.gradeIcon.get())))
    {
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
      localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
      paramImageView.setImageDrawable(URLDrawable.getDrawable(paramString.gradeIcon.get(), localURLDrawableOptions));
      paramImageView.setVisibility(0);
      return;
    }
    paramImageView.setVisibility(4);
  }
  
  private void a(SelectMemberActivity paramSelectMemberActivity, List<String> paramList, Map<String, List<TroopMemberInfo>> paramMap)
  {
    if ((paramSelectMemberActivity == null) || (paramMap == null)) {}
    do
    {
      return;
      if (paramList != null) {
        try
        {
          if (!paramList.isEmpty())
          {
            paramList = paramMap.keySet().iterator();
            while (paramList.hasNext()) {
              Collections.sort((List)paramMap.get((String)paramList.next()), this.jdField_a_of_type_JavaUtilComparator);
            }
          }
          ThreadManagerV2.getUIHandlerV2().post(new QQGameTroopManager.5(this, paramSelectMemberActivity));
        }
        catch (Throwable paramSelectMemberActivity)
        {
          QLog.e("QQGameTroopManager", 1, paramSelectMemberActivity, new Object[0]);
          return;
        }
      }
    } while (!a(paramSelectMemberActivity));
    a(0, 50, a());
  }
  
  public static void a(BaseActivity paramBaseActivity, TroopMemberInfo paramTroopMemberInfo, TextView paramTextView1, ImageView paramImageView, TextView paramTextView2)
  {
    if (paramTroopMemberInfo != null)
    {
      try
      {
        paramTextView1.setVisibility(0);
        String str = paramBaseActivity.getResources().getString(2131720152);
        paramTextView1.setText(str);
        paramImageView.setVisibility(8);
        sgame_qgroup_datacard.GroupMemberInfo localGroupMemberInfo = (sgame_qgroup_datacard.GroupMemberInfo)jdField_a_of_type_JavaUtilMap.get(paramTroopMemberInfo.memberuin);
        if (localGroupMemberInfo != null)
        {
          if (localGroupMemberInfo.ret.get() != 0) {
            break label166;
          }
          if (!TextUtils.isEmpty(localGroupMemberInfo.gradeName.get())) {
            break label153;
          }
          paramTextView1.setText(str);
          if (!TextUtils.isEmpty(localGroupMemberInfo.gradeIcon.get()))
          {
            paramTextView1 = URLDrawable.URLDrawableOptions.obtain();
            paramTextView1.mLoadingDrawable = URLDrawableHelper.TRANSPARENT;
            paramTextView1.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
            paramImageView.setImageDrawable(URLDrawable.getDrawable(localGroupMemberInfo.gradeIcon.get(), paramTextView1));
            paramImageView.setVisibility(0);
          }
        }
        for (;;)
        {
          if (jdField_a_of_type_JavaUtilList != null) {
            break label210;
          }
          paramTextView2.setVisibility(8);
          return;
          label153:
          str = localGroupMemberInfo.gradeName.get();
          break;
          label166:
          if (localGroupMemberInfo.ret.get() == 200022) {
            paramTextView1.setText(paramBaseActivity.getResources().getString(2131720153));
          }
        }
        paramTextView2.setVisibility(0);
      }
      catch (Throwable paramBaseActivity)
      {
        QLog.e("QQGameTroopManager", 1, paramBaseActivity, new Object[0]);
        return;
      }
      label210:
      if (jdField_a_of_type_JavaUtilList.contains(paramTroopMemberInfo.memberuin))
      {
        paramTextView2.setText(paramBaseActivity.getResources().getString(2131719512));
        return;
      }
      paramTextView2.setText(paramBaseActivity.getResources().getString(2131719511));
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(4), "20");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("groupid", paramString1);
      localJSONObject.put("roomnum", jdField_a_of_type_Int + "");
      localJSONObject.put("guestuin", paramString2);
      localJSONObject.put("adtag", paramString3);
      localHashMap.put(Integer.valueOf(27), localJSONObject.toString());
      GameCenterUtils.a(CmGameUtil.a(), "1006", "207967", paramString4, "100602", "1", "145", localHashMap);
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        QLog.e("QQGameTroopManager", 1, paramString1, new Object[0]);
      }
    }
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
          continue;
        }
        i = paramArrayList.size();
        localJSONObject.put("viewnum", i + "");
        localJSONObject.put("roomnum", jdField_a_of_type_Int + "");
      }
      catch (JSONException paramString1)
      {
        int i;
        QLog.e("QQGameTroopManager", 1, paramString1, new Object[0]);
        continue;
      }
      localHashMap.put(Integer.valueOf(27), localJSONObject.toString());
      GameCenterUtils.a(CmGameUtil.a(), "1006", "207968", paramString2, "100602", "1", "145", localHashMap);
      return;
      i = 0;
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
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QQGameTroopManager", 2, "doReqGameMemberInfo...friendsUinList size:" + paramList.size() + ",troopUin：" + paramString);
    }
    try
    {
      sgame_qgroup_datacard.QueryGroupMemberInfoReq localQueryGroupMemberInfoReq = new sgame_qgroup_datacard.QueryGroupMemberInfoReq();
      localQueryGroupMemberInfoReq.groupId.set(Long.parseLong(paramString));
      localQueryGroupMemberInfoReq.uinList.set(paramList);
      paramList = ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/14", false, localQueryGroupMemberInfoReq.toByteArray());
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
  
  public static boolean a(SelectMemberActivity paramSelectMemberActivity)
  {
    boolean bool = true;
    if (paramSelectMemberActivity == null) {
      return false;
    }
    if ((paramSelectMemberActivity.getIntent().getIntExtra("game_req_info_flag", 0) & 0x1) == 1) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public static boolean b(SelectMemberActivity paramSelectMemberActivity)
  {
    boolean bool = true;
    if ((paramSelectMemberActivity == null) || (paramSelectMemberActivity.app == null)) {
      bool = false;
    }
    while ((paramSelectMemberActivity.getIntent().getIntExtra("param_entrance", 0) == 43) && (paramSelectMemberActivity.getIntent().getIntExtra("GAME_H5_SELECT_BUSINESS_TYPE", 0) == 1)) {
      return bool;
    }
    return false;
  }
  
  public void a()
  {
    jdField_a_of_type_JavaUtilSet.add("member");
    jdField_a_of_type_JavaUtilSet.add("friends");
    jdField_a_of_type_JavaUtilSet.add("online");
  }
  
  public void a(int paramInt1, int paramInt2, SelectMemberActivity paramSelectMemberActivity)
  {
    int j = 0;
    if (paramSelectMemberActivity != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i;
      for (;;)
      {
        try
        {
          localCharDividedFacePreloadBaseAdapter = paramSelectMemberActivity.a();
          i = paramInt2;
          if (paramInt1 == 0) {
            i = localCharDividedFacePreloadBaseAdapter.getCount();
          }
        }
        catch (Throwable localThrowable1)
        {
          CharDividedFacePreloadBaseAdapter localCharDividedFacePreloadBaseAdapter;
          int k;
          TroopMemberInfo localTroopMemberInfo;
          i = 0;
        }
        try
        {
          j = Math.min(paramInt2, i - 1);
          paramInt2 = j;
          j = i;
          i = paramInt2;
          k = paramInt1;
          m = j;
          paramInt2 = i;
          if (k > i) {}
        }
        catch (Throwable localThrowable2)
        {
          break label143;
        }
        try
        {
          localTroopMemberInfo = (TroopMemberInfo)localCharDividedFacePreloadBaseAdapter.getItem(k);
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
      label143:
      QLog.e("QQGameTroopManager", 1, localThrowable1, new Object[0]);
      int m = i;
      if (QLog.isColorLevel()) {
        QLog.i("QQGameTroopManager", 2, "reqGameInfoByPosition,firstPosition:" + paramInt1 + ",lastPosition:" + paramInt2 + ",itemCount：" + m);
      }
      a(localArrayList, paramSelectMemberActivity.getIntent().getStringExtra("group_uin"), this.jdField_b_of_type_ComTencentGamecenterWadlBizListenerWadlTrpcListener);
    }
  }
  
  public void a(SelectMemberActivity paramSelectMemberActivity, List<ResultRecord> paramList, int paramInt, String paramString1, String paramString2)
  {
    a(paramSelectMemberActivity);
    String str;
    if ((paramInt == 3) || (paramInt == 2))
    {
      if (paramInt == 3)
      {
        str = "1";
        a(paramString2, paramString1, str, paramSelectMemberActivity.getIntent().getStringExtra("GAME_H5_SELECT_GAME_APPID"));
      }
    }
    else {
      if (a(paramSelectMemberActivity)) {
        break label59;
      }
    }
    label59:
    do
    {
      do
      {
        return;
        str = "2";
        break;
      } while ((paramList == null) || (paramList.size() == 0));
      if (QLog.isColorLevel()) {
        QLog.i("QQGameTroopManager", 2, "onSearchBarDone,recordsSize：" + paramList.size() + ",searchType:" + paramInt);
      }
      paramSelectMemberActivity = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramString1 = (ResultRecord)paramList.next();
        if (paramString1 != null) {
          try
          {
            if (!jdField_a_of_type_JavaUtilMap.containsKey(paramString1.uin)) {
              paramSelectMemberActivity.add(Long.valueOf(Long.parseLong(paramString1.uin)));
            }
          }
          catch (Throwable paramString1)
          {
            QLog.e("QQGameTroopManager", 1, paramString1, new Object[0]);
          }
        }
      }
    } while (paramSelectMemberActivity.size() == 0);
    if (paramInt == 3) {}
    for (paramInt = 500;; paramInt = 100)
    {
      ThreadManager.getSubThreadHandler().removeCallbacksAndMessages("reqGameInfo");
      ThreadManager.getSubThreadHandler().postAtTime(new QQGameTroopManager.4(this, paramSelectMemberActivity, paramString2), "reqGameInfo", SystemClock.uptimeMillis() + paramInt);
      return;
    }
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramBaseActivity);
  }
  
  public void a(PinnedDividerListView paramPinnedDividerListView, SelectMemberActivity paramSelectMemberActivity)
  {
    if (paramPinnedDividerListView != null) {
      a(paramPinnedDividerListView.getFirstVisiblePosition(), paramPinnedDividerListView.getLastVisiblePosition(), paramSelectMemberActivity);
    }
  }
  
  public void a(String paramString)
  {
    jdField_a_of_type_JavaUtilSet.remove(paramString);
    SelectMemberActivity localSelectMemberActivity;
    if (jdField_a_of_type_JavaUtilSet.size() == 0)
    {
      localSelectMemberActivity = a();
      if (localSelectMemberActivity != null)
      {
        localMap = localSelectMemberActivity.a();
        if ((localMap != null) && (localMap.size() != 0)) {}
      }
    }
    while (!QLog.isColorLevel())
    {
      Map localMap;
      return;
      a(localSelectMemberActivity, jdField_a_of_type_JavaUtilList, localMap);
    }
    QLog.i("QQGameTroopManager", 2, "checkNeedSortAndPreload,sTaskSet:" + jdField_a_of_type_JavaUtilSet.toString() + ",taskName:" + paramString);
  }
  
  public void a(String paramString, SelectMemberActivity paramSelectMemberActivity)
  {
    if ((paramSelectMemberActivity == null) || (paramSelectMemberActivity.app == null)) {
      return;
    }
    ((TroopHandler)paramSelectMemberActivity.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).t(paramString);
  }
  
  public void a(String paramString, BaseActivity paramBaseActivity)
  {
    try
    {
      a(paramBaseActivity);
      String str = paramString;
      if (TextUtils.isEmpty(paramString)) {
        str = paramBaseActivity.getIntent().getStringExtra("group_uin");
      }
      jdField_b_of_type_JavaUtilList.clear();
      paramString = new QQGameMemberSelectInfo.QueryOldFriendsReq();
      paramString.groupCode.set(Long.parseLong(str));
      paramString = ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).createTrpcInvokeReq("/v1/12", false, paramString.toByteArray());
      paramBaseActivity = new TrpcProxy.TrpcListReq();
      paramBaseActivity.list.add(paramString);
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).addListener(this.jdField_a_of_type_ComTencentGamecenterWadlBizListenerWadlTrpcListener);
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).requestTrpc(paramBaseActivity, null);
      if (QLog.isColorLevel()) {
        QLog.i("QQGameTroopManager", 2, "doReqGameFriends...troopUin:" + str);
      }
      return;
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
      localJSONObject.put("roomnum", jdField_a_of_type_Int + "");
      localHashMap.put(Integer.valueOf(27), localJSONObject.toString());
      GameCenterUtils.a(CmGameUtil.a(), "1006", "207851", paramString2, "100602", "1", "145", localHashMap);
      return;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        QLog.e("QQGameTroopManager", 1, paramString1, new Object[0]);
      }
    }
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
      Map localMap;
      List localList1;
      List localList2;
      Object localObject1;
      Object localObject2;
      try
      {
        if (a() == null) {
          return;
        }
        SelectMemberActivity localSelectMemberActivity = a();
        localMap = localSelectMemberActivity.a();
        if ((localMap == null) || (localMap.size() == 0)) {
          break label655;
        }
        jdField_a_of_type_Int = 0;
        localList1 = Collections.synchronizedList(new ArrayList());
        localList2 = Collections.synchronizedList(new ArrayList());
        localObject1 = localMap.keySet().iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label220;
        }
        localObject2 = (List)localMap.get((String)((Iterator)localObject1).next());
        if (localObject2 == null) {
          continue;
        }
        localObject2 = ((List)localObject2).iterator();
      }
      catch (Throwable localThrowable)
      {
        try
        {
          if ((jdField_b_of_type_JavaUtilList != null) && (jdField_b_of_type_JavaUtilList.contains(Long.valueOf(Long.parseLong(((TroopMemberInfo)localObject3).memberuin)))))
          {
            localList2.add(localObject3);
            continue;
          }
          localList1.add(localObject3);
        }
        catch (Exception localException) {}
        localThrowable = localThrowable;
        QLog.e("QQGameTroopManager", 1, localThrowable, new Object[0]);
        return;
      }
      if (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (TroopMemberInfo)((Iterator)localObject2).next();
        if (localObject3 != null)
        {
          label220:
          jdField_a_of_type_Int = localList2.size() + localList1.size();
          localMap = Collections.synchronizedMap(new LinkedHashMap());
          if (localList2.size() > 0) {
            localMap.put(localThrowable.getResources().getString(2131720146), localList2);
          }
          if (localList1.size() > 0)
          {
            if (localList2.size() <= 0) {
              break label355;
            }
            localMap.put(localThrowable.getResources().getString(2131720156), localList1);
          }
          int j;
          for (;;)
          {
            j = localMap.keySet().size();
            if (j != 0) {
              break;
            }
            if (!QLog.isColorLevel()) {
              break label655;
            }
            QLog.e("QQGameTroopManager", 2, "groupSize=0");
            return;
            label355:
            localMap.put(localThrowable.getResources().getString(2131720150), localList1);
          }
          localObject3 = localMap.keySet().iterator();
          localObject1 = new int[j];
          localObject2 = new String[j];
          localObject1[0] = 0;
          int i = 1;
          while (i < localObject1.length)
          {
            int k = localObject1[i];
            int m = localObject1[(i - 1)];
            localObject1[i] = (((List)localMap.get(((Iterator)localObject3).next())).size() + m + 1 + k);
            i += 1;
          }
          localObject3 = localMap.keySet().iterator();
          i = 0;
          while (((Iterator)localObject3).hasNext())
          {
            localObject2[i] = ((String)((Iterator)localObject3).next());
            i += 1;
          }
          if (Looper.getMainLooper() == Looper.myLooper()) {
            localThrowable.a(localMap, (int[])localObject1, (String[])localObject2);
          }
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.i("QQGameTroopManager", 2, "handleGameClockData...gameFriendList:" + localList2.size() + ",otherMemberList:" + localList1.size() + ",groupSize:" + j);
            }
            a(localThrowable.getIntent().getStringExtra("group_uin"), localThrowable.getIntent().getStringExtra("GAME_H5_SELECT_GAME_APPID"));
            return;
            ThreadManagerV2.getUIHandlerV2().post(new QQGameTroopManager.1(this, localThrowable, localMap, (int[])localObject1, (String[])localObject2));
          }
          label655:
          return;
        }
      }
    }
  }
  
  public void onDestroy()
  {
    try
    {
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).removeListener(this.jdField_a_of_type_ComTencentGamecenterWadlBizListenerWadlTrpcListener);
      ((IQQGameTrpcService)QRoute.api(IQQGameTrpcService.class)).removeListener(this.jdField_b_of_type_ComTencentGamecenterWadlBizListenerWadlTrpcListener);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_MqqUtilWeakReference = null;
      jdField_a_of_type_JavaUtilMap.clear();
      jdField_a_of_type_JavaUtilList = null;
      jdField_b_of_type_JavaUtilList.clear();
      jdField_a_of_type_JavaUtilSet.clear();
      jdField_a_of_type_Int = 0;
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQGameTroopManager", 1, localThrowable, new Object[0]);
      return;
    }
    finally
    {
      if (QLog.isColorLevel()) {
        QLog.i("QQGameTroopManager", 1, "onDestroy");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.util.QQGameTroopManager
 * JD-Core Version:    0.7.0.1
 */