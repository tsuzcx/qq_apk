package com.tencent.qqmini.sdk.widget.media;

import com.tencent.qqmini.sdk.widget.media.danmu.Barrage;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MiniAppVideoConfig
{
  private static final String TAG = "MiniAppVideoConfig";
  public boolean autoPauseIfNavigate = true;
  public boolean autoPauseIfOpenNative = true;
  public boolean autoplay = false;
  public List<Barrage> barrages;
  public boolean customCache;
  public int direction = -1;
  public boolean enableDanmu = false;
  public boolean enablePlayGesture;
  public boolean enableProgressGesture = true;
  public boolean hide;
  public boolean hideTimeDesc = false;
  public double initialTime = 0.0D;
  public boolean isBarrageOpen;
  boolean isBusyInChangeScreen = false;
  public boolean isFullScreen;
  public boolean isLive = false;
  public boolean isMuted = false;
  public boolean isPageOnBackground = false;
  boolean isResetPath = false;
  public boolean isShowBasicControl = true;
  public boolean isShowControlBar = true;
  public String lastPoster;
  long lastSmallScreenTime = -1L;
  public boolean loop = false;
  public String mUrls;
  public int maxVolume = 0;
  public boolean muted = false;
  public boolean needEvent;
  public String objectFit = "contain";
  public boolean pageGesture = false;
  public int parentId;
  public String playBtnPosition;
  public String poster = null;
  public boolean showCenterPlayBtn = true;
  public boolean showControlProgress;
  public boolean showDanmuBtn = false;
  public boolean showFullScreenBtn = true;
  public boolean showLiveBtn;
  public boolean showMuteBtn = false;
  public boolean showPlayBtn = true;
  public boolean showProgress = true;
  public String title;
  public int videoHeight = 150;
  public int videoWidth = 300;
  public int videoX;
  public int videoY;
  
  private List<Barrage> parseDanmuList(JSONArray paramJSONArray)
  {
    if (paramJSONArray == null) {
      return this.barrages;
    }
    List localList = this.barrages;
    if (localList == null) {
      this.barrages = new LinkedList();
    } else {
      localList.clear();
    }
    int j = paramJSONArray.length();
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        try
        {
          this.barrages.add(Barrage.parseJson(paramJSONArray.getJSONObject(i)));
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        i += 1;
      }
    }
    return this.barrages;
  }
  
  public void initSetting(JSONObject paramJSONObject)
  {
    this.poster = paramJSONObject.optString("poster", this.poster);
    this.enableDanmu = paramJSONObject.optBoolean("enableDanmu", this.enableDanmu);
    this.needEvent = paramJSONObject.optBoolean("needEvent", this.needEvent);
    this.hide = paramJSONObject.optBoolean("hide", this.hide);
    this.loop = paramJSONObject.optBoolean("loop", this.loop);
    this.enablePlayGesture = paramJSONObject.optBoolean("enablePlayGesture", this.enablePlayGesture);
    this.direction = paramJSONObject.optInt("direction", this.direction);
    this.isShowBasicControl = paramJSONObject.optBoolean("showBasicControls", this.isShowBasicControl);
    this.isShowControlBar = paramJSONObject.optBoolean("controls", this.isShowControlBar);
    this.autoPauseIfNavigate = paramJSONObject.optBoolean("autoPauseIfNavigate", this.autoPauseIfNavigate);
    this.autoPauseIfOpenNative = paramJSONObject.optBoolean("autoPauseIfOpenNative", this.autoPauseIfOpenNative);
    this.muted = paramJSONObject.optBoolean("muted", this.muted);
    this.objectFit = paramJSONObject.optString("objectFit", this.objectFit);
    this.autoplay = paramJSONObject.optBoolean("autoplay", this.autoplay);
    this.barrages = parseDanmuList((JSONArray)paramJSONObject.opt("danmuList"));
    this.isLive = paramJSONObject.optBoolean("isLive", this.isLive);
    this.isMuted = paramJSONObject.optBoolean("isMuted", this.isMuted);
    this.pageGesture = paramJSONObject.optBoolean("pageGesture", this.pageGesture);
    this.initialTime = paramJSONObject.optDouble("initialTime", this.initialTime);
    this.parentId = paramJSONObject.optInt("parentId", this.parentId);
    this.customCache = paramJSONObject.optBoolean("customCache", this.customCache);
    this.title = paramJSONObject.optString("title", this.title);
    this.playBtnPosition = paramJSONObject.optString("playBtnPosition", this.playBtnPosition);
    this.showDanmuBtn = paramJSONObject.optBoolean("showDanmuBtn", this.showDanmuBtn);
    this.showLiveBtn = paramJSONObject.optBoolean("showLiveBtn", this.showLiveBtn);
    this.showPlayBtn = paramJSONObject.optBoolean("showPlayBtn", this.showPlayBtn);
    this.showFullScreenBtn = paramJSONObject.optBoolean("showFullScreenBtn", this.showFullScreenBtn);
    this.showProgress = paramJSONObject.optBoolean("showProgress", this.showProgress);
    this.showControlProgress = paramJSONObject.optBoolean("showControlProgress", this.showControlProgress);
    this.showMuteBtn = paramJSONObject.optBoolean("showMuteBtn", this.showMuteBtn);
    this.showCenterPlayBtn = paramJSONObject.optBoolean("showCenterPlayBtn", this.showCenterPlayBtn);
    this.enableProgressGesture = paramJSONObject.optBoolean("enableProgressGesture", this.enableProgressGesture);
    if (!this.isFullScreen)
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject("position");
      if (localJSONObject != null)
      {
        this.videoX = localJSONObject.optInt("left", this.videoX);
        this.videoY = localJSONObject.optInt("top", this.videoY);
        this.videoWidth = localJSONObject.optInt("width", this.videoWidth);
        this.videoHeight = localJSONObject.optInt("height", this.videoHeight);
        return;
      }
      this.videoX = paramJSONObject.optInt("x", this.videoX);
      this.videoY = paramJSONObject.optInt("y", this.videoY);
      this.videoWidth = paramJSONObject.optInt("width", this.videoWidth);
      this.videoHeight = paramJSONObject.optInt("height", this.videoHeight);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.media.MiniAppVideoConfig
 * JD-Core Version:    0.7.0.1
 */