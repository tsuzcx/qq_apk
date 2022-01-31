package com.tencent.mobileqq.confess;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItemExtMsg;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONObject;
import tencent.im.confess.common.RedpointInfo;

public class FrdConfessInfo
{
  public int a;
  public long a;
  public String a;
  public boolean a;
  public int b;
  public String b;
  public String c = "";
  private String d;
  private String e;
  
  public FrdConfessInfo(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.e = paramString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {}
    label171:
    do
    {
      return;
      this.jdField_a_of_type_Boolean = true;
      this.d = SharedPreUtils.a(this.e, "confess_config_sp").getString("key_frd_rec_confess_info", "");
      if (!TextUtils.isEmpty(this.d)) {}
      try
      {
        JSONObject localJSONObject = new JSONObject(this.d);
        if (localJSONObject.has("nUnReadCnt")) {
          this.jdField_a_of_type_Int = localJSONObject.getInt("nUnReadCnt");
        }
        if (localJSONObject.has("lLastMsgTime")) {
          this.jdField_a_of_type_Long = localJSONObject.getLong("lLastMsgTime");
        }
        if (localJSONObject.has("nTopicId")) {
          this.jdField_b_of_type_Int = localJSONObject.getInt("nTopicId");
        }
        if (localJSONObject.has("strTopicDesc")) {
          this.c = localJSONObject.getString("strTopicDesc");
        }
        if (localJSONObject.has("strFrdUin")) {
          this.jdField_a_of_type_JavaLangString = localJSONObject.getString("strFrdUin");
        }
        if (localJSONObject.has("strFrdNick")) {
          this.jdField_b_of_type_JavaLangString = localJSONObject.getString("strFrdNick");
        }
      }
      catch (Exception localException)
      {
        break label171;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("FrdConfessInfo", 4, String.format(Locale.getDefault(), "init strJsonStr: %s", new Object[] { this.d }));
  }
  
  public void a(RedTouchItem paramRedTouchItem)
  {
    if (paramRedTouchItem == null) {
      return;
    }
    int i;
    Object localObject;
    if (paramRedTouchItem.unReadFlag)
    {
      i = paramRedTouchItem.count;
      this.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Long = paramRedTouchItem.lastRecvTime;
      if ((paramRedTouchItem.extMsgs == null) || (paramRedTouchItem.extMsgs.size() <= 0)) {
        break label232;
      }
      localObject = null;
      Iterator localIterator = paramRedTouchItem.extMsgs.iterator();
      i = 0;
      paramRedTouchItem = (RedTouchItem)localObject;
      label67:
      if (!localIterator.hasNext()) {
        break label111;
      }
      localObject = (RedTouchItemExtMsg)localIterator.next();
      if (((RedTouchItemExtMsg)localObject).time <= i) {
        break label258;
      }
      i = ((RedTouchItemExtMsg)localObject).time;
      paramRedTouchItem = (RedTouchItem)localObject;
    }
    label258:
    for (;;)
    {
      break label67;
      i = 0;
      break;
      try
      {
        label111:
        localObject = new RedpointInfo();
        ((RedpointInfo)localObject).mergeFrom(paramRedTouchItem.bytesData);
        if (((RedpointInfo)localObject).data.has())
        {
          paramRedTouchItem = new JSONObject(((RedpointInfo)localObject).data.get());
          if (paramRedTouchItem.has("topicId")) {
            this.jdField_b_of_type_Int = paramRedTouchItem.getInt("topicId");
          }
          if (paramRedTouchItem.has("topicDesc")) {
            this.c = paramRedTouchItem.getString("topicDesc");
          }
          if (paramRedTouchItem.has("frdUin")) {
            this.jdField_a_of_type_JavaLangString = String.valueOf(paramRedTouchItem.getLong("frdUin"));
          }
          if (paramRedTouchItem.has("frdNick")) {
            this.jdField_b_of_type_JavaLangString = paramRedTouchItem.getString("frdNick");
          }
        }
      }
      catch (Exception paramRedTouchItem)
      {
        for (;;)
        {
          label232:
          if (QLog.isColorLevel()) {
            QLog.e("FrdConfessInfo", 2, paramRedTouchItem, new Object[0]);
          }
        }
      }
      b();
      return;
    }
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.c));
  }
  
  public void b()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("nUnReadCnt", this.jdField_a_of_type_Int);
      localJSONObject.put("lLastMsgTime", this.jdField_a_of_type_Long);
      localJSONObject.put("nTopicId", this.jdField_b_of_type_Int);
      localJSONObject.put("strTopicDesc", this.c);
      localJSONObject.put("strFrdUin", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("strFrdNick", this.jdField_b_of_type_JavaLangString);
      this.d = localJSONObject.toString();
      SharedPreUtils.a(this.e, "confess_config_sp").edit().putString("key_frd_rec_confess_info", this.d).apply();
      label112:
      if (QLog.isColorLevel()) {
        QLog.e("FrdConfessInfo", 2, String.format(Locale.getDefault(), "updateJsonStr str: %s", new Object[] { this.d }));
      }
      return;
    }
    catch (Exception localException)
    {
      break label112;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("{isInit = ").append(this.jdField_a_of_type_Boolean).append(", nUnReadCnt = ").append(this.jdField_a_of_type_Int).append(", lLastMsgTime = ").append(this.jdField_a_of_type_Long).append(", nTopicId = ").append(this.jdField_b_of_type_Int).append(", strTopicDesc = ").append(this.c).append(", strFrdUin = ").append(this.jdField_a_of_type_JavaLangString).append(", strFrdNick = ").append(this.jdField_b_of_type_JavaLangString).append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.confess.FrdConfessInfo
 * JD-Core Version:    0.7.0.1
 */