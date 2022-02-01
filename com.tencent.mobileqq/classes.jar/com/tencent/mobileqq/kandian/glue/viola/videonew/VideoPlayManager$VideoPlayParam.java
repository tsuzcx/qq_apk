package com.tencent.mobileqq.kandian.glue.viola.videonew;

import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.api.IVideoView;
import com.tencent.mobileqq.kandian.biz.viola.video.VideoInfo;
import org.json.JSONObject;

class VideoPlayManager$VideoPlayParam
{
  public ViewGroup a;
  public IVideoView b;
  public VideoInfo c;
  public int d;
  public boolean e;
  public boolean f;
  public int g;
  public int h;
  public boolean i = true;
  public int j = 1000;
  public int k = -1;
  public boolean l = false;
  public boolean m = false;
  int n = 0;
  public boolean o = false;
  private VideoPlayerWrapper p;
  
  public VideoPlayManager$VideoPlayParam(ViewGroup paramViewGroup, JSONObject paramJSONObject)
  {
    this.a = paramViewGroup;
    this.f = true;
    this.e = false;
    this.d = 0;
    this.g = -1;
    this.h = -1;
    this.c = new VideoInfo(paramJSONObject.getJSONObject("video_info"));
    if (paramJSONObject.has("autoplay")) {
      this.f = paramJSONObject.getBoolean("autoplay");
    }
    if (paramJSONObject.has("muted")) {
      this.e = paramJSONObject.getBoolean("muted");
    }
    if (paramJSONObject.has("start_position")) {
      this.d = paramJSONObject.getInt("start_position");
    }
    if (paramJSONObject.has("width")) {
      this.g = paramJSONObject.getInt("width");
    }
    if (paramJSONObject.has("height")) {
      this.h = paramJSONObject.getInt("height");
    }
    if (paramJSONObject.has("controls")) {
      this.i = paramJSONObject.getBoolean("controls");
    }
    if (paramJSONObject.has("resize")) {
      a(paramJSONObject.getString("resize"));
    }
    if (paramJSONObject.has("timeupdateRate")) {
      this.j = paramJSONObject.getInt("timeupdateRate");
    }
    if (paramJSONObject.has("barBottomMargin")) {
      this.k = paramJSONObject.getInt("barBottomMargin");
    }
    if (paramJSONObject.has("disableFullScreen")) {
      this.l = paramJSONObject.getBoolean("disableFullScreen");
    }
    if (paramJSONObject.has("disableSeek")) {
      this.m = paramJSONObject.getBoolean("disableSeek");
    }
    if (paramJSONObject.has("endWithLastFrame")) {
      this.o = paramJSONObject.getBoolean("endWithLastFrame");
    }
  }
  
  void a(String paramString)
  {
    if (paramString.equals("contain"))
    {
      this.n = 0;
      return;
    }
    if (paramString.equals("cover")) {
      this.n = 2;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoPlayParam{videoInfo=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", startPosition=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", muted=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", autoPlay=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", width=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", height=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", controls=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", timeupdateRate=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", barBottomMargin=");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", disableFullScreen=");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", disableSeek=");
    localStringBuilder.append(this.m);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.VideoPlayManager.VideoPlayParam
 * JD-Core Version:    0.7.0.1
 */