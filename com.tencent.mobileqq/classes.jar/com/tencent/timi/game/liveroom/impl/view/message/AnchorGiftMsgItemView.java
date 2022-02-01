package com.tencent.timi.game.liveroom.impl.view.message;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.CharacterStyle;
import android.util.AttributeSet;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qqgift.api.IQQGiftSDK;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftResDownloadModule;
import com.tencent.mobileqq.qqgift.callback.IQQGiftPanelResDownloadCallback;
import com.tencent.mobileqq.qqgift.sdk.config.QQGiftSDKConfig;
import com.tencent.mobileqq.qqgift.sdk.config.QQGiftSDKConfig.Builder;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftPanelResource;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.component.qqlive.api.TgLiveAnchorUserInfo;
import com.tencent.timi.game.ex.LayoutExKt;
import com.tencent.timi.game.ex.ViewExKt;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.utils.ResUtils;
import com.tencent.timi.game.utils.Logger;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.jvm.internal.Ref.ObjectRef;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/liveroom/impl/view/message/AnchorGiftMsgItemView;", "Lcom/tencent/timi/game/liveroom/impl/view/message/AnchorBaseTextMsgItemView;", "Lcom/tencent/mobileqq/qqgift/callback/IQQGiftPanelResDownloadCallback;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "defaultIcon", "Landroid/graphics/Bitmap;", "giftSDK", "Lcom/tencent/mobileqq/qqgift/api/IQQGiftSDK;", "msg", "Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "receiverSpan", "Lcom/tencent/timi/game/liveroom/impl/view/message/AnchorBaseTextMsgItemView$NickNameLongClick;", "getReceiverSpan", "()Lcom/tencent/timi/game/liveroom/impl/view/message/AnchorBaseTextMsgItemView$NickNameLongClick;", "senderSpan", "getSenderSpan", "onDetachedFromWindow", "", "onLoadFail", "id", "errorCode", "httpCode", "errorMessage", "onLoadSuccess", "panelResource", "Lcom/tencent/mobileqq/qqgift/updatasystem/QQGiftPanelResource;", "onProgress", "progress", "", "progressMax", "progressRate", "refresh", "bitmap", "renderGift", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public class AnchorGiftMsgItemView
  extends AnchorBaseTextMsgItemView
  implements IQQGiftPanelResDownloadCallback
{
  private String a = "AnchorGiftMsgItemView";
  private IQQGiftSDK b;
  private GiftMessage c;
  private Bitmap d;
  @NotNull
  private final AnchorBaseTextMsgItemView.NickNameLongClick e;
  @NotNull
  private final AnchorBaseTextMsgItemView.NickNameLongClick f;
  
  @JvmOverloads
  public AnchorGiftMsgItemView(@NotNull Context paramContext)
  {
    this(paramContext, null, 0, 6, null);
  }
  
  @JvmOverloads
  public AnchorGiftMsgItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0, 4, null);
  }
  
  @JvmOverloads
  public AnchorGiftMsgItemView(@NotNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = ((IQQGiftManager)QRoute.api(IQQGiftManager.class)).getSDKImpl(10001);
    Intrinsics.checkExpressionValueIsNotNull(paramContext, "QRoute.api(IQQGiftManage…nst.LIVE_APP_BUSINESS_ID)");
    this.b = paramContext;
    this.e = new AnchorBaseTextMsgItemView.NickNameLongClick();
    this.f = new AnchorBaseTextMsgItemView.NickNameLongClick();
    if (!this.b.a())
    {
      Logger.c(this.a, "QQGiftSDKConfig init call  ");
      paramContext = QQGiftSDKConfig.a().a(10001).a();
      this.b.a(MobileQQ.sMobileQQ.waitAppRuntime(null), paramContext);
    }
    try
    {
      paramContext = MobileQQ.context;
      Intrinsics.checkExpressionValueIsNotNull(paramContext, "MobileQQ.context");
      this.d = BitmapFactory.decodeResource(paramContext.getResources(), 2130852857);
    }
    catch (Throwable paramContext)
    {
      paramAttributeSet = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("defaultIcon init error ");
      localStringBuilder.append(paramContext.getMessage());
      Logger.c(paramAttributeSet, localStringBuilder.toString());
    }
    setHighlightColor(0);
    setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  private final void a(Bitmap paramBitmap)
  {
    GiftMessage localGiftMessage = this.c;
    if (localGiftMessage != null)
    {
      Ref.IntRef localIntRef = new Ref.IntRef();
      localIntRef.element = (localGiftMessage.giftNum * localGiftMessage.allComboCnt);
      if (localIntRef.element == 0) {
        localIntRef.element = localGiftMessage.giftNum;
      }
      Object localObject1 = new Ref.ObjectRef();
      ((Ref.ObjectRef)localObject1).element = localGiftMessage.senderNick;
      if (TextUtils.isEmpty((CharSequence)((Ref.ObjectRef)localObject1).element)) {
        ((Ref.ObjectRef)localObject1).element = String.valueOf(localGiftMessage.sender);
      }
      if (((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).e(0L) == null)
      {
        setBackgroundResource(2130852867);
        localObject2 = new SpannableString((CharSequence)"感谢TA");
        ((SpannableString)localObject2).setSpan(new AnchorGiftMsgItemView.refresh..inlined.let.lambda.1(localGiftMessage, (Ref.ObjectRef)localObject1, localIntRef, this, paramBitmap), 0, ((SpannableString)localObject2).length(), 17);
        ((SpannableString)localObject2).setSpan(new RadiusBackgroundSpan(-1, -16777216, LayoutExKt.b(10)), 0, ((SpannableString)localObject2).length(), 17);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append((String)((Ref.ObjectRef)localObject1).element);
        ((StringBuilder)localObject3).append(65306);
        localObject3 = ((StringBuilder)localObject3).toString();
        localObject4 = this.e;
        localLiveUserInfo = new LiveUserInfo();
        localLiveUserInfo.nick = ((String)((Ref.ObjectRef)localObject1).element);
        localLiveUserInfo.uid = localGiftMessage.sender;
        localLiveUserInfo.headUrl = localGiftMessage.senderHead;
        ((AnchorBaseTextMsgItemView.NickNameLongClick)localObject4).a(localLiveUserInfo, getRoomId());
        localObject1 = (CharSequence)a((String)localObject3, (CharacterStyle)localObject4);
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("送给你");
        ((StringBuilder)localObject3).append(localGiftMessage.giftName);
        ((StringBuilder)localObject3).append('x');
        ((StringBuilder)localObject3).append(localIntRef.element);
        setSpanText(CollectionsKt.listOf(new CharSequence[] { localObject1, (CharSequence)((StringBuilder)localObject3).toString(), (CharSequence)a(paramBitmap, LayoutExKt.b(20), LayoutExKt.b(20), LayoutExKt.b(6), LayoutExKt.b(8)), (CharSequence)localObject2 }));
        return;
      }
      ViewExKt.a(ViewExKt.a(this, new int[] { ResUtils.b(2131165574) }), LayoutExKt.a(4), LayoutExKt.a(15), LayoutExKt.a(15), LayoutExKt.a(15));
      Object localObject2 = localGiftMessage.receiverNick;
      localObject2 = String.valueOf((String)((Ref.ObjectRef)localObject1).element);
      Object localObject3 = this.e;
      Object localObject4 = new LiveUserInfo();
      ((LiveUserInfo)localObject4).nick = ((String)((Ref.ObjectRef)localObject1).element);
      ((LiveUserInfo)localObject4).uid = localGiftMessage.sender;
      ((LiveUserInfo)localObject4).headUrl = localGiftMessage.senderHead;
      ((AnchorBaseTextMsgItemView.NickNameLongClick)localObject3).a((LiveUserInfo)localObject4, getRoomId());
      localObject1 = (CharSequence)a((String)localObject2, (CharacterStyle)localObject3);
      localObject2 = (CharSequence)" 送给 ";
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(localGiftMessage.receiverNick);
      ((StringBuilder)localObject3).append(' ');
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject4 = this.f;
      LiveUserInfo localLiveUserInfo = new LiveUserInfo();
      localLiveUserInfo.nick = localGiftMessage.receiverNick;
      TgLiveAnchorUserInfo localTgLiveAnchorUserInfo = ((ITgLiveRoomService)ServiceCenter.a(ITgLiveRoomService.class)).i(((AnchorBaseTextMsgItemView.NickNameLongClick)localObject4).a());
      long l;
      if (localTgLiveAnchorUserInfo != null) {
        l = localTgLiveAnchorUserInfo.getAnchorUid();
      } else {
        l = 0L;
      }
      localLiveUserInfo.uid = l;
      localLiveUserInfo.headUrl = localGiftMessage.receiverHead;
      ((AnchorBaseTextMsgItemView.NickNameLongClick)localObject4).a(localLiveUserInfo, getRoomId());
      localObject3 = (CharSequence)a((String)localObject3, (CharacterStyle)localObject4);
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(localGiftMessage.giftName);
      ((StringBuilder)localObject4).append('x');
      ((StringBuilder)localObject4).append(localIntRef.element);
      setSpanText(CollectionsKt.listOf(new CharSequence[] { localObject1, localObject2, localObject3, (CharSequence)((StringBuilder)localObject4).toString(), (CharSequence)AnchorBaseTextMsgItemView.a(this, paramBitmap, LayoutExKt.b(20), LayoutExKt.b(20), 0, 0, 24, null) }));
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, @Nullable String paramString)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadFail id:");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(",errorCode:");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(",httpCode:");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(",errorMessage:");
    localStringBuilder.append(paramString);
    Logger.c(str, localStringBuilder.toString());
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {}
  
  public void a(int paramInt, @Nullable QQGiftPanelResource paramQQGiftPanelResource)
  {
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadSuccess id:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(",panelResource:");
    if (paramQQGiftPanelResource != null) {
      localObject = paramQQGiftPanelResource.b;
    } else {
      localObject = null;
    }
    localStringBuilder.append((String)localObject);
    Logger.c(str, localStringBuilder.toString());
    Object localObject = this.c;
    if ((localObject != null) && (((GiftMessage)localObject).materialID == paramInt) && (paramQQGiftPanelResource != null)) {}
    try
    {
      paramQQGiftPanelResource = paramQQGiftPanelResource.b;
      if (paramQQGiftPanelResource != null)
      {
        paramQQGiftPanelResource = BitmapFactory.decodeFile(paramQQGiftPanelResource);
        if (paramQQGiftPanelResource != null) {
          a(paramQQGiftPanelResource);
        }
      }
      return;
    }
    catch (Throwable paramQQGiftPanelResource) {}
  }
  
  public final void a(@NotNull GiftMessage paramGiftMessage)
  {
    Intrinsics.checkParameterIsNotNull(paramGiftMessage, "msg");
    this.c = paramGiftMessage;
    Bitmap localBitmap = this.d;
    if (localBitmap != null) {
      a(localBitmap);
    }
    this.b.g().a(paramGiftMessage.materialID, (IQQGiftPanelResDownloadCallback)this);
  }
  
  @NotNull
  protected final AnchorBaseTextMsgItemView.NickNameLongClick getReceiverSpan()
  {
    return this.f;
  }
  
  @NotNull
  protected final AnchorBaseTextMsgItemView.NickNameLongClick getSenderSpan()
  {
    return this.e;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.c = ((GiftMessage)null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.liveroom.impl.view.message.AnchorGiftMsgItemView
 * JD-Core Version:    0.7.0.1
 */