import com.tencent.biz.pubaccount.readinjoy.video.VideoShareHelper;
import com.tencent.biz.widgets.ElasticHorScrView;

public class mfo
  implements Runnable
{
  public mfo(VideoShareHelper paramVideoShareHelper, ElasticHorScrView paramElasticHorScrView1, int paramInt1, ElasticHorScrView paramElasticHorScrView2, int paramInt2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.getWidth() < this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
    }
    while (this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.getWidth() < this.jdField_b_of_type_Int)
    {
      this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(true);
      return;
      this.jdField_a_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
    }
    this.jdField_b_of_type_ComTencentBizWidgetsElasticHorScrView.setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mfo
 * JD-Core Version:    0.7.0.1
 */