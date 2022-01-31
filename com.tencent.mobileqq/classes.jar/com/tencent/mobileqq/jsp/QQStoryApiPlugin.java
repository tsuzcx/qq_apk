package com.tencent.mobileqq.jsp;

import aeff;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.qqstory.pgc.QQStoryDiscoverSearchDialog;
import com.tencent.biz.qqstory.playvideo.StoryPlayVideoActivity;
import com.tencent.biz.qqstory.storyHome.StoryTransitionActivity;
import com.tencent.biz.qqstory.storyHome.memory.QQStoryMemoriesActivity;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
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
  BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new aeff(this);
  private volatile boolean jdField_a_of_type_Boolean;
  
  public QQStoryApiPlugin()
  {
    this.mPluginNameSpace = "story";
  }
  
  public static final void a(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, StoryTransitionActivity.class);
    localIntent.putExtra("jump_action", 1);
    paramContext.startActivity(localIntent);
  }
  
  public static final void a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent("com.tencent.mobileqq.action.dispatch_event_subscribe");
    localIntent.putExtra("doSubscibe", paramBoolean);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("selfuin", paramString2);
    paramContext.sendBroadcast(localIntent);
  }
  
  public static final void a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("vid", paramString);
      paramString = new ArrayList();
      paramString.add("*");
      EventApiPlugin.a("qqStoryVideoDelete", localJSONObject, paramString, null);
      return;
    }
    catch (JSONException paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQStoryApiPlugin", 2, paramString, new Object[0]);
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if (!"story".equals(paramString2)) {
      return false;
    }
    paramString1 = this.mRuntime.a();
    if (paramString3.equals("openIndex"))
    {
      StoryTransitionActivity.b(paramString1);
      return true;
    }
    if (paramString3.equals("newStory"))
    {
      paramJsBridgeListener = new Intent(paramString1, StoryTransitionActivity.class);
      paramJsBridgeListener.putExtra("jump_action", 1);
      paramJsBridgeListener.putExtra("video_tag", paramVarArgs[0]);
      paramString1.startActivity(paramJsBridgeListener);
      return true;
    }
    long l;
    if (paramString3.equals("playStory"))
    {
      try
      {
        paramString2 = new JSONObject(paramVarArgs[0]);
        paramJsBridgeListener = paramString2.optString("vid", "");
        l = paramString2.optLong("uin", 0L);
        if ((!TextUtils.isEmpty(paramJsBridgeListener)) && (l > 0L))
        {
          paramString2 = new Intent(paramString1, JumpActivity.class);
          paramString2.setData(Uri.parse("mqqapi://qstory/openVideo?videoOwnerUin=" + l + "&videoId=" + paramJsBridgeListener));
          paramString1.startActivity(paramString2);
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("QQStoryApiPlugin", 2, "StoryApi Exception: " + paramJsBridgeListener.getMessage());
          }
        }
      }
      return true;
    }
    if (paramString3.equals("openTopic"))
    {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        l = paramJsBridgeListener.optLong("topicId", -1L);
        paramJsBridgeListener = paramJsBridgeListener.optString("topicName", "");
        if ((l != -1L) && (!TextUtils.isEmpty(paramJsBridgeListener))) {
          StoryPlayVideoActivity.a(paramString1, l, paramJsBridgeListener, null);
        }
      }
      catch (Exception paramJsBridgeListener)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("QQStoryApiPlugin", 2, "StoryApi Exception: " + paramJsBridgeListener.getMessage());
          }
        }
      }
      return true;
    }
    if (paramString3.equals("openDiscoverSearch")) {
      try
      {
        if (this.mRuntime.a() != null)
        {
          new QQStoryDiscoverSearchDialog(this.mRuntime.a().a, paramString1, false, null).show();
          if (QLog.isColorLevel()) {
            QLog.w("QQStoryApiPlugin", 2, "QQStoryDiscoverSearchDialog show----");
          }
        }
        return true;
      }
      catch (Exception paramJsBridgeListener)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("QQStoryApiPlugin", 2, "StoryApi Exception: " + paramJsBridgeListener.getMessage());
          }
        }
      }
    }
    int i;
    if (paramString3.equals("openLive"))
    {
      try
      {
        paramJsBridgeListener = new JSONObject(paramVarArgs[0]);
        i = paramJsBridgeListener.optInt("type", 0);
        l = paramJsBridgeListener.optLong("roomId", 0L);
        int j = paramJsBridgeListener.optInt("fromId", 0);
        paramJsBridgeListener = paramJsBridgeListener.optJSONObject("extras");
        if (i != 1) {
          break label960;
        }
        paramString2 = new Intent(paramString1, JumpActivity.class);
        paramString3 = new StringBuilder().append("mqqapi://qstory/openNow?roomid=").append(l).append("&fromid=").append(j).append("&extras=");
        if (paramJsBridgeListener == null) {}
        for (paramJsBridgeListener = "";; paramJsBridgeListener = paramJsBridgeListener.toString())
        {
          paramString2.setData(Uri.parse(paramJsBridgeListener));
          paramString1.startActivity(paramString2);
          break;
        }
        QLog.w("QQStoryApiPlugin", 2, "StoryApi Exception: " + paramJsBridgeListener.getMessage());
      }
      catch (JSONException paramJsBridgeListener)
      {
        if (!QLog.isColorLevel()) {
          break label960;
        }
      }
    }
    else
    {
      if (("openInfoCard".equals(paramString3)) || ("openMiniSummary".equals(paramString3))) {
        try
        {
          QQStoryMemoriesActivity.a(paramString1, 23, new JSONObject(paramVarArgs[0]).optLong("uin", 0L));
          return true;
        }
        catch (Exception paramJsBridgeListener)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.w("QQStoryApiPlugin", 2, "StoryApi Exception: " + paramJsBridgeListener.getMessage());
            }
          }
        }
      }
      if (paramString3.equals("playVideos"))
      {
        try
        {
          paramString2 = new JSONObject(paramVarArgs[0]);
          paramString3 = paramString2.optString("videolist", "");
          paramJsBridgeListener = paramString2.optString("feedlist", "");
          i = paramString2.optInt("index", 0);
          paramVarArgs = paramString2.optString("play_scence", "");
          if ((TextUtils.isEmpty(paramVarArgs)) || (!"videoLabelDetail".equals(paramVarArgs))) {
            break label962;
          }
          paramString2.optInt("tagid");
          paramString2.optInt("tagtype");
          if (TextUtils.isEmpty(paramString3)) {
            break label962;
          }
          paramString2 = new ArrayList(Arrays.asList(paramString3.split(",")));
          if (!TextUtils.isEmpty(paramJsBridgeListener)) {}
          for (paramJsBridgeListener = new ArrayList(Arrays.asList(paramJsBridgeListener.split(",")));; paramJsBridgeListener = new ArrayList())
          {
            if (paramString2.size() > i) {
              paramString3 = (String)paramString2.get(i);
            }
            if (paramJsBridgeListener.size() > i) {
              paramString3 = (String)paramJsBridgeListener.get(i);
            }
            StoryPlayVideoActivity.a(paramString1, paramJsBridgeListener, paramString2, i, 105, null);
            break;
          }
          QLog.w("QQStoryApiPlugin", 2, "StoryApi Exception: " + paramJsBridgeListener.getMessage());
        }
        catch (Exception paramJsBridgeListener)
        {
          if (!QLog.isColorLevel()) {
            break label962;
          }
        }
        break label962;
      }
      return false;
    }
    label960:
    return true;
    label962:
    return true;
  }
  
  public void onActivityReady()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.action.dispatch_event_do_like");
    localIntentFilter.addAction("com.tencent.mobileqq.action.dispatch_event_comment");
    localIntentFilter.addAction("com.tencent.mobileqq.action.dispatch_event_subscribe");
    Activity localActivity = this.mRuntime.a();
    if ((localActivity != null) && (!this.jdField_a_of_type_Boolean)) {}
    try
    {
      localActivity.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter, "com.tencent.msg.permission.pushnotify", null);
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQStoryApiPlugin", 2, "regist receiver error:" + localException.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.QQStoryApiPlugin
 * JD-Core Version:    0.7.0.1
 */