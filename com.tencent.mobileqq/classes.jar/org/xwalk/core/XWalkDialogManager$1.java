package org.xwalk.core;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.widget.Button;
import java.util.ArrayList;
import java.util.Iterator;

class XWalkDialogManager$1
  implements DialogInterface.OnShowListener
{
  XWalkDialogManager$1(XWalkDialogManager paramXWalkDialogManager, ArrayList paramArrayList, AlertDialog paramAlertDialog) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    Object localObject = this.val$actions.iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramDialogInterface = (XWalkDialogManager.ButtonAction)((Iterator)localObject).next();
      Button localButton = this.val$dialog.getButton(paramDialogInterface.mWhich);
      if (localButton == null)
      {
        if (paramDialogInterface.mMandatory)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Button ");
          ((StringBuilder)localObject).append(paramDialogInterface.mWhich);
          ((StringBuilder)localObject).append(" is mandatory");
          throw new RuntimeException(((StringBuilder)localObject).toString());
        }
      }
      else if (paramDialogInterface.mClickAction != null) {
        localButton.setOnClickListener(new XWalkDialogManager.1.1(this, paramDialogInterface.mClickAction));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkDialogManager.1
 * JD-Core Version:    0.7.0.1
 */