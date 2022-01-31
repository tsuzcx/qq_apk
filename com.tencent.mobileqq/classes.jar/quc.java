import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.qphone.base.util.QLog;

class quc
  implements qts
{
  quc(qua paramqua, ColumnInfo paramColumnInfo) {}
  
  public void a(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    QLog.i("RIJUGC.ManageColumnPresenter", 2, "createTopic response errorCode = " + paramInt1 + ", errorMsg = " + paramString1 + ", tip = " + paramString2 + ", topicId = " + paramInt2);
    if (qua.a(this.jdField_a_of_type_Qua) == null) {
      return;
    }
    qua.a(this.jdField_a_of_type_Qua).d();
    if (paramInt1 == 0)
    {
      if (paramString2.equals(Integer.toString(0)))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo.columnID = paramInt2;
        qua.a(this.jdField_a_of_type_Qua).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo, true);
        qua.a(this.jdField_a_of_type_Qua).a(2131718800);
        qua.a(this.jdField_a_of_type_Qua).a();
        return;
      }
      qua.a(this.jdField_a_of_type_Qua).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo, false);
      if (!paramString1.isEmpty())
      {
        qua.a(this.jdField_a_of_type_Qua).a(paramString1);
        return;
      }
      qua.a(this.jdField_a_of_type_Qua).a(2131718799);
      return;
    }
    qua.a(this.jdField_a_of_type_Qua).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo, false);
    qua.a(this.jdField_a_of_type_Qua).a(2131718799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     quc
 * JD-Core Version:    0.7.0.1
 */