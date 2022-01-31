import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class sek
  extends amar
{
  sek(sei paramsei) {}
  
  public void a(int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ReadInJoyFeedsHeaderVie", 2, "handleKandianSearchHotwordError, resultCode = " + paramInt1 + "， errorMsg = " + paramString + ", fromType = " + paramInt2);
    }
  }
  
  public void a(List<ayks> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyFeedsHeaderVie", 2, "handleKandianSearchHotwordResult, result = " + paramList + ", fromType = " + paramInt);
    }
    if (paramInt != 6) {}
    while (((this.a.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel != null) && (this.a.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel.a.size() != 0)) || (paramList == null) || (paramList.size() <= 0) || (!(paramList.get(0) instanceof HotWordSearchEntryDataModel))) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqSearchModelHotWordSearchEntryDataModel = ((HotWordSearchEntryDataModel)paramList.get(0));
    sei.jdField_a_of_type_Int = 0;
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sek
 * JD-Core Version:    0.7.0.1
 */