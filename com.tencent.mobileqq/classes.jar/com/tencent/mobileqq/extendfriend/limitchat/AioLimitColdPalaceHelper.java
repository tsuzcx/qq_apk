package com.tencent.mobileqq.extendfriend.limitchat;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.ILifeCycleHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.mobileqq.extendfriend.network.ExtendFriendObserver;
import com.tencent.mobileqq.extendfriend.utils.ColdPalaceHelper;
import com.tencent.mobileqq.extendfriend.utils.ColdPalaceHelper.Companion;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/extendfriend/limitchat/AioLimitColdPalaceHelper;", "Lcom/tencent/mobileqq/activity/aio/helper/ILifeCycleHelper;", "Lcom/tencent/mobileqq/extendfriend/limitchat/IColdPalaceBanish;", "Lcom/tencent/mobileqq/extendfriend/network/ExtendFriendObserver;", "chatPie", "Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;", "(Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;)V", "mActivity", "Lcom/tencent/mobileqq/app/BaseActivity;", "getMActivity", "()Lcom/tencent/mobileqq/app/BaseActivity;", "setMActivity", "(Lcom/tencent/mobileqq/app/BaseActivity;)V", "mApp", "Lcom/tencent/mobileqq/app/QQAppInterface;", "getMApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "mChatPie", "getMChatPie", "()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;", "mColdPalaceGrayTipPosition", "", "getMColdPalaceGrayTipPosition", "()I", "setMColdPalaceGrayTipPosition", "(I)V", "mHasInitInsertColdPalaceGrayTip", "", "getMHasInitInsertColdPalaceGrayTip", "()Z", "setMHasInitInsertColdPalaceGrayTip", "(Z)V", "mHasInitLimitMatchFriendMsgCount", "getMHasInitLimitMatchFriendMsgCount", "setMHasInitLimitMatchFriendMsgCount", "mHasInsertColdPalaceGrayTip", "getMHasInsertColdPalaceGrayTip", "setMHasInsertColdPalaceGrayTip", "mLimitMatchFriendMsgCount", "getMLimitMatchFriendMsgCount", "setMLimitMatchFriendMsgCount", "mMsgObserver", "Lcom/tencent/mobileqq/app/MessageObserver;", "getMMsgObserver", "()Lcom/tencent/mobileqq/app/MessageObserver;", "mTipsDialog", "Landroid/app/Dialog;", "getMTipsDialog", "()Landroid/app/Dialog;", "setMTipsDialog", "(Landroid/app/Dialog;)V", "addBanishColdPalaceGrayTip", "", "doOnCreate", "doOnDestroy", "doOnShowFirst", "from", "getMsgTypeShouldNotInclude", "", "getTag", "getTipsDialog", "initHasInsertColdPalaceGrayTip", "initLimitMatchFriendMsgCount", "peerUin", "type", "interestedIn", "", "onBanishColdPalaceClick", "app", "context", "Landroid/content/Context;", "uinType", "uin", "onColdPalaceLimitCancel", "onColdPalaceLimitConfirm", "onMoveToState", "state", "onReqThrowToColdPalace", "suc", "isUsedUp", "preloadColdPalacePic", "setTipsDialog", "dialog", "shouldShowGrayTipEntry", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public class AioLimitColdPalaceHelper
  extends ExtendFriendObserver
  implements ILifeCycleHelper, IColdPalaceBanish
{
  public static final AioLimitColdPalaceHelper.Companion a;
  private volatile int jdField_a_of_type_Int;
  @Nullable
  private Dialog jdField_a_of_type_AndroidAppDialog;
  @NotNull
  private final BaseChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  @NotNull
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  @NotNull
  private final MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver;
  @NotNull
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private volatile boolean jdField_a_of_type_Boolean;
  private volatile int jdField_b_of_type_Int;
  private volatile boolean jdField_b_of_type_Boolean;
  private volatile boolean c;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatAioLimitColdPalaceHelper$Companion = new AioLimitColdPalaceHelper.Companion(null);
  }
  
  public AioLimitColdPalaceHelper(@NotNull BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie = paramBaseChatPie;
    QQAppInterface localQQAppInterface = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "chatPie.app");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = localQQAppInterface;
    paramBaseChatPie = paramBaseChatPie.a();
    Intrinsics.checkExpressionValueIsNotNull(paramBaseChatPie, "chatPie.activity");
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseChatPie;
    this.c = true;
    this.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver = ((MessageObserver)new AioLimitColdPalaceHelper.1(this));
  }
  
  @JvmStatic
  public static final void a(@NotNull Context paramContext)
  {
    jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatAioLimitColdPalaceHelper$Companion.a(paramContext);
  }
  
  @JvmStatic
  public static final void a(@NotNull QQAppInterface paramQQAppInterface, @NotNull Activity paramActivity, int paramInt, @NotNull String paramString, @NotNull IColdPalaceBanish paramIColdPalaceBanish)
  {
    jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatAioLimitColdPalaceHelper$Companion.a(paramQQAppInterface, paramActivity, paramInt, paramString, paramIColdPalaceBanish);
  }
  
  @JvmStatic
  public static final void a(@Nullable QQAppInterface paramQQAppInterface, @Nullable Context paramContext, int paramInt, @NotNull String paramString, @NotNull IColdPalaceBanish paramIColdPalaceBanish)
  {
    jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatAioLimitColdPalaceHelper$Companion.b(paramQQAppInterface, paramContext, paramInt, paramString, paramIColdPalaceBanish);
  }
  
  @JvmStatic
  public static final void a(@Nullable QQAppInterface paramQQAppInterface, @Nullable Context paramContext, boolean paramBoolean1, int paramInt, @NotNull String paramString, boolean paramBoolean2, @NotNull IColdPalaceBanish paramIColdPalaceBanish)
  {
    jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatAioLimitColdPalaceHelper$Companion.a(paramQQAppInterface, paramContext, paramBoolean1, paramInt, paramString, paramBoolean2, paramIColdPalaceBanish);
  }
  
  @JvmStatic
  public static final void a(@NotNull IColdPalaceBanish paramIColdPalaceBanish)
  {
    jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatAioLimitColdPalaceHelper$Companion.a(paramIColdPalaceBanish);
  }
  
  private final void a(String paramString, int paramInt)
  {
    int i = 0;
    Object localObject2 = (AioLimitColdPalaceHelper)this;
    Object localObject1 = ((AioLimitColdPalaceHelper)localObject2).a();
    localObject2 = QQEntityManagerFactoryProxy.a(((AioLimitColdPalaceHelper)localObject2).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject3 = StringCompanionObject.INSTANCE;
    localObject3 = new Object[2];
    localObject3[0] = Long.valueOf(9223372036854775807L);
    localObject3[1] = localObject1;
    localObject1 = String.format("time < %d and issend = 0 and msgtype %s", Arrays.copyOf((Object[])localObject3, localObject3.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "java.lang.String.format(format, *args)");
    paramString = ((EntityManager)localObject2).query(MessageRecord.class, MessageRecord.getTableName(paramString, paramInt), false, (String)localObject1, null, null, null, null, "20");
    if (paramString != null)
    {
      localObject1 = (Iterable)paramString;
      paramString = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      label177:
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (!ExpandFriendChatUtil.a((MessageRecord)localObject2)) {}
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0) {
            break label177;
          }
          paramString.add(localObject2);
          break;
        }
      }
      paramString = (List)paramString;
      if (paramString == null) {
        break label315;
      }
    }
    label315:
    for (paramInt = paramString.size();; paramInt = i)
    {
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("AioLimitColdPalaceHelper", 2, "initLimitMatchFriendMsgCount: mHasInsertColdPalaceGrayTip = " + this.c + " mLimitMatchFriendMsgCount = " + this.jdField_a_of_type_Int + " mHasInitInsertGrayTip = " + this.jdField_b_of_type_Boolean + " mColdPalaceGrayTipPosition = " + this.jdField_b_of_type_Int);
      }
      if ((this.jdField_b_of_type_Boolean) && (!this.c) && (this.jdField_a_of_type_Int >= this.jdField_b_of_type_Int)) {
        f();
      }
      return;
      paramString = null;
      break;
    }
  }
  
  private final boolean c()
  {
    return (this.jdField_b_of_type_Int > 0) && (ColdPalaceHelper.a.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a());
  }
  
  private final void h()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AioLimitColdPalaceHelper", 2, "initHasInsertColdPalaceGrayTip");
    }
    Object localObject1;
    Object localObject2;
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade() != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo != null))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
      if (localObject1 != null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        localObject2 = ((SessionInfo)localObject2).jdField_a_of_type_JavaLangString;
        SessionInfo localSessionInfo = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
        if (localSessionInfo == null) {
          Intrinsics.throwNpe();
        }
        localObject1 = ((QQMessageFacade)localObject1).a((String)localObject2, localSessionInfo.jdField_a_of_type_Int, new int[] { -5020 });
        this.c = false;
        if (localObject1 == null) {
          break label225;
        }
        i = ((List)localObject1).size();
        label121:
        if (i > 0) {
          break label230;
        }
        this.c = false;
        label129:
        break label244;
      }
    }
    for (;;)
    {
      this.jdField_b_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.i("AioLimitColdPalaceHelper", 2, "initHasInsertColdPalaceGrayTip: mHasInsertColdPalaceGrayTip = " + this.c + " mLimitMatchFriendMsgCount = " + this.jdField_a_of_type_Int + " mColdPalaceGrayTipPosition = " + this.jdField_b_of_type_Int);
      }
      if ((!this.c) && (this.jdField_a_of_type_Int >= this.jdField_b_of_type_Int)) {
        f();
      }
      return;
      localObject1 = null;
      break;
      label225:
      i = 0;
      break label121;
      label230:
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((List)localObject1).iterator();
      label244:
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if ((!(localObject2 instanceof MessageForUniteGrayTip)) || (((MessageForUniteGrayTip)localObject2).tipParam.jdField_b_of_type_Int != 459802)) {
          break label129;
        }
        this.c = true;
        continue;
        this.c = true;
      }
    }
  }
  
  public int a()
  {
    return 1;
  }
  
  @Nullable
  public Dialog a()
  {
    return this.jdField_a_of_type_AndroidAppDialog;
  }
  
  @NotNull
  public final BaseChatPie a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie;
  }
  
  @NotNull
  public final BaseActivity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  }
  
  @NotNull
  public final QQAppInterface a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  }
  
  @Nullable
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder(UinTypeUtil.b.length * 8);
    localStringBuilder.append("not in (");
    int i = 0;
    int[] arrayOfInt = UinTypeUtil.b;
    Intrinsics.checkExpressionValueIsNotNull(arrayOfInt, "UinTypeUtil.MSGTYPE_HISTORY_INVISIBLE");
    int j = arrayOfInt.length;
    while (i < j)
    {
      localStringBuilder.append(UinTypeUtil.b[i]);
      localStringBuilder.append(",");
      i += 1;
    }
    localStringBuilder.append(-5020);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public final void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AioLimitColdPalaceHelper", 2, "doOnCreate");
    }
    Manager localManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (localManager == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.extendfriend.ExtendFriendManager");
    }
    this.jdField_b_of_type_Int = ((ExtendFriendManager)localManager).g();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver((BusinessObserver)this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver((BusinessObserver)this);
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(@Nullable Dialog paramDialog)
  {
    this.jdField_a_of_type_AndroidAppDialog = paramDialog;
  }
  
  public void a(@NotNull QQAppInterface paramQQAppInterface, @NotNull Context paramContext, int paramInt, @Nullable String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    AioLimitColdPalaceHelper.Companion localCompanion = jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatAioLimitColdPalaceHelper$Companion;
    if (paramString == null) {
      Intrinsics.throwNpe();
    }
    localCompanion.b(paramQQAppInterface, paramContext, paramInt, paramString, (IColdPalaceBanish)this);
  }
  
  public final boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public final int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public final void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AioLimitColdPalaceHelper", 2, "doOnShowFirst mColdPalaceGrayTipPosition = " + this.jdField_b_of_type_Int);
    }
    if (!c()) {
      return;
    }
    ThreadManager.executeOnSubThread((Runnable)new AioLimitColdPalaceHelper.doOnShowFirst.1(this));
  }
  
  public final boolean b()
  {
    return this.c;
  }
  
  public final int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public void c()
  {
    AioLimitColdPalaceHelper.Companion localCompanion = jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatAioLimitColdPalaceHelper$Companion;
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Activity localActivity = (Activity)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int;
    String str = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
    Intrinsics.checkExpressionValueIsNotNull(str, "mChatPie.sessionInfo.curFriendUin");
    localCompanion.a(localQQAppInterface, localActivity, i, str, (IColdPalaceBanish)this);
  }
  
  public void d()
  {
    jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatAioLimitColdPalaceHelper$Companion.a((IColdPalaceBanish)this);
  }
  
  public final void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AioLimitColdPalaceHelper", 2, "doOnDestroy");
    }
    Dialog localDialog = this.jdField_a_of_type_AndroidAppDialog;
    if ((localDialog != null) && (localDialog.isShowing())) {
      localDialog.dismiss();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver((BusinessObserver)this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver((BusinessObserver)this);
  }
  
  public final void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AioLimitColdPalaceHelper", 2, "addBanishColdPalaceGrayTip: " + this.c);
    }
    if (!this.c)
    {
      this.c = true;
      ThreadManager.executeOnSubThread((Runnable)new AioLimitColdPalaceHelper.addBanishColdPalaceGrayTip.1(this));
    }
  }
  
  public final void g()
  {
    URLDrawable localURLDrawable = URLDrawable.getDrawable("https://downv6.qq.com/qq_relation/cold_palace/aio_limit_chat_cold_palace.png", null);
    Intrinsics.checkExpressionValueIsNotNull(localURLDrawable, "URLDrawable.getDrawable(…D_PALACE_IMAGE_URL, null)");
    if (1 != localURLDrawable.getStatus())
    {
      localURLDrawable.setAutoDownload(true);
      localURLDrawable.startDownload(true);
    }
  }
  
  @NotNull
  public String getTag()
  {
    return "AioLimitColdPalaceHelper";
  }
  
  @NotNull
  public int[] interestedIn()
  {
    return new int[] { 4, 8, 14 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4: 
      a();
      return;
    case 8: 
      b();
      return;
    }
    e();
  }
  
  public void onReqThrowToColdPalace(boolean paramBoolean1, @NotNull String paramString, int paramInt, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    if (StringsKt.equals(paramString, this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, true)) {
      jdField_a_of_type_ComTencentMobileqqExtendfriendLimitchatAioLimitColdPalaceHelper$Companion.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (Context)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramBoolean1, paramInt, paramString, paramBoolean2, (IColdPalaceBanish)this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.limitchat.AioLimitColdPalaceHelper
 * JD-Core Version:    0.7.0.1
 */