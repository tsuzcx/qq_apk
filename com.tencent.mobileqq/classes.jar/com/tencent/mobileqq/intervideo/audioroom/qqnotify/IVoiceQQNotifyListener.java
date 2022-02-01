package com.tencent.mobileqq.intervideo.audioroom.qqnotify;

import android.os.Bundle;
import com.tencent.mobileqq.activity.activateFriend.QQNotifyUtils.QQNotifyListener;

public abstract interface IVoiceQQNotifyListener
  extends QQNotifyUtils.QQNotifyListener
{
  public abstract void queryHasSetNotify(Bundle paramBundle1, Bundle paramBundle2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.qqnotify.IVoiceQQNotifyListener
 * JD-Core Version:    0.7.0.1
 */