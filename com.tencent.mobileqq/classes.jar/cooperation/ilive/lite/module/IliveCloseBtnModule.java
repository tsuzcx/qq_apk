package cooperation.ilive.lite.module;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.falco.utils.UIUtil;
import com.tencent.ilive.audiencepages.room.events.TurnToPortraitEvent;
import com.tencent.ilive.base.event.ModuleEvent;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule;
import com.tencent.ilive.pages.room.events.RoomCloseEvent;
import cooperation.ilive.lite.floatwindow.IliveFloatWindowHelper;
import cooperation.ilive.lite.floatwindow.IliveFloatWindowHelper.IPermissionCallback;

public class IliveCloseBtnModule
  extends RoomBizModule
{
  private static final String a = "cooperation.ilive.lite.module.IliveCloseBtnModule";
  private ImageView b;
  private IliveFloatWindowHelper.IPermissionCallback c = new IliveCloseBtnModule.2(this);
  
  private void b()
  {
    LinearLayout localLinearLayout = (LinearLayout)getRootView().findViewById(2131444839);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localLinearLayout.getLayoutParams();
    localLayoutParams.setMargins(0, UIUtil.getStatusBarHeight(this.context) + UIUtil.dp2px(this.context, 9.0F), UIUtil.dp2px(this.context, 12.0F), 0);
    localLinearLayout.setLayoutParams(localLayoutParams);
    ((ViewStub)getRootView().findViewById(2131430819)).inflate();
    this.b = ((ImageView)getRootView().findViewById(2131430001));
    this.b.setOnClickListener(new IliveCloseBtnModule.1(this));
  }
  
  private void c()
  {
    if (IliveFloatWindowHelper.a((Activity)this.context, this.c)) {
      return;
    }
    getEvent().post(new RoomCloseEvent((short)1003));
  }
  
  public void onActivityStop(LifecycleOwner paramLifecycleOwner)
  {
    getEvent().post(new TurnToPortraitEvent());
    super.onActivityStop(paramLifecycleOwner);
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    b();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.b.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveCloseBtnModule
 * JD-Core Version:    0.7.0.1
 */