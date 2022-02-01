package com.tencent.timi.game.router;

import android.content.Context;
import com.tencent.timi.game.component.qqlive.api.ITgLiveRoomService;
import com.tencent.timi.game.component.qqlive.impl.TgLiveRoomServiceImpl;
import com.tencent.timi.game.datareport.api.ILiveReportService;
import com.tencent.timi.game.datareport.api.IReportService;
import com.tencent.timi.game.datareport.impl.ReportServiceImpl;
import com.tencent.timi.game.datareport.impl.TGReportServiceImpl;
import com.tencent.timi.game.expand.hall.api.IExpandHallService;
import com.tencent.timi.game.expand.hall.impl.ExpandHallServiceImpl;
import com.tencent.timi.game.float_window.IFloatWindowService;
import com.tencent.timi.game.float_window.impl.FloatWindowServiceImpl;
import com.tencent.timi.game.image.api.IDrawableService;
import com.tencent.timi.game.image.impl.DrawableServiceImpl;
import com.tencent.timi.game.initer.api.IniterService;
import com.tencent.timi.game.initer.impl.IniterServiceImpl;
import com.tencent.timi.game.live.api.IGameLiveService;
import com.tencent.timi.game.live.impl.GameLiveServiceImpl;
import com.tencent.timi.game.liveroom.api.IAnchorRoomService;
import com.tencent.timi.game.liveroom.impl.AnchorRoomService;
import com.tencent.timi.game.logincore.api.ILoginCoreService;
import com.tencent.timi.game.logincore.impl.LoginCoreImpl;
import com.tencent.timi.game.mic.api.IMicService;
import com.tencent.timi.game.mic.impl.MicServiceImpl;
import com.tencent.timi.game.net.api.NetApi;
import com.tencent.timi.game.profile.api.IProfileDialogService;
import com.tencent.timi.game.profile.impl.ProfileDialogServiceImpl;
import com.tencent.timi.game.relationship.api.ITGRelationshipService;
import com.tencent.timi.game.relationship.impl.TGRelationshipService;
import com.tencent.timi.game.room.api.IRoomService;
import com.tencent.timi.game.room.impl.RoomServiceImpl;
import com.tencent.timi.game.room.impl.operation.RoomOperationService;
import com.tencent.timi.game.smoba.api.ISmobaService;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService;
import com.tencent.timi.game.smoba.impl.SmobaServiceImpl;
import com.tencent.timi.game.smoba.impl.UserSmobaInfoManager;
import com.tencent.timi.game.smoba.impl.UserSmobaInfoManager.Companion;
import com.tencent.timi.game.team.api.ITeamService;
import com.tencent.timi.game.team.impl.TeamServiceImpl;
import com.tencent.timi.game.test.api.ITimiGameTestService;
import com.tencent.timi.game.test.impl.TimiGameTestServiceImpl;
import com.tencent.timi.game.tim.api.ITimiGameTimApi;
import com.tencent.timi.game.tim.api.impl.TimiGameTimApiImpl;
import com.tencent.timi.game.userinfo.api.IUserInfoService;
import com.tencent.timi.game.userinfo.impl.UserInfoServiceImpl;
import com.tencent.timi.game.web.business.api.IWebBusinessService;
import com.tencent.timi.game.web.business.impl.WebBusinessServiceImpl;
import com.tentcent.timi.game.net.impl.NetImpl;
import com.yolo.esports.download.IDownloadService;
import com.yolo.esports.download.impl.DownloadServiceImpl;
import com.yolo.esports.room.api.IRoomOperationService;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ServiceCenter
{
  private static Map<Class<? extends IService>, IService> a = new HashMap();
  
  static
  {
    a(IniterService.class, new IniterServiceImpl());
    a(IDownloadService.class, new DownloadServiceImpl());
    a(ITeamService.class, new TeamServiceImpl());
    a(NetApi.class, new NetImpl());
    a(ILoginCoreService.class, new LoginCoreImpl());
    a(IExpandHallService.class, new ExpandHallServiceImpl());
    a(IRoomService.class, new RoomServiceImpl());
    a(IRoomOperationService.class, new RoomOperationService());
    a(IUserInfoService.class, new UserInfoServiceImpl());
    a(IUserSmobaInfoService.class, UserSmobaInfoManager.a.a());
    a(ITimiGameTimApi.class, new TimiGameTimApiImpl());
    a(IFloatWindowService.class, new FloatWindowServiceImpl());
    a(ISmobaService.class, new SmobaServiceImpl());
    a(IGameLiveService.class, new GameLiveServiceImpl());
    a(IProfileDialogService.class, new ProfileDialogServiceImpl());
    a(ITGRelationshipService.class, new TGRelationshipService());
    a(IAnchorRoomService.class, new AnchorRoomService());
    a(ITgLiveRoomService.class, new TgLiveRoomServiceImpl());
    a(IReportService.class, new ReportServiceImpl());
    a(IDrawableService.class, new DrawableServiceImpl());
    a(ITimiGameTestService.class, new TimiGameTestServiceImpl());
    a(IWebBusinessService.class, new WebBusinessServiceImpl());
    a(IMicService.class, new MicServiceImpl());
    a(ILiveReportService.class, new TGReportServiceImpl("0AND06MK9E48EOTF"));
  }
  
  public static <T extends IService> T a(Class<T> paramClass)
  {
    return (IService)a.get(paramClass);
  }
  
  public static void a()
  {
    Iterator localIterator = a.values().iterator();
    while (localIterator.hasNext()) {
      ((IService)localIterator.next()).g();
    }
  }
  
  public static void a(Context paramContext)
  {
    Iterator localIterator = a.values().iterator();
    while (localIterator.hasNext()) {
      ((IService)localIterator.next()).a(paramContext);
    }
  }
  
  private static void a(Class<? extends IService> paramClass, IService paramIService)
  {
    a.put(paramClass, paramIService);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.router.ServiceCenter
 * JD-Core Version:    0.7.0.1
 */