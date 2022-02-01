import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class mrg
  extends anxg
{
  mrg(mrf parammrf) {}
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, String paramString3, String paramString4, int paramInt4, int paramInt5, long paramLong)
  {
    mrl localmrl = (mrl)mrf.a(this.a).a(paramLong);
    if (paramBoolean)
    {
      mrf.a(this.a, SystemClock.elapsedRealtime());
      paramString2 = new mrn(SystemClock.elapsedRealtime(), paramInt3, paramString2, paramString3, paramString4);
      mrf.a(this.a).put(paramString1, paramString2);
      if (localmrl != null)
      {
        localmrl.a(paramInt3, paramString2, paramInt5);
        mrf.a(this.a).a(paramLong);
        this.a.a = paramInt4;
        if (mrf.a(this.a) == null) {
          break label261;
        }
        mrf.a(this.a).a(paramInt4);
        mrf.a(this.a, null);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "onGetTroopHideWebConfig record gVideoStrategy:" + paramInt3 + " isSucc:" + paramBoolean);
      }
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "mGVideoGrayConfigListener is null");
      break;
      paramString1 = (mrl)mrf.a(this.a).a(paramLong);
      if (paramString1 != null)
      {
        paramString1.a(-1, null, paramInt5);
        mrf.a(this.a).a(paramLong);
        break;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "mGVideoGrayConfigListener is null");
      break;
      label261:
      if (QLog.isColorLevel()) {
        QLog.e("GroupVideoManager.GVideoGrayConfig", 2, "mGVideoPreDownloadListener is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mrg
 * JD-Core Version:    0.7.0.1
 */