package com.tencent.mobileqq.colornote.data;

import com.tencent.mobileqq.colornote.ColorNoteReporter;
import com.tencent.mobileqq.kandian.biz.colornote.api.IColorNoteReportUtil;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.List;

public class ColorNoteDataLayerListener
  implements IColorNoteDataCallback
{
  public void a(ColorNote paramColorNote)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramColorNote);
    ColorNoteReporter.a(localArrayList);
    if ((paramColorNote != null) && (paramColorNote.getServiceType() == 16908290)) {
      ((IColorNoteReportUtil)QRoute.api(IColorNoteReportUtil.class)).reportRemainTime(paramColorNote);
    }
  }
  
  public void a(List<ColorNote> paramList)
  {
    ColorNoteReporter.a(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.colornote.data.ColorNoteDataLayerListener
 * JD-Core Version:    0.7.0.1
 */