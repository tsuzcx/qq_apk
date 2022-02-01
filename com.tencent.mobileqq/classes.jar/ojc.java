import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.annotation.UiThread;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.10;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.2;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.3;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.5;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.6;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.7;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController.8;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager.CustomFragmentPagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.reddot.ColorBandVideoEntranceButton;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.ThreadManager;
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

public class ojc
  implements pkj
{
  public static int a;
  public static final long a;
  public static TabChannelCoverInfo a;
  private static HashMap<Integer, Long> jdField_a_of_type_JavaUtilHashMap;
  public static boolean a;
  private static final int jdField_b_of_type_Int;
  private static HashMap<Integer, Long> jdField_b_of_type_JavaUtilHashMap;
  public static boolean b;
  private static final int jdField_c_of_type_Int;
  private static HashMap<Integer, Integer> jdField_c_of_type_JavaUtilHashMap;
  private static boolean jdField_c_of_type_Boolean;
  private static HashMap<Integer, Boolean> jdField_d_of_type_JavaUtilHashMap;
  private float jdField_a_of_type_Float = 0.4F;
  private Context jdField_a_of_type_AndroidContentContext;
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = new oji(this);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ReadInJoyChannelViewPager.CustomFragmentPagerAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter;
  private ReadInJoyChannelViewPager jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager;
  private ColorBandVideoEntranceButton jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton;
  private TabLayout jdField_a_of_type_ComTencentBizWidgetsTabLayout;
  private HorizontalListView.OnScrollStateChangedListener jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener;
  private List<TabChannelCoverInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private Map<Integer, rcn> jdField_a_of_type_JavaUtilMap = new HashMap();
  private ojj jdField_a_of_type_Ojj;
  private pkm jdField_a_of_type_Pkm;
  private pkt jdField_a_of_type_Pkt = new ojh(this);
  private pln jdField_a_of_type_Pln = new ojg(this);
  private sof jdField_a_of_type_Sof;
  sqh jdField_a_of_type_Sqh;
  private float jdField_b_of_type_Float = 1.0F;
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private List<TabChannelCoverInfo> jdField_b_of_type_JavaUtilList = new ArrayList();
  private View jdField_c_of_type_AndroidViewView;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = 1;
  private boolean jdField_e_of_type_Boolean;
  private int f = 1;
  
  static
  {
    jdField_a_of_type_Int = 3;
    jdField_c_of_type_Boolean = true;
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_JavaUtilHashMap = new HashMap();
    jdField_c_of_type_JavaUtilHashMap = new HashMap();
    jdField_d_of_type_JavaUtilHashMap = new HashMap();
    jdField_b_of_type_Int = ViewUtils.dpToPx(0.0F);
    jdField_c_of_type_Int = ViewUtils.dpToPx(0.0F);
    jdField_a_of_type_Long = bkwm.f(pay.a());
  }
  
  public ojc(Context paramContext, View paramView, ReadInJoyChannelViewPager paramReadInJoyChannelViewPager)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager = paramReadInJoyChannelViewPager;
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout = ((TabLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131378141));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369296));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369357));
    this.jdField_a_of_type_AndroidViewView = ((Activity)this.jdField_a_of_type_AndroidContentContext).getWindow().getDecorView();
    r();
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
  
  public static Integer a(int paramInt)
  {
    return (Integer)jdField_c_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
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
    if (this.jdField_a_of_type_ComTencentBizWidgetsTabLayout == null)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 1, "mChannelTabLayout null");
      return;
    }
    int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.getCurrentItem();
    if (i >= this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a())
    {
      QLog.d("ReadInJoyChannelViewPagerController", 1, "currentPosition larger than tablayout childsize, currentPosition " + i + " childsize: " + this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a());
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(i);
    View localView2;
    float f2;
    float f1;
    View localView1;
    if (localViewGroup != null)
    {
      localView2 = localViewGroup.findViewById(2131368957);
      paramInt2 = 0;
      if (paramInt1 != i - 1) {
        break label273;
      }
      f2 = (1.0F - paramFloat) * this.jdField_b_of_type_Float;
      f1 = f2;
      if (f2 > 1.0F) {
        f1 = 1.0F;
      }
      paramInt2 = jdField_b_of_type_Int;
      paramInt1 = i - 1;
      if ((paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a())) {
        break label256;
      }
      localView1 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(paramInt1);
      paramInt1 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(paramInt1);
      paramInt2 = (int)(jdField_b_of_type_Int - f1 * paramInt1);
      ThreadManager.getUIHandler().post(new ReadInJoyChannelViewPagerController.5(this, paramFloat, i, localViewGroup, localView1));
      paramInt1 = 0;
    }
    for (;;)
    {
      a(localView2, paramInt2, paramInt1);
      ThreadManager.getUIHandler().post(new ReadInJoyChannelViewPagerController.8(this, localView1, localView2));
      return;
      localView2 = null;
      break;
      label256:
      QLog.d("ReadInJoyChannelViewPagerController", 1, "targetTabView null");
      localView1 = null;
      paramInt1 = 0;
      continue;
      label273:
      if (paramInt1 == i)
      {
        f2 = this.jdField_b_of_type_Float * paramFloat;
        f1 = f2;
        if (f2 > 1.0F) {
          f1 = 1.0F;
        }
        paramInt1 = jdField_c_of_type_Int;
        paramInt2 = i + 1;
        if ((paramInt2 >= 0) && (paramInt2 < this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a()))
        {
          localView1 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(paramInt2);
          paramInt1 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(paramInt2);
          paramInt1 = (int)(jdField_c_of_type_Int - f1 * paramInt1);
          ThreadManager.getUIHandler().post(new ReadInJoyChannelViewPagerController.6(this, paramFloat, paramInt2, localView1, localViewGroup, i));
        }
        for (;;)
        {
          paramInt2 = paramInt1;
          paramInt1 = 1;
          break;
          QLog.d("ReadInJoyChannelViewPagerController", 1, "targetTabView null");
          localView1 = null;
        }
      }
      if (paramInt1 == i + 1)
      {
        i += 1;
        if ((i >= 0) && (i < this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a()))
        {
          localView1 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(i);
          paramInt1 = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(i);
        }
        for (paramInt1 = jdField_c_of_type_Int - paramInt1;; paramInt1 = paramInt2)
        {
          ThreadManager.getUIHandler().post(new ReadInJoyChannelViewPagerController.7(this, i, localView1, localViewGroup));
          paramInt2 = paramInt1;
          paramInt1 = 1;
          break;
          localView1 = null;
        }
      }
      QLog.d("ReadInJoyChannelViewPagerController", 1, "targetTabView null");
      localView1 = null;
      paramInt2 = 0;
      paramInt1 = 0;
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    jdField_c_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public static void a(int paramInt1, int paramInt2, String paramString)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "exitChannel, channelID = ", Integer.valueOf(paramInt1) });
    if (paramInt1 == -1) {
      return;
    }
    Object localObject = (Long)jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt1));
    if ((localObject == null) || (((Long)localObject).longValue() <= 0L))
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "exitChannel, enterTime is invalid");
      return;
    }
    long l = (System.currentTimeMillis() - ((Long)localObject).longValue()) / 1000L;
    try
    {
      paramString = new pbg().b().f().a(paramInt1).b(paramInt2 + 1).d(paramString);
      if (paramInt1 == 41695)
      {
        localObject = pkm.a().a();
        if (localObject != null)
        {
          localObject = ((SelectPositionModule)localObject).a();
          if (localObject != null)
          {
            paramString.e(((SelectPositionModule.PositionData)localObject).city);
            if (QLog.isColorLevel()) {
              QLog.i("ReadInJoyChannelViewPagerController", 2, "reportRecommendEvent CHANNEL_ID_LOCAL r5Str = " + paramString.a());
            }
          }
        }
      }
      a("0X8009733", String.valueOf(l), paramString.a());
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
    jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis()));
    h(paramInt1);
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
    for (;;)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 1, "changeChannelLineMargin: left " + localMarginLayoutParams.leftMargin + " right: " + localMarginLayoutParams.rightMargin);
      paramView.setLayoutParams(localMarginLayoutParams);
      return;
      localMarginLayoutParams.rightMargin = paramInt1;
      localMarginLayoutParams.leftMargin = jdField_b_of_type_Int;
    }
  }
  
  private void a(View paramView1, View paramView2)
  {
    if ((paramView1 == null) || (paramView2 == null))
    {
      QLog.d("ReadInJoyChannelViewPagerController", 1, "tvSelectTab or tvUnselectTab null");
      return;
    }
    paramView1 = (TextView)paramView1.findViewById(2131379877);
    paramView2 = (TextView)paramView2.findViewById(2131379877);
    a(paramView1);
    b(paramView2);
  }
  
  private void a(TextView paramTextView)
  {
    paramTextView.setTextColor(paramTextView.getResources().getColor(2131166902));
    paramTextView.setTypeface(Typeface.defaultFromStyle(1));
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "actionName = ", paramString1, "\n", "r2 = ", paramString2, ", r5 = ", paramString3 });
    odq.a(null, "", paramString1, paramString1, 0, 0, paramString2, "", "", paramString3, false);
  }
  
  private void a(List<TabChannelCoverInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0))
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "channel list size is 0");
      return;
    }
    jdField_a_of_type_Int = d();
    List localList = a(paramList);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(localList);
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a();
    if (this.jdField_a_of_type_Ojj != null)
    {
      paramList = a(paramList);
      this.jdField_a_of_type_Ojj.a(paramList);
    }
    ThreadManager.executeOnSubThread(new ReadInJoyChannelViewPagerController.2(this));
    l();
    m();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a(localList);
    if ((jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo != null) && (a(jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.mChannelCoverId) != null)) {
      c(jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.mChannelCoverId);
    }
    for (;;)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 1, "setAdapterData: " + localList);
      return;
      a();
    }
  }
  
  private void a(Map<Integer, rcn> paramMap)
  {
    if (paramMap != null)
    {
      paramMap = paramMap.values().iterator();
      if (paramMap.hasNext())
      {
        rcn localrcn = (rcn)paramMap.next();
        TabChannelCoverInfo localTabChannelCoverInfo = localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo;
        int j = opq.jdField_b_of_type_Int;
        if ((localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo != null) && (localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint != null) && (localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean)) {}
        for (int i = localrcn.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.redPoint.jdField_a_of_type_Int + 1;; i = 0)
        {
          opq.a("0X8009495", localTabChannelCoverInfo, j, i, localrcn.l);
          break;
        }
      }
    }
  }
  
  public static boolean a(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "isNeedRefreshChannel, channelID = ", Integer.valueOf(paramInt) });
    if (paramInt != -1) {
      return (Boolean)jdField_d_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt)) != null;
    }
    return false;
  }
  
  private boolean a(List<TabChannelCoverInfo> paramList)
  {
    boolean bool2 = false;
    paramList = b(paramList);
    if (paramList.size() == this.jdField_a_of_type_JavaUtilList.size())
    {
      int i = 0;
      for (;;)
      {
        boolean bool1 = bool2;
        if (i < paramList.size())
        {
          if (((TabChannelCoverInfo)paramList.get(i)).mChannelCoverId != ((TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(i)).mChannelCoverId) {
            bool1 = true;
          }
        }
        else {
          return bool1;
        }
        i += 1;
      }
    }
    return true;
  }
  
  private List<TabChannelCoverInfo> b(List<TabChannelCoverInfo> paramList)
  {
    int j = 0;
    int m = paramList.size();
    List localList = a(this.jdField_a_of_type_JavaUtilList);
    Iterator localIterator = localList.iterator();
    label99:
    while (localIterator.hasNext())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)localIterator.next();
      i = 0;
      for (;;)
      {
        if (i >= paramList.size()) {
          break label99;
        }
        if (localTabChannelCoverInfo.mChannelCoverId == ((TabChannelCoverInfo)paramList.get(i)).mChannelCoverId)
        {
          localIterator.remove();
          break;
        }
        i += 1;
      }
    }
    int k = 0;
    int i = j;
    j = k;
    while (i <= m - 1)
    {
      localList.add(jdField_a_of_type_Int + j, paramList.get(i));
      j += 1;
      i += 1;
    }
    return localList;
  }
  
  private void b(TextView paramTextView)
  {
    paramTextView.setTextColor(paramTextView.getResources().getColor(2131166903));
    paramTextView.setTypeface(Typeface.defaultFromStyle(0));
  }
  
  private void b(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo == null) {
      return;
    }
    KandianSubscribeManager localKandianSubscribeManager = (KandianSubscribeManager)pay.a().getManager(280);
    rfq localrfq = new rfq();
    localrfq.jdField_a_of_type_Long = 0L;
    localrfq.b = 9223372036854775807L;
    localrfq.jdField_a_of_type_Boolean = localKandianSubscribeManager.a();
    paramTabChannelCoverInfo.redPoint = localrfq;
    a(paramTabChannelCoverInfo);
  }
  
  private void b(List<TabChannelCoverInfo> paramList)
  {
    List localList = this.jdField_a_of_type_Pkm.a();
    if ((localList != null) && (localList.size() > 0))
    {
      ((rcp)localList.get(0)).jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_Pkm.a(localList, 1, true);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ReadInJoyChannelViewPagerController", 2, "updateMyChannelData channelCoverSectionList is null");
  }
  
  private void b(boolean paramBoolean)
  {
    int k = 0;
    Object localObject;
    int j;
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      if ((!paramBoolean) || (bcoo.a())) {
        break label60;
      }
      i = 1;
      localObject = this.jdField_c_of_type_AndroidViewView;
      if (i == 0) {
        break label65;
      }
      j = 0;
      label34:
      ((View)localObject).setVisibility(j);
      localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton;
      if (i == 0) {
        break label70;
      }
    }
    label60:
    label65:
    label70:
    for (int i = k;; i = 8)
    {
      ((ColorBandVideoEntranceButton)localObject).setVisibility(i);
      return;
      i = 0;
      break;
      j = 4;
      break label34;
    }
  }
  
  public static boolean b()
  {
    return jdField_c_of_type_Boolean;
  }
  
  public static boolean b(int paramInt)
  {
    return jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)) != null;
  }
  
  private void c(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo == null) {
      return;
    }
    int i;
    if (this.jdField_b_of_type_JavaUtilList.size() > 0) {
      i = 0;
    }
    for (;;)
    {
      if (i < this.jdField_b_of_type_JavaUtilList.size())
      {
        if (paramTabChannelCoverInfo.mChannelCoverId == ((TabChannelCoverInfo)this.jdField_b_of_type_JavaUtilList.get(i)).mChannelCoverId) {
          this.jdField_b_of_type_JavaUtilList.remove(i);
        }
      }
      else
      {
        if (paramTabChannelCoverInfo.reason == 4) {
          break;
        }
        this.jdField_b_of_type_JavaUtilList.add(0, paramTabChannelCoverInfo);
        return;
      }
      i += 1;
    }
  }
  
  public static boolean c(int paramInt)
  {
    Long localLong = (Long)jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    if ((localLong == null) || (localLong.longValue() <= 0L))
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "isLastExitChannelOverTimeLimit, lastExitTime is invalid.");
      return true;
    }
    long l = System.currentTimeMillis() - localLong.longValue();
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "refresh_time_limit = ", Long.valueOf(jdField_a_of_type_Long), ", channelID = ", Integer.valueOf(paramInt), ", channelExitTime = ", Long.valueOf(l) });
    return l > jdField_a_of_type_Long;
  }
  
  private int d()
  {
    List localList = this.jdField_a_of_type_Pkm.b();
    int k;
    if ((localList == null) || (localList.size() == 0))
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "No channel Cache info.");
      k = 0;
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyChannelViewPagerController", 2, "getChannelLockCount lockCount：" + k);
      }
      return k;
    }
    int j = 0;
    for (int i = 0;; i = k)
    {
      k = i;
      if (j >= localList.size()) {
        break;
      }
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)localList.get(j);
      k = i;
      if (localTabChannelCoverInfo != null)
      {
        k = i;
        if (localTabChannelCoverInfo.reason != 4) {
          break;
        }
        k = i + 1;
      }
      j += 1;
    }
  }
  
  public static void d(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "enterChannel, channelID = ", Integer.valueOf(paramInt) });
    if (paramInt != -1)
    {
      jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
      syp.b(paramInt);
    }
  }
  
  public static void e(int paramInt)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "refreshChannel, channelID = ", Integer.valueOf(paramInt) });
    if (paramInt != -1) {
      jdField_d_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), Boolean.valueOf(true));
    }
  }
  
  private void f(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {}
    TabChannelCoverInfo localTabChannelCoverInfo;
    do
    {
      return;
      localTabChannelCoverInfo = (TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    } while ((localTabChannelCoverInfo == null) || (localTabChannelCoverInfo.redPoint == null) || (!localTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean));
    localTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean = false;
    a(localTabChannelCoverInfo);
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) {
      this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = ((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getSupportFragmentManager();
    }
    this.jdField_a_of_type_Sof = new sof(this.jdField_b_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizWidgetsTabLayout, this);
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_Sof.a(this.jdField_a_of_type_JavaUtilMap);
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.setAdapter(this.jdField_a_of_type_Sof);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter = ((ReadInJoyChannelViewPager.CustomFragmentPagerAdapter)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.getAdapter());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.addOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
    pkp.a().a(this.jdField_a_of_type_Pkt);
    i();
    a();
    k();
    jdField_a_of_type_Int = d();
    pli.a(this.jdField_a_of_type_Pln);
    h();
  }
  
  private void g(int paramInt)
  {
    TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (((localTabChannelCoverInfo.redPoint != null) && (localTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean)) || (c(localTabChannelCoverInfo.mChannelCoverId))) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "checkBackToTopAndRefresh, position = ", Integer.valueOf(paramInt), ", channelID = ", Integer.valueOf(localTabChannelCoverInfo.mChannelCoverId), ", isNeedRefresh = ", Boolean.valueOf(bool) });
      if (bool)
      {
        Fragment localFragment = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a(paramInt);
        if (!(localFragment instanceof ReadInJoyBaseFragment)) {
          break;
        }
        QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "isShowingSelf = ", Boolean.valueOf(((ReadInJoyBaseFragment)localFragment).c()) });
        ((ReadInJoyBaseFragment)localFragment).a(3);
      }
      return;
    }
    e(localTabChannelCoverInfo.mChannelCoverId);
  }
  
  private void h()
  {
    VideoReport.setElementId(this.jdField_a_of_type_AndroidWidgetImageView, "more_channel_button");
    VideoReport.setElementParams(this.jdField_a_of_type_AndroidWidgetImageView, new pil().a("14").c("click_more_channel").b("channel_bar").a().a());
    VideoReport.setElementReportPolicy(this.jdField_a_of_type_AndroidWidgetImageView, ReportPolicy.REPORT_POLICY_CLICK);
  }
  
  private static void h(int paramInt)
  {
    onx.a(paramInt);
  }
  
  private void i()
  {
    Object localObject = (pks)pay.a().getManager(163);
    List localList;
    if (localObject != null)
    {
      localObject = ((pks)localObject).a();
      if (localObject != null)
      {
        localList = ((pkm)localObject).b();
        if ((localList != null) && (localList.size() != 0)) {
          break label62;
        }
        ((pkm)localObject).m();
        QLog.d("ReadInJoyChannelViewPagerController", 1, "No channel Cache info.");
      }
    }
    for (;;)
    {
      j();
      return;
      label62:
      a(localList);
    }
  }
  
  private void j()
  {
    if (pch.a())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130849329);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842951);
  }
  
  private void k()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new ojd(this));
  }
  
  private void l()
  {
    TabChannelCoverInfo localTabChannelCoverInfo = a(0);
    if (localTabChannelCoverInfo == null) {}
    while ((localTabChannelCoverInfo.redPoint == null) || (!localTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean)) {
      return;
    }
    localTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean = false;
    a(localTabChannelCoverInfo);
  }
  
  private void m()
  {
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a();
    n();
  }
  
  private void n()
  {
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.setOverScrollMode(2);
    int j = b();
    if (this.f == j)
    {
      QLog.i("ReadInJoyChannelViewPagerController", 1, "mLastCenterPosition = " + this.f + ", no need to move again.");
      return;
    }
    this.f = j;
    int i = this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a(j);
    int k = (int)(DeviceInfoUtil.getMinOfWidthHeight() - i) / 2 - ViewUtils.dip2px(12.0F);
    i = 200;
    if ((j < this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.getFirstVisiblePosition()) || (j > this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.getLastVisiblePosition())) {
      i = 0;
    }
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "smoothScrollToPosition, position = ", Integer.valueOf(j), ", offset = ", Integer.valueOf(k) });
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.smoothScrollToPositionFromLeftOrRight(j, -k, i);
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener == null) {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener = new ojf(this);
    }
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.setOnScrollStateChangedListener(this.jdField_a_of_type_ComTencentWidgetHorizontalListView$OnScrollStateChangedListener);
  }
  
  private void o()
  {
    Object localObject = jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo;
    if (localObject != null)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "onChannelBackground, channelID = ", Integer.valueOf(((TabChannelCoverInfo)localObject).mChannelCoverId) });
      int i = ((TabChannelCoverInfo)localObject).mChannelCoverId;
      int j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.getCurrentItem();
      if (TextUtils.isEmpty(((TabChannelCoverInfo)localObject).mChannelVersion)) {}
      for (localObject = "0";; localObject = ((TabChannelCoverInfo)localObject).mChannelVersion)
      {
        a(i, j, (String)localObject);
        return;
      }
    }
    QLog.d("ReadInJoyChannelViewPagerController", 2, "onChannelBackground, channel is null.");
  }
  
  private void p()
  {
    TabChannelCoverInfo localTabChannelCoverInfo = jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo;
    if (localTabChannelCoverInfo != null)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "onChannelBackground, channelID = ", Integer.valueOf(localTabChannelCoverInfo.mChannelCoverId) });
      d(localTabChannelCoverInfo.mChannelCoverId);
      return;
    }
    QLog.d("ReadInJoyChannelViewPagerController", 2, "onChannelForeground, channel is null.");
  }
  
  private void q()
  {
    if (!jdField_c_of_type_Boolean)
    {
      KandianMergeManager localKandianMergeManager = (KandianMergeManager)pay.a().getManager(162);
      if (localKandianMergeManager != null)
      {
        localKandianMergeManager.r();
        QLog.d("ReadInJoyChannelViewPagerController", 1, "clearKandianRedPoint");
      }
    }
  }
  
  private void r()
  {
    this.jdField_a_of_type_Pkm = ((pks)pay.a().getManager(163)).a();
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public Fragment a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a();
  }
  
  public TabChannelCoverInfo a()
  {
    int i = b();
    if ((i < 0) || (i >= this.jdField_a_of_type_JavaUtilList.size())) {
      return null;
    }
    return (TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(i);
  }
  
  public void a()
  {
    int i = Aladdin.getConfig(220).getIntegerFromString("main_feeds_channel_id", -1);
    if (i != -1) {}
    for (;;)
    {
      c(i);
      return;
      i = 0;
    }
  }
  
  public void a(int paramInt)
  {
    int j = 1;
    Object localObject;
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      localObject = (TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((localObject != null) && (jdField_c_of_type_JavaUtilHashMap.get(Integer.valueOf(((TabChannelCoverInfo)localObject).mChannelCoverId)) == null)) {
        a(((TabChannelCoverInfo)localObject).mChannelCoverId, 1);
      }
    }
    for (;;)
    {
      try
      {
        a("0X8009B94", "", new pbg().a("source", "302").a(((TabChannelCoverInfo)localObject).mChannelCoverId).b("style", 0).a());
        if (b() == paramInt)
        {
          localObject = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a(paramInt);
          if ((localObject instanceof ReadInJoyBaseFragment)) {
            ((ReadInJoyBaseFragment)localObject).a(5);
          }
          localObject = (TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
          if (localObject == null) {}
        }
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          a("0X8009665", "", pay.a().a(((TabChannelCoverInfo)localObject).mChannelCoverId).m(ReadInJoyChannelPanelFragment.a((ChannelCoverInfo)localObject)).n(ReadInJoyChannelPanelFragment.a((TabChannelCoverInfo)localObject)).a());
          boolean bool = bkwm.A();
          if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
            if (((TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).dynamicSort == 1)
            {
              i = 1;
              if ((!bool) || (i == 0)) {
                continue;
              }
              i = j;
              if ((paramInt < jdField_a_of_type_Int) || (i == 0)) {
                continue;
              }
              if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
              {
                localObject = (TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
                if ((localObject != null) && (jdField_c_of_type_JavaUtilHashMap.get(Integer.valueOf(((TabChannelCoverInfo)localObject).mChannelCoverId)) == null)) {
                  a(((TabChannelCoverInfo)localObject).mChannelCoverId, 0);
                }
              }
              f(paramInt);
              this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a();
              this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.postDelayed(new ReadInJoyChannelViewPagerController.10(this, paramInt), 0L);
              return;
              localJSONException1 = localJSONException1;
              QLog.d("ReadInJoyChannelViewPagerController", 2, "report click channel bar exception, e = ", localJSONException1);
            }
          }
        }
        catch (JSONException localJSONException2)
        {
          QLog.d("ReadInJoyChannelViewPagerController", 1, "report channel title click again exception, e = ", localJSONException2);
          continue;
          i = 0;
          continue;
          i = 0;
          continue;
          b(paramInt);
          return;
        }
      }
      int i = 0;
    }
  }
  
  public void a(View paramView, ColorBandVideoEntranceButton paramColorBandVideoEntranceButton)
  {
    this.jdField_c_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReddotColorBandVideoEntranceButton = paramColorBandVideoEntranceButton;
  }
  
  @UiThread
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    if (paramTabChannelCoverInfo == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "updateChannelToCacheAndDB channelID = ", Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId) });
        localObject = (pks)pay.a().getManager(163);
      } while (localObject == null);
      localObject = ((pks)localObject).a();
    } while (localObject == null);
    if (pay.k())
    {
      ((pkm)localObject).a(paramTabChannelCoverInfo);
      return;
    }
    pay.b().post(new ReadInJoyChannelViewPagerController.3(this, (pkm)localObject, paramTabChannelCoverInfo));
  }
  
  public void a(sqh paramsqh)
  {
    this.jdField_a_of_type_Sqh = paramsqh;
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "onTabChanged, visible = ", Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      a(this.jdField_a_of_type_JavaUtilMap);
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      if (paramBoolean) {
        FrameHelperActivity.u();
      }
      if (this.jdField_b_of_type_JavaUtilList.size() <= 0) {
        break label247;
      }
      boolean bool1 = a(this.jdField_b_of_type_JavaUtilList);
      boolean bool2 = bkwm.B();
      QLog.d("ReadInJoyChannelViewPagerController", 1, "has changed :" + bool1 + " ,isDynamicOrderSwitchOn : " + bool2);
      if ((!bool1) || (!bool2) || (paramBoolean)) {
        break label236;
      }
      int i = this.jdField_b_of_type_JavaUtilList.size() - 1;
      while (i > 0)
      {
        TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)this.jdField_b_of_type_JavaUtilList.get(i);
        a(localTabChannelCoverInfo.mChannelCoverId, 2);
        this.jdField_a_of_type_Pkm.a(localTabChannelCoverInfo.mChannelCoverId, 5, false, false);
        i -= 1;
      }
      this.jdField_a_of_type_Sof.notifyDataSetChanged();
    }
    b(b(this.jdField_b_of_type_JavaUtilList));
    a(b(this.jdField_b_of_type_JavaUtilList));
    jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_JavaUtilList.clear();
    label236:
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      FrameHelperActivity.b(paramBoolean);
      return;
      label247:
      if (paramBoolean) {
        break;
      }
      jdField_a_of_type_Boolean = false;
      n();
      break;
    }
  }
  
  public boolean a()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.getCurrentItem();
  }
  
  public void b()
  {
    jdField_a_of_type_Int = d();
    jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewView.setY(0.0F);
    j();
  }
  
  public void b(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size()))
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((localTabChannelCoverInfo != null) && (jdField_c_of_type_JavaUtilHashMap.get(Integer.valueOf(localTabChannelCoverInfo.mChannelCoverId)) == null)) {
        a(localTabChannelCoverInfo.mChannelCoverId, 0);
      }
    }
    f(paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.setCurrentItem(paramInt, false);
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a();
  }
  
  public int c()
  {
    return this.jdField_e_of_type_Int;
  }
  
  public void c()
  {
    jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidViewView.setY(0.0F);
  }
  
  public void c(int paramInt)
  {
    int i = 0;
    int j = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size()) {
      if (((TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(i)).mChannelCoverId != paramInt) {}
    }
    for (;;)
    {
      if (i == -1) {
        QLog.d("ReadInJoyChannelViewPagerController", 1, new Object[] { "setCurrentItemByChannelID error,channelID= ", Integer.valueOf(paramInt), " recommendIndex=", Integer.valueOf(j) });
      }
      for (;;)
      {
        b(j);
        this.jdField_e_of_type_Int = j;
        return;
        if (((TabChannelCoverInfo)this.jdField_a_of_type_JavaUtilList.get(i)).mChannelCoverId == 0) {
          j = i;
        }
        i += 1;
        break;
        j = i;
      }
      i = -1;
    }
  }
  
  public void d()
  {
    pkp.a().b(this.jdField_a_of_type_Pkt);
    ((KandianSubscribeManager)pay.a().getManager(280)).a(this);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.removeOnPageChangeListener(this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter != null) && ((this.jdField_a_of_type_AndroidContentContext instanceof SplashActivity)) && (!((SplashActivity)this.jdField_a_of_type_AndroidContentContext).isFinishing())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a();
    }
    if (jdField_a_of_type_JavaUtilHashMap != null) {
      jdField_a_of_type_JavaUtilHashMap.clear();
    }
    if (jdField_b_of_type_JavaUtilHashMap != null) {
      jdField_b_of_type_JavaUtilHashMap.clear();
    }
    if (jdField_d_of_type_JavaUtilHashMap != null) {
      jdField_d_of_type_JavaUtilHashMap.clear();
    }
    if (jdField_c_of_type_JavaUtilHashMap != null)
    {
      jdField_c_of_type_JavaUtilHashMap.clear();
      ReadInJoyBaseFragment.jdField_a_of_type_JavaUtilHashMap.clear();
    }
    if (this.jdField_a_of_type_Pln != null) {
      pli.b(this.jdField_a_of_type_Pln);
    }
    this.jdField_a_of_type_AndroidViewView = null;
    jdField_c_of_type_Boolean = true;
  }
  
  public void e()
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo = null;
    jdField_a_of_type_JavaUtilHashMap.clear();
    jdField_b_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Sof = new sof(this.jdField_b_of_type_AndroidViewView.getContext(), this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentBizWidgetsTabLayout, this);
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_Sof.a(this.jdField_a_of_type_JavaUtilMap);
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.setAdapter(this.jdField_a_of_type_Sof);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter.a();
    }
    if (this.jdField_a_of_type_AndroidSupportV4AppFragmentManager != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter = new ReadInJoyChannelViewPager.CustomFragmentPagerAdapter(this.jdField_a_of_type_AndroidSupportV4AppFragmentManager);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter);
      i();
      a();
      r();
      j();
      return;
      if ((this.jdField_a_of_type_AndroidContentContext instanceof FragmentActivity)) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyChannelViewPager$CustomFragmentPagerAdapter = new ReadInJoyChannelViewPager.CustomFragmentPagerAdapter(((FragmentActivity)this.jdField_a_of_type_AndroidContentContext).getSupportFragmentManager());
      }
    }
  }
  
  public void w_()
  {
    QLog.i("ReadInJoyChannelViewPagerController", 1, "[onReceiveKandianSubscribeMessage] ");
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty())) {}
    TabChannelCoverInfo localTabChannelCoverInfo;
    do
    {
      return;
      localTabChannelCoverInfo = a(70);
    } while (localTabChannelCoverInfo == null);
    rfq localrfq = new rfq();
    localrfq.jdField_a_of_type_Boolean = true;
    localrfq.jdField_a_of_type_Long = 0L;
    localrfq.b = 9223372036854775807L;
    localTabChannelCoverInfo.redPoint = localrfq;
    a(localTabChannelCoverInfo);
    this.jdField_a_of_type_ComTencentBizWidgetsTabLayout.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ojc
 * JD-Core Version:    0.7.0.1
 */