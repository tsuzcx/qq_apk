package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QIMNotifyAddFriend
  extends Entity
{
  public int age;
  public String coverStory;
  public int gender;
  public boolean hasRead = false;
  public boolean hasShowToast = false;
  public String nickName;
  public long pushTime;
  public long qqUin;
  public long storyTotalNum;
  @unique
  public long uin;
  public String videoInfoPacked;
  @notColumn
  public List<QIMNotifyAddFriend.VideoInfo> videoInfos = new ArrayList();
  public String wording;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (QIMNotifyAddFriend)paramObject;
      return this.uin == paramObject.uin;
    }
    return false;
  }
  
  public int hashCode()
  {
    long l = this.uin;
    return (int)(l ^ l >>> 32);
  }
  
  protected void postRead()
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
  
  protected void prewrite()
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
    localStringBuilder.append("uin=");
    localStringBuilder.append(this.uin);
    localStringBuilder.append("qqUin=");
    localStringBuilder.append(this.qqUin);
    localStringBuilder.append(", storyTotalNum=");
    localStringBuilder.append(this.storyTotalNum);
    localStringBuilder.append(", nickName='");
    localStringBuilder.append(this.nickName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", wording='");
    localStringBuilder.append(this.wording);
    localStringBuilder.append('\'');
    localStringBuilder.append(", coverStory='");
    localStringBuilder.append(this.coverStory);
    localStringBuilder.append('\'');
    localStringBuilder.append(", gender=");
    localStringBuilder.append(this.gender);
    localStringBuilder.append(", age=");
    localStringBuilder.append(this.age);
    localStringBuilder.append(", pushTime=");
    localStringBuilder.append(this.pushTime);
    localStringBuilder.append(", hasShowToast=");
    localStringBuilder.append(this.hasShowToast);
    localStringBuilder.append(", hasRead=");
    localStringBuilder.append(this.hasRead);
    localStringBuilder.append(", videoInfos=");
    localStringBuilder.append(this.videoInfos);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.QIMNotifyAddFriend
 * JD-Core Version:    0.7.0.1
 */