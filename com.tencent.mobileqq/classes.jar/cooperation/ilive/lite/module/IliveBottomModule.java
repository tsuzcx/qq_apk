package cooperation.ilive.lite.module;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.falco.base.libapi.imageloader.DisplayImageOptions;
import com.tencent.falco.base.libapi.imageloader.DisplayImageOptions.Builder;
import com.tencent.falco.base.libapi.imageloader.ImageLoaderInterface;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule;
import com.tencent.ilive.pages.room.bizmodule.RoomBizModule.InflateComponentTime;
import com.tencent.livesdk.roomengine.RoomEngine;

public class IliveBottomModule
  extends RoomBizModule
{
  private static DisplayImageOptions d = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).build();
  private FrameLayout a;
  private ImageLoaderInterface b;
  private ImageView c;
  
  private void a(Context paramContext)
  {
    this.a = ((FrameLayout)getRootView().findViewById(2131428953));
    this.c = new ImageView(paramContext);
    this.c.setBackgroundColor(-16777216);
    this.c.setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.c.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.a.addView(this.c, 0);
    this.b = ((ImageLoaderInterface)getRoomEngine().getService(ImageLoaderInterface.class));
    paramContext = this.b;
    if (paramContext != null) {
      paramContext.displayImage("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/live/tianxuan/ditu2.png", this.c, d);
    }
  }
  
  protected RoomBizModule.InflateComponentTime getInflateTime()
  {
    return RoomBizModule.InflateComponentTime.ENTERROOM_INFLATE;
  }
  
  public void onCreate(Context paramContext)
  {
    super.onCreate(paramContext);
  }
  
  protected void onInitComponentEvent()
  {
    a(this.context);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.lite.module.IliveBottomModule
 * JD-Core Version:    0.7.0.1
 */