package com.tencent.mobileqq.colornote.settings;

import com.tencent.mobileqq.colornotebiz.settings.HeaderClickHandlerBoodo;
import com.tencent.mobileqq.colornotebiz.settings.HeaderClickHandlerQFav;
import com.tencent.mobileqq.filemanager.fileviewer.colornote.QFileColorNoteHistoryHeaderHandler;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;

public class ColorNoteHistoryInjectUtil
{
  @ConfigInject(configPath="Business/ColorNote-impl/src/main/resources/Inject_ColorNoteHistoryConfig.yml", version=1)
  public static ArrayList<Class<? extends IOnHeaderClickHandler>> a = new ArrayList();
  
  static
  {
    a.add(QFileColorNoteHistoryHeaderHandler.class);
    a.add(HeaderClickHandlerQFav.class);
    a.add(HeaderClickHandlerBoodo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.settings.ColorNoteHistoryInjectUtil
 * JD-Core Version:    0.7.0.1
 */