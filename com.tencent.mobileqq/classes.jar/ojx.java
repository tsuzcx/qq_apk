import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextFaceEditLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;
import com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer;
import com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer.OnLayerTouchListener;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;

public class ojx
  implements BaseLayer.OnLayerTouchListener
{
  private final int jdField_a_of_type_Int = DisplayUtil.a(DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout), 40.0F);
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  
  private ojx(DoodleLayout paramDoodleLayout) {}
  
  public boolean a(BaseLayer paramBaseLayer, MotionEvent paramMotionEvent)
  {
    if ((paramBaseLayer instanceof FaceLayer)) {
      localRect = new Rect();
    }
    for (Rect localRect = ((FaceLayer)paramBaseLayer).a(localRect);; localRect = null)
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      int i = (int)Math.abs(f2 - DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout));
      int j;
      int k;
      int m;
      switch (paramMotionEvent.getAction() & 0xFF)
      {
      case 3: 
      case 4: 
      default: 
      case 0: 
      case 2: 
      case 5: 
      case 6: 
        do
        {
          return false;
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(new View[] { this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidWidgetRelativeLayout });
          this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.b.getGlobalVisibleRect(this.jdField_a_of_type_AndroidGraphicsRect);
          paramBaseLayer = this.jdField_a_of_type_AndroidGraphicsRect;
          paramBaseLayer.top -= this.jdField_a_of_type_Int;
          paramBaseLayer = this.jdField_a_of_type_AndroidGraphicsRect;
          paramBaseLayer.bottom += this.jdField_a_of_type_Int;
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleView.getGlobalVisibleRect(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect);
          DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, (int)f2);
          this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
          this.jdField_a_of_type_AndroidOsHandler.postDelayed(new ojy(this), 200L);
          return false;
        } while (i <= DoodleLayout.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout));
        if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a()) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e()) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 12))
        {
          i = (int)f1;
          j = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.left;
          k = (int)f2;
          m = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.top;
          if ((this.jdField_a_of_type_AndroidGraphicsRect.contains(i + j, k + m)) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(f1, f2, localRect)))
          {
            DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, true);
            return false;
          }
          DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, false);
          return false;
        }
        if ((paramMotionEvent.getPointerCount() == 1) && (this.jdField_a_of_type_AndroidGraphicsRect.contains((int)f1, (int)f2)))
        {
          DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, true);
          return false;
        }
        DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, false);
        return false;
      }
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      if ((this.jdField_a_of_type_AndroidGraphicsRect != null) && ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a()) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.e()) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 10) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int == 12)))
      {
        i = (int)f1;
        j = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.left;
        k = (int)f2;
        m = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.jdField_a_of_type_AndroidGraphicsRect.top;
        if ((DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout)) && ((this.jdField_a_of_type_AndroidGraphicsRect.contains(i + j, k + m)) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a(f1, f2, localRect))))
        {
          if (!(paramBaseLayer instanceof FaceLayer)) {
            break label661;
          }
          SLog.b("DoodleLayout", "remove face.");
          ((FaceLayer)paramBaseLayer).b();
          DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, false);
        }
      }
      label661:
      while ((paramMotionEvent.getPointerCount() != 1) || (this.jdField_a_of_type_AndroidGraphicsRect == null) || (!this.jdField_a_of_type_AndroidGraphicsRect.contains((int)f1, (int)f2))) {
        for (;;)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.f();
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.d(0);
          return false;
          if ((paramBaseLayer instanceof TextLayer))
          {
            SLog.b("DoodleLayout", "editpic remove text.");
            paramBaseLayer.a();
            paramBaseLayer.b(false);
          }
          else if ((paramBaseLayer instanceof TextFaceEditLayer))
          {
            paramMotionEvent = ((TextFaceEditLayer)paramBaseLayer).a();
            if ((paramMotionEvent != null) && ((paramMotionEvent instanceof TextLayer.TextItem)))
            {
              paramMotionEvent = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
              if (paramMotionEvent != null) {
                paramMotionEvent.a();
              }
            }
            ((TextFaceEditLayer)paramBaseLayer).b();
          }
        }
      }
      if ((paramBaseLayer instanceof TextLayer))
      {
        SLog.b("DoodleLayout", "remove text.");
        paramBaseLayer.a();
        paramBaseLayer.b(false);
      }
      for (;;)
      {
        DoodleLayout.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout, false);
        break;
        if ((paramBaseLayer instanceof FaceLayer))
        {
          SLog.b("DoodleLayout", "remove face.");
          ((FaceLayer)paramBaseLayer).b();
        }
        else if ((paramBaseLayer instanceof TextFaceEditLayer))
        {
          paramMotionEvent = ((TextFaceEditLayer)paramBaseLayer).a();
          if ((paramMotionEvent != null) && ((paramMotionEvent instanceof TextLayer.TextItem)))
          {
            paramMotionEvent = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiDoodleDoodleLayout.a();
            if (paramMotionEvent != null) {
              paramMotionEvent.a();
            }
          }
          ((TextFaceEditLayer)paramBaseLayer).b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ojx
 * JD-Core Version:    0.7.0.1
 */