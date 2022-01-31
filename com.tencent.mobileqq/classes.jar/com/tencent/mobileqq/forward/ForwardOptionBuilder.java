package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ForwardOptionBuilder
{
  public static ForwardBaseOption a(Intent paramIntent)
  {
    ForwardFileOption localForwardFileOption = null;
    int i = paramIntent.getIntExtra("forward_type", -1);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardOptionBuilder", 2, "ForwardOptionBuilder forwardType=" + i);
    }
    if (i == 0) {
      localForwardFileOption = new ForwardFileOption(paramIntent);
    }
    do
    {
      return localForwardFileOption;
      if (i == 1) {
        return new ForwardPhotoOption(paramIntent);
      }
      if (i == -1) {
        return new ForwardTextOption(paramIntent);
      }
      if (i == -2) {
        return new ForwardMapOption(paramIntent);
      }
      if (i == -3) {
        return new ForwardStructingMsgOption(paramIntent);
      }
      if (i == 17) {
        return new ForwardSendHongBaoOption(paramIntent);
      }
      if (i == 18) {
        return new ForwardH5HongBaoOption(paramIntent);
      }
      if ((i == 20) || (i == 24)) {
        return new ForwardRecommendFriendOption(paramIntent);
      }
      if (i == 11) {
        return new ForwardSdkShareOption(paramIntent);
      }
      if (i == 15) {
        return new ForwardChooseFriendOption(paramIntent);
      }
      if (i == 2) {
        return new ForwardQZoneRichImageOption(paramIntent);
      }
      if (i == 12) {
        return new ForwardAioAlbumOption(paramIntent);
      }
      if (i == 1001) {
        return new ForwardPluginShareStructMsgOption(paramIntent);
      }
      if (i == -4) {
        return new ForwardHyperTextOption(paramIntent);
      }
      if (i == 13) {
        return new ForwardVoiceCallOption(paramIntent);
      }
      if (i == 14) {
        return new ForwardEmojiPacketSendOption(paramIntent);
      }
      if (i == 9) {
        return new ForwardMarketFaceOption(paramIntent);
      }
      if (i == 16) {
        return new ForwardSelectContactOption(paramIntent);
      }
      if (i == 21) {
        return new ForwardShortVideoOption(paramIntent);
      }
      if (i == 22) {
        return new ForwardQFavBatchOption(paramIntent);
      }
      if (i == 10) {
        return new ForwardCompositeOption(paramIntent);
      }
      if (i == 23) {
        return new ForwardShareCardOption(paramIntent);
      }
      if (i == 25) {
        return new ForwardH5PTVOption(paramIntent);
      }
      if (i == 27) {
        return new ForwardArkMsgOption(paramIntent);
      }
      if (i == 35) {
        return new ForwardArkBabyqReplyMsgOption(paramIntent);
      }
      if (i == 33) {
        return new ForwardArkFlashChatMsgOption(paramIntent);
      }
      if (i == 26) {
        return new ForwardApolloActionSendOption(paramIntent);
      }
      if (i == -5) {
        return new ForwardStructingMsgOption(paramIntent);
      }
      if (i == 28) {
        return new ForwardQQStoryMsgOption(paramIntent);
      }
      if (i == 29) {
        return new ForwardQQStoryAccountMsgOption(paramIntent);
      }
      if (i == 31) {
        return new ForwardLbsHBOption(paramIntent);
      }
      if (i == 32) {
        return new ForwardTroopStoryMsgOption(paramIntent);
      }
      if (i == 34) {
        return new ForwardApolloGameMsgOption(paramIntent);
      }
      if (i == 36) {
        return new ForwardTribeShortVideoMsgOption(paramIntent);
      }
    } while (i != 37);
    return new ForwardHiboomMsgOption(paramIntent);
  }
  
  public static ForwardBaseOption a(Intent paramIntent, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    paramIntent = a(paramIntent);
    if (paramIntent != null)
    {
      paramIntent.a(paramQQAppInterface, paramActivity);
      paramIntent.a();
    }
    return paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardOptionBuilder
 * JD-Core Version:    0.7.0.1
 */