import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import eipc.EIPCResult;
import java.util.concurrent.ConcurrentHashMap;

class gn
  extends VasQuickUpdateManager.CallBacker
{
  gn(gm paramgm) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((paramLong == 1000L) && (paramString1.startsWith("signature.item.")))
    {
      paramString2 = paramString1.substring("signature.item.".length(), paramString1.length() - 5);
      if (TextUtils.isDigitsOnly(paramString2))
      {
        paramInt2 = Integer.parseInt(paramString2);
        if (gm.a(this.a).containsKey(Integer.valueOf(paramInt2)))
        {
          int i = ((Integer)gm.a(this.a).get(Integer.valueOf(paramInt2))).intValue();
          paramString2 = new Bundle();
          paramString2.putInt("id", paramInt2);
          paramString2.putInt("notify_type", 7);
          if (paramInt1 != 0) {
            break label273;
          }
          paramString2 = EIPCResult.createResult(0, paramString2);
          this.a.callbackResult(i, paramString2);
          gm.a(this.a).remove(Integer.valueOf(paramInt2));
        }
      }
    }
    if (gm.b(this.a).containsKey(paramString1))
    {
      paramString2 = new Bundle();
      paramString2.putInt("notify_type", 8);
      paramString2.putLong("bid", paramLong);
      paramString2.putString("scid", paramString1);
      if (paramInt1 != 0) {
        break label285;
      }
    }
    label273:
    label285:
    for (paramInt1 = 0;; paramInt1 = -1)
    {
      paramString2.putInt("download_result", paramInt1);
      paramString2 = EIPCResult.createResult(0, paramString2);
      paramInt1 = ((Integer)gm.b(this.a).get(paramString1)).intValue();
      this.a.callbackResult(paramInt1, paramString2);
      gm.b(this.a).remove(paramString1);
      return;
      paramString2 = EIPCResult.createResult(-102, paramString2);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     gn
 * JD-Core Version:    0.7.0.1
 */