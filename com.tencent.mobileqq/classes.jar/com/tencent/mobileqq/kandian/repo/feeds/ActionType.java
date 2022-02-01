package com.tencent.mobileqq.kandian.repo.feeds;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/ActionType;", "", "actionType", "", "(Ljava/lang/String;II)V", "getActionType", "()I", "toPBInt", "ACTION_ENTER", "ACTION_NONE", "ACTION_FOLLOW", "ACTION_LOVE", "ACTION_SEE_LATER", "ACTION_SHARE", "ACTION_VIDEO_PLAY_PROGRESS", "ACTION_ARTICLE_READ_PROGRESS", "ACTION_DATA_CARD_FOLLOW", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public enum ActionType
{
  public static final ActionType.Companion Companion = new ActionType.Companion(null);
  private final int actionType;
  
  static
  {
    ActionType localActionType1 = new ActionType("ACTION_ENTER", 0, 16777216);
    ACTION_ENTER = localActionType1;
    ActionType localActionType2 = new ActionType("ACTION_NONE", 1, 0);
    ACTION_NONE = localActionType2;
    ActionType localActionType3 = new ActionType("ACTION_FOLLOW", 2, 1);
    ACTION_FOLLOW = localActionType3;
    ActionType localActionType4 = new ActionType("ACTION_LOVE", 3, 2);
    ACTION_LOVE = localActionType4;
    ActionType localActionType5 = new ActionType("ACTION_SEE_LATER", 4, 4);
    ACTION_SEE_LATER = localActionType5;
    ActionType localActionType6 = new ActionType("ACTION_SHARE", 5, 8);
    ACTION_SHARE = localActionType6;
    ActionType localActionType7 = new ActionType("ACTION_VIDEO_PLAY_PROGRESS", 6, 16);
    ACTION_VIDEO_PLAY_PROGRESS = localActionType7;
    ActionType localActionType8 = new ActionType("ACTION_ARTICLE_READ_PROGRESS", 7, 32);
    ACTION_ARTICLE_READ_PROGRESS = localActionType8;
    ActionType localActionType9 = new ActionType("ACTION_DATA_CARD_FOLLOW", 8, 64);
    ACTION_DATA_CARD_FOLLOW = localActionType9;
    $VALUES = new ActionType[] { localActionType1, localActionType2, localActionType3, localActionType4, localActionType5, localActionType6, localActionType7, localActionType8, localActionType9 };
  }
  
  private ActionType(int paramInt)
  {
    this.actionType = paramInt;
  }
  
  public final int getActionType()
  {
    return this.actionType;
  }
  
  public final int toPBInt()
  {
    switch (ActionType.WhenMappings.a[ordinal()])
    {
    default: 
      return 0;
    case 7: 
      return 11;
    case 6: 
      return 7;
    case 5: 
      return 5;
    case 4: 
      return 4;
    case 3: 
      return 3;
    case 2: 
      return 2;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ActionType
 * JD-Core Version:    0.7.0.1
 */