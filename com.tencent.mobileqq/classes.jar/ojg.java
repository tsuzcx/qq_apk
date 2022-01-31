import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceAndTextItem;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.LayerEventListener;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextFaceEditLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextFaceEditLayer.LayerListener;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.LayerListener;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleEditView.DoodleEditViewListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.biz.qqstory.takevideo.doodle.util.GestureHelper.ZoomItem;
import java.util.List;

public class ojg
  implements TextFaceEditLayer.LayerListener
{
  public ojg(DoodleEditView paramDoodleEditView) {}
  
  public void a(GestureHelper.ZoomItem paramZoomItem)
  {
    if ((paramZoomItem instanceof TextLayer.TextItem))
    {
      paramZoomItem = (TextLayer)this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.a("TextLayer");
      if (paramZoomItem != null) {
        paramZoomItem.a();
      }
    }
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.b();
  }
  
  public void a(GestureHelper.ZoomItem paramZoomItem, int paramInt1, int paramInt2)
  {
    if ((paramZoomItem instanceof TextLayer.TextItem))
    {
      SLog.b("DoodleEditView", "click the TextItem:" + paramZoomItem);
      paramZoomItem = (TextLayer)this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.a("TextLayer");
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.b();
      if ((paramZoomItem != null) && (paramZoomItem.a != null))
      {
        paramZoomItem.d();
        paramZoomItem.a.a();
      }
    }
    FaceLayer localFaceLayer;
    do
    {
      do
      {
        do
        {
          return;
        } while (!(paramZoomItem instanceof FaceLayer.FaceItem));
        SLog.b("DoodleEditView", "click the FaceAndTextItem:" + paramZoomItem);
        paramZoomItem.d = false;
        localFaceLayer = (FaceLayer)this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a.a("FaceLayer");
        FaceLayer.FaceItem localFaceItem = (FaceLayer.FaceItem)paramZoomItem;
        if (localFaceLayer != null) {
          localFaceLayer.jdField_a_of_type_JavaUtilList.add(localFaceItem);
        }
        this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerTextFaceEditLayer.b();
        this.a.setVisibility(8);
      } while (DoodleEditView.a(this.a) == null);
      if (!(paramZoomItem instanceof FaceLayer.FaceAndTextItem)) {
        break;
      }
    } while ((localFaceLayer == null) || (localFaceLayer.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$LayerEventListener == null));
    localFaceLayer.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerFaceLayer$LayerEventListener.a((FaceLayer.FaceAndTextItem)paramZoomItem);
    return;
    DoodleEditView.a(this.a).a(paramZoomItem);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ojg
 * JD-Core Version:    0.7.0.1
 */