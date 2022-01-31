package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="uinType,senderUin,recieverUin,msgType,entrance,entrance2,onlineStatus,terminal,isFirst")
public class MessageReportData
  extends Entity
{
  private static final String IMAME_MSG_FORMAT = "%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%d|";
  private static final String MSG_FORMAT = "%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|";
  private static final String TEXT_MSG_FORMAT = "%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%d|";
  public String entrance = "";
  public String entrance2 = "";
  public String isFirst = "";
  public int msgCount;
  public String msgSize = "";
  public String msgType = "";
  public String onlineStatus = "";
  public String recieverUin = "";
  public String senderUin = "";
  public String terminal = "";
  public String uinType = "";
  
  public MessageReportData() {}
  
  public MessageReportData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10)
  {
    this.uinType = paramString1;
    this.senderUin = paramString2;
    this.recieverUin = paramString3;
    this.msgType = paramString4;
    this.entrance = paramString5;
    this.entrance2 = paramString6;
    this.msgSize = paramString7;
    this.onlineStatus = paramString8;
    this.terminal = paramString9;
    this.isFirst = paramString10;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    label35:
    label50:
    label308:
    label313:
    for (;;)
    {
      return true;
      if (!(paramObject instanceof MessageReportData)) {
        break;
      }
      int i;
      label62:
      label197:
      if (this.uinType != null)
      {
        i = 1;
        if (((MessageReportData)paramObject).uinType == null) {
          break label308;
        }
        j = 1;
        label77:
        label212:
        if ((j ^ i) == 0)
        {
          if (this.senderUin == null) {
            break label313;
          }
          i = 1;
          if (((MessageReportData)paramObject).senderUin == null) {
            break label318;
          }
          j = 1;
          label89:
          label224:
          if ((j ^ i) == 0)
          {
            if (this.recieverUin == null) {
              break label323;
            }
            i = 1;
            if (((MessageReportData)paramObject).recieverUin == null) {
              break label328;
            }
            j = 1;
            label104:
            label239:
            if ((j ^ i) == 0)
            {
              if (this.msgType == null) {
                break label333;
              }
              i = 1;
              if (((MessageReportData)paramObject).msgType == null) {
                break label338;
              }
              j = 1;
              label116:
              if ((j ^ i) == 0)
              {
                if (this.entrance == null) {
                  break label343;
                }
                i = 1;
                if (((MessageReportData)paramObject).entrance == null) {
                  break label348;
                }
                j = 1;
                if ((j ^ i) == 0)
                {
                  if (this.entrance2 == null) {
                    break label353;
                  }
                  i = 1;
                  if (((MessageReportData)paramObject).entrance2 == null) {
                    break label358;
                  }
                  j = 1;
                  if ((j ^ i) == 0)
                  {
                    if (this.msgSize == null) {
                      break label363;
                    }
                    i = 1;
                    if (((MessageReportData)paramObject).msgSize == null) {
                      break label368;
                    }
                    j = 1;
                    if ((j ^ i) == 0)
                    {
                      if (this.onlineStatus == null) {
                        break label373;
                      }
                      i = 1;
                      if (((MessageReportData)paramObject).onlineStatus == null) {
                        break label378;
                      }
                      j = 1;
                      if ((j ^ i) == 0)
                      {
                        if (this.terminal == null) {
                          break label383;
                        }
                        i = 1;
                        if (((MessageReportData)paramObject).terminal == null) {
                          break label388;
                        }
                        j = 1;
                        label251:
                        if ((j ^ i) == 0)
                        {
                          if (this.isFirst == null) {
                            break label393;
                          }
                          i = 1;
                          if (((MessageReportData)paramObject).isFirst == null) {
                            break label398;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      label185:
      for (int j = 1;; j = 0)
      {
        if (((j ^ i) == 0) && (getWholeMsgReport().equals(((MessageReportData)paramObject).getWholeMsgReport()))) {
          break label401;
        }
        return false;
        i = 0;
        break;
        j = 0;
        break label35;
        i = 0;
        break label50;
        label318:
        j = 0;
        break label62;
        label323:
        i = 0;
        break label77;
        label328:
        j = 0;
        break label89;
        label333:
        i = 0;
        break label104;
        label338:
        j = 0;
        break label116;
        label343:
        i = 0;
        break label131;
        label348:
        j = 0;
        break label143;
        label353:
        i = 0;
        break label158;
        label358:
        j = 0;
        break label170;
        label363:
        i = 0;
        break label185;
        label368:
        j = 0;
        break label197;
        label373:
        i = 0;
        break label212;
        label378:
        j = 0;
        break label224;
        label383:
        i = 0;
        break label239;
        j = 0;
        break label251;
        i = 0;
        break label266;
      }
    }
    label131:
    label143:
    label158:
    label170:
    return super.equals(paramObject);
  }
  
  public String getMsgReport()
  {
    if ((this.entrance2 != null) && (this.entrance2.equals(""))) {
      return String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%d|", new Object[] { this.uinType, this.senderUin, this.recieverUin, this.msgType, this.entrance, this.entrance2, this.msgSize, this.onlineStatus, this.terminal, this.isFirst, Integer.valueOf(this.msgCount) });
    }
    return String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%d|", new Object[] { this.uinType, this.senderUin, this.recieverUin, this.msgType, this.entrance, this.entrance2, this.msgSize, this.onlineStatus, this.terminal, this.isFirst, Integer.valueOf(this.msgCount) });
  }
  
  public String getWholeMsgReport()
  {
    return String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|", new Object[] { this.uinType, this.senderUin, this.recieverUin, this.msgType, this.entrance, this.entrance2, this.msgSize, this.onlineStatus, this.terminal, this.isFirst });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageReportData
 * JD-Core Version:    0.7.0.1
 */