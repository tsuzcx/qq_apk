package com.tencent.mobileqq.utils.abtest;

import java.util.ArrayList;
import java.util.List;

public class QCommonOnlineExpProviderImpl
  implements IOnlineExpProvider
{
  public List<String> getRegisterExpNameList()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("exp_qq_msg_marketface_input_icon");
    localArrayList.add("exp_qq_msg_marketface_gif_icon");
    localArrayList.add("message_reminder_layer2_1505_20210618");
    localArrayList.add("exp_status_new");
    localArrayList.add("exp_QQweather_gzh_homepage_hippy");
    localArrayList.add("exp_qq_miniapp_progame_aiofile");
    localArrayList.add("game_box1");
    localArrayList.add("exp_qq_yellow_sticker_manage");
    localArrayList.add("exp_qq_qqgame_predownload_screen");
    localArrayList.add("exp_cmshow_mood");
    localArrayList.add("exp_qq_mode_upper");
    localArrayList.add("exp_shouq_dongtai_jianjie_copy_copy");
    localArrayList.add("exp_game_box_banner");
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.abtest.QCommonOnlineExpProviderImpl
 * JD-Core Version:    0.7.0.1
 */