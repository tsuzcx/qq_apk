package com.tencent.mobileqq.colornote.data;

import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;

public class ColorNoteDataInjectUtil
{
  @ConfigInject(configPath="Business/ColorNote-impl/src/main/resources/Inject_ColorNoteServiceConfig.yml", version=1)
  public static ArrayList<Class<? extends IColorNoteDataCallback>> a = new ArrayList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.data.ColorNoteDataInjectUtil
 * JD-Core Version:    0.7.0.1
 */