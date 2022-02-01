import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.qphone.base.util.QLog;

class rzs
  implements rzi
{
  rzs(rzq paramrzq, ColumnInfo paramColumnInfo) {}
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    QLog.i("RIJUGC.ManageColumnPresenter", 2, "createTopic response errorCode = " + paramInt1 + ", errorMsg = " + paramString + ", bizCode = " + paramInt2 + ", topicId = " + paramInt3);
    if (rzq.a(this.jdField_a_of_type_Rzq) == null) {
      return;
    }
    rzq.a(this.jdField_a_of_type_Rzq).d();
    if (paramInt1 == 0)
    {
      if (paramInt2 == 0)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo.columnID = paramInt3;
        rzq.a(this.jdField_a_of_type_Rzq).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo, true);
        rzq.a(this.jdField_a_of_type_Rzq).a(2131717672);
        rzq.a(this.jdField_a_of_type_Rzq).a();
        return;
      }
      rzq.a(this.jdField_a_of_type_Rzq).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo, false);
      if (!paramString.isEmpty())
      {
        rzq.a(this.jdField_a_of_type_Rzq).a(paramString);
        return;
      }
      rzq.a(this.jdField_a_of_type_Rzq).a(2131717671);
      return;
    }
    rzq.a(this.jdField_a_of_type_Rzq).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo, false);
    rzq.a(this.jdField_a_of_type_Rzq).a(2131717671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rzs
 * JD-Core Version:    0.7.0.1
 */