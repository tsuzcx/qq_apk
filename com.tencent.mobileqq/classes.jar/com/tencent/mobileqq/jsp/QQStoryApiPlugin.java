package com.tencent.mobileqq.jsp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.qqstory.playvideo.StoryPlayerLauncher;
import com.tencent.biz.qqstory.playvideo.entrance.VidListPlayInfo;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

public class QQStoryApiPlugin
  extends WebViewPlugin
{
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new QQStoryApiPlugin.1(this);
  private volatile boolean jdField_a_of_type_Boolean = false;
  
  public QQStoryApiPlugin()
  {
    this.mPluginNameSpace = "story";
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"story".equals(paramString2)) {
      return false;
    }
    Activity localActivity = this.mRuntime.a();
    if (paramString3.equals("openIndex"))
    {
      StoryTransitionActivity.a(localActivity);
      return true;
    }
    if (paramString3.equals("newStory"))
    {
      paramJsBridgeListener = new Intent(localActivity, StoryTransitionActivity.class);
      paramJsBridgeListener.putExtra("jump_action", 1);
      paramJsBridgeListener.putExtra("video_tag", paramVarArgs[0]);
      localActivity.startActivity(paramJsBridgeListener);
      return true;
    }
    boolean bool = paramString3.equals("playStory");
    paramJsBridgeListener = "";
    long l;
    if (bool)
    {
      try
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
        paramJsBridgeListener = paramString1.optString("vid", "");
        l = paramString1.optLong("uin", 0L);
        if ((!TextUtils.isEmpty(paramJsBridgeListener)) && (l > 0L))
        {
          paramString1 = new Intent(localActivity, JumpActivity.class);
          paramString2 = new StringBuilder();
          paramString2.append("mqqapi://qstory/openVideo?videoOwnerUin=");
          paramString2.append(l);
          paramString2.append("&videoId=");
          paramString2.append(paramJsBridgeListener);
          paramString1.setData(Uri.parse(paramString2.toString()));
          localActivity.startActivity(paramString1);
          return true;
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("StoryApi Exception: ");
          paramString1.append(paramJsBridgeListener.getMessage());
          QLog.w("QQStoryApiPlugin", 2, paramString1.toString());
        }
      }
      return true;
    }
    if (paramString3.equals("openTopic")) {
      return false;
    }
    int i;
    if (paramString3.equals("openLive"))
    {
      try
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
        i = paramString1.optInt("type", 0);
        l = paramString1.optLong("roomId", 0L);
        int j = paramString1.optInt("fromId", 0);
        paramString3 = paramString1.optJSONObject("extras");
        if (i == 1)
        {
          paramString1 = new Intent(localActivity, JumpActivity.class);
          paramString2 = new StringBuilder();
          paramString2.append("mqqapi://qstory/openNow?roomid=");
          paramString2.append(l);
          paramString2.append("&fromid=");
          paramString2.append(j);
          paramString2.append("&extras=");
          if (paramString3 != null) {
            paramJsBridgeListener = paramString3.toString();
          }
          paramString2.append(paramJsBridgeListener);
          paramString1.setData(Uri.parse(paramString2.toString()));
          localActivity.startActivity(paramString1);
          return true;
        }
      }
      catch (JSONException paramJsBridgeListener)
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("StoryApi Exception: ");
          paramString1.append(paramJsBridgeListener.getMessage());
          QLog.w("QQStoryApiPlugin", 2, paramString1.toString());
        }
      }
      return true;
    }
    if ((!"openInfoCard".equals(paramString3)) && (!"openMiniSummary".equals(paramString3))) {
      if (!paramString3.equals("playVideos")) {}
    }
    for (;;)
    {
      try
      {
        paramString2 = new JSONObject(paramVarArgs[0]);
        paramString3 = paramString2.optString("videolist", "");
        paramString1 = paramString2.optString("feedlist", "");
        i = paramString2.optInt("index", 0);
        paramVarArgs = paramString2.optString("play_scence", "");
        if ((!TextUtils.isEmpty(paramVarArgs)) && ("videoLabelDetail".equals(paramVarArgs)))
        {
          paramString2.optInt("tagid");
          paramString2.optInt("tagtype");
          if (!TextUtils.isEmpty(paramString3))
          {
            paramString3 = new ArrayList(Arrays.asList(paramString3.split(",")));
            if (!TextUtils.isEmpty(paramString1)) {
              paramString1 = new ArrayList(Arrays.asList(paramString1.split(",")));
            } else {
              paramString1 = new ArrayList();
            }
            if (paramString3.size() <= i) {
              break label826;
            }
            paramString2 = (String)paramString3.get(i);
            if (paramString1.size() > i) {
              paramJsBridgeListener = (String)paramString1.get(i);
            }
            StoryPlayerLauncher.a(localActivity, new VidListPlayInfo(paramString1, paramString3, paramJsBridgeListener, paramString2), 105, null);
            return true;
          }
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("StoryApi Exception: ");
          paramString1.append(paramJsBridgeListener.getMessage());
          QLog.w("QQStoryApiPlugin", 2, paramString1.toString());
        }
      }
      return true;
      return false;
      try
      {
        QQStoryMemoriesActivity.a(localActivity, 23, new JSONObject(paramVarArgs[0]).optLong("uin", 0L));
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        if (QLog.isColorLevel())
        {
          paramString1 = new StringBuilder();
          paramString1.append("StoryApi Exception: ");
          paramString1.append(paramJsBridgeListener.getMessage());
          QLog.w("QQStoryApiPlugin", 2, paramString1.toString());
        }
        return true;
      }
      label826:
      paramString2 = "";
    }
  }
  
  public void onActivityReady()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.action.dispatch_event_do_like");
    localIntentFilter.addAction("com.tencent.mobileqq.action.dispatch_event_comment");
    localIntentFilter.addAction("com.tencent.mobileqq.action.dispatch_event_subscribe");
    Object localObject = this.mRuntime.a();
    if ((localObject != null) && (!this.jdField_a_of_type_Boolean)) {
      try
      {
        ((Activity)localObject).registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
        this.jdField_a_of_type_Boolean = true;
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("regist receiver error:");
          ((StringBuilder)localObject).append(localException.toString());
          QLog.e("QQStoryApiPlugin", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Activity localActivity = this.mRuntime.a();
    if ((localActivity != null) && (this.jdField_a_of_type_Boolean))
    {
      localActivity.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.QQStoryApiPlugin
 * JD-Core Version:    0.7.0.1
 */