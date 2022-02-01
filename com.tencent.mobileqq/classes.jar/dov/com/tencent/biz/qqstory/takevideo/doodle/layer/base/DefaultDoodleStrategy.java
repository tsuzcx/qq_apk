package dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base;

import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.DynamicFaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.LineLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleView;
import java.util.List;

public class DefaultDoodleStrategy
  implements DoodleStrategy
{
  public void a(List<BaseLayer> paramList, DoodleView paramDoodleView)
  {
    FaceLayer localFaceLayer = new FaceLayer(paramDoodleView);
    DynamicFaceLayer localDynamicFaceLayer = new DynamicFaceLayer(paramDoodleView);
    LineLayer localLineLayer = new LineLayer(paramDoodleView);
    paramDoodleView = new TextLayer(paramDoodleView);
    paramList.add(localFaceLayer);
    paramList.add(localDynamicFaceLayer);
    paramList.add(localLineLayer);
    paramList.add(paramDoodleView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.DefaultDoodleStrategy
 * JD-Core Version:    0.7.0.1
 */