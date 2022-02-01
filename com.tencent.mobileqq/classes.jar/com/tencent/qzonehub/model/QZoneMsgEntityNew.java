package com.tencent.qzonehub.model;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.qzonehub.api.contentbox.IMQMsg;
import java.io.Serializable;
import java.util.ArrayList;

public class QZoneMsgEntityNew
  extends Entity
  implements Serializable
{
  public static final String TAG = "QZoneMsgEntity";
  @notColumn
  public ArrayList<IMQMsg> ArkNes_vec = null;
  public String bottomItemBuffer;
  @notColumn
  public ArrayList bottomItems;
  public boolean hasmore = true;
  public String more_url = "";
  public String msgBuffer = "";
  public long pushTime = 0L;
  public long qzone_level = 0L;
  public long registered_days = 0L;
  public String trace_info = "";
  public MQUnReadSummaryInfo unReadSummaryInfo;
  public long visitor_count = 0L;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qzonehub.model.QZoneMsgEntityNew
 * JD-Core Version:    0.7.0.1
 */