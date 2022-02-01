package com.tencent.mobileqq.forward;

import android.app.Activity;
import android.content.Intent;
import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Constructor;

public class ForwardOptionBuilder
{
  public static SparseArray<Class<? extends ForwardBaseOption>> a = new SparseArray(30);
  
  static
  {
    a.put(0, ForwardFileOption.class);
    a.put(1, ForwardPhotoOption.class);
    a.put(-1, ForwardTextOption.class);
    a.put(-2, ForwardMapOption.class);
    a.put(-3, ForwardStructingMsgOption.class);
    a.put(17, ForwardSendHongBaoOption.class);
    a.put(18, ForwardH5HongBaoOption.class);
    a.put(20, ForwardRecommendFriendOption.class);
    a.put(24, ForwardRecommendFriendOption.class);
    a.put(42, ForwardRobotOption.class);
    a.put(11, ForwardSdkShareOption.class);
    a.put(15, ForwardChooseFriendOption.class);
    a.put(2, ForwardQZoneRichImageOption.class);
    a.put(12, ForwardAioAlbumOption.class);
    a.put(1001, ForwardPluginShareStructMsgOption.class);
    a.put(-4, ForwardHyperTextOption.class);
    a.put(13, ForwardVoiceCallOption.class);
    a.put(14, ForwardEmojiPacketSendOption.class);
    a.put(9, ForwardMarketFaceOption.class);
    a.put(16, ForwardSelectContactOption.class);
    a.put(21, ForwardShortVideoOption.class);
    a.put(22, ForwardQFavBatchOption.class);
    a.put(10, ForwardCompositeOption.class);
    a.put(23, ForwardShareCardOption.class);
    a.put(25, ForwardH5PTVOption.class);
    a.put(27, ForwardArkMsgOption.class);
    a.put(38, ForwardArkH5StructOption.class);
    a.put(35, ForwardArkBabyqReplyMsgOption.class);
    a.put(33, ForwardArkFlashChatMsgOption.class);
    a.put(26, ForwardApolloActionSendOption.class);
    a.put(-5, ForwardMixedMsgOption.class);
    a.put(28, ForwardQQStoryMsgOption.class);
    a.put(29, ForwardQQStoryAccountMsgOption.class);
    a.put(32, ForwardTroopStoryMsgOption.class);
    a.put(34, ForwardApolloGameMsgOption.class);
    a.put(36, ForwardTribeShortVideoMsgOption.class);
    a.put(37, ForwardHiboomMsgOption.class);
    a.put(39, ForwardQzoneArkMsgOption.class);
    a.put(41, ForwardGameMsgOption.class);
    a.put(-6, ForwardReplyMsgOption.class);
    a.put(44, ForwardMiniAppUpdatableMsgOption.class);
    a.put(45, ForwardReadInJoyOption.class);
    a.put(46, ForwardAskAnonymouslyMsgOption.class);
    a.put(47, EmotionBatchForwardOption.class);
  }
  
  public static ForwardBaseOption a(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("forward_type", -1);
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardOptionBuilder", 2, "ForwardOptionBuilder forwardType=" + i);
    }
    Class localClass = (Class)a.get(i);
    if (localClass != null) {
      try
      {
        paramIntent = (ForwardBaseOption)localClass.getDeclaredConstructor(new Class[] { Intent.class }).newInstance(new Object[] { paramIntent });
        return paramIntent;
      }
      catch (Exception paramIntent)
      {
        QLog.e("ForwardOption.ForwardOptionBuilder", 1, paramIntent, new Object[0]);
        return null;
      }
    }
    QLog.e("ForwardOption.ForwardOptionBuilder", 1, "clazz should not be null!!");
    return null;
  }
  
  public static ForwardBaseOption a(Intent paramIntent, QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    paramIntent.putExtra("emoInputType", 2);
    paramIntent = a(paramIntent);
    if (paramIntent != null)
    {
      paramIntent.a(paramQQAppInterface, paramActivity);
      paramIntent.a();
    }
    return paramIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardOptionBuilder
 * JD-Core Version:    0.7.0.1
 */