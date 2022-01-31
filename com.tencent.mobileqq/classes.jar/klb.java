import android.view.View;
import com.tencent.biz.addContactTroopView.TroopCardGroup;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.List;
import tencent.im.troop_search_searchtab.searchtab.Card;
import tencent.im.troop_search_searchtab.searchtab.Item1;
import tencent.im.troop_search_searchtab.searchtab.TitleBar;

public class klb
  implements AdapterView.OnItemClickListener
{
  public klb(TroopCardGroup paramTroopCardGroup) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (searchtab.Item1)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    TroopCardGroup.a(this.a, paramAdapterView);
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_find", "", "grptab", "Clk_grpdata", 0, 0, String.valueOf(paramAdapterView.uint64_group_code.get()), this.a.jdField_a_of_type_TencentImTroop_search_searchtabSearchtab$Card.title_bar.str_desc.get(), "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     klb
 * JD-Core Version:    0.7.0.1
 */