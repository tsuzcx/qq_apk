package com.tencent.tkd.topicsdk.common;

import android.app.Dialog;
import android.os.Message;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/common/ActivityLeakSolution;", "", "()V", "TAG", "", "fixMessageLeak", "", "dialog", "Landroid/app/Dialog;", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public final class ActivityLeakSolution
{
  public static final ActivityLeakSolution a = new ActivityLeakSolution();
  
  public final void a(@Nullable Dialog paramDialog)
  {
    if (paramDialog == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = CollectionsKt.arrayListOf(new String[] { "mDismissMessage", "mCancelMessage", "mShowMessage" }).iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (String)localIterator.next();
        try
        {
          localObject = Dialog.class.getDeclaredField((String)localObject);
          if (localObject != null)
          {
            if (!((Field)localObject).isAccessible()) {
              ((Field)localObject).setAccessible(true);
            }
            localObject = ((Field)localObject).get(paramDialog);
            if (((localObject instanceof Message)) && (((Message)localObject).obj != null))
            {
              ((Message)localObject).obj = null;
              ((Message)localObject).what = 0;
            }
          }
        }
        catch (Exception localException)
        {
          Log.e("ActivityLeakSolution", "fixMessageLeak Exception: " + localException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.ActivityLeakSolution
 * JD-Core Version:    0.7.0.1
 */