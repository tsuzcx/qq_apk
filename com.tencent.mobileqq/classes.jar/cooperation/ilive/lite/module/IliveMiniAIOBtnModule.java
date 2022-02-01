package cooperation.ilive.lite.module;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ilive.interfaces.IAudienceRoomPager;
import com.tencent.ilive.pages.room.RoomBizContext;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule;
import com.tencent.ilivesdk.roomservice_interface.model.EnterRoomInfo;
import com.tencent.ilivesdk.roomswitchservice_interface.SwitchRoomInfo;
import cooperation.ilive.lite.mini.IliveMiniAIOEntryView;

public class IliveMiniAIOBtnModule
  extends RoomBizModule
{
  private IliveMiniAIOEntryView a;
  
  private int a()
  {
    if ((this.roomBizContext != null) && (this.roomBizContext.getEnterRoomInfo() != null)) {
      return this.roomBizContext.getEnterRoomInfo().bootModulesIndex;
    }
    return 0;
  }
  
  private long a()
  {
    if ((this.roomBizContext != null) && (this.roomBizContext.getEnterRoomInfo() != null)) {
      return this.roomBizContext.getEnterRoomInfo().roomId;
    }
    return 0L;
  }
  
  private void a()
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)getRootView().findViewById(2131371045);
    this.a = new IliveMiniAIOEntryView(this.context, a(), localRelativeLayout, getEvent());
  }
  
  private boolean a()
  {
    int j = a();
    IAudienceRoomPager localIAudienceRoomPager = getAudienceRoomPager();
    boolean bool = false;
    int i;
    if (localIAudienceRoomPager != null) {
      i = getAudienceRoomPager().getCurrentIndex();
    } else {
      i = 0;
    }
    if (j == i) {
      bool = true;
    }
    return bool;
  }
  
  public void onActivityResume(LifecycleOwner paramLifecycleOwner)
  {
    super.onActivityResume(paramLifecycleOwner);
    if (a()) {
      this.a.d();
    }
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.e();
    this.a.f();
  }
  
  public void onEnterRoom(boolean paramBoolean)
  {
    super.onEnterRoom(paramBoolean);
    if (a())
    {
      this.a.c();
      this.a.d();
    }
  }
  
  public void onSwitchRoom(SwitchRoomInfo paramSwitchRoomInfo)
  {
    super.onSwitchRoom(paramSwitchRoomInfo);
    if (a()) {
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveMiniAIOBtnModule
 * JD-Core Version:    0.7.0.1
 */