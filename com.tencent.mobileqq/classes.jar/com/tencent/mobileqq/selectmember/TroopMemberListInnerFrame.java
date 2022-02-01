package com.tencent.mobileqq.selectmember;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.api.ISelectMemberRefatorHelperApi;
import com.tencent.mobileqq.adapter.CharDividedFacePreloadBaseAdapter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.search.business.contact.fragment.ContactSearchFragment;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.data.TroopRankConfig;
import com.tencent.mobileqq.troop.data.TroopRankConfig.TroopRankItem;
import com.tencent.mobileqq.troop.onlinemember.api.ITroopOnlineMemberHandler;
import com.tencent.mobileqq.troop.onlinemember.api.TroopOnlineMemberObserver;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mobileqq.troop.util.TroopInfoUtil;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.util.AccessibilityUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.IndexView;
import com.tencent.mobileqq.widget.IndexView.OnIndexChangedListener;
import com.tencent.mobileqq.widget.PinnedDividerListView;
import com.tencent.mobileqq.widget.PinnedDividerListView.OnLayoutListener;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class TroopMemberListInnerFrame
  extends SelectMemberInnerFrame
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, IndexView.OnIndexChangedListener, PinnedDividerListView.OnLayoutListener
{
  protected static double b = 10.0D;
  private static int d = 1000;
  protected double a;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  Handler jdField_a_of_type_AndroidOsHandler = new TroopMemberListInnerFrame.1(this);
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  protected ProgressBar a;
  RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private TroopInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
  TroopMemberInfo jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo;
  TroopMemberListInnerFrame.TroopMemberListAdapter jdField_a_of_type_ComTencentMobileqqSelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new TroopMemberListInnerFrame.7(this);
  private TroopOnlineMemberObserver jdField_a_of_type_ComTencentMobileqqTroopOnlinememberApiTroopOnlineMemberObserver = new TroopMemberListInnerFrame.8(this);
  private IndexView jdField_a_of_type_ComTencentMobileqqWidgetIndexView;
  PinnedDividerListView jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new TroopMemberListInnerFrame.9(this);
  String jdField_a_of_type_JavaLangString = "";
  List<TroopMemberInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  Map<String, List<TroopMemberInfo>> jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
  boolean jdField_a_of_type_Boolean;
  int[] jdField_a_of_type_ArrayOfInt = new int[0];
  String[] jdField_a_of_type_ArrayOfJavaLangString = new String[0];
  int jdField_b_of_type_Int = 1;
  protected RelativeLayout b;
  protected TextView b;
  String jdField_b_of_type_JavaLangString;
  boolean jdField_b_of_type_Boolean = false;
  private int jdField_c_of_type_Int = 0;
  protected TextView c;
  private String jdField_c_of_type_JavaLangString;
  boolean jdField_c_of_type_Boolean = false;
  protected TextView d;
  
  public TroopMemberListInnerFrame(Context paramContext)
  {
    super(paramContext);
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_Double = 0.0D;
  }
  
  public TroopMemberListInnerFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_Double = 0.0D;
  }
  
  public TroopMemberListInnerFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_b_of_type_AndroidWidgetTextView = null;
    this.jdField_c_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_Double = 0.0D;
  }
  
  private int a(Map<String, List<TroopMemberInfo>> paramMap)
  {
    Object localObject1 = (ITroopRobotService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopRobotService.class, "all");
    boolean bool = TroopInfoUtil.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    int j;
    if ((!((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).isTroopAdmin(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())) && (!bool)) {
      j = 1;
    } else {
      j = 0;
    }
    Iterator localIterator = paramMap.values().iterator();
    int k = 0;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (List)localIterator.next();
      int m;
      for (int i = 0; i < ((List)localObject2).size(); i = m + 1)
      {
        if (((List)localObject2).get(i) == null) {
          ((List)localObject2).remove(i);
        }
        for (;;)
        {
          m = i - 1;
          break;
          if (CommonUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((TroopMemberInfo)((List)localObject2).get(i)).memberuin))
          {
            ((List)localObject2).remove(i);
          }
          else
          {
            m = i;
            if (j == 0) {
              break;
            }
            m = i;
            if (!((ITroopRobotService)localObject1).isRobotUin(((TroopMemberInfo)((List)localObject2).get(i)).memberuin)) {
              break;
            }
            ((List)localObject2).remove(i);
          }
        }
      }
      k += ((List)localObject2).size();
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
    return k;
  }
  
  /* Error */
  private Bitmap a(View paramView)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: invokevirtual 249	android/view/View:getWidth	()I
    //   7: istore_2
    //   8: aload_1
    //   9: invokevirtual 252	android/view/View:getHeight	()I
    //   12: istore_3
    //   13: aload 5
    //   15: astore 4
    //   17: iload_2
    //   18: ifeq +34 -> 52
    //   21: aload 5
    //   23: astore 4
    //   25: iload_3
    //   26: ifeq +26 -> 52
    //   29: iload_2
    //   30: iload_3
    //   31: getstatic 258	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   34: invokestatic 264	android/graphics/Bitmap:createBitmap	(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   37: astore 4
    //   39: aload_1
    //   40: new 266	android/graphics/Canvas
    //   43: dup
    //   44: aload 4
    //   46: invokespecial 269	android/graphics/Canvas:<init>	(Landroid/graphics/Bitmap;)V
    //   49: invokevirtual 273	android/view/View:draw	(Landroid/graphics/Canvas;)V
    //   52: aload 4
    //   54: areturn
    //   55: astore_1
    //   56: aconst_null
    //   57: areturn
    //   58: astore_1
    //   59: goto -7 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	TroopMemberListInnerFrame
    //   0	62	1	paramView	View
    //   7	23	2	i	int
    //   12	19	3	j	int
    //   15	38	4	localObject1	Object
    //   1	21	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	13	55	java/lang/Exception
    //   3	13	55	java/lang/OutOfMemoryError
    //   29	39	55	java/lang/Exception
    //   29	39	55	java/lang/OutOfMemoryError
    //   39	52	55	java/lang/Exception
    //   39	52	58	java/lang/OutOfMemoryError
  }
  
  private void a(Message paramMessage)
  {
    paramMessage = (Object[])paramMessage.obj;
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    int i = paramMessage.length;
    boolean bool = true;
    if (i == 3)
    {
      this.jdField_a_of_type_JavaUtilMap = ((Map)paramMessage[0]);
      this.jdField_a_of_type_ArrayOfInt = ((int[])paramMessage[1]);
      this.jdField_a_of_type_ArrayOfJavaLangString = ((String[])paramMessage[2]);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      if (((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity))
      {
        ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).handleGameClockData(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        paramMessage = ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).getQQGameTroopManager_TASK_NAME_MEMBER_StringValue();
        ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).sortAndPreloadIfNeed(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramMessage);
      }
    }
    else
    {
      this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
      this.jdField_a_of_type_ArrayOfInt = new int[0];
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter.notifyDataSetChanged();
    paramMessage = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity;
    if (this.jdField_b_of_type_Int != 2) {
      bool = false;
    }
    paramMessage.refreshGVideoTextView(bool, this.jdField_c_of_type_Int);
  }
  
  private void a(String paramString)
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
        this.jdField_b_of_type_Boolean = true;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("get troop members from server, troopUin: ");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(" troopCode: ");
          ((StringBuilder)localObject2).append((String)localObject1);
          QLog.d("TroopMemberListInnerFrame", 2, ((StringBuilder)localObject2).toString());
        }
        Object localObject2 = ((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopMemberListHandlerName();
        localObject2 = (ITroopMemberListHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler((String)localObject2);
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        ((ITroopMemberListHandler)localObject2).a(true, paramString, (String)localObject1, true, 7, this.jdField_a_of_type_Long, ((ISelectMemberRefatorHelperApi)QRoute.api(ISelectMemberRefatorHelperApi.class)).getSCENE_TYPE_DEFAULT_Value());
      }
    }
  }
  
  private void a(String paramString, List<TroopMemberInfo> paramList)
  {
    if (paramList == null) {}
    try
    {
      localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getEntityManagerFactory().createEntityManager();
      paramList = ((EntityManager)localObject).query(TroopMemberInfo.class, false, "troopuin=? ", new String[] { paramString }, null, null, null, null);
      ((EntityManager)localObject).close();
      if (!QLog.isColorLevel()) {
        break label453;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTroopMemberFromDB, troopMemberInfoList==null, queryDB, troopUin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",");
      if (paramList == null) {
        i = 0;
      } else {
        i = paramList.size();
      }
      ((StringBuilder)localObject).append(i);
      QLog.d("TroopMemberListInnerFrame.thread", 2, ((StringBuilder)localObject).toString());
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        Map localMap;
        TroopInfo localTroopInfo;
        String str;
        int j;
        int k;
        StringBuilder localStringBuilder;
        for (;;)
        {
          throw paramString;
        }
        continue;
        continue;
        int i = 1;
        continue;
        i = 0;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTroopMemberFromDB, troopuin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",");
      if (paramList == null) {
        i = 0;
      } else {
        i = paramList.size();
      }
      ((StringBuilder)localObject).append(i);
      QLog.d("TroopMemberListInnerFrame.thread", 2, ((StringBuilder)localObject).toString());
      break label456;
      localMap = Collections.synchronizedMap(new LinkedHashMap());
      localTroopInfo = CommonUtils.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_JavaLangString);
      str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
      if (paramList == null)
      {
        paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
        this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
        return;
      }
      j = paramList.size();
      this.jdField_a_of_type_Int = (j - 1);
      if (j > 0)
      {
        k = j / jdField_d_of_type_Int;
        if (j % jdField_d_of_type_Int != 0) {
          break label459;
        }
        i = 0;
        localObject = new AtomicInteger(k + i);
        if (!QLog.isColorLevel()) {
          break label464;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("parallel process mJobCount: ");
        localStringBuilder.append(((AtomicInteger)localObject).get());
        QLog.d("TroopMemberListInnerFrame.thread", 2, localStringBuilder.toString());
        break label464;
        while (i < j)
        {
          ThreadManager.post(new TroopMemberListInnerFrame.5(this, paramList, i, Math.min(jdField_d_of_type_Int + i - 1, j), paramString, str, localTroopInfo, localMap, (AtomicInteger)localObject), 8, null, false);
          i += jdField_d_of_type_Int;
        }
      }
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(3);
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      return;
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if ((localRelativeLayout != null) && (localRelativeLayout.getVisibility() == 0))
    {
      boolean bool = false;
      if ((paramString != null) && (!paramBoolean) && (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()))
      {
        paramBoolean = bool;
      }
      else
      {
        int j = this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter.getCount();
        int i = 0;
        while (i < j)
        {
          paramString = (TroopMemberInfo)this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter.getItem(i);
          if ((paramString != null) && (!this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.isResultListContainFriend(paramString.memberuin)))
          {
            paramBoolean = bool;
            break label108;
          }
          i += 1;
        }
        paramBoolean = true;
      }
      label108:
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(paramBoolean);
    }
  }
  
  private Object[] a()
  {
    Object localObject1 = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      Collections.sort((List)this.jdField_a_of_type_JavaUtilMap.get(localObject2), new TroopMemberListInnerFrame.MyComparator(this, null));
    }
    localObject1 = this.jdField_a_of_type_JavaUtilMap;
    this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
    if ((this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mShowMyself) && (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mIsPutMySelfFirst) && (this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo != null))
    {
      localObject2 = new ArrayList(1);
      ((ArrayList)localObject2).add(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopMemberInfo);
      this.jdField_a_of_type_JavaUtilMap.put(HardCodeUtil.a(2131715372), localObject2);
    }
    for (char c1 = 'A'; c1 <= 'Z'; c1 = (char)(c1 + '\001')) {
      if (((Map)localObject1).get(String.valueOf(c1)) != null) {
        this.jdField_a_of_type_JavaUtilMap.put(String.valueOf(c1), ((Map)localObject1).get(String.valueOf(c1)));
      }
    }
    if (((Map)localObject1).get("#") != null) {
      this.jdField_a_of_type_JavaUtilMap.put("#", ((Map)localObject1).get("#"));
    }
    ((Map)localObject1).clear();
    localObject1 = new int[this.jdField_a_of_type_JavaUtilMap.keySet().size()];
    Object localObject2 = new String[this.jdField_a_of_type_JavaUtilMap.keySet().size()];
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    if (localObject1.length == 0) {
      return new Object[0];
    }
    localObject1[0] = 0;
    int i = 1;
    while (i < localObject1.length)
    {
      localObject1[i] += localObject1[(i - 1)] + ((List)this.jdField_a_of_type_JavaUtilMap.get(localIterator.next())).size() + 1;
      i += 1;
    }
    localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    i = 0;
    while (localIterator.hasNext())
    {
      localObject2[i] = ((String)localIterator.next());
      i += 1;
    }
    return new Object[] { this.jdField_a_of_type_JavaUtilMap, localObject1, localObject2 };
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView = ((PinnedDividerListView)findViewById(2131364470));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView = ((IndexView)findViewById(2131368761));
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setIndex(new String[] { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" });
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setOnIndexChangedListener(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelector(2131167333);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnLayoutListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379786));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131376735));
    Object localObject1 = (LinearLayout)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131370305);
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)findViewById(2131364377));
    ((LinearLayout)localObject1).setOnClickListener(this);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131379284));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)findViewById(2131368260));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131370395));
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mEntrance == 21)
    {
      localObject1 = (ViewGroup)this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getWindow().getDecorView();
      this.jdField_b_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity);
      Object localObject2 = new LinearLayout.LayoutParams(-2, (int)DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, 17.0F));
      this.jdField_b_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      int i = (int)DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, 4.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167116));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
      this.jdField_b_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715325));
      localObject2 = TroopRankConfig.a().a(301, false, false, true);
      if (localObject2 != null) {
        TroopRankConfig.a(this.jdField_b_of_type_AndroidWidgetTextView, ((TroopRankConfig.TroopRankItem)localObject2).jdField_b_of_type_Int);
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(4);
      ((ViewGroup)localObject1).addView(this.jdField_b_of_type_AndroidWidgetTextView);
      this.jdField_c_of_type_AndroidWidgetTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity);
      localObject2 = new LinearLayout.LayoutParams(-2, (int)DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, 17.0F));
      this.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      this.jdField_c_of_type_AndroidWidgetTextView.setPadding(i, 0, i, 0);
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(getResources().getColor(2131167116));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextSize(1, 12.0F);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131715369));
      localObject2 = TroopRankConfig.a().a(300, false, true, false);
      if (localObject2 != null) {
        TroopRankConfig.a(this.jdField_c_of_type_AndroidWidgetTextView, ((TroopRankConfig.TroopRankItem)localObject2).jdField_b_of_type_Int);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(4);
      ((ViewGroup)localObject1).addView(this.jdField_c_of_type_AndroidWidgetTextView);
      this.jdField_b_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(new TroopMemberListInnerFrame.2(this, (ViewGroup)localObject1));
      this.jdField_c_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(new TroopMemberListInnerFrame.3(this, (ViewGroup)localObject1));
    }
  }
  
  private void h()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("last_update_time");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
    localObject = ((SelectMemberActivity)localObject).getSharedPreferences(localStringBuilder.toString(), 4);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_last_update_time");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    long l1 = ((SharedPreferences)localObject).getLong(localStringBuilder.toString(), 0L);
    long l2 = System.currentTimeMillis();
    long l3 = Math.abs(l2 - l1);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getTroopMembers, lastUpdateTime=");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(", curTime=");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append(", diff=");
      ((StringBuilder)localObject).append(l3);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(hashCode());
      QLog.d("TroopMemberListInnerFrame", 2, ((StringBuilder)localObject).toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = CommonUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mEntrance != 21)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
      if (localObject != null)
      {
        this.jdField_a_of_type_Int = (((TroopInfo)localObject).wMemberNum - 1);
        if (this.jdField_a_of_type_Int > 0)
        {
          this.jdField_a_of_type_Double = 0.0D;
          localObject = this.jdField_a_of_type_AndroidOsHandler;
          ((Handler)localObject).sendMessage(((Handler)localObject).obtainMessage(4));
        }
      }
    }
    if ((l1 != 0L) && ((l1 <= 0L) || (l3 <= 300000L)))
    {
      ThreadManager.executeOnNetWorkThread(new TroopMemberListInnerFrame.4(this));
      return;
    }
    a(this.jdField_b_of_type_JavaLangString);
  }
  
  public CharDividedFacePreloadBaseAdapter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter;
  }
  
  public ContactSearchFragment a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mEntrance != 21) {
      return ContactSearchFragment.a(-1, 8192, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsToHide, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity);
    }
    return ContactSearchFragment.a(-1, 262144, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mUinsToHide, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity);
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  protected Map<String, List<TroopMemberInfo>> a()
  {
    return this.jdField_a_of_type_JavaUtilMap;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    setContentView(2131562810);
    g();
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter = new TroopMemberListInnerFrame.TroopMemberListAdapter(this);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() > 0) || ((this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getFirstVisiblePosition() == 0) && (this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getChildCount() < this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter.getCount() + this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.getHeaderViewsCount()))) && (!this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.isSoftInputShowing()) && (!((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity)))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetIndexView.setVisibility(4);
  }
  
  protected void a(Map<String, List<TroopMemberInfo>> paramMap, int[] paramArrayOfInt, String[] paramArrayOfString)
  {
    this.jdField_a_of_type_JavaUtilMap = paramMap;
    this.jdField_a_of_type_ArrayOfInt = paramArrayOfInt;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mSelectedAndSearchBar.b();
    this.jdField_b_of_type_JavaLangString = paramBundle.getString("group_uin");
    this.jdField_c_of_type_JavaLangString = paramBundle.getString("group_name");
    this.jdField_b_of_type_Int = paramBundle.getInt("param_member_show_type", 1);
    boolean bool = paramBundle.getBoolean("param_enable_all_select", false);
    paramBundle = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    int i;
    if (bool) {
      i = 0;
    } else {
      i = 8;
    }
    paramBundle.setVisibility(i);
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
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.setupTitleBar(true, "", this.jdField_c_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinememberApiTroopOnlineMemberObserver);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    paramBundle = this.jdField_b_of_type_JavaLangString;
    if ((paramBundle != null) && (paramBundle.length() > 0)) {
      if (!this.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap());
        this.jdField_a_of_type_ArrayOfInt = new int[0];
        this.jdField_a_of_type_ArrayOfJavaLangString = new String[0];
        this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter.notifyDataSetChanged();
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_c_of_type_Boolean = false;
        h();
        this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
        this.jdField_a_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
        if (((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity))
        {
          ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).initTaskSet(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
          ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).doReqGameFriends(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity);
          paramBundle = ((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopOnlineMemberHandlerName();
          ((ITroopOnlineMemberHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(paramBundle)).b(this.jdField_b_of_type_JavaLangString);
        }
      }
      else
      {
        this.jdField_c_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter.notifyDataSetChanged();
      }
    }
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopOnlinememberApiTroopOnlineMemberObserver);
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter;
    if (localObject != null) {
      ((TroopMemberListInnerFrame.TroopMemberListAdapter)localObject).c();
    }
    localObject = this.jdField_b_of_type_AndroidWidgetTextView;
    if ((localObject != null) && (((TextView)localObject).getTag() != null))
    {
      ((Bitmap)this.jdField_b_of_type_AndroidWidgetTextView.getTag()).recycle();
      this.jdField_b_of_type_AndroidWidgetTextView.setTag(null);
    }
    localObject = this.jdField_c_of_type_AndroidWidgetTextView;
    if ((localObject != null) && (((TextView)localObject).getTag() != null))
    {
      ((Bitmap)this.jdField_c_of_type_AndroidWidgetTextView.getTag()).recycle();
      this.jdField_c_of_type_AndroidWidgetTextView.setTag(null);
    }
    if (((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity)) {
      ((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).onDestroyForQQGameTroopManager(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    super.d();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter.notifyDataSetChanged();
    a(null, false);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (2131364377 == paramCompoundButton.getId())
    {
      if (paramBoolean)
      {
        ArrayList localArrayList = new ArrayList();
        int j = this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter.getCount();
        int i = 0;
        while (i < j)
        {
          TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter.getItem(i);
          if (localTroopMemberInfo != null)
          {
            String str = ((ITroopMemberNameService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberName(localTroopMemberInfo);
            SelectMemberActivity localSelectMemberActivity = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity;
            localArrayList.add(SelectMemberActivity.constructAResultRecord(localTroopMemberInfo.memberuin, str, 1, this.jdField_b_of_type_JavaLangString));
          }
          if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mEntrance == 31) {
            ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X8007CFB", "0X8007CFB", 0, 0, "", "", "", "");
          }
          i += 1;
        }
        this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.addFriendResults(localArrayList, false, true);
        if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mEntrance == 35) {
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8009E2C", "0X8009E2C", 0, 0, "", "", "", "");
        }
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.removeAllFriendResult();
        if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mEntrance == 35) {
          ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8009E2D", "0X8009E2D", 0, 0, "", "", "", "");
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter.notifyDataSetChanged();
    }
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
  
  public void onClick(View paramView)
  {
    Object localObject2;
    if (2131370305 != paramView.getId())
    {
      localObject1 = (TroopMemberListInnerFrame.ViewHolder)paramView.getTag();
      if ((localObject1 != null) && (((TroopMemberListInnerFrame.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox != null) && (((TroopMemberListInnerFrame.ViewHolder)localObject1).jdField_d_of_type_AndroidWidgetTextView != null) && (((TroopMemberListInnerFrame.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.isEnabled()))
      {
        boolean bool = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.onListViewItemClick(((TroopMemberListInnerFrame.ViewHolder)localObject1).jdField_a_of_type_JavaLangString, ((TroopMemberListInnerFrame.ViewHolder)localObject1).jdField_d_of_type_AndroidWidgetTextView.getText().toString(), 1, this.jdField_b_of_type_JavaLangString);
        ((TroopMemberListInnerFrame.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.setChecked(bool);
        a(((TroopMemberListInnerFrame.ViewHolder)localObject1).jdField_a_of_type_JavaLangString, bool);
        if (AppSetting.d)
        {
          if (((TroopMemberListInnerFrame.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.isChecked())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(((TroopMemberListInnerFrame.ViewHolder)localObject1).jdField_d_of_type_AndroidWidgetTextView.getText().toString());
            ((StringBuilder)localObject2).append(HardCodeUtil.a(2131715401));
            paramView.setContentDescription(((StringBuilder)localObject2).toString());
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(((TroopMemberListInnerFrame.ViewHolder)localObject1).jdField_d_of_type_AndroidWidgetTextView.getText().toString());
            ((StringBuilder)localObject2).append(HardCodeUtil.a(2131715385));
            paramView.setContentDescription(((StringBuilder)localObject2).toString());
          }
          int i;
          if (((TroopMemberListInnerFrame.ViewHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
            i = 2131715367;
          } else {
            i = 2131715352;
          }
          AccessibilityUtils.a(paramView, HardCodeUtil.a(i));
        }
      }
    }
    else if (((this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mEntrance == 32) || (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mEntrance == 43)) && (!this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) && (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mMaxSelectNumber < this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter.b()))
    {
      localObject1 = new TroopMemberListInnerFrame.6(this);
      localObject2 = MessageFormat.format(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131718717), new Object[] { Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mMaxSelectNumber) });
      localObject1 = DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, 232, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getResources().getString(2131719632), (String)localObject2, 2131690728, 2131698946, (DialogInterface.OnClickListener)localObject1, (DialogInterface.OnClickListener)localObject1);
    }
    try
    {
      ((Dialog)localObject1).show();
    }
    catch (Throwable localThrowable)
    {
      break label482;
    }
    Object localObject1 = this.jdField_a_of_type_AndroidWidgetCheckBox;
    ((CheckBox)localObject1).setChecked(true ^ ((CheckBox)localObject1).isChecked());
    localObject1 = this.jdField_a_of_type_AndroidWidgetCheckBox;
    onCheckedChanged((CompoundButton)localObject1, ((CheckBox)localObject1).isChecked());
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mEntrance == 32)
    {
      localObject2 = (IQWalletApi)QRoute.api(IQWalletApi.class);
      if (this.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) {
        localObject1 = "friendsfinder.all.confirm";
      } else {
        localObject1 = "friendsfinder.all.cancel";
      }
      ((IQWalletApi)localObject2).reportTenpay(0, (String)localObject1);
    }
    label482:
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onIndexChanged(String paramString)
  {
    if (((ITroopUtilApi)QRoute.api(ITroopUtilApi.class)).isGameClockBusiness(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity)) {
      return;
    }
    if ("$".equals(paramString))
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView.setSelection(0);
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopMemberListInnerFrame$TroopMemberListAdapter.a(paramString);
    if (i != -1)
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqWidgetPinnedDividerListView;
      paramString.setSelection(i + paramString.getHeaderViewsCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopMemberListInnerFrame
 * JD-Core Version:    0.7.0.1
 */