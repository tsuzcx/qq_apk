package com.tencent.youtu.ytagreflectlivecheck.data;

import com.tencent.youtu.ytagreflectlivecheck.requester.LiveStyleRequester.SeleceData;

public class YTActReflectData
{
  public YTActReflectImage best;
  public YTActReflectImage eye;
  public YTActReflectImage mouth;
  public LiveStyleRequester.SeleceData select_data;
  
  public YTActReflectData(YTActReflectImage paramYTActReflectImage1, YTActReflectImage paramYTActReflectImage2, YTActReflectImage paramYTActReflectImage3, LiveStyleRequester.SeleceData paramSeleceData)
  {
    this.best = paramYTActReflectImage1;
    this.eye = paramYTActReflectImage2;
    this.mouth = paramYTActReflectImage3;
    this.select_data = paramSeleceData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.youtu.ytagreflectlivecheck.data.YTActReflectData
 * JD-Core Version:    0.7.0.1
 */