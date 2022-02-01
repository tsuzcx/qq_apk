package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.ark.ArkViewImplement.ArkViewInterface;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.ArkAioContainerWrapper;
import com.tencent.mobileqq.activity.aio.item.ArkAppContainer.ArkViewExtraInterface;
import com.tencent.mobileqq.activity.aio.item.ArkAppLoadLayout;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.ark.ArkTipsManager;
import com.tencent.mobileqq.ark.api.module.ArkAppQQModuleBase;
import com.tencent.mobileqq.ark.share.core.ArkAsyncShareMsgManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForArkApp.Size;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildMsgItemLayout;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.remote.MessageRecordInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.open.sdk.report.SdkShareReporter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class GuildArkAppItemBuilder
  extends BaseGuildMsgViewBuild
{
  private static final int a = ViewUtils.dpToPx(146.0F);
  private SessionInfo l = null;
  private int m;
  private int n;
  private List<MessageForArkApp> o = new ArrayList();
  
  public GuildArkAppItemBuilder(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.l = paramSessionInfo;
  }
  
  private void a(View paramView, MessageForArkApp paramMessageForArkApp, GuildArkAppItemBuilder.Holder paramHolder, ArkViewImplement.ArkViewInterface paramArkViewInterface)
  {
    if (v)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if ((paramHolder.r != null) && (paramHolder.r.length() > 0)) {
        localStringBuilder.append(paramHolder.r);
      }
      localStringBuilder.append(b_(paramMessageForArkApp));
      paramView.setContentDescription(localStringBuilder);
      paramArkViewInterface.setContentDescription(localStringBuilder);
      paramView = new StringBuilder();
      paramView.append("Type is normal, and talkbackText is ");
      paramView.append(localStringBuilder);
      QLog.i("GuildArkAppItemBuilder", 1, paramView.toString());
    }
  }
  
  private void a(MessageForArkApp paramMessageForArkApp)
  {
    if (!this.o.contains(paramMessageForArkApp))
    {
      SdkShareReporter.a(paramMessageForArkApp);
      this.o.add(paramMessageForArkApp);
    }
  }
  
  private void a(MessageForArkApp paramMessageForArkApp, ArkAppMessage.Config paramConfig)
  {
    boolean bool1;
    if ((paramConfig.autoSize != null) && (paramConfig.autoSize.intValue() == 1)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int i = GuildMsgItemLayout.o;
    int k = MessageForArkApp.dp2px(390.0F);
    boolean bool2 = MessageForArkApp.isSetSizeByConfig(paramConfig);
    StringBuilder localStringBuilder = new StringBuilder("isSetSize=");
    localStringBuilder.append(bool2);
    localStringBuilder.append(",param=[");
    Object localObject;
    if (bool2)
    {
      localObject = MessageForArkApp.limitToSizeRange(ArkAppCenterUtil.d(), paramConfig.width.intValue(), paramConfig.height.intValue());
      if (localObject != null)
      {
        if (bool1) {
          j = i;
        } else {
          j = ((MessageForArkApp.Size)localObject).width;
        }
        this.m = j;
        this.n = ((MessageForArkApp.Size)localObject).height;
        paramMessageForArkApp.arkContainer.setFixSize(this.m, this.n);
        localStringBuilder.append("arkConfig.width=");
        localStringBuilder.append(paramConfig.width);
        localStringBuilder.append(",arkConfig.height=");
        localStringBuilder.append(paramConfig.height);
        localStringBuilder.append("][autoSize=");
        localStringBuilder.append(bool1);
        localStringBuilder.append(",maxSize=");
        localStringBuilder.append(i);
        localStringBuilder.append("][size=");
        localStringBuilder.append(((MessageForArkApp.Size)localObject).width);
        localStringBuilder.append(",");
        localStringBuilder.append(((MessageForArkApp.Size)localObject).height);
        localStringBuilder.append("]");
        localStringBuilder.append("],app=");
        localStringBuilder.append(paramMessageForArkApp.ark_app_message.appName);
      }
    }
    else
    {
      if (bool1) {
        j = i;
      } else {
        j = -1;
      }
      this.m = j;
      this.n = -1;
      localObject = paramMessageForArkApp.arkContainer;
      if (bool1) {
        j = i;
      } else {
        j = -1;
      }
      ((ArkAioContainerWrapper)localObject).setFixSize(j, -1);
      localStringBuilder.append("arkConfig.width=");
      localStringBuilder.append(paramConfig.width);
      localStringBuilder.append(",arkConfig.height=");
      localStringBuilder.append(paramConfig.height);
      localStringBuilder.append("][autoSize=");
      localStringBuilder.append(bool1);
      localStringBuilder.append(",maxSize=");
      localStringBuilder.append(i);
      localStringBuilder.append("]");
      localStringBuilder.append(",app=");
      localStringBuilder.append(paramMessageForArkApp.ark_app_message.appName);
    }
    QLog.i("GuildArkAppItemBuilder", 1, localStringBuilder.toString());
    ArkAppCenterUtil.a("GuildArkAppItemBuilder.attachArkView", this.b);
    int j = MessageForArkApp.dp2px(30.0F);
    int i1 = MessageForArkApp.dp2px(30.0F);
    paramMessageForArkApp.arkContainer.setMinSize(j, i1);
    paramMessageForArkApp.arkContainer.setHintSize(-1, i);
    paramMessageForArkApp.arkContainer.a(i, i);
    paramMessageForArkApp.arkContainer.setMaxSize(GuildMsgItemLayout.o, k);
  }
  
  private void b(MessageForArkApp paramMessageForArkApp)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:659)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s2stmt(TypeTransformer.java:820)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:843)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @NonNull
  protected View a(ChatMessage paramChatMessage, BaseGuildMsgViewBuild.ViewHolder paramViewHolder, View paramView, GuildMsgItemLayout paramGuildMsgItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramGuildMsgItemLayout = (MessageForArkApp)paramChatMessage;
    ArkAppMessage.Config localConfig = new ArkAppMessage.Config();
    localConfig.fromString(paramGuildMsgItemLayout.ark_app_message.config);
    GuildArkAppItemBuilder.Holder localHolder = (GuildArkAppItemBuilder.Holder)paramViewHolder;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.b).inflate(2131624417, null);
      localHolder.c = ((ArkAppView)paramView.findViewById(2131428746));
      localHolder.d = ((LinearLayout)paramView.findViewById(2131428755));
      localHolder.e = ((ImageView)paramView.findViewById(2131428754));
      localHolder.f = ((TextView)paramView.findViewById(2131428756));
      localHolder.c.setTag(localHolder);
      localHolder.b = ((ArkAppLoadLayout)paramView.findViewById(2131437612));
    }
    if (localHolder.b != null)
    {
      localObject1 = (RelativeLayout.LayoutParams)localHolder.b.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject1).width = GuildMsgItemLayout.o;
      ((RelativeLayout.LayoutParams)localObject1).height = a;
      ((RelativeLayout.LayoutParams)localObject1).setMargins(0, 0, 0, 0);
      localHolder.b.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    paramView.findViewById(2131428772).setPadding(0, 0, 0, 0);
    b(paramGuildMsgItemLayout);
    if (localHolder.d != null) {
      localHolder.d.setVisibility(8);
    }
    if (ArkTipsManager.b().b(paramChatMessage.uniseq)) {
      paramGuildMsgItemLayout.arkContainer = ArkTipsManager.b().f();
    }
    if (paramGuildMsgItemLayout.arkContainer == null) {
      paramGuildMsgItemLayout.arkContainer = new ArkAioContainerWrapper();
    }
    paramGuildMsgItemLayout.arkContainer.a(this.l);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("multiAio.ArkAppItemBubbleBuilder set session info =");
      ((StringBuilder)localObject1).append(ArkAppQQModuleBase.a(this.l));
      QLog.d("GuildArkAppItemBuilder", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = localHolder.b;
    paramGuildMsgItemLayout.arkContainer.a(paramGuildMsgItemLayout.ark_app_message.appName, paramGuildMsgItemLayout.ark_app_message.appView, paramGuildMsgItemLayout.ark_app_message.appMinVersion, paramGuildMsgItemLayout.ark_app_message.metaList, ArkAppCenterUtil.d(), paramGuildMsgItemLayout, this.c);
    Object localObject2 = new GuildArkAppItemBuilder.1(this, paramGuildMsgItemLayout, localHolder);
    localHolder.c.setLoadCallback((ArkViewImplement.LoadCallback)localObject2);
    a(paramGuildMsgItemLayout, localConfig);
    localHolder.a = paramGuildMsgItemLayout.msg;
    localObject2 = localHolder.c;
    ArkAppView localArkAppView = localHolder.c;
    ((ArkViewImplement.ArkViewInterface)localObject2).setClipRadius(6.0F);
    if (MessageForArkApp.isRectangleBorder(localConfig)) {
      ((ArkViewImplement.ArkViewInterface)localObject2).setBorderType(0);
    } else {
      ((ArkViewImplement.ArkViewInterface)localObject2).setBorderType(1);
    }
    ((ArkViewImplement.ArkViewInterface)localObject2).setAlignLeft(paramChatMessage.isSend() ^ true);
    localArkAppView.a(paramGuildMsgItemLayout.arkContainer, (ArkAppLoadLayout)localObject1);
    ((ArkViewImplement.ArkViewInterface)localObject2).setOnTouchListener(paramOnLongClickAndTouchListener);
    ((ArkViewImplement.ArkViewInterface)localObject2).setOnLongClickListener(paramOnLongClickAndTouchListener);
    if (localObject1 != null)
    {
      ((ArkAppLoadLayout)localObject1).setOnTouchListener(paramOnLongClickAndTouchListener);
      ((ArkAppLoadLayout)localObject1).setOnLongClickListener(paramOnLongClickAndTouchListener);
    }
    a(paramView, paramGuildMsgItemLayout, localHolder, (ArkViewImplement.ArkViewInterface)localObject2);
    ArkAsyncShareMsgManager.d(paramGuildMsgItemLayout);
    ((IApolloUtil)QRoute.api(IApolloUtil.class)).playShareMsgAction(this.g, this.c, paramChatMessage, paramViewHolder.l, paramViewHolder.m);
    a(paramGuildMsgItemLayout);
    return paramView;
  }
  
  protected BaseGuildMsgViewBuild.ViewHolder a()
  {
    return new GuildArkAppItemBuilder.Holder();
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateView type=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(",message=");
      localStringBuilder.append(paramChatMessage);
      QLog.d("GuildArkAppItemBuilder", 2, localStringBuilder.toString());
    }
    super.a(paramView, paramChatMessage, paramInt);
    c(paramChatMessage, (GuildMsgItemLayout)paramView);
  }
  
  public boolean a(BaseGuildMsgViewBuild.ViewHolder paramViewHolder)
  {
    return paramViewHolder instanceof GuildArkAppItemBuilder.Holder;
  }
  
  protected boolean b(View paramView)
  {
    return super.b(paramView);
  }
  
  protected String b_(ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null) {
      return "";
    }
    MessageForArkApp localMessageForArkApp = (MessageForArkApp)paramChatMessage;
    if (localMessageForArkApp.ark_app_message != null)
    {
      if (localMessageForArkApp.ark_app_message.promptText == null) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      if (MessageRecordInfo.b(paramChatMessage.issend)) {
        localStringBuilder.append("发出");
      } else {
        localStringBuilder.append("发来");
      }
      localStringBuilder.append(localMessageForArkApp.ark_app_message.promptText);
      if (localMessageForArkApp.arkContainer != null)
      {
        paramChatMessage = localMessageForArkApp.arkContainer.i;
        if (!TextUtils.isEmpty(paramChatMessage)) {
          localStringBuilder.append(paramChatMessage);
        }
      }
      return localStringBuilder.toString();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.GuildArkAppItemBuilder
 * JD-Core Version:    0.7.0.1
 */