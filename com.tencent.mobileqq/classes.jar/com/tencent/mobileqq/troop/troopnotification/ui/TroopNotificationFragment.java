package com.tencent.mobileqq.troop.troopnotification.ui;

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
  public static int B;
  protected static long D;
  BaseMessageObserver A = new TroopNotificationFragment.9(this);
  protected View.OnClickListener C = new TroopNotificationFragment.16(this);
  TroopNotificationUtils.TroopPrivilegeCallback E = new TroopNotificationFragment.21(this);
  protected SosoInterfaceOnLocationListener F = null;
  protected boolean G = false;
  TroopMngObserver H = new TroopNotificationFragment.22(this);
  protected boolean I = true;
  protected boolean J = false;
  protected View K;
  protected int L;
  protected boolean M;
  protected int N = 0;
  View.OnClickListener O = new TroopNotificationFragment.27(this);
  protected View.OnClickListener P = new TroopNotificationFragment.29(this);
  StrangerObserver Q = new TroopNotificationFragment.32(this);
  private boolean R;
  private boolean S;
  private QQProgressDialog T;
  private View U;
  private View V;
  private View W;
  private View X;
  private TextView Y;
  private TextView Z;
  NotifyAndRecAdapter a;
  private TextView aa;
  private ImageView ab;
  private ImageView ac;
  private ImageView ad;
  private TextView ae;
  private SlideAndOverScrollRecyclerView af;
  private SuspiciousAdapter ag;
  private int ah;
  private int ai;
  private TextView aj;
  private ImageView ak;
  private boolean al = false;
  private QBaseActivity am;
  private AppRuntime an;
  private AppInterface ao;
  private View ap;
  private int aq;
  private int ar;
  private boolean as;
  private View.OnClickListener at = new TroopNotificationFragment.4(this);
  private TroopNotifyHelper.OnTroopSafeDialogClickConfirm au = new TroopNotificationFragment.17(this);
  Drawable b;
  SwipListView c;
  protected List<MessageRecord> d;
  protected List<MessageRecord> e = new ArrayList();
  protected List<RecommendTroopItem> f = new ArrayList();
  protected Context g;
  protected boolean h;
  protected int i = 0;
  protected IFaceDecoder j;
  protected boolean k;
  protected TextView l;
  protected TextView m;
  protected int n = 0;
  protected List<Stranger> o = new ArrayList();
  public int p = 0;
  public int q = 0;
  public int r = 2;
  public boolean s = false;
  public int t;
  View.OnClickListener u = new TroopNotificationFragment.2(this);
  View.OnClickListener v = new TroopNotificationFragment.3(this);
  MqqHandler w = new TroopNotificationFragment.5(this);
  TroopNotificationObserver x = new TroopNotificationFragment.6(this);
  ITroopNotificationService.ITroopNotificationLoadDBListener y = new TroopNotificationFragment.7(this);
  protected View.OnClickListener z = new TroopNotificationFragment.8(this);
  
  private void A()
  {
    if (!this.M)
    {
      int i1 = this.n;
      if (i1 != 2)
      {
        if (i1 == 1) {
          return;
        }
        if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          localObject = this.g;
          QQToast.makeText((Context)localObject, ((Context)localObject).getResources().getString(2131917675), 0).show(b());
          return;
        }
        Object localObject = (IRecommendTroopService)this.an.getRuntimeService(IRecommendTroopService.class, "");
        if (localObject == null) {
          return;
        }
        NotifyAndRecAdapter localNotifyAndRecAdapter = this.a;
        if ((localNotifyAndRecAdapter != null) && ((!localNotifyAndRecAdapter.d()) || (this.a.a())))
        {
          localObject = (ITroopNotificationService)this.an.getRuntimeService(ITroopNotificationService.class, "");
          if ((localObject != null) && (((ITroopNotificationService)localObject).isTroopNotificaitonGetAll())) {
            return;
          }
          this.M = true;
          this.K.setVisibility(0);
          localObject = (IMessageHandler)this.an.getRuntimeService(IMessageHandler.class, "");
          if (localObject != null) {
            ((IMessageHandler)localObject).sendGetNextGroupSystemMsg();
          }
          if (QLog.isColorLevel()) {
            QLog.i("TroopNotificationFragment", 2, "loadNextPage.get next page of Notofication");
          }
        }
        else
        {
          if ((((IRecommendTroopService)localObject).isEnd() != 1) && (this.S))
          {
            this.M = true;
            this.K.setVisibility(0);
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
  
  private void B()
  {
    View localView = this.K;
    if (localView != null) {
      localView.setVisibility(8);
    }
    this.M = false;
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotificationFragment", 2, "stopLoadMore().");
    }
  }
  
  private void C()
  {
    if (this.U != null)
    {
      Object localObject = this.an;
      if (localObject == null) {
        return;
      }
      localObject = (ITroopNotificationService)((AppRuntime)localObject).getRuntimeService(ITroopNotificationService.class, "");
      if (localObject == null) {
        return;
      }
      List localList = ((ITroopNotificationService)localObject).getDataListFromClassificationCache(2);
      if ((((ITroopNotificationService)localObject).getDataListFromClassificationCache(1).isEmpty()) && (this.e.isEmpty()) && (localList.isEmpty()))
      {
        this.U.setVisibility(8);
        return;
      }
      this.U.setVisibility(0);
    }
  }
  
  private void D()
  {
    this.ag = new TroopNotificationFragment.24(this, getActivity(), 2131625945);
    this.ag.f(2131625946);
    this.ag.e(2131627897);
    this.ag.a(new TroopNotificationFragment.25(this));
  }
  
  private void E()
  {
    this.af = ((SlideAndOverScrollRecyclerView)this.ap.findViewById(2131446647));
    this.af.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
    this.af.addOnScrollListener(new TroopNotificationFragment.28(this));
    this.j = ((IQQAvatarService)this.an.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.ao);
    this.j.setDecodeTaskCompletionListener(this);
    this.af.setVisibility(8);
  }
  
  private void F()
  {
    this.ah = GroupSystemMsgController.a().c(this.an);
    this.af.setAdapter(this.ag);
    Object localObject = (IMessageFacade)this.an.getRuntimeService(IMessageFacade.class, "");
    if (localObject != null) {
      this.e = ((IMessageFacade)localObject).getMsgList(AppConstants.TROOP_SUSPICIOUS_MSG_UIN, 0);
    }
    TroopSuspiciousHelper.a(this.e, this.ao);
    localObject = new ArrayList();
    int i1 = 0;
    while (i1 < this.e.size())
    {
      List localList = this.e;
      ((List)localObject).add(localList.get(localList.size() - i1 - 1));
      i1 += 1;
    }
    this.e = ((List)localObject);
    localObject = this.e;
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      if (this.X.getVisibility() == 8) {
        ReportController.b(this.an, "dc00899", "Grp_contacts_news", "", "notice", "unnormal_tab_exp", 0, 0, "", "", "", "");
      }
      this.X.setVisibility(0);
      if (!(this.e.get(0) instanceof MessageForSystemMsg))
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopNotificationFragment", 2, "initListData error");
        }
        localObject = (ITroopSysMsgDependApiService)this.an.getRuntimeService(ITroopSysMsgDependApiService.class, "");
        if (localObject != null) {
          ((ITroopSysMsgDependApiService)localObject).clearGroupSystemMsgHistory();
        }
        this.ag.a(null);
      }
    }
    else
    {
      this.X.setVisibility(8);
    }
    this.ag.a(this.e);
    this.ag.notifyDataSetChanged();
    C();
  }
  
  private void G()
  {
    if (this.k) {
      return;
    }
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      localObject = this.g;
      QQToast.makeText((Context)localObject, ((Context)localObject).getResources().getString(2131917675), 0).show(b());
      return;
    }
    Object localObject = (ITroopNotificationService)this.an.getRuntimeService(ITroopNotificationService.class, "");
    if ((localObject != null) && (((ITroopNotificationService)localObject).isTroopSuspiciousNotificaitonGetAll())) {
      return;
    }
    this.k = true;
    localObject = this.ag;
    if (localObject != null) {
      ((SuspiciousAdapter)localObject).a(new TroopNotificationFragment.30(this));
    }
    localObject = (IMessageHandler)this.an.getRuntimeService(IMessageHandler.class, "");
    if (localObject != null) {
      ((IMessageHandler)localObject).sendGetNextGroupSystemMsgForSus();
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotificationFragment", 2, "loadNextPage.get next page.");
    }
  }
  
  private void H()
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotificationFragment", 2, "stopLoadMore().");
    }
    SuspiciousAdapter localSuspiciousAdapter = this.ag;
    if (localSuspiciousAdapter != null) {
      localSuspiciousAdapter.c();
    }
    this.k = false;
  }
  
  private void I()
  {
    ThreadManager.post(new TroopNotificationFragment.31(this), 8, null, false);
  }
  
  private void J()
  {
    this.ai = GroupSystemMsgController.a().c(this.an);
    MqqHandler localMqqHandler = this.w;
    if (localMqqHandler != null) {
      localMqqHandler.sendEmptyMessage(1012);
    }
  }
  
  public static List<MessageRecord> a(List<MessageRecord> paramList1, List<MessageRecord> paramList2)
  {
    if (paramList1 != null)
    {
      if (paramList2 == null) {
        return paramList1;
      }
      if (b(paramList1) >= b(paramList2))
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
    paramStructMsg = (ITroopSysMsgDependApiService)this.an.getRuntimeService(ITroopSysMsgDependApiService.class, "");
    if (paramStructMsg != null) {
      paramStructMsg.followPublicAccountReq(this.an, paramLong, new TroopNotificationFragment.18(this), localBundle);
    }
  }
  
  private void a(RecyclerView paramRecyclerView, String paramString, Bitmap paramBitmap)
  {
    if (this.i == 0)
    {
      int i2 = paramRecyclerView.getChildCount();
      int i1 = 0;
      while (i1 < i2)
      {
        Object localObject = paramRecyclerView.findViewHolderForAdapterPosition(i1);
        if ((localObject != null) && ((localObject instanceof SuspiciousHolder)))
        {
          SuspiciousHolder localSuspiciousHolder = (SuspiciousHolder)localObject;
          int i3 = TroopNotificationUtils.a(localSuspiciousHolder.a);
          if (i3 != 1)
          {
            if (i3 != 2) {
              localObject = String.valueOf(localSuspiciousHolder.g.msg.group_code.get());
            } else {
              localObject = localSuspiciousHolder.d;
            }
          }
          else {
            localObject = String.valueOf(localSuspiciousHolder.g.msg.action_uin.get());
          }
          if ((localSuspiciousHolder.j != null) && (paramString.equals(localObject)))
          {
            localSuspiciousHolder.j.setImageBitmap(paramBitmap);
            return;
          }
        }
        i1 += 1;
      }
    }
  }
  
  private void a(BusinessObserver paramBusinessObserver)
  {
    AppInterface localAppInterface = this.ao;
    if ((localAppInterface != null) && (paramBusinessObserver != null)) {
      localAppInterface.addObserver(paramBusinessObserver);
    }
  }
  
  private void a(TroopNotifyApplicantInfo paramTroopNotifyApplicantInfo, NotifyAndRecAdapter.ApplicantHolder paramApplicantHolder)
  {
    int i1 = paramTroopNotifyApplicantInfo.f();
    Object localObject = paramTroopNotifyApplicantInfo.e();
    String str1 = paramTroopNotifyApplicantInfo.c();
    String str2 = paramTroopNotifyApplicantInfo.d();
    String str3 = String.valueOf(paramTroopNotifyApplicantInfo.b());
    if (paramTroopNotifyApplicantInfo.j()) {
      paramApplicantHolder.e.setVisibility(0);
    } else {
      paramApplicantHolder.e.setVisibility(8);
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
      if (paramApplicantHolder.d != null)
      {
        paramApplicantHolder.d.setText(paramTroopNotifyApplicantInfo);
        paramApplicantHolder.d.setVisibility(0);
      }
    }
    else if (paramApplicantHolder.d != null)
    {
      paramApplicantHolder.d.setVisibility(8);
    }
    if (paramApplicantHolder.c != null) {
      if ((!str3.isEmpty()) && ((i1 == 1) || (i1 == 2)))
      {
        paramTroopNotifyApplicantInfo = (TextView)paramApplicantHolder.c.findViewById(2131441359);
        localObject = (ImageView)paramApplicantHolder.c.findViewById(2131441358);
        if ((localObject != null) && (paramTroopNotifyApplicantInfo != null))
        {
          if (i1 == 1)
          {
            ((ImageView)localObject).setImageResource(2130847525);
            paramApplicantHolder.c.setBackgroundResource(2130843495);
          }
          else if (i1 == 2)
          {
            ((ImageView)localObject).setImageResource(2130847523);
            paramApplicantHolder.c.setBackgroundResource(2130843494);
          }
          paramTroopNotifyApplicantInfo.setText(str3);
          paramApplicantHolder.c.setVisibility(0);
        }
      }
      else
      {
        paramApplicantHolder.c.setVisibility(8);
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
      localSuspiciousHolder.g = ((MessageForSystemMsg)localObject1).getSystemMsg();
      localSuspiciousHolder.h = paramMessageRecord.uniseq;
      int i1;
      if (paramMessageRecord != null) {
        i1 = ((MessageForSystemMsg)localObject1).getSystemMsg().msg_type.get();
      } else {
        i1 = 2;
      }
      if (i1 == 2)
      {
        if (paramInt < this.ai) {
          NotifyAndRecAdapter.a(paramViewHolder.a(), true);
        } else {
          NotifyAndRecAdapter.a(paramViewHolder.a(), false);
        }
        localObject1 = localSuspiciousHolder.g;
        localSuspiciousHolder.b = paramInt;
        paramMessageRecord = new StringBuilder();
        paramMessageRecord.append(((structmsg.StructMsg)localObject1).req_uin.get());
        paramMessageRecord.append("");
        localSuspiciousHolder.d = paramMessageRecord.toString();
        localSuspiciousHolder.a = ((structmsg.StructMsg)localObject1).msg.group_msg_type.get();
        paramInt = ((structmsg.StructMsg)localObject1).msg.sub_type.get();
        localSuspiciousHolder.c = ((structmsg.StructMsg)localObject1).msg_time.get();
        localSuspiciousHolder.e = ((structmsg.StructMsg)localObject1).msg.req_uin_nick.get();
        if ((localSuspiciousHolder.e == null) || (localSuspiciousHolder.e.equals(""))) {
          localSuspiciousHolder.e = localSuspiciousHolder.d;
        }
        a(localSuspiciousHolder, (structmsg.StructMsg)localObject1);
        localSuspiciousHolder.m.setVisibility(8);
        Object localObject2 = ((structmsg.StructMsg)localObject1).msg.group_info.msg_alert.get();
        if (((structmsg.StructMsg)localObject1).msg.bytes_warning_tips.get() != null) {
          paramMessageRecord = ((structmsg.StructMsg)localObject1).msg.bytes_warning_tips.get().toStringUtf8();
        } else {
          paramMessageRecord = "";
        }
        if (TextUtils.isEmpty(paramMessageRecord))
        {
          localSuspiciousHolder.o.setVisibility(8);
        }
        else
        {
          localSuspiciousHolder.o.setVisibility(0);
          localSuspiciousHolder.o.setText(paramMessageRecord);
          paramMessageRecord = this.g.getResources().getDrawable(2130849705);
          paramMessageRecord.setBounds(0, 0, ViewUtils.dip2px(16.0F), ViewUtils.dip2px(16.0F));
          localSuspiciousHolder.o.setCompoundDrawablePadding(ViewUtils.dip2px(5.0F));
          localSuspiciousHolder.o.setCompoundDrawables(paramMessageRecord, null, null, null);
        }
        Object localObject3;
        if (localSuspiciousHolder.a == 22)
        {
          paramMessageRecord = ((structmsg.StructMsg)localObject1).msg;
          localSuspiciousHolder.o.setVisibility(0);
          localObject3 = new SpannableString(this.an.getApp().getString(2131916973, new Object[] { paramMessageRecord.action_uin_nick.get() }));
          ((SpannableString)localObject3).setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), 6, paramMessageRecord.action_uin_nick.get().length() + 6, 33);
          localSuspiciousHolder.o.setText((CharSequence)localObject3);
          localSuspiciousHolder.o.setOnClickListener(new TroopNotificationFragment.26(this, paramMessageRecord));
        }
        else if ((localSuspiciousHolder.a == 2) && (((structmsg.StructMsg)localObject1).msg.msg_invite_extinfo.uint32_src_type.has()))
        {
          i1 = ((structmsg.StructMsg)localObject1).msg.msg_invite_extinfo.uint32_src_type.get();
          if (i1 != 0)
          {
            StringBuilder localStringBuilder;
            if (i1 != 1)
            {
              if (i1 == 2)
              {
                paramMessageRecord = (IDiscussionService)this.an.getRuntimeService(IDiscussionService.class, "");
                if (paramMessageRecord != null) {
                  paramMessageRecord = paramMessageRecord.getDiscussionName(String.valueOf(((structmsg.StructMsg)localObject1).msg.msg_invite_extinfo.uint64_src_code.get()));
                } else {
                  paramMessageRecord = "";
                }
                localObject3 = localSuspiciousHolder.o;
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(HardCodeUtil.a(2131905440));
                localStringBuilder.append(paramMessageRecord);
                ((TextView)localObject3).setText(localStringBuilder.toString());
                localSuspiciousHolder.o.setVisibility(0);
              }
            }
            else
            {
              paramMessageRecord = (ITroopInfoService)this.an.getRuntimeService(ITroopInfoService.class, "");
              if (paramMessageRecord != null) {
                paramMessageRecord = paramMessageRecord.getTroopNameByID(String.valueOf(((structmsg.StructMsg)localObject1).msg.msg_invite_extinfo.uint64_src_code.get()));
              } else {
                paramMessageRecord = "";
              }
              localObject3 = localSuspiciousHolder.o;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append(HardCodeUtil.a(2131905451));
              localStringBuilder.append(paramMessageRecord);
              ((TextView)localObject3).setText(localStringBuilder.toString());
              localSuspiciousHolder.o.setVisibility(0);
            }
          }
        }
        a(localSuspiciousHolder.t, (structmsg.StructMsg)localObject1, true);
        paramMessageRecord = TroopSystemMsgUtils.a((structmsg.StructMsg)localObject1, ((structmsg.StructMsg)localObject1).msg.msg_describe.get());
        if (paramMessageRecord != null)
        {
          localSuspiciousHolder.n.setText(paramMessageRecord);
        }
        else
        {
          paramMessageRecord = ((structmsg.StructMsg)localObject1).msg.msg_additional.get();
          if ((paramMessageRecord != null) && (!"".equals(paramMessageRecord))) {
            localSuspiciousHolder.n.setText(paramMessageRecord);
          } else {
            localSuspiciousHolder.n.setText(this.g.getString(2131893956));
          }
        }
        if (localSuspiciousHolder.a == 80)
        {
          paramMessageRecord = ((structmsg.StructMsg)localObject1).msg.actions.get();
          localSuspiciousHolder.q.setClickable(true);
          localSuspiciousHolder.q.setText(((structmsg.SystemMsgAction)paramMessageRecord.get(0)).name.get());
          localSuspiciousHolder.q.setTextAppearance(this.g, 2131952365);
          localSuspiciousHolder.q.setBackgroundResource(2130839494);
          paramMessageRecord = localSuspiciousHolder.q;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(localSuspiciousHolder.q.getText());
          ((StringBuilder)localObject2).append("");
          paramMessageRecord.setContentDescription(((StringBuilder)localObject2).toString());
          localSuspiciousHolder.q.setTag(localSuspiciousHolder);
          localSuspiciousHolder.q.setOnClickListener(this.P);
        }
        for (;;)
        {
          break;
          if (paramInt == 1)
          {
            paramMessageRecord = ((structmsg.StructMsg)localObject1).msg.actions.get();
            localSuspiciousHolder.q.setClickable(true);
            if ((paramMessageRecord != null) && (paramMessageRecord.size() > 0))
            {
              if ((localObject2 != null) && (!"".equals(localObject2)))
              {
                localSuspiciousHolder.q.setText(((structmsg.SystemMsgAction)paramMessageRecord.get(0)).name.get());
                localSuspiciousHolder.q.setTextAppearance(this.g, 2131952364);
                localSuspiciousHolder.q.setBackgroundResource(2130839493);
              }
              else if (paramMessageRecord.size() > 1)
              {
                localSuspiciousHolder.q.setText(((structmsg.SystemMsgAction)paramMessageRecord.get(1)).name.get());
                localSuspiciousHolder.q.setTextAppearance(this.g, 2131952365);
                localSuspiciousHolder.q.setBackgroundResource(2130839494);
              }
              else
              {
                localSuspiciousHolder.q.setText("");
              }
              paramMessageRecord = localSuspiciousHolder.q;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append(localSuspiciousHolder.q.getText());
              ((StringBuilder)localObject2).append("");
              paramMessageRecord.setContentDescription(((StringBuilder)localObject2).toString());
              localSuspiciousHolder.q.setTag(paramViewHolder);
              localSuspiciousHolder.q.setOnClickListener(this.P);
            }
            else
            {
              localSuspiciousHolder.q.setText("");
              localSuspiciousHolder.q.setBackgroundDrawable(null);
            }
          }
          else
          {
            localSuspiciousHolder.q.setBackgroundDrawable(null);
            localSuspiciousHolder.q.setClickable(false);
            localSuspiciousHolder.q.setTextAppearance(this.g, 2131953562);
            localSuspiciousHolder.q.setText(((structmsg.StructMsg)localObject1).msg.msg_decided.get());
            paramMessageRecord = (RelativeLayout.LayoutParams)localSuspiciousHolder.q.getLayoutParams();
          }
        }
        if (TextUtils.isEmpty(localSuspiciousHolder.q.getText())) {
          localSuspiciousHolder.q.setVisibility(8);
        } else {
          localSuspiciousHolder.q.setVisibility(0);
        }
        if ((paramInt == 2) && (localSuspiciousHolder.a == 2))
        {
          paramMessageRecord = (ITroopInfoService)this.an.getRuntimeService(ITroopInfoService.class, "");
          if (paramMessageRecord != null) {
            paramMessageRecord = paramMessageRecord.findTroopInfo(String.valueOf(((structmsg.StructMsg)localObject1).msg.group_code.get()));
          } else {
            paramMessageRecord = null;
          }
          if (paramMessageRecord != null) {
            TroopRemindSettingManager.a().c(String.valueOf(((structmsg.StructMsg)localObject1).msg.group_code.get()), this.ao);
          }
        }
        localSuspiciousHolder.i.setTag(paramViewHolder);
        localSuspiciousHolder.j.setTag(paramViewHolder);
        localSuspiciousHolder.j.setOnClickListener(this.O);
        a(localSuspiciousHolder);
      }
    }
  }
  
  private void a(NotifyAndRecAdapter.ApplicantHolder paramApplicantHolder, structmsg.StructMsg paramStructMsg, boolean paramBoolean)
  {
    if ((this.an != null) && (paramApplicantHolder != null) && (paramStructMsg != null))
    {
      if (paramApplicantHolder.a == null) {
        return;
      }
      ITroopNotificationService localITroopNotificationService = (ITroopNotificationService)this.an.getRuntimeService(ITroopNotificationService.class, "");
      if (localITroopNotificationService == null) {
        return;
      }
      int i1 = paramStructMsg.msg.group_msg_type.get();
      if ((!TroopNotifyHelper.d(i1)) && (!paramBoolean)) {
        return;
      }
      long l1;
      if (i1 == 2)
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
        if (!this.al)
        {
          paramApplicantHolder = new Message();
          paramApplicantHolder.what = 1016;
          this.w.sendMessageDelayed(paramApplicantHolder, 2000L);
          this.al = true;
        }
        return;
      }
      paramApplicantHolder.a.setVisibility(0);
      if (paramStructMsg.h())
      {
        a(paramStructMsg, paramApplicantHolder);
        i1 = 0;
      }
      else
      {
        localITroopNotificationService.addLackApplicantInfoUinToCacheBy0x5eb(Long.valueOf(l1));
        if (paramApplicantHolder.d != null) {
          paramApplicantHolder.c.setVisibility(8);
        }
        if (paramApplicantHolder.c != null) {
          paramApplicantHolder.c.setVisibility(8);
        }
        i1 = 1;
      }
      int i2;
      if (paramStructMsg.i())
      {
        i2 = paramStructMsg.g();
        paramStructMsg = new StringBuilder();
        paramStructMsg.append("LV");
        paramStructMsg.append(String.valueOf(i2));
        paramStructMsg = paramStructMsg.toString();
        i2 = i1;
        if (paramApplicantHolder.b != null)
        {
          paramApplicantHolder.b.setText(paramStructMsg);
          paramApplicantHolder.b.setVisibility(0);
          i2 = i1;
        }
      }
      else
      {
        localITroopNotificationService.addLackApplicantInfoUinToCacheBy0x668(Long.valueOf(l1));
        if (paramApplicantHolder.b != null) {
          paramApplicantHolder.b.setVisibility(8);
        }
        i2 = 1;
      }
      if ((!this.al) && (i2 != 0))
      {
        paramApplicantHolder = new Message();
        paramApplicantHolder.what = 1016;
        this.w.sendMessageDelayed(paramApplicantHolder, 2000L);
        this.al = true;
      }
    }
  }
  
  private void a(NotifyAndRecAdapter.ViewHolder paramViewHolder, structmsg.StructMsg paramStructMsg)
  {
    String str = TroopSystemMsgUtils.a(paramStructMsg, paramStructMsg.msg.msg_describe.get());
    if (paramViewHolder.b == 91)
    {
      b(paramViewHolder);
      return;
    }
    if (str != null)
    {
      paramViewHolder.l.setText(str);
      return;
    }
    paramStructMsg = paramStructMsg.msg.msg_additional.get();
    if ((paramStructMsg != null) && (!"".equals(paramStructMsg)))
    {
      paramViewHolder.l.setText(paramStructMsg);
      return;
    }
    paramViewHolder.l.setText(this.g.getString(2131893956));
  }
  
  private void a(NotifyAndRecAdapter.ViewHolder paramViewHolder, structmsg.StructMsg paramStructMsg, int paramInt)
  {
    if (!(paramViewHolder.u instanceof AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo))
    {
      paramViewHolder.p.setVisibility(8);
      return;
    }
    Object localObject = (AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)paramViewHolder.u;
    if (((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).m == 1)
    {
      int i1 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).e;
      paramStructMsg = "";
      if ((i1 == 1) && (paramInt == 1))
      {
        paramViewHolder.p.setClickable(true);
        paramViewHolder.p.setTextAppearance(this.g, 2131952365);
        paramViewHolder.p.setBackgroundResource(2130839494);
        paramViewHolder.p.setText(this.g.getString(2131897560));
        paramStructMsg = paramViewHolder.p;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramViewHolder.p.getText());
        ((StringBuilder)localObject).append("");
        paramStructMsg.setContentDescription(((StringBuilder)localObject).toString());
        paramViewHolder.p.setTag(paramViewHolder);
        paramViewHolder.p.setOnClickListener(this.C);
      }
      else
      {
        if (paramInt == 2) {
          paramStructMsg = this.g.getString(2131897557);
        } else if (paramInt == 3) {
          paramStructMsg = this.g.getString(2131897559);
        } else if (paramInt == 4) {
          paramStructMsg = this.g.getString(2131897558);
        }
        paramViewHolder.p.setBackgroundDrawable(null);
        paramViewHolder.p.setClickable(false);
        paramViewHolder.p.setTextAppearance(this.g, 2131953562);
        paramViewHolder.p.setText(paramStructMsg);
      }
    }
    else if (((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).m == 2)
    {
      paramViewHolder.p.setBackgroundDrawable(null);
      paramViewHolder.p.setClickable(false);
      paramViewHolder.p.setTextAppearance(this.g, 2131953562);
      paramViewHolder.p.setText(paramStructMsg.msg.msg_decided.get());
    }
    else
    {
      paramStructMsg = new StringBuilder();
      paramStructMsg.append("setSecondLineText reqSubMsgType:");
      paramStructMsg.append(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).m);
      QLog.d("TroopNotificationFragment", 2, paramStructMsg.toString());
    }
    paramStructMsg = (RelativeLayout.LayoutParams)paramViewHolder.p.getLayoutParams();
    if (paramStructMsg != null)
    {
      paramStructMsg.addRule(11);
      paramStructMsg.rightMargin = DisplayUtil.a(this.g, 16.0F);
      paramViewHolder.p.setLayoutParams(paramStructMsg);
    }
    paramViewHolder.p.setVisibility(0);
  }
  
  private void a(NotifyAndRecAdapter.ViewHolder paramViewHolder, structmsg.StructMsg paramStructMsg, int paramInt, String paramString)
  {
    if (paramViewHolder.b == 91)
    {
      a(paramViewHolder, paramStructMsg, paramInt);
      return;
    }
    if (paramViewHolder.b == 80)
    {
      paramStructMsg = paramStructMsg.msg.actions.get();
      paramViewHolder.p.setClickable(true);
      paramViewHolder.p.setText(((structmsg.SystemMsgAction)paramStructMsg.get(0)).name.get());
      paramViewHolder.p.setTextAppearance(this.g, 2131952365);
      paramViewHolder.p.setBackgroundResource(2130839494);
      paramStructMsg = paramViewHolder.p;
      paramString = new StringBuilder();
      paramString.append(paramViewHolder.p.getText());
      paramString.append("");
      paramStructMsg.setContentDescription(paramString.toString());
      paramViewHolder.p.setTag(paramViewHolder);
      paramViewHolder.p.setOnClickListener(this.C);
    }
    else
    {
      if (paramInt != 1) {
        break label495;
      }
      paramStructMsg = paramStructMsg.msg.actions.get();
      paramViewHolder.p.setClickable(true);
      if ((paramStructMsg != null) && (paramStructMsg.size() > 0))
      {
        if ((paramString != null) && (!"".equals(paramString)))
        {
          paramViewHolder.p.setText(((structmsg.SystemMsgAction)paramStructMsg.get(0)).name.get());
          paramViewHolder.p.setTextAppearance(this.g, 2131952364);
          paramViewHolder.p.setBackgroundResource(2130839493);
        }
        else if (paramStructMsg.size() > 1)
        {
          paramViewHolder.p.setText(((structmsg.SystemMsgAction)paramStructMsg.get(1)).name.get());
          paramViewHolder.p.setTextAppearance(this.g, 2131952365);
          paramViewHolder.p.setBackgroundResource(2130839494);
        }
        else
        {
          paramViewHolder.p.setText("");
        }
        paramStructMsg = paramViewHolder.p;
        paramString = new StringBuilder();
        paramString.append(paramViewHolder.p.getText());
        paramString.append("");
        paramStructMsg.setContentDescription(paramString.toString());
        paramViewHolder.p.setTag(paramViewHolder);
        paramViewHolder.p.setOnClickListener(this.C);
      }
      else
      {
        paramViewHolder.p.setText("");
        paramViewHolder.p.setBackgroundDrawable(null);
      }
    }
    paramStructMsg = (RelativeLayout.LayoutParams)paramViewHolder.p.getLayoutParams();
    if (paramStructMsg != null)
    {
      paramStructMsg.addRule(11);
      paramStructMsg.rightMargin = DisplayUtil.a(this.g, 16.0F);
      paramViewHolder.p.setLayoutParams(paramStructMsg);
    }
    if (TextUtils.isEmpty(paramViewHolder.p.getText()))
    {
      paramViewHolder.p.setVisibility(8);
      return;
    }
    paramViewHolder.p.setVisibility(0);
    return;
    label495:
    paramViewHolder.p.setBackgroundDrawable(null);
    paramViewHolder.p.setClickable(false);
    paramViewHolder.p.setTextAppearance(this.g, 2131953562);
    paramViewHolder.p.setText(paramStructMsg.msg.msg_decided.get());
  }
  
  private void a(NotifyAndRecAdapter.ViewHolder paramViewHolder, structmsg.StructMsg paramStructMsg, String paramString)
  {
    if (paramViewHolder.b == 91)
    {
      c(paramViewHolder);
      return;
    }
    int i1 = paramViewHolder.b;
    String str = "";
    if (i1 == 11)
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
    else if ((!TextUtils.isEmpty(paramString)) && ((paramViewHolder.b == 1) || (paramViewHolder.b == 22)))
    {
      paramViewHolder.m.setTextAppearance(this.g, 2131953563);
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
      if ((paramViewHolder.b == 12) || (paramViewHolder.b == 83)) {
        ((List)localObject).add(paramStructMsg.msg.msg_detail.get());
      }
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramString = (String)((Iterator)localObject).next();
        if ((paramString != null) && (!paramString.isEmpty())) {
          break label327;
        }
      }
      paramString = "";
    }
    label327:
    Object localObject = paramString;
    if (paramStructMsg.msg.pic_url.has()) {
      if (!TextUtils.isEmpty(paramString))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131912943));
        ((StringBuilder)localObject).append(paramString);
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = HardCodeUtil.a(2131912944);
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      paramViewHolder.m.setSingleLine(true);
      paramViewHolder.m.setText((CharSequence)localObject);
      paramViewHolder.m.setVisibility(0);
    }
    else
    {
      paramViewHolder.m.setVisibility(8);
    }
    if (paramViewHolder.b == 22)
    {
      paramStructMsg = paramStructMsg.msg;
      paramViewHolder.m.setVisibility(0);
      paramString = new SpannableString(this.an.getApp().getString(2131916973, new Object[] { paramStructMsg.action_uin_nick.get() }));
      paramString.setSpan(new ForegroundColorSpan(Color.parseColor("#00a5e0")), 5, paramStructMsg.action_uin_nick.get().length() + 6, 33);
      paramViewHolder.m.setText(paramString);
      paramViewHolder.m.setOnClickListener(new TroopNotificationFragment.15(this, paramStructMsg));
      return;
    }
    if ((paramViewHolder.b == 2) && (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
    {
      i1 = paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get();
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 2) {
            return;
          }
          paramString = (IDiscussionService)this.an.getRuntimeService(IDiscussionService.class, "");
          if (paramString != null) {
            str = paramString.getDiscussionName(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
          }
          paramStructMsg = paramViewHolder.m;
          paramString = new StringBuilder();
          paramString.append(HardCodeUtil.a(2131912945));
          paramString.append(str);
          paramStructMsg.setText(paramString.toString());
          paramViewHolder.m.setVisibility(0);
          return;
        }
        paramString = (ITroopInfoService)this.an.getRuntimeService(ITroopInfoService.class, "");
        if (paramString != null) {
          str = paramString.getTroopNameByID(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()));
        }
        paramStructMsg = paramViewHolder.m;
        paramString = new StringBuilder();
        paramString.append(HardCodeUtil.a(2131912947));
        paramString.append(str);
        paramStructMsg.setText(paramString.toString());
        paramViewHolder.m.setVisibility(0);
      }
    }
  }
  
  private void a(SuspiciousHolder paramSuspiciousHolder)
  {
    if (paramSuspiciousHolder == null) {
      return;
    }
    int i2 = TroopNotificationUtils.a(paramSuspiciousHolder.a);
    int i1 = 1;
    Object localObject2;
    if (i2 != 1)
    {
      if (i2 != 2)
      {
        localObject1 = String.valueOf(paramSuspiciousHolder.g.msg.group_code.get());
        i1 = 4;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramSuspiciousHolder.g.msg.group_name.get());
        ((StringBuilder)localObject2).append(this.g.getString(2131894292));
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject1 = paramSuspiciousHolder.d;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramSuspiciousHolder.g.msg.req_uin_nick.get());
        ((StringBuilder)localObject2).append(this.g.getString(2131894291));
        localObject2 = ((StringBuilder)localObject2).toString();
      }
    }
    else
    {
      localObject1 = String.valueOf(paramSuspiciousHolder.g.msg.action_uin.get());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramSuspiciousHolder.g.msg.action_uin_nick.get());
      ((StringBuilder)localObject2).append(this.g.getString(2131894290));
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    Object localObject1 = TroopNotificationUtils.a(this.j, (String)localObject1, i1);
    paramSuspiciousHolder.j.setContentDescription((CharSequence)localObject2);
    paramSuspiciousHolder.j.setImageDrawable((Drawable)localObject1);
  }
  
  private void a(SuspiciousHolder paramSuspiciousHolder, structmsg.StructMsg paramStructMsg)
  {
    if (paramSuspiciousHolder != null)
    {
      if (paramStructMsg == null) {
        return;
      }
      if ((paramSuspiciousHolder.a == 2) && (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
      {
        Object localObject2 = paramStructMsg.msg.action_uin_qq_nick.get().toStringUtf8();
        i1 = paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get();
        Object localObject1;
        if (i1 != 0)
        {
          Object localObject3;
          if (i1 != 1)
          {
            if (i1 != 2)
            {
              localObject1 = localObject2;
            }
            else
            {
              localObject3 = (IDiscussionService)this.an.getRuntimeService(IDiscussionService.class, "");
              localObject1 = localObject2;
              if (localObject3 != null) {
                localObject1 = ((IDiscussionService)localObject3).getDiscussionMemberName(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(paramStructMsg.msg.action_uin.get()));
              }
            }
          }
          else
          {
            Object localObject4 = (ITroopInfoService)this.an.getRuntimeService(ITroopInfoService.class, "");
            localObject1 = localObject2;
            if (localObject4 != null)
            {
              localObject3 = String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get());
              String str = String.valueOf(paramStructMsg.msg.action_uin.get());
              localObject1 = ((ITroopInfoService)localObject4).getTroopCodeByTroopUin((String)localObject3);
              localObject4 = (ITroopSysMsgDependApiService)this.an.getRuntimeService(ITroopSysMsgDependApiService.class, "");
              paramStructMsg = (structmsg.StructMsg)localObject2;
              if (localObject4 != null) {
                paramStructMsg = ((ITroopSysMsgDependApiService)localObject4).getTroopNickName(str, (String)localObject3, (String)localObject1, true, null);
              }
              localObject1 = paramStructMsg;
              if (TextUtils.isEmpty(paramStructMsg))
              {
                localObject2 = (ITroopMemberNameService)this.an.getRuntimeService(ITroopMemberNameService.class, "");
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
        paramSuspiciousHolder.l.setText((CharSequence)localObject1);
        return;
      }
      int i1 = TroopNotificationUtils.a(paramSuspiciousHolder.a);
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            paramSuspiciousHolder.l.setText(paramSuspiciousHolder.e);
            return;
          }
          paramSuspiciousHolder.l.setText(paramSuspiciousHolder.e);
          return;
        }
        paramSuspiciousHolder.l.setText(paramStructMsg.msg.action_uin_nick.get());
        return;
      }
      paramSuspiciousHolder.l.setText(paramStructMsg.msg.group_name.get());
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
      GroupSystemMsgController.a().c((String)localObject);
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
  
  private boolean a(int paramInt, structmsg.StructMsg paramStructMsg)
  {
    boolean bool2;
    if (paramStructMsg != null)
    {
      int i1 = paramStructMsg.msg_type.get();
      long l1 = paramStructMsg.msg_seq.get();
      long l2 = paramStructMsg.req_uin.get();
      int i2 = paramStructMsg.msg.sub_type.get();
      int i3 = paramStructMsg.msg.src_id.get();
      int i4 = paramStructMsg.msg.sub_src_id.get();
      int i5 = paramStructMsg.msg.group_msg_type.get();
      Object localObject = paramStructMsg.msg.actions.get();
      IMessageHandler localIMessageHandler;
      boolean bool1;
      if ((localObject != null) && (paramInt < ((List)localObject).size()))
      {
        localIMessageHandler = (IMessageHandler)this.an.getRuntimeService(IMessageHandler.class, "");
        if (localIMessageHandler != null) {
          localIMessageHandler.sendGroupSystemMsgAction(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(paramInt)).action_info.get(), paramInt);
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
        localIMessageHandler = (IMessageHandler)this.an.getRuntimeService(IMessageHandler.class, "");
        if (localIMessageHandler != null) {
          localIMessageHandler.sendGroupSystemMsgAction(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgActionInfo)localObject).get(), paramInt);
        }
        bool1 = false;
      }
      bool2 = bool1;
      if (i3 == 116)
      {
        bool2 = bool1;
        if (i4 == 0)
        {
          ReportController.b(this.an, "P_CliOper", "Grp_discuss", "", "verify_msg", "Clk_agree", 0, 0, String.valueOf(paramStructMsg.msg.group_code.get()), "", "", "");
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
  
  public static long b(List<MessageRecord> paramList)
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
  
  private void b(BusinessObserver paramBusinessObserver)
  {
    AppInterface localAppInterface = this.ao;
    if ((localAppInterface != null) && (paramBusinessObserver != null)) {
      localAppInterface.removeObserver(paramBusinessObserver);
    }
  }
  
  private void b(NotifyAndRecAdapter.ViewHolder paramViewHolder)
  {
    if (!(paramViewHolder.u instanceof AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo))
    {
      paramViewHolder.l.setVisibility(8);
      return;
    }
    Object localObject = (AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)paramViewHolder.u;
    StringBuilder localStringBuilder;
    if (((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).m == 1)
    {
      localObject = paramViewHolder.l;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.g.getString(2131897555));
      localStringBuilder.append(" ");
      localStringBuilder.append(this.g.getString(2131897553));
      ((TextView)localObject).setText(localStringBuilder.toString());
    }
    else if (((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).m == 2)
    {
      if (((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).e == 2)
      {
        localObject = paramViewHolder.l;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.g.getString(2131897562));
        localStringBuilder.append(" ");
        localStringBuilder.append(this.g.getString(2131897552));
        ((TextView)localObject).setText(localStringBuilder.toString());
      }
      else if (((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject).e == 3)
      {
        localObject = paramViewHolder.l;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.g.getString(2131897564));
        localStringBuilder.append(" ");
        localStringBuilder.append(this.g.getString(2131897552));
        ((TextView)localObject).setText(localStringBuilder.toString());
      }
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setSecondLineText reqSubMsgType:");
      ((StringBuilder)localObject).append(paramViewHolder.u.m);
      QLog.d("TroopNotificationFragment", 2, ((StringBuilder)localObject).toString());
    }
    paramViewHolder.l.setVisibility(0);
  }
  
  private void b(NotifyAndRecAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("jumpToTroopRequestActivity!");
      ((StringBuilder)localObject).append(paramViewHolder.c);
      ((StringBuilder)localObject).append(": dealMsgType = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("TroopNotificationFragment", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new Intent(this.am, TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", paramViewHolder.c);
    localBundle.putInt("mTroopMsgType", paramViewHolder.b);
    localBundle.putString("mTroopCode", String.valueOf(paramViewHolder.r.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(paramViewHolder.r.msg.action_uin.get()));
    localBundle.putString("troopsMsg", paramViewHolder.r.msg.msg_additional.get());
    boolean bool;
    if ((this.a != null) && (paramViewHolder.q < this.a.d)) {
      bool = true;
    } else {
      bool = false;
    }
    localBundle.putBoolean("is_unread", bool);
    localBundle.putString("troopRequestUin", String.valueOf(paramViewHolder.r.req_uin.get()));
    localBundle.putString("troopsummary", paramViewHolder.r.msg.msg_describe.get());
    localBundle.putLong("infotime", paramViewHolder.d);
    localBundle.putInt("troopfromtab", this.n);
    long l1 = paramViewHolder.r.msg.action_uin.get();
    localBundle.putBoolean("troop_invitee_is_friend", a(this.o, String.valueOf(l1)));
    if (paramViewHolder.r.msg.group_msg_type.get() != 83) {
      ((Intent)localObject).putExtra("troopMsgDealInfo", paramViewHolder.r.msg.msg_detail.get());
    }
    a((structmsg.StructMsg)paramViewHolder.r.get(), paramViewHolder.s);
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
      if ((paramViewHolder.b == 91) && ((paramViewHolder.u instanceof AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)))
      {
        paramStructMsg = (AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)paramViewHolder.u;
        if (!TextUtils.isEmpty(paramStructMsg.g))
        {
          paramViewHolder.j.setText(paramStructMsg.g);
          return;
        }
        if (paramStructMsg.f > 0L)
        {
          paramViewHolder.j.setText(String.valueOf(paramStructMsg.f));
          return;
        }
        paramStructMsg = new StringBuilder();
        paramStructMsg.append("setFirstLineText ");
        paramStructMsg.append(paramViewHolder.b);
        paramStructMsg.append("reqTroopName and reqTroopCode is null");
        QLog.d("TroopNotificationFragment", 2, paramStructMsg.toString());
        return;
      }
      if ((paramViewHolder.b == 2) && (paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.has()))
      {
        Object localObject2 = paramStructMsg.msg.action_uin_qq_nick.get().toStringUtf8();
        i1 = paramStructMsg.msg.msg_invite_extinfo.uint32_src_type.get();
        Object localObject1;
        if (i1 != 0)
        {
          Object localObject3;
          if (i1 != 1)
          {
            if (i1 != 2)
            {
              localObject1 = localObject2;
            }
            else
            {
              localObject3 = (IDiscussionService)this.an.getRuntimeService(IDiscussionService.class, "");
              localObject1 = localObject2;
              if (localObject3 != null) {
                localObject1 = ((IDiscussionService)localObject3).getDiscussionMemberName(String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get()), String.valueOf(paramStructMsg.msg.action_uin.get()));
              }
            }
          }
          else
          {
            Object localObject4 = (ITroopInfoService)this.an.getRuntimeService(ITroopInfoService.class, "");
            localObject1 = localObject2;
            if (localObject4 != null)
            {
              localObject3 = String.valueOf(paramStructMsg.msg.msg_invite_extinfo.uint64_src_code.get());
              String str = String.valueOf(paramStructMsg.msg.action_uin.get());
              localObject1 = ((ITroopInfoService)localObject4).getTroopCodeByTroopUin((String)localObject3);
              localObject4 = (ITroopSysMsgDependApiService)this.an.getRuntimeService(ITroopSysMsgDependApiService.class, "");
              paramStructMsg = (structmsg.StructMsg)localObject2;
              if (localObject4 != null) {
                paramStructMsg = ((ITroopSysMsgDependApiService)localObject4).getTroopNickName(str, (String)localObject3, (String)localObject1, true, null);
              }
              localObject1 = paramStructMsg;
              if (TextUtils.isEmpty(paramStructMsg))
              {
                localObject2 = (ITroopMemberNameService)this.an.getRuntimeService(ITroopMemberNameService.class, "");
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
        paramViewHolder.j.setText((CharSequence)localObject1);
        return;
      }
      int i1 = TroopNotificationUtils.a(paramViewHolder.b);
      if (i1 != 0)
      {
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            paramViewHolder.j.setText(paramViewHolder.f);
            return;
          }
          paramViewHolder.j.setText(paramViewHolder.f);
          return;
        }
        paramViewHolder.j.setText(paramStructMsg.msg.action_uin_nick.get());
        return;
      }
      paramViewHolder.j.setText(paramStructMsg.msg.group_name.get());
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
      ((StringBuilder)localObject).append(paramSuspiciousHolder.b);
      QLog.d("TroopNotificationFragment", 2, ((StringBuilder)localObject).toString());
    }
    TroopSuspiciousHelper.a(paramSuspiciousHolder.g, "unnormal_edit");
    Object localObject = new Intent(getActivity(), TroopRequestActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putLong("troopMsgId", paramSuspiciousHolder.b);
    localBundle.putInt("mTroopMsgType", paramSuspiciousHolder.a);
    localBundle.putString("mTroopCode", String.valueOf(paramSuspiciousHolder.g.msg.group_code.get()));
    localBundle.putString("troopmanagerUin", String.valueOf(paramSuspiciousHolder.g.msg.action_uin.get()));
    localBundle.putString("troopsMsg", paramSuspiciousHolder.g.msg.msg_additional.get());
    int i1 = GroupSystemMsgController.a().b(this.an);
    boolean bool;
    if (paramSuspiciousHolder.f < i1) {
      bool = true;
    } else {
      bool = false;
    }
    localBundle.putBoolean("is_unread", bool);
    localBundle.putString("troopRequestUin", String.valueOf(paramSuspiciousHolder.g.req_uin.get()));
    localBundle.putString("troopsummary", paramSuspiciousHolder.g.msg.msg_describe.get());
    localBundle.putLong("infotime", paramSuspiciousHolder.c);
    long l1 = paramSuspiciousHolder.g.msg.action_uin.get();
    localBundle.putBoolean("troop_invitee_is_friend", a(this.o, String.valueOf(l1)));
    if (paramSuspiciousHolder.g.msg.group_msg_type.get() != 83) {
      ((Intent)localObject).putExtra("troopMsgDealInfo", paramSuspiciousHolder.g.msg.msg_detail.get());
    }
    TroopSuspiciousHelper.a((structmsg.StructMsg)paramSuspiciousHolder.g.get());
    a((structmsg.StructMsg)paramSuspiciousHolder.g.get(), paramSuspiciousHolder.h);
    localBundle.putInt("t_s_f", 1001);
    localBundle.putBoolean("troop_suspicious_request", true);
    ((Intent)localObject).putExtras(localBundle);
    startActivity((Intent)localObject);
  }
  
  private boolean b(int paramInt)
  {
    return (paramInt != 2) && (paramInt != 3);
  }
  
  private boolean b(int paramInt, structmsg.StructMsg paramStructMsg)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramStructMsg != null)
    {
      int i1 = paramStructMsg.msg_type.get();
      long l1 = paramStructMsg.msg_seq.get();
      long l2 = paramStructMsg.req_uin.get();
      int i2 = paramStructMsg.msg.sub_type.get();
      int i3 = paramStructMsg.msg.src_id.get();
      int i4 = paramStructMsg.msg.sub_src_id.get();
      int i5 = paramStructMsg.msg.group_msg_type.get();
      Object localObject = paramStructMsg.msg.actions.get();
      if ((localObject != null) && (paramInt < ((List)localObject).size()))
      {
        localObject = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject).get(paramInt)).action_info.get();
        ((structmsg.SystemMsgActionInfo)localObject).uint32_req_msg_type.set(2);
        IMessageHandler localIMessageHandler = (IMessageHandler)this.an.getRuntimeService(IMessageHandler.class, "");
        if (localIMessageHandler != null) {
          localIMessageHandler.sendGroupSystemMsgAction(i1, l1, l2, i2, i3, i4, i5, (structmsg.SystemMsgActionInfo)localObject, paramInt);
        }
        bool1 = true;
      }
      bool2 = bool1;
      if (i3 == 116)
      {
        bool2 = bool1;
        if (i4 == 0)
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
    if (!(paramViewHolder.u instanceof AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo))
    {
      paramViewHolder.m.setVisibility(8);
      return;
    }
    Object localObject3 = (AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)paramViewHolder.u;
    int i1 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject3).m;
    Object localObject2 = "";
    Object localObject1;
    if (i1 == 1)
    {
      if (!TextUtils.isEmpty(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject3).i))
      {
        localObject1 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject3).i;
      }
      else if (((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject3).h > 0L)
      {
        localObject1 = String.valueOf(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject3).h);
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("setThirdLine ");
        ((StringBuilder)localObject1).append(paramViewHolder.b);
        ((StringBuilder)localObject1).append("reqTroopOwnerNickName is Empty");
        QLog.d("TroopNotificationFragment", 2, ((StringBuilder)localObject1).toString());
        localObject1 = "";
      }
      if (!TextUtils.isEmpty(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject3).k))
      {
        localObject2 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject3).k;
      }
      else if (((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject3).j > 0L)
      {
        localObject2 = String.valueOf(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject3).j);
      }
      else
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("setThirdLine ");
        ((StringBuilder)localObject3).append(paramViewHolder.b);
        ((StringBuilder)localObject3).append("reqSourceTroopName is Empty");
        QLog.d("TroopNotificationFragment", 2, ((StringBuilder)localObject3).toString());
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.g.getString(2131897554));
      ((StringBuilder)localObject3).append(" ");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(this.g.getString(2131897551));
      ((StringBuilder)localObject3).append((String)localObject2);
      localObject1 = ((StringBuilder)localObject3).toString();
      paramViewHolder.m.setText((CharSequence)localObject1);
    }
    else if (paramViewHolder.u.m == 2)
    {
      if (!TextUtils.isEmpty(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject3).c))
      {
        localObject1 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject3).c;
      }
      else if (((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject3).d > 0L)
      {
        localObject1 = String.valueOf(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject3).d);
      }
      else
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("setThirdLine ");
        ((StringBuilder)localObject1).append(paramViewHolder.b);
        ((StringBuilder)localObject1).append("actionName is Empty");
        QLog.d("TroopNotificationFragment", 2, ((StringBuilder)localObject1).toString());
        localObject1 = localObject2;
      }
      localObject2 = paramViewHolder.m;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.g.getString(2131897548));
      ((StringBuilder)localObject3).append(" ");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((TextView)localObject2).setText(((StringBuilder)localObject3).toString());
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setThirdLine ");
      ((StringBuilder)localObject1).append(paramViewHolder.u.m);
      ((StringBuilder)localObject1).append("reqSubMsgType is error value");
      QLog.d("TroopNotificationFragment", 2, ((StringBuilder)localObject1).toString());
    }
    paramViewHolder.m.setVisibility(0);
  }
  
  private void d(NotifyAndRecAdapter.ViewHolder paramViewHolder)
  {
    if (paramViewHolder == null) {
      return;
    }
    int i1 = TroopNotificationUtils.a(paramViewHolder.b);
    if (paramViewHolder.b == 91) {
      i1 = 3;
    }
    Object localObject1;
    if (i1 != 1)
    {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          localObject2 = String.valueOf(paramViewHolder.r.msg.group_code.get());
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramViewHolder.r.msg.group_name.get());
          ((StringBuilder)localObject1).append(this.g.getString(2131894292));
        }
        for (localObject1 = ((StringBuilder)localObject1).toString();; localObject1 = ((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject1).g)
        {
          i1 = 4;
          break label274;
          if (!(paramViewHolder.u instanceof AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)) {
            break;
          }
          localObject1 = (AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)paramViewHolder.u;
          localObject2 = String.valueOf(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)localObject1).f);
        }
        localObject1 = null;
        localObject2 = localObject1;
        i1 = -1;
        break label274;
      }
      localObject2 = paramViewHolder.e;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramViewHolder.r.msg.req_uin_nick.get());
      ((StringBuilder)localObject1).append(this.g.getString(2131894291));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    else
    {
      localObject2 = String.valueOf(paramViewHolder.r.msg.action_uin.get());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramViewHolder.r.msg.action_uin_nick.get());
      ((StringBuilder)localObject1).append(this.g.getString(2131894290));
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    i1 = 1;
    label274:
    if (this.b == null) {
      BaseImageUtil.j();
    }
    AppInterface localAppInterface = this.ao;
    Drawable localDrawable = this.b;
    Object localObject2 = FaceDrawable.getFaceDrawable(localAppInterface, i1, (String)localObject2, 3, localDrawable, localDrawable);
    paramViewHolder.h.setContentDescription((CharSequence)localObject1);
    paramViewHolder.h.setImageDrawable((Drawable)localObject2);
  }
  
  private AppInterface l()
  {
    AppRuntime localAppRuntime = this.am.getAppRuntime();
    if ((localAppRuntime instanceof AppInterface)) {
      return (AppInterface)localAppRuntime;
    }
    return null;
  }
  
  private void m()
  {
    this.a = new NotifyAndRecAdapter(this.an, this.am, this.w, this);
    this.m = ((TextView)this.ap.findViewById(2131436180));
    this.m.setOnClickListener(this.at);
    this.aj = ((TextView)this.ap.findViewById(2131448219));
    this.ak = ((ImageView)this.ap.findViewById(2131436666));
    n();
    this.l = ((TextView)this.ap.findViewById(2131430750));
    this.l.setOnClickListener(this.v);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      this.ap.setFitsSystemWindows(true);
      this.ap.setPadding(0, ImmersiveUtils.getStatusBarHeight(this.g), 0, 0);
    }
    this.c = ((SwipListView)this.ap.findViewById(2131448019));
    this.U = this.ap.findViewById(2131430720);
    this.V = this.ap.findViewById(2131446706);
    this.Y = ((TextView)this.ap.findViewById(2131446709));
    this.ab = ((ImageView)this.ap.findViewById(2131446707));
    this.ae = ((TextView)this.ap.findViewById(2131446708));
    this.V.setOnClickListener(this.u);
    this.W = this.ap.findViewById(2131446701);
    this.Z = ((TextView)this.ap.findViewById(2131446704));
    this.ac = ((ImageView)this.ap.findViewById(2131446702));
    this.W.setOnClickListener(this.u);
    this.X = this.ap.findViewById(2131446710);
    this.aa = ((TextView)this.ap.findViewById(2131446711));
    this.ad = ((ImageView)this.ap.findViewById(2131446712));
    this.X.setOnClickListener(this.u);
    this.c.setDragEnable(true);
    this.c.setAdapter(this.a);
    this.c.setOnScrollListener(this);
    IStrangerService localIStrangerService = (IStrangerService)this.an.getRuntimeService(IStrangerService.class, "all");
    if (localIStrangerService != null)
    {
      localIStrangerService.getLocalList();
      localIStrangerService.getRemoteList(false);
    }
  }
  
  private void n()
  {
    ThreadManager.postImmediately(new TroopNotificationFragment.1(this, (IMessageFacade)this.an.getRuntimeService(IMessageFacade.class, "")), null, false);
  }
  
  private void o()
  {
    Object localObject1 = (ITroopNotificationService)this.an.getRuntimeService(ITroopNotificationService.class, "");
    if (localObject1 == null) {
      return;
    }
    ReportController.b(this.an, "dc00899", "Grp_contacts_news", "", "notice", "todo_tab_clk", 0, 0, "", "", "", "");
    ((ITroopNotificationService)localObject1).setUnreadUndealMsg(false);
    a(false, 1);
    this.af.setVisibility(8);
    this.c.setVisibility(0);
    if (this.n != 1)
    {
      localObject2 = this.l;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(4);
      }
      a(1);
      a(true);
      localObject2 = new ArrayList();
      this.a.b((List)localObject2);
      this.a.notifyDataSetChanged();
      this.a.a(((ITroopNotificationService)localObject1).getDataListFromClassificationCache(1));
      localObject1 = this.a;
      ((NotifyAndRecAdapter)localObject1).d = 0;
      ((NotifyAndRecAdapter)localObject1).notifyDataSetChanged();
      return;
    }
    Object localObject2 = this.l;
    if (localObject2 != null) {
      ((TextView)localObject2).setVisibility(0);
    }
    a(0);
    a(false);
    this.a.a(((ITroopNotificationService)localObject1).getDataListFromClassificationCache(0));
    this.a.d = GroupSystemMsgController.a().b(this.an);
    localObject1 = this.f;
    if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
      this.a.b(this.f);
    }
    this.a.notifyDataSetChanged();
  }
  
  private void p()
  {
    Object localObject1 = (ITroopNotificationService)this.an.getRuntimeService(ITroopNotificationService.class, "");
    if (localObject1 == null) {
      return;
    }
    ReportController.b(this.an, "dc00899", "Grp_contacts_news", "", "notice", "quit_tab_clk", 0, 0, "", "", "", "");
    this.af.setVisibility(8);
    this.c.setVisibility(0);
    if (this.n != 2)
    {
      localObject2 = this.l;
      if (localObject2 != null) {
        ((TextView)localObject2).setVisibility(4);
      }
      a(2);
      b(true);
      localObject2 = new ArrayList();
      this.a.b((List)localObject2);
      this.a.a(((ITroopNotificationService)localObject1).getDataListFromClassificationCache(2));
      localObject1 = this.a;
      ((NotifyAndRecAdapter)localObject1).d = 0;
      ((NotifyAndRecAdapter)localObject1).notifyDataSetChanged();
      return;
    }
    Object localObject2 = this.l;
    if (localObject2 != null) {
      ((TextView)localObject2).setVisibility(0);
    }
    a(0);
    b(false);
    this.a.a(((ITroopNotificationService)localObject1).getDataListFromClassificationCache(0));
    this.a.d = GroupSystemMsgController.a().b(this.an);
    localObject1 = this.f;
    if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
      this.a.b(this.f);
    }
    this.a.notifyDataSetChanged();
  }
  
  private void q()
  {
    Object localObject = (ITroopNotificationService)this.an.getRuntimeService(ITroopNotificationService.class, "");
    if (localObject == null) {
      return;
    }
    ReportController.b(this.an, "dc00899", "Grp_contacts_news", "", "notice", "unnormal_tab_clk", 0, 0, "", "", "", "");
    if (this.n != 3)
    {
      localObject = this.l;
      if (localObject != null) {
        ((TextView)localObject).setVisibility(4);
      }
      this.af.setVisibility(0);
      this.c.setVisibility(8);
      a(3);
      c(true);
      return;
    }
    TextView localTextView = this.l;
    if (localTextView != null) {
      localTextView.setVisibility(0);
    }
    this.af.setVisibility(8);
    this.c.setVisibility(0);
    a(0);
    this.a.a(((ITroopNotificationService)localObject).getDataListFromClassificationCache(0));
    this.a.d = GroupSystemMsgController.a().b(this.an);
    this.a.notifyDataSetChanged();
    c(false);
  }
  
  private void r()
  {
    Object localObject = this.an;
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
    this.al = false;
  }
  
  private void s()
  {
    Object localObject1 = this.an;
    if (localObject1 == null) {
      return;
    }
    localObject1 = (ITroopNotificationService)((AppRuntime)localObject1).getRuntimeService(ITroopNotificationService.class, "");
    Object localObject2 = this.a;
    if (localObject2 != null)
    {
      if (this.n != 0) {
        ((NotifyAndRecAdapter)localObject2).d = 0;
      } else {
        ((NotifyAndRecAdapter)localObject2).d = GroupSystemMsgController.a().b(this.an);
      }
      localObject2 = (IRecommendTroopService)this.an.getRuntimeService(IRecommendTroopService.class, "");
      if (localObject2 != null) {
        ((IRecommendTroopService)localObject2).setUnreadNum(GroupSystemMsgController.a().b(this.an));
      }
      if (localObject1 != null)
      {
        d(((ITroopNotificationService)localObject1).getDataListFromClassificationCache(2));
        c(((ITroopNotificationService)localObject1).getDataListFromClassificationCache(1));
        a(false, 1);
      }
      this.a.notifyDataSetChanged();
    }
    localObject1 = this.ag;
    if (localObject1 != null) {
      ((SuspiciousAdapter)localObject1).notifyDataSetChanged();
    }
  }
  
  private void t()
  {
    int i1 = GroupSystemMsgController.a().b(this.an);
    Object localObject = this.a;
    if (localObject != null) {
      if (this.s)
      {
        ((NotifyAndRecAdapter)localObject).d = 0;
        a(1);
      }
      else
      {
        ((NotifyAndRecAdapter)localObject).d = i1;
      }
    }
    localObject = (ITroopNotificationService)this.an.getRuntimeService(ITroopNotificationService.class, "");
    if (localObject != null)
    {
      this.d = ((ITroopNotificationService)localObject).getMessageRecordMayBeLoadDB(this.y);
      localObject = this.d;
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        u();
      }
    }
  }
  
  private void u()
  {
    Object localObject1 = this.an;
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
    if (this.n == 1)
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
      localObject1 = (ITroopSysMsgDependApiService)this.an.getRuntimeService(ITroopSysMsgDependApiService.class, "");
      if (localObject1 != null) {
        ((ITroopSysMsgDependApiService)localObject1).clearGroupSystemMsgHistory();
      }
      localObject1 = this.a;
      if (localObject1 != null)
      {
        ((NotifyAndRecAdapter)localObject1).a(null);
        this.a.notifyDataSetChanged();
      }
      return;
    }
    localObject2 = this.a;
    if (localObject2 != null)
    {
      ((NotifyAndRecAdapter)localObject2).a((List)localObject1);
      this.a.notifyDataSetChanged();
      this.a.b();
    }
    d(localList2);
    c(localList1);
    if (localITroopNotificationService.hasUnreadUndealMsg()) {
      a(true, 1);
    } else {
      a(false, 1);
    }
    C();
    v();
  }
  
  private void v()
  {
    Object localObject1 = this.an;
    if (localObject1 == null) {
      return;
    }
    localObject1 = (ITroopNotificationService)((AppRuntime)localObject1).getRuntimeService(ITroopNotificationService.class, "");
    if (localObject1 == null) {
      return;
    }
    List localList = ((ITroopNotificationService)localObject1).getMessageRecordListFromCache();
    localObject1 = this.am;
    String str1 = "2";
    String str2 = "1";
    String str3 = "3";
    if (localObject1 != null)
    {
      localObject1 = ((QBaseActivity)localObject1).getIntent();
      if (localObject1 != null)
      {
        int i1 = ((Intent)localObject1).getIntExtra("key_from", 0);
        if (i1 == 1)
        {
          localObject1 = "1";
          localObject2 = str3;
          break label322;
        }
        if (i1 == 2)
        {
          if (((Intent)localObject1).getBooleanExtra("has_red", false))
          {
            localObject1 = str1;
            localObject2 = str3;
            if (localList == null) {
              break label322;
            }
            localObject1 = str1;
            localObject2 = str3;
            if (localList.size() <= 0) {
              break label322;
            }
            localObject1 = (MessageRecord)localList.get(0);
            if ((localObject1 instanceof MessageForSystemMsg))
            {
              long l1 = ((MessageForSystemMsg)localObject1).getSystemMsg().msg.group_code.get();
              localObject1 = (ITroopInfoService)this.an.getRuntimeService(ITroopInfoService.class, "");
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
                  break label290;
                }
              }
            }
            localObject1 = "3";
            label290:
            localObject2 = localObject1;
            localObject1 = str1;
            break label322;
          }
          localObject1 = "3";
          localObject2 = str3;
          break label322;
        }
      }
    }
    localObject1 = "";
    Object localObject2 = localObject1;
    label322:
    TroopReportor.a("Grp_contacts_news", "notice", "enter_verify", 0, 0, new String[] { localObject1, localObject2 });
  }
  
  private void w()
  {
    ThreadManager.postImmediately(new TroopNotificationFragment.13(this), null, false);
  }
  
  private void x()
  {
    ITroopNotificationService localITroopNotificationService = (ITroopNotificationService)this.an.getRuntimeService(ITroopNotificationService.class, "");
    if (localITroopNotificationService == null) {
      return;
    }
    List localList1 = localITroopNotificationService.getDataListFromClassificationCache(0);
    int i1 = this.n;
    List localList2;
    if (i1 == 1)
    {
      localList2 = localITroopNotificationService.getDataListFromClassificationCache(1);
      if ((localList2 != null) && (!localList2.isEmpty()))
      {
        this.a.a(localList2);
      }
      else
      {
        a(0);
        this.a.a(localList1);
      }
    }
    else if (i1 == 2)
    {
      localList2 = localITroopNotificationService.getDataListFromClassificationCache(2);
      if ((localList2 != null) && (!localList2.isEmpty()))
      {
        this.a.a(localITroopNotificationService.getDataListFromClassificationCache(2));
      }
      else
      {
        a(0);
        this.a.a(localList1);
      }
    }
    else if (i1 == 0)
    {
      this.a.a(localList1);
    }
    this.a.notifyDataSetChanged();
    c(localITroopNotificationService.getDataListFromClassificationCache(1));
    d(localITroopNotificationService.getDataListFromClassificationCache(2));
    C();
    this.a.d = 0;
  }
  
  private void y()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TroopNotificationFragment", 2, "sendReadConfirm lll");
    }
    ThreadManager.post(new TroopNotificationFragment.14(this), 8, null, false);
    if (QLog.isColorLevel()) {
      QLog.i("TroopNotificationFragment", 2, "sendReadConfirm is end!");
    }
  }
  
  private void z()
  {
    if (this.K == null) {
      this.K = LayoutInflater.from(this.g).inflate(2131626752, null);
    }
    if (this.K.getParent() == null) {
      this.c.addFooterView(this.K);
    }
    this.K.setVisibility(8);
  }
  
  protected void a()
  {
    a(this.x);
    a(this.A);
    a(this.Q);
    z();
    t();
    this.T = new QQProgressDialog(this.g, b());
    if (TroopNotificationUtils.e(this.ao) > 0)
    {
      localObject = (IMessageHandler)this.an.getRuntimeService(IMessageHandler.class, "");
      if (localObject != null) {
        ((IMessageHandler)localObject).sendGetSystemMsg(3);
      }
    }
    TroopNotificationUtils.d(this.ao);
    Object localObject = this.a;
    if (localObject != null) {
      ((NotifyAndRecAdapter)localObject).notifyDataSetChanged();
    }
    int i1 = GroupSystemMsgController.a().b(this.an);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notification num:");
      ((StringBuilder)localObject).append(i1);
      QLog.d("TroopNotificationFragment", 2, ((StringBuilder)localObject).toString());
    }
    localObject = (IRecommendTroopService)this.an.getRuntimeService(IRecommendTroopService.class, "");
    if (localObject != null) {
      ((IRecommendTroopService)localObject).setUnreadNum(GroupSystemMsgController.a().b(this.an));
    }
    int i2 = RecommendTroopUtils.b(this.ao);
    localObject = (IConversationFacade)this.an.getRuntimeService(IConversationFacade.class, "");
    if (localObject != null) {
      ((IConversationFacade)localObject).increaseUnread(AppConstants.TROOP_NOTIFICATION_UIN, 9000, 0 - (i2 + i1));
    }
    GroupSystemMsgController.a().a(this.ao, 0);
  }
  
  public void a(int paramInt)
  {
    this.n = paramInt;
  }
  
  void a(NotifyAndRecAdapter.ViewHolder paramViewHolder)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleGroupSystemMsg! start ");
      ((StringBuilder)localObject1).append(paramViewHolder.c);
      QLog.d("TroopNotificationFragment", 2, ((StringBuilder)localObject1).toString());
    }
    b(paramViewHolder, 998);
    String str3 = paramViewHolder.r.msg.group_info.msg_alert.get();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramViewHolder.r.msg.group_code.get());
    Object localObject2 = "";
    ((StringBuilder)localObject1).append("");
    String str2 = ((StringBuilder)localObject1).toString();
    Object localObject3 = this.a;
    localObject1 = "1";
    String str1;
    if ((localObject3 != null) && (paramViewHolder.q < this.a.d)) {
      str1 = "1";
    } else {
      str1 = "0";
    }
    boolean bool = b(paramViewHolder.r.msg.group_inviter_role.get());
    int i1 = paramViewHolder.b;
    if (i1 != 1) {
      if (i1 != 2)
      {
        if (i1 != 3)
        {
          localObject3 = localObject1;
          if (i1 != 6)
          {
            if (i1 != 7)
            {
              if (i1 != 15)
              {
                localObject3 = localObject1;
                if (i1 != 16)
                {
                  if (i1 == 22) {
                    break label482;
                  }
                  switch (i1)
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
                  break label437;
                }
              }
              else
              {
                localObject3 = "0";
              }
              localObject1 = "un_admin_page";
              paramViewHolder = (NotifyAndRecAdapter.ViewHolder)localObject3;
              break label625;
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
            break label625;
          }
        }
        else
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(paramViewHolder.r.req_uin.get());
          ((StringBuilder)localObject3).append("");
          paramViewHolder = (NotifyAndRecAdapter.ViewHolder)localObject1;
          if (((StringBuilder)localObject3).toString().equals(this.an.getCurrentAccountUin())) {
            paramViewHolder = "0";
          }
          localObject1 = "set_admin_page";
        }
        label437:
        break label625;
      }
      else
      {
        if (paramViewHolder.r.msg.sub_type.get() == 1) {
          localObject1 = "0";
        }
        localObject3 = "enter_invite";
        paramViewHolder = "";
        localObject2 = localObject1;
        localObject1 = localObject3;
        break label625;
      }
    }
    label482:
    if ((str3 != null) && (!"".equals(str3))) {
      localObject1 = "0";
    } else {
      localObject1 = "1";
    }
    if (paramViewHolder.r.msg.sub_type.get() == 1) {
      localObject2 = "0";
    }
    label622:
    for (;;)
    {
      paramViewHolder = (NotifyAndRecAdapter.ViewHolder)localObject1;
      localObject1 = "enter_askjoin";
      break;
      long l1 = paramViewHolder.r.msg.actor_uin.get();
      if (l1 != 0L)
      {
        paramViewHolder = new StringBuilder();
        paramViewHolder.append(l1);
        paramViewHolder.append("");
        if (!paramViewHolder.toString().equals(this.an.getCurrentAccountUin()))
        {
          localObject2 = "2";
          break label622;
        }
      }
      localObject2 = "1";
    }
    label625:
    TroopReportor.a("Grp_contacts_news", "notice", (String)localObject1, 3, 0, new String[] { str2, str1, paramViewHolder, localObject2 });
  }
  
  public void a(NotifyAndRecAdapter.ViewHolder paramViewHolder, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("bindTroopSystemMsgView! start ");
      ((StringBuilder)localObject1).append(paramViewHolder.c);
      QLog.d("TroopNotificationFragment", 2, ((StringBuilder)localObject1).toString());
    }
    structmsg.StructMsg localStructMsg = paramViewHolder.r;
    paramViewHolder.c = paramInt;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(localStructMsg.req_uin.get());
    Object localObject1 = "";
    ((StringBuilder)localObject2).append("");
    paramViewHolder.e = ((StringBuilder)localObject2).toString();
    paramViewHolder.b = localStructMsg.msg.group_msg_type.get();
    paramInt = localStructMsg.msg.sub_type.get();
    paramViewHolder.d = localStructMsg.msg_time.get();
    paramViewHolder.f = localStructMsg.msg.req_uin_nick.get();
    if ((paramViewHolder.f == null) || (paramViewHolder.f.equals(""))) {
      paramViewHolder.f = paramViewHolder.e;
    }
    localObject2 = (ITroopNotificationService)this.an.getRuntimeService(ITroopNotificationService.class, "");
    if (localObject2 == null) {
      return;
    }
    if (paramViewHolder.b == 91) {
      paramViewHolder.u = ((ITroopNotificationService)localObject2).getGeneralGroupNotifyParser(91).a(localStructMsg);
    }
    if (paramViewHolder.b == 2) {
      paramViewHolder.u = ((ITroopNotificationService)localObject2).getGeneralGroupNotifyParser(2).a(localStructMsg);
    }
    b(paramViewHolder, localStructMsg);
    a(paramViewHolder.t, localStructMsg, false);
    paramViewHolder.k.setVisibility(8);
    localObject2 = localStructMsg.msg.group_info.msg_alert.get();
    a(paramViewHolder, localStructMsg, (String)localObject2);
    a(paramViewHolder, localStructMsg);
    a(paramViewHolder, localStructMsg, paramInt, (String)localObject2);
    if ((paramInt == 2) && (paramViewHolder.b == 2))
    {
      localObject2 = (ITroopInfoService)this.an.getRuntimeService(ITroopInfoService.class, "");
      if ((localObject2 != null) && (((ITroopInfoService)localObject2).findTroopInfo(String.valueOf(localStructMsg.msg.group_code.get())) != null)) {
        TroopRemindSettingManager.a().c(String.valueOf(localStructMsg.msg.group_code.get()), this.ao);
      }
    }
    if (localStructMsg.msg.bytes_warning_tips.get() != null) {
      localObject1 = localStructMsg.msg.bytes_warning_tips.get().toStringUtf8();
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramViewHolder.n.setText((CharSequence)localObject1);
      paramViewHolder.n.setVisibility(0);
    }
    else
    {
      paramViewHolder.n.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.security_verify", 2, String.format("bindTroopSystemMsgView reqUin: %s, warningTips: %s", new Object[] { paramViewHolder.e, localObject1 }));
    }
    paramViewHolder.g.setTag(paramViewHolder);
    paramViewHolder.g.setOnClickListener(this.z);
    paramViewHolder.h.setTag(paramViewHolder);
    if ((paramViewHolder.b != 8) && (paramViewHolder.b != 7)) {
      paramViewHolder.h.setOnClickListener(this);
    } else {
      paramViewHolder.h.setEnabled(false);
    }
    d(paramViewHolder);
    if (((paramViewHolder.b == 1) || (paramViewHolder.b == 22) || (paramViewHolder.b == 60)) && (QLog.isColorLevel()))
    {
      boolean bool = localStructMsg.msg.has();
      int i2 = -1;
      if ((bool) && (localStructMsg.msg.src_id.has())) {
        paramInt = localStructMsg.msg.src_id.get();
      } else {
        paramInt = -1;
      }
      int i1 = i2;
      if (localStructMsg.msg.has())
      {
        i1 = i2;
        if (localStructMsg.msg.sub_src_id.has()) {
          i1 = localStructMsg.msg.sub_src_id.get();
        }
      }
      QLog.i("TroopNotificationFragment", 2, String.format("joinGroup subSourceID=%d sourceID=%d msgType=%d", new Object[] { Integer.valueOf(i1), Integer.valueOf(paramInt), Integer.valueOf(paramViewHolder.b) }));
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
    if (this.V != null)
    {
      Object localObject = this.Y;
      if (localObject != null)
      {
        if (this.ab == null) {
          return;
        }
        localObject = new SpannableStringBuilder(((TextView)localObject).getText());
        if ((paramBoolean) && (this.n == 1))
        {
          this.Y.setTextColor(-16725252);
          ((SpannableStringBuilder)localObject).setSpan(new StyleSpan(1), 0, this.Y.getText().length(), 18);
          this.ab.setVisibility(0);
          b(false);
          c(false);
          this.Y.setText((CharSequence)localObject);
          return;
        }
        this.Y.setTextColor(-7894119);
        this.ab.setVisibility(8);
        localObject = this.an;
        if (localObject != null)
        {
          localObject = (ITroopNotificationService)((AppRuntime)localObject).getRuntimeService(ITroopNotificationService.class, "");
          if (localObject != null) {
            c(((ITroopNotificationService)localObject).getDataListFromClassificationCache(1));
          }
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (this.ae == null) {
      return;
    }
    int i1 = this.n;
    if ((i1 == paramInt) && ((i1 == 1) || (i1 == 2)))
    {
      this.ae.setVisibility(8);
      return;
    }
    if (paramBoolean)
    {
      this.ae.setVisibility(0);
      return;
    }
    this.ae.setVisibility(8);
  }
  
  public int b()
  {
    return getResources().getDimensionPixelSize(2131299920);
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.W != null) && (this.ac != null))
    {
      Object localObject = this.Z;
      if (localObject == null) {
        return;
      }
      localObject = new SpannableStringBuilder(((TextView)localObject).getText());
      if ((paramBoolean) && (this.n == 2))
      {
        this.Z.setTextColor(-16725252);
        ((SpannableStringBuilder)localObject).setSpan(new StyleSpan(1), 0, this.Z.getText().length(), 18);
        this.ac.setVisibility(0);
        c(false);
        a(false);
        this.Z.setText((CharSequence)localObject);
        return;
      }
      this.Z.setTextColor(-7894119);
      this.ac.setVisibility(8);
      this.Z.setText("退群");
    }
  }
  
  public void c()
  {
    Context localContext = this.g;
    DialogUtil.a(localContext, null, localContext.getString(2131917593), null, 2131887648, 2131892267, new TroopNotificationFragment.19(this), new TroopNotificationFragment.20(this)).show();
  }
  
  public void c(List<MessageRecord> paramList)
  {
    if (this.V != null)
    {
      if (this.Y == null) {
        return;
      }
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        int i1 = paramList.size();
        paramList = String.valueOf(i1);
        if (i1 > 99) {
          paramList = "99+";
        }
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("待处理(");
        ((StringBuilder)localObject).append(paramList);
        ((StringBuilder)localObject).append(")");
        paramList = ((StringBuilder)localObject).toString();
        if (this.V.getVisibility() == 8) {
          ReportController.b(this.an, "dc00899", "Grp_contacts_news", "", "notice", "todo_tab_exp", 0, 0, "", "", "", "");
        }
        if (this.n == 1)
        {
          localObject = new SpannableStringBuilder(paramList);
          ((SpannableStringBuilder)localObject).setSpan(new StyleSpan(1), 0, paramList.length(), 18);
          this.Y.setText((CharSequence)localObject);
        }
        else
        {
          this.Y.setText(paramList);
        }
        this.V.setVisibility(0);
        return;
      }
      this.V.setVisibility(8);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if ((this.X != null) && (this.ad != null))
    {
      Object localObject = this.aa;
      if (localObject == null) {
        return;
      }
      localObject = new SpannableStringBuilder(((TextView)localObject).getText());
      if ((paramBoolean) && (this.n == 3))
      {
        this.aa.setTextColor(-16725252);
        ((SpannableStringBuilder)localObject).setSpan(new StyleSpan(1), 0, this.aa.getText().length(), 33);
        this.aa.setText((CharSequence)localObject);
        this.ad.setVisibility(0);
        a(false);
        b(false);
        return;
      }
      this.aa.setTextColor(-7894119);
      this.ad.setVisibility(8);
      this.aa.setText("已过滤");
    }
  }
  
  public void d()
  {
    if (this.an == null) {
      return;
    }
    y();
    Object localObject = (ITroopSysMsgDependApiService)this.an.getRuntimeService(ITroopSysMsgDependApiService.class, "");
    if (localObject != null) {
      ((ITroopSysMsgDependApiService)localObject).clearGroupSystemMsg();
    }
    GroupSystemMsgController.a().a(this.ao, 0);
    localObject = (ITroopNotificationService)this.an.getRuntimeService(ITroopNotificationService.class, "");
    if (localObject != null) {
      ((ITroopNotificationService)localObject).clearAllMsgCache();
    }
    localObject = this.a;
    if (localObject != null)
    {
      ((NotifyAndRecAdapter)localObject).c();
      this.a.notifyDataSetChanged();
    }
    d(null);
    c(null);
    a(false, 1);
    this.w.sendEmptyMessage(1012);
  }
  
  public void d(List<MessageRecord> paramList)
  {
    if (this.Z != null)
    {
      if (this.W == null) {
        return;
      }
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        if (this.V.getVisibility() == 8) {
          ReportController.b(this.an, "dc00899", "Grp_contacts_news", "", "notice", "quit_tab_exp", 0, 0, "", "", "", "");
        }
        this.W.setVisibility(0);
        return;
      }
      this.W.setVisibility(8);
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = (int)paramMotionEvent.getX();
    int i2 = (int)paramMotionEvent.getY();
    int i3 = paramMotionEvent.getAction();
    if (i3 != 0)
    {
      if (i3 != 1) {
        if (i3 != 2)
        {
          if (i3 != 3) {
            break label137;
          }
        }
        else
        {
          i3 = i1 - this.aq;
          int i4 = i2 - this.ar;
          if ((i3 > 20) || (i3 < -20)) {
            this.as = true;
          }
          if (((i4 <= 20) && (i4 >= -20)) || (this.as)) {
            break label137;
          }
          this.ap.getParent().requestDisallowInterceptTouchEvent(false);
          break label137;
        }
      }
      this.as = false;
    }
    else
    {
      this.ap.getParent().requestDisallowInterceptTouchEvent(true);
    }
    label137:
    this.ar = i2;
    this.aq = i1;
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void e()
  {
    a(this.H);
    f();
  }
  
  public void f()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopNotificationFragment", 4, "onChecked........");
    }
    this.S = this.an.getPreferences().getBoolean("show_new_troop_recommend", false);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getNotificationRecommendTroopList showOpen is :");
      ((StringBuilder)localObject).append(this.S);
      QLog.d("TroopNotificationFragment", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.I) && (this.S))
    {
      this.I = false;
      localObject = (IRecommendTroopService)this.an.getRuntimeService(IRecommendTroopService.class, "");
      if (localObject != null) {
        ((IRecommendTroopService)localObject).downloadRecommendTroop();
      }
    }
    if (!this.S)
    {
      localObject = this.a;
      if (localObject != null)
      {
        ((NotifyAndRecAdapter)localObject).j = true;
        ((NotifyAndRecAdapter)localObject).notifyDataSetChanged();
      }
    }
    h();
    g();
  }
  
  protected void g()
  {
    if (this.G)
    {
      NotifyAndRecAdapter localNotifyAndRecAdapter = this.a;
      if ((localNotifyAndRecAdapter != null) && (localNotifyAndRecAdapter.d()))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("TroopNotificationFragment", 4, "reportPv");
        }
        ReportController.b(this.an, "P_CliOper", "Grp_recom", "", "msg_page", "exp", 0, 0, "", "", "", "");
      }
    }
  }
  
  protected int h()
  {
    int i3 = RecommendTroopUtils.b(this.ao);
    IRecommendTroopService localIRecommendTroopService = (IRecommendTroopService)this.an.getRuntimeService(IRecommendTroopService.class, "");
    int i2 = 0;
    if (i3 > 0)
    {
      IConversationFacade localIConversationFacade = (IConversationFacade)this.an.getRuntimeService(IConversationFacade.class, "");
      if (localIConversationFacade != null) {
        localIConversationFacade.increaseUnread(AppConstants.TROOP_NOTIFICATION_UIN, 9000, 0 - i3);
      }
      if (localIRecommendTroopService != null) {
        localIRecommendTroopService.sendReadConfirm();
      }
    }
    int i1 = i2;
    if (localIRecommendTroopService != null)
    {
      i1 = i2;
      if (i3 > 0) {
        i1 = 1;
      }
    }
    return i1;
  }
  
  public void i()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopNotificationFragment", 4, "refreshRecommendTroopList");
    }
    if (this.J) {
      return;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopNotificationFragment", 4, "refreshRecommendTroopList start ");
    }
  }
  
  public void j()
  {
    E();
    D();
    F();
  }
  
  public void k()
  {
    I();
    Object localObject = (ITroopSysMsgDependApiService)this.an.getRuntimeService(ITroopSysMsgDependApiService.class, "");
    if (localObject != null) {
      ((ITroopSysMsgDependApiService)localObject).clearGroupSuspiciousMsg();
    }
    GroupSystemMsgController.a().b(this.ao, 0);
    this.e.clear();
    localObject = this.ag;
    if (localObject != null) {
      ((SuspiciousAdapter)localObject).b();
    }
    localObject = this.X;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    this.w.sendEmptyMessage(1012);
  }
  
  public void onClick(View paramView)
  {
    long l1 = System.currentTimeMillis();
    long l2 = D;
    if ((l1 - l2 <= 0L) || (l1 - l2 >= 800L))
    {
      D = l1;
      int i1 = paramView.getId();
      if (i1 == 2131441346)
      {
        Object localObject1;
        if ((paramView.getTag() instanceof NotifyAndRecAdapter.ViewHolder))
        {
          Object localObject3 = (NotifyAndRecAdapter.ViewHolder)paramView.getTag();
          if (localObject3 != null)
          {
            Object localObject2 = ((NotifyAndRecAdapter.ViewHolder)localObject3).r;
            i1 = ((NotifyAndRecAdapter.ViewHolder)localObject3).b;
            Object localObject4;
            if (TroopNotificationUtils.a(i1) == 0)
            {
              localObject2 = String.valueOf(((NotifyAndRecAdapter.ViewHolder)localObject3).r.msg.group_code.get());
              localObject1 = localObject2;
              if (i1 == 91)
              {
                localObject1 = localObject2;
                if ((((NotifyAndRecAdapter.ViewHolder)localObject3).u instanceof AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)) {
                  localObject1 = String.valueOf(((AllianceGeneralGroupNotifyParser.AllianceGeneralGroupNotifyInfo)((NotifyAndRecAdapter.ViewHolder)localObject3).u).f);
                }
              }
              localObject2 = (ITroopUtilApi)QRoute.api(ITroopUtilApi.class);
              if (localObject2 != null) {
                ((ITroopUtilApi)localObject2).openTroopInfoActivity(this.am, (String)localObject1);
              }
              if ((i1 != 2) && (i1 != 10) && (i1 != 12)) {
                i1 = 0;
              } else {
                i1 = 1;
              }
              localObject4 = this.an;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(((NotifyAndRecAdapter.ViewHolder)localObject3).r.msg.group_code.get());
              ((StringBuilder)localObject1).append("");
              String str = ((StringBuilder)localObject1).toString();
              localObject2 = "0";
              if (i1 != 0) {
                localObject1 = "0";
              } else {
                localObject1 = "1";
              }
              ReportController.b((AppRuntime)localObject4, "P_CliOper", "Grp_contacts", "", "notice", "see_data", 0, 0, str, (String)localObject1, "", "");
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(((NotifyAndRecAdapter.ViewHolder)localObject3).r.msg.group_code);
              ((StringBuilder)localObject1).append("");
              localObject3 = ((StringBuilder)localObject1).toString();
              if (i1 != 0) {
                localObject1 = localObject2;
              } else {
                localObject1 = "1";
              }
              TroopReportor.a("Grp_contacts_news", "notice", "see_data", 0, 0, new String[] { localObject3, localObject1 });
            }
            else if ((((NotifyAndRecAdapter.ViewHolder)localObject3).b != 2) || (!TroopInfo.isQidianPrivateTroop(((NotifyAndRecAdapter.ViewHolder)localObject3).r.msg.uint32_group_flagext3.get())))
            {
              localObject4 = (ITroopSysMsgDependApiService)this.an.getRuntimeService(ITroopSysMsgDependApiService.class, "");
              if (localObject4 != null) {
                if (((NotifyAndRecAdapter.ViewHolder)localObject3).b == 82)
                {
                  localObject1 = new ActivityURIRequest(this.g, "/pubaccount/detail");
                  localObject2 = ((ActivityURIRequest)localObject1).extra();
                  localObject4 = new StringBuilder();
                  ((StringBuilder)localObject4).append(((NotifyAndRecAdapter.ViewHolder)localObject3).r.req_uin.get());
                  ((StringBuilder)localObject4).append("");
                  ((Bundle)localObject2).putString("uin", ((StringBuilder)localObject4).toString());
                  ((ActivityURIRequest)localObject1).extra().putInt("source", 112);
                  QRoute.startUri((URIRequest)localObject1, null);
                }
                else
                {
                  l1 = ((structmsg.StructMsg)localObject2).req_uin.get();
                  i1 = TroopNotificationUtils.a(i1);
                  if (i1 != 1)
                  {
                    if (i1 != 2) {}
                    for (localObject1 = String.valueOf(l1);; localObject1 = ((NotifyAndRecAdapter.ViewHolder)localObject3).e)
                    {
                      bool = false;
                      break;
                    }
                  }
                  localObject1 = String.valueOf(((NotifyAndRecAdapter.ViewHolder)localObject3).r.msg.action_uin.get());
                  boolean bool = true;
                  ((ITroopSysMsgDependApiService)localObject4).openProfileCardForTroopSysMsg(this.am, (String)localObject1, ((structmsg.StructMsg)localObject2).msg.group_code.get(), ((structmsg.StructMsg)localObject2).msg.action_uin.get(), ((structmsg.StructMsg)localObject2).msg.group_msg_type.get(), ((structmsg.StructMsg)localObject2).msg.sub_type.get(), bool);
                }
              }
            }
          }
        }
        else if (i1 == 2131439162)
        {
          localObject1 = (ITroopSysMsgDependApiService)this.an.getRuntimeService(ITroopSysMsgDependApiService.class, "");
          if (localObject1 != null) {
            ((ITroopSysMsgDependApiService)localObject1).openNearTroopActivity(this.am, this.ao);
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.am = getQBaseActivity();
    paramBundle = this.am;
    this.g = paramBundle;
    this.an = paramBundle.getAppRuntime();
    this.ao = l();
    if (this.ao == null)
    {
      this.am.finish();
      paramLayoutInflater = null;
    }
    else
    {
      paramBundle = this.am.getIntent();
      if (paramBundle != null)
      {
        this.t = paramBundle.getIntExtra("key_from", 0);
        this.s = paramBundle.getBooleanExtra("show_type", false);
        this.q = paramBundle.getIntExtra("key_tab_mode", 0);
        this.r = paramBundle.getIntExtra("show_mode", 2);
      }
      paramBundle = (IRecommendTroopService)this.an.getRuntimeService(IRecommendTroopService.class, "");
      if (this.q == 2)
      {
        if (GroupSystemMsgController.a().b(this.an) > 0) {
          this.p = 1;
        } else if ((paramBundle != null) && (RecommendTroopUtils.b(this.ao) > 0)) {
          this.p = 0;
        }
        int i1 = this.p;
        if (i1 == 0) {
          ReportController.b(this.an, "P_CliOper", "Grp_contacts", "", "notice", "enter_recom", 0, 0, "", "", "", "");
        } else if (i1 == 1) {
          ReportController.b(this.an, "P_CliOper", "Grp_contacts", "", "notice", "enter_verify", 0, 0, "", "", "", "");
        }
      }
      paramViewGroup = paramLayoutInflater.inflate(2131625934, paramViewGroup, false);
      this.ap = paramViewGroup;
      m();
      a();
      e();
      j();
      paramBundle = (IMessageFacade)this.an.getRuntimeService(IMessageFacade.class, "");
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
      a(this.af, paramString, paramBitmap);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.a;
    if (localObject != null) {
      ((NotifyAndRecAdapter)localObject).e();
    }
    localObject = this.a;
    if ((localObject != null) && (((NotifyAndRecAdapter)localObject).f() > 0)) {
      y();
    }
    if (this.ah > 0)
    {
      localObject = this.ag;
      if ((localObject != null) && (((SuspiciousAdapter)localObject).a() > 0)) {
        I();
      }
    }
    localObject = this.w;
    if (localObject != null) {
      ((MqqHandler)localObject).removeCallbacksAndMessages(null);
    }
    b(this.H);
    b(this.x);
    b(this.A);
    b(this.Q);
    localObject = this.a;
    if (localObject != null)
    {
      ((NotifyAndRecAdapter)localObject).c();
      this.a.notifyDataSetChanged();
    }
    TroopNotificationUtils.b();
    GroupSystemMsgController.a().a(this.ao, 0);
    GroupSystemMsgController.a().g();
    GroupCatalogTool.a(this.am).c();
    if (this.F != null) {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(this.F);
    }
    localObject = (IRecommendTroopService)this.an.getRuntimeService(IRecommendTroopService.class, "");
    if (localObject != null)
    {
      ((IRecommendTroopService)localObject).sendReadConfirm();
      ((IRecommendTroopService)localObject).reSetConfig();
      ((IRecommendTroopService)localObject).clearGroupSysNotifyReportData();
    }
    localObject = this.j;
    if (localObject != null) {
      ((IFaceDecoder)localObject).setDecodeTaskCompletionListener(null);
    }
    localObject = this.ag;
    if (localObject != null)
    {
      ((SuspiciousAdapter)localObject).b();
      this.ag.notifyDataSetChanged();
    }
    localObject = (ITroopNotificationService)this.an.getRuntimeService(ITroopNotificationService.class, "");
    if (localObject != null) {
      ((ITroopNotificationService)localObject).clearAllLackApplicantInfoUinsFromCache();
    }
    localObject = (IConversationFacade)this.an.getRuntimeService(IConversationFacade.class, "");
    if (localObject != null) {
      ((IConversationFacade)localObject).increaseUnread(AppConstants.TROOP_NOTIFICATION_UIN, 9000, 0 - GroupSystemMsgController.a().b(this.an));
    }
    localObject = (IMessageFacade)this.an.getRuntimeService(IMessageFacade.class, "");
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
    if (this.R)
    {
      TroopNotificationUtils.b();
      GroupSystemMsgController.a().a(this.ao, 0);
      Object localObject = this.a;
      if (localObject != null)
      {
        ((NotifyAndRecAdapter)localObject).d = 0;
        ((NotifyAndRecAdapter)localObject).notifyDataSetChanged();
      }
      localObject = (IRecommendTroopService)this.an.getRuntimeService(IRecommendTroopService.class, "");
      if (localObject != null) {
        ((IRecommendTroopService)localObject).setUnreadNum(GroupSystemMsgController.a().b(this.an));
      }
    }
    if (this.n == 3) {
      GroupSystemMsgController.a().b(this.ao, 0);
    }
    this.R = true;
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.L = (paramInt1 + paramInt2 - 1);
    paramAbsListView = this.a;
    if (paramAbsListView != null) {
      paramAbsListView.a(this.L, this.n);
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
      paramAbsListView.append(this.L);
      paramAbsListView.append("list count");
      NotifyAndRecAdapter localNotifyAndRecAdapter = this.a;
      int i1;
      if (localNotifyAndRecAdapter != null) {
        i1 = localNotifyAndRecAdapter.getCount();
      } else {
        i1 = 0;
      }
      paramAbsListView.append(i1);
      QLog.d("TroopNotificationFragment", 2, paramAbsListView.toString());
    }
    paramAbsListView = this.a;
    if ((paramAbsListView != null) && (paramInt == 0) && (this.L == paramAbsListView.getCount() - 1)) {
      A();
    }
    this.N = paramInt;
  }
  
  public void onStop()
  {
    super.onStop();
    IRecommendTroopService localIRecommendTroopService = (IRecommendTroopService)this.an.getRuntimeService(IRecommendTroopService.class, "");
    if (localIRecommendTroopService != null) {
      localIRecommendTroopService.sendReadConfirm();
    }
    if (this.n == 3)
    {
      this.j.pause();
      this.j.cancelPendingRequests();
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if ((paramObject instanceof MessageRecord))
    {
      paramObservable = (MessageRecord)paramObject;
      if ((!paramObservable.isSendFromLocal()) && (ThemeUtil.isDefaultOrDIYTheme(false)))
      {
        paramObject = (TextView)this.ap.findViewById(2131448219);
        ImageView localImageView = (ImageView)this.ap.findViewById(2131436666);
        ThreadManager.postImmediately(new TroopNotificationFragment.GetUnReadNumRunnable(this.an, new WeakReference(this.am), paramObject, localImageView), null, false);
      }
      if ((!paramObservable.isSendFromLocal()) || (paramObservable.msgtype != -2002)) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopnotification.ui.TroopNotificationFragment
 * JD-Core Version:    0.7.0.1
 */