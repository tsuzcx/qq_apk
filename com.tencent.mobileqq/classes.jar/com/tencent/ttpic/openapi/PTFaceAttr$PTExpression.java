package com.tencent.ttpic.openapi;

public enum PTFaceAttr$PTExpression
{
  public static final PTExpression[] ACTION_TRIGGER_TYPE;
  public PTExpression opposite;
  public final int value;
  
  static
  {
    ALWAYS = new PTExpression("ALWAYS", 1, 1);
    FACE_DETECT = new PTExpression("FACE_DETECT", 2, 2);
    MOUTH_OPEN = new PTExpression("MOUTH_OPEN", 3, 3);
    EYEBROWS_RAISE = new PTExpression("EYEBROWS_RAISE", 4, 4);
    BLINK = new PTExpression("BLINK", 5, 5);
    HEAD_SHAKE = new PTExpression("HEAD_SHAKE", 6, 6);
    KISS = new PTExpression("KISS", 7, 7);
    BLINK_LEFT_EYE = new PTExpression("BLINK_LEFT_EYE", 8, 8);
    BLINK_RIGHT_EYE = new PTExpression("BLINK_RIGHT_EYE", 9, 9);
    HEAD_NOD = new PTExpression("HEAD_NOD", 10, 10);
    HEAD_SHAKE_NEW = new PTExpression("HEAD_SHAKE_NEW", 11, 11);
    TRY_CLICK_SCREEN = new PTExpression("TRY_CLICK_SCREEN", 12, 12);
    MV_PART_INDEX = new PTExpression("MV_PART_INDEX", 13, 13);
    SMILE = new PTExpression("SMILE", 14, 14);
    MOUTH_OCCLUDED = new PTExpression("MOUTH_OCCLUDED", 15, 15);
    LEFT_EYE_OCCLUDED = new PTExpression("LEFT_EYE_OCCLUDED", 16, 16);
    RIGHT_EYE_OCCLUDED = new PTExpression("RIGHT_EYE_OCCLUDED", 17, 17);
    DOUBLE_EYE_OCCLUDED = new PTExpression("DOUBLE_EYE_OCCLUDED", 18, 18);
    FACE_NO_NOUTH = new PTExpression("FACE_NO_NOUTH", 19, 103, MOUTH_OPEN);
    FACE_NO_EYEBROWS = new PTExpression("FACE_NO_EYEBROWS", 20, 104, EYEBROWS_RAISE);
    FACE_NO_BLINK = new PTExpression("FACE_NO_BLINK", 21, 105, BLINK);
    FACE_NO_HEAD = new PTExpression("FACE_NO_HEAD", 22, 106, HEAD_SHAKE);
    FACE_NO_KISS = new PTExpression("FACE_NO_KISS", 23, 107, KISS);
    HAND_LABEL_HAND = new PTExpression("HAND_LABEL_HAND", 24, 200);
    HAND_LABEL_HEART = new PTExpression("HAND_LABEL_HEART", 25, 201);
    HAND_LABEL_PAPER = new PTExpression("HAND_LABEL_PAPER", 26, 202);
    HAND_LABEL_SCISSOR = new PTExpression("HAND_LABEL_SCISSOR", 27, 203);
    HAND_LABEL_FIST = new PTExpression("HAND_LABEL_FIST", 28, 204);
    HAND_LABEL_ONE = new PTExpression("HAND_LABEL_ONE", 29, 205);
    HAND_LABEL_LOVE = new PTExpression("HAND_LABEL_LOVE", 30, 206);
    HAND_LABEL_LIKE = new PTExpression("HAND_LABEL_LIKE", 31, 207);
    HAND_LABEL_OK = new PTExpression("HAND_LABEL_OK", 32, 208);
    HAND_LABEL_ROCK = new PTExpression("HAND_LABEL_ROCK", 33, 209);
    HAND_LABEL_SIX = new PTExpression("HAND_LABEL_SIX", 34, 210);
    HAND_LABEL_EIGHT = new PTExpression("HAND_LABEL_EIGHT", 35, 211);
    ALL_VIEWER_ITEM_FRAME_FROZEN = new PTExpression("ALL_VIEWER_ITEM_FRAME_FROZEN", 36, 501);
    TIME_TRIGGER = new PTExpression("TIME_TRIGGER", 37, 601);
    EXTERNAL_WORDS = new PTExpression("EXTERNAL_WORDS", 38, 701);
    TAP_SCREEN = new PTExpression("TAP_SCREEN", 39, 801);
    PTExpression localPTExpression1 = UNKNOW;
    PTExpression localPTExpression2 = ALWAYS;
    PTExpression localPTExpression3 = FACE_DETECT;
    PTExpression localPTExpression4 = MOUTH_OPEN;
    PTExpression localPTExpression5 = EYEBROWS_RAISE;
    PTExpression localPTExpression6 = BLINK;
    PTExpression localPTExpression7 = HEAD_SHAKE;
    PTExpression localPTExpression8 = KISS;
    PTExpression localPTExpression9 = BLINK_LEFT_EYE;
    PTExpression localPTExpression10 = BLINK_RIGHT_EYE;
    PTExpression localPTExpression11 = HEAD_NOD;
    PTExpression localPTExpression12 = HEAD_SHAKE_NEW;
    PTExpression localPTExpression13 = TRY_CLICK_SCREEN;
    $VALUES = new PTExpression[] { localPTExpression1, localPTExpression2, localPTExpression3, localPTExpression4, localPTExpression5, localPTExpression6, localPTExpression7, localPTExpression8, localPTExpression9, localPTExpression10, localPTExpression11, localPTExpression12, localPTExpression13, MV_PART_INDEX, SMILE, MOUTH_OCCLUDED, LEFT_EYE_OCCLUDED, RIGHT_EYE_OCCLUDED, DOUBLE_EYE_OCCLUDED, FACE_NO_NOUTH, FACE_NO_EYEBROWS, FACE_NO_BLINK, FACE_NO_HEAD, FACE_NO_KISS, HAND_LABEL_HAND, HAND_LABEL_HEART, HAND_LABEL_PAPER, HAND_LABEL_SCISSOR, HAND_LABEL_FIST, HAND_LABEL_ONE, HAND_LABEL_LOVE, HAND_LABEL_LIKE, HAND_LABEL_OK, HAND_LABEL_ROCK, HAND_LABEL_SIX, HAND_LABEL_EIGHT, ALL_VIEWER_ITEM_FRAME_FROZEN, TIME_TRIGGER, EXTERNAL_WORDS, TAP_SCREEN };
    ACTION_TRIGGER_TYPE = new PTExpression[] { localPTExpression4, localPTExpression5, localPTExpression6, localPTExpression7, localPTExpression8, localPTExpression9, localPTExpression10, localPTExpression11, localPTExpression12, localPTExpression13 };
  }
  
  private PTFaceAttr$PTExpression(int paramInt)
  {
    this.value = paramInt;
  }
  
  private PTFaceAttr$PTExpression(int paramInt, PTExpression paramPTExpression)
  {
    this.value = paramInt;
    this.opposite = paramPTExpression;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.PTFaceAttr.PTExpression
 * JD-Core Version:    0.7.0.1
 */