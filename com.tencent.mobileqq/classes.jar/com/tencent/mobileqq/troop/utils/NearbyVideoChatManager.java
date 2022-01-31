package com.tencent.mobileqq.troop.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.cs.longconn.hd_video.MsgBody;
import tencent.im.cs.longconn.hd_video.RspBody;
import tencent.im.cs.longconn.hd_video.VideoHead;

public class NearbyVideoChatManager
  implements Manager
{
  int jdField_a_of_type_Int;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  NearbyVideoChatManager.BannerConfig jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig;
  NearbyVideoChatManager.DialogConfig jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig;
  public String a;
  @NonNull
  List jdField_a_of_type_JavaUtilList = new ArrayList(5);
  boolean jdField_a_of_type_Boolean = false;
  int b;
  public String b;
  public String c = "banner_show_num";
  public String d = "dialog_show_num";
  String e;
  String f;
  public String g = "一对一随机视频聊天";
  public String h = "附近有$人在线";
  String i = "";
  String j;
  String k;
  
  public NearbyVideoChatManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_JavaLangString = "banner_config";
    this.jdField_b_of_type_JavaLangString = "dialog_config";
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    paramAppInterface = paramAppInterface.getCurrentAccountUin();
    this.jdField_a_of_type_JavaLangString += paramAppInterface;
    this.c += paramAppInterface;
    this.jdField_b_of_type_JavaLangString += paramAppInterface;
    this.d += paramAppInterface;
    paramAppInterface = BaseApplicationImpl.getContext().getSharedPreferences("nearby_videochat", 0);
    this.i = paramAppInterface.getString("config", "");
    if (!TextUtils.isEmpty(this.i)) {
      a(this.i);
    }
    this.jdField_a_of_type_Boolean = paramAppInterface.getBoolean("enter_guide", true);
    String str = paramAppInterface.getString(this.jdField_a_of_type_JavaLangString, "");
    if (!TextUtils.isEmpty(str))
    {
      a(str, true);
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_b_of_type_Int = a(paramAppInterface.getString(this.c, ""), this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_a_of_type_JavaLangString);
        this.k = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_a_of_type_JavaLangString;
      }
    }
    str = paramAppInterface.getString(this.jdField_b_of_type_JavaLangString, "");
    if (!TextUtils.isEmpty(str))
    {
      b(str, true);
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_Int = a(paramAppInterface.getString(this.d, ""), this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_a_of_type_JavaLangString);
        this.j = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_a_of_type_JavaLangString;
      }
    }
  }
  
  public static int a(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    int m;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append(paramString2).append(" parseSubType:").append(paramString1).append(", buff.len=");
      if (paramArrayOfByte == null)
      {
        m = 0;
        QLog.d("nearby.video.multiMsg", 2, m);
      }
    }
    else
    {
      if (!"SharpSvr.c2sack".equalsIgnoreCase(paramString1)) {
        break label322;
      }
      paramString1 = new hd_video.RspBody();
      if (paramArrayOfByte == null) {
        break label278;
      }
    }
    int n;
    long l1;
    int i1;
    long l2;
    label278:
    label322:
    while (!"SharpSvr.s2c".equalsIgnoreCase(paramString1))
    {
      try
      {
        paramArrayOfByte = (hd_video.RspBody)paramString1.mergeFrom(paramArrayOfByte);
        if (paramArrayOfByte.msg_video_head.has())
        {
          paramArrayOfByte = (hd_video.VideoHead)paramArrayOfByte.msg_video_head.get();
          n = paramArrayOfByte.enum_body_type.get();
          l1 = paramArrayOfByte.uint64_uin.get();
          if (paramArrayOfByte.int32_sub_service_type.has()) {}
          for (m = paramArrayOfByte.int32_sub_service_type.get();; m = -1)
          {
            i1 = paramArrayOfByte.uint32_seq.get();
            l2 = paramArrayOfByte.uint64_room_id.get();
            if (QLog.isColorLevel()) {
              QLog.d("nearby.video.multiMsg", 2, paramString2 + " bodyType=" + n + ", subServiceType=" + m + ", uin=" + l1 + ", seq=" + i1 + ", roomId=" + l2);
            }
            return m;
            m = paramArrayOfByte.length;
            break;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.e("nearby.video.multiMsg", 2, paramString2 + " head not exist");
        }
      }
      catch (Exception paramArrayOfByte)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("nearby.video.multiMsg", 2, paramString2 + " invalid format:" + paramArrayOfByte.toString());
          }
        }
      }
      return -1;
    }
    paramString1 = new hd_video.MsgBody();
    for (;;)
    {
      try
      {
        paramArrayOfByte = (hd_video.MsgBody)paramString1.mergeFrom(paramArrayOfByte);
        if (paramArrayOfByte.msg_video_head.has())
        {
          paramArrayOfByte = (hd_video.VideoHead)paramArrayOfByte.msg_video_head.get();
          n = paramArrayOfByte.enum_body_type.get();
          l1 = paramArrayOfByte.uint64_uin.get();
          if (!paramArrayOfByte.int32_sub_service_type.has()) {
            break label580;
          }
          m = paramArrayOfByte.int32_sub_service_type.get();
          i1 = paramArrayOfByte.uint32_seq.get();
          l2 = paramArrayOfByte.uint64_room_id.get();
          if (!QLog.isColorLevel()) {
            break label578;
          }
          QLog.d("nearby.video.multiMsg", 2, paramString2 + " bodyType=" + n + ", subServiceType=" + m + ", uin=" + l1 + ", seq=" + i1 + ", roomId=" + l2);
          break label578;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("nearby.video.multiMsg", 2, paramString2 + " head not exist");
      }
      catch (Exception paramArrayOfByte) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("nearby.video.multiMsg", 2, paramString2 + " invalid format:" + paramArrayOfByte.toString());
      break;
      label578:
      return m;
      label580:
      m = -1;
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("Q.nearby.video_chat", 2, "parseBannerJson json is null");
        return;
      }
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig = new NearbyVideoChatManager.BannerConfig();
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_a_of_type_JavaLangString = paramString.optString("unique_key");
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_a_of_type_Int = paramString.optInt("display_times");
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_a_of_type_Long = paramString.optLong("start_timestamp", 0L);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_b_of_type_Long = paramString.optLong("end_timestamp", 0L);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_b_of_type_Int = paramString.optInt("target_group");
      Object localObject = paramString.optJSONObject("content");
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("image_url");
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.c = ((JSONObject)localObject).optString("jump_url");
      }
      if (!paramBoolean)
      {
        localObject = BaseApplicationImpl.getContext().getSharedPreferences("nearby_videochat", 0);
        ((SharedPreferences)localObject).edit().putString(this.jdField_a_of_type_JavaLangString, paramString.toString()).commit();
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_a_of_type_JavaLangString.equals(this.k)))
        {
          this.k = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_a_of_type_JavaLangString;
          paramString = new JSONObject();
          paramString.put(this.k, 0);
          ((SharedPreferences)localObject).edit().putString(this.c, paramString.toString()).commit();
          return;
        }
      }
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.nearby.video_chat", 2, "parseBannerJson JSONException", paramString);
      }
    }
  }
  
  private void b(String paramString, boolean paramBoolean)
  {
    try
    {
      if (TextUtils.isEmpty(paramString))
      {
        QLog.e("Q.nearby.video_chat", 2, "parseDialogJson json is null");
        return;
      }
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig = new NearbyVideoChatManager.DialogConfig();
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_a_of_type_JavaLangString = paramString.optString("unique_key");
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_a_of_type_Int = paramString.optInt("display_times");
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_a_of_type_Long = paramString.optLong("start_timestamp", 0L);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_b_of_type_Long = paramString.optLong("end_timestamp", 0L);
      this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_b_of_type_Int = paramString.optInt("target_group");
      Object localObject = paramString.optJSONObject("content");
      if (localObject != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("header_url");
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.c = ((JSONObject)localObject).optString("title");
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.d = ((JSONObject)localObject).optString("content");
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.e = ((JSONObject)localObject).optString("button_text");
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.f = ((JSONObject)localObject).optString("jump_url");
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.g = ((JSONObject)localObject).optString("button_text_color");
        this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.h = ((JSONObject)localObject).optString("button_background_color");
      }
      if (!paramBoolean)
      {
        localObject = BaseApplicationImpl.getContext().getSharedPreferences("nearby_videochat", 0);
        ((SharedPreferences)localObject).edit().putString(this.jdField_b_of_type_JavaLangString, paramString.toString()).commit();
        if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_a_of_type_JavaLangString.equals(this.j)))
        {
          this.j = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_a_of_type_JavaLangString;
          paramString = new JSONObject();
          paramString.put(this.j, 0);
          ((SharedPreferences)localObject).edit().putString(this.d, paramString.toString()).commit();
          return;
        }
      }
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.nearby.video_chat", 2, "parseDialogJson JSONException", paramString);
      }
    }
  }
  
  public int a(String paramString1, String paramString2)
  {
    try
    {
      if (TextUtils.isEmpty(paramString1)) {
        return 0;
      }
      int m = new JSONObject(paramString1).optInt(paramString2);
      return m;
    }
    catch (JSONException paramString2)
    {
      QLog.e("Q.nearby.video_chat", 2, "getNumFromJson json:" + paramString1);
    }
    return 0;
  }
  
  public NearbyVideoChatManager.BannerConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig;
  }
  
  public NearbyVideoChatManager.DialogConfig a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig;
  }
  
  public String a()
  {
    return this.i;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int += 1;
    this.jdField_b_of_type_Int += 1;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("nearby_videochat", 0);
    try
    {
      JSONObject localJSONObject;
      if (!TextUtils.isEmpty(this.j))
      {
        localJSONObject = new JSONObject();
        localJSONObject.put(this.j, this.jdField_a_of_type_Int);
        localSharedPreferences.edit().putString(this.d, localJSONObject.toString()).commit();
      }
      if (!TextUtils.isEmpty(this.k))
      {
        localJSONObject = new JSONObject();
        localJSONObject.put(this.k, this.jdField_b_of_type_Int);
        localSharedPreferences.edit().putString(this.c, localJSONObject.toString()).commit();
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public void a(String paramString)
  {
    int m = 0;
    try
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      if (TextUtils.isEmpty(paramString))
      {
        this.e = null;
        this.f = null;
        BaseApplicationImpl.getContext().getSharedPreferences("nearby_videochat", 0).edit().putString("config", paramString).commit();
        return;
      }
      this.i = paramString;
      Object localObject = new JSONObject(paramString);
      this.g = ((JSONObject)localObject).optString("detail_default");
      this.h = ((JSONObject)localObject).optString("detail_num");
      this.e = ((JSONObject)localObject).optString("guide");
      this.f = ((JSONObject)localObject).optString("title");
      SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("nearby_videochat", 4);
      localSharedPreferences.edit().putString("detail_default", this.g).commit();
      localSharedPreferences.edit().putString("detail_num", this.h).commit();
      if (TextUtils.isEmpty(this.f)) {
        localSharedPreferences.edit().putString("title", "视频随聊").commit();
      }
      for (;;)
      {
        localObject = ((JSONObject)localObject).optJSONArray("tips");
        while (m < ((JSONArray)localObject).length())
        {
          this.jdField_a_of_type_JavaUtilList.add(((JSONArray)localObject).optString(m));
          m += 1;
        }
        break;
        localSharedPreferences.edit().putString("title", this.f).commit();
      }
      return;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.nearby.video_chat", 2, "parseJson JSONException", paramString);
      }
    }
  }
  
  public boolean a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig == null) || ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_a_of_type_Int < this.jdField_a_of_type_Int))) {}
    long l;
    do
    {
      do
      {
        return false;
      } while ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_b_of_type_Int != paramInt));
      l = System.currentTimeMillis() / 1000L;
    } while ((l <= this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_a_of_type_Long) || (l > this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$DialogConfig.jdField_b_of_type_Long));
    return true;
  }
  
  public String b()
  {
    return this.f;
  }
  
  public void b(String paramString)
  {
    a(paramString, false);
  }
  
  public boolean b(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig == null) || ((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_a_of_type_Int >= 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_a_of_type_Int < this.jdField_b_of_type_Int))) {}
    long l;
    do
    {
      do
      {
        return false;
      } while (((this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_b_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_b_of_type_Int != paramInt)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_b_of_type_JavaLangString)) || (!HttpUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.c)) || (!HttpUtil.a(this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.c)));
      l = System.currentTimeMillis() / 1000L;
    } while ((l <= this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_a_of_type_Long) || (l > this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNearbyVideoChatManager$BannerConfig.jdField_b_of_type_Long));
    return true;
  }
  
  public void c(String paramString)
  {
    b(paramString, false);
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.NearbyVideoChatManager
 * JD-Core Version:    0.7.0.1
 */