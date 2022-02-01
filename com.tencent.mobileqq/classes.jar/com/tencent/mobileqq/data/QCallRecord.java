package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.imcore.message.UinMD5Cache;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.BaseApplication;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class QCallRecord
  extends Entity
{
  private static final int Kilo = 1000;
  public static int TYPE_DATE = 0;
  public static int TYPE_REALRECORD = 1;
  public static final int VERSION_CODE = 1;
  public int contactId;
  public String friendUin;
  public int isVideo;
  public int issend;
  public byte[] msgData;
  public String senderuin;
  public int state;
  public String talkTime;
  public long time;
  public int type;
  public int uinType;
  public long uniseq;
  public int versionCode;
  
  public QCallRecord()
  {
    this(TYPE_REALRECORD);
  }
  
  public QCallRecord(int paramInt)
  {
    int i = TYPE_REALRECORD;
    this.type = i;
    this.issend = 1;
    this.versionCode = 1;
    this.contactId = -1;
    this.type = paramInt;
    if (paramInt == i) {
      createMessageUniseq();
    }
  }
  
  public static String getTableName(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qc_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(UinMD5Cache.a(paramString));
    return localStringBuilder.toString();
  }
  
  public void createMessageUniseq()
  {
    this.uniseq = ((int)this.time);
    if (this.uniseq == 0L) {
      this.uniseq = ((int)(System.currentTimeMillis() / 1000L));
    }
    this.uniseq = (this.uniseq << 32 | Math.abs(new Random().nextInt()));
  }
  
  public int getDate()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(this.time * 1000L);
    return localCalendar.get(5);
  }
  
  public String getDateString()
  {
    Calendar localCalendar1 = Calendar.getInstance();
    Date localDate = new Date(this.time * 1000L);
    localCalendar1.setTime(localDate);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(System.currentTimeMillis());
    if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6))) {
      return HardCodeUtil.a(2131709565);
    }
    if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) + 1 == localCalendar2.get(6))) {
      return HardCodeUtil.a(2131709563);
    }
    if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) > localCalendar2.get(6) - 7)) {
      switch (localCalendar1.get(7))
      {
      default: 
        break;
      case 7: 
        return HardCodeUtil.a(2131709562);
      case 6: 
        return HardCodeUtil.a(2131709567);
      case 5: 
        return HardCodeUtil.a(2131709564);
      case 4: 
        return HardCodeUtil.a(2131709561);
      case 3: 
        return HardCodeUtil.a(2131709559);
      case 2: 
        return HardCodeUtil.a(2131709560);
      case 1: 
        return HardCodeUtil.a(2131709557);
      }
    }
    return new SimpleDateFormat("yy-MM-dd").format(localDate);
  }
  
  public String getTableName()
  {
    return getTableName(this.friendUin, this.uinType);
  }
  
  public String getTalkTimeMinute()
  {
    boolean bool = TextUtils.isEmpty(this.talkTime);
    Object localObject2 = "";
    if (bool) {
      return "";
    }
    String str = this.talkTime;
    int i = this.uinType;
    int k = 0;
    Object localObject1 = str;
    if (i == 3000)
    {
      long l2 = Long.parseLong(str);
      if (l2 > 0L)
      {
        long l1 = l2 % 60L;
        long l3 = l2 / 60L;
        l2 = l3 / 60L;
        l3 %= 60L;
        if (l2 > 0L) {
          localObject1 = String.format(Locale.CHINA, "%02d:%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1) });
        } else {
          localObject1 = String.format(Locale.CHINA, "%02d:%02d", new Object[] { Long.valueOf(l3), Long.valueOf(l1) });
        }
      }
      else
      {
        localObject1 = "00:00";
      }
    }
    if ((localObject1 != null) && (!((String)localObject1).equals("")) && (((String)localObject1).split(":").length >= 2))
    {
      localObject1 = ((String)localObject1).split(":");
      int j;
      if (localObject1.length == 2)
      {
        j = Integer.parseInt(localObject1[0]);
        i = Integer.parseInt(localObject1[1]);
      }
      else if (localObject1.length == 3)
      {
        k = Integer.parseInt(localObject1[0]);
        j = Integer.parseInt(localObject1[1]);
        i = Integer.parseInt(localObject1[2]);
      }
      else
      {
        i = 0;
        j = 0;
      }
      localObject1 = localObject2;
      if (k != 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(k);
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131709558));
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (j != 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append(HardCodeUtil.a(2131709566));
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(HardCodeUtil.a(2131709556));
      return ((StringBuilder)localObject1).toString();
    }
    return "";
  }
  
  public String getTime()
  {
    return android.text.format.DateFormat.getTimeFormat(BaseApplication.getContext()).format(new Date(this.time * 1000L));
  }
  
  public boolean isMissCall()
  {
    if (this.uinType != 3000)
    {
      if (this.issend == 0)
      {
        int i = this.state;
        if ((12 == i) || (10 == i) || (6 == i)) {
          return true;
        }
      }
    }
    else if ((this.issend == 0) && (this.state == 2)) {
      return true;
    }
    return false;
  }
  
  public boolean isSender()
  {
    return this.issend == 1;
  }
  
  public boolean isVideo()
  {
    return this.isVideo == 1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCallRecord [state=");
    localStringBuilder.append(this.state);
    localStringBuilder.append(", time=");
    localStringBuilder.append(this.time);
    localStringBuilder.append(", talkTime=");
    localStringBuilder.append(this.talkTime);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", friendUin=");
    localStringBuilder.append(this.friendUin);
    localStringBuilder.append(", uinType=");
    localStringBuilder.append(this.uinType);
    localStringBuilder.append(", uniseq=");
    localStringBuilder.append(this.uniseq);
    localStringBuilder.append(", issend=");
    localStringBuilder.append(this.issend);
    localStringBuilder.append(", msgData=");
    localStringBuilder.append(Arrays.toString(this.msgData));
    localStringBuilder.append(", senderuin=");
    localStringBuilder.append(this.senderuin);
    localStringBuilder.append(", isVideo=");
    localStringBuilder.append(this.isVideo);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.QCallRecord
 * JD-Core Version:    0.7.0.1
 */