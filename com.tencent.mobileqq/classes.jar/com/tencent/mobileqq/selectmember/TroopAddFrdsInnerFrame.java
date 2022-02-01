package com.tencent.mobileqq.selectmember;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.friend.observer.IFriendObserver;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.handler.ITroopAddFriendHandler;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.util.TroopInfoUtil;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class TroopAddFrdsInnerFrame
  extends SelectMemberInnerFrame
  implements Handler.Callback, View.OnClickListener, SelectMemberActivity.IOnSelectStateChange, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener, AbsListView.OnScrollListener
{
  protected static double b = 10.0D;
  public static int d = 0;
  public static int e = 1;
  private static final int i = ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getSCENE_TYPE_DEFAULT_Value();
  private static int j = 1000;
  protected double a;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  Handler jdField_a_of_type_AndroidOsHandler;
  private View jdField_a_of_type_AndroidViewView;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  protected ProgressBar a;
  protected RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
  FriendObserver jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver = new TroopAddFrdsInnerFrame.1(this);
  IFriendObserver jdField_a_of_type_ComTencentMobileqqFriendObserverIFriendObserver = new TroopAddFrdsInnerFrame.2(this);
  TroopAddFrdsInnerFrame.ListAdapter jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame$ListAdapter;
  TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new TroopAddFrdsInnerFrame.3(this);
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  Long jdField_a_of_type_JavaLangLong;
  String jdField_a_of_type_JavaLangString = "";
  Map<String, List<TroopMemberInfo>> jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
  Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  boolean jdField_a_of_type_Boolean = false;
  int[] jdField_a_of_type_ArrayOfInt = new int[0];
  String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  int jdField_b_of_type_Int = 0;
  Handler jdField_b_of_type_AndroidOsHandler;
  protected TextView b;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private String e;
  int f = jdField_e_of_type_Int;
  private int g;
  private int h = 0;
  
  public TroopAddFrdsInnerFrame(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Double = 0.0D;
  }
  
  public TroopAddFrdsInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Double = 0.0D;
  }
  
  public TroopAddFrdsInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Double = 0.0D;
  }
  
  private int a(String paramString)
  {
    boolean bool2 = SearchUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString);
    boolean bool1;
    if (!bool2) {
      bool1 = SearchUtils.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString);
    } else {
      bool1 = false;
    }
    if (bool2) {
      return 4;
    }
    if (bool1) {
      return 3;
    }
    return 2;
  }
  
  public static void a(Context paramContext, TroopMemberInfo paramTroopMemberInfo, String paramString, boolean paramBoolean)
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    String str = CommonUtils.a(localAppInterface, paramTroopMemberInfo.troopuin, paramTroopMemberInfo.memberuin);
    if ((paramContext instanceof Activity))
    {
      k = ((Activity)paramContext).getIntent().getIntExtra("batch_addfrd_scene_type", i);
      if (k != i)
      {
        k = ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getSubSourceId_single(k);
        break label83;
      }
    }
    int k = 16;
    label83:
    paramString = ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).startAddFriend(paramContext, 1, paramTroopMemberInfo.memberuin, paramString, 3004, k, str, null, null, null, null);
    paramString.putExtra("need_result_uin", true);
    paramString.putExtra("select_multi_mode", paramBoolean);
    paramString.putExtra("troop_uin", paramTroopMemberInfo.troopuin);
    ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).launchAddFriendForResult((Activity)paramContext, paramString, 11);
    ThreadManager.post(new TroopAddFrdsInnerFrame.7(paramBoolean, localAppInterface, paramTroopMemberInfo), 5, null, true);
  }
  
  private void a(Message paramMessage)
  {
    paramMessage = (Object[])paramMessage.obj;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    if (paramMessage.length == 3)
    {
      this.jdField_a_of_type_JavaUtilMap = ((Map)paramMessage[0]);
      this.jdField_a_of_type_ArrayOfInt = ((int[])paramMessage[1]);
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])paramMessage[2]);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    else
    {
      this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
      this.jdField_a_of_type_ArrayOfInt = new int[0];
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    f();
  }
  
  private void a(String paramString, List<TroopMemberInfo> paramList)
  {
    try
    {
      boolean bool = TextUtils.isEmpty(paramString);
      if (bool) {
        return;
      }
      if (paramList == null)
      {
        localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
        paramList = ((EntityManager)localObject).query(TroopMemberInfo.class, false, "troopuin=? ", new String[] { paramString }, null, null, null, null);
        ((EntityManager)localObject).close();
        if (!QLog.isColorLevel()) {
          break label475;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getTroopMemberFromDB, troopMemberInfoList==null, queryDB, troopUin=");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(",");
        if (paramList == null) {
          k = 0;
        } else {
          k = paramList.size();
        }
        ((StringBuilder)localObject).append(k);
        QLog.d("TroopMemberListInnerFrame.thread", 2, ((StringBuilder)localObject).toString());
        break label475;
      }
      if (!QLog.isColorLevel()) {
        break label478;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTroopMemberFromDB, troopuin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",");
      if (paramList == null) {
        k = 0;
      } else {
        k = paramList.size();
      }
      ((StringBuilder)localObject).append(k);
      QLog.d("TroopMemberListInnerFrame.thread", 2, ((StringBuilder)localObject).toString());
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        Map localMap;
        ArrayList localArrayList;
        String str;
        int m;
        int n;
        StringBuilder localStringBuilder;
        for (;;)
        {
          throw paramString;
        }
        label475:
        continue;
        label478:
        continue;
        int k = 1;
        continue;
        label486:
        k = 0;
      }
    }
    localMap = Collections.synchronizedMap(new LinkedHashMap());
    localArrayList = new ArrayList();
    CommonUtils.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_JavaLangString);
    str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    if (paramList == null)
    {
      paramString = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(3);
      this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramString);
      return;
    }
    m = paramList.size();
    this.jdField_a_of_type_Int = (m - 1);
    if (m > 0)
    {
      n = m / j;
      if (m % j == 0)
      {
        k = 0;
        localObject = new AtomicInteger(n + k);
        if (!QLog.isColorLevel()) {
          break label486;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parallel process mJobCount: ");
        localStringBuilder.append(((AtomicInteger)localObject).get());
        QLog.d("TroopMemberListInnerFrame.thread", 2, localStringBuilder.toString());
        break label486;
        while (k < m)
        {
          ThreadManager.post(new TroopAddFrdsInnerFrame.5(this, paramList, k, Math.min(j + k - 1, m), paramString, str, localMap, localArrayList, (AtomicInteger)localObject), 8, null, false);
          k += j;
        }
      }
    }
    else
    {
      paramString = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(3);
      this.jdField_b_of_type_AndroidOsHandler.sendMessage(paramString);
      return;
    }
  }
  
  private void a(Map<String, List<TroopMemberInfo>> paramMap)
  {
    Object localObject1 = (ITroopRobotService)this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getAppRuntime().getRuntimeService(ITroopRobotService.class, "all");
    boolean bool = TroopInfoUtil.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getAppRuntime(), this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getAppRuntime().getCurrentAccountUin());
    int m;
    if ((!((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopAdmin(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getAppRuntime(), this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getAppRuntime().getCurrentAccountUin())) && (!bool)) {
      m = 1;
    } else {
      m = 0;
    }
    Iterator localIterator = paramMap.values().iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (List)localIterator.next();
      int n;
      for (int k = 0; k < ((List)localObject2).size(); k = n + 1)
      {
        if (((List)localObject2).get(k) == null) {
          ((List)localObject2).remove(k);
        }
        for (;;)
        {
          n = k - 1;
          break;
          if (CommonUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((TroopMemberInfo)((List)localObject2).get(k)).memberuin))
          {
            ((List)localObject2).remove(k);
          }
          else
          {
            n = k;
            if (m == 0) {
              break;
            }
            n = k;
            if (!((ITroopRobotService)localObject1).isRobotUin(((TroopMemberInfo)((List)localObject2).get(k)).memberuin)) {
              break;
            }
            ((List)localObject2).remove(k);
          }
        }
      }
    }
    localObject1 = new HashMap();
    localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      if (((List)paramMap.get(localObject2)).size() == 0) {
        ((Map)localObject1).put(localObject2, Integer.valueOf(1));
      }
    }
    localObject1 = ((Map)localObject1).keySet().iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramMap.remove((String)((Iterator)localObject1).next());
    }
  }
  
  private Object[] a()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo == null) && (QLog.isColorLevel())) {
      QLog.d("TroopAddFrdsInnerFrame", 2, "sortMembers: mTroopInfo not exist");
    }
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      Collections.sort((List)this.jdField_a_of_type_JavaUtilMap.get(localObject2), new TroopAddFrdsInnerFrame.MyComparator(this, null));
    }
    localObject1 = this.jdField_a_of_type_JavaUtilMap;
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
    int k = this.f;
    if (k == jdField_d_of_type_Int)
    {
      for (char c1 = 'A'; c1 <= 'Z'; c1 = (char)(c1 + '\001')) {
        if (((Map)localObject1).get(String.valueOf(c1)) != null) {
          this.jdField_a_of_type_JavaUtilMap.put(String.valueOf(c1), ((Map)localObject1).get(String.valueOf(c1)));
        }
      }
      if (((Map)localObject1).get("#") != null) {
        this.jdField_a_of_type_JavaUtilMap.put("#", ((Map)localObject1).get("#"));
      }
      ((Map)localObject1).clear();
    }
    else if (k == jdField_e_of_type_Int)
    {
      k = 1;
      while (k < 5)
      {
        if (((Map)localObject1).get(String.valueOf(k)) != null) {
          this.jdField_a_of_type_JavaUtilMap.put(String.valueOf(k), ((Map)localObject1).get(String.valueOf(k)));
        }
        k += 1;
      }
      ((Map)localObject1).clear();
    }
    localObject1 = new int[this.jdField_a_of_type_JavaUtilMap.keySet().size()];
    Object localObject2 = new String[this.jdField_a_of_type_JavaUtilMap.keySet().size()];
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    if (localObject1.length == 0) {
      return new Object[0];
    }
    localObject1[0] = 0;
    k = 1;
    while (k < localObject1.length)
    {
      localObject1[k] += localObject1[(k - 1)] + ((List)this.jdField_a_of_type_JavaUtilMap.get(localIterator.next())).size() + 1;
      k += 1;
    }
    localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    k = 0;
    while (localIterator.hasNext())
    {
      localObject2[k] = ((String)localIterator.next());
      k += 1;
    }
    return new Object[] { this.jdField_a_of_type_JavaUtilMap, localObject1, localObject2 };
  }
  
  private void b(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      Object localObject1 = CommonUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString);
      if (localObject1 != null) {
        localObject1 = ((TroopInfo)localObject1).troopcode;
      } else {
        localObject1 = "0";
      }
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.stopTitleProgress();
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131692183), 0).b(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mTitleBar.getHeight());
          return;
        }
        this.jdField_a_of_type_Boolean = true;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("get troop members from server, troopUin: ");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(" troopCode: ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("TroopAddFrdsInnerFrame", 2, ((StringBuilder)localObject2).toString());
        }
        Object localObject2 = ((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMemberListHandlerName();
        localObject2 = (ITroopMemberListHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler((String)localObject2);
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        ((ITroopMemberListHandler)localObject2).a(true, paramString, (String)localObject1, true, 7, this.jdField_a_of_type_Long, i);
      }
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131364470));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131368761));
    if (this.f == jdField_d_of_type_Int)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131167333);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379786));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131379284));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131368260));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370395));
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity).inflate(2131562770, this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView, false);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131363868).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131366333));
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setCursorVisible(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
  }
  
  private void h()
  {
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp());
    String str = ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getScene_SP_KEY_BAF_DATA_CHECK_FLAG_MEMBERS_KeyString();
    long l = ((SharedPreferences)localObject).getLong(String.format(Locale.getDefault(), "%s_%s_%s", new Object[] { str, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_b_of_type_JavaLangString }), 0L);
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = CommonUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_JavaLangString);
    localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
    if (localObject != null)
    {
      this.jdField_a_of_type_Int = (((TroopInfo)localObject).wMemberNum - 1);
      if (this.jdField_a_of_type_Int > 0)
      {
        this.jdField_a_of_type_Double = 0.0D;
        localObject = this.jdField_b_of_type_AndroidOsHandler;
        ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(4));
      }
    }
    if (l == 0L)
    {
      b(this.jdField_b_of_type_JavaLangString);
      return;
    }
    ThreadManager.executeOnNetWorkThread(new TroopAddFrdsInnerFrame.4(this));
  }
  
  public ContactSearchFragment a()
  {
    return ContactSearchFragment.a(24, 1048576, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsToHide, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity);
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if ((paramInt1 == 10) && (paramIntent != null) && (paramInt2 == -1))
    {
      localObject = paramIntent.getStringExtra(((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getUnitedVerifyMsgEditFragment_VERIFY_MSG_KeyString());
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      paramIntent = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getResultUins();
      paramInt1 = ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getSubSourceId_multi(this.g);
      ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).batchAddFriendForTroopMembers(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_JavaLangString, (String)localObject, paramIntent, true, 3093, paramInt1);
      localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
      ((Message)localObject).obj = paramIntent;
      ((Message)localObject).sendToTarget();
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.toggleSelectMode(true, false);
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
      localObject = this.jdField_b_of_type_AndroidOsHandler;
      ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(8), 120L);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131718756), 0).a();
      f();
      localObject = this.jdField_b_of_type_JavaLangString;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        ThreadManager.post(new TroopAddFrdsInnerFrame.6(this, (String)localObject, paramIntent), 5, null, true);
      }
    }
    else if ((paramInt1 == 11) && (paramIntent != null) && (paramInt2 == -1))
    {
      localObject = paramIntent.getStringExtra("uin");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      paramIntent = new ArrayList(1);
      paramIntent.add(localObject);
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.toggleSelectMode(true, false);
        this.jdField_b_of_type_AndroidOsHandler.removeMessages(8);
        localObject = this.jdField_b_of_type_AndroidOsHandler;
        ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(8), 120L);
      }
      localObject = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
      ((Message)localObject).obj = paramIntent;
      ((Message)localObject).sendToTarget();
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2131562810);
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper(), this);
    this.jdField_b_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this);
    this.g = paramBundle.getInt("batch_addfrd_scene_type", i);
    g();
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame$ListAdapter = new TroopAddFrdsInnerFrame.ListAdapter(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame$ListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverIFriendObserver);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.setOnSelectStateChangeListener(this);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(ResultRecord paramResultRecord, boolean paramBoolean)
  {
    if (paramResultRecord != null) {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame$ListAdapter.a(paramResultRecord, paramBoolean);
    }
  }
  
  public void a(String paramString)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    TroopMemberInfo localTroopMemberInfo = null;
    label110:
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (List)this.jdField_a_of_type_JavaUtilMap.get(localObject);
      int k = 0;
      for (;;)
      {
        if (k >= ((List)localObject).size()) {
          break label110;
        }
        if (paramString.equals(((TroopMemberInfo)((List)localObject).get(k)).memberuin))
        {
          localTroopMemberInfo = (TroopMemberInfo)((List)localObject).get(k);
          break;
        }
        k += 1;
      }
    }
    if (localTroopMemberInfo != null) {
      a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, localTroopMemberInfo, this.jdField_d_of_type_JavaLangString, true);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean2) {
      this.jdField_b_of_type_Boolean ^= true;
    }
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.removeHeaderView(this.jdField_a_of_type_AndroidViewView);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
    }
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame$ListAdapter.a.clear();
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.removeAllFriendResult();
    }
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame$ListAdapter.a(this.jdField_b_of_type_Boolean);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mSelectedAndSearchBar.b();
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("group_uin");
    this.jdField_c_of_type_JavaLangString = paramBundle.getString("group_name");
    this.jdField_d_of_type_JavaLangString = paramBundle.getString("param_groupcode");
    this.jdField_e_of_type_JavaLangString = paramBundle.getString("batch_addfrd_recommand_uin");
    paramBundle = this.jdField_c_of_type_JavaLangString;
    if ((paramBundle == null) || (paramBundle.length() == 0))
    {
      paramBundle = this.jdField_b_of_type_JavaLangString;
      if ((paramBundle != null) && (paramBundle.length() > 0))
      {
        paramBundle = CommonUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_JavaLangString);
        if (paramBundle != null) {
          this.jdField_c_of_type_JavaLangString = paramBundle.getTroopDisplayName();
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mOnlyTroopMember) {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.setupTitleBar(false, "", this.jdField_c_of_type_JavaLangString);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.setupTitleBar(true, HardCodeUtil.a(2131714934), this.jdField_c_of_type_JavaLangString);
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramBundle = this.jdField_b_of_type_JavaLangString;
    if ((paramBundle != null) && (paramBundle.length() > 0))
    {
      if (!this.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
        this.jdField_a_of_type_ArrayOfInt = new int[0];
        this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
        f();
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        h();
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
        this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        return;
      }
      f();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.finish();
  }
  
  public void c()
  {
    super.c();
  }
  
  public void d()
  {
    TroopAddFrdsInnerFrame.ListAdapter localListAdapter = this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame$ListAdapter;
    if (localListAdapter != null) {
      localListAdapter.c();
    }
    this.jdField_b_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverIFriendObserver);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame$ListAdapter.notifyDataSetChanged();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject1;
    Object localObject2;
    int k;
    int n;
    int m;
    String str;
    switch (paramMessage.what)
    {
    default: 
      return false;
    case 10: 
      if (this.jdField_a_of_type_JavaUtilSet.size() > 0)
      {
        paramMessage = new HashMap(this.jdField_a_of_type_JavaUtilSet.size());
        localObject1 = this.jdField_a_of_type_JavaUtilSet.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          paramMessage.put(localObject2, Integer.valueOf(a((String)localObject2)));
        }
        this.jdField_a_of_type_JavaUtilSet.clear();
        localObject1 = this.jdField_b_of_type_AndroidOsHandler.obtainMessage(7);
        ((Message)localObject1).obj = paramMessage;
        ((Message)localObject1).sendToTarget();
        return false;
      }
      break;
    case 9: 
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof List)))
      {
        paramMessage = (List)paramMessage.obj;
        this.jdField_a_of_type_JavaUtilSet.addAll(paramMessage);
        if (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(10))
        {
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(10, 300L);
          return false;
        }
      }
      break;
    case 8: 
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelectionFromTop(0, 0);
      return false;
    case 7: 
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof HashMap)))
      {
        paramMessage = (HashMap)paramMessage.obj;
        localObject1 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
        for (k = 0; ((Iterator)localObject1).hasNext(); k = m)
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localObject2 = (List)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
          n = 0;
          for (;;)
          {
            m = k;
            if (n >= ((List)localObject2).size()) {
              break;
            }
            str = ((TroopMemberInfo)((List)localObject2).get(n)).memberuin;
            m = k;
            if (paramMessage.containsKey(str))
            {
              m = k + 1;
              k = ((Integer)paramMessage.get(str)).intValue();
              ((TroopMemberInfo)((List)localObject2).get(n)).addState = k;
            }
            if (m >= paramMessage.size()) {
              break;
            }
            n += 1;
            k = m;
          }
        }
        f();
        return false;
      }
      break;
    case 6: 
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof HashMap)))
      {
        paramMessage = (HashMap)paramMessage.obj;
        localObject1 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
        for (k = 0; ((Iterator)localObject1).hasNext(); k = m)
        {
          localObject2 = (String)((Iterator)localObject1).next();
          localObject2 = (List)this.jdField_a_of_type_JavaUtilMap.get(localObject2);
          n = 0;
          for (;;)
          {
            m = k;
            if (n >= ((List)localObject2).size()) {
              break;
            }
            str = ((TroopMemberInfo)((List)localObject2).get(n)).memberuin;
            m = k;
            if (paramMessage.containsKey(str))
            {
              k += 1;
              m = ((Integer)paramMessage.get(str)).intValue();
              ((TroopMemberInfo)((List)localObject2).get(n)).commonFrdCnt = m;
              m = k;
              if (k >= paramMessage.size())
              {
                m = k;
                break;
              }
            }
            n += 1;
            k = m;
          }
        }
        f();
        return false;
      }
      break;
    case 5: 
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof List)))
      {
        paramMessage = (List)paramMessage.obj;
        localObject1 = ((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopAddFriendHandlerName();
        localObject1 = (ITroopAddFriendHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler((String)localObject1);
        this.jdField_a_of_type_JavaLangLong = Long.valueOf(System.currentTimeMillis());
        ((ITroopAddFriendHandler)localObject1).a(this.jdField_b_of_type_JavaLangString, paramMessage, 0, this.jdField_a_of_type_JavaLangLong.longValue(), i, false);
        return false;
      }
      break;
    case 4: 
      this.jdField_a_of_type_Double += jdField_b_of_type_Double;
      if ((this.jdField_a_of_type_Double < 90.0D) && (this.jdField_a_of_type_Int > 0))
      {
        if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 8) {
          this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        }
        this.jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)this.jdField_a_of_type_Double);
        paramMessage = this.jdField_b_of_type_AndroidWidgetTextView;
        localObject1 = HardCodeUtil.a(2131714932);
        k = this.jdField_a_of_type_Int;
        double d1 = k;
        double d2 = this.jdField_a_of_type_Double;
        Double.isNaN(d1);
        paramMessage.setText(String.format((String)localObject1, new Object[] { Integer.valueOf(Math.min((int)(d1 * d2 / 100.0D), k)), Integer.valueOf(this.jdField_a_of_type_Int) }));
        paramMessage = this.jdField_b_of_type_AndroidOsHandler;
        paramMessage.sendMessageDelayed(paramMessage.obtainMessage(4), 800L);
        return false;
      }
      break;
    case 3: 
      this.h = paramMessage.arg1;
      this.jdField_b_of_type_AndroidOsHandler.removeMessages(4);
      if ((paramMessage.obj instanceof Object[]))
      {
        localObject2 = (Object[])paramMessage.obj;
        if (localObject2.length > 0)
        {
          localObject1 = (String)localObject2[1];
          if (!((String)localObject1).equals(this.jdField_b_of_type_JavaLangString))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            paramMessage = new StringBuilder();
            paramMessage.append("handleMessage, troopUin != mTroopUin, break:");
            paramMessage.append((String)localObject1);
            paramMessage.append(",");
            paramMessage.append(this.jdField_b_of_type_JavaLangString);
            QLog.d("TroopMemberListInnerFrame.thread", 2, paramMessage.toString());
            return false;
          }
          this.jdField_a_of_type_JavaUtilMap = ((Map)localObject2[0]);
        }
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleMessage, mIndexedFriends.size=");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaUtilMap.size());
        QLog.d("TroopMemberListInnerFrame.thread", 2, ((StringBuilder)localObject1).toString());
      }
      a(this.jdField_a_of_type_JavaUtilMap);
      paramMessage.obj = a();
      a(paramMessage);
      return false;
    case 1: 
    case 2: 
      a(paramMessage);
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131366333)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("batch_addfrd_scene_type", this.g);
      ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).launchContactSearchComponentActivityForResult(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, null, this.jdField_b_of_type_JavaLangString, 23, 1048576, 21001, localBundle);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onIndexChanged(String paramString)
  {
    if ("$".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
      return;
    }
    int k = this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopAddFrdsInnerFrame$ListAdapter.a(paramString);
    if (k != -1)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
      paramString.setSelection(k + paramString.getHeaderViewsCount());
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt != 0)
    {
      paramAbsListView = MobileQQ.sMobileQQ;
      ((InputMethodManager)MobileQQ.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getWindowToken(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopAddFrdsInnerFrame
 * JD-Core Version:    0.7.0.1
 */