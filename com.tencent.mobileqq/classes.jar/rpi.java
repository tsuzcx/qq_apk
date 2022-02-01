import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.qphone.base.util.QLog;

class rpi
  implements rox
{
  rpi(rpf paramrpf, ColumnInfo paramColumnInfo) {}
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    QLog.i("RIJUGC.ManageColumnPresenter", 2, "createTopic response errorCode = " + paramInt1 + ", errorMsg = " + paramString + ", bizCode = " + paramInt2 + ", topicId = " + paramInt3);
    if (rpf.a(this.jdField_a_of_type_Rpf) == null) {
      return;
    }
    rpf.a(this.jdField_a_of_type_Rpf).d();
    if (paramInt1 == 0)
    {
      if (paramInt2 == 0)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo.columnID = paramInt3;
        rpf.a(this.jdField_a_of_type_Rpf).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo, true);
        rpf.a(this.jdField_a_of_type_Rpf).a(2131717014);
        rpf.a(this.jdField_a_of_type_Rpf).a();
        return;
      }
      rpf.a(this.jdField_a_of_type_Rpf).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo, false);
      if (!paramString.isEmpty())
      {
        rpf.a(this.jdField_a_of_type_Rpf).a(paramString);
        return;
      }
      rpf.a(this.jdField_a_of_type_Rpf).a(2131717013);
      return;
    }
    rpf.a(this.jdField_a_of_type_Rpf).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo, false);
    rpf.a(this.jdField_a_of_type_Rpf).a(2131717013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rpi
 * JD-Core Version:    0.7.0.1
 */