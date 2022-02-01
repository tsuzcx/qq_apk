package com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.nickitem.AbsGuildNickLayoutItem;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.nickitem.AbsGuildNickLayoutItem.Data;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.nickitem.NickLayoutGameItem;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.nickitem.NickLayoutNickNameItem;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.nickitem.NickLayoutRobotItem;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.nickitem.NickLayoutTimeStampItem;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.builder.BaseGuildMsgViewBuild.ViewHolder;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class GuildNickLayoutProcessor
  implements IGuildNickLayoutProcessor
{
  public static int a;
  public static final int b;
  public static final int c;
  public static final int d;
  public static final int e;
  public static final int f = a;
  protected GuildMsgItemLayout g;
  protected Context h;
  protected AppRuntime i;
  protected HashMap<Integer, AbsGuildNickLayoutItem> j;
  private LinearLayout k;
  
  static
  {
    int m = a;
    a = m + 1;
    b = m;
    m = a;
    a = m + 1;
    c = m;
    m = a;
    a = m + 1;
    d = m;
    m = a;
    a = m + 1;
    e = m;
  }
  
  public GuildNickLayoutProcessor(AppRuntime paramAppRuntime, GuildMsgItemLayout paramGuildMsgItemLayout, Context paramContext)
  {
    this.g = paramGuildMsgItemLayout;
    this.h = paramContext;
    this.i = paramAppRuntime;
  }
  
  public void a()
  {
    this.j = new HashMap();
    this.j.put(Integer.valueOf(b), new NickLayoutNickNameItem(this.h, this.i));
    this.j.put(Integer.valueOf(c), new NickLayoutRobotItem(this.h, this.i));
    this.j.put(Integer.valueOf(d), new NickLayoutGameItem(this.h, this.i));
    this.j.put(Integer.valueOf(e), new NickLayoutTimeStampItem(this.h, this.i));
  }
  
  public void a(int paramInt)
  {
    LinearLayout localLinearLayout = this.k;
    if (localLinearLayout != null) {
      localLinearLayout.setVisibility(paramInt);
    }
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    LinearLayout localLinearLayout = this.k;
    if (localLinearLayout != null) {
      localLinearLayout.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    if ((this.k == null) || (this.j == null))
    {
      d();
      e();
    }
    int m = 0;
    while (m < f)
    {
      AbsGuildNickLayoutItem localAbsGuildNickLayoutItem = (AbsGuildNickLayoutItem)this.j.get(Integer.valueOf(m));
      if (localAbsGuildNickLayoutItem != null) {
        localAbsGuildNickLayoutItem.a(new AbsGuildNickLayoutItem.Data(paramChatMessage));
      }
      m += 1;
    }
  }
  
  public void a(@NonNull AbsGuildNickLayoutItem.Data paramData)
  {
    if (this.k != null)
    {
      Object localObject = this.j;
      if (localObject != null)
      {
        if (((HashMap)localObject).size() == 0) {
          return;
        }
        localObject = (AbsGuildNickLayoutItem)this.j.get(Integer.valueOf(paramData.a));
        if (localObject != null) {
          ((AbsGuildNickLayoutItem)localObject).a(paramData);
        }
      }
    }
  }
  
  public LinearLayout b()
  {
    Object localObject = (BaseGuildMsgViewBuild.ViewHolder)AIOUtils.b(this.g);
    if ((localObject != null) && (((BaseGuildMsgViewBuild.ViewHolder)localObject).q != null))
    {
      localObject = this.k;
      if (localObject != null) {
        return localObject;
      }
      d();
      e();
      return this.k;
    }
    return new LinearLayout(this.h);
  }
  
  public String c()
  {
    Object localObject = this.j;
    if (localObject == null) {
      return "";
    }
    localObject = (AbsGuildNickLayoutItem)((HashMap)localObject).get(Integer.valueOf(b));
    if ((localObject instanceof NickLayoutNickNameItem)) {
      return ((NickLayoutNickNameItem)localObject).d();
    }
    return "";
  }
  
  public void d()
  {
    if (this.k == null)
    {
      this.k = new LinearLayout(this.h);
      this.k.setGravity(0);
      this.k.setId(2131430596);
      this.k.setVisibility(8);
    }
  }
  
  public void e()
  {
    if (this.j == null) {
      a();
    }
    Iterator localIterator = this.j.values().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (AbsGuildNickLayoutItem)localIterator.next();
      if (localObject != null)
      {
        View localView = ((AbsGuildNickLayoutItem)localObject).a();
        localObject = ((AbsGuildNickLayoutItem)localObject).b();
        if ((localView != null) && (localView.getParent() == null))
        {
          this.k.addView(localView, (ViewGroup.LayoutParams)localObject);
        }
        else if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("addNickItemView error item = ");
          ((StringBuilder)localObject).append(localView);
          QLog.e("NickNameLayoutProcessor", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.baseview.GuildNickLayoutProcessor
 * JD-Core Version:    0.7.0.1
 */