import com.tencent.pts.core.jni.PTSJsJniHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class qnh
  extends qlu
{
  qnh(qng paramqng) {}
  
  public void a(int paramInt, List<Long> paramList, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onFeedsLoaded], channelID = ").append(paramInt).append("\n");
    paramList = pkm.a().a(Integer.valueOf(paramInt), paramList);
    if (QLog.isColorLevel())
    {
      paramInt = 0;
      while (paramInt < paramList.size())
      {
        ((StringBuilder)localObject).append("articleInfo [").append(paramInt).append("]: ").append(paramList.get(paramInt)).append("\n");
        paramInt += 1;
      }
      QLog.i("PTSLoadFeedsModule", 1, ((StringBuilder)localObject).toString());
    }
    localObject = new Object[1];
    localObject[0] = qne.a(true, paramList);
    if (QLog.isColorLevel()) {
      QLog.i("PTSLoadFeedsModule", 1, "[onFeedsLoaded], args[0]" + localObject[0]);
    }
    QLog.i("PTSLoadFeedsModule", 1, "js callback ptr = " + paramLong);
    PTSJsJniHandler.jsFunctionCallbackAsync(paramLong, (Object[])localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qnh
 * JD-Core Version:    0.7.0.1
 */