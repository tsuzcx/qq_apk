package com.tencent.mobileqq.qqgamepub.hippy.fragment;

import android.text.TextUtils;
import com.tencent.mobileqq.qqgamepub.data.GmpEnterInfoRsp;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qqgamepub.view.GamePubNav;

class GamePAHippyFragmentV2$6
  implements Runnable
{
  GamePAHippyFragmentV2$6(GamePAHippyFragmentV2 paramGamePAHippyFragmentV2, GmpEnterInfoRsp paramGmpEnterInfoRsp, boolean paramBoolean) {}
  
  public void run()
  {
    GmpEnterInfoRsp localGmpEnterInfoRsp = this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataGmpEnterInfoRsp;
    if ((localGmpEnterInfoRsp != null) && (localGmpEnterInfoRsp.ret_code == 0) && (this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataGmpEnterInfoRsp.state == 1) && (this.jdField_a_of_type_Boolean))
    {
      GamePAHippyFragmentV2.a(this.this$0).setBubbleId(this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataGmpEnterInfoRsp.bubble_id);
      GamePAHippyFragmentV2.a(this.this$0).setBubbleJumpUrl(this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataGmpEnterInfoRsp.url);
      GamePAHippyFragmentV2.a(this.this$0).setUrlType(this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataGmpEnterInfoRsp.url_type);
      GamePAHippyFragmentV2.a(this.this$0).setTabGrayid(this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataGmpEnterInfoRsp.tab_grayid);
      GamePAHippyFragmentV2.a(this.this$0).setGameAppid(this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataGmpEnterInfoRsp.appid);
      GamePAHippyFragmentV2.a(this.this$0).a(true, this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataGmpEnterInfoRsp.bubble_id);
      GamePAHippyFragmentV2.a(this.this$0).a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataGmpEnterInfoRsp.icon, this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataGmpEnterInfoRsp.content, this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataGmpEnterInfoRsp.url, this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataGmpEnterInfoRsp.bubble_id, this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataGmpEnterInfoRsp.bubble_appear, this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataGmpEnterInfoRsp.bubble_disappear);
      GamePubAccountHelper.a(this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataGmpEnterInfoRsp);
      return;
    }
    localGmpEnterInfoRsp = GamePubAccountHelper.a();
    if ((!TextUtils.isEmpty(localGmpEnterInfoRsp.url)) && (!TextUtils.isEmpty(localGmpEnterInfoRsp.bubble_id)) && (this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataGmpEnterInfoRsp != null))
    {
      GamePAHippyFragmentV2.a(this.this$0).setBubbleId(this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataGmpEnterInfoRsp.bubble_id);
      GamePAHippyFragmentV2.a(this.this$0).setBubbleJumpUrl(this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataGmpEnterInfoRsp.url);
      GamePAHippyFragmentV2.a(this.this$0).setUrlType(this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataGmpEnterInfoRsp.url_type);
      GamePAHippyFragmentV2.a(this.this$0).setTabGrayid(this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataGmpEnterInfoRsp.tab_grayid);
      GamePAHippyFragmentV2.a(this.this$0).setGameAppid(this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataGmpEnterInfoRsp.appid);
      GamePAHippyFragmentV2.a(this.this$0).a(true, this.jdField_a_of_type_ComTencentMobileqqQqgamepubDataGmpEnterInfoRsp.bubble_id);
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
 * Qualified Name:     com.tencent.mobileqq.qqgamepub.hippy.fragment.GamePAHippyFragmentV2.6
 * JD-Core Version:    0.7.0.1
 */