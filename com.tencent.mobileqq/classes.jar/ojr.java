import android.util.SparseBooleanArray;
import android.view.View;
import com.tencent.biz.qqstory.takevideo.doodle.layer.LineLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.model.TextInfo;
import com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog.EditTextDialogEventListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.DoodleEventListener;

public class ojr
  implements EditTextDialog.EditTextDialogEventListener
{
  private ojr(DoodleLayout paramDoodleLayout) {}
  
  public void a()
  {
    this.a.a().c();
  }
  
  public void a(int paramInt)
  {
    this.a.a().a(paramInt);
  }
  
  public void a(boolean paramBoolean, TextInfo paramTextInfo)
  {
    TextLayer localTextLayer = this.a.a();
    if (paramBoolean)
    {
      localTextLayer.a(true);
      switch (this.a.b)
      {
      }
      for (;;)
      {
        this.a.c(3);
        return;
        this.a.a().b(false);
      }
    }
    if (paramTextInfo.jdField_a_of_type_Int != -1) {
      this.a.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(this.a.jdField_a_of_type_Int, true);
    }
    for (;;)
    {
      localTextLayer.a(paramTextInfo);
      localTextLayer.a(false);
      this.a.a(new View[] { this.a.jdField_a_of_type_AndroidWidgetRelativeLayout });
      this.a.c(0);
      this.a.d(0);
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.i();
      return;
      this.a.jdField_a_of_type_AndroidUtilSparseBooleanArray.put(this.a.jdField_a_of_type_Int, false);
    }
  }
  
  public void b(int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener != null) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout$DoodleEventListener.b(3, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ojr
 * JD-Core Version:    0.7.0.1
 */