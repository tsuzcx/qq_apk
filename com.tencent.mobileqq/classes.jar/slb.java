import UserGrowth.stH5OpInfo;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;

class slb
  implements snn
{
  slb(sla paramsla, Context paramContext, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed) {}
  
  public void a(String paramString, int paramInt)
  {
    sla.a(this.jdField_a_of_type_Sla, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, paramString, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, 501);
    sms.a(114, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.h5_op_info.type, this.jdField_a_of_type_Int, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.h5_op_info.id);
    WSPublicAccReport.getInstance().reportOperationCard("gzh_click", 1000003, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.h5_op_info.id);
  }
  
  public void b(String paramString, int paramInt)
  {
    sla.a(this.jdField_a_of_type_Sla, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
  }
  
  public void c(String paramString, int paramInt)
  {
    sla.a(this.jdField_a_of_type_Sla, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
    sms.a(115, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.h5_op_info.type, this.jdField_a_of_type_Int, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.h5_op_info.id);
    WSPublicAccReport.getInstance().reportOperationCard("gzh_click", 1000002, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.h5_op_info.id);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     slb
 * JD-Core Version:    0.7.0.1
 */