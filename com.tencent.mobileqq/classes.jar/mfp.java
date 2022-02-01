import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.ui.MultiVideoCtrlLayerUIBase;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class mfp
  implements View.OnClickListener
{
  public mfp(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase, ImageView paramImageView) {}
  
  public void onClick(View paramView)
  {
    ((TextView)this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.a.findViewById(2131373531)).setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_a_of_type_ComTencentAvUiMultiVideoCtrlLayerUIBase.f = true;
    bcst.b(null, "CliOper", "", "", "0X800AEB8", "0X800AEB8", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mfp
 * JD-Core Version:    0.7.0.1
 */