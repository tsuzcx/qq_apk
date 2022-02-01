package com.tencent.mobileqq.teamwork.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import tencent.im.oidb.cmd0xae9.online_docs.DocId;

@QAPI(process={"all"})
public abstract interface IGroupTeamWorkHandler
  extends QRouteApi
{
  public static final String CMD_ADD_GROUP_TEAM_WORK_COPY = "OidbSvc.0xaf3_2";
  public static final String CMD_ADD_GROUP_TEAM_WORK_LINK = "OidbSvc.0xaf3_1";
  public static final String CMD_DELETE_GROUP_TEAM_WORK_FILE = "OidbSvc.0xaea_1";
  public static final String CMD_GET_GOURP_TEAM_WORK_LAST_ADD_TIME = "OidbSvc.0xae9_2";
  public static final String CMD_GET_GROUP_PAD_TEMPLATE_LIST = "OidbSvc.0xaee";
  public static final String CMD_GET_GROUP_TEAM_WORK_LIST = "OidbSvc.0xae9_1";
  public static final String CMD_SEARCH_FOR_GROUP_TEAM_WORK_LIST = "OidbSvc.0xaef_1";
  public static final String KEY_GROUP_CODE = "key_group_code";
  public static final String KEY_REQ_LIMIT = "key_req_limit";
  public static final String KEY_REQ_START = "key_req_start";
  public static final String KEY_TYPE_KEY_PAD_URL = "key_type_pad_url";
  public static final String KEY_TYPE_KEY_WORD = "key_type_key_word";
  public static final String KEY_TYPE_OPERATION = "key_type_operation";
  public static final int OBSERVER_TYPE_ADD_GROUP_TEAM_WORK_COPY = 6;
  public static final int OBSERVER_TYPE_ADD_GROUP_TEAM_WORK_LINK = 5;
  public static final int OBSERVER_TYPE_DELETE_GROUP_TEAM_WORK_FILE = 4;
  public static final int OBSERVER_TYPE_GET_GPAD_LIST = 1;
  public static final int OBSERVER_TYPE_GET_GPAD_TEMPLATE_LIST = 3;
  public static final int OBSERVER_TYPE_REFRESH_ADD_TIMESTAMP = 7;
  public static final int OBSERVER_TYPE_SEARCH_FOR_GPAD_LIST = 2;
  public static final int TYPE_FISRT_ENTER_OPERATION = 1;
  public static final int TYPE_LOAD_MORE_OPERATION = 3;
  public static final int TYPE_REFRESH_OPERATION = 2;
  
  public abstract void getGroupPadTemplateList(long paramLong);
  
  public abstract void getGroupTeamWorkList(long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void getGroupTeamWorkListLastAddTime(long paramLong);
  
  public abstract void reqDeleteGroupTeamWorkFile(long paramLong, online_docs.DocId paramDocId, String paramString, boolean paramBoolean);
  
  public abstract void reqSearchGroupTeamWorkList(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.teamwork.api.IGroupTeamWorkHandler
 * JD-Core Version:    0.7.0.1
 */