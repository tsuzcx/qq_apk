package cooperation.ilive.lite.module;

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

public class IliveCloseBtnModule
  extends RoomBizModule
{
  private static final String jdField_a_of_type_JavaLangString = IliveCloseBtnModule.class.getName();
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  
  private void a()
  {
    LinearLayout localLinearLayout = (LinearLayout)getRootView().findViewById(2131377107);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localLinearLayout.getLayoutParams();
    localLayoutParams.setMargins(0, UIUtil.getStatusBarHeight(this.context) + UIUtil.dp2px(this.context, 9.0F), UIUtil.dp2px(this.context, 12.0F), 0);
    localLinearLayout.setLayoutParams(localLayoutParams);
    ((ViewStub)getRootView().findViewById(2131364826)).inflate();
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)getRootView().findViewById(2131364122));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new IliveCloseBtnModule.1(this));
  }
  
  public void onActivityStop(LifecycleOwner paramLifecycleOwner)
  {
    getEvent().post(new TurnToPortraitEvent());
    super.onActivityStop(paramLifecycleOwner);
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
    a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveCloseBtnModule
 * JD-Core Version:    0.7.0.1
 */