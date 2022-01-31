import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class rov
  extends akjb
{
  rov(rou paramrou) {}
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyTabTopSearchHeaderController", 2, "handleKandianSearchHotwordError, resultCode = " + paramInt1 + "， errorMsg = " + paramString + ", fromType = " + paramInt2);
    }
  }
  
  public void a(List<awpp> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyTabTopSearchHeaderController", 2, "handleKandianSearchHotwordResult, result = " + paramList + ", fromType = " + paramInt);
    }
    if (paramInt != 10) {}
    awpp localawpp;
    do
    {
      do
      {
        return;
        while ((paramList == null) || (paramList.size() <= 0)) {}
        paramList = paramList.iterator();
      } while (!paramList.hasNext());
      localawpp = (awpp)paramList.next();
    } while (!(localawpp instanceof HotWordSearchEntryDataModel));
    this.a.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = ((HotWordSearchEntryDataModel)localawpp);
    rou.jdField_a_of_type_Int = 0;
    this.a.a(false, -1, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rov
 * JD-Core Version:    0.7.0.1
 */