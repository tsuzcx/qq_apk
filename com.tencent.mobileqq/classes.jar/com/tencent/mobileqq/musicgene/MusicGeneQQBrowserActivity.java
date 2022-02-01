package com.tencent.mobileqq.musicgene;

import Override;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import anzj;
import auxu;
import axrk;
import bdoi;
import bdom;
import bdov;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class MusicGeneQQBrowserActivity
  extends QQBrowserActivity
{
  private BroadcastReceiver a;
  
  public MusicGeneQQBrowserActivity()
  {
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new axrk(this);
    this.jdField_a_of_type_JavaLangClass = MusicGeneQQBrowserActivity.MusicGeneQQBrowserFragment.class;
  }
  
  private void a()
  {
    WebViewFragment localWebViewFragment = a();
    if (localWebViewFragment != null)
    {
      if ((localWebViewFragment.webView != null) && (localWebViewFragment.webView.canGoBack()))
      {
        localWebViewFragment.webView.goBack();
        return;
      }
      finish();
      return;
    }
    finish();
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, long paramLong)
  {
    paramString6 = new bdoi(StructMsgForAudioShare.class).c(2).a(anzj.a(2131705915)).a();
    paramString6.mContentSrc = paramString3;
    paramString6.mContentTitle = paramString5;
    paramString6.mContentCover = paramString1;
    paramString6.mContentSummary = paramString4;
    paramString6.mMsgUrl = paramString2;
    paramString6.mSourceName = "QQ音乐";
    paramString6.mSourceAction = "app";
    paramString6.mSourceAppid = paramLong;
    paramString2 = bdov.a(2);
    paramString2.a(paramString1, paramString5, paramString4);
    paramString6.addItem(paramString2);
    paramString1 = new Bundle();
    paramString1.putInt("forward_type", 11);
    if (!TextUtils.isEmpty(paramString3)) {
      paramString1.putInt("req_type", 2);
    }
    for (;;)
    {
      paramString1.putString("app_name", anzj.a(2131705914));
      paramString1.putString("detail_url", paramString6.mMsgUrl);
      paramString1.putString("audio_url", paramString6.mContentSrc);
      paramString1.putString("image_url_remote", paramString6.mContentCover);
      paramString1.putString("title", paramString6.mContentTitle);
      paramString1.putString("desc", paramString6.mContentSummary);
      paramString1.putString("struct_share_key_source_icon", paramString6.mSourceIcon);
      paramString1.putString("struct_share_key_source_action", paramString6.mSourceAction);
      paramString1.putString("struct_share_key_source_a_action_data", paramString6.mSource_A_ActionData);
      paramString1.putLong("req_share_id", paramString6.mSourceAppid);
      paramString1.putString("brief_key", paramString6.mMsgBrief);
      paramString1.putBoolean("k_send", false);
      paramString1.putBoolean("k_qzone", false);
      paramString1.putBoolean("k_favorites", false);
      paramString1.putBoolean("k_dataline", false);
      paramString2 = new Intent();
      paramString2.putExtra("refuse_show_share_result_dialog", true);
      paramString2.putExtras(paramString1);
      auxu.a(this, paramString2);
      return;
      paramString1.putInt("req_type", 1);
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
    return bool;
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      a();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnStart()
  {
    try
    {
      super.doOnStart();
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("BROAD_CAST_SHARE_MUSIC_GENE");
      localIntentFilter.addAction("BROAD_CAST_SHARE_SONG");
      localIntentFilter.addAction("BROAD_CAST_UPDATE_TITLE");
      registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.music.data.permission", null);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MusicGeneQQBrowserActivity", 1, "doOnStart() exception", localException);
    }
  }
  
  public void doOnStop()
  {
    try
    {
      unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      super.doOnStop();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("MusicGeneQQBrowserActivity", 1, "doOnStop() exception", localException);
    }
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicGeneQQBrowserActivity
 * JD-Core Version:    0.7.0.1
 */