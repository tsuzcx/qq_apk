package com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import android.text.util.Linkify;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.TouchDelegate;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.Callback;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.FileTransferManager;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.BaseBubbleBuilderMenuProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.BaseBubbleBuilderMenuProcessorImpl;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuAddProcessor;
import com.tencent.mobileqq.activity.aio.coreui.msglist.menu.IBaseBubbleBuilderMenuClickProcessor;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.mobileqq.guild.chatpie.GuildMsgItemBuildFactory;
import com.tencent.mobileqq.guild.chatpie.GuildPieAdapter;
import com.tencent.mobileqq.guild.chatpie.Util.GuildNameUtil;
import com.tencent.mobileqq.guild.chatpie.menu.GuildBuilderMenuProcessorImpl;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildLiveChannelMsgItemLayout;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildMsgItemLayout;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildNickLayoutProcessor;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.IGuildNickLayoutProcessor;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.nickitem.AbsGuildNickLayoutItem.Data;
import com.tencent.mobileqq.guild.data.profilecard.GuildBaseProfileData;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.guild.util.GuildProfileUtils;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.troop.quickat.ui.AtTag;
import com.tencent.mobileqq.troop.quickat.ui.AtUtil;
import com.tencent.mobileqq.troop.text.GuildAtTroopMemberSpan;
import com.tencent.mobileqq.util.SystemDragUtils;
import com.tencent.mobileqq.util.SystemDragUtils.DragTouchDelegate;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import com.tencent.mobileqq.utils.dialogutils.QQCustomMenuItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;

