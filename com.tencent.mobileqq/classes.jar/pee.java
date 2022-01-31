import com.tencent.pts.core.PTSJNIHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class pee
  extends pdm
{
  pee(ped paramped) {}
  
  public void a(int paramInt, List<Long> paramList, long paramLong)
  {
    if (!odm.c(paramInt)) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onFeedsLoaded], channelID = ").append(paramInt).append("\n");
    paramList = ogy.a().a(Integer.valueOf(paramInt), paramList);
    paramInt = 0;
    while (paramInt < paramList.size())
    {
      ((StringBuilder)localObject).append("articleInfo [").append(paramInt).append("]: ").append(paramList.get(paramInt)).append("\n");
      paramInt += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PTSLoadDailyDBArticlesModule", 1, ((StringBuilder)localObject).toString());
    }
    localObject = new Object[1];
    localObject[0] = peb.a(true, paramList);
    if (QLog.isColorLevel()) {
      QLog.i("PTSLoadDailyDBArticlesModule", 1, "[onFeedsLoaded], args[0]" + localObject[0]);
    }
    QLog.i("PTSLoadDailyDBArticlesModule", 1, "js callback ptr = " + paramLong);
    PTSJNIHandler.jsFunctionCallbackAsync(paramLong, (Object[])localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pee
 * JD-Core Version:    0.7.0.1
 */