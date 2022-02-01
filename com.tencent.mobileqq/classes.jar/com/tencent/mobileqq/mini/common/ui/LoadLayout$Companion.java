package com.tencent.mobileqq.mini.common.ui;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/common/ui/LoadLayout$Companion;", "", "()V", "HIDE", "", "LOADING", "LOADING_MORE", "LOAD_MORE_PENDING", "NO_MORE_DATA", "checkStateSwitch", "", "oldState", "newState", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class LoadLayout$Companion
{
  public final boolean checkStateSwitch(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      return true;
    }
    if (paramInt1 != 0)
    {
      if ((paramInt1 != 1) && (paramInt1 != 2))
      {
        if (paramInt1 != 3)
        {
          if ((paramInt1 == 4) && ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 3))) {
            return true;
          }
        }
        else if ((paramInt2 == 0) || (paramInt2 == 1) || (paramInt2 == 2) || (paramInt2 == 4)) {
          return true;
        }
      }
      else
      {
        if ((paramInt2 == 0) || (paramInt2 == 3)) {
          break label88;
        }
        if (paramInt2 == 4) {
          return true;
        }
      }
      return false;
    }
    label88:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.common.ui.LoadLayout.Companion
 * JD-Core Version:    0.7.0.1
 */