package com.tencent.timi.game.teamlist.model;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.timi.game.net.api.NetApi;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.utils.Logger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import trpc.yes.common.PremadesTeamServerOuterClass.SearchSmobaPremadesTeamRsp;
import trpc.yes.common.PremadesTeamServerOuterClass.SmobaPremadesTeamInfo;

public class TeamListModel
{
  public int a;
  public int b = 5;
  public Vector<PremadesTeamServerOuterClass.SmobaPremadesTeamInfo> c = new Vector();
  public boolean d = false;
  private boolean e = false;
  
  public void a(String paramString, TeamListModel.INotifyData paramINotifyData)
  {
    try
    {
      if ((!this.e) && (!TextUtils.isEmpty(paramString)))
      {
        this.e = true;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("开始加载首页数据originID:");
        localStringBuilder.append(paramString);
        Logger.a("TeamListModel", localStringBuilder.toString());
        ((NetApi)ServiceCenter.a(NetApi.class)).a(SearchTeamListServlet.a(null, null, null, paramString, 0, 1), PremadesTeamServerOuterClass.SearchSmobaPremadesTeamRsp.class, new TeamListModel.1(this, paramINotifyData));
        return;
      }
      return;
    }
    finally {}
  }
  
  public void a(List<PremadesTeamServerOuterClass.SmobaPremadesTeamInfo> paramList, TeamListModel.INotifyData paramINotifyData)
  {
    do
    {
      try
      {
        boolean bool = this.e;
        if (bool) {
          return;
        }
        localObject = new HashSet();
        paramList = paramList.iterator();
        if (!paramList.hasNext()) {
          break;
        }
        localSmobaPremadesTeamInfo = (PremadesTeamServerOuterClass.SmobaPremadesTeamInfo)paramList.next();
        i = 0;
      }
      finally
      {
        for (;;)
        {
          Object localObject;
          PremadesTeamServerOuterClass.SmobaPremadesTeamInfo localSmobaPremadesTeamInfo;
          int i;
          for (;;)
          {
            throw paramList;
          }
          i += 1;
        }
      }
    } while (i >= this.c.size());
    if (((PremadesTeamServerOuterClass.SmobaPremadesTeamInfo)this.c.get(i)).id == localSmobaPremadesTeamInfo.id) {
      if (localSmobaPremadesTeamInfo.status.get() != 1)
      {
        ((HashSet)localObject).add(Integer.valueOf(i));
      }
      else
      {
        this.c.set(i, localSmobaPremadesTeamInfo);
        break label185;
        paramList = ((HashSet)localObject).iterator();
        while (paramList.hasNext())
        {
          localObject = (Integer)paramList.next();
          this.c.remove(localObject);
        }
        paramINotifyData.d();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.teamlist.model.TeamListModel
 * JD-Core Version:    0.7.0.1
 */