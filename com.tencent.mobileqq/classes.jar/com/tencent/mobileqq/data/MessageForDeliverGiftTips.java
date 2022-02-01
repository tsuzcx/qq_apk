package com.tencent.mobileqq.data;

import android.content.Context;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import bggz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.qphone.base.util.QLog;

public class MessageForDeliverGiftTips
  extends MessageForGrayTips
  implements bggz
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
  public int interactState;
  public String interactText = "";
  public boolean isFromNearby;
  public int is_activity_gift;
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
    if (QLog.isColorLevel()) {
      QLog.d(".troop.send_gift", 2, "MessageForDeliverGiftTips.buildDeliverGiftTips seq:" + this.shmsgseq);
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
    return !TextUtils.isEmpty(this.interactId);
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
    return (this.animationPackageId == 0) && (this.exflag > 1000) && (this.exflag <= 2000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForDeliverGiftTips
 * JD-Core Version:    0.7.0.1
 */