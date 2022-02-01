package dov.com.qq.im.aeeditor.module.edit;

import com.microrapid.opencv.ImageMainColorData;
import java.util.Comparator;

class AEEditorImageEditFragment$13
  implements Comparator<ImageMainColorData>
{
  AEEditorImageEditFragment$13(AEEditorImageEditFragment paramAEEditorImageEditFragment) {}
  
  public int a(ImageMainColorData paramImageMainColorData1, ImageMainColorData paramImageMainColorData2)
  {
    int i = 0;
    if (paramImageMainColorData1.area > paramImageMainColorData2.area) {
      i = -1;
    }
    while (paramImageMainColorData1.area >= paramImageMainColorData2.area) {
      return i;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.13
 * JD-Core Version:    0.7.0.1
 */