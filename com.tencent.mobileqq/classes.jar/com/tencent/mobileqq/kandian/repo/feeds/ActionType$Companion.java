package com.tencent.mobileqq.kandian.repo.feeds;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/repo/feeds/ActionType$Companion;", "", "()V", "fromInt", "Lcom/tencent/mobileqq/kandian/repo/feeds/ActionType;", "operation", "", "fromPBInt", "value", "kandian-api_release"}, k=1, mv={1, 1, 16})
public final class ActionType$Companion
{
  @NotNull
  public final ActionType a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4)
          {
            if (paramInt != 5)
            {
              if (paramInt != 7)
              {
                if (paramInt != 11) {
                  return ActionType.ACTION_NONE;
                }
                return ActionType.ACTION_DATA_CARD_FOLLOW;
              }
              return ActionType.ACTION_ARTICLE_READ_PROGRESS;
            }
            return ActionType.ACTION_VIDEO_PLAY_PROGRESS;
          }
          return ActionType.ACTION_SHARE;
        }
        return ActionType.ACTION_SEE_LATER;
      }
      return ActionType.ACTION_LOVE;
    }
    return ActionType.ACTION_FOLLOW;
  }
  
  @NotNull
  public final ActionType b(int paramInt)
  {
    if (paramInt == ActionType.ACTION_FOLLOW.getActionType()) {
      return ActionType.ACTION_FOLLOW;
    }
    if (paramInt == ActionType.ACTION_LOVE.getActionType()) {
      return ActionType.ACTION_LOVE;
    }
    if (paramInt == ActionType.ACTION_SEE_LATER.getActionType()) {
      return ActionType.ACTION_SEE_LATER;
    }
    if (paramInt == ActionType.ACTION_SHARE.getActionType()) {
      return ActionType.ACTION_SHARE;
    }
    if (paramInt == ActionType.ACTION_VIDEO_PLAY_PROGRESS.getActionType()) {
      return ActionType.ACTION_VIDEO_PLAY_PROGRESS;
    }
    if (paramInt == ActionType.ACTION_ARTICLE_READ_PROGRESS.getActionType()) {
      return ActionType.ACTION_ARTICLE_READ_PROGRESS;
    }
    if (paramInt == ActionType.ACTION_DATA_CARD_FOLLOW.getActionType()) {
      return ActionType.ACTION_DATA_CARD_FOLLOW;
    }
    return ActionType.ACTION_NONE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ActionType.Companion
 * JD-Core Version:    0.7.0.1
 */