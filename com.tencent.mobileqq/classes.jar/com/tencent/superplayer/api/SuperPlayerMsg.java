package com.tencent.superplayer.api;

import android.util.SparseIntArray;

public class SuperPlayerMsg
{
  public static final int PLAYER_INFO_ALL_DOWNLOAD_FINISH = 201;
  public static final int PLAYER_INFO_ASYNC_CALL_SELECT_PROGRAM = 125;
  public static final int PLAYER_INFO_AUDIO_DECODER_TYPE = 114;
  public static final int PLAYER_INFO_AUDIO_HW_DECODING_SLOW = 117;
  public static final int PLAYER_INFO_AUDIO_SW_DECODING_SLOW = 116;
  public static final int PLAYER_INFO_BUFFERING_END = 113;
  public static final int PLAYER_INFO_BUFFERING_START = 112;
  public static final int PLAYER_INFO_CLIP_EOS = 109;
  public static final int PLAYER_INFO_CURRENT_LOOP_END = 108;
  public static final int PLAYER_INFO_CURRENT_LOOP_START = 107;
  public static final int PLAYER_INFO_DOWNLOAD_STATUS_UPDATE = 206;
  public static final int PLAYER_INFO_EOS = 110;
  public static final int PLAYER_INFO_FIRST_AUDIO_DECODER_START = 102;
  public static final int PLAYER_INFO_FIRST_AUDIO_FRAME_RENDERED = 104;
  public static final int PLAYER_INFO_FIRST_CLIP_OPENED = 100;
  public static final int PLAYER_INFO_FIRST_PACKET_READ = 106;
  public static final int PLAYER_INFO_FIRST_VIDEO_DECODER_START = 103;
  public static final int PLAYER_INFO_FIRST_VIDEO_FRAME_RENDERED = 105;
  public static final int PLAYER_INFO_MEDIACODEC_VIDEO_CROP = 122;
  public static final int PLAYER_INFO_NEED_TO_ROTATE_SURFACE = 121;
  public static final int PLAYER_INFO_OBJECT_MEDIA_CODEC_INFO = 208;
  public static final int PLAYER_INFO_OBJECT_PLAY_CDN_INFO_UPDATE = 204;
  public static final int PLAYER_INFO_OBJECT_PLAY_CDN_URL_CHANGED = 203;
  public static final int PLAYER_INFO_OBJECT_VIDEO_SEI = 126;
  public static final int PLAYER_INFO_PACKET_READ = 101;
  public static final int PLAYER_INFO_PLAYER_TYPE = 124;
  public static final int PLAYER_INFO_PRIVATE_HLS_TAG = 123;
  public static final int PLAYER_INFO_PROTOCOL_UPDATE = 205;
  public static final int PLAYER_INFO_RETRY_PLAYER = 200;
  public static final int PLAYER_INFO_SWITCH_DEFINITION = 111;
  public static final int PLAYER_INFO_UNKNOW = 0;
  public static final int PLAYER_INFO_VIDEO_DECODER_TYPE = 115;
  public static final int PLAYER_INFO_VIDEO_FRAME_CHECK_INFO = 209;
  public static final int PLAYER_INFO_VIDEO_HW_DECODING_SLOW = 119;
  public static final int PLAYER_INFO_VIDEO_SW_DECODING_SLOW = 118;
  public static final int TP_PLAYER_INFO_OBJECT_DOWNLOAD_PROGRESS_UPDATE = 207;
  public static final int TP_PLAYER_INFO_STRING_DOWNLOAD_QUIC_STATUS_UPDATE = 250;
  private static SparseIntArray sTPPlayerMsgMap = new SparseIntArray();
  
  static
  {
    sTPPlayerMsgMap.put(-1, 0);
    sTPPlayerMsgMap.put(101, 100);
    sTPPlayerMsgMap.put(103, 102);
    sTPPlayerMsgMap.put(104, 103);
    sTPPlayerMsgMap.put(105, 104);
    sTPPlayerMsgMap.put(106, 105);
    sTPPlayerMsgMap.put(107, 106);
    sTPPlayerMsgMap.put(150, 107);
    sTPPlayerMsgMap.put(151, 108);
    sTPPlayerMsgMap.put(152, 109);
    sTPPlayerMsgMap.put(154, 110);
    sTPPlayerMsgMap.put(200, 112);
    sTPPlayerMsgMap.put(201, 113);
    sTPPlayerMsgMap.put(203, 114);
    sTPPlayerMsgMap.put(204, 115);
    sTPPlayerMsgMap.put(205, 116);
    sTPPlayerMsgMap.put(206, 117);
    sTPPlayerMsgMap.put(207, 118);
    sTPPlayerMsgMap.put(208, 119);
    sTPPlayerMsgMap.put(501, 123);
    sTPPlayerMsgMap.put(500, 122);
    sTPPlayerMsgMap.put(1000, 124);
    sTPPlayerMsgMap.put(1001, 201);
    sTPPlayerMsgMap.put(1003, 204);
    sTPPlayerMsgMap.put(1004, 206);
    sTPPlayerMsgMap.put(1005, 205);
    sTPPlayerMsgMap.put(1006, 207);
    sTPPlayerMsgMap.put(502, 208);
    sTPPlayerMsgMap.put(6, 125);
    sTPPlayerMsgMap.put(2100, 250);
    sTPPlayerMsgMap.put(503, 126);
  }
  
  public static int convert(int paramInt)
  {
    return sTPPlayerMsgMap.get(paramInt, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.api.SuperPlayerMsg
 * JD-Core Version:    0.7.0.1
 */