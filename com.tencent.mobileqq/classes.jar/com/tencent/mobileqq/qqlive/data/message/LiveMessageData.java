package com.tencent.mobileqq.qqlive.data.message;

public class LiveMessageData
{
  public static final int ENTER_ROOM_MSG_TYPE = 3;
  public static final int E_BUY_MESSAGE = 6;
  public static final int FOLLOW_ANCHOR_MESSAGE = 5;
  public static final int GIFT_MSG_TYPE = 2;
  public static final int MSG_ELEMENT_IMAGE_TYPE = 2;
  public static final int MSG_ELEMENT_TEXT_TYPE = 1;
  public static final int NORMAL_CHAT_MESSAGE = 33;
  public static final int NORMAL_CHAT_TEXT_MSG_TYPE = 1;
  public static final int SYSTEM_NOTICE_MESSAGE = 4;
  public static final int VOTE_MESSAGE = 7;
  public static final int VOTE_PASS_MESSAGE = 8;
  public String mEBuyProgramId;
  public String mEBuyScreenMsg;
  public int mEBuyType;
  public LiveMessageData.GiftInfo mGiftInfo = new LiveMessageData.GiftInfo(this);
  public int mMainRoomId;
  public String mMessageId;
  public int mMessageType;
  public LiveMsgExtInfo mMsgExtInfo;
  public String mRawTipStr;
  public LiveMessageData.SpeakerInfo mSpeakerInfo = new LiveMessageData.SpeakerInfo();
  public int mSubRoomId;
  public String mVoteMsg;
  public String mVotePassMsg;
  public LiveMessageData.MsgContent msgContent = new LiveMessageData.MsgContent(this);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.message.LiveMessageData
 * JD-Core Version:    0.7.0.1
 */