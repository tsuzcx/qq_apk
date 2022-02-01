package com.tencent.mobileqq.kandian.biz.ugc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.ugc.capture.ReadInJoyVideoCompositeManager;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.TagInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class KanDianVideoUploadUtils
{
  private static final String[] a = { "readinjoy", "kandian" };
  
  public static ArrayList<Intent> a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = RIJSPUtils.a(ReadInJoyUtils.a(), true, false);
    int i = 1;
    while (i <= 2)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("arg_video_local_task1");
      ((StringBuilder)localObject2).append(i);
      localObject2 = ((SharedPreferences)localObject1).getString(((StringBuilder)localObject2).toString(), "");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        a(((SharedPreferences)localObject1).getString((String)localObject2, ""), localArrayList);
      }
      i += 1;
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("task load over, fail task size:");
    ((StringBuilder)localObject1).append(localArrayList.size());
    QLog.e("KanDianVideoUploadUtils", 1, ((StringBuilder)localObject1).toString());
    return localArrayList;
  }
  
  public static ArrayList<BiuCommentInfo> a(JSONObject paramJSONObject)
  {
    localArrayList = new ArrayList();
    try
    {
      paramJSONObject = new JSONArray(paramJSONObject.get("multiBiuStruct").toString());
      int i = 0;
      Object localObject;
      while (i < paramJSONObject.length())
      {
        localObject = paramJSONObject.getJSONObject(i);
        String str1 = ((JSONObject)localObject).get("uin").toString();
        String str2 = ((JSONObject)localObject).get("comment").toString();
        long l = Long.parseLong(((JSONObject)localObject).get("feedid").toString());
        localArrayList.add(new BiuCommentInfo(Long.valueOf(str1), Long.valueOf(l), str2));
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramJSONObject)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("biuJson2List异常:");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.e("KanDianVideoUploadUtils", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public static JSONArray a(ArrayList<BiuCommentInfo> paramArrayList)
  {
    JSONArray localJSONArray = new JSONArray();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      BiuCommentInfo localBiuCommentInfo = (BiuCommentInfo)paramArrayList.next();
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("uin", localBiuCommentInfo.mUin);
        ((JSONObject)localObject).put("comment", localBiuCommentInfo.mBiuComment);
        ((JSONObject)localObject).put("feedid", localBiuCommentInfo.mFeedId);
        ((JSONObject)localObject).put("opType", localBiuCommentInfo.mOpType);
        localJSONArray.put(localObject);
      }
      catch (JSONException localJSONException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("biuList2JsonArray异常:");
        ((StringBuilder)localObject).append(localJSONException.toString());
        QLog.e("KanDianVideoUploadUtils", 1, ((StringBuilder)localObject).toString());
      }
    }
    return localJSONArray;
  }
  
  public static JSONArray a(List<TagInfo> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TagInfo localTagInfo = (TagInfo)paramList.next();
      Object localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("tagId", localTagInfo.a());
        ((JSONObject)localObject).put("tagName", localTagInfo.a());
        ((JSONObject)localObject).put("tagScore", localTagInfo.a());
        ((JSONObject)localObject).put("channel", localTagInfo.b());
        localJSONArray.put(localObject);
      }
      catch (JSONException localJSONException)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("tagList2JsonArray异常:");
        ((StringBuilder)localObject).append(localJSONException.toString());
        QLog.e("KanDianVideoUploadUtils", 1, ((StringBuilder)localObject).toString());
      }
    }
    return localJSONArray;
  }
  
  public static void a(Bundle paramBundle)
  {
    String str1 = "arg_ad_tag";
    String str2 = paramBundle.getString("mTaskID");
    if (TextUtils.isEmpty(str2)) {
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("saveData2Local taskID:");
    ((StringBuilder)localObject1).append(str2);
    QLog.e("KanDianVideoUploadUtils", 1, ((StringBuilder)localObject1).toString());
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      int i;
      try
      {
        SharedPreferences localSharedPreferences = RIJSPUtils.a(ReadInJoyUtils.a(), true, true);
        SharedPreferences.Editor localEditor = localSharedPreferences.edit();
        localObject1 = a();
        ArrayList localArrayList = new ArrayList();
        localObject1 = ((ArrayList)localObject1).iterator();
        Object localObject2;
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Intent)((Iterator)localObject1).next()).getStringExtra("mTaskID");
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            localArrayList.add(localObject2);
          }
          continue;
        }
        localObject1 = "";
        i = 1;
        if (i <= 2)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("arg_video_local_task1");
          ((StringBuilder)localObject2).append(i);
          localObject2 = localSharedPreferences.getString(((StringBuilder)localObject2).toString(), "");
          if (str2.equals(localObject2)) {
            return;
          }
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("arg_video_local_task1");
            ((StringBuilder)localObject1).append(i);
            localObject1 = ((StringBuilder)localObject1).toString();
            break label821;
          }
          if (localArrayList.contains(localObject2)) {
            break label821;
          }
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("arg_video_local_task1");
          ((StringBuilder)localObject1).append(i);
          localObject1 = ((StringBuilder)localObject1).toString();
          break label821;
        }
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localJSONObject.put("arg_is_from_wang_zhe", paramBundle.getBoolean("arg_is_from_wang_zhe", false));
          localJSONObject.put("is_from_dian_dian", paramBundle.getBoolean("is_from_dian_dian", false));
          localJSONObject.put("is_from_kan_dian", paramBundle.getBoolean("is_from_kan_dian", false));
          localJSONObject.put("arg_video_path", paramBundle.getString("arg_video_path", ""));
          localJSONObject.put("arg_video_cover", paramBundle.getString("arg_video_cover", ""));
          localJSONObject.put("mTaskID", str2);
          localJSONObject.put("commentString", paramBundle.getString("commentString", ""));
          localJSONObject.put("multiBiuStruct", a(paramBundle.getParcelableArrayList("multiBiuStruct")).toString());
          localJSONObject.put("mSelectedTagList", a(paramBundle.getParcelableArrayList("mSelectedTagList")).toString());
          localJSONObject.put(str1, paramBundle.getInt(str1));
          localJSONObject.put("arg_topic_id", paramBundle.getString("arg_topic_id", ""));
          localJSONObject.put("arg_video_cover_url", paramBundle.getString("arg_video_cover_url", ""));
          localJSONObject.put("arg_video_cover_md5", paramBundle.getString("arg_video_cover_md5", ""));
          localJSONObject.put("arg_video_url", paramBundle.getString("arg_video_url", ""));
          localJSONObject.put("arg_video_title", paramBundle.getString("arg_video_title", ""));
          localJSONObject.put("arg_video_uuid", paramBundle.getString("arg_video_uuid", ""));
          localJSONObject.put("arg_video_duration", paramBundle.getLong("arg_video_duration"));
          localJSONObject.put("arg_video_cover_width", paramBundle.getInt("arg_video_cover_width"));
          localJSONObject.put("arg_video_cover_height", paramBundle.getInt("arg_video_cover_height"));
          localJSONObject.put("arg_video_width", paramBundle.getInt("arg_video_width"));
          localJSONObject.put("arg_video_height", paramBundle.getInt("arg_video_height"));
          localEditor.putString((String)localObject1, str2);
          localEditor.putString(str2, localJSONObject.toString());
          localEditor.commit();
          paramBundle = new StringBuilder();
          paramBundle.append(str2);
          paramBundle.append("  saveData2Local success! ");
          paramBundle.append((String)localObject1);
          paramBundle.append(" data content:");
          paramBundle.append(localJSONObject.toString());
          paramBundle = paramBundle.toString();
        }
        try
        {
          QLog.e("KanDianVideoUploadUtils", 1, paramBundle);
          return;
        }
        catch (Exception paramBundle) {}
        paramBundle = new StringBuilder();
        paramBundle.append(str2);
        paramBundle.append("save  data failed!!");
        QLog.e("KanDianVideoUploadUtils", 1, paramBundle.toString());
        return;
      }
      catch (Exception paramBundle) {}
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str2);
      ((StringBuilder)localObject1).append("save data error");
      ((StringBuilder)localObject1).append(paramBundle.toString());
      QLog.e("KanDianVideoUploadUtils", 1, ((StringBuilder)localObject1).toString());
      paramBundle.printStackTrace();
      return;
      label821:
      i += 1;
    }
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    paramString = new File(paramString);
    if (paramString.exists()) {
      paramString.delete();
    }
  }
  
  private static void a(String paramString, ArrayList<Intent> paramArrayList)
  {
    label712:
    label748:
    label753:
    label758:
    label763:
    for (;;)
    {
      Intent localIntent;
      Bundle localBundle;
      JSONObject localJSONObject;
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          return;
        }
        localIntent = new Intent();
        localBundle = new Bundle();
        localJSONObject = new JSONObject(paramString);
        paramString = localJSONObject.getString("arg_video_cover");
        try
        {
          str1 = localJSONObject.getString("mTaskID");
          bool2 = localJSONObject.getBoolean("arg_is_from_wang_zhe");
          if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(paramString))) {
            break label753;
          }
          if (new File(paramString).exists()) {
            break label748;
          }
        }
        catch (Exception paramString)
        {
          String str1;
          boolean bool2;
          String str2;
          Object localObject;
          String str3;
          StringBuilder localStringBuilder;
          break label712;
        }
        str2 = localJSONObject.getString("arg_video_path");
        if (bool2) {
          break label763;
        }
        if (TextUtils.isEmpty(str2)) {
          break label758;
        }
        if (new File(str2).exists()) {
          break label763;
        }
      }
      catch (Exception paramString) {}
      if (bool1)
      {
        localBundle.putBoolean("arg_is_from_wang_zhe", bool2);
        localBundle.putBoolean("is_from_dian_dian", localJSONObject.getBoolean("is_from_dian_dian"));
        localBundle.putBoolean("is_from_kan_dian", localJSONObject.getBoolean("is_from_kan_dian"));
        localIntent.putExtra("arg_video_path", str2);
        localIntent.putExtra("arg_video_cover", paramString);
        localIntent.putExtra("mTaskID", str1);
        localIntent.putExtra("commentString", localJSONObject.getString("commentString"));
        localBundle.putParcelableArrayList("mSelectedTagList", b(localJSONObject));
        localBundle.putParcelableArrayList("multiBiuStruct", a(localJSONObject));
        try
        {
          localBundle.putString("arg_topic_id", localJSONObject.getString("arg_topic_id"));
          localBundle.putInt("arg_ad_tag", localJSONObject.getInt("arg_ad_tag"));
        }
        catch (Exception localException1)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(" parseJson error");
            ((StringBuilder)localObject).append(localException1.toString());
            QLog.d("KandianVideoUpload", 2, ((StringBuilder)localObject).toString());
          }
        }
        localObject = " parseJson error";
        str3 = "KandianVideoUpload";
        try
        {
          localBundle.putInt("arg_video_width", localJSONObject.getInt("arg_video_width"));
          localBundle.putInt("arg_video_height", localJSONObject.getInt("arg_video_height"));
          localBundle.putLong("arg_video_duration", localJSONObject.getLong("arg_video_duration"));
        }
        catch (Exception localException2)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject);
            localStringBuilder.append(localException2.toString());
            QLog.d(str3, 2, localStringBuilder.toString());
          }
        }
        try
        {
          localBundle.putString("arg_video_cover_url", localJSONObject.getString("arg_video_cover_url"));
          localBundle.putString("arg_video_cover_md5", localJSONObject.getString("arg_video_cover_md5"));
          localBundle.putString("arg_video_url", localJSONObject.getString("arg_video_url"));
          localBundle.putString("arg_video_title", localJSONObject.getString("arg_video_title"));
          localBundle.putString("arg_video_uuid", localJSONObject.getString("arg_video_uuid"));
        }
        catch (Exception localException3)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append((String)localObject);
            localStringBuilder.append(localException3.toString());
            QLog.d(str3, 2, localStringBuilder.toString());
          }
        }
        localBundle.putInt("arg_video_cover_width", localJSONObject.getInt("arg_video_cover_width"));
        localBundle.putInt("arg_video_cover_height", localJSONObject.getInt("arg_video_cover_height"));
        localIntent.putExtras(localBundle);
        paramArrayList.add(localIntent);
      }
      paramArrayList = new StringBuilder();
      paramArrayList.append("parseJson shouldParse:");
      paramArrayList.append(bool1);
      paramArrayList.append(" vp:");
      paramArrayList.append(str2);
      paramArrayList.append(" cp:");
      paramArrayList.append(paramString);
      paramArrayList.append(" id:");
      paramArrayList.append(str1);
      paramString = paramArrayList.toString();
      try
      {
        QLog.d("KanDianVideoUploadUtils", 1, paramString);
        return;
      }
      catch (Exception paramString) {}
      paramArrayList = new StringBuilder();
      paramArrayList.append("parseJson json Exception:");
      paramArrayList.append(paramString.toString());
      QLog.e("KanDianVideoUploadUtils", 1, paramArrayList.toString());
      return;
      boolean bool1 = true;
      continue;
      bool1 = false;
      continue;
      bool1 = false;
    }
  }
  
  public static ArrayList<TagInfo> b(JSONObject paramJSONObject)
  {
    localArrayList = new ArrayList();
    try
    {
      paramJSONObject = new JSONArray(paramJSONObject.get("mSelectedTagList").toString());
      int i = 0;
      Object localObject;
      while (i < paramJSONObject.length())
      {
        localObject = paramJSONObject.getJSONObject(i);
        localArrayList.add(new TagInfo(Long.valueOf(((JSONObject)localObject).get("uin").toString()).longValue(), ((JSONObject)localObject).get("nickName").toString(), Double.parseDouble(((JSONObject)localObject).get("tagScore").toString()), Long.parseLong(((JSONObject)localObject).get("channel").toString())));
        i += 1;
      }
      return localArrayList;
    }
    catch (Exception paramJSONObject)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("tagJson2List异常:");
      ((StringBuilder)localObject).append(paramJSONObject.toString());
      QLog.e("KanDianVideoUploadUtils", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public static void b(Bundle paramBundle)
  {
    String str = paramBundle.getString("mTaskID", "");
    c(paramBundle);
    Object localObject = RIJSPUtils.a(ReadInJoyUtils.a(), true, true);
    paramBundle = ((SharedPreferences)localObject).edit();
    int i = 1;
    while (i <= 2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("arg_video_local_task1");
      localStringBuilder.append(i);
      if (str.equals(((SharedPreferences)localObject).getString(localStringBuilder.toString(), "")))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("arg_video_local_task1");
        ((StringBuilder)localObject).append(i);
        paramBundle.putString(((StringBuilder)localObject).toString(), "");
        paramBundle.putString(str, "");
        bool = true;
        break label145;
      }
      i += 1;
    }
    boolean bool = false;
    label145:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("remove local task:");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(" state:");
    ((StringBuilder)localObject).append(bool);
    QLog.e("KanDianVideoUploadUtils", 1, ((StringBuilder)localObject).toString());
    paramBundle.commit();
  }
  
  private static void c(Bundle paramBundle)
  {
    String str1 = paramBundle.getString("arg_video_cover");
    String str2 = paramBundle.getString("compressPath");
    String str3 = paramBundle.getString("arg_video_path");
    paramBundle = paramBundle.getString("mFakeVidForComposition");
    if (!TextUtils.isEmpty(paramBundle)) {
      new ReadInJoyVideoCompositeManager().a(paramBundle);
    }
    a(str1);
    a(str2);
    a(str3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.ugc.KanDianVideoUploadUtils
 * JD-Core Version:    0.7.0.1
 */