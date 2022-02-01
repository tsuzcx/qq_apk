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
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof MessageReportData))
    {
      int i;
      if (this.uinType != null) {
        i = 1;
      } else {
        i = 0;
      }
      paramObject = (MessageReportData)paramObject;
      int j;
      if (paramObject.uinType != null) {
        j = 1;
      } else {
        j = 0;
      }
      if ((i ^ j) == 0)
      {
        if (this.senderUin != null) {
          i = 1;
        } else {
          i = 0;
        }
        if (paramObject.senderUin != null) {
          j = 1;
        } else {
          j = 0;
        }
        if ((i ^ j) == 0)
        {
          if (this.recieverUin != null) {
            i = 1;
          } else {
            i = 0;
          }
          if (paramObject.recieverUin != null) {
            j = 1;
          } else {
            j = 0;
          }
          if ((i ^ j) == 0)
          {
            if (this.msgType != null) {
              i = 1;
            } else {
              i = 0;
            }
            if (paramObject.msgType != null) {
              j = 1;
            } else {
              j = 0;
            }
            if ((i ^ j) == 0)
            {
              if (this.entrance != null) {
                i = 1;
              } else {
                i = 0;
              }
              if (paramObject.entrance != null) {
                j = 1;
              } else {
                j = 0;
              }
              if ((i ^ j) == 0)
              {
                if (this.entrance2 != null) {
                  i = 1;
                } else {
                  i = 0;
                }
                if (paramObject.entrance2 != null) {
                  j = 1;
                } else {
                  j = 0;
                }
                if ((i ^ j) == 0)
                {
                  if (this.msgSize != null) {
                    i = 1;
                  } else {
                    i = 0;
                  }
                  if (paramObject.msgSize != null) {
                    j = 1;
                  } else {
                    j = 0;
                  }
                  if ((i ^ j) == 0)
                  {
                    if (this.onlineStatus != null) {
                      i = 1;
                    } else {
                      i = 0;
                    }
                    if (paramObject.onlineStatus != null) {
                      j = 1;
                    } else {
                      j = 0;
                    }
                    if ((i ^ j) == 0)
                    {
                      if (this.terminal != null) {
                        i = 1;
                      } else {
                        i = 0;
                      }
                      if (paramObject.terminal != null) {
                        j = 1;
                      } else {
                        j = 0;
                      }
                      if ((i ^ j) == 0)
                      {
                        if (this.isFirst != null) {
                          i = 1;
                        } else {
                          i = 0;
                        }
                        if (paramObject.isFirst != null) {
                          j = 1;
                        } else {
                          j = 0;
                        }
                        if (((i ^ j) == 0) && (getWholeMsgReport().equals(paramObject.getWholeMsgReport()))) {
                          return true;
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
      return false;
    }
    return super.equals(paramObject);
  }
  
  public String getMsgReport()
  {
    String str = this.entrance2;
    if ((str != null) && (str.equals(""))) {
      return String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%d|", new Object[] { this.uinType, this.senderUin, this.recieverUin, this.msgType, this.entrance, this.entrance2, this.msgSize, this.onlineStatus, this.terminal, this.isFirst, Integer.valueOf(this.msgCount) });
    }
    return String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%d|", new Object[] { this.uinType, this.senderUin, this.recieverUin, this.msgType, this.entrance, this.entrance2, this.msgSize, this.onlineStatus, this.terminal, this.isFirst, Integer.valueOf(this.msgCount) });
  }
  
  public String getWholeMsgReport()
  {
    return String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|", new Object[] { this.uinType, this.senderUin, this.recieverUin, this.msgType, this.entrance, this.entrance2, this.msgSize, this.onlineStatus, this.terminal, this.isFirst });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageReportData
 * JD-Core Version:    0.7.0.1
 */