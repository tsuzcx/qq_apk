package com.tencent.tav;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.text.TextUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class Utils
{
  private static final String FIELD_NAME_HANDLER_M_QUEUE = "mQueue";
  private static final String FIELD_NAME_MESSAGE_NEXT = "next";
  private static final String FIELD_NAME_MESSAGE_QUEUE_M_MESSAGES = "mMessages";
  public static final long UNIT_TIME = 1000L;
  
  public static Bitmap flipYBitmap(Bitmap paramBitmap)
  {
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(1.0F, -1.0F, paramBitmap.getWidth() / 2.0F, paramBitmap.getHeight() / 2.0F);
    return Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), localMatrix, true);
  }
  
  @NotNull
  public static ArrayList<Message> getContinuesMessage(int paramInt, Class paramClass, Handler paramHandler)
  {
    Message localMessage = getMessageFromHandler(paramHandler);
    ArrayList localArrayList = new ArrayList();
    while (localMessage != null)
    {
      if ((localMessage.what == paramInt) && (paramClass.isInstance(localMessage.obj))) {
        localArrayList.add(localMessage);
      } else if (localMessage.getTarget() == paramHandler) {
        return localArrayList;
      }
      Field localField = Message.class.getDeclaredField("next");
      localField.setAccessible(true);
      localMessage = (Message)localField.get(localMessage);
    }
    return localArrayList;
  }
  
  public static long getCurrentUsTime()
  {
    return System.nanoTime() / 1000L;
  }
  
  public static Message getMessageFromHandler(Handler paramHandler)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramHandler = paramHandler.getLooper().getQueue();
    }
    else
    {
      localField = Handler.class.getDeclaredField("mQueue");
      localField.setAccessible(true);
      paramHandler = (MessageQueue)localField.get(paramHandler);
    }
    Field localField = MessageQueue.class.getDeclaredField("mMessages");
    localField.setAccessible(true);
    return (Message)localField.get(paramHandler);
  }
  
  public static String getPhoneName()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(Build.MANUFACTURER.toUpperCase());
    ((StringBuilder)localObject).append(" ");
    ((StringBuilder)localObject).append(Build.MODEL);
    localObject = ((StringBuilder)localObject).toString();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return "";
    }
    return ((String)localObject).replace(" ", "_").replace("+", "").replace("(t)", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tav.Utils
 * JD-Core Version:    0.7.0.1
 */