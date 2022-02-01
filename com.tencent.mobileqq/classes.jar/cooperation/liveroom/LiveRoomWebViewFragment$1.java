package cooperation.liveroom;

import bieb;
import biko;
import org.json.JSONObject;

class LiveRoomWebViewFragment$1
  implements biko
{
  LiveRoomWebViewFragment$1(LiveRoomWebViewFragment paramLiveRoomWebViewFragment, bieb parambieb) {}
  
  public long getDetect302Time()
  {
    return this.this$0.mWebViewBuilder.mRedirect302Time;
  }
  
  public boolean getIsReloadUrl()
  {
    return this.this$0.mWebViewBuilder.getIsReloadUrl();
  }
  
  public long getOpenUrlAfterCheckOfflineTime()
  {
    return this.this$0.mWebViewBuilder.getOpenUrlAfterCheckOfflineTime();
  }
  
  public long getReadIndexFromOfflineTime()
  {
    return this.this$0.mWebViewBuilder.getReadIndexFromOfflineTime();
  }
  
  public JSONObject getX5Performance()
  {
    return this.this$0.mWebViewBuilder.mX5PerformanceJson;
  }
  
  public long getgetWebViewTime()
  {
    return 0L;
  }
  
  public long getinitBrowserTime()
  {
    return this.val$webViewDirector.a;
  }
  
  public long getinitTBSTime()
  {
    return 0L;
  }
  
  public long getinitTime()
  {
    return 0L;
  }
  
  public boolean getisWebViewCache()
  {
    return LiveRoomWebViewFragment.access$100(this.this$0);
  }
  
  public long getmClickTime()
  {
    return LiveRoomWebViewFragment.access$200(this.this$0);
  }
  
  public long getmOnCreateMilliTimeStamp()
  {
    return LiveRoomWebViewFragment.access$000(this.this$0);
  }
  
  public boolean getmPerfFirstLoadTag()
  {
    return this.this$0.mWebViewBuilder.ismPerfFirstLoadTag();
  }
  
  public long getmStartLoadUrlMilliTimeStamp()
  {
    return this.this$0.mWebViewBuilder.mStartLoadUrlMilliTimeStamp;
  }
  
  public long getmTimeBeforeLoadUrl()
  {
    return this.this$0.mWebViewBuilder.getmTimeBeforeLoadUrl();
  }
  
  public long getonCreateTime()
  {
    return LiveRoomWebViewFragment.access$300(this.this$0);
  }
  
  public long getpluginFinished()
  {
    return LiveRoomWebViewFragment.access$400(this.this$0);
  }
  
  public long getviewInflateTime()
  {
    return this.val$webViewDirector.b;
  }
  
  public boolean isMainPageUseLocalFile()
  {
    return this.this$0.mWebViewBuilder.isMainPageUseLocalFile();
  }
  
  public void setX5Performance(JSONObject paramJSONObject)
  {
    this.this$0.mWebViewBuilder.mX5PerformanceJson = paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.liveroom.LiveRoomWebViewFragment.1
 * JD-Core Version:    0.7.0.1
 */