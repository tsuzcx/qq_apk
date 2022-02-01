package com.tencent.mobileqq.troop.viewmodel;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/troop/viewmodel/ViewActionType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "SocialBottomBarCommentClickType", "SocialBottomBarLikeClickType", "SocialBottomBarShareClickType", "ActivityClose", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public enum ViewActionType
{
  private final int value;
  
  static
  {
    ViewActionType localViewActionType1 = new ViewActionType("SocialBottomBarCommentClickType", 0, 1);
    SocialBottomBarCommentClickType = localViewActionType1;
    ViewActionType localViewActionType2 = new ViewActionType("SocialBottomBarLikeClickType", 1, 2);
    SocialBottomBarLikeClickType = localViewActionType2;
    ViewActionType localViewActionType3 = new ViewActionType("SocialBottomBarShareClickType", 2, 3);
    SocialBottomBarShareClickType = localViewActionType3;
    ViewActionType localViewActionType4 = new ViewActionType("ActivityClose", 3, 4);
    ActivityClose = localViewActionType4;
    $VALUES = new ViewActionType[] { localViewActionType1, localViewActionType2, localViewActionType3, localViewActionType4 };
  }
  
  private ViewActionType(int paramInt)
  {
    this.value = paramInt;
  }
  
  public final int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.viewmodel.ViewActionType
 * JD-Core Version:    0.7.0.1
 */