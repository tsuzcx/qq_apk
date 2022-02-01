package com.tencent.mobileqq.emotionintegrate;

import android.content.Intent;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;

class AIOEmotionFragment$5
  implements View.OnTouchListener
{
  AIOEmotionFragment$5(AIOEmotionFragment paramAIOEmotionFragment, int paramInt, MessageForPic paramMessageForPic) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.a("0X800A7E7");
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.b.setBackgroundColor(Color.parseColor("#F7F7F7"));
      if (this.jdField_a_of_type_Int == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.a("0X800A7E9");
        EmojiHomeUiPlugin.openEmojiDetailPage(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.getBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.a().getAccount(), 8, this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.picExtraData.emojiPkgId, false, false);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.a("0X800A7E8");
        paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.getBaseActivity(), QQBrowserActivity.class);
        paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.picExtraData.webUrl);
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.getBaseActivity().startActivity(paramView);
      }
    }
    else if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment.b.setBackgroundColor(Color.parseColor("#DEDEDE"));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.5
 * JD-Core Version:    0.7.0.1
 */