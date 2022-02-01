package dov.com.qq.im.ae.entry;

import android.os.Bundle;
import android.support.annotation.NonNull;

public final class AELaunchParamsBuilder
{
  private Bundle a = new Bundle();
  
  public AELaunchParamsBuilder() {}
  
  public AELaunchParamsBuilder(@NonNull Bundle paramBundle)
  {
    this.a = paramBundle;
  }
  
  public Bundle a()
  {
    return this.a;
  }
  
  public AELaunchParamsBuilder a(int paramInt)
  {
    this.a.putInt("BUNDLE_KEY_CIRCLE_HAS_PICKED_NUM", paramInt);
    return this;
  }
  
  public AELaunchParamsBuilder a(AECameraEntry paramAECameraEntry)
  {
    this.a.putInt("VIDEO_STORY_FROM_TYPE", paramAECameraEntry.a());
    return this;
  }
  
  public AELaunchParamsBuilder a(boolean paramBoolean)
  {
    this.a.putBoolean("BUNDLE_KEY_CIRCLE_CAN_MIX_PICK_PHOTO_AND_VIDEO", paramBoolean);
    return this;
  }
  
  public AELaunchParamsBuilder b(boolean paramBoolean)
  {
    this.a.putBoolean("BUNDLE_KEY_CIRCLE_CAN_SWITCH_SECTION_MODE", paramBoolean);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.entry.AELaunchParamsBuilder
 * JD-Core Version:    0.7.0.1
 */