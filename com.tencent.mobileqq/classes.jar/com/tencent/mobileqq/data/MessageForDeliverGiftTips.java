package com.tencent.mobileqq.data;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.utils.AIOAnimationControlManager.IAnimationMessage;
import com.tencent.qphone.base.util.QLog;

public class MessageForDeliverGiftTips
  extends MessageForGrayTips
  implements AIOAnimationControlManager.IAnimationMessage
{
  public static final String MESSAGERECORD_EXTSTR_TYPE = "troop_send_gift_ext_remind";
  public static final int VERSION = 2;
  public String activity_text;
  public String activity_text_color;
  public String activity_url;
  public long alreadyPlayMicroseconds;
  public String animationBrief = "";
  public int animationPackageId;
  public String animationPackageUrl = "";
  public int animationType;
  public String bagId;
  public int btFlag;
  public String charmHeroism = "";
  public int exflag;
  public int giftCount;
  public int giftId;
  public String grayTipContent;
  public TroopTipsEntity grayTipsEntity;
  public boolean hasFetchButFailed;
  public String interacEndtUrl = "";
  public String interactFirstNickname = "";
  public long interactFirstUin;
  public String interactId;
  public int interactState = 0;
  public String interactText = "";
  public boolean isFromNearby;
  public int is_activity_gift = 0;
  public String jumpUrl;
  public int objColor;
  public int participateNum;
  public long playTotalMicroseconds;
  public String rcvName;
  public String receiveAvatarUrl;
  public String receiverHead;
  public String receiverName;
  public long receiverUin;
  public int recvScore;
  public String remindBrief = "";
  public String resultText;
  public int resultType;
  public int sendScore;
  public String senderAvatarUrl;
  public String senderName;
  public long senderUin;
  public boolean showButton;
  public boolean showCloseBtn = true;
  public String subtitle = "";
  public String summary;
  public int version;
  
  public void buildDeliverGiftTips(QQAppInterface paramQQAppInterface, Context paramContext, TextView paramTextView)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MessageForDeliverGiftTips.buildDeliverGiftTips seq:");
      localStringBuilder.append(this.shmsgseq);
      QLog.d(".troop.send_gift", 2, localStringBuilder.toString());
    }
    paramTextView.setText(getHightlightMsgText(paramQQAppInterface, paramContext, false, paramTextView));
    paramTextView.setClickable(true);
    paramTextView.setFocusable(true);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
  }
  
  public String getFriendUin()
  {
    return this.frienduin;
  }
  
  public int getLimitType()
  {
    return 0;
  }
  
  public long getSenderUin()
  {
    return this.senderUin;
  }
  
  public long getShmsgseq()
  {
    return this.shmsgseq;
  }
  
  public boolean isInteract()
  {
    return TextUtils.isEmpty(this.interactId) ^ true;
  }
  
  public boolean isReaded()
  {
    return this.isread;
  }
  
  public boolean isSupportColor()
  {
    return true;
  }
  
  public boolean isSupportImage()
  {
    return true;
  }
  
  public boolean isToAll()
  {
    if (this.animationPackageId == 0)
    {
      int i = this.exflag;
      if ((i > 1000) && (i <= 2000)) {
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForDeliverGiftTips
 * JD-Core Version:    0.7.0.1
 */