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
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ModuleEvent jdField_a_of_type_ComTencentIliveBaseEventModuleEvent;
  private MiniMsgUser jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
  
  public IliveMiniAIOEntryView(Context paramContext, long paramLong, RelativeLayout paramRelativeLayout, ModuleEvent paramModuleEvent)
  {
    if ((paramContext instanceof Activity)) {
      this.jdField_a_of_type_AndroidAppActivity = ((Activity)paramContext);
    }
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_ComTencentIliveBaseEventModuleEvent = paramModuleEvent;
    a();
  }
  
  private Intent a()
  {
    Intent localIntent1 = new Intent();
    if (this.jdField_a_of_type_AndroidAppActivity == null) {
      return localIntent1;
    }
    localIntent1.setFlags(67108864);
    localIntent1.putExtra("tab_index", FrameControllerUtil.a);
    localIntent1.putExtra("fragment_id", 1);
    localIntent1.putExtra("banner_businessCategory", "LiveRoom");
    localIntent1.putExtra("banner_activityName", JumpActivity.class);
    localIntent1.putExtra("banner_plguinType", 1);
    localIntent1.putExtra("banner_wording", "正在观看 开播啦鹅");
    localIntent1.putExtra("banner_iconIdx", 15);
    Intent localIntent2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, JumpActivity.class);
    localIntent2.setData(Uri.parse("mqqapi://vaslive/watch?roomid={roomid}".replace("{roomid}", String.valueOf(this.jdField_a_of_type_Long))));
    localIntent2.addFlags(268435456);
    localIntent1.putExtra("banner_pendingIntent", PendingIntent.getActivities(this.jdField_a_of_type_AndroidAppActivity, 0, new Intent[] { localIntent2 }, 134217728));
    return localIntent1;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131371244));
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
    localMiniMsgUserParam.entryView = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    localMiniMsgUserParam.unreadView = this.jdField_a_of_type_AndroidWidgetTextView;
    localMiniMsgUserParam.filterMsgType = 1;
    localMiniMsgUserParam.backConversationIntent = a();
    if (QLog.isColorLevel()) {
      QLog.d("MiniAIOEntryView", 2, "initMiniMsgUse");
    }
    Activity localActivity = this.jdField_a_of_type_AndroidAppActivity;
    if (localActivity != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = new MiniMsgUser(localActivity, localMiniMsgUserParam);
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.showEntry();
    }
  }
  
  public void c()
  {
    IliveShareHelper.reportAction("qq_live", "room_page", "", "mini_aio_page", "", 111, "");
  }
  
  public void d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
    if (localObject != null)
    {
      ((MiniMsgUser)localObject).onForeground();
      localObject = MiniMsgIPCClient.getInstance().getBusinessInfo(this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser.getParam().businessName);
      if ((localObject != null) && (((MiniMsgBusinessInfo)localObject).a)) {
        show(((MiniMsgBusinessInfo)localObject).b);
      }
    }
  }
  
  public void destroy()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  }
  
  public void e()
  {
    MiniMsgUser localMiniMsgUser = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
    if (localMiniMsgUser != null) {
      localMiniMsgUser.onBackground();
    }
  }
  
  public void f()
  {
    MiniMsgUser localMiniMsgUser = this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser;
    if (localMiniMsgUser != null)
    {
      localMiniMsgUser.destroy();
      this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgUser = null;
    }
    this.jdField_a_of_type_AndroidWidgetTextView = null;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  }
  
  public void hide()
  {
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
    if (localRelativeLayout != null) {
      localRelativeLayout.setVisibility(8);
    }
  }
  
  public void hideUnread()
  {
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setVisibility(8);
    }
  }
  
  public void onFromMiniAIOToAIO() {}
  
  public void onGoToConversation()
  {
    QIPCClientHelper.getInstance().getClient().callServer("VasLiveIPCModule", "action_close_drawer", null, null);
    if (this.jdField_a_of_type_ComTencentIliveBaseEventModuleEvent != null)
    {
      IliveLiteHelper.b();
      this.jdField_a_of_type_ComTencentIliveBaseEventModuleEvent.post(new RoomCloseEvent((short)1005));
    }
  }
  
  public void onOpenMiniAIOCallback()
  {
    IliveShareHelper.reportAction("qq_live", "room_page", "", "mini_aio_page", "", 124, "");
  }
  
  public boolean show(int paramInt)
  {
    RelativeLayout localRelativeLayout = this.jdField_a_of_type_AndroidWidgetRelativeLayout;
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
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.mini.IliveMiniAIOEntryView
 * JD-Core Version:    0.7.0.1
 */