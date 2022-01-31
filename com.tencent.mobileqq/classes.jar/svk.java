import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.widget.ARMapHongBaoListView;

class svk
  implements View.OnLayoutChangeListener
{
  svk(svc paramsvc, spz paramspz) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    urk.b(svc.b(), "onLayoutChange");
    if ((paramInt4 - paramInt2 > 0) && (paramInt3 - paramInt1 > 0) && ((this.jdField_a_of_type_Svc.d) || (this.jdField_a_of_type_Svc.e)) && (!this.jdField_a_of_type_Svc.jdField_a_of_type_ComTencentWidgetARMapHongBaoListView.mForStory))
    {
      urk.b(svc.b(), "first show node, showStoryNode");
      if (this.jdField_a_of_type_Svc.d)
      {
        this.jdField_a_of_type_Svc.d = false;
        this.jdField_a_of_type_Spz.b("first_show_node", Boolean.valueOf(false));
      }
      this.jdField_a_of_type_Svc.e = false;
      if (this.jdField_a_of_type_Svc.a()) {
        this.jdField_a_of_type_Svc.jdField_a_of_type_Suo.a("exp_story", 4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     svk
 * JD-Core Version:    0.7.0.1
 */