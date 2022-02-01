package dov.com.tencent.mobileqq.activity.richmedia;

import android.os.Message;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import cooperation.qzone.util.QZLog;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.data.CaptureComboManager.CaptureComboListener;
import dov.com.qq.im.capture.music.EditVideoQimMusic;
import dov.com.tencent.biz.qqstory.takevideo.EditProviderPart;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoDoodle;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPart;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoSpeedFilter;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.LineLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneEditVideoPartReport
  extends EditVideoPart
{
  private static final SparseArray<QzoneEditPictureAndVideoReportModel> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  CaptureComboManager.CaptureComboListener jdField_a_of_type_DovComQqImCaptureDataCaptureComboManager$CaptureComboListener = new QzoneEditVideoPartReport.1(this);
  private Set<Integer> jdField_a_of_type_JavaUtilSet = new HashSet();
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray.put(3000, QzoneEditPictureAndVideoReportModel.a(99, 1, 0, QzoneEditVideoPartReport.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(2, QzoneEditPictureAndVideoReportModel.a(99, 3, 0, EditVideoDoodle.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3, QzoneEditPictureAndVideoReportModel.a(99, 5, 0, EditVideoDoodle.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(4, QzoneEditPictureAndVideoReportModel.a(99, 7, 0, EditVideoDoodle.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(1, QzoneEditPictureAndVideoReportModel.a(99, 4, 0, EditVideoQimMusic.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(14, QzoneEditPictureAndVideoReportModel.a(99, 6, 0, EditProviderPart.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(12, QzoneEditPictureAndVideoReportModel.a(99, 9, 0, EditVideoSpeedFilter.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(13, QzoneEditPictureAndVideoReportModel.a(99, 8, 0, EditProviderPart.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(4001, QzoneEditPictureAndVideoReportModel.a(99, 16, 0, EditProviderPart.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3005, QzoneEditPictureAndVideoReportModel.a(99, 2, 0, QzoneEditVideoPartReport.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3006, QzoneEditPictureAndVideoReportModel.a(99, 15, 0, QzoneEditVideoPartReport.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3002, QzoneEditPictureAndVideoReportModel.a(99, 10, 1, QzoneEditVideoPartReport.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3003, QzoneEditPictureAndVideoReportModel.a(99, 10, 2, QzoneEditVideoPartReport.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3001, QzoneEditPictureAndVideoReportModel.a(99, 13, 0, QzoneEditVideoPartReport.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3007, QzoneEditPictureAndVideoReportModel.a(99, 12, 1, QzoneEditVideoPartReport.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3008, QzoneEditPictureAndVideoReportModel.a(99, 12, 2, QzoneEditVideoPartReport.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3004, QzoneEditPictureAndVideoReportModel.a(99, 14, 0, QzoneEditVideoPartReport.class));
    jdField_a_of_type_AndroidUtilSparseArray.put(3009, QzoneEditPictureAndVideoReportModel.a(99, 11, 0, QzoneEditVideoPartReport.class));
  }
  
  public QzoneEditVideoPartReport(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private void c()
  {
    Iterator localIterator = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (EditVideoPart)localIterator.next();
      Object localObject2;
      if ((localObject1 instanceof EditVideoDoodle))
      {
        localObject2 = (EditVideoDoodle)localObject1;
        if (!((EditVideoDoodle)localObject2).a().b())
        {
          if (!((EditVideoDoodle)localObject2).a().a().a()) {
            this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(5));
          }
          if (!((EditVideoDoodle)localObject2).a().a().a()) {
            this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(1));
          }
          if (!((EditVideoDoodle)localObject2).a().a().a()) {
            this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(3));
          }
        }
      }
      if ((localObject1 instanceof EditProviderPart))
      {
        localObject1 = (EditProviderPart)localObject1;
        localObject2 = new JSONObject();
        ((EditProviderPart)localObject1).a((JSONObject)localObject2);
        if (((JSONObject)localObject2).has(EditProviderPart.a))
        {
          try
          {
            localObject1 = ((JSONObject)localObject2).getJSONObject(EditProviderPart.a);
            if (!((JSONObject)localObject1).has("comboItem")) {
              break label237;
            }
            QZLog.d("QzoneEditVideoPartRepor", 2, new Object[] { "buildReportExtraReserves", " has combo item" });
            this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(4));
          }
          catch (JSONException localJSONException)
          {
            QZLog.d("QzoneEditVideoPartRepor", 2, "buildReportExtraReserves", localJSONException);
          }
          continue;
          label237:
          if (localJSONException.has("musicItem"))
          {
            QZLog.d("QzoneEditVideoPartRepor", 2, new Object[] { "buildReportExtraReserves", " has music item" });
            this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(2));
          }
          else if (localJSONException.has("filterItem"))
          {
            QZLog.d("QzoneEditVideoPartRepor", 2, new Object[] { "buildReportExtraReserves", " has filter item" });
          }
        }
      }
    }
  }
  
  public void a()
  {
    super.a();
    a(3000, null);
    ((CaptureComboManager)QIMManager.a(5)).a(this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboManager$CaptureComboListener);
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    if (paramGenerateContext.a.saveMode != 0) {
      this.jdField_a_of_type_JavaUtilSet.add(Integer.valueOf(7));
    }
    c();
    a(3006, null);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    super.a(paramInt, paramObject);
    paramObject = (QzoneEditPictureAndVideoReportModel)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramObject != null)
    {
      if (paramInt == 3006) {
        paramObject.a(this.jdField_a_of_type_JavaUtilSet);
      }
      paramObject.a();
      return;
    }
    QZLog.w("QzoneEditVideoPartRepor", 2, new Object[] { "editVideoStateChanged we are not interested at this edit state " + paramInt });
  }
  
  public boolean a(Message paramMessage)
  {
    if ((paramMessage.what == 9) && (paramMessage.arg1 == 12)) {
      a(paramMessage.arg1, null);
    }
    return super.a(paramMessage);
  }
  
  public void g()
  {
    super.g();
    ((CaptureComboManager)QIMManager.a(5)).b(this.jdField_a_of_type_DovComQqImCaptureDataCaptureComboManager$CaptureComboListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.QzoneEditVideoPartReport
 * JD-Core Version:    0.7.0.1
 */