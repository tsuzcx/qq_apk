import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import com.tencent.mobileqq.hotpic.PublicAccountHotPicPanel;

public class oyx
  implements bkqk
{
  public oyx(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public View a(int paramInt)
  {
    EmoticonMainPanel localEmoticonMainPanel = null;
    if (paramInt == 3)
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel == null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel = ((EmoticonMainPanel)View.inflate(ReadInJoyCommentComponentFragment.a(this.a), 2131559123, null));
        this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.setCallBack(ReadInJoyCommentComponentFragment.a(this.a));
        this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.b = true;
        this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.a(ReadInJoyCommentComponentFragment.a(this.a).app, 1008, ReadInJoyCommentComponentFragment.a(this.a), ReadInJoyCommentComponentFragment.a(this.a).getTitleBarHeight(), null, null);
        this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel.k();
      }
      localEmoticonMainPanel = this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonMainPanel;
    }
    while (paramInt != 24) {
      return localEmoticonMainPanel;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel == null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel = ((PublicAccountHotPicPanel)View.inflate(ReadInJoyCommentComponentFragment.a(this.a), 2131559610, null));
      this.a.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel.a(ReadInJoyCommentComponentFragment.a(this.a).app, ReadInJoyCommentComponentFragment.a(this.a), null, this.a.jdField_a_of_type_ComTencentWidgetXPanelContainer);
      this.a.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel.setPublicAccountGifListener(ReadInJoyCommentComponentFragment.a(this.a));
    }
    return this.a.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    boolean bool;
    if ((paramInt1 == 24) && (this.a.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel != null)) {
      if (paramInt2 == 1)
      {
        bool = true;
        this.a.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel.a(bool);
        label34:
        if (paramInt2 != 1) {
          break label82;
        }
        ReadInJoyCommentComponentFragment.a(this.a, 1);
      }
    }
    label82:
    do
    {
      return;
      bool = false;
      break;
      if ((paramInt2 != 24) || (this.a.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel == null)) {
        break label34;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqHotpicPublicAccountHotPicPanel.f();
      break label34;
      if (paramInt2 == 3)
      {
        ReadInJoyCommentComponentFragment.a(this.a, 2);
        return;
      }
      if (paramInt2 == 0)
      {
        ReadInJoyCommentComponentFragment.a(this.a, 0);
        return;
      }
    } while (paramInt2 != 24);
    ReadInJoyCommentComponentFragment.a(this.a, 3);
  }
  
  public boolean a(int paramInt)
  {
    return false;
  }
  
  public void s() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     oyx
 * JD-Core Version:    0.7.0.1
 */