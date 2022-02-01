package cooperation.ilive.share;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import cooperation.ilive.IliveLaunchFragment;

public class IliveShareImpl
  implements ILiveShare
{
  public void openShare(Context paramContext, Bundle paramBundle)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("share", 1);
    localIntent.putExtras(paramBundle);
    IliveLaunchFragment.startSelf(paramContext, localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.share.IliveShareImpl
 * JD-Core Version:    0.7.0.1
 */