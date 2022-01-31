import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.biz.widgets.ElasticHorScrView;

public class nbr
  implements Runnable
{
  public nbr(PublicAccountImageCollectionMainActivity paramPublicAccountImageCollectionMainActivity, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionMainActivity.a.getWidth() < this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionMainActivity.a.setMove(true);
    }
    while (this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionMainActivity.b.getWidth() < this.b)
    {
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionMainActivity.b.setMove(true);
      return;
      this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionMainActivity.a.setMove(false);
    }
    this.jdField_a_of_type_ComTencentBizPublicAccountImageCollectionPublicAccountImageCollectionMainActivity.b.setMove(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nbr
 * JD-Core Version:    0.7.0.1
 */