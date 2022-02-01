package com.tencent.mobileqq.kandian.biz.tab;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.annotation.UiThread;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.RIJThreadHandler;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.fragment.ReadInJoyBaseFragment;
import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJChannelStayTimeMonitor;
import com.tencent.mobileqq.kandian.biz.feeds.api.IReadInJoyBaseFragmentEntryPath;
import com.tencent.mobileqq.kandian.biz.feeds.channelbanner.RIJChannelReporter;
import com.tencent.mobileqq.kandian.biz.feeds.channelcover.ChannelCoverView;
import com.tencent.mobileqq.kandian.biz.framework.CallHotwordChange;
import com.tencent.mobileqq.kandian.biz.framework.util.RIJChannelViewpagerEnterPathHelper;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianSubscribeManager;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianSubscribeManager.KandianSubscribeMessageObserver;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.mobileqq.kandian.glue.report.dt.RIJDtParamBuilder;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.ChannelModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.db.struct.ChannelSection;
import com.tencent.mobileqq.kandian.repo.feeds.RIJChannelHelper;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.channelcover.RIJMainChannelUtil;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo.RedPoint;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ReportPolicy;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONException;

public class ReadInJoyChannelViewPagerController
  implements KandianSubscribeManager.KandianSubscribeMessageObserver
{
  public static int a = 3;
  public static TabChannelCoverInfo a;
  private static HashMap<Integer, Boolean> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public static boolean a = false;
  private static final int jdField_b_of_type_Int = ViewUtils.b(0.0F);
  private static boolean jdField_b_of_type_Boolean = true;
  private static final int jdField_c_of_type_Int = ViewUtils.b(0.0F);
  private float jdField_a_of_type_Float = 0.4F;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private FragmentManager jdField_a_of_type_AndroidxFragmentAppFragmentManager;
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener = new ReadInJoyChannelViewPagerController.9(this);
  private TabLayout jdField_a_of_type_ComTencentBizWidgetsTabLayout;
  CallHotwordChange jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkCallHotwordChange;
  private ReadInJoyChannelViewPager.CustomFragmentPagerAdapter jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager$CustomFragmentPagerAdapter;
  private ReadInJoyChannelViewPager jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager;
  private ReadInJoyChannelViewPagerController.OnChannelChangeListener jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPagerController$OnChannelChangeListener;
  private ReadInJoyChannelViewPagerController.OnDataChangeListener jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPagerController$OnDataChangeListener;
  private ReadInJoyTabAdapter jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyTabAdapter;
  private ReadInJoyLogicEngine jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine;
  private ReadInJoyObserver jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver = new ReadInJoyChannelViewPagerController.4(this);
  private HorizontalListView.OnScrollStateChangedListener jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener;
  private List<TabChannelCoverInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<Integer, BaseReportData> jdField_a_of_type_JavaUtilMap = new HashMap();
  private float jdField_b_of_type_Float = 1.0F;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private List<TabChannelCoverInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean = false;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e = 1;
  private int f = 1;
  
  public ReadInJoyChannelViewPagerController(Context paramContext, View paramView, ReadInJoyChannelViewPager paramReadInJoyChannelViewPager)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager = paramReadInJoyChannelViewPager;
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout = ((TabLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131378247));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369420));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369479));
    this.jdField_a_of_type_AndroidViewView = ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView();
    p();
    g();
  }
  
  private TabChannelCoverInfo a(int paramInt)
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)localIterator.next();
      if (localTabChannelCoverInfo.mChannelCoverId == paramInt) {
        return localTabChannelCoverInfo;
      }
    }
    return null;
  }
  
  private List<TabChannelCoverInfo> a(List<TabChannelCoverInfo> paramList)
  {
    Object localObject = new ArrayList(paramList);
    paramList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)((Iterator)localObject).next();
      if (localTabChannelCoverInfo != null) {
        paramList.add(localTabChannelCoverInfo.clone());
      }
    }
    return paramList;
  }
  
  private void a(int paramInt1, float paramFloat, int paramInt2)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout;
    paramInt2 = 1;
    if (localObject1 == null)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 1, "mChannelTabLayout null");
      return;
    }
    int k = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager.getCurrentItem();
    if (k >= this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("currentPosition larger than tablayout childsize, currentPosition ");
      ((StringBuilder)localObject1).append(k);
      ((StringBuilder)localObject1).append(" childsize: ");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a());
      QLog.d("ReadInJoyChannelViewPagerController", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(k);
    localObject1 = null;
    Object localObject3 = null;
    Object localObject2 = null;
    View localView;
    if (localViewGroup != null) {
      localView = localViewGroup.findViewById(2131369098);
    } else {
      localView = null;
    }
    int m = k - 1;
    int j = 0;
    int i = 0;
    float f2;
    float f1;
    if (paramInt1 == m)
    {
      f2 = (1.0F - paramFloat) * this.jdField_b_of_type_Float;
      f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      paramInt1 = jdField_b_of_type_Int;
      if ((m >= 0) && (m < this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a()))
      {
        localObject1 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(m);
        paramInt1 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(m);
        paramInt1 = (int)(jdField_b_of_type_Int - paramInt1 * f1);
        ThreadManager.getUIHandler().post(new ReadInJoyChannelViewPagerController.5(this, paramFloat, k, localViewGroup, (View)localObject1));
      }
      else
      {
        QLog.d("ReadInJoyChannelViewPagerController", 1, "targetTabView null");
      }
    }
    else
    {
      if (paramInt1 == k)
      {
        f2 = this.jdField_b_of_type_Float * paramFloat;
        f1 = f2;
        if (f2 > 1.0F) {
          f1 = 1.0F;
        }
        paramInt1 = jdField_c_of_type_Int;
        i = k + 1;
        if ((i >= 0) && (i < this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a()))
        {
          localObject1 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(i);
          paramInt1 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(i);
          paramInt1 = (int)(jdField_c_of_type_Int - paramInt1 * f1);
          ThreadManager.getUIHandler().post(new ReadInJoyChannelViewPagerController.6(this, paramFloat, i, (View)localObject1, localViewGroup, k));
          break label516;
        }
        QLog.d("ReadInJoyChannelViewPagerController", 1, "targetTabView null");
        localObject1 = localObject3;
        break label516;
      }
      k += 1;
      if (paramInt1 == k)
      {
        paramInt1 = i;
        localObject1 = localObject2;
        if (k >= 0)
        {
          paramInt1 = i;
          localObject1 = localObject2;
          if (k < this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a())
          {
            localObject1 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(k);
            paramInt1 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(k);
            paramInt1 = jdField_c_of_type_Int - paramInt1;
          }
        }
        ThreadManager.getUIHandler().post(new ReadInJoyChannelViewPagerController.7(this, k, (View)localObject1, localViewGroup));
        break label516;
      }
      QLog.d("ReadInJoyChannelViewPagerController", 1, "targetTabView null");
      paramInt1 = j;
    }
    paramInt2 = 0;
    label516:
    a(localView, paramInt1, paramInt2);
    ThreadManager.getUIHandler().post(new ReadInJoyChannelViewPagerController.8(this, (View)localObject1, localView));
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView == null)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 1, "line null");
      return;
    }
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)paramView.getLayoutParams();
    if (paramInt2 == 0)
    {
      localMarginLayoutParams.leftMargin = paramInt1;
      localMarginLayoutParams.rightMargin = jdField_c_of_type_Int;
    }
    else
    {
      localMarginLayoutParams.rightMargin = paramInt1;
      localMarginLayoutParams.leftMargin = jdField_b_of_type_Int;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("changeChannelLineMargin: left ");
    localStringBuilder.append(localMarginLayoutParams.leftMargin);
    localStringBuilder.append(" right: ");
    localStringBuilder.append(localMarginLayoutParams.rightMargin);
    QLog.d("ReadInJoyChannelViewPagerController", 1, localStringBuilder.toString());
    paramView.setLayoutParams(localMarginLayoutParams);
  }
  
  private void a(View paramView1, View paramView2)
  {
    if ((paramView1 != null) && (paramView2 != null))
    {
      paramView1 = (TextView)paramView1.findViewById(2131379930);
      paramView2 = (TextView)paramView2.findViewById(2131379930);
      a(paramView1);
      b(paramView2);
      return;
    }
    QLog.d("ReadInJoyChannelViewPagerController", 1, "tvSelectTab or tvUnselectTab null");
  }
  
  private void a(TextView paramTextView)
  {
    paramTextView.setTextColor(paramTextView.getResources().getColor(2131166935));
    paramTextView.setTypeface(Typeface.defaultFromStyle(1));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "actionName = ", paramString1, "\n", "r2 = ", paramString2, ", r5 = ", paramString3 });
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", paramString1, paramString1, 0, 0, paramString2, "", "", paramString3, false);
  }
  
  private void a(List<TabChannelCoverInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      jdField_a_of_type_Int = e();
      List localList = a(paramList);
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(localList);
      this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a();
      if (this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPagerController$OnDataChangeListener != null)
      {
        paramList = a(paramList);
        this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPagerController$OnDataChangeListener.a(paramList);
      }
      ThreadManager.executeOnSubThread(new ReadInJoyChannelViewPagerController.2(this));
      l();
      m();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a(localList);
      paramList = jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTabChannelCoverInfo;
      if ((paramList != null) && (a(paramList.mChannelCoverId) != null)) {
        c(jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTabChannelCoverInfo.mChannelCoverId);
      } else {
        b();
      }
      paramList = new StringBuilder();
      paramList.append("setAdapterData: ");
      paramList.append(localList);
      QLog.d("ReadInJoyChannelViewPagerController", 1, paramList.toString());
      return;
    }
    QLog.d("ReadInJoyChannelViewPagerController", 2, "channel list size is 0");
  }
  
  private void a(Map<Integer, BaseReportData> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = paramMap.values().iterator();
      while (paramMap.hasNext())
      {
        BaseReportData localBaseReportData = (BaseReportData)paramMap.next();
        TabChannelCoverInfo localTabChannelCoverInfo = localBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTabChannelCoverInfo;
        int j = ChannelCoverView.jdField_b_of_type_Int;
        int i;
        if ((localBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTabChannelCoverInfo != null) && (localBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTabChannelCoverInfo.redPoint != null) && (localBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean)) {
          i = localBaseReportData.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTabChannelCoverInfo.redPoint.jdField_a_of_type_Int + 1;
        } else {
          i = 0;
        }
        ChannelCoverView.a("0X8009495", localTabChannelCoverInfo, j, i, localBaseReportData.l);
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    boolean bool2 = false;
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "isNeedRefreshChannel, channelID = ", Integer.valueOf(paramInt) });
    boolean bool1 = bool2;
    if (paramInt != -1)
    {
      bool1 = bool2;
      if ((Boolean)jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt)) != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean a(List<TabChannelCoverInfo> paramList)
  {
    paramList = b(paramList);
    int i = paramList.size();
    int j = this.jdField_a_of_type_JavaUtilList.size();
    boolean bool = true;
    if (i == j)
    {
      i = 0;
      while (i < paramList.size())
      {
        if (((TabChannelCoverInfo)paramList.get(i)).mChannelCoverId != ((TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(i)).mChannelCoverId) {
          return true;
        }
        i += 1;
      }
      bool = false;
    }
    return bool;
  }
  
  private List<TabChannelCoverInfo> b(List<TabChannelCoverInfo> paramList)
  {
    int k = paramList.size();
    List localList = a(this.jdField_a_of_type_JavaUtilList);
    Iterator localIterator = localList.iterator();
    int i;
    label105:
    for (;;)
    {
      boolean bool = localIterator.hasNext();
      i = 0;
      j = 0;
      if (!bool) {
        break;
      }
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)localIterator.next();
      i = j;
      for (;;)
      {
        if (i >= paramList.size()) {
          break label105;
        }
        if (localTabChannelCoverInfo.mChannelCoverId == ((TabChannelCoverInfo)paramList.get(i)).mChannelCoverId)
        {
          localIterator.remove();
          break;
        }
        i += 1;
      }
    }
    int j = 0;
    while (i <= k - 1)
    {
      localList.add(jdField_a_of_type_Int + j, paramList.get(i));
      j += 1;
      i += 1;
    }
    return localList;
  }
  
  private void b(TextView paramTextView)
  {
    paramTextView.setTextColor(paramTextView.getResources().getColor(2131166936));
    paramTextView.setTypeface(Typeface.defaultFromStyle(0));
  }
  
  private void b(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo == null) {
      return;
    }
    KandianSubscribeManager localKandianSubscribeManager = (KandianSubscribeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_SUBSCRIBE_MANAGER);
    TabChannelCoverInfo.RedPoint localRedPoint = new TabChannelCoverInfo.RedPoint();
    localRedPoint.jdField_a_of_type_Long = 0L;
    localRedPoint.b = 9223372036854775807L;
    localRedPoint.jdField_a_of_type_Boolean = localKandianSubscribeManager.a();
    paramTabChannelCoverInfo.redPoint = localRedPoint;
    a(paramTabChannelCoverInfo);
  }
  
  private void b(List<TabChannelCoverInfo> paramList)
  {
    List localList = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine.a();
    if ((localList != null) && (localList.size() > 0))
    {
      ((ChannelSection)localList.get(0)).jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine.a(localList, 1, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "updateMyChannelData channelCoverSectionList is null");
    }
  }
  
  public static boolean b()
  {
    return jdField_b_of_type_Boolean;
  }
  
  private void c(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo == null) {
      return;
    }
    if (this.jdField_b_of_type_JavaUtilList.size() > 0)
    {
      int i = 0;
      while (i < this.jdField_b_of_type_JavaUtilList.size())
      {
        if (paramTabChannelCoverInfo.mChannelCoverId == ((TabChannelCoverInfo)this.jdField_b_of_type_JavaUtilList.get(i)).mChannelCoverId)
        {
          this.jdField_b_of_type_JavaUtilList.remove(i);
          break;
        }
        i += 1;
      }
    }
    if (paramTabChannelCoverInfo.reason != 4) {
      this.jdField_b_of_type_JavaUtilList.add(0, paramTabChannelCoverInfo);
    }
  }
  
  public static void d(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "refreshChannel, channelID = ", Integer.valueOf(paramInt) });
    if (paramInt != -1) {
      jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), Boolean.valueOf(true));
    }
  }
  
  private int e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine.b();
    int i = 0;
    int j = 0;
    if ((localObject != null) && (((List)localObject).size() != 0))
    {
      int k;
      for (i = 0; j < ((List)localObject).size(); i = k)
      {
        TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)((List)localObject).get(j);
        k = i;
        if (localTabChannelCoverInfo != null)
        {
          if (localTabChannelCoverInfo.reason != 4) {
            break;
          }
          k = i + 1;
        }
        j += 1;
      }
    }
    else
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "No channel Cache info.");
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getChannelLockCount lockCount：");
      ((StringBuilder)localObject).append(i);
      QLog.d("ReadInJoyChannelViewPagerController", 2, ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  private void e(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
        return;
      }
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((localTabChannelCoverInfo != null) && (localTabChannelCoverInfo.redPoint != null) && (localTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean))
      {
        localTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean = false;
        a(localTabChannelCoverInfo);
      }
    }
  }
  
  private void f(int paramInt)
  {
    Object localObject = (TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    boolean bool;
    if (((((TabChannelCoverInfo)localObject).redPoint != null) && (((TabChannelCoverInfo)localObject).redPoint.jdField_a_of_type_Boolean)) || (((IRIJChannelStayTimeMonitor)QRoute.api(IRIJChannelStayTimeMonitor.class)).isLastExitChannelOverTimeLimit(((TabChannelCoverInfo)localObject).mChannelCoverId))) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "checkBackToTopAndRefresh, position = ", Integer.valueOf(paramInt), ", channelID = ", Integer.valueOf(((TabChannelCoverInfo)localObject).mChannelCoverId), ", isNeedRefresh = ", Boolean.valueOf(bool) });
    if (bool)
    {
      QBaseFragment localQBaseFragment = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a(paramInt);
      if ((localQBaseFragment instanceof ReadInJoyBaseFragment))
      {
        localObject = (ReadInJoyBaseFragment)localQBaseFragment;
        QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "isShowingSelf = ", Boolean.valueOf(((ReadInJoyBaseFragment)localObject).b()) });
        ((ReadInJoyBaseFragment)localObject).a(3);
        return;
      }
      d(((TabChannelCoverInfo)localObject).mChannelCoverId);
    }
  }
  
  private void g()
  {
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    if ((localContext instanceof BaseActivity)) {
      this.jdField_a_of_type_AndroidxFragmentAppFragmentManager = ((BaseActivity)localContext).getSupportFragmentManager();
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyTabAdapter = new ReadInJoyTabAdapter(this.jdField_b_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizWidgetsTabLayout, this);
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyTabAdapter.a(this.jdField_a_of_type_JavaUtilMap);
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyTabAdapter);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager$CustomFragmentPagerAdapter = ((ReadInJoyChannelViewPager.CustomFragmentPagerAdapter)this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager.getAdapter());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager.addOnPageChangeListener(this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener);
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    i();
    b();
    k();
    jdField_a_of_type_Int = e();
    ((IRIJChannelStayTimeMonitor)QRoute.api(IRIJChannelStayTimeMonitor.class)).startMonitor();
    h();
  }
  
  private void h()
  {
    VideoReport.setElementId(this.jdField_a_of_type_AndroidWidgetImageView, "more_channel_button");
    VideoReport.setElementParams(this.jdField_a_of_type_AndroidWidgetImageView, new RIJDtParamBuilder().a("14").c("click_more_channel").b("channel_bar").a().a());
    VideoReport.setElementReportPolicy(this.jdField_a_of_type_AndroidWidgetImageView, ReportPolicy.REPORT_POLICY_CLICK);
  }
  
  private void i()
  {
    Object localObject = (ReadInJoyLogicManager)ReadInJoyUtils.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if (localObject != null)
    {
      localObject = ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine();
      if (localObject != null)
      {
        List localList = ((ReadInJoyLogicEngine)localObject).b();
        if ((localList != null) && (localList.size() != 0))
        {
          a(localList);
        }
        else
        {
          ((ReadInJoyLogicEngine)localObject).m();
          QLog.d("ReadInJoyChannelViewPagerController", 1, "No channel Cache info.");
        }
      }
    }
    j();
  }
  
  private void j()
  {
    if (ChannelModeConfigHandler.a())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849703);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843046);
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ReadInJoyChannelViewPagerController.1(this));
  }
  
  private void l()
  {
    TabChannelCoverInfo localTabChannelCoverInfo = a(0);
    if (localTabChannelCoverInfo == null) {
      return;
    }
    if ((localTabChannelCoverInfo.redPoint != null) && (localTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean))
    {
      localTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean = false;
      a(localTabChannelCoverInfo);
    }
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a();
    n();
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.setOverScrollMode(2);
    int j = c();
    if (this.f == j)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("mLastCenterPosition = ");
      localStringBuilder.append(this.f);
      localStringBuilder.append(", no need to move again.");
      QLog.i("ReadInJoyChannelViewPagerController", 1, localStringBuilder.toString());
      return;
    }
    this.f = j;
    int i = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(j);
    int k = (int)(DeviceInfoUtil.m() - i) / 2 - ViewUtils.a(12.0F);
    i = 200;
    if ((j < this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.getFirstVisiblePosition()) || (j > this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.getLastVisiblePosition())) {
      i = 0;
    }
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "smoothScrollToPosition, position = ", Integer.valueOf(j), ", offset = ", Integer.valueOf(k) });
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.smoothScrollToPositionFromLeftOrRight(j, -k, i);
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener == null) {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener = new ReadInJoyChannelViewPagerController.11(this);
    }
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.setOnScrollStateChangedListener(this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener);
  }
  
  private void o()
  {
    if (!jdField_b_of_type_Boolean)
    {
      KandianMergeManager localKandianMergeManager = (KandianMergeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      if (localKandianMergeManager != null)
      {
        localKandianMergeManager.r();
        QLog.d("ReadInJoyChannelViewPagerController", 1, "clearKandianRedPoint");
      }
    }
  }
  
  private void p()
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine = ((ReadInJoyLogicManager)ReadInJoyUtils.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine();
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public QBaseFragment a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a();
  }
  
  public TabChannelCoverInfo a()
  {
    int i = c();
    if ((i >= 0) && (i < this.jdField_a_of_type_JavaUtilList.size())) {
      return (TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(i);
    }
    return null;
  }
  
  public void a()
  {
    QLog.i("ReadInJoyChannelViewPagerController", 1, "[onReceiveKandianSubscribeMessage] ");
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      if (((List)localObject).isEmpty()) {
        return;
      }
      localObject = a(70);
      if (localObject != null)
      {
        TabChannelCoverInfo.RedPoint localRedPoint = new TabChannelCoverInfo.RedPoint();
        localRedPoint.jdField_a_of_type_Boolean = true;
        localRedPoint.jdField_a_of_type_Long = 0L;
        localRedPoint.b = 9223372036854775807L;
        ((TabChannelCoverInfo)localObject).redPoint = localRedPoint;
        a((TabChannelCoverInfo)localObject);
        this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a();
      }
    }
  }
  
  public void a(int paramInt)
  {
    int j = 1;
    Object localObject;
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      localObject = (TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((localObject != null) && (RIJChannelViewpagerEnterPathHelper.a().get(Integer.valueOf(((TabChannelCoverInfo)localObject).mChannelCoverId)) == null))
      {
        RIJChannelViewpagerEnterPathHelper.a().put(Integer.valueOf(((TabChannelCoverInfo)localObject).mChannelCoverId), Integer.valueOf(1));
        RIJChannelReporter.a(((TabChannelCoverInfo)localObject).mChannelCoverId, "302");
      }
    }
    if (c() == paramInt)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a(paramInt);
      if ((localObject instanceof ReadInJoyBaseFragment)) {
        ((ReadInJoyBaseFragment)localObject).a(5);
      }
      localObject = (TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (localObject != null) {
        try
        {
          a("0X8009665", "", RIJTransMergeKanDianReport.a().addChannelId(((TabChannelCoverInfo)localObject).mChannelCoverId).addContentType(RIJChannelHelper.a((ChannelCoverInfo)localObject)).addRedDotStatus(RIJChannelHelper.a((TabChannelCoverInfo)localObject)).build());
        }
        catch (JSONException localJSONException)
        {
          QLog.d("ReadInJoyChannelViewPagerController", 1, "report channel title click again exception, e = ", localJSONException);
        }
      }
    }
    boolean bool = ReadInJoyHelper.x();
    int i;
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()) && (((TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).dynamicSort == 1)) {
      i = 1;
    } else {
      i = 0;
    }
    if ((bool) && (i != 0)) {
      i = j;
    } else {
      i = 0;
    }
    if ((paramInt >= jdField_a_of_type_Int) && (i != 0))
    {
      if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
      {
        TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
        if ((localTabChannelCoverInfo != null) && (RIJChannelViewpagerEnterPathHelper.a().get(Integer.valueOf(localTabChannelCoverInfo.mChannelCoverId)) == null)) {
          RIJChannelViewpagerEnterPathHelper.a().put(Integer.valueOf(localTabChannelCoverInfo.mChannelCoverId), Integer.valueOf(0));
        }
      }
      e(paramInt);
      this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a();
      this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager.postDelayed(new ReadInJoyChannelViewPagerController.10(this, paramInt), 0L);
      return;
    }
    b(paramInt);
  }
  
  public void a(CallHotwordChange paramCallHotwordChange)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFrameworkCallHotwordChange = paramCallHotwordChange;
  }
  
  public void a(ReadInJoyChannelViewPagerController.OnChannelChangeListener paramOnChannelChangeListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPagerController$OnChannelChangeListener = paramOnChannelChangeListener;
  }
  
  @UiThread
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo == null) {
      return;
    }
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "updateChannelToCacheAndDB channelID = ", Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId) });
    Object localObject = (ReadInJoyLogicManager)ReadInJoyUtils.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER);
    if (localObject != null)
    {
      localObject = ((ReadInJoyLogicManager)localObject).getReadInJoyLogicEngine();
      if (localObject != null)
      {
        if (RIJThreadHandler.a())
        {
          ((ReadInJoyLogicEngine)localObject).a(paramTabChannelCoverInfo);
          return;
        }
        RIJThreadHandler.b().post(new ReadInJoyChannelViewPagerController.3(this, (ReadInJoyLogicEngine)localObject, paramTabChannelCoverInfo));
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "onTabChanged, visible = ", Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      a(this.jdField_a_of_type_JavaUtilMap);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyTabAdapter.notifyDataSetChanged();
    }
    this.jdField_a_of_type_JavaUtilMap.clear();
    if (paramBoolean) {
      FrameHelperActivity.x();
    }
    if (this.jdField_b_of_type_JavaUtilList.size() > 0)
    {
      boolean bool1 = a(this.jdField_b_of_type_JavaUtilList);
      boolean bool2 = ReadInJoyHelper.y();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("has changed :");
      ((StringBuilder)localObject).append(bool1);
      ((StringBuilder)localObject).append(" ,isDynamicOrderSwitchOn : ");
      ((StringBuilder)localObject).append(bool2);
      QLog.d("ReadInJoyChannelViewPagerController", 1, ((StringBuilder)localObject).toString());
      if ((bool1) && (bool2) && (!paramBoolean))
      {
        int i = this.jdField_b_of_type_JavaUtilList.size() - 1;
        while (i > 0)
        {
          localObject = (TabChannelCoverInfo)this.jdField_b_of_type_JavaUtilList.get(i);
          RIJChannelViewpagerEnterPathHelper.a().put(Integer.valueOf(((TabChannelCoverInfo)localObject).mChannelCoverId), Integer.valueOf(2));
          this.jdField_a_of_type_ComTencentMobileqqKandianGlueBusinesshandlerEngineReadInJoyLogicEngine.a(((TabChannelCoverInfo)localObject).mChannelCoverId, 5, false, false);
          i -= 1;
        }
        b(b(this.jdField_b_of_type_JavaUtilList));
        a(b(this.jdField_b_of_type_JavaUtilList));
        com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule.jdField_a_of_type_Boolean = true;
        this.jdField_b_of_type_JavaUtilList.clear();
      }
    }
    else if (!paramBoolean)
    {
      com.tencent.mobileqq.kandian.repo.feeds.ChannelCoverInfoModule.jdField_a_of_type_Boolean = false;
      n();
    }
    FrameHelperActivity.a(paramBoolean ^ true);
  }
  
  public boolean a()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public int b()
  {
    TabChannelCoverInfo localTabChannelCoverInfo = a();
    if (localTabChannelCoverInfo != null) {
      return localTabChannelCoverInfo.mChannelCoverId;
    }
    QLog.d("ReadInJoyChannelViewPagerController", 1, "current channel id is null, return -1");
    return -1;
  }
  
  public void b()
  {
    int i = RIJMainChannelUtil.a.a();
    if (i == -1) {
      i = 0;
    }
    c(i);
  }
  
  public void b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((localTabChannelCoverInfo != null) && (RIJChannelViewpagerEnterPathHelper.a().get(Integer.valueOf(localTabChannelCoverInfo.mChannelCoverId)) == null)) {
        RIJChannelViewpagerEnterPathHelper.a().put(Integer.valueOf(localTabChannelCoverInfo.mChannelCoverId), Integer.valueOf(0));
      }
    }
    e(paramInt);
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager.setCurrentItem(paramInt, false);
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a();
  }
  
  public int c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager.getCurrentItem();
  }
  
  public void c()
  {
    jdField_a_of_type_Int = e();
    jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView.setY(0.0F);
    j();
  }
  
  public void c(int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (((TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(i)).mChannelCoverId == paramInt) {
        break label70;
      }
      if (((TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(i)).mChannelCoverId == 0) {
        j = i;
      }
      i += 1;
    }
    i = -1;
    label70:
    int k = i;
    if (i == -1)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "setCurrentItemByChannelID error,channelID= ", Integer.valueOf(paramInt), " recommendIndex=", Integer.valueOf(j) });
      k = j;
    }
    b(k);
    this.e = k;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public void d()
  {
    jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView.setY(0.0F);
  }
  
  public void e()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsReadInJoyObserver);
    ((KandianSubscribeManager)ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_SUBSCRIBE_MANAGER)).a(this);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager;
    if (localObject != null) {
      ((ReadInJoyChannelViewPager)localObject).removeOnPageChangeListener(this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager$OnPageChangeListener);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager$CustomFragmentPagerAdapter != null)
    {
      localObject = this.jdField_a_of_type_AndroidContentContext;
      if (((localObject instanceof SplashActivity)) && (!((SplashActivity)localObject).isFinishing())) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a();
      }
    }
    localObject = jdField_a_of_type_JavaUtilHashMap;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    if (RIJChannelViewpagerEnterPathHelper.a() != null)
    {
      RIJChannelViewpagerEnterPathHelper.a().clear();
      ((IReadInJoyBaseFragmentEntryPath)QRoute.api(IReadInJoyBaseFragmentEntryPath.class)).clear();
    }
    ((IRIJChannelStayTimeMonitor)QRoute.api(IRIJChannelStayTimeMonitor.class)).endMonitor();
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.setOnScrollStateChangedListener(null);
    this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener = null;
    this.jdField_a_of_type_AndroidViewView = null;
    jdField_b_of_type_Boolean = true;
  }
  
  public void f()
  {
    jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityTabChannelCoverInfo = null;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyTabAdapter = new ReadInJoyTabAdapter(this.jdField_b_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizWidgetsTabLayout, this);
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyTabAdapter.a(this.jdField_a_of_type_JavaUtilMap);
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyTabAdapter);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager$CustomFragmentPagerAdapter;
    if (localObject != null) {
      ((ReadInJoyChannelViewPager.CustomFragmentPagerAdapter)localObject).a();
    }
    localObject = this.jdField_a_of_type_AndroidxFragmentAppFragmentManager;
    if (localObject != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager$CustomFragmentPagerAdapter = new ReadInJoyChannelViewPager.CustomFragmentPagerAdapter((FragmentManager)localObject);
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidContentContext;
      if ((localObject instanceof BaseActivity)) {
        this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager$CustomFragmentPagerAdapter = new ReadInJoyChannelViewPager.CustomFragmentPagerAdapter(((BaseActivity)localObject).getSupportFragmentManager());
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager.setAdapter(this.jdField_a_of_type_ComTencentMobileqqKandianBizTabReadInJoyChannelViewPager$CustomFragmentPagerAdapter);
    i();
    b();
    p();
    j();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadInJoyChannelViewPagerController
 * JD-Core Version:    0.7.0.1
 */