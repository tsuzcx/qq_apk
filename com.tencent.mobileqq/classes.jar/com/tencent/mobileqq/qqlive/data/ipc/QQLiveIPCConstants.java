package com.tencent.mobileqq.qqlive.data.ipc;

public abstract interface QQLiveIPCConstants
{
  public static final String ACTION_CLIENT_AUDIO = "Action_Client_Audio";
  public static final String ACTION_CLIENT_AUDIO_MUTE_AUDIO = "Action_Client_Audio_Mute_Audio";
  public static final String ACTION_CLIENT_AUDIO_START_MIC = "Action_Client_Audio_StartMic";
  public static final String ACTION_CLIENT_AUDIO_STOP_MIC = "Action_Client_Audio_StopMic";
  public static final String ACTION_CLIENT_DESTROY_SDK = "Action_Client_Destroy_SDK";
  public static final String ACTION_CLIENT_INIT_SDK = "Action_Client_Init_SDK";
  public static final String ACTION_CLIENT_ROOM = "Action_Client_Room";
  public static final String ACTION_CLIENT_ROOM_DESTROY_ROOM = "Action_Client_Room_Destroy_Room";
  public static final String ACTION_CLIENT_ROOM_ENTER_ROOM = "Action_Client_Room_Enter_Room";
  public static final String ACTION_CLIENT_ROOM_EXIT_ROOM = "Action_Client_Room_Exit_Room";
  public static final String ACTION_CLIENT_ROOM_SWITCH_ROOM = "Action_Client_Room_Switch_Room";
  public static final String ACTION_CLIENT_SCREEN = "Action_Client_Screen";
  public static final String ACTION_CLIENT_SCREEN_MUTE_VIDEO = "Action_Client_Screen_Mute_Video";
  public static final String ACTION_CLIENT_SCREEN_SET_MUTE_BITMAP = "Action_Client_Screen_Set_Mute_Bitmap";
  public static final String ACTION_CLIENT_SCREEN_SET_QUALITY = "Action_Client_Screen_Set_Quality";
  public static final String ACTION_CLIENT_SCREEN_START = "Action_Client_Screen_Start";
  public static final String ACTION_CLIENT_SCREEN_STOP = "Action_Client_Screen_Stop";
  public static final String ACTION_SERVER_NOTIFY_ENGINE = "Action_Server_Notify_Engine";
  public static final String ACTION_SERVER_ON_BIND = "Action_Server_OnBind";
  public static final String ACTION_SERVER_ROOM_CALLBACK = "Action_Server_Room_Callback";
  public static final String ACTION_SERVER_ROOM_CALLBACK_ON_ENTER_ROOM = "Action_Server_Room_Callback_onEnterRoom";
  public static final String ACTION_SERVER_ROOM_CALLBACK_ON_EVENT = "Action_Server_Room_Callback_onEvent";
  public static final String ACTION_SERVER_ROOM_CALLBACK_ON_EXIT_ROOM = "Action_Server_Room_Callback_onExitRoom";
  public static final String ACTION_SERVER_ROOM_CALLBACK_ON_FIRST_LOCAL_AUDIO_FRAME_SENT = "Action_Server_Room_Callback_onFirstLocalAudioFrameSent";
  public static final String ACTION_SERVER_ROOM_CALLBACK_ON_FIRST_LOCAL_VIDEO_FRAME_SENT = "Action_Server_Room_Callback_onFirstLocalVideoFrameSent";
  public static final String ACTION_SERVER_ROOM_CALLBACK_ON_REMOTE_USER_ENTER_ROOM = "Action_Server_Room_Callback_onRemoteUserEnterRoom";
  public static final String ACTION_SERVER_ROOM_CALLBACK_ON_REMOTE_USER_LEAVE_ROOM = "Action_Server_Room_Callback_onRemoteUserLeaveRoom";
  public static final String ACTION_SERVER_ROOM_CALLBACK_ON_SWITCH_ROOM = "Action_Server_Room_Callback_onSwitchRoom";
  public static final String ACTION_SERVER_SCREEN_CALLBACK = "Action_Server_Screen_Callback";
  public static final String ACTION_SERVER_SCREEN_CALLBACK_ON_ERROR = "Action_Server_Screen_Callback_On_Error";
  public static final String ACTION_SERVER_SCREEN_CALLBACK_START = "Action_Server_Screen_Callback_Start";
  public static final String ACTION_SERVER_SCREEN_CALLBACK_STOP = "Action_Server_Screen_Callback_Stop";
  public static final String CLIENT_MODULE_NAME = "QQLiveClientIPCModule";
  public static final String KEY_TRTC_AUDIO_PARAMS = "Key_trtc_audio_params";
  public static final String KEY_TRTC_CONFIG_DATA = "key_trtc_config_data";
  public static final String KEY_TRTC_ENGINE_INIT_CODE = "Key_trtc_engine_init_code";
  public static final String KEY_TRTC_ENGINE_INIT_STATE = "Key_trtc_engine_init_state";
  public static final String KEY_TRTC_ERR_CODE = "Key_TRTC_ErrCode";
  public static final String KEY_TRTC_ERR_MSG = "Key_TRTC_ErrMsg";
  public static final String KEY_TRTC_EVENT_ID = "Key_TRTC_EventID";
  public static final String KEY_TRTC_EXTRA = "Key_TRTC_Extra";
  public static final String KEY_TRTC_INITED = "Key_TRTC_Inited";
  public static final String KEY_TRTC_ROOM_PARAMS = "Key_trtc_room_params";
  public static final String KEY_TRTC_SCREEN_PARAMS = "Key_trtc_screen_params";
  public static final String KEY_TRTC_SOURCE_MUTE = "Key_trtc_source_mute";
  public static final String KEY_TRTC_SOURCE_MUTE_BITMAP = "Key_trtc_source_mute_bitmap";
  public static final String KEY_TRTC_SOURCE_MUTE_FPS = "Key_trtc_source_mute_fps";
  public static final String KEY_TRTC_SO_PATH = "key_trtc_so_path";
  public static final String SERVER_MODULE_NAME = "QQLiveServerIPCModule";
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.ipc.QQLiveIPCConstants
 * JD-Core Version:    0.7.0.1
 */