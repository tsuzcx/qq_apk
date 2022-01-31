package com.tencent.mobileqq.nearby.now.send.capturepart;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.nearby.now.send.SmallVideoCameraCaptureFragment;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.PhotoCaptureResult;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;

public abstract class StoryCapturePart
{
  public SmallVideoCameraCaptureFragment a;
  
  public StoryCapturePart(@NonNull SmallVideoCameraCaptureFragment paramSmallVideoCameraCaptureFragment)
  {
    this.a = paramSmallVideoCameraCaptureFragment;
  }
  
  public int a()
  {
    return this.a.c();
  }
  
  public Bundle a()
  {
    return this.a.a();
  }
  
  public FragmentActivity a()
  {
    return this.a.getActivity();
  }
  
  public View a(LayoutInflater paramLayoutInflater, View paramView, Bundle paramBundle)
  {
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Intent paramIntent, int paramInt)
  {
    this.a.startActivityForResult(paramIntent, paramInt);
  }
  
  public void a(Bundle paramBundle) {}
  
  public void a(View paramView, Bundle paramBundle) {}
  
  public void a(CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult) {}
  
  public void a(CameraCaptureView.VideoCaptureResult paramVideoCaptureResult, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.send.capturepart.StoryCapturePart
 * JD-Core Version:    0.7.0.1
 */