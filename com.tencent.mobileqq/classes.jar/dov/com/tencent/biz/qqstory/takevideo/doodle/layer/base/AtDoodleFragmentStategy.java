package dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base;

import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.AtLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.List;

public class AtDoodleFragmentStategy
  implements DoodleStrategy
{
  public static final String[] a = { "AtLayer0", "AtLayer1", "AtLayer2", "AtLayer3", "AtLayer4", "AtLayer5" };
  
  public void a(List<BaseLayer> paramList, DoodleView paramDoodleView)
  {
    int i = 0;
    while (i < a.length)
    {
      paramList.add(new AtLayer(paramDoodleView, a[i]));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.AtDoodleFragmentStategy
 * JD-Core Version:    0.7.0.1
 */