package com.tencent.mobileqq.highway.utils;

public abstract interface BaseConstants
{
  public static abstract interface BdhBusinessType
  {
    public static final int BUSI_BASE_PIC_C2C = 1;
    public static final int BUSI_BASE_PIC_C2C_UP = 4;
    public static final int BUSI_BASE_PIC_GRP = 2;
    public static final int BUSI_BASE_PIC_WALL = 3;
    public static final int BUSI_LONG_VIDEO = 25;
    public static final int BUSI_SECRETMSG_PIC = 1001;
    public static final int BUSI_SECRETMSG_SNAP = 1002;
    public static final int BUSI_SHORT_VIDEO = 12;
    public static final int[] reportBDHExcept = { 1, 2, 12, 25 };
  }
  
  public static abstract interface ERROR
  {
    public static final int ERR_CODE_BAD_HTTP_RESP = -1014;
    public static final int ERR_CODE_BDH_RESP = -1013;
    public static final int ERR_CODE_CONN_CLOSE = -1003;
    public static final int ERR_CODE_CONN_FAILED = -1001;
    public static final int ERR_CODE_ENCODE_ERR = -1004;
    public static final int ERR_CODE_MTU_SIZE = -1012;
    public static final int ERR_CODE_NONE_NETWORK = -1000;
    public static final int ERR_CODE_PING_FAIL = -1009;
    public static final int ERR_CODE_REQ_TIMEOUT = -1005;
    public static final int ERR_CODE_ROUTE = -1008;
    public static final int ERR_CODE_TRACEROUTE = -1011;
    public static final int ERR_CODE_TRANS_GET_SESSIONLEY_TIMEOUT = -1015;
    public static final int ERR_CODE_TRANS_TIMEOUT = -1002;
    public static final int ERR_CODE_UNREACHABLE = -1007;
    public static final int ERR_CODE_WIFI_PROBE = -1010;
    public static final int ERR_CODE_WRITE_TIMEOUT = -1006;
    public static final int ERR_NO_NETWORK_RDM = 9004;
    public static final int Error_FIN_FLAG_LOST_TWICE = 9305;
    public static final int Error_FileSize_TooBig = 9063;
    public static final int Error_FileSize_Zero = 9071;
    public static final int Error_File_NotExist = 9042;
    public static final int Error_File_NotReadable = 9070;
    public static final int Error_Get_MD5 = 9041;
    public static final int Error_No_SDCard = 9039;
    public static final int Error_Not_Picture = 9072;
    public static final int Error_Param_Check = 9302;
    public static final int Error_ReUpload_Twice = 9304;
    public static final int Error_ReadFile = 9303;
    public static final int Error_SDCard_NoSpace = 9040;
    public static final int Error_WriteFile = 9301;
    public static final int HTRET_ERR_DECODE = 64;
    public static final int HTRET_ERR_OVERLOAD = 66;
    public static final int HTRET_ERR_PARA = 65;
    public static final int HTRET_ERR_SRV = 67;
    public static final int HTRET_SUCCESS = 0;
    public static final int RET_CODE_SUCCESS = 0;
    public static final int RET_ERR_ACCOUNT_PROXY_ERR = 212;
    public static final int RET_ERR_ACCOUNT_PROXY_TIMEOUT = 213;
    public static final int RET_ERR_ACKEY = 196;
    public static final int RET_ERR_FILE_MAXSIZE = 199;
    public static final int RET_ERR_MD5MATCH = 200;
    public static final int RET_ERR_NOFILE = 208;
    public static final int RET_ERR_NO_REPLY = 214;
    public static final int RET_ERR_OVER_MAX_NUM = 206;
    public static final int RET_ERR_OVER_MAX_VOLUME = 207;
    public static final int RET_ERR_PARA = 201;
    public static final int RET_ERR_QUERY_FTN_TIMEOUT = 210;
    public static final int RET_ERR_QUERY_PIC_TIMEOUT = 209;
    public static final int RET_ERR_SRV = 203;
    public static final int RET_ERR_SSO_LANIF_TIMEOUT = 211;
    public static final int RET_WRITE_IMGPLAT_FAIL = 194;
  }
  
  public static abstract interface NetType
  {
    public static final int CABLE = 5;
    public static final int G2 = 2;
    public static final int G3 = 3;
    public static final int G4 = 4;
    public static final int NONE = 0;
    public static final int WIFI = 1;
  }
  
  public static abstract interface PROTO_TYPE
  {
    public static final int PROTO_HTTP = 2;
    public static final int PROTO_TCP = 1;
  }
  
  public static abstract interface REQ_CONST
  {
    public static final long DEFAULT_TIME_OUT = 30000L;
    public static final long DEFAULT_TIME_OUT_HEARTBREAK = 10000L;
    public static final long DEFAULT_TIME_OUT_INCRE = 15000L;
    public static final int HEARTBREAK_DELTA = 60000;
    public static final long URGENT_HEARTBREAK_TIMEOUT = 10000L;
  }
  
  public static abstract interface REQ_HW_CMD
  {
    public static final String REQ_CMD_DATA = "PicUp.DataUp";
    public static final String REQ_CMD_HEART_BREAK = "PicUp.Echo";
    public static final String REQ_CMD_QUERY = "PicUp.QueryOffset";
    public static final String REQ_CMD_UPLOAD_ACK = "PicUp.DataUp";
  }
  
  public static abstract interface SsoSocketConnStat
  {
    public static final int connError_ebadFileNum = 12;
    public static final int connError_enobufs = 11;
    public static final int connError_enotsock = 10;
    public static final int connError_illegalargument = 1;
    public static final int connError_invalidArgument = 13;
    public static final int connError_invalidData = 15;
    public static final int connError_noroute = 2;
    public static final int connError_permission = 4;
    public static final int connError_refused = 5;
    public static final int connError_reset = 6;
    public static final int connError_timeout = 7;
    public static final int connError_unknown = 14;
    public static final int connError_unknownhost = 8;
    public static final int connError_unreachable = 3;
    public static final int connError_unresolved = 9;
    public static final int connSuccess = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.highway.utils.BaseConstants
 * JD-Core Version:    0.7.0.1
 */