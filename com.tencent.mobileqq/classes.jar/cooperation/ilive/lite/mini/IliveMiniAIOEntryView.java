package cooperation.ilive.lite.mini;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.pages.room.events.RoomCloseEvent;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgBusinessInfo;
import com.tencent.mobileqq.activity.miniaio.MiniMsgIPCClient;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser.IMiniMsgActionCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.lite.IliveLiteHelper;
import cooperation.ilive.share.IliveShareHelper;
import eipc.EIPCClient;

public class IliveMiniAIOEntryView
  implements IMiniMsgUnreadCallback, MiniMsgUser.IMiniMsgActionCallback
{
  private RelativeLayout a;
  private TextView b;
  private MiniMsgUser c;
  private Activity d;
  private long e;
  private ModuleEvent f;
  
  public IliveMiniAIOEntryView(Context paramContext, long paramLong, RelativeLayout paramRelativeLayout, ModuleEvent paramModuleEvent)
  {
    if ((paramContext instanceof Activity)) {
      this.d = ((Activity)paramContext);
    }
    this.e = paramLong;
    this.a = paramRelativeLayout;
    this.f = paramModuleEvent;
    a();
  }
  
  private Intent g()
  {
    Intent localIntent1 = new Intent();
    if (this.d == null) {
      return localIntent1;
    }
    localIntent1.setFlags(67108864);
    localIntent1.putExtra("tab_index", FrameControllerUtil.a);
    localIntent1.putExtra("fragment_id", 1);
    localIntent1.putExtra("banner_businessCategory", "LiveRoom");
    localIntent1.putExtra("banner_activityName", JumpActivity.class);
    localIntent1.putExtra("banner_plguinType", 1);
    localIntent1.putExtra("banner_wording", "正在观看 QQ直播");
    localIntent1.putExtra("banner_iconIdx", 15);
    Intent localIntent2 = new Intent(this.d, JumpActivity.class);
    localIntent2.setData(Uri.parse("mqqapi://vaslive/watch?roomid={roomid}".replace("{roomid}", String.valueOf(this.e))));
    localIntent2.addFlags(268435456);
    localIntent1.putExtra("banner_pendingIntent", PendingIntent.getActivities(this.d, 0, new Intent[] { localIntent2 }, 134217728));
    return localIntent1;
  }
  
  public void a()
  {
    this.b = ((TextView)this.a.findViewById(2131438588));
    b();
  }
  
  public void b()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = 29;
    localMiniMsgUserParam.accessType = 1;
    localMiniMsgUserParam.filterMsgType = 1;
    localMiniMsgUserParam.isNeedBackConversation = true;
    localMiniMsgUserParam.unreadCallback = this;
    localMiniMsgUserParam.actionCallback = this;
    localMiniMsgUserParam.entryView = this.a;
    localMiniMsgUserParam.unreadView = this.b;
    localMiniMsgUserParam.filterMsgType = 1;
    localMiniMsgUserParam.backConversationIntent = g();
    if (QLog.isColorLevel()) {
      QLog.d("MiniAIOEntryView", 2, "initMiniMsgUse");
    }
    Activity localActivity = this.d;
    if (localActivity != null)
    {
      this.c = new MiniMsgUser(localActivity, localMiniMsgUserParam);
      this.c.showEntry();
    }
  }
  
  public void c()
  {
    IliveShareHelper.reportAction("qq_live", "room_page", "", "mini_aio_page", "", 111, "");
  }
  
  public void d()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      ((MiniMsgUser)localObject).onForeground();
      localObject = MiniMsgIPCClient.getInstance().getBusinessInfo(this.c.getParam().businessName);
      if ((localObject != null) && (((MiniMsgBusinessInfo)localObject).b)) {
        show(((MiniMsgBusinessInfo)localObject).d);
      }
    }
  }
  
  public void destroy()
  {
    this.b = null;
    this.a = null;
  }
  
  public void e()
  {
    MiniMsgUser localMiniMsgUser = this.c;
    if (localMiniMsgUser != null) {
      localMiniMsgUser.onBackground();
    }
  }
  
  public void f()
  {
    MiniMsgUser localMiniMsgUser = this.c;
    if (localMiniMsgUser != null)
    {
      localMiniMsgUser.destroy();
      this.c = null;
    }
    this.b = null;
    this.a = null;
  }
  
  public void hide()
  {
    RelativeLayout localRelativeLayout = this.a;
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(8);
    }
  }
  
  public void hideUnread()
  {
    TextView localTextView = this.b;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
  }
  
  public void onFromMiniAIOToAIO() {}
  
  public void onGoToConversation()
  {
    QIPCClientHelper.getInstance().getClient().callServer("VasLiveIPCModule", "action_close_drawer", null, null);
    if (this.f != null)
    {
      IliveLiteHelper.c();
      this.f.post(new RoomCloseEvent((short)1005));
    }
  }
  
  public void onOpenMiniAIOCallback()
  {
    IliveShareHelper.reportAction("qq_live", "room_page", "", "mini_aio_page", "", 124, "");
  }
  
  public boolean show(int paramInt)
  {
    RelativeLayout localRelativeLayout = this.a;
    if (localRelativeLayout != null)
    {
      localRelativeLayout.setVisibility(0);
      updateUnreadCount(paramInt, false);
    }
    return true;
  }
  
  public void updateOnBackFromMiniAIO(Bundle paramBundle) {}
  
  public void updateUnreadCount(int paramInt, boolean paramBoolean)
  {
    TextView localTextView = this.b;
    if (localTextView == null) {
      return;
    }
    String str = String.valueOf(paramInt);
    if (paramInt > 99) {
      str = "99+";
    }
    localTextView.setText(str);
    if (!paramBoolean)
    {
      if (paramInt <= 0)
      {
        localTextView.setVisibility(8);
        return;
      }
      localTextView.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.mini.IliveMiniAIOEntryView
 * JD-Core Version:    0.7.0.1
 */