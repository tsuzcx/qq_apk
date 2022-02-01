package com.tencent.mobileqq.newfriend.poke;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Property;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.handler.NewFriendNotifyPokeHandler;
import com.tencent.mobileqq.newfriend.ui.builder.SystemMsgItemBuilder.SystemMsgItemHolder;
import com.tencent.mobileqq.newfriend.ui.holder.MoreSysMsgHolder;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IAddFriendTempApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import tencent.im.s2c.frdsysmsg.FrdSysMsg.AddtionInfo;
import tencent.mobileim.structmsg.structmsg.StructMsg;
import tencent.mobileim.structmsg.structmsg.SystemMsg;

public class NewFriendNotifyPokeMsgHelper
{
  public static ArrayList<Long> a = new ArrayList();
  public static ArrayList<Long> b = new ArrayList();
  public static ArrayList<Long> c = new ArrayList();
  public static ArrayList<Long> d = new ArrayList();
  
  public static long a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NewFriendNotifyPokeMsgHelper", 2, "getPokeExpiredTime() isDebugVersion = false");
    }
    return 604800L;
  }
  
  public static String a(structmsg.StructMsg paramStructMsg)
  {
    int i;
    if (paramStructMsg != null) {
      i = paramStructMsg.msg.req_uin_gender.get();
    } else {
      i = 0;
    }
    if (i == 1) {
      return MobileQQ.getContext().getResources().getString(2131719044);
    }
    return MobileQQ.getContext().getResources().getString(2131693128);
  }
  
  public static void a()
  {
    a.clear();
    b.clear();
  }
  
  public static void a(Context paramContext, AppInterface paramAppInterface, Object paramObject)
  {
    long l = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getCurrStructMsgKey();
    structmsg.StructMsg localStructMsg = ((INewFriendApi)QRoute.api(INewFriendApi.class)).getStructMsgFromMap(Long.valueOf(l));
    if (localStructMsg != null)
    {
      l = localStructMsg.req_uin.get();
      if (a(localStructMsg))
      {
        if ((paramObject instanceof MoreSysMsgHolder)) {
          ReportController.b(null, "dc00898", "", "", "0X800B759", "0X800B759", 0, 0, String.valueOf(2), "", "", "");
        } else {
          ReportController.b(null, "dc00898", "", "", "0X800B759", "0X800B759", 0, 0, String.valueOf(1), "", "", "");
        }
        a(localStructMsg, ((INewFriendApi)QRoute.api(INewFriendApi.class)).getCurrentUniseq(), paramAppInterface);
        b(paramObject, paramAppInterface);
        a(paramAppInterface, paramContext, String.valueOf(l));
        a(paramAppInterface, String.valueOf(l));
        return;
      }
      if ((paramObject instanceof MoreSysMsgHolder)) {
        ReportController.b(null, "dc00898", "", "", "0X800B75B", "0X800B75B", 0, 0, String.valueOf(2), "", "", "");
      } else {
        ReportController.b(null, "dc00898", "", "", "0X800B75B", "0X800B75B", 0, 0, String.valueOf(1), "", "", "");
      }
      a(paramContext, String.valueOf(l), localStructMsg.msg.action_uin_nick.get());
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    Intent localIntent = ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).getChatActivityIntent(paramContext);
    localIntent.putExtra("uin", String.valueOf(paramString1));
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("uintype", 0);
    localIntent.putExtras(new Bundle());
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, NewFriendNotifyPokeMsgHelper.LottieDrawableLoadedListener paramLottieDrawableLoadedListener)
  {
    try
    {
      LottieComposition.Factory.fromAssetFileName(paramContext, paramString1, new NewFriendNotifyPokeMsgHelper.3(paramInt1, paramInt2, paramInt3, paramContext, paramString2, paramLottieDrawableLoadedListener));
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("NewFriendNotifyPokeMsgHelper", 1, "fromAssetFileName fail", paramContext);
      ThreadManager.getUIHandler().post(new NewFriendNotifyPokeMsgHelper.4(paramLottieDrawableLoadedListener));
    }
  }
  
  private static void a(View paramView)
  {
    paramView.setPivotX(paramView.getWidth() * 0.5F);
    paramView.setPivotY(paramView.getHeight() * 1.0F);
    Property localProperty = View.ROTATION;
    float f1 = -10;
    float f2 = 10;
    paramView = ObjectAnimator.ofFloat(paramView, localProperty, new float[] { 0.0F, f1, 0.0F, f2, 0.0F, f1, 0.0F, f2, 0.0F });
    paramView.setDuration(720L);
    paramView.setRepeatCount(1);
    paramView.start();
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, String paramString)
  {
    ((IAddFriendTempApi)QRoute.api(IAddFriendTempApi.class)).sendPokeMsg(paramAppInterface, paramContext, paramString);
  }
  
  public static void a(AppInterface paramAppInterface, String paramString)
  {
    ((NewFriendNotifyPokeHandler)paramAppInterface.getBusinessHandler(NewFriendNotifyPokeHandler.class.getName())).a(paramString);
  }
  
  public static void a(AppInterface paramAppInterface, structmsg.StructMsg paramStructMsg, View paramView1, View paramView2, ImageView paramImageView, TextView paramTextView, int paramInt)
  {
    if (a(paramStructMsg, paramAppInterface))
    {
      boolean bool = a(paramStructMsg);
      paramView1.setVisibility(8);
      paramView2.setVisibility(8);
      paramImageView.setVisibility(0);
      int i;
      if (bool) {
        i = 2130846346;
      } else {
        i = 2130846345;
      }
      paramImageView.setImageResource(i);
      if (a(paramStructMsg)) {
        paramAppInterface = paramTextView.getContext().getString(2131699382);
      } else {
        paramAppInterface = paramTextView.getContext().getString(2131699381);
      }
      paramImageView.setContentDescription(paramAppInterface);
      paramTextView.setVisibility(0);
      paramAppInterface = a(paramStructMsg);
      if (a(paramStructMsg)) {
        paramAppInterface = paramTextView.getContext().getString(2131699386, new Object[] { paramAppInterface });
      } else {
        paramAppInterface = paramTextView.getContext().getString(2131699385, new Object[] { paramAppInterface, paramAppInterface });
      }
      paramTextView.setText(paramAppInterface);
      a(paramStructMsg, bool, paramInt);
    }
  }
  
  public static void a(Object paramObject, AppInterface paramAppInterface)
  {
    if (paramObject == null)
    {
      QLog.d("NewFriendNotifyPokeMsgHelper", 1, "showPockAndMsg () holder is null");
      return;
    }
    if ((paramObject instanceof MoreSysMsgHolder))
    {
      paramObject = (MoreSysMsgHolder)paramObject;
      a(paramAppInterface, paramObject.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, paramObject.e, paramObject.jdField_a_of_type_AndroidWidgetButton, paramObject.b, paramObject.d, 2);
      return;
    }
    if ((paramObject instanceof SystemMsgItemBuilder.SystemMsgItemHolder))
    {
      paramObject = (SystemMsgItemBuilder.SystemMsgItemHolder)paramObject;
      a(paramAppInterface, paramObject.jdField_a_of_type_TencentMobileimStructmsgStructmsg$StructMsg, paramObject.k, paramObject.jdField_a_of_type_AndroidWidgetButton, paramObject.g, paramObject.j, 1);
    }
  }
  
  public static void a(structmsg.StructMsg paramStructMsg, long paramLong, AppInterface paramAppInterface)
  {
    FrdSysMsg.AddtionInfo localAddtionInfo = new FrdSysMsg.AddtionInfo();
    localAddtionInfo.uint32_poke.set(0);
    localAddtionInfo.uint32_format.set(1);
    paramStructMsg.msg.bytes_addtion.set(ByteStringMicro.copyFrom(localAddtionInfo.toByteArray()));
    ThreadManager.executeOnSubThread(new NewFriendNotifyPokeMsgHelper.1(paramLong, paramStructMsg, paramAppInterface));
  }
  
  public static void a(structmsg.StructMsg paramStructMsg, boolean paramBoolean, int paramInt)
  {
    if (paramStructMsg == null) {
      return;
    }
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        QLog.e("NewFriendNotifyPokeMsgHelper", 1, "reportExposure error: no this display scenes");
        return;
      }
      if (paramBoolean)
      {
        if (!c.contains(Long.valueOf(paramStructMsg.msg_seq.get())))
        {
          ReportController.b(null, "dc00898", "", "", "0X800B758", "0X800B758", 0, 0, String.valueOf(2), "", "", "");
          c.add(Long.valueOf(paramStructMsg.msg_seq.get()));
        }
      }
      else if (!d.contains(Long.valueOf(paramStructMsg.msg_seq.get())))
      {
        ReportController.b(null, "dc00898", "", "", "0X800B75A", "0X800B75A", 0, 0, String.valueOf(2), "", "", "");
        d.add(Long.valueOf(paramStructMsg.msg_seq.get()));
      }
    }
    else if (paramBoolean)
    {
      if (!a.contains(Long.valueOf(paramStructMsg.msg_seq.get())))
      {
        ReportController.b(null, "dc00898", "", "", "0X800B758", "0X800B758", 0, 0, String.valueOf(1), "", "", "");
        a.add(Long.valueOf(paramStructMsg.msg_seq.get()));
      }
    }
    else if (!b.contains(Long.valueOf(paramStructMsg.msg_seq.get())))
    {
      ReportController.b(null, "dc00898", "", "", "0X800B75A", "0X800B75A", 0, 0, String.valueOf(1), "", "", "");
      b.add(Long.valueOf(paramStructMsg.msg_seq.get()));
    }
  }
  
  public static boolean a(structmsg.StructMsg paramStructMsg)
  {
    Object localObject = new FrdSysMsg.AddtionInfo();
    boolean bool2 = false;
    try
    {
      ((FrdSysMsg.AddtionInfo)localObject).mergeFrom(paramStructMsg.msg.bytes_addtion.get().toByteArray());
      int i = ((FrdSysMsg.AddtionInfo)localObject).uint32_poke.get();
      boolean bool3 = b(paramStructMsg);
      if (QLog.isColorLevel())
      {
        paramStructMsg = new StringBuilder();
        paramStructMsg.append("isShowingPoke () addtionInfo.poke = ");
        paramStructMsg.append(i);
        paramStructMsg.append(" isPokeExpired is ");
        paramStructMsg.append(bool3);
        QLog.d("NewFriendNotifyPokeMsgHelper", 2, paramStructMsg.toString());
      }
      boolean bool1 = bool2;
      if (i > 0)
      {
        bool1 = bool2;
        if (!bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (InvalidProtocolBufferMicroException paramStructMsg)
    {
      paramStructMsg.printStackTrace();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isShowingPoke () exp ");
      ((StringBuilder)localObject).append(paramStructMsg);
      QLog.d("NewFriendNotifyPokeMsgHelper", 1, ((StringBuilder)localObject).toString());
    }
    return false;
  }
  
  public static boolean a(structmsg.StructMsg paramStructMsg, AppInterface paramAppInterface)
  {
    boolean bool = false;
    if (paramAppInterface == null) {
      return false;
    }
    long l = paramStructMsg.req_uin.get();
    if (!((IFriendDataService)paramAppInterface.getRuntimeService(IFriendDataService.class, "")).isFriend(String.valueOf(l))) {
      return false;
    }
    paramAppInterface = new FrdSysMsg.AddtionInfo();
    try
    {
      paramAppInterface.mergeFrom(paramStructMsg.msg.bytes_addtion.get().toByteArray());
      int i = paramAppInterface.uint32_poke.get();
      int j = paramAppInterface.uint32_format.get();
      if (QLog.isColorLevel())
      {
        paramStructMsg = new StringBuilder();
        paramStructMsg.append("needShowPokeAndMsgEntrance () addtionInfo.poke = ");
        paramStructMsg.append(i);
        paramStructMsg.append(" format = ");
        paramStructMsg.append(j);
        QLog.d("NewFriendNotifyPokeMsgHelper", 2, paramStructMsg.toString());
      }
      if (j > 0) {
        bool = true;
      }
      return bool;
    }
    catch (InvalidProtocolBufferMicroException paramStructMsg)
    {
      paramStructMsg.printStackTrace();
      paramAppInterface = new StringBuilder();
      paramAppInterface.append("needShowPokeAndMsgEntrance () exp ");
      paramAppInterface.append(paramStructMsg);
      QLog.d("NewFriendNotifyPokeMsgHelper", 1, paramAppInterface.toString());
    }
    return false;
  }
  
  public static void b()
  {
    c.clear();
    d.clear();
  }
  
  private static void b(Object paramObject, AppInterface paramAppInterface)
  {
    Object localObject;
    ImageView localImageView;
    if ((paramObject instanceof MoreSysMsgHolder))
    {
      localObject = (MoreSysMsgHolder)paramObject;
      localImageView = ((MoreSysMsgHolder)localObject).b;
      localObject = ((MoreSysMsgHolder)localObject).jdField_a_of_type_AndroidWidgetImageView;
    }
    else
    {
      if (!(paramObject instanceof SystemMsgItemBuilder.SystemMsgItemHolder)) {
        return;
      }
      localObject = (SystemMsgItemBuilder.SystemMsgItemHolder)paramObject;
      localImageView = ((SystemMsgItemBuilder.SystemMsgItemHolder)localObject).g;
      localObject = ((SystemMsgItemBuilder.SystemMsgItemHolder)localObject).f;
    }
    a(localImageView.getContext(), "poke/click_poke.json", "poke/images/", 45, 45, 0, new NewFriendNotifyPokeMsgHelper.2((ImageView)localObject, paramObject, paramAppInterface, localImageView));
    a((View)localObject);
  }
  
  public static boolean b(structmsg.StructMsg paramStructMsg)
  {
    boolean bool2 = false;
    if (paramStructMsg == null) {
      return false;
    }
    boolean bool1 = bool2;
    if (paramStructMsg.msg_time.has())
    {
      if (paramStructMsg.msg_time.get() <= 0L) {
        return false;
      }
      bool1 = bool2;
      if (NetConnInfoCenter.getServerTime() - paramStructMsg.msg_time.get() > a()) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.newfriend.poke.NewFriendNotifyPokeMsgHelper
 * JD-Core Version:    0.7.0.1
 */