public abstract class BaseGuildMsgViewBuild
  extends ChatItemBuilder
  implements View.OnClickListener, View.OnLongClickListener
{
  public static ColorFilter j = new PorterDuffColorFilter(637534208, PorterDuff.Mode.SRC_ATOP);
  public static CompoundButton.OnCheckedChangeListener k = new BaseGuildMsgViewBuild.1();
  private final BaseBubbleBuilderMenuProcessor a;
  protected Context b;
  protected SessionInfo c;
  protected AIOAnimationConatiner d;
  protected float e;
  protected BaseAdapter f;
  protected QQAppInterface g;
  protected ViewGroup h;
  protected IFaceDecoder i;
  private boolean l;
  
  public BaseGuildMsgViewBuild(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner)
  {
    this.g = paramQQAppInterface;
    this.f = paramBaseAdapter;
    this.b = paramContext;
    this.c = paramSessionInfo;
    this.d = paramAIOAnimationConatiner;
    this.e = paramContext.getResources().getDisplayMetrics().density;
    this.a = new GuildBuilderMenuProcessorImpl(paramQQAppInterface, this.c);
  }
  
  private void a(ChatMessage paramChatMessage, Context paramContext, Exception paramException)
  {
    if ((paramContext != null) && ((paramContext instanceof Activity))) {
      paramContext = paramContext.getClass().getName();
    } else {
      paramContext = "";
    }
    paramException = new StringBuilder();
    paramException.append(paramContext);
    paramException.append(" BaseGuildMsgViewBuild CatchException ");
    paramException.append(paramChatMessage.msgtype);
    QLog.e("BaseGuildMsgViewBuild", 1, paramException.toString());
  }
  
  private void a(ChatMessage paramChatMessage, GuildMsgItemLayout paramGuildMsgItemLayout, BaseGuildMsgViewBuild.ViewHolder paramViewHolder)
  {
    if (AppSetting.e)
    {
      if (paramViewHolder.r == null) {
        paramViewHolder.r = new StringBuilder();
      }
      paramViewHolder.r.append(b_(paramChatMessage));
      paramChatMessage = Spannable.Factory.getInstance().newSpannable(paramViewHolder.r.toString());
      if (Linkify.addLinks(paramChatMessage, 15)) {
        paramGuildMsgItemLayout.setContentDescription(paramChatMessage);
      } else {
        paramGuildMsgItemLayout.setContentDescription(paramViewHolder.r.toString());
      }
      paramGuildMsgItemLayout.setHeadIconContentDescription("");
      paramGuildMsgItemLayout.setFocusable(true);
    }
  }
  
  private boolean a(String paramString)
  {
    return "3161".equals(paramString);
  }
  
  private GuildMsgItemLayout c()
  {
    if (d()) {
      return new GuildLiveChannelMsgItemLayout(this.g, this.b);
    }
    return new GuildMsgItemLayout(this.g, this.b);
  }
  
  private void d(ChatMessage paramChatMessage, GuildMsgItemLayout paramGuildMsgItemLayout)
  {
    paramGuildMsgItemLayout.b(paramChatMessage);
  }
  
  private void g(View paramView)
  {
    if (b(paramView)) {}
  }
  
  private void h(View paramView)
  {
    if (e(paramView)) {
      return;
    }
    l(paramView);
  }
  
  private void h(GuildMsgItemLayout paramGuildMsgItemLayout, ChatMessage paramChatMessage)
  {
    if ((paramGuildMsgItemLayout instanceof GuildLiveChannelMsgItemLayout)) {
      ((GuildLiveChannelMsgItemLayout)paramGuildMsgItemLayout).a();
    }
  }
  
  private void i(View paramView)
  {
    if (f(paramView)) {
      return;
    }
    j(paramView);
  }
  
  private void j(View paramView)
  {
    Object localObject1 = this.b;
    if (localObject1 != null)
    {
      localObject1 = ((BaseActivity)localObject1).getChatFragment();
      if (localObject1 != null)
      {
        localObject1 = (GuildChatContext)((ChatFragment)localObject1).k().bv();
        break label45;
      }
    }
    localObject1 = null;
    label45:
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = (BaseGuildMsgViewBuild.ViewHolder)AIOUtils.b(paramView);
    if ((localObject2 != null) && ((paramView.getContext() instanceof Activity)))
    {
      paramView = ((BaseGuildMsgViewBuild.ViewHolder)localObject2).q;
      localObject2 = paramView.getExtInfoFromExtStr("GUILD_ID");
      String str = paramView.senderuin;
      localObject2 = GuildNameUtil.a(this.g, (String)localObject2, str);
      paramView = GuildAtTroopMemberSpan.a(this.g, ((GuildChatContext)localObject1).b(), ((GuildChatContext)localObject1).O().b, paramView.senderuin, (String)localObject2, (String)localObject2, ((GuildChatContext)localObject1).Q(), ((GuildChatContext)localObject1).X());
      if (TextUtils.isEmpty(paramView)) {
        return;
      }
      localObject2 = ((GuildChatContext)localObject1).Q().getEditableText();
      int i2 = ((GuildChatContext)localObject1).Q().getSelectionStart();
      int i3 = ((GuildChatContext)localObject1).Q().getText().toString().lastIndexOf("@", i2);
      int m;
      int n;
      if ((i3 != -1) && (AtUtil.c(((GuildChatContext)localObject1).Q()) < i3))
      {
        m = i3;
        n = 1;
      }
      else
      {
        m = i2;
        n = 0;
      }
      int i1 = m;
      if (m < 0) {
        i1 = 0;
      }
      localObject1 = new AtTag(i1, paramView);
      if (n != 0) {
        ((Editable)localObject2).delete(i3, i2);
      }
      ((Editable)localObject2).insert(i1, paramView);
      if (QLog.isColorLevel()) {
        QLog.d("BaseGuildMsgViewBuild", 2, new Object[] { "insertAtSpan: invoked. ", " atTag: ", localObject1, " editableText: ", localObject2 });
      }
      return;
    }
    QLog.e("BaseGuildMsgViewBuild", 1, "onHeadIconClick error");
  }
  
  private void k(View paramView)
  {
    if (d(paramView)) {
      return;
    }
    l(paramView);
  }
  
  private void l(View paramView)
  {
    Object localObject2 = (BaseGuildMsgViewBuild.ViewHolder)AIOUtils.b(paramView);
    if ((localObject2 != null) && ((paramView.getContext() instanceof Activity)))
    {
      Object localObject1 = (IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class);
      if ((((BaseGuildMsgViewBuild.ViewHolder)localObject2).q != null) && (((IGuildMessageUtilsApi)localObject1).isGuest(((BaseGuildMsgViewBuild.ViewHolder)localObject2).q.frienduin)))
      {
        QQToast.makeText(paramView.getContext(), 0, paramView.getContext().getString(2131896466), 1).show();
        return;
      }
      localObject1 = ((BaseGuildMsgViewBuild.ViewHolder)localObject2).q;
      if (localObject1 != null)
      {
        if (TextUtils.isEmpty(((MessageRecord)localObject1).senderuin)) {
          return;
        }
        if (d()) {
          localObject1 = new GuildProfileData(((MessageRecord)localObject1).getExtInfoFromExtStr("GUILD_ID"), ((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).senderuin, 2, 2);
        } else {
          localObject1 = new GuildProfileData("", ((MessageRecord)localObject1).frienduin, ((MessageRecord)localObject1).senderuin, 0, 2);
        }
        if (a(((BaseGuildMsgViewBuild.ViewHolder)localObject2).q.getExtInfoFromExtStr("GUILD_MSG_FROME_APPID"))) {
          ((GuildProfileData)localObject1).getGuildBaseProfileData().a(true);
        }
        localObject2 = this.f;
        if ((localObject2 instanceof GuildPieAdapter))
        {
          localObject2 = (GuildPieAdapter)localObject2;
          ((GuildProfileData)localObject1).getGuildBaseProfileData().d(((GuildPieAdapter)localObject2).h());
        }
        GuildProfileUtils.a((Activity)paramView.getContext(), (GuildProfileData)localObject1);
      }
      return;
    }
    QLog.e("BaseGuildMsgViewBuild", 1, "onHeadIconClick error");
  }
  
  /* Error */
  public View a(int paramInt1, int paramInt2, ChatMessage paramChatMessage, View paramView, ViewGroup paramViewGroup, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    // Byte code:
    //   0: invokestatic 345	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +74 -> 77
    //   6: new 113	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   13: astore 8
    //   15: aload 8
    //   17: ldc_w 426
    //   20: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: pop
    //   24: aload 8
    //   26: iload_1
    //   27: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: pop
    //   31: aload 8
    //   33: ldc_w 428
    //   36: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 8
    //   42: iload_2
    //   43: invokevirtual 129	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 8
    //   49: ldc_w 430
    //   52: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: aload 8
    //   58: aload_3
    //   59: invokevirtual 431	com/tencent/mobileqq/data/ChatMessage:toString	()Ljava/lang/String;
    //   62: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: ldc 131
    //   68: iconst_2
    //   69: aload 8
    //   71: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 433	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_0
    //   78: aload 5
    //   80: putfield 435	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild:h	Landroid/view/ViewGroup;
    //   83: aload 5
    //   85: invokevirtual 438	android/view/ViewGroup:getContext	()Landroid/content/Context;
    //   88: astore 11
    //   90: getstatic 144	com/tencent/common/config/AppSetting:e	Z
    //   93: istore 7
    //   95: aload 4
    //   97: ifnonnull +64 -> 161
    //   100: invokestatic 345	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   103: ifeq +12 -> 115
    //   106: ldc 131
    //   108: iconst_2
    //   109: ldc_w 440
    //   112: invokestatic 433	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   115: aload_0
    //   116: invokevirtual 442	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild:e	()V
    //   119: aload_0
    //   120: invokespecial 444	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild:c	()Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/baseview/GuildMsgItemLayout;
    //   123: astore 4
    //   125: aload 4
    //   127: ldc_w 445
    //   130: invokevirtual 449	com/tencent/mobileqq/guild/chatpie/msgviewbuild/baseview/GuildMsgItemLayout:setId	(I)V
    //   133: aload 4
    //   135: iconst_1
    //   136: invokevirtual 452	com/tencent/mobileqq/guild/chatpie/msgviewbuild/baseview/GuildMsgItemLayout:setFocusableInTouchMode	(Z)V
    //   139: aload_0
    //   140: invokevirtual 455	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild:a	()Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild$ViewHolder;
    //   143: astore 5
    //   145: aload 4
    //   147: aload 5
    //   149: invokevirtual 459	com/tencent/mobileqq/guild/chatpie/msgviewbuild/baseview/GuildMsgItemLayout:setTag	(Ljava/lang/Object;)V
    //   152: aload_0
    //   153: aload 4
    //   155: invokevirtual 462	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild:b	(Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/baseview/GuildMsgItemLayout;)V
    //   158: goto +199 -> 357
    //   161: invokestatic 345	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   164: ifeq +12 -> 176
    //   167: ldc 131
    //   169: iconst_2
    //   170: ldc_w 464
    //   173: invokestatic 433	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: aconst_null
    //   177: astore 5
    //   179: aload 4
    //   181: checkcast 172	com/tencent/mobileqq/guild/chatpie/msgviewbuild/baseview/GuildMsgItemLayout
    //   184: astore 9
    //   186: aload 5
    //   188: astore 4
    //   190: aload 9
    //   192: invokevirtual 468	com/tencent/mobileqq/guild/chatpie/msgviewbuild/baseview/GuildMsgItemLayout:getTag	()Ljava/lang/Object;
    //   195: checkcast 146	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild$ViewHolder
    //   198: astore 10
    //   200: aload_0
    //   201: aload 10
    //   203: invokevirtual 471	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild:a	(Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild$ViewHolder;)Z
    //   206: ifne +386 -> 592
    //   209: new 113	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   216: astore 4
    //   218: aload 4
    //   220: ldc_w 473
    //   223: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: aload 4
    //   229: aload 10
    //   231: invokevirtual 476	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: aload 4
    //   237: ldc_w 478
    //   240: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: aload 4
    //   246: aload_0
    //   247: invokevirtual 476	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: ldc 131
    //   253: iconst_1
    //   254: aload 4
    //   256: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 139	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   262: aload_0
    //   263: invokevirtual 455	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild:a	()Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild$ViewHolder;
    //   266: astore 5
    //   268: aload 5
    //   270: astore 4
    //   272: aload 9
    //   274: aload 5
    //   276: invokevirtual 459	com/tencent/mobileqq/guild/chatpie/msgviewbuild/baseview/GuildMsgItemLayout:setTag	(Ljava/lang/Object;)V
    //   279: goto +3 -> 282
    //   282: aload 5
    //   284: astore 4
    //   286: aload_0
    //   287: aload 9
    //   289: aload 5
    //   291: invokevirtual 481	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild:a	(Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/baseview/GuildMsgItemLayout;Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild$ViewHolder;)V
    //   294: aload 5
    //   296: astore 4
    //   298: aload 9
    //   300: astore 5
    //   302: goto +43 -> 345
    //   305: astore 8
    //   307: aload 9
    //   309: astore 5
    //   311: aload 10
    //   313: astore 4
    //   315: goto +21 -> 336
    //   318: astore 8
    //   320: aload 9
    //   322: astore 5
    //   324: goto +12 -> 336
    //   327: astore 8
    //   329: aconst_null
    //   330: astore 5
    //   332: aload 5
    //   334: astore 4
    //   336: aload_0
    //   337: aload_3
    //   338: aload 11
    //   340: aload 8
    //   342: invokespecial 483	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild:a	(Lcom/tencent/mobileqq/data/ChatMessage;Landroid/content/Context;Ljava/lang/Exception;)V
    //   345: aload 5
    //   347: astore 8
    //   349: aload 4
    //   351: astore 5
    //   353: aload 8
    //   355: astore 4
    //   357: aload 5
    //   359: iload_1
    //   360: putfield 485	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild$ViewHolder:l	I
    //   363: aload 5
    //   365: iload_2
    //   366: putfield 488	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild$ViewHolder:m	I
    //   369: aload 5
    //   371: aload_3
    //   372: putfield 256	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild$ViewHolder:q	Lcom/tencent/mobileqq/data/ChatMessage;
    //   375: aload 5
    //   377: aload 4
    //   379: putfield 491	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild$ViewHolder:k	Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/baseview/GuildMsgItemLayout;
    //   382: invokestatic 345	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   385: ifeq +61 -> 446
    //   388: new 113	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 114	java/lang/StringBuilder:<init>	()V
    //   395: astore 8
    //   397: aload 8
    //   399: ldc_w 493
    //   402: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload 8
    //   408: aload_3
    //   409: invokevirtual 496	com/tencent/mobileqq/data/ChatMessage:isNeedCombine	()Z
    //   412: invokevirtual 499	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: aload 8
    //   418: ldc_w 501
    //   421: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: pop
    //   425: aload 8
    //   427: aload_3
    //   428: invokevirtual 504	com/tencent/mobileqq/data/ChatMessage:isSend	()Z
    //   431: invokevirtual 499	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: ldc 131
    //   437: iconst_2
    //   438: aload 8
    //   440: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokestatic 433	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   446: aload_0
    //   447: aload 4
    //   449: invokevirtual 506	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild:a	(Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/baseview/GuildMsgItemLayout;)V
    //   452: aload_0
    //   453: aload 4
    //   455: aload_3
    //   456: invokevirtual 508	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild:b	(Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/baseview/GuildMsgItemLayout;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   459: aload_0
    //   460: aload 4
    //   462: aload_3
    //   463: invokevirtual 510	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild:a	(Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/baseview/GuildMsgItemLayout;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   466: aload_0
    //   467: aload 4
    //   469: aload_3
    //   470: invokevirtual 512	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild:d	(Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/baseview/GuildMsgItemLayout;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   473: aload_0
    //   474: aload 4
    //   476: aload_3
    //   477: invokevirtual 514	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild:c	(Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/baseview/GuildMsgItemLayout;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   480: aload_0
    //   481: aload 4
    //   483: aload_3
    //   484: invokevirtual 516	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild:e	(Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/baseview/GuildMsgItemLayout;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   487: aload_0
    //   488: aload_3
    //   489: aload 4
    //   491: invokespecial 518	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild:d	(Lcom/tencent/mobileqq/data/ChatMessage;Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/baseview/GuildMsgItemLayout;)V
    //   494: aload_0
    //   495: aload_3
    //   496: aload 5
    //   498: aload 5
    //   500: getfield 521	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild$ViewHolder:j	Landroid/view/View;
    //   503: aload 4
    //   505: aload 6
    //   507: invokevirtual 524	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild:b	(Lcom/tencent/mobileqq/data/ChatMessage;Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild$ViewHolder;Landroid/view/View;Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/baseview/GuildMsgItemLayout;Lcom/tencent/mobileqq/activity/aio/OnLongClickAndTouchListener;)Landroid/view/View;
    //   510: astore 6
    //   512: aload 4
    //   514: aload_0
    //   515: aload 5
    //   517: aload 6
    //   519: aload 4
    //   521: invokevirtual 527	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild:a	(Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild$ViewHolder;Landroid/view/View;Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/baseview/GuildMsgItemLayout;)Landroid/widget/RelativeLayout$LayoutParams;
    //   524: invokevirtual 531	com/tencent/mobileqq/guild/chatpie/msgviewbuild/baseview/GuildMsgItemLayout:setProgressAndFailParams	(Landroid/widget/RelativeLayout$LayoutParams;)V
    //   527: aload_0
    //   528: aload_3
    //   529: aload 4
    //   531: invokevirtual 533	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild:a	(Lcom/tencent/mobileqq/data/ChatMessage;Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/baseview/GuildMsgItemLayout;)V
    //   534: aload_0
    //   535: aload 4
    //   537: aload_3
    //   538: invokespecial 535	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild:h	(Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/baseview/GuildMsgItemLayout;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   541: aload_0
    //   542: aload 4
    //   544: aload_3
    //   545: invokevirtual 537	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild:f	(Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/baseview/GuildMsgItemLayout;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   548: aload_0
    //   549: aload 4
    //   551: aload_3
    //   552: invokevirtual 539	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild:g	(Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/baseview/GuildMsgItemLayout;Lcom/tencent/mobileqq/data/ChatMessage;)V
    //   555: aload 5
    //   557: aload 6
    //   559: putfield 521	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild$ViewHolder:j	Landroid/view/View;
    //   562: aload_0
    //   563: aload_3
    //   564: aload 11
    //   566: aload 4
    //   568: aload 5
    //   570: iload 7
    //   572: invokevirtual 542	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild:a	(Lcom/tencent/mobileqq/data/ChatMessage;Landroid/content/Context;Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/baseview/GuildMsgItemLayout;Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild$ViewHolder;Z)V
    //   575: aload_0
    //   576: aload_3
    //   577: aload 4
    //   579: aload 5
    //   581: invokespecial 544	com/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild:a	(Lcom/tencent/mobileqq/data/ChatMessage;Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/baseview/GuildMsgItemLayout;Lcom/tencent/mobileqq/guild/chatpie/msgviewbuild/builder/BaseGuildMsgViewBuild$ViewHolder;)V
    //   584: aload 4
    //   586: invokevirtual 547	com/tencent/mobileqq/guild/chatpie/msgviewbuild/baseview/GuildMsgItemLayout:requestLayout	()V
    //   589: aload 4
    //   591: areturn
    //   592: aload 10
    //   594: astore 5
    //   596: goto -314 -> 282
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	599	0	this	BaseGuildMsgViewBuild
    //   0	599	1	paramInt1	int
    //   0	599	2	paramInt2	int
    //   0	599	3	paramChatMessage	ChatMessage
    //   0	599	4	paramView	View
    //   0	599	5	paramViewGroup	ViewGroup
    //   0	599	6	paramOnLongClickAndTouchListener	OnLongClickAndTouchListener
    //   93	478	7	bool	boolean
    //   13	57	8	localStringBuilder	StringBuilder
    //   305	1	8	localException1	Exception
    //   318	1	8	localException2	Exception
    //   327	14	8	localException3	Exception
    //   347	92	8	localObject	Object
    //   184	137	9	localGuildMsgItemLayout	GuildMsgItemLayout
    //   198	395	10	localViewHolder	BaseGuildMsgViewBuild.ViewHolder
    //   88	477	11	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   200	268	305	java/lang/Exception
    //   190	200	318	java/lang/Exception
    //   272	279	318	java/lang/Exception
    //   286	294	318	java/lang/Exception
    //   179	186	327	java/lang/Exception
  }
  
  @NonNull
  protected abstract View a(ChatMessage paramChatMessage, BaseGuildMsgViewBuild.ViewHolder paramViewHolder, View paramView, GuildMsgItemLayout paramGuildMsgItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener);
  
  protected RelativeLayout.LayoutParams a(BaseGuildMsgViewBuild.ViewHolder paramViewHolder, View paramView, GuildMsgItemLayout paramGuildMsgItemLayout)
  {
    int m = AIOUtils.b(16.0F, this.b.getResources());
    paramViewHolder = new RelativeLayout.LayoutParams(m, m);
    paramViewHolder.addRule(5, 2131430578);
    paramViewHolder.addRule(3, 2131430578);
    paramViewHolder.bottomMargin = AIOUtils.b(8.666666F, this.b.getResources());
    return paramViewHolder;
  }
  
  protected abstract BaseGuildMsgViewBuild.ViewHolder a();
  
  public QQCustomMenu a(QQCustomMenu paramQQCustomMenu, ChatMessage paramChatMessage)
  {
    return paramQQCustomMenu;
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    if (!b(paramInt, paramContext, paramChatMessage))
    {
      paramContext = BaseBubbleBuilderMenuProcessorImpl.a(this.a);
      if (paramContext != null) {
        paramContext.a(paramInt, this.b, paramChatMessage);
      }
    }
  }
  
  public void a(View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    if (SystemDragUtils.a(false))
    {
      SystemDragUtils.DragTouchDelegate localDragTouchDelegate = new SystemDragUtils.DragTouchDelegate();
      SystemDragUtils.a(this.b, localDragTouchDelegate, paramOnLongClickAndTouchListener);
      paramView.setOnTouchListener(localDragTouchDelegate);
      paramView.setOnLongClickListener(localDragTouchDelegate);
      return;
    }
    paramView.setOnTouchListener(paramOnLongClickAndTouchListener);
    paramView.setOnLongClickListener(paramOnLongClickAndTouchListener);
  }
  
  public void a(View paramView, ChatMessage paramChatMessage, int paramInt)
  {
    if ((paramInt == 10001) && (paramView != null))
    {
      paramView = (IGuildNickLayoutProcessor)((GuildMsgItemLayout)paramView).a(IGuildNickLayoutProcessor.class);
      if (paramView != null) {
        paramView.a(new AbsGuildNickLayoutItem.Data(GuildNickLayoutProcessor.b, paramChatMessage));
      }
    }
    else if ((paramInt == 10002) && (paramView != null))
    {
      paramView = (IGuildNickLayoutProcessor)((GuildMsgItemLayout)paramView).a(IGuildNickLayoutProcessor.class);
      if (paramView != null) {
        paramView.a(new AbsGuildNickLayoutItem.Data(GuildNickLayoutProcessor.d, paramChatMessage));
      }
    }
  }
  
  public void a(IFaceDecoder paramIFaceDecoder)
  {
    this.i = paramIFaceDecoder;
  }
  
  protected void a(ChatMessage paramChatMessage, Context paramContext, GuildMsgItemLayout paramGuildMsgItemLayout, BaseGuildMsgViewBuild.ViewHolder paramViewHolder, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramGuildMsgItemLayout.setContentDescription(null);
      paramViewHolder.r = new StringBuilder();
      if (paramChatMessage.time <= 0L) {}
    }
    try
    {
      paramChatMessage = TimeFormatterUtils.a(paramContext, 3, paramChatMessage.time * 1000L);
    }
    catch (Exception paramChatMessage)
    {
      label48:
      break label48;
    }
    paramChatMessage = "";
    paramContext = paramViewHolder.r;
    paramContext.append(" ");
    paramContext.append(paramChatMessage);
    paramContext.append(" ");
    paramContext.append(paramGuildMsgItemLayout.getNickNameString());
    paramContext.append(" ");
  }
  
  protected void a(ChatMessage paramChatMessage, GuildMsgItemLayout paramGuildMsgItemLayout)
  {
    if (c(paramChatMessage, paramGuildMsgItemLayout))
    {
      paramGuildMsgItemLayout.setProgressVisable(false);
      return;
    }
    b(paramChatMessage, paramGuildMsgItemLayout);
  }
  
  public void a(MessageRecord paramMessageRecord, View paramView, Callback paramCallback)
  {
    if ((paramMessageRecord.extraflag != 32772) || (!((IOrderMediaMsgService)this.g.getRuntimeService(IOrderMediaMsgService.class)).addCallback(this.c.b, paramMessageRecord.uniseq, paramView, paramCallback)))
    {
      paramMessageRecord = FileTransferManager.a(this.g);
      if (paramMessageRecord != null) {
        paramMessageRecord.a(paramView, paramCallback);
      }
    }
  }
  
  protected void a(GuildMsgItemLayout paramGuildMsgItemLayout)
  {
    paramGuildMsgItemLayout.setPadding(0, 0, 0, 0);
  }
  
  protected void a(GuildMsgItemLayout paramGuildMsgItemLayout, ChatMessage paramChatMessage)
  {
    paramGuildMsgItemLayout.setFlushView(paramChatMessage);
  }
  
  protected void a(GuildMsgItemLayout paramGuildMsgItemLayout, BaseGuildMsgViewBuild.ViewHolder paramViewHolder)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseGuildMsgViewBuild", 2, "postReuseChatLayout");
    }
  }
  
  protected void a(QQCustomMenu paramQQCustomMenu, Context paramContext, int paramInt, ChatMessage paramChatMessage, Bundle paramBundle)
  {
    IBaseBubbleBuilderMenuAddProcessor localIBaseBubbleBuilderMenuAddProcessor = BaseBubbleBuilderMenuProcessorImpl.b(this.a);
    if (localIBaseBubbleBuilderMenuAddProcessor != null) {
      localIBaseBubbleBuilderMenuAddProcessor.a(paramQQCustomMenu, paramContext, paramInt, paramChatMessage, paramBundle);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  protected boolean a(ChatMessage paramChatMessage)
  {
    return (paramChatMessage.extraflag == 32768) && (paramChatMessage.isSendFromLocal());
  }
  
  public boolean a(BaseGuildMsgViewBuild.ViewHolder paramViewHolder)
  {
    return paramViewHolder != null;
  }
  
  public QQCustomMenuItem[] a(View paramView)
  {
    QQCustomMenu localQQCustomMenu2 = new QQCustomMenu();
    BaseGuildMsgViewBuild.ViewHolder localViewHolder = (BaseGuildMsgViewBuild.ViewHolder)AIOUtils.b(paramView);
    QQCustomMenu localQQCustomMenu1 = localQQCustomMenu2;
    if (localViewHolder != null)
    {
      localQQCustomMenu1 = a(localQQCustomMenu2, localViewHolder.q);
      a(localQQCustomMenu1, paramView.getContext(), 2131439015, localViewHolder.q, null);
      a(localQQCustomMenu1, paramView.getContext(), 2131444634, localViewHolder.q, null);
      a(localQQCustomMenu1, paramView.getContext(), 2131438943, localViewHolder.q, null);
    }
    return localQQCustomMenu1.d();
  }
  
  protected View b(ChatMessage paramChatMessage, BaseGuildMsgViewBuild.ViewHolder paramViewHolder, View paramView, GuildMsgItemLayout paramGuildMsgItemLayout, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    paramViewHolder = a(paramChatMessage, paramViewHolder, paramView, paramGuildMsgItemLayout, paramOnLongClickAndTouchListener);
    paramGuildMsgItemLayout.setContentView(paramViewHolder, paramChatMessage.isNeedCombine(), GuildMsgItemBuildFactory.a(this.g, paramChatMessage));
    return paramViewHolder;
  }
  
  public void b() {}
  
  protected void b(ChatMessage paramChatMessage, GuildMsgItemLayout paramGuildMsgItemLayout)
  {
    paramGuildMsgItemLayout.setProgressVisable(this.g.getMsgCache().g(paramChatMessage));
  }
  
  protected void b(GuildMsgItemLayout paramGuildMsgItemLayout)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseGuildMsgViewBuild", 2, "postFinishNewChatLayout");
    }
  }
  
  protected void b(GuildMsgItemLayout paramGuildMsgItemLayout, ChatMessage paramChatMessage)
  {
    paramGuildMsgItemLayout.setAtView(this.b, paramChatMessage);
  }
  
  public boolean b(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    return false;
  }
  
  protected boolean b(View paramView)
  {
    return false;
  }
  
  protected abstract String b_(ChatMessage paramChatMessage);
  
  public BaseBubbleBuilder.TouchDelegate c(View paramView)
  {
    return null;
  }
  
  protected void c(GuildMsgItemLayout paramGuildMsgItemLayout, ChatMessage paramChatMessage)
  {
    if (paramChatMessage.isNeedCombine())
    {
      paramGuildMsgItemLayout.setHeadIconVisible(8);
      return;
    }
    String str;
    if (paramChatMessage.isSend()) {
      str = ((IGPSService)this.g.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
    } else {
      str = paramChatMessage.senderuin;
    }
    paramGuildMsgItemLayout.setHeadIcon(this.g, str, paramChatMessage, this);
    paramGuildMsgItemLayout.setIconLongClickListener(this);
  }
  
  protected boolean c(ChatMessage paramChatMessage, GuildMsgItemLayout paramGuildMsgItemLayout)
  {
    if (a(paramChatMessage))
    {
      paramGuildMsgItemLayout.setFailedIconVisable(true, this);
      return true;
    }
    paramGuildMsgItemLayout.setFailedIconVisable(false, null);
    return false;
  }
  
  protected void d(GuildMsgItemLayout paramGuildMsgItemLayout, ChatMessage paramChatMessage)
  {
    paramGuildMsgItemLayout.setSelCheckBox(paramChatMessage, k);
  }
  
  public boolean d()
  {
    return this.l;
  }
  
  protected boolean d(View paramView)
  {
    return false;
  }
  
  protected void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseGuildMsgViewBuild", 2, "postPreNewChatLayout");
    }
  }
  
  protected void e(GuildMsgItemLayout paramGuildMsgItemLayout, ChatMessage paramChatMessage)
  {
    IGuildNickLayoutProcessor localIGuildNickLayoutProcessor = (IGuildNickLayoutProcessor)paramGuildMsgItemLayout.a(IGuildNickLayoutProcessor.class);
    if (localIGuildNickLayoutProcessor == null) {
      return;
    }
    if (paramChatMessage.isNeedCombine())
    {
      localIGuildNickLayoutProcessor.a(8);
      return;
    }
    paramGuildMsgItemLayout.a(paramChatMessage, new -..Lambda.BaseGuildMsgViewBuild.KxkXzFSB8ahCIkpFo3dIcfFGzAk(this));
    localIGuildNickLayoutProcessor.a(0);
  }
  
  protected boolean e(View paramView)
  {
    return false;
  }
  
  public int f()
  {
    int n = -1;
    int m = n;
    try
    {
      if (this.b != null)
      {
        Object localObject = ((BaseActivity)this.b).getChatFragment();
        m = n;
        if (localObject != null)
        {
          localObject = ((ChatFragment)localObject).k();
          m = n;
          if (localObject != null) {
            m = ((BaseChatPie)localObject).bb();
          }
        }
      }
      return m;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  protected void f(GuildMsgItemLayout paramGuildMsgItemLayout, ChatMessage paramChatMessage)
  {
    paramGuildMsgItemLayout.setOtherWhenNeeded(this.b, paramGuildMsgItemLayout, paramChatMessage);
  }
  
  protected boolean f(View paramView)
  {
    return false;
  }
  
  public void g()
  {
    this.f.notifyDataSetChanged();
  }
  
  protected void g(GuildMsgItemLayout paramGuildMsgItemLayout, ChatMessage paramChatMessage)
  {
    paramGuildMsgItemLayout.setDtReport(paramChatMessage);
  }
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    if (m != 2131430585)
    {
      if (m != 2131430587)
      {
        if (m != 2131430595) {
          return;
        }
        k(paramView);
        return;
      }
      h(paramView);
      return;
    }
    g(paramView);
  }
  
  public boolean onLongClick(View paramView)
  {
    if (paramView.getId() == 2131430587) {
      i(paramView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.BaseGuildMsgViewBuild
 * JD-Core Version:    0.7.0.1
 */