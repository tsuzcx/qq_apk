package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

class InformationFaceAdapter$2
  implements Runnable
{
  InformationFaceAdapter$2(InformationFaceAdapter paramInformationFaceAdapter, String paramString) {}
  
  public void run()
  {
    FileUtils.a(new File(this.a).getParentFile().getParentFile().getPath(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.2
 * JD-Core Version:    0.7.0.1
 */