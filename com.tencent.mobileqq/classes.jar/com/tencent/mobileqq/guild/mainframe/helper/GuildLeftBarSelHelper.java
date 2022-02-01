package com.tencent.mobileqq.guild.mainframe.helper;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewLifeCycle;
import com.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildListItemBaseBuilder;
import com.tencent.mobileqq.guild.mainframe.leftbar.itemdata.GuildBaseLeftItemData;
import com.tencent.mobileqq.guild.util.QQGuildUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.guild.mainframe.leftbar.itembuilder.GuildListItemBaseBuilder;>;
import java.util.Iterator;
import mqq.app.AppRuntime;

public class GuildLeftBarSelHelper
  extends GuildMainViewLifeCycle
{
  private final String b = "GuildLeftBarSelHelper";
  private String c = "";
  private GuildLeftBarSelHelper.SelItem d = null;
  
  public GuildLeftBarSelHelper(GuildMainViewContext paramGuildMainViewContext)
  {
    super(paramGuildMainViewContext);
  }
  
  private void a(ArrayList<GuildListItemBaseBuilder> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    Object localObject = null;
    Iterator localIterator = paramArrayList.iterator();
    paramArrayList = (ArrayList<GuildListItemBaseBuilder>)localObject;
    do
    {
      for (;;)
      {
        localObject = paramArrayList;
        if (!localIterator.hasNext()) {
          break label98;
        }
        localObject = (GuildListItemBaseBuilder)localIterator.next();
        if (((GuildListItemBaseBuilder)localObject).d() != 2) {
          break;
        }
        paramArrayList = new GuildLeftBarSelHelper.SelItem(((GuildListItemBaseBuilder)localObject).d.a, ((GuildListItemBaseBuilder)localObject).d.b);
      }
    } while (((GuildListItemBaseBuilder)localObject).d() != 1);
    localObject = new GuildLeftBarSelHelper.SelItem(((GuildListItemBaseBuilder)localObject).d.a, ((GuildListItemBaseBuilder)localObject).d.b);
    label98:
    if (localObject != null) {
      a((GuildLeftBarSelHelper.SelItem)localObject);
    }
    if (localObject != null)
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append(((GuildLeftBarSelHelper.SelItem)localObject).b);
      paramArrayList.append(" ");
      paramArrayList.append(QQGuildUtil.f());
      this.c = paramArrayList.toString();
      paramArrayList = new StringBuilder();
      paramArrayList.append("setDefaultSelItem type:");
      paramArrayList.append(((GuildLeftBarSelHelper.SelItem)localObject).a);
      paramArrayList.append(" new value:");
      paramArrayList.append(this.c);
      QLog.i("GuildLeftBarSelHelper", 1, paramArrayList.toString());
      return;
    }
    QLog.i("GuildLeftBarSelHelper", 1, "setDefaultSelItem null");
  }
  
  private void j()
  {
    GuildLeftBarSelHelper.SelItem localSelItem = ((GuildLeftBarSelHelper)this.a.a(GuildMainFrameConstants.b)).i();
    if (localSelItem != null)
    {
      this.a.b(localSelItem.a, localSelItem.b);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("jumpLastSel type:");
      localStringBuilder.append(localSelItem.a);
      localStringBuilder.append(" key:");
      localStringBuilder.append(localSelItem.b);
      QLog.i("GuildLeftBarSelHelper", 1, localStringBuilder.toString());
    }
  }
  
  public void a(GuildLeftBarSelHelper.SelItem paramSelItem)
  {
    this.d = paramSelItem;
    Object localObject = this.a.a().getApp().getSharedPreferences(this.a.a().getCurrentAccountUin(), 0);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject).edit();
    GuildLeftBarSelHelper.SelItem localSelItem = this.d;
    int i;
    if (localSelItem != null) {
      i = localSelItem.a;
    } else {
      i = -1;
    }
    localEditor.putInt("guild_leftbar_selitem_type", i).apply();
    localEditor = ((SharedPreferences)localObject).edit();
    localObject = this.d;
    if (localObject != null) {
      localObject = ((GuildLeftBarSelHelper.SelItem)localObject).b;
    } else {
      localObject = "";
    }
    localEditor.putString("guild_leftbar_selitem_key", (String)localObject).apply();
    ((GuildLeftItemViewExtHelper)this.a.a(GuildMainFrameConstants.d)).j();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("setSelItem=");
    ((StringBuilder)localObject).append(paramSelItem.toString());
    QLog.i("GuildLeftBarSelHelper", 1, ((StringBuilder)localObject).toString());
  }
  
  public void a(ArrayList<GuildListItemBaseBuilder> paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList == null) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("updateCurSelItem forceJump=");
    ((StringBuilder)localObject1).append(paramBoolean);
    localObject1 = ((StringBuilder)localObject1).toString();
    int k = 1;
    QLog.d("GuildLeftBarSelHelper", 1, (String)localObject1);
    localObject1 = i();
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((GuildLeftBarSelHelper.SelItem)localObject1).b);
    ((StringBuilder)localObject2).append(" ");
    ((StringBuilder)localObject2).append(QQGuildUtil.f());
    localObject2 = ((StringBuilder)localObject2).toString();
    int i;
    if (((GuildLeftBarSelHelper.SelItem)localObject1).a == -1)
    {
      a(paramArrayList);
      i = k;
    }
    else
    {
      Iterator localIterator = paramArrayList.iterator();
      int j;
      GuildListItemBaseBuilder localGuildListItemBaseBuilder;
      do
      {
        boolean bool = localIterator.hasNext();
        j = 0;
        i = 0;
        if (!bool) {
          break label324;
        }
        localGuildListItemBaseBuilder = (GuildListItemBaseBuilder)localIterator.next();
        if ((((GuildLeftBarSelHelper.SelItem)localObject1).a == 0) || (((GuildLeftBarSelHelper.SelItem)localObject1).a == 1)) {
          break;
        }
      } while (!((GuildLeftBarSelHelper.SelItem)localObject1).equals(new GuildLeftBarSelHelper.SelItem(localGuildListItemBaseBuilder.d.a, localGuildListItemBaseBuilder.d.b)));
      this.c = ((String)localObject2);
      i = 0;
      for (;;)
      {
        j = 1;
        break label326;
        if (((localGuildListItemBaseBuilder.d.a != 0) && (localGuildListItemBaseBuilder.d.a != 1)) || (!((GuildLeftBarSelHelper.SelItem)localObject1).b.equals(localGuildListItemBaseBuilder.d.b))) {
          break;
        }
        if (((GuildLeftBarSelHelper.SelItem)localObject1).a != localGuildListItemBaseBuilder.d.a)
        {
          ((GuildLeftBarSelHelper.SelItem)localObject1).a = localGuildListItemBaseBuilder.d.a;
          i = 1;
        }
        if (!TextUtils.equals((CharSequence)localObject2, this.c))
        {
          this.c = ((String)localObject2);
          i = 1;
        }
      }
      label324:
      i = 0;
      label326:
      if (j == 0)
      {
        a(paramArrayList);
        i = k;
      }
    }
    if ((paramBoolean) || (i != 0)) {
      j();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = null;
  }
  
  public void e()
  {
    this.d = null;
  }
  
  public GuildLeftBarSelHelper.SelItem i()
  {
    if (this.a.a() == null) {
      return this.d;
    }
    if (this.d == null)
    {
      SharedPreferences localSharedPreferences = this.a.a().getApp().getSharedPreferences(this.a.a().getCurrentAccountUin(), 0);
      this.d = new GuildLeftBarSelHelper.SelItem(localSharedPreferences.getInt("guild_leftbar_selitem_type", -1), localSharedPreferences.getString("guild_leftbar_selitem_key", ""));
    }
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.helper.GuildLeftBarSelHelper
 * JD-Core Version:    0.7.0.1
 */