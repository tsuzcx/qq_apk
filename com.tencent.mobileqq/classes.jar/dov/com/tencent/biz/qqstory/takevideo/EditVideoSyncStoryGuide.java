package dov.com.tencent.biz.qqstory.takevideo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import aodu;
import aodv;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;

public class EditVideoSyncStoryGuide
  extends EditVideoPart
{
  public EditVideoSyncStoryGuide(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    c();
  }
  
  protected void c()
  {
    Object localObject = DialogUtil.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoUi.a(), 230);
    ((QQCustomDialog)localObject).setTitle("分享到小视频");
    ((QQCustomDialog)localObject).setMessage("分享后，好友即可在小视频中查看该视频，并保存到\"我的小视频\"");
    ((QQCustomDialog)localObject).setNegativeButton("我知道了", new aodu(this, (QQCustomDialog)localObject));
    ((QQCustomDialog)localObject).setOnDismissListener(new aodv(this));
    ((QQCustomDialog)localObject).show();
    int i;
    if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a != null)
    {
      i = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoPartManager.a.a.getInt("curType", 1);
      if (i != 1) {
        break label123;
      }
    }
    label123:
    for (localObject = "1";; localObject = "2")
    {
      StoryReportor.a("aio_shoot", "exp_tip", 0, 0, new String[] { localObject });
      return;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoSyncStoryGuide
 * JD-Core Version:    0.7.0.1
 */