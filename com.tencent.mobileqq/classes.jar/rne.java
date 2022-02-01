import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.qphone.base.util.QLog;

class rne
  implements rmt
{
  rne(rnb paramrnb, ColumnInfo paramColumnInfo) {}
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    QLog.i("RIJUGC.ManageColumnPresenter", 2, "createTopic response errorCode = " + paramInt1 + ", errorMsg = " + paramString + ", bizCode = " + paramInt2 + ", topicId = " + paramInt3);
    if (rnb.a(this.jdField_a_of_type_Rnb) == null) {
      return;
    }
    rnb.a(this.jdField_a_of_type_Rnb).d();
    if (paramInt1 == 0)
    {
      if (paramInt2 == 0)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo.columnID = paramInt3;
        rnb.a(this.jdField_a_of_type_Rnb).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo, true);
        rnb.a(this.jdField_a_of_type_Rnb).a(2131717367);
        rnb.a(this.jdField_a_of_type_Rnb).a();
        return;
      }
      rnb.a(this.jdField_a_of_type_Rnb).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo, false);
      if (!paramString.isEmpty())
      {
        rnb.a(this.jdField_a_of_type_Rnb).a(paramString);
        return;
      }
      rnb.a(this.jdField_a_of_type_Rnb).a(2131717366);
      return;
    }
    rnb.a(this.jdField_a_of_type_Rnb).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo, false);
    rnb.a(this.jdField_a_of_type_Rnb).a(2131717366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rne
 * JD-Core Version:    0.7.0.1
 */