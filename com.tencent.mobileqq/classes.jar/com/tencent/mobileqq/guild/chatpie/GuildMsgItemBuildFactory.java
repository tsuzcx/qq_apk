package com.tencent.mobileqq.guild.chatpie;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.util.ArrayMap;
import android.util.SparseArray;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopUnreadTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.BaseGuildMsgViewBuild;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.msgtypesupplier.GuildArkAppTypeSupplier;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.msgtypesupplier.GuildMessageTypeSupplier;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.msgtypesupplier.GuildMixedTypeSupplier;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.msgtypesupplier.GuildVideoTypeSupplier;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.supplier.GuildArkAppSupplier;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.supplier.GuildFileTypeSupplier;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.supplier.GuildImageFileSupplier;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.supplier.GuildItemBuilderSupplier;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.supplier.GuildLongVideoSupplier;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.supplier.GuildMarketFaceSupplier;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.supplier.GuildMixedSuppplier;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.supplier.GuildPicSupplier;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.supplier.GuildQWalletSupplier;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.supplier.GuildReplyTextSupplier;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.supplier.GuildShortVideoSupplier;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.supplier.GuildSimpleFileSupplier;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.supplier.GuildStructTypeSupplier;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.supplier.GuildTextSupplier;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.supplier.GuildUnreadTipsSupplier;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.supplier.GuildVideoFileSupplier;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.supplier.GuildWelcomeSupplier;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GuildMsgItemBuildFactory
{
  public static final int a;
  public static final int b;
  public static final int c;
  public static final int d;
  public static final int e;
  public static final int f;
  public static final int g;
  public static final int h;
  public static final int i;
  public static final int j;
  public static final int k;
  public static final int l;
  public static final int m;
  public static final int n;
  public static final int o;
  public static final int p;
  public static final int q;
  private static int v = -1;
  private static final ArrayMap<Class<? extends MessageRecord>, Integer> y;
  private static final ArrayMap<Class<? extends ChatMessage>, GuildMessageTypeSupplier> z;
  private final SparseArray<GuildItemBuilderSupplier<ChatItemBuilder>> A = new SparseArray();
  protected Context r;
  protected QQAppInterface s;
  protected SessionInfo t;
  protected AIOAnimationConatiner u;
  private final BaseChatPie w;
  private final Set<ChatItemBuilder> x;
  
  static
  {
    int i1 = v;
    v = i1 + 1;
    a = i1;
    i1 = v;
    v = i1 + 1;
    b = i1;
    i1 = v;
    v = i1 + 1;
    c = i1;
    i1 = v;
    v = i1 + 1;
    d = i1;
    i1 = v;
    v = i1 + 1;
    e = i1;
    i1 = v;
    v = i1 + 1;
    f = i1;
    i1 = v;
    v = i1 + 1;
    g = i1;
    i1 = v;
    v = i1 + 1;
    h = i1;
    i1 = v;
    v = i1 + 1;
    i = i1;
    i1 = v;
    v = i1 + 1;
    j = i1;
    i1 = v;
    v = i1 + 1;
    k = i1;
    i1 = v;
    v = i1 + 1;
    l = i1;
    i1 = v;
    v = i1 + 1;
    m = i1;
    i1 = v;
    v = i1 + 1;
    n = i1;
    i1 = v;
    v = i1 + 1;
    o = i1;
    i1 = v;
    v = i1 + 1;
    p = i1;
    i1 = v;
    v = i1 + 1;
    q = i1;
    y = new ArrayMap();
    y.put(MessageForText.class, Integer.valueOf(b));
    y.put(MessageForPic.class, Integer.valueOf(c));
    y.put(MessageForMarketFace.class, Integer.valueOf(i));
    y.put(((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).getMessageRecordForGuildWelcomeClazz(), Integer.valueOf(d));
    y.put(MessageForTroopUnreadTips.class, Integer.valueOf(k));
    y.put(MessageForReplyText.class, Integer.valueOf(l));
    y.put(MessageForQQWalletMsg.class, Integer.valueOf(p));
    z = new ArrayMap();
    z.put(MessageForMixedMsg.class, new GuildMixedTypeSupplier());
    z.put(MessageForArkApp.class, new GuildArkAppTypeSupplier());
    z.put(MessageForShortVideo.class, new GuildVideoTypeSupplier());
    z.put(MessageForFile.class, new GuildFileTypeSupplier());
  }
  
  public GuildMsgItemBuildFactory(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    this.A.put(b, new GuildTextSupplier());
    this.A.put(c, new GuildPicSupplier());
    this.A.put(d, new GuildWelcomeSupplier());
    this.A.put(e, new GuildLongVideoSupplier());
    this.A.put(f, new GuildShortVideoSupplier());
    this.A.put(g, new GuildStructTypeSupplier());
    this.A.put(h, new GuildMixedSuppplier());
    this.A.put(i, new GuildMarketFaceSupplier());
    this.A.put(j, new GuildArkAppSupplier());
    this.A.put(k, new GuildUnreadTipsSupplier());
    this.A.put(l, new GuildReplyTextSupplier());
    this.A.put(m, new GuildSimpleFileSupplier());
    this.A.put(n, new GuildImageFileSupplier());
    this.A.put(o, new GuildVideoFileSupplier());
    this.A.put(p, new GuildQWalletSupplier());
    this.r = paramContext;
    this.s = paramQQAppInterface;
    this.t = paramSessionInfo;
    this.u = paramAIOAnimationConatiner;
    this.w = paramBaseChatPie;
    this.x = new HashSet();
    int i2 = this.A.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((GuildItemBuilderSupplier)this.A.valueAt(i1)).a(paramContext, paramQQAppInterface, paramSessionInfo, paramBaseChatPie, paramAIOAnimationConatiner);
      i1 += 1;
    }
  }
  
  public static int a(QQAppInterface paramQQAppInterface, @Nullable ChatMessage paramChatMessage)
  {
    if (paramChatMessage == null)
    {
      QLog.e("GuildMsgItemBuildFactory", 1, "message is null");
      return a;
    }
    if (z.containsKey(paramChatMessage.getClass()))
    {
      int i1 = ((GuildMessageTypeSupplier)z.get(paramChatMessage.getClass())).a(paramQQAppInterface, paramChatMessage);
      if (i1 != a) {
        return i1;
      }
    }
    if (y.containsKey(paramChatMessage.getClass())) {
      return ((Integer)y.get(paramChatMessage.getClass())).intValue();
    }
    paramQQAppInterface = new StringBuilder();
    paramQQAppInterface.append("getMessageType: unknown messageType:");
    paramQQAppInterface.append(paramChatMessage.msgtype);
    QLog.e("GuildMsgItemBuildFactory", 1, paramQQAppInterface.toString());
    return a;
  }
  
  protected ChatItemBuilder a(ChatItemBuilder paramChatItemBuilder, BaseAdapter paramBaseAdapter)
  {
    if (((paramChatItemBuilder instanceof BaseGuildMsgViewBuild)) && ((paramBaseAdapter instanceof GuildPieAdapter)))
    {
      paramBaseAdapter = (GuildPieAdapter)paramBaseAdapter;
      ((BaseGuildMsgViewBuild)paramChatItemBuilder).a(paramBaseAdapter.i);
    }
    this.x.add(paramChatItemBuilder);
    return paramChatItemBuilder;
  }
  
  public ChatItemBuilder a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    int i2 = a(this.s, paramChatMessage);
    int i1 = i2;
    if (i2 == a)
    {
      i1 = b;
      QLog.e("GuildMsgItemBuildFactory", 1, "findItemBuilder messageType: unknown");
    }
    if (this.A.get(i1) != null)
    {
      GuildItemBuilderSupplier localGuildItemBuilderSupplier = (GuildItemBuilderSupplier)this.A.get(i1);
      paramChatMessage = localGuildItemBuilderSupplier.b(paramChatMessage, paramBaseAdapter);
      if (localGuildItemBuilderSupplier.a())
      {
        a(paramChatMessage, paramBaseAdapter);
        return paramChatMessage;
      }
      this.x.add(paramChatMessage);
      return paramChatMessage;
    }
    return ((GuildItemBuilderSupplier)this.A.get(b)).b(paramChatMessage, paramBaseAdapter);
  }
  
  public void a()
  {
    Iterator localIterator = this.x.iterator();
    while (localIterator.hasNext()) {
      ((ChatItemBuilder)localIterator.next()).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.GuildMsgItemBuildFactory
 * JD-Core Version:    0.7.0.1
 */