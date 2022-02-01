package com.tencent.mobileqq.colornote.list;

import com.tencent.mobileqq.colornotebiz.list.ColorNoteListDataListener;
import com.tencent.mobileqq.colornotebiz.list.MiniAppColorNoteListListener;
import com.tencent.mobileqq.colornotebiz.list.RecentViewColorNoteListener;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;

public class ColorNoteListInjectUtil
{
  @ConfigInject(configPath="Business/ColorNote-impl/src/main/resources/Inject_ColorNoteListConfig.yml", version=1)
  public static ArrayList<Class<? extends IColorNoteListListener>> a = new ArrayList();
  
  static
  {
    a.add(ColorNoteListDataListener.class);
    a.add(RecentViewColorNoteListener.class);
    a.add(MiniAppColorNoteListListener.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.list.ColorNoteListInjectUtil
 * JD-Core Version:    0.7.0.1
 */