import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;

class pdf
{
  private final EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = new pdg(this);
  private EmoticonMainPanel jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  
  private pdf(pdd parampdd) {}
  
  View a(Context paramContext)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)View.inflate(paramContext, 2131559158, null));
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.onlySysAndEmoji = true;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.init(this.jdField_a_of_type_Pdd.a(), 1008, paramContext, ((BaseActivity)paramContext).getTitleBarHeight(), null, null);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.hideAllTabs();
    }
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
  }
  
  void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.onDestory();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pdf
 * JD-Core Version:    0.7.0.1
 */