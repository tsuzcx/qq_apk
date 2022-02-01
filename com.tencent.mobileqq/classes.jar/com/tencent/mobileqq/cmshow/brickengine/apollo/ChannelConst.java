package com.tencent.mobileqq.cmshow.brickengine.apollo;

import java.util.Arrays;
import java.util.HashSet;

public class ChannelConst
{
  private static final String[] a = { "cs.close_room.local", "sc.force_stop_game.local", "cs.get_dress_path.local", "cs.first_frame_drawn.local", "sc.init_global_var.local", "cs.report_data_2_compass.local", "cs.report_data_2_backstage.local", "cs.report_event.local", "cs.report_flow_data.local", "cs.encrypt_data.local", "cs.decrypt_data.local", "cs.get_server_ip_port.local", "cs.save_recommend_ip.local", "cs.game_start.local", "cs.check_pubAccount_state.local", "cs.enter_pubAccount_card.local", "cs.finish_group_whiteface.local", "cs.ready_play_whiteface.local", "cs.apolloGameWebMessage.local", "cs.openFloatTransparentView.local", "cs.openWebView.local", "cs.show_apollo_panel.local", "cs.slave_action_status_notify.local", "cs.qta_notify_test_result.local", "cs.single_action_status_changed.local", "cs.script_action_status_notify.local", "cs.script_get_dress_data.local", "cs.script_change_panel_status.local", "cs.script_sprite_status_change.local", "cs.script_get_show_action.local", "cs.script_is_allow_play_audio.local", "cs.script_show_barrage.local", "cs.script_send_action_msg.local", "cs.script_show_toast.local", "cs.script_get_config.local", "cs.script_get_nickname.local", "cs.script_get_action_data.local", "cs.h5_communicate.local", "cs.get_cm3D_state.local", "cs.trace_begin.local", "cs.trace_end.local", "cs.trace_span_begin.local", "cs.trace_span_end.local", "cs.trace_log.local" };
  private static final HashSet<String> b = new HashSet(Arrays.asList(a));
  
  public static boolean a(String paramString)
  {
    return b.contains(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.apollo.ChannelConst
 * JD-Core Version:    0.7.0.1
 */