package com.tencent.mobileqq.troop.troopnotification;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseMessageObserver;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopNotifyApplicantInfo;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.msg.api.IConversationFacade;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.stranger.api.IStrangerService;
import com.tencent.mobileqq.stranger.data.Stranger;
import com.tencent.mobileqq.stranger.observer.StrangerObserver;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.troop.adapter.base.ViewHolder;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.troop.api.IRecommendTroopService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.mobileqq.troop.api.ITroopNotificationService;
import com.tencent.mobileqq.troop.api.ITroopNotificationService.ITroopNotificationLoadDBListener;
import com.tencent.mobileqq.troop.api.ITroopSysMsgDependApiService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.api.observer.TroopNotificationObserver;
import com.tencent.mobileqq.troop.recommend.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogTool;
import com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestActivity;
import com.tencent.mobileqq.troop.troopnotification.adapter.NotifyAndRecAdapter;
import com.tencent.mobileqq.troop.troopnotification.adapter.NotifyAndRecAdapter.ApplicantHolder;
import com.tencent.mobileqq.troop.troopnotification.adapter.NotifyAndRecAdapter.ViewHolder;
import com.tencent.mobileqq.troop.troopnotification.adapter.SuspiciousAdapter;
import com.tencent.mobileqq.troop.troopnotification.adapter.SuspiciousHolder;
import com.tencent.mobileqq.troop.troopnotification.generalgroupnotifyparser.AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo;
import com.tencent.mobileqq.troop.troopnotification.generalgroupnotifyparser.IGeneralGroupNotifyParser;
import com.tencent.mobileqq.troop.troopnotification.generalgroupnotifyparser.IGeneralGroupNotifyParser.GeneralGroupNotifyInfo;
import com.tencent.mobileqq.troop.troopnotification.systemmsginterface.BaseSystemMsgInterfaceForTroop;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopNotificationUtils.TroopPrivilegeCallback;
import com.tencent.mobileqq.troop.troopnotification.utils.TroopSuspiciousHelper;
import com.tencent.mobileqq.troop.util.TroopSystemMsgUtils;
import com.tencent.mobileqq.troop.utils.RecommendTroopUtils;
import com.tencent.mobileqq.troop.utils.TroopNotifyHelper;
import com.tencent.mobileqq.troop.utils.TroopNotifyHelper.OnTroopSafeDialogClickConfirm;
import com.tencent.mobileqq.troop.utils.TroopRemindSettingManager;
import com.tencent.mobileqq.troop.widget.SlideAndOverScrollRecyclerView;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import tencent.mobileim.structmsg.structmsg.GroupInfo;
import tencent.mobileim.structmsg.structmsg.MsgInviteExt;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class TroopNotificationFragment
  extends QPublicBaseFragment
  implements View.OnClickListener, DecodeTaskCompletionListener, BaseSystemMsgInterfaceForTroop, AbsListView.OnScrollListener, Observer
{
  protected static long a;
  public static int g;
  protected int a;
  protected Context a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new TroopNotificationFragment.2(this);
  protected View a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  protected TextView a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  BaseMessageObserver jdField_a_of_type_ComTencentMobileqqAppBaseMessageObserver = new TroopNotificationFragment.9(this);
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  protected IFaceDecoder a;
  protected SosoInterfaceOnLocationListener a;
  StrangerObserver jdField_a_of_type_ComTencentMobileqqStrangerObserverStrangerObserver = new TroopNotificationFragment.32(this);
  ITroopNotificationService.ITroopNotificationLoadDBListener jdField_a_of_type_ComTencentMobileqqTroopApiITroopNotificationService$ITroopNotificationLoadDBListener = new TroopNotificationFragment.7(this);
  TroopMngObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new TroopNotificationFragment.22(this);
  TroopNotificationObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopNotificationObserver = new TroopNotificationFragment.6(this);
  NotifyAndRecAdapter jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter;
  private SuspiciousAdapter jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterSuspiciousAdapter;
  TroopNotificationUtils.TroopPrivilegeCallback jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationUtilsTroopNotificationUtils$TroopPrivilegeCallback = new TroopNotificationFragment.21(this);
  private TroopNotifyHelper.OnTroopSafeDialogClickConfirm jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopNotifyHelper$OnTroopSafeDialogClickConfirm = new TroopNotificationFragment.17(this);
  private SlideAndOverScrollRecyclerView jdField_a_of_type_ComTencentMobileqqTroopWidgetSlideAndOverScrollRecyclerView;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  protected List<MessageRecord> a;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  MqqHandler jdField_a_of_type_MqqOsMqqHandler = new TroopNotificationFragment.5(this);
  protected boolean a;
  protected int b;
  View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new TroopNotificationFragment.3(this);
  private View jdField_b_of_type_AndroidViewView;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  protected TextView b;
  protected List<MessageRecord> b;
  protected boolean b;
  public int c;
  protected View.OnClickListener c;
  private View jdField_c_of_type_AndroidViewView;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  protected List<RecommendTroopItem> c;
  public boolean c;
  public int d;
  protected View.OnClickListener d;
  private View jdField_d_of_type_AndroidViewView;
  private ImageView jdField_d_of_type_AndroidWidgetImageView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  protected List<Stranger> d;
  protected boolean d;
  public int e;
  View.OnClickListener jdField_e_of_type_AndroidViewView$OnClickListener = new TroopNotificationFragment.27(this);
  private View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  protected boolean e;
  public int f;
  protected View.OnClickListener f;
  private View jdField_f_of_type_AndroidViewView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  protected boolean f;
  private View.OnClickListener jdField_g_of_type_AndroidViewView$OnClickListener = new TroopNotificationFragment.4(this);
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  protected boolean g;
  protected int h;
  private boolean h;
  protected int i;
  private boolean i;
  private int jdField_j_of_type_Int;
  private boolean jdField_j_of_type_Boolean = false;
  private int jdField_k_of_type_Int;
  private boolean jdField_k_of_type_Boolean;
  private int l;
  private int m;
  
  public TroopNotificationFragment()
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_d_of_type_JavaUtilList = new ArrayList();
    this.jdField_c_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 2;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_c_of_type_AndroidViewView$OnClickListener = new TroopNotificationFragment.8(this);
    this.jdField_d_of_type_AndroidViewView$OnClickListener = new TroopNotificationFragment.16(this);
    this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_f_of_type_Boolean = false;
    this.jdField_i_of_type_Int = 0;
    this.jdField_f_of_type_AndroidViewView$OnClickListener = new TroopNotificationFragment.29(this);
  }
  
  private void A()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterSuspiciousAdapter = new TroopNotificationFragment.24(this, getActivity(), 2131559902);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterSuspiciousAdapter.a(2131559903);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterSuspiciousAdapter.a(2131561536);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterSuspiciousAdapter.a(new TroopNotificationFragment.25(this));
  }
  
  private void B()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetSlideAndOverScrollRecyclerView = ((SlideAndOverScrollRecyclerView)this.jdField_f_of_type_AndroidViewView.findViewById(2131378138));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetSlideAndOverScrollRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetSlideAndOverScrollRecyclerView.addOnScrollListener(new TroopNotificationFragment.28(this));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetSlideAndOverScrollRecyclerView.setVisibility(8);
  }
  
  private void C()
  {
    this.jdField_j_of_type_Int = GroupSystemMsgController.a().b(this.jdField_a_of_type_MqqAppAppRuntime);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetSlideAndOverScrollRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterSuspiciousAdapter);
    Object localObject = (IMessageFacade)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IMessageFacade.class, "");
    if (localObject != null) {
      this.jdField_b_of_type_JavaUtilList = ((IMessageFacade)localObject).getMsgList(AppConstants.TROOP_SUSPICIOUS_MSG_UIN, 0);
    }
    TroopSuspiciousHelper.a(this.jdField_b_of_type_JavaUtilList, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    localObject = new ArrayList();
    int n = 0;
    while (n < this.jdField_b_of_type_JavaUtilList.size())
    {
      List localList = this.jdField_b_of_type_JavaUtilList;
      ((List)localObject).add(localList.get(localList.size() - n - 1));
      n += 1;
    }
    this.jdField_b_of_type_JavaUtilList = ((List)localObject);
    localObject = this.jdField_b_of_type_JavaUtilList;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      if (this.jdField_e_of_type_AndroidViewView.getVisibility() == 8) {
        ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00899", "Grp_contacts_news", "", "notice", "unnormal_tab_exp", 0, 0, "", "", "", "");
      }
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      if (!(this.jdField_b_of_type_JavaUtilList.get(0) instanceof MessageForSystemMsg))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotificationFragment", 2, "initListData error");
        }
        localObject = (ITroopSysMsgDependApiService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopSysMsgDependApiService.class, "");
        if (localObject != null) {
          ((ITroopSysMsgDependApiService)localObject).clearGroupSystemMsgHistory();
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterSuspiciousAdapter.a(null);
      }
    }
    else
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterSuspiciousAdapter.a(this.jdField_b_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterSuspiciousAdapter.notifyDataSetChanged();
    z();
  }
  
  private void D()
  {
    if (this.jdField_b_of_type_Boolean) {
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      localObject = this.jdField_a_of_type_AndroidContentContext;
      QQToast.a((Context)localObject, ((Context)localObject).getResources().getString(2131720054), 0).b(a());
      return;
    }
    Object localObject = (ITroopNotificationService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopNotificationService.class, "");
    if ((localObject != null) && (((ITroopNotificationService)localObject).isTroopSuspiciousNotificaitonGetAll())) {
      return;
    }
    this.jdField_b_of_type_Boolean = true;
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterSuspiciousAdapter;
    if (localObject != null) {
      ((SuspiciousAdapter)localObject).a(new TroopNotificationFragment.30(this));
    }
    localObject = (IMessageHandler)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IMessageHandler.class, "");
    if (localObject != null) {
      ((IMessageHandler)localObject).sendGetNextGroupSystemMsgForSus();
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotificationFragment", 2, "loadNextPage.get next page.");
    }
  }
  
  private void E()
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotificationFragment", 2, "stopLoadMore().");
    }
    SuspiciousAdapter localSuspiciousAdapter = this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterSuspiciousAdapter;
    if (localSuspiciousAdapter != null) {
      localSuspiciousAdapter.b();
    }
    this.jdField_b_of_type_Boolean = false;
  }
  
  private void F()
  {
    ThreadManager.post(new TroopNotificationFragment.31(this), 8, null, false);
  }
  
  private void G()
  {
    this.jdField_k_of_type_Int = GroupSystemMsgController.a().b(this.jdField_a_of_type_MqqAppAppRuntime);
    MqqHandler localMqqHandler = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(1012);
    }
  }
  
  public static long a(List<MessageRecord> paramList)
  {
    long l2 = 0L;
    long l1 = l2;
    if (paramList != null)
    {
      l1 = l2;
      if (paramList.size() > 0)
      {
        paramList = (MessageRecord)paramList.get(0);
        l1 = l2;
        if ((paramList instanceof MessageForSystemMsg))
        {
          paramList = ((MessageForSystemMsg)paramList).getSystemMsg();
          l1 = l2;
          if (paramList != null)
          {
            l1 = l2;
            if (paramList.msg_seq.has())
            {
              long l3 = paramList.msg_seq.get();
              l1 = l2;
              if (l3 > 0L) {
                l1 = l3;
              }
            }
          }
        }
      }
    }
    return l1;
  }
  
  private AppInterface a()
  {
    AppRuntime localAppRuntime = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
    if ((localAppRuntime instanceof AppInterface)) {
      return (AppInterface)localAppRuntime;
    }
    return null;
  }
  
  public static List<MessageRecord> a(List<MessageRecord> paramList1, List<MessageRecord> paramList2)
  {
    if (paramList1 != null)
    {
      if (paramList2 == null) {
        return paramList1;
      }
      if (a(paramList1) >= a(paramList2))
      {
        paramList1.addAll(paramList2);
        return paramList1;
      }
      paramList2.addAll(paramList1);
      return paramList2;
    }
    return paramList1;
  }
  
  private void a(long paramLong, structmsg.StructMsg paramStructMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("structMsg", paramStructMsg.toByteArray());
    paramStructMsg = (ITroopSysMsgDependApiService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopSysMsgDependApiService.class, "");
    if (paramStructMsg != null) {
      paramStructMsg.followPublicAccountReq(this.jdField_a_of_type_MqqAppAppRuntime, paramLong, new TroopNotificationFragment.18(this), localBundle);
    }
  }
  
  private void a(RecyclerView paramRecyclerView, String paramString, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      int i1 = paramRecyclerView.getChildCount();
      int n = 0;
      while (n < i1)
      {
        Object localObject = paramRecyclerView.findViewHolderForAdapterPosition(n);
        if ((localObject != null) && ((localObject instanceof SuspiciousHolder)))
        {
          SuspiciousHolder localSuspiciousHolder = (SuspiciousHolder)localObject;
          int i2 = TroopNotificationUtils.a(localSuspiciousHolder.jdField_a_of_type_Int);
          if (i2 != 1)
          {
            if (i2 != 2) {
              localObject = String.valueOf(localSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
            } else {
              localObject = localSuspiciousHolder.jdField_a_of_type_JavaLangString;
            }
          }
          else {
            localObject = String.valueOf(localSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
          }
          if ((localSuspiciousHolder.jdField_a_of_type_AndroidWidgetImageView != null) && (paramString.equals(localObject)))
          {
            localSuspiciousHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            return;
          }
        }
        n += 1;
      }
    }
  }
  
  private void a(BusinessObserver paramBusinessObserver)
  {
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if ((localAppInterface != null) && (paramBusinessObserver != null)) {
      localAppInterface.addObserver(paramBusinessObserver);
    }
  }
  
  private void a(TroopNotifyApplicantInfo paramTroopNotifyApplicantInfo, NotifyAndRecAdapter.ApplicantHolder paramApplicantHolder)
  {
    int n = paramTroopNotifyApplicantInfo.b();
    Object localObject = paramTroopNotifyApplicantInfo.c();
    String str1 = paramTroopNotifyApplicantInfo.a();
    String str2 = paramTroopNotifyApplicantInfo.b();
    String str3 = String.valueOf(paramTroopNotifyApplicantInfo.a());
    if (paramTroopNotifyApplicantInfo.c()) {
      paramApplicantHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    } else {
      paramApplicantHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if ((localObject != null) && (!((String)localObject).isEmpty())) {
      paramTroopNotifyApplicantInfo = (TroopNotifyApplicantInfo)localObject;
    } else if ((str2 != null) && (!str2.isEmpty())) {
      paramTroopNotifyApplicantInfo = str2;
    } else if ((str1 != null) && (!str1.isEmpty())) {
      paramTroopNotifyApplicantInfo = str1;
    } else {
      paramTroopNotifyApplicantInfo = "";
    }
    if (!paramTroopNotifyApplicantInfo.isEmpty())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("在");
      ((StringBuilder)localObject).append(paramTroopNotifyApplicantInfo);
      paramTroopNotifyApplicantInfo = ((StringBuilder)localObject).toString();
      if (paramApplicantHolder.jdField_b_of_type_AndroidWidgetTextView != null)
      {
        paramApplicantHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramTroopNotifyApplicantInfo);
        paramApplicantHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
    else if (paramApplicantHolder.jdField_b_of_type_AndroidWidgetTextView != null)
    {
      paramApplicantHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (paramApplicantHolder.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
      if ((!str3.isEmpty()) && ((n == 1) || (n == 2)))
      {
        paramTroopNotifyApplicantInfo = (TextView)paramApplicantHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131373685);
        localObject = (ImageView)paramApplicantHolder.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(2131373684);
        if ((localObject != null) && (paramTroopNotifyApplicantInfo != null))
        {
          if (n == 1)
          {
            ((ImageView)localObject).setImageResource(2130846055);
            paramApplicantHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130842542);
          }
          else if (n == 2)
          {
            ((ImageView)localObject).setImageResource(2130846053);
            paramApplicantHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setBackgroundResource(2130842541);
          }
          paramTroopNotifyApplicantInfo.setText(str3);
          paramApplicantHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
        }
      }
      else
      {
        paramApplicantHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
    }
  }
  
  private void a(ViewHolder paramViewHolder, MessageRecord paramMessageRecord, int paramInt)
  {
    SuspiciousHolder localSuspiciousHolder = (SuspiciousHolder)paramViewHolder;
    if (paramMessageRecord != null)
    {
      if (!(paramMessageRecord instanceof MessageForSystemMsg)) {
        return;
      }
      Object localObject1 = (MessageForSystemMsg)paramMessageRecord;
      localSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = ((MessageForSystemMsg)localObject1).getSystemMsg();
      localSuspiciousHolder.jdField_c_of_type_Long = paramMessageRecord.uniseq;
      int n;
      if (paramMessageRecord != null) {
        n = ((MessageForSystemMsg)localObject1).getSystemMsg().msg_type.get();
      } else {
        n = 2;
      }
      if (n == 2)
      {
        if (paramInt < this.jdField_k_of_type_Int) {
          NotifyAndRecAdapter.a(paramViewHolder.a(), true);
        } else {
          NotifyAndRecAdapter.a(paramViewHolder.a(), false);
        }
        localObject1 = localSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
        localSuspiciousHolder.jdField_a_of_type_Long = paramInt;
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append(((structmsg.StructMsg)localObject1).req_uin.get());
        paramMessageRecord.append("");
        localSuspiciousHolder.jdField_a_of_type_JavaLangString = paramMessageRecord.toString();
        localSuspiciousHolder.jdField_a_of_type_Int = ((structmsg.StructMsg)localObject1).msg.group_msg_type.get();
        paramInt = ((structmsg.StructMsg)localObject1).msg.sub_type.get();
        localSuspiciousHolder.jdField_b_of_type_Long = ((structmsg.StructMsg)localObject1).msg_time.get();
        localSuspiciousHolder.jdField_b_of_type_JavaLangString = ((structmsg.StructMsg)localObject1).msg.req_uin_nick.get();
        if ((localSuspiciousHolder.jdField_b_of_type_JavaLangString == null) || (localSuspiciousHolder.jdField_b_of_type_JavaLangString.equals(""))) {
          localSuspiciousHolder.jdField_b_of_type_JavaLangString = localSuspiciousHolder.jdField_a_of_type_JavaLangString;
        }
        a(localSuspiciousHolder, (structmsg.StructMsg)localObject1);
        localSuspiciousHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        Object localObject2 = ((structmsg.StructMsg)localObject1).msg.group_info.msg_alert.get();
        if (((structmsg.StructMsg)localObject1).msg.bytes_warning_tips.get() != null) {
          paramMessageRecord = ((structmsg.StructMsg)localObject1).msg.bytes_warning_tips.get().toStringUtf8();
        } else {
          paramMessageRecord = "";
        }
        if (TextUtils.isEmpty(paramMessageRecord))
        {
          localSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        else
        {
          localSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          localSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramMessageRecord);
          paramMessageRecord = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130848043);
          paramMessageRecord.setBounds(0, 0, ViewUtils.a(16.0F), ViewUtils.a(16.0F));
          localSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(ViewUtils.a(5.0F));
          localSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setCompoundDrawables(paramMessageRecord, null, null, null);
        }
        Object localObject3;
        if (localSuspiciousHolder.jdField_a_of_type_Int == 22)
        {
          paramMessageRecord = ((structmsg.StructMsg)localObject1).msg;
          localSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          localObject3 = new SpannableString(this.jdField_a_of_type_MqqAppAppRuntime.getApp().getString(2131719414, new Object[] { paramMessageRecord.action_uin_nick.get() }));
          ((SpannableString)localObject3).setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), 6, paramMessageRecord.action_uin_nick.get().length() + 6, 33);
          localSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject3);
          localSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new TroopNotificationFragment.26(this, paramMessageRecord));
        }
        else if ((localSuspiciousHolder.jdField_a_of_type_Int == 2) && (((structmsg.StructMsg)localObject1).msg.msg_invite_extinfo.uint32_src_type.has()))
        {
          n = ((structmsg.StructMsg)localObject1).msg.msg_invite_extinfo.uint32_src_type.get();
          if (n != 0)
          {
            StringBuilder localStringBuilder;
            if (n != 1)
            {
              if (n == 2)
              {
                paramMessageRecord = (IDiscussionService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IDiscussionService.class, "");
                if (paramMessageRecord != null) {
                  paramMessageRecord = paramMessageRecord.getDiscussionName(String.valueOf(((structmsg.StructMsg)localObject1).msg.msg_invite_extinfo.uint64_src_code.get()));
                } else {
                  paramMessageRecord = "";
                }
                localObject3 = localSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView;
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(HardCodeUtil.a(2131707625));
                localStringBuilder.append(paramMessageRecord);
                ((TextView)localObject3).setText(localStringBuilder.toString());
                localSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
              }
            }
            else
            {
              paramMessageRecord = (ITroopInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopInfoService.class, "");
              if (paramMessageRecord != null) {
                paramMessageRecord = paramMessageRecord.getTroopNameByID(String.valueOf(((structmsg.StructMsg)localObject1).msg.msg_invite_extinfo.uint64_src_code.get()));
              } else {
                paramMessageRecord = "";
              }
              localObject3 = localSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(HardCodeUtil.a(2131707636));
              localStringBuilder.append(paramMessageRecord);
              ((TextView)localObject3).setText(localStringBuilder.toString());
              localSuspiciousHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
            }
          }
        }
        a(localSuspiciousHolder.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter$ApplicantHolder, (structmsg.StructMsg)localObject1, true);
        paramMessageRecord = TroopSystemMsgUtils.a((structmsg.StructMsg)localObject1, ((structmsg.StructMsg)localObject1).msg.msg_describe.get());
        if (paramMessageRecord != null)
        {
          localSuspiciousHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord);
        }
        else
        {
          paramMessageRecord = ((structmsg.StructMsg)localObject1).msg.msg_additional.get();
          if ((paramMessageRecord != null) && (!"".equals(paramMessageRecord))) {
            localSuspiciousHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramMessageRecord);
          } else {
            localSuspiciousHolder.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131696190));
          }
        }
        if (localSuspiciousHolder.jdField_a_of_type_Int == 80)
        {
          paramMessageRecord = ((structmsg.StructMsg)localObject1).msg.actions.get();
          localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
          localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramMessageRecord.get(0)).name.get());
          localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755552);
          localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839314);
          paramMessageRecord = localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.getText());
          ((StringBuilder)localObject2).append("");
          paramMessageRecord.setContentDescription(((StringBuilder)localObject2).toString());
          localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setTag(localSuspiciousHolder);
          localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
        }
        for (;;)
        {
          break;
          if (paramInt == 1)
          {
            paramMessageRecord = ((structmsg.StructMsg)localObject1).msg.actions.get();
            localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
            if ((paramMessageRecord != null) && (paramMessageRecord.size() > 0))
            {
              if ((localObject2 != null) && (!"".equals(localObject2)))
              {
                localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramMessageRecord.get(0)).name.get());
                localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755551);
                localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839313);
              }
              else if (paramMessageRecord.size() > 1)
              {
                localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramMessageRecord.get(1)).name.get());
                localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755552);
                localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839314);
              }
              else
              {
                localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setText("");
              }
              paramMessageRecord = localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.getText());
              ((StringBuilder)localObject2).append("");
              paramMessageRecord.setContentDescription(((StringBuilder)localObject2).toString());
              localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramViewHolder);
              localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_f_of_type_AndroidViewView$OnClickListener);
            }
            else
            {
              localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setText("");
              localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
            }
          }
          else
          {
            localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
            localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
            localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131756396);
            localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.StructMsg)localObject1).msg.msg_decided.get());
            paramMessageRecord = (RelativeLayout.LayoutParams)localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
          }
        }
        if (TextUtils.isEmpty(localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.getText())) {
          localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        } else {
          localSuspiciousHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
        }
        if ((paramInt == 2) && (localSuspiciousHolder.jdField_a_of_type_Int == 2))
        {
          paramMessageRecord = (ITroopInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopInfoService.class, "");
          if (paramMessageRecord != null) {
            paramMessageRecord = paramMessageRecord.findTroopInfo(String.valueOf(((structmsg.StructMsg)localObject1).msg.group_code.get()));
          } else {
            paramMessageRecord = null;
          }
          if (paramMessageRecord != null) {
            TroopRemindSettingManager.a().b(String.valueOf(((structmsg.StructMsg)localObject1).msg.group_code.get()), this.jdField_a_of_type_ComTencentCommonAppAppInterface);
          }
        }
        localSuspiciousHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramViewHolder);
        localSuspiciousHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(paramViewHolder);
        localSuspiciousHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this.jdField_e_of_type_AndroidViewView$OnClickListener);
        a(localSuspiciousHolder);
      }
    }
  }
  
  private void a(NotifyAndRecAdapter.ApplicantHolder paramApplicantHolder, structmsg.StructMsg paramStructMsg, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_MqqAppAppRuntime != null) && (paramApplicantHolder != null) && (paramStructMsg != null))
    {
      if (paramApplicantHolder.jdField_a_of_type_AndroidViewView == null) {
        return;
      }
      ITroopNotificationService localITroopNotificationService = (ITroopNotificationService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopNotificationService.class, "");
      if (localITroopNotificationService == null) {
        return;
      }
      int n = paramStructMsg.msg.group_msg_type.get();
      if ((!TroopNotifyHelper.b(n)) && (!paramBoolean)) {
        return;
      }
      long l1;
      if (n == 2)
      {
        if (paramStructMsg.msg.has()) {
          l1 = paramStructMsg.msg.action_uin.get();
        } else {
          l1 = 0L;
        }
      }
      else {
        l1 = paramStructMsg.req_uin.get();
      }
      if (l1 <= 0L) {
        return;
      }
      paramStructMsg = localITroopNotificationService.getApplicantInfo(Long.valueOf(l1));
      if (paramStructMsg == null)
      {
        localITroopNotificationService.addLackApplicantInfoUinToCacheBy0x5eb(Long.valueOf(l1));
        localITroopNotificationService.addLackApplicantInfoUinToCacheBy0x668(Long.valueOf(l1));
        if (!this.jdField_j_of_type_Boolean)
        {
          paramApplicantHolder = new Message();
          paramApplicantHolder.what = 1016;
          this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramApplicantHolder, 2000L);
          this.jdField_j_of_type_Boolean = true;
        }
        return;
      }
      paramApplicantHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
      if (paramStructMsg.a())
      {
        a(paramStructMsg, paramApplicantHolder);
        n = 0;
      }
      else
      {
        localITroopNotificationService.addLackApplicantInfoUinToCacheBy0x5eb(Long.valueOf(l1));
        if (paramApplicantHolder.jdField_b_of_type_AndroidWidgetTextView != null) {
          paramApplicantHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        if (paramApplicantHolder.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
          paramApplicantHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
        }
        n = 1;
      }
      int i1;
      if (paramStructMsg.b())
      {
        i1 = paramStructMsg.c();
        paramStructMsg = new StringBuilder();
        paramStructMsg.append("LV");
        paramStructMsg.append(String.valueOf(i1));
        paramStructMsg = paramStructMsg.toString();
        i1 = n;
        if (paramApplicantHolder.jdField_a_of_type_AndroidWidgetTextView != null)
        {
          paramApplicantHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg);
          paramApplicantHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
          i1 = n;
        }
      }
      else
      {
        localITroopNotificationService.addLackApplicantInfoUinToCacheBy0x668(Long.valueOf(l1));
        if (paramApplicantHolder.jdField_a_of_type_AndroidWidgetTextView != null) {
          paramApplicantHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        i1 = 1;
      }
      if ((!this.jdField_j_of_type_Boolean) && (i1 != 0))
      {
        paramApplicantHolder = new Message();
        paramApplicantHolder.what = 1016;
        this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed(paramApplicantHolder, 2000L);
        this.jdField_j_of_type_Boolean = true;
      }
    }
  }
  
  private void a(NotifyAndRecAdapter.ViewHolder paramViewHolder, structmsg.StructMsg paramStructMsg)
  {
    String str = TroopSystemMsgUtils.a(paramStructMsg, paramStructMsg.msg.msg_describe.get());
    if (paramViewHolder.jdField_a_of_type_Int == 91)
    {
      b(paramViewHolder);
      return;
    }
    if (str != null)
    {
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(str);
      return;
    }
    paramStructMsg = paramStructMsg.msg.msg_additional.get();
    if ((paramStructMsg != null) && (!"".equals(paramStructMsg)))
    {
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramStructMsg);
      return;
    }
    paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131696190));
  }
  
  private void a(NotifyAndRecAdapter.ViewHolder paramViewHolder, structmsg.StructMsg paramStructMsg, int paramInt)
  {
    if (!(paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationGeneralgroupnotifyparserIGeneralGroupNotifyParser$GeneralGroupNotifyInfo instanceof AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo))
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
    }
    Object localObject = (AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationGeneralgroupnotifyparserIGeneralGroupNotifyParser$GeneralGroupNotifyInfo;
    if (((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_c_of_type_Int == 1)
    {
      int n = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_a_of_type_Int;
      paramStructMsg = "";
      if ((n == 1) && (paramInt == 1))
      {
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755552);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839314);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(this.jdField_a_of_type_AndroidContentContext.getString(2131699529));
        paramStructMsg = paramViewHolder.jdField_a_of_type_AndroidWidgetButton;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getText());
        ((StringBuilder)localObject).append("");
        paramStructMsg.setContentDescription(((StringBuilder)localObject).toString());
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramViewHolder);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      }
      else
      {
        if (paramInt == 2) {
          paramStructMsg = this.jdField_a_of_type_AndroidContentContext.getString(2131699526);
        } else if (paramInt == 3) {
          paramStructMsg = this.jdField_a_of_type_AndroidContentContext.getString(2131699528);
        } else if (paramInt == 4) {
          paramStructMsg = this.jdField_a_of_type_AndroidContentContext.getString(2131699527);
        }
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131756396);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
      }
    }
    else if (((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_c_of_type_Int == 2)
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131756396);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg.msg.msg_decided.get());
    }
    else
    {
      paramStructMsg = new StringBuilder();
      paramStructMsg.append("setSecondLineText reqSubMsgType:");
      paramStructMsg.append(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_c_of_type_Int);
      QLog.d("TroopNotificationFragment", 2, paramStructMsg.toString());
    }
    paramStructMsg = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
    if (paramStructMsg != null)
    {
      paramStructMsg.addRule(11);
      paramStructMsg.rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 16.0F);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setLayoutParams(paramStructMsg);
    }
    paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
  }
  
  private void a(NotifyAndRecAdapter.ViewHolder paramViewHolder, structmsg.StructMsg paramStructMsg, int paramInt, String paramString)
  {
    if (paramViewHolder.jdField_a_of_type_Int == 91)
    {
      a(paramViewHolder, paramStructMsg, paramInt);
      return;
    }
    if (paramViewHolder.jdField_a_of_type_Int == 80)
    {
      paramStructMsg = paramStructMsg.msg.actions.get();
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramStructMsg.get(0)).name.get());
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755552);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839314);
      paramStructMsg = paramViewHolder.jdField_a_of_type_AndroidWidgetButton;
      paramString = new StringBuilder();
      paramString.append(paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getText());
      paramString.append("");
      paramStructMsg.setContentDescription(paramString.toString());
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramViewHolder);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
    }
    else
    {
      if (paramInt != 1) {
        break label490;
      }
      paramStructMsg = paramStructMsg.msg.actions.get();
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(true);
      if ((paramStructMsg != null) && (paramStructMsg.size() > 0))
      {
        if ((paramString != null) && (!"".equals(paramString)))
        {
          paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramStructMsg.get(0)).name.get());
          paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755551);
          paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839313);
        }
        else if (paramStructMsg.size() > 1)
        {
          paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(((structmsg.SystemMsgAction)paramStructMsg.get(1)).name.get());
          paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131755552);
          paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130839314);
        }
        else
        {
          paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText("");
        }
        paramStructMsg = paramViewHolder.jdField_a_of_type_AndroidWidgetButton;
        paramString = new StringBuilder();
        paramString.append(paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getText());
        paramString.append("");
        paramStructMsg.setContentDescription(paramString.toString());
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramViewHolder);
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_d_of_type_AndroidViewView$OnClickListener);
      }
      else
      {
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText("");
        paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
      }
    }
    paramStructMsg = (RelativeLayout.LayoutParams)paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
    if (paramStructMsg != null)
    {
      paramStructMsg.addRule(11);
      paramStructMsg.rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 16.0F);
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setLayoutParams(paramStructMsg);
    }
    if (TextUtils.isEmpty(paramViewHolder.jdField_a_of_type_AndroidWidgetButton.getText()))
    {
      paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      return;
    }
    paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    return;
    label490:
    paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setBackgroundDrawable(null);
    paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setClickable(false);
    paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131756396);
    paramViewHolder.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg.msg.msg_decided.get());
  }
  
  private void a(NotifyAndRecAdapter.ViewHolder paramViewHolder, structmsg.StructMsg paramStructMsg, String paramString)
  {
    if (paramViewHolder.jdField_a_of_type_Int == 91)
    {
      c(paramViewHolder);
      return;
    }
    int n = paramViewHolder.jdField_a_of_type_Int;
    String str = "";
    if (n == 11)
    {
      localObject = paramStructMsg.msg.msg_additional.get();
      paramString = (String)localObject;
      if (((String)localObject).length() > 15)
      {
        paramString = new StringBuilder();
        paramString.append(((String)localObject).subSequence(0, 15));
        paramString.append("...");
        paramString = paramString.toString();
      }
    }
    else if ((!TextUtils.isEmpty(paramString)) && ((paramViewHolder.jdField_a_of_type_Int == 1) || (paramViewHolder.jdField_a_of_type_Int == 22)))
    {
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setTextAppearance(this.jdField_a_of_type_AndroidContentContext, 2131756397);
    }
    else
    {
      localObject = new ArrayList();
      ((List)localObject).add(paramStructMsg.msg.msg_qna.get());
      if (paramStructMsg.msg.msg_actor_describe.get() != null) {
        paramString = TroopSystemMsgUtils.a(paramStructMsg, paramStructMsg.msg.msg_actor_describe.get());
      } else {
        paramString = "";
      }
      ((List)localObject).add(paramString);
      ((List)localObject).add(paramStructMsg.msg.msg_additional_list.get());
      ((List)localObject).add(paramStructMsg.msg.msg_additional.get());
      if ((paramViewHolder.jdField_a_of_type_Int == 12) || (paramViewHolder.jdField_a_of_type_Int == 83)) {
        ((List)localObject).add(paramStructMsg.msg.msg_detail.get());
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramString = (String)((Iterator)localObject).next();
        if ((paramString != null) && (!paramString.isEmpty())) {
          break label324;
        }
      }
      paramString = "";
    }
    label324:
    Object localObject = paramString;
    if (paramStructMsg.msg.pic_url.has()) {
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131715466));
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = HardCodeUtil.a(2131715467);
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setSingleLine(true);
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else
    {
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (paramViewHolder.jdField_a_of_type_Int == 22)
    {
      paramStructMsg = paramStructMsg.msg;
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      paramString = new SpannableString(this.jdField_a_of_type_MqqAppAppRuntime.getApp().getString(2131719414, new Object[] { paramStructMsg.action_uin_nick.get() }));
      paramString.setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), 5, paramStructMsg.action_uin_nick.get().length() + 6, 33);
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText(paramString);
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(new TroopNotificationFragment.15(this, paramStructMsg));
      return;
    }
    if ((paramViewHolder.jdField_a_of_type_Int == 2) && (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      n = paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get();
      if (n != 0)
      {
        if (n != 1)
        {
          if (n != 2) {
            return;
          }
          paramString = (IDiscussionService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IDiscussionService.class, "");
          if (paramString != null) {
            str = paramString.getDiscussionName(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
          }
          paramStructMsg = paramViewHolder.jdField_c_of_type_AndroidWidgetTextView;
          paramString = new StringBuilder();
          paramString.append(HardCodeUtil.a(2131715468));
          paramString.append(str);
          paramStructMsg.setText(paramString.toString());
          paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
          return;
        }
        paramString = (ITroopInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopInfoService.class, "");
        if (paramString != null) {
          str = paramString.getTroopNameByID(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
        }
        paramStructMsg = paramViewHolder.jdField_c_of_type_AndroidWidgetTextView;
        paramString = new StringBuilder();
        paramString.append(HardCodeUtil.a(2131715470));
        paramString.append(str);
        paramStructMsg.setText(paramString.toString());
        paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      }
    }
  }
  
  private void a(SuspiciousHolder paramSuspiciousHolder)
  {
    if (paramSuspiciousHolder == null) {
      return;
    }
    int i1 = TroopNotificationUtils.a(paramSuspiciousHolder.jdField_a_of_type_Int);
    int n = 1;
    Object localObject2;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        localObject1 = String.valueOf(paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
        n = 4;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get());
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_AndroidContentContext.getString(2131696518));
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject1 = paramSuspiciousHolder.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get());
        ((StringBuilder)localObject2).append(this.jdField_a_of_type_AndroidContentContext.getString(2131696517));
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    else
    {
      localObject1 = String.valueOf(paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get());
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_AndroidContentContext.getString(2131696516));
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    Object localObject1 = TroopNotificationUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder, (String)localObject1, n);
    paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject2);
    paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject1);
  }
  
  private void a(SuspiciousHolder paramSuspiciousHolder, structmsg.StructMsg paramStructMsg)
  {
    if (paramSuspiciousHolder != null)
    {
      if (paramStructMsg == null) {
        return;
      }
      if ((paramSuspiciousHolder.jdField_a_of_type_Int == 2) && (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
      {
        Object localObject2 = paramStructMsg.msg.action_uin_qq_nick.get().toStringUtf8();
        n = paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get();
        Object localObject1;
        if (n != 0)
        {
          Object localObject3;
          if (n != 1)
          {
            if (n != 2)
            {
              localObject1 = localObject2;
            }
            else
            {
              localObject3 = (IDiscussionService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IDiscussionService.class, "");
              localObject1 = localObject2;
              if (localObject3 != null) {
                localObject1 = ((IDiscussionService)localObject3).getDiscussionMemberName(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(paramStructMsg.msg.action_uin.get()));
              }
            }
          }
          else
          {
            Object localObject4 = (ITroopInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopInfoService.class, "");
            localObject1 = localObject2;
            if (localObject4 != null)
            {
              localObject3 = String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get());
              String str = String.valueOf(paramStructMsg.msg.action_uin.get());
              localObject1 = ((ITroopInfoService)localObject4).getTroopCodeByTroopUin((String)localObject3);
              localObject4 = (ITroopSysMsgDependApiService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopSysMsgDependApiService.class, "");
              paramStructMsg = (structmsg.StructMsg)localObject2;
              if (localObject4 != null) {
                paramStructMsg = ((ITroopSysMsgDependApiService)localObject4).getTroopNickName(str, (String)localObject3, (String)localObject1, true, null);
              }
              localObject1 = paramStructMsg;
              if (TextUtils.isEmpty(paramStructMsg))
              {
                localObject2 = (ITroopMemberNameService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopMemberNameService.class, "");
                localObject1 = paramStructMsg;
                if (localObject2 != null) {
                  localObject1 = ((ITroopMemberNameService)localObject2).getTroopMemberName((String)localObject3, str);
                }
              }
            }
          }
        }
        else
        {
          localObject1 = paramStructMsg.msg.action_uin_nick.get();
        }
        paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        return;
      }
      int n = TroopNotificationUtils.a(paramSuspiciousHolder.jdField_a_of_type_Int);
      if (n != 0)
      {
        if (n != 1)
        {
          if (n != 2)
          {
            paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramSuspiciousHolder.jdField_b_of_type_JavaLangString);
            return;
          }
          paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramSuspiciousHolder.jdField_b_of_type_JavaLangString);
          return;
        }
        paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.action_uin_nick.get());
        return;
      }
      paramSuspiciousHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.group_name.get());
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get());
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(((structmsg.StructMsg)paramStructMsg.get()).msg_type.get());
      localObject = ((StringBuilder)localObject).toString();
      GroupSystemMsgController.a().a((String)localObject, (structmsg.StructMsg)paramStructMsg.get());
      GroupSystemMsgController.a().b((String)localObject);
      GroupSystemMsgController.a().a(paramLong);
    }
  }
  
  private void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4)
  {
    ThreadManager.getUIHandler().post(new TroopNotificationFragment.10(this, paramString1, paramBoolean, paramString3, paramInt3, paramString2, paramString4, paramInt1, paramInt2));
  }
  
  private void a(boolean paramBoolean, List<MessageRecord> paramList)
  {
    try
    {
      ThreadManager.getUIHandler().post(new TroopNotificationFragment.11(this, paramBoolean, paramList));
      return;
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, List<MessageRecord> paramList)
  {
    try
    {
      ThreadManager.getUIHandler().post(new TroopNotificationFragment.12(this, paramBoolean1, paramBoolean2, paramList));
      return;
    }
    catch (Exception paramList)
    {
      paramList.printStackTrace();
      QLog.d("TroopNotificationFragment", 1, "onGetSuspiciousSystemMsgFin failed", paramList);
    }
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt != 2) && (paramInt != 3);
  }
  
  private boolean a(int paramInt, structmsg.StructMsg paramStructMsg)
  {
    boolean bool2;
    if (paramStructMsg != null)
    {
      int n = paramStructMsg.msg_type.get();
      long l1 = paramStructMsg.msg_seq.get();
      long l2 = paramStructMsg.req_uin.get();
      int i1 = paramStructMsg.msg.sub_type.get();
      int i2 = paramStructMsg.msg.src_id.get();
      int i3 = paramStructMsg.msg.sub_src_id.get();
      int i4 = paramStructMsg.msg.group_msg_type.get();
      Object localObject = paramStructMsg.msg.actions.get();
      IMessageHandler localIMessageHandler;
      boolean bool1;
      if ((localObject != null) && (paramInt < ((List)localObject).size()))
      {
        localIMessageHandler = (IMessageHandler)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IMessageHandler.class, "");
        if (localIMessageHandler != null) {
          localIMessageHandler.sendGroupSystemMsgAction(n, l1, l2, i1, i2, i3, i4, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(paramInt)).action_info.get(), paramInt);
        }
        bool1 = true;
      }
      else
      {
        localObject = new structmsg.SystemMsgActionInfo();
        if (paramInt == 0) {
          ((structmsg.SystemMsgActionInfo)localObject).type.set(11);
        } else if (paramInt == 1) {
          ((structmsg.SystemMsgActionInfo)localObject).type.set(12);
        } else if (paramInt == 2) {
          ((structmsg.SystemMsgActionInfo)localObject).type.set(14);
        }
        ((structmsg.SystemMsgActionInfo)localObject).group_code.set(paramStructMsg.msg.group_code.get());
        ((structmsg.SystemMsgActionInfo)localObject).sig.set(ByteStringMicro.EMPTY);
        localIMessageHandler = (IMessageHandler)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IMessageHandler.class, "");
        if (localIMessageHandler != null) {
          localIMessageHandler.sendGroupSystemMsgAction(n, l1, l2, i1, i2, i3, i4, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgActionInfo)localObject).get(), paramInt);
        }
        bool1 = false;
      }
      bool2 = bool1;
      if (i2 == 116)
      {
        bool2 = bool1;
        if (i3 == 0)
        {
          ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "P_CliOper", "Grp_discuss", "", "verify_msg", "Clk_agree", 0, 0, String.valueOf(paramStructMsg.msg.group_code.get()), "", "", "");
          return bool1;
        }
      }
    }
    else
    {
      bool2 = false;
    }
    return bool2;
  }
  
  private boolean a(List<Stranger> paramList, String paramString)
  {
    if (paramList != null)
    {
      paramList = paramList.iterator();
      do
      {
        if (!paramList.hasNext()) {
          break;
        }
      } while (!TextUtils.equals(((Stranger)paramList.next()).uin, paramString));
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationFragment", 2, "checkInviteeIsFriend stranger list is empty ");
    }
    return false;
  }
  
  private void b(BusinessObserver paramBusinessObserver)
  {
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    if ((localAppInterface != null) && (paramBusinessObserver != null)) {
      localAppInterface.removeObserver(paramBusinessObserver);
    }
  }
  
  private void b(NotifyAndRecAdapter.ViewHolder paramViewHolder)
  {
    if (!(paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationGeneralgroupnotifyparserIGeneralGroupNotifyParser$GeneralGroupNotifyInfo instanceof AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo))
    {
      paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    Object localObject = (AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationGeneralgroupnotifyparserIGeneralGroupNotifyParser$GeneralGroupNotifyInfo;
    StringBuilder localStringBuilder;
    if (((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_c_of_type_Int == 1)
    {
      localObject = paramViewHolder.jdField_b_of_type_AndroidWidgetTextView;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getString(2131699524));
      localStringBuilder.append(" ");
      localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getString(2131699522));
      ((TextView)localObject).setText(localStringBuilder.toString());
    }
    else if (((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_c_of_type_Int == 2)
    {
      if (((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_a_of_type_Int == 2)
      {
        localObject = paramViewHolder.jdField_b_of_type_AndroidWidgetTextView;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getString(2131699531));
        localStringBuilder.append(" ");
        localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getString(2131699521));
        ((TextView)localObject).setText(localStringBuilder.toString());
      }
      else if (((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).jdField_a_of_type_Int == 3)
      {
        localObject = paramViewHolder.jdField_b_of_type_AndroidWidgetTextView;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getString(2131699533));
        localStringBuilder.append(" ");
        localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext.getString(2131699521));
        ((TextView)localObject).setText(localStringBuilder.toString());
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setSecondLineText reqSubMsgType:");
      ((StringBuilder)localObject).append(paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationGeneralgroupnotifyparserIGeneralGroupNotifyParser$GeneralGroupNotifyInfo.jdField_c_of_type_Int);
      QLog.d("TroopNotificationFragment", 2, ((StringBuilder)localObject).toString());
    }
    paramViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  private void b(NotifyAndRecAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jumpToTroopRequestActivity!");
      ((StringBuilder)localObject).append(paramViewHolder.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append(": dealMsgType = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("TroopNotificationFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", paramViewHolder.jdField_a_of_type_Long);
    localBundle.putInt("mTroopMsgType", paramViewHolder.jdField_a_of_type_Int);
    localBundle.putString("mTroopCode", String.valueOf(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
    localBundle.putString("troopsMsg", paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    boolean bool;
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter != null) && (paramViewHolder.jdField_b_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.jdField_a_of_type_Int)) {
      bool = true;
    } else {
      bool = false;
    }
    localBundle.putBoolean("is_unread", bool);
    localBundle.putString("troopRequestUin", String.valueOf(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
    localBundle.putString("troopsummary", paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
    localBundle.putLong("infotime", paramViewHolder.jdField_b_of_type_Long);
    localBundle.putInt("troopfromtab", this.jdField_b_of_type_Int);
    long l1 = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get();
    localBundle.putBoolean("troop_invitee_is_friend", a(this.jdField_d_of_type_JavaUtilList, String.valueOf(l1)));
    if (paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 83) {
      ((Intent)localObject).putExtra("troopMsgDealInfo", paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
    }
    a((structmsg.StructMsg)paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramViewHolder.jdField_c_of_type_Long);
    localBundle.putInt("t_s_f", 1001);
    ((Intent)localObject).putExtras(localBundle);
    startActivity((Intent)localObject);
  }
  
  private void b(NotifyAndRecAdapter.ViewHolder paramViewHolder, structmsg.StructMsg paramStructMsg)
  {
    if (paramViewHolder != null)
    {
      if (paramStructMsg == null) {
        return;
      }
      if ((paramViewHolder.jdField_a_of_type_Int == 91) && ((paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationGeneralgroupnotifyparserIGeneralGroupNotifyParser$GeneralGroupNotifyInfo instanceof AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)))
      {
        paramStructMsg = (AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationGeneralgroupnotifyparserIGeneralGroupNotifyParser$GeneralGroupNotifyInfo;
        if (!TextUtils.isEmpty(paramStructMsg.jdField_c_of_type_JavaLangString))
        {
          paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.jdField_c_of_type_JavaLangString);
          return;
        }
        if (paramStructMsg.jdField_c_of_type_Long > 0L)
        {
          paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(paramStructMsg.jdField_c_of_type_Long));
          return;
        }
        paramStructMsg = new StringBuilder();
        paramStructMsg.append("setFirstLineText ");
        paramStructMsg.append(paramViewHolder.jdField_a_of_type_Int);
        paramStructMsg.append("reqTroopName and reqTroopCode is null");
        QLog.d("TroopNotificationFragment", 2, paramStructMsg.toString());
        return;
      }
      if ((paramViewHolder.jdField_a_of_type_Int == 2) && (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
      {
        Object localObject2 = paramStructMsg.msg.action_uin_qq_nick.get().toStringUtf8();
        n = paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get();
        Object localObject1;
        if (n != 0)
        {
          Object localObject3;
          if (n != 1)
          {
            if (n != 2)
            {
              localObject1 = localObject2;
            }
            else
            {
              localObject3 = (IDiscussionService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IDiscussionService.class, "");
              localObject1 = localObject2;
              if (localObject3 != null) {
                localObject1 = ((IDiscussionService)localObject3).getDiscussionMemberName(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(paramStructMsg.msg.action_uin.get()));
              }
            }
          }
          else
          {
            Object localObject4 = (ITroopInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopInfoService.class, "");
            localObject1 = localObject2;
            if (localObject4 != null)
            {
              localObject3 = String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get());
              String str = String.valueOf(paramStructMsg.msg.action_uin.get());
              localObject1 = ((ITroopInfoService)localObject4).getTroopCodeByTroopUin((String)localObject3);
              localObject4 = (ITroopSysMsgDependApiService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopSysMsgDependApiService.class, "");
              paramStructMsg = (structmsg.StructMsg)localObject2;
              if (localObject4 != null) {
                paramStructMsg = ((ITroopSysMsgDependApiService)localObject4).getTroopNickName(str, (String)localObject3, (String)localObject1, true, null);
              }
              localObject1 = paramStructMsg;
              if (TextUtils.isEmpty(paramStructMsg))
              {
                localObject2 = (ITroopMemberNameService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopMemberNameService.class, "");
                localObject1 = paramStructMsg;
                if (localObject2 != null) {
                  localObject1 = ((ITroopMemberNameService)localObject2).getTroopMemberName((String)localObject3, str);
                }
              }
            }
          }
        }
        else
        {
          localObject1 = paramStructMsg.msg.action_uin_nick.get();
        }
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        return;
      }
      int n = TroopNotificationUtils.a(paramViewHolder.jdField_a_of_type_Int);
      if (n != 0)
      {
        if (n != 1)
        {
          if (n != 2)
          {
            paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewHolder.jdField_b_of_type_JavaLangString);
            return;
          }
          paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewHolder.jdField_b_of_type_JavaLangString);
          return;
        }
        paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.action_uin_nick.get());
        return;
      }
      paramViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramStructMsg.msg.group_name.get());
    }
  }
  
  private void b(SuspiciousHolder paramSuspiciousHolder)
  {
    if (paramSuspiciousHolder == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jumpToTroopRequestActivity!");
      ((StringBuilder)localObject).append(paramSuspiciousHolder.jdField_a_of_type_Long);
      QLog.d("TroopNotificationFragment", 2, ((StringBuilder)localObject).toString());
    }
    TroopSuspiciousHelper.a(paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, "unnormal_edit");
    Object localObject = new Intent(getActivity(), TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", paramSuspiciousHolder.jdField_a_of_type_Long);
    localBundle.putInt("mTroopMsgType", paramSuspiciousHolder.jdField_a_of_type_Int);
    localBundle.putString("mTroopCode", String.valueOf(paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get()));
    localBundle.putString("troopsMsg", paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    int n = GroupSystemMsgController.a().a(this.jdField_a_of_type_MqqAppAppRuntime);
    boolean bool;
    if (paramSuspiciousHolder.jdField_b_of_type_Int < n) {
      bool = true;
    } else {
      bool = false;
    }
    localBundle.putBoolean("is_unread", bool);
    localBundle.putString("troopRequestUin", String.valueOf(paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
    localBundle.putString("troopsummary", paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
    localBundle.putLong("infotime", paramSuspiciousHolder.jdField_b_of_type_Long);
    long l1 = paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get();
    localBundle.putBoolean("troop_invitee_is_friend", a(this.jdField_d_of_type_JavaUtilList, String.valueOf(l1)));
    if (paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_msg_type.get() != 83) {
      ((Intent)localObject).putExtra("troopMsgDealInfo", paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
    }
    TroopSuspiciousHelper.a((structmsg.StructMsg)paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get());
    a((structmsg.StructMsg)paramSuspiciousHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramSuspiciousHolder.jdField_c_of_type_Long);
    localBundle.putInt("t_s_f", 1001);
    localBundle.putBoolean("troop_suspicious_request", true);
    ((Intent)localObject).putExtras(localBundle);
    startActivity((Intent)localObject);
  }
  
  private boolean b(int paramInt, structmsg.StructMsg paramStructMsg)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramStructMsg != null)
    {
      int n = paramStructMsg.msg_type.get();
      long l1 = paramStructMsg.msg_seq.get();
      long l2 = paramStructMsg.req_uin.get();
      int i1 = paramStructMsg.msg.sub_type.get();
      int i2 = paramStructMsg.msg.src_id.get();
      int i3 = paramStructMsg.msg.sub_src_id.get();
      int i4 = paramStructMsg.msg.group_msg_type.get();
      Object localObject = paramStructMsg.msg.actions.get();
      if ((localObject != null) && (paramInt < ((List)localObject).size()))
      {
        localObject = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(paramInt)).action_info.get();
        ((structmsg.SystemMsgActionInfo)localObject).uint32_req_msg_type.set(2);
        IMessageHandler localIMessageHandler = (IMessageHandler)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IMessageHandler.class, "");
        if (localIMessageHandler != null) {
          localIMessageHandler.sendGroupSystemMsgAction(n, l1, l2, i1, i2, i3, i4, (structmsg.SystemMsgActionInfo)localObject, paramInt);
        }
        bool1 = true;
      }
      bool2 = bool1;
      if (i2 == 116)
      {
        bool2 = bool1;
        if (i3 == 0)
        {
          ReportController.b(null, "P_CliOper", "Grp_discuss", "", "verify_msg", "Clk_agree", 0, 0, String.valueOf(paramStructMsg.msg.group_code.get()), "", "", "");
          return bool1;
        }
      }
    }
    return bool2;
  }
  
  private void c(NotifyAndRecAdapter.ViewHolder paramViewHolder)
  {
    if (!(paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationGeneralgroupnotifyparserIGeneralGroupNotifyParser$GeneralGroupNotifyInfo instanceof AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo))
    {
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    Object localObject3 = (AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationGeneralgroupnotifyparserIGeneralGroupNotifyParser$GeneralGroupNotifyInfo;
    int n = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject3).jdField_c_of_type_Int;
    Object localObject2 = "";
    Object localObject1;
    if (n == 1)
    {
      if (!TextUtils.isEmpty(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject3).jdField_d_of_type_JavaLangString))
      {
        localObject1 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject3).jdField_d_of_type_JavaLangString;
      }
      else if (((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject3).jdField_d_of_type_Long > 0L)
      {
        localObject1 = String.valueOf(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject3).jdField_d_of_type_Long);
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("setThirdLine ");
        ((StringBuilder)localObject1).append(paramViewHolder.jdField_a_of_type_Int);
        ((StringBuilder)localObject1).append("reqTroopOwnerNickName is Empty");
        QLog.d("TroopNotificationFragment", 2, ((StringBuilder)localObject1).toString());
        localObject1 = "";
      }
      if (!TextUtils.isEmpty(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject3).jdField_e_of_type_JavaLangString))
      {
        localObject2 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject3).jdField_e_of_type_JavaLangString;
      }
      else if (((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject3).jdField_e_of_type_Long > 0L)
      {
        localObject2 = String.valueOf(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject3).jdField_e_of_type_Long);
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("setThirdLine ");
        ((StringBuilder)localObject3).append(paramViewHolder.jdField_a_of_type_Int);
        ((StringBuilder)localObject3).append("reqSourceTroopName is Empty");
        QLog.d("TroopNotificationFragment", 2, ((StringBuilder)localObject3).toString());
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_AndroidContentContext.getString(2131699523));
      ((StringBuilder)localObject3).append(" ");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_AndroidContentContext.getString(2131699520));
      ((StringBuilder)localObject3).append((String)localObject2);
      localObject1 = ((StringBuilder)localObject3).toString();
      paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
    }
    else if (paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationGeneralgroupnotifyparserIGeneralGroupNotifyParser$GeneralGroupNotifyInfo.jdField_c_of_type_Int == 2)
    {
      if (!TextUtils.isEmpty(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject3).jdField_b_of_type_JavaLangString))
      {
        localObject1 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject3).jdField_b_of_type_JavaLangString;
      }
      else if (((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject3).jdField_b_of_type_Long > 0L)
      {
        localObject1 = String.valueOf(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject3).jdField_b_of_type_Long);
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("setThirdLine ");
        ((StringBuilder)localObject1).append(paramViewHolder.jdField_a_of_type_Int);
        ((StringBuilder)localObject1).append("actionName is Empty");
        QLog.d("TroopNotificationFragment", 2, ((StringBuilder)localObject1).toString());
        localObject1 = localObject2;
      }
      localObject2 = paramViewHolder.jdField_c_of_type_AndroidWidgetTextView;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_AndroidContentContext.getString(2131699517));
      ((StringBuilder)localObject3).append(" ");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setThirdLine ");
      ((StringBuilder)localObject1).append(paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationGeneralgroupnotifyparserIGeneralGroupNotifyParser$GeneralGroupNotifyInfo.jdField_c_of_type_Int);
      ((StringBuilder)localObject1).append("reqSubMsgType is error value");
      QLog.d("TroopNotificationFragment", 2, ((StringBuilder)localObject1).toString());
    }
    paramViewHolder.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  private void d(NotifyAndRecAdapter.ViewHolder paramViewHolder)
  {
    if (paramViewHolder == null) {
      return;
    }
    int n = TroopNotificationUtils.a(paramViewHolder.jdField_a_of_type_Int);
    if (paramViewHolder.jdField_a_of_type_Int == 91) {
      n = 3;
    }
    Object localObject1;
    if (n != 1)
    {
      if (n != 2)
      {
        if (n != 3)
        {
          localObject2 = String.valueOf(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_name.get());
          ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getString(2131696518));
        }
        for (localObject1 = ((StringBuilder)localObject1).toString();; localObject1 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject1).jdField_c_of_type_JavaLangString)
        {
          n = 4;
          break label274;
          if (!(paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationGeneralgroupnotifyparserIGeneralGroupNotifyParser$GeneralGroupNotifyInfo instanceof AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)) {
            break;
          }
          localObject1 = (AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationGeneralgroupnotifyparserIGeneralGroupNotifyParser$GeneralGroupNotifyInfo;
          localObject2 = String.valueOf(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject1).jdField_c_of_type_Long);
        }
        localObject1 = null;
        localObject2 = localObject1;
        n = -1;
        break label274;
      }
      localObject2 = paramViewHolder.jdField_a_of_type_JavaLangString;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get());
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getString(2131696517));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject2 = String.valueOf(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin_nick.get());
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_AndroidContentContext.getString(2131696516));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    n = 1;
    label274:
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
      BaseImageUtil.e();
    }
    AppInterface localAppInterface = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    Object localObject2 = FaceDrawable.getFaceDrawable(localAppInterface, n, (String)localObject2, 3, localDrawable, localDrawable);
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setContentDescription((CharSequence)localObject1);
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable((Drawable)localObject2);
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter = new NotifyAndRecAdapter(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_MqqOsMqqHandler, this);
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_f_of_type_AndroidViewView.findViewById(2131369202));
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_g_of_type_AndroidViewView$OnClickListener);
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_f_of_type_AndroidViewView.findViewById(2131379476));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_f_of_type_AndroidViewView.findViewById(2131369563));
    k();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_f_of_type_AndroidViewView.findViewById(2131364663));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.jdField_f_of_type_AndroidViewView.setFitsSystemWindows(true);
      this.jdField_f_of_type_AndroidViewView.setPadding(0, ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidContentContext), 0, 0);
    }
    this.jdField_a_of_type_ComTencentWidgetSwipListView = ((SwipListView)this.jdField_f_of_type_AndroidViewView.findViewById(2131379282));
    this.jdField_b_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131364635);
    this.jdField_c_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131378189);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_f_of_type_AndroidViewView.findViewById(2131378192));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_f_of_type_AndroidViewView.findViewById(2131378190));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_f_of_type_AndroidViewView.findViewById(2131378191));
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_d_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131378184);
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_f_of_type_AndroidViewView.findViewById(2131378187));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_f_of_type_AndroidViewView.findViewById(2131378185));
    this.jdField_d_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_e_of_type_AndroidViewView = this.jdField_f_of_type_AndroidViewView.findViewById(2131378193);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_f_of_type_AndroidViewView.findViewById(2131378194));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_f_of_type_AndroidViewView.findViewById(2131378195));
    this.jdField_e_of_type_AndroidViewView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this);
    IStrangerService localIStrangerService = (IStrangerService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IStrangerService.class, "all");
    if (localIStrangerService != null)
    {
      localIStrangerService.getLocalList();
      localIStrangerService.getRemoteList(false);
    }
  }
  
  private void k()
  {
    ThreadManager.postImmediately(new TroopNotificationFragment.1(this, (IMessageFacade)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IMessageFacade.class, "")), null, false);
  }
  
  private void l()
  {
    Object localObject1 = (ITroopNotificationService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopNotificationService.class, "");
    if (localObject1 == null) {
      return;
    }
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00899", "Grp_contacts_news", "", "notice", "todo_tab_clk", 0, 0, "", "", "", "");
    ((ITroopNotificationService)localObject1).setUnreadUndealMsg(false);
    a(false, 1);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetSlideAndOverScrollRecyclerView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(0);
    if (this.jdField_b_of_type_Int != 1)
    {
      localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(4);
      }
      a(1);
      a(true);
      localObject2 = new ArrayList();
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.b((List)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.a(((ITroopNotificationService)localObject1).getDataListFromClassificationCache(1));
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter;
      ((NotifyAndRecAdapter)localObject1).jdField_a_of_type_Int = 0;
      ((NotifyAndRecAdapter)localObject1).notifyDataSetChanged();
      return;
    }
    Object localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject2 != null) {
      ((TextView)localObject2).setVisibility(0);
    }
    a(0);
    a(false);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.a(((ITroopNotificationService)localObject1).getDataListFromClassificationCache(0));
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.jdField_a_of_type_Int = GroupSystemMsgController.a().a(this.jdField_a_of_type_MqqAppAppRuntime);
    localObject1 = this.jdField_c_of_type_JavaUtilList;
    if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.b(this.jdField_c_of_type_JavaUtilList);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.notifyDataSetChanged();
  }
  
  private void m()
  {
    Object localObject1 = (ITroopNotificationService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopNotificationService.class, "");
    if (localObject1 == null) {
      return;
    }
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00899", "Grp_contacts_news", "", "notice", "quit_tab_clk", 0, 0, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetSlideAndOverScrollRecyclerView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(0);
    if (this.jdField_b_of_type_Int != 2)
    {
      localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(4);
      }
      a(2);
      b(true);
      localObject2 = new ArrayList();
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.b((List)localObject2);
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.a(((ITroopNotificationService)localObject1).getDataListFromClassificationCache(2));
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter;
      ((NotifyAndRecAdapter)localObject1).jdField_a_of_type_Int = 0;
      ((NotifyAndRecAdapter)localObject1).notifyDataSetChanged();
      return;
    }
    Object localObject2 = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localObject2 != null) {
      ((TextView)localObject2).setVisibility(0);
    }
    a(0);
    b(false);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.a(((ITroopNotificationService)localObject1).getDataListFromClassificationCache(0));
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.jdField_a_of_type_Int = GroupSystemMsgController.a().a(this.jdField_a_of_type_MqqAppAppRuntime);
    localObject1 = this.jdField_c_of_type_JavaUtilList;
    if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.b(this.jdField_c_of_type_JavaUtilList);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.notifyDataSetChanged();
  }
  
  private void n()
  {
    Object localObject = (ITroopNotificationService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopNotificationService.class, "");
    if (localObject == null) {
      return;
    }
    ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00899", "Grp_contacts_news", "", "notice", "unnormal_tab_clk", 0, 0, "", "", "", "");
    if (this.jdField_b_of_type_Int != 3)
    {
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(4);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetSlideAndOverScrollRecyclerView.setVisibility(0);
      this.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(8);
      a(3);
      c(true);
      return;
    }
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setVisibility(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetSlideAndOverScrollRecyclerView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setVisibility(0);
    a(0);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.a(((ITroopNotificationService)localObject).getDataListFromClassificationCache(0));
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.jdField_a_of_type_Int = GroupSystemMsgController.a().a(this.jdField_a_of_type_MqqAppAppRuntime);
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.notifyDataSetChanged();
    c(false);
  }
  
  private void o()
  {
    Object localObject = this.jdField_a_of_type_MqqAppAppRuntime;
    if (localObject == null) {
      return;
    }
    localObject = (ITroopNotificationService)((AppRuntime)localObject).getRuntimeService(ITroopNotificationService.class, "");
    if (localObject == null) {
      return;
    }
    List localList = ((ITroopNotificationService)localObject).getLackApplicantInfoWaitingListFromCache("OidbSvc.0x5eb_troopnotifycation");
    if (localList != null) {
      ((ITroopNotificationService)localObject).getNotifyCationApplicantInfoBy0x5eb(localList);
    }
    localList = ((ITroopNotificationService)localObject).getLackApplicantInfoWaitingListFromCache("OidbSvc.0x668");
    if (localList != null) {
      ((ITroopNotificationService)localObject).getNotifyCationApplicantQQLevelBy0x668(localList);
    }
    this.jdField_j_of_type_Boolean = false;
  }
  
  private void p()
  {
    Object localObject1 = this.jdField_a_of_type_MqqAppAppRuntime;
    if (localObject1 == null) {
      return;
    }
    localObject1 = (ITroopNotificationService)((AppRuntime)localObject1).getRuntimeService(ITroopNotificationService.class, "");
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter;
    if (localObject2 != null)
    {
      if (this.jdField_b_of_type_Int != 0) {
        ((NotifyAndRecAdapter)localObject2).jdField_a_of_type_Int = 0;
      } else {
        ((NotifyAndRecAdapter)localObject2).jdField_a_of_type_Int = GroupSystemMsgController.a().a(this.jdField_a_of_type_MqqAppAppRuntime);
      }
      localObject2 = (IRecommendTroopService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRecommendTroopService.class, "");
      if (localObject2 != null) {
        ((IRecommendTroopService)localObject2).setUnreadNum(GroupSystemMsgController.a().a(this.jdField_a_of_type_MqqAppAppRuntime));
      }
      if (localObject1 != null)
      {
        c(((ITroopNotificationService)localObject1).getDataListFromClassificationCache(2));
        b(((ITroopNotificationService)localObject1).getDataListFromClassificationCache(1));
        a(false, 1);
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.notifyDataSetChanged();
    }
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterSuspiciousAdapter;
    if (localObject1 != null) {
      ((SuspiciousAdapter)localObject1).notifyDataSetChanged();
    }
  }
  
  private void q()
  {
    int n = GroupSystemMsgController.a().a(this.jdField_a_of_type_MqqAppAppRuntime);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter;
    if (localObject != null) {
      if (this.jdField_c_of_type_Boolean)
      {
        ((NotifyAndRecAdapter)localObject).jdField_a_of_type_Int = 0;
        a(1);
      }
      else
      {
        ((NotifyAndRecAdapter)localObject).jdField_a_of_type_Int = n;
      }
    }
    localObject = (ITroopNotificationService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopNotificationService.class, "");
    if (localObject != null)
    {
      this.jdField_a_of_type_JavaUtilList = ((ITroopNotificationService)localObject).getMessageRecordMayBeLoadDB(this.jdField_a_of_type_ComTencentMobileqqTroopApiITroopNotificationService$ITroopNotificationLoadDBListener);
      localObject = this.jdField_a_of_type_JavaUtilList;
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        r();
      }
    }
  }
  
  private void r()
  {
    Object localObject1 = this.jdField_a_of_type_MqqAppAppRuntime;
    if (localObject1 == null) {
      return;
    }
    ITroopNotificationService localITroopNotificationService = (ITroopNotificationService)((AppRuntime)localObject1).getRuntimeService(ITroopNotificationService.class, "");
    if (localITroopNotificationService == null) {
      return;
    }
    Object localObject2 = localITroopNotificationService.getDataListFromClassificationCache(0);
    List localList2 = localITroopNotificationService.getDataListFromClassificationCache(2);
    List localList1 = localITroopNotificationService.getDataListFromClassificationCache(1);
    if (this.jdField_b_of_type_Int == 1)
    {
      a(true);
      localObject1 = localList1;
    }
    else
    {
      localObject1 = localObject2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationFragment", 2, new Object[] { "withoutExitDatas Size =", Integer.valueOf(((List)localObject2).size()), "exitDataList Size =", Integer.valueOf(localList2.size()), "undealDataList Size=", Integer.valueOf(localList1.size()) });
    }
    if ((localObject2 != null) && (((List)localObject2).size() > 0) && (!(((List)localObject2).get(0) instanceof MessageForSystemMsg)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("TroopNotificationFragment", 2, "initNotificationListData error");
      }
      localObject1 = (ITroopSysMsgDependApiService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopSysMsgDependApiService.class, "");
      if (localObject1 != null) {
        ((ITroopSysMsgDependApiService)localObject1).clearGroupSystemMsgHistory();
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter;
      if (localObject1 != null)
      {
        ((NotifyAndRecAdapter)localObject1).a(null);
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.notifyDataSetChanged();
      }
      return;
    }
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter;
    if (localObject2 != null)
    {
      ((NotifyAndRecAdapter)localObject2).a((List)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.notifyDataSetChanged();
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.a();
    }
    c(localList2);
    b(localList1);
    if (localITroopNotificationService.hasUnreadUndealMsg()) {
      a(true, 1);
    } else {
      a(false, 1);
    }
    z();
    s();
  }
  
  private void s()
  {
    Object localObject1 = this.jdField_a_of_type_MqqAppAppRuntime;
    if (localObject1 == null) {
      return;
    }
    localObject1 = (ITroopNotificationService)((AppRuntime)localObject1).getRuntimeService(ITroopNotificationService.class, "");
    if (localObject1 == null) {
      return;
    }
    List localList = ((ITroopNotificationService)localObject1).getMessageRecordListFromCache();
    localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    String str1 = "2";
    String str2 = "1";
    String str3 = "3";
    if (localObject1 != null)
    {
      localObject1 = ((QBaseActivity)localObject1).getIntent();
      if (localObject1 != null)
      {
        int n = ((Intent)localObject1).getIntExtra("key_from", 0);
        if (n == 1)
        {
          localObject1 = "1";
          localObject2 = str3;
          break label318;
        }
        if (n == 2)
        {
          if (((Intent)localObject1).getBooleanExtra("has_red", false))
          {
            localObject1 = str1;
            localObject2 = str3;
            if (localList == null) {
              break label318;
            }
            localObject1 = str1;
            localObject2 = str3;
            if (localList.size() <= 0) {
              break label318;
            }
            localObject1 = (MessageRecord)localList.get(0);
            if ((localObject1 instanceof MessageForSystemMsg))
            {
              long l1 = ((MessageForSystemMsg)localObject1).getSystemMsg().msg.group_code.get();
              localObject1 = (ITroopInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopInfoService.class, "");
              if (localObject1 != null)
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append(l1);
                ((StringBuilder)localObject2).append("");
                localObject1 = ((ITroopInfoService)localObject1).findTroopInfo(((StringBuilder)localObject2).toString());
                if (localObject1 != null)
                {
                  if (((TroopInfo)localObject1).isAdmin()) {
                    localObject1 = str2;
                  } else {
                    localObject1 = "2";
                  }
                  break label287;
                }
              }
            }
            localObject1 = "3";
            label287:
            localObject2 = localObject1;
            localObject1 = str1;
            break label318;
          }
          localObject1 = "3";
          localObject2 = str3;
          break label318;
        }
      }
    }
    localObject1 = "";
    Object localObject2 = localObject1;
    label318:
    TroopReportor.a("Grp_contacts_news", "notice", "enter_verify", 0, 0, new String[] { localObject1, localObject2 });
  }
  
  private void t()
  {
    ThreadManager.postImmediately(new TroopNotificationFragment.13(this), null, false);
  }
  
  private void u()
  {
    ITroopNotificationService localITroopNotificationService = (ITroopNotificationService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopNotificationService.class, "");
    if (localITroopNotificationService == null) {
      return;
    }
    List localList1 = localITroopNotificationService.getDataListFromClassificationCache(0);
    int n = this.jdField_b_of_type_Int;
    List localList2;
    if (n == 1)
    {
      localList2 = localITroopNotificationService.getDataListFromClassificationCache(1);
      if ((localList2 != null) && (!localList2.isEmpty()))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.a(localList2);
      }
      else
      {
        a(0);
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.a(localList1);
      }
    }
    else if (n == 2)
    {
      localList2 = localITroopNotificationService.getDataListFromClassificationCache(2);
      if ((localList2 != null) && (!localList2.isEmpty()))
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.a(localITroopNotificationService.getDataListFromClassificationCache(2));
      }
      else
      {
        a(0);
        this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.a(localList1);
      }
    }
    else if (n == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.a(localList1);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.notifyDataSetChanged();
    b(localITroopNotificationService.getDataListFromClassificationCache(1));
    c(localITroopNotificationService.getDataListFromClassificationCache(2));
    z();
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.jdField_a_of_type_Int = 0;
  }
  
  private void v()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationFragment", 2, "sendReadConfirm lll");
    }
    ThreadManager.post(new TroopNotificationFragment.14(this), 8, null, false);
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotificationFragment", 2, "sendReadConfirm is end!");
    }
  }
  
  private void w()
  {
    if (this.jdField_a_of_type_AndroidViewView == null) {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560707, null);
    }
    if (this.jdField_a_of_type_AndroidViewView.getParent() == null) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.addFooterView(this.jdField_a_of_type_AndroidViewView);
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void x()
  {
    if (!this.jdField_g_of_type_Boolean)
    {
      int n = this.jdField_b_of_type_Int;
      if (n != 2)
      {
        if (n == 1) {
          return;
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          localObject = this.jdField_a_of_type_AndroidContentContext;
          QQToast.a((Context)localObject, ((Context)localObject).getResources().getString(2131720054), 0).b(a());
          return;
        }
        Object localObject = (IRecommendTroopService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRecommendTroopService.class, "");
        if (localObject == null) {
          return;
        }
        NotifyAndRecAdapter localNotifyAndRecAdapter = this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter;
        if ((localNotifyAndRecAdapter != null) && ((!localNotifyAndRecAdapter.b()) || (this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.a())))
        {
          localObject = (ITroopNotificationService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopNotificationService.class, "");
          if ((localObject != null) && (((ITroopNotificationService)localObject).isTroopNotificaitonGetAll())) {
            return;
          }
          this.jdField_g_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          localObject = (IMessageHandler)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IMessageHandler.class, "");
          if (localObject != null) {
            ((IMessageHandler)localObject).sendGetNextGroupSystemMsg();
          }
          if (QLog.isColorLevel()) {
            QLog.i("TroopNotificationFragment", 2, "loadNextPage.get next page of Notofication");
          }
        }
        else
        {
          if ((((IRecommendTroopService)localObject).isEnd() != 1) && (this.jdField_i_of_type_Boolean))
          {
            this.jdField_g_of_type_Boolean = true;
            this.jdField_a_of_type_AndroidViewView.setVisibility(0);
            ((IRecommendTroopService)localObject).downloadRecommendTroop();
            if (QLog.isColorLevel()) {
              QLog.i("TroopNotificationFragment", 2, "loadNextPage.get next page of recommend");
            }
            TroopReportor.a("Grp_contacts_news", "notice", "recom_,more", 2, 0, new String[0]);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.i("TroopNotificationFragment", 2, "ray test touch the end of list.");
          }
        }
      }
    }
  }
  
  private void y()
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(8);
    }
    this.jdField_g_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotificationFragment", 2, "stopLoadMore().");
    }
  }
  
  private void z()
  {
    if (this.jdField_b_of_type_AndroidViewView != null)
    {
      Object localObject = this.jdField_a_of_type_MqqAppAppRuntime;
      if (localObject == null) {
        return;
      }
      localObject = (ITroopNotificationService)((AppRuntime)localObject).getRuntimeService(ITroopNotificationService.class, "");
      if (localObject == null) {
        return;
      }
      List localList = ((ITroopNotificationService)localObject).getDataListFromClassificationCache(2);
      if ((((ITroopNotificationService)localObject).getDataListFromClassificationCache(1).isEmpty()) && (this.jdField_b_of_type_JavaUtilList.isEmpty()) && (localList.isEmpty()))
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        return;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131299168);
  }
  
  protected void a()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopNotificationObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageObserver);
    a(this.jdField_a_of_type_ComTencentMobileqqStrangerObserverStrangerObserver);
    w();
    q();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext, a());
    if (TroopNotificationUtils.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface) > 0)
    {
      localObject = (IMessageHandler)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IMessageHandler.class, "");
      if (localObject != null) {
        ((IMessageHandler)localObject).sendGetSystemMsg(3);
      }
    }
    TroopNotificationUtils.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter;
    if (localObject != null) {
      ((NotifyAndRecAdapter)localObject).notifyDataSetChanged();
    }
    int n = GroupSystemMsgController.a().a(this.jdField_a_of_type_MqqAppAppRuntime);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notification num:");
      ((StringBuilder)localObject).append(n);
      QLog.d("TroopNotificationFragment", 2, ((StringBuilder)localObject).toString());
    }
    localObject = (IRecommendTroopService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRecommendTroopService.class, "");
    if (localObject != null) {
      ((IRecommendTroopService)localObject).setUnreadNum(GroupSystemMsgController.a().a(this.jdField_a_of_type_MqqAppAppRuntime));
    }
    int i1 = RecommendTroopUtils.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    localObject = (IConversationFacade)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IConversationFacade.class, "");
    if (localObject != null) {
      ((IConversationFacade)localObject).increaseUnread(AppConstants.TROOP_NOTIFICATION_UIN, 9000, 0 - (i1 + n));
    }
    GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 0);
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  void a(NotifyAndRecAdapter.ViewHolder paramViewHolder)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleGroupSystemMsg! start ");
      ((StringBuilder)localObject1).append(paramViewHolder.jdField_a_of_type_Long);
      QLog.d("TroopNotificationFragment", 2, ((StringBuilder)localObject1).toString());
    }
    b(paramViewHolder, 998);
    String str3 = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_info.msg_alert.get();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
    Object localObject2 = "";
    ((StringBuilder)localObject1).append("");
    String str2 = ((StringBuilder)localObject1).toString();
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter;
    localObject1 = "1";
    String str1;
    if ((localObject3 != null) && (paramViewHolder.jdField_b_of_type_Int < this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.jdField_a_of_type_Int)) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    boolean bool = a(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_inviter_role.get());
    int n = paramViewHolder.jdField_a_of_type_Int;
    if (n != 1) {
      if (n != 2)
      {
        if (n != 3)
        {
          localObject3 = localObject1;
          if (n != 6)
          {
            if (n != 7)
            {
              if (n != 15)
              {
                localObject3 = localObject1;
                if (n != 16)
                {
                  if (n == 22) {
                    break label474;
                  }
                  switch (n)
                  {
                  default: 
                    paramViewHolder = "";
                    localObject1 = paramViewHolder;
                    break;
                  case 13: 
                    paramViewHolder = "quit_page";
                    break;
                  case 12: 
                    paramViewHolder = (NotifyAndRecAdapter.ViewHolder)localObject1;
                    if (bool) {
                      paramViewHolder = "0";
                    }
                    localObject1 = "refuseagree_page";
                    break;
                  case 11: 
                    paramViewHolder = "refuseask_page";
                    localObject1 = paramViewHolder;
                    paramViewHolder = "";
                    break;
                  }
                  paramViewHolder = (NotifyAndRecAdapter.ViewHolder)localObject1;
                  if (bool) {
                    paramViewHolder = "0";
                  }
                  localObject1 = "refuseinvite_page";
                  break label430;
                }
              }
              else
              {
                localObject3 = "0";
              }
              localObject1 = "un_admin_page";
              paramViewHolder = (NotifyAndRecAdapter.ViewHolder)localObject3;
              break label615;
            }
            else
            {
              localObject3 = "0";
            }
          }
          else
          {
            localObject1 = "byquit_page";
            paramViewHolder = (NotifyAndRecAdapter.ViewHolder)localObject3;
            break label615;
          }
        }
        else
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
          ((StringBuilder)localObject3).append("");
          paramViewHolder = (NotifyAndRecAdapter.ViewHolder)localObject1;
          if (((StringBuilder)localObject3).toString().equals(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin())) {
            paramViewHolder = "0";
          }
          localObject1 = "set_admin_page";
        }
        label430:
        break label615;
      }
      else
      {
        if (paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() == 1) {
          localObject1 = "0";
        }
        localObject3 = "enter_invite";
        paramViewHolder = "";
        localObject2 = localObject1;
        localObject1 = localObject3;
        break label615;
      }
    }
    label474:
    if ((str3 != null) && (!"".equals(str3))) {
      localObject1 = "0";
    } else {
      localObject1 = "1";
    }
    if (paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get() == 1) {
      localObject2 = "0";
    }
    label612:
    for (;;)
    {
      paramViewHolder = (NotifyAndRecAdapter.ViewHolder)localObject1;
      localObject1 = "enter_askjoin";
      break;
      long l1 = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actor_uin.get();
      if (l1 != 0L)
      {
        paramViewHolder = new StringBuilder();
        paramViewHolder.append(l1);
        paramViewHolder.append("");
        if (!paramViewHolder.toString().equals(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin()))
        {
          localObject2 = "2";
          break label612;
        }
      }
      localObject2 = "1";
    }
    label615:
    TroopReportor.a("Grp_contacts_news", "notice", (String)localObject1, 3, 0, new String[] { str2, str1, paramViewHolder, localObject2 });
  }
  
  public void a(NotifyAndRecAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("bindTroopSystemMsgView! start ");
      ((StringBuilder)localObject1).append(paramViewHolder.jdField_a_of_type_Long);
      QLog.d("TroopNotificationFragment", 2, ((StringBuilder)localObject1).toString());
    }
    structmsg.StructMsg localStructMsg = paramViewHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    paramViewHolder.jdField_a_of_type_Long = paramInt;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(localStructMsg.req_uin.get());
    Object localObject1 = "";
    ((StringBuilder)localObject2).append("");
    paramViewHolder.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
    paramViewHolder.jdField_a_of_type_Int = localStructMsg.msg.group_msg_type.get();
    paramInt = localStructMsg.msg.sub_type.get();
    paramViewHolder.jdField_b_of_type_Long = localStructMsg.msg_time.get();
    paramViewHolder.jdField_b_of_type_JavaLangString = localStructMsg.msg.req_uin_nick.get();
    if ((paramViewHolder.jdField_b_of_type_JavaLangString == null) || (paramViewHolder.jdField_b_of_type_JavaLangString.equals(""))) {
      paramViewHolder.jdField_b_of_type_JavaLangString = paramViewHolder.jdField_a_of_type_JavaLangString;
    }
    localObject2 = (ITroopNotificationService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopNotificationService.class, "");
    if (localObject2 == null) {
      return;
    }
    if (paramViewHolder.jdField_a_of_type_Int == 91) {
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationGeneralgroupnotifyparserIGeneralGroupNotifyParser$GeneralGroupNotifyInfo = ((ITroopNotificationService)localObject2).getGeneralGroupNotifyParser(91).a(localStructMsg);
    }
    if (paramViewHolder.jdField_a_of_type_Int == 2) {
      paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationGeneralgroupnotifyparserIGeneralGroupNotifyParser$GeneralGroupNotifyInfo = ((ITroopNotificationService)localObject2).getGeneralGroupNotifyParser(2).a(localStructMsg);
    }
    b(paramViewHolder, localStructMsg);
    a(paramViewHolder.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter$ApplicantHolder, localStructMsg, false);
    paramViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    localObject2 = localStructMsg.msg.group_info.msg_alert.get();
    a(paramViewHolder, localStructMsg, (String)localObject2);
    a(paramViewHolder, localStructMsg);
    a(paramViewHolder, localStructMsg, paramInt, (String)localObject2);
    if ((paramInt == 2) && (paramViewHolder.jdField_a_of_type_Int == 2))
    {
      localObject2 = (ITroopInfoService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopInfoService.class, "");
      if ((localObject2 != null) && (((ITroopInfoService)localObject2).findTroopInfo(String.valueOf(localStructMsg.msg.group_code.get())) != null)) {
        TroopRemindSettingManager.a().b(String.valueOf(localStructMsg.msg.group_code.get()), this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      }
    }
    if (localStructMsg.msg.bytes_warning_tips.get() != null) {
      localObject1 = localStructMsg.msg.bytes_warning_tips.get().toStringUtf8();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramViewHolder.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      paramViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
    }
    else
    {
      paramViewHolder.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.security_verify", 2, String.format("bindTroopSystemMsgView reqUin: %s, warningTips: %s", new Object[] { paramViewHolder.jdField_a_of_type_JavaLangString, localObject1 }));
    }
    paramViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setTag(paramViewHolder);
    paramViewHolder.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(paramViewHolder);
    if ((paramViewHolder.jdField_a_of_type_Int != 8) && (paramViewHolder.jdField_a_of_type_Int != 7)) {
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    } else {
      paramViewHolder.jdField_a_of_type_AndroidWidgetImageView.setEnabled(false);
    }
    d(paramViewHolder);
    if (((paramViewHolder.jdField_a_of_type_Int == 1) || (paramViewHolder.jdField_a_of_type_Int == 22) || (paramViewHolder.jdField_a_of_type_Int == 60)) && (QLog.isColorLevel()))
    {
      boolean bool = localStructMsg.msg.has();
      int i1 = -1;
      if ((bool) && (localStructMsg.msg.src_id.has())) {
        paramInt = localStructMsg.msg.src_id.get();
      } else {
        paramInt = -1;
      }
      int n = i1;
      if (localStructMsg.msg.has())
      {
        n = i1;
        if (localStructMsg.msg.sub_src_id.has()) {
          n = localStructMsg.msg.sub_src_id.get();
        }
      }
      QLog.i("TroopNotificationFragment", 2, String.format("joinGroup subSourceID=%d sourceID=%d msgType=%d", new Object[] { Integer.valueOf(n), Integer.valueOf(paramInt), Integer.valueOf(paramViewHolder.jdField_a_of_type_Int) }));
    }
  }
  
  protected void a(List<RecommendTroopItem> paramList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleRecommendDataResult: ");
      localStringBuilder.append(Log.getStackTraceString(new RuntimeException("debug trace")));
      QLog.d("TroopNotificationFragment", 2, localStringBuilder.toString());
    }
    ThreadManager.getUIHandler().post(new TroopNotificationFragment.23(this, paramList));
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      Object localObject = this.jdField_c_of_type_AndroidWidgetTextView;
      if (localObject != null)
      {
        if (this.jdField_a_of_type_AndroidWidgetImageView == null) {
          return;
        }
        localObject = new SpannableStringBuilder(((TextView)localObject).getText());
        if ((paramBoolean) && (this.jdField_b_of_type_Int == 1))
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-16725252);
          ((SpannableStringBuilder)localObject).setSpan(new StyleSpan(1), 0, this.jdField_c_of_type_AndroidWidgetTextView.getText().length(), 18);
          this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          b(false);
          c(false);
          this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
          return;
        }
        this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-7894119);
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        localObject = this.jdField_a_of_type_MqqAppAppRuntime;
        if (localObject != null)
        {
          localObject = (ITroopNotificationService)((AppRuntime)localObject).getRuntimeService(ITroopNotificationService.class, "");
          if (localObject != null) {
            b(((ITroopNotificationService)localObject).getDataListFromClassificationCache(1));
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (this.jdField_f_of_type_AndroidWidgetTextView == null) {
      return;
    }
    int n = this.jdField_b_of_type_Int;
    if ((n == paramInt) && ((n == 1) || (n == 2)))
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      return;
    }
    if (paramBoolean)
    {
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  protected int b()
  {
    int i2 = RecommendTroopUtils.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    IRecommendTroopService localIRecommendTroopService = (IRecommendTroopService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRecommendTroopService.class, "");
    int i1 = 0;
    if (i2 > 0)
    {
      IConversationFacade localIConversationFacade = (IConversationFacade)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IConversationFacade.class, "");
      if (localIConversationFacade != null) {
        localIConversationFacade.increaseUnread(AppConstants.TROOP_NOTIFICATION_UIN, 9000, 0 - i2);
      }
      if (localIRecommendTroopService != null) {
        localIRecommendTroopService.sendReadConfirm();
      }
    }
    int n = i1;
    if (localIRecommendTroopService != null)
    {
      n = i1;
      if (i2 > 0) {
        n = 1;
      }
    }
    return n;
  }
  
  public void b()
  {
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    DialogUtil.a(localContext, null, localContext.getString(2131719988), null, 2131690728, 2131694583, new TroopNotificationFragment.19(this), new TroopNotificationFragment.20(this)).show();
  }
  
  public void b(List<MessageRecord> paramList)
  {
    if (this.jdField_c_of_type_AndroidViewView != null)
    {
      if (this.jdField_c_of_type_AndroidWidgetTextView == null) {
        return;
      }
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        int n = paramList.size();
        paramList = String.valueOf(n);
        if (n > 99) {
          paramList = "99+";
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("待处理(");
        ((StringBuilder)localObject).append(paramList);
        ((StringBuilder)localObject).append(")");
        paramList = ((StringBuilder)localObject).toString();
        if (this.jdField_c_of_type_AndroidViewView.getVisibility() == 8) {
          ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00899", "Grp_contacts_news", "", "notice", "todo_tab_exp", 0, 0, "", "", "", "");
        }
        if (this.jdField_b_of_type_Int == 1)
        {
          localObject = new SpannableStringBuilder(paramList);
          ((SpannableStringBuilder)localObject).setSpan(new StyleSpan(1), 0, paramList.length(), 18);
          this.jdField_c_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        }
        else
        {
          this.jdField_c_of_type_AndroidWidgetTextView.setText(paramList);
        }
        this.jdField_c_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_d_of_type_AndroidViewView != null) && (this.jdField_b_of_type_AndroidWidgetImageView != null))
    {
      Object localObject = this.jdField_d_of_type_AndroidWidgetTextView;
      if (localObject == null) {
        return;
      }
      localObject = new SpannableStringBuilder(((TextView)localObject).getText());
      if ((paramBoolean) && (this.jdField_b_of_type_Int == 2))
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-16725252);
        ((SpannableStringBuilder)localObject).setSpan(new StyleSpan(1), 0, this.jdField_d_of_type_AndroidWidgetTextView.getText().length(), 18);
        this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        c(false);
        a(false);
        this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        return;
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-7894119);
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setText("退群");
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_MqqAppAppRuntime == null) {
      return;
    }
    v();
    Object localObject = (ITroopSysMsgDependApiService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopSysMsgDependApiService.class, "");
    if (localObject != null) {
      ((ITroopSysMsgDependApiService)localObject).clearGroupSystemMsg();
    }
    GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 0);
    localObject = (ITroopNotificationService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopNotificationService.class, "");
    if (localObject != null) {
      ((ITroopNotificationService)localObject).clearAllMsgCache();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter;
    if (localObject != null)
    {
      ((NotifyAndRecAdapter)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.notifyDataSetChanged();
    }
    c(null);
    b(null);
    a(false, 1);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
  }
  
  public void c(List<MessageRecord> paramList)
  {
    if (this.jdField_d_of_type_AndroidWidgetTextView != null)
    {
      if (this.jdField_d_of_type_AndroidViewView == null) {
        return;
      }
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        if (this.jdField_c_of_type_AndroidViewView.getVisibility() == 8) {
          ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "dc00899", "Grp_contacts_news", "", "notice", "quit_tab_exp", 0, 0, "", "", "", "");
        }
        this.jdField_d_of_type_AndroidViewView.setVisibility(0);
        return;
      }
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if ((this.jdField_e_of_type_AndroidViewView != null) && (this.jdField_c_of_type_AndroidWidgetImageView != null))
    {
      Object localObject = this.jdField_e_of_type_AndroidWidgetTextView;
      if (localObject == null) {
        return;
      }
      localObject = new SpannableStringBuilder(((TextView)localObject).getText());
      if ((paramBoolean) && (this.jdField_b_of_type_Int == 3))
      {
        this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-16725252);
        ((SpannableStringBuilder)localObject).setSpan(new StyleSpan(1), 0, this.jdField_e_of_type_AndroidWidgetTextView.getText().length(), 33);
        this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
        a(false);
        b(false);
        return;
      }
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-7894119);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      this.jdField_e_of_type_AndroidWidgetTextView.setText("已过滤");
    }
  }
  
  protected void d()
  {
    a(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    e();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int n = (int)paramMotionEvent.getX();
    int i1 = (int)paramMotionEvent.getY();
    int i2 = paramMotionEvent.getAction();
    if (i2 != 0)
    {
      if (i2 != 1) {
        if (i2 != 2)
        {
          if (i2 != 3) {
            break label137;
          }
        }
        else
        {
          i2 = n - this.l;
          int i3 = i1 - this.m;
          if ((i2 > 20) || (i2 < -20)) {
            this.jdField_k_of_type_Boolean = true;
          }
          if (((i3 <= 20) && (i3 >= -20)) || (this.jdField_k_of_type_Boolean)) {
            break label137;
          }
          this.jdField_f_of_type_AndroidViewView.getParent().requestDisallowInterceptTouchEvent(false);
          break label137;
        }
      }
      this.jdField_k_of_type_Boolean = false;
    }
    else
    {
      this.jdField_f_of_type_AndroidViewView.getParent().requestDisallowInterceptTouchEvent(true);
    }
    label137:
    this.m = i1;
    this.l = n;
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void e()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopNotificationFragment", 4, "onChecked........");
    }
    this.jdField_i_of_type_Boolean = this.jdField_a_of_type_MqqAppAppRuntime.getPreferences().getBoolean("show_new_troop_recommend", false);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getNotificationRecommendTroopList showOpen is :");
      ((StringBuilder)localObject).append(this.jdField_i_of_type_Boolean);
      QLog.d("TroopNotificationFragment", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.jdField_e_of_type_Boolean) && (this.jdField_i_of_type_Boolean))
    {
      this.jdField_e_of_type_Boolean = false;
      localObject = (IRecommendTroopService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRecommendTroopService.class, "");
      if (localObject != null) {
        ((IRecommendTroopService)localObject).downloadRecommendTroop();
      }
    }
    if (!this.jdField_i_of_type_Boolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter;
      if (localObject != null)
      {
        ((NotifyAndRecAdapter)localObject).jdField_b_of_type_Boolean = true;
        ((NotifyAndRecAdapter)localObject).notifyDataSetChanged();
      }
    }
    b();
    f();
  }
  
  protected void f()
  {
    if (this.jdField_d_of_type_Boolean)
    {
      NotifyAndRecAdapter localNotifyAndRecAdapter = this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter;
      if ((localNotifyAndRecAdapter != null) && (localNotifyAndRecAdapter.b()))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("TroopNotificationFragment", 4, "reportPv");
        }
        ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "P_CliOper", "Grp_recom", "", "msg_page", "exp", 0, 0, "", "", "", "");
      }
    }
  }
  
  public void g()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopNotificationFragment", 4, "refreshRecommendTroopList");
    }
    if (this.jdField_f_of_type_Boolean) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopNotificationFragment", 4, "refreshRecommendTroopList start ");
    }
  }
  
  public void h()
  {
    B();
    A();
    C();
  }
  
  public void i()
  {
    F();
    Object localObject = (ITroopSysMsgDependApiService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopSysMsgDependApiService.class, "");
    if (localObject != null) {
      ((ITroopSysMsgDependApiService)localObject).clearGroupSuspiciousMsg();
    }
    GroupSystemMsgController.a().b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 0);
    this.jdField_b_of_type_JavaUtilList.clear();
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterSuspiciousAdapter;
    if (localObject != null) {
      ((SuspiciousAdapter)localObject).a();
    }
    localObject = this.jdField_e_of_type_AndroidViewView;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessage(1012);
  }
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    long l2 = jdField_a_of_type_Long;
    if ((l1 - l2 <= 0L) || (l1 - l2 >= 800L))
    {
      jdField_a_of_type_Long = l1;
      int n = paramView.getId();
      if (n == 2131373672)
      {
        Object localObject1;
        if ((paramView.getTag() instanceof NotifyAndRecAdapter.ViewHolder))
        {
          Object localObject3 = (NotifyAndRecAdapter.ViewHolder)paramView.getTag();
          if (localObject3 != null)
          {
            Object localObject2 = ((NotifyAndRecAdapter.ViewHolder)localObject3).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
            n = ((NotifyAndRecAdapter.ViewHolder)localObject3).jdField_a_of_type_Int;
            Object localObject4;
            if (TroopNotificationUtils.a(n) == 0)
            {
              localObject2 = String.valueOf(((NotifyAndRecAdapter.ViewHolder)localObject3).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
              localObject1 = localObject2;
              if (n == 91)
              {
                localObject1 = localObject2;
                if ((((NotifyAndRecAdapter.ViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationGeneralgroupnotifyparserIGeneralGroupNotifyParser$GeneralGroupNotifyInfo instanceof AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)) {
                  localObject1 = String.valueOf(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)((NotifyAndRecAdapter.ViewHolder)localObject3).jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationGeneralgroupnotifyparserIGeneralGroupNotifyParser$GeneralGroupNotifyInfo).jdField_c_of_type_Long);
                }
              }
              localObject2 = (ITroopUtilApi)QRoute.api(ITroopUtilApi.class);
              if (localObject2 != null) {
                ((ITroopUtilApi)localObject2).openTroopInfoActivity(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, (String)localObject1);
              }
              if ((n != 2) && (n != 10) && (n != 12)) {
                n = 0;
              } else {
                n = 1;
              }
              localObject4 = this.jdField_a_of_type_MqqAppAppRuntime;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(((NotifyAndRecAdapter.ViewHolder)localObject3).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
              ((StringBuilder)localObject1).append("");
              String str = ((StringBuilder)localObject1).toString();
              localObject2 = "0";
              if (n != 0) {
                localObject1 = "0";
              } else {
                localObject1 = "1";
              }
              ReportController.b((AppRuntime)localObject4, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, str, (String)localObject1, "", "");
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(((NotifyAndRecAdapter.ViewHolder)localObject3).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code);
              ((StringBuilder)localObject1).append("");
              localObject3 = ((StringBuilder)localObject1).toString();
              if (n != 0) {
                localObject1 = localObject2;
              } else {
                localObject1 = "1";
              }
              TroopReportor.a("Grp_contacts_news", "notice", "see_data", 0, 0, new String[] { localObject3, localObject1 });
            }
            else if ((((NotifyAndRecAdapter.ViewHolder)localObject3).jdField_a_of_type_Int != 2) || (!TroopInfo.isQidianPrivateTroop(((NotifyAndRecAdapter.ViewHolder)localObject3).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_group_flagext3.get())))
            {
              localObject4 = (ITroopSysMsgDependApiService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopSysMsgDependApiService.class, "");
              if (localObject4 != null) {
                if (((NotifyAndRecAdapter.ViewHolder)localObject3).jdField_a_of_type_Int == 82)
                {
                  localObject1 = new ActivityURIRequest(this.jdField_a_of_type_AndroidContentContext, "/pubaccount/detail");
                  localObject2 = ((ActivityURIRequest)localObject1).extra();
                  localObject4 = new StringBuilder();
                  ((StringBuilder)localObject4).append(((NotifyAndRecAdapter.ViewHolder)localObject3).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
                  ((StringBuilder)localObject4).append("");
                  ((Bundle)localObject2).putString("uin", ((StringBuilder)localObject4).toString());
                  ((ActivityURIRequest)localObject1).extra().putInt("source", 112);
                  QRoute.startUri((URIRequest)localObject1, null);
                }
                else
                {
                  l1 = ((structmsg.StructMsg)localObject2).req_uin.get();
                  n = TroopNotificationUtils.a(n);
                  if (n != 1)
                  {
                    if (n != 2) {}
                    for (localObject1 = String.valueOf(l1);; localObject1 = ((NotifyAndRecAdapter.ViewHolder)localObject3).jdField_a_of_type_JavaLangString)
                    {
                      bool = false;
                      break;
                    }
                  }
                  localObject1 = String.valueOf(((NotifyAndRecAdapter.ViewHolder)localObject3).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.action_uin.get());
                  boolean bool = true;
                  ((ITroopSysMsgDependApiService)localObject4).openProfileCardForTroopSysMsg(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, (String)localObject1, ((structmsg.StructMsg)localObject2).msg.group_code.get(), ((structmsg.StructMsg)localObject2).msg.action_uin.get(), ((structmsg.StructMsg)localObject2).msg.group_msg_type.get(), ((structmsg.StructMsg)localObject2).msg.sub_type.get(), bool);
                }
              }
            }
          }
        }
        else if (n == 2131371731)
        {
          localObject1 = (ITroopSysMsgDependApiService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopSysMsgDependApiService.class, "");
          if (localObject1 != null) {
            ((ITroopSysMsgDependApiService)localObject1).openNearTroopActivity(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = getQBaseActivity();
    paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
    this.jdField_a_of_type_AndroidContentContext = paramBundle;
    this.jdField_a_of_type_MqqAppAppRuntime = paramBundle.getAppRuntime();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = a();
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
      paramLayoutInflater = null;
    }
    else
    {
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getIntent();
      if (paramBundle != null)
      {
        this.jdField_f_of_type_Int = paramBundle.getIntExtra("key_from", 0);
        this.jdField_c_of_type_Boolean = paramBundle.getBooleanExtra("show_type", false);
        this.jdField_d_of_type_Int = paramBundle.getIntExtra("key_tab_mode", 0);
        this.jdField_e_of_type_Int = paramBundle.getIntExtra("show_mode", 2);
      }
      paramBundle = (IRecommendTroopService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRecommendTroopService.class, "");
      if (this.jdField_d_of_type_Int == 2)
      {
        if (GroupSystemMsgController.a().a(this.jdField_a_of_type_MqqAppAppRuntime) > 0) {
          this.jdField_c_of_type_Int = 1;
        } else if ((paramBundle != null) && (RecommendTroopUtils.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface) > 0)) {
          this.jdField_c_of_type_Int = 0;
        }
        int n = this.jdField_c_of_type_Int;
        if (n == 0) {
          ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "P_CliOper", "Grp_contacts", "", "notice", "enter_recom", 0, 0, "", "", "", "");
        } else if (n == 1) {
          ReportController.b(this.jdField_a_of_type_MqqAppAppRuntime, "P_CliOper", "Grp_contacts", "", "notice", "enter_verify", 0, 0, "", "", "", "");
        }
      }
      paramViewGroup = paramLayoutInflater.inflate(2131559891, paramViewGroup, false);
      this.jdField_f_of_type_AndroidViewView = paramViewGroup;
      j();
      a();
      d();
      h();
      paramBundle = (IMessageFacade)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IMessageFacade.class, "");
      paramLayoutInflater = paramViewGroup;
      if (paramBundle != null)
      {
        paramBundle.addObserver(this);
        paramLayoutInflater = paramViewGroup;
      }
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetSlideAndOverScrollRecyclerView, paramString, paramBitmap);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter;
    if (localObject != null) {
      ((NotifyAndRecAdapter)localObject).c();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter;
    if ((localObject != null) && (((NotifyAndRecAdapter)localObject).a() > 0)) {
      v();
    }
    if (this.jdField_j_of_type_Int > 0)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterSuspiciousAdapter;
      if ((localObject != null) && (((SuspiciousAdapter)localObject).a() > 0)) {
        F();
      }
    }
    localObject = this.jdField_a_of_type_MqqOsMqqHandler;
    if (localObject != null) {
      ((MqqHandler)localObject).removeCallbacksAndMessages(null);
    }
    b(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopNotificationObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqAppBaseMessageObserver);
    b(this.jdField_a_of_type_ComTencentMobileqqStrangerObserverStrangerObserver);
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter;
    if (localObject != null)
    {
      ((NotifyAndRecAdapter)localObject).b();
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter.notifyDataSetChanged();
    }
    TroopNotificationUtils.b();
    GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 0);
    GroupSystemMsgController.a().b();
    GroupCatalogTool.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity).a();
    if (this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener != null) {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(this.jdField_a_of_type_ComTencentMobileqqSosoLocationSosoInterfaceOnLocationListener);
    }
    localObject = (IRecommendTroopService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRecommendTroopService.class, "");
    if (localObject != null)
    {
      ((IRecommendTroopService)localObject).sendReadConfirm();
      ((IRecommendTroopService)localObject).reSetConfig();
      ((IRecommendTroopService)localObject).clearGroupSysNotifyReportData();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
    if (localObject != null) {
      ((IFaceDecoder)localObject).setDecodeTaskCompletionListener(null);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterSuspiciousAdapter;
    if (localObject != null)
    {
      ((SuspiciousAdapter)localObject).a();
      this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterSuspiciousAdapter.notifyDataSetChanged();
    }
    localObject = (ITroopNotificationService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(ITroopNotificationService.class, "");
    if (localObject != null) {
      ((ITroopNotificationService)localObject).clearAllLackApplicantInfoUinsFromCache();
    }
    localObject = (IConversationFacade)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IConversationFacade.class, "");
    if (localObject != null) {
      ((IConversationFacade)localObject).increaseUnread(AppConstants.TROOP_NOTIFICATION_UIN, 9000, 0 - GroupSystemMsgController.a().a(this.jdField_a_of_type_MqqAppAppRuntime));
    }
    localObject = (IMessageFacade)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IMessageFacade.class, "");
    if (localObject != null) {
      ((IMessageFacade)localObject).deleteObserver(this);
    }
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_h_of_type_Boolean)
    {
      TroopNotificationUtils.b();
      GroupSystemMsgController.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 0);
      Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter;
      if (localObject != null)
      {
        ((NotifyAndRecAdapter)localObject).jdField_a_of_type_Int = 0;
        ((NotifyAndRecAdapter)localObject).notifyDataSetChanged();
      }
      localObject = (IRecommendTroopService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRecommendTroopService.class, "");
      if (localObject != null) {
        ((IRecommendTroopService)localObject).setUnreadNum(GroupSystemMsgController.a().a(this.jdField_a_of_type_MqqAppAppRuntime));
      }
    }
    if (this.jdField_b_of_type_Int == 3) {
      GroupSystemMsgController.a().b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 0);
    }
    this.jdField_h_of_type_Boolean = true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_h_of_type_Int = (paramInt1 + paramInt2 - 1);
    paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter;
    if (paramAbsListView != null) {
      paramAbsListView.a(this.jdField_h_of_type_Int, this.jdField_b_of_type_Int);
    }
    if (QLog.isColorLevel())
    {
      paramAbsListView = new StringBuilder();
      paramAbsListView.append("ray test firstvis:");
      paramAbsListView.append(paramInt1);
      paramAbsListView.append(" viscount:");
      paramAbsListView.append(paramInt2);
      QLog.d("TroopNotificationFragment", 2, paramAbsListView.toString());
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      paramAbsListView = new StringBuilder();
      paramAbsListView.append("ray test lastindex:");
      paramAbsListView.append(this.jdField_h_of_type_Int);
      paramAbsListView.append("list count");
      NotifyAndRecAdapter localNotifyAndRecAdapter = this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter;
      int n;
      if (localNotifyAndRecAdapter != null) {
        n = localNotifyAndRecAdapter.getCount();
      } else {
        n = 0;
      }
      paramAbsListView.append(n);
      QLog.d("TroopNotificationFragment", 2, paramAbsListView.toString());
    }
    paramAbsListView = this.jdField_a_of_type_ComTencentMobileqqTroopTroopnotificationAdapterNotifyAndRecAdapter;
    if ((paramAbsListView != null) && (paramInt == 0) && (this.jdField_h_of_type_Int == paramAbsListView.getCount() - 1)) {
      x();
    }
    this.jdField_i_of_type_Int = paramInt;
  }
  
  public void onStop()
  {
    super.onStop();
    IRecommendTroopService localIRecommendTroopService = (IRecommendTroopService)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IRecommendTroopService.class, "");
    if (localIRecommendTroopService != null) {
      localIRecommendTroopService.sendReadConfirm();
    }
    if (this.jdField_b_of_type_Int == 3)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.pause();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((!paramObservable.isSendFromLocal()) && (ThemeUtil.isDefaultOrDIYTheme(false)))
      {
        paramObject = (TextView)this.jdField_f_of_type_AndroidViewView.findViewById(2131379476);
        ImageView localImageView = (ImageView)this.jdField_f_of_type_AndroidViewView.findViewById(2131369563);
        ThreadManager.postImmediately(new TroopNotificationFragment.GetUnReadNumRunnable(this.jdField_a_of_type_MqqAppAppRuntime, new WeakReference(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity), paramObject, localImageView), null, false);
      }
      if ((!paramObservable.isSendFromLocal()) || (paramObservable.msgtype != -2002)) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.TroopNotificationFragment
 * JD-Core Version:    0.7.0.1
 */