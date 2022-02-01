package com.tencent.mobileqq.data;

import android.text.TextUtils;
import appoint.define.appoint_define.AppointInfo;
import appoint.define.appoint_define.DateComment;
import appoint.define.appoint_define.DateEvent;
import appoint.define.appoint_define.StrangerInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.dating.DatingComment;
import com.tencent.mobileqq.dating.DatingStranger;
import com.tencent.mobileqq.dating.DatingUtil;
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
  public DatingComment date_comment;
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
  public DatingStranger user_info;
  
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
    if (paramDateEvent.msg_user_info.has()) {
      localDateEventMsg.user_info = DatingStranger.a((appoint_define.StrangerInfo)paramDateEvent.msg_user_info.get());
    } else {
      localDateEventMsg.msg_user_info = null;
    }
    if (paramDateEvent.msg_date_info.has()) {
      localDateEventMsg.date_info = ((appoint_define.AppointInfo)paramDateEvent.msg_date_info.get());
    } else {
      localDateEventMsg.date_info = null;
    }
    int i = localDateEventMsg.type;
    if ((i != 1) && (i != 2))
    {
      if ((i == 3) || (i == 4) || (i == 5))
      {
        localDateEventMsg.str_event_tips = paramDateEvent.str_event_tips.get();
        if (TextUtils.isEmpty(localDateEventMsg.str_event_tips))
        {
          i = localDateEventMsg.type;
          if (i != 3)
          {
            if (i != 4)
            {
              if (i == 5) {
                localDateEventMsg.str_event_tips = HardCodeUtil.a(2131702950);
              }
            }
            else {
              localDateEventMsg.str_event_tips = HardCodeUtil.a(2131702949);
            }
          }
          else {
            localDateEventMsg.str_event_tips = HardCodeUtil.a(2131702948);
          }
        }
        DatingUtil.a("DateEventMsg.convertFrom", new Object[] { paramDateEvent.str_event_tips.get(), localDateEventMsg.str_event_tips });
      }
    }
    else
    {
      if (paramDateEvent.msg_comment.has()) {
        localDateEventMsg.date_comment = DatingComment.a((appoint_define.DateComment)paramDateEvent.msg_comment.get());
      } else {
        DatingUtil.b("DateEventMsg.convertFrom", new Object[] { "msg_comment no value" });
      }
      DatingUtil.a("DateEventMsg.convertFrom", new Object[] { localDateEventMsg.date_comment });
    }
    localDateEventMsg.isInited = true;
    return localDateEventMsg;
  }
  
  public int compareTo(DateEventMsg paramDateEventMsg)
  {
    if (paramDateEventMsg != null)
    {
      long l1 = this.event_id;
      long l2 = paramDateEventMsg.event_id;
      if (l1 <= l2)
      {
        if (l1 == l2) {
          return 0;
        }
        return -1;
      }
    }
    return 1;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = false;
    if (paramObject == null) {
      return false;
    }
    if (paramObject == this) {
      return true;
    }
    if (paramObject.getClass() != getClass()) {
      return false;
    }
    if (this.event_id == ((DateEventMsg)paramObject).event_id) {
      bool = true;
    }
    return bool;
  }
  
  public void init()
  {
    if (this.isInited) {
      return;
    }
    this.isInited = true;
    try
    {
      if (TextUtils.isEmpty(this.msg_user_info)) {
        this.user_info = null;
      } else {
        this.user_info = DatingStranger.a(new JSONObject(this.msg_user_info));
      }
    }
    catch (Exception localException1)
    {
      localException1.printStackTrace();
    }
    byte[] arrayOfByte = this.msg_date_info;
    if ((arrayOfByte != null) && (arrayOfByte.length != 0))
    {
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
    else
    {
      this.date_info = null;
    }
    int i = this.type;
    if ((i != 1) && (i != 2))
    {
      if ((i == 3) || (i == 4) || (i == 5)) {
        this.str_event_tips = this.msg_content;
      }
    }
    else {
      try
      {
        if (TextUtils.isEmpty(this.msg_content))
        {
          this.str_event_tips = "";
          return;
        }
        this.date_comment = DatingComment.a(new JSONObject(this.msg_content));
        DatingUtil.a("DateEventMsg.init", new Object[] { Integer.valueOf(this.type), this.date_comment, this.msg_content });
        return;
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
  }
  
  protected void prewrite()
  {
    Object localObject = DatingStranger.a(this.user_info);
    String str = "";
    if (localObject == null) {
      localObject = "";
    } else {
      localObject = ((JSONObject)localObject).toString();
    }
    this.msg_user_info = ((String)localObject);
    localObject = this.date_info;
    if (localObject != null) {
      this.msg_date_info = ((appoint_define.AppointInfo)localObject).toByteArray();
    } else {
      this.msg_date_info = null;
    }
    int i = this.type;
    if ((i != 1) && (i != 2))
    {
      if ((i == 3) || (i == 4) || (i == 5))
      {
        str = this.str_event_tips;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        this.msg_content = ((String)localObject);
      }
    }
    else
    {
      localObject = DatingComment.a(this.date_comment);
      if (localObject == null) {
        localObject = str;
      } else {
        localObject = ((JSONObject)localObject).toString();
      }
      this.msg_content = ((String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.DateEventMsg
 * JD-Core Version:    0.7.0.1
 */