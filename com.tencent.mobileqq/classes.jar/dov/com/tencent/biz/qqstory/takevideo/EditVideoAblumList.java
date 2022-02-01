package dov.com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ThrowablesUtils;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager;
import dov.com.qq.im.capture.text.DynamicTextConfigManager.DynamicTextConfigBean;

public class EditVideoAblumList
  extends EditVideoPart
  implements IEventReceiver
{
  private EditVideoAblumList.IDynamicTextResDownloadCallback a;
  
  public EditVideoAblumList(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoAblumList$IDynamicTextResDownloadCallback = new EditVideoAblumList.IDynamicTextResDownloadCallback(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager);
  }
  
  public void a()
  {
    EditProviderExport localEditProviderExport = (EditProviderExport)a(EditProviderExport.class);
    if (localEditProviderExport != null) {
      localEditProviderExport.aL_();
    }
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.a(paramMessage);
      int i;
      DynamicTextConfigManager localDynamicTextConfigManager;
      DynamicTextConfigManager.DynamicTextConfigBean localDynamicTextConfigBean;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("EditVideoAblumList", 2, "handle message MESSAGE_DOODLE_LAYOUT_LOADED");
        }
        Object localObject = (EditVideoParams)this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.getActivity().getIntent().getParcelableExtra(EditVideoParams.class.getName());
        i = ((EditVideoParams)localObject).a("extra_slide_sticker_id", -1);
        localObject = ((EditVideoParams)localObject).a("extra_slide_sticker_str");
        if ((TextUtils.isEmpty((CharSequence)localObject)) || (i == -1)) {
          continue;
        }
        localDynamicTextConfigManager = (DynamicTextConfigManager)QIMManager.a(7);
        if (!localDynamicTextConfigManager.a()) {
          localDynamicTextConfigManager.a();
        }
        localDynamicTextConfigBean = localDynamicTextConfigManager.a(i + "");
        if (localDynamicTextConfigBean == null) {
          continue;
        }
        if (!localDynamicTextConfigManager.a(localDynamicTextConfigBean)) {
          break label226;
        }
        if (QLog.isColorLevel()) {
          QLog.d("EditVideoAblumList", 2, "isDynamicTextUsable, addSticker : " + localDynamicTextConfigBean.text_id);
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a(i, (String)localObject);
      }
      catch (Exception localException) {}
      if (QLog.isColorLevel())
      {
        QLog.d("EditVideoAblumList", 2, ThrowablesUtils.a(localException));
        continue;
        label226:
        if (QLog.isColorLevel()) {
          QLog.d("EditVideoAblumList", 2, "configBean has not downloaded, start download : " + localDynamicTextConfigBean.text_id);
        }
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoAblumList$IDynamicTextResDownloadCallback.a(i);
        this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoAblumList$IDynamicTextResDownloadCallback.a(localException);
        localDynamicTextConfigManager.a(localDynamicTextConfigBean, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoAblumList$IDynamicTextResDownloadCallback);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoAblumList
 * JD-Core Version:    0.7.0.1
 */