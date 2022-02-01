package com.tencent.mobileqq.data;

import android.text.TextUtils;
import anni;
import appoint.define.appoint_define.AppointInfo;
import appoint.define.appoint_define.DateComment;
import appoint.define.appoint_define.DateEvent;
import appoint.define.appoint_define.StrangerInfo;
import arkr;
import arkv;
import arkw;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.unique;
import org.json.JSONObject;

public class DateEventMsg
  extends Entity
  implements Comparable<DateEventMsg>
{
  public int attendIdx;
  public byte bDeleted;
  public byte bReaded;
  @notColumn
  public arkr date_comment;
  @notColumn
  public appoint_define.AppointInfo date_info;
  @unique
  public long event_id;
  @notColumn
  boolean isInited = false;
  public String msg_content;
  public byte[] msg_date_info;
  public String msg_user_info;
  @notColumn
  public String strReadableTime;
  @notColumn
  public String strTime;
  @notColumn
  public String str_event_tips;
  public long time;
  public int type;
  @notColumn
  public arkv user_info;
  
  public static DateEventMsg convertFrom(appoint_define.DateEvent paramDateEvent)
  {
    if (paramDateEvent == null) {
      return null;
    }
    DateEventMsg localDateEventMsg = new DateEventMsg();
    localDateEventMsg.event_id = paramDateEvent.uint64_event_id.get();
    localDateEventMsg.time = paramDateEvent.uint32_time.get();
    localDateEventMsg.type = paramDateEvent.uint32_type.get();
    localDateEventMsg.attendIdx = paramDateEvent.uint32_attend_idx.get();
    localDateEventMsg.bDeleted = 0;
    localDateEventMsg.bReaded = 0;
    if (paramDateEvent.msg_user_info.has())
    {
      localDateEventMsg.user_info = arkv.a((appoint_define.StrangerInfo)paramDateEvent.msg_user_info.get());
      label96:
      if (!paramDateEvent.msg_date_info.has()) {
        break label175;
      }
    }
    label175:
    for (localDateEventMsg.date_info = ((appoint_define.AppointInfo)paramDateEvent.msg_date_info.get());; localDateEventMsg.date_info = null) {
      switch (localDateEventMsg.type)
      {
      default: 
        localDateEventMsg.isInited = true;
        return localDateEventMsg;
        localDateEventMsg.msg_user_info = null;
        break label96;
      }
    }
    if (paramDateEvent.msg_comment.has()) {
      localDateEventMsg.date_comment = arkr.a((appoint_define.DateComment)paramDateEvent.msg_comment.get());
    }
    for (;;)
    {
      arkw.a("DateEventMsg.convertFrom", new Object[] { localDateEventMsg.date_comment });
      break;
      arkw.b("DateEventMsg.convertFrom", new Object[] { "msg_comment no value" });
    }
    localDateEventMsg.str_event_tips = paramDateEvent.str_event_tips.get();
    if (TextUtils.isEmpty(localDateEventMsg.str_event_tips)) {
      switch (localDateEventMsg.type)
      {
      }
    }
    for (;;)
    {
      arkw.a("DateEventMsg.convertFrom", new Object[] { paramDateEvent.str_event_tips.get(), localDateEventMsg.str_event_tips });
      break;
      localDateEventMsg.str_event_tips = anni.a(2131701575);
      continue;
      localDateEventMsg.str_event_tips = anni.a(2131701576);
      continue;
      localDateEventMsg.str_event_tips = anni.a(2131701577);
    }
  }
  
  public int compareTo(DateEventMsg paramDateEventMsg)
  {
    if ((paramDateEventMsg == null) || (this.event_id > paramDateEventMsg.event_id)) {
      return 1;
    }
    if (this.event_id == paramDateEventMsg.event_id) {
      return 0;
    }
    return -1;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {}
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
    } while (paramObject.getClass() != getClass());
    if (this.event_id == ((DateEventMsg)paramObject).event_id) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public void init()
  {
    if (this.isInited) {}
    label150:
    label202:
    do
    {
      return;
      this.isInited = true;
      try
      {
        if (TextUtils.isEmpty(this.msg_user_info)) {}
        for (this.user_info = null; (this.msg_date_info == null) || (this.msg_date_info.length == 0); this.user_info = arkv.a(new JSONObject(this.msg_user_info)))
        {
          this.date_info = null;
          if ((this.type != 1) && (this.type != 2)) {
            break label202;
          }
          try
          {
            if (!TextUtils.isEmpty(this.msg_content)) {
              break label150;
            }
            this.str_event_tips = "";
            return;
          }
          catch (Exception localException1)
          {
            localException1.printStackTrace();
            return;
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
          continue;
          this.date_info = new appoint_define.AppointInfo();
          try
          {
            this.date_info.mergeFrom(this.msg_date_info);
          }
          catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
          }
        }
        this.date_comment = arkr.a(new JSONObject(this.msg_content));
        arkw.a("DateEventMsg.init", new Object[] { Integer.valueOf(this.type), this.date_comment, this.msg_content });
        return;
      }
    } while ((this.type != 3) && (this.type != 4) && (this.type != 5));
    this.str_event_tips = this.msg_content;
  }
  
  public void prewrite()
  {
    Object localObject = arkv.a(this.user_info);
    if (localObject == null)
    {
      localObject = "";
      this.msg_user_info = ((String)localObject);
      if (this.date_info == null) {
        break label83;
      }
      this.msg_date_info = this.date_info.toByteArray();
      label38:
      if ((this.type != 1) && (this.type != 2)) {
        break label99;
      }
      localObject = arkr.a(this.date_comment);
      if (localObject != null) {
        break label91;
      }
      localObject = "";
      this.msg_content = ((String)localObject);
    }
    label83:
    label91:
    label99:
    while ((this.type != 3) && (this.type != 4) && (this.type != 5)) {
      for (;;)
      {
        return;
        localObject = ((JSONObject)localObject).toString();
        break;
        this.msg_date_info = null;
        break label38;
        localObject = ((JSONObject)localObject).toString();
      }
    }
    if (this.str_event_tips == null) {}
    for (localObject = "";; localObject = this.str_event_tips)
    {
      this.msg_content = ((String)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.DateEventMsg
 * JD-Core Version:    0.7.0.1
 */