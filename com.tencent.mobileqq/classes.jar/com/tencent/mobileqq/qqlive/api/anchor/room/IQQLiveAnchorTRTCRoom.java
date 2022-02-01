package com.tencent.mobileqq.qqlive.api.anchor.room;

import android.widget.FrameLayout;
import com.tencent.mobileqq.qqlive.api.anchor.camera.IQQLiveModuleCamera;
import com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorMediaControl;
import com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorStreamControl;
import com.tencent.mobileqq.qqlive.api.anchor.stream.IQQLiveAnchorStreamQuality;
import com.tencent.mobileqq.qqlive.api.room.ILiveMediaRoom;

public abstract interface IQQLiveAnchorTRTCRoom
  extends IQQLiveModuleCamera, IQQLiveAnchorRoom, IQQLiveAnchorMediaControl, IQQLiveAnchorStreamControl, IQQLiveAnchorStreamQuality, ILiveMediaRoom<FrameLayout>
{}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.api.anchor.room.IQQLiveAnchorTRTCRoom
 * JD-Core Version:    0.7.0.1
 */