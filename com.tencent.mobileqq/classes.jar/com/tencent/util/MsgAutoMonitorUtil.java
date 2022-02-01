package com.tencent.util;

import android.util.Log;
import com.tencent.qphone.base.util.QLog;

public class MsgAutoMonitorUtil
{
  public static final String ADD_MSG_NUM_KEY = "MSG_AddMsgNum";
  public static final String ADD_MSG_TIME_KEY = "MSG_AddMsgTime";
  public static final String DB_IO_NUM_KEY = "MSG_DbIoNum";
  public static final String DB_IO_TIME_KEY = "MSG_DbIoTime";
  public static final String DB_IO_TRANSACTION_KEY = "MSG_DbIoTransaction";
  public static final String DB_TABLE_NUM_KEY = "MSG_DbTableNum";
  public static final String MSG_DECODE_C2C_NUM_KEY = "MSG_DecodeC2CMsgNum";
  public static final String MSG_DECODE_C2C_TIME_KEY = "MSG_DecodeC2CMsgTime";
  public static final String MSG_DECODE_GRPDIS_NUM_KEY = "MSG_DecodeGrpDisMsgNum";
  public static final String MSG_DECODE_GRPDIS_TIME_KEY = "MSG_DecodeGrpDisMsgTime";
  public static final String MSG_FILTER_NUM_KEY = "MSG_MsgFilterNum";
  public static final String MSG_FILTER_TIME_KEY = "MSG_MsgFilterTime";
  public static final String MSG_INIT_MSG_NUM = "MSG_InitMsgNum";
  public static final String MSG_INIT_TAG = "AutoMonitor";
  public static final String MSG_INIT_TIME_KEY = "MSG_InitCostTime";
  public static final String MSG_NOTIFY_FIN_C2C = "MSG_NOTIFY_FIN_C2C";
  public static final String MSG_NOTIFY_FIN_DIS = "MSG_NOTIFY_FIN_DIS";
  public static final String MSG_NOTIFY_FIN_GRP = "MSG_NOTIFY_FIN_GRP";
  public static final String MSG_OBSERVER_NOTIFY_NUM = "MSG_ObserverNotifyNum";
  public static final String MSG_OBSERVER_TIME_KEY = "MSG_ObserverTime";
  public static final String MSG_PROXY_INIT_TIME_KEY = "MSG_ProxyInitTime";
  public static final String MSG_PROXY_SEQ_DIS = "MSG_PROXY_SEQ_DIS_T";
  public static final String MSG_PROXY_SEQ_GRP = "MSG_PROXY_SEQ_GRP_T";
  public static final String MSG_PROXY_THREAD_NUM_BEGIN = "MSG_PROXY_THREAD_NUM_BEGIN";
  public static final String MSG_PROXY_THREAD_NUM_END = "MSG_PROXY_THREAD_NUM_END";
  public static final String MSG_TABLE_NUM_KEY = "MSG_TableNum";
  private static MsgAutoMonitorUtil util;
  private long addMsgNum = 0L;
  private long addMsgTime = 0L;
  private long dbIoNum = 0L;
  private long dbIoTime = 0L;
  private long dbIoTransaction = 0L;
  private long decodeC2CNum = 0L;
  private long decodeC2CTime = 0L;
  private long decodeGrpDisNum = 0L;
  private long decodeGrpDisTime = 0L;
  private long msgFilterNum = 0L;
  private long msgFilterTime = 0L;
  private int msgObserverNotifyNum = 0;
  private long msgObserverTime = 0L;
  private long msgProxyThreadNumBegin = 0L;
  private long msgProxyThreadNumEnd = 0L;
  private long notifyMsgFinishTimeC2C = 0L;
  private long notifyMsgFinishTimeC2CS = 0L;
  private long notifyMsgFinishTimeDisS = 0L;
  private long notifyMsgFinishTimeGrp = 0L;
  private long notifyMsgFinishTimeGrpS = 0L;
  private long notufyMsgFinishTimeDis = 0L;
  private long proxySeqTimeDis = 0L;
  private long proxySeqTimeGrp = 0L;
  
  public static MsgAutoMonitorUtil getInstance()
  {
    if (util == null) {
      util = new MsgAutoMonitorUtil();
    }
    return util;
  }
  
  public void addAddMsgTime(long paramLong1, long paramLong2)
  {
    this.addMsgTime += paramLong1;
    this.addMsgNum += paramLong2;
  }
  
  public void addDbIoTime(long paramLong)
  {
    this.dbIoTime += paramLong;
    this.dbIoNum += 1L;
  }
  
  public void addDbIoTransaction(long paramLong)
  {
    this.dbIoTransaction += paramLong;
  }
  
  public void addDecodeC2CMsgTime(long paramLong)
  {
    this.decodeC2CTime += paramLong;
    this.decodeC2CNum += 1L;
  }
  
  public void addDecodeGrpDisMsgTime(long paramLong)
  {
    this.decodeGrpDisTime += paramLong;
    this.decodeGrpDisNum += 1L;
  }
  
  public void addMsgFilterTime(long paramLong)
  {
    this.msgFilterTime += paramLong;
    this.msgFilterNum += 1L;
  }
  
