package com.tencent.mobileqq.newfriend.ui.builder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.KplRoleInfo.WZRYUIinfo;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.msg.FriendSystemMessage;
import com.tencent.mobileqq.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.newfriend.poke.NewFriendNotifyPokeMsgHelper;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListAdapter;
import com.tencent.mobileqq.newfriend.ui.adapter.SystemMsgListBaseAdapter;
import com.tencent.mobileqq.newfriend.ui.view.BaseNewFriendView.INewFriendContext;
import com.tencent.mobileqq.newfriend.ui.view.SystemMsgListView;
import com.tencent.mobileqq.newfriend.utils.NewFriendUtil;
import com.tencent.mobileqq.newfriend.utils.SystemMessageHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.systemmsg.MessageForSystemMsg;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipRightMenuBuilder.SwipItemBaseHolder;
import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import tencent.mobileim.structmsg.structmsg.AddFrdSNInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsgAction;
import tencent.mobileim.structmsg.structmsg.SystemMsgActionInfo;

public class SystemMsgItemBuilder
  extends NewFriendBaseBuilder
  implements View.OnClickListener
{
  public long a;
  private INewFriendService jdField_a_of_type_ComTencentMobileqqNewfriendApiINewFriendService;
  private String jdField_a_of_type_JavaLangString;
  private structmsg.StructMsg jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
  private long b;
  
  public SystemMsgItemBuilder(Context paramContext, AppInterface paramAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    this.jdField_a_of_type_Long = 0L;
    paramSystemMsgListAdapter = (FriendSystemMessage)paramNewFriendMessage;
    this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = paramSystemMsgListAdapter.a.getSystemMsg();
    this.jdField_b_of_type_Long = paramSystemMsgListAdapter.a.uniseq;
    this.jdField_a_of_type_ComTencentWidgetSwipRightMenuBuilder = a(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqNewfriendApiINewFriendService = ((INewFriendService)paramAppInterface.getRuntimeService(INewFriendService.class, ""));
    int i;
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_source_flag.has()) {
      i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint32_source_flag.get();
    } else {
      i = 0;
    }
    paramSystemMsgListAdapter = null;
    if ((i & 0x8) == 8)
    {
      if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint64_discuss_uin.has()) {
        this.jdField_a_of_type_Long = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.uint64_discuss_uin.get();
      }
      if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.has()) {
        paramSystemMsgListAdapter = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get();
      }
      if (this.jdField_a_of_type_Long != 0L)
      {
        this.jdField_a_of_type_JavaLangString = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getDiscussionNameCanNull(paramAppInterface, String.valueOf(this.jdField_a_of_type_Long));
        if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getDiscussInfo(this.jdField_a_of_type_Long, paramAppInterface);
          if (QLog.isColorLevel()) {
            QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "SystemMsgItemBuilder need get discuss info %d", new Object[] { Long.valueOf(this.jdField_a_of_type_Long) }));
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "SystemMsgItemBuilder source_flag: %d  discussUin: %d mDiscussName: %s msg_source: %s", new Object[] { Integer.valueOf(i), Long.valueOf(this.jdField_a_of_type_Long), this.jdField_a_of_type_JavaLangString, paramSystemMsgListAdapter }));
      }
    }
    else
    {
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_a_of_type_Long = 0L;
    }
    this.jdField_b_of_type_Int = paramContext.getResources().getDimensionPixelSize(2131297481);
  }
  
  private void a(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleBuddySystemMsg! start ");
      ((StringBuilder)localObject1).append(paramSystemMsgItemHolder.jdField_a_of_type_Long);
      QLog.d("SystemMsgItemBuilder", 2, ((StringBuilder)localObject1).toString());
    }
    int j = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
    Object localObject1 = null;
    if (FriendSystemMessage.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true)) {
      localObject1 = KplRoleInfo.WZRYUIinfo.createInfo(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), paramSystemMsgItemHolder.h.getText().toString(), "", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_src_id.get());
    }
    switch (j)
    {
    case 11: 
    default: 
      break;
    case 13: 
      paramSystemMsgItemHolder = new Intent();
      paramSystemMsgItemHolder.putExtra("param_wzry_data", (Serializable)localObject1);
      ((INewFriendApi)QRoute.api(INewFriendApi.class)).openProfileCard(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidContentContext, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get(), j, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get(), paramSystemMsgItemHolder);
      return;
    case 2: 
    case 3: 
      SystemMessageHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_AndroidContentContext, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
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
    Object localObject3 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
    Object localObject2 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject2 = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
    }
    localObject3 = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getAddRequestIntent(this.jdField_a_of_type_AndroidContentContext);
    ((Intent)localObject3).putExtra("infoid", paramSystemMsgItemHolder.jdField_a_of_type_Long);
    ((Intent)localObject3).putExtra("infouin", String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
    ((Intent)localObject3).putExtra("infonick", (String)localObject2);
    ((Intent)localObject3).putExtra("infotime", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_time.get());
    ((Intent)localObject3).putExtra("msg_type", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get());
    ((Intent)localObject3).putExtra("strNickName", (String)localObject2);
    ((Intent)localObject3).putExtra("verify_msg", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
    ((Intent)localObject3).putExtra("msg_source", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get());
    ((Intent)localObject3).putExtra("msg_troopuin", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.group_code.get());
    ((Intent)localObject3).putExtra("system_message_summary", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get());
    ((Intent)localObject3).putExtra("info_dealwith_msg", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_detail.get());
    ((Intent)localObject3).putExtra("msg_title", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_title.get());
    ((Intent)localObject3).putExtra("msg_source_id", this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get());
    if (i > 0) {
      ((Intent)localObject3).putExtra("verify_type", i);
    }
    if (localObject1 != null)
    {
      ((Intent)localObject3).putExtra("param_wzry_data", (Serializable)localObject1);
      ((Intent)localObject3).putExtra("strNickName", ((KplRoleInfo.WZRYUIinfo)localObject1).nick);
      ((Intent)localObject3).putExtra("infonick", ((KplRoleInfo.WZRYUIinfo)localObject1).nick);
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X800843B", "0X800843B", 0, 0, "", "", "", "");
    }
    a((structmsg.StructMsg)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), this.jdField_b_of_type_Long);
    ((Activity)this.jdField_a_of_type_AndroidContentContext).startActivityForResult((Intent)localObject3, 227);
    this.jdField_a_of_type_ComTencentMobileqqNewfriendApiINewFriendService.markSystemMsgReaded();
  }
  
  private void a(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder, int paramInt, View.OnClickListener paramOnClickListener)
  {
    paramSystemMsgItemHolder.jdField_a_of_type_Long = paramInt;
    paramSystemMsgItemHolder.jdField_f_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get());
    structmsg.StructMsg localStructMsg = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg;
    paramSystemMsgItemHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg = localStructMsg;
    a(paramSystemMsgItemHolder, paramInt, String.valueOf(localStructMsg.req_uin.get()));
    a(paramSystemMsgItemHolder, this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    paramSystemMsgItemHolder.jdField_f_of_type_AndroidWidgetImageView.setTag(paramSystemMsgItemHolder);
    paramSystemMsgItemHolder.l.setVisibility(8);
    g(paramSystemMsgItemHolder);
    a(paramSystemMsgItemHolder, paramOnClickListener);
  }
  
  private void a(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder, int paramInt, String paramString)
  {
    Object localObject1 = (IFriendDataService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IFriendDataService.class, "");
    Object localObject2 = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_nick.get();
    Object localObject3 = ((IFriendDataService)localObject1).getFriend(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(((Friends)localObject3).remark)) {
        localObject1 = ((Friends)localObject3).remark;
      }
    }
    if ((FriendSystemMessage.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramString, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true)) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_game_nick.has()))
    {
      localObject2 = new String(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_game_nick.get().toByteArray());
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = KplRoleInfo.WZRYUIinfo.buildNickName((String)localObject1, (String)localObject2);
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = paramString;
    }
    paramSystemMsgItemHolder.h.setText((CharSequence)localObject2);
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_name_more.has()) {
      localObject1 = new String(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.bytes_name_more.get().toByteArray());
    } else {
      localObject1 = null;
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramSystemMsgItemHolder.n.setVisibility(8);
    }
    else
    {
      paramSystemMsgItemHolder.n.setVisibility(0);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("（");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("）");
      localObject1 = ((StringBuilder)localObject3).toString();
      paramSystemMsgItemHolder.n.setText((CharSequence)localObject1);
    }
    if ((!TextUtils.isEmpty(paramString)) && (Utils.b(paramString)))
    {
      paramString = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130841838);
      paramString.setBounds(0, 0, ViewUtils.b(15.0F), ViewUtils.b(15.0F));
      paramSystemMsgItemHolder.h.setCompoundDrawables(null, null, paramString, null);
      paramSystemMsgItemHolder.h.setCompoundDrawablePadding(ViewUtils.b(5.0F));
    }
    else
    {
      paramSystemMsgItemHolder.h.setCompoundDrawables(null, null, null, null);
    }
    if (QLog.isColorLevel())
    {
      paramSystemMsgItemHolder = new StringBuilder();
      paramSystemMsgItemHolder.append("bindBuddySystemMsgView|position is : ");
      paramSystemMsgItemHolder.append(paramInt);
      paramSystemMsgItemHolder.append(",name is : ");
      paramSystemMsgItemHolder.append((String)localObject2);
      paramSystemMsgItemHolder.append(",source is : ");
      paramSystemMsgItemHolder.append(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get());
      QLog.d("SystemMsgItemBuilder", 2, paramSystemMsgItemHolder.toString());
    }
  }
  
  private void a(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg != null)
    {
      f(paramSystemMsgItemHolder);
      int i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("bindBuddySystemMsgView|myAllowFlag : ");
        ((StringBuilder)localObject).append(i);
        QLog.d("SystemMsgItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
      switch (i)
      {
      case 11: 
      default: 
        break;
      case 13: 
        paramSystemMsgItemHolder.k.setVisibility(0);
        localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
        paramSystemMsgItemHolder.k.setText((CharSequence)localObject);
        paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        paramSystemMsgItemHolder.j.setVisibility(8);
        break;
      case 12: 
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.reqsubtype.has()) {
          if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.reqsubtype.get() == 1)
          {
            paramSystemMsgItemHolder.k.setVisibility(0);
            localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
            paramSystemMsgItemHolder.k.setText((CharSequence)localObject);
            paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
          else if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.reqsubtype.get() == 2)
          {
            paramSystemMsgItemHolder.k.setVisibility(8);
            paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          }
        }
        break;
      case 9: 
      case 10: 
        d(paramSystemMsgItemHolder);
        break;
      case 8: 
        paramSystemMsgItemHolder.k.setVisibility(0);
        localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
        paramSystemMsgItemHolder.k.setText((CharSequence)localObject);
        paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        break;
      case 6: 
        e(paramSystemMsgItemHolder);
        break;
      case 4: 
      case 5: 
        paramSystemMsgItemHolder.k.setVisibility(8);
        paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        break;
      case 2: 
      case 3: 
      case 7: 
        paramSystemMsgItemHolder.k.setVisibility(0);
        localObject = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
        paramSystemMsgItemHolder.k.setText((CharSequence)localObject);
        paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        h(paramSystemMsgItemHolder);
        NewFriendNotifyPokeMsgHelper.a(paramSystemMsgItemHolder, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        break;
      case 1: 
        c(paramSystemMsgItemHolder);
      }
      paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setTag(paramSystemMsgItemHolder);
      paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
      paramSystemMsgItemHolder.g.setTag(paramSystemMsgItemHolder);
      paramSystemMsgItemHolder.g.setOnClickListener(paramOnClickListener);
    }
  }
  
  public static void a(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder, SystemMsgListBaseAdapter paramSystemMsgListBaseAdapter, AppInterface paramAppInterface)
  {
    if (paramSystemMsgItemHolder != null)
    {
      if (paramSystemMsgItemHolder.jdField_f_of_type_AndroidWidgetImageView == null) {
        return;
      }
      int k = paramSystemMsgItemHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.src_id.get();
      int j = 0;
      int i;
      if ((k != 3007) && (k != 3019) && (k != 2007) && (k != 4007))
      {
        i = j;
        if (k != 2019) {}
      }
      else if (((IFriendDataService)paramAppInterface.getRuntimeService(IFriendDataService.class, "")).isFriend(String.valueOf(paramSystemMsgItemHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get())))
      {
        i = j;
      }
      else
      {
        i = 1;
      }
      Bitmap localBitmap;
      if (i != 0)
      {
        localBitmap = paramSystemMsgListBaseAdapter.a().getBitmapFromCache(32, String.valueOf(paramSystemMsgItemHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 200);
        paramAppInterface = localBitmap;
        if (localBitmap == null)
        {
          paramAppInterface = localBitmap;
          if (!paramSystemMsgListBaseAdapter.a().isPausing())
          {
            paramSystemMsgListBaseAdapter.a().requestDecodeStrangeFace(String.valueOf(paramSystemMsgItemHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 200, true, true);
            paramAppInterface = localBitmap;
          }
        }
      }
      else
      {
        localBitmap = paramSystemMsgListBaseAdapter.a().getBitmapFromCache(1, String.valueOf(paramSystemMsgItemHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()));
        paramAppInterface = localBitmap;
        if (localBitmap == null)
        {
          paramAppInterface = localBitmap;
          if (!paramSystemMsgListBaseAdapter.a().isPausing())
          {
            paramSystemMsgListBaseAdapter.a().requestDecodeFace(String.valueOf(paramSystemMsgItemHolder.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), 1, true);
            paramAppInterface = localBitmap;
          }
        }
      }
      paramSystemMsgListBaseAdapter = paramAppInterface;
      if (paramAppInterface == null) {
        paramSystemMsgListBaseAdapter = BaseImageUtil.f();
      }
      paramSystemMsgItemHolder.jdField_f_of_type_AndroidWidgetImageView.setImageBitmap(paramSystemMsgListBaseAdapter);
    }
  }
  
  private void a(structmsg.StructMsg paramStructMsg, long paramLong)
  {
    if (paramStructMsg != null)
    {
      long l = ((structmsg.StructMsg)paramStructMsg.get()).msg_seq.get() + ((structmsg.StructMsg)paramStructMsg.get()).msg_type.get();
      ((INewFriendApi)QRoute.api(INewFriendApi.class)).putStructMsgToMap(Long.valueOf(l), (structmsg.StructMsg)paramStructMsg.get());
      ((INewFriendApi)QRoute.api(INewFriendApi.class)).setCurrStructMsgKey(l);
      ((INewFriendApi)QRoute.api(INewFriendApi.class)).setCurrentUniseq(paramLong);
    }
  }
  
  private void b(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder)
  {
    paramSystemMsgItemHolder.jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
    paramSystemMsgItemHolder.h.setVisibility(0);
    paramSystemMsgItemHolder.n.setVisibility(8);
    paramSystemMsgItemHolder.i.setVisibility(0);
    paramSystemMsgItemHolder.l.setVisibility(0);
    paramSystemMsgItemHolder.j.setVisibility(0);
    paramSystemMsgItemHolder.k.setVisibility(8);
    paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
    paramSystemMsgItemHolder.g.setVisibility(8);
  }
  
  private void c(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder)
  {
    String str;
    if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get())))
    {
      paramSystemMsgItemHolder.k.setVisibility(8);
      paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      str = ((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get();
      paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setText(str);
    }
    else if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() == 0))
    {
      paramSystemMsgItemHolder.k.setVisibility(0);
      str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
      paramSystemMsgItemHolder.k.setText(str);
      paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    }
    h(paramSystemMsgItemHolder);
  }
  
  private void d(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder)
  {
    String str;
    if ((this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get() != null) && (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get())))
    {
      paramSystemMsgItemHolder.k.setVisibility(8);
      paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      str = ((structmsg.SystemMsgAction)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.actions.get().get(0)).name.get();
      paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setText(str);
    }
    else
    {
      paramSystemMsgItemHolder.k.setVisibility(0);
      str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_decided.get();
      paramSystemMsgItemHolder.k.setText(str);
      paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
      NewFriendNotifyPokeMsgHelper.a(paramSystemMsgItemHolder, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    }
    h(paramSystemMsgItemHolder);
  }
  
  private void e(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder)
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get()))
    {
      paramSystemMsgItemHolder.j.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_additional.get());
      paramSystemMsgItemHolder.i.setText(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_describe.get());
    }
    else
    {
      paramSystemMsgItemHolder.j.setVisibility(8);
    }
    paramSystemMsgItemHolder.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    paramSystemMsgItemHolder.k.setVisibility(8);
  }
  
  private void f(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder)
  {
    paramSystemMsgItemHolder.i.setText(FriendSystemMessage.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg));
  }
  
  private void g(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder)
  {
    String str;
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.has()) {
      str = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.msg_source.get();
    } else {
      str = null;
    }
    if (!TextUtils.isEmpty(str))
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        str = String.format(Locale.getDefault(), HardCodeUtil.a(2131714506), new Object[] { str, this.jdField_a_of_type_JavaLangString });
      } else {
        str = String.format(Locale.getDefault(), HardCodeUtil.a(2131707525), new Object[] { str });
      }
      paramSystemMsgItemHolder.j.setText(str);
      paramSystemMsgItemHolder.j.setVisibility(0);
      return;
    }
    paramSystemMsgItemHolder.j.setVisibility(8);
  }
  
  private void h(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder)
  {
    int i;
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.has()) {
      i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_gender.get();
    } else {
      i = -1;
    }
    int j;
    if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.has()) {
      j = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.req_uin_age.get();
    } else {
      j = 0;
    }
    ((INewFriendApi)QRoute.api(INewFriendApi.class)).showGenderAge(paramSystemMsgItemHolder.l, i, j, null);
  }
  
  protected int a()
  {
    return ((FriendSystemMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a.mSysmsgMenuFlag;
  }
  
  public View a(int paramInt, View paramView)
  {
    Object localObject;
    View localView;
    if ((paramView != null) && ((paramView.getTag() instanceof SystemMsgItemBuilder.SystemMsgItemHolder)))
    {
      localObject = (SystemMsgItemBuilder.SystemMsgItemHolder)paramView.getTag();
      b((SystemMsgItemBuilder.SystemMsgItemHolder)localObject);
      localView = paramView;
    }
    else
    {
      paramView = new SystemMsgItemBuilder.SystemMsgItemHolder();
      localView = a(this.jdField_a_of_type_AndroidContentContext, 2131561509, paramView);
      a(localView, this.jdField_b_of_type_Int);
      paramView.jdField_f_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131361799));
      paramView.h = ((TextView)localView.findViewById(2131371877));
      paramView.n = ((TextView)localView.findViewById(2131377681));
      paramView.i = ((TextView)localView.findViewById(2131376487));
      paramView.l = ((TextView)localView.findViewById(2131362299));
      paramView.j = ((TextView)localView.findViewById(2131377726));
      paramView.k = ((TextView)localView.findViewById(2131376485));
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131376477));
      paramView.g = ((ImageView)localView.findViewById(2131376480));
      b(paramView.jdField_f_of_type_AndroidWidgetImageView);
      localView.setTag(paramView);
      localObject = paramView;
    }
    ((SystemMsgItemBuilder.SystemMsgItemHolder)localObject).leftView.setTag(localObject);
    ((SystemMsgItemBuilder.SystemMsgItemHolder)localObject).leftView.setOnClickListener(this);
    a(this.jdField_a_of_type_AndroidContentContext, localView, paramInt, this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage, (SwipRightMenuBuilder.SwipItemBaseHolder)localObject, this);
    if (!this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage.a())
    {
      NewFriendUtil.a(((SystemMsgItemBuilder.SystemMsgItemHolder)localObject).leftView, true);
      if (Utils.b(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()))) {
        ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X800826D", "0X800826D", 0, 0, "", "", "", "");
      }
    }
    else
    {
      NewFriendUtil.a(((SystemMsgItemBuilder.SystemMsgItemHolder)localObject).leftView, false);
    }
    a((SystemMsgItemBuilder.SystemMsgItemHolder)localObject, paramInt, this);
    return localView;
  }
  
  protected void a()
  {
    MessageForSystemMsg localMessageForSystemMsg = ((FriendSystemMessage)this.jdField_a_of_type_ComTencentMobileqqNewfriendMsgNewFriendMessage).a;
    this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.a.j();
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).sendDelSingleSystemMsg(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, localMessageForSystemMsg.frienduin, localMessageForSystemMsg.istroop, localMessageForSystemMsg.uniseq, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X8006A74", "0X8006A74", 0, 0, "", "", "", "");
    if (FriendSystemMessage.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true)) {
      ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X800843D", "0X800843D", 0, 0, "", "", "", "");
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject1;
    if (i == 2131376644)
    {
      localObject1 = paramView.getTag();
      if ((localObject1 != null) && ((localObject1 instanceof SystemMsgItemBuilder.SystemMsgItemHolder)))
      {
        localObject1 = (SystemMsgItemBuilder.SystemMsgItemHolder)localObject1;
        if (this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg_type.get() == 1)
        {
          a((SystemMsgItemBuilder.SystemMsgItemHolder)localObject1);
          i = this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.msg.sub_type.get();
          if (i != 1)
          {
            if ((i != 2) && (i != 3))
            {
              if (i != 6)
              {
                if (i == 13) {
                  ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X8007702", "0X8007702", 0, 0, "", "", "", "");
                }
              }
              else {
                ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X8007703", "0X8007703", 0, 0, "", "", "", "");
              }
            }
            else {
              ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X8007701", "0X8007701", 0, 0, "", "", "", "");
            }
          }
          else {
            ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X80076FF", "0X80076FF", 0, 0, "", "", "", "");
          }
        }
      }
    }
    else
    {
      int j = 0;
      if (i == 2131376477)
      {
        localObject1 = paramView.getTag();
        if ((localObject1 != null) && ((localObject1 instanceof SystemMsgItemBuilder.SystemMsgItemHolder))) {
          if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692183), 0).b(c());
          }
          else
          {
            localObject1 = (SystemMsgItemBuilder.SystemMsgItemHolder)localObject1;
            a((structmsg.StructMsg)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), this.jdField_b_of_type_Long);
            long l1 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
            localObject1 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(l1));
            if (localObject1 != null)
            {
              i = ((structmsg.StructMsg)localObject1).msg_type.get();
              l1 = ((structmsg.StructMsg)localObject1).msg_seq.get();
              long l2 = ((structmsg.StructMsg)localObject1).req_uin.get();
              int k = ((structmsg.StructMsg)localObject1).msg.sub_type.get();
              int m = ((structmsg.StructMsg)localObject1).msg.src_id.get();
              int n = ((structmsg.StructMsg)localObject1).msg.sub_src_id.get();
              int i1 = ((structmsg.StructMsg)localObject1).msg.group_msg_type.get();
              Object localObject2 = ((structmsg.StructMsg)localObject1).msg.actions.get();
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
                QLog.d("SystemMsgItemBuilder", 1, ((StringBuilder)localObject1).toString());
                i = j;
              }
            }
            else
            {
              QLog.d("SystemMsgItemBuilder", 1, "agree");
              i = j;
            }
            if (i != 0) {
              this.jdField_a_of_type_ComTencentMobileqqNewfriendUiAdapterSystemMsgListBaseAdapter.a.a.d();
            }
            ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "1", "", "", "");
            ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X8007700", "0X8007700", 0, 0, "", "", "", "");
            if (Utils.b(String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()))) {
              ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X800826E", "0X800826E", 0, 0, "", "", "", "");
            }
            if (FriendSystemMessage.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, String.valueOf(this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.req_uin.get()), this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, true)) {
              ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "CliOper", "", "", "0X800843C", "0X800843C", 0, 0, "", "", "", "");
            }
          }
        }
      }
      else if (i == 2131376480)
      {
        if ((paramView.getTag() != null) && ((paramView.getTag() instanceof SystemMsgItemBuilder.SystemMsgItemHolder)))
        {
          localObject1 = (SystemMsgItemBuilder.SystemMsgItemHolder)paramView.getTag();
          if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_AndroidContentContext))
          {
            QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131692183), 0).b(c());
          }
          else
          {
            a((structmsg.StructMsg)this.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg.get(), this.jdField_b_of_type_Long);
            NewFriendNotifyPokeMsgHelper.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentCommonAppAppInterface, localObject1);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.SystemMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */