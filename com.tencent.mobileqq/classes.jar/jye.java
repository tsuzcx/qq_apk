import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.GAudioUIObserver;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.ui.MultiMembersAudioUI;
import com.tencent.av.ui.MultiVideoEnterPageActivity;
import com.tencent.av.ui.MultiVideoEnterPageMembersControlUI;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class jye
  extends GAudioUIObserver
{
  public jye(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  protected void a(int paramInt)
  {
    this.a.b(paramInt);
  }
  
  protected void a(long paramLong, ArrayList paramArrayList, int paramInt1, int paramInt2)
  {
    super.a(paramLong, paramArrayList, paramInt1, paramInt2);
    if (paramArrayList == null)
    {
      QLog.w(this.a.jdField_a_of_type_JavaLangString, 1, "onUserListALLUpdate, simpleData is null, flag[" + this.a.jdField_a_of_type_Boolean + "]");
      if (!this.a.jdField_a_of_type_Boolean)
      {
        this.a.b();
        MultiVideoEnterPageActivity.c(this.a);
      }
    }
    label310:
    do
    {
      return;
      if ((paramInt1 == 2) || (paramInt1 == 10) || (paramInt1 == 12)) {}
      for (this.a.e = paramArrayList.size();; this.a.e = paramInt2)
      {
        QLog.w(this.a.jdField_a_of_type_JavaLangString, 1, "onUserListALLUpdate, flag[" + this.a.jdField_a_of_type_Boolean + "], userCount[" + paramInt2 + "], simpleData[" + paramArrayList.size() + "], mMemberCount[" + this.a.e + "], multiAVType[" + paramInt1 + "]");
        if (this.a.e != 0) {
          break label383;
        }
        if (!this.a.jdField_a_of_type_Boolean) {
          break label368;
        }
        if ((this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI == null) || (this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI.length != 2)) {
          break;
        }
        if (paramInt1 != 2) {
          break label310;
        }
        this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].c.setVisibility(0);
        this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].c.setText("当前无人视频");
        this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        return;
      }
    } while (paramInt1 != 10);
    this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].c.setVisibility(0);
    this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].c.setText("当前无人通话");
    this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    return;
    label368:
    this.a.b();
    MultiVideoEnterPageActivity.d(this.a);
    return;
    label383:
    this.a.b.setVisibility(8);
    if ((paramInt1 == 10) && (this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI != null) && (this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI.length > 1))
    {
      this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].setVisibility(0);
      this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].a(paramArrayList);
      if (this.a.jdField_a_of_type_Boolean)
      {
        this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].c.setVisibility(8);
        this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[1].jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      }
    }
    for (;;)
    {
      this.a.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
      this.a.b.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.setVisibility(0);
      this.a.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(paramArrayList);
      paramArrayList = "通话成员（" + this.a.e + "人）";
      this.a.d.setText(paramArrayList);
      this.a.c();
      this.a.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.a.jdField_a_of_type_Jym);
      return;
      if ((this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI != null) && (this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI.length > 0))
      {
        this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
        this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].setVisibility(0);
        this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].a(paramArrayList);
        if (this.a.jdField_a_of_type_Boolean)
        {
          this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].c.setVisibility(8);
          this.a.jdField_a_of_type_ArrayOfComTencentAvUiMultiVideoEnterPageMembersControlUI[0].jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
        }
      }
    }
  }
  
  protected void a(long paramLong, boolean paramBoolean, int paramInt)
  {
    if (this.a.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
      } while (paramLong != this.a.jdField_a_of_type_Long);
      if (paramBoolean)
      {
        MultiVideoEnterPageActivity.b(this.a);
        return;
      }
    } while ((this.a.jdField_a_of_type_Boolean) || (!MultiVideoEnterPageActivity.a(this.a)));
    this.a.a(paramInt);
  }
  
  protected void d()
  {
    if (!this.a.jdField_a_of_type_Boolean)
    {
      super.d();
      ArrayList localArrayList = this.a.jdField_a_of_type_ComTencentAvVideoController.b();
      this.a.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jye
 * JD-Core Version:    0.7.0.1
 */