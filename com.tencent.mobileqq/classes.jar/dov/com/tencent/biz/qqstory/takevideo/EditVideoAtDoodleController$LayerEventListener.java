package dov.com.tencent.biz.qqstory.takevideo;

import android.graphics.PointF;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.AtLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.AtLayer.AtItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.AtLayer.LayerEventListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;

public class EditVideoAtDoodleController$LayerEventListener
  implements AtLayer.LayerEventListener
{
  public EditVideoAtDoodleController$LayerEventListener(EditVideoAtDoodleController paramEditVideoAtDoodleController) {}
  
  public void a(int paramInt)
  {
    QQToast.a(EditVideoAtDoodleController.a(this.a), "最多可以圈10个好友哦", 0).a();
  }
  
  public void a(AtLayer.AtItem paramAtItem)
  {
    if (paramAtItem.jdField_a_of_type_Int == 0)
    {
      f1 = paramAtItem.jdField_a_of_type_AndroidGraphicsPointF.x;
      f2 = paramAtItem.s;
      f3 = -paramAtItem.u;
      if (f1 + f2 + f3 >= paramAtItem.u / 2.0F)
      {
        EditVideoAtDoodleController.a(this.a).a(1, f3 + paramAtItem.s);
        return;
      }
      SLog.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "at label can not be reversed because it will be beyond layer.");
      return;
    }
    float f1 = paramAtItem.jdField_a_of_type_AndroidGraphicsPointF.x;
    float f2 = paramAtItem.s;
    float f3 = paramAtItem.u;
    if (f1 + f2 + f3 <= EditVideoAtDoodleController.a(this.a).getWidth() - paramAtItem.u / 2.0F)
    {
      EditVideoAtDoodleController.a(this.a).a(0, f3 + paramAtItem.s);
      return;
    }
    SLog.c("Q.qqstory.publish.edit.EditVideoAtDoodleController", "at label can not be reversed because it will be beyond layer.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoAtDoodleController.LayerEventListener
 * JD-Core Version:    0.7.0.1
 */