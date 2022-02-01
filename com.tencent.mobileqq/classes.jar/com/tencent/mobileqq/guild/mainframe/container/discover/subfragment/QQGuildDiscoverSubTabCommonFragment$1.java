package com.tencent.mobileqq.guild.mainframe.container.discover.subfragment;

import android.util.SparseArray;
import com.tencent.mobileqq.guild.mainframe.container.discover.handler.QQGuildDiscoverDataCenter;
import com.tencent.mobileqq.guild.mainframe.container.discover.handler.QQGuildDiscoverObserver;
import com.tencent.mobileqq.guild.mainframe.container.discover.subfragment.adapter.QQGuildDiscoverSubTabCommonRvAdapter;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class QQGuildDiscoverSubTabCommonFragment$1
  extends QQGuildDiscoverObserver
{
  QQGuildDiscoverSubTabCommonFragment$1(QQGuildDiscoverSubTabCommonFragment paramQQGuildDiscoverSubTabCommonFragment) {}
  
  public void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      this.a.l.a((List)QQGuildDiscoverDataCenter.b.get(this.a.f()));
    }
    else
    {
      this.a.l.a(new ArrayList());
      QQToast.makeText(this.a.h, 1, "服务器繁忙，请稍后再试～", 0).show();
    }
    if (QQGuildDiscoverSubTabCommonFragment.a(this.a))
    {
      if (this.a.b != null) {
        this.a.b.a(this.a.g(), paramBoolean, null);
      }
      QQGuildDiscoverSubTabCommonFragment.a(this.a, false);
    }
    paramObject = new StringBuilder();
    paramObject.append("isSuccess == ");
    paramObject.append(paramBoolean);
    paramObject.append("，data == ");
    paramObject.append(QQGuildDiscoverDataCenter.c());
    QLog.i("GuildDiscover.QQGuildDiscoverSubTabCommonFragment", 1, paramObject.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.subfragment.QQGuildDiscoverSubTabCommonFragment.1
 * JD-Core Version:    0.7.0.1
 */