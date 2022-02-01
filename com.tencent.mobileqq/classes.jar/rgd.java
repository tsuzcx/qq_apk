import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.qphone.base.util.QLog;

class rgd
  implements rft
{
  rgd(rgb paramrgb, ColumnInfo paramColumnInfo) {}
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    QLog.i("RIJUGC.ManageColumnPresenter", 2, "createTopic response errorCode = " + paramInt1 + ", errorMsg = " + paramString + ", bizCode = " + paramInt2 + ", topicId = " + paramInt3);
    if (rgb.a(this.jdField_a_of_type_Rgb) == null) {
      return;
    }
    rgb.a(this.jdField_a_of_type_Rgb).d();
    if (paramInt1 == 0)
    {
      if (paramInt2 == 0)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo.columnID = paramInt3;
        rgb.a(this.jdField_a_of_type_Rgb).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo, true);
        rgb.a(this.jdField_a_of_type_Rgb).a(2131717069);
        rgb.a(this.jdField_a_of_type_Rgb).a();
        return;
      }
      rgb.a(this.jdField_a_of_type_Rgb).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo, false);
      if (!paramString.isEmpty())
      {
        rgb.a(this.jdField_a_of_type_Rgb).a(paramString);
        return;
      }
      rgb.a(this.jdField_a_of_type_Rgb).a(2131717068);
      return;
    }
    rgb.a(this.jdField_a_of_type_Rgb).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructColumnInfo, false);
    rgb.a(this.jdField_a_of_type_Rgb).a(2131717068);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rgd
 * JD-Core Version:    0.7.0.1
 */