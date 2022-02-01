package com.tencent.mobileqq.werewolves;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class WerewolvesHandler$UIHandler
  extends Handler
{
  public WerewolvesHandler$UIHandler()
  {
    super(Looper.getMainLooper());
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    paramMessage = (String[])paramMessage.obj;
    Object localObject = paramMessage[0];
    CharSequence localCharSequence = paramMessage[1];
    WeakReference localWeakReference = (WeakReference)WerewolvesHandler.b.remove(localObject);
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      if ((((TextView)localWeakReference.get()).getTag() instanceof String[])) {
        paramMessage = (String[])((TextView)localWeakReference.get()).getTag();
      } else {
        paramMessage = null;
      }
      if ((paramMessage == null) || (paramMessage.length != 2) || (!paramMessage[0].equals(localObject))) {}
    }
    try
    {
      ((TextView)localWeakReference.get()).setText(String.format(paramMessage[1], new Object[] { localCharSequence }));
    }
    catch (Exception paramMessage)
    {
      label137:
      break label137;
    }
    ((TextView)localWeakReference.get()).setText(localCharSequence);
    ((TextView)localWeakReference.get()).setText(localCharSequence);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WerewolvesHandler.UIHandler
 * JD-Core Version:    0.7.0.1
 */