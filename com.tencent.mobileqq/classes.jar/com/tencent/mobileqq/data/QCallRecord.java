package com.tencent.mobileqq.data;

import abwz;
import amtj;
import android.text.TextUtils;
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
  public int contactId = -1;
  public String friendUin;
  public int isVideo;
  public int issend = 1;
  public byte[] msgData;
  public String senderuin;
  public int state;
  public String talkTime;
  public long time;
  public int type = TYPE_REALRECORD;
  public int uinType;
  public long uniseq;
  public int versionCode = 1;
  
  public QCallRecord()
  {
    this(TYPE_REALRECORD);
  }
  
  public QCallRecord(int paramInt)
  {
    this.type = paramInt;
    if (paramInt == TYPE_REALRECORD) {
      createMessageUniseq();
    }
  }
  
  public static String getTableName(String paramString, int paramInt)
  {
    return "qc_" + paramInt + "_" + abwz.a(paramString);
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
      return amtj.a(2131708693);
    }
    if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) + 1 == localCalendar2.get(6))) {
      return amtj.a(2131708691);
    }
    if ((localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) > localCalendar2.get(6) - 7)) {}
    switch (localCalendar1.get(7))
    {
    default: 
      return new SimpleDateFormat("yy-MM-dd").format(localDate);
    case 1: 
      return amtj.a(2131708685);
    case 2: 
      return amtj.a(2131708688);
    case 3: 
      return amtj.a(2131708687);
    case 4: 
      return amtj.a(2131708689);
    case 5: 
      return amtj.a(2131708692);
    case 6: 
      return amtj.a(2131708695);
    }
    return amtj.a(2131708690);
  }
  
  public String getTableName()
  {
    return getTableName(this.friendUin, this.uinType);
  }
  
  public String getTalkTimeMinute()
  {
    int j = 0;
    if (TextUtils.isEmpty(this.talkTime)) {
      return "";
    }
    Object localObject = this.talkTime;
    long l1;
    long l3;
    if (this.uinType == 3000)
    {
      long l2 = Long.parseLong(this.talkTime);
      localObject = "00:00";
      if (l2 > 0L)
      {
        l1 = l2 % 60L;
        l3 = l2 / 60L;
        l2 = l3 / 60L;
        l3 %= 60L;
        if (l2 <= 0L) {
          break label283;
        }
        localObject = String.format(Locale.CHINA, "%02d:%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1) });
      }
    }
    int i;
    int k;
    if ((localObject != null) && (!((String)localObject).equals("")) && (((String)localObject).split(":").length >= 2))
    {
      localObject = ((String)localObject).split(":");
      if (localObject.length == 2)
      {
        j = Integer.parseInt(localObject[0]);
        i = Integer.parseInt(localObject[1]);
        k = 0;
      }
    }
    for (;;)
    {
      label189:
      if (k != 0) {}
      for (localObject = "" + k + amtj.a(2131708686);; localObject = "")
      {
        if (j != 0) {
          localObject = (String)localObject + j + amtj.a(2131708694);
        }
        for (;;)
        {
          return (String)localObject + i + amtj.a(2131708684);
          label283:
          localObject = String.format(Locale.CHINA, "%02d:%02d", new Object[] { Long.valueOf(l3), Long.valueOf(l1) });
          break;
          if (localObject.length != 3) {
            break label363;
          }
          k = Integer.parseInt(localObject[0]);
          j = Integer.parseInt(localObject[1]);
          i = Integer.parseInt(localObject[2]);
          break label189;
          return "";
        }
      }
      label363:
      i = 0;
      k = 0;
    }
  }
  
  public String getTime()
  {
    return android.text.format.DateFormat.getTimeFormat(BaseApplication.getContext()).format(new Date(this.time * 1000L));
  }
  
  public boolean isMissCall()
  {
    if (this.uinType != 3000)
    {
      if ((this.issend != 0) || ((12 != this.state) && (10 != this.state) && (6 != this.state))) {}
    }
    else {
      while ((this.issend == 0) && (this.state == 2)) {
        return true;
      }
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
    return "QCallRecord [state=" + this.state + ", time=" + this.time + ", talkTime=" + this.talkTime + ", type=" + this.type + ", friendUin=" + this.friendUin + ", uinType=" + this.uinType + ", uniseq=" + this.uniseq + ", issend=" + this.issend + ", msgData=" + Arrays.toString(this.msgData) + ", senderuin=" + this.senderuin + ", isVideo=" + this.isVideo + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.QCallRecord
 * JD-Core Version:    0.7.0.1
 */