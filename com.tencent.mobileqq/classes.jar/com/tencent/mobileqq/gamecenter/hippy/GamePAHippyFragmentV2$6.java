package com.tencent.mobileqq.gamecenter.hippy;

import android.text.TextUtils;
import com.tencent.mobileqq.gamecenter.protocol.GmpEnterInfoRsp;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper;
import com.tencent.mobileqq.gamecenter.view.GamePubNav;

class GamePAHippyFragmentV2$6
  implements Runnable
{
  GamePAHippyFragmentV2$6(GamePAHippyFragmentV2 paramGamePAHippyFragmentV2, GmpEnterInfoRsp paramGmpEnterInfoRsp, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGmpEnterInfoRsp != null) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGmpEnterInfoRsp.ret_code == 0) && (this.jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGmpEnterInfoRsp.state == 1) && (this.jdField_a_of_type_Boolean))
    {
      GamePAHippyFragmentV2.a(this.this$0).setBubbleId(this.jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGmpEnterInfoRsp.bubble_id);
      GamePAHippyFragmentV2.a(this.this$0).setBubbleJumpUrl(this.jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGmpEnterInfoRsp.url);
      GamePAHippyFragmentV2.a(this.this$0).setUrlType(this.jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGmpEnterInfoRsp.url_type);
      GamePAHippyFragmentV2.a(this.this$0).setTabGrayid(this.jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGmpEnterInfoRsp.tab_grayid);
      GamePAHippyFragmentV2.a(this.this$0).setGameAppid(this.jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGmpEnterInfoRsp.appid);
      GamePAHippyFragmentV2.a(this.this$0).a(true, this.jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGmpEnterInfoRsp.bubble_id);
      GamePAHippyFragmentV2.a(this.this$0).a(this.jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGmpEnterInfoRsp.icon, this.jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGmpEnterInfoRsp.content, this.jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGmpEnterInfoRsp.url, this.jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGmpEnterInfoRsp.bubble_id, this.jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGmpEnterInfoRsp.bubble_appear, this.jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGmpEnterInfoRsp.bubble_disappear);
      QQGameHelper.a(this.jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGmpEnterInfoRsp);
      return;
    }
    GmpEnterInfoRsp localGmpEnterInfoRsp = QQGameHelper.a();
    if ((!TextUtils.isEmpty(localGmpEnterInfoRsp.url)) && (!TextUtils.isEmpty(localGmpEnterInfoRsp.bubble_id)))
    {
      GamePAHippyFragmentV2.a(this.this$0).setBubbleId(this.jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGmpEnterInfoRsp.bubble_id);
      GamePAHippyFragmentV2.a(this.this$0).setBubbleJumpUrl(this.jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGmpEnterInfoRsp.url);
      GamePAHippyFragmentV2.a(this.this$0).setUrlType(this.jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGmpEnterInfoRsp.url_type);
      GamePAHippyFragmentV2.a(this.this$0).setTabGrayid(this.jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGmpEnterInfoRsp.tab_grayid);
      GamePAHippyFragmentV2.a(this.this$0).setGameAppid(this.jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGmpEnterInfoRsp.appid);
      GamePAHippyFragmentV2.a(this.this$0).a(true, this.jdField_a_of_type_ComTencentMobileqqGamecenterProtocolGmpEnterInfoRsp.bubble_id);
      return;
    }
    GamePAHippyFragmentV2.a(this.this$0).setBubbleId("");
    GamePAHippyFragmentV2.a(this.this$0).setBubbleJumpUrl("");
    GamePAHippyFragmentV2.a(this.this$0).setTabGrayid("");
    GamePAHippyFragmentV2.a(this.this$0).setGameAppid("");
    GamePAHippyFragmentV2.a(this.this$0).setUrlType(0);
    GamePAHippyFragmentV2.a(this.this$0).a(false, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.hippy.GamePAHippyFragmentV2.6
 * JD-Core Version:    0.7.0.1
 */