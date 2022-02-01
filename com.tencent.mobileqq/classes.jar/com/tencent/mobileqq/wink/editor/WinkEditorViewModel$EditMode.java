package com.tencent.mobileqq.wink.editor;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "", "(Ljava/lang/String;I)V", "Image", "Video", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public enum WinkEditorViewModel$EditMode
{
  static
  {
    EditMode localEditMode1 = new EditMode("Image", 0);
    Image = localEditMode1;
    EditMode localEditMode2 = new EditMode("Video", 1);
    Video = localEditMode2;
    $VALUES = new EditMode[] { localEditMode1, localEditMode2 };
  }
  
  private WinkEditorViewModel$EditMode() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.WinkEditorViewModel.EditMode
 * JD-Core Version:    0.7.0.1
 */