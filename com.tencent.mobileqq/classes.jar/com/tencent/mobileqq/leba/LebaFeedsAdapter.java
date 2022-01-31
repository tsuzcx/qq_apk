package com.tencent.mobileqq.leba;

import adyk;
import adyl;
import adym;
import adyn;
import adyo;
import adyp;
import adyz;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaFeedInfo;
import com.tencent.mobileqq.leba.UITemplate.ARKUITemplateInfo;
import com.tencent.mobileqq.leba.UITemplate.BaseUITemplateInfo;
import com.tencent.mobileqq.leba.UITemplate.PicUITemplateInfo;
import com.tencent.mobileqq.leba.UITemplate.VideoUITemplateInfo;
import com.tencent.mobileqq.leba.ark.LebaArkReporter;
import com.tencent.mobileqq.leba.ark.LebaFeedsArkHelper;
import com.tencent.mobileqq.leba.view.LebaFPSXListView;
import com.tencent.mobileqq.leba.view.LebaFPSXListView.Listener;
import com.tencent.mobileqq.leba.view.LebaFeedsDayHeaderView;
import com.tencent.mobileqq.leba.view.LebaFeedsVideoView1;
import com.tencent.mobileqq.leba.view.LebaFeedsViewBase;
import com.tencent.mobileqq.leba.view.LebaFeedsViewBase.ItemClickListener;
import com.tencent.mobileqq.leba.view.LebaFeedsViewImage1;
import com.tencent.mobileqq.leba.view.LebaFeedsViewImage3;
import com.tencent.mobileqq.leba.view.LebaFeedsViewImage6;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LebaFeedsAdapter
  extends BaseAdapter
  implements adyz, LebaFPSXListView.Listener, LebaFeedsViewBase.ItemClickListener, AbsListView.OnScrollListener
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private adyp jdField_a_of_type_Adyp;
  private Animator.AnimatorListener jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new adyo(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private LebaFeedInfo jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo;
  private LebaFeedsVideoPlayController jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController;
  private LebaWithFeeds jdField_a_of_type_ComTencentMobileqqLebaLebaWithFeeds;
  private LebaFPSXListView jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap(32);
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long = -1L;
  private ValueAnimator jdField_b_of_type_AndroidAnimationValueAnimator;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private List jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  private int[] jdField_b_of_type_ArrayOfInt = new int[2];
  private int jdField_c_of_type_Int = 1;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public LebaFeedsAdapter(QQAppInterface paramQQAppInterface, Context paramContext, View paramView, LebaFPSXListView paramLebaFPSXListView, LebaWithFeeds paramLebaWithFeeds)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView = paramLebaFPSXListView;
    this.jdField_a_of_type_ComTencentMobileqqLebaLebaWithFeeds = paramLebaWithFeeds;
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370335));
    this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController = new LebaFeedsVideoPlayController(paramContext, paramView, paramLebaFPSXListView);
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.setListener(this);
    o();
    m();
    this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController.a(this);
    l();
    this.jdField_b_of_type_Int = ViewConfiguration.get(this.jdField_a_of_type_AndroidContentContext).getScaledTouchSlop();
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      paramQQAppInterface = new IntentFilter();
      paramQQAppInterface.addAction("mqq.intent.action.QQ_BACKGROUND");
      paramQQAppInterface.addAction("tencent.av.v2q.StartVideoChat");
      paramQQAppInterface.addAction("tencent.av.v2q.StopVideoChat");
      this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramQQAppInterface);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("Leba2018.LebaFeedsAdapter", 1, "LebaFeedsAdapter registerReceiver exception", paramQQAppInterface);
    }
  }
  
  private View a(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      QLog.i("Leba2018.LebaFeedsAdapter", 1, "getView invalid view type " + paramInt);
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return paramView;
              } while ((paramView != null) && ((paramView instanceof LebaFeedsDayHeaderView)));
              return new LebaFeedsDayHeaderView(this.jdField_a_of_type_AndroidContentContext);
            } while ((paramView != null) && ((paramView instanceof LebaFeedsViewImage1)));
            return new LebaFeedsViewImage1(this.jdField_a_of_type_AndroidContentContext);
          } while ((paramView != null) && ((paramView instanceof LebaFeedsViewImage3)));
          return new LebaFeedsViewImage3(this.jdField_a_of_type_AndroidContentContext);
        } while ((paramView != null) && ((paramView instanceof LebaFeedsViewImage6)));
        return new LebaFeedsViewImage6(this.jdField_a_of_type_AndroidContentContext);
      } while ((paramView != null) && ((paramView instanceof LebaFeedsVideoView1)));
      return new LebaFeedsVideoView1(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController);
    case 5: 
      return LebaFeedsArkHelper.a().a(this.jdField_a_of_type_AndroidContentContext, paramView);
    }
    return LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969496, null);
  }
  
  private String a(int paramInt)
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      localObject = (String)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt));
    }
    String str;
    do
    {
      return localObject;
      str = LebaUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramInt);
      localObject = str;
    } while (TextUtils.isEmpty(str));
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), str);
    return str;
  }
  
  private void a(long paramLong, boolean paramBoolean)
  {
    if (paramLong < 0L) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.getChildCount())
      {
        Object localObject = this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.getChildAt(i);
        if ((localObject != null) && ((localObject instanceof LebaFeedsViewBase)))
        {
          localObject = (LebaFeedsViewBase)localObject;
          if (((LebaFeedsViewBase)localObject).a() == paramLong)
          {
            if (paramBoolean)
            {
              ((LebaFeedsViewBase)localObject).k();
              return;
            }
            ((LebaFeedsViewBase)localObject).j();
            return;
          }
        }
        i += 1;
      }
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView != null)
    {
      if (paramInt1 != 0) {
        break label28;
      }
      paramView = (LebaFeedsViewBase)paramView;
      paramView.setPosition(paramInt2);
      paramView.a(a(paramInt2));
    }
    label28:
    do
    {
      return;
      if ((1 <= paramInt1) && (paramInt1 <= 5))
      {
        Object localObject = (LebaFeedsViewBase)paramView;
        ((LebaFeedsViewBase)localObject).setPosition(paramInt2);
        ((LebaFeedsViewBase)localObject).d();
        ((LebaFeedsViewBase)localObject).e();
        ((LebaFeedsViewBase)localObject).setItemClickListener(this);
        paramView = a(paramInt2);
        ((LebaFeedsViewBase)localObject).a(paramView);
        if ((this.jdField_b_of_type_Long > 0L) && (paramView != null) && (paramView.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo.feedID == this.jdField_b_of_type_Long)) {
          ((LebaFeedsViewBase)localObject).i();
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (paramView == null) {}
        for (paramView = null;; paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo)
        {
          LebaUtils.a((QQAppInterface)localObject, paramView, paramInt2, "trends_feeds", "feeds_exp", 0L);
          return;
        }
      }
    } while (paramInt1 != 6);
  }
  
  private void a(LebaFeedsViewBase paramLebaFeedsViewBase, LebaFeedInfo paramLebaFeedInfo)
  {
    if (this.d) {
      return;
    }
    this.d = true;
    this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController.a(paramLebaFeedInfo);
    this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController.a(true);
    int i = paramLebaFeedsViewBase.getHeight();
    this.jdField_b_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofInt(new int[] { 0, 360 });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(360L);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new adym(this, paramLebaFeedsViewBase, i));
    this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener = new adyn(this, paramLebaFeedInfo);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addListener(this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
    r();
  }
  
  private boolean b(long paramLong)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        LebaFeedInfo localLebaFeedInfo = (LebaFeedInfo)this.jdField_a_of_type_JavaUtilList.get(i);
        if ((localLebaFeedInfo != null) && (localLebaFeedInfo.feedID == paramLong))
        {
          this.jdField_a_of_type_JavaUtilList.remove(i);
          if (QLog.isColorLevel()) {
            QLog.i("Leba2018.LebaFeedsAdapter", 2, "removeData " + localLebaFeedInfo);
          }
          bool1 = true;
        }
      }
      else
      {
        return bool1;
      }
      i += 1;
    }
  }
  
  private boolean c()
  {
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      LebaFeedsManager localLebaFeedsManager = (LebaFeedsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(276);
      if (localLebaFeedsManager == null) {
        return false;
      }
      bool2 = localLebaFeedsManager.jdField_a_of_type_Boolean;
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.i("Leba2018.LebaFeedsAdapter", 2, "isShowArk configShow:" + bool2);
    return bool2;
  }
  
  private void l()
  {
    int i = 0;
    if (ImmersiveUtils.isSupporImmersive() == 0) {
      i = ImmersiveUtils.a(this.jdField_a_of_type_AndroidContentContext);
    }
    int j = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().heightPixels / 2;
    int k = AIOUtils.a(20.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetTextView.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.topMargin = (j - k - i);
      this.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    }
  }
  
  private void m()
  {
    
    if ((this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView != null) && (this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.getChildCount() > 0))
    {
      int i = 0;
      while (i < this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.getChildCount())
      {
        View localView = this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.getChildAt(i);
        if ((localView != null) && ((localView instanceof LebaFeedsViewBase))) {
          ((LebaFeedsViewBase)localView).e();
        }
        i += 1;
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController.j();
    }
    p();
  }
  
  private void n()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)
    {
      QLog.e("Leba2018.LebaFeedsAdapter", 1, "buildShowItemList app is null");
      return;
    }
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList1 = new ArrayList(this.jdField_a_of_type_JavaUtilList.size());
    localArrayList1.addAll(this.jdField_a_of_type_JavaUtilList);
    boolean bool = c();
    ArrayList localArrayList2 = new ArrayList();
    LebaFeedsManager localLebaFeedsManager = (LebaFeedsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(276);
    int j = -1;
    int m = LebaUtils.a(0);
    Object localObject1 = null;
    int k = 0;
    LebaFeedInfo localLebaFeedInfo;
    label122:
    Object localObject2;
    int i;
    if (k < localArrayList1.size())
    {
      localLebaFeedInfo = (LebaFeedInfo)localArrayList1.get(k);
      if (localLebaFeedInfo == null) {}
      label532:
      for (;;)
      {
        k += 1;
        break;
        localObject2 = localObject1;
        i = j;
        if (localLebaFeedInfo.uiLoadDayTimestamp != j)
        {
          i = localLebaFeedInfo.uiLoadDayTimestamp;
          localObject2 = new LebaFeedsAdapter.ListItem(this, 0);
          ((LebaFeedsAdapter.ListItem)localObject2).jdField_b_of_type_Int = localLebaFeedInfo.uiLoadDayTimestamp;
          localObject1 = Calendar.getInstance();
          ((Calendar)localObject1).setTimeInMillis(localLebaFeedInfo.uiLoadDayTimestamp * 1000L);
          j = ((Calendar)localObject1).get(2);
          int n = ((Calendar)localObject1).get(5);
          ((LebaFeedsAdapter.ListItem)localObject2).jdField_b_of_type_JavaLangString = (j + 1 + "月" + n + "日");
          j = ((Calendar)localObject1).get(7);
          if (m != localLebaFeedInfo.uiLoadDayTimestamp) {
            break label448;
          }
          localObject3 = localLebaFeedsManager.jdField_a_of_type_JavaLangString;
          localObject1 = localObject3;
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            localObject1 = "今日精选";
          }
          ((LebaFeedsAdapter.ListItem)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
          ((LebaFeedsAdapter.ListItem)localObject2).jdField_b_of_type_JavaLangString = (((LebaFeedsAdapter.ListItem)localObject2).jdField_b_of_type_JavaLangString + " " + LebaUtils.a(j));
        }
        for (;;)
        {
          localObject1 = localObject2;
          j = i;
          if (localLebaFeedInfo.templateInfo == null) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.i("Leba2018.LebaFeedsAdapter", 2, "buildShowItemList, handling=" + localLebaFeedInfo + ", title=" + localLebaFeedInfo.templateInfo.f);
          }
          if (!localHashSet.contains(Long.valueOf(localLebaFeedInfo.feedID))) {
            break label460;
          }
          QLog.i("Leba2018.LebaFeedsAdapter", 1, "buildShowItemList same feedId=" + localLebaFeedInfo.feedID);
          localObject1 = localObject2;
          j = i;
          break;
          label448:
          ((LebaFeedsAdapter.ListItem)localObject2).jdField_a_of_type_JavaLangString = LebaUtils.a(j);
        }
        label460:
        switch (localLebaFeedInfo.templateInfo.jdField_a_of_type_Int)
        {
        default: 
          QLog.e("Leba2018.LebaFeedsAdapter", 1, "buildShowItemList bad template id:" + localLebaFeedInfo.templateInfo.jdField_a_of_type_Int);
          localObject3 = null;
          localObject1 = localObject2;
          j = i;
          if (localObject3 != null)
          {
            Object localObject4 = localObject2;
            if (localObject2 != null)
            {
              localArrayList2.add(localObject2);
              localObject4 = null;
            }
            ((LebaFeedsAdapter.ListItem)localObject3).c = a(localLebaFeedInfo.uiResID);
            localArrayList2.add(localObject3);
            localHashSet.add(Long.valueOf(localLebaFeedInfo.feedID));
            localObject1 = localObject4;
            j = i;
            if (QLog.isColorLevel())
            {
              QLog.i("Leba2018.LebaFeedsAdapter", 2, "buildShowItemList added feedId=" + ((LebaFeedsAdapter.ListItem)localObject3).jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo.feedID);
              localObject1 = localObject4;
              j = i;
            }
          }
          break;
        }
      }
      if (!(localLebaFeedInfo.templateInfo instanceof PicUITemplateInfo)) {
        break label1110;
      }
    }
    label708:
    label1110:
    for (Object localObject3 = (PicUITemplateInfo)localLebaFeedInfo.templateInfo;; localObject3 = null)
    {
      localObject1 = localObject2;
      j = i;
      if (localObject3 == null) {
        break label122;
      }
      if (((PicUITemplateInfo)localObject3).jdField_a_of_type_JavaUtilList != null)
      {
        j = ((PicUITemplateInfo)localObject3).jdField_a_of_type_JavaUtilList.size();
        switch (j)
        {
        case 2: 
        case 4: 
        case 5: 
        default: 
          QLog.e("Leba2018.LebaFeedsAdapter", 1, "buildShowItemList invalid img count=" + ((PicUITemplateInfo)localObject3).jdField_b_of_type_Int + ", info=" + localLebaFeedInfo);
          localObject1 = null;
        }
      }
      for (;;)
      {
        localObject3 = localObject1;
        if (localObject1 == null) {
          break;
        }
        ((LebaFeedsAdapter.ListItem)localObject1).jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo = localLebaFeedInfo;
        localObject3 = localObject1;
        break;
        j = 0;
        break label708;
        localObject1 = new LebaFeedsAdapter.ListItem(this, 1);
        continue;
        localObject1 = new LebaFeedsAdapter.ListItem(this, 2);
        continue;
        localObject1 = new LebaFeedsAdapter.ListItem(this, 3);
      }
      localObject3 = null;
      if ((localLebaFeedInfo.templateInfo instanceof VideoUITemplateInfo)) {
        localObject3 = (VideoUITemplateInfo)localLebaFeedInfo.templateInfo;
      }
      localObject1 = localObject2;
      j = i;
      if (localObject3 == null) {
        break label122;
      }
      localObject3 = new LebaFeedsAdapter.ListItem(this, 4);
      ((LebaFeedsAdapter.ListItem)localObject3).jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo = localLebaFeedInfo;
      break label532;
      localObject1 = localObject2;
      j = i;
      if (!bool) {
        break label122;
      }
      localObject3 = null;
      if ((localLebaFeedInfo.templateInfo instanceof ARKUITemplateInfo)) {
        localObject3 = (ARKUITemplateInfo)localLebaFeedInfo.templateInfo;
      }
      localObject1 = localObject2;
      j = i;
      if (localObject3 == null) {
        break label122;
      }
      localObject1 = ((ARKUITemplateInfo)localObject3).jdField_a_of_type_JavaLangString;
      if ((!"com.tencent.dongtaifeeds".equals(localObject1)) && (!"com.tencent.test.dongtaifeeds".equals(localObject1)))
      {
        QLog.e("Leba2018.LebaFeedsAdapter", 1, "buildShowItemList ark app name not match:" + (String)localObject1);
        localObject1 = localObject2;
        j = i;
        break label122;
      }
      localObject3 = new LebaFeedsAdapter.ListItem(this, 5);
      ((LebaFeedsAdapter.ListItem)localObject3).jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo = localLebaFeedInfo;
      break label532;
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.addAll(localArrayList2);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Leba2018.LebaFeedsAdapter", 2, "buildShowItemList add size:" + localArrayList2.size());
      return;
    }
  }
  
  private void o()
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130969497, null);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366712));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366714));
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)this.jdField_a_of_type_AndroidViewView.findViewById(2131366713));
    p();
    ViewGroup.LayoutParams localLayoutParams = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new AbsListView.LayoutParams(-1, 0);
    }
    ((ViewGroup.LayoutParams)localObject).height = AIOUtils.a(55.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new adyk(this));
    this.jdField_a_of_type_AndroidViewView.setOnTouchListener(new adyl(this));
    e();
  }
  
  private void p()
  {
    int j = 2131493444;
    int i = j;
    switch (LebaUtils.jdField_a_of_type_Int)
    {
    }
    for (i = j;; i = 2131494267)
    {
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(i));
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(i));
      return;
    }
  }
  
  private void q()
  {
    if ((this.jdField_b_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_b_of_type_AndroidAnimationValueAnimator.isRunning())) {}
    try
    {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.removeAllListeners();
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
      if (this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener != null) {
        this.jdField_a_of_type_AndroidAnimationAnimator$AnimatorListener.onAnimationEnd(this.jdField_b_of_type_AndroidAnimationValueAnimator);
      }
      this.d = false;
    }
    catch (Exception localException1)
    {
      try
      {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.removeAllListeners();
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
        if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
          break label103;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        return;
        localException1 = localException1;
        QLog.e("Leba2018.LebaFeedsAdapter", 2, "onDislikeClick exception", localException1);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          QLog.e("Leba2018.LebaFeedsAdapter", 2, "onDislikeClick mTipsAnimator exception", localException2);
        }
      }
    }
    if ((this.jdField_a_of_type_AndroidAnimationValueAnimator == null) || (!this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {}
  }
  
  private void r()
  {
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131439338, 0).a();
  }
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  public LebaFeedsAdapter.ListItem a(int paramInt)
  {
    if ((paramInt < 0) || (this.jdField_b_of_type_JavaUtilList == null) || (paramInt >= this.jdField_b_of_type_JavaUtilList.size())) {
      return null;
    }
    return (LebaFeedsAdapter.ListItem)this.jdField_b_of_type_JavaUtilList.get(paramInt);
  }
  
  public AbsListView.OnScrollListener a()
  {
    return this;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Leba2018.LebaFeedsAdapter", 2, "onPostThemeChanged");
    }
    m();
  }
  
  public void a(adyp paramadyp)
  {
    this.jdField_a_of_type_Adyp = paramadyp;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Leba2018.LebaFeedsAdapter", 2, "onAccountChange app= " + paramQQAppInterface);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    LebaFeedsArkHelper.a().d();
    LebaFeedsArkHelper.a().c();
    this.jdField_a_of_type_JavaUtilList.clear();
    notifyDataSetChanged();
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController.i();
    }
  }
  
  public void a(LebaFeedsViewBase paramLebaFeedsViewBase, LebaFeedInfo paramLebaFeedInfo, int paramInt)
  {
    if ((paramLebaFeedsViewBase == null) || (paramLebaFeedInfo == null)) {
      return;
    }
    if (this.jdField_a_of_type_Adyp != null) {
      this.jdField_a_of_type_Adyp.a(paramLebaFeedInfo);
    }
    a(paramLebaFeedsViewBase, paramLebaFeedInfo);
    LebaUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLebaFeedInfo, paramInt, "trends_feeds", "feeds_dislike", 0L);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController.a(paramAbsListView, paramInt);
    if ((paramAbsListView != null) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (paramInt == 0) && (this.jdField_a_of_type_Adyp != null)) {
      this.jdField_a_of_type_Adyp.b();
    }
    if ((paramInt == 1) && (this.jdField_b_of_type_Long > 0L)) {
      a(this.jdField_b_of_type_Long, true);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController.a(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if ((this.jdField_c_of_type_Int == 4) && (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0))
    {
      this.jdField_a_of_type_AndroidViewView.getLocationOnScreen(this.jdField_b_of_type_ArrayOfInt);
      if (!this.jdField_c_of_type_Boolean) {
        break label81;
      }
      if (this.jdField_b_of_type_ArrayOfInt[1] + this.jdField_a_of_type_AndroidViewView.getHeight() <= this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.getHeight()) {
        this.jdField_a_of_type_AndroidViewView.performClick();
      }
    }
    label81:
    while (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) {
      return;
    }
    this.jdField_c_of_type_Boolean = true;
  }
  
  public void a(List paramList)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("setDataList size=");
      if (paramList != null) {
        break label47;
      }
    }
    label47:
    for (Object localObject = "null";; localObject = Integer.valueOf(paramList.size()))
    {
      QLog.i("Leba2018.LebaFeedsAdapter", 2, localObject);
      if (paramList != null) {
        break;
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Leba2018.LebaFeedsAdapter", 2, "setHasMoreFeeds " + paramBoolean);
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(long paramLong)
  {
    return (this.jdField_b_of_type_Long > 0L) && (this.jdField_b_of_type_Long == paramLong);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() != 0) || (this.jdField_b_of_type_Long <= 0L) || (this.jdField_a_of_type_AndroidWidgetButton == null)) {}
    float f1;
    float f2;
    do
    {
      return false;
      f1 = paramMotionEvent.getRawX();
      f2 = paramMotionEvent.getRawY();
      if (this.jdField_a_of_type_ArrayOfInt == null) {
        this.jdField_a_of_type_ArrayOfInt = new int[2];
      }
      this.jdField_a_of_type_AndroidWidgetButton.getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
    } while ((f1 >= this.jdField_a_of_type_ArrayOfInt[0] - this.jdField_b_of_type_Int) && (f2 >= this.jdField_a_of_type_ArrayOfInt[1] - this.jdField_b_of_type_Int) && (f1 <= this.jdField_a_of_type_ArrayOfInt[0] + this.jdField_a_of_type_AndroidWidgetButton.getWidth() + this.jdField_b_of_type_Int) && (f2 <= this.jdField_a_of_type_ArrayOfInt[1] + this.jdField_a_of_type_AndroidWidgetButton.getHeight() + this.jdField_b_of_type_Int));
    a(this.jdField_b_of_type_Long, true);
    return true;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.removeFooterView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.addFooterView(this.jdField_a_of_type_AndroidViewView, null, false);
    this.jdField_c_of_type_Int = 2;
    if (QLog.isColorLevel()) {
      QLog.i("Leba2018.LebaFeedsAdapter", 2, "showFooterLoadMore");
    }
  }
  
  public void b(LebaFeedsViewBase paramLebaFeedsViewBase, LebaFeedInfo paramLebaFeedInfo, int paramInt)
  {
    if (this.jdField_a_of_type_Adyp != null)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if ((paramLebaFeedsViewBase instanceof LebaFeedsVideoView1))
      {
        localObject1 = localObject2;
        if (paramLebaFeedInfo != null)
        {
          paramLebaFeedsViewBase = this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController.a();
          localObject1 = localObject2;
          if (paramLebaFeedsViewBase != null)
          {
            localObject1 = localObject2;
            if (paramLebaFeedsViewBase.jdField_a_of_type_Long == paramLebaFeedInfo.feedID)
            {
              long l = this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController.a();
              localObject1 = localObject2;
              if (l > 0L)
              {
                localObject1 = new HashMap(1);
                ((HashMap)localObject1).put("dt_v_p", String.valueOf(l));
              }
            }
          }
        }
      }
      this.jdField_a_of_type_Adyp.a(paramLebaFeedInfo, (HashMap)localObject1);
    }
    LebaUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLebaFeedInfo, paramInt, "trends_feeds", "feeds_clk", 0L);
    this.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo = paramLebaFeedInfo;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean b()
  {
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
    if (QLog.isColorLevel()) {
      QLog.i("Leba2018.LebaFeedsAdapter", 2, "isVideoChatting " + bool);
    }
    return bool;
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText("没有更多内容了");
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.removeFooterView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.addFooterView(this.jdField_a_of_type_AndroidViewView, null, false);
    this.jdField_c_of_type_Int = 3;
    this.jdField_c_of_type_AndroidWidgetTextView.setAlpha(1.0F);
    if (QLog.isColorLevel()) {
      QLog.i("Leba2018.LebaFeedsAdapter", 2, "showFooterNoMore");
    }
  }
  
  public void c(LebaFeedsViewBase paramLebaFeedsViewBase, LebaFeedInfo paramLebaFeedInfo, int paramInt)
  {
    if (this.jdField_a_of_type_Adyp != null) {
      this.jdField_a_of_type_Adyp.b(paramLebaFeedInfo);
    }
    LebaUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramLebaFeedInfo, paramInt, "trends_feeds", "feeds_business_clk", 0L);
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_c_of_type_AndroidWidgetTextView.setText("加载失败，请点击重试。");
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.removeFooterView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.addFooterView(this.jdField_a_of_type_AndroidViewView, null, false);
    this.jdField_c_of_type_Int = 4;
    this.jdField_c_of_type_AndroidWidgetTextView.setAlpha(1.0F);
    this.jdField_c_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i("Leba2018.LebaFeedsAdapter", 2, "showFooterClickToRetry");
    }
  }
  
  public void d(LebaFeedsViewBase paramLebaFeedsViewBase, LebaFeedInfo paramLebaFeedInfo, int paramInt)
  {
    if ((this.jdField_b_of_type_Long > 0L) && (this.jdField_b_of_type_Long == paramLebaFeedInfo.feedID))
    {
      this.jdField_b_of_type_Long = -1L;
      this.jdField_a_of_type_AndroidWidgetButton = null;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController.h();
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqLebaViewLebaFPSXListView.removeFooterView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_c_of_type_Int = 1;
    if (QLog.isColorLevel()) {
      QLog.i("Leba2018.LebaFeedsAdapter", 2, "hideFooter");
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Leba2018.LebaFeedsAdapter", 2, "onResume");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController.c();
    }
    m();
    LebaFeedsArkHelper.a().a();
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Leba2018.LebaFeedsAdapter", 2, "onPause");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController.d();
    }
    a(this.jdField_b_of_type_Long, false);
    this.jdField_b_of_type_Long = -1L;
    this.jdField_a_of_type_AndroidWidgetButton = null;
    LebaFeedsArkHelper.a().b();
    q();
  }
  
  public int getCount()
  {
    return this.jdField_b_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    if ((paramInt < 0) || (this.jdField_b_of_type_JavaUtilList == null) || (paramInt >= this.jdField_b_of_type_JavaUtilList.size())) {
      return -1;
    }
    return ((LebaFeedsAdapter.ListItem)this.jdField_b_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_Int;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    paramView = a(paramView, i);
    a(paramView, i, paramInt);
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 7;
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Leba2018.LebaFeedsAdapter", 2, "onStart  mJumpFeedInfo=" + this.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo + ", mAppForeground=" + this.jdField_a_of_type_Boolean);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo != null) && (this.jdField_a_of_type_Boolean))
    {
      long l = System.currentTimeMillis() - this.jdField_a_of_type_Long;
      if (l > 0L)
      {
        LebaUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo, this.jdField_a_of_type_Int, "trends_feeds", "feeds_exit", l);
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
          ((LebaFeedsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(276)).a(this.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo, (int)(l / 1000L));
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqDataLebaFeedInfo = null;
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController.f();
    }
  }
  
  public void i()
  {
    LebaArkReporter.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController.e();
    }
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController.g();
    }
    e();
    LebaFeedsArkHelper.a().d();
    LebaFeedsArkHelper.a().c();
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {}
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Leba2018.LebaFeedsAdapter", 2, "onDestroy unregisterReceiver exception", localException);
    }
  }
  
  public void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController != null) {
      this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController.b();
    }
  }
  
  public void notifyDataSetChanged()
  {
    if (LebaFeedsArkHelper.jdField_a_of_type_Int != 0) {}
    n();
    boolean bool;
    if (this.jdField_b_of_type_JavaUtilList.size() == 0)
    {
      bool = true;
      super.notifyDataSetChanged();
      if (this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController != null) {
        this.jdField_a_of_type_ComTencentMobileqqLebaLebaFeedsVideoPlayController.b(true);
      }
      if (QLog.isColorLevel()) {
        QLog.i("Leba2018.LebaFeedsAdapter", 2, "notifyDataSetChanged mHasMoreFeeds=" + this.jdField_b_of_type_Boolean + ", noData=" + bool);
      }
      if (!bool) {
        break label160;
      }
      e();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Leba2018.LebaFeedsAdapter", 2, "notifyDataSetChanged data size=" + this.jdField_a_of_type_JavaUtilList.size() + ", show size=" + this.jdField_b_of_type_JavaUtilList.size());
      }
      return;
      bool = false;
      break;
      label160:
      if (this.jdField_b_of_type_Boolean) {
        b();
      } else {
        c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.leba.LebaFeedsAdapter
 * JD-Core Version:    0.7.0.1
 */