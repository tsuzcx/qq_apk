package com.tencent.mobileqq.data;

import android.text.TextUtils;
import android.util.Base64;
import appoint.define.appoint_define.CommonLabel;
import appoint.define.appoint_define.PublisherInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class StrangerInfo
  extends Entity
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  public int age;
  public int charm;
  public int charmLevel;
  public int chatFlag;
  public int chatupCount;
  public String constellation;
  public String distance;
  public int gender;
  public int godFlag;
  public String interestNameStr;
  @notColumn
  public ArrayList<String> interestNames = new ArrayList();
  public String interestTypeStr;
  @notColumn
  public ArrayList<Integer> interestTypes = new ArrayList();
  @notColumn
  public boolean isNewVisitor;
  public int lableId;
  public byte[] lableMsgLast;
  public byte[] lableMsgPre;
  public int marriage;
  public String nickName;
  public int profession;
  public int pubNumber;
  public int recentVisitorTime;
  public int recommend;
  public byte[] strangerDeclare;
  @notColumn
  public String timeStr;
  public long tinyId;
  public long uin;
  public String vipInfo;
  
  public static StrangerInfo convertFrom(appoint_define.PublisherInfo paramPublisherInfo)
  {
    JSONObject localJSONObject1 = null;
    if (paramPublisherInfo == null) {
      return null;
    }
    StrangerInfo localStrangerInfo = new StrangerInfo();
    boolean bool = paramPublisherInfo.uint32_age.has();
    int j = 0;
    if (bool) {
      i = paramPublisherInfo.uint32_age.get();
    } else {
      i = 0;
    }
    localStrangerInfo.age = i;
    if (paramPublisherInfo.uint32_charm.has()) {
      i = paramPublisherInfo.uint32_charm.get();
    } else {
      i = 0;
    }
    localStrangerInfo.charm = i;
    if (paramPublisherInfo.uint32_charm_level.has()) {
      i = paramPublisherInfo.uint32_charm_level.get();
    } else {
      i = 0;
    }
    localStrangerInfo.charmLevel = i;
    if (paramPublisherInfo.uint32_chatflag.has()) {
      i = paramPublisherInfo.uint32_chatflag.get();
    } else {
      i = 0;
    }
    localStrangerInfo.chatFlag = i;
    if (paramPublisherInfo.uint32_chatup_count.has()) {
      i = paramPublisherInfo.uint32_chatup_count.get();
    } else {
      i = 0;
    }
    localStrangerInfo.chatupCount = i;
    bool = paramPublisherInfo.str_constellation.has();
    String str1 = "";
    Object localObject1;
    if (bool) {
      localObject1 = paramPublisherInfo.str_constellation.get();
    } else {
      localObject1 = "";
    }
    localStrangerInfo.constellation = ((String)localObject1);
    if (paramPublisherInfo.str_distance.has()) {
      localObject1 = paramPublisherInfo.str_distance.get();
    } else {
      localObject1 = "";
    }
    localStrangerInfo.distance = ((String)localObject1);
    if (paramPublisherInfo.uint32_gender.has()) {
      i = paramPublisherInfo.uint32_gender.get();
    } else {
      i = 0;
    }
    localStrangerInfo.gender = i;
    if (paramPublisherInfo.uint32_godflag.has()) {
      i = paramPublisherInfo.uint32_godflag.get();
    } else {
      i = 0;
    }
    localStrangerInfo.godFlag = i;
    bool = paramPublisherInfo.uint64_tinyid.has();
    long l2 = 0L;
    if (bool) {
      l1 = paramPublisherInfo.uint64_tinyid.get();
    } else {
      l1 = 0L;
    }
    localStrangerInfo.tinyId = l1;
    if (paramPublisherInfo.bytes_nickname.has()) {
      localObject1 = paramPublisherInfo.bytes_nickname.get().toStringUtf8();
    } else {
      localObject1 = "";
    }
    localStrangerInfo.nickName = ((String)localObject1);
    if (paramPublisherInfo.uint32_marriage.has()) {
      i = paramPublisherInfo.uint32_marriage.get();
    } else {
      i = 0;
    }
    localStrangerInfo.marriage = i;
    if (paramPublisherInfo.uint32_profession.has()) {
      i = paramPublisherInfo.uint32_profession.get();
    } else {
      i = 0;
    }
    localStrangerInfo.profession = i;
    if (paramPublisherInfo.uint32_recent_vistor_time.has()) {
      i = paramPublisherInfo.uint32_recent_vistor_time.get();
    } else {
      i = 0;
    }
    localStrangerInfo.recentVisitorTime = i;
    if (paramPublisherInfo.str_vipinfo.has()) {
      localObject1 = paramPublisherInfo.str_vipinfo.get();
    } else {
      localObject1 = "";
    }
    localStrangerInfo.vipInfo = ((String)localObject1);
    if (paramPublisherInfo.uint32_recommend.has()) {
      i = paramPublisherInfo.uint32_recommend.get();
    } else {
      i = 0;
    }
    localStrangerInfo.recommend = i;
    if (paramPublisherInfo.uint32_pub_number.has()) {
      i = paramPublisherInfo.uint32_pub_number.get();
    } else {
      i = 0;
    }
    localStrangerInfo.pubNumber = i;
    long l1 = l2;
    if (paramPublisherInfo.uint64_friend_uin.has()) {
      l1 = paramPublisherInfo.uint64_friend_uin.get();
    }
    localStrangerInfo.uin = l1;
    if (paramPublisherInfo.bytes_stranger_declare.has()) {
      localObject1 = Base64.decode(paramPublisherInfo.bytes_stranger_declare.get().toByteArray(), 0);
    } else {
      localObject1 = null;
    }
    localStrangerInfo.strangerDeclare = ((byte[])localObject1);
    if ((paramPublisherInfo.uint32_history_flag.has()) && (paramPublisherInfo.uint32_history_flag.get() == 1)) {
      localStrangerInfo.isNewVisitor = false;
    } else {
      localStrangerInfo.isNewVisitor = true;
    }
    if (paramPublisherInfo.msg_common_label.has()) {
      paramPublisherInfo = (appoint_define.CommonLabel)paramPublisherInfo.msg_common_label.get();
    } else {
      paramPublisherInfo = null;
    }
    if (paramPublisherInfo != null)
    {
      i = j;
      if (paramPublisherInfo.uint32_lable_id.has()) {
        i = paramPublisherInfo.uint32_lable_id.get();
      }
      localStrangerInfo.lableId = i;
      if (paramPublisherInfo.bytes_lable_msg_pre.has()) {
        localObject1 = paramPublisherInfo.bytes_lable_msg_pre.get().toByteArray();
      } else {
        localObject1 = null;
      }
      localStrangerInfo.lableMsgPre = ((byte[])localObject1);
      if (paramPublisherInfo.bytes_lable_msg_last.has()) {
        localObject1 = paramPublisherInfo.bytes_lable_msg_last.get().toByteArray();
      } else {
        localObject1 = null;
      }
      localStrangerInfo.lableMsgLast = ((byte[])localObject1);
      if (paramPublisherInfo.rpt_interst_name.has()) {
        localObject1 = paramPublisherInfo.rpt_interst_name.get();
      } else {
        localObject1 = null;
      }
      Object localObject3;
      if (localObject1 != null)
      {
        localObject3 = new ArrayList();
        JSONObject localJSONObject2 = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          String str2 = ((ByteStringMicro)((Iterator)localObject1).next()).toStringUtf8();
          ((ArrayList)localObject3).add(str2);
          localJSONArray.put(str2);
        }
        localStrangerInfo.interestNames = ((ArrayList)localObject3);
        try
        {
          localJSONObject2.put("interestNames", localJSONArray);
          localStrangerInfo.interestNameStr = localJSONObject2.toString();
        }
        catch (JSONException localJSONException)
        {
          if (QLog.isDevelopLevel()) {
            localJSONException.printStackTrace();
          }
        }
      }
      Object localObject2 = localJSONObject1;
      if (paramPublisherInfo.rpt_interst_type.has()) {
        localObject2 = paramPublisherInfo.rpt_interst_type.get();
      }
      if (localObject2 != null)
      {
        paramPublisherInfo = new ArrayList();
        localJSONObject1 = new JSONObject();
        localObject3 = new JSONArray();
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          i = ((Integer)((Iterator)localObject2).next()).intValue();
          paramPublisherInfo.add(Integer.valueOf(i));
          ((JSONArray)localObject3).put(i);
        }
        localStrangerInfo.interestTypes = paramPublisherInfo;
        try
        {
          localJSONObject1.put("interestTypes", localObject3);
          localStrangerInfo.interestTypeStr = localJSONObject1.toString();
        }
        catch (JSONException paramPublisherInfo)
        {
          if (QLog.isDevelopLevel()) {
            paramPublisherInfo.printStackTrace();
          }
        }
      }
    }
    int i = localStrangerInfo.recentVisitorTime;
    paramPublisherInfo = str1;
    if (i > 0) {
      paramPublisherInfo = TimeFormatterUtils.a(i * 1000L, true, "yyyy-MM-dd");
    }
    localStrangerInfo.timeStr = paramPublisherInfo;
    return localStrangerInfo;
  }
  
  protected void postRead()
  {
    super.postRead();
    int i = this.recentVisitorTime;
    if (i > 0) {
      this.timeStr = TimeFormatterUtils.a(i * 1000L, true, "yyyy-MM-dd");
    }
    boolean bool = TextUtils.isEmpty(this.interestNameStr);
    int j = 0;
    if (!bool) {
      try
      {
        JSONArray localJSONArray1 = new JSONObject(this.interestNameStr).getJSONArray("interestNames");
        if (localJSONArray1 != null)
        {
          i = 0;
          while (i < localJSONArray1.length())
          {
            String str = localJSONArray1.getString(i);
            if (!TextUtils.isEmpty(str)) {
              this.interestNames.add(str);
            }
            i += 1;
          }
        }
        if (TextUtils.isEmpty(this.interestTypeStr)) {
          return;
        }
      }
      catch (JSONException localJSONException1)
      {
        if (QLog.isDevelopLevel()) {
          localJSONException1.printStackTrace();
        }
      }
    } else {
      try
      {
        JSONArray localJSONArray2 = new JSONObject(this.interestTypeStr).getJSONArray("interestTypes");
        if (localJSONArray2 != null)
        {
          i = j;
          while (i < localJSONArray2.length())
          {
            this.interestTypes.add(Integer.valueOf(localJSONArray2.getInt(i)));
            i += 1;
          }
        }
        return;
      }
      catch (JSONException localJSONException2)
      {
        if (QLog.isDevelopLevel()) {
          localJSONException2.printStackTrace();
        }
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Class localClass = getClass();
    for (;;)
    {
      int i;
      label32:
      Object localObject;
      String str;
      if (localClass != Entity.class)
      {
        Field[] arrayOfField = localClass.getDeclaredFields();
        int j = arrayOfField.length;
        i = 0;
        if (i < j)
        {
          localObject = arrayOfField[i];
          if (!Modifier.isStatic(((Field)localObject).getModifiers()))
          {
            if (!((Field)localObject).isAccessible()) {
              ((Field)localObject).setAccessible(true);
            }
            str = ((Field)localObject).getName();
          }
        }
      }
      try
      {
        localObject = ((Field)localObject).get(this);
        localStringBuilder.append(',');
        localStringBuilder.append(str);
        localStringBuilder.append('=');
        localStringBuilder.append(localObject);
        label118:
        i += 1;
        break label32;
        localClass = localClass.getSuperclass();
        continue;
        return localStringBuilder.toString();
      }
      catch (Exception localException)
      {
        break label118;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.StrangerInfo
 * JD-Core Version:    0.7.0.1
 */