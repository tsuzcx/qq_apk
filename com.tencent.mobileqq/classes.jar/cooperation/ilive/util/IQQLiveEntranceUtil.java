package cooperation.ilive.util;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQQLiveEntranceUtil
  extends QRouteApi
{
  public abstract void oldLiveAnchorEntranceJump(Context paramContext, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.util.IQQLiveEntranceUtil
 * JD-Core Version:    0.7.0.1
 */