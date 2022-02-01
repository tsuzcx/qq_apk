import android.text.TextUtils;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class sub
  extends aoki
{
  sub(sua paramsua) {}
  
  public void handleSearchDiscoveryError(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyTabTopSearchHeaderController", 2, "handleKandianSearchHotwordError, resultCode = " + paramInt1 + "， errorMsg = " + paramString + ", fromType = " + paramInt2);
    }
  }
  
  public void handleSearchDiscoveryResult(List<bcgy> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyTabTopSearchHeaderController", 2, "handleKandianSearchHotwordResult, result = " + paramList + ", fromType = " + paramInt);
    }
    if (paramInt != 10) {}
    String str;
    bcgy localbcgy;
    do
    {
      return;
      while (!paramList.hasNext())
      {
        do
        {
          str = bbzo.b;
        } while ((paramList == null) || (paramList.size() <= 0));
        paramList = paramList.iterator();
      }
      localbcgy = (bcgy)paramList.next();
    } while (((localbcgy.c != 1) || (!TextUtils.equals(str, "Hot_word"))) && ((localbcgy.c != 7) || (!TextUtils.equals(str, "Recom_word"))));
    this.a.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = ((HotWordSearchEntryDataModel)localbcgy);
    sua.jdField_a_of_type_Int = 0;
    this.a.a(true, -1, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sub
 * JD-Core Version:    0.7.0.1
 */