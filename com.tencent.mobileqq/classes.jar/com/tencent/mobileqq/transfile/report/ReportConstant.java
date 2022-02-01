package com.tencent.mobileqq.transfile.report;

public abstract interface ReportConstant
{
  public static final String COSTREPORT_HT = "ht";
  public static final String COSTREPORT_PIC = "pic";
  public static final String COSTREPORT_PREFIX = "s";
  public static final String COSTREPORT_SN = "sn";
  public static final String COSTREPORT_TRANS = "tr";
  public static final String KEYIS_PRESEND = "param_isPresend";
  public static final String KEYIS_SECOND_TRANS = "param_isSecondTrans";
  public static final String KEY_AIODURATION = "param_AIODuration";
  public static final String KEY_AIOPERCENT = "param_AIOPercent";
  public static final String KEY_BDHEXIST_BEFORE_VIDEO_UPLOAD = "param_BDHExistBeforeVideoUpload";
  public static final String KEY_BDHGENERATE_COMBINE_FILE_TIME = "param_BDHGenerateCombineFileTime";
  public static final String KEY_BDHSRV_IP = "param_bdhSrv";
  public static final String KEY_BDHSRV_PORT = "param_bdhPort";
  public static final String KEY_BDHTRANS_INFO = "param_BdhTrans";
  public static final String KEY_BUSI_TYPE = "param_busiType";
  public static final String KEY_COST_EACH = "param_CostEach";
  public static final String KEY_DOWN_MODE = "param_DownMode";
  public static final String KEY_ENCRYPT = "param_encrypt";
  public static final String KEY_ENC_RETRY = "param_encRetry";
  public static final String KEY_ERR_DESC = "param_errorDesc";
  public static final String KEY_FAIL_CODE = "param_FailCode";
  public static final String KEY_FILE_MD5 = "param_fileMd5";
  public static final String KEY_FROM_BUSI_TYPE = "param_fromBusiType";
  public static final String KEY_FROM_CHAT_TYPE = "param_fromChatType";
  public static final String KEY_FROM_UIN = "param_fromUin";
  public static final String KEY_GROUP_FILE_ID = "param_fileid";
  public static final String KEY_GROUP_ID = "param_grpUin";
  public static final String KEY_IMAGETYPE = "param_imgType";
  public static final String KEY_IN_QUEUE_COST = "param_inQueueCost";
  public static final String KEY_IPV6POLICY = "param_Ipv6Policy";
  public static final String KEY_IS_ENCRYPT_ROLLBACK = "param_encryptRollback";
  public static final String KEY_IS_HTTPS = "param_isHttps";
  public static final String KEY_IS_OPEN_UP = "param_openUp";
  public static final String KEY_IS_RAW_PIC = "param_IsRawPic";
  public static final String KEY_LONG_MSG_ANDROID_ERR_CODE = "param_android_error_code";
  public static final String KEY_LONG_MSG_CHANNEL = "param_channel";
  public static final String KEY_LONG_MSG_ERROR_CODE = "param_errcode";
  public static final String KEY_LONG_MSG_HTTP_ERROR_CODE = "param_http_error_code";
  public static final String KEY_LONG_MSG_IP_SOURCE = "param_ip_source";
  public static final String KEY_LONG_MSG_PUIN = "param_puin";
  public static final String KEY_LONG_MSG_RESID = "param_resid";
  public static final String KEY_LONG_MSG_UIN = "param_uin";
  public static final String KEY_LONG_MSG_URL = "param_url";
  public static final String KEY_MD5CHECK = "param_md5check";
  public static final String KEY_MSFCONN_IP_TPYE = "msfConnIPType";
  public static final String KEY_NET_IP_TYPE = "ipStackType";
  public static final String KEY_NET_TYPE = "param_NetType";
  public static final String KEY_OLD_SERVER_IP = "param_Server";
  public static final String KEY_OPEN_UP_STEP_INFO = "param_openUpStep";
  public static final String KEY_PHONE_TYPE = "param_PhoneType";
  public static final String KEY_PIC_DECRYPT_TIME = "param_picDecryptTime";
  public static final String KEY_PIC_ENCRYPT = "param_picEncrypt";
  public static final String KEY_PIC_MD5 = "param_picmd5";
  public static final String KEY_PIC_RES_LENGTH = "param_picResLength";
  public static final String KEY_PIC_RES_WIDTH = "param_picResWidth";
  public static final String KEY_PIC_SIZE = "param_picSize";
  public static final String KEY_PIC_TYPE = "param_picType";
  public static final String KEY_PTT_NET_DOWN = "param_pttNetDown";
  public static final String KEY_PTT_OPT = "param_pttOpt";
  public static final String KEY_PTT_WRITTEN_SIZE = "param_writtenSize";
  public static final String KEY_REASON = "param_reason";
  public static final String KEY_RECV_DATA_LEN = "param_recvDataLen";
  public static final String KEY_REQ_HEADER = "param_reqHeader";
  public static final String KEY_REQ_IP = "param_reqIp";
  public static final String KEY_RESP_HEADER = "param_rspHeader";
  public static final String KEY_RETRY = "param_Retry";
  public static final String KEY_SEG_PER_CNT = "param_segspercnt";
  public static final String KEY_SENDBY_QUICK_HTTP = "param_quickHttp";
  public static final String KEY_SERVER_IP = "serverip";
  public static final String KEY_SERVER_VIDEO_IPS = "param_iplist";
  public static final String KEY_SESSION_KEY = "param_sessionKey";
  public static final String KEY_SLICE_NUM = "param_sliceNum";
  public static final String KEY_SOURCE_TYPE = "param_source_type";
  public static final String KEY_STEP_INFO = "param_step";
  public static final String KEY_SWITCH_CHNL = "param_switchChannel";
  public static final String KEY_TIME_COST = "param_time_cost";
  public static final String KEY_TO_BUSI_TYPE = "param_toBusiType";
  public static final String KEY_TO_CHAT_TYPE = "param_toChatType";
  public static final String KEY_TO_UIN = "param_toUin";
  public static final String KEY_TRANS_CONSUME = "param_trans_consume";
  public static final String KEY_URL = "param_url";
  public static final String KEY_URL_ENCRYPT = "param_urlEncrypt";
  public static final String KEY_UUID = "param_uuid";
  public static final String KEY_VIDEO_AIOTIME = "param_cost_c_aio";
  public static final String KEY_VIDEO_CLIENT_COMP_TIME = "param_cost_c_comp";
  public static final String KEY_VIDEO_DURATION = "param_videoDuration";
  public static final String KEY_VIDEO_FILE_FORMAT = "param_fileFormat";
  public static final String KEY_VIDEO_FILE_MD5_S = "param_fileMD5";
  public static final String KEY_VIDEO_IS_PRE_UPLOAD = "param_isPreUpload";
  public static final String KEY_VIDEO_RECORD_TIME = "param_cost_c_record";
  public static final String KEY_VIDEO_RECORD_TIMES = "param_recordTimes";
  public static final String KEY_VIDEO_ROLLBACK = "param_rollback";
  public static final String KEY_VIDEO_SEGS_TIME = "param_cost_s_segs";
  public static final String KEY_VIDEO_SERVER_COMP_TIME = "param_cost_s_comp";
  public static final String KEY_VIDEO_SERVER_ERR_CODE = "param_SvrErroCode";
  public static final String KEY_VIDEO_SERVER_STORE_TIME = "param_cost_s_store";
  public static final String KEY_VIDEO_SESSION_ID = "param_sessionID";
  public static final String KEY_VIDEO_THUMB_MD5 = "param_thumbMd5";
  public static final String KEY_VIDEO_THUMB_SIZE = "param_thumbSize";
  public static final String KEY_VIDEO_TIME_BEFORE_SEND = "param_timeBeforeSend";
  public static final String KEY_VIDEO_TRANS_TIME = "param_cost_c_trans";
  public static final String KEY_VIDEO_WAIT_TIME = "param_cost_c_wait";
  public static final String KEY_XPICCACHETIME = "X-piccachetime";
  public static final String KEY_XRT_FLAG = "param_xRtFlag";
  public static final String REPORT_TAG_SUCC = "param_succ_flag";
  public static final String STORAGE_FTN = "ftn";
  public static final String STORAGE_PIC_PLATFORM = "picplatform";
  public static final String STORAGE_PTT_CENTER = "pttcenter";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.report.ReportConstant
 * JD-Core Version:    0.7.0.1
 */