import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyXListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoySocialMsgTips;

class mly
  implements Runnable
{
  mly(mlx parammlx, KandianOx210MsgInfo paramKandianOx210MsgInfo) {}
  
  public void run()
  {
    if ((ReadInJoyListViewGroup.a(this.jdField_a_of_type_Mlx.a) != null) && (ReadInJoyListViewGroup.a(this.jdField_a_of_type_Mlx.a).a())) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.a <= 0)
      {
        ReadInJoyListViewGroup.a(this.jdField_a_of_type_Mlx.a).b();
        ReadInJoyListViewGroup.a(this.jdField_a_of_type_Mlx.a).removeHeaderView(ReadInJoyListViewGroup.a(this.jdField_a_of_type_Mlx.a).a());
      }
    }
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo.a <= 0)
    {
      return;
      ReadInJoyListViewGroup.a(this.jdField_a_of_type_Mlx.a).a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo);
      return;
    }
    this.jdField_a_of_type_Mlx.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructKandianOx210MsgInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mly
 * JD-Core Version:    0.7.0.1
 */