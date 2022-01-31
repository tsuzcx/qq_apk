package com.tencent.mobileqq.data;

import android.text.TextUtils;
import awge;
import awhp;
import awhs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QIMNotifyAddFriend
  extends awge
{
  public int age;
  public String coverStory;
  public int gender;
  public boolean hasRead;
  public boolean hasShowToast;
  public String nickName;
  public long pushTime;
  public long qqUin;
  public long storyTotalNum;
  @awhs
  public long uin;
  public String videoInfoPacked;
  @awhp
  public List<QIMNotifyAddFriend.VideoInfo> videoInfos = new ArrayList();
  public String wording;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (QIMNotifyAddFriend)paramObject;
    } while (this.uin == paramObject.uin);
    return false;
  }
  
  public int hashCode()
  {
    return (int)(this.uin ^ this.uin >>> 32);
  }
  
  public void postRead()
  {
    super.postRead();
    if (!TextUtils.isEmpty(this.videoInfoPacked))
    {
      ArrayList localArrayList = new ArrayList();
      try
      {
        JSONArray localJSONArray = new JSONArray(this.videoInfoPacked);
        int i = 0;
        while (i < localJSONArray.length())
        {
          JSONObject localJSONObject = (JSONObject)localJSONArray.get(i);
          QIMNotifyAddFriend.VideoInfo localVideoInfo = new QIMNotifyAddFriend.VideoInfo();
          localVideoInfo.coverUrl = localJSONObject.optString("coverUrl");
          localVideoInfo.videoVid = localJSONObject.optString("videoVid");
          localArrayList.add(localVideoInfo);
          i += 1;
        }
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        this.videoInfos = localArrayList;
      }
    }
  }
  
  public void prewrite()
  {
    super.prewrite();
    if (this.videoInfos.size() > 0)
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.videoInfos.iterator();
      while (localIterator.hasNext())
      {
        QIMNotifyAddFriend.VideoInfo localVideoInfo = (QIMNotifyAddFriend.VideoInfo)localIterator.next();
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("coverUrl", localVideoInfo.coverUrl);
          localJSONObject.put("videoVid", localVideoInfo.videoVid);
          localJSONArray.put(localJSONObject);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
      this.videoInfoPacked = localJSONArray.toString();
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("QIMNotifyAddFriend{");
    localStringBuilder.append("uin=").append(this.uin);
    localStringBuilder.append("qqUin=").append(this.qqUin);
    localStringBuilder.append(", storyTotalNum=").append(this.storyTotalNum);
    localStringBuilder.append(", nickName='").append(this.nickName).append('\'');
    localStringBuilder.append(", wording='").append(this.wording).append('\'');
    localStringBuilder.append(", coverStory='").append(this.coverStory).append('\'');
    localStringBuilder.append(", gender=").append(this.gender);
    localStringBuilder.append(", age=").append(this.age);
    localStringBuilder.append(", pushTime=").append(this.pushTime);
    localStringBuilder.append(", hasShowToast=").append(this.hasShowToast);
    localStringBuilder.append(", hasRead=").append(this.hasRead);
    localStringBuilder.append(", videoInfos=").append(this.videoInfos);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.QIMNotifyAddFriend
 * JD-Core Version:    0.7.0.1
 */