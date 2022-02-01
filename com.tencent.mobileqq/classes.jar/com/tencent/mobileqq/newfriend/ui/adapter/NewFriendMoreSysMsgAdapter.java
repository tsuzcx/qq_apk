package com.tencent.mobileqq.newfriend.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.mobileqq.newfriend.msg.FriendSystemMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.msg.PhoneContactAddMessage;
import com.tencent.mobileqq.newfriend.msg.QIMNotifyAddFriendMsg;
import com.tencent.mobileqq.newfriend.msg.controller.FriendSystemMsgController;
import com.tencent.mobileqq.newfriend.observer.NewFriendListObserver;
import com.tencent.mobileqq.newfriend.observer.NewFriendMessageObserver;
import com.tencent.mobileqq.newfriend.observer.NewFriendNotifyPokeObserver;
import com.tencent.mobileqq.newfriend.poke.NewFriendNotifyPokeMsgHelper;
import com.tencent.mobileqq.newfriend.ui.holder.MoreSysMsgHolder;
import com.tencent.mobileqq.newfriend.utils.NewFriendUtil;
import com.tencent.mobileqq.newfriend.utils.SystemMessageHelper;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.data.PhoneContactAdd;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipListView;
import com.tencent.widget.SwipListView.SwipListListener;
import com.tencent.widget.SwipRightMenuBuilder;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;
import com.tencent.widget.ThemeImageView;
import com.tencent.widget.XBaseAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import tencent.mobileim.structmsg.structmsg.AddFrdSNInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class NewFriendMoreSysMsgAdapter
  extends XBaseAdapter
  implements View.OnClickListener, DecodeTaskCompletionListener, AbsListView.OnScrollListener, SwipListView.SwipListListener
{
  private static final int[] f = { 2131888438 };
  private static final int[] g = { 2130839698 };
  private static final int[] h = { 2131438111 };
  private IMessageFacade A;
  private Comparator<NewFriendMessage> B = new NewFriendMoreSysMsgAdapter.1(this);
  private AvatarObserver C = new NewFriendMoreSysMsgAdapter.6(this);
  private FriendObserver D = new NewFriendMoreSysMsgAdapter.7(this);
  private NewFriendListObserver E = new NewFriendMoreSysMsgAdapter.8(this);
  private NewFriendMessageObserver F = new NewFriendMoreSysMsgAdapter.9(this);
  AppInterface a;
  final ConcurrentHashMap<Long, String> b = new ConcurrentHashMap();
  DiscussionObserver c = new NewFriendMoreSysMsgAdapter.10(this);
  NewFriendNotifyPokeObserver d = new NewFriendMoreSysMsgAdapter.11(this);
  private final int e = 0;
  private View i;
  private SwipListView j;
  private View k;
  private View l;
  private TextView m;
  private QQProgressDialog n;
  private Activity o;
  private SwipRightMenuBuilder p;
  private IFaceDecoder q;
  private int r = -1;
  private int s;
  private boolean t;
  private FlingHandler u;
  private ArrayList<NewFriendMessage> v = new ArrayList();
  private HashMap<String, Bitmap> w = new HashMap();
  private IFriendDataService x;
  private int y;
  private IPhoneContactService z;
  
  public NewFriendMoreSysMsgAdapter(Activity paramActivity, AppInterface paramAppInterface, SwipListView paramSwipListView, View paramView1, View paramView2, FlingHandler paramFlingHandler, int paramInt)
  {
    this.o = paramActivity;
    this.a = paramAppInterface;
    this.x = ((IFriendDataService)paramAppInterface.getRuntimeService(IFriendDataService.class, ""));
    this.q = ((IQQAvatarService)paramAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramAppInterface);
    this.q.setDecodeTaskCompletionListener(this);
    this.i = paramView1;
    this.j = paramSwipListView;
    h();
    g();
    this.j.setAdapter(this);
    this.j.setOnScrollListener(this);
    this.j.setDragEnable(true);
    this.a.addObserver(this.E);
    this.a.addObserver(this.D);
    this.a.addObserver(this.C);
    this.a.addObserver(this.F);
    this.a.addObserver(this.c, true);
    this.a.addObserver(this.d);
    this.p = a(paramActivity);
    this.u = paramFlingHandler;
    this.y = paramInt;
    this.z = ((IPhoneContactService)paramAppInterface.getRuntimeService(IPhoneContactService.class, ""));
    this.A = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, ""));
    a(true);
    paramView2.setOnClickListener(new NewFriendMoreSysMsgAdapter.2(this, paramAppInterface));
    if (c()) {
      ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getSuspiciousFriendsUnreadNum(paramAppInterface);
    }
  }
  
  private View a(Context paramContext, int paramInt, MoreSysMsgHolder paramMoreSysMsgHolder)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.p.createView(paramContext, localView, paramMoreSysMsgHolder, -1);
  }
  
  private SwipRightMenuBuilder a(Context paramContext)
  {
    int i1 = paramContext.getResources().getDimensionPixelSize(2131299607);
    int i2 = paramContext.getResources().getDimensionPixelSize(2131299608);
    paramContext = h;
    int[] arrayOfInt1 = f;
    int[] arrayOfInt2 = g;
    return new NewFriendMoreSysMsgAdapter.14(this, 1, 2, new int[] { i1, i2 }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  private void a(Context paramContext, View paramView, int paramInt, Object paramObject, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, View.OnClickListener paramOnClickListener)
  {
    SwipRightMenuBuilder localSwipRightMenuBuilder = this.p;
    int i1;
    if (localSwipRightMenuBuilder != null) {
      i1 = localSwipRightMenuBuilder.updateRightMenuView(paramContext, paramView, paramInt, paramObject, paramSwipItemBaseHolder, paramOnClickListener);
    } else {
      i1 = 0;
    }
    int i2 = this.r;
    if (i2 != -1)
    {
      if (paramInt != i2)
      {
        paramView.scrollTo(0, 0);
        return;
      }
      paramView.scrollTo(i1, 0);
    }
  }
  
  private void a(View paramView)
  {
    if (!NetworkUtil.isNetworkAvailable(this.o))
    {
      paramView = this.o;
      QQToast.makeText(paramView, paramView.getResources().getString(2131889169), 0).show(k());
      return;
    }
    if (!Utils.a("tag_swip_icon_menu_item", paramView.getTag()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("NewFriendMoreSysMsgAdapter", 2, "handleDeleteItem|onClick tag is not int");
      }
      return;
    }
    Object localObject = paramView.getTag(-1);
    paramView = paramView.getTag(-2);
    if (((localObject instanceof Integer)) && ((paramView instanceof Integer)))
    {
      int i1 = ((Integer)localObject).intValue();
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("handleDeleteItem|onClick position = ");
        paramView.append(i1);
        QLog.i("NewFriendMoreSysMsgAdapter", 2, paramView.toString());
      }
      paramView = getItem(i1);
      if (!(paramView instanceof NewFriendMessage)) {
        return;
      }
      paramView = (NewFriendMessage)paramView;
      if ((paramView instanceof FriendSystemMessage))
      {
        paramView = (FriendSystemMessage)paramView;
        e();
        ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).sendDelSingleSystemMsg(paramView.a.structMsg, paramView.a.frienduin, paramView.a.istroop, paramView.a.uniseq, this.a);
        ReportController.b(this.a, "CliOper", "", "", "0X8006A74", "0X8006A74", 0, 0, "", "", "", "");
        return;
      }
      if ((paramView instanceof PhoneContactAddMessage))
      {
        ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.12(this, paramView), null, true);
        return;
      }
      if ((paramView instanceof QIMNotifyAddFriendMsg)) {
        ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.13(this, paramView), null, true);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "handleDeleteItem|onClick posTag or subTag is not int");
    }
  }
  
  private void a(MoreSysMsgHolder paramMoreSysMsgHolder)
  {
    boolean bool = QLog.isColorLevel();
    int i1 = 2;
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleBuddySystemMsg! start ");
      ((StringBuilder)localObject1).append(paramMoreSysMsgHolder.h);
      QLog.d("NewFriendMoreSysMsgAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = null;
    if (FriendSystemMessage.a(this.a, String.valueOf(paramMoreSysMsgHolder.i.req_uin.get()), paramMoreSysMsgHolder.i, true)) {
      localObject1 = KplRoleInfo.WZRYUIinfo.createInfo(String.valueOf(paramMoreSysMsgHolder.i.req_uin.get()), paramMoreSysMsgHolder.b.getText().toString(), "", paramMoreSysMsgHolder.i.msg.src_id.get(), paramMoreSysMsgHolder.i.msg.sub_src_id.get());
    }
    int i2 = paramMoreSysMsgHolder.i.msg.sub_type.get();
    switch (i2)
    {
    case 11: 
    default: 
      break;
    case 13: 
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("param_wzry_data", (Serializable)localObject1);
      SystemMessageHelper.a(this.a, this.o, String.valueOf(paramMoreSysMsgHolder.i.req_uin.get()), paramMoreSysMsgHolder.i.msg.group_code.get(), i2, paramMoreSysMsgHolder.i.msg.src_id.get(), (Intent)localObject2);
      return;
    case 2: 
    case 3: 
      paramMoreSysMsgHolder = new AllInOne(String.valueOf(paramMoreSysMsgHolder.i.req_uin.get()), 1);
      ProfileUtils.openProfileCard(this.o, paramMoreSysMsgHolder);
      return;
    case 1: 
      i1 = 1;
      break;
    case 0: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 12: 
      i1 = 0;
    }
    Object localObject3 = paramMoreSysMsgHolder.i.msg.req_uin_nick.get();
    Object localObject2 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject2 = String.valueOf(paramMoreSysMsgHolder.i.req_uin.get());
    }
    localObject3 = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getAddRequestIntent(this.o);
    ((Intent)localObject3).putExtra("infoid", paramMoreSysMsgHolder.h);
    ((Intent)localObject3).putExtra("infouin", String.valueOf(paramMoreSysMsgHolder.i.req_uin.get()));
    ((Intent)localObject3).putExtra("infonick", (String)localObject2);
    ((Intent)localObject3).putExtra("infotime", paramMoreSysMsgHolder.i.msg_time.get());
    ((Intent)localObject3).putExtra("msg_type", paramMoreSysMsgHolder.i.msg.sub_type.get());
    ((Intent)localObject3).putExtra("strNickName", (String)localObject2);
    ((Intent)localObject3).putExtra("verify_msg", paramMoreSysMsgHolder.i.msg.msg_additional.get());
    ((Intent)localObject3).putExtra("msg_source", paramMoreSysMsgHolder.i.msg.msg_source.get());
    ((Intent)localObject3).putExtra("msg_troopuin", paramMoreSysMsgHolder.i.msg.group_code.get());
    ((Intent)localObject3).putExtra("system_message_summary", paramMoreSysMsgHolder.i.msg.msg_decided.get());
    ((Intent)localObject3).putExtra("info_dealwith_msg", paramMoreSysMsgHolder.i.msg.msg_detail.get());
    ((Intent)localObject3).putExtra("msg_title", paramMoreSysMsgHolder.i.msg.msg_title.get());
    ((Intent)localObject3).putExtra("msg_source_id", paramMoreSysMsgHolder.i.msg.src_id.get());
    if (i1 > 0) {
      ((Intent)localObject3).putExtra("verify_type", i1);
    }
    if (localObject1 != null)
    {
      ((Intent)localObject3).putExtra("param_wzry_data", (Serializable)localObject1);
      ((Intent)localObject3).putExtra("strNickName", ((KplRoleInfo.WZRYUIinfo)localObject1).nick);
      ((Intent)localObject3).putExtra("infonick", ((KplRoleInfo.WZRYUIinfo)localObject1).nick);
    }
    a((structmsg.StructMsg)paramMoreSysMsgHolder.i.get(), paramMoreSysMsgHolder.j);
    this.o.startActivity((Intent)localObject3);
  }
  
  private void a(MoreSysMsgHolder paramMoreSysMsgHolder, int paramInt, structmsg.StructMsg paramStructMsg, long paramLong)
  {
    paramMoreSysMsgHolder.h = paramInt;
    paramMoreSysMsgHolder.k = String.valueOf(paramStructMsg.req_uin.get());
    paramMoreSysMsgHolder.i = paramStructMsg;
    paramMoreSysMsgHolder.j = paramLong;
    paramMoreSysMsgHolder.l = 0;
    Object localObject1 = paramStructMsg.msg;
    String str = null;
    if (localObject1 != null) {
      localObject2 = paramStructMsg.msg.req_uin_nick.get();
    } else {
      localObject2 = null;
    }
    Object localObject3 = this.x.getFriend(String.valueOf(paramStructMsg.req_uin.get()));
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(((Friends)localObject3).remark)) {
        localObject1 = ((Friends)localObject3).remark;
      }
    }
    localObject3 = String.valueOf(paramStructMsg.req_uin.get());
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = localObject3;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      paramMoreSysMsgHolder.b.setVisibility(0);
      paramMoreSysMsgHolder.b.setText((CharSequence)localObject2);
    }
    else
    {
      paramMoreSysMsgHolder.b.setVisibility(8);
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (Utils.c((String)localObject3)))
    {
      localObject1 = this.o.getResources().getDrawable(2130842755);
      ((Drawable)localObject1).setBounds(0, 0, ViewUtils.dip2px(15.0F), ViewUtils.dip2px(15.0F));
      ThemeUtil.setThemeFilter((Drawable)localObject1, ThemeUtil.curThemeId);
      paramMoreSysMsgHolder.b.setCompoundDrawablePadding(ViewUtils.dip2px(5.0F));
      paramMoreSysMsgHolder.b.setCompoundDrawables(null, null, (Drawable)localObject1, null);
    }
    else
    {
      paramMoreSysMsgHolder.b.setCompoundDrawables(null, null, null, null);
    }
    d(paramMoreSysMsgHolder);
    paramMoreSysMsgHolder.a.setTag(paramMoreSysMsgHolder);
    paramMoreSysMsgHolder.c.setVisibility(8);
    localObject1 = str;
    if (paramStructMsg.msg != null)
    {
      localObject2 = paramStructMsg.msg.msg_source.get();
      paramInt = paramStructMsg.msg.uint32_source_flag.get();
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        if ((paramInt & 0x8) == 8)
        {
          paramLong = paramStructMsg.msg.uint64_discuss_uin.get();
          localObject1 = localObject2;
          if (paramLong != 0L)
          {
            str = (String)this.b.get(Long.valueOf(paramLong));
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(str)) {
              localObject1 = String.format(Locale.getDefault(), "%s-%s", new Object[] { localObject2, str });
            }
          }
        }
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramMoreSysMsgHolder.e.setText(String.format(Locale.getDefault(), HardCodeUtil.a(2131905340), new Object[] { localObject1 }));
      paramMoreSysMsgHolder.e.setVisibility(0);
    }
    else
    {
      paramMoreSysMsgHolder.e.setVisibility(8);
    }
    if (paramStructMsg.msg != null)
    {
      paramMoreSysMsgHolder.d.setText(FriendSystemMessage.a(this.o, paramStructMsg));
      switch (paramStructMsg.msg.sub_type.get())
      {
      case 11: 
      default: 
        break;
      case 13: 
        paramMoreSysMsgHolder.g.setVisibility(0);
        paramStructMsg = paramStructMsg.msg.msg_decided.get();
        paramMoreSysMsgHolder.g.setText(paramStructMsg);
        paramMoreSysMsgHolder.f.setVisibility(8);
        paramMoreSysMsgHolder.e.setVisibility(8);
        break;
      case 12: 
        if (paramStructMsg.msg.reqsubtype.has()) {
          if (paramStructMsg.msg.reqsubtype.get() == 1)
          {
            paramMoreSysMsgHolder.g.setVisibility(0);
            paramStructMsg = paramStructMsg.msg.msg_decided.get();
            paramMoreSysMsgHolder.g.setText(paramStructMsg);
            paramMoreSysMsgHolder.f.setVisibility(8);
          }
          else if (paramStructMsg.msg.reqsubtype.get() == 2)
          {
            paramMoreSysMsgHolder.g.setVisibility(8);
            paramMoreSysMsgHolder.f.setVisibility(8);
          }
        }
        break;
      case 10: 
        if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
        {
          paramMoreSysMsgHolder.g.setVisibility(8);
          paramMoreSysMsgHolder.f.setVisibility(0);
          paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
          paramMoreSysMsgHolder.f.setText(paramStructMsg);
        }
        else
        {
          paramMoreSysMsgHolder.g.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramMoreSysMsgHolder.g.setText(paramStructMsg);
          paramMoreSysMsgHolder.f.setVisibility(8);
        }
        c(paramMoreSysMsgHolder);
        break;
      case 9: 
        if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
        {
          paramMoreSysMsgHolder.g.setVisibility(8);
          paramMoreSysMsgHolder.f.setVisibility(0);
          paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
          paramMoreSysMsgHolder.f.setText(paramStructMsg);
        }
        else
        {
          paramMoreSysMsgHolder.g.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramMoreSysMsgHolder.g.setText(paramStructMsg);
          paramMoreSysMsgHolder.f.setVisibility(8);
          NewFriendNotifyPokeMsgHelper.a(paramMoreSysMsgHolder, this.a);
        }
        c(paramMoreSysMsgHolder);
        break;
      case 8: 
        paramMoreSysMsgHolder.g.setVisibility(0);
        paramStructMsg = paramStructMsg.msg.msg_decided.get();
        paramMoreSysMsgHolder.g.setText(paramStructMsg);
        paramMoreSysMsgHolder.f.setVisibility(8);
        break;
      case 7: 
        paramMoreSysMsgHolder.g.setVisibility(0);
        paramStructMsg = paramStructMsg.msg.msg_decided.get();
        paramMoreSysMsgHolder.g.setText(paramStructMsg);
        paramMoreSysMsgHolder.f.setVisibility(8);
        c(paramMoreSysMsgHolder);
        break;
      case 6: 
        if (!TextUtils.isEmpty(paramStructMsg.msg.msg_additional.get()))
        {
          paramMoreSysMsgHolder.e.setText(paramStructMsg.msg.msg_additional.get());
          paramMoreSysMsgHolder.d.setText(paramStructMsg.msg.msg_describe.get());
        }
        else
        {
          paramMoreSysMsgHolder.e.setVisibility(8);
        }
        paramMoreSysMsgHolder.f.setVisibility(8);
        paramMoreSysMsgHolder.g.setVisibility(8);
        break;
      case 5: 
        paramMoreSysMsgHolder.g.setVisibility(8);
        paramMoreSysMsgHolder.f.setVisibility(8);
        break;
      case 4: 
        paramMoreSysMsgHolder.g.setVisibility(8);
        paramMoreSysMsgHolder.f.setVisibility(8);
        break;
      case 3: 
        paramMoreSysMsgHolder.g.setVisibility(0);
        paramStructMsg = paramStructMsg.msg.msg_decided.get();
        paramMoreSysMsgHolder.g.setText(paramStructMsg);
        paramMoreSysMsgHolder.f.setVisibility(8);
        c(paramMoreSysMsgHolder);
        NewFriendNotifyPokeMsgHelper.a(paramMoreSysMsgHolder, this.a);
        break;
      case 2: 
        paramMoreSysMsgHolder.g.setVisibility(0);
        paramStructMsg = paramStructMsg.msg.msg_decided.get();
        paramMoreSysMsgHolder.g.setText(paramStructMsg);
        paramMoreSysMsgHolder.f.setVisibility(8);
        c(paramMoreSysMsgHolder);
        NewFriendNotifyPokeMsgHelper.a(paramMoreSysMsgHolder, this.a);
        break;
      case 1: 
        if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
        {
          paramMoreSysMsgHolder.g.setVisibility(8);
          paramMoreSysMsgHolder.f.setVisibility(0);
          paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
          paramMoreSysMsgHolder.f.setText(paramStructMsg);
        }
        else if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() == 0))
        {
          paramMoreSysMsgHolder.g.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramMoreSysMsgHolder.g.setText(paramStructMsg);
          paramMoreSysMsgHolder.f.setVisibility(8);
        }
        c(paramMoreSysMsgHolder);
      }
      paramMoreSysMsgHolder.f.setTag(paramMoreSysMsgHolder);
      paramMoreSysMsgHolder.f.setOnClickListener(this);
      paramMoreSysMsgHolder.o.setTag(paramMoreSysMsgHolder);
      paramMoreSysMsgHolder.o.setOnClickListener(this);
    }
  }
  
  private void a(MoreSysMsgHolder paramMoreSysMsgHolder, QIMNotifyAddFriend paramQIMNotifyAddFriend)
  {
    paramMoreSysMsgHolder.l = 2;
    paramMoreSysMsgHolder.n = paramQIMNotifyAddFriend;
    paramMoreSysMsgHolder.b.setText(paramQIMNotifyAddFriend.nickName);
    ((INewFriendApi)QRoute.api(INewFriendApi.class)).showGenderAge(paramMoreSysMsgHolder.c, paramQIMNotifyAddFriend.gender, paramQIMNotifyAddFriend.age, null);
    Object localObject = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getQQInfoFromQQUin(paramQIMNotifyAddFriend.uin, paramQIMNotifyAddFriend.qqUin, this.a);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramMoreSysMsgHolder.d.setVisibility(8);
    }
    else
    {
      paramMoreSysMsgHolder.d.setVisibility(0);
      paramMoreSysMsgHolder.d.setText((CharSequence)localObject);
    }
    String str = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getQIMNewFriendSource(this.a);
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = "来自QIM的好友申请";
    }
    localObject = String.format(Locale.getDefault(), HardCodeUtil.a(2131905340), new Object[] { localObject });
    paramMoreSysMsgHolder.e.setText((CharSequence)localObject);
    paramMoreSysMsgHolder.e.setVisibility(0);
    paramMoreSysMsgHolder.g.setVisibility(8);
    paramMoreSysMsgHolder.f.setText(HardCodeUtil.a(2131905336));
    paramMoreSysMsgHolder.f.setVisibility(0);
    paramMoreSysMsgHolder.f.setTag(paramMoreSysMsgHolder);
    paramMoreSysMsgHolder.f.setOnClickListener(this);
    paramMoreSysMsgHolder.o.setTag(paramMoreSysMsgHolder);
    paramMoreSysMsgHolder.o.setOnClickListener(this);
    paramMoreSysMsgHolder.k = String.valueOf(paramQIMNotifyAddFriend.uin);
    paramMoreSysMsgHolder.a.setImageBitmap(a(1, String.valueOf(paramQIMNotifyAddFriend.uin)));
  }
  
  private void a(MoreSysMsgHolder paramMoreSysMsgHolder, PhoneContactAdd paramPhoneContactAdd)
  {
    paramMoreSysMsgHolder.l = 1;
    paramMoreSysMsgHolder.m = paramPhoneContactAdd;
    if (!TextUtils.isEmpty(paramPhoneContactAdd.name))
    {
      paramMoreSysMsgHolder.b.setVisibility(0);
      paramMoreSysMsgHolder.b.setText(paramPhoneContactAdd.name);
    }
    else
    {
      paramMoreSysMsgHolder.b.setVisibility(8);
    }
    paramMoreSysMsgHolder.c.setVisibility(8);
    paramMoreSysMsgHolder.e.setVisibility(8);
    if (!TextUtils.isEmpty(paramPhoneContactAdd.remindInfo))
    {
      paramMoreSysMsgHolder.d.setVisibility(0);
      paramMoreSysMsgHolder.d.setText(paramPhoneContactAdd.remindInfo);
    }
    else
    {
      paramMoreSysMsgHolder.d.setVisibility(8);
    }
    paramMoreSysMsgHolder.g.setVisibility(0);
    paramMoreSysMsgHolder.f.setVisibility(8);
    paramMoreSysMsgHolder.g.setText(this.o.getString(2131915704));
    paramMoreSysMsgHolder.k = paramPhoneContactAdd.unifiedCode;
    paramMoreSysMsgHolder.a.setImageBitmap(a(11, paramPhoneContactAdd.unifiedCode));
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l1 = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      FriendSystemMsgController.a().a(Long.valueOf(l1), (structmsg.StructMsg)paramStructMsg.get());
      FriendSystemMsgController.a().b(l1);
      FriendSystemMsgController.a().a(paramLong);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.5(this, paramBoolean), null, true);
  }
  
  private void b()
  {
    Activity localActivity = this.o;
    DialogUtil.a(localActivity, null, localActivity.getString(2131897410), null, 2131887648, 2131897409, new NewFriendMoreSysMsgAdapter.3(this), new NewFriendMoreSysMsgAdapter.4(this)).show();
  }
  
  private void b(MoreSysMsgHolder paramMoreSysMsgHolder)
  {
    paramMoreSysMsgHolder.a.setVisibility(0);
    paramMoreSysMsgHolder.b.setVisibility(0);
    paramMoreSysMsgHolder.d.setVisibility(0);
    paramMoreSysMsgHolder.c.setVisibility(0);
    paramMoreSysMsgHolder.e.setVisibility(0);
    paramMoreSysMsgHolder.g.setVisibility(8);
    paramMoreSysMsgHolder.f.setVisibility(0);
    paramMoreSysMsgHolder.o.setVisibility(8);
  }
  
  private void c(MoreSysMsgHolder paramMoreSysMsgHolder)
  {
    int i3;
    if (paramMoreSysMsgHolder.i.msg.req_uin_gender.has()) {
      i3 = paramMoreSysMsgHolder.i.msg.req_uin_gender.get();
    } else {
      i3 = -1;
    }
    int i1;
    int i2;
    if (i3 != 0)
    {
      if (i3 != 1)
      {
        paramMoreSysMsgHolder.c.setBackgroundResource(2130847526);
        i1 = 0;
        i2 = 0;
      }
      else
      {
        paramMoreSysMsgHolder.c.setBackgroundResource(2130847524);
        i1 = 1;
        i2 = 2130847523;
      }
    }
    else
    {
      i2 = 2130847525;
      paramMoreSysMsgHolder.c.setBackgroundResource(2130847526);
      i1 = 1;
    }
    int i4 = i1;
    if (paramMoreSysMsgHolder.i.msg.req_uin_age.has()) {
      if ((paramMoreSysMsgHolder.i.msg.req_uin_age.get() > 0) && ((i3 == 0) || (i3 == 1)))
      {
        paramMoreSysMsgHolder.c.setText(String.valueOf(paramMoreSysMsgHolder.i.msg.req_uin_age.get()));
        i4 = 1;
      }
      else
      {
        paramMoreSysMsgHolder.c.setText("");
        i4 = i1;
      }
    }
    paramMoreSysMsgHolder.c.setCompoundDrawablesWithIntrinsicBounds(i2, 0, 0, 0);
    if (i4 != 0)
    {
      paramMoreSysMsgHolder.c.setVisibility(0);
      return;
    }
    paramMoreSysMsgHolder.c.setVisibility(8);
  }
  
  private boolean c()
  {
    return ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).isSuspiciousSwitchOpen();
  }
  
  private void d()
  {
    a(false);
  }
  
  private void d(MoreSysMsgHolder paramMoreSysMsgHolder)
  {
    if (paramMoreSysMsgHolder != null)
    {
      if (paramMoreSysMsgHolder.a == null) {
        return;
      }
      int i3 = paramMoreSysMsgHolder.i.msg.src_id.get();
      int i2 = 0;
      int i1;
      Object localObject1;
      if ((i3 != 3007) && (i3 != 3019) && (i3 != 2007) && (i3 != 4007))
      {
        i1 = i2;
        if (i3 != 2019) {}
      }
      else
      {
        localObject1 = this.x;
        if ((localObject1 != null) && (((IFriendDataService)localObject1).isFriend(String.valueOf(paramMoreSysMsgHolder.i.req_uin.get())))) {
          i1 = i2;
        } else {
          i1 = 1;
        }
      }
      if (i1 != 0)
      {
        localObject2 = this.q.getBitmapFromCache(32, String.valueOf(paramMoreSysMsgHolder.i.req_uin.get()), 200);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.q.isPausing())
          {
            this.q.requestDecodeStrangeFace(String.valueOf(paramMoreSysMsgHolder.i.req_uin.get()), 200, true, true);
            localObject1 = localObject2;
          }
        }
      }
      else
      {
        localObject2 = this.q.getBitmapFromCache(1, String.valueOf(paramMoreSysMsgHolder.i.req_uin.get()));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.q.isPausing())
          {
            this.q.requestDecodeFace(String.valueOf(paramMoreSysMsgHolder.i.req_uin.get()), 1, true);
            localObject1 = localObject2;
          }
        }
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = BaseImageUtil.k();
      }
      paramMoreSysMsgHolder.a.setImageBitmap((Bitmap)localObject2);
    }
  }
  
  private void e()
  {
    if (this.n == null) {
      this.n = new QQProgressDialog(this.o, k());
    }
    this.n.a(this.o.getString(2131916272));
    this.n.show();
  }
  
  private void f()
  {
    QQProgressDialog localQQProgressDialog = this.n;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.n.dismiss();
    }
    this.n = null;
  }
  
  private void g()
  {
    if (c())
    {
      ReportController.b(this.a, "dc00898", "", "", "0X800A329", "0X800A329", 0, 0, "", "", "", "");
      if (this.l == null) {
        this.l = LayoutInflater.from(this.o).inflate(2131627996, null);
      }
      Object localObject = this.l.findViewById(2131446645);
      ((View)localObject).setOnClickListener(this);
      if (ThemeUtil.isDefaultTheme()) {
        ((View)localObject).setBackgroundResource(2130839577);
      } else {
        ((View)localObject).setBackgroundResource(2130839574);
      }
      this.m = ((TextView)this.l.findViewById(2131446646));
      if (this.j != null)
      {
        localObject = new AbsListView.LayoutParams(-1, ViewUtils.dip2px(80.0F));
        this.l.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.j.addHeaderView(this.l);
      }
      int i1 = ((NewFriendServiceImpl)this.a.getRuntimeService(INewFriendService.class, "")).getSysSuspiciousUnreadNum();
      if (i1 > 0)
      {
        localObject = this.m;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(i1);
        localStringBuilder.append("");
        ((TextView)localObject).setText(localStringBuilder.toString());
        return;
      }
      this.m.setText("");
    }
  }
  
  private void h()
  {
    if (this.k == null) {
      this.k = LayoutInflater.from(this.o).inflate(2131627871, null);
    }
    if (this.k.getParent() == null) {
      this.j.addFooterView(this.k);
    }
    this.k.setVisibility(8);
  }
  
  private void i()
  {
    if (this.t) {
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext()))
    {
      localObject = this.o;
      QQToast.makeText((Context)localObject, ((Activity)localObject).getResources().getString(2131889169), 0).show(k());
      return;
    }
    Object localObject = this.A.getMsgList(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
    if ((localObject != null) && (((List)localObject).size() >= 20))
    {
      if (FriendSystemMsgController.a().a(this.a)) {
        return;
      }
      this.t = true;
      this.k.setVisibility(0);
      ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).sendGetNextFriendSystemMsg(this.a);
      if (QLog.isColorLevel()) {
        QLog.i("NewFriendMoreSysMsgAdapter", 2, "loadNextPage.get next page.");
      }
    }
  }
  
  private void j()
  {
    View localView = this.k;
    if (localView != null) {
      localView.setVisibility(8);
    }
    this.t = false;
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "stopLoadMore().");
    }
  }
  
  private int k()
  {
    return this.o.getResources().getDimensionPixelSize(2131299920);
  }
  
  public Bitmap a(int paramInt, String paramString)
  {
    Bitmap localBitmap = this.q.getBitmapFromCache(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.q.isPausing()) {
      this.q.requestDecodeFace(paramString, paramInt, true, (byte)0);
    }
    return BaseImageUtil.k();
  }
  
  public void a()
  {
    this.a.removeObserver(this.E);
    this.a.removeObserver(this.D);
    this.a.removeObserver(this.C);
    this.a.removeObserver(this.F);
    this.a.removeObserver(this.c);
    this.a.removeObserver(this.d);
    this.q.setDecodeTaskCompletionListener(null);
    this.q.destory();
    NewFriendNotifyPokeMsgHelper.b();
  }
  
  public int getCount()
  {
    return this.v.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.v.size())) {
      return this.v.get(paramInt);
    }
    return new Object();
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    MoreSysMsgHolder localMoreSysMsgHolder;
    if (paramView == null)
    {
      localMoreSysMsgHolder = new MoreSysMsgHolder();
      paramView = a(this.o, 2131627870, localMoreSysMsgHolder);
      localMoreSysMsgHolder.a = ((ImageView)paramView.findViewById(2131427337));
      localMoreSysMsgHolder.b = ((TextView)paramView.findViewById(2131439320));
      localMoreSysMsgHolder.c = ((TextView)paramView.findViewById(2131427898));
      localMoreSysMsgHolder.d = ((TextView)paramView.findViewById(2131444728));
      localMoreSysMsgHolder.e = ((TextView)paramView.findViewById(2131446184));
      localMoreSysMsgHolder.f = ((Button)paramView.findViewById(2131444718));
      localMoreSysMsgHolder.g = ((TextView)paramView.findViewById(2131444726));
      localMoreSysMsgHolder.o = ((ImageView)paramView.findViewById(2131444721));
      if ((localMoreSysMsgHolder.a instanceof ThemeImageView)) {
        ((ThemeImageView)localMoreSysMsgHolder.a).setSupportMaskView(false);
      }
      paramView.setTag(localMoreSysMsgHolder);
    }
    else
    {
      localMoreSysMsgHolder = (MoreSysMsgHolder)paramView.getTag();
      b(localMoreSysMsgHolder);
    }
    localMoreSysMsgHolder.leftView.setTag(localMoreSysMsgHolder);
    localMoreSysMsgHolder.leftView.setOnClickListener(this);
    Object localObject = (NewFriendMessage)getItem(paramInt);
    a(this.o, paramView, paramInt, localObject, localMoreSysMsgHolder, this);
    NewFriendUtil.a(localMoreSysMsgHolder.leftView, ((NewFriendMessage)localObject).b() ^ true);
    if ((localObject instanceof FriendSystemMessage))
    {
      localObject = ((FriendSystemMessage)getItem(paramInt)).a;
      a(localMoreSysMsgHolder, paramInt, ((MessageForSystemMsg)localObject).structMsg, ((MessageForSystemMsg)localObject).uniseq);
    }
    else if ((localObject instanceof PhoneContactAddMessage))
    {
      a(localMoreSysMsgHolder, ((PhoneContactAddMessage)getItem(paramInt)).a);
    }
    else if ((localObject instanceof QIMNotifyAddFriendMsg))
    {
      localObject = ((QIMNotifyAddFriendMsg)getItem(paramInt)).a;
      localMoreSysMsgHolder.leftView.setClickable(false);
      a(localMoreSysMsgHolder, (QIMNotifyAddFriend)localObject);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void hideMenuPop() {}
  
  public void interceptTouchEvent(boolean paramBoolean)
  {
    Object localObject = this.u;
    if ((localObject != null) && ((localObject instanceof FlingGestureHandler)))
    {
      localObject = (FlingGestureHandler)localObject;
      if (((FlingGestureHandler)localObject).mTopLayout != null) {
        ((FlingGestureHandler)localObject).mTopLayout.setInterceptTouchFlag(paramBoolean ^ true);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i3 = paramView.getId();
    Object localObject1;
    int i1;
    Object localObject2;
    if (i3 == 2131444905)
    {
      localObject1 = paramView.getTag();
      if ((localObject1 instanceof MoreSysMsgHolder))
      {
        localObject1 = (MoreSysMsgHolder)localObject1;
        if (((MoreSysMsgHolder)localObject1).l == 0)
        {
          if (((MoreSysMsgHolder)localObject1).i.msg_type.get() == 1)
          {
            a((MoreSysMsgHolder)localObject1);
            i1 = ((MoreSysMsgHolder)localObject1).i.msg.sub_type.get();
            if (i1 != 1)
            {
              if ((i1 != 2) && (i1 != 3))
              {
                if (i1 != 6)
                {
                  if (i1 == 13) {
                    ReportController.b(this.a, "dc00898", "", "", "0X8007708", "0X8007708", 0, 0, "", "", "", "");
                  }
                }
                else {
                  ReportController.b(this.a, "dc00898", "", "", "0X8007709", "0X8007709", 0, 0, "", "", "", "");
                }
              }
              else {
                ReportController.b(this.a, "dc00898", "", "", "0X8007707", "0X8007707", 0, 0, "", "", "", "");
              }
            }
            else {
              ReportController.b(this.a, "dc00898", "", "", "0X8007705", "0X8007705", 0, 0, "", "", "", "");
            }
          }
        }
        else if (((MoreSysMsgHolder)localObject1).l == 1)
        {
          localObject2 = ((MoreSysMsgHolder)localObject1).m;
          if (localObject2 != null)
          {
            if (((IPhoneContactService)this.a.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload()) {
              localObject1 = new AllInOne(((PhoneContactAdd)localObject2).unifiedCode, 34);
            } else {
              localObject1 = new AllInOne(((PhoneContactAdd)localObject2).unifiedCode, 29);
            }
            ((AllInOne)localObject1).nickname = ((PhoneContactAdd)localObject2).name;
            ProfileUtils.openProfileCard(this.o, (AllInOne)localObject1);
          }
        }
      }
    }
    else
    {
      i1 = 0;
      int i2 = 0;
      if (i3 == 2131444718)
      {
        localObject1 = paramView.getTag();
        if ((localObject1 != null) && ((localObject1 instanceof MoreSysMsgHolder))) {
          if (!NetworkUtil.isNetworkAvailable(this.o))
          {
            localObject1 = this.o;
            QQToast.makeText((Context)localObject1, ((Activity)localObject1).getResources().getString(2131889169), 0).show(k());
          }
          else
          {
            localObject1 = (MoreSysMsgHolder)localObject1;
            if (((MoreSysMsgHolder)localObject1).l != 2)
            {
              a((structmsg.StructMsg)((MoreSysMsgHolder)localObject1).i.get(), ((MoreSysMsgHolder)localObject1).j);
              long l1 = FriendSystemMsgController.a().d();
              localObject1 = FriendSystemMsgController.a().a(Long.valueOf(l1));
              if (localObject1 != null)
              {
                i1 = ((structmsg.StructMsg)localObject1).msg_type.get();
                l1 = ((structmsg.StructMsg)localObject1).msg_seq.get();
                long l2 = ((structmsg.StructMsg)localObject1).req_uin.get();
                i3 = ((structmsg.StructMsg)localObject1).msg.sub_type.get();
                int i4 = ((structmsg.StructMsg)localObject1).msg.src_id.get();
                int i5 = ((structmsg.StructMsg)localObject1).msg.sub_src_id.get();
                int i6 = ((structmsg.StructMsg)localObject1).msg.group_msg_type.get();
                localObject2 = ((structmsg.StructMsg)localObject1).msg.actions.get();
                if ((localObject2 != null) && (((List)localObject2).size() > 0))
                {
                  localObject2 = (structmsg.SystemMsgActionInfo)((structmsg.SystemMsgAction)((List)localObject2).get(0)).action_info.get();
                  ((structmsg.SystemMsgActionInfo)localObject2).remark.set("");
                  ((structmsg.SystemMsgActionInfo)localObject2).group_id.set(0);
                  structmsg.AddFrdSNInfo localAddFrdSNInfo = new structmsg.AddFrdSNInfo();
                  localAddFrdSNInfo.uint32_not_see_dynamic.set(0);
                  localAddFrdSNInfo.uint32_set_sn.set(0);
                  ((structmsg.SystemMsgActionInfo)localObject2).addFrdSNInfo.set(localAddFrdSNInfo);
                  ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).sendFriendSystemMsgAction(i1, l1, l2, i3, i4, i5, i6, (structmsg.SystemMsgActionInfo)localObject2, 0, (structmsg.StructMsg)localObject1, false, this.a);
                  i1 = 1;
                }
                else
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("agree, ");
                  if (localObject2 != null) {
                    i1 = ((List)localObject2).size();
                  } else {
                    i1 = -1;
                  }
                  ((StringBuilder)localObject1).append(i1);
                  QLog.d("NewFriendMoreSysMsgAdapter", 1, ((StringBuilder)localObject1).toString());
                  i1 = i2;
                }
                i2 = i1;
                if (Utils.c(String.valueOf(l2)))
                {
                  ReportController.b(this.a, "dc00898", "", "", "0X800826E", "0X800826E", 0, 0, "", "", "", "");
                  i2 = i1;
                }
              }
              else
              {
                QLog.d("NewFriendMoreSysMsgAdapter", 1, "agree");
                i2 = i1;
              }
              if (i2 != 0) {
                e();
              }
              ReportController.b(this.a, "dc00898", "", "", "0X8007706", "0X8007706", 0, 0, "", "", "", "");
            }
            else
            {
              ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).clickQIMSource(this.o, null, this.a);
            }
          }
        }
      }
      else if (i3 == 2131446645)
      {
        localObject1 = this.m;
        if (localObject1 != null) {
          ((TextView)localObject1).setText("");
        }
        ReportController.b(this.a, "dc00898", "", "", "0X800A32A", "0X800A32A", 0, 0, "", "", "", "");
        ((INewFriendService)this.a.getRuntimeService(INewFriendService.class, "")).setSysSuspiciousUnreadNum(0);
        ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).jumpToNewFriendMoreSysMsgSuspiciousFragment(this.o);
      }
      else if (i3 == 2131444721)
      {
        if ((paramView.getTag() != null) && ((paramView.getTag() instanceof MoreSysMsgHolder)))
        {
          localObject1 = (MoreSysMsgHolder)paramView.getTag();
          if ((!NetworkUtil.isNetworkAvailable(this.o)) && (NewFriendNotifyPokeMsgHelper.a((structmsg.StructMsg)((MoreSysMsgHolder)localObject1).i.get())))
          {
            localObject1 = this.o;
            QQToast.makeText((Context)localObject1, ((Activity)localObject1).getResources().getString(2131889169), 0).show(k());
          }
          else
          {
            a((structmsg.StructMsg)((MoreSysMsgHolder)localObject1).i.get(), ((MoreSysMsgHolder)localObject1).j);
            NewFriendNotifyPokeMsgHelper.a(this.o, this.a, localObject1);
          }
        }
      }
      else
      {
        a(paramView);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.w.put(paramString, paramBitmap);
    }
    if (paramInt1 <= 0)
    {
      paramInt2 = this.j.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramString = this.j.getChildAt(paramInt1).getTag();
        if ((paramString != null) && ((paramString instanceof MoreSysMsgHolder)))
        {
          paramString = (MoreSysMsgHolder)paramString;
          if ((paramString.k != null) && (paramString.k.length() > 0))
          {
            paramBitmap = (Bitmap)this.w.get(paramString.k);
            if (paramBitmap != null) {
              paramString.a.setImageBitmap(paramBitmap);
            }
          }
        }
        paramInt1 += 1;
      }
      this.w.clear();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.s = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.s == getCount())) {
      i();
    }
    if ((paramInt != 0) && (paramInt != 1))
    {
      this.q.cancelPendingRequests();
      this.q.pause();
      return;
    }
    if (this.q.isPausing()) {
      this.q.resume();
    }
    int i1 = this.j.getChildCount();
    paramInt = 0;
    while (paramInt < i1)
    {
      paramAbsListView = this.j.getChildAt(paramInt).getTag();
      if ((paramAbsListView instanceof MoreSysMsgHolder))
      {
        paramAbsListView = (MoreSysMsgHolder)paramAbsListView;
        if (paramAbsListView.l == 0) {
          d(paramAbsListView);
        } else if (paramAbsListView.l == 1) {
          paramAbsListView.a.setImageBitmap(a(11, paramAbsListView.k));
        }
      }
      paramInt += 1;
    }
  }
  
  public void updateCurShowRightView(View paramView)
  {
    int i2 = -1;
    int i1 = i2;
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      i1 = i2;
      if ((paramView instanceof Integer)) {
        i1 = ((Integer)paramView).intValue();
      }
    }
    this.r = i1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.adapter.NewFriendMoreSysMsgAdapter
 * JD-Core Version:    0.7.0.1
 */