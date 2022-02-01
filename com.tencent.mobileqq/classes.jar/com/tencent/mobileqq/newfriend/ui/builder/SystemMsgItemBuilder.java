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
  public long a = 0L;
  private structmsg.StructMsg b;
  private long i;
  private INewFriendService j;
  private String k;
  
  public SystemMsgItemBuilder(Context paramContext, AppInterface paramAppInterface, SystemMsgListAdapter paramSystemMsgListAdapter, NewFriendMessage paramNewFriendMessage)
  {
    super(paramContext, paramAppInterface, paramSystemMsgListAdapter, paramNewFriendMessage);
    paramSystemMsgListAdapter = (FriendSystemMessage)paramNewFriendMessage;
    this.b = paramSystemMsgListAdapter.a.getSystemMsg();
    this.i = paramSystemMsgListAdapter.a.uniseq;
    this.f = a(paramContext);
    this.j = ((INewFriendService)paramAppInterface.getRuntimeService(INewFriendService.class, ""));
    int m;
    if (this.b.msg.uint32_source_flag.has()) {
      m = this.b.msg.uint32_source_flag.get();
    } else {
      m = 0;
    }
    paramSystemMsgListAdapter = null;
    if ((m & 0x8) == 8)
    {
      if (this.b.msg.uint64_discuss_uin.has()) {
        this.a = this.b.msg.uint64_discuss_uin.get();
      }
      if (this.b.msg.msg_source.has()) {
        paramSystemMsgListAdapter = this.b.msg.msg_source.get();
      }
      if (this.a != 0L)
      {
        this.k = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getDiscussionNameCanNull(paramAppInterface, String.valueOf(this.a));
        if (TextUtils.isEmpty(this.k))
        {
          ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getDiscussInfo(this.a, paramAppInterface);
          if (QLog.isColorLevel()) {
            QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "SystemMsgItemBuilder need get discuss info %d", new Object[] { Long.valueOf(this.a) }));
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("addFriendTag", 2, String.format(Locale.getDefault(), "SystemMsgItemBuilder source_flag: %d  discussUin: %d mDiscussName: %s msg_source: %s", new Object[] { Integer.valueOf(m), Long.valueOf(this.a), this.k, paramSystemMsgListAdapter }));
      }
    }
    else
    {
      this.k = null;
      this.a = 0L;
    }
    this.h = paramContext.getResources().getDimensionPixelSize(2131298132);
  }
  
  private void a(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder)
  {
    boolean bool = QLog.isColorLevel();
    int m = 2;
    if (bool)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("handleBuddySystemMsg! start ");
      ((StringBuilder)localObject1).append(paramSystemMsgItemHolder.a);
      QLog.d("SystemMsgItemBuilder", 2, ((StringBuilder)localObject1).toString());
    }
    int n = this.b.msg.sub_type.get();
    Object localObject1 = null;
    if (FriendSystemMessage.a(this.d, String.valueOf(this.b.req_uin.get()), this.b, true)) {
      localObject1 = KplRoleInfo.WZRYUIinfo.createInfo(String.valueOf(this.b.req_uin.get()), paramSystemMsgItemHolder.x.getText().toString(), "", this.b.msg.src_id.get(), this.b.msg.sub_src_id.get());
    }
    switch (n)
    {
    case 11: 
    default: 
      break;
    case 13: 
      paramSystemMsgItemHolder = new Intent();
      paramSystemMsgItemHolder.putExtra("param_wzry_data", (Serializable)localObject1);
      ((INewFriendApi)QRoute.api(INewFriendApi.class)).openProfileCard(this.d, this.c, String.valueOf(this.b.req_uin.get()), this.b.msg.group_code.get(), n, this.b.msg.src_id.get(), paramSystemMsgItemHolder);
      return;
    case 2: 
    case 3: 
      SystemMessageHelper.a(this.d, this.c, String.valueOf(this.b.req_uin.get()));
      return;
    case 1: 
      m = 1;
      break;
    case 0: 
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    case 12: 
      m = 0;
    }
    Object localObject3 = this.b.msg.req_uin_nick.get();
    Object localObject2 = localObject3;
    if (TextUtils.isEmpty((CharSequence)localObject3)) {
      localObject2 = String.valueOf(this.b.req_uin.get());
    }
    localObject3 = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getAddRequestIntent(this.c);
    ((Intent)localObject3).putExtra("infoid", paramSystemMsgItemHolder.a);
    ((Intent)localObject3).putExtra("infouin", String.valueOf(this.b.req_uin.get()));
    ((Intent)localObject3).putExtra("infonick", (String)localObject2);
    ((Intent)localObject3).putExtra("infotime", this.b.msg_time.get());
    ((Intent)localObject3).putExtra("msg_type", this.b.msg.sub_type.get());
    ((Intent)localObject3).putExtra("strNickName", (String)localObject2);
    ((Intent)localObject3).putExtra("verify_msg", this.b.msg.msg_additional.get());
    ((Intent)localObject3).putExtra("msg_source", this.b.msg.msg_source.get());
    ((Intent)localObject3).putExtra("msg_troopuin", this.b.msg.group_code.get());
    ((Intent)localObject3).putExtra("system_message_summary", this.b.msg.msg_decided.get());
    ((Intent)localObject3).putExtra("info_dealwith_msg", this.b.msg.msg_detail.get());
    ((Intent)localObject3).putExtra("msg_title", this.b.msg.msg_title.get());
    ((Intent)localObject3).putExtra("msg_source_id", this.b.msg.src_id.get());
    if (m > 0) {
      ((Intent)localObject3).putExtra("verify_type", m);
    }
    if (localObject1 != null)
    {
      ((Intent)localObject3).putExtra("param_wzry_data", (Serializable)localObject1);
      ((Intent)localObject3).putExtra("strNickName", ((KplRoleInfo.WZRYUIinfo)localObject1).nick);
      ((Intent)localObject3).putExtra("infonick", ((KplRoleInfo.WZRYUIinfo)localObject1).nick);
      ReportController.b(this.d, "CliOper", "", "", "0X800843B", "0X800843B", 0, 0, "", "", "", "");
    }
    a((structmsg.StructMsg)this.b.get(), this.i);
    ((Activity)this.c).startActivityForResult((Intent)localObject3, 227);
    this.j.markSystemMsgReaded();
  }
  
  private void a(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder, int paramInt, View.OnClickListener paramOnClickListener)
  {
    paramSystemMsgItemHolder.a = paramInt;
    paramSystemMsgItemHolder.D = String.valueOf(this.b.req_uin.get());
    structmsg.StructMsg localStructMsg = this.b;
    paramSystemMsgItemHolder.b = localStructMsg;
    a(paramSystemMsgItemHolder, paramInt, String.valueOf(localStructMsg.req_uin.get()));
    a(paramSystemMsgItemHolder, this.e, this.d);
    paramSystemMsgItemHolder.w.setTag(paramSystemMsgItemHolder);
    paramSystemMsgItemHolder.C.setVisibility(8);
    g(paramSystemMsgItemHolder);
    a(paramSystemMsgItemHolder, paramOnClickListener);
  }
  
  private void a(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder, int paramInt, String paramString)
  {
    Object localObject1 = (IFriendDataService)this.d.getRuntimeService(IFriendDataService.class, "");
    Object localObject2 = this.b.msg.req_uin_nick.get();
    Object localObject3 = ((IFriendDataService)localObject1).getFriend(String.valueOf(this.b.req_uin.get()));
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(((Friends)localObject3).remark)) {
        localObject1 = ((Friends)localObject3).remark;
      }
    }
    if ((FriendSystemMessage.a(this.d, paramString, this.b, true)) && (this.b.msg.bytes_game_nick.has()))
    {
      localObject2 = new String(this.b.msg.bytes_game_nick.get().toByteArray());
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = KplRoleInfo.WZRYUIinfo.buildNickName((String)localObject1, (String)localObject2);
      }
    }
    localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = paramString;
    }
    paramSystemMsgItemHolder.x.setText((CharSequence)localObject2);
    if (this.b.msg.bytes_name_more.has()) {
      localObject1 = new String(this.b.msg.bytes_name_more.get().toByteArray());
    } else {
      localObject1 = null;
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      paramSystemMsgItemHolder.H.setVisibility(8);
    }
    else
    {
      paramSystemMsgItemHolder.H.setVisibility(0);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("（");
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append("）");
      localObject1 = ((StringBuilder)localObject3).toString();
      paramSystemMsgItemHolder.H.setText((CharSequence)localObject1);
    }
    if ((!TextUtils.isEmpty(paramString)) && (Utils.c(paramString)))
    {
      paramString = this.c.getResources().getDrawable(2130842755);
      paramString.setBounds(0, 0, ViewUtils.dpToPx(15.0F), ViewUtils.dpToPx(15.0F));
      paramSystemMsgItemHolder.x.setCompoundDrawables(null, null, paramString, null);
      paramSystemMsgItemHolder.x.setCompoundDrawablePadding(ViewUtils.dpToPx(5.0F));
    }
    else
    {
      paramSystemMsgItemHolder.x.setCompoundDrawables(null, null, null, null);
    }
    if (QLog.isColorLevel())
    {
      paramSystemMsgItemHolder = new StringBuilder();
      paramSystemMsgItemHolder.append("bindBuddySystemMsgView|position is : ");
      paramSystemMsgItemHolder.append(paramInt);
      paramSystemMsgItemHolder.append(",name is : ");
      paramSystemMsgItemHolder.append((String)localObject2);
      paramSystemMsgItemHolder.append(",source is : ");
      paramSystemMsgItemHolder.append(this.b.msg.msg_source.get());
      QLog.d("SystemMsgItemBuilder", 2, paramSystemMsgItemHolder.toString());
    }
  }
  
  private void a(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder, View.OnClickListener paramOnClickListener)
  {
    if (this.b.msg != null)
    {
      f(paramSystemMsgItemHolder);
      int m = this.b.msg.sub_type.get();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("bindBuddySystemMsgView|myAllowFlag : ");
        ((StringBuilder)localObject).append(m);
        QLog.d("SystemMsgItemBuilder", 2, ((StringBuilder)localObject).toString());
      }
      switch (m)
      {
      case 11: 
      default: 
        break;
      case 13: 
        paramSystemMsgItemHolder.B.setVisibility(0);
        localObject = this.b.msg.msg_decided.get();
        paramSystemMsgItemHolder.B.setText((CharSequence)localObject);
        paramSystemMsgItemHolder.A.setVisibility(8);
        paramSystemMsgItemHolder.z.setVisibility(8);
        break;
      case 12: 
        if (this.b.msg.reqsubtype.has()) {
          if (this.b.msg.reqsubtype.get() == 1)
          {
            paramSystemMsgItemHolder.B.setVisibility(0);
            localObject = this.b.msg.msg_decided.get();
            paramSystemMsgItemHolder.B.setText((CharSequence)localObject);
            paramSystemMsgItemHolder.A.setVisibility(8);
          }
          else if (this.b.msg.reqsubtype.get() == 2)
          {
            paramSystemMsgItemHolder.B.setVisibility(8);
            paramSystemMsgItemHolder.A.setVisibility(8);
          }
        }
        break;
      case 9: 
      case 10: 
        d(paramSystemMsgItemHolder);
        break;
      case 8: 
        paramSystemMsgItemHolder.B.setVisibility(0);
        localObject = this.b.msg.msg_decided.get();
        paramSystemMsgItemHolder.B.setText((CharSequence)localObject);
        paramSystemMsgItemHolder.A.setVisibility(8);
        break;
      case 6: 
        e(paramSystemMsgItemHolder);
        break;
      case 4: 
      case 5: 
        paramSystemMsgItemHolder.B.setVisibility(8);
        paramSystemMsgItemHolder.A.setVisibility(8);
        break;
      case 2: 
      case 3: 
      case 7: 
        paramSystemMsgItemHolder.B.setVisibility(0);
        localObject = this.b.msg.msg_decided.get();
        paramSystemMsgItemHolder.B.setText((CharSequence)localObject);
        paramSystemMsgItemHolder.A.setVisibility(8);
        h(paramSystemMsgItemHolder);
        NewFriendNotifyPokeMsgHelper.a(paramSystemMsgItemHolder, this.d);
        break;
      case 1: 
        c(paramSystemMsgItemHolder);
      }
      paramSystemMsgItemHolder.A.setTag(paramSystemMsgItemHolder);
      paramSystemMsgItemHolder.A.setOnClickListener(paramOnClickListener);
      paramSystemMsgItemHolder.E.setTag(paramSystemMsgItemHolder);
      paramSystemMsgItemHolder.E.setOnClickListener(paramOnClickListener);
    }
  }
  
  public static void a(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder, SystemMsgListBaseAdapter paramSystemMsgListBaseAdapter, AppInterface paramAppInterface)
  {
    if (paramSystemMsgItemHolder != null)
    {
      if (paramSystemMsgItemHolder.w == null) {
        return;
      }
      int i1 = paramSystemMsgItemHolder.b.msg.src_id.get();
      int n = 0;
      int m;
      if ((i1 != 3007) && (i1 != 3019) && (i1 != 2007) && (i1 != 4007))
      {
        m = n;
        if (i1 != 2019) {}
      }
      else if (((IFriendDataService)paramAppInterface.getRuntimeService(IFriendDataService.class, "")).isFriend(String.valueOf(paramSystemMsgItemHolder.b.req_uin.get())))
      {
        m = n;
      }
      else
      {
        m = 1;
      }
      Bitmap localBitmap;
      if (m != 0)
      {
        localBitmap = paramSystemMsgListBaseAdapter.d().getBitmapFromCache(32, String.valueOf(paramSystemMsgItemHolder.b.req_uin.get()), 200);
        paramAppInterface = localBitmap;
        if (localBitmap == null)
        {
          paramAppInterface = localBitmap;
          if (!paramSystemMsgListBaseAdapter.d().isPausing())
          {
            paramSystemMsgListBaseAdapter.d().requestDecodeStrangeFace(String.valueOf(paramSystemMsgItemHolder.b.req_uin.get()), 200, true, true);
            paramAppInterface = localBitmap;
          }
        }
      }
      else
      {
        localBitmap = paramSystemMsgListBaseAdapter.d().getBitmapFromCache(1, String.valueOf(paramSystemMsgItemHolder.b.req_uin.get()));
        paramAppInterface = localBitmap;
        if (localBitmap == null)
        {
          paramAppInterface = localBitmap;
          if (!paramSystemMsgListBaseAdapter.d().isPausing())
          {
            paramSystemMsgListBaseAdapter.d().requestDecodeFace(String.valueOf(paramSystemMsgItemHolder.b.req_uin.get()), 1, true);
            paramAppInterface = localBitmap;
          }
        }
      }
      paramSystemMsgListBaseAdapter = paramAppInterface;
      if (paramAppInterface == null) {
        paramSystemMsgListBaseAdapter = BaseImageUtil.k();
      }
      paramSystemMsgItemHolder.w.setImageBitmap(paramSystemMsgListBaseAdapter);
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
    paramSystemMsgItemHolder.w.setVisibility(0);
    paramSystemMsgItemHolder.x.setVisibility(0);
    paramSystemMsgItemHolder.H.setVisibility(8);
    paramSystemMsgItemHolder.y.setVisibility(0);
    paramSystemMsgItemHolder.C.setVisibility(0);
    paramSystemMsgItemHolder.z.setVisibility(0);
    paramSystemMsgItemHolder.B.setVisibility(8);
    paramSystemMsgItemHolder.A.setVisibility(0);
    paramSystemMsgItemHolder.E.setVisibility(8);
  }
  
  private void c(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder)
  {
    String str;
    if ((this.b.msg.actions.get() != null) && (this.b.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)this.b.msg.actions.get().get(0)).name.get())))
    {
      paramSystemMsgItemHolder.B.setVisibility(8);
      paramSystemMsgItemHolder.A.setVisibility(0);
      str = ((structmsg.SystemMsgAction)this.b.msg.actions.get().get(0)).name.get();
      paramSystemMsgItemHolder.A.setText(str);
    }
    else if ((this.b.msg.actions.get() != null) && (this.b.msg.actions.get().size() == 0))
    {
      paramSystemMsgItemHolder.B.setVisibility(0);
      str = this.b.msg.msg_decided.get();
      paramSystemMsgItemHolder.B.setText(str);
      paramSystemMsgItemHolder.A.setVisibility(8);
    }
    h(paramSystemMsgItemHolder);
  }
  
  private void d(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder)
  {
    String str;
    if ((this.b.msg.actions.get() != null) && (this.b.msg.actions.get().size() > 0) && (!TextUtils.isEmpty(((structmsg.SystemMsgAction)this.b.msg.actions.get().get(0)).name.get())))
    {
      paramSystemMsgItemHolder.B.setVisibility(8);
      paramSystemMsgItemHolder.A.setVisibility(0);
      str = ((structmsg.SystemMsgAction)this.b.msg.actions.get().get(0)).name.get();
      paramSystemMsgItemHolder.A.setText(str);
    }
    else
    {
      paramSystemMsgItemHolder.B.setVisibility(0);
      str = this.b.msg.msg_decided.get();
      paramSystemMsgItemHolder.B.setText(str);
      paramSystemMsgItemHolder.A.setVisibility(8);
      NewFriendNotifyPokeMsgHelper.a(paramSystemMsgItemHolder, this.d);
    }
    h(paramSystemMsgItemHolder);
  }
  
  private void e(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder)
  {
    if (!TextUtils.isEmpty(this.b.msg.msg_additional.get()))
    {
      paramSystemMsgItemHolder.z.setText(this.b.msg.msg_additional.get());
      paramSystemMsgItemHolder.y.setText(this.b.msg.msg_describe.get());
    }
    else
    {
      paramSystemMsgItemHolder.z.setVisibility(8);
    }
    paramSystemMsgItemHolder.A.setVisibility(8);
    paramSystemMsgItemHolder.B.setVisibility(8);
  }
  
  private void f(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder)
  {
    paramSystemMsgItemHolder.y.setText(FriendSystemMessage.a(this.c, this.b));
  }
  
  private void g(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder)
  {
    String str;
    if (this.b.msg.msg_source.has()) {
      str = this.b.msg.msg_source.get();
    } else {
      str = null;
    }
    if (!TextUtils.isEmpty(str))
    {
      if (!TextUtils.isEmpty(this.k)) {
        str = String.format(Locale.getDefault(), HardCodeUtil.a(2131912015), new Object[] { str, this.k });
      } else {
        str = String.format(Locale.getDefault(), HardCodeUtil.a(2131905340), new Object[] { str });
      }
      paramSystemMsgItemHolder.z.setText(str);
      paramSystemMsgItemHolder.z.setVisibility(0);
      return;
    }
    paramSystemMsgItemHolder.z.setVisibility(8);
  }
  
  private void h(SystemMsgItemBuilder.SystemMsgItemHolder paramSystemMsgItemHolder)
  {
    int m;
    if (this.b.msg.req_uin_gender.has()) {
      m = this.b.msg.req_uin_gender.get();
    } else {
      m = -1;
    }
    int n;
    if (this.b.msg.req_uin_age.has()) {
      n = this.b.msg.req_uin_age.get();
    } else {
      n = 0;
    }
    ((INewFriendApi)QRoute.api(INewFriendApi.class)).showGenderAge(paramSystemMsgItemHolder.C, m, n, null);
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
      localView = a(this.c, 2131627870, paramView);
      a(localView, this.h);
      paramView.w = ((ImageView)localView.findViewById(2131427337));
      paramView.x = ((TextView)localView.findViewById(2131439320));
      paramView.H = ((TextView)localView.findViewById(2131446106));
      paramView.y = ((TextView)localView.findViewById(2131444728));
      paramView.C = ((TextView)localView.findViewById(2131427898));
      paramView.z = ((TextView)localView.findViewById(2131446184));
      paramView.B = ((TextView)localView.findViewById(2131444726));
      paramView.A = ((Button)localView.findViewById(2131444718));
      paramView.E = ((ImageView)localView.findViewById(2131444721));
      b(paramView.w);
      localView.setTag(paramView);
      localObject = paramView;
    }
    ((SystemMsgItemBuilder.SystemMsgItemHolder)localObject).leftView.setTag(localObject);
    ((SystemMsgItemBuilder.SystemMsgItemHolder)localObject).leftView.setOnClickListener(this);
    a(this.c, localView, paramInt, this.g, (SwipRightMenuBuilder.SwipItemBaseHolder)localObject, this);
    if (!this.g.b())
    {
      NewFriendUtil.a(((SystemMsgItemBuilder.SystemMsgItemHolder)localObject).leftView, true);
      if (Utils.c(String.valueOf(this.b.req_uin.get()))) {
        ReportController.b(this.d, "dc00898", "", "", "0X800826D", "0X800826D", 0, 0, "", "", "", "");
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
    MessageForSystemMsg localMessageForSystemMsg = ((FriendSystemMessage)this.g).a;
    this.e.e.k();
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).sendDelSingleSystemMsg(this.b, localMessageForSystemMsg.frienduin, localMessageForSystemMsg.istroop, localMessageForSystemMsg.uniseq, this.d);
    ReportController.b(this.d, "CliOper", "", "", "0X8006A74", "0X8006A74", 0, 0, "", "", "", "");
    if (FriendSystemMessage.a(this.d, String.valueOf(this.b.req_uin.get()), this.b, true)) {
      ReportController.b(this.d, "CliOper", "", "", "0X800843D", "0X800843D", 0, 0, "", "", "", "");
    }
  }
  
  protected int b()
  {
    return ((FriendSystemMessage)this.g).a.mSysmsgMenuFlag;
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    Object localObject1;
    if (m == 2131444905)
    {
      localObject1 = paramView.getTag();
      if ((localObject1 != null) && ((localObject1 instanceof SystemMsgItemBuilder.SystemMsgItemHolder)))
      {
        localObject1 = (SystemMsgItemBuilder.SystemMsgItemHolder)localObject1;
        if (this.b.msg_type.get() == 1)
        {
          a((SystemMsgItemBuilder.SystemMsgItemHolder)localObject1);
          m = this.b.msg.sub_type.get();
          if (m != 1)
          {
            if ((m != 2) && (m != 3))
            {
              if (m != 6)
              {
                if (m == 13) {
                  ReportController.b(this.d, "dc00898", "", "", "0X8007702", "0X8007702", 0, 0, "", "", "", "");
                }
              }
              else {
                ReportController.b(this.d, "dc00898", "", "", "0X8007703", "0X8007703", 0, 0, "", "", "", "");
              }
            }
            else {
              ReportController.b(this.d, "dc00898", "", "", "0X8007701", "0X8007701", 0, 0, "", "", "", "");
            }
          }
          else {
            ReportController.b(this.d, "dc00898", "", "", "0X80076FF", "0X80076FF", 0, 0, "", "", "", "");
          }
        }
      }
    }
    else
    {
      int n = 0;
      if (m == 2131444718)
      {
        localObject1 = paramView.getTag();
        if ((localObject1 != null) && ((localObject1 instanceof SystemMsgItemBuilder.SystemMsgItemHolder))) {
          if (!NetworkUtil.isNetworkAvailable(this.c))
          {
            QQToast.makeText(this.c, this.c.getResources().getString(2131889169), 0).show(i());
          }
          else
          {
            localObject1 = (SystemMsgItemBuilder.SystemMsgItemHolder)localObject1;
            a((structmsg.StructMsg)this.b.get(), this.i);
            long l1 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
            localObject1 = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(l1));
            if (localObject1 != null)
            {
              m = ((structmsg.StructMsg)localObject1).msg_type.get();
              l1 = ((structmsg.StructMsg)localObject1).msg_seq.get();
              long l2 = ((structmsg.StructMsg)localObject1).req_uin.get();
              int i1 = ((structmsg.StructMsg)localObject1).msg.sub_type.get();
              int i2 = ((structmsg.StructMsg)localObject1).msg.src_id.get();
              int i3 = ((structmsg.StructMsg)localObject1).msg.sub_src_id.get();
              int i4 = ((structmsg.StructMsg)localObject1).msg.group_msg_type.get();
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
                ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).sendFriendSystemMsgAction(m, l1, l2, i1, i2, i3, i4, (structmsg.SystemMsgActionInfo)localObject2, 0, (structmsg.StructMsg)localObject1, false, this.d);
                m = 1;
              }
              else
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("agree, ");
                if (localObject2 != null) {
                  m = ((List)localObject2).size();
                } else {
                  m = -1;
                }
                ((StringBuilder)localObject1).append(m);
                QLog.d("SystemMsgItemBuilder", 1, ((StringBuilder)localObject1).toString());
                m = n;
              }
            }
            else
            {
              QLog.d("SystemMsgItemBuilder", 1, "agree");
              m = n;
            }
            if (m != 0) {
              this.e.e.a.f();
            }
            ReportController.b(this.d, "CliOper", "", "", "frd_recommend", "Frd_accept", 0, 0, "1", "", "", "");
            ReportController.b(this.d, "dc00898", "", "", "0X8007700", "0X8007700", 0, 0, "", "", "", "");
            if (Utils.c(String.valueOf(this.b.req_uin.get()))) {
              ReportController.b(this.d, "dc00898", "", "", "0X800826E", "0X800826E", 0, 0, "", "", "", "");
            }
            if (FriendSystemMessage.a(this.d, String.valueOf(this.b.req_uin.get()), this.b, true)) {
              ReportController.b(this.d, "CliOper", "", "", "0X800843C", "0X800843C", 0, 0, "", "", "", "");
            }
          }
        }
      }
      else if (m == 2131444721)
      {
        if ((paramView.getTag() != null) && ((paramView.getTag() instanceof SystemMsgItemBuilder.SystemMsgItemHolder)))
        {
          localObject1 = (SystemMsgItemBuilder.SystemMsgItemHolder)paramView.getTag();
          if (!NetworkUtil.isNetworkAvailable(this.c))
          {
            QQToast.makeText(this.c, this.c.getResources().getString(2131889169), 0).show(i());
          }
          else
          {
            a((structmsg.StructMsg)this.b.get(), this.i);
            NewFriendNotifyPokeMsgHelper.a(this.c, this.d, localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.ui.builder.SystemMsgItemBuilder
 * JD-Core Version:    0.7.0.1
 */