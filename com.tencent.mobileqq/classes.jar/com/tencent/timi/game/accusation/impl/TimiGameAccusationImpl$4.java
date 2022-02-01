package com.tencent.timi.game.accusation.impl;

import com.tencent.timi.game.base.ui.LoadingUtils;
import com.tencent.timi.game.ui.widget.EmptyDialog;
import mqq.util.WeakReference;

final class TimiGameAccusationImpl$4
  implements Runnable
{
  public void run()
  {
    if (TimiGameAccusationImpl.b() != null)
    {
      EmptyDialog localEmptyDialog = (EmptyDialog)TimiGameAccusationImpl.b().get();
      if (localEmptyDialog != null)
      {
        LoadingUtils.a.b(localEmptyDialog);
        localEmptyDialog.dismiss();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.accusation.impl.TimiGameAccusationImpl.4
 * JD-Core Version:    0.7.0.1
 */