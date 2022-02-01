package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import android.support.annotation.NonNull;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.DynamicFaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.EmptyLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.GuideLineLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.LineLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer;
import java.util.ArrayList;

public class DoodleLayout$LayerCollection
{
  @NonNull
  public final DynamicFaceLayer a;
  @NonNull
  public final EmptyLayer a;
  @NonNull
  public final FaceLayer a;
  @NonNull
  public final GuideLineLayer a;
  @NonNull
  public final LineLayer a;
  @NonNull
  public final TextLayer a;
  public final ArrayList<BaseLayer> a;
  
  public DoodleLayout$LayerCollection(@NonNull TextLayer paramTextLayer, @NonNull LineLayer paramLineLayer, @NonNull FaceLayer paramFaceLayer, @NonNull DynamicFaceLayer paramDynamicFaceLayer, @NonNull GuideLineLayer paramGuideLineLayer, @NonNull EmptyLayer paramEmptyLayer)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer = paramTextLayer;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerLineLayer = paramLineLayer;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerFaceLayer = paramFaceLayer;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerDynamicFaceLayer = paramDynamicFaceLayer;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerEmptyLayer = paramEmptyLayer;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerGuideLineLayer = paramGuideLineLayer;
    this.jdField_a_of_type_JavaUtilArrayList.add(paramFaceLayer);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramDynamicFaceLayer);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramLineLayer);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramTextLayer);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramGuideLineLayer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.LayerCollection
 * JD-Core Version:    0.7.0.1
 */