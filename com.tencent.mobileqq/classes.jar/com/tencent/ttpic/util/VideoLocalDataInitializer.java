package com.tencent.ttpic.util;

import com.tencent.ttpic.openapi.model.VideoMaterialMetaData;
import java.util.ArrayList;
import java.util.List;

public class VideoLocalDataInitializer
{
  private static String[] LOCAL_MATERIAL_IDS = { "video_fireburning_db", "video_fengkuangdacall_audio", "video_dangdangdang", "video_jmskull2", "video_mv_gun", "video_yinxingchibang", "video_expression_level1", "video_voice_text_mouth", "video_pikachu", "video_money_1", "video_bubble", "video_mv_comic3", "video_egaoshuangwanzi", "video_newyearlucky_suiji", "video_filters_chazi", "video_filters_hanfeng", "video_filters_hongkong", "video_filters_jiazhou", "video_animalword" };
  public static String[] ONLINE_MATERIAL_IDS = { "video_3DFace_santaglass", "video_bluecat", "video_huzi_white", "video_nihongshu", "video_Qmaozi", "video_wawaji", "video_nonono", "video_rainbow", "video_mv_fenbimao", "video_baby_agetest", "video_mjdance", "video_astronaut", "video_mv_wing", "video_liuhai", "video_mv_dongwuyuan", "video_handsomeGuy", "video_qixi", "video_guifeiface", "video_huaxianzi", "video_particle_cherryblossom", "video_heart_lips", "video_yinjiuzui", "video_huzi_black", "video_xinniang", "video_xiaobian", "video_mojing_yangyang" };
  
  public static List<VideoMaterialMetaData> buildVideoMaterials()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new VideoMaterialMetaData(null, "None", null, "assets://none.png"));
    String[] arrayOfString = LOCAL_MATERIAL_IDS;
    int k = arrayOfString.length;
    int j = 0;
    int i = 0;
    String str;
    Object localObject;
    StringBuilder localStringBuilder;
    while (i < k)
    {
      str = arrayOfString[i];
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("assets://camera/camera_video/CameraVideoAnimal/");
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("assets://camera/camera_video/CameraVideoAnimal/");
      localStringBuilder.append(str);
      localStringBuilder.append("/");
      localStringBuilder.append(str);
      localStringBuilder.append(".png");
      localArrayList.add(new VideoMaterialMetaData(str, (String)localObject, "", localStringBuilder.toString()));
      i += 1;
    }
    arrayOfString = ONLINE_MATERIAL_IDS;
    k = arrayOfString.length;
    i = j;
    while (i < k)
    {
      str = arrayOfString[i];
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("https://res.tu.qq.com/materials/");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("Android.zip");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://res.tu.qq.com/materials/");
      localStringBuilder.append(str);
      localStringBuilder.append(".png");
      localArrayList.add(new VideoMaterialMetaData(str, "", (String)localObject, localStringBuilder.toString()));
      i += 1;
    }
    localArrayList.add(new VideoMaterialMetaData("video_3DFace_fashionglass1", "", "https://st1.xiangji.qq.com/pitu/materials/video_3DFace_fashionglass1Android.zip", "https://st1.xiangji.qq.com/pitu/materials/video_3DFace_fashionglass1.png"));
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoLocalDataInitializer
 * JD-Core Version:    0.7.0.1
 */