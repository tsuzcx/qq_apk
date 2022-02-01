package com.tencent.mobileqq.dpc;

public abstract interface IDPCApiConstant
{
  public static final String AIO_BLOCK_BROKEN_VIDEO = "-1|1=0,2=0,3=0,4=0,5=1|1|999|4|1";
  public static final String AIO_CMWAP_CONNECT = "-1|1=0,2=0,3=0,4=0,5=1|1|999|4";
  public static final String AIO_CMWAP_QQHEAD = "-1|1=0,2=0,3=0,4=0,5=1|1|999|4|1|0_2|1";
  public static final String AIO_MSG_LIMIT_COUNT = "-1|1=0,2=0,3=0,4=0,5=1|1|999";
  public static final String AIO_MSG_MENU_UI_STATE_DEFAULT = "-1|1=0,2=0,3=0,4=0,5=1";
  public static final String AIO_PIC_THUMB_SIZE_DEFAULT = "135|135";
  public static final String AIO_PREDOWNLOAD_SHORTVIDEO = "-1|1=0,2=0,3=0,4=0,5=1|1|999|4|1|0_2";
  public static final String AIO_PRELOAD_OPEN = "-1|1=0,2=0,3=0,4=0,5=1|1";
  public static final String AIO_THIRD_QQ_DISPLAY = "-1|1=0,2=0,3=0,4=0,5=1|1|999|4|1|0_2|1|0";
  public static final String DPCCONFIG_ACCOUNT_SHAREPRE_NAME = "dpcConfig_account";
  public static final String DPCCONFIG_SHAREPRE_NAME = "dpcConfig";
  public static final String HEAD_CONFIG_DEFAULT = "24|3500|1|0";
  public static final String LONG_VIDEO_COMPRESS_CONFIG_DEFAULT = "640|640|384|768|30";
  public static final String MULTI_MSG_CONFIG = "100|10|0|0";
  public static final String PG_SWITCH_DEFAULT = "1|1|1";
  public static final String PIC_PREDOWNLOAD_FLOW_DEFAULT = "12000|600|20000|400|6000|300|20000|200";
  public static final long PIC_PREDOWNLOAD_MAX_REQUEST = 100L;
  public static final String PIC_PREDOWNLOAD_TROOP_DEFAULT = "20|10|50|10";
  public static final String PIC_PRESEND_DEFAULT = "0|0|0|0|1|0|1|1|1048576|0|307200|307200|0|90|70|50";
  public static final String PRE_UPLOAD_VIDEO_CONFIG_DEFAULT = "0|0|1.0|5|480000|0";
  public static final String PROGRESS_VIDEO_DOWNLOAD_SWITCH_CONFIG_DEFAULT = "1|1|1";
  public static final String SEND_PHOTO_COMPRESS_ARG_DEFAULT = "9|960|960|960|960|960|960|80|70|70";
  public static final int STATE_SERVERDATA_EMPTY = 1;
  public static final int STATE_SERVERDATA_PARSING = 3;
  public static final int STATE_SERVERDATA_PULLING = 2;
  public static final int STATE_SERVERDATA_READY = 4;
  public static final String STRUT_MSG_SERVICE_IDS = "1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|32|35|38|40|41|44|53|54|60";
  public static final String VIDEO_THUMB_SIZE_DEFAULT_MAX = "-1";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dpc.IDPCApiConstant
 * JD-Core Version:    0.7.0.1
 */