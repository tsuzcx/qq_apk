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
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131691479 };
  private static final int[] jdField_b_of_type_ArrayOfInt = { 2130839507 };
  private static final int[] jdField_c_of_type_ArrayOfInt = { 2131370801 };
  private final int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private FlingHandler jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new NewFriendMoreSysMsgAdapter.6(this);
  DiscussionObserver jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver = new NewFriendMoreSysMsgAdapter.10(this);
  private IFriendDataService jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService;
  private FriendObserver jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver = new NewFriendMoreSysMsgAdapter.7(this);
  private IMessageFacade jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade;
  private NewFriendListObserver jdField_a_of_type_ComTencentMobileqqNewfriendObserverNewFriendListObserver = new NewFriendMoreSysMsgAdapter.8(this);
  private NewFriendMessageObserver jdField_a_of_type_ComTencentMobileqqNewfriendObserverNewFriendMessageObserver = new NewFriendMoreSysMsgAdapter.9(this);
  NewFriendNotifyPokeObserver jdField_a_of_type_ComTencentMobileqqNewfriendObserverNewFriendNotifyPokeObserver = new NewFriendMoreSysMsgAdapter.11(this);
  private IPhoneContactService jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private SwipListView jdField_a_of_type_ComTencentWidgetSwipListView;
  private SwipRightMenuBuilder jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder;
  private ArrayList<NewFriendMessage> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Comparator<NewFriendMessage> jdField_a_of_type_JavaUtilComparator = new NewFriendMoreSysMsgAdapter.1(this);
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  final ConcurrentHashMap<Long, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private View jdField_b_of_type_AndroidViewView;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private int d;
  
  public NewFriendMoreSysMsgAdapter(Activity paramActivity, AppInterface paramAppInterface, SwipListView paramSwipListView, View paramView1, View paramView2, FlingHandler paramFlingHandler, int paramInt)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService = ((IFriendDataService)paramAppInterface.getRuntimeService(IFriendDataService.class, ""));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
    this.jdField_a_of_type_AndroidViewView = paramView1;
    this.jdField_a_of_type_ComTencentWidgetSwipListView = paramSwipListView;
    g();
    f();
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setAdapter(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setOnScrollListener(this);
    this.jdField_a_of_type_ComTencentWidgetSwipListView.setDragEnable(true);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqNewfriendObserverNewFriendListObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqNewfriendObserverNewFriendMessageObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver, true);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqNewfriendObserverNewFriendNotifyPokeObserver);
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler = paramFlingHandler;
    this.d = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqPhonecontactApiIPhoneContactService = ((IPhoneContactService)paramAppInterface.getRuntimeService(IPhoneContactService.class, ""));
    this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade = ((IMessageFacade)paramAppInterface.getRuntimeService(IMessageFacade.class, ""));
    a(true);
    paramView2.setOnClickListener(new NewFriendMoreSysMsgAdapter.2(this, paramAppInterface));
    if (a()) {
      ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getSuspiciousFriendsUnreadNum(paramAppInterface);
    }
  }
  
  private int a()
  {
    return this.jdField_a_of_type_AndroidAppActivity.getResources().getDimensionPixelSize(2131299168);
  }
  
  private View a(Context paramContext, int paramInt, MoreSysMsgHolder paramMoreSysMsgHolder)
  {
    View localView = LayoutInflater.from(paramContext).inflate(paramInt, null);
    return this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder.createView(paramContext, localView, paramMoreSysMsgHolder, -1);
  }
  
  private SwipRightMenuBuilder a(Context paramContext)
  {
    int i = paramContext.getResources().getDimensionPixelSize(2131298886);
    int j = paramContext.getResources().getDimensionPixelSize(2131298887);
    paramContext = jdField_c_of_type_ArrayOfInt;
    int[] arrayOfInt1 = jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = jdField_b_of_type_ArrayOfInt;
    return new NewFriendMoreSysMsgAdapter.14(this, 1, 2, new int[] { i, j }, -1, paramContext, arrayOfInt1, arrayOfInt2);
  }
  
  private void a(Context paramContext, View paramView, int paramInt, Object paramObject, SwipRightMenuBuilder.SwipItemBaseHolder paramSwipItemBaseHolder, View.OnClickListener paramOnClickListener)
  {
    SwipRightMenuBuilder localSwipRightMenuBuilder = this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder;
    int i;
    if (localSwipRightMenuBuilder != null) {
      i = localSwipRightMenuBuilder.updateRightMenuView(paramContext, paramView, paramInt, paramObject, paramSwipItemBaseHolder, paramOnClickListener);
    } else {
      i = 0;
    }
    int j = this.jdField_b_of_type_Int;
    if (j != -1)
    {
      if (paramInt != j)
      {
        paramView.scrollTo(0, 0);
        return;
      }
      paramView.scrollTo(i, 0);
    }
  }
  
  private void a(View paramView)
  {
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity))
    {
      paramView = this.jdField_a_of_type_AndroidAppActivity;
      QQToast.a(paramView, paramView.getResources().getString(2131692183), 0).b(a());
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
      int i = ((Integer)localObject).intValue();
      if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("handleDeleteItem|onClick position = ");
        paramView.append(i);
        QLog.i("NewFriendMoreSysMsgAdapter", 2, paramView.toString());
      }
      paramView = getItem(i);
      if (!(paramView instanceof NewFriendMessage)) {
        return;
      }
      paramView = (NewFriendMessage)paramView;
      if ((paramView instanceof FriendSystemMessage))
      {
        paramView = (FriendSystemMessage)paramView;
        d();
        ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).sendDelSingleSystemMsg(paramView.a.structMsg, paramView.a.frienduin, paramView.a.istroop, paramView.a.uniseq, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8006A74", "0X8006A74", 0, 0, "", "", "", "");
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
    int i = 2;
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleBuddySystemMsg! start ");
      ((StringBuilder)localObject1).append(paramMoreSysMsgHolder.jdField_a_of_type_Long);
      QLog.d("NewFriendMoreSysMsgAdapter", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = null;
    if (FriendSystemMessage.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true)) {
      localObject1 = KplRoleInfo.WZRYUIinfo.createInfo(String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.getText().toString(), "", paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get());
    }
    int j = paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
    switch (j)
    {
    case 11: 
    default: 
      break;
    case 13: 
      localObject2 = new Intent();
      ((Intent)localObject2).putExtra("param_wzry_data", (Serializable)localObject1);
      SystemMessageHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidAppActivity, String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get(), j, paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), (Intent)localObject2);
      return;
    case 2: 
    case 3: 
      paramMoreSysMsgHolder = new AllInOne(String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 1);
      ProfileUtils.openProfileCard(this.jdField_a_of_type_AndroidAppActivity, paramMoreSysMsgHolder);
      return;
    case 1: 
      i = 1;
      break;
    case 0: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 12: 
      i = 0;
    }
    Object localObject3 = paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
    Object localObject2 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject2 = String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
    }
    localObject3 = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getAddRequestIntent(this.jdField_a_of_type_AndroidAppActivity);
    ((Intent)localObject3).putExtra("infoid", paramMoreSysMsgHolder.jdField_a_of_type_Long);
    ((Intent)localObject3).putExtra("infouin", String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
    ((Intent)localObject3).putExtra("infonick", (String)localObject2);
    ((Intent)localObject3).putExtra("infotime", paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_time.get());
    ((Intent)localObject3).putExtra("msg_type", paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get());
    ((Intent)localObject3).putExtra("strNickName", (String)localObject2);
    ((Intent)localObject3).putExtra("verify_msg", paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    ((Intent)localObject3).putExtra("msg_source", paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get());
    ((Intent)localObject3).putExtra("msg_troopuin", paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
    ((Intent)localObject3).putExtra("system_message_summary", paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get());
    ((Intent)localObject3).putExtra("info_dealwith_msg", paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
    ((Intent)localObject3).putExtra("msg_title", paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_title.get());
    ((Intent)localObject3).putExtra("msg_source_id", paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get());
    if (i > 0) {
      ((Intent)localObject3).putExtra("verify_type", i);
    }
    if (localObject1 != null)
    {
      ((Intent)localObject3).putExtra("param_wzry_data", (Serializable)localObject1);
      ((Intent)localObject3).putExtra("strNickName", ((KplRoleInfo.WZRYUIinfo)localObject1).nick);
      ((Intent)localObject3).putExtra("infonick", ((KplRoleInfo.WZRYUIinfo)localObject1).nick);
    }
    a((structmsg.StructMsg)paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), paramMoreSysMsgHolder.jdField_b_of_type_Long);
    this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject3);
  }
  
  private void a(MoreSysMsgHolder paramMoreSysMsgHolder, int paramInt, structmsg.StructMsg paramStructMsg, long paramLong)
  {
    paramMoreSysMsgHolder.jdField_a_of_type_Long = paramInt;
    paramMoreSysMsgHolder.jdField_a_of_type_JavaLangString = String.valueOf(paramStructMsg.req_uin.get());
    paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = paramStructMsg;
    paramMoreSysMsgHolder.jdField_b_of_type_Long = paramLong;
    paramMoreSysMsgHolder.jdField_a_of_type_Int = 0;
    Object localObject1 = paramStructMsg.msg;
    String str = null;
    if (localObject1 != null) {
      localObject2 = paramStructMsg.msg.req_uin_nick.get();
    } else {
      localObject2 = null;
    }
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService.getFriend(String.valueOf(paramStructMsg.req_uin.get()));
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
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
    }
    else
    {
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (Utils.b((String)localObject3)))
    {
      localObject1 = this.jdField_a_of_type_AndroidAppActivity.getResources().getDrawable(2130841838);
      ((Drawable)localObject1).setBounds(0, 0, ViewUtils.a(15.0F), ViewUtils.a(15.0F));
      ThemeUtil.setThemeFilter((Drawable)localObject1, ThemeUtil.curThemeId);
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(ViewUtils.a(5.0F));
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, (Drawable)localObject1, null);
    }
    else
    {
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
    d(paramMoreSysMsgHolder);
    paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetImageView.setTag(paramMoreSysMsgHolder);
    paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
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
            str = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(paramLong));
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
      paramMoreSysMsgHolder.d.setText(String.format(Locale.getDefault(), HardCodeUtil.a(2131707525), new Object[] { localObject1 }));
      paramMoreSysMsgHolder.d.setVisibility(0);
    }
    else
    {
      paramMoreSysMsgHolder.d.setVisibility(8);
    }
    if (paramStructMsg.msg != null)
    {
      paramMoreSysMsgHolder.c.setText(FriendSystemMessage.a(this.jdField_a_of_type_AndroidAppActivity, paramStructMsg));
      switch (paramStructMsg.msg.sub_type.get())
      {
      case 11: 
      default: 
        break;
      case 13: 
        paramMoreSysMsgHolder.e.setVisibility(0);
        paramStructMsg = paramStructMsg.msg.msg_decided.get();
        paramMoreSysMsgHolder.e.setText(paramStructMsg);
        paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        paramMoreSysMsgHolder.d.setVisibility(8);
        break;
      case 12: 
        if (paramStructMsg.msg.reqsubtype.has()) {
          if (paramStructMsg.msg.reqsubtype.get() == 1)
          {
            paramMoreSysMsgHolder.e.setVisibility(0);
            paramStructMsg = paramStructMsg.msg.msg_decided.get();
            paramMoreSysMsgHolder.e.setText(paramStructMsg);
            paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
          else if (paramStructMsg.msg.reqsubtype.get() == 2)
          {
            paramMoreSysMsgHolder.e.setVisibility(8);
            paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
        }
        break;
      case 10: 
        if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
        {
          paramMoreSysMsgHolder.e.setVisibility(8);
          paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
          paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
        }
        else
        {
          paramMoreSysMsgHolder.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramMoreSysMsgHolder.e.setText(paramStructMsg);
          paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        }
        c(paramMoreSysMsgHolder);
        break;
      case 9: 
        if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
        {
          paramMoreSysMsgHolder.e.setVisibility(8);
          paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
          paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
        }
        else
        {
          paramMoreSysMsgHolder.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramMoreSysMsgHolder.e.setText(paramStructMsg);
          paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          NewFriendNotifyPokeMsgHelper.a(paramMoreSysMsgHolder, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        }
        c(paramMoreSysMsgHolder);
        break;
      case 8: 
        paramMoreSysMsgHolder.e.setVisibility(0);
        paramStructMsg = paramStructMsg.msg.msg_decided.get();
        paramMoreSysMsgHolder.e.setText(paramStructMsg);
        paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        break;
      case 7: 
        paramMoreSysMsgHolder.e.setVisibility(0);
        paramStructMsg = paramStructMsg.msg.msg_decided.get();
        paramMoreSysMsgHolder.e.setText(paramStructMsg);
        paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        c(paramMoreSysMsgHolder);
        break;
      case 6: 
        if (!TextUtils.isEmpty(paramStructMsg.msg.msg_additional.get()))
        {
          paramMoreSysMsgHolder.d.setText(paramStructMsg.msg.msg_additional.get());
          paramMoreSysMsgHolder.c.setText(paramStructMsg.msg.msg_describe.get());
        }
        else
        {
          paramMoreSysMsgHolder.d.setVisibility(8);
        }
        paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        paramMoreSysMsgHolder.e.setVisibility(8);
        break;
      case 5: 
        paramMoreSysMsgHolder.e.setVisibility(8);
        paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        break;
      case 4: 
        paramMoreSysMsgHolder.e.setVisibility(8);
        paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        break;
      case 3: 
        paramMoreSysMsgHolder.e.setVisibility(0);
        paramStructMsg = paramStructMsg.msg.msg_decided.get();
        paramMoreSysMsgHolder.e.setText(paramStructMsg);
        paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        c(paramMoreSysMsgHolder);
        NewFriendNotifyPokeMsgHelper.a(paramMoreSysMsgHolder, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        break;
      case 2: 
        paramMoreSysMsgHolder.e.setVisibility(0);
        paramStructMsg = paramStructMsg.msg.msg_decided.get();
        paramMoreSysMsgHolder.e.setText(paramStructMsg);
        paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        c(paramMoreSysMsgHolder);
        NewFriendNotifyPokeMsgHelper.a(paramMoreSysMsgHolder, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        break;
      case 1: 
        if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get())))
        {
          paramMoreSysMsgHolder.e.setVisibility(8);
          paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          paramStructMsg = ((structmsg.SystemMsgAction)paramStructMsg.msg.actions.get().get(0)).name.get();
          paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setText(paramStructMsg);
        }
        else if ((paramStructMsg.msg.actions.get() != null) && (paramStructMsg.msg.actions.get().size() == 0))
        {
          paramMoreSysMsgHolder.e.setVisibility(0);
          paramStructMsg = paramStructMsg.msg.msg_decided.get();
          paramMoreSysMsgHolder.e.setText(paramStructMsg);
          paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        }
        c(paramMoreSysMsgHolder);
      }
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramMoreSysMsgHolder);
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetImageView.setTag(paramMoreSysMsgHolder);
      paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    }
  }
  
  private void a(MoreSysMsgHolder paramMoreSysMsgHolder, QIMNotifyAddFriend paramQIMNotifyAddFriend)
  {
    paramMoreSysMsgHolder.jdField_a_of_type_Int = 2;
    paramMoreSysMsgHolder.jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend = paramQIMNotifyAddFriend;
    paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramQIMNotifyAddFriend.nickName);
    ((INewFriendApi)QRoute.api(INewFriendApi.class)).showGenderAge(paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView, paramQIMNotifyAddFriend.gender, paramQIMNotifyAddFriend.age, null);
    Object localObject = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getQQInfoFromQQUin(paramQIMNotifyAddFriend.uin, paramQIMNotifyAddFriend.qqUin, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramMoreSysMsgHolder.c.setVisibility(8);
    }
    else
    {
      paramMoreSysMsgHolder.c.setVisibility(0);
      paramMoreSysMsgHolder.c.setText((CharSequence)localObject);
    }
    String str = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getQIMNewFriendSource(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    localObject = str;
    if (TextUtils.isEmpty(str)) {
      localObject = "来自QIM的好友申请";
    }
    localObject = String.format(Locale.getDefault(), HardCodeUtil.a(2131707525), new Object[] { localObject });
    paramMoreSysMsgHolder.d.setText((CharSequence)localObject);
    paramMoreSysMsgHolder.d.setVisibility(0);
    paramMoreSysMsgHolder.e.setVisibility(8);
    paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setText(HardCodeUtil.a(2131707521));
    paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramMoreSysMsgHolder);
    paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
    paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetImageView.setTag(paramMoreSysMsgHolder);
    paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    paramMoreSysMsgHolder.jdField_a_of_type_JavaLangString = String.valueOf(paramQIMNotifyAddFriend.uin);
    paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(1, String.valueOf(paramQIMNotifyAddFriend.uin)));
  }
  
  private void a(MoreSysMsgHolder paramMoreSysMsgHolder, PhoneContactAdd paramPhoneContactAdd)
  {
    paramMoreSysMsgHolder.jdField_a_of_type_Int = 1;
    paramMoreSysMsgHolder.jdField_a_of_type_ComTencentMobileqqPhonecontactDataPhoneContactAdd = paramPhoneContactAdd;
    if (!TextUtils.isEmpty(paramPhoneContactAdd.name))
    {
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramPhoneContactAdd.name);
    }
    else
    {
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    paramMoreSysMsgHolder.d.setVisibility(8);
    if (!TextUtils.isEmpty(paramPhoneContactAdd.remindInfo))
    {
      paramMoreSysMsgHolder.c.setVisibility(0);
      paramMoreSysMsgHolder.c.setText(paramPhoneContactAdd.remindInfo);
    }
    else
    {
      paramMoreSysMsgHolder.c.setVisibility(8);
    }
    paramMoreSysMsgHolder.e.setVisibility(0);
    paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    paramMoreSysMsgHolder.e.setText(this.jdField_a_of_type_AndroidAppActivity.getString(2131718222));
    paramMoreSysMsgHolder.jdField_a_of_type_JavaLangString = paramPhoneContactAdd.unifiedCode;
    paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(11, paramPhoneContactAdd.unifiedCode));
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      FriendSystemMsgController.a().a(Long.valueOf(l), (structmsg.StructMsg)paramStructMsg.get());
      FriendSystemMsgController.a().b(l);
      FriendSystemMsgController.a().a(paramLong);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    ThreadManager.postImmediately(new NewFriendMoreSysMsgAdapter.5(this, paramBoolean), null, true);
  }
  
  private boolean a()
  {
    return ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).isSuspiciousSwitchOpen();
  }
  
  private void b()
  {
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    DialogUtil.a(localActivity, null, localActivity.getString(2131699379), null, 2131690728, 2131699378, new NewFriendMoreSysMsgAdapter.3(this), new NewFriendMoreSysMsgAdapter.4(this)).show();
  }
  
  private void b(MoreSysMsgHolder paramMoreSysMsgHolder)
  {
    paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramMoreSysMsgHolder.c.setVisibility(0);
    paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
    paramMoreSysMsgHolder.d.setVisibility(0);
    paramMoreSysMsgHolder.e.setVisibility(8);
    paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  private void c()
  {
    a(false);
  }
  
  private void c(MoreSysMsgHolder paramMoreSysMsgHolder)
  {
    int k;
    if (paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.has()) {
      k = paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.get();
    } else {
      k = -1;
    }
    int i;
    int j;
    if (k != 0)
    {
      if (k != 1)
      {
        paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130846056);
        i = 0;
        j = 0;
      }
      else
      {
        paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130846054);
        i = 1;
        j = 2130846053;
      }
    }
    else
    {
      j = 2130846055;
      paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130846056);
      i = 1;
    }
    int m = i;
    if (paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.has()) {
      if ((paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get() > 0) && ((k == 0) || (k == 1)))
      {
        paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get()));
        m = 1;
      }
      else
      {
        paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setText("");
        m = i;
      }
    }
    paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(j, 0, 0, 0);
    if (m != 0)
    {
      paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    paramMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidAppActivity, a());
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.jdField_a_of_type_AndroidAppActivity.getString(2131718766));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
  
  private void d(MoreSysMsgHolder paramMoreSysMsgHolder)
  {
    if (paramMoreSysMsgHolder != null)
    {
      if (paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetImageView == null) {
        return;
      }
      int k = paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
      int j = 0;
      int i;
      Object localObject1;
      if ((k != 3007) && (k != 3019) && (k != 2007) && (k != 4007))
      {
        i = j;
        if (k != 2019) {}
      }
      else
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqFriendApiIFriendDataService;
        if ((localObject1 != null) && (((IFriendDataService)localObject1).isFriend(String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get())))) {
          i = j;
        } else {
          i = 1;
        }
      }
      if (i != 0)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(32, String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 200);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
          {
            this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeStrangeFace(String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 200, true, true);
            localObject1 = localObject2;
          }
        }
      }
      else
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = localObject2;
          if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing())
          {
            this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(String.valueOf(paramMoreSysMsgHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 1, true);
            localObject1 = localObject2;
          }
        }
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = BaseImageUtil.f();
      }
      paramMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
    }
  }
  
  private void e()
  {
    QQProgressDialog localQQProgressDialog = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  }
  
  private void f()
  {
    if (a())
    {
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X800A329", "0X800A329", 0, 0, "", "", "", "");
      if (this.jdField_c_of_type_AndroidViewView == null) {
        this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561617, null);
      }
      Object localObject = this.jdField_c_of_type_AndroidViewView.findViewById(2131378136);
      ((View)localObject).setOnClickListener(this);
      if (ThemeUtil.isDefaultTheme()) {
        ((View)localObject).setBackgroundResource(2130839393);
      } else {
        ((View)localObject).setBackgroundResource(2130839390);
      }
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378137));
      if (this.jdField_a_of_type_ComTencentWidgetSwipListView != null)
      {
        localObject = new AbsListView.LayoutParams(-1, ViewUtils.a(80.0F));
        this.jdField_c_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_a_of_type_ComTencentWidgetSwipListView.addHeaderView(this.jdField_c_of_type_AndroidViewView);
      }
      int i = ((NewFriendServiceImpl)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(INewFriendService.class, "")).getSysSuspiciousUnreadNum();
      if (i > 0)
      {
        localObject = this.jdField_a_of_type_AndroidWidgetTextView;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(i);
        localStringBuilder.append("");
        ((TextView)localObject).setText(localStringBuilder.toString());
        return;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText("");
    }
  }
  
  private void g()
  {
    if (this.jdField_b_of_type_AndroidViewView == null) {
      this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131561510, null);
    }
    if (this.jdField_b_of_type_AndroidViewView.getParent() == null) {
      this.jdField_a_of_type_ComTencentWidgetSwipListView.addFooterView(this.jdField_b_of_type_AndroidViewView);
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext()))
    {
      localObject = this.jdField_a_of_type_AndroidAppActivity;
      QQToast.a((Context)localObject, ((Activity)localObject).getResources().getString(2131692183), 0).b(a());
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqMsgApiIMessageFacade.getMsgList(AppConstants.FRIEND_SYSTEM_MSG_UIN, 0);
    if ((localObject != null) && (((List)localObject).size() >= 20))
    {
      if (FriendSystemMsgController.a().a(this.jdField_a_of_type_ComTencentCommonAppAppInterface)) {
        return;
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).sendGetNextFriendSystemMsg(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
      if (QLog.isColorLevel()) {
        QLog.i("NewFriendMoreSysMsgAdapter", 2, "loadNextPage.get next page.");
      }
    }
  }
  
  private void i()
  {
    View localView = this.jdField_b_of_type_AndroidViewView;
    if (localView != null) {
      localView.setVisibility(8);
    }
    this.jdField_a_of_type_Boolean = false;
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendMoreSysMsgAdapter", 2, "stopLoadMore().");
    }
  }
  
  public Bitmap a(int paramInt, String paramString)
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(paramInt, paramString);
    if (localBitmap != null) {
      return localBitmap;
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, paramInt, true, (byte)0);
    }
    return BaseImageUtil.f();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqNewfriendObserverNewFriendListObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqNewfriendObserverNewFriendMessageObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqDiscussionObserverDiscussionObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqNewfriendObserverNewFriendNotifyPokeObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(null);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    NewFriendNotifyPokeMsgHelper.b();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())) {
      return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
      paramView = a(this.jdField_a_of_type_AndroidAppActivity, 2131561509, localMoreSysMsgHolder);
      localMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131361799));
      localMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131371877));
      localMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362299));
      localMoreSysMsgHolder.c = ((TextView)paramView.findViewById(2131376487));
      localMoreSysMsgHolder.d = ((TextView)paramView.findViewById(2131377726));
      localMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131376477));
      localMoreSysMsgHolder.e = ((TextView)paramView.findViewById(2131376485));
      localMoreSysMsgHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131376480));
      if ((localMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetImageView instanceof ThemeImageView)) {
        ((ThemeImageView)localMoreSysMsgHolder.jdField_a_of_type_AndroidWidgetImageView).setSupportMaskView(false);
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
    a(this.jdField_a_of_type_AndroidAppActivity, paramView, paramInt, localObject, localMoreSysMsgHolder, this);
    NewFriendUtil.a(localMoreSysMsgHolder.leftView, ((NewFriendMessage)localObject).a() ^ true);
    if ((localObject instanceof FriendSystemMessage))
    {
      localObject = ((FriendSystemMessage)getItem(paramInt)).a;
      a(localMoreSysMsgHolder, paramInt, ((MessageForSystemMsg)localObject).structMsg, ((MessageForSystemMsg)localObject).uniseq);
    }
    else if ((localObject instanceof PhoneContactAddMessage))
    {
      a(localMoreSysMsgHolder, ((PhoneContactAddMessage)getItem(paramInt)).jdField_a_of_type_ComTencentMobileqqPhonecontactDataPhoneContactAdd);
    }
    else if ((localObject instanceof QIMNotifyAddFriendMsg))
    {
      localObject = ((QIMNotifyAddFriendMsg)getItem(paramInt)).jdField_a_of_type_ComTencentMobileqqDataQIMNotifyAddFriend;
      localMoreSysMsgHolder.leftView.setClickable(false);
      a(localMoreSysMsgHolder, (QIMNotifyAddFriend)localObject);
    }
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public void hideMenuPop() {}
  
  public void interceptTouchEvent(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFlingFlingHandler;
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
    int k = paramView.getId();
    Object localObject1;
    int i;
    Object localObject2;
    if (k == 2131376644)
    {
      localObject1 = paramView.getTag();
      if ((localObject1 instanceof MoreSysMsgHolder))
      {
        localObject1 = (MoreSysMsgHolder)localObject1;
        if (((MoreSysMsgHolder)localObject1).jdField_a_of_type_Int == 0)
        {
          if (((MoreSysMsgHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get() == 1)
          {
            a((MoreSysMsgHolder)localObject1);
            i = ((MoreSysMsgHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
            if (i != 1)
            {
              if ((i != 2) && (i != 3))
              {
                if (i != 6)
                {
                  if (i == 13) {
                    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X8007708", "0X8007708", 0, 0, "", "", "", "");
                  }
                }
                else {
                  ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X8007709", "0X8007709", 0, 0, "", "", "", "");
                }
              }
              else {
                ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X8007707", "0X8007707", 0, 0, "", "", "", "");
              }
            }
            else {
              ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X8007705", "0X8007705", 0, 0, "", "", "", "");
            }
          }
        }
        else if (((MoreSysMsgHolder)localObject1).jdField_a_of_type_Int == 1)
        {
          localObject2 = ((MoreSysMsgHolder)localObject1).jdField_a_of_type_ComTencentMobileqqPhonecontactDataPhoneContactAdd;
          if (localObject2 != null)
          {
            if (((IPhoneContactService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IPhoneContactService.class, "")).isBindedIgnoreUpload()) {
              localObject1 = new AllInOne(((PhoneContactAdd)localObject2).unifiedCode, 34);
            } else {
              localObject1 = new AllInOne(((PhoneContactAdd)localObject2).unifiedCode, 29);
            }
            ((AllInOne)localObject1).nickname = ((PhoneContactAdd)localObject2).name;
            ProfileUtils.openProfileCard(this.jdField_a_of_type_AndroidAppActivity, (AllInOne)localObject1);
          }
        }
      }
    }
    else
    {
      i = 0;
      int j = 0;
      if (k == 2131376477)
      {
        localObject1 = paramView.getTag();
        if ((localObject1 != null) && ((localObject1 instanceof MoreSysMsgHolder))) {
          if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity))
          {
            localObject1 = this.jdField_a_of_type_AndroidAppActivity;
            QQToast.a((Context)localObject1, ((Activity)localObject1).getResources().getString(2131692183), 0).b(a());
          }
          else
          {
            localObject1 = (MoreSysMsgHolder)localObject1;
            if (((MoreSysMsgHolder)localObject1).jdField_a_of_type_Int != 2)
            {
              a((structmsg.StructMsg)((MoreSysMsgHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), ((MoreSysMsgHolder)localObject1).jdField_b_of_type_Long);
              long l1 = FriendSystemMsgController.a().b();
              localObject1 = FriendSystemMsgController.a().a(Long.valueOf(l1));
              if (localObject1 != null)
              {
                i = ((structmsg.StructMsg)localObject1).msg_type.get();
                l1 = ((structmsg.StructMsg)localObject1).msg_seq.get();
                long l2 = ((structmsg.StructMsg)localObject1).req_uin.get();
                k = ((structmsg.StructMsg)localObject1).msg.sub_type.get();
                int m = ((structmsg.StructMsg)localObject1).msg.src_id.get();
                int n = ((structmsg.StructMsg)localObject1).msg.sub_src_id.get();
                int i1 = ((structmsg.StructMsg)localObject1).msg.group_msg_type.get();
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
                  ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).sendFriendSystemMsgAction(i, l1, l2, k, m, n, i1, (structmsg.SystemMsgActionInfo)localObject2, 0, (structmsg.StructMsg)localObject1, false, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
                  i = 1;
                }
                else
                {
                  localObject1 = new StringBuilder();
                  ((StringBuilder)localObject1).append("agree, ");
                  if (localObject2 != null) {
                    i = ((List)localObject2).size();
                  } else {
                    i = -1;
                  }
                  ((StringBuilder)localObject1).append(i);
                  QLog.d("NewFriendMoreSysMsgAdapter", 1, ((StringBuilder)localObject1).toString());
                  i = j;
                }
                j = i;
                if (Utils.b(String.valueOf(l2)))
                {
                  ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X800826E", "0X800826E", 0, 0, "", "", "", "");
                  j = i;
                }
              }
              else
              {
                QLog.d("NewFriendMoreSysMsgAdapter", 1, "agree");
                j = i;
              }
              if (j != 0) {
                d();
              }
              ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X8007706", "0X8007706", 0, 0, "", "", "", "");
            }
            else
            {
              ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).clickQIMSource(this.jdField_a_of_type_AndroidAppActivity, null, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
            }
          }
        }
      }
      else if (k == 2131378136)
      {
        localObject1 = this.jdField_a_of_type_AndroidWidgetTextView;
        if (localObject1 != null) {
          ((TextView)localObject1).setText("");
        }
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X800A32A", "0X800A32A", 0, 0, "", "", "", "");
        ((INewFriendService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(INewFriendService.class, "")).setSysSuspiciousUnreadNum(0);
        ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).jumpToNewFriendMoreSysMsgSuspiciousFragment(this.jdField_a_of_type_AndroidAppActivity);
      }
      else if (k == 2131376480)
      {
        if ((paramView.getTag() != null) && ((paramView.getTag() instanceof MoreSysMsgHolder)))
        {
          localObject1 = (MoreSysMsgHolder)paramView.getTag();
          if ((!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidAppActivity)) && (NewFriendNotifyPokeMsgHelper.a((structmsg.StructMsg)((MoreSysMsgHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get())))
          {
            localObject1 = this.jdField_a_of_type_AndroidAppActivity;
            QQToast.a((Context)localObject1, ((Activity)localObject1).getResources().getString(2131692183), 0).b(a());
          }
          else
          {
            a((structmsg.StructMsg)((MoreSysMsgHolder)localObject1).jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), ((MoreSysMsgHolder)localObject1).jdField_b_of_type_Long);
            NewFriendNotifyPokeMsgHelper.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface, localObject1);
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
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
    }
    if (paramInt1 <= 0)
    {
      paramInt2 = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildCount();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        paramString = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt1).getTag();
        if ((paramString != null) && ((paramString instanceof MoreSysMsgHolder)))
        {
          paramString = (MoreSysMsgHolder)paramString;
          if ((paramString.jdField_a_of_type_JavaLangString != null) && (paramString.jdField_a_of_type_JavaLangString.length() > 0))
          {
            paramBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString.jdField_a_of_type_JavaLangString);
            if (paramBitmap != null) {
              paramString.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap);
            }
          }
        }
        paramInt1 += 1;
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_c_of_type_Int = (paramInt1 + paramInt2 - 1);
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_c_of_type_Int == getCount())) {
      h();
    }
    if ((paramInt != 0) && (paramInt != 1))
    {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.cancelPendingRequests();
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.pause();
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.isPausing()) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.resume();
    }
    int i = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildCount();
    paramInt = 0;
    while (paramInt < i)
    {
      paramAbsListView = this.jdField_a_of_type_ComTencentWidgetSwipListView.getChildAt(paramInt).getTag();
      if ((paramAbsListView instanceof MoreSysMsgHolder))
      {
        paramAbsListView = (MoreSysMsgHolder)paramAbsListView;
        if (paramAbsListView.jdField_a_of_type_Int == 0) {
          d(paramAbsListView);
        } else if (paramAbsListView.jdField_a_of_type_Int == 1) {
          paramAbsListView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(a(11, paramAbsListView.jdField_a_of_type_JavaLangString));
        }
      }
      paramInt += 1;
    }
  }
  
  public void updateCurShowRightView(View paramView)
  {
    int j = -1;
    int i = j;
    if (paramView != null)
    {
      paramView = paramView.getTag(-1);
      i = j;
      if ((paramView instanceof Integer)) {
        i = ((Integer)paramView).intValue();
      }
    }
    this.jdField_b_of_type_Int = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.adapter.NewFriendMoreSysMsgAdapter
 * JD-Core Version:    0.7.0.1
 */