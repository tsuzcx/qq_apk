package dov.com.tencent.biz.qqstory.takevideo;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig.ConfigData;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferData;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.data.CaptureComboManager;
import dov.com.qq.im.capture.data.TransitionCategoryItem;
import dov.com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import dov.com.tencent.mobileqq.activity.richmedia.QzEditVideoPartManager;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools;
import dov.com.tencent.mobileqq.activity.richmedia.VideoFilterTools.ComboFilterData;
import java.util.ArrayList;
import java.util.Iterator;

public class EditVideoTransfer
  extends EditVideoPart
  implements IEventReceiver, EditTransferExport
{
  private int jdField_a_of_type_Int = 0;
  private TransferData jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData = new TransferData();
  
  public EditVideoTransfer(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  public static int a(int paramInt)
  {
    int i = 1;
    if (paramInt == 1) {
      i = 0;
    }
    while (paramInt == 2) {
      return i;
    }
    return -1;
  }
  
  public static long a()
  {
    return -200L;
  }
  
  private void a(long paramLong)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.getPositions();
    if ((localObject == null) || (((ArrayList)localObject).size() == 0))
    {
      this.jdField_a_of_type_Int = 1;
      return;
    }
    localObject = ((ArrayList)localObject).iterator();
    Long localLong;
    for (long l = 0L; ((Iterator)localObject).hasNext(); l = localLong.longValue())
    {
      localLong = (Long)((Iterator)localObject).next();
      if (localLong.longValue() - l < 2000L)
      {
        this.jdField_a_of_type_Int = 2;
        return;
      }
    }
    if (paramLong - l < 2000L)
    {
      this.jdField_a_of_type_Int = 2;
      return;
    }
    this.jdField_a_of_type_Int = 0;
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.mConfigData.mID != -1) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.getPositions().size() > 0);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    a(EditTransferExport.class, this);
    if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditLocalPhotoSource)) {
      this.jdField_a_of_type_Int = 3;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Int == 0)
      {
        localObject = ((CaptureComboManager)QIMManager.a(5)).a;
        if (localObject != null)
        {
          localObject = ((VideoFilterTools.ComboFilterData)localObject).a();
          a(Integer.parseInt(((TransitionCategoryItem)localObject).a));
          VideoFilterTools.a().a((TransitionCategoryItem)localObject);
          localObject = (EditProviderExport)a(EditProviderExport.class);
          if ((localObject != null) && (!(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager instanceof QzEditVideoPartManager))) {
            ((EditProviderExport)localObject).c();
          }
        }
        if (AudioHelper.f()) {
          this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.setReverseShift(a());
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoTransfer", 2, "onCreate, state:" + this.jdField_a_of_type_Int);
      }
      Object localObject = (EditButtonExport)a(EditButtonExport.class);
      if (this.jdField_a_of_type_Int != 0) {
        ((EditButtonExport)localObject).b();
      }
      StoryReportor.a("video_edit_transition", "exp_transition", a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a("extra_transiton_src_from", -1)), 0, new String[0]);
      return;
      if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditLocalVideoSource))
      {
        this.jdField_a_of_type_Int = 3;
      }
      else if ((this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a instanceof EditTakeVideoSource))
      {
        this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.setPositions(((EditTakeVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a).a.mTransferPosList);
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a("extra_transiton_src_from", -1) == 1) {
          this.jdField_a_of_type_Int = 0;
        } else {
          a(((EditTakeVideoSource)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a).a.mDuration);
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = TransferConfig.getConfigData(paramInt);
    if (paramInt == 1)
    {
      ((TransferConfig.ConfigData)localObject).mCommonFloat1 = null;
      ((TransferConfig.ConfigData)localObject).mCommonFloat2 = null;
      ((TransferConfig.ConfigData)localObject).mCommonFloat3 = null;
      ((TransferConfig.ConfigData)localObject).mCommonFloat4 = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.setConfigData((TransferConfig.ConfigData)localObject);
    if (c())
    {
      localObject = (EditVideoPlayerExport)a(EditVideoPlayerExport.class);
      if (localObject != null) {
        ((EditVideoPlayerExport)localObject).a(this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    if (this.jdField_a_of_type_Int != 0) {}
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    if (!b()) {}
    String str;
    do
    {
      return;
      str = this.jdField_a_of_type_ComTencentMobileqqShortvideoVideotransferTransferData.toJSONObject();
    } while (TextUtils.isEmpty(str));
    paramGenerateContext.a.putExtra("transfer_effect_data", str);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int == 1) {
      QQToast.a(a(), 2131720017, 0).a();
    }
    while (this.jdField_a_of_type_Int != 2) {
      return;
    }
    QQToast.a(a(), 2131720016, 0).a();
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int == 0;
  }
  
  public void g()
  {
    super.g();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoTransfer", 2, "onDestroy");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoTransfer
 * JD-Core Version:    0.7.0.1
 */