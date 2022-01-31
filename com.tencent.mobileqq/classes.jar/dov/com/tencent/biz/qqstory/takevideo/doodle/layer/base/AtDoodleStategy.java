package dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base;

import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.AtLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.List;

public class AtDoodleStategy
  implements DoodleStrategy
{
  public void a(List paramList, DoodleView paramDoodleView)
  {
    paramList.add(new AtLayer(paramDoodleView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.AtDoodleStategy
 * JD-Core Version:    0.7.0.1
 */