import android.os.Handler;
import android.widget.ImageView;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.filter.EffectFilterTools;
import com.tencent.av.business.manager.filter.FilterItem;
import com.tencent.av.ui.funchat.filter.EffectFilterPanel;
import com.tencent.av.ui.funchat.filter.EffectFilterTextPager.OnEffectFilterChangeListener;
import com.tencent.mobileqq.statistics.MultiVideoRichActionReportCollection;

public class kfa
  implements EffectFilterTextPager.OnEffectFilterChangeListener
{
  EffectFilterTextPager.OnEffectFilterChangeListener jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager$OnEffectFilterChangeListener;
  
  public kfa(EffectFilterPanel paramEffectFilterPanel, EffectFilterTextPager.OnEffectFilterChangeListener paramOnEffectFilterChangeListener)
  {
    a(paramOnEffectFilterChangeListener);
  }
  
  public void a(int paramInt, String paramString)
  {
    AVLog.c("EffectFilterPanel", "OnItemSelected ddd:" + paramInt + "|" + paramString + "|" + EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).getVisibility() + "|" + this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager$OnEffectFilterChangeListener);
    if (EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).getVisibility() == 0)
    {
      EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).removeCallbacks(EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel));
      EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).clearAnimation();
      EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).setVisibility(8);
    }
    paramString = (FilterItem)EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).a(paramString);
    EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).a(paramString);
    if (paramString != null)
    {
      if (!paramString.isUsable()) {
        EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).a(paramString);
      }
      MultiVideoRichActionReportCollection.c(paramString.getId());
      if ((paramString.getId() != null) && (paramString.getId().compareToIgnoreCase("MANHUA") == 0)) {
        EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).a().f(51, paramString.getId());
      }
    }
    else
    {
      return;
    }
    EffectFilterPanel.a(this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterPanel).a().f(0, paramString.getId());
  }
  
  public void a(EffectFilterTextPager.OnEffectFilterChangeListener paramOnEffectFilterChangeListener)
  {
    this.jdField_a_of_type_ComTencentAvUiFunchatFilterEffectFilterTextPager$OnEffectFilterChangeListener = paramOnEffectFilterChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kfa
 * JD-Core Version:    0.7.0.1
 */