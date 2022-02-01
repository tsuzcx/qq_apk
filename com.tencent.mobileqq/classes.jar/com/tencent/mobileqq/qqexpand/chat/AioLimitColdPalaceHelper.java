package com.tencent.mobileqq.qqexpand.chat;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
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
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper;
import com.tencent.mobileqq.qqexpand.utils.ColdPalaceHelper.Companion;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/chat/AioLimitColdPalaceHelper;", "Lcom/tencent/mobileqq/activity/aio/helper/ILifeCycleHelper;", "Lcom/tencent/mobileqq/qqexpand/chat/IColdPalaceBanish;", "Lcom/tencent/mobileqq/qqexpand/network/ExpandObserver;", "chatPie", "Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;", "(Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;)V", "mActivity", "Lcom/tencent/mobileqq/app/BaseActivity;", "getMActivity", "()Lcom/tencent/mobileqq/app/BaseActivity;", "setMActivity", "(Lcom/tencent/mobileqq/app/BaseActivity;)V", "mApp", "Lcom/tencent/mobileqq/app/QQAppInterface;", "getMApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "mChatPie", "getMChatPie", "()Lcom/tencent/mobileqq/activity/aio/core/BaseChatPie;", "mColdPalaceGrayTipPosition", "", "getMColdPalaceGrayTipPosition", "()I", "setMColdPalaceGrayTipPosition", "(I)V", "mHasInitInsertColdPalaceGrayTip", "", "getMHasInitInsertColdPalaceGrayTip", "()Z", "setMHasInitInsertColdPalaceGrayTip", "(Z)V", "mHasInitLimitMatchFriendMsgCount", "getMHasInitLimitMatchFriendMsgCount", "setMHasInitLimitMatchFriendMsgCount", "mHasInsertColdPalaceGrayTip", "getMHasInsertColdPalaceGrayTip", "setMHasInsertColdPalaceGrayTip", "mLimitMatchFriendMsgCount", "getMLimitMatchFriendMsgCount", "setMLimitMatchFriendMsgCount", "mMsgObserver", "Lcom/tencent/mobileqq/app/MessageObserver;", "getMMsgObserver", "()Lcom/tencent/mobileqq/app/MessageObserver;", "mTipsDialog", "Landroid/app/Dialog;", "getMTipsDialog", "()Landroid/app/Dialog;", "setMTipsDialog", "(Landroid/app/Dialog;)V", "addJubaoGrayTip", "", "doOnCreate", "doOnDestroy", "doOnShowFirst", "from", "getMsgTypeShouldNotInclude", "", "getTag", "getTipsDialog", "initHasInsertColdPalaceGrayTip", "initLimitMatchFriendMsgCount", "peerUin", "type", "interestedIn", "", "onBanishColdPalaceClick", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "context", "Landroid/content/Context;", "uinType", "uin", "onColdPalaceLimitCancel", "onColdPalaceLimitConfirm", "onMoveToState", "state", "onReqThrowToColdPalace", "suc", "isUsedUp", "preloadColdPalacePic", "setTipsDialog", "dialog", "shouldShowGrayTipEntry", "Companion", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public class AioLimitColdPalaceHelper
  extends ExpandObserver
  implements ILifeCycleHelper, IColdPalaceBanish
{
  public static final AioLimitColdPalaceHelper.Companion a = new AioLimitColdPalaceHelper.Companion(null);
  @NotNull
  private final BaseChatPie b;
  @NotNull
  private final QQAppInterface c;
  @NotNull
  private BaseActivity d;
  @Nullable
  private Dialog e;
  @NotNull
  private final MessageObserver f;
  private volatile boolean g;
  private volatile int h;
  private volatile boolean i;
  private volatile boolean j;
  private volatile int k;
  
  public AioLimitColdPalaceHelper(@NotNull BaseChatPie paramBaseChatPie)
  {
    this.b = paramBaseChatPie;
    QQAppInterface localQQAppInterface = paramBaseChatPie.d;
    Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "chatPie.app");
    this.c = localQQAppInterface;
    paramBaseChatPie = paramBaseChatPie.aX();
    Intrinsics.checkExpressionValueIsNotNull(paramBaseChatPie, "chatPie.activity");
    this.d = paramBaseChatPie;
    this.j = true;
    this.k = 1;
    this.f = ((MessageObserver)new AioLimitColdPalaceHelper.1(this));
  }
  
  private final void a(String paramString, int paramInt)
  {
    Object localObject2 = (AioLimitColdPalaceHelper)this;
    Object localObject1 = ((AioLimitColdPalaceHelper)localObject2).p();
    localObject2 = QQEntityManagerFactoryProxy.a(((AioLimitColdPalaceHelper)localObject2).c);
    Object localObject3 = StringCompanionObject.INSTANCE;
    localObject3 = new Object[2];
    int m = 0;
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
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        localObject3 = (MessageRecord)localObject2;
        if ((((ILimitChatUtils)QRoute.api(ILimitChatUtils.class)).isSystemMessage(((MessageRecord)localObject3).msgtype) ^ true)) {
          paramString.add(localObject2);
        }
      }
      paramString = (List)paramString;
    }
    else
    {
      paramString = null;
    }
    paramInt = m;
    if (paramString != null) {
      paramInt = paramString.size();
    }
    this.h = paramInt;
    this.g = true;
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("initLimitMatchFriendMsgCount: mHasInsertColdPalaceGrayTip = ");
      paramString.append(this.j);
      paramString.append(" mLimitMatchFriendMsgCount = ");
      paramString.append(this.h);
      paramString.append(" mHasInitInsertGrayTip = ");
      paramString.append(this.i);
      paramString.append(" mColdPalaceGrayTipPosition = ");
      paramString.append(this.k);
      QLog.i("AioLimitColdPalaceHelper", 2, paramString.toString());
    }
    if ((this.i) && (!this.j) && (this.h >= this.k)) {
      o();
    }
  }
  
  private final void r()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AioLimitColdPalaceHelper", 2, "initHasInsertColdPalaceGrayTip");
    }
    Object localObject1;
    Object localObject2;
    if ((this.c.getMessageFacade() != null) && (this.b.ah != null))
    {
      localObject1 = this.c.getMessageFacade();
      if (localObject1 != null)
      {
        localObject2 = this.b.ah;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        localObject2 = ((SessionInfo)localObject2).b;
        SessionInfo localSessionInfo = this.b.ah;
        if (localSessionInfo == null) {
          Intrinsics.throwNpe();
        }
        localObject1 = ((QQMessageFacade)localObject1).a((String)localObject2, localSessionInfo.a, new int[] { -5020 });
      }
      else
      {
        localObject1 = null;
      }
      this.j = false;
      int m;
      if (localObject1 != null) {
        m = ((List)localObject1).size();
      } else {
        m = 0;
      }
      if (m <= 0)
      {
        this.j = false;
      }
      else
      {
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        localObject1 = ((List)localObject1).iterator();
      }
    }
    else
    {
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (MessageRecord)((Iterator)localObject1).next();
        if (((localObject2 instanceof MessageForUniteGrayTip)) && (((MessageForUniteGrayTip)localObject2).tipParam.i == 459802))
        {
          this.j = true;
          break;
          this.j = true;
        }
      }
    }
    this.i = true;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("initHasInsertColdPalaceGrayTip: mHasInsertColdPalaceGrayTip = ");
      ((StringBuilder)localObject1).append(this.j);
      ((StringBuilder)localObject1).append(" mLimitMatchFriendMsgCount = ");
      ((StringBuilder)localObject1).append(this.h);
      ((StringBuilder)localObject1).append(" mColdPalaceGrayTipPosition = ");
      ((StringBuilder)localObject1).append(this.k);
      QLog.i("AioLimitColdPalaceHelper", 2, ((StringBuilder)localObject1).toString());
    }
    if ((!this.j) && (this.h >= this.k)) {
      o();
    }
  }
  
  private final boolean s()
  {
    return (this.k > 0) && (ColdPalaceHelper.f.a((BaseQQAppInterface)this.c).f());
  }
  
  @NotNull
  public final BaseChatPie a()
  {
    return this.b;
  }
  
  public void a(@Nullable Dialog paramDialog)
  {
    this.e = paramDialog;
  }
  
  protected void a(boolean paramBoolean1, @NotNull String paramString, int paramInt, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    if (StringsKt.equals(paramString, this.b.ah.b, true)) {
      a.a((BaseQQAppInterface)this.c, (Context)this.d, paramBoolean1, paramInt, paramString, paramBoolean2, (IColdPalaceBanish)this);
    }
  }
  
  @NotNull
  public final QQAppInterface b()
  {
    return this.c;
  }
  
  public final void b(int paramInt)
  {
    this.h = paramInt;
  }
  
  @Nullable
  public Dialog c()
  {
    return this.e;
  }
  
  public void d()
  {
    AioLimitColdPalaceHelper.Companion localCompanion = a;
    BaseQQAppInterface localBaseQQAppInterface = (BaseQQAppInterface)this.c;
    Activity localActivity = (Activity)this.d;
    int m = this.b.ah.a;
    String str = this.b.ah.b;
    Intrinsics.checkExpressionValueIsNotNull(str, "mChatPie.sessionInfo.curFriendUin");
    localCompanion.a(localBaseQQAppInterface, localActivity, m, str, (IColdPalaceBanish)this);
  }
  
  public void e()
  {
    a.a((IColdPalaceBanish)this);
  }
  
  public int f()
  {
    return 1;
  }
  
  @NotNull
  public final BaseActivity g()
  {
    return this.d;
  }
  
  @NotNull
  public String getTag()
  {
    return "AioLimitColdPalaceHelper";
  }
  
  public final int h()
  {
    return this.h;
  }
  
  public final boolean i()
  {
    return this.i;
  }
  
  @NotNull
  public int[] interestedIn()
  {
    return new int[] { 4, 9, 15 };
  }
  
  public final boolean j()
  {
    return this.j;
  }
  
  public final int k()
  {
    return this.k;
  }
  
  public final void l()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AioLimitColdPalaceHelper", 2, "doOnCreate");
    }
    Manager localManager = this.c.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (localManager != null)
    {
      this.k = ((IExpandManager)localManager).Q();
      this.c.addObserver((BusinessObserver)this.f);
      this.c.addObserver((BusinessObserver)this);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.qqexpand.manager.IExpandManager");
  }
  
  public final void m()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnShowFirst mColdPalaceGrayTipPosition = ");
      localStringBuilder.append(this.k);
      QLog.i("AioLimitColdPalaceHelper", 2, localStringBuilder.toString());
    }
    if (!s()) {
      return;
    }
    ThreadManager.executeOnSubThread((Runnable)new AioLimitColdPalaceHelper.doOnShowFirst.1(this));
  }
  
  public final void n()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AioLimitColdPalaceHelper", 2, "doOnDestroy");
    }
    Dialog localDialog = this.e;
    if ((localDialog != null) && (localDialog.isShowing())) {
      localDialog.dismiss();
    }
    this.c.removeObserver((BusinessObserver)this.f);
    this.c.removeObserver((BusinessObserver)this);
  }
  
  public final void o()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("addBanishColdPalaceGrayTip: ");
      localStringBuilder.append(this.j);
      QLog.i("AioLimitColdPalaceHelper", 2, localStringBuilder.toString());
    }
    if (!this.j)
    {
      this.j = true;
      ThreadManager.executeOnSubThread((Runnable)new AioLimitColdPalaceHelper.addJubaoGrayTip.1(this));
    }
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 9)
      {
        if (paramInt != 15) {
          return;
        }
        n();
        return;
      }
      m();
      return;
    }
    l();
  }
  
  @Nullable
  public String p()
  {
    StringBuilder localStringBuilder = new StringBuilder(UinTypeUtil.b.length * 8);
    localStringBuilder.append("not in (");
    int[] arrayOfInt = UinTypeUtil.b;
    Intrinsics.checkExpressionValueIsNotNull(arrayOfInt, "UinTypeUtil.MSGTYPE_HISTORY_INVISIBLE");
    int n = arrayOfInt.length;
    int m = 0;
    while (m < n)
    {
      localStringBuilder.append(UinTypeUtil.b[m]);
      localStringBuilder.append(",");
      m += 1;
    }
    localStringBuilder.append(-5020);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public final void q()
  {
    URLDrawable localURLDrawable = URLDrawable.getDrawable("https://downv6.qq.com/qq_relation/cold_palace/aio_limit_chat_cold_palace.png", null);
    Intrinsics.checkExpressionValueIsNotNull(localURLDrawable, "URLDrawable.getDrawable(…D_PALACE_IMAGE_URL, null)");
    if (1 != localURLDrawable.getStatus())
    {
      localURLDrawable.setAutoDownload(true);
      localURLDrawable.startDownload(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.chat.AioLimitColdPalaceHelper
 * JD-Core Version:    0.7.0.1
 */