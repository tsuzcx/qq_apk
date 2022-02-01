import android.text.TextUtils;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class tdj
  extends anxw
{
  tdj(tdi paramtdi) {}
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyTabTopSearchHeaderController", 2, "handleKandianSearchHotwordError, resultCode = " + paramInt1 + "， errorMsg = " + paramString + ", fromType = " + paramInt2);
    }
  }
  
  public void a(List<bbof> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyTabTopSearchHeaderController", 2, "handleKandianSearchHotwordResult, result = " + paramList + ", fromType = " + paramInt);
    }
    if (paramInt != 10) {}
    String str;
    bbof localbbof;
    do
    {
      return;
      while (!paramList.hasNext())
      {
        do
        {
          str = bbgu.b;
        } while ((paramList == null) || (paramList.size() <= 0));
        paramList = paramList.iterator();
      }
      localbbof = (bbof)paramList.next();
    } while (((localbbof.jdField_a_of_type_Int != 1) || (!TextUtils.equals(str, "Hot_word"))) && ((localbbof.jdField_a_of_type_Int != 7) || (!TextUtils.equals(str, "Recom_word"))));
    this.a.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = ((HotWordSearchEntryDataModel)localbbof);
    tdi.b = 0;
    tdi.jdField_a_of_type_Int = 0;
    this.a.a(true, -1, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tdj
 * JD-Core Version:    0.7.0.1
 */