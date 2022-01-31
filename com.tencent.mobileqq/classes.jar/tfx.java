import UserGrowth.stH5OpInfo;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;

class tfx
  implements tmc
{
  tfx(tfw paramtfw, Context paramContext, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed) {}
  
  public void a(String paramString, int paramInt)
  {
    tfw.a(this.jdField_a_of_type_Tfw, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, paramString, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed, 501);
    tju.a(114, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.h5_op_info.type, this.jdField_a_of_type_Int, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.h5_op_info.id);
    WSPublicAccReport.getInstance().reportOperationCard("gzh_click", 1000003, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
  }
  
  public void b(String paramString, int paramInt)
  {
    tfw.a(this.jdField_a_of_type_Tfw, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_Int, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
  }
  
  public void c(String paramString, int paramInt)
  {
    tfw.a(this.jdField_a_of_type_Tfw, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
    tju.a(115, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.h5_op_info.type, this.jdField_a_of_type_Int, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.h5_op_info.id);
    WSPublicAccReport.getInstance().reportOperationCard("gzh_click", 1000002, this.jdField_a_of_type_UserGrowthStSimpleMetaFeed);
  }
  
  public void d(String paramString, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tfx
 * JD-Core Version:    0.7.0.1
 */