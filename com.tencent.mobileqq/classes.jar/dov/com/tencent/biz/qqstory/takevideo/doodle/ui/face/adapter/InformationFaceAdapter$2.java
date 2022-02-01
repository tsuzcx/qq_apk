package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter;

import bnlw;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;

public class InformationFaceAdapter$2
  implements Runnable
{
  public InformationFaceAdapter$2(bnlw parambnlw, String paramString) {}
  
  public void run()
  {
    FileUtils.delete(new File(this.a).getParentFile().getParentFile().getPath(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.InformationFaceAdapter.2
 * JD-Core Version:    0.7.0.1
 */