  public void addMsgObserverNotifyNum()
  {
    this.msgObserverNotifyNum += 1;
  }
  
  public void addMsgObserverTime(long paramLong)
  {
    this.msgObserverTime += paramLong;
  }
  
  public void addProxySeqTime_Dis(long paramLong)
  {
    this.proxySeqTimeDis += paramLong;
  }
  
  public void addProxySeqTime_Grp(long paramLong)
  {
    this.proxySeqTimeGrp += paramLong;
  }
  
  public void markC2CFinishCost()
  {
    this.notifyMsgFinishTimeC2C = (System.currentTimeMillis() - this.notifyMsgFinishTimeC2CS);
  }
  
  public void markC2CFinishTime()
  {
    this.notifyMsgFinishTimeC2CS = System.currentTimeMillis();
  }
  
  public void markDisFinishCost()
  {
    this.notufyMsgFinishTimeDis = (System.currentTimeMillis() - this.notifyMsgFinishTimeDisS);
  }
  
  public void markDisFinishTime()
  {
    this.notifyMsgFinishTimeDisS = System.currentTimeMillis();
  }
  
  public void markGrpFinishCost()
  {
    this.notifyMsgFinishTimeGrp = (System.currentTimeMillis() - this.notifyMsgFinishTimeGrpS);
  }
  
  public void markGrpFinishTime()
  {
    this.notifyMsgFinishTimeGrpS = System.currentTimeMillis();
  }
  
  public void markMsgProxyThreadNumBegin(int paramInt)
  {
    this.msgProxyThreadNumBegin = paramInt;
  }
  
  public void markMsgProxyThreadNumEnd(int paramInt)
  {
    this.msgProxyThreadNumEnd = paramInt;
  }
  
  public void printDbAutoMonitorValue()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.dbIoTime);
    localStringBuilder.append("");
    printKeyAndValue("MSG_DbIoTime", localStringBuilder.toString());
    this.dbIoTime = 0L;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.dbIoNum);
    localStringBuilder.append("");
    printKeyAndValue("MSG_DbIoNum", localStringBuilder.toString());
    this.dbIoNum = 0L;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.dbIoTransaction);
    localStringBuilder.append("");
    printKeyAndValue("MSG_DbIoTransaction", localStringBuilder.toString());
    this.dbIoTransaction = 0L;
  }
  
  public void printKeyAndValue(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", cost=");
      localStringBuilder.append(paramString2);
      QLog.d("AutoMonitor", 2, localStringBuilder.toString());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(", cost=");
    localStringBuilder.append(paramString2);
    Log.i("AutoMonitor", localStringBuilder.toString());
  }
  
  public void printMsgInfo()
  {
    printKeyAndValue("MSG_DecodeC2CMsgNum", String.valueOf(this.decodeC2CNum));
    printKeyAndValue("MSG_DecodeC2CMsgTime", String.valueOf(this.decodeC2CTime));
    printKeyAndValue("MSG_DecodeGrpDisMsgNum", String.valueOf(this.decodeGrpDisNum));
    printKeyAndValue("MSG_DecodeGrpDisMsgTime", String.valueOf(this.decodeGrpDisTime));
    printKeyAndValue("MSG_AddMsgNum", String.valueOf(this.addMsgNum));
    printKeyAndValue("MSG_AddMsgTime", String.valueOf(this.addMsgTime));
    printKeyAndValue("MSG_MsgFilterNum", String.valueOf(this.msgFilterNum));
    printKeyAndValue("MSG_MsgFilterTime", String.valueOf(this.msgFilterTime));
    printKeyAndValue("MSG_PROXY_SEQ_DIS_T", String.valueOf(this.proxySeqTimeDis));
    printKeyAndValue("MSG_PROXY_SEQ_GRP_T", String.valueOf(this.proxySeqTimeGrp));
    printDbAutoMonitorValue();
    printMsgObserverAutoMonitorValue();
    printKeyAndValue("MSG_NOTIFY_FIN_C2C", String.valueOf(this.notifyMsgFinishTimeC2C));
    printKeyAndValue("MSG_NOTIFY_FIN_GRP", String.valueOf(this.notifyMsgFinishTimeGrp));
    printKeyAndValue("MSG_NOTIFY_FIN_DIS", String.valueOf(this.notufyMsgFinishTimeDis));
    printKeyAndValue("MSG_PROXY_THREAD_NUM_BEGIN", String.valueOf(this.msgProxyThreadNumBegin));
    printKeyAndValue("MSG_PROXY_THREAD_NUM_END", String.valueOf(this.msgProxyThreadNumEnd));
  }
  
  public void printMsgObserverAutoMonitorValue()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.msgObserverTime);
    localStringBuilder.append("");
    printKeyAndValue("MSG_ObserverTime", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.msgObserverNotifyNum);
    localStringBuilder.append("");
    printKeyAndValue("MSG_ObserverNotifyNum", localStringBuilder.toString());
    this.msgObserverTime = 0L;
    this.msgObserverNotifyNum = 0;
  }
  
  public void release()
  {
    util = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.MsgAutoMonitorUtil
 * JD-Core Version:    0.7.0.1
 */