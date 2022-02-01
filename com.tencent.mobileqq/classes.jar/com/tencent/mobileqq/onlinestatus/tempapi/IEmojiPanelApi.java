package com.tencent.mobileqq.onlinestatus.tempapi;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IEmojiPanelApi
  extends QRouteApi
{
  public abstract View findAndInitEmojiPanel(@NonNull AppRuntime paramAppRuntime, @NonNull Activity paramActivity, @NonNull View paramView, int paramInt, @NonNull EditText paramEditText);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.tempapi.IEmojiPanelApi
 * JD-Core Version:    0.7.0.1
 */