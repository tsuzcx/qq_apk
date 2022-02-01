package cooperation.qqreader.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.support.annotation.Nullable;

public class ReaderContextUtils
{
  @Nullable
  public static Activity a(Context paramContext)
  {
    if ((paramContext instanceof Activity)) {
      return (Activity)paramContext;
    }
    if ((paramContext instanceof ContextWrapper))
    {
      paramContext = (ContextWrapper)paramContext;
      if ((paramContext.getBaseContext() instanceof Activity)) {
        return (Activity)paramContext.getBaseContext();
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qqreader.utils.ReaderContextUtils
 * JD-Core Version:    0.7.0.1
 */