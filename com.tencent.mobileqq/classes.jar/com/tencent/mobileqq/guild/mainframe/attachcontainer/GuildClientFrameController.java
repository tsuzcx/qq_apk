package com.tencent.mobileqq.guild.mainframe.attachcontainer;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.client.GuildClientParams;
import com.tencent.mobileqq.guild.mainframe.GuildMainViewContext;
import com.tencent.mobileqq.guild.mainframe.container.GuildBaseContainer;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.ITimiGameApi;

public class GuildClientFrameController
  extends GuildBaseContainer
{
  private int b = 0;
  private FrameLayout c;
  private QBaseFragment d;
  private String e = "";
  
  public GuildClientFrameController(GuildMainViewContext paramGuildMainViewContext)
  {
    super(paramGuildMainViewContext);
  }
  
  private QPublicBaseFragment a(String paramString)
  {
    paramString = ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).buildLaunchParamFromLink(this.a.b(), paramString);
    return ((ITimiGameApi)QRoute.api(ITimiGameApi.class)).createExpandHallFragment(this.a.b(), paramString, null);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    this.c = ((FrameLayout)paramViewGroup);
    this.b = this.c.getId();
  }
  
  public void a(Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("show clientFragment is null ? ");
      boolean bool;
      if (this.d == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject1).append(bool);
      QLog.d("GuildClientFrameController", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.a.g().beginTransaction();
    Object localObject2 = this.d;
    if ((localObject2 != null) && (((QBaseFragment)localObject2).getActivity() != null))
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("remove clientFragment for channelId  ");
        ((StringBuilder)localObject2).append(this.e);
        QLog.d("GuildClientFrameController", 2, ((StringBuilder)localObject2).toString());
      }
      this.e = "";
      this.d.onDestroyView();
      this.d.onDestroy();
      ((FragmentTransaction)localObject1).remove(this.d);
    }
    paramObject = (GuildClientParams)paramObject;
    if ((paramObject != null) && (!TextUtils.isEmpty(paramObject.k())))
    {
      if (paramObject.n() == 1000000)
      {
        this.d = a(paramObject.k());
        this.e = paramObject.g();
        int i = this.b;
        paramObject = this.d;
        ((FragmentTransaction)localObject1).add(i, paramObject, paramObject.getClass().getName());
        ((FragmentTransaction)localObject1).commitAllowingStateLoss();
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("unsupported appid：");
      ((StringBuilder)localObject1).append(paramObject.n());
      QLog.w("GuildClientFrameController", 1, ((StringBuilder)localObject1).toString());
      return;
    }
    QLog.d("GuildClientFrameController", 1, "show clientFragment params or jumpUrl is null ");
  }
  
  public boolean b(Object paramObject)
  {
    GuildClientParams localGuildClientParams = (GuildClientParams)paramObject;
    if ((localGuildClientParams != null) && (!TextUtils.isEmpty(localGuildClientParams.k())))
    {
      if (!localGuildClientParams.p()) {
        return true;
      }
      if ((!TextUtils.isEmpty(this.e)) && (localGuildClientParams.g().equals(this.e))) {
        return false;
      }
      return super.b(paramObject);
    }
    QLog.d("GuildClientFrameController", 1, "canOpenWhenHasShow clientFragment params or jumpUrl is null ");
    return false;
  }
  
  public void g()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBeforeAccountChanged clientFragment is null ? ");
      boolean bool;
      if (this.d == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("GuildClientFrameController", 2, localStringBuilder.toString());
    }
    if (this.d != null)
    {
      ((IGuildTempApi)QRoute.api(IGuildTempApi.class)).removeGuildChatFragment(this.a.g(), this.d);
      this.d = null;
      if (this.a.e().l() == GuildAttachContainerController.g)
      {
        this.a.e().d(true);
        this.a.e().a(GuildAttachContainerController.b, null);
      }
    }
  }
  
  public boolean h()
  {
    if ((this.c != null) && (this.a.e().i()) && (this.a.e().l() == GuildAttachContainerController.g))
    {
      QBaseFragment localQBaseFragment = this.d;
      if ((localQBaseFragment != null) && (localQBaseFragment.getActivity() != null) && (!((QPublicBaseFragment)this.d).onBackEvent())) {
        this.a.e().e(true);
      }
      return true;
    }
    return false;
  }
  
  public int i()
  {
    return GuildAttachContainerController.g;
  }
  
  public void j()
  {
    if (this.d != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("hide clientFragment for channelId  ");
        localStringBuilder.append(this.e);
        QLog.d("GuildClientFrameController", 2, localStringBuilder.toString());
      }
      this.e = "";
      this.a.g().beginTransaction().remove(this.d).commitAllowingStateLoss();
      this.d = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.attachcontainer.GuildClientFrameController
 * JD-Core Version:    0.7.0.1
 */