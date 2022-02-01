package com.tencent.mobileqq.guild.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardNewVersionDialog;
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.message.mobapremadesteam.IMobaPremadesTeamHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.utils.QQCustomDialogWtihEmoticonInput;
import java.util.ArrayList;
import java.util.List;

public class ForwardMobaTeamArkMsgOption
  extends ForwardBaseOption
{
  private long a = 0L;
  
  public ForwardMobaTeamArkMsgOption(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  private void a(ArrayList<Pair<Long, Long>> paramArrayList)
  {
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      String str;
      if ((this.A instanceof QQCustomDialogWtihEmoticonInput)) {
        str = ((QQCustomDialogWtihEmoticonInput)this.A).getInputValue();
      } else if ((this.A instanceof ForwardNewVersionDialog)) {
        str = ((ForwardNewVersionDialog)this.A).getInputValue();
      } else {
        str = "";
      }
      ((IMobaPremadesTeamHandler)this.q.getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getMobaPremadesTeamHandlerName())).a(paramArrayList, this.a, str);
    }
  }
  
  protected boolean U()
  {
    return false;
  }
  
  public List<RecentUser> a(List<RecentUser> paramList)
  {
    return new ArrayList();
  }
  
  public void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    super.a(paramQQAppInterface, paramActivity);
  }
  
  protected void b()
  {
    super.b();
  }
  
  protected void c() {}
  
  public boolean e()
  {
    this.a = this.t.getLong("moba_teamid");
    return super.e();
  }
  
  protected boolean f()
  {
    ArrayList localArrayList;
    Object localObject1;
    int i;
    if (K())
    {
      localArrayList = new ArrayList();
      localObject1 = M();
      i = 0;
    }
    for (;;)
    {
      Object localObject2;
      if (i < ((List)localObject1).size())
      {
        localObject2 = (ResultRecord)((List)localObject1).get(i);
        if (((ResultRecord)localObject2).getUinType() != 10014) {}
      }
      try
      {
        localArrayList.add(new Pair(Long.valueOf(Long.parseLong(((ResultRecord)localObject2).guildId)), Long.valueOf(Long.parseLong(((ResultRecord)localObject2).uin))));
        i += 1;
        continue;
        a(localArrayList);
        return super.f();
        localArrayList = new ArrayList();
        if (this.t.getInt("uintype") == 10014)
        {
          localObject1 = this.t.getString("uin");
          localObject2 = this.t.getString("guild_id");
        }
      }
      catch (Exception localException2)
      {
        try
        {
          localArrayList.add(new Pair(Long.valueOf(Long.parseLong((String)localObject2)), Long.valueOf(Long.parseLong((String)localObject1))));
          label177:
          a(localArrayList);
          return super.f();
          localException2 = localException2;
        }
        catch (Exception localException1)
        {
          break label177;
        }
      }
    }
  }
  
  public boolean l()
  {
    return true;
  }
  
  public String n()
  {
    if (TextUtils.isEmpty(this.u))
    {
      this.u = this.t.getString("forward_ark_app_prompt");
      if (TextUtils.isEmpty(this.u)) {
        this.u = this.t.getString("forward_ark_app_desc");
      }
    }
    return this.u;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.forward.ForwardMobaTeamArkMsgOption
 * JD-Core Version:    0.7.0.1
 */