package com.tencent.tavsticker.model;

import java.util.Comparator;
import org.libpag.PAGLayer;

class TAVSticker$2
  implements Comparator<PAGLayer>
{
  TAVSticker$2(TAVSticker paramTAVSticker) {}
  
  public int compare(PAGLayer paramPAGLayer1, PAGLayer paramPAGLayer2)
  {
    if ((paramPAGLayer1 != null) && (paramPAGLayer2 != null)) {
      return paramPAGLayer1.editableIndex() - paramPAGLayer2.editableIndex();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tavsticker.model.TAVSticker.2
 * JD-Core Version:    0.7.0.1
 */