import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.UniteSearchObserver;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.mobileqq.search.model.SearchEntryDataModel;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class str
  extends UniteSearchObserver
{
  public str(Leba paramLeba) {}
  
  public void b(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "handleSearchDiscoveryError error, resultCode = " + paramInt1 + ",  errorMsg = " + paramString + ", fromType = " + paramInt2);
    }
  }
  
  public void b(List paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.lebatab.leba", 2, "handleSearchDiscoveryResult() result = " + paramList + ", fromType = " + paramInt);
    }
    if (paramInt != 4) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.leba", 2, "handleSearchDiscoveryResult(), fromType is wrong, return");
      }
    }
    for (;;)
    {
      return;
      paramInt = 0;
      while (paramInt < paramList.size())
      {
        SearchEntryDataModel localSearchEntryDataModel = (SearchEntryDataModel)paramList.get(paramInt);
        if ((localSearchEntryDataModel instanceof HotWordSearchEntryDataModel))
        {
          Leba.a(this.a, ((HotWordSearchEntryDataModel)localSearchEntryDataModel).a);
          return;
        }
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     str
 * JD-Core Version:    0.7.0.1
 */